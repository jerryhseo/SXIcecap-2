/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sx.icecap.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StructuredDataService}.
 *
 * @author Brian Wing Shun Chan
 * @see StructuredDataService
 * @generated
 */
public class StructuredDataServiceWrapper
	implements ServiceWrapper<StructuredDataService>, StructuredDataService {

	public StructuredDataServiceWrapper(
		StructuredDataService structuredDataService) {

		_structuredDataService = structuredDataService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _structuredDataService.getOSGiServiceIdentifier();
	}

	@Override
	public StructuredDataService getWrappedService() {
		return _structuredDataService;
	}

	@Override
	public void setWrappedService(StructuredDataService structuredDataService) {
		_structuredDataService = structuredDataService;
	}

	private StructuredDataService _structuredDataService;

}