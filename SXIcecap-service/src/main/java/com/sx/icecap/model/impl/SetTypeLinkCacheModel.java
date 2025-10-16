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

import com.sx.icecap.model.SetTypeLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SetTypeLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SetTypeLinkCacheModel
	implements CacheModel<SetTypeLink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SetTypeLinkCacheModel)) {
			return false;
		}

		SetTypeLinkCacheModel setTypeLinkCacheModel =
			(SetTypeLinkCacheModel)object;

		if (setTypeLinkId == setTypeLinkCacheModel.setTypeLinkId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, setTypeLinkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{setTypeLinkId=");
		sb.append(setTypeLinkId);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", order=");
		sb.append(order);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SetTypeLink toEntityModel() {
		SetTypeLinkImpl setTypeLinkImpl = new SetTypeLinkImpl();

		setTypeLinkImpl.setSetTypeLinkId(setTypeLinkId);
		setTypeLinkImpl.setDataSetId(dataSetId);
		setTypeLinkImpl.setDataTypeId(dataTypeId);
		setTypeLinkImpl.setOrder(order);
		setTypeLinkImpl.setCommentable(commentable);
		setTypeLinkImpl.setVerifiable(verifiable);
		setTypeLinkImpl.setFreezable(freezable);
		setTypeLinkImpl.setFreezed(freezed);
		setTypeLinkImpl.setFreezedUserId(freezedUserId);

		if (freezedUserName == null) {
			setTypeLinkImpl.setFreezedUserName("");
		}
		else {
			setTypeLinkImpl.setFreezedUserName(freezedUserName);
		}

		if (freezedDate == Long.MIN_VALUE) {
			setTypeLinkImpl.setFreezedDate(null);
		}
		else {
			setTypeLinkImpl.setFreezedDate(new Date(freezedDate));
		}

		setTypeLinkImpl.setVerified(verified);
		setTypeLinkImpl.setVerifiedUserId(verifiedUserId);

		if (verifiedUserName == null) {
			setTypeLinkImpl.setVerifiedUserName("");
		}
		else {
			setTypeLinkImpl.setVerifiedUserName(verifiedUserName);
		}

		if (verifiedDate == Long.MIN_VALUE) {
			setTypeLinkImpl.setVerifiedDate(null);
		}
		else {
			setTypeLinkImpl.setVerifiedDate(new Date(verifiedDate));
		}

		setTypeLinkImpl.resetOriginalValues();

		return setTypeLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		setTypeLinkId = objectInput.readLong();

		dataSetId = objectInput.readLong();

		dataTypeId = objectInput.readLong();

		order = objectInput.readInt();

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
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(setTypeLinkId);

		objectOutput.writeLong(dataSetId);

		objectOutput.writeLong(dataTypeId);

		objectOutput.writeInt(order);

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
	}

	public long setTypeLinkId;
	public long dataSetId;
	public long dataTypeId;
	public int order;
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

}