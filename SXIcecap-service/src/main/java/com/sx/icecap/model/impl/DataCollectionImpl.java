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
import com.sx.icecap.constant.DataCollectionProperties;

import java.util.Locale;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class DataCollectionImpl extends DataCollectionBaseImpl {
	public JSONObject toJSON() {
		JSONObject dataCollection = _unlocalizedJSON();
		
		JSONObject localizedObj = null;
		
		localizedObj = _mapToJSON(  this.getDisplayNameMap() );
		dataCollection.put(DataCollectionProperties.DISPLAY_NAME, localizedObj);
		
		localizedObj = _mapToJSON( this.getDescriptionMap() );
		dataCollection.put(DataCollectionProperties.DESCRIPTION, localizedObj);
		
		return dataCollection;
	}
	
	public JSONObject toJSON( Locale locale ) {
		JSONObject dataCollection = _unlocalizedJSON();
		
		dataCollection.put(DataCollectionProperties.DISPLAY_NAME, this.getDisplayName(locale));
		dataCollection.put(DataCollectionProperties.DESCRIPTION, this.getDescription(locale));
		
		return dataCollection;
	}
	
	private JSONObject _unlocalizedJSON() {
		JSONObject dataCollection = JSONFactoryUtil.createJSONObject();
		
		dataCollection.put("dataCollectionId", this.getPrimaryKey());
		
		dataCollection.put("companyId", this.getCompanyId());
		dataCollection.put("groupId", this.getGroupId());
		dataCollection.put("userId", this.getUserId());
		dataCollection.put("status", this.getStatus());
		dataCollection.put("createDate", this.getCreateDate());
		dataCollection.put("modifiedDate", this.getModifiedDate());
		dataCollection.put(DataCollectionProperties.DATA_COLLECTION_NAME, this.getDataCollectionName());
		dataCollection.put(DataCollectionProperties.DATA_COLLECTION_VERSION, this.getDataCollectionVersion());
		
		return dataCollection;
	}
	
	private JSONObject _mapToJSON( Map<Locale, String> map) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		for (Map.Entry<Locale, String> entry : map.entrySet()) {
			json.put(entry.getKey().toLanguageTag(), entry.getValue()); 
		}
		
		return json;
	}
}