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
public class DisverifiedDataSoap implements Serializable {

	public static DisverifiedDataSoap toSoapModel(DisverifiedData model) {
		DisverifiedDataSoap soapModel = new DisverifiedDataSoap();

		soapModel.setDisverifiedDataId(model.getDisverifiedDataId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setTempDataTitle(model.getTempDataTitle());
		soapModel.setDataSetDisplayName(model.getDataSetDisplayName());
		soapModel.setDataTypeDisplayName(model.getDataTypeDisplayName());
		soapModel.setFolderName(model.getFolderName());
		soapModel.setStructuredData(model.getStructuredData());

		return soapModel;
	}

	public static DisverifiedDataSoap[] toSoapModels(DisverifiedData[] models) {
		DisverifiedDataSoap[] soapModels =
			new DisverifiedDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DisverifiedDataSoap[][] toSoapModels(
		DisverifiedData[][] models) {

		DisverifiedDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DisverifiedDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DisverifiedDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DisverifiedDataSoap[] toSoapModels(
		List<DisverifiedData> models) {

		List<DisverifiedDataSoap> soapModels =
			new ArrayList<DisverifiedDataSoap>(models.size());

		for (DisverifiedData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DisverifiedDataSoap[soapModels.size()]);
	}

	public DisverifiedDataSoap() {
	}

	public long getPrimaryKey() {
		return _disverifiedDataId;
	}

	public void setPrimaryKey(long pk) {
		setDisverifiedDataId(pk);
	}

	public long getDisverifiedDataId() {
		return _disverifiedDataId;
	}

	public void setDisverifiedDataId(long disverifiedDataId) {
		_disverifiedDataId = disverifiedDataId;
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

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public String getTempDataTitle() {
		return _tempDataTitle;
	}

	public void setTempDataTitle(String tempDataTitle) {
		_tempDataTitle = tempDataTitle;
	}

	public String getDataSetDisplayName() {
		return _dataSetDisplayName;
	}

	public void setDataSetDisplayName(String dataSetDisplayName) {
		_dataSetDisplayName = dataSetDisplayName;
	}

	public String getDataTypeDisplayName() {
		return _dataTypeDisplayName;
	}

	public void setDataTypeDisplayName(String dataTypeDisplayName) {
		_dataTypeDisplayName = dataTypeDisplayName;
	}

	public String getFolderName() {
		return _folderName;
	}

	public void setFolderName(String folderName) {
		_folderName = folderName;
	}

	public String getStructuredData() {
		return _structuredData;
	}

	public void setStructuredData(String structuredData) {
		_structuredData = structuredData;
	}

	private long _disverifiedDataId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _dataSetId;
	private long _dataTypeId;
	private long _folderId;
	private String _tempDataTitle;
	private String _dataSetDisplayName;
	private String _dataTypeDisplayName;
	private String _folderName;
	private String _structuredData;

}