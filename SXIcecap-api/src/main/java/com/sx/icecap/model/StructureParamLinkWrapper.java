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
 * This class is a wrapper for {@link StructureParamLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StructureParamLink
 * @generated
 */
public class StructureParamLinkWrapper
	extends BaseModelWrapper<StructureParamLink>
	implements ModelWrapper<StructureParamLink>, StructureParamLink {

	public StructureParamLinkWrapper(StructureParamLink structureParamLink) {
		super(structureParamLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("structureParamLinkId", getStructureParamLinkId());
		attributes.put("dataStructureId", getDataStructureId());
		attributes.put("parameterId", getParameterId());
		attributes.put("order", getOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long structureParamLinkId = (Long)attributes.get(
			"structureParamLinkId");

		if (structureParamLinkId != null) {
			setStructureParamLinkId(structureParamLinkId);
		}

		Long dataStructureId = (Long)attributes.get("dataStructureId");

		if (dataStructureId != null) {
			setDataStructureId(dataStructureId);
		}

		Long parameterId = (Long)attributes.get("parameterId");

		if (parameterId != null) {
			setParameterId(parameterId);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}
	}

	/**
	 * Returns the data structure ID of this structure param link.
	 *
	 * @return the data structure ID of this structure param link
	 */
	@Override
	public long getDataStructureId() {
		return model.getDataStructureId();
	}

	/**
	 * Returns the order of this structure param link.
	 *
	 * @return the order of this structure param link
	 */
	@Override
	public int getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the parameter ID of this structure param link.
	 *
	 * @return the parameter ID of this structure param link
	 */
	@Override
	public long getParameterId() {
		return model.getParameterId();
	}

	/**
	 * Returns the primary key of this structure param link.
	 *
	 * @return the primary key of this structure param link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the structure param link ID of this structure param link.
	 *
	 * @return the structure param link ID of this structure param link
	 */
	@Override
	public long getStructureParamLinkId() {
		return model.getStructureParamLinkId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data structure ID of this structure param link.
	 *
	 * @param dataStructureId the data structure ID of this structure param link
	 */
	@Override
	public void setDataStructureId(long dataStructureId) {
		model.setDataStructureId(dataStructureId);
	}

	/**
	 * Sets the order of this structure param link.
	 *
	 * @param order the order of this structure param link
	 */
	@Override
	public void setOrder(int order) {
		model.setOrder(order);
	}

	/**
	 * Sets the parameter ID of this structure param link.
	 *
	 * @param parameterId the parameter ID of this structure param link
	 */
	@Override
	public void setParameterId(long parameterId) {
		model.setParameterId(parameterId);
	}

	/**
	 * Sets the primary key of this structure param link.
	 *
	 * @param primaryKey the primary key of this structure param link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the structure param link ID of this structure param link.
	 *
	 * @param structureParamLinkId the structure param link ID of this structure param link
	 */
	@Override
	public void setStructureParamLinkId(long structureParamLinkId) {
		model.setStructureParamLinkId(structureParamLinkId);
	}

	@Override
	protected StructureParamLinkWrapper wrap(
		StructureParamLink structureParamLink) {

		return new StructureParamLinkWrapper(structureParamLink);
	}

}