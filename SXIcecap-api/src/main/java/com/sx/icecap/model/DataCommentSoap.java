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
		soapModel.setCommentType(model.getCommentType());
		soapModel.setCommentBase(model.getCommentBase());
		soapModel.setCommentDataId(model.getCommentDataId());
		soapModel.setParamCode(model.getParamCode());
		soapModel.setParentCommentId(model.getParentCommentId());
		soapModel.setComment(model.getComment());
		soapModel.setClosed(model.isClosed());
		soapModel.setClosedUserId(model.getClosedUserId());
		soapModel.setClosedUserName(model.getClosedUserName());
		soapModel.setClosedDate(model.getClosedDate());

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

	public String getCommentType() {
		return _commentType;
	}

	public void setCommentType(String commentType) {
		_commentType = commentType;
	}

	public String getCommentBase() {
		return _commentBase;
	}

	public void setCommentBase(String commentBase) {
		_commentBase = commentBase;
	}

	public long getCommentDataId() {
		return _commentDataId;
	}

	public void setCommentDataId(long commentDataId) {
		_commentDataId = commentDataId;
	}

	public String getParamCode() {
		return _paramCode;
	}

	public void setParamCode(String paramCode) {
		_paramCode = paramCode;
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

	public boolean getClosed() {
		return _closed;
	}

	public boolean isClosed() {
		return _closed;
	}

	public void setClosed(boolean closed) {
		_closed = closed;
	}

	public long getClosedUserId() {
		return _closedUserId;
	}

	public void setClosedUserId(long closedUserId) {
		_closedUserId = closedUserId;
	}

	public String getClosedUserName() {
		return _closedUserName;
	}

	public void setClosedUserName(String closedUserName) {
		_closedUserName = closedUserName;
	}

	public Date getClosedDate() {
		return _closedDate;
	}

	public void setClosedDate(Date closedDate) {
		_closedDate = closedDate;
	}

	private long _dataCommentId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _commentType;
	private String _commentBase;
	private long _commentDataId;
	private String _paramCode;
	private long _parentCommentId;
	private String _comment;
	private boolean _closed;
	private long _closedUserId;
	private String _closedUserName;
	private Date _closedDate;

}