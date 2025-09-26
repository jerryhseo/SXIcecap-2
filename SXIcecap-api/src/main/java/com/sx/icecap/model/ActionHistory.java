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
 * The extended model interface for the ActionHistory service. Represents a row in the &quot;SX_ICECAP_ActionHistory&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ActionHistoryModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.ActionHistoryImpl")
@ProviderType
public interface ActionHistory extends ActionHistoryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.ActionHistoryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ActionHistory, Long>
		ACTION_HISTORY_ID_ACCESSOR = new Accessor<ActionHistory, Long>() {

			@Override
			public Long get(ActionHistory actionHistory) {
				return actionHistory.getActionHistoryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ActionHistory> getTypeClass() {
				return ActionHistory.class;
			}

		};

	public com.liferay.portal.kernel.json.JSONObject toJSON();

}