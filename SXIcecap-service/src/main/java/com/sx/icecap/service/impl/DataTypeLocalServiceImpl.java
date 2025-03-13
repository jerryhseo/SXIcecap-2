/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the dataTypes of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sx.icecap.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
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
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.sx.constant.StationXConstants;
import com.sx.icecap.constant.DataStructureProperty;
import com.sx.icecap.constant.Constant;
import com.sx.icecap.constant.DataTypeProperty;
import com.sx.icecap.constant.ParameterProperty;
import com.sx.icecap.constant.ParameterType;
import com.sx.icecap.exception.DuplicatedDataTypeNameException;
import com.sx.icecap.exception.InvalidDataTypeNameException;
import com.sx.icecap.exception.NoSuchDataStructureException;
import com.sx.icecap.exception.NoSuchDataTypeException;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataStructureLocalService;
import com.sx.icecap.service.StructuredDataLocalServiceUtil;
import com.sx.icecap.service.base.DataTypeLocalServiceBaseImpl;
import com.sx.icecap.util.comparator.GroupIdComparator;
import com.sx.icecap.util.comparator.ModifiedDateComparator;
import com.sx.icecap.util.comparator.UserIdComparator;
import com.sx.icecap.util.comparator.datatype.DataTypeNameComparator;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.DataType",
	service = AopService.class
)
public class DataTypeLocalServiceImpl extends DataTypeLocalServiceBaseImpl {
	
	@Reference
	private DLAppService _dlAppService;
	
