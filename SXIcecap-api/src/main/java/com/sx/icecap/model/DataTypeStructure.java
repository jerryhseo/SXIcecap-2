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
 * The extended model interface for the DataTypeStructure service. Represents a row in the &quot;SX_ICECAP_DataTypeStructure&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeStructureModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.DataTypeStructureImpl")
@ProviderType
public interface DataTypeStructure
	extends DataTypeStructureModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.DataTypeStructureImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataTypeStructure, Long>
		DATA_TYPE_ID_ACCESSOR = new Accessor<DataTypeStructure, Long>() {

			@Override
			public Long get(DataTypeStructure dataTypeStructure) {
				return dataTypeStructure.getDataTypeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DataTypeStructure> getTypeClass() {
				return DataTypeStructure.class;
			}

		};

}