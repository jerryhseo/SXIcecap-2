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
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("freezed", isFreezed());
		attributes.put("verified", isVerified());

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

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		Boolean freezed = (Boolean)attributes.get("freezed");

		if (freezed != null) {
			setFreezed(freezed);
		}

		Boolean verified = (Boolean)attributes.get("verified");

		if (verified != null) {
			setVerified(verified);
		}
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
	 * Returns the data type ID of this set type link.
	 *
	 * @return the data type ID of this set type link
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the freezed of this set type link.
	 *
	 * @return the freezed of this set type link
	 */
	@Override
	public boolean getFreezed() {
		return model.getFreezed();
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

	/**
	 * Returns the verified of this set type link.
	 *
	 * @return the verified of this set type link
	 */
	@Override
	public boolean getVerified() {
		return model.getVerified();
	}

	/**
	 * Returns <code>true</code> if this set type link is freezed.
	 *
	 * @return <code>true</code> if this set type link is freezed; <code>false</code> otherwise
	 */
	@Override
	public boolean isFreezed() {
		return model.isFreezed();
	}

	/**
	 * Returns <code>true</code> if this set type link is verified.
	 *
	 * @return <code>true</code> if this set type link is verified; <code>false</code> otherwise
	 */
	@Override
	public boolean isVerified() {
		return model.isVerified();
	}

	@Override
	public void persist() {
		model.persist();
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
	 * Sets the data type ID of this set type link.
	 *
	 * @param dataTypeId the data type ID of this set type link
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets whether this set type link is freezed.
	 *
	 * @param freezed the freezed of this set type link
	 */
	@Override
	public void setFreezed(boolean freezed) {
		model.setFreezed(freezed);
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

	/**
	 * Sets whether this set type link is verified.
	 *
	 * @param verified the verified of this set type link
	 */
	@Override
	public void setVerified(boolean verified) {
		model.setVerified(verified);
	}

	@Override
	protected SetTypeLinkWrapper wrap(SetTypeLink setTypeLink) {
		return new SetTypeLinkWrapper(setTypeLink);
	}

}