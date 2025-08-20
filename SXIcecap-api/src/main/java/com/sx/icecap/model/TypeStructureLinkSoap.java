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
public class TypeStructureLinkSoap implements Serializable {

	public static TypeStructureLinkSoap toSoapModel(TypeStructureLink model) {
		TypeStructureLinkSoap soapModel = new TypeStructureLinkSoap();

		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setDataStructureId(model.getDataStructureId());
		soapModel.setCommentable(model.isCommentable());
		soapModel.setVerifiable(model.isVerifiable());
		soapModel.setFreezable(model.isFreezable());
		soapModel.setFreezed(model.isFreezed());
		soapModel.setFreezedUserId(model.getFreezedUserId());
		soapModel.setFreezedDate(model.getFreezedDate());
		soapModel.setVerified(model.isVerified());
		soapModel.setVerifiedUserId(model.getVerifiedUserId());
		soapModel.setVerifiedDate(model.getVerifiedDate());
		soapModel.setInputStatus(model.isInputStatus());
		soapModel.setJumpTo(model.isJumpTo());

		return soapModel;
	}

	public static TypeStructureLinkSoap[] toSoapModels(
		TypeStructureLink[] models) {

		TypeStructureLinkSoap[] soapModels =
			new TypeStructureLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TypeStructureLinkSoap[][] toSoapModels(
		TypeStructureLink[][] models) {

		TypeStructureLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TypeStructureLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TypeStructureLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TypeStructureLinkSoap[] toSoapModels(
		List<TypeStructureLink> models) {

		List<TypeStructureLinkSoap> soapModels =
			new ArrayList<TypeStructureLinkSoap>(models.size());

		for (TypeStructureLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TypeStructureLinkSoap[soapModels.size()]);
	}

	public TypeStructureLinkSoap() {
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

	public long getDataStructureId() {
		return _dataStructureId;
	}

	public void setDataStructureId(long dataStructureId) {
		_dataStructureId = dataStructureId;
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

	public Date getVerifiedDate() {
		return _verifiedDate;
	}

	public void setVerifiedDate(Date verifiedDate) {
		_verifiedDate = verifiedDate;
	}

	public boolean getInputStatus() {
		return _inputStatus;
	}

	public boolean isInputStatus() {
		return _inputStatus;
	}

	public void setInputStatus(boolean inputStatus) {
		_inputStatus = inputStatus;
	}

	public boolean getJumpTo() {
		return _jumpTo;
	}

	public boolean isJumpTo() {
		return _jumpTo;
	}

	public void setJumpTo(boolean jumpTo) {
		_jumpTo = jumpTo;
	}

	private long _dataTypeId;
	private long _dataStructureId;
	private boolean _commentable;
	private boolean _verifiable;
	private boolean _freezable;
	private boolean _freezed;
	private long _freezedUserId;
	private Date _freezedDate;
	private boolean _verified;
	private long _verifiedUserId;
	private Date _verifiedDate;
	private boolean _inputStatus;
	private boolean _jumpTo;

}