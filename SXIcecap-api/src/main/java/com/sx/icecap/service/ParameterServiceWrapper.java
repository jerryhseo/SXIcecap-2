/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sx.icecap.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ParameterService}.
 *
 * @author Brian Wing Shun Chan
 * @see ParameterService
 * @generated
 */
public class ParameterServiceWrapper
	implements ParameterService, ServiceWrapper<ParameterService> {

	public ParameterServiceWrapper(ParameterService parameterService) {
		_parameterService = parameterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _parameterService.getOSGiServiceIdentifier();
	}

	@Override
	public ParameterService getWrappedService() {
		return _parameterService;
	}

	@Override
	public void setWrappedService(ParameterService parameterService) {
		_parameterService = parameterService;
	}

	private ParameterService _parameterService;

}