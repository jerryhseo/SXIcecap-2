/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the structuredDatas of the GNU Lesser General Public License as published by the Free
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
import com.liferay.document.library.kernel.service.DLAppService;
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
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.sx.icecap.constant.ActionHistoryTypes;
import com.sx.icecap.constant.DataCommentTypes;
import com.sx.icecap.constant.DataStructureProperties;
import com.sx.icecap.model.DataCollection;
import com.sx.icecap.model.DataComment;
import com.sx.icecap.model.DataSet;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.model.TypeStructureLink;
import com.sx.icecap.service.base.StructuredDataLocalServiceBaseImpl;
import com.sx.util.SXPortalUtil;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.StructuredData",
	service = AopService.class
)
public class StructuredDataLocalServiceImpl
	extends StructuredDataLocalServiceBaseImpl {
	
	@Reference
	DLAppService _dlAppService;
	
	@Indexable(type = IndexableType.REINDEX)
	public StructuredData addStructuredData( 
			long dataCollectionId, 
			long dataSetId, 
			long dataTypeId,
			boolean multiple,
			long startIndex,
			int count,
			boolean freezed,
			boolean verified,
			String data,
			int status,
			ServiceContext sc) throws PortalException  {
	
		User user = super.userLocalService.getUser( sc.getUserId() );
		
		Date now = sc.getCreateDate();
		
		long structuredDataId = super.counterLocalService.increment();
		StructuredData structuredData = super.structuredDataPersistence.create(structuredDataId);
		
		structuredData.setCompanyId(sc.getCompanyId());
		structuredData.setGroupId(sc.getScopeGroupId());
		structuredData.setUserId(sc.getUserId());
		structuredData.setUserName(user.getFullName());
		structuredData.setCreateDate(now);
		structuredData.setModifiedDate(now);
		
		if( status > WorkflowConstants.STATUS_ANY ) {
			structuredData.setStatus(status);
		}
		else {
			structuredData.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		
		structuredData.setStatusByUserId(sc.getUserId());
		structuredData.setStatusByUserName(user.getFullName());
		structuredData.setStatusDate(sc.getModifiedDate(null));

		structuredData.setExpandoBridgeAttributes(sc);

		structuredData.setDataCollectionId(dataCollectionId);
		structuredData.setDataSetId(dataSetId);
		structuredData.setDataTypeId(dataTypeId);
				
		structuredData.setMultiple(multiple);
		structuredData.setStartIndex(startIndex);
		structuredData.setCount(count);
		structuredData.setFreezed(freezed);
		structuredData.setVerified(verified);
		structuredData.setData(data);
		
		super.structuredDataPersistence.update(structuredData);
		
		super.resourceLocalService.addResources(
				structuredData.getCompanyId(), 
				structuredData.getGroupId(), 
				structuredData.getUserId(), 
				StructuredData.class.getName(), 
				structuredData.getPrimaryKey(), 
				false, 
				true, 
				true);
		
		super.assetEntryLocalService.updateEntry(
				structuredData.getUserId(), 
				structuredData.getGroupId(), 
				structuredData.getCreateDate(), 
				structuredData.getModifiedDate(),
				StructuredData.class.getName(), 
				structuredData.getPrimaryKey(), 
				structuredData.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				structuredData.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				structuredData.getUserName(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				structuredData.getCompanyId(), 
				structuredData.getGroupId(), 
				structuredData.getUserId(), 
				StructuredData.class.getName(), 
				structuredData.getPrimaryKey(), 
				structuredData, 
				sc);
		
		return structuredData;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public StructuredData updateStructuredData(
			long structuredDataId,
			long dataCollectionId, 
			long dataSetId, 
			long dataTypeId,
			boolean multiple,
			long startIndex,
			int count,
			boolean freezed,
			boolean verified,
			String data,
			int status,
			ServiceContext sc) throws PortalException {
		StructuredData structuredData = super.structuredDataPersistence.findByPrimaryKey(structuredDataId);
		
		structuredData.setDataCollectionId(dataCollectionId);
		structuredData.setDataSetId(dataSetId);
		structuredData.setDataTypeId(dataTypeId);
				
		structuredData.setMultiple(multiple);
		structuredData.setStartIndex(startIndex);
		structuredData.setCount(count);
		structuredData.setFreezed(freezed);
		structuredData.setVerified(verified);
		structuredData.setData(data);
		
		super.structuredDataPersistence.update(structuredData);
		
		structuredData.setUserId(sc.getUserId());
		structuredData.setGroupId(sc.getScopeGroupId());
		structuredData.setModifiedDate(new Date() );
	
		boolean statusChanged = false;
		if( status > WorkflowConstants.STATUS_ANY && status != structuredData.getStatus()) {
			User user = super.userLocalService.getUser(sc.getUserId());
			structuredData.setStatus(status);
			structuredData.setStatusByUserId(user.getUserId());
			structuredData.setStatusByUserName(user.getFullName());
			structuredData.setStatusDate(new Date());
			statusChanged = true;
		}
		
		structuredData.setExpandoBridgeAttributes(sc);
		
		super.structuredDataPersistence.update(structuredData, sc);
		
		super.resourceLocalService.updateResources(
				structuredData.getCompanyId(),
				structuredData.getGroupId(), 
				StructuredData.class.getName(), 
				structuredData.getPrimaryKey(),
				sc.getModelPermissions());
		
		super.assetEntryLocalService.updateEntry(
				structuredData.getUserId(), 
				structuredData.getGroupId(), 
				structuredData.getCreateDate(), 
				structuredData.getModifiedDate(),
				StructuredData.class.getName(), 
				structuredData.getPrimaryKey(), 
				structuredData.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				structuredData.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				structuredData.getUserName(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		if( statusChanged ) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				super.assetEntryLocalService.updateVisible(StructuredData.class.getName(), structuredDataId, true);
			} else {
				super.assetEntryLocalService.updateVisible(StructuredData.class.getName(), structuredDataId, false);
			}
		}
		
		return structuredData;
	}

	@Indexable(type = IndexableType.REINDEX)
	public StructuredData updateStatus(
			long userId, 
			long structuredDataId, 
			Integer status,
			ServiceContext sc) throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		StructuredData structuredData = super.structuredDataPersistence.findByPrimaryKey(structuredDataId);

		structuredData.setStatus(status);
		structuredData.setStatusByUserId(userId);
		structuredData.setStatusByUserName(user.getFullName());
		structuredData.setStatusDate(new Date());

		super.structuredDataPersistence.update(structuredData, sc);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			super.assetEntryLocalService.updateVisible(StructuredData.class.getName(), structuredDataId, true);
		} else {
			super.assetEntryLocalService.updateVisible(StructuredData.class.getName(), structuredDataId, false);
		}

		return structuredData;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public StructuredData removeStructuredData( long structuredDataId, long dataFileFolderId ) throws PortalException {
		StructuredData structuredData = super.structuredDataPersistence.remove(structuredDataId);
		
		if( dataFileFolderId > 0 ) {
			_dlAppService.deleteFolder(dataFileFolderId);
		}
		
		super.assetEntryLocalService.deleteEntry(StructuredData.class.getName(), structuredData.getPrimaryKey());

		super.resourceLocalService.deleteResource(
				structuredData.getCompanyId(), 
				StructuredData.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, 
				structuredData.getPrimaryKey());
		
		super.workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
				structuredData.getCompanyId(), structuredData.getGroupId(),
			    StructuredData.class.getName(), structuredData.getPrimaryKey());
		
		return structuredData;
	}
	
	/*
	public void removeStructuredDatas( long[] structuredDataIds ) throws PortalException {
		for( long structuredDataId : structuredDataIds ) {
			this.removeStructuredData(structuredDataId);
		}
	}
	*/
	
	public List<StructuredData> getAllStructuredDatas(){
		return super.structuredDataPersistence.findAll();
	}
	public List<StructuredData> getAllStructuredDatas( int start, int end ){
		return super.structuredDataPersistence.findAll(start, end);
	}
	public List<StructuredData> getAllStructuredDatas( int start, int end, OrderByComparator<StructuredData> comparator){
		return super.structuredDataPersistence.findAll(start, end, comparator);
	}
	public int countAllStructuredDatas() {
		return super.structuredDataPersistence.countAll();
	}
	public List<StructuredData> getStructuredDatasByDataTypeId( long dataTypeId ){
		return super.structuredDataPersistence.findByDataTypeId(dataTypeId);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId( long dataTypeId, int start, int end ){
		return super.structuredDataPersistence.findByDataTypeId(dataTypeId, start, end);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId( long dataTypeId, int start, int end,  OrderByComparator<StructuredData> comparator ){
		return super.structuredDataPersistence.findByDataTypeId(dataTypeId, start, end, comparator);
	}
	public int countStructuredDatasByDataTypeId( long groupId ) {
		return super.structuredDataPersistence.countByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}

	
	public List<StructuredData> getStructuredDatasByGroupId( long groupId ){
		return super.structuredDataPersistence.findByGroupId(groupId);
	}
	public List<StructuredData>  getStructuredDatasByGroupId( long groupId, int start, int end ){
		return super.structuredDataPersistence.findByGroupId(groupId, start, end);
	}
	public List<StructuredData>  getStructuredDatasByGroupId( long groupId, int start, int end, OrderByComparator<StructuredData> comparator ){
		return super.structuredDataPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int countStructuredDatasByGroupId(long groupId) {
		return super.structuredDataPersistence.countByGroupId(groupId);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_G( long dataTypeId, long groupId ){
		return super.structuredDataPersistence.findByDataTypeId_G(dataTypeId, groupId);
	}
	public List<StructuredData>  getStructuredDatasByDataTypeId_G(long dataTypeId,  long groupId, int start, int end ){
		return super.structuredDataPersistence.findByDataTypeId_G(dataTypeId, groupId, start, end);
	}
	public List<StructuredData>  getStructuredDatasByDataTypeId_G( long dataTypeId, long groupId, int start, int end, OrderByComparator<StructuredData> comparator ){
		return super.structuredDataPersistence.findByDataTypeId_G( dataTypeId, groupId, start, end, comparator);
	}
	public int countStructuredDatasByDataTypeId_G( long dataTypeId, long groupId) {
		return super.structuredDataPersistence.countByDataTypeId_G(dataTypeId, groupId);
	}

	public List<StructuredData> getStructuredDatasByUserId( long userId ){
		return super.structuredDataPersistence.findByUserId(userId);
	}
	public List<StructuredData>  getStructuredDatasByUserId( long userId, int start, int end ){
		return super.structuredDataPersistence.findByUserId(userId, start, end);
	}
	public List<StructuredData>  getStructuredDatasByUserId( long userId, int start, int end, OrderByComparator<StructuredData> comparator ){
		return super.structuredDataPersistence.findByUserId(userId, start, end, comparator);
	}
	public int countStructuredDatasByUserId(long userId) {
		return super.structuredDataPersistence.countByUserId(userId);
	}
	public int countStructuredDatasByDataTypeId_U(long dataTypeId, long userId) {
		return super.structuredDataPersistence.countByDataTypeId_U(dataTypeId, userId);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_U( long dataTypeId, long userId ){
		return super.structuredDataPersistence.findByDataTypeId_U(dataTypeId, userId);
	}
	public List<StructuredData>  getStructuredDatasByDataTypeId_U( long dataTypeId, long userId, int start, int end ){
		return super.structuredDataPersistence.findByDataTypeId_U(dataTypeId, userId, start, end);
	}
	public List<StructuredData>  getStructuredDatasByDataTypeId_U( long dataTypeId, long userId, int start, int end, OrderByComparator<StructuredData> comparator ){
		return super.structuredDataPersistence.findByDataTypeId_U(dataTypeId, userId, start, end, comparator);
	}

	public List<StructuredData> getStructuredDatasByStatus( int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findAll();
		else
			return super.structuredDataPersistence.findByStatus(status);
	}
	public List<StructuredData>  getStructuredDatasByStatus( int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findAll(start, end);
		else
			return super.structuredDataPersistence.findByStatus(status, start, end);
	}
	public List<StructuredData>  getStructuredDatasByStatus( int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findAll(start, end, comparator);
		else
			return super.structuredDataPersistence.findByStatus(status, start, end, comparator);
	}
	public int countStructuredDatasByStatus(int status) {
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countAll();
		else
			return super.structuredDataPersistence.countByStatus(status);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_S( long dataTypeId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId(dataTypeId);
		else
			return super.structuredDataPersistence.findByDataTypeId_S(dataTypeId, status);
	}
	public List<StructuredData>  getStructuredDatasByDataTypeId_S( long dataTypeId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId(dataTypeId, start, end);
		else
			return super.structuredDataPersistence.findByDataTypeId_S(dataTypeId, status, start, end);
	}
	public List<StructuredData>  getStructuredDatasByDataTypeId_S( long dataTypeId, int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId(dataTypeId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByDataTypeId_S(dataTypeId, status, start, end, comparator);
	}
	public int countStructuredDatasByDataTypeId_S( long dataTypeId, int status) {
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByDataTypeId(dataTypeId);
		else
			return super.structuredDataPersistence.countByDataTypeId_S(dataTypeId, status);
	}
	
	public List<StructuredData> getStructuredDatasByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId);
		else
			return super.structuredDataPersistence.findByG_S(groupId, status);
	}
	public List<StructuredData> getStructuredDatasByG_S( long groupId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId, start, end);
		else
			return super.structuredDataPersistence.findByG_S(groupId, status, start, end);
	}
	public List<StructuredData> getStructuredDatasByG_S( long groupId, int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByG_S(groupId, status, start, end, comparator);
	}
	public int countStructuredDatasByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByGroupId(groupId);
		else
			return super.structuredDataPersistence.countByG_S(groupId, status);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_G_S( long dataTypeId, long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_G(dataTypeId, groupId);
		else
			return super.structuredDataPersistence.findByDataTypeId_G_S(dataTypeId, groupId, status);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_G_S( long dataTypeId, long groupId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_G(dataTypeId, groupId, start, end);
		else
			return super.structuredDataPersistence.findByDataTypeId_G_S(dataTypeId, groupId, status, start, end);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_G_S( long dataTypeId, long groupId, int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_G(dataTypeId, groupId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByDataTypeId_G_S(dataTypeId, groupId, status, start, end, comparator);
	}
	public int countStructuredDatasByDataTypeId_G_S( long dataTypeId, long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByDataTypeId_G(dataTypeId, groupId);
		else
			return super.structuredDataPersistence.countByDataTypeId_G_S(dataTypeId, groupId, status);
	}
	
	public List<StructuredData> getStructuredDatasByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByUserId(userId);
		else
			return super.structuredDataPersistence.findByU_S(userId, status);
	}
	public List<StructuredData> getStructuredDatasByU_S( long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByUserId(userId, start, end);
		else
			return super.structuredDataPersistence.findByU_S(userId, status, start, end);
	}
	public List<StructuredData> getStructuredDatasByU_S( long userId, int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByUserId(userId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByU_S(userId, status, start, end, comparator);
	}
	public int countStructuredDatasByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByUserId(userId);
		else
			return super.structuredDataPersistence.countByU_S(userId, status);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_U_S( long dataTypeId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_U(dataTypeId, userId);
		else
			return super.structuredDataPersistence.findByDataTypeId_U_S(dataTypeId, userId, status);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_U_S( long dataTypeId, long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_U(dataTypeId, userId, start, end);
		else
			return super.structuredDataPersistence.findByDataTypeId_U_S(dataTypeId, userId, status, start, end);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_U_S( long dataTypeId, long userId, int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_U(dataTypeId, userId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByDataTypeId_U_S(dataTypeId, userId, status, start, end, comparator);
	}
	public int countStructuredDatasByDataTypeId_U_S( long dataTypeId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByDataTypeId_U(dataTypeId, userId);
		else
			return super.structuredDataPersistence.countByDataTypeId_U_S(dataTypeId, userId, status);
	}
	
	public List<StructuredData> getStructuredDatasByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByG_U(groupId, userId);
		else
			return super.structuredDataPersistence.findByG_U_S(groupId, userId, status);
	}
	public List<StructuredData> getStructuredDatasByG_U_S( long groupId, long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByG_U(groupId, userId, start, end);
		else
			return super.structuredDataPersistence.findByG_U_S(groupId, userId, status, start, end);
	}
	public List<StructuredData> getStructuredDatasByG_U_S( long groupId, long userId, int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByG_U(groupId, userId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByG_U_S(groupId, userId, status, start, end, comparator);
	}
	public int countStructuredDatasByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByG_U(groupId, userId);
		else
			return super.structuredDataPersistence.countByG_U_S(groupId, userId, status);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_G_U_S( long dataTypeId, long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_G_U(dataTypeId, groupId, userId);
		else
			return super.structuredDataPersistence.findByDataTypeId_G_U_S(dataTypeId, groupId, userId, status);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_G_U_S( long dataTypeId, long groupId, long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_G_U(dataTypeId, groupId, userId, start, end);
		else
			return super.structuredDataPersistence.findByDataTypeId_G_U_S(dataTypeId, groupId, userId, status, start, end);
	}
	public List<StructuredData> getStructuredDatasByDataTypeId_G_U_S( long dataTypeId, long groupId, long userId, int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_G_U(dataTypeId, groupId, userId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByDataTypeId_G_U_S(dataTypeId, groupId, userId, status, start, end, comparator);
	}
	public int countStructuredDatasByG_U_SDataTypeId_( long dataTypeId, long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByDataTypeId_G_U(dataTypeId, groupId, userId);
		else
			return super.structuredDataPersistence.countByDataTypeId_G_U_S(dataTypeId, groupId, userId, status);
	}
	
	public List<StructuredData> getApprovedStructuredDatas( long groupId ){
		return super.structuredDataPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	public List<StructuredData> getApprovedStructuredDatas( long groupId, int start, int end ){
		return super.structuredDataPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
	}
	public List<StructuredData> getApprovedStructuredDatas( long groupId, int start, int end, OrderByComparator<StructuredData> comparator ){
		return super.structuredDataPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end, comparator);
	}
	public int countApprovedStructuredDatas( long groupId ) {
		return super.structuredDataPersistence.countByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	
	public JSONObject getStructuredDataListWithInfo(long dataCollectionId, long dataSetId, long dataTypeId, Locale locale){
		List<StructuredData> dataList = null;
		
		if( dataCollectionId > 0 && dataSetId > 0 && dataTypeId > 0) {
			dataList = structuredDataPersistence.findByCollectionSetType(dataCollectionId, dataSetId, dataTypeId);
		} else if( dataCollectionId > 0 && dataSetId > 0) {
			dataList = structuredDataPersistence.findByCollectionSet(dataCollectionId, dataSetId);
		} else if( dataCollectionId > 0 ) {
			dataList = structuredDataPersistence.findByDataCollectionId(dataCollectionId);
		} else if( dataSetId > 0 && dataTypeId > 0 ) {
			dataList = structuredDataPersistence.findBySetType(dataSetId, dataTypeId);
		} else if( dataSetId > 0  ) {
			dataList = structuredDataPersistence.findByDataSetId(dataSetId);
		}  else if( dataTypeId > 0  ) {
			dataList = structuredDataPersistence.findByDataTypeId(dataTypeId);
		} else {
			dataList = structuredDataPersistence.findAll();
		}
		
		
		return createStructuredDataInfo(dataList, dataCollectionId, dataSetId, dataTypeId, locale);
	}
	public int countStructuredData(long dataCollectionId, long dataSetId, long dataTypeId){
		int count = 0;;
		
		if( dataCollectionId > 0 && dataSetId > 0 && dataTypeId > 0) {
			count = structuredDataPersistence.countByCollectionSetType(dataCollectionId, dataSetId, dataTypeId);
		} else if( dataCollectionId > 0 && dataSetId > 0) {
			count = structuredDataPersistence.countByCollectionSet(dataCollectionId, dataSetId);
		} else if( dataCollectionId > 0 ) {
			count = structuredDataPersistence.countByDataCollectionId(dataCollectionId);
		} else if( dataSetId > 0 && dataTypeId > 0 ) {
			count = structuredDataPersistence.countBySetType(dataSetId, dataTypeId);
		} else if( dataSetId > 0  ) {
			count = structuredDataPersistence.countByDataSetId(dataSetId);
		}  else if( dataTypeId > 0  ) {
			count = structuredDataPersistence.countByDataTypeId(dataTypeId);
		}   else {
			count = structuredDataPersistence.countAll();
		}
		
		return count;
	}
	public JSONObject getStructuredDataList(long dataCollectionId, long dataSetId, long dataTypeId, int start, int end, Locale locale){
		List<StructuredData> dataList = null;
		
		if( dataCollectionId > 0 && dataSetId > 0 && dataTypeId > 0) {
			dataList = structuredDataPersistence.findByCollectionSetType(dataCollectionId, dataSetId, dataTypeId, start, end);
		} else if( dataCollectionId > 0 && dataSetId > 0) {
			dataList = structuredDataPersistence.findByCollectionSet(dataCollectionId, dataSetId, start, end);
		} else if( dataCollectionId > 0 ) {
			dataList = structuredDataPersistence.findByDataCollectionId(dataCollectionId, start, end);
		} else if( dataSetId > 0 && dataTypeId > 0 ) {
			dataList = structuredDataPersistence.findBySetType(dataSetId, dataTypeId, start, end);
		} else if( dataSetId > 0  ) {
			dataList = structuredDataPersistence.findByDataSetId(dataSetId, start, end);
		}  else if( dataTypeId > 0  ) {
			dataList = structuredDataPersistence.findByDataTypeId(dataTypeId, start, end);
		}  else {
			dataList = structuredDataPersistence.findAll(start, end);
		}
		
		return createStructuredDataInfo(dataList, dataCollectionId, dataSetId, dataTypeId, locale);
	}
	
	public JSONObject createStructuredDataInfo( List<StructuredData> dataList, long dataCollectionId, long dataSetId, long dataTypeId, Locale locale) {
		JSONObject jsonList = JSONFactoryUtil.createJSONObject();
		
		if( Validator.isNotNull(dataList)) {
			JSONArray dataArray = JSONFactoryUtil.createJSONArray();
			
			Iterator<StructuredData> iter = dataList.iterator();
			while(iter.hasNext()) {
				StructuredData structuredData = iter.next();
				
				dataArray.put(structuredData.toJSON());
			}
			
			jsonList.put("structuredDataList", dataArray);
		}
		
		DataCollection dataCollection = null;
		if( dataCollectionId > 0 ) {
			dataCollection = dataCollectionPersistence.fetchByPrimaryKey(dataCollectionId);
		}
		if(Validator.isNotNull(dataCollection)) {
			jsonList.put("dataCollection", dataCollection.toJSON(locale));
		}
		
		DataSet dataSet = null;
		if( dataSetId > 0 ) {
			dataSet = dataSetPersistence.fetchByPrimaryKey(dataSetId);
		}
		if(Validator.isNotNull(dataSet)) {
			jsonList.put("dataSet", dataSet.toJSON(locale));
		}
		
		DataType dataType = null;
		if( dataTypeId > 0 ) {
			dataType = dataTypePersistence.fetchByPrimaryKey(dataTypeId);
		}
		if(Validator.isNotNull(dataType)) {
			jsonList.put("dataType", dataType.toJSON(locale));
		}
		
		return jsonList;
	}
	
	public JSONObject getStructuredDataWithInfo(
			long structuredDataId,
			long dataCollectionId,
			long dataSetId,
			long dataTypeId,
			long dataStructureId,
			Locale locale) {
		
		JSONObject dataInfo = JSONFactoryUtil.createJSONObject();
		
		DataCollection dataCollection = dataCollectionPersistence.fetchByPrimaryKey(dataCollectionId);
		DataSet dataSet = dataSetPersistence.fetchByPrimaryKey(dataSetId);
		DataType dataType = dataTypePersistence.fetchByPrimaryKey(dataTypeId);
		DataStructure dataStructure = dataStructurePersistence.fetchByPrimaryKey(dataStructureId);
		StructuredData structuredData = structuredDataPersistence.fetchByPrimaryKey(structuredDataId);
		
		if(Validator.isNotNull(dataCollection)) {
			JSONObject jsonCollectionInfo = JSONFactoryUtil.createJSONObject();
			jsonCollectionInfo.put("dataCollectionId", dataCollection.getDataCollectionId());
			jsonCollectionInfo.put("dataCollectionCode", dataCollection.getDataCollectionCode());
			jsonCollectionInfo.put("dataCollectionVersion", dataCollection.getDataCollectionVersion());
			jsonCollectionInfo.put("displayName", dataCollection.getDisplayName(locale));
			
			dataInfo.put("dataCollection", jsonCollectionInfo);
		}
		
		if(Validator.isNotNull(dataSet)) {
			JSONObject jsonSetInfo = JSONFactoryUtil.createJSONObject();
			jsonSetInfo.put("dataSetId", dataSet.getDataSetId());
			jsonSetInfo.put("dataSetCode", dataSet.getDataSetCode());
			jsonSetInfo.put("dataSetVersion", dataSet.getDataSetVersion());
			jsonSetInfo.put("displayName", dataSet.getDisplayName(locale));
			
			dataInfo.put("dataSet", jsonSetInfo);
		}
		
		if(Validator.isNotNull(dataType)) {
			JSONObject jsonDataTypeInfo = JSONFactoryUtil.createJSONObject();
			jsonDataTypeInfo.put("dataDataTypeId", dataType.getDataTypeId());
			jsonDataTypeInfo.put("dataTypeCode", dataType.getDataTypeCode());
			jsonDataTypeInfo.put("dataTypeVersion", dataType.getDataTypeVersion());
			jsonDataTypeInfo.put("displayName", dataType.getDisplayName(locale));
			
			dataInfo.put("dataType", jsonDataTypeInfo);
			
			TypeStructureLink typeStructureLink = typeStructureLinkPersistence.fetchByPrimaryKey(dataTypeId);
			if( Validator.isNotNull(typeStructureLink)) {
				dataInfo.put("typeStructureLonk", typeStructureLink.toJSON());
				if( Validator.isNull(dataStructure)) {
					dataStructure = dataStructurePersistence.fetchByPrimaryKey(typeStructureLink.getDataStructureId());
				}
			}
		}
		
		JSONObject jsonDataStructure = null;
		
		JSONObject jsonStructure = null;
		if( Validator.isNotNull(structuredData)) {
			if(Validator.isNotNull(dataStructure)) {
				jsonDataStructure = dataStructure.toJSON();
				jsonStructure = jsonDataStructure.getJSONObject(DataStructureProperties.STRUCTURE);
				jsonStructure.put("data", structuredData.toJSON());
			}
		}
		
		if(Validator.isNotNull(jsonDataStructure)) {
			dataInfo.put("dataStructure", jsonDataStructure);
		}
		
		return dataInfo;
	}
	
	public SearchContainerResults<AssetEntry> getSearchContainerResults(
			SearchContainer<StructuredData> searchContainer)
		throws PortalException {

		AssetEntryQuery assetEntryQuery = new AssetEntryQuery(
			StructuredData.class.getName(), searchContainer);

		assetEntryQuery.setExcludeZeroViewCount(false);
		assetEntryQuery.setOrderByCol1(searchContainer.getOrderByCol());
		assetEntryQuery.setOrderByType1(searchContainer.getOrderByType());
		
		System.out.println("StructuredDataLocalService.getSearchContainerResults Type: "+searchContainer.getOrderByType());
		assetEntryQuery.setVisible(Boolean.TRUE);

		int total = AssetEntryServiceUtil.getEntriesCount(assetEntryQuery);

		assetEntryQuery.setEnd(searchContainer.getEnd());
		assetEntryQuery.setStart(searchContainer.getStart());

		List<AssetEntry> assetEntries = AssetEntryServiceUtil.getEntries(
			assetEntryQuery);

		return new SearchContainerResults<AssetEntry>(assetEntries, total);
		
	}
	
	public JSONObject convertModelToJSONObject(StructuredData structuredData) throws JSONException {
		JSONObject jsonData = JSONFactoryUtil.createJSONObject(structuredData.getData()); 
		String serializedData = JSONFactoryUtil.looseSerialize(structuredData);
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject( serializedData);

		jsonObject.put("data", jsonData);
		
		return jsonObject;
	}
	
	public JSONArray convertListToJSONArray(List<StructuredData> list) throws JSONException {
		JSONArray array = JSONFactoryUtil.createJSONArray();
		
		Iterator<StructuredData> iter = list.iterator();
		while( iter.hasNext()) {
			array.put(convertModelToJSONObject(iter.next()));
		}
		
		return array;
	}

}