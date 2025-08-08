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
		StringBundler sb = new StringBundler(11);

		sb.append("{setTypeLinkId=");
		sb.append(setTypeLinkId);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
		sb.append(", dataSet=");
		sb.append(dataSet);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", dataType=");
		sb.append(dataType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SetTypeLink toEntityModel() {
		SetTypeLinkImpl setTypeLinkImpl = new SetTypeLinkImpl();

		setTypeLinkImpl.setSetTypeLinkId(setTypeLinkId);
		setTypeLinkImpl.setDataSetId(dataSetId);
		setTypeLinkImpl.setDataSet(dataSet);
		setTypeLinkImpl.setDataTypeId(dataTypeId);

		if (dataType == null) {
			setTypeLinkImpl.setDataType("");
		}
		else {
			setTypeLinkImpl.setDataType(dataType);
		}

		setTypeLinkImpl.resetOriginalValues();

		return setTypeLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		setTypeLinkId = objectInput.readLong();

		dataSetId = objectInput.readLong();

		dataSet = objectInput.readLong();

		dataTypeId = objectInput.readLong();
		dataType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(setTypeLinkId);

		objectOutput.writeLong(dataSetId);

		objectOutput.writeLong(dataSet);

		objectOutput.writeLong(dataTypeId);

		if (dataType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataType);
		}
	}

	public long setTypeLinkId;
	public long dataSetId;
	public long dataSet;
	public long dataTypeId;
	public String dataType;

}