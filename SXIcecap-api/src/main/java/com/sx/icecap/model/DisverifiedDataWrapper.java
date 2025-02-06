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
 * This class is a wrapper for {@link DisverifiedData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DisverifiedData
 * @generated
 */
public class DisverifiedDataWrapper
	extends BaseModelWrapper<DisverifiedData>
	implements DisverifiedData, ModelWrapper<DisverifiedData> {

	public DisverifiedDataWrapper(DisverifiedData disverifiedData) {
		super(disverifiedData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("disverifiedDataId", getDisverifiedDataId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("folderId", getFolderId());
		attributes.put("tempDataTitle", getTempDataTitle());
		attributes.put("dataSetDisplayName", getDataSetDisplayName());
		attributes.put("dataTypeDisplayName", getDataTypeDisplayName());
		attributes.put("folderName", getFolderName());
		attributes.put("structuredData", getStructuredData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long disverifiedDataId = (Long)attributes.get("disverifiedDataId");

		if (disverifiedDataId != null) {
			setDisverifiedDataId(disverifiedDataId);
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

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		String tempDataTitle = (String)attributes.get("tempDataTitle");

		if (tempDataTitle != null) {
			setTempDataTitle(tempDataTitle);
		}

		String dataSetDisplayName = (String)attributes.get(
			"dataSetDisplayName");

		if (dataSetDisplayName != null) {
			setDataSetDisplayName(dataSetDisplayName);
		}

		String dataTypeDisplayName = (String)attributes.get(
			"dataTypeDisplayName");

		if (dataTypeDisplayName != null) {
			setDataTypeDisplayName(dataTypeDisplayName);
		}

		String folderName = (String)attributes.get("folderName");

		if (folderName != null) {
			setFolderName(folderName);
		}

		String structuredData = (String)attributes.get("structuredData");

		if (structuredData != null) {
			setStructuredData(structuredData);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this disverified data.
	 *
	 * @return the company ID of this disverified data
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this disverified data.
	 *
	 * @return the create date of this disverified data
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data set display name of this disverified data.
	 *
	 * @return the data set display name of this disverified data
	 */
	@Override
	public String getDataSetDisplayName() {
		return model.getDataSetDisplayName();
	}

	/**
	 * Returns the localized data set display name of this disverified data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized data set display name of this disverified data
	 */
	@Override
	public String getDataSetDisplayName(java.util.Locale locale) {
		return model.getDataSetDisplayName(locale);
	}

	/**
	 * Returns the localized data set display name of this disverified data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data set display name of this disverified data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDataSetDisplayName(
		java.util.Locale locale, boolean useDefault) {

		return model.getDataSetDisplayName(locale, useDefault);
	}

	/**
	 * Returns the localized data set display name of this disverified data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized data set display name of this disverified data
	 */
	@Override
	public String getDataSetDisplayName(String languageId) {
		return model.getDataSetDisplayName(languageId);
	}

	/**
	 * Returns the localized data set display name of this disverified data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data set display name of this disverified data
	 */
	@Override
	public String getDataSetDisplayName(String languageId, boolean useDefault) {
		return model.getDataSetDisplayName(languageId, useDefault);
	}

	@Override
	public String getDataSetDisplayNameCurrentLanguageId() {
		return model.getDataSetDisplayNameCurrentLanguageId();
	}

	@Override
	public String getDataSetDisplayNameCurrentValue() {
		return model.getDataSetDisplayNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized data set display names of this disverified data.
	 *
	 * @return the locales and localized data set display names of this disverified data
	 */
	@Override
	public Map<java.util.Locale, String> getDataSetDisplayNameMap() {
		return model.getDataSetDisplayNameMap();
	}

	/**
	 * Returns the data set ID of this disverified data.
	 *
	 * @return the data set ID of this disverified data
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the data type display name of this disverified data.
	 *
	 * @return the data type display name of this disverified data
	 */
	@Override
	public String getDataTypeDisplayName() {
		return model.getDataTypeDisplayName();
	}

	/**
	 * Returns the localized data type display name of this disverified data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized data type display name of this disverified data
	 */
	@Override
	public String getDataTypeDisplayName(java.util.Locale locale) {
		return model.getDataTypeDisplayName(locale);
	}

	/**
	 * Returns the localized data type display name of this disverified data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data type display name of this disverified data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDataTypeDisplayName(
		java.util.Locale locale, boolean useDefault) {

		return model.getDataTypeDisplayName(locale, useDefault);
	}

	/**
	 * Returns the localized data type display name of this disverified data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized data type display name of this disverified data
	 */
	@Override
	public String getDataTypeDisplayName(String languageId) {
		return model.getDataTypeDisplayName(languageId);
	}

	/**
	 * Returns the localized data type display name of this disverified data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data type display name of this disverified data
	 */
	@Override
	public String getDataTypeDisplayName(
		String languageId, boolean useDefault) {

		return model.getDataTypeDisplayName(languageId, useDefault);
	}

	@Override
	public String getDataTypeDisplayNameCurrentLanguageId() {
		return model.getDataTypeDisplayNameCurrentLanguageId();
	}

	@Override
	public String getDataTypeDisplayNameCurrentValue() {
		return model.getDataTypeDisplayNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized data type display names of this disverified data.
	 *
	 * @return the locales and localized data type display names of this disverified data
	 */
	@Override
	public Map<java.util.Locale, String> getDataTypeDisplayNameMap() {
		return model.getDataTypeDisplayNameMap();
	}

	/**
	 * Returns the data type ID of this disverified data.
	 *
	 * @return the data type ID of this disverified data
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the disverified data ID of this disverified data.
	 *
	 * @return the disverified data ID of this disverified data
	 */
	@Override
	public long getDisverifiedDataId() {
		return model.getDisverifiedDataId();
	}

	/**
	 * Returns the folder ID of this disverified data.
	 *
	 * @return the folder ID of this disverified data
	 */
	@Override
	public long getFolderId() {
		return model.getFolderId();
	}

	/**
	 * Returns the folder name of this disverified data.
	 *
	 * @return the folder name of this disverified data
	 */
	@Override
	public String getFolderName() {
		return model.getFolderName();
	}

	/**
	 * Returns the localized folder name of this disverified data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized folder name of this disverified data
	 */
	@Override
	public String getFolderName(java.util.Locale locale) {
		return model.getFolderName(locale);
	}

	/**
	 * Returns the localized folder name of this disverified data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized folder name of this disverified data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getFolderName(java.util.Locale locale, boolean useDefault) {
		return model.getFolderName(locale, useDefault);
	}

	/**
	 * Returns the localized folder name of this disverified data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized folder name of this disverified data
	 */
	@Override
	public String getFolderName(String languageId) {
		return model.getFolderName(languageId);
	}

	/**
	 * Returns the localized folder name of this disverified data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized folder name of this disverified data
	 */
	@Override
	public String getFolderName(String languageId, boolean useDefault) {
		return model.getFolderName(languageId, useDefault);
	}

	@Override
	public String getFolderNameCurrentLanguageId() {
		return model.getFolderNameCurrentLanguageId();
	}

	@Override
	public String getFolderNameCurrentValue() {
		return model.getFolderNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized folder names of this disverified data.
	 *
	 * @return the locales and localized folder names of this disverified data
	 */
	@Override
	public Map<java.util.Locale, String> getFolderNameMap() {
		return model.getFolderNameMap();
	}

	/**
	 * Returns the group ID of this disverified data.
	 *
	 * @return the group ID of this disverified data
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this disverified data.
	 *
	 * @return the modified date of this disverified data
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this disverified data.
	 *
	 * @return the primary key of this disverified data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this disverified data.
	 *
	 * @return the status of this disverified data
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the structured data of this disverified data.
	 *
	 * @return the structured data of this disverified data
	 */
	@Override
	public String getStructuredData() {
		return model.getStructuredData();
	}

	/**
	 * Returns the temp data title of this disverified data.
	 *
	 * @return the temp data title of this disverified data
	 */
	@Override
	public String getTempDataTitle() {
		return model.getTempDataTitle();
	}

	/**
	 * Returns the user ID of this disverified data.
	 *
	 * @return the user ID of this disverified data
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this disverified data.
	 *
	 * @return the user name of this disverified data
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this disverified data.
	 *
	 * @return the user uuid of this disverified data
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
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
	 * Sets the company ID of this disverified data.
	 *
	 * @param companyId the company ID of this disverified data
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this disverified data.
	 *
	 * @param createDate the create date of this disverified data
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data set display name of this disverified data.
	 *
	 * @param dataSetDisplayName the data set display name of this disverified data
	 */
	@Override
	public void setDataSetDisplayName(String dataSetDisplayName) {
		model.setDataSetDisplayName(dataSetDisplayName);
	}

	/**
	 * Sets the localized data set display name of this disverified data in the language.
	 *
	 * @param dataSetDisplayName the localized data set display name of this disverified data
	 * @param locale the locale of the language
	 */
	@Override
	public void setDataSetDisplayName(
		String dataSetDisplayName, java.util.Locale locale) {

		model.setDataSetDisplayName(dataSetDisplayName, locale);
	}

	/**
	 * Sets the localized data set display name of this disverified data in the language, and sets the default locale.
	 *
	 * @param dataSetDisplayName the localized data set display name of this disverified data
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataSetDisplayName(
		String dataSetDisplayName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDataSetDisplayName(dataSetDisplayName, locale, defaultLocale);
	}

	@Override
	public void setDataSetDisplayNameCurrentLanguageId(String languageId) {
		model.setDataSetDisplayNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized data set display names of this disverified data from the map of locales and localized data set display names.
	 *
	 * @param dataSetDisplayNameMap the locales and localized data set display names of this disverified data
	 */
	@Override
	public void setDataSetDisplayNameMap(
		Map<java.util.Locale, String> dataSetDisplayNameMap) {

		model.setDataSetDisplayNameMap(dataSetDisplayNameMap);
	}

	/**
	 * Sets the localized data set display names of this disverified data from the map of locales and localized data set display names, and sets the default locale.
	 *
	 * @param dataSetDisplayNameMap the locales and localized data set display names of this disverified data
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataSetDisplayNameMap(
		Map<java.util.Locale, String> dataSetDisplayNameMap,
		java.util.Locale defaultLocale) {

		model.setDataSetDisplayNameMap(dataSetDisplayNameMap, defaultLocale);
	}

	/**
	 * Sets the data set ID of this disverified data.
	 *
	 * @param dataSetId the data set ID of this disverified data
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets the data type display name of this disverified data.
	 *
	 * @param dataTypeDisplayName the data type display name of this disverified data
	 */
	@Override
	public void setDataTypeDisplayName(String dataTypeDisplayName) {
		model.setDataTypeDisplayName(dataTypeDisplayName);
	}

	/**
	 * Sets the localized data type display name of this disverified data in the language.
	 *
	 * @param dataTypeDisplayName the localized data type display name of this disverified data
	 * @param locale the locale of the language
	 */
	@Override
	public void setDataTypeDisplayName(
		String dataTypeDisplayName, java.util.Locale locale) {

		model.setDataTypeDisplayName(dataTypeDisplayName, locale);
	}

	/**
	 * Sets the localized data type display name of this disverified data in the language, and sets the default locale.
	 *
	 * @param dataTypeDisplayName the localized data type display name of this disverified data
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataTypeDisplayName(
		String dataTypeDisplayName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDataTypeDisplayName(
			dataTypeDisplayName, locale, defaultLocale);
	}

	@Override
	public void setDataTypeDisplayNameCurrentLanguageId(String languageId) {
		model.setDataTypeDisplayNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized data type display names of this disverified data from the map of locales and localized data type display names.
	 *
	 * @param dataTypeDisplayNameMap the locales and localized data type display names of this disverified data
	 */
	@Override
	public void setDataTypeDisplayNameMap(
		Map<java.util.Locale, String> dataTypeDisplayNameMap) {

		model.setDataTypeDisplayNameMap(dataTypeDisplayNameMap);
	}

	/**
	 * Sets the localized data type display names of this disverified data from the map of locales and localized data type display names, and sets the default locale.
	 *
	 * @param dataTypeDisplayNameMap the locales and localized data type display names of this disverified data
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataTypeDisplayNameMap(
		Map<java.util.Locale, String> dataTypeDisplayNameMap,
		java.util.Locale defaultLocale) {

		model.setDataTypeDisplayNameMap(dataTypeDisplayNameMap, defaultLocale);
	}

	/**
	 * Sets the data type ID of this disverified data.
	 *
	 * @param dataTypeId the data type ID of this disverified data
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the disverified data ID of this disverified data.
	 *
	 * @param disverifiedDataId the disverified data ID of this disverified data
	 */
	@Override
	public void setDisverifiedDataId(long disverifiedDataId) {
		model.setDisverifiedDataId(disverifiedDataId);
	}

	/**
	 * Sets the folder ID of this disverified data.
	 *
	 * @param folderId the folder ID of this disverified data
	 */
	@Override
	public void setFolderId(long folderId) {
		model.setFolderId(folderId);
	}

	/**
	 * Sets the folder name of this disverified data.
	 *
	 * @param folderName the folder name of this disverified data
	 */
	@Override
	public void setFolderName(String folderName) {
		model.setFolderName(folderName);
	}

	/**
	 * Sets the localized folder name of this disverified data in the language.
	 *
	 * @param folderName the localized folder name of this disverified data
	 * @param locale the locale of the language
	 */
	@Override
	public void setFolderName(String folderName, java.util.Locale locale) {
		model.setFolderName(folderName, locale);
	}

	/**
	 * Sets the localized folder name of this disverified data in the language, and sets the default locale.
	 *
	 * @param folderName the localized folder name of this disverified data
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFolderName(
		String folderName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setFolderName(folderName, locale, defaultLocale);
	}

	@Override
	public void setFolderNameCurrentLanguageId(String languageId) {
		model.setFolderNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized folder names of this disverified data from the map of locales and localized folder names.
	 *
	 * @param folderNameMap the locales and localized folder names of this disverified data
	 */
	@Override
	public void setFolderNameMap(Map<java.util.Locale, String> folderNameMap) {
		model.setFolderNameMap(folderNameMap);
	}

	/**
	 * Sets the localized folder names of this disverified data from the map of locales and localized folder names, and sets the default locale.
	 *
	 * @param folderNameMap the locales and localized folder names of this disverified data
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFolderNameMap(
		Map<java.util.Locale, String> folderNameMap,
		java.util.Locale defaultLocale) {

		model.setFolderNameMap(folderNameMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this disverified data.
	 *
	 * @param groupId the group ID of this disverified data
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this disverified data.
	 *
	 * @param modifiedDate the modified date of this disverified data
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this disverified data.
	 *
	 * @param primaryKey the primary key of this disverified data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this disverified data.
	 *
	 * @param status the status of this disverified data
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the structured data of this disverified data.
	 *
	 * @param structuredData the structured data of this disverified data
	 */
	@Override
	public void setStructuredData(String structuredData) {
		model.setStructuredData(structuredData);
	}

	/**
	 * Sets the temp data title of this disverified data.
	 *
	 * @param tempDataTitle the temp data title of this disverified data
	 */
	@Override
	public void setTempDataTitle(String tempDataTitle) {
		model.setTempDataTitle(tempDataTitle);
	}

	/**
	 * Sets the user ID of this disverified data.
	 *
	 * @param userId the user ID of this disverified data
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this disverified data.
	 *
	 * @param userName the user name of this disverified data
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this disverified data.
	 *
	 * @param userUuid the user uuid of this disverified data
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DisverifiedDataWrapper wrap(DisverifiedData disverifiedData) {
		return new DisverifiedDataWrapper(disverifiedData);
	}

}