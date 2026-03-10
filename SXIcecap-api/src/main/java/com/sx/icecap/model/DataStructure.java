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
 * The extended model interface for the DataStructure service. Represents a row in the &quot;SX_ICECAP_DataStructure&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DataStructureModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.DataStructureImpl")
@ProviderType
public interface DataStructure extends DataStructureModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.DataStructureImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataStructure, String> UUID_ACCESSOR =
		new Accessor<DataStructure, String>() {

			@Override
			public String get(DataStructure dataStructure) {
				return dataStructure.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<DataStructure> getTypeClass() {
				return DataStructure.class;
			}

		};

	public static final Accessor<DataStructure, Long>
		DATA_STRUCTURE_ID_ACCESSOR = new Accessor<DataStructure, Long>() {

			@Override
			public Long get(DataStructure dataStructure) {
				return dataStructure.getDataStructureId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DataStructure> getTypeClass() {
				return DataStructure.class;
			}

		};

	public com.liferay.portal.kernel.json.JSONObject toJSON();

	public com.liferay.portal.kernel.json.JSONObject toJSON(
		java.util.Locale locale);

}