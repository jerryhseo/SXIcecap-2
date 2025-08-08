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

import com.sx.icecap.model.TypeParamLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TypeParamLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TypeParamLinkCacheModel
	implements CacheModel<TypeParamLink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TypeParamLinkCacheModel)) {
			return false;
		}

		TypeParamLinkCacheModel typeParamLinkCacheModel =
			(TypeParamLinkCacheModel)object;

		if (typeParamLinkId == typeParamLinkCacheModel.typeParamLinkId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, typeParamLinkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{typeParamLinkId=");
		sb.append(typeParamLinkId);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", dataType=");
		sb.append(dataType);
		sb.append(", paramId=");
		sb.append(paramId);
		sb.append(", param=");
		sb.append(param);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TypeParamLink toEntityModel() {
		TypeParamLinkImpl typeParamLinkImpl = new TypeParamLinkImpl();

		typeParamLinkImpl.setTypeParamLinkId(typeParamLinkId);
		typeParamLinkImpl.setDataTypeId(dataTypeId);
		typeParamLinkImpl.setDataType(dataType);
		typeParamLinkImpl.setParamId(paramId);

		if (param == null) {
			typeParamLinkImpl.setParam("");
		}
		else {
			typeParamLinkImpl.setParam(param);
		}

		typeParamLinkImpl.resetOriginalValues();

		return typeParamLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		typeParamLinkId = objectInput.readLong();

		dataTypeId = objectInput.readLong();

		dataType = objectInput.readLong();

		paramId = objectInput.readLong();
		param = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(typeParamLinkId);

		objectOutput.writeLong(dataTypeId);

		objectOutput.writeLong(dataType);

		objectOutput.writeLong(paramId);

		if (param == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(param);
		}
	}

	public long typeParamLinkId;
	public long dataTypeId;
	public long dataType;
	public long paramId;
	public String param;

}