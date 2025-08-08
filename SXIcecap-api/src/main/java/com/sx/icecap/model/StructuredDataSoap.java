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
public class StructuredDataSoap implements Serializable {

	public static StructuredDataSoap toSoapModel(StructuredData model) {
		StructuredDataSoap soapModel = new StructuredDataSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setStructuredDataId(model.getStructuredDataId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setDataCollectionId(model.getDataCollectionId());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setMultiple(model.isMultiple());
		soapModel.setStartIndex(model.getStartIndex());
		soapModel.setCount(model.getCount());
		soapModel.setFreezed(model.isFreezed());
		soapModel.setVerified(model.isVerified());
		soapModel.setComments(model.isComments());
		soapModel.setHistory(model.isHistory());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static StructuredDataSoap[] toSoapModels(StructuredData[] models) {
		StructuredDataSoap[] soapModels = new StructuredDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StructuredDataSoap[][] toSoapModels(
		StructuredData[][] models) {

		StructuredDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StructuredDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StructuredDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StructuredDataSoap[] toSoapModels(
		List<StructuredData> models) {

		List<StructuredDataSoap> soapModels = new ArrayList<StructuredDataSoap>(
			models.size());

		for (StructuredData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StructuredDataSoap[soapModels.size()]);
	}

	public StructuredDataSoap() {
	}

	public long getPrimaryKey() {
		return _structuredDataId;
	}

	public void setPrimaryKey(long pk) {
		setStructuredDataId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getStructuredDataId() {
		return _structuredDataId;
	}

	public void setStructuredDataId(long structuredDataId) {
		_structuredDataId = structuredDataId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getDataCollectionId() {
		return _dataCollectionId;
	}

	public void setDataCollectionId(long dataCollectionId) {
		_dataCollectionId = dataCollectionId;
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

	public boolean getMultiple() {
		return _multiple;
	}

	public boolean isMultiple() {
		return _multiple;
	}

	public void setMultiple(boolean multiple) {
		_multiple = multiple;
	}

	public long getStartIndex() {
		return _startIndex;
	}

	public void setStartIndex(long startIndex) {
		_startIndex = startIndex;
	}

	public int getCount() {
		return _count;
	}

	public void setCount(int count) {
		_count = count;
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

	public boolean getComments() {
		return _comments;
	}

	public boolean isComments() {
		return _comments;
	}

	public void setComments(boolean comments) {
		_comments = comments;
	}

	public boolean getHistory() {
		return _history;
	}

	public boolean isHistory() {
		return _history;
	}

	public void setHistory(boolean history) {
		_history = history;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	private String _uuid;
	private long _structuredDataId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _dataCollectionId;
	private long _dataSetId;
	private long _dataTypeId;
	private boolean _multiple;
	private long _startIndex;
	private int _count;
	private boolean _freezed;
	private boolean _verified;
	private boolean _comments;
	private boolean _history;
	private String _data;

}