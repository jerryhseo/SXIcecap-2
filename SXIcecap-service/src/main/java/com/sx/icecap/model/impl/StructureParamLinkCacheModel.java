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

import com.sx.icecap.model.StructureParamLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StructureParamLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StructureParamLinkCacheModel
	implements CacheModel<StructureParamLink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StructureParamLinkCacheModel)) {
			return false;
		}

		StructureParamLinkCacheModel structureParamLinkCacheModel =
			(StructureParamLinkCacheModel)object;

		if (structureParamLinkId ==
				structureParamLinkCacheModel.structureParamLinkId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, structureParamLinkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{structureParamLinkId=");
		sb.append(structureParamLinkId);
		sb.append(", dataStructureId=");
		sb.append(dataStructureId);
		sb.append(", parameterId=");
		sb.append(parameterId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StructureParamLink toEntityModel() {
		StructureParamLinkImpl structureParamLinkImpl =
			new StructureParamLinkImpl();

		structureParamLinkImpl.setStructureParamLinkId(structureParamLinkId);
		structureParamLinkImpl.setDataStructureId(dataStructureId);
		structureParamLinkImpl.setParameterId(parameterId);

		structureParamLinkImpl.resetOriginalValues();

		return structureParamLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		structureParamLinkId = objectInput.readLong();

		dataStructureId = objectInput.readLong();

		parameterId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(structureParamLinkId);

		objectOutput.writeLong(dataStructureId);

		objectOutput.writeLong(parameterId);
	}

	public long structureParamLinkId;
	public long dataStructureId;
	public long parameterId;

}