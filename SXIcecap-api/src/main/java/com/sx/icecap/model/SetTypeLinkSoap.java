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
public class SetTypeLinkSoap implements Serializable {

	public static SetTypeLinkSoap toSoapModel(SetTypeLink model) {
		SetTypeLinkSoap soapModel = new SetTypeLinkSoap();

		soapModel.setSetTypeLinkId(model.getSetTypeLinkId());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setOrder(model.getOrder());
		soapModel.setCommentable(model.isCommentable());
		soapModel.setVerifiable(model.isVerifiable());
		soapModel.setFreezable(model.isFreezable());
		soapModel.setFreezed(model.isFreezed());
		soapModel.setFreezedUserId(model.getFreezedUserId());
		soapModel.setFreezedUserName(model.getFreezedUserName());
		soapModel.setFreezedDate(model.getFreezedDate());
		soapModel.setVerified(model.isVerified());
		soapModel.setVerifiedUserId(model.getVerifiedUserId());
		soapModel.setVerifiedUserName(model.getVerifiedUserName());
		soapModel.setVerifiedDate(model.getVerifiedDate());

		return soapModel;
	}

	public static SetTypeLinkSoap[] toSoapModels(SetTypeLink[] models) {
		SetTypeLinkSoap[] soapModels = new SetTypeLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SetTypeLinkSoap[][] toSoapModels(SetTypeLink[][] models) {
		SetTypeLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SetTypeLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SetTypeLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SetTypeLinkSoap[] toSoapModels(List<SetTypeLink> models) {
		List<SetTypeLinkSoap> soapModels = new ArrayList<SetTypeLinkSoap>(
			models.size());

		for (SetTypeLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SetTypeLinkSoap[soapModels.size()]);
	}

	public SetTypeLinkSoap() {
	}

	public long getPrimaryKey() {
		return _setTypeLinkId;
	}

	public void setPrimaryKey(long pk) {
		setSetTypeLinkId(pk);
	}

	public long getSetTypeLinkId() {
		return _setTypeLinkId;
	}

	public void setSetTypeLinkId(long setTypeLinkId) {
		_setTypeLinkId = setTypeLinkId;
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

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public boolean getCommentable() {
		return _commentable;
	}

	public boolean isCommentable() {
		return _commentable;
	}

	public void setCommentable(boolean commentable) {
		_commentable = commentable;
	}

	public boolean getVerifiable() {
		return _verifiable;
	}

	public boolean isVerifiable() {
		return _verifiable;
	}

	public void setVerifiable(boolean verifiable) {
		_verifiable = verifiable;
	}

	public boolean getFreezable() {
		return _freezable;
	}

	public boolean isFreezable() {
		return _freezable;
	}

	public void setFreezable(boolean freezable) {
		_freezable = freezable;
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

	public long getFreezedUserId() {
		return _freezedUserId;
	}

	public void setFreezedUserId(long freezedUserId) {
		_freezedUserId = freezedUserId;
	}

	public String getFreezedUserName() {
		return _freezedUserName;
	}

	public void setFreezedUserName(String freezedUserName) {
		_freezedUserName = freezedUserName;
	}

	public Date getFreezedDate() {
		return _freezedDate;
	}

	public void setFreezedDate(Date freezedDate) {
		_freezedDate = freezedDate;
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

	public long getVerifiedUserId() {
		return _verifiedUserId;
	}

	public void setVerifiedUserId(long verifiedUserId) {
		_verifiedUserId = verifiedUserId;
	}

	public String getVerifiedUserName() {
		return _verifiedUserName;
	}

	public void setVerifiedUserName(String verifiedUserName) {
		_verifiedUserName = verifiedUserName;
	}

	public Date getVerifiedDate() {
		return _verifiedDate;
	}

	public void setVerifiedDate(Date verifiedDate) {
		_verifiedDate = verifiedDate;
	}

	private long _setTypeLinkId;
	private long _dataSetId;
	private long _dataTypeId;
	private int _order;
	private boolean _commentable;
	private boolean _verifiable;
	private boolean _freezable;
	private boolean _freezed;
	private long _freezedUserId;
	private String _freezedUserName;
	private Date _freezedDate;
	private boolean _verified;
	private long _verifiedUserId;
	private String _verifiedUserName;
	private Date _verifiedDate;

}