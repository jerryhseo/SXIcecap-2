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

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.Locale;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class DataTypeImpl extends DataTypeBaseImpl {
	public JSONObject toJSON() {
		JSONObject dataType = _unlocalizedJSON();
		
		JSONObject localizedObj = null;
		
		localizedObj = _mapToJSON(  this.getDisplayNameMap() );
		dataType.put("displayName", localizedObj);
		
		localizedObj = _mapToJSON( this.getDescriptionMap() );
		dataType.put("description", localizedObj);
		
		localizedObj = _mapToJSON( this.getTooltipMap() );
		dataType.put("tooltip", localizedObj);
		
		return dataType;
	}
	
	public JSONObject toJSON( Locale locale ) {
		JSONObject dataType = _unlocalizedJSON();
		
		dataType.put("displayName", this.getDisplayName(locale));
		dataType.put("description", this.getDescription(locale));
		dataType.put("tooltip", this.getTooltip(locale));
		
		return dataType;
	}
	
	private JSONObject _unlocalizedJSON() {
		JSONObject dataType = JSONFactoryUtil.createJSONObject();
		
		dataType.put("dataTypeId", this.getPrimaryKey());
		
		dataType.put("companyId", this.getCompanyId());
		dataType.put("groupId", this.getGroupId());
		dataType.put("userId", this.getUserId());
		dataType.put("userName", this.getUserName());
		dataType.put("status", this.getStatus());
		dataType.put("createDate", this.getCreateDate());
		dataType.put("modifiedDate", this.getModifiedDate());
		dataType.put("dataTypeCode", this.getDataTypeCode());
		dataType.put("dataTypeVersion", this.getDataTypeVersion());
		dataType.put("extension", this.getExtension());
		
		return dataType;
	}
	
	private JSONObject _mapToJSON( Map<Locale, String> map) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		for (Map.Entry<Locale, String> entry : map.entrySet()) {
			json.put(entry.getKey().toLanguageTag(), entry.getValue()); 
		}
		
		return json;
	}
}