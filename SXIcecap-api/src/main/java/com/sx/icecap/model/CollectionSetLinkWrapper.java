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
 * This class is a wrapper for {@link CollectionSetLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CollectionSetLink
 * @generated
 */
public class CollectionSetLinkWrapper
	extends BaseModelWrapper<CollectionSetLink>
	implements CollectionSetLink, ModelWrapper<CollectionSetLink> {

	public CollectionSetLinkWrapper(CollectionSetLink collectionSetLink) {
		super(collectionSetLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("collectionSetLinkId", getCollectionSetLinkId());
		attributes.put("dataCollectionId", getDataCollectionId());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("freezed", isFreezed());
		attributes.put("verified", isVerified());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long collectionSetLinkId = (Long)attributes.get("collectionSetLinkId");

		if (collectionSetLinkId != null) {
			setCollectionSetLinkId(collectionSetLinkId);
		}

		Long dataCollectionId = (Long)attributes.get("dataCollectionId");

		if (dataCollectionId != null) {
			setDataCollectionId(dataCollectionId);
		}

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
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
	 * Returns the collection set link ID of this collection set link.
	 *
	 * @return the collection set link ID of this collection set link
	 */
	@Override
	public long getCollectionSetLinkId() {
		return model.getCollectionSetLinkId();
	}

	/**
	 * Returns the data collection ID of this collection set link.
	 *
	 * @return the data collection ID of this collection set link
	 */
	@Override
	public long getDataCollectionId() {
		return model.getDataCollectionId();
	}

	/**
	 * Returns the data set ID of this collection set link.
	 *
	 * @return the data set ID of this collection set link
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the freezed of this collection set link.
	 *
	 * @return the freezed of this collection set link
	 */
	@Override
	public boolean getFreezed() {
		return model.getFreezed();
	}

	/**
	 * Returns the primary key of this collection set link.
	 *
	 * @return the primary key of this collection set link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the verified of this collection set link.
	 *
	 * @return the verified of this collection set link
	 */
	@Override
	public boolean getVerified() {
		return model.getVerified();
	}

	/**
	 * Returns <code>true</code> if this collection set link is freezed.
	 *
	 * @return <code>true</code> if this collection set link is freezed; <code>false</code> otherwise
	 */
	@Override
	public boolean isFreezed() {
		return model.isFreezed();
	}

	/**
	 * Returns <code>true</code> if this collection set link is verified.
	 *
	 * @return <code>true</code> if this collection set link is verified; <code>false</code> otherwise
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
	 * Sets the collection set link ID of this collection set link.
	 *
	 * @param collectionSetLinkId the collection set link ID of this collection set link
	 */
	@Override
	public void setCollectionSetLinkId(long collectionSetLinkId) {
		model.setCollectionSetLinkId(collectionSetLinkId);
	}

	/**
	 * Sets the data collection ID of this collection set link.
	 *
	 * @param dataCollectionId the data collection ID of this collection set link
	 */
	@Override
	public void setDataCollectionId(long dataCollectionId) {
		model.setDataCollectionId(dataCollectionId);
	}

	/**
	 * Sets the data set ID of this collection set link.
	 *
	 * @param dataSetId the data set ID of this collection set link
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets whether this collection set link is freezed.
	 *
	 * @param freezed the freezed of this collection set link
	 */
	@Override
	public void setFreezed(boolean freezed) {
		model.setFreezed(freezed);
	}

	/**
	 * Sets the primary key of this collection set link.
	 *
	 * @param primaryKey the primary key of this collection set link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this collection set link is verified.
	 *
	 * @param verified the verified of this collection set link
	 */
	@Override
	public void setVerified(boolean verified) {
		model.setVerified(verified);
	}

	@Override
	protected CollectionSetLinkWrapper wrap(
		CollectionSetLink collectionSetLink) {

		return new CollectionSetLinkWrapper(collectionSetLink);
	}

}