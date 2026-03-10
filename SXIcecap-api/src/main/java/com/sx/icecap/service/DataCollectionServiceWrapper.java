/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sx.icecap.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataCollectionService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataCollectionService
 * @generated
 */
public class DataCollectionServiceWrapper
	implements DataCollectionService, ServiceWrapper<DataCollectionService> {

	public DataCollectionServiceWrapper(
		DataCollectionService dataCollectionService) {

		_dataCollectionService = dataCollectionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataCollectionService.getOSGiServiceIdentifier();
	}

	@Override
	public DataCollectionService getWrappedService() {
		return _dataCollectionService;
	}

	@Override
	public void setWrappedService(DataCollectionService dataCollectionService) {
		_dataCollectionService = dataCollectionService;
	}

	private DataCollectionService _dataCollectionService;

}