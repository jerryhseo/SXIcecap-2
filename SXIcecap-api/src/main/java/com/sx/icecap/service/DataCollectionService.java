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
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.sx.icecap.model.DataCollection;

import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for DataCollection. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DataCollectionServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DataCollectionService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.sx.icecap.service.impl.DataCollectionServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the data collection remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DataCollectionServiceUtil} if injection and service tracking are not available.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataCollection addDataCollection(
			String dataCollectionName, String dataCollectionVersion,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap, int status, ServiceContext sc)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Indexable(type = IndexableType.DELETE)
	public DataCollection removeDataCollection(long dataCollectionId)
		throws PortalException;

	public void removeDataCollections(long[] dataCollectionIds)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public DataCollection updateDataCollection(
			long dataCollectionId, String dataCollectionName,
			String dataCollectionVersion, Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap, int status, ServiceContext sc)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public DataCollection updateStatus(
			long userId, long dataCollectionId, Integer status,
			ServiceContext sc)
		throws PortalException, SystemException;

}