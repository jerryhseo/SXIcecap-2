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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ActionHistory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActionHistory
 * @generated
 */
public class ActionHistoryWrapper
	extends BaseModelWrapper<ActionHistory>
	implements ActionHistory, ModelWrapper<ActionHistory> {

	public ActionHistoryWrapper(ActionHistory actionHistory) {
		super(actionHistory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("actionHistoryId", getActionHistoryId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("actionType", getActionType());
		attributes.put("actionBase", getActionBase());
		attributes.put("actionDataId", getActionDataId());
		attributes.put("paramCode", getParamCode());
		attributes.put("actionCommand", getActionCommand());
		attributes.put("prevValue", getPrevValue());
		attributes.put("modifiedValue", getModifiedValue());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long actionHistoryId = (Long)attributes.get("actionHistoryId");

		if (actionHistoryId != null) {
			setActionHistoryId(actionHistoryId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String actionType = (String)attributes.get("actionType");

		if (actionType != null) {
			setActionType(actionType);
		}

		String actionBase = (String)attributes.get("actionBase");

		if (actionBase != null) {
			setActionBase(actionBase);
		}

		Long actionDataId = (Long)attributes.get("actionDataId");

		if (actionDataId != null) {
			setActionDataId(actionDataId);
		}

		String paramCode = (String)attributes.get("paramCode");

		if (paramCode != null) {
			setParamCode(paramCode);
		}

		String actionCommand = (String)attributes.get("actionCommand");

		if (actionCommand != null) {
			setActionCommand(actionCommand);
		}

		String prevValue = (String)attributes.get("prevValue");

		if (prevValue != null) {
			setPrevValue(prevValue);
		}

		String modifiedValue = (String)attributes.get("modifiedValue");

		if (modifiedValue != null) {
			setModifiedValue(modifiedValue);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	/**
	 * Returns the action base of this action history.
	 *
	 * @return the action base of this action history
	 */
	@Override
	public String getActionBase() {
		return model.getActionBase();
	}

	/**
	 * Returns the action command of this action history.
	 *
	 * @return the action command of this action history
	 */
	@Override
	public String getActionCommand() {
		return model.getActionCommand();
	}

	/**
	 * Returns the action data ID of this action history.
	 *
	 * @return the action data ID of this action history
	 */
	@Override
	public long getActionDataId() {
		return model.getActionDataId();
	}

	/**
	 * Returns the action history ID of this action history.
	 *
	 * @return the action history ID of this action history
	 */
	@Override
	public long getActionHistoryId() {
		return model.getActionHistoryId();
	}

	/**
	 * Returns the action type of this action history.
	 *
	 * @return the action type of this action history
	 */
	@Override
	public String getActionType() {
		return model.getActionType();
	}

	/**
	 * Returns the comment of this action history.
	 *
	 * @return the comment of this action history
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the create date of this action history.
	 *
	 * @return the create date of this action history
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified value of this action history.
	 *
	 * @return the modified value of this action history
	 */
	@Override
	public String getModifiedValue() {
		return model.getModifiedValue();
	}

	/**
	 * Returns the param code of this action history.
	 *
	 * @return the param code of this action history
	 */
	@Override
	public String getParamCode() {
		return model.getParamCode();
	}

	/**
	 * Returns the prev value of this action history.
	 *
	 * @return the prev value of this action history
	 */
	@Override
	public String getPrevValue() {
		return model.getPrevValue();
	}

	/**
	 * Returns the primary key of this action history.
	 *
	 * @return the primary key of this action history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this action history.
	 *
	 * @return the user ID of this action history
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this action history.
	 *
	 * @return the user name of this action history
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this action history.
	 *
	 * @return the user uuid of this action history
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the action base of this action history.
	 *
	 * @param actionBase the action base of this action history
	 */
	@Override
	public void setActionBase(String actionBase) {
		model.setActionBase(actionBase);
	}

	/**
	 * Sets the action command of this action history.
	 *
	 * @param actionCommand the action command of this action history
	 */
	@Override
	public void setActionCommand(String actionCommand) {
		model.setActionCommand(actionCommand);
	}

	/**
	 * Sets the action data ID of this action history.
	 *
	 * @param actionDataId the action data ID of this action history
	 */
	@Override
	public void setActionDataId(long actionDataId) {
		model.setActionDataId(actionDataId);
	}

	/**
	 * Sets the action history ID of this action history.
	 *
	 * @param actionHistoryId the action history ID of this action history
	 */
	@Override
	public void setActionHistoryId(long actionHistoryId) {
		model.setActionHistoryId(actionHistoryId);
	}

	/**
	 * Sets the action type of this action history.
	 *
	 * @param actionType the action type of this action history
	 */
	@Override
	public void setActionType(String actionType) {
		model.setActionType(actionType);
	}

	/**
	 * Sets the comment of this action history.
	 *
	 * @param comment the comment of this action history
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the create date of this action history.
	 *
	 * @param createDate the create date of this action history
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified value of this action history.
	 *
	 * @param modifiedValue the modified value of this action history
	 */
	@Override
	public void setModifiedValue(String modifiedValue) {
		model.setModifiedValue(modifiedValue);
	}

	/**
	 * Sets the param code of this action history.
	 *
	 * @param paramCode the param code of this action history
	 */
	@Override
	public void setParamCode(String paramCode) {
		model.setParamCode(paramCode);
	}

	/**
	 * Sets the prev value of this action history.
	 *
	 * @param prevValue the prev value of this action history
	 */
	@Override
	public void setPrevValue(String prevValue) {
		model.setPrevValue(prevValue);
	}

	/**
	 * Sets the primary key of this action history.
	 *
	 * @param primaryKey the primary key of this action history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this action history.
	 *
	 * @param userId the user ID of this action history
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this action history.
	 *
	 * @param userName the user name of this action history
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this action history.
	 *
	 * @param userUuid the user uuid of this action history
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return model.toJSON();
	}

	@Override
	protected ActionHistoryWrapper wrap(ActionHistory actionHistory) {
		return new ActionHistoryWrapper(actionHistory);
	}

}