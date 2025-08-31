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

import com.sx.icecap.model.TypeStructureLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TypeStructureLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TypeStructureLinkCacheModel
	implements CacheModel<TypeStructureLink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TypeStructureLinkCacheModel)) {
			return false;
		}

		TypeStructureLinkCacheModel typeStructureLinkCacheModel =
			(TypeStructureLinkCacheModel)object;

		if (dataTypeId == typeStructureLinkCacheModel.dataTypeId) {
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
		StringBundler sb = new StringBundler(35);

		sb.append("{dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", dataStructureId=");
		sb.append(dataStructureId);
		sb.append(", commentable=");
		sb.append(commentable);
		sb.append(", verifiable=");
		sb.append(verifiable);
		sb.append(", freezable=");
		sb.append(freezable);
		sb.append(", freezed=");
		sb.append(freezed);
		sb.append(", freezedUserId=");
		sb.append(freezedUserId);
		sb.append(", freezedUserName=");
		sb.append(freezedUserName);
		sb.append(", freezedDate=");
		sb.append(freezedDate);
		sb.append(", verified=");
		sb.append(verified);
		sb.append(", verifiedUserId=");
		sb.append(verifiedUserId);
		sb.append(", verifiedUserName=");
		sb.append(verifiedUserName);
		sb.append(", verifiedDate=");
		sb.append(verifiedDate);
		sb.append(", inputStatus=");
		sb.append(inputStatus);
		sb.append(", jumpTo=");
		sb.append(jumpTo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TypeStructureLink toEntityModel() {
		TypeStructureLinkImpl typeStructureLinkImpl =
			new TypeStructureLinkImpl();

		typeStructureLinkImpl.setDataTypeId(dataTypeId);
		typeStructureLinkImpl.setUserId(userId);
		typeStructureLinkImpl.setGroupId(groupId);
		typeStructureLinkImpl.setDataStructureId(dataStructureId);
		typeStructureLinkImpl.setCommentable(commentable);
		typeStructureLinkImpl.setVerifiable(verifiable);
		typeStructureLinkImpl.setFreezable(freezable);
		typeStructureLinkImpl.setFreezed(freezed);
		typeStructureLinkImpl.setFreezedUserId(freezedUserId);

		if (freezedUserName == null) {
			typeStructureLinkImpl.setFreezedUserName("");
		}
		else {
			typeStructureLinkImpl.setFreezedUserName(freezedUserName);
		}

		if (freezedDate == Long.MIN_VALUE) {
			typeStructureLinkImpl.setFreezedDate(null);
		}
		else {
			typeStructureLinkImpl.setFreezedDate(new Date(freezedDate));
		}

		typeStructureLinkImpl.setVerified(verified);
		typeStructureLinkImpl.setVerifiedUserId(verifiedUserId);

		if (verifiedUserName == null) {
			typeStructureLinkImpl.setVerifiedUserName("");
		}
		else {
			typeStructureLinkImpl.setVerifiedUserName(verifiedUserName);
		}

		if (verifiedDate == Long.MIN_VALUE) {
			typeStructureLinkImpl.setVerifiedDate(null);
		}
		else {
			typeStructureLinkImpl.setVerifiedDate(new Date(verifiedDate));
		}

		typeStructureLinkImpl.setInputStatus(inputStatus);
		typeStructureLinkImpl.setJumpTo(jumpTo);

		typeStructureLinkImpl.resetOriginalValues();

		return typeStructureLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataTypeId = objectInput.readLong();

		userId = objectInput.readLong();

		groupId = objectInput.readLong();

		dataStructureId = objectInput.readLong();

		commentable = objectInput.readBoolean();

		verifiable = objectInput.readBoolean();

		freezable = objectInput.readBoolean();

		freezed = objectInput.readBoolean();

		freezedUserId = objectInput.readLong();
		freezedUserName = objectInput.readUTF();
		freezedDate = objectInput.readLong();

		verified = objectInput.readBoolean();

		verifiedUserId = objectInput.readLong();
		verifiedUserName = objectInput.readUTF();
		verifiedDate = objectInput.readLong();

		inputStatus = objectInput.readBoolean();

		jumpTo = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dataTypeId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(dataStructureId);

		objectOutput.writeBoolean(commentable);

		objectOutput.writeBoolean(verifiable);

		objectOutput.writeBoolean(freezable);

		objectOutput.writeBoolean(freezed);

		objectOutput.writeLong(freezedUserId);

		if (freezedUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(freezedUserName);
		}

		objectOutput.writeLong(freezedDate);

		objectOutput.writeBoolean(verified);

		objectOutput.writeLong(verifiedUserId);

		if (verifiedUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(verifiedUserName);
		}

		objectOutput.writeLong(verifiedDate);

		objectOutput.writeBoolean(inputStatus);

		objectOutput.writeBoolean(jumpTo);
	}

	public long dataTypeId;
	public long userId;
	public long groupId;
	public long dataStructureId;
	public boolean commentable;
	public boolean verifiable;
	public boolean freezable;
	public boolean freezed;
	public long freezedUserId;
	public String freezedUserName;
	public long freezedDate;
	public boolean verified;
	public long verifiedUserId;
	public String verifiedUserName;
	public long verifiedDate;
	public boolean inputStatus;
	public boolean jumpTo;

}