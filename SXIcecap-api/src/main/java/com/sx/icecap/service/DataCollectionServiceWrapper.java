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

	@Override
	public com.sx.icecap.model.DataCollection addDataCollection(
			String dataCollectionName, String dataCollectionVersion,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionService.addDataCollection(
			dataCollectionName, dataCollectionVersion, displayNameMap,
			descriptionMap, status, sc);
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
	public com.sx.icecap.model.DataCollection removeDataCollection(
			long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionService.removeDataCollection(dataCollectionId);
	}

	@Override
	public void removeDataCollections(long[] dataCollectionIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dataCollectionService.removeDataCollections(dataCollectionIds);
	}

	@Override
	public com.sx.icecap.model.DataCollection updateDataCollection(
			long dataCollectionId, String dataCollectionName,
			String dataCollectionVersion,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCollectionService.updateDataCollection(
			dataCollectionId, dataCollectionName, dataCollectionVersion,
			displayNameMap, descriptionMap, status, sc);
	}

	@Override
	public com.sx.icecap.model.DataCollection updateStatus(
			long userId, long dataCollectionId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dataCollectionService.updateStatus(
			userId, dataCollectionId, status, sc);
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