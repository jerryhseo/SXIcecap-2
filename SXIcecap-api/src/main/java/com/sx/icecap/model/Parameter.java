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
 * The extended model interface for the Parameter service. Represents a row in the &quot;SX_ICECAP_Parameter&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ParameterModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.ParameterImpl")
@ProviderType
public interface Parameter extends ParameterModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.ParameterImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Parameter, String> UUID_ACCESSOR =
		new Accessor<Parameter, String>() {

			@Override
			public String get(Parameter parameter) {
				return parameter.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Parameter> getTypeClass() {
				return Parameter.class;
			}

		};

	public static final Accessor<Parameter, Long> PARAMETER_ID_ACCESSOR =
		new Accessor<Parameter, Long>() {

			@Override
			public Long get(Parameter parameter) {
				return parameter.getParameterId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Parameter> getTypeClass() {
				return Parameter.class;
			}

		};

	public com.liferay.portal.kernel.json.JSONObject toJSON();

	public com.liferay.portal.kernel.json.JSONObject toJSON(
		java.util.Locale locale);

}