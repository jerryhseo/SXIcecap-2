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
public class CollectionSetLinkImpl extends CollectionSetLinkBaseImpl {
	
	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		json.put("groupId", getGroupId());
		json.put("dataCollectionId", getDataCollectionId());
		json.put("dataSetId", getDataSetId());
		json.put("order", getOrder());
		
		json.put("commentable", this.getCommentable());
		json.put("verifiable", this.getVerifiable());
		json.put("verified", this.getVerified());
		json.put("verifiedUserId", this.getVerifiedUserId());
		json.put("verifiedUserName", this.getVerifiedUserName());
		json.put("verifiedDate", this.getVerifiedDate());
		json.put("freezable", this.getFreezable());
		json.put("freezed", this.getFreezed());
		json.put("freezedUserId", this.getFreezedUserId());
		json.put("freezedUserName", this.getFreezedUserName());
		json.put("freezedDate", this.getFreezedDate());
		
		return json;
	}
}