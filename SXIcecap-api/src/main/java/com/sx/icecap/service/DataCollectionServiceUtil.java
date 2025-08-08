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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import com.sx.icecap.model.DataCollection;

import java.util.Map;

/**
 * Provides the remote service utility for DataCollection. This utility wraps
 * <code>com.sx.icecap.service.impl.DataCollectionServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DataCollectionService
 * @generated
 */
public class DataCollectionServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.DataCollectionServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static DataCollection addDataCollection(
			String dataCollectionName, String dataCollectionVersion,
			Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addDataCollection(
			dataCollectionName, dataCollectionVersion, displayNameMap,
			descriptionMap, status, sc);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DataCollection removeDataCollection(long dataCollectionId)
		throws PortalException {

		return getService().removeDataCollection(dataCollectionId);
	}

	public static void removeDataCollections(long[] dataCollectionIds)
		throws PortalException {

		getService().removeDataCollections(dataCollectionIds);
	}

	public static DataCollection updateDataCollection(
			long dataCollectionId, String dataCollectionName,
			String dataCollectionVersion,
			Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateDataCollection(
			dataCollectionId, dataCollectionName, dataCollectionVersion,
			displayNameMap, descriptionMap, status, sc);
	}

	public static DataCollection updateStatus(
			long userId, long dataCollectionId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException, SystemException {

		return getService().updateStatus(userId, dataCollectionId, status, sc);
	}

	public static DataCollectionService getService() {
		return _service;
	}

	private static volatile DataCollectionService _service;

}