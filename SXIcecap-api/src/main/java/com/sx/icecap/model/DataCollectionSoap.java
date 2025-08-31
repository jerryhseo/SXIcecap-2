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
 * This class is used by SOAP remote services, specifically {@link com.sx.icecap.service.http.DataCollectionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataCollectionSoap implements Serializable {

	public static DataCollectionSoap toSoapModel(DataCollection model) {
		DataCollectionSoap soapModel = new DataCollectionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDataCollectionId(model.getDataCollectionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLastPublishDate(model.getLastPublishDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setDataCollectionCode(model.getDataCollectionCode());
		soapModel.setDataCollectionVersion(model.getDataCollectionVersion());
		soapModel.setDisplayName(model.getDisplayName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static DataCollectionSoap[] toSoapModels(DataCollection[] models) {
		DataCollectionSoap[] soapModels = new DataCollectionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataCollectionSoap[][] toSoapModels(
		DataCollection[][] models) {

		DataCollectionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DataCollectionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataCollectionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataCollectionSoap[] toSoapModels(
		List<DataCollection> models) {

		List<DataCollectionSoap> soapModels = new ArrayList<DataCollectionSoap>(
			models.size());

		for (DataCollection model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataCollectionSoap[soapModels.size()]);
	}

	public DataCollectionSoap() {
	}

	public long getPrimaryKey() {
		return _dataCollectionId;
	}

	public void setPrimaryKey(long pk) {
		setDataCollectionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDataCollectionId() {
		return _dataCollectionId;
	}

	public void setDataCollectionId(long dataCollectionId) {
		_dataCollectionId = dataCollectionId;
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

	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
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

	public String getDataCollectionCode() {
		return _dataCollectionCode;
	}

	public void setDataCollectionCode(String dataCollectionCode) {
		_dataCollectionCode = dataCollectionCode;
	}

	public String getDataCollectionVersion() {
		return _dataCollectionVersion;
	}

	public void setDataCollectionVersion(String dataCollectionVersion) {
		_dataCollectionVersion = dataCollectionVersion;
	}

	public String getDisplayName() {
		return _displayName;
	}

	public void setDisplayName(String displayName) {
		_displayName = displayName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _uuid;
	private long _dataCollectionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _lastPublishDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _dataCollectionCode;
	private String _dataCollectionVersion;
	private String _displayName;
	private String _description;

}