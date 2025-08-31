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
		StringBundler sb = new StringBundler(21);

		sb.append("{actionHistoryId=");
		sb.append(actionHistoryId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", structuredDataId=");
		sb.append(structuredDataId);
		sb.append(", paramCode=");
		sb.append(paramCode);
		sb.append(", prevValue=");
		sb.append(prevValue);
		sb.append(", changedValue=");
		sb.append(changedValue);
		sb.append(", action=");
		sb.append(action);
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

		actionHistoryImpl.setStructuredDataId(structuredDataId);

		if (paramCode == null) {
			actionHistoryImpl.setParamCode("");
		}
		else {
			actionHistoryImpl.setParamCode(paramCode);
		}

		if (prevValue == null) {
			actionHistoryImpl.setPrevValue("");
		}
		else {
			actionHistoryImpl.setPrevValue(prevValue);
		}

		if (changedValue == null) {
			actionHistoryImpl.setChangedValue("");
		}
		else {
			actionHistoryImpl.setChangedValue(changedValue);
		}

		if (action == null) {
			actionHistoryImpl.setAction("");
		}
		else {
			actionHistoryImpl.setAction(action);
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

		structuredDataId = objectInput.readLong();
		paramCode = objectInput.readUTF();
		prevValue = objectInput.readUTF();
		changedValue = objectInput.readUTF();
		action = objectInput.readUTF();
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

		objectOutput.writeLong(structuredDataId);

		if (paramCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paramCode);
		}

		if (prevValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prevValue);
		}

		if (changedValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(changedValue);
		}

		if (action == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(action);
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
	public long structuredDataId;
	public String paramCode;
	public String prevValue;
	public String changedValue;
	public String action;
	public String comment;

}