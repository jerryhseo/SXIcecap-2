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

import com.sx.icecap.model.DataStructure;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataStructure in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataStructureCacheModel
	implements CacheModel<DataStructure>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataStructureCacheModel)) {
			return false;
		}

		DataStructureCacheModel dataStructureCacheModel =
			(DataStructureCacheModel)object;

		if (dataStructureId == dataStructureCacheModel.dataStructureId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataStructureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
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
		sb.append(", dataStructureId=");
		sb.append(dataStructureId);
		sb.append(", dataStructureName=");
		sb.append(dataStructureName);
		sb.append(", dataStructureVersion=");
		sb.append(dataStructureVersion);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", structure=");
		sb.append(structure);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataStructure toEntityModel() {
		DataStructureImpl dataStructureImpl = new DataStructureImpl();

		if (uuid == null) {
			dataStructureImpl.setUuid("");
		}
		else {
			dataStructureImpl.setUuid(uuid);
		}

		dataStructureImpl.setCompanyId(companyId);
		dataStructureImpl.setGroupId(groupId);
		dataStructureImpl.setUserId(userId);

		if (userName == null) {
			dataStructureImpl.setUserName("");
		}
		else {
			dataStructureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataStructureImpl.setCreateDate(null);
		}
		else {
			dataStructureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataStructureImpl.setModifiedDate(null);
		}
		else {
			dataStructureImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			dataStructureImpl.setLastPublishDate(null);
		}
		else {
			dataStructureImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		dataStructureImpl.setStatus(status);
		dataStructureImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataStructureImpl.setStatusByUserName("");
		}
		else {
			dataStructureImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataStructureImpl.setStatusDate(null);
		}
		else {
			dataStructureImpl.setStatusDate(new Date(statusDate));
		}

		dataStructureImpl.setDataStructureId(dataStructureId);

		if (dataStructureName == null) {
			dataStructureImpl.setDataStructureName("");
		}
		else {
			dataStructureImpl.setDataStructureName(dataStructureName);
		}

		if (dataStructureVersion == null) {
			dataStructureImpl.setDataStructureVersion("");
		}
		else {
			dataStructureImpl.setDataStructureVersion(dataStructureVersion);
		}

		if (displayName == null) {
			dataStructureImpl.setDisplayName("");
		}
		else {
			dataStructureImpl.setDisplayName(displayName);
		}

		if (description == null) {
			dataStructureImpl.setDescription("");
		}
		else {
			dataStructureImpl.setDescription(description);
		}

		if (structure == null) {
			dataStructureImpl.setStructure("");
		}
		else {
			dataStructureImpl.setStructure(structure);
		}

		dataStructureImpl.resetOriginalValues();

		return dataStructureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		lastPublishDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		dataStructureId = objectInput.readLong();
		dataStructureName = objectInput.readUTF();
		dataStructureVersion = objectInput.readUTF();
		displayName = objectInput.readUTF();
		description = objectInput.readUTF();
		structure = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

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

		objectOutput.writeLong(dataStructureId);

		if (dataStructureName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataStructureName);
		}

		if (dataStructureVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataStructureVersion);
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

		if (structure == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(structure);
		}
	}

	public String uuid;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long lastPublishDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long dataStructureId;
	public String dataStructureName;
	public String dataStructureVersion;
	public String displayName;
	public String description;
	public String structure;

}