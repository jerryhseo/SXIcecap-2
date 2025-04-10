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

package com.sx.icecap.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.sx.icecap.model.DataStructure;
import com.sx.icecap.model.DataStructureModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DataStructure service. Represents a row in the &quot;SX_ICECAP_DataStructure&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DataStructureModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DataStructureImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataStructureImpl
 * @generated
 */
public class DataStructureModelImpl
	extends BaseModelImpl<DataStructure> implements DataStructureModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a data structure model instance should use the <code>DataStructure</code> interface instead.
	 */
	public static final String TABLE_NAME = "SX_ICECAP_DataStructure";

	public static final Object[][] TABLE_COLUMNS = {
		{"dataTypeId", Types.BIGINT}, {"structure", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("dataTypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("structure", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SX_ICECAP_DataStructure (dataTypeId LONG not null primary key,structure TEXT null)";

	public static final String TABLE_SQL_DROP =
		"drop table SX_ICECAP_DataStructure";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dataStructure.dataTypeId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SX_ICECAP_DataStructure.dataTypeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public DataStructureModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dataTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDataTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dataTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DataStructure.class;
	}

	@Override
	public String getModelClassName() {
		return DataStructure.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DataStructure, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DataStructure, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataStructure, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DataStructure)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DataStructure, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DataStructure, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DataStructure)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DataStructure, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DataStructure, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DataStructure, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DataStructure, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DataStructure, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DataStructure, Object>>();
		Map<String, BiConsumer<DataStructure, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DataStructure, ?>>();

		attributeGetterFunctions.put(
			"dataTypeId", DataStructure::getDataTypeId);
		attributeSetterBiConsumers.put(
			"dataTypeId",
			(BiConsumer<DataStructure, Long>)DataStructure::setDataTypeId);
		attributeGetterFunctions.put("structure", DataStructure::getStructure);
		attributeSetterBiConsumers.put(
			"structure",
			(BiConsumer<DataStructure, String>)DataStructure::setStructure);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getDataTypeId() {
		return _dataTypeId;
	}

	@Override
	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	@JSON
	@Override
	public String getStructure() {
		if (_structure == null) {
			return "";
		}
		else {
			return _structure;
		}
	}

	@Override
	public void setStructure(String structure) {
		_structure = structure;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, DataStructure.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DataStructure toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DataStructure>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DataStructureImpl dataStructureImpl = new DataStructureImpl();

		dataStructureImpl.setDataTypeId(getDataTypeId());
		dataStructureImpl.setStructure(getStructure());

		dataStructureImpl.resetOriginalValues();

		return dataStructureImpl;
	}

	@Override
	public int compareTo(DataStructure dataStructure) {
		long primaryKey = dataStructure.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataStructure)) {
			return false;
		}

		DataStructure dataStructure = (DataStructure)object;

		long primaryKey = dataStructure.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<DataStructure> toCacheModel() {
		DataStructureCacheModel dataStructureCacheModel =
			new DataStructureCacheModel();

		dataStructureCacheModel.dataTypeId = getDataTypeId();

		dataStructureCacheModel.structure = getStructure();

		String structure = dataStructureCacheModel.structure;

		if ((structure != null) && (structure.length() == 0)) {
			dataStructureCacheModel.structure = null;
		}

		return dataStructureCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DataStructure, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DataStructure, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataStructure, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DataStructure)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<DataStructure, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DataStructure, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataStructure, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DataStructure)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DataStructure>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DataStructure.class, ModelWrapper.class);

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _dataTypeId;
	private String _structure;
	private DataStructure _escapedModel;

}