	@Indexable(type = IndexableType.REINDEX)
	public DataType addDataType(
			String dataTypeName,
			String dataTypeVersion,
			String extension,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap,
			Map<Locale, String> tooltipMap,
			String visualizers,
			int status,
			ServiceContext sc) throws PortalException {
		
		try {
			if( !_verifyDataTypeName(dataTypeName) ) {
				throw new InvalidDataTypeNameException(dataTypeName+" "+dataTypeVersion+" Invalid"); 
			}
		} catch( DuplicatedDataTypeNameException e ) {
			throw e;
		}
		
		Locale defaultLocale = sc.getThemeDisplay().getLocale();
		
		long dataTypeId = super.counterLocalService.increment();
		DataType dataType = super.dataTypeLocalService.createDataType(dataTypeId);
		
		dataType.setDataTypeName(dataTypeName);
		dataType.setDataTypeVersion(dataTypeVersion);
		dataType.setExtension(extension);
		dataType.setDisplayNameMap(displayNameMap, defaultLocale);
		dataType.setDescriptionMap(descriptionMap, defaultLocale);
		dataType.setTooltipMap(tooltipMap, defaultLocale);
		dataType.setVisualizers(visualizers);
		dataType.setHasDataStructure(false);
		
		Date now = new Date();
		User user = super.userLocalService.getUser(sc.getUserId());
		dataType.setCompanyId(sc.getCompanyId());
		dataType.setGroupId(sc.getScopeGroupId());
		dataType.setUserId(user.getUserId());
		dataType.setUserName(user.getFullName());
		dataType.setCreateDate(now);
		dataType.setModifiedDate(now);
		
		if( status > WorkflowConstants.STATUS_ANY ) {
			dataType.setStatus(status);
		}
		else {
			dataType.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		dataType.setStatusByUserId(sc.getUserId());
		dataType.setStatusByUserName(user.getFullName());
		dataType.setStatusDate(sc.getModifiedDate(null));
		
		
		dataType.setExpandoBridgeAttributes(sc);
		
		dataType = super.dataTypePersistence.update(dataType, sc);

		super.resourceLocalService.addResources(
				dataType.getCompanyId(), 
				dataType.getGroupId(), 
				dataType.getUserId(), 
				DataType.class.getName(), 
				dataType.getPrimaryKey(), 
				false, 
				true, 
				true);
//			System.out.println("Resource Finished....");
		
		super.assetEntryLocalService.updateEntry(
			dataType.getUserId(), 
			dataType.getGroupId(), 
			dataType.getCreateDate(), 
			dataType.getModifiedDate(),
			DataType.class.getName(), 
			dataType.getPrimaryKey(), 
			dataType.getUuid(), 
			0,
			sc.getAssetCategoryIds(), 
			sc.getAssetTagNames(), 
			true,
			true, 
			null, 
			null, 
			dataType.getCreateDate(),
			null, 
			ContentTypes.TEXT_HTML_UTF8, 
			dataType.getDataTypeName(),
			null, 
			null, 
			null, 
			null,
			0, 0, null);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				dataType.getCompanyId(), 
				dataType.getGroupId(), 
				dataType.getUserId(), 
				DataType.class.getName(), 
				dataType.getPrimaryKey(), 
				dataType, 
				sc);
		
		return dataType;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataType updateDataType(
			long dataTypeId, 
			String dataTypeName, 
			String dataTypeVersion,
			String extension,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap,
			Map<Locale, String> tooltipMap,
			String visualizers,
			int status,
			ServiceContext sc) throws PortalException {
		DataType dataType = super.dataTypePersistence.findByPrimaryKey(dataTypeId);
		
		dataType.setDataTypeName(dataTypeName);
		dataType.setDataTypeVersion(dataTypeVersion);
		dataType.setExtension(extension);
		dataType.setDisplayNameMap(displayNameMap, sc.getLocale());
		dataType.setDescriptionMap(descriptionMap, sc.getLocale());
		dataType.setTooltipMap(tooltipMap, sc.getLocale());
		dataType.setVisualizers(visualizers);
		
		dataType.setUserId(sc.getUserId());
		dataType.setGroupId(sc.getScopeGroupId());
		dataType.setModifiedDate(new Date() );

		boolean statusChanged = false;
		if( status > WorkflowConstants.STATUS_ANY && status != dataType.getStatus()) {
			User user = super.userLocalService.getUser(sc.getUserId());
			dataType.setStatus(status);
			dataType.setStatusByUserId(user.getUserId());
			dataType.setStatusByUserName(user.getFullName());
			dataType.setStatusDate(new Date());
			statusChanged = true;
		}
		
		dataType.setExpandoBridgeAttributes(sc);
		
		super.dataTypePersistence.update(dataType, sc);
		
		super.resourceLocalService.updateResources(
				dataType.getCompanyId(),
				dataType.getGroupId(), 
				DataType.class.getName(), 
				dataType.getPrimaryKey(),
				sc.getModelPermissions());
		
		super.assetEntryLocalService.updateEntry(
				dataType.getUserId(), 
				dataType.getGroupId(), 
				dataType.getCreateDate(), 
				dataType.getModifiedDate(),
				DataType.class.getName(), 
				dataType.getPrimaryKey(), 
				dataType.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				dataType.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				dataType.getDataTypeName(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		if( statusChanged ) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				super.assetEntryLocalService.updateVisible(DataType.class.getName(), dataTypeId, true);
			} else {
				super.assetEntryLocalService.updateVisible(DataType.class.getName(), dataTypeId, false);
			}
		}
		
		return dataType;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataType updateStatus(
			long userId, 
			long dataTypeId, 
			Integer status,
			ServiceContext sc) throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		DataType dataType = super.dataTypePersistence.findByPrimaryKey(dataTypeId);

		dataType.setStatus(status);
		dataType.setStatusByUserId(userId);
		dataType.setStatusByUserName(user.getFullName());
		dataType.setStatusDate(new Date());

		super.dataTypePersistence.update(dataType, sc);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			super.assetEntryLocalService.updateVisible(DataType.class.getName(), dataTypeId, true);
		} else {
			super.assetEntryLocalService.updateVisible(DataType.class.getName(), dataTypeId, false);
		}

		return dataType;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public DataType removeDataType( long dataTypeId ) throws PortalException {
		DataType dataType = super.dataTypePersistence.remove(dataTypeId);
		
		_dataStructureLocalService.deleteDataStructures(dataTypeId);
		_updateHasDataStructure(dataTypeId, false);
		
		super.assetEntryLocalService.deleteEntry(DataType.class.getName(), dataType.getPrimaryKey());

		super.resourceLocalService.deleteResource(
				dataType.getCompanyId(), 
				DataType.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, 
				dataType.getPrimaryKey());
		
		super.workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			    dataType.getCompanyId(), dataType.getGroupId(),
			    DataType.class.getName(), dataType.getDataTypeId());
		
		return dataType;
	}
	
	public void removeDataTypes( long[] dataTypeIds ) throws PortalException {
		for( long dataTypeId : dataTypeIds ) {
			this.removeDataType(dataTypeId);
		}
	}
	
