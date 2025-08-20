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
 * This class is a wrapper for {@link Parameter}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Parameter
 * @generated
 */
public class ParameterWrapper
	extends BaseModelWrapper<Parameter>
	implements ModelWrapper<Parameter>, Parameter {

	public ParameterWrapper(Parameter parameter) {
		super(parameter);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("parameterId", getParameterId());
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
		attributes.put("paramName", getParamName());
		attributes.put("paramVersion", getParamVersion());
		attributes.put("paramType", getParamType());
		attributes.put("displayName", getDisplayName());
		attributes.put("definition", getDefinition());
		attributes.put("tooltip", getTooltip());
		attributes.put("synonyms", getSynonyms());
		attributes.put("typeProperties", getTypeProperties());
		attributes.put("standard", isStandard());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long parameterId = (Long)attributes.get("parameterId");

		if (parameterId != null) {
			setParameterId(parameterId);
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

		String paramName = (String)attributes.get("paramName");

		if (paramName != null) {
			setParamName(paramName);
		}

		String paramVersion = (String)attributes.get("paramVersion");

		if (paramVersion != null) {
			setParamVersion(paramVersion);
		}

		String paramType = (String)attributes.get("paramType");

		if (paramType != null) {
			setParamType(paramType);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		String definition = (String)attributes.get("definition");

		if (definition != null) {
			setDefinition(definition);
		}

		String tooltip = (String)attributes.get("tooltip");

		if (tooltip != null) {
			setTooltip(tooltip);
		}

		String synonyms = (String)attributes.get("synonyms");

		if (synonyms != null) {
			setSynonyms(synonyms);
		}

		String typeProperties = (String)attributes.get("typeProperties");

		if (typeProperties != null) {
			setTypeProperties(typeProperties);
		}

		Boolean standard = (Boolean)attributes.get("standard");

		if (standard != null) {
			setStandard(standard);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this parameter.
	 *
	 * @return the company ID of this parameter
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this parameter.
	 *
	 * @return the create date of this parameter
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the definition of this parameter.
	 *
	 * @return the definition of this parameter
	 */
	@Override
	public String getDefinition() {
		return model.getDefinition();
	}

	/**
	 * Returns the localized definition of this parameter in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized definition of this parameter
	 */
	@Override
	public String getDefinition(java.util.Locale locale) {
		return model.getDefinition(locale);
	}

	/**
	 * Returns the localized definition of this parameter in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized definition of this parameter. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDefinition(java.util.Locale locale, boolean useDefault) {
		return model.getDefinition(locale, useDefault);
	}

	/**
	 * Returns the localized definition of this parameter in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized definition of this parameter
	 */
	@Override
	public String getDefinition(String languageId) {
		return model.getDefinition(languageId);
	}

	/**
	 * Returns the localized definition of this parameter in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized definition of this parameter
	 */
	@Override
	public String getDefinition(String languageId, boolean useDefault) {
		return model.getDefinition(languageId, useDefault);
	}

	@Override
	public String getDefinitionCurrentLanguageId() {
		return model.getDefinitionCurrentLanguageId();
	}

	@Override
	public String getDefinitionCurrentValue() {
		return model.getDefinitionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized definitions of this parameter.
	 *
	 * @return the locales and localized definitions of this parameter
	 */
	@Override
	public Map<java.util.Locale, String> getDefinitionMap() {
		return model.getDefinitionMap();
	}

	/**
	 * Returns the display name of this parameter.
	 *
	 * @return the display name of this parameter
	 */
	@Override
	public String getDisplayName() {
		return model.getDisplayName();
	}

	/**
	 * Returns the localized display name of this parameter in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized display name of this parameter
	 */
	@Override
	public String getDisplayName(java.util.Locale locale) {
		return model.getDisplayName(locale);
	}

	/**
	 * Returns the localized display name of this parameter in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this parameter. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDisplayName(java.util.Locale locale, boolean useDefault) {
		return model.getDisplayName(locale, useDefault);
	}

	/**
	 * Returns the localized display name of this parameter in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized display name of this parameter
	 */
	@Override
	public String getDisplayName(String languageId) {
		return model.getDisplayName(languageId);
	}

	/**
	 * Returns the localized display name of this parameter in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this parameter
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
	 * Returns a map of the locales and localized display names of this parameter.
	 *
	 * @return the locales and localized display names of this parameter
	 */
	@Override
	public Map<java.util.Locale, String> getDisplayNameMap() {
		return model.getDisplayNameMap();
	}

	/**
	 * Returns the group ID of this parameter.
	 *
	 * @return the group ID of this parameter
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last publish date of this parameter.
	 *
	 * @return the last publish date of this parameter
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Returns the modified date of this parameter.
	 *
	 * @return the modified date of this parameter
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the parameter ID of this parameter.
	 *
	 * @return the parameter ID of this parameter
	 */
	@Override
	public long getParameterId() {
		return model.getParameterId();
	}

	/**
	 * Returns the param name of this parameter.
	 *
	 * @return the param name of this parameter
	 */
	@Override
	public String getParamName() {
		return model.getParamName();
	}

	/**
	 * Returns the param type of this parameter.
	 *
	 * @return the param type of this parameter
	 */
	@Override
	public String getParamType() {
		return model.getParamType();
	}

	/**
	 * Returns the param version of this parameter.
	 *
	 * @return the param version of this parameter
	 */
	@Override
	public String getParamVersion() {
		return model.getParamVersion();
	}

	/**
	 * Returns the primary key of this parameter.
	 *
	 * @return the primary key of this parameter
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the standard of this parameter.
	 *
	 * @return the standard of this parameter
	 */
	@Override
	public boolean getStandard() {
		return model.getStandard();
	}

	/**
	 * Returns the status of this parameter.
	 *
	 * @return the status of this parameter
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this parameter.
	 *
	 * @return the status by user ID of this parameter
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this parameter.
	 *
	 * @return the status by user name of this parameter
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this parameter.
	 *
	 * @return the status by user uuid of this parameter
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this parameter.
	 *
	 * @return the status date of this parameter
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the synonyms of this parameter.
	 *
	 * @return the synonyms of this parameter
	 */
	@Override
	public String getSynonyms() {
		return model.getSynonyms();
	}

	/**
	 * Returns the tooltip of this parameter.
	 *
	 * @return the tooltip of this parameter
	 */
	@Override
	public String getTooltip() {
		return model.getTooltip();
	}

	/**
	 * Returns the localized tooltip of this parameter in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized tooltip of this parameter
	 */
	@Override
	public String getTooltip(java.util.Locale locale) {
		return model.getTooltip(locale);
	}

	/**
	 * Returns the localized tooltip of this parameter in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized tooltip of this parameter. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTooltip(java.util.Locale locale, boolean useDefault) {
		return model.getTooltip(locale, useDefault);
	}

	/**
	 * Returns the localized tooltip of this parameter in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized tooltip of this parameter
	 */
	@Override
	public String getTooltip(String languageId) {
		return model.getTooltip(languageId);
	}

	/**
	 * Returns the localized tooltip of this parameter in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized tooltip of this parameter
	 */
	@Override
	public String getTooltip(String languageId, boolean useDefault) {
		return model.getTooltip(languageId, useDefault);
	}

	@Override
	public String getTooltipCurrentLanguageId() {
		return model.getTooltipCurrentLanguageId();
	}

	@Override
	public String getTooltipCurrentValue() {
		return model.getTooltipCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized tooltips of this parameter.
	 *
	 * @return the locales and localized tooltips of this parameter
	 */
	@Override
	public Map<java.util.Locale, String> getTooltipMap() {
		return model.getTooltipMap();
	}

	/**
	 * Returns the trash entry created when this parameter was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this parameter.
	 *
	 * @return the trash entry created when this parameter was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this parameter.
	 *
	 * @return the class primary key of the trash entry for this parameter
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this parameter.
	 *
	 * @return the trash handler for this parameter
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the type properties of this parameter.
	 *
	 * @return the type properties of this parameter
	 */
	@Override
	public String getTypeProperties() {
		return model.getTypeProperties();
	}

	/**
	 * Returns the user ID of this parameter.
	 *
	 * @return the user ID of this parameter
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this parameter.
	 *
	 * @return the user name of this parameter
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this parameter.
	 *
	 * @return the user uuid of this parameter
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this parameter.
	 *
	 * @return the uuid of this parameter
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this parameter is approved.
	 *
	 * @return <code>true</code> if this parameter is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this parameter is denied.
	 *
	 * @return <code>true</code> if this parameter is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this parameter is a draft.
	 *
	 * @return <code>true</code> if this parameter is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this parameter is expired.
	 *
	 * @return <code>true</code> if this parameter is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this parameter is inactive.
	 *
	 * @return <code>true</code> if this parameter is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this parameter is incomplete.
	 *
	 * @return <code>true</code> if this parameter is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this parameter is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this parameter is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this parameter is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this parameter is in the Recycle Bin; <code>false</code> otherwise
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
	 * Returns <code>true</code> if this parameter is pending.
	 *
	 * @return <code>true</code> if this parameter is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this parameter is scheduled.
	 *
	 * @return <code>true</code> if this parameter is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	/**
	 * Returns <code>true</code> if this parameter is standard.
	 *
	 * @return <code>true</code> if this parameter is standard; <code>false</code> otherwise
	 */
	@Override
	public boolean isStandard() {
		return model.isStandard();
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
	 * Sets the company ID of this parameter.
	 *
	 * @param companyId the company ID of this parameter
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this parameter.
	 *
	 * @param createDate the create date of this parameter
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the definition of this parameter.
	 *
	 * @param definition the definition of this parameter
	 */
	@Override
	public void setDefinition(String definition) {
		model.setDefinition(definition);
	}

	/**
	 * Sets the localized definition of this parameter in the language.
	 *
	 * @param definition the localized definition of this parameter
	 * @param locale the locale of the language
	 */
	@Override
	public void setDefinition(String definition, java.util.Locale locale) {
		model.setDefinition(definition, locale);
	}

	/**
	 * Sets the localized definition of this parameter in the language, and sets the default locale.
	 *
	 * @param definition the localized definition of this parameter
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDefinition(
		String definition, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDefinition(definition, locale, defaultLocale);
	}

	@Override
	public void setDefinitionCurrentLanguageId(String languageId) {
		model.setDefinitionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized definitions of this parameter from the map of locales and localized definitions.
	 *
	 * @param definitionMap the locales and localized definitions of this parameter
	 */
	@Override
	public void setDefinitionMap(Map<java.util.Locale, String> definitionMap) {
		model.setDefinitionMap(definitionMap);
	}

	/**
	 * Sets the localized definitions of this parameter from the map of locales and localized definitions, and sets the default locale.
	 *
	 * @param definitionMap the locales and localized definitions of this parameter
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDefinitionMap(
		Map<java.util.Locale, String> definitionMap,
		java.util.Locale defaultLocale) {

		model.setDefinitionMap(definitionMap, defaultLocale);
	}

	/**
	 * Sets the display name of this parameter.
	 *
	 * @param displayName the display name of this parameter
	 */
	@Override
	public void setDisplayName(String displayName) {
		model.setDisplayName(displayName);
	}

	/**
	 * Sets the localized display name of this parameter in the language.
	 *
	 * @param displayName the localized display name of this parameter
	 * @param locale the locale of the language
	 */
	@Override
	public void setDisplayName(String displayName, java.util.Locale locale) {
		model.setDisplayName(displayName, locale);
	}

	/**
	 * Sets the localized display name of this parameter in the language, and sets the default locale.
	 *
	 * @param displayName the localized display name of this parameter
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
	 * Sets the localized display names of this parameter from the map of locales and localized display names.
	 *
	 * @param displayNameMap the locales and localized display names of this parameter
	 */
	@Override
	public void setDisplayNameMap(
		Map<java.util.Locale, String> displayNameMap) {

		model.setDisplayNameMap(displayNameMap);
	}

	/**
	 * Sets the localized display names of this parameter from the map of locales and localized display names, and sets the default locale.
	 *
	 * @param displayNameMap the locales and localized display names of this parameter
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDisplayNameMap(
		Map<java.util.Locale, String> displayNameMap,
		java.util.Locale defaultLocale) {

		model.setDisplayNameMap(displayNameMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this parameter.
	 *
	 * @param groupId the group ID of this parameter
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last publish date of this parameter.
	 *
	 * @param lastPublishDate the last publish date of this parameter
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this parameter.
	 *
	 * @param modifiedDate the modified date of this parameter
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the parameter ID of this parameter.
	 *
	 * @param parameterId the parameter ID of this parameter
	 */
	@Override
	public void setParameterId(long parameterId) {
		model.setParameterId(parameterId);
	}

	/**
	 * Sets the param name of this parameter.
	 *
	 * @param paramName the param name of this parameter
	 */
	@Override
	public void setParamName(String paramName) {
		model.setParamName(paramName);
	}

	/**
	 * Sets the param type of this parameter.
	 *
	 * @param paramType the param type of this parameter
	 */
	@Override
	public void setParamType(String paramType) {
		model.setParamType(paramType);
	}

	/**
	 * Sets the param version of this parameter.
	 *
	 * @param paramVersion the param version of this parameter
	 */
	@Override
	public void setParamVersion(String paramVersion) {
		model.setParamVersion(paramVersion);
	}

	/**
	 * Sets the primary key of this parameter.
	 *
	 * @param primaryKey the primary key of this parameter
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this parameter is standard.
	 *
	 * @param standard the standard of this parameter
	 */
	@Override
	public void setStandard(boolean standard) {
		model.setStandard(standard);
	}

	/**
	 * Sets the status of this parameter.
	 *
	 * @param status the status of this parameter
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this parameter.
	 *
	 * @param statusByUserId the status by user ID of this parameter
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this parameter.
	 *
	 * @param statusByUserName the status by user name of this parameter
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this parameter.
	 *
	 * @param statusByUserUuid the status by user uuid of this parameter
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this parameter.
	 *
	 * @param statusDate the status date of this parameter
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the synonyms of this parameter.
	 *
	 * @param synonyms the synonyms of this parameter
	 */
	@Override
	public void setSynonyms(String synonyms) {
		model.setSynonyms(synonyms);
	}

	/**
	 * Sets the tooltip of this parameter.
	 *
	 * @param tooltip the tooltip of this parameter
	 */
	@Override
	public void setTooltip(String tooltip) {
		model.setTooltip(tooltip);
	}

	/**
	 * Sets the localized tooltip of this parameter in the language.
	 *
	 * @param tooltip the localized tooltip of this parameter
	 * @param locale the locale of the language
	 */
	@Override
	public void setTooltip(String tooltip, java.util.Locale locale) {
		model.setTooltip(tooltip, locale);
	}

	/**
	 * Sets the localized tooltip of this parameter in the language, and sets the default locale.
	 *
	 * @param tooltip the localized tooltip of this parameter
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTooltip(
		String tooltip, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTooltip(tooltip, locale, defaultLocale);
	}

	@Override
	public void setTooltipCurrentLanguageId(String languageId) {
		model.setTooltipCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized tooltips of this parameter from the map of locales and localized tooltips.
	 *
	 * @param tooltipMap the locales and localized tooltips of this parameter
	 */
	@Override
	public void setTooltipMap(Map<java.util.Locale, String> tooltipMap) {
		model.setTooltipMap(tooltipMap);
	}

	/**
	 * Sets the localized tooltips of this parameter from the map of locales and localized tooltips, and sets the default locale.
	 *
	 * @param tooltipMap the locales and localized tooltips of this parameter
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTooltipMap(
		Map<java.util.Locale, String> tooltipMap,
		java.util.Locale defaultLocale) {

		model.setTooltipMap(tooltipMap, defaultLocale);
	}

	/**
	 * Sets the type properties of this parameter.
	 *
	 * @param typeProperties the type properties of this parameter
	 */
	@Override
	public void setTypeProperties(String typeProperties) {
		model.setTypeProperties(typeProperties);
	}

	/**
	 * Sets the user ID of this parameter.
	 *
	 * @param userId the user ID of this parameter
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this parameter.
	 *
	 * @param userName the user name of this parameter
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this parameter.
	 *
	 * @param userUuid the user uuid of this parameter
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this parameter.
	 *
	 * @param uuid the uuid of this parameter
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
	protected ParameterWrapper wrap(Parameter parameter) {
		return new ParameterWrapper(parameter);
	}

}