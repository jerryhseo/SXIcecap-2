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
import com.sx.icecap.constant.DataSetProperties;

import java.util.Locale;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class DataSetImpl extends DataSetBaseImpl {
	public JSONObject toJSON() {
		JSONObject dataSet = _unlocalizedJSON();
		
		JSONObject localizedObj = null;
		
		localizedObj = _mapToJSON(  this.getDisplayNameMap() );
		dataSet.put("displayName", localizedObj);
		
		localizedObj = _mapToJSON( this.getDescriptionMap() );
		dataSet.put("description", localizedObj);
		
		return dataSet;
	}
	
	public JSONObject toJSON( Locale locale ) {
		JSONObject dataSet = _unlocalizedJSON();
		
		dataSet.put("displayName", this.getDisplayName(locale));
		dataSet.put("description", this.getDescription(locale));
		
		return dataSet;
	}
	
	private JSONObject _unlocalizedJSON() {
		JSONObject dataSet = JSONFactoryUtil.createJSONObject();
		
		dataSet.put("dataSetId", this.getPrimaryKey());
		
		dataSet.put("companyId", this.getCompanyId());
		dataSet.put("groupId", this.getGroupId());
		dataSet.put("userId", this.getUserId());
		dataSet.put("status", this.getStatus());
		dataSet.put("createDate", this.getCreateDate());
		dataSet.put("modifiedDate", this.getModifiedDate());
		dataSet.put(DataSetProperties.DATASET_NAME, this.getDataSetName());
		dataSet.put(DataSetProperties.DATASET_VERSION, this.getDataSetVersion());
		
		return dataSet;
	}
	
	private JSONObject _mapToJSON( Map<Locale, String> map) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		for (Map.Entry<Locale, String> entry : map.entrySet()) {
			json.put(entry.getKey().toLanguageTag(), entry.getValue()); 
		}
		
		return json;
	}
}