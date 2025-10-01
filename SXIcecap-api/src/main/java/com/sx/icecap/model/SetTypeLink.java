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

package com.sx.icecap.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SetTypeLink service. Represents a row in the &quot;SX_ICECAP_SetTypeLink&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SetTypeLinkModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.SetTypeLinkImpl")
@ProviderType
public interface SetTypeLink extends PersistedModel, SetTypeLinkModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.SetTypeLinkImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SetTypeLink, Long> SET_TYPE_LINK_ID_ACCESSOR =
		new Accessor<SetTypeLink, Long>() {

			@Override
			public Long get(SetTypeLink setTypeLink) {
				return setTypeLink.getSetTypeLinkId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SetTypeLink> getTypeClass() {
				return SetTypeLink.class;
			}

		};

	public com.liferay.portal.kernel.json.JSONObject toJSON();

}