/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sx.icecap.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DataSet service. Represents a row in the &quot;SX_ICECAP_DataSet&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DataSetModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.DataSetImpl")
@ProviderType
public interface DataSet extends DataSetModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.DataSetImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataSet, String> UUID_ACCESSOR =
		new Accessor<DataSet, String>() {

			@Override
			public String get(DataSet dataSet) {
				return dataSet.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<DataSet> getTypeClass() {
				return DataSet.class;
			}

		};

	public static final Accessor<DataSet, Long> DATA_SET_ID_ACCESSOR =
		new Accessor<DataSet, Long>() {

			@Override
			public Long get(DataSet dataSet) {
				return dataSet.getDataSetId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DataSet> getTypeClass() {
				return DataSet.class;
			}

		};

	public com.liferay.portal.kernel.json.JSONObject toJSON();

	public com.liferay.portal.kernel.json.JSONObject toJSON(
		java.util.Locale locale);

}