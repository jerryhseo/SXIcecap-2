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
 * This class is a wrapper for {@link SetTypeLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SetTypeLink
 * @generated
 */
public class SetTypeLinkWrapper
	extends BaseModelWrapper<SetTypeLink>
	implements ModelWrapper<SetTypeLink>, SetTypeLink {

	public SetTypeLinkWrapper(SetTypeLink setTypeLink) {
		super(setTypeLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("setTypeLinkId", getSetTypeLinkId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("dataCollectionId", getDataCollectionId());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("order", getOrder());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long setTypeLinkId = (Long)attributes.get("setTypeLinkId");

		if (setTypeLinkId != null) {
			setSetTypeLinkId(setTypeLinkId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long dataCollectionId = (Long)attributes.get("dataCollectionId");

		if (dataCollectionId != null) {
			setDataCollectionId(dataCollectionId);
		}

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
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
	}

	/**
	 * Returns the commentable of this set type link.
	 *
	 * @return the commentable of this set type link
	 */
	@Override
	public boolean getCommentable() {
		return model.getCommentable();
	}

	/**
	 * Returns the company ID of this set type link.
	 *
	 * @return the company ID of this set type link
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the data collection ID of this set type link.
	 *
	 * @return the data collection ID of this set type link
	 */
	@Override
	public long getDataCollectionId() {
		return model.getDataCollectionId();
	}

	/**
	 * Returns the data set ID of this set type link.
	 *
	 * @return the data set ID of this set type link
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the data type ID of this set type link.
	 *
	 * @return the data type ID of this set type link
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the freezable of this set type link.
	 *
	 * @return the freezable of this set type link
	 */
	@Override
	public boolean getFreezable() {
		return model.getFreezable();
	}

	/**
	 * Returns the freezed of this set type link.
	 *
	 * @return the freezed of this set type link
	 */
	@Override
	public boolean getFreezed() {
		return model.getFreezed();
	}

	/**
	 * Returns the freezed date of this set type link.
	 *
	 * @return the freezed date of this set type link
	 */
	@Override
	public Date getFreezedDate() {
		return model.getFreezedDate();
	}

	/**
	 * Returns the freezed user ID of this set type link.
	 *
	 * @return the freezed user ID of this set type link
	 */
	@Override
	public long getFreezedUserId() {
		return model.getFreezedUserId();
	}

	/**
	 * Returns the freezed user name of this set type link.
	 *
	 * @return the freezed user name of this set type link
	 */
	@Override
	public String getFreezedUserName() {
		return model.getFreezedUserName();
	}

	/**
	 * Returns the freezed user uuid of this set type link.
	 *
	 * @return the freezed user uuid of this set type link
	 */
	@Override
	public String getFreezedUserUuid() {
		return model.getFreezedUserUuid();
	}

	/**
	 * Returns the group ID of this set type link.
	 *
	 * @return the group ID of this set type link
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the order of this set type link.
	 *
	 * @return the order of this set type link
	 */
	@Override
	public int getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the primary key of this set type link.
	 *
	 * @return the primary key of this set type link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the set type link ID of this set type link.
	 *
	 * @return the set type link ID of this set type link
	 */
	@Override
	public long getSetTypeLinkId() {
		return model.getSetTypeLinkId();
	}

	/**
	 * Returns the verifiable of this set type link.
	 *
	 * @return the verifiable of this set type link
	 */
	@Override
	public boolean getVerifiable() {
		return model.getVerifiable();
	}

	/**
	 * Returns the verified of this set type link.
	 *
	 * @return the verified of this set type link
	 */
	@Override
	public boolean getVerified() {
		return model.getVerified();
	}

	/**
	 * Returns the verified date of this set type link.
	 *
	 * @return the verified date of this set type link
	 */
	@Override
	public Date getVerifiedDate() {
		return model.getVerifiedDate();
	}

	/**
	 * Returns the verified user ID of this set type link.
	 *
	 * @return the verified user ID of this set type link
	 */
	@Override
	public long getVerifiedUserId() {
		return model.getVerifiedUserId();
	}

	/**
	 * Returns the verified user name of this set type link.
	 *
	 * @return the verified user name of this set type link
	 */
	@Override
	public String getVerifiedUserName() {
		return model.getVerifiedUserName();
	}

	/**
	 * Returns the verified user uuid of this set type link.
	 *
	 * @return the verified user uuid of this set type link
	 */
	@Override
	public String getVerifiedUserUuid() {
		return model.getVerifiedUserUuid();
	}

	/**
	 * Returns <code>true</code> if this set type link is commentable.
	 *
	 * @return <code>true</code> if this set type link is commentable; <code>false</code> otherwise
	 */
	@Override
	public boolean isCommentable() {
		return model.isCommentable();
	}

	/**
	 * Returns <code>true</code> if this set type link is freezable.
	 *
	 * @return <code>true</code> if this set type link is freezable; <code>false</code> otherwise
	 */
	@Override
	public boolean isFreezable() {
		return model.isFreezable();
	}

	/**
	 * Returns <code>true</code> if this set type link is freezed.
	 *
	 * @return <code>true</code> if this set type link is freezed; <code>false</code> otherwise
	 */
	@Override
	public boolean isFreezed() {
		return model.isFreezed();
	}

	/**
	 * Returns <code>true</code> if this set type link is verifiable.
	 *
	 * @return <code>true</code> if this set type link is verifiable; <code>false</code> otherwise
	 */
	@Override
	public boolean isVerifiable() {
		return model.isVerifiable();
	}

	/**
	 * Returns <code>true</code> if this set type link is verified.
	 *
	 * @return <code>true</code> if this set type link is verified; <code>false</code> otherwise
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
	 * Sets whether this set type link is commentable.
	 *
	 * @param commentable the commentable of this set type link
	 */
	@Override
	public void setCommentable(boolean commentable) {
		model.setCommentable(commentable);
	}

	/**
	 * Sets the company ID of this set type link.
	 *
	 * @param companyId the company ID of this set type link
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the data collection ID of this set type link.
	 *
	 * @param dataCollectionId the data collection ID of this set type link
	 */
	@Override
	public void setDataCollectionId(long dataCollectionId) {
		model.setDataCollectionId(dataCollectionId);
	}

	/**
	 * Sets the data set ID of this set type link.
	 *
	 * @param dataSetId the data set ID of this set type link
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets the data type ID of this set type link.
	 *
	 * @param dataTypeId the data type ID of this set type link
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets whether this set type link is freezable.
	 *
	 * @param freezable the freezable of this set type link
	 */
	@Override
	public void setFreezable(boolean freezable) {
		model.setFreezable(freezable);
	}

	/**
	 * Sets whether this set type link is freezed.
	 *
	 * @param freezed the freezed of this set type link
	 */
	@Override
	public void setFreezed(boolean freezed) {
		model.setFreezed(freezed);
	}

	/**
	 * Sets the freezed date of this set type link.
	 *
	 * @param freezedDate the freezed date of this set type link
	 */
	@Override
	public void setFreezedDate(Date freezedDate) {
		model.setFreezedDate(freezedDate);
	}

	/**
	 * Sets the freezed user ID of this set type link.
	 *
	 * @param freezedUserId the freezed user ID of this set type link
	 */
	@Override
	public void setFreezedUserId(long freezedUserId) {
		model.setFreezedUserId(freezedUserId);
	}

	/**
	 * Sets the freezed user name of this set type link.
	 *
	 * @param freezedUserName the freezed user name of this set type link
	 */
	@Override
	public void setFreezedUserName(String freezedUserName) {
		model.setFreezedUserName(freezedUserName);
	}

	/**
	 * Sets the freezed user uuid of this set type link.
	 *
	 * @param freezedUserUuid the freezed user uuid of this set type link
	 */
	@Override
	public void setFreezedUserUuid(String freezedUserUuid) {
		model.setFreezedUserUuid(freezedUserUuid);
	}

	/**
	 * Sets the group ID of this set type link.
	 *
	 * @param groupId the group ID of this set type link
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the order of this set type link.
	 *
	 * @param order the order of this set type link
	 */
	@Override
	public void setOrder(int order) {
		model.setOrder(order);
	}

	/**
	 * Sets the primary key of this set type link.
	 *
	 * @param primaryKey the primary key of this set type link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the set type link ID of this set type link.
	 *
	 * @param setTypeLinkId the set type link ID of this set type link
	 */
	@Override
	public void setSetTypeLinkId(long setTypeLinkId) {
		model.setSetTypeLinkId(setTypeLinkId);
	}

	/**
	 * Sets whether this set type link is verifiable.
	 *
	 * @param verifiable the verifiable of this set type link
	 */
	@Override
	public void setVerifiable(boolean verifiable) {
		model.setVerifiable(verifiable);
	}

	/**
	 * Sets whether this set type link is verified.
	 *
	 * @param verified the verified of this set type link
	 */
	@Override
	public void setVerified(boolean verified) {
		model.setVerified(verified);
	}

	/**
	 * Sets the verified date of this set type link.
	 *
	 * @param verifiedDate the verified date of this set type link
	 */
	@Override
	public void setVerifiedDate(Date verifiedDate) {
		model.setVerifiedDate(verifiedDate);
	}

	/**
	 * Sets the verified user ID of this set type link.
	 *
	 * @param verifiedUserId the verified user ID of this set type link
	 */
	@Override
	public void setVerifiedUserId(long verifiedUserId) {
		model.setVerifiedUserId(verifiedUserId);
	}

	/**
	 * Sets the verified user name of this set type link.
	 *
	 * @param verifiedUserName the verified user name of this set type link
	 */
	@Override
	public void setVerifiedUserName(String verifiedUserName) {
		model.setVerifiedUserName(verifiedUserName);
	}

	/**
	 * Sets the verified user uuid of this set type link.
	 *
	 * @param verifiedUserUuid the verified user uuid of this set type link
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
	protected SetTypeLinkWrapper wrap(SetTypeLink setTypeLink) {
		return new SetTypeLinkWrapper(setTypeLink);
	}

}