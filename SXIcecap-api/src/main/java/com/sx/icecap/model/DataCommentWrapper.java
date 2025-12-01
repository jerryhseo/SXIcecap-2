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

import com.liferay.exportimport.kernel.lar.StagedModelType;
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

		attributes.put("uuid", getUuid());
		attributes.put("dataCommentId", getDataCommentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("lastPublishDate", getLastPublishDate());
		attributes.put("commentModel", getCommentModel());
		attributes.put("dataId", getDataId());
		attributes.put("paramCode", getParamCode());
		attributes.put("parentCommentId", getParentCommentId());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}

		String commentModel = (String)attributes.get("commentModel");

		if (commentModel != null) {
			setCommentModel(commentModel);
		}

		Long dataId = (Long)attributes.get("dataId");

		if (dataId != null) {
			setDataId(dataId);
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
	 * Returns the comment model of this data comment.
	 *
	 * @return the comment model of this data comment
	 */
	@Override
	public String getCommentModel() {
		return model.getCommentModel();
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
	 * Returns the data ID of this data comment.
	 *
	 * @return the data ID of this data comment
	 */
	@Override
	public long getDataId() {
		return model.getDataId();
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
	 * Returns the last publish date of this data comment.
	 *
	 * @return the last publish date of this data comment
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
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
	 * Returns the status of this data comment.
	 *
	 * @return the status of this data comment
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this data comment.
	 *
	 * @return the status by user ID of this data comment
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this data comment.
	 *
	 * @return the status by user name of this data comment
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this data comment.
	 *
	 * @return the status by user uuid of this data comment
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this data comment.
	 *
	 * @return the status date of this data comment
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the trash entry created when this data comment was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this data comment.
	 *
	 * @return the trash entry created when this data comment was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this data comment.
	 *
	 * @return the class primary key of the trash entry for this data comment
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this data comment.
	 *
	 * @return the trash handler for this data comment
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
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
	 * Returns the uuid of this data comment.
	 *
	 * @return the uuid of this data comment
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this data comment is approved.
	 *
	 * @return <code>true</code> if this data comment is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this data comment is denied.
	 *
	 * @return <code>true</code> if this data comment is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this data comment is a draft.
	 *
	 * @return <code>true</code> if this data comment is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this data comment is expired.
	 *
	 * @return <code>true</code> if this data comment is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this data comment is inactive.
	 *
	 * @return <code>true</code> if this data comment is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this data comment is incomplete.
	 *
	 * @return <code>true</code> if this data comment is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this data comment is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this data comment is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this data comment is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this data comment is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	/**
	 * Returns <code>true</code> if this data comment is pending.
	 *
	 * @return <code>true</code> if this data comment is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this data comment is scheduled.
	 *
	 * @return <code>true</code> if this data comment is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
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
	 * Sets the comment model of this data comment.
	 *
	 * @param commentModel the comment model of this data comment
	 */
	@Override
	public void setCommentModel(String commentModel) {
		model.setCommentModel(commentModel);
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
	 * Sets the data ID of this data comment.
	 *
	 * @param dataId the data ID of this data comment
	 */
	@Override
	public void setDataId(long dataId) {
		model.setDataId(dataId);
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
	 * Sets the last publish date of this data comment.
	 *
	 * @param lastPublishDate the last publish date of this data comment
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
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
	 * Sets the status of this data comment.
	 *
	 * @param status the status of this data comment
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this data comment.
	 *
	 * @param statusByUserId the status by user ID of this data comment
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this data comment.
	 *
	 * @param statusByUserName the status by user name of this data comment
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this data comment.
	 *
	 * @param statusByUserUuid the status by user uuid of this data comment
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this data comment.
	 *
	 * @param statusDate the status date of this data comment
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
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

	/**
	 * Sets the uuid of this data comment.
	 *
	 * @param uuid the uuid of this data comment
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return model.toJSON();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DataCommentWrapper wrap(DataComment dataComment) {
		return new DataCommentWrapper(dataComment);
	}

}