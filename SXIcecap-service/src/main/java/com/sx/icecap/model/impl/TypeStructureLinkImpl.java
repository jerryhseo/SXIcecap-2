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
public class TypeStructureLinkImpl extends TypeStructureLinkBaseImpl {
	public JSONObject toJSON() {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		json.put("groupId", this.getGroupId());
		json.put("userId", this.getUserId());
		json.put("dataTypeId", this.getDataTypeId());
		json.put("dataStructureId", this.getDataStructureId());
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
		json.put("inputStatus", this.getInputStatus());
		json.put("jumpTo", this.getJumpTo());
		
		return json;
	}
}