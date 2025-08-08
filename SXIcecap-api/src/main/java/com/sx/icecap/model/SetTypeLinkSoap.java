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
public class SetTypeLinkSoap implements Serializable {

	public static SetTypeLinkSoap toSoapModel(SetTypeLink model) {
		SetTypeLinkSoap soapModel = new SetTypeLinkSoap();

		soapModel.setSetTypeLinkId(model.getSetTypeLinkId());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setDataSet(model.getDataSet());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setDataType(model.getDataType());

		return soapModel;
	}

	public static SetTypeLinkSoap[] toSoapModels(SetTypeLink[] models) {
		SetTypeLinkSoap[] soapModels = new SetTypeLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SetTypeLinkSoap[][] toSoapModels(SetTypeLink[][] models) {
		SetTypeLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SetTypeLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SetTypeLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SetTypeLinkSoap[] toSoapModels(List<SetTypeLink> models) {
		List<SetTypeLinkSoap> soapModels = new ArrayList<SetTypeLinkSoap>(
			models.size());

		for (SetTypeLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SetTypeLinkSoap[soapModels.size()]);
	}

	public SetTypeLinkSoap() {
	}

	public long getPrimaryKey() {
		return _setTypeLinkId;
	}

	public void setPrimaryKey(long pk) {
		setSetTypeLinkId(pk);
	}

	public long getSetTypeLinkId() {
		return _setTypeLinkId;
	}

	public void setSetTypeLinkId(long setTypeLinkId) {
		_setTypeLinkId = setTypeLinkId;
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

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public String getDataType() {
		return _dataType;
	}

	public void setDataType(String dataType) {
		_dataType = dataType;
	}

	private long _setTypeLinkId;
	private long _dataSetId;
	private long _dataSet;
	private long _dataTypeId;
	private String _dataType;

}