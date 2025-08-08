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

package com.sx.icecap.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import com.sx.icecap.service.DataCollectionServiceUtil;

import java.rmi.RemoteException;

import java.util.Locale;
import java.util.Map;

/**
 * Provides the SOAP utility for the
 * <code>DataCollectionServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.sx.icecap.model.DataCollectionSoap</code>. If the method in the
 * service utility returns a
 * <code>com.sx.icecap.model.DataCollection</code>, that is translated to a
 * <code>com.sx.icecap.model.DataCollectionSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataCollectionServiceHttp
 * @generated
 */
public class DataCollectionServiceSoap {

	public static com.sx.icecap.model.DataCollectionSoap addDataCollection(
			String dataCollectionName, String dataCollectionVersion,
			String[] displayNameMapLanguageIds, String[] displayNameMapValues,
			String[] descriptionMapLanguageIds, String[] descriptionMapValues,
			int status, com.liferay.portal.kernel.service.ServiceContext sc)
		throws RemoteException {

		try {
			Map<Locale, String> displayNameMap =
				LocalizationUtil.getLocalizationMap(
					displayNameMapLanguageIds, displayNameMapValues);
			Map<Locale, String> descriptionMap =
				LocalizationUtil.getLocalizationMap(
					descriptionMapLanguageIds, descriptionMapValues);

			com.sx.icecap.model.DataCollection returnValue =
				DataCollectionServiceUtil.addDataCollection(
					dataCollectionName, dataCollectionVersion, displayNameMap,
					descriptionMap, status, sc);

			return com.sx.icecap.model.DataCollectionSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.sx.icecap.model.DataCollectionSoap updateDataCollection(
			long dataCollectionId, String dataCollectionName,
			String dataCollectionVersion, String[] displayNameMapLanguageIds,
			String[] displayNameMapValues, String[] descriptionMapLanguageIds,
			String[] descriptionMapValues, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws RemoteException {

		try {
			Map<Locale, String> displayNameMap =
				LocalizationUtil.getLocalizationMap(
					displayNameMapLanguageIds, displayNameMapValues);
			Map<Locale, String> descriptionMap =
				LocalizationUtil.getLocalizationMap(
					descriptionMapLanguageIds, descriptionMapValues);

			com.sx.icecap.model.DataCollection returnValue =
				DataCollectionServiceUtil.updateDataCollection(
					dataCollectionId, dataCollectionName, dataCollectionVersion,
					displayNameMap, descriptionMap, status, sc);

			return com.sx.icecap.model.DataCollectionSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.sx.icecap.model.DataCollectionSoap updateStatus(
			long userId, long dataCollectionId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws RemoteException {

		try {
			com.sx.icecap.model.DataCollection returnValue =
				DataCollectionServiceUtil.updateStatus(
					userId, dataCollectionId, status, sc);

			return com.sx.icecap.model.DataCollectionSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.sx.icecap.model.DataCollectionSoap removeDataCollection(
			long dataCollectionId)
		throws RemoteException {

		try {
			com.sx.icecap.model.DataCollection returnValue =
				DataCollectionServiceUtil.removeDataCollection(
					dataCollectionId);

			return com.sx.icecap.model.DataCollectionSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void removeDataCollections(long[] dataCollectionIds)
		throws RemoteException {

		try {
			DataCollectionServiceUtil.removeDataCollections(dataCollectionIds);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		DataCollectionServiceSoap.class);

}