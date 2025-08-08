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

import com.sx.icecap.model.DataCollection;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataCollection in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataCollectionCacheModel
	implements CacheModel<DataCollection>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataCollectionCacheModel)) {
			return false;
		}

		DataCollectionCacheModel dataCollectionCacheModel =
			(DataCollectionCacheModel)object;

		if (dataCollectionId == dataCollectionCacheModel.dataCollectionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataCollectionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataCollectionId=");
		sb.append(dataCollectionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", dataCollectionName=");
		sb.append(dataCollectionName);
		sb.append(", dataCollectionVersion=");
		sb.append(dataCollectionVersion);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", freezeLevel=");
		sb.append(freezeLevel);
		sb.append(", verifyLevel=");
		sb.append(verifyLevel);
		sb.append(", commentLevel=");
		sb.append(commentLevel);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataCollection toEntityModel() {
		DataCollectionImpl dataCollectionImpl = new DataCollectionImpl();

		if (uuid == null) {
			dataCollectionImpl.setUuid("");
		}
		else {
			dataCollectionImpl.setUuid(uuid);
		}

		dataCollectionImpl.setDataCollectionId(dataCollectionId);
		dataCollectionImpl.setGroupId(groupId);
		dataCollectionImpl.setCompanyId(companyId);
		dataCollectionImpl.setUserId(userId);

		if (userName == null) {
			dataCollectionImpl.setUserName("");
		}
		else {
			dataCollectionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataCollectionImpl.setCreateDate(null);
		}
		else {
			dataCollectionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataCollectionImpl.setModifiedDate(null);
		}
		else {
			dataCollectionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			dataCollectionImpl.setLastPublishDate(null);
		}
		else {
			dataCollectionImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		dataCollectionImpl.setStatus(status);
		dataCollectionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataCollectionImpl.setStatusByUserName("");
		}
		else {
			dataCollectionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataCollectionImpl.setStatusDate(null);
		}
		else {
			dataCollectionImpl.setStatusDate(new Date(statusDate));
		}

		if (dataCollectionName == null) {
			dataCollectionImpl.setDataCollectionName("");
		}
		else {
			dataCollectionImpl.setDataCollectionName(dataCollectionName);
		}

		if (dataCollectionVersion == null) {
			dataCollectionImpl.setDataCollectionVersion("");
		}
		else {
			dataCollectionImpl.setDataCollectionVersion(dataCollectionVersion);
		}

		if (displayName == null) {
			dataCollectionImpl.setDisplayName("");
		}
		else {
			dataCollectionImpl.setDisplayName(displayName);
		}

		if (description == null) {
			dataCollectionImpl.setDescription("");
		}
		else {
			dataCollectionImpl.setDescription(description);
		}

		if (freezeLevel == null) {
			dataCollectionImpl.setFreezeLevel("");
		}
		else {
			dataCollectionImpl.setFreezeLevel(freezeLevel);
		}

		if (verifyLevel == null) {
			dataCollectionImpl.setVerifyLevel("");
		}
		else {
			dataCollectionImpl.setVerifyLevel(verifyLevel);
		}

		if (commentLevel == null) {
			dataCollectionImpl.setCommentLevel("");
		}
		else {
			dataCollectionImpl.setCommentLevel(commentLevel);
		}

		dataCollectionImpl.resetOriginalValues();

		return dataCollectionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataCollectionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		lastPublishDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		dataCollectionName = objectInput.readUTF();
		dataCollectionVersion = objectInput.readUTF();
		displayName = objectInput.readUTF();
		description = objectInput.readUTF();
		freezeLevel = objectInput.readUTF();
		verifyLevel = objectInput.readUTF();
		commentLevel = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dataCollectionId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(lastPublishDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (dataCollectionName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataCollectionName);
		}

		if (dataCollectionVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataCollectionVersion);
		}

		if (displayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (freezeLevel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(freezeLevel);
		}

		if (verifyLevel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(verifyLevel);
		}

		if (commentLevel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commentLevel);
		}
	}

	public String uuid;
	public long dataCollectionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long lastPublishDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String dataCollectionName;
	public String dataCollectionVersion;
	public String displayName;
	public String description;
	public String freezeLevel;
	public String verifyLevel;
	public String commentLevel;

}