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
		attributes.put("structuredDataId", getStructuredDataId());
		attributes.put("paramCode", getParamCode());
		attributes.put("prevValue", getPrevValue());
		attributes.put("changedValue", getChangedValue());
		attributes.put("action", getAction());
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

		Long structuredDataId = (Long)attributes.get("structuredDataId");

		if (structuredDataId != null) {
			setStructuredDataId(structuredDataId);
		}

		String paramCode = (String)attributes.get("paramCode");

		if (paramCode != null) {
			setParamCode(paramCode);
		}

		String prevValue = (String)attributes.get("prevValue");

		if (prevValue != null) {
			setPrevValue(prevValue);
		}

		String changedValue = (String)attributes.get("changedValue");

		if (changedValue != null) {
			setChangedValue(changedValue);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	/**
	 * Returns the action of this action history.
	 *
	 * @return the action of this action history
	 */
	@Override
	public String getAction() {
		return model.getAction();
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
	 * Returns the changed value of this action history.
	 *
	 * @return the changed value of this action history
	 */
	@Override
	public String getChangedValue() {
		return model.getChangedValue();
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
	 * Returns the structured data ID of this action history.
	 *
	 * @return the structured data ID of this action history
	 */
	@Override
	public long getStructuredDataId() {
		return model.getStructuredDataId();
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
	 * Sets the action of this action history.
	 *
	 * @param action the action of this action history
	 */
	@Override
	public void setAction(String action) {
		model.setAction(action);
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
	 * Sets the changed value of this action history.
	 *
	 * @param changedValue the changed value of this action history
	 */
	@Override
	public void setChangedValue(String changedValue) {
		model.setChangedValue(changedValue);
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
	 * Sets the structured data ID of this action history.
	 *
	 * @param structuredDataId the structured data ID of this action history
	 */
	@Override
	public void setStructuredDataId(long structuredDataId) {
		model.setStructuredDataId(structuredDataId);
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
	protected ActionHistoryWrapper wrap(ActionHistory actionHistory) {
		return new ActionHistoryWrapper(actionHistory);
	}

}