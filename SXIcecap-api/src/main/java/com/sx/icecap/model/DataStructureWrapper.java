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
 * This class is a wrapper for {@link DataStructure}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataStructure
 * @generated
 */
public class DataStructureWrapper
	extends BaseModelWrapper<DataStructure>
	implements DataStructure, ModelWrapper<DataStructure> {

	public DataStructureWrapper(DataStructure dataStructure) {
		super(dataStructure);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("lastPublishDate", getLastPublishDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("dataStructureId", getDataStructureId());
		attributes.put("dataStructureName", getDataStructureName());
		attributes.put("dataStructureVersion", getDataStructureVersion());
		attributes.put("displayName", getDisplayName());
		attributes.put("description", getDescription());
		attributes.put("structure", getStructure());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
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

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
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

		Long dataStructureId = (Long)attributes.get("dataStructureId");

		if (dataStructureId != null) {
			setDataStructureId(dataStructureId);
		}

		String dataStructureName = (String)attributes.get("dataStructureName");

		if (dataStructureName != null) {
			setDataStructureName(dataStructureName);
		}

		String dataStructureVersion = (String)attributes.get(
			"dataStructureVersion");

		if (dataStructureVersion != null) {
			setDataStructureVersion(dataStructureVersion);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String structure = (String)attributes.get("structure");

		if (structure != null) {
			setStructure(structure);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this data structure.
	 *
	 * @return the company ID of this data structure
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this data structure.
	 *
	 * @return the create date of this data structure
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data structure ID of this data structure.
	 *
	 * @return the data structure ID of this data structure
	 */
	@Override
	public long getDataStructureId() {
		return model.getDataStructureId();
	}

	/**
	 * Returns the data structure name of this data structure.
	 *
	 * @return the data structure name of this data structure
	 */
	@Override
	public String getDataStructureName() {
		return model.getDataStructureName();
	}

	/**
	 * Returns the data structure version of this data structure.
	 *
	 * @return the data structure version of this data structure
	 */
	@Override
	public String getDataStructureVersion() {
		return model.getDataStructureVersion();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this data structure.
	 *
	 * @return the description of this data structure
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this data structure in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this data structure
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this data structure in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this data structure. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this data structure in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this data structure
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this data structure in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this data structure
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return model.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return model.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this data structure.
	 *
	 * @return the locales and localized descriptions of this data structure
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the display name of this data structure.
	 *
	 * @return the display name of this data structure
	 */
	@Override
	public String getDisplayName() {
		return model.getDisplayName();
	}

	/**
	 * Returns the localized display name of this data structure in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized display name of this data structure
	 */
	@Override
	public String getDisplayName(java.util.Locale locale) {
		return model.getDisplayName(locale);
	}

	/**
	 * Returns the localized display name of this data structure in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this data structure. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDisplayName(java.util.Locale locale, boolean useDefault) {
		return model.getDisplayName(locale, useDefault);
	}

	/**
	 * Returns the localized display name of this data structure in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized display name of this data structure
	 */
	@Override
	public String getDisplayName(String languageId) {
		return model.getDisplayName(languageId);
	}

	/**
	 * Returns the localized display name of this data structure in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this data structure
	 */
	@Override
	public String getDisplayName(String languageId, boolean useDefault) {
		return model.getDisplayName(languageId, useDefault);
	}

	@Override
	public String getDisplayNameCurrentLanguageId() {
		return model.getDisplayNameCurrentLanguageId();
	}

	@Override
	public String getDisplayNameCurrentValue() {
		return model.getDisplayNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized display names of this data structure.
	 *
	 * @return the locales and localized display names of this data structure
	 */
	@Override
	public Map<java.util.Locale, String> getDisplayNameMap() {
		return model.getDisplayNameMap();
	}

	/**
	 * Returns the group ID of this data structure.
	 *
	 * @return the group ID of this data structure
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last publish date of this data structure.
	 *
	 * @return the last publish date of this data structure
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Returns the modified date of this data structure.
	 *
	 * @return the modified date of this data structure
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this data structure.
	 *
	 * @return the primary key of this data structure
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this data structure.
	 *
	 * @return the status of this data structure
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this data structure.
	 *
	 * @return the status by user ID of this data structure
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this data structure.
	 *
	 * @return the status by user name of this data structure
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this data structure.
	 *
	 * @return the status by user uuid of this data structure
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this data structure.
	 *
	 * @return the status date of this data structure
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the structure of this data structure.
	 *
	 * @return the structure of this data structure
	 */
	@Override
	public String getStructure() {
		return model.getStructure();
	}

	/**
	 * Returns the trash entry created when this data structure was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this data structure.
	 *
	 * @return the trash entry created when this data structure was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this data structure.
	 *
	 * @return the class primary key of the trash entry for this data structure
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this data structure.
	 *
	 * @return the trash handler for this data structure
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this data structure.
	 *
	 * @return the user ID of this data structure
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this data structure.
	 *
	 * @return the user name of this data structure
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this data structure.
	 *
	 * @return the user uuid of this data structure
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this data structure.
	 *
	 * @return the uuid of this data structure
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this data structure is approved.
	 *
	 * @return <code>true</code> if this data structure is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this data structure is denied.
	 *
	 * @return <code>true</code> if this data structure is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this data structure is a draft.
	 *
	 * @return <code>true</code> if this data structure is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this data structure is expired.
	 *
	 * @return <code>true</code> if this data structure is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this data structure is inactive.
	 *
	 * @return <code>true</code> if this data structure is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this data structure is incomplete.
	 *
	 * @return <code>true</code> if this data structure is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this data structure is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this data structure is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this data structure is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this data structure is in the Recycle Bin; <code>false</code> otherwise
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
	 * Returns <code>true</code> if this data structure is pending.
	 *
	 * @return <code>true</code> if this data structure is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this data structure is scheduled.
	 *
	 * @return <code>true</code> if this data structure is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the company ID of this data structure.
	 *
	 * @param companyId the company ID of this data structure
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this data structure.
	 *
	 * @param createDate the create date of this data structure
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data structure ID of this data structure.
	 *
	 * @param dataStructureId the data structure ID of this data structure
	 */
	@Override
	public void setDataStructureId(long dataStructureId) {
		model.setDataStructureId(dataStructureId);
	}

	/**
	 * Sets the data structure name of this data structure.
	 *
	 * @param dataStructureName the data structure name of this data structure
	 */
	@Override
	public void setDataStructureName(String dataStructureName) {
		model.setDataStructureName(dataStructureName);
	}

	/**
	 * Sets the data structure version of this data structure.
	 *
	 * @param dataStructureVersion the data structure version of this data structure
	 */
	@Override
	public void setDataStructureVersion(String dataStructureVersion) {
		model.setDataStructureVersion(dataStructureVersion);
	}

	/**
	 * Sets the description of this data structure.
	 *
	 * @param description the description of this data structure
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this data structure in the language.
	 *
	 * @param description the localized description of this data structure
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this data structure in the language, and sets the default locale.
	 *
	 * @param description the localized description of this data structure
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this data structure from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this data structure
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this data structure from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this data structure
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the display name of this data structure.
	 *
	 * @param displayName the display name of this data structure
	 */
	@Override
	public void setDisplayName(String displayName) {
		model.setDisplayName(displayName);
	}

	/**
	 * Sets the localized display name of this data structure in the language.
	 *
	 * @param displayName the localized display name of this data structure
	 * @param locale the locale of the language
	 */
	@Override
	public void setDisplayName(String displayName, java.util.Locale locale) {
		model.setDisplayName(displayName, locale);
	}

	/**
	 * Sets the localized display name of this data structure in the language, and sets the default locale.
	 *
	 * @param displayName the localized display name of this data structure
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDisplayName(
		String displayName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDisplayName(displayName, locale, defaultLocale);
	}

	@Override
	public void setDisplayNameCurrentLanguageId(String languageId) {
		model.setDisplayNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized display names of this data structure from the map of locales and localized display names.
	 *
	 * @param displayNameMap the locales and localized display names of this data structure
	 */
	@Override
	public void setDisplayNameMap(
		Map<java.util.Locale, String> displayNameMap) {

		model.setDisplayNameMap(displayNameMap);
	}

	/**
	 * Sets the localized display names of this data structure from the map of locales and localized display names, and sets the default locale.
	 *
	 * @param displayNameMap the locales and localized display names of this data structure
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDisplayNameMap(
		Map<java.util.Locale, String> displayNameMap,
		java.util.Locale defaultLocale) {

		model.setDisplayNameMap(displayNameMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this data structure.
	 *
	 * @param groupId the group ID of this data structure
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last publish date of this data structure.
	 *
	 * @param lastPublishDate the last publish date of this data structure
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this data structure.
	 *
	 * @param modifiedDate the modified date of this data structure
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this data structure.
	 *
	 * @param primaryKey the primary key of this data structure
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this data structure.
	 *
	 * @param status the status of this data structure
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this data structure.
	 *
	 * @param statusByUserId the status by user ID of this data structure
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this data structure.
	 *
	 * @param statusByUserName the status by user name of this data structure
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this data structure.
	 *
	 * @param statusByUserUuid the status by user uuid of this data structure
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this data structure.
	 *
	 * @param statusDate the status date of this data structure
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the structure of this data structure.
	 *
	 * @param structure the structure of this data structure
	 */
	@Override
	public void setStructure(String structure) {
		model.setStructure(structure);
	}

	/**
	 * Sets the user ID of this data structure.
	 *
	 * @param userId the user ID of this data structure
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this data structure.
	 *
	 * @param userName the user name of this data structure
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this data structure.
	 *
	 * @param userUuid the user uuid of this data structure
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this data structure.
	 *
	 * @param uuid the uuid of this data structure
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
	public com.liferay.portal.kernel.json.JSONObject toJSON(
		java.util.Locale locale) {

		return model.toJSON(locale);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DataStructureWrapper wrap(DataStructure dataStructure) {
		return new DataStructureWrapper(dataStructure);
	}

}