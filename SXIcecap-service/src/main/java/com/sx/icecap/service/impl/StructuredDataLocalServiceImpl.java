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
import com.sx.icecap.service.DataTypeLocalService;
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
		structuredData.setData(data);
		
		System.out.println("StructuredData: " + data);
		
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
	
	public List<StructuredData> getStructuredDataByCollection(long groupId,  long dataCollectionId,  int status){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataCollectionId_G(groupId, dataCollectionId);
		else
			return structuredDataPersistence.findByDataCollectionId_G_S(groupId, dataCollectionId, status);
	}
	public List<StructuredData> getStructuredDataByCollection(long groupId,  long dataCollectionId, int start, int end, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataCollectionId_G(groupId, dataCollectionId, start, end);
		else
			return structuredDataPersistence.findByDataCollectionId_G_S(groupId, dataCollectionId, start, end, status);
	}
	public List<StructuredData> getStructuredDataByCollection(long groupId,  long dataCollectionId,  int start, int end, int status, OrderByComparator<StructuredData> comparator){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataCollectionId_G(groupId, dataCollectionId, start, end, comparator);
		else
			return structuredDataPersistence.findByDataCollectionId_G_S(groupId, dataCollectionId, start, end,status,  comparator);
	}
	public int countStructuredDataByCollection(long groupId,  long dataCollectionId,int status){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByDataCollectionId_G(groupId, dataCollectionId);
		else
			return structuredDataPersistence.countByDataCollectionId_G_S(groupId, dataCollectionId, status);
	}
	
	public List<StructuredData> getStructuredDataByCollectionSet(long groupId,  long dataCollectionId,  long dataSetId, int status){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByCollectionSet_G(groupId, dataCollectionId, dataSetId);
		else
			return structuredDataPersistence.findByCollectionSet_G_S(groupId, dataCollectionId, dataSetId, status);
	}
	public List<StructuredData> getStructuredDataByCollectionSet(long groupId,  long dataCollectionId,  long dataSetId, int start, int end, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByCollectionSet_G(groupId, dataCollectionId, dataSetId, start, end);
		else
			return structuredDataPersistence.findByCollectionSet_G_S(groupId, dataCollectionId, dataSetId, start, end, status);
	}
	public List<StructuredData> getStructuredDataByCollectionSet(long groupId,  long dataCollectionId,  long dataSetId,  int start, int end, int status, OrderByComparator<StructuredData> comparator){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByCollectionSet_G(groupId, dataCollectionId, dataSetId, start, end, comparator);
		else
			return structuredDataPersistence.findByCollectionSet_G_S(groupId, dataCollectionId, dataSetId, start, end, status, comparator);
	}
	public int countStructuredDataByCollectionSet(long groupId,  long dataCollectionId,  long dataSetId,int status){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByCollectionSet_G(groupId, dataCollectionId, dataSetId);
		else
			return structuredDataPersistence.countByCollectionSet_G_S(groupId, dataCollectionId, dataSetId, status);
	}
	

	public List<StructuredData> getStructuredDatasByGroupId( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId);
		else
			return super.structuredDataPersistence.findByGroupId_S(groupId, status);
	}
	public List<StructuredData>  getStructuredDatasByGroupId( long groupId, int start, int end, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId, start, end);
		else
		return super.structuredDataPersistence.findByGroupId_S(groupId, start, end, status);
	}
	public List<StructuredData>  getStructuredDatasByGroupId( long groupId, int start, int end, int status, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByGroupId_S(groupId, start, end, status, comparator);
	}
	public int countStructuredDatasByGroupId(long groupId, int status) {
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByGroupId(groupId);
		else
		return super.structuredDataPersistence.countByGroupId_S(groupId, status);
	}
	
	
	public List<StructuredData> getStructuredDatasByCollectionId( long groupId,  long dataTypeId ){
		return super.structuredDataPersistence.findByDataCollectionId_G(dataTypeId, groupId);
	}
	public List<StructuredData>  getStructuredDatasByCollectionId(long dataTypeId,  long groupId, int start, int end ){
		return super.structuredDataPersistence.findByDataTypeId_G(dataTypeId, groupId, start, end);
	}
	public List<StructuredData>  getStructuredDatasByCollectionId( long dataTypeId, long groupId, int start, int end, OrderByComparator<StructuredData> comparator ){
		return super.structuredDataPersistence.findByDataTypeId_G( dataTypeId, groupId, start, end, comparator);
	}
	public int countStructuredDatasByDataCollectionId( long dataTypeId, long groupId) {
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
	public List<StructuredData> getStructuredDatasByDataTypeId( long groupId, long dataTypeId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_G(groupId, dataTypeId);
		else
			return super.structuredDataPersistence.findByDataTypeId_G_S(groupId, dataTypeId, status);
	}
	public List<StructuredData>  getStructuredDatasByDataTypeId( long groupId, long dataTypeId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_G(groupId, dataTypeId, start, end);
		else
			return super.structuredDataPersistence.findByDataTypeId_G_S(groupId, dataTypeId, start, end, status);
	}
	public List<StructuredData>  getStructuredDatasByDataTypeId( long groupId, long dataTypeId, int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataTypeId_G(groupId, dataTypeId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByDataTypeId_G_S(groupId, dataTypeId, start, end, status, comparator);
	}
	public int countStructuredDatasByDataTypeId( long groupId, long dataTypeId, int status) {
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByDataTypeId_G(groupId, dataTypeId);
		else
			return super.structuredDataPersistence.countByDataTypeId_G_S(groupId, dataTypeId, status);
	}
	
	public List<StructuredData> getStructuredDatas( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId);
		else
			return super.structuredDataPersistence.findByGroupId_S(groupId, status);
	}
	public List<StructuredData> getStructuredDatas( long groupId, int start, int end, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId, start, end);
		else
			return super.structuredDataPersistence.findByGroupId_S(groupId, start, end, status);
	}
	public List<StructuredData> getStructuredDatas( long groupId, int start, int end, int status, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByGroupId_S(groupId, start, end, status, comparator);
	}
	public int countStructuredDatas( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByGroupId(groupId);
		else
			return super.structuredDataPersistence.countByGroupId_S(groupId, status);
	}
	
	public List<StructuredData> getStructuredDatasByUserId( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByUserId(userId);
		else
			return super.structuredDataPersistence.findByUserId_S(userId, status);
	}
	public List<StructuredData> getStructuredDatasByUserId( long userId, int start, int end, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByUserId(userId, start, end);
		else
			return super.structuredDataPersistence.findByUserId_S(userId, start, end, status);
	}
	public List<StructuredData> getStructuredDatasByUserId( long userId, int start, int end, int status, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByUserId(userId, start, end);
		else
			return super.structuredDataPersistence.findByUserId_S(userId, start, end, status, comparator);
	}
	public int countStructuredDatasByUserId( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByUserId(userId);
		else
			return super.structuredDataPersistence.countByUserId_S(userId, status);
	}
	
	public List<StructuredData> getStructuredDatasByG_U( long groupId, long userId, int status ){
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
	
	public List<StructuredData> getStructuredDatasByDataCollectionId( long groupId, long dataCollectionId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataCollectionId_G(groupId, dataCollectionId);
		else
			return super.structuredDataPersistence.findByDataCollectionId_G_S(groupId, dataCollectionId, status);
	}
	public List<StructuredData> getStructuredDatasByDataCollectionId( long groupId, long dataCollectionId, int start, int end, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataCollectionId_G(groupId, dataCollectionId, start, end);
		else
			return super.structuredDataPersistence.findByDataCollectionId_G_S(groupId, dataCollectionId, start, end, status);
	}
	public List<StructuredData> getStructuredDatasByDataCollectionId( long groupId, long dataCollectionId, int start, int end, int status, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataCollectionId_G(groupId, dataCollectionId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByDataCollectionId_G_S(groupId, dataCollectionId, start, end, status, comparator);
	}
	public int countStructuredDatasByDataCollectionId( long groupId, long dataCollectionId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByDataCollectionId_G(groupId, dataCollectionId);
		else
			return super.structuredDataPersistence.countByDataCollectionId_G_S(groupId, dataCollectionId, status);
	}
	
	public List<StructuredData> getStructuredDatasByCollectionSet( long groupId, long dataCollectionId, long dataSetId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByCollectionSet_G(groupId, dataCollectionId, dataSetId);
		else
			return super.structuredDataPersistence.findByCollectionSet_G_S(groupId, dataCollectionId, dataSetId, status);
	}
	public List<StructuredData> getStructuredDatasByCollectionSet( long groupId, long dataCollectionId, long dataSetId, int start, int end, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByCollectionSet_G(groupId, dataCollectionId, dataSetId, start, end);
		else
			return super.structuredDataPersistence.findByCollectionSet_G_S(groupId, dataCollectionId, dataSetId, start, end, status);
	}
	public List<StructuredData> getStructuredDatasByCollectionSet( long groupId, long dataCollectionId, long dataSetId, int start, int end, int status, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByCollectionSet_G(groupId, dataCollectionId, dataSetId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByCollectionSet_G_S(groupId, dataCollectionId, dataSetId, start, end, status, comparator);
	}
	public int countStructuredDatasByCollectionSet( long groupId, long dataCollectionId, long dataSetId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByCollectionSet_G(groupId, dataCollectionId, dataSetId);
		else
			return super.structuredDataPersistence.countByCollectionSet_G_S(groupId, dataCollectionId, dataSetId, status);
	}
	
	public List<StructuredData> getStructuredDatasBySetType( long groupId, long dataSetId, long dataTypeId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findBySetType_G(groupId, dataSetId, dataTypeId);
		else
			return super.structuredDataPersistence.findBySetType_G_S(groupId, dataSetId, dataTypeId, status);
	}
	public List<StructuredData> getStructuredDatasBySetType( long groupId, long dataSetId, long dataTypeId, int start, int end, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findBySetType_G(groupId, dataSetId, dataTypeId, start, end);
		else
			return super.structuredDataPersistence.findBySetType_G_S(groupId, dataSetId, dataTypeId, start, end, status);
	}
	public List<StructuredData> getStructuredDatasBySetType( long groupId, long dataSetId, long dataTypeId, int start, int end, int status, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findBySetType_G(groupId, dataSetId, dataTypeId, start, end, comparator);
		else
			return super.structuredDataPersistence.findBySetType_G_S(groupId, dataSetId, dataTypeId, start, end, status, comparator);
	}
	public int countStructuredDatasBySetType( long groupId, long dataSetId, long dataTypeId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countBySetType_G(groupId, dataSetId, dataTypeId);
		else
			return super.structuredDataPersistence.countBySetType_G_S(groupId, dataSetId, dataTypeId, status);
	}
	
	public List<StructuredData> getStructuredDatasByDataSetId( long groupId, long dataSetId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataSetId_G(groupId, dataSetId);
		else
			return super.structuredDataPersistence.findByDataSetId_G_S(groupId, dataSetId, status);
	}
	public List<StructuredData> getStructuredDatasByDataSetId( long groupId, long dataSetId, int start, int end, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataSetId_G(groupId, dataSetId, start, end);
		else
			return super.structuredDataPersistence.findByDataSetId_G_S(groupId, dataSetId, start, end, status);
	}
	public List<StructuredData> getStructuredDatasByDataSetId( long groupId, long dataSetId, int start, int end, int status, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByDataSetId_G(groupId, dataSetId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByDataSetId_G_S(groupId, dataSetId, start, end, status, comparator);
	}
	public int countStructuredDatasByDataSetId( long groupId, long dataSetId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByDataSetId_G(groupId, dataSetId);
		else
			return super.structuredDataPersistence.countByDataSetId_G_S(groupId, dataSetId, status);
	}
	
	public List<StructuredData> getStructuredDatasByCollectionSetType( long groupId, long dataCollectionId, long dataSetId, long dataTypeId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByCollectionSetType_G(groupId, dataCollectionId, dataSetId, dataTypeId);
		else
			return super.structuredDataPersistence.findByCollectionSetType_G_S(groupId, dataCollectionId, dataSetId, dataTypeId, status);
	}
	public List<StructuredData> getStructuredDatasByCollectionSetType( long groupId, long dataCollectionId, long dataSetId, long dataTypeId, int start, int end, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByCollectionSetType_G(groupId, dataCollectionId, dataSetId, dataTypeId, start, end);
		else
			return super.structuredDataPersistence.findByCollectionSetType_G_S(groupId, dataCollectionId, dataSetId, dataTypeId, start, end, status);
	}
	public List<StructuredData> getStructuredDatasByCollectionSetType( long groupId, long dataCollectionId, long dataSetId, long dataTypeId, int start, int end, int status, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByCollectionSetType_G(groupId, dataCollectionId, dataSetId, dataTypeId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByCollectionSetType_G_S(groupId, dataCollectionId, dataSetId, dataTypeId, start, end, status, comparator);
	}
	public int countStructuredDatasByCollectionSetType( long groupId, long dataCollectionId, long dataSetId, long dataTypeId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByCollectionSetType_G(groupId, dataCollectionId, dataSetId, dataTypeId);
		else
			return super.structuredDataPersistence.countByCollectionSetType_G_S(groupId, dataCollectionId, dataSetId, dataTypeId, status);
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
		
		JSONArray jsonDataArray = _setDataAbstraction(dataList, locale);
		
		return createStructuredDataInfo(jsonDataArray, dataCollectionId, dataSetId, dataTypeId, locale);
	}
	
	private JSONArray _setDataAbstraction(List<StructuredData> dataList, Locale locale){
		JSONArray dataArray = JSONFactoryUtil.createJSONArray();
		
		Iterator<StructuredData> iter = dataList.iterator();
		while( iter.hasNext() ) {
			StructuredData data = iter.next();
			DataType dataType = dataTypePersistence.fetchByPrimaryKey(data.getDataTypeId());
			
			JSONObject jsonData = data.toJSON();
			jsonData.put("dataTypeCode", dataType.getDataTypeCode());
			jsonData.put("dataTypeVersion", dataType.getDataTypeVersion());
			jsonData.put("dataTypeLabel", dataType.getDisplayName(locale));

			DataSet dataSet = dataSetPersistence.fetchByPrimaryKey(data.getDataSetId());
			
			jsonData.put("dataSetCode", dataSet.getDataSetCode());
			jsonData.put("dataSetVersion", dataSet.getDataSetVersion());
			jsonData.put("dataSetLabel", dataSet.getDisplayName(locale));
			
			dataArray.put(jsonData);
		}
		
		return dataArray;
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
	
	/*
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
	*/
	
	public JSONObject createStructuredDataInfo( JSONArray dataArray, long dataCollectionId, long dataSetId, long dataTypeId, Locale locale) {
		JSONObject jsonList = JSONFactoryUtil.createJSONObject();
		
			jsonList.put("structuredDataList", dataArray);
		
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
			Locale locale) throws JSONException {
		
		JSONObject dataInfo = JSONFactoryUtil.createJSONObject();
		DataStructure dataStructure = null;

		if( structuredDataId > 0 ) {
			StructuredData structuredData = structuredDataPersistence.fetchByPrimaryKey(structuredDataId);
			
			if( Validator.isNotNull(structuredData)) {
				dataInfo.put("data", JSONFactoryUtil.createJSONObject(structuredData.getData()));

				DataCollection dataCollection = dataCollectionPersistence.fetchByPrimaryKey(structuredData.getDataCollectionId());
				DataSet dataSet = dataSetPersistence.fetchByPrimaryKey(structuredData.getDataSetId());
				DataType dataType = dataTypePersistence.fetchByPrimaryKey(structuredData.getDataTypeId());
				
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
					
					TypeStructureLink typeStructureLink = typeStructureLinkPersistence.fetchByPrimaryKey(dataType.getPrimaryKey());
					if( Validator.isNotNull(typeStructureLink)) {
						dataInfo.put("typeStructureLink", typeStructureLink.toJSON());

						dataStructure = dataStructurePersistence.fetchByPrimaryKey(typeStructureLink.getDataStructureId());
						
						if( Validator.isNull(dataStructure)) {
							dataStructure = dataStructurePersistence.fetchByPrimaryKey(typeStructureLink.getDataStructureId());
							
							if(Validator.isNotNull(dataStructure)) {
								JSONObject jsonStructure =  JSONFactoryUtil.createJSONObject(dataStructure.getStructure());
								
								dataInfo.put("dataStructure", jsonStructure);
							}
						}
					}
				}
			}
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