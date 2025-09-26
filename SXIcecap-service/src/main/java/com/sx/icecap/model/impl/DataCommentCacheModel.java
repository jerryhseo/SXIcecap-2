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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.sx.icecap.model.DataComment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataComment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataCommentCacheModel
	implements CacheModel<DataComment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataCommentCacheModel)) {
			return false;
		}

		DataCommentCacheModel dataCommentCacheModel =
			(DataCommentCacheModel)object;

		if (dataCommentId == dataCommentCacheModel.dataCommentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataCommentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{dataCommentId=");
		sb.append(dataCommentId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", commentType=");
		sb.append(commentType);
		sb.append(", commentBase=");
		sb.append(commentBase);
		sb.append(", commentDataId=");
		sb.append(commentDataId);
		sb.append(", paramCode=");
		sb.append(paramCode);
		sb.append(", parentCommentId=");
		sb.append(parentCommentId);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", closed=");
		sb.append(closed);
		sb.append(", closedUserId=");
		sb.append(closedUserId);
		sb.append(", closedUserName=");
		sb.append(closedUserName);
		sb.append(", closedDate=");
		sb.append(closedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataComment toEntityModel() {
		DataCommentImpl dataCommentImpl = new DataCommentImpl();

		dataCommentImpl.setDataCommentId(dataCommentId);
		dataCommentImpl.setCompanyId(companyId);
		dataCommentImpl.setGroupId(groupId);
		dataCommentImpl.setUserId(userId);

		if (userName == null) {
			dataCommentImpl.setUserName("");
		}
		else {
			dataCommentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataCommentImpl.setCreateDate(null);
		}
		else {
			dataCommentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataCommentImpl.setModifiedDate(null);
		}
		else {
			dataCommentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (commentType == null) {
			dataCommentImpl.setCommentType("");
		}
		else {
			dataCommentImpl.setCommentType(commentType);
		}

		if (commentBase == null) {
			dataCommentImpl.setCommentBase("");
		}
		else {
			dataCommentImpl.setCommentBase(commentBase);
		}

		dataCommentImpl.setCommentDataId(commentDataId);

		if (paramCode == null) {
			dataCommentImpl.setParamCode("");
		}
		else {
			dataCommentImpl.setParamCode(paramCode);
		}

		dataCommentImpl.setParentCommentId(parentCommentId);

		if (comment == null) {
			dataCommentImpl.setComment("");
		}
		else {
			dataCommentImpl.setComment(comment);
		}

		dataCommentImpl.setClosed(closed);
		dataCommentImpl.setClosedUserId(closedUserId);

		if (closedUserName == null) {
			dataCommentImpl.setClosedUserName("");
		}
		else {
			dataCommentImpl.setClosedUserName(closedUserName);
		}

		if (closedDate == Long.MIN_VALUE) {
			dataCommentImpl.setClosedDate(null);
		}
		else {
			dataCommentImpl.setClosedDate(new Date(closedDate));
		}

		dataCommentImpl.resetOriginalValues();

		return dataCommentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataCommentId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		commentType = objectInput.readUTF();
		commentBase = objectInput.readUTF();

		commentDataId = objectInput.readLong();
		paramCode = objectInput.readUTF();

		parentCommentId = objectInput.readLong();
		comment = objectInput.readUTF();

		closed = objectInput.readBoolean();

		closedUserId = objectInput.readLong();
		closedUserName = objectInput.readUTF();
		closedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dataCommentId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (commentType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commentType);
		}

		if (commentBase == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commentBase);
		}

		objectOutput.writeLong(commentDataId);

		if (paramCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paramCode);
		}

		objectOutput.writeLong(parentCommentId);

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}

		objectOutput.writeBoolean(closed);

		objectOutput.writeLong(closedUserId);

		if (closedUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(closedUserName);
		}

		objectOutput.writeLong(closedDate);
	}

	public long dataCommentId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String commentType;
	public String commentBase;
	public long commentDataId;
	public String paramCode;
	public long parentCommentId;
	public String comment;
	public boolean closed;
	public long closedUserId;
	public String closedUserName;
	public long closedDate;

}