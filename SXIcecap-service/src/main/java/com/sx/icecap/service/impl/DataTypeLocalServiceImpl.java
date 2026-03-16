/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under the dataTypes of
 * the GNU Lesser General Public License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.sx.icecap.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.sx.constant.StationXConstants;
import com.sx.icecap.constant.DataTypeProperties;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.DataTypeStructure;
import com.sx.icecap.service.DataStructureLocalService;
import com.sx.icecap.service.DataTypeStructureLocalService;
import com.sx.icecap.service.SetTypeLinkLocalService;
import com.sx.icecap.service.TypeVisualizerLinkLocalService;
import com.sx.icecap.service.base.DataTypeLocalServiceBaseImpl;
import com.sx.icecap.util.comparator.GroupIdComparator;
import com.sx.icecap.util.comparator.ModifiedDateComparator;
import com.sx.icecap.util.comparator.UserIdComparator;
import com.sx.icecap.util.comparator.datatype.DataTypeCodeComparator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
			property = "model.class.name=com.sx.icecap.model.DataType", service = AopService.class
)
public class DataTypeLocalServiceImpl extends DataTypeLocalServiceBaseImpl {

	@Reference
	private DLAppService _dlAppService;

	@Indexable(
				type = IndexableType.REINDEX
	)
	public DataType addDataType (
				String dataTypeCode, String dataTypeVersion, String extension, Map<Locale, String> displayNameMap,
				Map<Locale, String> descriptionMap, int status, ServiceContext sc
	) throws PortalException {

		Locale defaultLocale = sc.getThemeDisplay ().getLocale ();

		long dataTypeId = super.counterLocalService.increment ();
		DataType dataType = super.dataTypeLocalService.createDataType ( dataTypeId );

		dataType.setDataTypeCode ( dataTypeCode );
		dataType.setDataTypeVersion ( dataTypeVersion );
		dataType.setExtension ( extension );
		dataType.setDisplayNameMap ( displayNameMap, defaultLocale );
		dataType.setDescriptionMap ( descriptionMap, defaultLocale );

		Date now = new Date ();
		User user = super.userLocalService.getUser ( sc.getUserId () );
		dataType.setCompanyId ( sc.getCompanyId () );
		dataType.setGroupId ( sc.getScopeGroupId () );
		dataType.setUserId ( user.getUserId () );
		dataType.setUserName ( user.getFullName () );
		dataType.setCreateDate ( now );
		dataType.setModifiedDate ( now );

		if ( status > WorkflowConstants.STATUS_ANY ) {
			dataType.setStatus ( status );
		} else {
			dataType.setStatus ( WorkflowConstants.STATUS_DRAFT );
		}
		dataType.setStatusByUserId ( sc.getUserId () );
		dataType.setStatusByUserName ( user.getFullName () );
		dataType.setStatusDate ( sc.getModifiedDate ( null ) );

		dataType.setExpandoBridgeAttributes ( sc );

		dataType = super.dataTypePersistence.update ( dataType, sc );

		super.resourceLocalService.addResources (
					dataType.getCompanyId (),
					dataType.getGroupId (),
					dataType.getUserId (),
					DataType.class.getName (),
					dataType.getPrimaryKey (),
					false,
					true,
					true
		);
		// System.out.println("Resource Finished....");

		super.assetEntryLocalService.updateEntry (
					dataType.getUserId (),
					dataType.getGroupId (),
					dataType.getCreateDate (),
					dataType.getModifiedDate (),
					DataType.class.getName (),
					dataType.getPrimaryKey (),
					dataType.getUuid (),
					0,
					sc.getAssetCategoryIds (),
					sc.getAssetTagNames (),
					true,
					true,
					null,
					null,
					dataType.getCreateDate (),
					null,
					ContentTypes.TEXT_HTML_UTF8,
					dataType.getDataTypeCode (),
					null,
					null,
					null,
					null,
					0,
					0,
					null
		);

		WorkflowHandlerRegistryUtil.startWorkflowInstance (
					dataType.getCompanyId (),
					dataType.getGroupId (),
					dataType.getUserId (),
					DataType.class.getName (),
					dataType.getPrimaryKey (),
					dataType,
					sc
		);

		return dataType;
	}

