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
 * This class is a wrapper for {@link TypeParamLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TypeParamLink
 * @generated
 */
public class TypeParamLinkWrapper
	extends BaseModelWrapper<TypeParamLink>
	implements ModelWrapper<TypeParamLink>, TypeParamLink {

	public TypeParamLinkWrapper(TypeParamLink typeParamLink) {
		super(typeParamLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("typeParamLinkId", getTypeParamLinkId());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("dataType", getDataType());
		attributes.put("paramId", getParamId());
		attributes.put("param", getParam());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long typeParamLinkId = (Long)attributes.get("typeParamLinkId");

		if (typeParamLinkId != null) {
			setTypeParamLinkId(typeParamLinkId);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		Long dataType = (Long)attributes.get("dataType");

		if (dataType != null) {
			setDataType(dataType);
		}

		Long paramId = (Long)attributes.get("paramId");

		if (paramId != null) {
			setParamId(paramId);
		}

		String param = (String)attributes.get("param");

		if (param != null) {
			setParam(param);
		}
	}

	/**
	 * Returns the data type of this type param link.
	 *
	 * @return the data type of this type param link
	 */
	@Override
	public long getDataType() {
		return model.getDataType();
	}

	/**
	 * Returns the data type ID of this type param link.
	 *
	 * @return the data type ID of this type param link
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the param of this type param link.
	 *
	 * @return the param of this type param link
	 */
	@Override
	public String getParam() {
		return model.getParam();
	}

	/**
	 * Returns the param ID of this type param link.
	 *
	 * @return the param ID of this type param link
	 */
	@Override
	public long getParamId() {
		return model.getParamId();
	}

	/**
	 * Returns the primary key of this type param link.
	 *
	 * @return the primary key of this type param link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type param link ID of this type param link.
	 *
	 * @return the type param link ID of this type param link
	 */
	@Override
	public long getTypeParamLinkId() {
		return model.getTypeParamLinkId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data type of this type param link.
	 *
	 * @param dataType the data type of this type param link
	 */
	@Override
	public void setDataType(long dataType) {
		model.setDataType(dataType);
	}

	/**
	 * Sets the data type ID of this type param link.
	 *
	 * @param dataTypeId the data type ID of this type param link
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the param of this type param link.
	 *
	 * @param param the param of this type param link
	 */
	@Override
	public void setParam(String param) {
		model.setParam(param);
	}

	/**
	 * Sets the param ID of this type param link.
	 *
	 * @param paramId the param ID of this type param link
	 */
	@Override
	public void setParamId(long paramId) {
		model.setParamId(paramId);
	}

	/**
	 * Sets the primary key of this type param link.
	 *
	 * @param primaryKey the primary key of this type param link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type param link ID of this type param link.
	 *
	 * @param typeParamLinkId the type param link ID of this type param link
	 */
	@Override
	public void setTypeParamLinkId(long typeParamLinkId) {
		model.setTypeParamLinkId(typeParamLinkId);
	}

	@Override
	protected TypeParamLinkWrapper wrap(TypeParamLink typeParamLink) {
		return new TypeParamLinkWrapper(typeParamLink);
	}

}