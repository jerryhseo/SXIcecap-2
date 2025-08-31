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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sx.icecap.model.DataCollection;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for DataCollection. This utility wraps
 * <code>com.sx.icecap.service.impl.DataCollectionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DataCollectionLocalService
 * @generated
 */
public class DataCollectionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.DataCollectionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data collection to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCollectionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was added
	 */
	public static DataCollection addDataCollection(
		DataCollection dataCollection) {

		return getService().addDataCollection(dataCollection);
	}

	public static DataCollection addDataCollection(
			String dataCollectionCode, String dataCollectionVersion,
			Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addDataCollection(
			dataCollectionCode, dataCollectionVersion, displayNameMap,
			descriptionMap, status, sc);
	}

	/**
	 * Creates a new data collection with the primary key. Does not add the data collection to the database.
	 *
	 * @param dataCollectionId the primary key for the new data collection
	 * @return the new data collection
	 */
	public static DataCollection createDataCollection(long dataCollectionId) {
		return getService().createDataCollection(dataCollectionId);
	}

	/**
	 * Deletes the data collection from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCollectionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was removed
	 */
	public static DataCollection deleteDataCollection(
		DataCollection dataCollection) {

		return getService().deleteDataCollection(dataCollection);
	}

	/**
	 * Deletes the data collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCollectionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection that was removed
	 * @throws PortalException if a data collection with the primary key could not be found
	 */
	public static DataCollection deleteDataCollection(long dataCollectionId)
		throws PortalException {

		return getService().deleteDataCollection(dataCollectionId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static DataCollection fetchDataCollection(long dataCollectionId) {
		return getService().fetchDataCollection(dataCollectionId);
	}

	/**
	 * Returns the data collection matching the UUID and group.
	 *
	 * @param uuid the data collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public static DataCollection fetchDataCollectionByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDataCollectionByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the data collection with the primary key.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection
	 * @throws PortalException if a data collection with the primary key could not be found
	 */
	public static DataCollection getDataCollection(long dataCollectionId)
		throws PortalException {

		return getService().getDataCollection(dataCollectionId);
	}

	/**
	 * Returns the data collection matching the UUID and group.
	 *
	 * @param uuid the data collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data collection
	 * @throws PortalException if a matching data collection could not be found
	 */
	public static DataCollection getDataCollectionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDataCollectionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the data collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of data collections
	 */
	public static List<DataCollection> getDataCollections(int start, int end) {
		return getService().getDataCollections(start, end);
	}

	/**
	 * Returns all the data collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data collections
	 * @param companyId the primary key of the company
	 * @return the matching data collections, or an empty list if no matches were found
	 */
	public static List<DataCollection> getDataCollectionsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDataCollectionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the data collections
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data collections, or an empty list if no matches were found
	 */
	public static List<DataCollection> getDataCollectionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataCollection> orderByComparator) {

		return getService().getDataCollectionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data collections.
	 *
	 * @return the number of data collections
	 */
	public static int getDataCollectionsCount() {
		return getService().getDataCollectionsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static DataCollection removeDataCollection(long dataCollectionId)
		throws PortalException {

		return getService().removeDataCollection(dataCollectionId);
	}

	public static void removeDataCollections(long[] dataCollectionIds)
		throws PortalException {

		getService().removeDataCollections(dataCollectionIds);
	}

	/**
	 * Updates the data collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCollectionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataCollection the data collection
	 * @return the data collection that was updated
	 */
	public static DataCollection updateDataCollection(
		DataCollection dataCollection) {

		return getService().updateDataCollection(dataCollection);
	}

	public static DataCollection updateDataCollection(
			long dataCollectionId, String dataCollectionCode,
			String dataCollectionVersion,
			Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateDataCollection(
			dataCollectionId, dataCollectionCode, dataCollectionVersion,
			displayNameMap, descriptionMap, status, sc);
	}

	public static DataCollection updateStatus(
			long userId, long dataCollectionId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException, SystemException {

		return getService().updateStatus(userId, dataCollectionId, status, sc);
	}

	public static DataCollectionLocalService getService() {
		return _service;
	}

	private static volatile DataCollectionLocalService _service;

}