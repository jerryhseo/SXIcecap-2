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

import com.sx.icecap.model.CollectionSetLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CollectionSetLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CollectionSetLinkCacheModel
	implements CacheModel<CollectionSetLink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CollectionSetLinkCacheModel)) {
			return false;
		}

		CollectionSetLinkCacheModel collectionSetLinkCacheModel =
			(CollectionSetLinkCacheModel)object;

		if (collectionSetLinkId ==
				collectionSetLinkCacheModel.collectionSetLinkId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, collectionSetLinkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", collectionSetLinkId=");
		sb.append(collectionSetLinkId);
		sb.append(", dataCollectionId=");
		sb.append(dataCollectionId);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
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
	public CollectionSetLink toEntityModel() {
		CollectionSetLinkImpl collectionSetLinkImpl =
			new CollectionSetLinkImpl();

		collectionSetLinkImpl.setCompanyId(companyId);
		collectionSetLinkImpl.setGroupId(groupId);
		collectionSetLinkImpl.setCollectionSetLinkId(collectionSetLinkId);
		collectionSetLinkImpl.setDataCollectionId(dataCollectionId);
		collectionSetLinkImpl.setDataSetId(dataSetId);
		collectionSetLinkImpl.setOrder(order);
		collectionSetLinkImpl.setCommentable(commentable);
		collectionSetLinkImpl.setVerifiable(verifiable);
		collectionSetLinkImpl.setFreezable(freezable);
		collectionSetLinkImpl.setFreezed(freezed);
		collectionSetLinkImpl.setFreezedUserId(freezedUserId);

		if (freezedUserName == null) {
			collectionSetLinkImpl.setFreezedUserName("");
		}
		else {
			collectionSetLinkImpl.setFreezedUserName(freezedUserName);
		}

		if (freezedDate == Long.MIN_VALUE) {
			collectionSetLinkImpl.setFreezedDate(null);
		}
		else {
			collectionSetLinkImpl.setFreezedDate(new Date(freezedDate));
		}

		collectionSetLinkImpl.setVerified(verified);
		collectionSetLinkImpl.setVerifiedUserId(verifiedUserId);

		if (verifiedUserName == null) {
			collectionSetLinkImpl.setVerifiedUserName("");
		}
		else {
			collectionSetLinkImpl.setVerifiedUserName(verifiedUserName);
		}

		if (verifiedDate == Long.MIN_VALUE) {
			collectionSetLinkImpl.setVerifiedDate(null);
		}
		else {
			collectionSetLinkImpl.setVerifiedDate(new Date(verifiedDate));
		}

		collectionSetLinkImpl.resetOriginalValues();

		return collectionSetLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		collectionSetLinkId = objectInput.readLong();

		dataCollectionId = objectInput.readLong();

		dataSetId = objectInput.readLong();

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
		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(collectionSetLinkId);

		objectOutput.writeLong(dataCollectionId);

		objectOutput.writeLong(dataSetId);

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

	public long companyId;
	public long groupId;
	public long collectionSetLinkId;
	public long dataCollectionId;
	public long dataSetId;
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