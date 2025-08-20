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
		StringBundler sb = new StringBundler(11);

		sb.append("{collectionSetLinkId=");
		sb.append(collectionSetLinkId);
		sb.append(", dataCollectionId=");
		sb.append(dataCollectionId);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
		sb.append(", freezed=");
		sb.append(freezed);
		sb.append(", verified=");
		sb.append(verified);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CollectionSetLink toEntityModel() {
		CollectionSetLinkImpl collectionSetLinkImpl =
			new CollectionSetLinkImpl();

		collectionSetLinkImpl.setCollectionSetLinkId(collectionSetLinkId);
		collectionSetLinkImpl.setDataCollectionId(dataCollectionId);
		collectionSetLinkImpl.setDataSetId(dataSetId);
		collectionSetLinkImpl.setFreezed(freezed);
		collectionSetLinkImpl.setVerified(verified);

		collectionSetLinkImpl.resetOriginalValues();

		return collectionSetLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		collectionSetLinkId = objectInput.readLong();

		dataCollectionId = objectInput.readLong();

		dataSetId = objectInput.readLong();

		freezed = objectInput.readBoolean();

		verified = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(collectionSetLinkId);

		objectOutput.writeLong(dataCollectionId);

		objectOutput.writeLong(dataSetId);

		objectOutput.writeBoolean(freezed);

		objectOutput.writeBoolean(verified);
	}

	public long collectionSetLinkId;
	public long dataCollectionId;
	public long dataSetId;
	public boolean freezed;
	public boolean verified;

}