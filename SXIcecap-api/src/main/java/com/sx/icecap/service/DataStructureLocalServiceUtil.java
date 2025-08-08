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

import com.sx.icecap.model.DataStructure;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for DataStructure. This utility wraps
 * <code>com.sx.icecap.service.impl.DataStructureLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DataStructureLocalService
 * @generated
 */
public class DataStructureLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.DataStructureLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data structure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataStructure the data structure
	 * @return the data structure that was added
	 */
	public static DataStructure addDataStructure(DataStructure dataStructure) {
		return getService().addDataStructure(dataStructure);
	}

	public static DataStructure addDataStructure(
			String dataStructureName, String dataStructureVersion,
			Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> descriptionMap, String structure,
			boolean freezable, boolean verifiable, boolean commentable,
			int status, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addDataStructure(
			dataStructureName, dataStructureVersion, displayNameMap,
			descriptionMap, structure, freezable, verifiable, commentable,
			status, sc);
	}

	public static com.liferay.portal.kernel.json.JSONArray
			convertListToJSONArray(List<DataStructure> list)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().convertListToJSONArray(list);
	}

	public static com.liferay.portal.kernel.json.JSONObject
			convertModelToJSONObject(DataStructure structure)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().convertModelToJSONObject(structure);
	}

	/**
	 * Creates a new data structure with the primary key. Does not add the data structure to the database.
	 *
	 * @param dataStructureId the primary key for the new data structure
	 * @return the new data structure
	 */
	public static DataStructure createDataStructure(long dataStructureId) {
		return getService().createDataStructure(dataStructureId);
	}

	/**
	 * Deletes the data structure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataStructure the data structure
	 * @return the data structure that was removed
	 */
	public static DataStructure deleteDataStructure(
		DataStructure dataStructure) {

		return getService().deleteDataStructure(dataStructure);
	}

	/**
	 * Deletes the data structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure that was removed
	 * @throws PortalException if a data structure with the primary key could not be found
	 */
	public static DataStructure deleteDataStructure(long dataStructureId)
		throws PortalException {

		return getService().deleteDataStructure(dataStructureId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataStructureModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataStructureModelImpl</code>.
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

	public static DataStructure fetchDataStructure(long dataStructureId) {
		return getService().fetchDataStructure(dataStructureId);
	}

	/**
	 * Returns the data structure matching the UUID and group.
	 *
	 * @param uuid the data structure's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchDataStructureByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDataStructureByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the data structure with the primary key.
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure
	 * @throws PortalException if a data structure with the primary key could not be found
	 */
	public static DataStructure getDataStructure(long dataStructureId)
		throws PortalException {

		return getService().getDataStructure(dataStructureId);
	}

	/**
	 * Returns the data structure matching the UUID and group.
	 *
	 * @param uuid the data structure's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data structure
	 * @throws PortalException if a matching data structure could not be found
	 */
	public static DataStructure getDataStructureByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDataStructureByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the data structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of data structures
	 */
	public static List<DataStructure> getDataStructures(int start, int end) {
		return getService().getDataStructures(start, end);
	}

	/**
	 * Returns all the data structures matching the UUID and company.
	 *
	 * @param uuid the UUID of the data structures
	 * @param companyId the primary key of the company
	 * @return the matching data structures, or an empty list if no matches were found
	 */
	public static List<DataStructure> getDataStructuresByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDataStructuresByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data structures matching the UUID and company.
	 *
	 * @param uuid the UUID of the data structures
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data structures, or an empty list if no matches were found
	 */
	public static List<DataStructure> getDataStructuresByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getService().getDataStructuresByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data structures.
	 *
	 * @return the number of data structures
	 */
	public static int getDataStructuresCount() {
		return getService().getDataStructuresCount();
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

	public static DataStructure removeDataStructure(long dataStructureId)
		throws PortalException {

		return getService().removeDataStructure(dataStructureId);
	}

	public static void removeDataStructures(long[] dataStructureIds)
		throws PortalException {

		getService().removeDataStructures(dataStructureIds);
	}

	/**
	 * Updates the data structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataStructure the data structure
	 * @return the data structure that was updated
	 */
	public static DataStructure updateDataStructure(
		DataStructure dataStructure) {

		return getService().updateDataStructure(dataStructure);
	}

	public static DataStructure updateDataStructure(
			long dataStructureId, String dataStructureName,
			String dataStructureVersion,
			Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> descriptionMap, String structure,
			boolean freezable, boolean verifiable, boolean commentable,
			int status, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateDataStructure(
			dataStructureId, dataStructureName, dataStructureVersion,
			displayNameMap, descriptionMap, structure, freezable, verifiable,
			commentable, status, sc);
	}

	public static DataStructure updateStatus(
			long userId, long dataStructureId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException, SystemException {

		return getService().updateStatus(userId, dataStructureId, status, sc);
	}

	public static DataStructure updateStructure(
			long dataStructureId, String structure)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getService().updateStructure(dataStructureId, structure);
	}

	public static DataStructureLocalService getService() {
		return _service;
	}

	private static volatile DataStructureLocalService _service;

}