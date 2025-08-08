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
public class TypeParamLinkSoap implements Serializable {

	public static TypeParamLinkSoap toSoapModel(TypeParamLink model) {
		TypeParamLinkSoap soapModel = new TypeParamLinkSoap();

		soapModel.setTypeParamLinkId(model.getTypeParamLinkId());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setDataType(model.getDataType());
		soapModel.setParamId(model.getParamId());
		soapModel.setParam(model.getParam());

		return soapModel;
	}

	public static TypeParamLinkSoap[] toSoapModels(TypeParamLink[] models) {
		TypeParamLinkSoap[] soapModels = new TypeParamLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TypeParamLinkSoap[][] toSoapModels(TypeParamLink[][] models) {
		TypeParamLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TypeParamLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TypeParamLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TypeParamLinkSoap[] toSoapModels(List<TypeParamLink> models) {
		List<TypeParamLinkSoap> soapModels = new ArrayList<TypeParamLinkSoap>(
			models.size());

		for (TypeParamLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TypeParamLinkSoap[soapModels.size()]);
	}

	public TypeParamLinkSoap() {
	}

	public long getPrimaryKey() {
		return _typeParamLinkId;
	}

	public void setPrimaryKey(long pk) {
		setTypeParamLinkId(pk);
	}

	public long getTypeParamLinkId() {
		return _typeParamLinkId;
	}

	public void setTypeParamLinkId(long typeParamLinkId) {
		_typeParamLinkId = typeParamLinkId;
	}

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public long getDataType() {
		return _dataType;
	}

	public void setDataType(long dataType) {
		_dataType = dataType;
	}

	public long getParamId() {
		return _paramId;
	}

	public void setParamId(long paramId) {
		_paramId = paramId;
	}

	public String getParam() {
		return _param;
	}

	public void setParam(String param) {
		_param = param;
	}

	private long _typeParamLinkId;
	private long _dataTypeId;
	private long _dataType;
	private long _paramId;
	private String _param;

}