	public DataType copyDataType( long dataTypeId, ServiceContext sc ) throws PortalException {
		DataType dataType = super.dataTypePersistence.fetchByPrimaryKey(dataTypeId);
		if( Validator.isNull(dataType) ) {
			throw new PortalException( "Cannot find data type to be copied: " + dataTypeId );
		}
		
		DataType copiedDataType = this.addDataType(
							dataType.getDataTypeName() + "_copied", 
							"1.0.0", 
							dataType.getExtension(), 
							dataType.getDisplayNameMap(), 
							dataType.getDescriptionMap(), 
							dataType.getTooltipMap(),
							dataType.getVisualizers(),
							WorkflowConstants.STATUS_DRAFT, 
							sc);
		
		return copiedDataType;
	}
	
	/**
	 *  Set the data structure for the dataType specified by dataTypeId.
	 *  
	 *  @since 1.0
	 *  @see com.sx.icecap.datatype.service
	 *  @author Jerry H. Seo
	 *  @param
	 *  	long Datatype ID
	 *  	String Data Structure
	 *  @throws
	 *  	void
	 *  @return
	 *  	void
	 */
	public DataStructure updateDataStructure( long dataTypeId, String version, String strDataStructure ) {
		
		// Set data structure and update the table
		DataStructure dataStructure = _dataStructureLocalService.updateDataStructure(dataTypeId, version, strDataStructure);
		// Update the property, hasDataStructure,  of the data type as true
		_updateHasDataStructure( dataTypeId, true );
		
		return dataStructure;
	}
	
	public void deleteDataStructures( long dataTypeId ) {
		_dataStructureLocalService.deleteDataStructures(dataTypeId);
		_updateHasDataStructure( dataTypeId, false );
	}
	
	public void deleteDataStructure( long dataTypeId, String version) throws NoSuchDataStructureException {
		_dataStructureLocalService.deleteDataStructure(dataTypeId, version);
		
		if( _dataStructureLocalService.countByDataTypeId(dataTypeId) < 1 ) {
			_updateHasDataStructure(dataTypeId, false);
		}
	}
	
	public List<DataType> getDataTypes( 
			long groupId, 
			long userId, 
			int status, 
			int start, 
			int end, 
			String orderCol,
			String orderType){
		if( groupId > 0 && userId > 0 ) {
			return getDataTypesByG_U_S(groupId, userId, status, start, end, getSortOrderComparator(orderCol, orderType));
		}
		else if( groupId > 0 ) {
			return getDataTypesByG_S(groupId, status, start, end, getSortOrderComparator(orderCol, orderType));
		}
		else if( userId > 0 ) {
			return getDataTypesByU_S(userId, status, start, end, getSortOrderComparator(orderCol, orderType));
		}
		else {
			return getDataTypesByStatus(status, start, end, getSortOrderComparator(orderCol, orderType));
		}
	}
	public String getDataTypesJSON(  long groupId, long userId, int status, int start, int end, String orderCol,
			String orderType ){
		List<DataType> dataTypeList = getDataTypes( groupId, userId, status, start, end, orderCol, orderType);

		return JSONFactoryUtil.looseSerialize(dataTypeList);
	}
	public int countDataTypes( long groupId, long userId, int status ) {
		if( groupId > 0 && userId > 0 ) {
			return countDataTypesByG_U_S(groupId, userId, status);
		}
		else if( groupId > 0 ) {
			return countDataTypesByG_S(groupId, status);
		}
		else if( userId > 0 ) {
			return countDataTypesByU_S(userId, status);
		}
		else {
			return countDataTypesByStatus(status);
		}
	}
	
	public List<DataType> getAllDataTypes(){
		return super.dataTypePersistence.findAll();
	}
	public List<DataType> getAllDataTypes( int start, int end ){
		return super.dataTypePersistence.findAll(start, end);
	}
	public List<DataType> getAllDataTypes( int start, int end, OrderByComparator<DataType> comparator){
		return super.dataTypePersistence.findAll(start, end, comparator);
	}
	public int countAllDataTypes() {
		return super.dataTypePersistence.countAll();
	}
	
