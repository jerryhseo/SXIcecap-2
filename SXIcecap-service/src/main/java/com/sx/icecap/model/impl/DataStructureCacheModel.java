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
		StringBundler sb = new StringBundler(9);

		sb.append("{dataStructureId=");
		sb.append(dataStructureId);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", structure=");
		sb.append(structure);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataStructure toEntityModel() {
		DataStructureImpl dataStructureImpl = new DataStructureImpl();

		dataStructureImpl.setDataStructureId(dataStructureId);
		dataStructureImpl.setDataTypeId(dataTypeId);

		if (version == null) {
			dataStructureImpl.setVersion("");
		}
		else {
			dataStructureImpl.setVersion(version);
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
		dataStructureId = objectInput.readLong();

		dataTypeId = objectInput.readLong();
		version = objectInput.readUTF();
		structure = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dataStructureId);

		objectOutput.writeLong(dataTypeId);

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		if (structure == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(structure);
		}
	}

	public long dataStructureId;
	public long dataTypeId;
	public String version;
	public String structure;

}