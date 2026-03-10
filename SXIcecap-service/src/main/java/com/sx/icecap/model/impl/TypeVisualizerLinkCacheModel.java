/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sx.icecap.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.sx.icecap.model.TypeVisualizerLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TypeVisualizerLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TypeVisualizerLinkCacheModel
	implements CacheModel<TypeVisualizerLink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TypeVisualizerLinkCacheModel)) {
			return false;
		}

		TypeVisualizerLinkCacheModel typeVisualizerLinkCacheModel =
			(TypeVisualizerLinkCacheModel)object;

		if (typeVisualizerLinkId ==
				typeVisualizerLinkCacheModel.typeVisualizerLinkId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, typeVisualizerLinkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{typeVisualizerLinkId=");
		sb.append(typeVisualizerLinkId);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", visualizerId=");
		sb.append(visualizerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TypeVisualizerLink toEntityModel() {
		TypeVisualizerLinkImpl typeVisualizerLinkImpl =
			new TypeVisualizerLinkImpl();

		typeVisualizerLinkImpl.setTypeVisualizerLinkId(typeVisualizerLinkId);
		typeVisualizerLinkImpl.setDataTypeId(dataTypeId);
		typeVisualizerLinkImpl.setVisualizerId(visualizerId);

		typeVisualizerLinkImpl.resetOriginalValues();

		return typeVisualizerLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		typeVisualizerLinkId = objectInput.readLong();

		dataTypeId = objectInput.readLong();

		visualizerId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(typeVisualizerLinkId);

		objectOutput.writeLong(dataTypeId);

		objectOutput.writeLong(visualizerId);
	}

	public long typeVisualizerLinkId;
	public long dataTypeId;
	public long visualizerId;

}