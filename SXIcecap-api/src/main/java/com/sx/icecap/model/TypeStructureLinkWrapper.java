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
 * This class is a wrapper for {@link TypeStructureLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TypeStructureLink
 * @generated
 */
public class TypeStructureLinkWrapper
	extends BaseModelWrapper<TypeStructureLink>
	implements ModelWrapper<TypeStructureLink>, TypeStructureLink {

	public TypeStructureLinkWrapper(TypeStructureLink typeStructureLink) {
		super(typeStructureLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("dataStructureId", getDataStructureId());
		attributes.put("commentable", isCommentable());
		attributes.put("verifiable", isVerifiable());
		attributes.put("freezable", isFreezable());
		attributes.put("freezed", isFreezed());
		attributes.put("freezedUserId", getFreezedUserId());
		attributes.put("freezedUserName", getFreezedUserName());
		attributes.put("freezedDate", getFreezedDate());
		attributes.put("verified", isVerified());
		attributes.put("verifiedUserId", getVerifiedUserId());
		attributes.put("verifiedUserName", getVerifiedUserName());
		attributes.put("verifiedDate", getVerifiedDate());
		attributes.put("inputStatus", isInputStatus());
		attributes.put("jumpTo", isJumpTo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long dataStructureId = (Long)attributes.get("dataStructureId");

		if (dataStructureId != null) {
			setDataStructureId(dataStructureId);
		}

		Boolean commentable = (Boolean)attributes.get("commentable");

		if (commentable != null) {
			setCommentable(commentable);
		}

		Boolean verifiable = (Boolean)attributes.get("verifiable");

		if (verifiable != null) {
			setVerifiable(verifiable);
		}

		Boolean freezable = (Boolean)attributes.get("freezable");

		if (freezable != null) {
			setFreezable(freezable);
		}

		Boolean freezed = (Boolean)attributes.get("freezed");

		if (freezed != null) {
			setFreezed(freezed);
		}

		Long freezedUserId = (Long)attributes.get("freezedUserId");

		if (freezedUserId != null) {
			setFreezedUserId(freezedUserId);
		}

		String freezedUserName = (String)attributes.get("freezedUserName");

		if (freezedUserName != null) {
			setFreezedUserName(freezedUserName);
		}

		Date freezedDate = (Date)attributes.get("freezedDate");

		if (freezedDate != null) {
			setFreezedDate(freezedDate);
		}

		Boolean verified = (Boolean)attributes.get("verified");

		if (verified != null) {
			setVerified(verified);
		}

		Long verifiedUserId = (Long)attributes.get("verifiedUserId");

		if (verifiedUserId != null) {
			setVerifiedUserId(verifiedUserId);
		}

		String verifiedUserName = (String)attributes.get("verifiedUserName");

		if (verifiedUserName != null) {
			setVerifiedUserName(verifiedUserName);
		}

		Date verifiedDate = (Date)attributes.get("verifiedDate");

		if (verifiedDate != null) {
			setVerifiedDate(verifiedDate);
		}

		Boolean inputStatus = (Boolean)attributes.get("inputStatus");

		if (inputStatus != null) {
			setInputStatus(inputStatus);
		}

		Boolean jumpTo = (Boolean)attributes.get("jumpTo");

		if (jumpTo != null) {
			setJumpTo(jumpTo);
		}
	}

	/**
	 * Returns the commentable of this type structure link.
	 *
	 * @return the commentable of this type structure link
	 */
	@Override
	public boolean getCommentable() {
		return model.getCommentable();
	}

	/**
	 * Returns the data structure ID of this type structure link.
	 *
	 * @return the data structure ID of this type structure link
	 */
	@Override
	public long getDataStructureId() {
		return model.getDataStructureId();
	}

	/**
	 * Returns the data type ID of this type structure link.
	 *
	 * @return the data type ID of this type structure link
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the freezable of this type structure link.
	 *
	 * @return the freezable of this type structure link
	 */
	@Override
	public boolean getFreezable() {
		return model.getFreezable();
	}

	/**
	 * Returns the freezed of this type structure link.
	 *
	 * @return the freezed of this type structure link
	 */
	@Override
	public boolean getFreezed() {
		return model.getFreezed();
	}

	/**
	 * Returns the freezed date of this type structure link.
	 *
	 * @return the freezed date of this type structure link
	 */
	@Override
	public Date getFreezedDate() {
		return model.getFreezedDate();
	}

	/**
	 * Returns the freezed user ID of this type structure link.
	 *
	 * @return the freezed user ID of this type structure link
	 */
	@Override
	public long getFreezedUserId() {
		return model.getFreezedUserId();
	}

	/**
	 * Returns the freezed user name of this type structure link.
	 *
	 * @return the freezed user name of this type structure link
	 */
	@Override
	public String getFreezedUserName() {
		return model.getFreezedUserName();
	}

	/**
	 * Returns the freezed user uuid of this type structure link.
	 *
	 * @return the freezed user uuid of this type structure link
	 */
	@Override
	public String getFreezedUserUuid() {
		return model.getFreezedUserUuid();
	}

	/**
	 * Returns the group ID of this type structure link.
	 *
	 * @return the group ID of this type structure link
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the input status of this type structure link.
	 *
	 * @return the input status of this type structure link
	 */
	@Override
	public boolean getInputStatus() {
		return model.getInputStatus();
	}

	/**
	 * Returns the jump to of this type structure link.
	 *
	 * @return the jump to of this type structure link
	 */
	@Override
	public boolean getJumpTo() {
		return model.getJumpTo();
	}

	/**
	 * Returns the primary key of this type structure link.
	 *
	 * @return the primary key of this type structure link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this type structure link.
	 *
	 * @return the user ID of this type structure link
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this type structure link.
	 *
	 * @return the user uuid of this type structure link
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the verifiable of this type structure link.
	 *
	 * @return the verifiable of this type structure link
	 */
	@Override
	public boolean getVerifiable() {
		return model.getVerifiable();
	}

	/**
	 * Returns the verified of this type structure link.
	 *
	 * @return the verified of this type structure link
	 */
	@Override
	public boolean getVerified() {
		return model.getVerified();
	}

	/**
	 * Returns the verified date of this type structure link.
	 *
	 * @return the verified date of this type structure link
	 */
	@Override
	public Date getVerifiedDate() {
		return model.getVerifiedDate();
	}

	/**
	 * Returns the verified user ID of this type structure link.
	 *
	 * @return the verified user ID of this type structure link
	 */
	@Override
	public long getVerifiedUserId() {
		return model.getVerifiedUserId();
	}

	/**
	 * Returns the verified user name of this type structure link.
	 *
	 * @return the verified user name of this type structure link
	 */
	@Override
	public String getVerifiedUserName() {
		return model.getVerifiedUserName();
	}

	/**
	 * Returns the verified user uuid of this type structure link.
	 *
	 * @return the verified user uuid of this type structure link
	 */
	@Override
	public String getVerifiedUserUuid() {
		return model.getVerifiedUserUuid();
	}

	/**
	 * Returns <code>true</code> if this type structure link is commentable.
	 *
	 * @return <code>true</code> if this type structure link is commentable; <code>false</code> otherwise
	 */
	@Override
	public boolean isCommentable() {
		return model.isCommentable();
	}

	/**
	 * Returns <code>true</code> if this type structure link is freezable.
	 *
	 * @return <code>true</code> if this type structure link is freezable; <code>false</code> otherwise
	 */
	@Override
	public boolean isFreezable() {
		return model.isFreezable();
	}

	/**
	 * Returns <code>true</code> if this type structure link is freezed.
	 *
	 * @return <code>true</code> if this type structure link is freezed; <code>false</code> otherwise
	 */
	@Override
	public boolean isFreezed() {
		return model.isFreezed();
	}

	/**
	 * Returns <code>true</code> if this type structure link is input status.
	 *
	 * @return <code>true</code> if this type structure link is input status; <code>false</code> otherwise
	 */
	@Override
	public boolean isInputStatus() {
		return model.isInputStatus();
	}

	/**
	 * Returns <code>true</code> if this type structure link is jump to.
	 *
	 * @return <code>true</code> if this type structure link is jump to; <code>false</code> otherwise
	 */
	@Override
	public boolean isJumpTo() {
		return model.isJumpTo();
	}

	/**
	 * Returns <code>true</code> if this type structure link is verifiable.
	 *
	 * @return <code>true</code> if this type structure link is verifiable; <code>false</code> otherwise
	 */
	@Override
	public boolean isVerifiable() {
		return model.isVerifiable();
	}

	/**
	 * Returns <code>true</code> if this type structure link is verified.
	 *
	 * @return <code>true</code> if this type structure link is verified; <code>false</code> otherwise
	 */
	@Override
	public boolean isVerified() {
		return model.isVerified();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this type structure link is commentable.
	 *
	 * @param commentable the commentable of this type structure link
	 */
	@Override
	public void setCommentable(boolean commentable) {
		model.setCommentable(commentable);
	}

	/**
	 * Sets the data structure ID of this type structure link.
	 *
	 * @param dataStructureId the data structure ID of this type structure link
	 */
	@Override
	public void setDataStructureId(long dataStructureId) {
		model.setDataStructureId(dataStructureId);
	}

	/**
	 * Sets the data type ID of this type structure link.
	 *
	 * @param dataTypeId the data type ID of this type structure link
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets whether this type structure link is freezable.
	 *
	 * @param freezable the freezable of this type structure link
	 */
	@Override
	public void setFreezable(boolean freezable) {
		model.setFreezable(freezable);
	}

	/**
	 * Sets whether this type structure link is freezed.
	 *
	 * @param freezed the freezed of this type structure link
	 */
	@Override
	public void setFreezed(boolean freezed) {
		model.setFreezed(freezed);
	}

	/**
	 * Sets the freezed date of this type structure link.
	 *
	 * @param freezedDate the freezed date of this type structure link
	 */
	@Override
	public void setFreezedDate(Date freezedDate) {
		model.setFreezedDate(freezedDate);
	}

	/**
	 * Sets the freezed user ID of this type structure link.
	 *
	 * @param freezedUserId the freezed user ID of this type structure link
	 */
	@Override
	public void setFreezedUserId(long freezedUserId) {
		model.setFreezedUserId(freezedUserId);
	}

	/**
	 * Sets the freezed user name of this type structure link.
	 *
	 * @param freezedUserName the freezed user name of this type structure link
	 */
	@Override
	public void setFreezedUserName(String freezedUserName) {
		model.setFreezedUserName(freezedUserName);
	}

	/**
	 * Sets the freezed user uuid of this type structure link.
	 *
	 * @param freezedUserUuid the freezed user uuid of this type structure link
	 */
	@Override
	public void setFreezedUserUuid(String freezedUserUuid) {
		model.setFreezedUserUuid(freezedUserUuid);
	}

	/**
	 * Sets the group ID of this type structure link.
	 *
	 * @param groupId the group ID of this type structure link
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this type structure link is input status.
	 *
	 * @param inputStatus the input status of this type structure link
	 */
	@Override
	public void setInputStatus(boolean inputStatus) {
		model.setInputStatus(inputStatus);
	}

	/**
	 * Sets whether this type structure link is jump to.
	 *
	 * @param jumpTo the jump to of this type structure link
	 */
	@Override
	public void setJumpTo(boolean jumpTo) {
		model.setJumpTo(jumpTo);
	}

	/**
	 * Sets the primary key of this type structure link.
	 *
	 * @param primaryKey the primary key of this type structure link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this type structure link.
	 *
	 * @param userId the user ID of this type structure link
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this type structure link.
	 *
	 * @param userUuid the user uuid of this type structure link
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets whether this type structure link is verifiable.
	 *
	 * @param verifiable the verifiable of this type structure link
	 */
	@Override
	public void setVerifiable(boolean verifiable) {
		model.setVerifiable(verifiable);
	}

	/**
	 * Sets whether this type structure link is verified.
	 *
	 * @param verified the verified of this type structure link
	 */
	@Override
	public void setVerified(boolean verified) {
		model.setVerified(verified);
	}

	/**
	 * Sets the verified date of this type structure link.
	 *
	 * @param verifiedDate the verified date of this type structure link
	 */
	@Override
	public void setVerifiedDate(Date verifiedDate) {
		model.setVerifiedDate(verifiedDate);
	}

	/**
	 * Sets the verified user ID of this type structure link.
	 *
	 * @param verifiedUserId the verified user ID of this type structure link
	 */
	@Override
	public void setVerifiedUserId(long verifiedUserId) {
		model.setVerifiedUserId(verifiedUserId);
	}

	/**
	 * Sets the verified user name of this type structure link.
	 *
	 * @param verifiedUserName the verified user name of this type structure link
	 */
	@Override
	public void setVerifiedUserName(String verifiedUserName) {
		model.setVerifiedUserName(verifiedUserName);
	}

	/**
	 * Sets the verified user uuid of this type structure link.
	 *
	 * @param verifiedUserUuid the verified user uuid of this type structure link
	 */
	@Override
	public void setVerifiedUserUuid(String verifiedUserUuid) {
		model.setVerifiedUserUuid(verifiedUserUuid);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return model.toJSON();
	}

	@Override
	protected TypeStructureLinkWrapper wrap(
		TypeStructureLink typeStructureLink) {

		return new TypeStructureLinkWrapper(typeStructureLink);
	}

}