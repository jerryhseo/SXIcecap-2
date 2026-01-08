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

/**
 * @author Brian Wing Shun Chan
 */
public class StructuredDataImpl extends StructuredDataBaseImpl {
	
	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		json.put("structuredDataId", getStructuredDataId());
		json.put("userId", getUserId());
		json.put("createDate", getCreateDate());
		json.put("modifiedDate", getModifiedDate());
		json.put("status", getStatus());

		json.put("dataCollectionId", getDataCollectionId());
		json.put("dataSetId", getDataSetId());
		json.put("dataTypeId", getDataTypeId());

		json.put("freezed", getFreezed());
		json.put("freezedUserId", getFreezedUserId());
		json.put("freezedUserName", getFreezedUserName());
		json.put("freezedDate", getFreezedDate());
		json.put("verified", getVerified());
		json.put("verifiedUserId", getFreezedUserId());
		json.put("verifiedUserName", getFreezedUserName());
		json.put("verifiedDate", getFreezedDate());
		
		try {
			json.put("data", JSONFactoryUtil.createJSONObject(getData()));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}
}