	@Indexable(
				type = IndexableType.REINDEX
	)
	public DataType updateDataType (
				long dataTypeId, String dataTypeCode, String dataTypeVersion, String extension,
				Map<Locale, String> displayNameMap, Map<Locale, String> descriptionMap, int status, ServiceContext sc
	) throws PortalException {
		DataType dataType = super.dataTypePersistence.findByPrimaryKey ( dataTypeId );

		dataType.setDataTypeCode ( dataTypeCode );
		dataType.setDataTypeVersion ( dataTypeVersion );
		dataType.setExtension ( extension );
		dataType.setDisplayNameMap ( displayNameMap, sc.getLocale () );
		dataType.setDescriptionMap ( descriptionMap, sc.getLocale () );

		dataType.setUserId ( sc.getUserId () );
		dataType.setGroupId ( sc.getScopeGroupId () );
		dataType.setModifiedDate ( new Date () );

		boolean statusChanged = false;
		if ( status > WorkflowConstants.STATUS_ANY && status != dataType.getStatus () ) {
			User user = super.userLocalService.getUser ( sc.getUserId () );
			dataType.setStatus ( status );
			dataType.setStatusByUserId ( user.getUserId () );
			dataType.setStatusByUserName ( user.getFullName () );
			dataType.setStatusDate ( new Date () );
			statusChanged = true;
		}

		dataType.setExpandoBridgeAttributes ( sc );

		super.dataTypePersistence.update ( dataType, sc );

		super.resourceLocalService.updateResources (
					dataType.getCompanyId (),
					dataType.getGroupId (),
					DataType.class.getName (),
					dataType.getPrimaryKey (),
					sc.getModelPermissions ()
		);

		super.assetEntryLocalService.updateEntry (
					dataType.getUserId (),
					dataType.getGroupId (),
					dataType.getCreateDate (),
					dataType.getModifiedDate (),
					DataType.class.getName (),
					dataType.getPrimaryKey (),
					dataType.getUuid (),
					0,
					sc.getAssetCategoryIds (),
					sc.getAssetTagNames (),
					true,
					true,
					null,
					null,
					dataType.getCreateDate (),
					null,
					ContentTypes.TEXT_HTML_UTF8,
					dataType.getDataTypeCode (),
					null,
					null,
					null,
					null,
					0,
					0,
					null
		);

		if ( statusChanged ) {
			if ( status == WorkflowConstants.STATUS_APPROVED ) {
				super.assetEntryLocalService.updateVisible ( DataType.class.getName (), dataTypeId, true );
			} else {
				super.assetEntryLocalService.updateVisible ( DataType.class.getName (), dataTypeId, false );
			}
		}

		return dataType;
	}

	@Indexable(
				type = IndexableType.REINDEX
	)
	public DataType updateStatus ( long userId, long dataTypeId, Integer status, ServiceContext sc )
				throws PortalException, SystemException {

		User user = userLocalService.getUser ( userId );
		DataType dataType = super.dataTypePersistence.findByPrimaryKey ( dataTypeId );

		dataType.setStatus ( status );
		dataType.setStatusByUserId ( userId );
		dataType.setStatusByUserName ( user.getFullName () );
		dataType.setStatusDate ( new Date () );

		super.dataTypePersistence.update ( dataType, sc );

		if ( status == WorkflowConstants.STATUS_APPROVED ) {
			super.assetEntryLocalService.updateVisible ( DataType.class.getName (), dataTypeId, true );
		} else {
			super.assetEntryLocalService.updateVisible ( DataType.class.getName (), dataTypeId, false );
		}

		return dataType;
	}

	@Indexable(
				type = IndexableType.DELETE
	)
	public DataType removeDataType ( long dataTypeId ) throws PortalException {
		DataType dataType = super.dataTypePersistence.remove ( dataTypeId );

		if ( hasDataStructure ( dataTypeId ) ) {
			dataTypeStructurePersistence.remove ( dataTypeId );
		}

		_setTypeLinkLocalService.removeSetTypeLinksByType ( dataTypeId );

		super.assetEntryLocalService.deleteEntry ( DataType.class.getName (), dataType.getPrimaryKey () );

		super.resourceLocalService.deleteResource (
					dataType.getCompanyId (),
					DataType.class.getName (),
					ResourceConstants.SCOPE_INDIVIDUAL,
					dataType.getPrimaryKey ()
		);

		super.workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks (
					dataType.getCompanyId (),
					dataType.getGroupId (),
					DataType.class.getName (),
					dataType.getDataTypeId ()
		);

		return dataType;
	}

