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
 * The extended model interface for the CollectionSetLink service. Represents a row in the &quot;SX_ICECAP_CollectionSetLink&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CollectionSetLinkModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.CollectionSetLinkImpl")
@ProviderType
public interface CollectionSetLink
	extends CollectionSetLinkModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.CollectionSetLinkImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CollectionSetLink, Long>
		COLLECTION_SET_LINK_ID_ACCESSOR =
			new Accessor<CollectionSetLink, Long>() {

				@Override
				public Long get(CollectionSetLink collectionSetLink) {
					return collectionSetLink.getCollectionSetLinkId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<CollectionSetLink> getTypeClass() {
					return CollectionSetLink.class;
				}

			};

	public com.liferay.portal.kernel.json.JSONObject toJSON();

}