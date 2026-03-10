/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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
public class DataTypeStructureSoap implements Serializable {

	public static DataTypeStructureSoap toSoapModel(DataTypeStructure model) {
		DataTypeStructureSoap soapModel = new DataTypeStructureSoap();

		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setStructure(model.getStructure());

		return soapModel;
	}

	public static DataTypeStructureSoap[] toSoapModels(
		DataTypeStructure[] models) {

		DataTypeStructureSoap[] soapModels =
			new DataTypeStructureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataTypeStructureSoap[][] toSoapModels(
		DataTypeStructure[][] models) {

		DataTypeStructureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DataTypeStructureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataTypeStructureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataTypeStructureSoap[] toSoapModels(
		List<DataTypeStructure> models) {

		List<DataTypeStructureSoap> soapModels =
			new ArrayList<DataTypeStructureSoap>(models.size());

		for (DataTypeStructure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataTypeStructureSoap[soapModels.size()]);
	}

	public DataTypeStructureSoap() {
	}

	public long getPrimaryKey() {
		return _dataTypeId;
	}

	public void setPrimaryKey(long pk) {
		setDataTypeId(pk);
	}

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public String getStructure() {
		return _structure;
	}

	public void setStructure(String structure) {
		_structure = structure;
	}

	private long _dataTypeId;
	private String _structure;

}