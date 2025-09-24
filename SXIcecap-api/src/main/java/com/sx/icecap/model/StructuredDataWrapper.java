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
 * This class is a wrapper for {@link StructuredData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StructuredData
 * @generated
 */
public class StructuredDataWrapper
	extends BaseModelWrapper<StructuredData>
	implements ModelWrapper<StructuredData>, StructuredData {

	public StructuredDataWrapper(StructuredData structuredData) {
		super(structuredData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("structuredDataId", getStructuredDataId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("dataCollectionId", getDataCollectionId());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("multiple", isMultiple());
		attributes.put("startIndex", getStartIndex());
		attributes.put("count", getCount());
		attributes.put("freezed", isFreezed());
		attributes.put("freezedUserId", getFreezedUserId());
		attributes.put("freezedUserName", getFreezedUserName());
		attributes.put("freezedDate", getFreezedDate());
		attributes.put("verified", isVerified());
		attributes.put("verifiedUserId", getVerifiedUserId());
		attributes.put("verifiedUserName", getVerifiedUserName());
		attributes.put("verifiedDate", getVerifiedDate());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long structuredDataId = (Long)attributes.get("structuredDataId");

		if (structuredDataId != null) {
			setStructuredDataId(structuredDataId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Boolean multiple = (Boolean)attributes.get("multiple");

		if (multiple != null) {
			setMultiple(multiple);
		}

		Long startIndex = (Long)attributes.get("startIndex");

		if (startIndex != null) {
			setStartIndex(startIndex);
		}

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
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

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	/**
	 * Returns the company ID of this structured data.
	 *
	 * @return the company ID of this structured data
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the count of this structured data.
	 *
	 * @return the count of this structured data
	 */
	@Override
	public int getCount() {
		return model.getCount();
	}

	/**
	 * Returns the create date of this structured data.
	 *
	 * @return the create date of this structured data
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data of this structured data.
	 *
	 * @return the data of this structured data
	 */
	@Override
	public String getData() {
		return model.getData();
	}

	/**
	 * Returns the data collection ID of this structured data.
	 *
	 * @return the data collection ID of this structured data
	 */
	@Override
	public long getDataCollectionId() {
		return model.getDataCollectionId();
	}

	/**
	 * Returns the data set ID of this structured data.
	 *
	 * @return the data set ID of this structured data
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the data type ID of this structured data.
	 *
	 * @return the data type ID of this structured data
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the freezed of this structured data.
	 *
	 * @return the freezed of this structured data
	 */
	@Override
	public boolean getFreezed() {
		return model.getFreezed();
	}

	/**
	 * Returns the freezed date of this structured data.
	 *
	 * @return the freezed date of this structured data
	 */
	@Override
	public Date getFreezedDate() {
		return model.getFreezedDate();
	}

	/**
	 * Returns the freezed user ID of this structured data.
	 *
	 * @return the freezed user ID of this structured data
	 */
	@Override
	public long getFreezedUserId() {
		return model.getFreezedUserId();
	}

	/**
	 * Returns the freezed user name of this structured data.
	 *
	 * @return the freezed user name of this structured data
	 */
	@Override
	public String getFreezedUserName() {
		return model.getFreezedUserName();
	}

	/**
	 * Returns the freezed user uuid of this structured data.
	 *
	 * @return the freezed user uuid of this structured data
	 */
	@Override
	public String getFreezedUserUuid() {
		return model.getFreezedUserUuid();
	}

	/**
	 * Returns the group ID of this structured data.
	 *
	 * @return the group ID of this structured data
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this structured data.
	 *
	 * @return the modified date of this structured data
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the multiple of this structured data.
	 *
	 * @return the multiple of this structured data
	 */
	@Override
	public boolean getMultiple() {
		return model.getMultiple();
	}

	/**
	 * Returns the primary key of this structured data.
	 *
	 * @return the primary key of this structured data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start index of this structured data.
	 *
	 * @return the start index of this structured data
	 */
	@Override
	public long getStartIndex() {
		return model.getStartIndex();
	}

	/**
	 * Returns the status of this structured data.
	 *
	 * @return the status of this structured data
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this structured data.
	 *
	 * @return the status by user ID of this structured data
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this structured data.
	 *
	 * @return the status by user name of this structured data
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this structured data.
	 *
	 * @return the status by user uuid of this structured data
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this structured data.
	 *
	 * @return the status date of this structured data
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the structured data ID of this structured data.
	 *
	 * @return the structured data ID of this structured data
	 */
	@Override
	public long getStructuredDataId() {
		return model.getStructuredDataId();
	}

	/**
	 * Returns the trash entry created when this structured data was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this structured data.
	 *
	 * @return the trash entry created when this structured data was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this structured data.
	 *
	 * @return the class primary key of the trash entry for this structured data
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this structured data.
	 *
	 * @return the trash handler for this structured data
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this structured data.
	 *
	 * @return the user ID of this structured data
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this structured data.
	 *
	 * @return the user name of this structured data
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this structured data.
	 *
	 * @return the user uuid of this structured data
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this structured data.
	 *
	 * @return the uuid of this structured data
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the verified of this structured data.
	 *
	 * @return the verified of this structured data
	 */
	@Override
	public boolean getVerified() {
		return model.getVerified();
	}

	/**
	 * Returns the verified date of this structured data.
	 *
	 * @return the verified date of this structured data
	 */
	@Override
	public Date getVerifiedDate() {
		return model.getVerifiedDate();
	}

	/**
	 * Returns the verified user ID of this structured data.
	 *
	 * @return the verified user ID of this structured data
	 */
	@Override
	public long getVerifiedUserId() {
		return model.getVerifiedUserId();
	}

	/**
	 * Returns the verified user name of this structured data.
	 *
	 * @return the verified user name of this structured data
	 */
	@Override
	public String getVerifiedUserName() {
		return model.getVerifiedUserName();
	}

	/**
	 * Returns the verified user uuid of this structured data.
	 *
	 * @return the verified user uuid of this structured data
	 */
	@Override
	public String getVerifiedUserUuid() {
		return model.getVerifiedUserUuid();
	}

	/**
	 * Returns <code>true</code> if this structured data is approved.
	 *
	 * @return <code>true</code> if this structured data is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this structured data is denied.
	 *
	 * @return <code>true</code> if this structured data is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this structured data is a draft.
	 *
	 * @return <code>true</code> if this structured data is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this structured data is expired.
	 *
	 * @return <code>true</code> if this structured data is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this structured data is freezed.
	 *
	 * @return <code>true</code> if this structured data is freezed; <code>false</code> otherwise
	 */
	@Override
	public boolean isFreezed() {
		return model.isFreezed();
	}

	/**
	 * Returns <code>true</code> if this structured data is inactive.
	 *
	 * @return <code>true</code> if this structured data is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this structured data is incomplete.
	 *
	 * @return <code>true</code> if this structured data is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this structured data is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this structured data is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this structured data is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this structured data is in the Recycle Bin; <code>false</code> otherwise
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
	 * Returns <code>true</code> if this structured data is multiple.
	 *
	 * @return <code>true</code> if this structured data is multiple; <code>false</code> otherwise
	 */
	@Override
	public boolean isMultiple() {
		return model.isMultiple();
	}

	/**
	 * Returns <code>true</code> if this structured data is pending.
	 *
	 * @return <code>true</code> if this structured data is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this structured data is scheduled.
	 *
	 * @return <code>true</code> if this structured data is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	/**
	 * Returns <code>true</code> if this structured data is verified.
	 *
	 * @return <code>true</code> if this structured data is verified; <code>false</code> otherwise
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
	 * Sets the company ID of this structured data.
	 *
	 * @param companyId the company ID of this structured data
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the count of this structured data.
	 *
	 * @param count the count of this structured data
	 */
	@Override
	public void setCount(int count) {
		model.setCount(count);
	}

	/**
	 * Sets the create date of this structured data.
	 *
	 * @param createDate the create date of this structured data
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data of this structured data.
	 *
	 * @param data the data of this structured data
	 */
	@Override
	public void setData(String data) {
		model.setData(data);
	}

	/**
	 * Sets the data collection ID of this structured data.
	 *
	 * @param dataCollectionId the data collection ID of this structured data
	 */
	@Override
	public void setDataCollectionId(long dataCollectionId) {
		model.setDataCollectionId(dataCollectionId);
	}

	/**
	 * Sets the data set ID of this structured data.
	 *
	 * @param dataSetId the data set ID of this structured data
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets the data type ID of this structured data.
	 *
	 * @param dataTypeId the data type ID of this structured data
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets whether this structured data is freezed.
	 *
	 * @param freezed the freezed of this structured data
	 */
	@Override
	public void setFreezed(boolean freezed) {
		model.setFreezed(freezed);
	}

	/**
	 * Sets the freezed date of this structured data.
	 *
	 * @param freezedDate the freezed date of this structured data
	 */
	@Override
	public void setFreezedDate(Date freezedDate) {
		model.setFreezedDate(freezedDate);
	}

	/**
	 * Sets the freezed user ID of this structured data.
	 *
	 * @param freezedUserId the freezed user ID of this structured data
	 */
	@Override
	public void setFreezedUserId(long freezedUserId) {
		model.setFreezedUserId(freezedUserId);
	}

	/**
	 * Sets the freezed user name of this structured data.
	 *
	 * @param freezedUserName the freezed user name of this structured data
	 */
	@Override
	public void setFreezedUserName(String freezedUserName) {
		model.setFreezedUserName(freezedUserName);
	}

	/**
	 * Sets the freezed user uuid of this structured data.
	 *
	 * @param freezedUserUuid the freezed user uuid of this structured data
	 */
	@Override
	public void setFreezedUserUuid(String freezedUserUuid) {
		model.setFreezedUserUuid(freezedUserUuid);
	}

	/**
	 * Sets the group ID of this structured data.
	 *
	 * @param groupId the group ID of this structured data
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this structured data.
	 *
	 * @param modifiedDate the modified date of this structured data
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets whether this structured data is multiple.
	 *
	 * @param multiple the multiple of this structured data
	 */
	@Override
	public void setMultiple(boolean multiple) {
		model.setMultiple(multiple);
	}

	/**
	 * Sets the primary key of this structured data.
	 *
	 * @param primaryKey the primary key of this structured data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start index of this structured data.
	 *
	 * @param startIndex the start index of this structured data
	 */
	@Override
	public void setStartIndex(long startIndex) {
		model.setStartIndex(startIndex);
	}

	/**
	 * Sets the status of this structured data.
	 *
	 * @param status the status of this structured data
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this structured data.
	 *
	 * @param statusByUserId the status by user ID of this structured data
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this structured data.
	 *
	 * @param statusByUserName the status by user name of this structured data
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this structured data.
	 *
	 * @param statusByUserUuid the status by user uuid of this structured data
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this structured data.
	 *
	 * @param statusDate the status date of this structured data
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the structured data ID of this structured data.
	 *
	 * @param structuredDataId the structured data ID of this structured data
	 */
	@Override
	public void setStructuredDataId(long structuredDataId) {
		model.setStructuredDataId(structuredDataId);
	}

	/**
	 * Sets the user ID of this structured data.
	 *
	 * @param userId the user ID of this structured data
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this structured data.
	 *
	 * @param userName the user name of this structured data
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this structured data.
	 *
	 * @param userUuid the user uuid of this structured data
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this structured data.
	 *
	 * @param uuid the uuid of this structured data
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets whether this structured data is verified.
	 *
	 * @param verified the verified of this structured data
	 */
	@Override
	public void setVerified(boolean verified) {
		model.setVerified(verified);
	}

	/**
	 * Sets the verified date of this structured data.
	 *
	 * @param verifiedDate the verified date of this structured data
	 */
	@Override
	public void setVerifiedDate(Date verifiedDate) {
		model.setVerifiedDate(verifiedDate);
	}

	/**
	 * Sets the verified user ID of this structured data.
	 *
	 * @param verifiedUserId the verified user ID of this structured data
	 */
	@Override
	public void setVerifiedUserId(long verifiedUserId) {
		model.setVerifiedUserId(verifiedUserId);
	}

	/**
	 * Sets the verified user name of this structured data.
	 *
	 * @param verifiedUserName the verified user name of this structured data
	 */
	@Override
	public void setVerifiedUserName(String verifiedUserName) {
		model.setVerifiedUserName(verifiedUserName);
	}

	/**
	 * Sets the verified user uuid of this structured data.
	 *
	 * @param verifiedUserUuid the verified user uuid of this structured data
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
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected StructuredDataWrapper wrap(StructuredData structuredData) {
		return new StructuredDataWrapper(structuredData);
	}

}