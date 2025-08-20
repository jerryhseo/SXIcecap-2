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
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setFreezed(model.isFreezed());
		soapModel.setVerified(model.isVerified());

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

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public boolean getFreezed() {
		return _freezed;
	}

	public boolean isFreezed() {
		return _freezed;
	}

	public void setFreezed(boolean freezed) {
		_freezed = freezed;
	}

	public boolean getVerified() {
		return _verified;
	}

	public boolean isVerified() {
		return _verified;
	}

	public void setVerified(boolean verified) {
		_verified = verified;
	}

	private long _setTypeLinkId;
	private long _dataSetId;
	private long _dataTypeId;
	private boolean _freezed;
	private boolean _verified;

}