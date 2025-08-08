/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sx.icecap.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.sx.icecap.exception.DuplicatedDataCollectionNameException;
import com.sx.icecap.exception.DuplicatedDataTypeNameException;
import com.sx.icecap.model.DataCollection;
import com.sx.icecap.service.base.DataCollectionLocalServiceBaseImpl;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.DataCollection",
	service = AopService.class
)
public class DataCollectionLocalServiceImpl
	extends DataCollectionLocalServiceBaseImpl {
	
	@Indexable(type = IndexableType.REINDEX)
	public DataCollection addDataCollection(
			String dataCollectionName,
			String dataCollectionVersion,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap,
			int status,
			ServiceContext sc) throws PortalException {
		
		try {
			if( !_verifyDataCollectionName(dataCollectionName) ) {
				throw new PortalException(dataCollectionName+" "+dataCollectionVersion+" Invalid"); 
			}
		} catch( DuplicatedDataCollectionNameException e ) {
			throw e;
		}
		
		Locale defaultLocale = sc.getThemeDisplay().getLocale();
		
		long dataCollectionId = super.counterLocalService.increment();
		DataCollection dataCollection = super.dataCollectionLocalService.createDataCollection(dataCollectionId);
		
		dataCollection.setDataCollectionName(dataCollectionName);
		dataCollection.setDataCollectionVersion(dataCollectionVersion);
		dataCollection.setDisplayNameMap(displayNameMap, defaultLocale);
		dataCollection.setDescriptionMap(descriptionMap, defaultLocale);
		
		Date now = new Date();
		User user = super.userLocalService.getUser(sc.getUserId());
		dataCollection.setCompanyId(sc.getCompanyId());
		dataCollection.setGroupId(sc.getScopeGroupId());
		dataCollection.setUserId(user.getUserId());
		dataCollection.setUserName(user.getFullName());
		dataCollection.setCreateDate(now);
		dataCollection.setModifiedDate(now);
		
		if( status > WorkflowConstants.STATUS_ANY ) {
			dataCollection.setStatus(status);
		}
		else {
			dataCollection.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		dataCollection.setStatusByUserId(sc.getUserId());
		dataCollection.setStatusByUserName(user.getFullName());
		dataCollection.setStatusDate(sc.getModifiedDate(null));
		
		
		dataCollection.setExpandoBridgeAttributes(sc);
		
		dataCollection = super.dataCollectionPersistence.update(dataCollection, sc);

		super.resourceLocalService.addResources(
				dataCollection.getCompanyId(), 
				dataCollection.getGroupId(), 
				dataCollection.getUserId(), 
				DataCollection.class.getName(), 
				dataCollection.getPrimaryKey(), 
				false, 
				true, 
				true);
//			System.out.println("Resource Finished....");
		
		super.assetEntryLocalService.updateEntry(
			dataCollection.getUserId(), 
			dataCollection.getGroupId(), 
			dataCollection.getCreateDate(), 
			dataCollection.getModifiedDate(),
			DataCollection.class.getName(), 
			dataCollection.getPrimaryKey(), 
			dataCollection.getUuid(), 
			0,
			sc.getAssetCategoryIds(), 
			sc.getAssetTagNames(), 
			true,
			true, 
			null, 
			null, 
			dataCollection.getCreateDate(),
			null, 
			ContentTypes.TEXT_HTML_UTF8, 
			dataCollection.getDataCollectionName(),
			null, 
			null, 
			null, 
			null,
			0, 0, null);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				dataCollection.getCompanyId(), 
				dataCollection.getGroupId(), 
				dataCollection.getUserId(), 
				DataCollection.class.getName(), 
				dataCollection.getPrimaryKey(), 
				dataCollection, 
				sc);
		
		return dataCollection;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataCollection updateDataCollection(
			long dataCollectionId, 
			String dataCollectionName, 
			String dataCollectionVersion,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap,
			int status,
			ServiceContext sc) throws PortalException {
		DataCollection dataCollection = super.dataCollectionPersistence.findByPrimaryKey(dataCollectionId);
		
		dataCollection.setDataCollectionName(dataCollectionName);
		dataCollection.setDataCollectionVersion(dataCollectionVersion);
		dataCollection.setDisplayNameMap(displayNameMap, sc.getLocale());
		dataCollection.setDescriptionMap(descriptionMap, sc.getLocale());
		
		dataCollection.setUserId(sc.getUserId());
		dataCollection.setGroupId(sc.getScopeGroupId());
		dataCollection.setModifiedDate(new Date() );

		boolean statusChanged = false;
		if( status > WorkflowConstants.STATUS_ANY && status != dataCollection.getStatus()) {
			User user = super.userLocalService.getUser(sc.getUserId());
			dataCollection.setStatus(status);
			dataCollection.setStatusByUserId(user.getUserId());
			dataCollection.setStatusByUserName(user.getFullName());
			dataCollection.setStatusDate(new Date());
			statusChanged = true;
		}
		
		dataCollection.setExpandoBridgeAttributes(sc);
		
		super.dataCollectionPersistence.update(dataCollection, sc);
		
		super.resourceLocalService.updateResources(
				dataCollection.getCompanyId(),
				dataCollection.getGroupId(), 
				DataCollection.class.getName(), 
				dataCollection.getPrimaryKey(),
				sc.getModelPermissions());
		
		super.assetEntryLocalService.updateEntry(
				dataCollection.getUserId(), 
				dataCollection.getGroupId(), 
				dataCollection.getCreateDate(), 
				dataCollection.getModifiedDate(),
				DataCollection.class.getName(), 
				dataCollection.getPrimaryKey(), 
				dataCollection.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				dataCollection.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				dataCollection.getDataCollectionName(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		if( statusChanged ) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				super.assetEntryLocalService.updateVisible(DataCollection.class.getName(), dataCollectionId, true);
			} else {
				super.assetEntryLocalService.updateVisible(DataCollection.class.getName(), dataCollectionId, false);
			}
		}
		
		return dataCollection;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataCollection updateStatus(
			long userId, 
			long dataCollectionId, 
			Integer status,
			ServiceContext sc) throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		DataCollection dataCollection = super.dataCollectionPersistence.findByPrimaryKey(dataCollectionId);

		dataCollection.setStatus(status);
		dataCollection.setStatusByUserId(userId);
		dataCollection.setStatusByUserName(user.getFullName());
		dataCollection.setStatusDate(new Date());

		super.dataCollectionPersistence.update(dataCollection, sc);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			super.assetEntryLocalService.updateVisible(DataCollection.class.getName(), dataCollectionId, true);
		} else {
			super.assetEntryLocalService.updateVisible(DataCollection.class.getName(), dataCollectionId, false);
		}

		return dataCollection;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public DataCollection removeDataCollection( long dataCollectionId ) throws PortalException {
		DataCollection dataCollection = super.dataCollectionPersistence.remove(dataCollectionId);
		
		dataStructurePersistence.remove(dataCollectionId);
		
		super.assetEntryLocalService.deleteEntry(DataCollection.class.getName(), dataCollection.getPrimaryKey());

		super.resourceLocalService.deleteResource(
				dataCollection.getCompanyId(), 
				DataCollection.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, 
				dataCollection.getPrimaryKey());
		
		super.workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			    dataCollection.getCompanyId(), dataCollection.getGroupId(),
			    DataCollection.class.getName(), dataCollection.getDataCollectionId());
		
		return dataCollection;
	}
	
	public void removeDataCollections( long[] dataCollectionIds ) throws PortalException {
		for( long dataCollectionId : dataCollectionIds ) {
			this.removeDataCollection(dataCollectionId);
		}
	}
	
	private boolean _verifyDataCollectionName( String dataCollectionName ) throws DuplicatedDataCollectionNameException {
		// Check uniqueness of the dataCollectionName
		if( super.dataTypePersistence.countByName(dataCollectionName) > 0 ) {
			throw new DuplicatedDataCollectionNameException( dataCollectionName + " exists already." );
		}
		
		return true;
	}
}