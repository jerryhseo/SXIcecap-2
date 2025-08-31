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
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.sx.icecap.exception.NoSuchDataStructureException;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.model.Parameter;
import com.sx.icecap.service.base.DataStructureLocalServiceBaseImpl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.DataStructure",
	service = AopService.class
)
public class DataStructureLocalServiceImpl
	extends DataStructureLocalServiceBaseImpl {
	
	@Indexable(type = IndexableType.REINDEX)
	public DataStructure addDataStructure(
			String dataStructureCode,
			String dataStructureVersion,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap,
			String structure,
			int status,
			ServiceContext sc) throws PortalException {
		
		Locale defaultLocale = sc.getThemeDisplay().getLocale();
		
		long dataStructureId = super.counterLocalService.increment();
		DataStructure dataStructure = super.dataStructureLocalService.createDataStructure(dataStructureId);
		
		dataStructure.setDataStructureCode(dataStructureCode);
		dataStructure.setDataStructureVersion(dataStructureVersion);
		dataStructure.setDisplayNameMap(displayNameMap, defaultLocale);
		dataStructure.setDescriptionMap(descriptionMap, defaultLocale);
		dataStructure.setStructure(structure);
		
		Date now = new Date();
		User user = super.userLocalService.getUser(sc.getUserId());
		dataStructure.setCompanyId(sc.getCompanyId());
		dataStructure.setGroupId(sc.getScopeGroupId());
		dataStructure.setUserId(user.getUserId());
		dataStructure.setUserName(user.getFullName());
		dataStructure.setCreateDate(now);
		dataStructure.setModifiedDate(now);
		
		if( status > WorkflowConstants.STATUS_ANY ) {
			dataStructure.setStatus(status);
		}
		else {
			dataStructure.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		dataStructure.setStatusByUserId(sc.getUserId());
		dataStructure.setStatusByUserName(user.getFullName());
		dataStructure.setStatusDate(sc.getModifiedDate(null));
		
		
		dataStructure.setExpandoBridgeAttributes(sc);
		
		dataStructure = super.dataStructurePersistence.update(dataStructure, sc);

		super.resourceLocalService.addResources(
				dataStructure.getCompanyId(), 
				dataStructure.getGroupId(), 
				dataStructure.getUserId(), 
				DataStructure.class.getName(), 
				dataStructure.getPrimaryKey(), 
				false, 
				true, 
				true);
//			System.out.println("Resource Finished....");
		
		super.assetEntryLocalService.updateEntry(
			dataStructure.getUserId(), 
			dataStructure.getGroupId(), 
			dataStructure.getCreateDate(), 
			dataStructure.getModifiedDate(),
			DataStructure.class.getName(), 
			dataStructure.getPrimaryKey(), 
			dataStructure.getUuid(), 
			0,
			sc.getAssetCategoryIds(), 
			sc.getAssetTagNames(), 
			true,
			true, 
			null, 
			null, 
			dataStructure.getCreateDate(),
			null, 
			ContentTypes.TEXT_HTML_UTF8, 
			dataStructure.getDataStructureCode(),
			null, 
			null, 
			null, 
			null,
			0, 0, null);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				dataStructure.getCompanyId(), 
				dataStructure.getGroupId(), 
				dataStructure.getUserId(), 
				DataStructure.class.getName(), 
				dataStructure.getPrimaryKey(), 
				dataStructure, 
				sc);
		
		return dataStructure;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataStructure updateDataStructure(
			long dataStructureId, 
			String dataStructureCode, 
			String dataStructureVersion,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap,
			String structure,
			int status,
			ServiceContext sc) throws PortalException {
		DataStructure dataStructure = super.dataStructurePersistence.findByPrimaryKey(dataStructureId);
		
		dataStructure.setDataStructureCode(dataStructureCode);
		dataStructure.setDataStructureVersion(dataStructureVersion);
		dataStructure.setDisplayNameMap(displayNameMap, sc.getLocale());
		dataStructure.setDescriptionMap(descriptionMap, sc.getLocale());
		dataStructure.setStructure(structure);
		
		dataStructure.setUserId(sc.getUserId());
		dataStructure.setGroupId(sc.getScopeGroupId());
		dataStructure.setModifiedDate(new Date() );

		boolean statusChanged = false;
		if( status > WorkflowConstants.STATUS_ANY && status != dataStructure.getStatus()) {
			User user = super.userLocalService.getUser(sc.getUserId());
			dataStructure.setStatus(status);
			dataStructure.setStatusByUserId(user.getUserId());
			dataStructure.setStatusByUserName(user.getFullName());
			dataStructure.setStatusDate(new Date());
			statusChanged = true;
		}
		
		dataStructure.setExpandoBridgeAttributes(sc);
		
		super.dataStructurePersistence.update(dataStructure, sc);
		
		super.resourceLocalService.updateResources(
				dataStructure.getCompanyId(),
				dataStructure.getGroupId(), 
				DataStructure.class.getName(), 
				dataStructure.getPrimaryKey(),
				sc.getModelPermissions());
		
		super.assetEntryLocalService.updateEntry(
				dataStructure.getUserId(), 
				dataStructure.getGroupId(), 
				dataStructure.getCreateDate(), 
				dataStructure.getModifiedDate(),
				DataStructure.class.getName(), 
				dataStructure.getPrimaryKey(), 
				dataStructure.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				dataStructure.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				dataStructure.getDataStructureCode(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		if( statusChanged ) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				super.assetEntryLocalService.updateVisible(DataStructure.class.getName(), dataStructureId, true);
			} else {
				super.assetEntryLocalService.updateVisible(DataStructure.class.getName(), dataStructureId, false);
			}
		}
		
		return dataStructure;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataStructure updateStatus(
			long userId, 
			long dataStructureId, 
			Integer status,
			ServiceContext sc) throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		DataStructure dataStructure = super.dataStructurePersistence.findByPrimaryKey(dataStructureId);

		dataStructure.setStatus(status);
		dataStructure.setStatusByUserId(userId);
		dataStructure.setStatusByUserName(user.getFullName());
		dataStructure.setStatusDate(new Date());

		super.dataStructurePersistence.update(dataStructure, sc);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			super.assetEntryLocalService.updateVisible(DataStructure.class.getName(), dataStructureId, true);
		} else {
			super.assetEntryLocalService.updateVisible(DataStructure.class.getName(), dataStructureId, false);
		}

		return dataStructure;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public DataStructure removeDataStructure( long dataStructureId ) throws PortalException {
		DataStructure dataStructure = super.dataStructurePersistence.remove(dataStructureId);
		
		dataStructurePersistence.remove(dataStructureId);
		
		super.assetEntryLocalService.deleteEntry(DataStructure.class.getName(), dataStructure.getPrimaryKey());

		super.resourceLocalService.deleteResource(
				dataStructure.getCompanyId(), 
				DataStructure.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, 
				dataStructure.getPrimaryKey());
		
		super.workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			    dataStructure.getCompanyId(), dataStructure.getGroupId(),
			    DataStructure.class.getName(), dataStructure.getDataStructureId());
		
		return dataStructure;
	}
	
	public void removeDataStructures( long[] dataStructureIds ) throws PortalException {
		for( long dataStructureId : dataStructureIds ) {
			this.removeDataStructure(dataStructureId);
		}
	}
	
	public DataStructure updateStructure(long dataStructureId, String structure) throws NoSuchDataStructureException {
		DataStructure dataStructure = super.dataStructurePersistence.findByPrimaryKey(dataStructureId);
		
		dataStructure.setStructure(structure);
		
		updateDataStructure(dataStructure);
		
		return dataStructure;
	}

	public List<DataStructure> getAllDataStructures(){
		return super.dataStructurePersistence.findAll();
	}
}