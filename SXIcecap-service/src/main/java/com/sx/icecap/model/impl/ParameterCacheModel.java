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

import com.sx.icecap.model.Parameter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Parameter in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ParameterCacheModel
	implements CacheModel<Parameter>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ParameterCacheModel)) {
			return false;
		}

		ParameterCacheModel parameterCacheModel = (ParameterCacheModel)object;

		if (parameterId == parameterCacheModel.parameterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, parameterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", parameterId=");
		sb.append(parameterId);
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
		sb.append(", paramCode=");
		sb.append(paramCode);
		sb.append(", paramVersion=");
		sb.append(paramVersion);
		sb.append(", paramType=");
		sb.append(paramType);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", definition=");
		sb.append(definition);
		sb.append(", tooltip=");
		sb.append(tooltip);
		sb.append(", synonyms=");
		sb.append(synonyms);
		sb.append(", typeProperties=");
		sb.append(typeProperties);
		sb.append(", standard=");
		sb.append(standard);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Parameter toEntityModel() {
		ParameterImpl parameterImpl = new ParameterImpl();

		if (uuid == null) {
			parameterImpl.setUuid("");
		}
		else {
			parameterImpl.setUuid(uuid);
		}

		parameterImpl.setParameterId(parameterId);
		parameterImpl.setCompanyId(companyId);
		parameterImpl.setGroupId(groupId);
		parameterImpl.setUserId(userId);

		if (userName == null) {
			parameterImpl.setUserName("");
		}
		else {
			parameterImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			parameterImpl.setCreateDate(null);
		}
		else {
			parameterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			parameterImpl.setModifiedDate(null);
		}
		else {
			parameterImpl.setModifiedDate(new Date(modifiedDate));
		}

		parameterImpl.setStatus(status);
		parameterImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			parameterImpl.setStatusByUserName("");
		}
		else {
			parameterImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			parameterImpl.setStatusDate(null);
		}
		else {
			parameterImpl.setStatusDate(new Date(statusDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			parameterImpl.setLastPublishDate(null);
		}
		else {
			parameterImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		if (paramCode == null) {
			parameterImpl.setParamCode("");
		}
		else {
			parameterImpl.setParamCode(paramCode);
		}

		if (paramVersion == null) {
			parameterImpl.setParamVersion("");
		}
		else {
			parameterImpl.setParamVersion(paramVersion);
		}

		if (paramType == null) {
			parameterImpl.setParamType("");
		}
		else {
			parameterImpl.setParamType(paramType);
		}

		if (displayName == null) {
			parameterImpl.setDisplayName("");
		}
		else {
			parameterImpl.setDisplayName(displayName);
		}

		if (definition == null) {
			parameterImpl.setDefinition("");
		}
		else {
			parameterImpl.setDefinition(definition);
		}

		if (tooltip == null) {
			parameterImpl.setTooltip("");
		}
		else {
			parameterImpl.setTooltip(tooltip);
		}

		if (synonyms == null) {
			parameterImpl.setSynonyms("");
		}
		else {
			parameterImpl.setSynonyms(synonyms);
		}

		if (typeProperties == null) {
			parameterImpl.setTypeProperties("");
		}
		else {
			parameterImpl.setTypeProperties(typeProperties);
		}

		parameterImpl.setStandard(standard);

		parameterImpl.resetOriginalValues();

		return parameterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		parameterId = objectInput.readLong();

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
		paramCode = objectInput.readUTF();
		paramVersion = objectInput.readUTF();
		paramType = objectInput.readUTF();
		displayName = objectInput.readUTF();
		definition = objectInput.readUTF();
		tooltip = objectInput.readUTF();
		synonyms = objectInput.readUTF();
		typeProperties = objectInput.readUTF();

		standard = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(parameterId);

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

		if (paramCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paramCode);
		}

		if (paramVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paramVersion);
		}

		if (paramType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paramType);
		}

		if (displayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		if (definition == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(definition);
		}

		if (tooltip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tooltip);
		}

		if (synonyms == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(synonyms);
		}

		if (typeProperties == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeProperties);
		}

		objectOutput.writeBoolean(standard);
	}

	public String uuid;
	public long parameterId;
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
	public String paramCode;
	public String paramVersion;
	public String paramType;
	public String displayName;
	public String definition;
	public String tooltip;
	public String synonyms;
	public String typeProperties;
	public boolean standard;

}