/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sx.icecap.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataTypeStructure}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeStructure
 * @generated
 */
public class DataTypeStructureWrapper
	extends BaseModelWrapper<DataTypeStructure>
	implements DataTypeStructure, ModelWrapper<DataTypeStructure> {

	public DataTypeStructureWrapper(DataTypeStructure dataTypeStructure) {
		super(dataTypeStructure);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("structure", getStructure());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		String structure = (String)attributes.get("structure");

		if (structure != null) {
			setStructure(structure);
		}
	}

	/**
	 * Returns the data type ID of this data type structure.
	 *
	 * @return the data type ID of this data type structure
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the primary key of this data type structure.
	 *
	 * @return the primary key of this data type structure
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the structure of this data type structure.
	 *
	 * @return the structure of this data type structure
	 */
	@Override
	public String getStructure() {
		return model.getStructure();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data type ID of this data type structure.
	 *
	 * @param dataTypeId the data type ID of this data type structure
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the primary key of this data type structure.
	 *
	 * @param primaryKey the primary key of this data type structure
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the structure of this data type structure.
	 *
	 * @param structure the structure of this data type structure
	 */
	@Override
	public void setStructure(String structure) {
		model.setStructure(structure);
	}

	@Override
	protected DataTypeStructureWrapper wrap(
		DataTypeStructure dataTypeStructure) {

		return new DataTypeStructureWrapper(dataTypeStructure);
	}

}