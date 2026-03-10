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
 * The extended model interface for the StructureParamLink service. Represents a row in the &quot;SX_ICECAP_StructureParamLink&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StructureParamLinkModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.StructureParamLinkImpl")
@ProviderType
public interface StructureParamLink
	extends PersistedModel, StructureParamLinkModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.StructureParamLinkImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StructureParamLink, Long>
		STRUCTURE_PARAM_LINK_ID_ACCESSOR =
			new Accessor<StructureParamLink, Long>() {

				@Override
				public Long get(StructureParamLink structureParamLink) {
					return structureParamLink.getStructureParamLinkId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<StructureParamLink> getTypeClass() {
					return StructureParamLink.class;
				}

			};

}