	public void removeDataTypes ( long[] dataTypeIds ) throws PortalException {
		for ( long dataTypeId : dataTypeIds ) {
			this.removeDataType ( dataTypeId );
		}
	}

	public JSONArray removeDataTypes ( String[] dataTypeIds ) throws PortalException {
		JSONArray errorObject = JSONFactoryUtil.createJSONArray ();

		for ( String dataTypeId : dataTypeIds ) {
			try {
				this.removeDataType ( Long.parseLong ( dataTypeId ) );
			} catch ( NumberFormatException e ) {
				errorObject.put ( dataTypeId );
			}
		}

		return errorObject;
	}

	public void importDataStructure ( long dataTypeId, long dataStructureId ) {
		DataStructure dataStructure = dataStructurePersistence.fetchByPrimaryKey ( dataStructureId );

		if ( Validator.isNotNull ( dataStructure ) ) {
			_dataTypeStructureLocalService.updateDataTypeStructure ( dataTypeId, dataStructure.getStructure () );
		}
	}

	public boolean checkDataTypeCodeUnique ( String paramCode ) {
		int result = super.dataTypePersistence.countByCode ( paramCode );

		System.out.println ( "countByCode: " + result );

		return result < 1;
	}

	public void setDataTypeStructure ( long dataTypeId, String dataStructure ) {
		_dataTypeStructureLocalService.updateDataTypeStructure ( dataTypeId, dataStructure );
	}

	public List<DataType> getDataTypes (
				long groupId, long userId, int status, int start, int end, String orderCol, String orderType
	) {
		if ( groupId > 0 && userId > 0 ) {
			return getDataTypesByG_U_S (
						groupId,
						userId,
						status,
						start,
						end,
						getSortOrderComparator ( orderCol, orderType )
			);
		} else if ( groupId > 0 ) {
			return getDataTypesByG_S ( groupId, status, start, end, getSortOrderComparator ( orderCol, orderType ) );
		} else if ( userId > 0 ) {
			return getDataTypesByU_S ( userId, status, start, end, getSortOrderComparator ( orderCol, orderType ) );
		} else {
			return getDataTypesByStatus ( status, start, end, getSortOrderComparator ( orderCol, orderType ) );
		}
	}

	public String getDataTypesJSON (
				long groupId, long userId, int status, int start, int end, String orderCol, String orderType
	) {
		List<DataType> dataTypeList = getDataTypes ( groupId, userId, status, start, end, orderCol, orderType );

		return JSONFactoryUtil.looseSerialize ( dataTypeList );
	}

	public int countDataTypes ( long groupId, long userId, int status ) {
		if ( groupId > 0 && userId > 0 ) {
			return countDataTypesByG_U_S ( groupId, userId, status );
		} else if ( groupId > 0 ) {
			return countDataTypesByG_S ( groupId, status );
		} else if ( userId > 0 ) {
			return countDataTypesByU_S ( userId, status );
		} else {
			return countDataTypesByStatus ( status );
		}
	}

	public List<DataType> getAllDataTypes () {
		return super.dataTypePersistence.findAll ();
	}

	public List<DataType> getAllDataTypes ( int start, int end ) {
		return super.dataTypePersistence.findAll ( start, end );
	}

	public List<DataType> getAllDataTypes ( int start, int end, OrderByComparator<DataType> comparator ) {
		return super.dataTypePersistence.findAll ( start, end, comparator );
	}

	public int countAllDataTypes () {
		return super.dataTypePersistence.countAll ();
	}

	public List<DataType> getDataTypesByGroupId ( long groupId ) {
		return super.dataTypePersistence.findByGroupId ( groupId );
	}

