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
public class DataStructureSoap implements Serializable {

	public static DataStructureSoap toSoapModel(DataStructure model) {
		DataStructureSoap soapModel = new DataStructureSoap();

		soapModel.setDataStructureId(model.getDataStructureId());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setVersion(model.getVersion());
		soapModel.setStructure(model.getStructure());

		return soapModel;
	}

	public static DataStructureSoap[] toSoapModels(DataStructure[] models) {
		DataStructureSoap[] soapModels = new DataStructureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataStructureSoap[][] toSoapModels(DataStructure[][] models) {
		DataStructureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataStructureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataStructureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataStructureSoap[] toSoapModels(List<DataStructure> models) {
		List<DataStructureSoap> soapModels = new ArrayList<DataStructureSoap>(
			models.size());

		for (DataStructure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataStructureSoap[soapModels.size()]);
	}

	public DataStructureSoap() {
	}

	public long getPrimaryKey() {
		return _dataStructureId;
	}

	public void setPrimaryKey(long pk) {
		setDataStructureId(pk);
	}

	public long getDataStructureId() {
		return _dataStructureId;
	}

	public void setDataStructureId(long dataStructureId) {
		_dataStructureId = dataStructureId;
	}

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public String getStructure() {
		return _structure;
	}

	public void setStructure(String structure) {
		_structure = structure;
	}

	private long _dataStructureId;
	private long _dataTypeId;
	private String _version;
	private String _structure;

}