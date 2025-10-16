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
public class DataCommentSoap implements Serializable {

	public static DataCommentSoap toSoapModel(DataComment model) {
		DataCommentSoap soapModel = new DataCommentSoap();

		soapModel.setDataCommentId(model.getDataCommentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCommentModel(model.getCommentModel());
		soapModel.setCommentModelId(model.getCommentModelId());
		soapModel.setParentCommentId(model.getParentCommentId());
		soapModel.setComment(model.getComment());

		return soapModel;
	}

	public static DataCommentSoap[] toSoapModels(DataComment[] models) {
		DataCommentSoap[] soapModels = new DataCommentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataCommentSoap[][] toSoapModels(DataComment[][] models) {
		DataCommentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataCommentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataCommentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataCommentSoap[] toSoapModels(List<DataComment> models) {
		List<DataCommentSoap> soapModels = new ArrayList<DataCommentSoap>(
			models.size());

		for (DataComment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataCommentSoap[soapModels.size()]);
	}

	public DataCommentSoap() {
	}

	public long getPrimaryKey() {
		return _dataCommentId;
	}

	public void setPrimaryKey(long pk) {
		setDataCommentId(pk);
	}

	public long getDataCommentId() {
		return _dataCommentId;
	}

	public void setDataCommentId(long dataCommentId) {
		_dataCommentId = dataCommentId;
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

	public String getCommentModel() {
		return _commentModel;
	}

	public void setCommentModel(String commentModel) {
		_commentModel = commentModel;
	}

	public long getCommentModelId() {
		return _commentModelId;
	}

	public void setCommentModelId(long commentModelId) {
		_commentModelId = commentModelId;
	}

	public long getParentCommentId() {
		return _parentCommentId;
	}

	public void setParentCommentId(long parentCommentId) {
		_parentCommentId = parentCommentId;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	private long _dataCommentId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _commentModel;
	private long _commentModelId;
	private long _parentCommentId;
	private String _comment;

}