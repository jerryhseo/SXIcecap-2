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

package com.sx.icecap.model.impl;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sx.icecap.constant.ParameterProperties;

import java.util.Locale;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ParameterImpl extends ParameterBaseImpl {
	public JSONObject toJSON() {
		JSONObject parameter = _unlocalizedJSON();
		
		JSONObject localizedObj = null;
		
		localizedObj = _mapToJSON(  this.getDisplayNameMap() );
		parameter.put(ParameterProperties.DISPLAY_NAME, localizedObj);
		
		localizedObj = _mapToJSON( this.getDefinitionMap() );
		parameter.put(ParameterProperties.DEFINITION, localizedObj);
		
		localizedObj = _mapToJSON( this.getTooltipMap() );
		parameter.put(ParameterProperties.TOOLTIP, localizedObj);
		
		return parameter;
	}
	
	public JSONObject toJSON( Locale locale ) {
		JSONObject parameter = _unlocalizedJSON();
		
		parameter.put(ParameterProperties.DISPLAY_NAME, this.getDisplayName(locale));
		parameter.put(ParameterProperties.DEFINITION, this.getDefinition(locale));
		parameter.put(ParameterProperties.TOOLTIP, this.getTooltip(locale));
		
		return parameter;
	}
	
	private JSONObject _unlocalizedJSON() {
		JSONObject parameter = JSONFactoryUtil.createJSONObject();
		
		parameter.put("parameterId", this.getPrimaryKey());
		
		parameter.put("companyId", this.getCompanyId());
		parameter.put("groupId", this.getGroupId());
		parameter.put("userId", this.getUserId());
		parameter.put("status", this.getStatus());
		parameter.put("createDate", this.getCreateDate());
		parameter.put("modifiedDate", this.getModifiedDate());
		parameter.put(ParameterProperties.PARAM_NAME, this.getParamName());
		parameter.put(ParameterProperties.PARAM_VERSION, this.getParamVersion());
		parameter.put(ParameterProperties.PARAM_TYPE, this.getParamType());
		parameter.put(ParameterProperties.SYNONYMS, this.getSynonyms());
		parameter.put(ParameterProperties.STANDARD, this.getStandard());
		
		JSONObject typeProperties;
		try {
			typeProperties = JSONFactoryUtil.createJSONObject(this.getTypeProperties());
		} catch (JSONException e) {
			typeProperties = JSONFactoryUtil.createJSONObject();
		}
		
		parameter.put(ParameterProperties.TYPE_PROPERTIES, typeProperties);
		
		return parameter;
	}
	
	private JSONObject _mapToJSON( Map<Locale, String> map) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		for (Map.Entry<Locale, String> entry : map.entrySet()) {
			json.put(entry.getKey().toLanguageTag(), entry.getValue()); 
		}
		
		return json;
	}

}