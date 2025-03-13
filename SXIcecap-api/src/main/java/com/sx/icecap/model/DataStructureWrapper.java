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

package com.sx.icecap.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataStructure}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataStructure
 * @generated
 */
public class DataStructureWrapper
	extends BaseModelWrapper<DataStructure>
	implements DataStructure, ModelWrapper<DataStructure> {

	public DataStructureWrapper(DataStructure dataStructure) {
		super(dataStructure);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataStructureId", getDataStructureId());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("version", getVersion());
		attributes.put("structure", getStructure());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataStructureId = (Long)attributes.get("dataStructureId");

		if (dataStructureId != null) {
			setDataStructureId(dataStructureId);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String structure = (String)attributes.get("structure");

		if (structure != null) {
			setStructure(structure);
		}
	}

	/**
	 * Returns the data structure ID of this data structure.
	 *
	 * @return the data structure ID of this data structure
	 */
	@Override
	public long getDataStructureId() {
		return model.getDataStructureId();
	}

	/**
	 * Returns the data type ID of this data structure.
	 *
	 * @return the data type ID of this data structure
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the primary key of this data structure.
	 *
	 * @return the primary key of this data structure
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the structure of this data structure.
	 *
	 * @return the structure of this data structure
	 */
	@Override
	public String getStructure() {
		return model.getStructure();
	}

	/**
	 * Returns the version of this data structure.
	 *
	 * @return the version of this data structure
	 */
	@Override
	public String getVersion() {
		return model.getVersion();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data structure ID of this data structure.
	 *
	 * @param dataStructureId the data structure ID of this data structure
	 */
	@Override
	public void setDataStructureId(long dataStructureId) {
		model.setDataStructureId(dataStructureId);
	}

	/**
	 * Sets the data type ID of this data structure.
	 *
	 * @param dataTypeId the data type ID of this data structure
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the primary key of this data structure.
	 *
	 * @param primaryKey the primary key of this data structure
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the structure of this data structure.
	 *
	 * @param structure the structure of this data structure
	 */
	@Override
	public void setStructure(String structure) {
		model.setStructure(structure);
	}

	/**
	 * Sets the version of this data structure.
	 *
	 * @param version the version of this data structure
	 */
	@Override
	public void setVersion(String version) {
		model.setVersion(version);
	}

	@Override
	protected DataStructureWrapper wrap(DataStructure dataStructure) {
		return new DataStructureWrapper(dataStructure);
	}

}