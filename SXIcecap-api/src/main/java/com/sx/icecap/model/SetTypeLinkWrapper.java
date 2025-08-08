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
 * This class is a wrapper for {@link SetTypeLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SetTypeLink
 * @generated
 */
public class SetTypeLinkWrapper
	extends BaseModelWrapper<SetTypeLink>
	implements ModelWrapper<SetTypeLink>, SetTypeLink {

	public SetTypeLinkWrapper(SetTypeLink setTypeLink) {
		super(setTypeLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("setTypeLinkId", getSetTypeLinkId());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("dataSet", getDataSet());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("dataType", getDataType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long setTypeLinkId = (Long)attributes.get("setTypeLinkId");

		if (setTypeLinkId != null) {
			setSetTypeLinkId(setTypeLinkId);
		}

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
		}

		Long dataSet = (Long)attributes.get("dataSet");

		if (dataSet != null) {
			setDataSet(dataSet);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		String dataType = (String)attributes.get("dataType");

		if (dataType != null) {
			setDataType(dataType);
		}
	}

	/**
	 * Returns the data set of this set type link.
	 *
	 * @return the data set of this set type link
	 */
	@Override
	public long getDataSet() {
		return model.getDataSet();
	}

	/**
	 * Returns the data set ID of this set type link.
	 *
	 * @return the data set ID of this set type link
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the data type of this set type link.
	 *
	 * @return the data type of this set type link
	 */
	@Override
	public String getDataType() {
		return model.getDataType();
	}

	/**
	 * Returns the data type ID of this set type link.
	 *
	 * @return the data type ID of this set type link
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the primary key of this set type link.
	 *
	 * @return the primary key of this set type link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the set type link ID of this set type link.
	 *
	 * @return the set type link ID of this set type link
	 */
	@Override
	public long getSetTypeLinkId() {
		return model.getSetTypeLinkId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data set of this set type link.
	 *
	 * @param dataSet the data set of this set type link
	 */
	@Override
	public void setDataSet(long dataSet) {
		model.setDataSet(dataSet);
	}

	/**
	 * Sets the data set ID of this set type link.
	 *
	 * @param dataSetId the data set ID of this set type link
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets the data type of this set type link.
	 *
	 * @param dataType the data type of this set type link
	 */
	@Override
	public void setDataType(String dataType) {
		model.setDataType(dataType);
	}

	/**
	 * Sets the data type ID of this set type link.
	 *
	 * @param dataTypeId the data type ID of this set type link
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the primary key of this set type link.
	 *
	 * @param primaryKey the primary key of this set type link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the set type link ID of this set type link.
	 *
	 * @param setTypeLinkId the set type link ID of this set type link
	 */
	@Override
	public void setSetTypeLinkId(long setTypeLinkId) {
		model.setSetTypeLinkId(setTypeLinkId);
	}

	@Override
	protected SetTypeLinkWrapper wrap(SetTypeLink setTypeLink) {
		return new SetTypeLinkWrapper(setTypeLink);
	}

}