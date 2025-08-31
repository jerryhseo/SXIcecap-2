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
 * This class is a wrapper for {@link DataComment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataComment
 * @generated
 */
public class DataCommentWrapper
	extends BaseModelWrapper<DataComment>
	implements DataComment, ModelWrapper<DataComment> {

	public DataCommentWrapper(DataComment dataComment) {
		super(dataComment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataCommentId", getDataCommentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("structuredDataId", getStructuredDataId());
		attributes.put("paramCode", getParamCode());
		attributes.put("parentCommentId", getParentCommentId());
		attributes.put("comment", getComment());
		attributes.put("closed", isClosed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataCommentId = (Long)attributes.get("dataCommentId");

		if (dataCommentId != null) {
			setDataCommentId(dataCommentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long structuredDataId = (Long)attributes.get("structuredDataId");

		if (structuredDataId != null) {
			setStructuredDataId(structuredDataId);
		}

		String paramCode = (String)attributes.get("paramCode");

		if (paramCode != null) {
			setParamCode(paramCode);
		}

		Long parentCommentId = (Long)attributes.get("parentCommentId");

		if (parentCommentId != null) {
			setParentCommentId(parentCommentId);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		Boolean closed = (Boolean)attributes.get("closed");

		if (closed != null) {
			setClosed(closed);
		}
	}

	/**
	 * Returns the closed of this data comment.
	 *
	 * @return the closed of this data comment
	 */
	@Override
	public boolean getClosed() {
		return model.getClosed();
	}

	/**
	 * Returns the comment of this data comment.
	 *
	 * @return the comment of this data comment
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the company ID of this data comment.
	 *
	 * @return the company ID of this data comment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this data comment.
	 *
	 * @return the create date of this data comment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data comment ID of this data comment.
	 *
	 * @return the data comment ID of this data comment
	 */
	@Override
	public long getDataCommentId() {
		return model.getDataCommentId();
	}

	/**
	 * Returns the group ID of this data comment.
	 *
	 * @return the group ID of this data comment
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this data comment.
	 *
	 * @return the modified date of this data comment
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the param code of this data comment.
	 *
	 * @return the param code of this data comment
	 */
	@Override
	public String getParamCode() {
		return model.getParamCode();
	}

	/**
	 * Returns the parent comment ID of this data comment.
	 *
	 * @return the parent comment ID of this data comment
	 */
	@Override
	public long getParentCommentId() {
		return model.getParentCommentId();
	}

	/**
	 * Returns the primary key of this data comment.
	 *
	 * @return the primary key of this data comment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the structured data ID of this data comment.
	 *
	 * @return the structured data ID of this data comment
	 */
	@Override
	public long getStructuredDataId() {
		return model.getStructuredDataId();
	}

	/**
	 * Returns the user ID of this data comment.
	 *
	 * @return the user ID of this data comment
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this data comment.
	 *
	 * @return the user name of this data comment
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this data comment.
	 *
	 * @return the user uuid of this data comment
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this data comment is closed.
	 *
	 * @return <code>true</code> if this data comment is closed; <code>false</code> otherwise
	 */
	@Override
	public boolean isClosed() {
		return model.isClosed();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this data comment is closed.
	 *
	 * @param closed the closed of this data comment
	 */
	@Override
	public void setClosed(boolean closed) {
		model.setClosed(closed);
	}

	/**
	 * Sets the comment of this data comment.
	 *
	 * @param comment the comment of this data comment
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the company ID of this data comment.
	 *
	 * @param companyId the company ID of this data comment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this data comment.
	 *
	 * @param createDate the create date of this data comment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data comment ID of this data comment.
	 *
	 * @param dataCommentId the data comment ID of this data comment
	 */
	@Override
	public void setDataCommentId(long dataCommentId) {
		model.setDataCommentId(dataCommentId);
	}

	/**
	 * Sets the group ID of this data comment.
	 *
	 * @param groupId the group ID of this data comment
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this data comment.
	 *
	 * @param modifiedDate the modified date of this data comment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the param code of this data comment.
	 *
	 * @param paramCode the param code of this data comment
	 */
	@Override
	public void setParamCode(String paramCode) {
		model.setParamCode(paramCode);
	}

	/**
	 * Sets the parent comment ID of this data comment.
	 *
	 * @param parentCommentId the parent comment ID of this data comment
	 */
	@Override
	public void setParentCommentId(long parentCommentId) {
		model.setParentCommentId(parentCommentId);
	}

	/**
	 * Sets the primary key of this data comment.
	 *
	 * @param primaryKey the primary key of this data comment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the structured data ID of this data comment.
	 *
	 * @param structuredDataId the structured data ID of this data comment
	 */
	@Override
	public void setStructuredDataId(long structuredDataId) {
		model.setStructuredDataId(structuredDataId);
	}

	/**
	 * Sets the user ID of this data comment.
	 *
	 * @param userId the user ID of this data comment
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this data comment.
	 *
	 * @param userName the user name of this data comment
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this data comment.
	 *
	 * @param userUuid the user uuid of this data comment
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DataCommentWrapper wrap(DataComment dataComment) {
		return new DataCommentWrapper(dataComment);
	}

}