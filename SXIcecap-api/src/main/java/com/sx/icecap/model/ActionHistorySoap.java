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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActionHistorySoap implements Serializable {

	public static ActionHistorySoap toSoapModel(ActionHistory model) {
		ActionHistorySoap soapModel = new ActionHistorySoap();

		soapModel.setActionHistoryId(model.getActionHistoryId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setStructuredDataId(model.getStructuredDataId());
		soapModel.setParamCode(model.getParamCode());
		soapModel.setPrevValue(model.getPrevValue());
		soapModel.setChangedValue(model.getChangedValue());
		soapModel.setAction(model.getAction());
		soapModel.setComment(model.getComment());

		return soapModel;
	}

	public static ActionHistorySoap[] toSoapModels(ActionHistory[] models) {
		ActionHistorySoap[] soapModels = new ActionHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ActionHistorySoap[][] toSoapModels(ActionHistory[][] models) {
		ActionHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ActionHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ActionHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ActionHistorySoap[] toSoapModels(List<ActionHistory> models) {
		List<ActionHistorySoap> soapModels = new ArrayList<ActionHistorySoap>(
			models.size());

		for (ActionHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ActionHistorySoap[soapModels.size()]);
	}

	public ActionHistorySoap() {
	}

	public long getPrimaryKey() {
		return _actionHistoryId;
	}

	public void setPrimaryKey(long pk) {
		setActionHistoryId(pk);
	}

	public long getActionHistoryId() {
		return _actionHistoryId;
	}

	public void setActionHistoryId(long actionHistoryId) {
		_actionHistoryId = actionHistoryId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getStructuredDataId() {
		return _structuredDataId;
	}

	public void setStructuredDataId(long structuredDataId) {
		_structuredDataId = structuredDataId;
	}

	public String getParamCode() {
		return _paramCode;
	}

	public void setParamCode(String paramCode) {
		_paramCode = paramCode;
	}

	public String getPrevValue() {
		return _prevValue;
	}

	public void setPrevValue(String prevValue) {
		_prevValue = prevValue;
	}

	public String getChangedValue() {
		return _changedValue;
	}

	public void setChangedValue(String changedValue) {
		_changedValue = changedValue;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	private long _actionHistoryId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _structuredDataId;
	private String _paramCode;
	private String _prevValue;
	private String _changedValue;
	private String _action;
	private String _comment;

}