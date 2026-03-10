/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sx.icecap.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TypeVisualizerLinkService}.
 *
 * @author Brian Wing Shun Chan
 * @see TypeVisualizerLinkService
 * @generated
 */
public class TypeVisualizerLinkServiceWrapper
	implements ServiceWrapper<TypeVisualizerLinkService>,
			   TypeVisualizerLinkService {

	public TypeVisualizerLinkServiceWrapper(
		TypeVisualizerLinkService typeVisualizerLinkService) {

		_typeVisualizerLinkService = typeVisualizerLinkService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _typeVisualizerLinkService.getOSGiServiceIdentifier();
	}

	@Override
	public TypeVisualizerLinkService getWrappedService() {
		return _typeVisualizerLinkService;
	}

	@Override
	public void setWrappedService(
		TypeVisualizerLinkService typeVisualizerLinkService) {

		_typeVisualizerLinkService = typeVisualizerLinkService;
	}

	private TypeVisualizerLinkService _typeVisualizerLinkService;

}