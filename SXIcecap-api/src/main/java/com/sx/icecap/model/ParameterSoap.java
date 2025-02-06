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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sx.icecap.service.http.ParameterServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ParameterSoap implements Serializable {

	public static ParameterSoap toSoapModel(Parameter model) {
		ParameterSoap soapModel = new ParameterSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setParameterId(model.getParameterId());
		soapModel.setGroupParameterId(model.getGroupParameterId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setLastPublishDate(model.getLastPublishDate());
		soapModel.setParamName(model.getParamName());
		soapModel.setParamVersion(model.getParamVersion());
		soapModel.setParamType(model.getParamType());
		soapModel.setDisplayName(model.getDisplayName());
		soapModel.setDefinition(model.getDefinition());
		soapModel.setTooltip(model.getTooltip());
		soapModel.setSynonyms(model.getSynonyms());
		soapModel.setAttributesJSON(model.getAttributesJSON());
		soapModel.setStandard(model.isStandard());

		return soapModel;
	}

	public static ParameterSoap[] toSoapModels(Parameter[] models) {
		ParameterSoap[] soapModels = new ParameterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ParameterSoap[][] toSoapModels(Parameter[][] models) {
		ParameterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ParameterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ParameterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ParameterSoap[] toSoapModels(List<Parameter> models) {
		List<ParameterSoap> soapModels = new ArrayList<ParameterSoap>(
			models.size());

		for (Parameter model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ParameterSoap[soapModels.size()]);
	}

	public ParameterSoap() {
	}

	public long getPrimaryKey() {
		return _parameterId;
	}

	public void setPrimaryKey(long pk) {
		setParameterId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getParameterId() {
		return _parameterId;
	}

	public void setParameterId(long parameterId) {
		_parameterId = parameterId;
	}

	public String getGroupParameterId() {
		return _groupParameterId;
	}

	public void setGroupParameterId(String groupParameterId) {
		_groupParameterId = groupParameterId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	public String getParamName() {
		return _paramName;
	}

	public void setParamName(String paramName) {
		_paramName = paramName;
	}

	public String getParamVersion() {
		return _paramVersion;
	}

	public void setParamVersion(String paramVersion) {
		_paramVersion = paramVersion;
	}

	public String getParamType() {
		return _paramType;
	}

	public void setParamType(String paramType) {
		_paramType = paramType;
	}

	public String getDisplayName() {
		return _displayName;
	}

	public void setDisplayName(String displayName) {
		_displayName = displayName;
	}

	public String getDefinition() {
		return _definition;
	}

	public void setDefinition(String definition) {
		_definition = definition;
	}

	public String getTooltip() {
		return _tooltip;
	}

	public void setTooltip(String tooltip) {
		_tooltip = tooltip;
	}

	public String getSynonyms() {
		return _synonyms;
	}

	public void setSynonyms(String synonyms) {
		_synonyms = synonyms;
	}

	public String getAttributesJSON() {
		return _attributesJSON;
	}

	public void setAttributesJSON(String attributesJSON) {
		_attributesJSON = attributesJSON;
	}

	public boolean getStandard() {
		return _standard;
	}

	public boolean isStandard() {
		return _standard;
	}

	public void setStandard(boolean standard) {
		_standard = standard;
	}

	private String _uuid;
	private long _parameterId;
	private String _groupParameterId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private Date _lastPublishDate;
	private String _paramName;
	private String _paramVersion;
	private String _paramType;
	private String _displayName;
	private String _definition;
	private String _tooltip;
	private String _synonyms;
	private String _attributesJSON;
	private boolean _standard;

}