	public List<DataType> getDataTypesByGroupId( long groupId ){
		return super.dataTypePersistence.findByGroupId(groupId);
	}
	public List<DataType>  getDataTypesByGroupId( long groupId, int start, int end ){
		return super.dataTypePersistence.findByGroupId(groupId, start, end);
	}
	public List<DataType>  getDataTypesByGroupId( long groupId, int start, int end, OrderByComparator<DataType> comparator ){
		return super.dataTypePersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int countDataTypesByGroupId(long groupId) {
		return super.dataTypePersistence.countByGroupId(groupId);
	}

	public List<DataType> getDataTypesByUserId( long userId ){
		return super.dataTypePersistence.findByUserId(userId);
	}
	public List<DataType>  getDataTypesByUserId( long userId, int start, int end ){
		return super.dataTypePersistence.findByUserId(userId, start, end);
	}
	public List<DataType>  getDataTypesByUserId( long userId, int start, int end, OrderByComparator<DataType> comparator ){
		return super.dataTypePersistence.findByUserId(userId, start, end, comparator);
	}
	public int countDataTypesByUserId(long userId) {
		return super.dataTypePersistence.countByUserId(userId);
	}

	public List<DataType> getDataTypesByStatus( int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findAll();
		else
			return super.dataTypePersistence.findByStatus(status);
	}
	public List<DataType>  getDataTypesByStatus( int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findAll(start, end);
		else
			return super.dataTypePersistence.findByStatus(status, start, end);
	}
	public List<DataType>  getDataTypesByStatus( int status, int start, int end, OrderByComparator<DataType> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findAll(start, end, comparator);
		else
			return super.dataTypePersistence.findByStatus(status, start, end, comparator);
	}
	public int countDataTypesByStatus(int status) {
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countAll();
		else
			return super.dataTypePersistence.countByStatus(status);
	}

	public List<DataType> getDataTypesByName( String dataTypeName ){
		return super.dataTypePersistence.findByName(dataTypeName);
	}
	
	public List<DataType> getDataTypesByG_U( long groupId, long userId ){
		return super.dataTypePersistence.findByG_U(groupId, userId);
	}
	public List<DataType> getDataTypesByG_U( long groupId,  long userId, int start, int end ){
		return super.dataTypePersistence.findByG_U(groupId, userId, start, end);
	}
	public List<DataType> getDataTypesByG_U( long groupId,  long userId, int start, int end, OrderByComparator<DataType> comparator ){
		return super.dataTypePersistence.findByG_U(groupId, userId, start, end, comparator);
	}
	public int countDataTypesByG_U( long groupId,  long userId ){
		return super.dataTypePersistence.countByG_U(groupId, userId);
	}
	
	public List<DataType> getDataTypesByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByGroupId(groupId);
		else
			return super.dataTypePersistence.findByG_S(groupId, status);
	}
	public List<DataType> getDataTypesByG_S( long groupId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByGroupId(groupId, start, end);
		else
			return super.dataTypePersistence.findByG_S(groupId, status, start, end);
	}
	public List<DataType> getDataTypesByG_S( long groupId, int status, int start, int end, OrderByComparator<DataType> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByGroupId(groupId, start, end, comparator);
		else
			return super.dataTypePersistence.findByG_S(groupId, status, start, end, comparator);
	}
	public int countDataTypesByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countByGroupId(groupId);
		else
			return super.dataTypePersistence.countByG_S(groupId, status);
	}
	
	public List<DataType> getDataTypesByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByUserId(userId);
		else
			return super.dataTypePersistence.findByU_S(userId, status);
	}
	public List<DataType> getDataTypesByU_S( long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByUserId(userId, start, end);
		else
			return super.dataTypePersistence.findByU_S(userId, status, start, end);
	}
	public List<DataType> getDataTypesByU_S( long userId, int status, int start, int end, OrderByComparator<DataType> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByUserId(userId, start, end, comparator);
		else
			return super.dataTypePersistence.findByU_S(userId, status, start, end, comparator);
	}
	public int countDataTypesByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countByUserId(userId);
		else
			return super.dataTypePersistence.countByU_S(userId, status);
	}
	
	public List<DataType> getDataTypesByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByG_U(groupId, userId);
		else
			return super.dataTypePersistence.findByG_U_S(groupId, userId, status);
	}
	public List<DataType> getDataTypesByG_U_S( long groupId, long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByG_U(groupId, userId, start, end);
		else
			return super.dataTypePersistence.findByG_U_S(groupId, userId, status, start, end);
	}
	public List<DataType> getDataTypesByG_U_S( long groupId, long userId, int status, int start, int end, OrderByComparator<DataType> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByG_U(groupId, userId, start, end, comparator);
		else
			return super.dataTypePersistence.findByG_U_S(groupId, userId, status, start, end, comparator);
	}
	public int countDataTypesByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countByG_U(groupId, userId);
		else
			return super.dataTypePersistence.countByG_U_S(groupId, userId, status);
	}
	
	public List<DataType> getApprovedDataTypes( long groupId ){
		return super.dataTypePersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	public List<DataType> getApprovedDataTypes( long groupId, int start, int end ){
		return super.dataTypePersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
	}
	public List<DataType> getApprovedDataTypes( long groupId, int start, int end, OrderByComparator<DataType> comparator ){
		return super.dataTypePersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end, comparator);
	}
	public int countApprovedDataTypes( long groupId ) {
		return super.dataTypePersistence.countByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	
	public String getName( long dataTypeId, Locale locale ) throws NoSuchDataTypeException {
		DataType dataType = super.dataTypePersistence.findByPrimaryKey(dataTypeId);
		
		return dataType.getDisplayName(locale);
	}
	
	public OrderByComparator<DataType> getSortOrderComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = true;

		if (orderByType.equals(StationXConstants.DSC)) {
			orderByAsc = false;
		}

		OrderByComparator<DataType> orderByComparator = null;

		if (orderByCol.equals(DataTypeProperty.DATATYPE_NAME)) {
			orderByComparator = new DataTypeNameComparator(orderByAsc);
		}
		else if( orderByCol.equalsIgnoreCase("modifiedDate")) {
			orderByComparator = new ModifiedDateComparator(orderByAsc);
		}
		else if( orderByCol.equalsIgnoreCase("groupId")) {
			orderByComparator = new GroupIdComparator(orderByAsc);
		}
		else if( orderByCol.equalsIgnoreCase("userId")) {
			orderByComparator = new UserIdComparator(orderByAsc);
		}

		return orderByComparator;
	}
	
	public String getDataStructure( long dataTypeId ) throws NoSuchDataStructureException{
		DataStructure dataStructure = super.dataStructurePersistence.findByPrimaryKey(dataTypeId);
		String structure = dataStructure.getStructure();
		return Validator.isNull(structure) ? StringPool.BLANK : structure;
	}
	
	/**
	 * Get data structure as a JSON object.
	 * 
	 *  @return
	 *  	null,	if the data type has no structure
	 *  	JSONObject, if has a proper structure.
	 */
	
	public JSONObject getDataStructureJSONObject( long dataTypeId ) throws JSONException{
		String dataStructureString = "";
		
		try {
			dataStructureString = getDataStructure( dataTypeId );
		} catch (NoSuchDataStructureException e) {
			dataStructureString = "";
		}
		
		JSONObject jsonObject = null;
		if( !dataStructureString.isEmpty() ) {
				jsonObject = JSONFactoryUtil.createJSONObject( dataStructureString );
		}
		
		return jsonObject;
	}
	
	public JSONObject getParameterByName( long dataTypeId, String paramName ) throws JSONException {
		JSONObject param = null;
		
		JSONObject structure = getDataStructureJSONObject(dataTypeId);
		
		JSONArray params = structure.getJSONArray(DataStructureProperty.PARAMS);
		
		for( int i=0; i<params.length(); i++ ) {
			param = params.getJSONObject(i);
			
			if( paramName.equalsIgnoreCase( param.getString(ParameterProperty.NAME)) ) {
				break;
			}
		}
		
		return param;
	}
	
	public StructuredData addStructuredData(
			long dataSetId, 
			long dataTypeId,
			String data,
			int status,
			ServiceContext sc) throws PortalException  {
		return StructuredDataLocalServiceUtil.addStructuredData(dataSetId, dataTypeId, data, status, sc);
	}

	public StructuredData updateStructuredData(
			long structuredDataId,
			long dataSetId, 
			long dataTypeId,
			String data,
			int status,
			ServiceContext sc) throws PortalException  {
		return StructuredDataLocalServiceUtil.updateStructuredData(structuredDataId, dataSetId, dataTypeId, data, status, sc);
	}
	
	public StructuredData updateStructuredDataStatus(
			long userId, 
			long structuredDataId, 
			Integer status,
			ServiceContext sc) throws PortalException, SystemException {
		return StructuredDataLocalServiceUtil.updateStatus(userId, structuredDataId, status, sc);
	}
	
	public StructuredData removeStructuredData( long structuredDataId, long dataFileFolderId ) throws PortalException {
		return StructuredDataLocalServiceUtil.removeStructuredData( 
				structuredDataId, dataFileFolderId);
	}
	
	/*
	public void removeStructuredDatas( long[] structuredDataIds ) throws PortalException {
		StructuredDataLocalServiceUtil.removeStructuredDatas(structuredDataIds);
	}
	*/

	public String getStructuredData( long structuredDataId ){
		StructuredData data = super.structuredDataPersistence.fetchByPrimaryKey(structuredDataId);
		return data.getStructuredData();
	}
	
	public List<StructuredData> getStructuredDatas( long dataTypeId ){
		return super.structuredDataPersistence.findByDataTypeId(dataTypeId);
	}
	public List<StructuredData> getStructuredDatas( long dataTypeId, int start, int end ){
		return super.structuredDataPersistence.findByDataTypeId(dataTypeId, start, end);
	}
	
	public JSONArray getStructuredDatasJSON( long dataTypeId ) {
		List<StructuredData> listDatas = this.getStructuredDatas(dataTypeId);
		
		JSONArray datas = JSONFactoryUtil.createJSONArray( listDatas );
		
		return datas;
	}
	
	public List<StructuredData> performAdvancedSearchOnStructuredData( long dataTypeId, String advancedQuery, int start, int end ) throws JSONException{
		
		JSONObject dataStructure = this.getDataStructureJSONObject(dataTypeId);
		if( Validator.isNull(dataStructure) ) {
			return null;
		}
		
		List<StructuredData> results = new ArrayList<>();
		
		List<StructuredData> allData = getStructuredDatas(dataTypeId);
		JSONObject jsonQuery = JSONFactoryUtil.createJSONObject(advancedQuery);
		String fieldOperator = jsonQuery.getString("fieldOperator");
		JSONObject jsonClauses = jsonQuery.getJSONObject("clauses");
		
		for( int i=0; i<allData.size(); i++ ) {
			StructuredData data = allData.get(i);
			String structuredData = data.getStructuredData();
			JSONObject dataJson = JSONFactoryUtil.createJSONObject( structuredData );
			
			Iterator<String> fieldIter = jsonClauses.keys();
			while( fieldIter.hasNext() ) {
				String field = fieldIter.next();
				
				JSONObject clause = jsonClauses.getJSONObject(field);
				
				String inFieldOperator = clause.getString("operator");
				boolean rangeSearch = clause.getBoolean("searchType");
				
				if( rangeSearch == true ) {
					
				}
				else {
					JSONArray keywords;
				}
			}
		}
		
		try {
			JSONObject query = JSONFactoryUtil.createJSONObject(advancedQuery);
			
			JSONObject andQuery = null;
			if( query.has("and") ) {
				andQuery = query.getJSONObject("and");
				_processAndQuery( allData, dataStructure, andQuery, start, end );
			}
			
			JSONObject orQuery = null;
			if( query.has("or") ) {
				orQuery = query.getJSONObject("or");
				_processOrQuery( allData, dataStructure, orQuery, start, end );
			}
			
			boolean hit = false;
			
			Iterator<String> queryIter = query.keys();
			while( queryIter.hasNext() ) {
				String key = queryIter.next();
				
				String queryVal = query.getString(key);
				
				for( int i=0; i<allData.size(); i++ ) {
					StructuredData structuredData = allData.get(i);
					JSONObject data = JSONFactoryUtil.createJSONObject(structuredData.getStructuredData());
					
				}
				
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}
	
	private List<StructuredData> _processAndQuery( List<StructuredData> dataList, JSONObject dataStructure, JSONObject query, int start, int end ) {
		List<StructuredData> results = new ArrayList<>();
		
		int delta =end - start + 1;
		int resultCount = 0;
		
		Iterator<String> queryIter = query.keys();
		
		List<StructuredData> qualifiedDataList = dataList;
		
		while( queryIter.hasNext() ) {
			String field = queryIter.next();
			
			JSONObject fieldQuery = query.getJSONObject(field);
			String operator = fieldQuery.getString("operator");
			
			if( operator.equalsIgnoreCase("and") ) {
				
			}
			else {
				
			}
		}
		
		return results;
	}
	
	private List<StructuredData> _processOrQuery( List<StructuredData> dataList, 	JSONObject dataStructure, JSONObject andQuery, int start, int end ) {
		List<StructuredData> results = new ArrayList<>();
		
		return results;
	}
	
	public List<String> getAbstractFields( long dataTypeId, boolean abstractKey ) throws JSONException{
		List<String> abstractFieldList = new ArrayList<String>();
		
		JSONObject dataStructure = getDataStructureJSONObject(dataTypeId);
		
		if( Validator.isNotNull(dataStructure) ) {
			JSONArray params = dataStructure.getJSONArray(DataStructureProperty.PARAMS);
			
			for( int i=0; i<params.length(); i++ ) {
				JSONObject param = params.getJSONObject(i);
				
				boolean definedValue = (param.has(ParameterProperty.ABSTRACT_KEY) 
										&& param.getBoolean(ParameterProperty.ABSTRACT_KEY) == true) ? true : false;
				if( definedValue == abstractKey ) {
					abstractFieldList.add(param.getString(ParameterProperty.NAME));
				}
			}
		}
		
		return abstractFieldList;
	}
	
	public List<String> getSearchableFields( long dataTypeId, boolean searchable ) throws JSONException{
		List<String> searchableFieldList = new ArrayList<String>();
		
		JSONObject dataStructure = getDataStructureJSONObject(dataTypeId);
		
		if( Validator.isNotNull(dataStructure) ) {
			JSONArray params = dataStructure.getJSONArray(DataStructureProperty.PARAMS);
	
			for( int i=0; i<params.length(); i++ ) {
				JSONObject param = params.getJSONObject(i);
				if( param.getString(ParameterProperty.TYPE).equalsIgnoreCase(ParameterType.GROUP)) {
					continue;
				}
	
				boolean definedValue = (param.has(ParameterProperty.SEARCHABLE) 
											&& param.getBoolean(ParameterProperty.SEARCHABLE) == false) ? false : true;
				if( definedValue == searchable ) {
					searchableFieldList.add(param.getString(ParameterProperty.NAME));
				}
			}
		}
		
		return searchableFieldList;
	}
	
	public List<String> getDownloadableFields( long dataTypeId, boolean downloadable ) throws JSONException{
		List<String> downloadableFieldList = new ArrayList<String>();
		JSONObject dataStructure = getDataStructureJSONObject(dataTypeId);
		
		if( Validator.isNotNull(dataStructure) ) {
			JSONArray params = dataStructure.getJSONArray(DataStructureProperty.PARAMS);
	
			for( int i=0; i<params.length(); i++ ) {
				JSONObject param = params.getJSONObject(i);
	
				boolean definedValue = (param.has(ParameterProperty.DOWNLOADABLE) 
										&& param.getBoolean(ParameterProperty.DOWNLOADABLE) == false) ? false : true;
				if(  definedValue == downloadable ) {
					downloadableFieldList.add(param.getString(ParameterProperty.NAME));
				}
			}
		}
		
		return downloadableFieldList;
	}

	public final long getDataFileFolderId(
			long repositoryId,
			long parentFoderId,
			String dataTypeName,
			String dataTypeVersion,
			long dataId,
			String paramName,
			String paramVersion,
			ServiceContext sc,
			boolean createWhenNoExist ) throws PortalException {
	
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		String rootDataFolderName = "Data Files";
		
		long rootFolderId = _getFolderId( repositoryId, parentFolderId, rootDataFolderName, sc, createWhenNoExist);
		long dataTypeFolderId = _getFolderId( repositoryId, rootFolderId, dataTypeName, sc, createWhenNoExist);
		long dataTypeVersionFolderId = _getFolderId( repositoryId, dataTypeFolderId, dataTypeVersion, sc, createWhenNoExist);
		long dataFolderId = _getFolderId( repositoryId, dataTypeVersionFolderId, String.valueOf(dataId), sc, createWhenNoExist );
		
		if( paramName.isEmpty() ) {
			return dataFolderId;
		}
		
		long paramNameFolderId = _getFolderId( repositoryId, dataFolderId, paramName, sc, createWhenNoExist);
		long paramVersionFolderId = _getFolderId( repositoryId, paramNameFolderId, paramVersion, sc, createWhenNoExist);
		
		return paramVersionFolderId;
	}
	
	private final long _getFolderId( long repositoryId, long parentFolderId, String folderName, ServiceContext sc, boolean createWhenNoExist ) throws PortalException{
		Folder folder = null;
		try {
			folder = _dlAppService.getFolder(repositoryId, parentFolderId, folderName);
		} catch (PortalException e) {
			if( createWhenNoExist ) {
				folder = _dlAppService.addFolder(repositoryId, parentFolderId, folderName, "", sc);
			}
		}
		
		return Validator.isNull(folder) ? 0 : folder.getFolderId();
	}
	
	public JSONArray getDLFolderFiles( long repositoryId, long folderId ) {
		if( folderId == 0 ) {
			return null;
		}
		
		List<FileEntry> fileEntries = null;
		
		try {
			fileEntries = _dlAppService.getFileEntries( repositoryId, folderId );
		} catch (Exception e) {
			return null;
		}
		
		JSONArray files = JSONFactoryUtil.createJSONArray(); 
		for( FileEntry fileEntry : fileEntries ) {
			JSONObject fileInfo = JSONFactoryUtil.createJSONObject();
			fileInfo.put("parentFolderId", fileEntry.getFolderId() );
			fileInfo.put("fileId", fileEntry.getFileEntryId() );
			fileInfo.put("name", fileEntry.getFileName() );
			fileInfo.put("size", fileEntry.getSize() );
			fileInfo.put("type", fileEntry.getMimeType() );
			fileInfo.put("downloadURL", "/documents/" + fileEntry.getGroupId() + StringPool.BACK_SLASH + fileEntry.getFolderId() + StringPool.BACK_SLASH + fileEntry.getFileName() + StringPool.BACK_SLASH + fileEntry.getUuid() );
			
			files.put(fileInfo);
		}
		
		return files;
	}
	
	public Map<String, Object> parseStructuredData( 
			String paramDelimiter, String valueDelimiter, String structuredData ){
		
		Map<String, Object> valueMap = new HashMap<String, Object>();
		
		String[] lines = structuredData.split(paramDelimiter);
		for( int i=0; i<lines.length; i++ ) {
			String line = lines[i].trim();
			
			if(! line.isEmpty() ) {
				String[] tokens = line.split(valueDelimiter);
				List<String> tokenList = Arrays.asList( tokens );
				tokens = Arrays.stream(tokens).filter(token -> token.isEmpty() ).toArray(String[]::new);
				System.out.println();
				valueMap.put( tokens[0].trim(), tokens[2].trim() );
			}
		}
		
		return valueMap;
	}
	
	public SearchContainerResults<AssetEntry> getSearchContainerResults(
			SearchContainer<DataType> searchContainer)
		throws PortalException {

		AssetEntryQuery assetEntryQuery = new AssetEntryQuery(
			DataType.class.getName(), searchContainer);

		assetEntryQuery.setExcludeZeroViewCount(false);
		assetEntryQuery.setOrderByCol1(searchContainer.getOrderByCol());
		assetEntryQuery.setOrderByType1(searchContainer.getOrderByType());
		
		System.out.println("DataTypeLocalService.getSearchContainerResults Type: "+searchContainer.getOrderByType());
		assetEntryQuery.setVisible(Boolean.TRUE);

		int total = AssetEntryServiceUtil.getEntriesCount(assetEntryQuery);

		assetEntryQuery.setEnd(searchContainer.getEnd());
		assetEntryQuery.setStart(searchContainer.getStart());

		List<AssetEntry> assetEntries = AssetEntryServiceUtil.getEntries(
			assetEntryQuery);

		return new SearchContainerResults<AssetEntry>(assetEntries, total);
	}
	
	/**
	 * 
	 * @param dataTypeName
	 * @param dataTypeVersion
	 * @return true if the dataType is verified.
	 * @throws DuplicatedDataTypeNameException 
	 */
	private boolean _verifyDataTypeName( String dataTypeName ) throws DuplicatedDataTypeNameException {
		// Check uniqueness of the dataTypeName
		if( super.dataTypePersistence.countByName(dataTypeName) > 0 ) {
			throw new DuplicatedDataTypeNameException( dataTypeName + " exists already." );
		}
		
		// Check if the naming convention of the dataType name is followed
		String pattern = "[a-zA-Z]([a-zA-Z0-9_]*)";
		return dataTypeName.matches(pattern);
	}
	
	private boolean _isNotEmpty( String str ) {
		return Validator.isNotNull(str) && !str.isEmpty();
	}
	
	private DataStructure _updateDataStructure( long dataTypeId, String version, String strDataStructure ) {
		DataStructure dataStructure = _dataStructureLocalService.updateDataStructure(dataTypeId, version, strDataStructure);
		this._updateHasDataStructure(dataTypeId, true);
		
		return dataStructure;
	}
	
	private DataType _updateHasDataStructure( long dataTypeId, boolean has ) {
		DataType dataType = super.dataTypeLocalService.fetchDataType(dataTypeId);
		dataType.setHasDataStructure(has);
		super.dataTypePersistence.update(dataType);
		
		return dataType;
	}

	@Reference
	private DataStructureLocalService _dataStructureLocalService;
}