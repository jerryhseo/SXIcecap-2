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

import com.sx.icecap.model.StructuredData;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for StructuredData. This utility wraps
 * <code>com.sx.icecap.service.impl.StructuredDataLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StructuredDataLocalService
 * @generated
 */
public class StructuredDataLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.StructuredDataLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static StructuredData addStructuredData(
			long dataCollectionId, long dataSetId, long dataTypeId,
			boolean multiple, long startIndex, int count, String data,
			int status, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addStructuredData(
			dataCollectionId, dataSetId, dataTypeId, multiple, startIndex,
			count, data, status, sc);
	}

	/**
	 * Adds the structured data to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructuredDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structuredData the structured data
	 * @return the structured data that was added
	 */
	public static StructuredData addStructuredData(
		StructuredData structuredData) {

		return getService().addStructuredData(structuredData);
	}

	public static com.liferay.portal.kernel.json.JSONArray
			convertListToJSONArray(List<StructuredData> list)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().convertListToJSONArray(list);
	}

	public static com.liferay.portal.kernel.json.JSONObject
			convertModelToJSONObject(StructuredData structuredData)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().convertModelToJSONObject(structuredData);
	}

	public static int countAllStructuredDatas() {
		return getService().countAllStructuredDatas();
	}

	public static int countStructuredData(
		long dataCollectionId, long dataSetId, long dataTypeId) {

		return getService().countStructuredData(
			dataCollectionId, dataSetId, dataTypeId);
	}

	public static int countStructuredDataByCollection(
		long groupId, long dataCollectionId, int status) {

		return getService().countStructuredDataByCollection(
			groupId, dataCollectionId, status);
	}

	public static int countStructuredDataByCollectionSet(
		long groupId, long dataCollectionId, long dataSetId, int status) {

		return getService().countStructuredDataByCollectionSet(
			groupId, dataCollectionId, dataSetId, status);
	}

	public static int countStructuredDatas(long groupId, int status) {
		return getService().countStructuredDatas(groupId, status);
	}

	public static int countStructuredDatasByCollectionSet(
		long groupId, long dataCollectionId, long dataSetId, int status) {

		return getService().countStructuredDatasByCollectionSet(
			groupId, dataCollectionId, dataSetId, status);
	}

	public static int countStructuredDatasByCollectionSetType(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status) {

		return getService().countStructuredDatasByCollectionSetType(
			groupId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	public static int countStructuredDatasByDataCollectionId(
		long dataTypeId, long groupId) {

		return getService().countStructuredDatasByDataCollectionId(
			dataTypeId, groupId);
	}

	public static int countStructuredDatasByDataCollectionId(
		long groupId, long dataCollectionId, int status) {

		return getService().countStructuredDatasByDataCollectionId(
			groupId, dataCollectionId, status);
	}

	public static int countStructuredDatasByDataSetId(
		long groupId, long dataSetId, int status) {

		return getService().countStructuredDatasByDataSetId(
			groupId, dataSetId, status);
	}

	public static int countStructuredDatasByDataTypeId(
		long groupId, long dataTypeId, int status) {

		return getService().countStructuredDatasByDataTypeId(
			groupId, dataTypeId, status);
	}

	public static int countStructuredDatasByDataTypeId_U(
		long dataTypeId, long userId) {

		return getService().countStructuredDatasByDataTypeId_U(
			dataTypeId, userId);
	}

	public static int countStructuredDatasByG_U_S(
		long groupId, long userId, int status) {

		return getService().countStructuredDatasByG_U_S(
			groupId, userId, status);
	}

	public static int countStructuredDatasByGroupId(long groupId, int status) {
		return getService().countStructuredDatasByGroupId(groupId, status);
	}

	public static int countStructuredDatasBySetType(
		long groupId, long dataSetId, long dataTypeId, int status) {

		return getService().countStructuredDatasBySetType(
			groupId, dataSetId, dataTypeId, status);
	}

	public static int countStructuredDatasByStatus(int status) {
		return getService().countStructuredDatasByStatus(status);
	}

	public static int countStructuredDatasByUserId(long userId) {
		return getService().countStructuredDatasByUserId(userId);
	}

	public static int countStructuredDatasByUserId(long userId, int status) {
		return getService().countStructuredDatasByUserId(userId, status);
	}

	/**
	 * Creates a new structured data with the primary key. Does not add the structured data to the database.
	 *
	 * @param structuredDataId the primary key for the new structured data
	 * @return the new structured data
	 */
	public static StructuredData createStructuredData(long structuredDataId) {
		return getService().createStructuredData(structuredDataId);
	}

	public static com.liferay.portal.kernel.json.JSONObject
		createStructuredDataInfo(
			com.liferay.portal.kernel.json.JSONArray dataArray,
			long dataCollectionId, long dataSetId, long dataTypeId,
			java.util.Locale locale) {

		return getService().createStructuredDataInfo(
			dataArray, dataCollectionId, dataSetId, dataTypeId, locale);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the structured data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructuredDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data that was removed
	 * @throws PortalException if a structured data with the primary key could not be found
	 */
	public static StructuredData deleteStructuredData(long structuredDataId)
		throws PortalException {

		return getService().deleteStructuredData(structuredDataId);
	}

	/**
	 * Deletes the structured data from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructuredDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structuredData the structured data
	 * @return the structured data that was removed
	 */
	public static StructuredData deleteStructuredData(
		StructuredData structuredData) {

		return getService().deleteStructuredData(structuredData);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.StructuredDataModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.StructuredDataModelImpl</code>.
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

	public static StructuredData fetchStructuredData(long structuredDataId) {
		return getService().fetchStructuredData(structuredDataId);
	}

	/**
	 * Returns the structured data matching the UUID and group.
	 *
	 * @param uuid the structured data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchStructuredDataByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchStructuredDataByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<StructuredData> getAllStructuredDatas() {
		return getService().getAllStructuredDatas();
	}

	public static List<StructuredData> getAllStructuredDatas(
		int start, int end) {

		return getService().getAllStructuredDatas(start, end);
	}

	public static List<StructuredData> getAllStructuredDatas(
		int start, int end, OrderByComparator<StructuredData> comparator) {

		return getService().getAllStructuredDatas(start, end, comparator);
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

	public static com.liferay.portal.kernel.dao.search.SearchContainerResults
		<com.liferay.asset.kernel.model.AssetEntry> getSearchContainerResults(
				com.liferay.portal.kernel.dao.search.SearchContainer
					<StructuredData> searchContainer)
			throws PortalException {

		return getService().getSearchContainerResults(searchContainer);
	}

	/**
	 * Returns the structured data with the primary key.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data
	 * @throws PortalException if a structured data with the primary key could not be found
	 */
	public static StructuredData getStructuredData(long structuredDataId)
		throws PortalException {

		return getService().getStructuredData(structuredDataId);
	}

	public static List<StructuredData> getStructuredDataByCollection(
		long groupId, long dataCollectionId, int status) {

		return getService().getStructuredDataByCollection(
			groupId, dataCollectionId, status);
	}

	public static List<StructuredData> getStructuredDataByCollection(
		long groupId, long dataCollectionId, int start, int end, int status) {

		return getService().getStructuredDataByCollection(
			groupId, dataCollectionId, start, end, status);
	}

	public static List<StructuredData> getStructuredDataByCollection(
		long groupId, long dataCollectionId, int start, int end, int status,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDataByCollection(
			groupId, dataCollectionId, start, end, status, comparator);
	}

	public static List<StructuredData> getStructuredDataByCollectionSet(
		long groupId, long dataCollectionId, long dataSetId, int status) {

		return getService().getStructuredDataByCollectionSet(
			groupId, dataCollectionId, dataSetId, status);
	}

	public static List<StructuredData> getStructuredDataByCollectionSet(
		long groupId, long dataCollectionId, long dataSetId, int start, int end,
		int status) {

		return getService().getStructuredDataByCollectionSet(
			groupId, dataCollectionId, dataSetId, start, end, status);
	}

	public static List<StructuredData> getStructuredDataByCollectionSet(
		long groupId, long dataCollectionId, long dataSetId, int start, int end,
		int status, OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDataByCollectionSet(
			groupId, dataCollectionId, dataSetId, start, end, status,
			comparator);
	}

	/**
	 * Returns the structured data matching the UUID and group.
	 *
	 * @param uuid the structured data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching structured data
	 * @throws PortalException if a matching structured data could not be found
	 */
	public static StructuredData getStructuredDataByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getStructuredDataByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getStructuredDataListWithInfo(
			long dataCollectionId, long dataSetId, long dataTypeId,
			java.util.Locale locale) {

		return getService().getStructuredDataListWithInfo(
			dataCollectionId, dataSetId, dataTypeId, locale);
	}

	/**
	 * Returns a range of all the structured datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of structured datas
	 */
	public static List<StructuredData> getStructuredDatas(int start, int end) {
		return getService().getStructuredDatas(start, end);
	}

	public static List<StructuredData> getStructuredDatas(
		long groupId, int status) {

		return getService().getStructuredDatas(groupId, status);
	}

	public static List<StructuredData> getStructuredDatas(
		long groupId, int start, int end, int status) {

		return getService().getStructuredDatas(groupId, start, end, status);
	}

	public static List<StructuredData> getStructuredDatas(
		long groupId, int start, int end, int status,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatas(
			groupId, start, end, status, comparator);
	}

	public static List<StructuredData> getStructuredDatasByCollectionId(
		long groupId, long dataTypeId) {

		return getService().getStructuredDatasByCollectionId(
			groupId, dataTypeId);
	}

	public static List<StructuredData> getStructuredDatasByCollectionId(
		long dataTypeId, long groupId, int start, int end) {

		return getService().getStructuredDatasByCollectionId(
			dataTypeId, groupId, start, end);
	}

	public static List<StructuredData> getStructuredDatasByCollectionId(
		long dataTypeId, long groupId, int start, int end,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByCollectionId(
			dataTypeId, groupId, start, end, comparator);
	}

	public static List<StructuredData> getStructuredDatasByCollectionSet(
		long groupId, long dataCollectionId, long dataSetId, int status) {

		return getService().getStructuredDatasByCollectionSet(
			groupId, dataCollectionId, dataSetId, status);
	}

	public static List<StructuredData> getStructuredDatasByCollectionSet(
		long groupId, long dataCollectionId, long dataSetId, int start, int end,
		int status) {

		return getService().getStructuredDatasByCollectionSet(
			groupId, dataCollectionId, dataSetId, start, end, status);
	}

	public static List<StructuredData> getStructuredDatasByCollectionSet(
		long groupId, long dataCollectionId, long dataSetId, int start, int end,
		int status, OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByCollectionSet(
			groupId, dataCollectionId, dataSetId, start, end, status,
			comparator);
	}

	public static List<StructuredData> getStructuredDatasByCollectionSetType(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status) {

		return getService().getStructuredDatasByCollectionSetType(
			groupId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	public static List<StructuredData> getStructuredDatasByCollectionSetType(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int start, int end, int status) {

		return getService().getStructuredDatasByCollectionSetType(
			groupId, dataCollectionId, dataSetId, dataTypeId, start, end,
			status);
	}

	public static List<StructuredData> getStructuredDatasByCollectionSetType(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int start, int end, int status,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByCollectionSetType(
			groupId, dataCollectionId, dataSetId, dataTypeId, start, end,
			status, comparator);
	}

	public static List<StructuredData> getStructuredDatasByDataCollectionId(
		long groupId, long dataCollectionId, int status) {

		return getService().getStructuredDatasByDataCollectionId(
			groupId, dataCollectionId, status);
	}

	public static List<StructuredData> getStructuredDatasByDataCollectionId(
		long groupId, long dataCollectionId, int start, int end, int status) {

		return getService().getStructuredDatasByDataCollectionId(
			groupId, dataCollectionId, start, end, status);
	}

	public static List<StructuredData> getStructuredDatasByDataCollectionId(
		long groupId, long dataCollectionId, int start, int end, int status,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByDataCollectionId(
			groupId, dataCollectionId, start, end, status, comparator);
	}

	public static List<StructuredData> getStructuredDatasByDataSetId(
		long groupId, long dataSetId, int status) {

		return getService().getStructuredDatasByDataSetId(
			groupId, dataSetId, status);
	}

	public static List<StructuredData> getStructuredDatasByDataSetId(
		long groupId, long dataSetId, int start, int end, int status) {

		return getService().getStructuredDatasByDataSetId(
			groupId, dataSetId, start, end, status);
	}

	public static List<StructuredData> getStructuredDatasByDataSetId(
		long groupId, long dataSetId, int start, int end, int status,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByDataSetId(
			groupId, dataSetId, start, end, status, comparator);
	}

	public static List<StructuredData> getStructuredDatasByDataTypeId(
		long groupId, long dataTypeId, int status) {

		return getService().getStructuredDatasByDataTypeId(
			groupId, dataTypeId, status);
	}

	public static List<StructuredData> getStructuredDatasByDataTypeId(
		long groupId, long dataTypeId, int status, int start, int end) {

		return getService().getStructuredDatasByDataTypeId(
			groupId, dataTypeId, status, start, end);
	}

	public static List<StructuredData> getStructuredDatasByDataTypeId(
		long groupId, long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByDataTypeId(
			groupId, dataTypeId, status, start, end, comparator);
	}

	public static List<StructuredData> getStructuredDatasByDataTypeId_U(
		long dataTypeId, long userId) {

		return getService().getStructuredDatasByDataTypeId_U(
			dataTypeId, userId);
	}

	public static List<StructuredData> getStructuredDatasByDataTypeId_U(
		long dataTypeId, long userId, int start, int end) {

		return getService().getStructuredDatasByDataTypeId_U(
			dataTypeId, userId, start, end);
	}

	public static List<StructuredData> getStructuredDatasByDataTypeId_U(
		long dataTypeId, long userId, int start, int end,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByDataTypeId_U(
			dataTypeId, userId, start, end, comparator);
	}

	public static List<StructuredData> getStructuredDatasByG_U(
		long groupId, long userId, int status) {

		return getService().getStructuredDatasByG_U(groupId, userId, status);
	}

	public static List<StructuredData> getStructuredDatasByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getService().getStructuredDatasByG_U_S(
			groupId, userId, status, start, end);
	}

	public static List<StructuredData> getStructuredDatasByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByG_U_S(
			groupId, userId, status, start, end, comparator);
	}

	public static List<StructuredData> getStructuredDatasByGroupId(
		long groupId, int status) {

		return getService().getStructuredDatasByGroupId(groupId, status);
	}

	public static List<StructuredData> getStructuredDatasByGroupId(
		long groupId, int start, int end, int status) {

		return getService().getStructuredDatasByGroupId(
			groupId, start, end, status);
	}

	public static List<StructuredData> getStructuredDatasByGroupId(
		long groupId, int start, int end, int status,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByGroupId(
			groupId, start, end, status, comparator);
	}

	public static List<StructuredData> getStructuredDatasBySetType(
		long groupId, long dataSetId, long dataTypeId, int status) {

		return getService().getStructuredDatasBySetType(
			groupId, dataSetId, dataTypeId, status);
	}

	public static List<StructuredData> getStructuredDatasBySetType(
		long groupId, long dataSetId, long dataTypeId, int start, int end,
		int status) {

		return getService().getStructuredDatasBySetType(
			groupId, dataSetId, dataTypeId, start, end, status);
	}

	public static List<StructuredData> getStructuredDatasBySetType(
		long groupId, long dataSetId, long dataTypeId, int start, int end,
		int status, OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasBySetType(
			groupId, dataSetId, dataTypeId, start, end, status, comparator);
	}

	public static List<StructuredData> getStructuredDatasByStatus(int status) {
		return getService().getStructuredDatasByStatus(status);
	}

	public static List<StructuredData> getStructuredDatasByStatus(
		int status, int start, int end) {

		return getService().getStructuredDatasByStatus(status, start, end);
	}

	public static List<StructuredData> getStructuredDatasByStatus(
		int status, int start, int end,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByStatus(
			status, start, end, comparator);
	}

	public static List<StructuredData> getStructuredDatasByUserId(long userId) {
		return getService().getStructuredDatasByUserId(userId);
	}

	public static List<StructuredData> getStructuredDatasByUserId(
		long userId, int status) {

		return getService().getStructuredDatasByUserId(userId, status);
	}

	public static List<StructuredData> getStructuredDatasByUserId(
		long userId, int start, int end) {

		return getService().getStructuredDatasByUserId(userId, start, end);
	}

	public static List<StructuredData> getStructuredDatasByUserId(
		long userId, int start, int end, int status) {

		return getService().getStructuredDatasByUserId(
			userId, start, end, status);
	}

	public static List<StructuredData> getStructuredDatasByUserId(
		long userId, int start, int end, int status,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByUserId(
			userId, start, end, status, comparator);
	}

	public static List<StructuredData> getStructuredDatasByUserId(
		long userId, int start, int end,
		OrderByComparator<StructuredData> comparator) {

		return getService().getStructuredDatasByUserId(
			userId, start, end, comparator);
	}

	/**
	 * Returns all the structured datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the structured datas
	 * @param companyId the primary key of the company
	 * @return the matching structured datas, or an empty list if no matches were found
	 */
	public static List<StructuredData> getStructuredDatasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getStructuredDatasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of structured datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the structured datas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching structured datas, or an empty list if no matches were found
	 */
	public static List<StructuredData> getStructuredDatasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getService().getStructuredDatasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of structured datas.
	 *
	 * @return the number of structured datas
	 */
	public static int getStructuredDatasCount() {
		return getService().getStructuredDatasCount();
	}

	public static com.liferay.portal.kernel.json.JSONObject
			getStructuredDataWithInfo(
				long structuredDataId, java.util.Locale locale)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getStructuredDataWithInfo(structuredDataId, locale);
	}

	public static StructuredData removeStructuredData(
			long structuredDataId, long dataFileFolderId)
		throws PortalException {

		return getService().removeStructuredData(
			structuredDataId, dataFileFolderId);
	}

	public static StructuredData updateStatus(
			long userId, long structuredDataId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException, SystemException {

		return getService().updateStatus(userId, structuredDataId, status, sc);
	}

	public static StructuredData updateStructuredData(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long dataTypeId, boolean multiple, long startIndex, int count,
			String data, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateStructuredData(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, multiple,
			startIndex, count, data, status, sc);
	}

	/**
	 * Updates the structured data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructuredDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structuredData the structured data
	 * @return the structured data that was updated
	 */
	public static StructuredData updateStructuredData(
		StructuredData structuredData) {

		return getService().updateStructuredData(structuredData);
	}

	public static StructuredDataLocalService getService() {
		return _service;
	}

	private static volatile StructuredDataLocalService _service;

}