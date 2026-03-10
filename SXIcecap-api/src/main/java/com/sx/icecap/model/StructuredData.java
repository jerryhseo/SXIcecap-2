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
 * The extended model interface for the StructuredData service. Represents a row in the &quot;SX_ICECAP_StructuredData&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StructuredDataModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.StructuredDataImpl")
@ProviderType
public interface StructuredData extends PersistedModel, StructuredDataModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.StructuredDataImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StructuredData, String> UUID_ACCESSOR =
		new Accessor<StructuredData, String>() {

			@Override
			public String get(StructuredData structuredData) {
				return structuredData.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<StructuredData> getTypeClass() {
				return StructuredData.class;
			}

		};

	public static final Accessor<StructuredData, Long>
		STRUCTURED_DATA_ID_ACCESSOR = new Accessor<StructuredData, Long>() {

			@Override
			public Long get(StructuredData structuredData) {
				return structuredData.getStructuredDataId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StructuredData> getTypeClass() {
				return StructuredData.class;
			}

		};

	public com.liferay.portal.kernel.json.JSONObject toJSON();

}