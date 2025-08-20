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
 * This class is used by SOAP remote services, specifically {@link com.sx.icecap.service.http.TypeVisualizerLinkServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TypeVisualizerLinkSoap implements Serializable {

	public static TypeVisualizerLinkSoap toSoapModel(TypeVisualizerLink model) {
		TypeVisualizerLinkSoap soapModel = new TypeVisualizerLinkSoap();

		soapModel.setTypeVisualizerLinkId(model.getTypeVisualizerLinkId());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setVisualizerId(model.getVisualizerId());

		return soapModel;
	}

	public static TypeVisualizerLinkSoap[] toSoapModels(
		TypeVisualizerLink[] models) {

		TypeVisualizerLinkSoap[] soapModels =
			new TypeVisualizerLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TypeVisualizerLinkSoap[][] toSoapModels(
		TypeVisualizerLink[][] models) {

		TypeVisualizerLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TypeVisualizerLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TypeVisualizerLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TypeVisualizerLinkSoap[] toSoapModels(
		List<TypeVisualizerLink> models) {

		List<TypeVisualizerLinkSoap> soapModels =
			new ArrayList<TypeVisualizerLinkSoap>(models.size());

		for (TypeVisualizerLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TypeVisualizerLinkSoap[soapModels.size()]);
	}

	public TypeVisualizerLinkSoap() {
	}

	public long getPrimaryKey() {
		return _typeVisualizerLinkId;
	}

	public void setPrimaryKey(long pk) {
		setTypeVisualizerLinkId(pk);
	}

	public long getTypeVisualizerLinkId() {
		return _typeVisualizerLinkId;
	}

	public void setTypeVisualizerLinkId(long typeVisualizerLinkId) {
		_typeVisualizerLinkId = typeVisualizerLinkId;
	}

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public long getVisualizerId() {
		return _visualizerId;
	}

	public void setVisualizerId(long visualizerId) {
		_visualizerId = visualizerId;
	}

	private long _typeVisualizerLinkId;
	private long _dataTypeId;
	private long _visualizerId;

}