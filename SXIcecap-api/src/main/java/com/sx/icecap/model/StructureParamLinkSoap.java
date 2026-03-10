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
public class StructureParamLinkSoap implements Serializable {

	public static StructureParamLinkSoap toSoapModel(StructureParamLink model) {
		StructureParamLinkSoap soapModel = new StructureParamLinkSoap();

		soapModel.setStructureParamLinkId(model.getStructureParamLinkId());
		soapModel.setDataStructureId(model.getDataStructureId());
		soapModel.setParameterId(model.getParameterId());
		soapModel.setOrder(model.getOrder());

		return soapModel;
	}

	public static StructureParamLinkSoap[] toSoapModels(
		StructureParamLink[] models) {

		StructureParamLinkSoap[] soapModels =
			new StructureParamLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StructureParamLinkSoap[][] toSoapModels(
		StructureParamLink[][] models) {

		StructureParamLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StructureParamLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StructureParamLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StructureParamLinkSoap[] toSoapModels(
		List<StructureParamLink> models) {

		List<StructureParamLinkSoap> soapModels =
			new ArrayList<StructureParamLinkSoap>(models.size());

		for (StructureParamLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new StructureParamLinkSoap[soapModels.size()]);
	}

	public StructureParamLinkSoap() {
	}

	public long getPrimaryKey() {
		return _structureParamLinkId;
	}

	public void setPrimaryKey(long pk) {
		setStructureParamLinkId(pk);
	}

	public long getStructureParamLinkId() {
		return _structureParamLinkId;
	}

	public void setStructureParamLinkId(long structureParamLinkId) {
		_structureParamLinkId = structureParamLinkId;
	}

	public long getDataStructureId() {
		return _dataStructureId;
	}

	public void setDataStructureId(long dataStructureId) {
		_dataStructureId = dataStructureId;
	}

	public long getParameterId() {
		return _parameterId;
	}

	public void setParameterId(long parameterId) {
		_parameterId = parameterId;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	private long _structureParamLinkId;
	private long _dataStructureId;
	private long _parameterId;
	private int _order;

}