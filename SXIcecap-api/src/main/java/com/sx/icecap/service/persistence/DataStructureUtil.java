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

package com.sx.icecap.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sx.icecap.model.DataStructure;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the data structure service. This utility wraps <code>com.sx.icecap.service.persistence.impl.DataStructurePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataStructurePersistence
 * @generated
 */
public class DataStructureUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DataStructure dataStructure) {
		getPersistence().clearCache(dataStructure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DataStructure> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataStructure update(DataStructure dataStructure) {
		return getPersistence().update(dataStructure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataStructure update(
		DataStructure dataStructure, ServiceContext serviceContext) {

		return getPersistence().update(dataStructure, serviceContext);
	}

	/**
	 * Returns all the data structures where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data structures
	 */
	public static List<DataStructure> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the data structures where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	public static List<DataStructure> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data structures where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data structure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByUuid_First(
			String uuid, OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first data structure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByUuid_First(
		String uuid, OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByUuid_Last(
			String uuid, OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByUuid_Last(
		String uuid, OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where uuid = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] findByUuid_PrevAndNext(
			long dataStructureId, String uuid,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByUuid_PrevAndNext(
			dataStructureId, uuid, orderByComparator);
	}

	/**
	 * Removes all the data structures where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of data structures where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data structures
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the data structure where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataStructureException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data structure where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data structure where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the data structure where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data structure that was removed
	 */
	public static DataStructure removeByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of data structures where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data structures
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the data structures where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data structures
	 */
	public static List<DataStructure> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the data structures where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	public static List<DataStructure> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data structures where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data structure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first data structure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] findByUuid_C_PrevAndNext(
			long dataStructureId, String uuid, long companyId,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByUuid_C_PrevAndNext(
			dataStructureId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the data structures where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of data structures where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data structures
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the data structures where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data structures
	 */
	public static List<DataStructure> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the data structures where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	public static List<DataStructure> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data structures where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByGroupId_First(
			long groupId, OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByGroupId_First(
		long groupId, OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByGroupId_Last(
			long groupId, OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByGroupId_Last(
		long groupId, OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where groupId = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] findByGroupId_PrevAndNext(
			long dataStructureId, long groupId,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByGroupId_PrevAndNext(
			dataStructureId, groupId, orderByComparator);
	}

	/**
	 * Returns all the data structures that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the data structures that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set of data structures that the user has permission to view where groupId = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] filterFindByGroupId_PrevAndNext(
			long dataStructureId, long groupId,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			dataStructureId, groupId, orderByComparator);
	}

	/**
	 * Removes all the data structures where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of data structures where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data structures
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of data structures that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data structures that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the data structures where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data structures
	 */
	public static List<DataStructure> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the data structures where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	public static List<DataStructure> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data structures where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data structure in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByUserId_First(
			long userId, OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first data structure in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByUserId_First(
		long userId, OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByUserId_Last(
			long userId, OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByUserId_Last(
		long userId, OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where userId = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] findByUserId_PrevAndNext(
			long dataStructureId, long userId,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByUserId_PrevAndNext(
			dataStructureId, userId, orderByComparator);
	}

	/**
	 * Removes all the data structures where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of data structures where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data structures
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the data structures where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data structures
	 */
	public static List<DataStructure> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the data structures where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	public static List<DataStructure> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data structures where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data structure in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByStatus_First(
			int status, OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first data structure in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByStatus_First(
		int status, OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByStatus_Last(
			int status, OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByStatus_Last(
		int status, OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where status = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] findByStatus_PrevAndNext(
			long dataStructureId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByStatus_PrevAndNext(
			dataStructureId, status, orderByComparator);
	}

	/**
	 * Removes all the data structures where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of data structures where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data structures
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the data structures where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data structures
	 */
	public static List<DataStructure> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the data structures where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	public static List<DataStructure> findByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data structures where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByG_U_First(
			long groupId, long userId,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] findByG_U_PrevAndNext(
			long dataStructureId, long groupId, long userId,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByG_U_PrevAndNext(
			dataStructureId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns all the data structures that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByG_U(
		long groupId, long userId) {

		return getPersistence().filterFindByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the data structures that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().filterFindByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures that the user has permissions to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().filterFindByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set of data structures that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] filterFindByG_U_PrevAndNext(
			long dataStructureId, long groupId, long userId,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().filterFindByG_U_PrevAndNext(
			dataStructureId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the data structures where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	 * Returns the number of data structures where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data structures
	 */
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	 * Returns the number of data structures that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data structures that the user has permission to view
	 */
	public static int filterCountByG_U(long groupId, long userId) {
		return getPersistence().filterCountByG_U(groupId, userId);
	}

	/**
	 * Returns all the data structures where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data structures
	 */
	public static List<DataStructure> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the data structures where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	public static List<DataStructure> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data structures where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByG_S_First(
			long groupId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByG_S_Last(
			long groupId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] findByG_S_PrevAndNext(
			long dataStructureId, long groupId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByG_S_PrevAndNext(
			dataStructureId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the data structures that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByG_S(
		long groupId, int status) {

		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the data structures that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set of data structures that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] filterFindByG_S_PrevAndNext(
			long dataStructureId, long groupId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			dataStructureId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the data structures where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of data structures where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data structures
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of data structures that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data structures that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns all the data structures where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data structures
	 */
	public static List<DataStructure> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the data structures where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	public static List<DataStructure> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data structures where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data structure in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByU_S_First(
			long userId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first data structure in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByU_S_First(
		long userId, int status,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByU_S_Last(
			long userId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] findByU_S_PrevAndNext(
			long dataStructureId, long userId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByU_S_PrevAndNext(
			dataStructureId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the data structures where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of data structures where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data structures
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns all the data structures where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data structures
	 */
	public static List<DataStructure> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the data structures where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	public static List<DataStructure> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data structures where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] findByG_U_S_PrevAndNext(
			long dataStructureId, long groupId, long userId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByG_U_S_PrevAndNext(
			dataStructureId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the data structures that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterFindByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the data structures that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures that the user has permission to view
	 */
	public static List<DataStructure> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set of data structures that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] filterFindByG_U_S_PrevAndNext(
			long dataStructureId, long groupId, long userId, int status,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().filterFindByG_U_S_PrevAndNext(
			dataStructureId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the data structures where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of data structures where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data structures
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of data structures that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data structures that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterCountByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns all the data structures where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @return the matching data structures
	 */
	public static List<DataStructure> findByName(String dataStructureName) {
		return getPersistence().findByName(dataStructureName);
	}

	/**
	 * Returns a range of all the data structures where dataStructureName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dataStructureName the data structure name
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	public static List<DataStructure> findByName(
		String dataStructureName, int start, int end) {

		return getPersistence().findByName(dataStructureName, start, end);
	}

	/**
	 * Returns an ordered range of all the data structures where dataStructureName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dataStructureName the data structure name
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByName(
		String dataStructureName, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findByName(
			dataStructureName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data structures where dataStructureName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dataStructureName the data structure name
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	public static List<DataStructure> findByName(
		String dataStructureName, int start, int end,
		OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			dataStructureName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data structure in the ordered set where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByName_First(
			String dataStructureName,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByName_First(
			dataStructureName, orderByComparator);
	}

	/**
	 * Returns the first data structure in the ordered set where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByName_First(
		String dataStructureName,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByName_First(
			dataStructureName, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByName_Last(
			String dataStructureName,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByName_Last(
			dataStructureName, orderByComparator);
	}

	/**
	 * Returns the last data structure in the ordered set where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByName_Last(
		String dataStructureName,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().fetchByName_Last(
			dataStructureName, orderByComparator);
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where dataStructureName = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param dataStructureName the data structure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure[] findByName_PrevAndNext(
			long dataStructureId, String dataStructureName,
			OrderByComparator<DataStructure> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByName_PrevAndNext(
			dataStructureId, dataStructureName, orderByComparator);
	}

	/**
	 * Removes all the data structures where dataStructureName = &#63; from the database.
	 *
	 * @param dataStructureName the data structure name
	 */
	public static void removeByName(String dataStructureName) {
		getPersistence().removeByName(dataStructureName);
	}

	/**
	 * Returns the number of data structures where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @return the number of matching data structures
	 */
	public static int countByName(String dataStructureName) {
		return getPersistence().countByName(dataStructureName);
	}

	/**
	 * Returns the data structure where dataStructureName = &#63; and dataStructureVersion = &#63; or throws a <code>NoSuchDataStructureException</code> if it could not be found.
	 *
	 * @param dataStructureName the data structure name
	 * @param dataStructureVersion the data structure version
	 * @return the matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public static DataStructure findByNameVersion(
			String dataStructureName, String dataStructureVersion)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByNameVersion(
			dataStructureName, dataStructureVersion);
	}

	/**
	 * Returns the data structure where dataStructureName = &#63; and dataStructureVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataStructureName the data structure name
	 * @param dataStructureVersion the data structure version
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByNameVersion(
		String dataStructureName, String dataStructureVersion) {

		return getPersistence().fetchByNameVersion(
			dataStructureName, dataStructureVersion);
	}

	/**
	 * Returns the data structure where dataStructureName = &#63; and dataStructureVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataStructureName the data structure name
	 * @param dataStructureVersion the data structure version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public static DataStructure fetchByNameVersion(
		String dataStructureName, String dataStructureVersion,
		boolean useFinderCache) {

		return getPersistence().fetchByNameVersion(
			dataStructureName, dataStructureVersion, useFinderCache);
	}

	/**
	 * Removes the data structure where dataStructureName = &#63; and dataStructureVersion = &#63; from the database.
	 *
	 * @param dataStructureName the data structure name
	 * @param dataStructureVersion the data structure version
	 * @return the data structure that was removed
	 */
	public static DataStructure removeByNameVersion(
			String dataStructureName, String dataStructureVersion)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().removeByNameVersion(
			dataStructureName, dataStructureVersion);
	}

	/**
	 * Returns the number of data structures where dataStructureName = &#63; and dataStructureVersion = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @param dataStructureVersion the data structure version
	 * @return the number of matching data structures
	 */
	public static int countByNameVersion(
		String dataStructureName, String dataStructureVersion) {

		return getPersistence().countByNameVersion(
			dataStructureName, dataStructureVersion);
	}

	/**
	 * Caches the data structure in the entity cache if it is enabled.
	 *
	 * @param dataStructure the data structure
	 */
	public static void cacheResult(DataStructure dataStructure) {
		getPersistence().cacheResult(dataStructure);
	}

	/**
	 * Caches the data structures in the entity cache if it is enabled.
	 *
	 * @param dataStructures the data structures
	 */
	public static void cacheResult(List<DataStructure> dataStructures) {
		getPersistence().cacheResult(dataStructures);
	}

	/**
	 * Creates a new data structure with the primary key. Does not add the data structure to the database.
	 *
	 * @param dataStructureId the primary key for the new data structure
	 * @return the new data structure
	 */
	public static DataStructure create(long dataStructureId) {
		return getPersistence().create(dataStructureId);
	}

	/**
	 * Removes the data structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure that was removed
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure remove(long dataStructureId)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().remove(dataStructureId);
	}

	public static DataStructure updateImpl(DataStructure dataStructure) {
		return getPersistence().updateImpl(dataStructure);
	}

	/**
	 * Returns the data structure with the primary key or throws a <code>NoSuchDataStructureException</code> if it could not be found.
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure findByPrimaryKey(long dataStructureId)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByPrimaryKey(dataStructureId);
	}

	/**
	 * Returns the data structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure, or <code>null</code> if a data structure with the primary key could not be found
	 */
	public static DataStructure fetchByPrimaryKey(long dataStructureId) {
		return getPersistence().fetchByPrimaryKey(dataStructureId);
	}

	/**
	 * Returns all the data structures.
	 *
	 * @return the data structures
	 */
	public static List<DataStructure> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the data structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of data structures
	 */
	public static List<DataStructure> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the data structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data structures
	 */
	public static List<DataStructure> findAll(
		int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data structures
	 */
	public static List<DataStructure> findAll(
		int start, int end, OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the data structures from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data structures.
	 *
	 * @return the number of data structures
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataStructurePersistence getPersistence() {
		return _persistence;
	}

	private static volatile DataStructurePersistence _persistence;

}