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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.sx.icecap.service.DataCollectionServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>DataCollectionServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataCollectionServiceSoap
 * @generated
 */
public class DataCollectionServiceHttp {

	public static com.sx.icecap.model.DataCollection addDataCollection(
			HttpPrincipal httpPrincipal, String dataCollectionName,
			String dataCollectionVersion,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DataCollectionServiceUtil.class, "addDataCollection",
				_addDataCollectionParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, dataCollectionName, dataCollectionVersion,
				displayNameMap, descriptionMap, status, sc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.sx.icecap.model.DataCollection)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.sx.icecap.model.DataCollection updateDataCollection(
			HttpPrincipal httpPrincipal, long dataCollectionId,
			String dataCollectionName, String dataCollectionVersion,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DataCollectionServiceUtil.class, "updateDataCollection",
				_updateDataCollectionParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, dataCollectionId, dataCollectionName,
				dataCollectionVersion, displayNameMap, descriptionMap, status,
				sc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.sx.icecap.model.DataCollection)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.sx.icecap.model.DataCollection updateStatus(
			HttpPrincipal httpPrincipal, long userId, long dataCollectionId,
			Integer status, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		try {
			MethodKey methodKey = new MethodKey(
				DataCollectionServiceUtil.class, "updateStatus",
				_updateStatusParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, dataCollectionId, status, sc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				if (exception instanceof
						com.liferay.portal.kernel.exception.SystemException) {

					throw (com.liferay.portal.kernel.exception.SystemException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.sx.icecap.model.DataCollection)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.sx.icecap.model.DataCollection removeDataCollection(
			HttpPrincipal httpPrincipal, long dataCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DataCollectionServiceUtil.class, "removeDataCollection",
				_removeDataCollectionParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, dataCollectionId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.sx.icecap.model.DataCollection)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void removeDataCollections(
			HttpPrincipal httpPrincipal, long[] dataCollectionIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DataCollectionServiceUtil.class, "removeDataCollections",
				_removeDataCollectionsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, dataCollectionIds);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		DataCollectionServiceHttp.class);

	private static final Class<?>[] _addDataCollectionParameterTypes0 =
		new Class[] {
			String.class, String.class, java.util.Map.class,
			java.util.Map.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateDataCollectionParameterTypes1 =
		new Class[] {
			long.class, String.class, String.class, java.util.Map.class,
			java.util.Map.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateStatusParameterTypes2 = new Class[] {
		long.class, long.class, Integer.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _removeDataCollectionParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _removeDataCollectionsParameterTypes4 =
		new Class[] {long[].class};

}