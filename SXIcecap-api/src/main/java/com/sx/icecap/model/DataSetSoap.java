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
public class DataSetSoap implements Serializable {

	public static DataSetSoap toSoapModel(DataSet model) {
		DataSetSoap soapModel = new DataSetSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLastPublishDate(model.getLastPublishDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setDataSetName(model.getDataSetName());
		soapModel.setDataSetVersion(model.getDataSetVersion());
		soapModel.setDisplayName(model.getDisplayName());
		soapModel.setDescription(model.getDescription());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setStructure(model.getStructure());
		soapModel.setVerificationType(model.getVerificationType());
		soapModel.setMultiEntryLevel(model.getMultiEntryLevel());

		return soapModel;
	}

	public static DataSetSoap[] toSoapModels(DataSet[] models) {
		DataSetSoap[] soapModels = new DataSetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataSetSoap[][] toSoapModels(DataSet[][] models) {
		DataSetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataSetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataSetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataSetSoap[] toSoapModels(List<DataSet> models) {
		List<DataSetSoap> soapModels = new ArrayList<DataSetSoap>(
			models.size());

		for (DataSet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataSetSoap[soapModels.size()]);
	}

	public DataSetSoap() {
	}

	public long getPrimaryKey() {
		return _dataSetId;
	}

	public void setPrimaryKey(long pk) {
		setDataSetId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDataSetId() {
		return _dataSetId;
	}

	public void setDataSetId(long dataSetId) {
		_dataSetId = dataSetId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getDataSetName() {
		return _dataSetName;
	}

	public void setDataSetName(String dataSetName) {
		_dataSetName = dataSetName;
	}

	public String getDataSetVersion() {
		return _dataSetVersion;
	}

	public void setDataSetVersion(String dataSetVersion) {
		_dataSetVersion = dataSetVersion;
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

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public String getStructure() {
		return _structure;
	}

	public void setStructure(String structure) {
		_structure = structure;
	}

	public String getVerificationType() {
		return _verificationType;
	}

	public void setVerificationType(String verificationType) {
		_verificationType = verificationType;
	}

	public int getMultiEntryLevel() {
		return _multiEntryLevel;
	}

	public void setMultiEntryLevel(int multiEntryLevel) {
		_multiEntryLevel = multiEntryLevel;
	}

	private String _uuid;
	private long _dataSetId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _lastPublishDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _dataSetName;
	private String _dataSetVersion;
	private String _displayName;
	private String _description;
	private long _folderId;
	private String _structure;
	private String _verificationType;
	private int _multiEntryLevel;

}