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
 * The extended model interface for the TypeVisualizerLink service. Represents a row in the &quot;SX_ICECAP_TypeVisualizerLink&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TypeVisualizerLinkModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.TypeVisualizerLinkImpl")
@ProviderType
public interface TypeVisualizerLink
	extends PersistedModel, TypeVisualizerLinkModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.TypeVisualizerLinkImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TypeVisualizerLink, Long>
		TYPE_VISUALIZER_LINK_ID_ACCESSOR =
			new Accessor<TypeVisualizerLink, Long>() {

				@Override
				public Long get(TypeVisualizerLink typeVisualizerLink) {
					return typeVisualizerLink.getTypeVisualizerLinkId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<TypeVisualizerLink> getTypeClass() {
					return TypeVisualizerLink.class;
				}

			};

}