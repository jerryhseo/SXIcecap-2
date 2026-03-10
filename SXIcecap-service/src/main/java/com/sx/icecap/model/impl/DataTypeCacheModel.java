/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sx.icecap.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.sx.icecap.model.DataType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataTypeCacheModel
	implements CacheModel<DataType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataTypeCacheModel)) {
			return false;
		}

		DataTypeCacheModel dataTypeCacheModel = (DataTypeCacheModel)object;

		if (dataTypeId == dataTypeCacheModel.dataTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
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
		sb.append(", dataTypeCode=");
		sb.append(dataTypeCode);
		sb.append(", dataTypeVersion=");
		sb.append(dataTypeVersion);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", extension=");
		sb.append(extension);
		sb.append(", sampleFileId=");
		sb.append(sampleFileId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", inputStatus=");
		sb.append(inputStatus);
		sb.append(", jumpTo=");
		sb.append(jumpTo);
		sb.append(", verified=");
		sb.append(verified);
		sb.append(", freezed=");
		sb.append(freezed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataType toEntityModel() {
		DataTypeImpl dataTypeImpl = new DataTypeImpl();

		if (uuid == null) {
			dataTypeImpl.setUuid("");
		}
		else {
			dataTypeImpl.setUuid(uuid);
		}

		dataTypeImpl.setDataTypeId(dataTypeId);
		dataTypeImpl.setCompanyId(companyId);
		dataTypeImpl.setGroupId(groupId);
		dataTypeImpl.setUserId(userId);

		if (userName == null) {
			dataTypeImpl.setUserName("");
		}
		else {
			dataTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataTypeImpl.setCreateDate(null);
		}
		else {
			dataTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataTypeImpl.setModifiedDate(null);
		}
		else {
			dataTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			dataTypeImpl.setLastPublishDate(null);
		}
		else {
			dataTypeImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		dataTypeImpl.setStatus(status);
		dataTypeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataTypeImpl.setStatusByUserName("");
		}
		else {
			dataTypeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataTypeImpl.setStatusDate(null);
		}
		else {
			dataTypeImpl.setStatusDate(new Date(statusDate));
		}

		if (dataTypeCode == null) {
			dataTypeImpl.setDataTypeCode("");
		}
		else {
			dataTypeImpl.setDataTypeCode(dataTypeCode);
		}

		if (dataTypeVersion == null) {
			dataTypeImpl.setDataTypeVersion("");
		}
		else {
			dataTypeImpl.setDataTypeVersion(dataTypeVersion);
		}

		if (displayName == null) {
			dataTypeImpl.setDisplayName("");
		}
		else {
			dataTypeImpl.setDisplayName(displayName);
		}

		if (extension == null) {
			dataTypeImpl.setExtension("");
		}
		else {
			dataTypeImpl.setExtension(extension);
		}

		dataTypeImpl.setSampleFileId(sampleFileId);

		if (description == null) {
			dataTypeImpl.setDescription("");
		}
		else {
			dataTypeImpl.setDescription(description);
		}

		dataTypeImpl.setInputStatus(inputStatus);
		dataTypeImpl.setJumpTo(jumpTo);

		if (verified == null) {
			dataTypeImpl.setVerified("");
		}
		else {
			dataTypeImpl.setVerified(verified);
		}

		if (freezed == null) {
			dataTypeImpl.setFreezed("");
		}
		else {
			dataTypeImpl.setFreezed(freezed);
		}

		dataTypeImpl.resetOriginalValues();

		return dataTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataTypeId = objectInput.readLong();

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
		dataTypeCode = objectInput.readUTF();
		dataTypeVersion = objectInput.readUTF();
		displayName = objectInput.readUTF();
		extension = objectInput.readUTF();

		sampleFileId = objectInput.readLong();
		description = objectInput.readUTF();

		inputStatus = objectInput.readBoolean();

		jumpTo = objectInput.readBoolean();
		verified = objectInput.readUTF();
		freezed = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dataTypeId);

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

		if (dataTypeCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeCode);
		}

		if (dataTypeVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeVersion);
		}

		if (displayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		if (extension == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(extension);
		}

		objectOutput.writeLong(sampleFileId);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(inputStatus);

		objectOutput.writeBoolean(jumpTo);

		if (verified == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(verified);
		}

		if (freezed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(freezed);
		}
	}

	public String uuid;
	public long dataTypeId;
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
	public String dataTypeCode;
	public String dataTypeVersion;
	public String displayName;
	public String extension;
	public long sampleFileId;
	public String description;
	public boolean inputStatus;
	public boolean jumpTo;
	public String verified;
	public String freezed;

}