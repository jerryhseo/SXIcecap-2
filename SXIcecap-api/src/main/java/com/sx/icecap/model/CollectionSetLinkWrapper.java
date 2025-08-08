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
		attributes.put("dataCollection", getDataCollection());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("dataSet", getDataSet());

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

		Long dataCollection = (Long)attributes.get("dataCollection");

		if (dataCollection != null) {
			setDataCollection(dataCollection);
		}

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
		}

		Long dataSet = (Long)attributes.get("dataSet");

		if (dataSet != null) {
			setDataSet(dataSet);
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
	 * Returns the data collection of this collection set link.
	 *
	 * @return the data collection of this collection set link
	 */
	@Override
	public long getDataCollection() {
		return model.getDataCollection();
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
	 * Returns the data set of this collection set link.
	 *
	 * @return the data set of this collection set link
	 */
	@Override
	public long getDataSet() {
		return model.getDataSet();
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
	 * Returns the primary key of this collection set link.
	 *
	 * @return the primary key of this collection set link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
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
	 * Sets the data collection of this collection set link.
	 *
	 * @param dataCollection the data collection of this collection set link
	 */
	@Override
	public void setDataCollection(long dataCollection) {
		model.setDataCollection(dataCollection);
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
	 * Sets the data set of this collection set link.
	 *
	 * @param dataSet the data set of this collection set link
	 */
	@Override
	public void setDataSet(long dataSet) {
		model.setDataSet(dataSet);
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
	 * Sets the primary key of this collection set link.
	 *
	 * @param primaryKey the primary key of this collection set link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CollectionSetLinkWrapper wrap(
		CollectionSetLink collectionSetLink) {

		return new CollectionSetLinkWrapper(collectionSetLink);
	}

}