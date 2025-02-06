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

import com.sx.icecap.model.DisverifiedData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DisverifiedData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DisverifiedDataCacheModel
	implements CacheModel<DisverifiedData>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DisverifiedDataCacheModel)) {
			return false;
		}

		DisverifiedDataCacheModel disverifiedDataCacheModel =
			(DisverifiedDataCacheModel)object;

		if (disverifiedDataId == disverifiedDataCacheModel.disverifiedDataId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, disverifiedDataId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{disverifiedDataId=");
		sb.append(disverifiedDataId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", tempDataTitle=");
		sb.append(tempDataTitle);
		sb.append(", dataSetDisplayName=");
		sb.append(dataSetDisplayName);
		sb.append(", dataTypeDisplayName=");
		sb.append(dataTypeDisplayName);
		sb.append(", folderName=");
		sb.append(folderName);
		sb.append(", structuredData=");
		sb.append(structuredData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DisverifiedData toEntityModel() {
		DisverifiedDataImpl disverifiedDataImpl = new DisverifiedDataImpl();

		disverifiedDataImpl.setDisverifiedDataId(disverifiedDataId);
		disverifiedDataImpl.setGroupId(groupId);
		disverifiedDataImpl.setCompanyId(companyId);
		disverifiedDataImpl.setUserId(userId);

		if (userName == null) {
			disverifiedDataImpl.setUserName("");
		}
		else {
			disverifiedDataImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			disverifiedDataImpl.setCreateDate(null);
		}
		else {
			disverifiedDataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			disverifiedDataImpl.setModifiedDate(null);
		}
		else {
			disverifiedDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		disverifiedDataImpl.setStatus(status);
		disverifiedDataImpl.setDataSetId(dataSetId);
		disverifiedDataImpl.setDataTypeId(dataTypeId);
		disverifiedDataImpl.setFolderId(folderId);

		if (tempDataTitle == null) {
			disverifiedDataImpl.setTempDataTitle("");
		}
		else {
			disverifiedDataImpl.setTempDataTitle(tempDataTitle);
		}

		if (dataSetDisplayName == null) {
			disverifiedDataImpl.setDataSetDisplayName("");
		}
		else {
			disverifiedDataImpl.setDataSetDisplayName(dataSetDisplayName);
		}

		if (dataTypeDisplayName == null) {
			disverifiedDataImpl.setDataTypeDisplayName("");
		}
		else {
			disverifiedDataImpl.setDataTypeDisplayName(dataTypeDisplayName);
		}

		if (folderName == null) {
			disverifiedDataImpl.setFolderName("");
		}
		else {
			disverifiedDataImpl.setFolderName(folderName);
		}

		if (structuredData == null) {
			disverifiedDataImpl.setStructuredData("");
		}
		else {
			disverifiedDataImpl.setStructuredData(structuredData);
		}

		disverifiedDataImpl.resetOriginalValues();

		return disverifiedDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		disverifiedDataId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		dataSetId = objectInput.readLong();

		dataTypeId = objectInput.readLong();

		folderId = objectInput.readLong();
		tempDataTitle = objectInput.readUTF();
		dataSetDisplayName = objectInput.readUTF();
		dataTypeDisplayName = objectInput.readUTF();
		folderName = objectInput.readUTF();
		structuredData = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(disverifiedDataId);

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

		objectOutput.writeInt(status);

		objectOutput.writeLong(dataSetId);

		objectOutput.writeLong(dataTypeId);

		objectOutput.writeLong(folderId);

		if (tempDataTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tempDataTitle);
		}

		if (dataSetDisplayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataSetDisplayName);
		}

		if (dataTypeDisplayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeDisplayName);
		}

		if (folderName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(folderName);
		}

		if (structuredData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(structuredData);
		}
	}

	public long disverifiedDataId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long dataSetId;
	public long dataTypeId;
	public long folderId;
	public String tempDataTitle;
	public String dataSetDisplayName;
	public String dataTypeDisplayName;
	public String folderName;
	public String structuredData;

}