	public List<DataType> getDataTypesByGroupId ( long groupId, int start, int end ) {
		return super.dataTypePersistence.findByGroupId ( groupId, start, end );
	}

	public List<DataType> getDataTypesByGroupId (
				long groupId, int start, int end, OrderByComparator<DataType> comparator
	) {
		return super.dataTypePersistence.findByGroupId ( groupId, start, end, comparator );
	}

	public int countDataTypesByGroupId ( long groupId ) {
		return super.dataTypePersistence.countByGroupId ( groupId );
	}

	public List<DataType> getDataTypesByUserId ( long userId ) {
		return super.dataTypePersistence.findByUserId ( userId );
	}

	public List<DataType> getDataTypesByUserId ( long userId, int start, int end ) {
		return super.dataTypePersistence.findByUserId ( userId, start, end );
	}

	public List<DataType> getDataTypesByUserId (
				long userId, int start, int end, OrderByComparator<DataType> comparator
	) {
		return super.dataTypePersistence.findByUserId ( userId, start, end, comparator );
	}

	public int countDataTypesByUserId ( long userId ) {
		return super.dataTypePersistence.countByUserId ( userId );
	}

	public List<DataType> getDataTypesByStatus ( int status ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findAll ();
		else
			return super.dataTypePersistence.findByStatus ( status );
	}

	public List<DataType> getDataTypesByStatus ( int status, int start, int end ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findAll ( start, end );
		else
			return super.dataTypePersistence.findByStatus ( status, start, end );
	}

