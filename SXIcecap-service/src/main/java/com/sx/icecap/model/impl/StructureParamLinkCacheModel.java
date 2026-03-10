/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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
		StringBundler sb = new StringBundler(9);

		sb.append("{structureParamLinkId=");
		sb.append(structureParamLinkId);
		sb.append(", dataStructureId=");
		sb.append(dataStructureId);
		sb.append(", parameterId=");
		sb.append(parameterId);
		sb.append(", order=");
		sb.append(order);
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
		structureParamLinkImpl.setOrder(order);

		structureParamLinkImpl.resetOriginalValues();

		return structureParamLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		structureParamLinkId = objectInput.readLong();

		dataStructureId = objectInput.readLong();

		parameterId = objectInput.readLong();

		order = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(structureParamLinkId);

		objectOutput.writeLong(dataStructureId);

		objectOutput.writeLong(parameterId);

		objectOutput.writeInt(order);
	}

	public long structureParamLinkId;
	public long dataStructureId;
	public long parameterId;
	public int order;

}