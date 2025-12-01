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
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataCommentId=");
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
		sb.append(", commentModel=");
		sb.append(commentModel);
		sb.append(", dataId=");
		sb.append(dataId);
		sb.append(", paramCode=");
		sb.append(paramCode);
		sb.append(", parentCommentId=");
		sb.append(parentCommentId);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataComment toEntityModel() {
		DataCommentImpl dataCommentImpl = new DataCommentImpl();

		if (uuid == null) {
			dataCommentImpl.setUuid("");
		}
		else {
			dataCommentImpl.setUuid(uuid);
		}

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

		dataCommentImpl.setStatus(status);
		dataCommentImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataCommentImpl.setStatusByUserName("");
		}
		else {
			dataCommentImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataCommentImpl.setStatusDate(null);
		}
		else {
			dataCommentImpl.setStatusDate(new Date(statusDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			dataCommentImpl.setLastPublishDate(null);
		}
		else {
			dataCommentImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		if (commentModel == null) {
			dataCommentImpl.setCommentModel("");
		}
		else {
			dataCommentImpl.setCommentModel(commentModel);
		}

		dataCommentImpl.setDataId(dataId);

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

		dataCommentImpl.resetOriginalValues();

		return dataCommentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataCommentId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		lastPublishDate = objectInput.readLong();
		commentModel = objectInput.readUTF();

		dataId = objectInput.readLong();
		paramCode = objectInput.readUTF();

		parentCommentId = objectInput.readLong();
		comment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

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

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
		objectOutput.writeLong(lastPublishDate);

		if (commentModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commentModel);
		}

		objectOutput.writeLong(dataId);

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
	}

	public String uuid;
	public long dataCommentId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long lastPublishDate;
	public String commentModel;
	public long dataId;
	public String paramCode;
	public long parentCommentId;
	public String comment;

}