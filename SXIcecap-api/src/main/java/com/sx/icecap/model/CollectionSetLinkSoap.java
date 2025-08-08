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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CollectionSetLinkSoap implements Serializable {

	public static CollectionSetLinkSoap toSoapModel(CollectionSetLink model) {
		CollectionSetLinkSoap soapModel = new CollectionSetLinkSoap();

		soapModel.setCollectionSetLinkId(model.getCollectionSetLinkId());
		soapModel.setDataCollectionId(model.getDataCollectionId());
		soapModel.setDataCollection(model.getDataCollection());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setDataSet(model.getDataSet());

		return soapModel;
	}

	public static CollectionSetLinkSoap[] toSoapModels(
		CollectionSetLink[] models) {

		CollectionSetLinkSoap[] soapModels =
			new CollectionSetLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CollectionSetLinkSoap[][] toSoapModels(
		CollectionSetLink[][] models) {

		CollectionSetLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CollectionSetLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CollectionSetLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CollectionSetLinkSoap[] toSoapModels(
		List<CollectionSetLink> models) {

		List<CollectionSetLinkSoap> soapModels =
			new ArrayList<CollectionSetLinkSoap>(models.size());

		for (CollectionSetLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CollectionSetLinkSoap[soapModels.size()]);
	}

	public CollectionSetLinkSoap() {
	}

	public long getPrimaryKey() {
		return _collectionSetLinkId;
	}

	public void setPrimaryKey(long pk) {
		setCollectionSetLinkId(pk);
	}

	public long getCollectionSetLinkId() {
		return _collectionSetLinkId;
	}

	public void setCollectionSetLinkId(long collectionSetLinkId) {
		_collectionSetLinkId = collectionSetLinkId;
	}

	public long getDataCollectionId() {
		return _dataCollectionId;
	}

	public void setDataCollectionId(long dataCollectionId) {
		_dataCollectionId = dataCollectionId;
	}

	public long getDataCollection() {
		return _dataCollection;
	}

	public void setDataCollection(long dataCollection) {
		_dataCollection = dataCollection;
	}

	public long getDataSetId() {
		return _dataSetId;
	}

	public void setDataSetId(long dataSetId) {
		_dataSetId = dataSetId;
	}

	public long getDataSet() {
		return _dataSet;
	}

	public void setDataSet(long dataSet) {
		_dataSet = dataSet;
	}

	private long _collectionSetLinkId;
	private long _dataCollectionId;
	private long _dataCollection;
	private long _dataSetId;
	private long _dataSet;

}