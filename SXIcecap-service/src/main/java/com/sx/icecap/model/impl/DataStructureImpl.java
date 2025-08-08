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
import com.sx.icecap.constant.DataStructureProperties;

import java.util.Locale;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class DataStructureImpl extends DataStructureBaseImpl {
	public JSONObject toJSON() {
		JSONObject dataStructure = _unlocalizedJSON();
		
		JSONObject localizedObj = null;
		
		localizedObj = _mapToJSON(  this.getDisplayNameMap() );
		dataStructure.put(DataStructureProperties.DISPLAY_NAME, localizedObj);
		
		localizedObj = _mapToJSON( this.getDescriptionMap() );
		dataStructure.put(DataStructureProperties.DESCRIPTION, localizedObj);
		
		return dataStructure;
	}
	
	public JSONObject toJSON( Locale locale ) {
		JSONObject dataStructure = _unlocalizedJSON();
		
		dataStructure.put(DataStructureProperties.DISPLAY_NAME, this.getDisplayName(locale));
		dataStructure.put(DataStructureProperties.DESCRIPTION, this.getDescription(locale));
		
		return dataStructure;
	}
	
	private JSONObject _unlocalizedJSON() {
		JSONObject dataStructure = JSONFactoryUtil.createJSONObject();
		
		dataStructure.put("dataStructureId", this.getPrimaryKey());
		
		dataStructure.put("companyId", this.getCompanyId());
		dataStructure.put("groupId", this.getGroupId());
		dataStructure.put("userId", this.getUserId());
		dataStructure.put("status", this.getStatus());
		dataStructure.put("createDate", this.getCreateDate());
		dataStructure.put("modifiedDate", this.getModifiedDate());
		
		dataStructure.put(DataStructureProperties.DATA_STRUCTURE_NAME, this.getDataStructureName());
		dataStructure.put(DataStructureProperties.DATA_STRUCTURE_VERSION, this.getDataStructureVersion());
		dataStructure.put(DataStructureProperties.FREEZABLE, this.getFreezable());
		dataStructure.put(DataStructureProperties.VERIFIABLE, this.getVerifiable());
		dataStructure.put(DataStructureProperties.COMMENTABLE, this.getCommentable());
		
		JSONObject structure;
		try {
			structure = JSONFactoryUtil.createJSONObject(this.getStructure());
		} catch (JSONException e) {
			structure = JSONFactoryUtil.createJSONObject();
		}
		
		dataStructure.put(DataStructureProperties.STRUCTURE, structure);
		
		return dataStructure;
	}
	
	private JSONObject _mapToJSON( Map<Locale, String> map) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		for (Map.Entry<Locale, String> entry : map.entrySet()) {
			json.put(entry.getKey().toLanguageTag(), entry.getValue()); 
		}
		
		return json;
	}
}