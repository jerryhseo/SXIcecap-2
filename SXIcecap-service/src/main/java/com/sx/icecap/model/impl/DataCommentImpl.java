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

/**
 * @author Brian Wing Shun Chan
 */
public class DataCommentImpl extends DataCommentBaseImpl {
	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		json.put("actionHistoryId", getPrimaryKey());
		json.put("userId", getUserId());
		json.put("userName", getUserName());
		json.put("createDate", getCreateDate());
		json.put("modifiedDate", getModifiedDate());
		json.put("commentDataId", getCommentDataId());
		json.put("paramCode", getParamCode());
		json.put("parentCommentId", getParentCommentId());
		json.put("comment", getComment());
		json.put("closed", getClosed());
		json.put("closedUserId", getClosedUserId());
		json.put("closedUserName", getClosedUserName());
		json.put("closedDate", getClosedDate());
		
		return json;
	}
}