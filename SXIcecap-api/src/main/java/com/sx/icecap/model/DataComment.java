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
 * The extended model interface for the DataComment service. Represents a row in the &quot;SX_ICECAP_DataComment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DataCommentModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.DataCommentImpl")
@ProviderType
public interface DataComment extends DataCommentModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.DataCommentImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataComment, String> UUID_ACCESSOR =
		new Accessor<DataComment, String>() {

			@Override
			public String get(DataComment dataComment) {
				return dataComment.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<DataComment> getTypeClass() {
				return DataComment.class;
			}

		};

	public static final Accessor<DataComment, Long> DATA_COMMENT_ID_ACCESSOR =
		new Accessor<DataComment, Long>() {

			@Override
			public Long get(DataComment dataComment) {
				return dataComment.getDataCommentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DataComment> getTypeClass() {
				return DataComment.class;
			}

		};

	public com.liferay.portal.kernel.json.JSONObject toJSON();

}