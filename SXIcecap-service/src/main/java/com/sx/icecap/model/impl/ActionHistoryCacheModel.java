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

package com.sx.icecap.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.sx.icecap.model.ActionHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ActionHistory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActionHistoryCacheModel
	implements CacheModel<ActionHistory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ActionHistoryCacheModel)) {
			return false;
		}

		ActionHistoryCacheModel actionHistoryCacheModel =
			(ActionHistoryCacheModel)object;

		if (actionHistoryId == actionHistoryCacheModel.actionHistoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, actionHistoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{actionHistoryId=");
		sb.append(actionHistoryId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", actionType=");
		sb.append(actionType);
		sb.append(", actionBase=");
		sb.append(actionBase);
		sb.append(", actionDataId=");
		sb.append(actionDataId);
		sb.append(", paramCode=");
		sb.append(paramCode);
		sb.append(", actionCommand=");
		sb.append(actionCommand);
		sb.append(", prevValue=");
		sb.append(prevValue);
		sb.append(", modifiedValue=");
		sb.append(modifiedValue);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ActionHistory toEntityModel() {
		ActionHistoryImpl actionHistoryImpl = new ActionHistoryImpl();

		actionHistoryImpl.setActionHistoryId(actionHistoryId);
		actionHistoryImpl.setUserId(userId);

		if (userName == null) {
			actionHistoryImpl.setUserName("");
		}
		else {
			actionHistoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			actionHistoryImpl.setCreateDate(null);
		}
		else {
			actionHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (actionType == null) {
			actionHistoryImpl.setActionType("");
		}
		else {
			actionHistoryImpl.setActionType(actionType);
		}

		if (actionBase == null) {
			actionHistoryImpl.setActionBase("");
		}
		else {
			actionHistoryImpl.setActionBase(actionBase);
		}

		actionHistoryImpl.setActionDataId(actionDataId);

		if (paramCode == null) {
			actionHistoryImpl.setParamCode("");
		}
		else {
			actionHistoryImpl.setParamCode(paramCode);
		}

		if (actionCommand == null) {
			actionHistoryImpl.setActionCommand("");
		}
		else {
			actionHistoryImpl.setActionCommand(actionCommand);
		}

		if (prevValue == null) {
			actionHistoryImpl.setPrevValue("");
		}
		else {
			actionHistoryImpl.setPrevValue(prevValue);
		}

		if (modifiedValue == null) {
			actionHistoryImpl.setModifiedValue("");
		}
		else {
			actionHistoryImpl.setModifiedValue(modifiedValue);
		}

		if (comment == null) {
			actionHistoryImpl.setComment("");
		}
		else {
			actionHistoryImpl.setComment(comment);
		}

		actionHistoryImpl.resetOriginalValues();

		return actionHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		actionHistoryId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		actionType = objectInput.readUTF();
		actionBase = objectInput.readUTF();

		actionDataId = objectInput.readLong();
		paramCode = objectInput.readUTF();
		actionCommand = objectInput.readUTF();
		prevValue = objectInput.readUTF();
		modifiedValue = objectInput.readUTF();
		comment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(actionHistoryId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		if (actionType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actionType);
		}

		if (actionBase == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actionBase);
		}

		objectOutput.writeLong(actionDataId);

		if (paramCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paramCode);
		}

		if (actionCommand == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actionCommand);
		}

		if (prevValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prevValue);
		}

		if (modifiedValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modifiedValue);
		}

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}
	}

	public long actionHistoryId;
	public long userId;
	public String userName;
	public long createDate;
	public String actionType;
	public String actionBase;
	public long actionDataId;
	public String paramCode;
	public String actionCommand;
	public String prevValue;
	public String modifiedValue;
	public String comment;

}