	public List<DataType> getDataTypesByStatus (
				int status, int start, int end, OrderByComparator<DataType> comparator
	) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findAll ( start, end, comparator );
		else
			return super.dataTypePersistence.findByStatus ( status, start, end, comparator );
	}

	public int countDataTypesByStatus ( int status ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countAll ();
		else
			return super.dataTypePersistence.countByStatus ( status );
	}

	public List<DataType> getDataTypesByCode ( String dataTypeCode ) {
		return super.dataTypePersistence.findByCode ( dataTypeCode );
	}

	public List<DataType> getDataTypesByG_U ( long groupId, long userId ) {
		return super.dataTypePersistence.findByG_U ( groupId, userId );
	}

	public List<DataType> getDataTypesByG_U ( long groupId, long userId, int start, int end ) {
		return super.dataTypePersistence.findByG_U ( groupId, userId, start, end );
	}

	public List<DataType> getDataTypesByG_U (
				long groupId, long userId, int start, int end, OrderByComparator<DataType> comparator
	) {
		return super.dataTypePersistence.findByG_U ( groupId, userId, start, end, comparator );
	}

	public int countDataTypesByG_U ( long groupId, long userId ) {
		return super.dataTypePersistence.countByG_U ( groupId, userId );
	}

	public List<DataType> getDataTypesByG_S ( long groupId, int status ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByGroupId ( groupId );
		else
			return super.dataTypePersistence.findByG_S ( groupId, status );
	}

	public List<DataType> getDataTypesByG_S ( long groupId, int status, int start, int end ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByGroupId ( groupId, start, end );
		else
			return super.dataTypePersistence.findByG_S ( groupId, status, start, end );
	}

	public List<DataType> getDataTypesByG_S (
				long groupId, int status, int start, int end, OrderByComparator<DataType> comparator
	) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByGroupId ( groupId, start, end, comparator );
		else
			return super.dataTypePersistence.findByG_S ( groupId, status, start, end, comparator );
	}

	public int countDataTypesByG_S ( long groupId, int status ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countByGroupId ( groupId );
		else
			return super.dataTypePersistence.countByG_S ( groupId, status );
	}

	public List<DataType> getDataTypesByU_S ( long userId, int status ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByUserId ( userId );
		else
			return super.dataTypePersistence.findByU_S ( userId, status );
	}

	public List<DataType> getDataTypesByU_S ( long userId, int status, int start, int end ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByUserId ( userId, start, end );
		else
			return super.dataTypePersistence.findByU_S ( userId, status, start, end );
	}

	public List<DataType> getDataTypesByU_S (
				long userId, int status, int start, int end, OrderByComparator<DataType> comparator
	) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByUserId ( userId, start, end, comparator );
		else
			return super.dataTypePersistence.findByU_S ( userId, status, start, end, comparator );
	}

	public int countDataTypesByU_S ( long userId, int status ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countByUserId ( userId );
		else
			return super.dataTypePersistence.countByU_S ( userId, status );
	}

	public List<DataType> getDataTypesByG_U_S ( long groupId, long userId, int status ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByG_U ( groupId, userId );
		else
			return super.dataTypePersistence.findByG_U_S ( groupId, userId, status );
	}

	public List<DataType> getDataTypesByG_U_S ( long groupId, long userId, int status, int start, int end ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByG_U ( groupId, userId, start, end );
		else
			return super.dataTypePersistence.findByG_U_S ( groupId, userId, status, start, end );
	}

	public List<DataType> getDataTypesByG_U_S (
				long groupId, long userId, int status, int start, int end, OrderByComparator<DataType> comparator
	) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByG_U ( groupId, userId, start, end, comparator );
		else
			return super.dataTypePersistence.findByG_U_S ( groupId, userId, status, start, end, comparator );
	}

	public int countDataTypesByG_U_S ( long groupId, long userId, int status ) {
		if ( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countByG_U ( groupId, userId );
		else
			return super.dataTypePersistence.countByG_U_S ( groupId, userId, status );
	}

	public List<DataType> getApprovedDataTypes ( long groupId ) {
		return super.dataTypePersistence.findByG_S ( groupId, WorkflowConstants.STATUS_APPROVED );
	}

	public List<DataType> getApprovedDataTypes ( long groupId, int start, int end ) {
		return super.dataTypePersistence.findByG_S ( groupId, WorkflowConstants.STATUS_APPROVED, start, end );
	}

	public List<DataType> getApprovedDataTypes (
				long groupId, int start, int end, OrderByComparator<DataType> comparator
	) {
		return super.dataTypePersistence
					.findByG_S ( groupId, WorkflowConstants.STATUS_APPROVED, start, end, comparator );
	}

	public int countApprovedDataTypes ( long groupId ) {
		return super.dataTypePersistence.countByG_S ( groupId, WorkflowConstants.STATUS_APPROVED );
	}

	public String getDisplayName ( long dataTypeId, Locale locale ) {
		DataType dataType = super.dataTypePersistence.fetchByPrimaryKey ( dataTypeId );

		return dataType.getDisplayName ( locale );
	}

	public DataType getDataType ( String dataTypeCode, String dataTypeVersion ) {
		DataType dataType = super.dataTypePersistence.fetchByCodeVersion ( dataTypeCode, dataTypeVersion );

		return dataType;
	}

	public int countDataTypesByCode ( String dataTypeCode ) {
		return dataTypePersistence.countByCode ( dataTypeCode );
	}

	public OrderByComparator<DataType> getSortOrderComparator ( String orderByCol, String orderByType ) {

		boolean orderByAsc = true;

		if ( orderByType.equals ( StationXConstants.DSC ) ) {
			orderByAsc = false;
		}

		OrderByComparator<DataType> orderByComparator = null;

		if ( orderByCol.equals ( DataTypeProperties.DATATYPE_CODE ) ) {
			orderByComparator = new DataTypeCodeComparator ( orderByAsc );
		} else if ( orderByCol.equalsIgnoreCase ( "modifiedDate" ) ) {
			orderByComparator = new ModifiedDateComparator ( orderByAsc );
		} else if ( orderByCol.equalsIgnoreCase ( "groupId" ) ) {
			orderByComparator = new GroupIdComparator ( orderByAsc );
		} else if ( orderByCol.equalsIgnoreCase ( "userId" ) ) {
			orderByComparator = new UserIdComparator ( orderByAsc );
		}

		return orderByComparator;
	}

	public String getDataStructure ( long dataTypeId ) {
		DataTypeStructure structure = dataTypeStructurePersistence.fetchByPrimaryKey ( dataTypeId );

		return structure.getStructure ();
	}

	public JSONObject getDataStructureJSON ( long dataTypeId ) throws JSONException {

		DataTypeStructure structure = dataTypeStructurePersistence.fetchByPrimaryKey ( dataTypeId );

		if ( Validator.isNull ( structure ) ) {
			return null;
		}

		String strStructure = structure.getStructure ();
		if ( Validator.isNull ( strStructure ) || strStructure.isEmpty () ) {
			return null;
		}

		JSONObject json = JSONFactoryUtil.createJSONObject ( structure.getStructure () );

		System.out.println ( "JSONDataTypeStructure: " + json.toString ( 4 ) );
		return json;
	}

	public boolean hasDataStructure ( long dataTypeId ) {
		DataTypeStructure dataStructure = dataTypeStructurePersistence.fetchByPrimaryKey ( dataTypeId );

		return Validator.isNotNull ( dataStructure );
	}

	public final long getDataFileFolderId (
				long repositoryId, long parentFoderId, String dataTypeCode, String dataTypeVersion, long dataId,
				String paramCode, String paramVersion, ServiceContext sc, boolean createWhenNoExist
	) throws PortalException {

		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		String rootDataFolderName = "Data Files";

		long rootFolderId = _getFolderId ( repositoryId, parentFolderId, rootDataFolderName, sc, createWhenNoExist );
		long dataTypeFolderId = _getFolderId ( repositoryId, rootFolderId, dataTypeCode, sc, createWhenNoExist );
		long dataTypeVersionFolderId =
					_getFolderId ( repositoryId, dataTypeFolderId, dataTypeVersion, sc, createWhenNoExist );
		long dataFolderId = _getFolderId (
					repositoryId,
					dataTypeVersionFolderId,
					String.valueOf ( dataId ),
					sc,
					createWhenNoExist
		);

		if ( paramCode.isEmpty () ) {
			return dataFolderId;
		}

		long paramCodeFolderId = _getFolderId ( repositoryId, dataFolderId, paramCode, sc, createWhenNoExist );
		long paramVersionFolderId =
					_getFolderId ( repositoryId, paramCodeFolderId, paramVersion, sc, createWhenNoExist );

		return paramVersionFolderId;
	}

	@Deprecated
	private final long _getFolderId (
				long repositoryId, long parentFolderId, String folderName, ServiceContext sc, boolean createWhenNoExist
	) throws PortalException {
		Folder folder = null;
		try {
			folder = _dlAppService.getFolder ( repositoryId, parentFolderId, folderName );
		} catch ( PortalException e ) {
			if ( createWhenNoExist ) {
				folder = _dlAppService.addFolder ( repositoryId, parentFolderId, folderName, "", sc );
			}
		}

		return Validator.isNull ( folder ) ? 0 : folder.getFolderId ();
	}

	@Deprecated
	public JSONArray getDLFolderFiles ( long repositoryId, long folderId ) {
		if ( folderId == 0 ) {
			return null;
		}

		List<FileEntry> fileEntries = null;

		try {
			fileEntries = _dlAppService.getFileEntries ( repositoryId, folderId );
		} catch ( Exception e ) {
			return null;
		}

		JSONArray files = JSONFactoryUtil.createJSONArray ();
		for ( FileEntry fileEntry : fileEntries ) {
			JSONObject fileInfo = JSONFactoryUtil.createJSONObject ();
			fileInfo.put ( "parentFolderId", fileEntry.getFolderId () );
			fileInfo.put ( "fileId", fileEntry.getFileEntryId () );
			fileInfo.put ( "name", fileEntry.getFileName () );
			fileInfo.put ( "size", fileEntry.getSize () );
			fileInfo.put ( "type", fileEntry.getMimeType () );
			fileInfo.put (
						"downloadURL",
						"/documents/" + fileEntry.getGroupId () + StringPool.BACK_SLASH + fileEntry.getFolderId ()
									+ StringPool.BACK_SLASH + fileEntry.getFileName () + StringPool.BACK_SLASH
									+ fileEntry.getUuid ()
			);

			files.put ( fileInfo );
		}

		return files;
	}

	public JSONArray getFileFields ( long dataTypeId ) {
		JSONArray fileFields = JSONFactoryUtil.createJSONArray ();

		try {
			JSONObject dataStructure = getDataStructureJSON ( dataTypeId );

			JSONArray fields = dataStructure.getJSONArray ( "members" );

			for ( int i = 0; i < fields.length (); i++ ) {
				JSONObject field = fields.getJSONObject ( i );

				String paramType = field.getString ( "paramType" );
				if ( paramType.equalsIgnoreCase ( "File" ) ) {
					fileFields.put ( field );
				}
			}
		} catch ( JSONException e ) {
			e.printStackTrace ();
		} ;

		return fileFields;
	}

	public List<String> getParamCodeList ( long dataTypeId, String[] paramTypes ) throws JSONException {
		JSONObject dataStructure = getDataStructureJSON ( dataTypeId );

		return getParamCodeList ( dataStructure, paramTypes );
	}

	public List<String> getParamCodeList ( String strDataStructure, String[] paramTypes ) throws JSONException {
		JSONObject dataStructure = JSONFactoryUtil.createJSONObject ( strDataStructure );

		return getParamCodeList ( dataStructure, paramTypes );
	}

	public List<String> getParamCodeList ( JSONObject dataStructure, String[] paramTypes ) {

		JSONArray fields = dataStructure.getJSONArray ( "members" );

		return getParamCodeList ( fields, paramTypes );
	}

	public List<String> getParamCodeList ( JSONArray fields, String[] paramTypes ) {
		List<String> fieldNames = new ArrayList<> ();

		for ( int i = 0; i < fields.length (); i++ ) {
			JSONObject field = fields.getJSONObject ( i );

			String paramType = field.getString ( "paramType" );

			boolean target = false;
			for ( String type : paramTypes ) {
				target = type.equalsIgnoreCase ( paramType );

				if ( target == true ) {
					break;
				}
			}

			if ( target ) {
				String paramCode = field.getString ( "paramCode" );
				fieldNames.add ( paramCode );
			}

			if ( paramType.equalsIgnoreCase ( "Group" ) || paramType.equalsIgnoreCase ( "Grid" ) ) {
				JSONArray members = field.getJSONArray ( "members" );
				if ( Validator.isNull ( members ) ) {
					members = field.getJSONArray ( "columns" );
				}

				if ( members.length () > 0 ) {
					List<String> subFieldNames = getParamCodeList ( members, paramTypes );

					if ( subFieldNames.size () > 0 ) {
						fieldNames.addAll ( subFieldNames );
					}
				}
			}
		}

		return fieldNames;
	}

	public SearchContainerResults<AssetEntry> getSearchContainerResults ( SearchContainer<DataType> searchContainer )
				throws PortalException {

		AssetEntryQuery assetEntryQuery = new AssetEntryQuery ( DataType.class.getName (), searchContainer );

		assetEntryQuery.setExcludeZeroViewCount ( false );
		assetEntryQuery.setOrderByCol1 ( searchContainer.getOrderByCol () );
		assetEntryQuery.setOrderByType1 ( searchContainer.getOrderByType () );

		System.out.println (
					"DataTypeLocalService.getSearchContainerResults Type: " + searchContainer.getOrderByType ()
		);
		assetEntryQuery.setVisible ( Boolean.TRUE );

		int total = AssetEntryServiceUtil.getEntriesCount ( assetEntryQuery );

		assetEntryQuery.setEnd ( searchContainer.getEnd () );
		assetEntryQuery.setStart ( searchContainer.getStart () );

		List<AssetEntry> assetEntries = AssetEntryServiceUtil.getEntries ( assetEntryQuery );

		return new SearchContainerResults<AssetEntry> ( assetEntries, total );
	}

	public boolean checkDuplicated ( String dataTypeCode, String dataTypeVersion ) {
		// Check uniqueness of the dataTypeCode
		return dataTypePersistence.countByCodeVersion ( dataTypeCode, dataTypeVersion ) > 0;
	}

	@Reference
	private DataStructureLocalService _dataStructureLocalService;

	@Reference
	private DataTypeStructureLocalService _dataTypeStructureLocalService;

	@Reference
	private SetTypeLinkLocalService _setTypeLinkLocalService;

	@Reference
	private TypeVisualizerLinkLocalService _typeVisualizerLinkLocalService;
}
