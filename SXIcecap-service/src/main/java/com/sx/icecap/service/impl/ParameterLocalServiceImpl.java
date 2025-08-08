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
import com.sx.icecap.model.Parameter;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.base.ParameterLocalServiceBaseImpl;

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
	property = "model.class.name=com.sx.icecap.model.Parameter",
	service = AopService.class
)
public class ParameterLocalServiceImpl extends ParameterLocalServiceBaseImpl {
	@Indexable(type = IndexableType.REINDEX)
	public Parameter addParameter(
			String paramType,
			String paramName,
			String paramVersion,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> definitionMap,
			Map<Locale, String> tooltipMap,
			String synonyms,
			String typeProperties,
			boolean standard,
			int status,
			ServiceContext sc) throws PortalException {
		
		Locale defaultLocale = sc.getThemeDisplay().getLocale();
		
		long parameterId = super.counterLocalService.increment();
		Parameter parameter = super.parameterLocalService.createParameter(parameterId);
		
		parameter.setParamType(paramType);
		parameter.setParamName(paramName);
		parameter.setParamVersion(paramVersion);
		parameter.setDisplayNameMap(displayNameMap, defaultLocale);
		parameter.setDefinitionMap(definitionMap, defaultLocale);
		parameter.setTooltipMap(tooltipMap, defaultLocale);
		parameter.setSynonyms(synonyms);
		parameter.setTypeProperties(typeProperties);
		parameter.setStandard(standard);
		
		Date now = new Date();
		User user = super.userLocalService.getUser(sc.getUserId());
		parameter.setCompanyId(sc.getCompanyId());
		parameter.setGroupId(sc.getScopeGroupId());
		parameter.setUserId(user.getUserId());
		parameter.setUserName(user.getFullName());
		parameter.setCreateDate(now);
		parameter.setModifiedDate(now);
		
		if( status > WorkflowConstants.STATUS_ANY ) {
			parameter.setStatus(status);
		}
		else {
			parameter.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		parameter.setStatusByUserId(sc.getUserId());
		parameter.setStatusByUserName(user.getFullName());
		parameter.setStatusDate(sc.getModifiedDate(null));
		
		
		parameter.setExpandoBridgeAttributes(sc);
		
		parameter = super.parameterPersistence.update(parameter, sc);

		super.resourceLocalService.addResources(
				parameter.getCompanyId(), 
				parameter.getGroupId(), 
				parameter.getUserId(), 
				Parameter.class.getName(), 
				parameter.getPrimaryKey(), 
				false, 
				true, 
				true);
//			System.out.println("Resource Finished....");
		
		super.assetEntryLocalService.updateEntry(
			parameter.getUserId(), 
			parameter.getGroupId(), 
			parameter.getCreateDate(), 
			parameter.getModifiedDate(),
			Parameter.class.getName(), 
			parameter.getPrimaryKey(), 
			parameter.getUuid(), 
			0,
			sc.getAssetCategoryIds(), 
			sc.getAssetTagNames(), 
			true,
			true, 
			null, 
			null, 
			parameter.getCreateDate(),
			null, 
			ContentTypes.TEXT_HTML_UTF8, 
			parameter.getParamName(),
			null, 
			null, 
			null, 
			null,
			0, 0, null);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				parameter.getCompanyId(), 
				parameter.getGroupId(), 
				parameter.getUserId(), 
				Parameter.class.getName(), 
				parameter.getPrimaryKey(), 
				parameter, 
				sc);
		
		return parameter;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Parameter updateParameter(
			long parameterId, 
			String paramType,
			String paramName,
			String paramVersion,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> definitionMap,
			Map<Locale, String> tooltipMap,
			String synonyms,
			String typeProperties,
			boolean standard,
			int status,
			ServiceContext sc) throws PortalException {
		Parameter parameter = super.parameterPersistence.findByPrimaryKey(parameterId);
		
		Locale defaultLocale = sc.getThemeDisplay().getLocale();
		
		parameter.setParamType(paramType);
		parameter.setParamName(paramName);
		parameter.setParamVersion(paramVersion);
		parameter.setDisplayNameMap(displayNameMap, defaultLocale);
		parameter.setDefinitionMap(definitionMap, defaultLocale);
		parameter.setTooltipMap(tooltipMap, defaultLocale);
		parameter.setSynonyms(synonyms);
		parameter.setTypeProperties(typeProperties);
		parameter.setStandard(standard);
		
		parameter.setUserId(sc.getUserId());
		parameter.setGroupId(sc.getScopeGroupId());
		parameter.setModifiedDate(new Date() );

		boolean statusChanged = false;
		if( status > WorkflowConstants.STATUS_ANY && status != parameter.getStatus()) {
			User user = super.userLocalService.getUser(sc.getUserId());
			parameter.setStatus(status);
			parameter.setStatusByUserId(user.getUserId());
			parameter.setStatusByUserName(user.getFullName());
			parameter.setStatusDate(new Date());
			statusChanged = true;
		}
		
		parameter.setExpandoBridgeAttributes(sc);
		
		super.parameterPersistence.update(parameter, sc);
		
		super.resourceLocalService.updateResources(
				parameter.getCompanyId(),
				parameter.getGroupId(), 
				Parameter.class.getName(), 
				parameter.getPrimaryKey(),
				sc.getModelPermissions());
		
		super.assetEntryLocalService.updateEntry(
				parameter.getUserId(), 
				parameter.getGroupId(), 
				parameter.getCreateDate(), 
				parameter.getModifiedDate(),
				Parameter.class.getName(), 
				parameter.getPrimaryKey(), 
				parameter.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				parameter.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				parameter.getParamName(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		if( statusChanged ) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				super.assetEntryLocalService.updateVisible(Parameter.class.getName(), parameterId, true);
			} else {
				super.assetEntryLocalService.updateVisible(Parameter.class.getName(), parameterId, false);
			}
		}
		
		return parameter;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Parameter updateStatus(
			long userId, 
			long parameterId, 
			Integer status,
			ServiceContext sc) throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		Parameter parameter = super.parameterPersistence.findByPrimaryKey(parameterId);

		parameter.setStatus(status);
		parameter.setStatusByUserId(userId);
		parameter.setStatusByUserName(user.getFullName());
		parameter.setStatusDate(new Date());

		super.parameterPersistence.update(parameter, sc);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			super.assetEntryLocalService.updateVisible(Parameter.class.getName(), parameterId, true);
		} else {
			super.assetEntryLocalService.updateVisible(Parameter.class.getName(), parameterId, false);
		}

		return parameter;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public Parameter removeParameter( long parameterId ) throws PortalException {
		Parameter parameter = super.parameterPersistence.remove(parameterId);
		
		parameterPersistence.remove(parameterId);
		
		super.assetEntryLocalService.deleteEntry(Parameter.class.getName(), parameter.getPrimaryKey());

		super.resourceLocalService.deleteResource(
				parameter.getCompanyId(), 
				Parameter.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, 
				parameter.getPrimaryKey());
		
		super.workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			    parameter.getCompanyId(), parameter.getGroupId(),
			    Parameter.class.getName(), parameter.getParameterId());
		
		return parameter;
	}
	
	public void removeParameters( long[] parameterIds ) throws PortalException {
		for( long parameterId : parameterIds ) {
			this.removeParameter(parameterId);
		}
	}

	public JSONObject convertModelToJSONObject(Parameter parameter) throws JSONException {
		JSONObject jsonProperties = JSONFactoryUtil.createJSONObject(parameter.getTypeProperties()); 
		String serializedData = JSONFactoryUtil.looseSerialize(parameter);
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject( serializedData);

		jsonObject.put("typeProperties", jsonProperties);
		
		return jsonObject;
	}
	
	public JSONArray convertListToJSONArray(List<Parameter> list) throws JSONException {
		JSONArray array = JSONFactoryUtil.createJSONArray();
		
		Iterator<Parameter> iter = list.iterator();
		while( iter.hasNext()) {
			array.put(convertModelToJSONObject(iter.next()));
		}
		
		return array;
	}
}