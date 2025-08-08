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
 * This class is a wrapper for {@link TypeVisualizerLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TypeVisualizerLink
 * @generated
 */
public class TypeVisualizerLinkWrapper
	extends BaseModelWrapper<TypeVisualizerLink>
	implements ModelWrapper<TypeVisualizerLink>, TypeVisualizerLink {

	public TypeVisualizerLinkWrapper(TypeVisualizerLink typeVisualizerLink) {
		super(typeVisualizerLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("typeVisualizerLinkId", getTypeVisualizerLinkId());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("dataType", getDataType());
		attributes.put("visualizerId", getVisualizerId());
		attributes.put("visualizer", getVisualizer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long typeVisualizerLinkId = (Long)attributes.get(
			"typeVisualizerLinkId");

		if (typeVisualizerLinkId != null) {
			setTypeVisualizerLinkId(typeVisualizerLinkId);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		Long dataType = (Long)attributes.get("dataType");

		if (dataType != null) {
			setDataType(dataType);
		}

		Long visualizerId = (Long)attributes.get("visualizerId");

		if (visualizerId != null) {
			setVisualizerId(visualizerId);
		}

		String visualizer = (String)attributes.get("visualizer");

		if (visualizer != null) {
			setVisualizer(visualizer);
		}
	}

	/**
	 * Returns the data type of this type visualizer link.
	 *
	 * @return the data type of this type visualizer link
	 */
	@Override
	public long getDataType() {
		return model.getDataType();
	}

	/**
	 * Returns the data type ID of this type visualizer link.
	 *
	 * @return the data type ID of this type visualizer link
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the primary key of this type visualizer link.
	 *
	 * @return the primary key of this type visualizer link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type visualizer link ID of this type visualizer link.
	 *
	 * @return the type visualizer link ID of this type visualizer link
	 */
	@Override
	public long getTypeVisualizerLinkId() {
		return model.getTypeVisualizerLinkId();
	}

	/**
	 * Returns the visualizer of this type visualizer link.
	 *
	 * @return the visualizer of this type visualizer link
	 */
	@Override
	public String getVisualizer() {
		return model.getVisualizer();
	}

	/**
	 * Returns the visualizer ID of this type visualizer link.
	 *
	 * @return the visualizer ID of this type visualizer link
	 */
	@Override
	public long getVisualizerId() {
		return model.getVisualizerId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data type of this type visualizer link.
	 *
	 * @param dataType the data type of this type visualizer link
	 */
	@Override
	public void setDataType(long dataType) {
		model.setDataType(dataType);
	}

	/**
	 * Sets the data type ID of this type visualizer link.
	 *
	 * @param dataTypeId the data type ID of this type visualizer link
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the primary key of this type visualizer link.
	 *
	 * @param primaryKey the primary key of this type visualizer link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type visualizer link ID of this type visualizer link.
	 *
	 * @param typeVisualizerLinkId the type visualizer link ID of this type visualizer link
	 */
	@Override
	public void setTypeVisualizerLinkId(long typeVisualizerLinkId) {
		model.setTypeVisualizerLinkId(typeVisualizerLinkId);
	}

	/**
	 * Sets the visualizer of this type visualizer link.
	 *
	 * @param visualizer the visualizer of this type visualizer link
	 */
	@Override
	public void setVisualizer(String visualizer) {
		model.setVisualizer(visualizer);
	}

	/**
	 * Sets the visualizer ID of this type visualizer link.
	 *
	 * @param visualizerId the visualizer ID of this type visualizer link
	 */
	@Override
	public void setVisualizerId(long visualizerId) {
		model.setVisualizerId(visualizerId);
	}

	@Override
	protected TypeVisualizerLinkWrapper wrap(
		TypeVisualizerLink typeVisualizerLink) {

		return new TypeVisualizerLinkWrapper(typeVisualizerLink);
	}

}