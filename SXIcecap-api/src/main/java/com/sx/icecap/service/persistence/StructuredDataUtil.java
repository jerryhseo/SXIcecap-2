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

import com.sx.icecap.model.StructuredData;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the structured data service. This utility wraps <code>com.sx.icecap.service.persistence.impl.StructuredDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StructuredDataPersistence
 * @generated
 */
public class StructuredDataUtil {

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
	public static void clearCache(StructuredData structuredData) {
		getPersistence().clearCache(structuredData);
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
	public static Map<Serializable, StructuredData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StructuredData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StructuredData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StructuredData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StructuredData update(StructuredData structuredData) {
		return getPersistence().update(structuredData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StructuredData update(
		StructuredData structuredData, ServiceContext serviceContext) {

		return getPersistence().update(structuredData, serviceContext);
	}

	/**
	 * Returns all the structured datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the structured datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUuid_First(
			String uuid, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUuid_First(
		String uuid, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUuid_Last(
			String uuid, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUuid_Last(
		String uuid, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where uuid = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByUuid_PrevAndNext(
			long structuredDataId, String uuid,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_PrevAndNext(
			structuredDataId, uuid, orderByComparator);
	}

	/**
	 * Removes all the structured datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of structured datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching structured datas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the structured data where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStructuredDataException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the structured data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the structured data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the structured data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the structured data that was removed
	 */
	public static StructuredData removeByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of structured datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByUuid_C_PrevAndNext(
			long structuredDataId, String uuid, long companyId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_C_PrevAndNext(
			structuredDataId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching structured datas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByGroupId_First(
			long groupId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByGroupId_First(
		long groupId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByGroupId_Last(
			long groupId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByGroupId_Last(
		long groupId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByGroupId_PrevAndNext(
			long structuredDataId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByGroupId_PrevAndNext(
			structuredDataId, groupId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByGroupId_PrevAndNext(
			long structuredDataId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			structuredDataId, groupId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByGroupId_S(
		long groupId, int status) {

		return getPersistence().findByGroupId_S(groupId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByGroupId_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByGroupId_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByGroupId_S(
		long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByGroupId_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByGroupId_S(
		long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByGroupId_S_First(
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByGroupId_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByGroupId_S_First(
		long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByGroupId_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByGroupId_S_Last(
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByGroupId_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByGroupId_S_Last(
		long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByGroupId_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByGroupId_S_PrevAndNext(
			long structuredDataId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByGroupId_S_PrevAndNext(
			structuredDataId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByGroupId_S(
		long groupId, int status) {

		return getPersistence().filterFindByGroupId_S(groupId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByGroupId_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByGroupId_S(
			groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByGroupId_S(
		long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByGroupId_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByGroupId_S_PrevAndNext(
			long structuredDataId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByGroupId_S_PrevAndNext(
			structuredDataId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByGroupId_S(long groupId, int status) {
		getPersistence().removeByGroupId_S(groupId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByGroupId_S(long groupId, int status) {
		return getPersistence().countByGroupId_S(groupId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByGroupId_S(long groupId, int status) {
		return getPersistence().filterCountByGroupId_S(groupId, status);
	}

	/**
	 * Returns all the structured datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUserId(
		long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUserId(
		long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUserId_First(
			long userId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUserId_First(
		long userId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUserId_Last(
			long userId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUserId_Last(
		long userId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByUserId_PrevAndNext(
			long structuredDataId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUserId_PrevAndNext(
			structuredDataId, userId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of structured datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByUserId_S(long userId, int status) {
		return getPersistence().findByUserId_S(userId, status);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByUserId_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByUserId_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUserId_S(
		long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByUserId_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUserId_S(
		long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUserId_S_First(
			long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUserId_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUserId_S_First(
		long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUserId_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUserId_S_Last(
			long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUserId_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUserId_S_Last(
		long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUserId_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByUserId_S_PrevAndNext(
			long structuredDataId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUserId_S_PrevAndNext(
			structuredDataId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByUserId_S(long userId, int status) {
		getPersistence().removeByUserId_S(userId, status);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByUserId_S(long userId, int status) {
		return getPersistence().countByUserId_S(userId, status);
	}

	/**
	 * Returns all the structured datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the structured datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByStatus(
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByStatus(
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByStatus_First(
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByStatus_First(
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByStatus_Last(
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByStatus_Last(
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByStatus_PrevAndNext(
			long structuredDataId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByStatus_PrevAndNext(
			structuredDataId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of structured datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByG_U_First(
			long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByG_U_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_PrevAndNext(
			structuredDataId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U(
		long groupId, long userId) {

		return getPersistence().filterFindByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().filterFindByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByG_U_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByG_U_PrevAndNext(
			structuredDataId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByG_U(long groupId, long userId) {
		return getPersistence().filterCountByG_U(groupId, userId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByG_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_S_PrevAndNext(
			structuredDataId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterFindByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByG_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByG_U_S_PrevAndNext(
			structuredDataId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterCountByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId(
		long dataCollectionId) {

		return getPersistence().findByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId(
		long dataCollectionId, int start, int end) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_First(
			long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_First(
		long dataCollectionId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_Last(
			long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_Last(
		long dataCollectionId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_PrevAndNext(
			long structuredDataId, long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_PrevAndNext(
			structuredDataId, dataCollectionId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public static void removeByDataCollectionId(long dataCollectionId) {
		getPersistence().removeByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId(long dataCollectionId) {
		return getPersistence().countByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_S(
		long dataCollectionId, int status) {

		return getPersistence().findByDataCollectionId_S(
			dataCollectionId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_S(
		long dataCollectionId, int status, int start, int end) {

		return getPersistence().findByDataCollectionId_S(
			dataCollectionId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_S(
		long dataCollectionId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_S(
			dataCollectionId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_S(
		long dataCollectionId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_S(
			dataCollectionId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_S_First(
			long dataCollectionId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_S_First(
			dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_S_First(
		long dataCollectionId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_S_First(
			dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_S_Last(
			long dataCollectionId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_S_Last(
			dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_S_Last(
		long dataCollectionId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_S_Last(
			dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_S_PrevAndNext(
			structuredDataId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 */
	public static void removeByDataCollectionId_S(
		long dataCollectionId, int status) {

		getPersistence().removeByDataCollectionId_S(dataCollectionId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_S(
		long dataCollectionId, int status) {

		return getPersistence().countByDataCollectionId_S(
			dataCollectionId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G(
		long groupId, long dataCollectionId) {

		return getPersistence().findByDataCollectionId_G(
			groupId, dataCollectionId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G(
		long groupId, long dataCollectionId, int start, int end) {

		return getPersistence().findByDataCollectionId_G(
			groupId, dataCollectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G(
		long groupId, long dataCollectionId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_G(
			groupId, dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G(
		long groupId, long dataCollectionId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_G(
			groupId, dataCollectionId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_First(
			long groupId, long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_First(
			groupId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_First(
		long groupId, long dataCollectionId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_First(
			groupId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_Last(
			long groupId, long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_Last(
			groupId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_Last(
		long groupId, long dataCollectionId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_Last(
			groupId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_G_PrevAndNext(
			long structuredDataId, long groupId, long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G(
		long groupId, long dataCollectionId) {

		return getPersistence().filterFindByDataCollectionId_G(
			groupId, dataCollectionId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G(
		long groupId, long dataCollectionId, int start, int end) {

		return getPersistence().filterFindByDataCollectionId_G(
			groupId, dataCollectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G(
		long groupId, long dataCollectionId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataCollectionId_G(
			groupId, dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataCollectionId_G_PrevAndNext(
			long structuredDataId, long groupId, long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataCollectionId_G_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataCollectionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 */
	public static void removeByDataCollectionId_G(
		long groupId, long dataCollectionId) {

		getPersistence().removeByDataCollectionId_G(groupId, dataCollectionId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_G(
		long groupId, long dataCollectionId) {

		return getPersistence().countByDataCollectionId_G(
			groupId, dataCollectionId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataCollectionId_G(
		long groupId, long dataCollectionId) {

		return getPersistence().filterCountByDataCollectionId_G(
			groupId, dataCollectionId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_S(
		long groupId, long dataCollectionId, int status) {

		return getPersistence().findByDataCollectionId_G_S(
			groupId, dataCollectionId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_S(
		long groupId, long dataCollectionId, int status, int start, int end) {

		return getPersistence().findByDataCollectionId_G_S(
			groupId, dataCollectionId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_S(
		long groupId, long dataCollectionId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_G_S(
			groupId, dataCollectionId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_S(
		long groupId, long dataCollectionId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_G_S(
			groupId, dataCollectionId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_S_First(
			long groupId, long dataCollectionId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_S_First(
			groupId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_S_First(
		long groupId, long dataCollectionId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_S_First(
			groupId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_S_Last(
			long groupId, long dataCollectionId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_S_Last(
			groupId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_S_Last(
		long groupId, long dataCollectionId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_S_Last(
			groupId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_G_S_PrevAndNext(
			long structuredDataId, long groupId, long dataCollectionId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_S_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_S(
		long groupId, long dataCollectionId, int status) {

		return getPersistence().filterFindByDataCollectionId_G_S(
			groupId, dataCollectionId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_S(
		long groupId, long dataCollectionId, int status, int start, int end) {

		return getPersistence().filterFindByDataCollectionId_G_S(
			groupId, dataCollectionId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_S(
		long groupId, long dataCollectionId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataCollectionId_G_S(
			groupId, dataCollectionId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataCollectionId_G_S_PrevAndNext(
			long structuredDataId, long groupId, long dataCollectionId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataCollectionId_G_S_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataCollectionId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 */
	public static void removeByDataCollectionId_G_S(
		long groupId, long dataCollectionId, int status) {

		getPersistence().removeByDataCollectionId_G_S(
			groupId, dataCollectionId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_G_S(
		long groupId, long dataCollectionId, int status) {

		return getPersistence().countByDataCollectionId_G_S(
			groupId, dataCollectionId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataCollectionId_G_S(
		long groupId, long dataCollectionId, int status) {

		return getPersistence().filterCountByDataCollectionId_G_S(
			groupId, dataCollectionId, status);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U(
		long userId, long dataCollectionId) {

		return getPersistence().findByDataCollectionId_U(
			userId, dataCollectionId);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U(
		long userId, long dataCollectionId, int start, int end) {

		return getPersistence().findByDataCollectionId_U(
			userId, dataCollectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U(
		long userId, long dataCollectionId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_U(
			userId, dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U(
		long userId, long dataCollectionId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_U(
			userId, dataCollectionId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_U_First(
			long userId, long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_First(
			userId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_U_First(
		long userId, long dataCollectionId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_U_First(
			userId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_U_Last(
			long userId, long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_Last(
			userId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_U_Last(
		long userId, long dataCollectionId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_U_Last(
			userId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_U_PrevAndNext(
			long structuredDataId, long userId, long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_PrevAndNext(
			structuredDataId, userId, dataCollectionId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataCollectionId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 */
	public static void removeByDataCollectionId_U(
		long userId, long dataCollectionId) {

		getPersistence().removeByDataCollectionId_U(userId, dataCollectionId);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_U(
		long userId, long dataCollectionId) {

		return getPersistence().countByDataCollectionId_U(
			userId, dataCollectionId);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U_S(
		long userId, long dataCollectionId, int status) {

		return getPersistence().findByDataCollectionId_U_S(
			userId, dataCollectionId, status);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U_S(
		long userId, long dataCollectionId, int status, int start, int end) {

		return getPersistence().findByDataCollectionId_U_S(
			userId, dataCollectionId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U_S(
		long userId, long dataCollectionId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_U_S(
			userId, dataCollectionId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U_S(
		long userId, long dataCollectionId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_U_S(
			userId, dataCollectionId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_U_S_First(
			long userId, long dataCollectionId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_S_First(
			userId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_U_S_First(
		long userId, long dataCollectionId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_U_S_First(
			userId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_U_S_Last(
			long userId, long dataCollectionId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_S_Last(
			userId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_U_S_Last(
		long userId, long dataCollectionId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_U_S_Last(
			userId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_U_S_PrevAndNext(
			long structuredDataId, long userId, long dataCollectionId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_S_PrevAndNext(
			structuredDataId, userId, dataCollectionId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataCollectionId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 */
	public static void removeByDataCollectionId_U_S(
		long userId, long dataCollectionId, int status) {

		getPersistence().removeByDataCollectionId_U_S(
			userId, dataCollectionId, status);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_U_S(
		long userId, long dataCollectionId, int status) {

		return getPersistence().countByDataCollectionId_U_S(
			userId, dataCollectionId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U(
		long groupId, long userId, long dataCollectionId) {

		return getPersistence().findByDataCollectionId_G_U(
			groupId, userId, dataCollectionId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U(
		long groupId, long userId, long dataCollectionId, int start, int end) {

		return getPersistence().findByDataCollectionId_G_U(
			groupId, userId, dataCollectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U(
		long groupId, long userId, long dataCollectionId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_G_U(
			groupId, userId, dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U(
		long groupId, long userId, long dataCollectionId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_G_U(
			groupId, userId, dataCollectionId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_U_First(
			long groupId, long userId, long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_First(
			groupId, userId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_U_First(
		long groupId, long userId, long dataCollectionId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_U_First(
			groupId, userId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_U_Last(
			long groupId, long userId, long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_Last(
			groupId, userId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_U_Last(
		long groupId, long userId, long dataCollectionId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_U_Last(
			groupId, userId, dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_G_U_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U(
		long groupId, long userId, long dataCollectionId) {

		return getPersistence().filterFindByDataCollectionId_G_U(
			groupId, userId, dataCollectionId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U(
		long groupId, long userId, long dataCollectionId, int start, int end) {

		return getPersistence().filterFindByDataCollectionId_G_U(
			groupId, userId, dataCollectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U(
		long groupId, long userId, long dataCollectionId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataCollectionId_G_U(
			groupId, userId, dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataCollectionId_G_U_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			long dataCollectionId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataCollectionId_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 */
	public static void removeByDataCollectionId_G_U(
		long groupId, long userId, long dataCollectionId) {

		getPersistence().removeByDataCollectionId_G_U(
			groupId, userId, dataCollectionId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_G_U(
		long groupId, long userId, long dataCollectionId) {

		return getPersistence().countByDataCollectionId_G_U(
			groupId, userId, dataCollectionId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataCollectionId_G_U(
		long groupId, long userId, long dataCollectionId) {

		return getPersistence().filterCountByDataCollectionId_G_U(
			groupId, userId, dataCollectionId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U_S(
		long groupId, long userId, long dataCollectionId, int status) {

		return getPersistence().findByDataCollectionId_G_U_S(
			groupId, userId, dataCollectionId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U_S(
		long groupId, long userId, long dataCollectionId, int status, int start,
		int end) {

		return getPersistence().findByDataCollectionId_G_U_S(
			groupId, userId, dataCollectionId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U_S(
		long groupId, long userId, long dataCollectionId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_G_U_S(
			groupId, userId, dataCollectionId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U_S(
		long groupId, long userId, long dataCollectionId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_G_U_S(
			groupId, userId, dataCollectionId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_U_S_First(
			long groupId, long userId, long dataCollectionId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_S_First(
			groupId, userId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_U_S_First(
		long groupId, long userId, long dataCollectionId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_U_S_First(
			groupId, userId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_U_S_Last(
			long groupId, long userId, long dataCollectionId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_S_Last(
			groupId, userId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_U_S_Last(
		long groupId, long userId, long dataCollectionId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_U_S_Last(
			groupId, userId, dataCollectionId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_G_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			long dataCollectionId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U_S(
		long groupId, long userId, long dataCollectionId, int status) {

		return getPersistence().filterFindByDataCollectionId_G_U_S(
			groupId, userId, dataCollectionId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U_S(
		long groupId, long userId, long dataCollectionId, int status, int start,
		int end) {

		return getPersistence().filterFindByDataCollectionId_G_U_S(
			groupId, userId, dataCollectionId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U_S(
		long groupId, long userId, long dataCollectionId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataCollectionId_G_U_S(
			groupId, userId, dataCollectionId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[]
			filterFindByDataCollectionId_G_U_S_PrevAndNext(
				long structuredDataId, long groupId, long userId,
				long dataCollectionId, int status,
				OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataCollectionId_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 */
	public static void removeByDataCollectionId_G_U_S(
		long groupId, long userId, long dataCollectionId, int status) {

		getPersistence().removeByDataCollectionId_G_U_S(
			groupId, userId, dataCollectionId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_G_U_S(
		long groupId, long userId, long dataCollectionId, int status) {

		return getPersistence().countByDataCollectionId_G_U_S(
			groupId, userId, dataCollectionId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataCollectionId_G_U_S(
		long groupId, long userId, long dataCollectionId, int status) {

		return getPersistence().filterCountByDataCollectionId_G_U_S(
			groupId, userId, dataCollectionId, status);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId(long dataSetId) {
		return getPersistence().findByDataSetId(dataSetId);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId(
		long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId(dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_First(
			long dataSetId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_First(
		long dataSetId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_Last(
			long dataSetId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_Last(
		long dataSetId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_PrevAndNext(
			long structuredDataId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_PrevAndNext(
			structuredDataId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId(long dataSetId) {
		getPersistence().removeByDataSetId(dataSetId);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId(long dataSetId) {
		return getPersistence().countByDataSetId(dataSetId);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_S(
		long dataSetId, int status) {

		return getPersistence().findByDataSetId_S(dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_S(
		long dataSetId, int status, int start, int end) {

		return getPersistence().findByDataSetId_S(
			dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_S(
		long dataSetId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_S(
			dataSetId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_S(
		long dataSetId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_S(
			dataSetId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_S_First(
			long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_S_First(
			dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_S_First(
		long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_S_First(
			dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_S_Last(
			long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_S_Last(
			dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_S_Last(
		long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_S_Last(
			dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_S_PrevAndNext(
			long structuredDataId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_S_PrevAndNext(
			structuredDataId, dataSetId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and status = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param status the status
	 */
	public static void removeByDataSetId_S(long dataSetId, int status) {
		getPersistence().removeByDataSetId_S(dataSetId, status);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_S(long dataSetId, int status) {
		return getPersistence().countByDataSetId_S(dataSetId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G(
		long groupId, long dataSetId) {

		return getPersistence().findByDataSetId_G(groupId, dataSetId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G(
		long groupId, long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId_G(
			groupId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G(
		long groupId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_G(
			groupId, dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G(
		long groupId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_G(
			groupId, dataSetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_First(
			long groupId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_First(
			groupId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_First(
		long groupId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_First(
			groupId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_Last(
			long groupId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_Last(
			groupId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_Last(
		long groupId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_Last(
			groupId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_G_PrevAndNext(
			long structuredDataId, long groupId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_PrevAndNext(
			structuredDataId, groupId, dataSetId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G(
		long groupId, long dataSetId) {

		return getPersistence().filterFindByDataSetId_G(groupId, dataSetId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G(
		long groupId, long dataSetId, int start, int end) {

		return getPersistence().filterFindByDataSetId_G(
			groupId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G(
		long groupId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataSetId_G(
			groupId, dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataSetId_G_PrevAndNext(
			long structuredDataId, long groupId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataSetId_G_PrevAndNext(
			structuredDataId, groupId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId_G(long groupId, long dataSetId) {
		getPersistence().removeByDataSetId_G(groupId, dataSetId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_G(long groupId, long dataSetId) {
		return getPersistence().countByDataSetId_G(groupId, dataSetId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataSetId_G(long groupId, long dataSetId) {
		return getPersistence().filterCountByDataSetId_G(groupId, dataSetId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_S(
		long groupId, long dataSetId, int status) {

		return getPersistence().findByDataSetId_G_S(groupId, dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_S(
		long groupId, long dataSetId, int status, int start, int end) {

		return getPersistence().findByDataSetId_G_S(
			groupId, dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_S(
		long groupId, long dataSetId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_G_S(
			groupId, dataSetId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_S(
		long groupId, long dataSetId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_G_S(
			groupId, dataSetId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_S_First(
			long groupId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_S_First(
			groupId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_S_First(
		long groupId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_S_First(
			groupId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_S_Last(
			long groupId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_S_Last(
			groupId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_S_Last(
		long groupId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_S_Last(
			groupId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_G_S_PrevAndNext(
			long structuredDataId, long groupId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_S_PrevAndNext(
			structuredDataId, groupId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_S(
		long groupId, long dataSetId, int status) {

		return getPersistence().filterFindByDataSetId_G_S(
			groupId, dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_S(
		long groupId, long dataSetId, int status, int start, int end) {

		return getPersistence().filterFindByDataSetId_G_S(
			groupId, dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_S(
		long groupId, long dataSetId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataSetId_G_S(
			groupId, dataSetId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataSetId_G_S_PrevAndNext(
			long structuredDataId, long groupId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataSetId_G_S_PrevAndNext(
			structuredDataId, groupId, dataSetId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataSetId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 */
	public static void removeByDataSetId_G_S(
		long groupId, long dataSetId, int status) {

		getPersistence().removeByDataSetId_G_S(groupId, dataSetId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_G_S(
		long groupId, long dataSetId, int status) {

		return getPersistence().countByDataSetId_G_S(
			groupId, dataSetId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataSetId_G_S(
		long groupId, long dataSetId, int status) {

		return getPersistence().filterCountByDataSetId_G_S(
			groupId, dataSetId, status);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U(
		long userId, long dataSetId) {

		return getPersistence().findByDataSetId_U(userId, dataSetId);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U(
		long userId, long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId_U(
			userId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U(
		long userId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_U(
			userId, dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U(
		long userId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_U(
			userId, dataSetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_U_First(
			long userId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_First(
			userId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_U_First(
		long userId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_U_First(
			userId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_U_Last(
			long userId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_Last(
			userId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_U_Last(
		long userId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_U_Last(
			userId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_U_PrevAndNext(
			long structuredDataId, long userId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_PrevAndNext(
			structuredDataId, userId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId_U(long userId, long dataSetId) {
		getPersistence().removeByDataSetId_U(userId, dataSetId);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_U(long userId, long dataSetId) {
		return getPersistence().countByDataSetId_U(userId, dataSetId);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U_S(
		long userId, long dataSetId, int status) {

		return getPersistence().findByDataSetId_U_S(userId, dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U_S(
		long userId, long dataSetId, int status, int start, int end) {

		return getPersistence().findByDataSetId_U_S(
			userId, dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U_S(
		long userId, long dataSetId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_U_S(
			userId, dataSetId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U_S(
		long userId, long dataSetId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_U_S(
			userId, dataSetId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_U_S_First(
			long userId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_S_First(
			userId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_U_S_First(
		long userId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_U_S_First(
			userId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_U_S_Last(
			long userId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_S_Last(
			userId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_U_S_Last(
		long userId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_U_S_Last(
			userId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_U_S_PrevAndNext(
			long structuredDataId, long userId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_S_PrevAndNext(
			structuredDataId, userId, dataSetId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataSetId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 */
	public static void removeByDataSetId_U_S(
		long userId, long dataSetId, int status) {

		getPersistence().removeByDataSetId_U_S(userId, dataSetId, status);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_U_S(
		long userId, long dataSetId, int status) {

		return getPersistence().countByDataSetId_U_S(userId, dataSetId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U(
		long groupId, long userId, long dataSetId) {

		return getPersistence().findByDataSetId_G_U(groupId, userId, dataSetId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U(
		long groupId, long userId, long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId_G_U(
			groupId, userId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U(
		long groupId, long userId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_G_U(
			groupId, userId, dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U(
		long groupId, long userId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_G_U(
			groupId, userId, dataSetId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_U_First(
			long groupId, long userId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_First(
			groupId, userId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_U_First(
		long groupId, long userId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_U_First(
			groupId, userId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_U_Last(
			long groupId, long userId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_Last(
			groupId, userId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_U_Last(
		long groupId, long userId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_U_Last(
			groupId, userId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_G_U_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataSetId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U(
		long groupId, long userId, long dataSetId) {

		return getPersistence().filterFindByDataSetId_G_U(
			groupId, userId, dataSetId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U(
		long groupId, long userId, long dataSetId, int start, int end) {

		return getPersistence().filterFindByDataSetId_G_U(
			groupId, userId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U(
		long groupId, long userId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataSetId_G_U(
			groupId, userId, dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataSetId_G_U_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataSetId_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId_G_U(
		long groupId, long userId, long dataSetId) {

		getPersistence().removeByDataSetId_G_U(groupId, userId, dataSetId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_G_U(
		long groupId, long userId, long dataSetId) {

		return getPersistence().countByDataSetId_G_U(
			groupId, userId, dataSetId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataSetId_G_U(
		long groupId, long userId, long dataSetId) {

		return getPersistence().filterCountByDataSetId_G_U(
			groupId, userId, dataSetId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U_S(
		long groupId, long userId, long dataSetId, int status) {

		return getPersistence().findByDataSetId_G_U_S(
			groupId, userId, dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U_S(
		long groupId, long userId, long dataSetId, int status, int start,
		int end) {

		return getPersistence().findByDataSetId_G_U_S(
			groupId, userId, dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U_S(
		long groupId, long userId, long dataSetId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_G_U_S(
			groupId, userId, dataSetId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U_S(
		long groupId, long userId, long dataSetId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_G_U_S(
			groupId, userId, dataSetId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_U_S_First(
			long groupId, long userId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_S_First(
			groupId, userId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_U_S_First(
		long groupId, long userId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_U_S_First(
			groupId, userId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_U_S_Last(
			long groupId, long userId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_S_Last(
			groupId, userId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_U_S_Last(
		long groupId, long userId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_U_S_Last(
			groupId, userId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_G_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataSetId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataSetId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U_S(
		long groupId, long userId, long dataSetId, int status) {

		return getPersistence().filterFindByDataSetId_G_U_S(
			groupId, userId, dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U_S(
		long groupId, long userId, long dataSetId, int status, int start,
		int end) {

		return getPersistence().filterFindByDataSetId_G_U_S(
			groupId, userId, dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U_S(
		long groupId, long userId, long dataSetId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataSetId_G_U_S(
			groupId, userId, dataSetId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataSetId_G_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataSetId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataSetId_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataSetId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 */
	public static void removeByDataSetId_G_U_S(
		long groupId, long userId, long dataSetId, int status) {

		getPersistence().removeByDataSetId_G_U_S(
			groupId, userId, dataSetId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_G_U_S(
		long groupId, long userId, long dataSetId, int status) {

		return getPersistence().countByDataSetId_G_U_S(
			groupId, userId, dataSetId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataSetId_G_U_S(
		long groupId, long userId, long dataSetId, int status) {

		return getPersistence().filterCountByDataSetId_G_U_S(
			groupId, userId, dataSetId, status);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet(
		long dataCollectionId, long dataSetId) {

		return getPersistence().findByCollectionSet(
			dataCollectionId, dataSetId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet(
		long dataCollectionId, long dataSetId, int start, int end) {

		return getPersistence().findByCollectionSet(
			dataCollectionId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet(
		long dataCollectionId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet(
			dataCollectionId, dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet(
		long dataCollectionId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet(
			dataCollectionId, dataSetId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_First(
			long dataCollectionId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_First(
			dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_First(
		long dataCollectionId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_First(
			dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_Last(
			long dataCollectionId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_Last(
			dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_Last(
		long dataCollectionId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_Last(
			dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 */
	public static void removeByCollectionSet(
		long dataCollectionId, long dataSetId) {

		getPersistence().removeByCollectionSet(dataCollectionId, dataSetId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet(
		long dataCollectionId, long dataSetId) {

		return getPersistence().countByCollectionSet(
			dataCollectionId, dataSetId);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_S(
		long dataCollectionId, long dataSetId, int status) {

		return getPersistence().findByCollectionSet_S(
			dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_S(
		long dataCollectionId, long dataSetId, int status, int start, int end) {

		return getPersistence().findByCollectionSet_S(
			dataCollectionId, dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_S(
		long dataCollectionId, long dataSetId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_S(
			dataCollectionId, dataSetId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_S(
		long dataCollectionId, long dataSetId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_S(
			dataCollectionId, dataSetId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_S_First(
			long dataCollectionId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_S_First(
			dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_S_First(
		long dataCollectionId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_S_First(
			dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_S_Last(
			long dataCollectionId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_S_Last(
			dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_S_Last(
		long dataCollectionId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_S_Last(
			dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 */
	public static void removeByCollectionSet_S(
		long dataCollectionId, long dataSetId, int status) {

		getPersistence().removeByCollectionSet_S(
			dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_S(
		long dataCollectionId, long dataSetId, int status) {

		return getPersistence().countByCollectionSet_S(
			dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId) {

		return getPersistence().findByCollectionSet_G(
			groupId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId, int start,
		int end) {

		return getPersistence().findByCollectionSet_G(
			groupId, dataCollectionId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_G(
			groupId, dataCollectionId, dataSetId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_G(
			groupId, dataCollectionId, dataSetId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_First(
			long groupId, long dataCollectionId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_First(
			groupId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_First(
		long groupId, long dataCollectionId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_First(
			groupId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_Last(
			long groupId, long dataCollectionId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_Last(
			groupId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_Last(
		long groupId, long dataCollectionId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_Last(
			groupId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_G_PrevAndNext(
			long structuredDataId, long groupId, long dataCollectionId,
			long dataSetId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, dataSetId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId) {

		return getPersistence().filterFindByCollectionSet_G(
			groupId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId, int start,
		int end) {

		return getPersistence().filterFindByCollectionSet_G(
			groupId, dataCollectionId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSet_G(
			groupId, dataCollectionId, dataSetId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByCollectionSet_G_PrevAndNext(
			long structuredDataId, long groupId, long dataCollectionId,
			long dataSetId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSet_G_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, dataSetId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 */
	public static void removeByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId) {

		getPersistence().removeByCollectionSet_G(
			groupId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId) {

		return getPersistence().countByCollectionSet_G(
			groupId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId) {

		return getPersistence().filterCountByCollectionSet_G(
			groupId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_S(
		long groupId, long dataCollectionId, long dataSetId, int status) {

		return getPersistence().findByCollectionSet_G_S(
			groupId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_S(
		long groupId, long dataCollectionId, long dataSetId, int status,
		int start, int end) {

		return getPersistence().findByCollectionSet_G_S(
			groupId, dataCollectionId, dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_S(
		long groupId, long dataCollectionId, long dataSetId, int status,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_G_S(
			groupId, dataCollectionId, dataSetId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_S(
		long groupId, long dataCollectionId, long dataSetId, int status,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_G_S(
			groupId, dataCollectionId, dataSetId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_S_First(
			long groupId, long dataCollectionId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_S_First(
			groupId, dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_S_First(
		long groupId, long dataCollectionId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_S_First(
			groupId, dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_S_Last(
			long groupId, long dataCollectionId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_S_Last(
			groupId, dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_S_Last(
		long groupId, long dataCollectionId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_S_Last(
			groupId, dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_G_S_PrevAndNext(
			long structuredDataId, long groupId, long dataCollectionId,
			long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_S_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, dataSetId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_S(
		long groupId, long dataCollectionId, long dataSetId, int status) {

		return getPersistence().filterFindByCollectionSet_G_S(
			groupId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_S(
		long groupId, long dataCollectionId, long dataSetId, int status,
		int start, int end) {

		return getPersistence().filterFindByCollectionSet_G_S(
			groupId, dataCollectionId, dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_S(
		long groupId, long dataCollectionId, long dataSetId, int status,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSet_G_S(
			groupId, dataCollectionId, dataSetId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByCollectionSet_G_S_PrevAndNext(
			long structuredDataId, long groupId, long dataCollectionId,
			long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSet_G_S_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, dataSetId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 */
	public static void removeByCollectionSet_G_S(
		long groupId, long dataCollectionId, long dataSetId, int status) {

		getPersistence().removeByCollectionSet_G_S(
			groupId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_G_S(
		long groupId, long dataCollectionId, long dataSetId, int status) {

		return getPersistence().countByCollectionSet_G_S(
			groupId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSet_G_S(
		long groupId, long dataCollectionId, long dataSetId, int status) {

		return getPersistence().filterCountByCollectionSet_G_S(
			groupId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U(
		long userId, long dataCollectionId, long dataSetId) {

		return getPersistence().findByCollectionSet_U(
			userId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U(
		long userId, long dataCollectionId, long dataSetId, int start,
		int end) {

		return getPersistence().findByCollectionSet_U(
			userId, dataCollectionId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U(
		long userId, long dataCollectionId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_U(
			userId, dataCollectionId, dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U(
		long userId, long dataCollectionId, long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_U(
			userId, dataCollectionId, dataSetId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_U_First(
			long userId, long dataCollectionId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_First(
			userId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_U_First(
		long userId, long dataCollectionId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_U_First(
			userId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_U_Last(
			long userId, long dataCollectionId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_Last(
			userId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_U_Last(
		long userId, long dataCollectionId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_U_Last(
			userId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_U_PrevAndNext(
			long structuredDataId, long userId, long dataCollectionId,
			long dataSetId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_PrevAndNext(
			structuredDataId, userId, dataCollectionId, dataSetId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 */
	public static void removeByCollectionSet_U(
		long userId, long dataCollectionId, long dataSetId) {

		getPersistence().removeByCollectionSet_U(
			userId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_U(
		long userId, long dataCollectionId, long dataSetId) {

		return getPersistence().countByCollectionSet_U(
			userId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U_S(
		long userId, long dataCollectionId, long dataSetId, int status) {

		return getPersistence().findByCollectionSet_U_S(
			userId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U_S(
		long userId, long dataCollectionId, long dataSetId, int status,
		int start, int end) {

		return getPersistence().findByCollectionSet_U_S(
			userId, dataCollectionId, dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U_S(
		long userId, long dataCollectionId, long dataSetId, int status,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_U_S(
			userId, dataCollectionId, dataSetId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U_S(
		long userId, long dataCollectionId, long dataSetId, int status,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_U_S(
			userId, dataCollectionId, dataSetId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_U_S_First(
			long userId, long dataCollectionId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_S_First(
			userId, dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_U_S_First(
		long userId, long dataCollectionId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_U_S_First(
			userId, dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_U_S_Last(
			long userId, long dataCollectionId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_S_Last(
			userId, dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_U_S_Last(
		long userId, long dataCollectionId, long dataSetId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_U_S_Last(
			userId, dataCollectionId, dataSetId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_U_S_PrevAndNext(
			long structuredDataId, long userId, long dataCollectionId,
			long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_S_PrevAndNext(
			structuredDataId, userId, dataCollectionId, dataSetId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 */
	public static void removeByCollectionSet_U_S(
		long userId, long dataCollectionId, long dataSetId, int status) {

		getPersistence().removeByCollectionSet_U_S(
			userId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_U_S(
		long userId, long dataCollectionId, long dataSetId, int status) {

		return getPersistence().countByCollectionSet_U_S(
			userId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId) {

		return getPersistence().findByCollectionSet_G_U(
			groupId, userId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int start, int end) {

		return getPersistence().findByCollectionSet_G_U(
			groupId, userId, dataCollectionId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_G_U(
			groupId, userId, dataCollectionId, dataSetId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_G_U(
			groupId, userId, dataCollectionId, dataSetId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_U_First(
			long groupId, long userId, long dataCollectionId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_First(
			groupId, userId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_U_First(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_U_First(
			groupId, userId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_U_Last(
			long groupId, long userId, long dataCollectionId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_Last(
			groupId, userId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_U_Last(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_U_Last(
			groupId, userId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_G_U_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			long dataCollectionId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId, dataSetId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId) {

		return getPersistence().filterFindByCollectionSet_G_U(
			groupId, userId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int start, int end) {

		return getPersistence().filterFindByCollectionSet_G_U(
			groupId, userId, dataCollectionId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSet_G_U(
			groupId, userId, dataCollectionId, dataSetId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByCollectionSet_G_U_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			long dataCollectionId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSet_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId, dataSetId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 */
	public static void removeByCollectionSet_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId) {

		getPersistence().removeByCollectionSet_G_U(
			groupId, userId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId) {

		return getPersistence().countByCollectionSet_G_U(
			groupId, userId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSet_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId) {

		return getPersistence().filterCountByCollectionSet_G_U(
			groupId, userId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status) {

		return getPersistence().findByCollectionSet_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status, int start, int end) {

		return getPersistence().findByCollectionSet_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_U_S_First(
			long groupId, long userId, long dataCollectionId, long dataSetId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_S_First(
			groupId, userId, dataCollectionId, dataSetId, status,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_U_S_First(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_U_S_First(
			groupId, userId, dataCollectionId, dataSetId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_U_S_Last(
			long groupId, long userId, long dataCollectionId, long dataSetId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_S_Last(
			groupId, userId, dataCollectionId, dataSetId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_U_S_Last(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_U_S_Last(
			groupId, userId, dataCollectionId, dataSetId, status,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_G_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			long dataCollectionId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId, dataSetId,
			status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status) {

		return getPersistence().filterFindByCollectionSet_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status, int start, int end) {

		return getPersistence().filterFindByCollectionSet_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSet_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByCollectionSet_G_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			long dataCollectionId, long dataSetId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSet_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId, dataSetId,
			status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 */
	public static void removeByCollectionSet_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status) {

		getPersistence().removeByCollectionSet_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status) {

		return getPersistence().countByCollectionSet_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSet_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		int status) {

		return getPersistence().filterCountByCollectionSet_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, status);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType(
		long dataSetId, long dataTypeId) {

		return getPersistence().findBySetType(dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType(
		long dataSetId, long dataTypeId, int start, int end) {

		return getPersistence().findBySetType(
			dataSetId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType(
		long dataSetId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType(
			dataSetId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType(
		long dataSetId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType(
			dataSetId, dataTypeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_First(
			long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_First(
			dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_First(
		long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_First(
			dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_Last(
			long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_Last(
			dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_Last(
		long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_Last(
			dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeBySetType(long dataSetId, long dataTypeId) {
		getPersistence().removeBySetType(dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countBySetType(long dataSetId, long dataTypeId) {
		return getPersistence().countBySetType(dataSetId, dataTypeId);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_S(
		long dataSetId, long dataTypeId, int status) {

		return getPersistence().findBySetType_S(dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_S(
		long dataSetId, long dataTypeId, int status, int start, int end) {

		return getPersistence().findBySetType_S(
			dataSetId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_S(
		long dataSetId, long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_S(
			dataSetId, dataTypeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_S(
		long dataSetId, long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_S(
			dataSetId, dataTypeId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_S_First(
			long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_S_First(
			dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_S_First(
		long dataSetId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_S_First(
			dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_S_Last(
			long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_S_Last(
			dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_S_Last(
		long dataSetId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_S_Last(
			dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_S_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_S_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeBySetType_S(
		long dataSetId, long dataTypeId, int status) {

		getPersistence().removeBySetType_S(dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_S(
		long dataSetId, long dataTypeId, int status) {

		return getPersistence().countBySetType_S(dataSetId, dataTypeId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_G(
		long groupId, long dataSetId, long dataTypeId) {

		return getPersistence().findBySetType_G(groupId, dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G(
		long groupId, long dataSetId, long dataTypeId, int start, int end) {

		return getPersistence().findBySetType_G(
			groupId, dataSetId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G(
		long groupId, long dataSetId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_G(
			groupId, dataSetId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G(
		long groupId, long dataSetId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_G(
			groupId, dataSetId, dataTypeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_First(
			long groupId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_First(
			groupId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_First(
		long groupId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_First(
			groupId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_Last(
			long groupId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_Last(
			groupId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_Last(
		long groupId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_Last(
			groupId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_G_PrevAndNext(
			long structuredDataId, long groupId, long dataSetId,
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_PrevAndNext(
			structuredDataId, groupId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G(
		long groupId, long dataSetId, long dataTypeId) {

		return getPersistence().filterFindBySetType_G(
			groupId, dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G(
		long groupId, long dataSetId, long dataTypeId, int start, int end) {

		return getPersistence().filterFindBySetType_G(
			groupId, dataSetId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G(
		long groupId, long dataSetId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindBySetType_G(
			groupId, dataSetId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindBySetType_G_PrevAndNext(
			long structuredDataId, long groupId, long dataSetId,
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindBySetType_G_PrevAndNext(
			structuredDataId, groupId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeBySetType_G(
		long groupId, long dataSetId, long dataTypeId) {

		getPersistence().removeBySetType_G(groupId, dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_G(
		long groupId, long dataSetId, long dataTypeId) {

		return getPersistence().countBySetType_G(
			groupId, dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountBySetType_G(
		long groupId, long dataSetId, long dataTypeId) {

		return getPersistence().filterCountBySetType_G(
			groupId, dataSetId, dataTypeId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_S(
		long groupId, long dataSetId, long dataTypeId, int status) {

		return getPersistence().findBySetType_G_S(
			groupId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_S(
		long groupId, long dataSetId, long dataTypeId, int status, int start,
		int end) {

		return getPersistence().findBySetType_G_S(
			groupId, dataSetId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_S(
		long groupId, long dataSetId, long dataTypeId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_G_S(
			groupId, dataSetId, dataTypeId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_S(
		long groupId, long dataSetId, long dataTypeId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_G_S(
			groupId, dataSetId, dataTypeId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_S_First(
			long groupId, long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_S_First(
			groupId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_S_First(
		long groupId, long dataSetId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_S_First(
			groupId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_S_Last(
			long groupId, long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_S_Last(
			groupId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_S_Last(
		long groupId, long dataSetId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_S_Last(
			groupId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_G_S_PrevAndNext(
			long structuredDataId, long groupId, long dataSetId,
			long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_S_PrevAndNext(
			structuredDataId, groupId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_S(
		long groupId, long dataSetId, long dataTypeId, int status) {

		return getPersistence().filterFindBySetType_G_S(
			groupId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_S(
		long groupId, long dataSetId, long dataTypeId, int status, int start,
		int end) {

		return getPersistence().filterFindBySetType_G_S(
			groupId, dataSetId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_S(
		long groupId, long dataSetId, long dataTypeId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindBySetType_G_S(
			groupId, dataSetId, dataTypeId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindBySetType_G_S_PrevAndNext(
			long structuredDataId, long groupId, long dataSetId,
			long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindBySetType_G_S_PrevAndNext(
			structuredDataId, groupId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeBySetType_G_S(
		long groupId, long dataSetId, long dataTypeId, int status) {

		getPersistence().removeBySetType_G_S(
			groupId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_G_S(
		long groupId, long dataSetId, long dataTypeId, int status) {

		return getPersistence().countBySetType_G_S(
			groupId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountBySetType_G_S(
		long groupId, long dataSetId, long dataTypeId, int status) {

		return getPersistence().filterCountBySetType_G_S(
			groupId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_U(
		long userId, long dataSetId, long dataTypeId) {

		return getPersistence().findBySetType_U(userId, dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U(
		long userId, long dataSetId, long dataTypeId, int start, int end) {

		return getPersistence().findBySetType_U(
			userId, dataSetId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U(
		long userId, long dataSetId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_U(
			userId, dataSetId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U(
		long userId, long dataSetId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_U(
			userId, dataSetId, dataTypeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_U_First(
			long userId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_First(
			userId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_U_First(
		long userId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_U_First(
			userId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_U_Last(
			long userId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_Last(
			userId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_U_Last(
		long userId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_U_Last(
			userId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_U_PrevAndNext(
			long structuredDataId, long userId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_PrevAndNext(
			structuredDataId, userId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeBySetType_U(
		long userId, long dataSetId, long dataTypeId) {

		getPersistence().removeBySetType_U(userId, dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_U(
		long userId, long dataSetId, long dataTypeId) {

		return getPersistence().countBySetType_U(userId, dataSetId, dataTypeId);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_U_S(
		long userId, long dataSetId, long dataTypeId, int status) {

		return getPersistence().findBySetType_U_S(
			userId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U_S(
		long userId, long dataSetId, long dataTypeId, int status, int start,
		int end) {

		return getPersistence().findBySetType_U_S(
			userId, dataSetId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U_S(
		long userId, long dataSetId, long dataTypeId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_U_S(
			userId, dataSetId, dataTypeId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U_S(
		long userId, long dataSetId, long dataTypeId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_U_S(
			userId, dataSetId, dataTypeId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_U_S_First(
			long userId, long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_S_First(
			userId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_U_S_First(
		long userId, long dataSetId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_U_S_First(
			userId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_U_S_Last(
			long userId, long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_S_Last(
			userId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_U_S_Last(
		long userId, long dataSetId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_U_S_Last(
			userId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_U_S_PrevAndNext(
			long structuredDataId, long userId, long dataSetId, long dataTypeId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_S_PrevAndNext(
			structuredDataId, userId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeBySetType_U_S(
		long userId, long dataSetId, long dataTypeId, int status) {

		getPersistence().removeBySetType_U_S(
			userId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_U_S(
		long userId, long dataSetId, long dataTypeId, int status) {

		return getPersistence().countBySetType_U_S(
			userId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U(
		long groupId, long userId, long dataSetId, long dataTypeId) {

		return getPersistence().findBySetType_G_U(
			groupId, userId, dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U(
		long groupId, long userId, long dataSetId, long dataTypeId, int start,
		int end) {

		return getPersistence().findBySetType_G_U(
			groupId, userId, dataSetId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U(
		long groupId, long userId, long dataSetId, long dataTypeId, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_G_U(
			groupId, userId, dataSetId, dataTypeId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U(
		long groupId, long userId, long dataSetId, long dataTypeId, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_G_U(
			groupId, userId, dataSetId, dataTypeId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_U_First(
			long groupId, long userId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_First(
			groupId, userId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_U_First(
		long groupId, long userId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_U_First(
			groupId, userId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_U_Last(
			long groupId, long userId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_Last(
			groupId, userId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_U_Last(
		long groupId, long userId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_U_Last(
			groupId, userId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_G_U_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataSetId,
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U(
		long groupId, long userId, long dataSetId, long dataTypeId) {

		return getPersistence().filterFindBySetType_G_U(
			groupId, userId, dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U(
		long groupId, long userId, long dataSetId, long dataTypeId, int start,
		int end) {

		return getPersistence().filterFindBySetType_G_U(
			groupId, userId, dataSetId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U(
		long groupId, long userId, long dataSetId, long dataTypeId, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindBySetType_G_U(
			groupId, userId, dataSetId, dataTypeId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindBySetType_G_U_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataSetId,
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindBySetType_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeBySetType_G_U(
		long groupId, long userId, long dataSetId, long dataTypeId) {

		getPersistence().removeBySetType_G_U(
			groupId, userId, dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_G_U(
		long groupId, long userId, long dataSetId, long dataTypeId) {

		return getPersistence().countBySetType_G_U(
			groupId, userId, dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountBySetType_G_U(
		long groupId, long userId, long dataSetId, long dataTypeId) {

		return getPersistence().filterCountBySetType_G_U(
			groupId, userId, dataSetId, dataTypeId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U_S(
		long groupId, long userId, long dataSetId, long dataTypeId,
		int status) {

		return getPersistence().findBySetType_G_U_S(
			groupId, userId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U_S(
		long groupId, long userId, long dataSetId, long dataTypeId, int status,
		int start, int end) {

		return getPersistence().findBySetType_G_U_S(
			groupId, userId, dataSetId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U_S(
		long groupId, long userId, long dataSetId, long dataTypeId, int status,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_G_U_S(
			groupId, userId, dataSetId, dataTypeId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U_S(
		long groupId, long userId, long dataSetId, long dataTypeId, int status,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_G_U_S(
			groupId, userId, dataSetId, dataTypeId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_U_S_First(
			long groupId, long userId, long dataSetId, long dataTypeId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_S_First(
			groupId, userId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_U_S_First(
		long groupId, long userId, long dataSetId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_U_S_First(
			groupId, userId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_U_S_Last(
			long groupId, long userId, long dataSetId, long dataTypeId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_S_Last(
			groupId, userId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_U_S_Last(
		long groupId, long userId, long dataSetId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_U_S_Last(
			groupId, userId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_G_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataSetId,
			long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U_S(
		long groupId, long userId, long dataSetId, long dataTypeId,
		int status) {

		return getPersistence().filterFindBySetType_G_U_S(
			groupId, userId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U_S(
		long groupId, long userId, long dataSetId, long dataTypeId, int status,
		int start, int end) {

		return getPersistence().filterFindBySetType_G_U_S(
			groupId, userId, dataSetId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U_S(
		long groupId, long userId, long dataSetId, long dataTypeId, int status,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindBySetType_G_U_S(
			groupId, userId, dataSetId, dataTypeId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindBySetType_G_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataSetId,
			long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindBySetType_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeBySetType_G_U_S(
		long groupId, long userId, long dataSetId, long dataTypeId,
		int status) {

		getPersistence().removeBySetType_G_U_S(
			groupId, userId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_G_U_S(
		long groupId, long userId, long dataSetId, long dataTypeId,
		int status) {

		return getPersistence().countBySetType_G_U_S(
			groupId, userId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountBySetType_G_U_S(
		long groupId, long userId, long dataSetId, long dataTypeId,
		int status) {

		return getPersistence().filterCountBySetType_G_U_S(
			groupId, userId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType(
		long dataCollectionId, long dataSetId, long dataTypeId) {

		return getPersistence().findByCollectionSetType(
			dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType(
		long dataCollectionId, long dataSetId, long dataTypeId, int start,
		int end) {

		return getPersistence().findByCollectionSetType(
			dataCollectionId, dataSetId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType(
		long dataCollectionId, long dataSetId, long dataTypeId, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType(
			dataCollectionId, dataSetId, dataTypeId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType(
		long dataCollectionId, long dataSetId, long dataTypeId, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType(
			dataCollectionId, dataSetId, dataTypeId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_First(
			long dataCollectionId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_First(
			dataCollectionId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_First(
		long dataCollectionId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_First(
			dataCollectionId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_Last(
			long dataCollectionId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_Last(
			dataCollectionId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_Last(
		long dataCollectionId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_Last(
			dataCollectionId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeByCollectionSetType(
		long dataCollectionId, long dataSetId, long dataTypeId) {

		getPersistence().removeByCollectionSetType(
			dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType(
		long dataCollectionId, long dataSetId, long dataTypeId) {

		return getPersistence().countByCollectionSetType(
			dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_S(
		long dataCollectionId, long dataSetId, long dataTypeId, int status) {

		return getPersistence().findByCollectionSetType_S(
			dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_S(
		long dataCollectionId, long dataSetId, long dataTypeId, int status,
		int start, int end) {

		return getPersistence().findByCollectionSetType_S(
			dataCollectionId, dataSetId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_S(
		long dataCollectionId, long dataSetId, long dataTypeId, int status,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_S(
			dataCollectionId, dataSetId, dataTypeId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_S(
		long dataCollectionId, long dataSetId, long dataTypeId, int status,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_S(
			dataCollectionId, dataSetId, dataTypeId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_S_First(
			long dataCollectionId, long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_S_First(
			dataCollectionId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_S_First(
		long dataCollectionId, long dataSetId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_S_First(
			dataCollectionId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_S_Last(
			long dataCollectionId, long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_S_Last(
			dataCollectionId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_S_Last(
		long dataCollectionId, long dataSetId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_S_Last(
			dataCollectionId, dataSetId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeByCollectionSetType_S(
		long dataCollectionId, long dataSetId, long dataTypeId, int status) {

		getPersistence().removeByCollectionSetType_S(
			dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_S(
		long dataCollectionId, long dataSetId, long dataTypeId, int status) {

		return getPersistence().countByCollectionSetType_S(
			dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId) {

		return getPersistence().findByCollectionSetType_G(
			groupId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int start, int end) {

		return getPersistence().findByCollectionSetType_G(
			groupId, dataCollectionId, dataSetId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_G(
			groupId, dataCollectionId, dataSetId, dataTypeId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_G(
			groupId, dataCollectionId, dataSetId, dataTypeId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_First(
			long groupId, long dataCollectionId, long dataSetId,
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_First(
			groupId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_First(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_First(
			groupId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_Last(
			long groupId, long dataCollectionId, long dataSetId,
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_Last(
			groupId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_Last(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_Last(
			groupId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_G_PrevAndNext(
			long structuredDataId, long groupId, long dataCollectionId,
			long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId) {

		return getPersistence().filterFindByCollectionSetType_G(
			groupId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int start, int end) {

		return getPersistence().filterFindByCollectionSetType_G(
			groupId, dataCollectionId, dataSetId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSetType_G(
			groupId, dataCollectionId, dataSetId, dataTypeId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByCollectionSetType_G_PrevAndNext(
			long structuredDataId, long groupId, long dataCollectionId,
			long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSetType_G_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeByCollectionSetType_G(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId) {

		getPersistence().removeByCollectionSetType_G(
			groupId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_G(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId) {

		return getPersistence().countByCollectionSetType_G(
			groupId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSetType_G(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId) {

		return getPersistence().filterCountByCollectionSetType_G(
			groupId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_S(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status) {

		return getPersistence().findByCollectionSetType_G_S(
			groupId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_S(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, int start, int end) {

		return getPersistence().findByCollectionSetType_G_S(
			groupId, dataCollectionId, dataSetId, dataTypeId, status, start,
			end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_S(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_G_S(
			groupId, dataCollectionId, dataSetId, dataTypeId, status, start,
			end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_S(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_G_S(
			groupId, dataCollectionId, dataSetId, dataTypeId, status, start,
			end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_S_First(
			long groupId, long dataCollectionId, long dataSetId,
			long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_S_First(
			groupId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_S_First(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_S_First(
			groupId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_S_Last(
			long groupId, long dataCollectionId, long dataSetId,
			long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_S_Last(
			groupId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_S_Last(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_S_Last(
			groupId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_G_S_PrevAndNext(
			long structuredDataId, long groupId, long dataCollectionId,
			long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_S_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, dataSetId, dataTypeId,
			status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_S(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status) {

		return getPersistence().filterFindByCollectionSetType_G_S(
			groupId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_S(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, int start, int end) {

		return getPersistence().filterFindByCollectionSetType_G_S(
			groupId, dataCollectionId, dataSetId, dataTypeId, status, start,
			end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_S(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSetType_G_S(
			groupId, dataCollectionId, dataSetId, dataTypeId, status, start,
			end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[]
			filterFindByCollectionSetType_G_S_PrevAndNext(
				long structuredDataId, long groupId, long dataCollectionId,
				long dataSetId, long dataTypeId, int status,
				OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSetType_G_S_PrevAndNext(
			structuredDataId, groupId, dataCollectionId, dataSetId, dataTypeId,
			status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeByCollectionSetType_G_S(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status) {

		getPersistence().removeByCollectionSetType_G_S(
			groupId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_G_S(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status) {

		return getPersistence().countByCollectionSetType_G_S(
			groupId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSetType_G_S(
		long groupId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status) {

		return getPersistence().filterCountByCollectionSetType_G_S(
			groupId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId) {

		return getPersistence().findByCollectionSetType_U(
			userId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		int start, int end) {

		return getPersistence().findByCollectionSetType_U(
			userId, dataCollectionId, dataSetId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_U(
			userId, dataCollectionId, dataSetId, dataTypeId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_U(
			userId, dataCollectionId, dataSetId, dataTypeId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_U_First(
			long userId, long dataCollectionId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_First(
			userId, dataCollectionId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_U_First(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_U_First(
			userId, dataCollectionId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_U_Last(
			long userId, long dataCollectionId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_Last(
			userId, dataCollectionId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_U_Last(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_U_Last(
			userId, dataCollectionId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_U_PrevAndNext(
			long structuredDataId, long userId, long dataCollectionId,
			long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_PrevAndNext(
			structuredDataId, userId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeByCollectionSetType_U(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId) {

		getPersistence().removeByCollectionSetType_U(
			userId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_U(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId) {

		return getPersistence().countByCollectionSetType_U(
			userId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U_S(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status) {

		return getPersistence().findByCollectionSetType_U_S(
			userId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U_S(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, int start, int end) {

		return getPersistence().findByCollectionSetType_U_S(
			userId, dataCollectionId, dataSetId, dataTypeId, status, start,
			end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U_S(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_U_S(
			userId, dataCollectionId, dataSetId, dataTypeId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U_S(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_U_S(
			userId, dataCollectionId, dataSetId, dataTypeId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_U_S_First(
			long userId, long dataCollectionId, long dataSetId, long dataTypeId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_S_First(
			userId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_U_S_First(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_U_S_First(
			userId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_U_S_Last(
			long userId, long dataCollectionId, long dataSetId, long dataTypeId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_S_Last(
			userId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_U_S_Last(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_U_S_Last(
			userId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_U_S_PrevAndNext(
			long structuredDataId, long userId, long dataCollectionId,
			long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_S_PrevAndNext(
			structuredDataId, userId, dataCollectionId, dataSetId, dataTypeId,
			status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeByCollectionSetType_U_S(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status) {

		getPersistence().removeByCollectionSetType_U_S(
			userId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_U_S(
		long userId, long dataCollectionId, long dataSetId, long dataTypeId,
		int status) {

		return getPersistence().countByCollectionSetType_U_S(
			userId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId) {

		return getPersistence().findByCollectionSetType_G_U(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int start, int end) {

		return getPersistence().findByCollectionSetType_G_U(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, start,
			end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_G_U(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, start,
			end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_G_U(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, start,
			end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_U_First(
			long groupId, long userId, long dataCollectionId, long dataSetId,
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_First(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_U_First(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_U_First(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_U_Last(
			long groupId, long userId, long dataCollectionId, long dataSetId,
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_Last(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_U_Last(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_U_Last(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_G_U_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			long dataCollectionId, long dataSetId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId, dataSetId,
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId) {

		return getPersistence().filterFindByCollectionSetType_G_U(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int start, int end) {

		return getPersistence().filterFindByCollectionSetType_G_U(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, start,
			end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSetType_G_U(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, start,
			end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[]
			filterFindByCollectionSetType_G_U_PrevAndNext(
				long structuredDataId, long groupId, long userId,
				long dataCollectionId, long dataSetId, long dataTypeId,
				OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSetType_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId, dataSetId,
			dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeByCollectionSetType_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId) {

		getPersistence().removeByCollectionSetType_G_U(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId) {

		return getPersistence().countByCollectionSetType_G_U(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSetType_G_U(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId) {

		return getPersistence().filterCountByCollectionSetType_G_U(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status) {

		return getPersistence().findByCollectionSetType_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status, int start, int end) {

		return getPersistence().findByCollectionSetType_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status,
			start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status,
			start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status,
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_U_S_First(
			long groupId, long userId, long dataCollectionId, long dataSetId,
			long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_S_First(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_U_S_First(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_U_S_First(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_U_S_Last(
			long groupId, long userId, long dataCollectionId, long dataSetId,
			long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_S_Last(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_U_S_Last(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_U_S_Last(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_G_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			long dataCollectionId, long dataSetId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId, dataSetId,
			dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status) {

		return getPersistence().filterFindByCollectionSetType_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status, int start, int end) {

		return getPersistence().filterFindByCollectionSetType_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status,
			start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSetType_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status,
			start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[]
			filterFindByCollectionSetType_G_U_S_PrevAndNext(
				long structuredDataId, long groupId, long userId,
				long dataCollectionId, long dataSetId, long dataTypeId,
				int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSetType_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataCollectionId, dataSetId,
			dataTypeId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeByCollectionSetType_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status) {

		getPersistence().removeByCollectionSetType_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status) {

		return getPersistence().countByCollectionSetType_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSetType_G_U_S(
		long groupId, long userId, long dataCollectionId, long dataSetId,
		long dataTypeId, int status) {

		return getPersistence().filterCountByCollectionSetType_G_U_S(
			groupId, userId, dataCollectionId, dataSetId, dataTypeId, status);
	}

	/**
	 * Returns all the structured datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId(long dataTypeId) {
		return getPersistence().findByDataTypeId(dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return getPersistence().findByDataTypeId(dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_First(
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_First(
		long dataTypeId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_Last(
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_Last(
		long dataTypeId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_PrevAndNext(
			long structuredDataId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_PrevAndNext(
			structuredDataId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public static void removeByDataTypeId(long dataTypeId) {
		getPersistence().removeByDataTypeId(dataTypeId);
	}

	/**
	 * Returns the number of structured datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId(long dataTypeId) {
		return getPersistence().countByDataTypeId(dataTypeId);
	}

	/**
	 * Returns all the structured datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_S(
		long dataTypeId, int status) {

		return getPersistence().findByDataTypeId_S(dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end) {

		return getPersistence().findByDataTypeId_S(
			dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_S(
			dataTypeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_S(
			dataTypeId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_S_First(
			long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_S_First(
			dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_S_First(
		long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_S_First(
			dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_S_Last(
			long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_S_Last(
			dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_S_Last(
		long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_S_Last(
			dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_S_PrevAndNext(
			long structuredDataId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_S_PrevAndNext(
			structuredDataId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeByDataTypeId_S(long dataTypeId, int status) {
		getPersistence().removeByDataTypeId_S(dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_S(long dataTypeId, int status) {
		return getPersistence().countByDataTypeId_S(dataTypeId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G(
		long groupId, long dataTypeId) {

		return getPersistence().findByDataTypeId_G(groupId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G(
		long groupId, long dataTypeId, int start, int end) {

		return getPersistence().findByDataTypeId_G(
			groupId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G(
		long groupId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_G(
			groupId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G(
		long groupId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G(
			groupId, dataTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_First(
			long groupId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_First(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_First(
		long groupId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_First(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_Last(
			long groupId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_Last(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_Last(
		long groupId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_Last(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_G_PrevAndNext(
			long structuredDataId, long groupId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_PrevAndNext(
			structuredDataId, groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G(
		long groupId, long dataTypeId) {

		return getPersistence().filterFindByDataTypeId_G(groupId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G(
		long groupId, long dataTypeId, int start, int end) {

		return getPersistence().filterFindByDataTypeId_G(
			groupId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G(
		long groupId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataTypeId_G(
			groupId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataTypeId_G_PrevAndNext(
			long structuredDataId, long groupId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataTypeId_G_PrevAndNext(
			structuredDataId, groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeByDataTypeId_G(long groupId, long dataTypeId) {
		getPersistence().removeByDataTypeId_G(groupId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_G(long groupId, long dataTypeId) {
		return getPersistence().countByDataTypeId_G(groupId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataTypeId_G(long groupId, long dataTypeId) {
		return getPersistence().filterCountByDataTypeId_G(groupId, dataTypeId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_S(
		long groupId, long dataTypeId, int status) {

		return getPersistence().findByDataTypeId_G_S(
			groupId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_S(
		long groupId, long dataTypeId, int status, int start, int end) {

		return getPersistence().findByDataTypeId_G_S(
			groupId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_S(
		long groupId, long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_G_S(
			groupId, dataTypeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_S(
		long groupId, long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G_S(
			groupId, dataTypeId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_S_First(
			long groupId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_S_First(
			groupId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_S_First(
		long groupId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_S_First(
			groupId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_S_Last(
			long groupId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_S_Last(
			groupId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_S_Last(
		long groupId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_S_Last(
			groupId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_G_S_PrevAndNext(
			long structuredDataId, long groupId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_S_PrevAndNext(
			structuredDataId, groupId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_S(
		long groupId, long dataTypeId, int status) {

		return getPersistence().filterFindByDataTypeId_G_S(
			groupId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_S(
		long groupId, long dataTypeId, int status, int start, int end) {

		return getPersistence().filterFindByDataTypeId_G_S(
			groupId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_S(
		long groupId, long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataTypeId_G_S(
			groupId, dataTypeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataTypeId_G_S_PrevAndNext(
			long structuredDataId, long groupId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataTypeId_G_S_PrevAndNext(
			structuredDataId, groupId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeByDataTypeId_G_S(
		long groupId, long dataTypeId, int status) {

		getPersistence().removeByDataTypeId_G_S(groupId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_G_S(
		long groupId, long dataTypeId, int status) {

		return getPersistence().countByDataTypeId_G_S(
			groupId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataTypeId_G_S(
		long groupId, long dataTypeId, int status) {

		return getPersistence().filterCountByDataTypeId_G_S(
			groupId, dataTypeId, status);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U(
		long userId, long dataTypeId) {

		return getPersistence().findByDataTypeId_U(userId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U(
		long userId, long dataTypeId, int start, int end) {

		return getPersistence().findByDataTypeId_U(
			userId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U(
		long userId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_U(
			userId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U(
		long userId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_U(
			userId, dataTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_U_First(
			long userId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_First(
			userId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_U_First(
		long userId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_First(
			userId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_U_Last(
			long userId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_Last(
			userId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_U_Last(
		long userId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_Last(
			userId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_U_PrevAndNext(
			long structuredDataId, long userId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_PrevAndNext(
			structuredDataId, userId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeByDataTypeId_U(long userId, long dataTypeId) {
		getPersistence().removeByDataTypeId_U(userId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_U(long userId, long dataTypeId) {
		return getPersistence().countByDataTypeId_U(userId, dataTypeId);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U_S(
		long userId, long dataTypeId, int status) {

		return getPersistence().findByDataTypeId_U_S(
			userId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U_S(
		long userId, long dataTypeId, int status, int start, int end) {

		return getPersistence().findByDataTypeId_U_S(
			userId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U_S(
		long userId, long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_U_S(
			userId, dataTypeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U_S(
		long userId, long dataTypeId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_U_S(
			userId, dataTypeId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_U_S_First(
			long userId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_S_First(
			userId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_U_S_First(
		long userId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_S_First(
			userId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_U_S_Last(
			long userId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_S_Last(
			userId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_U_S_Last(
		long userId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_S_Last(
			userId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_U_S_PrevAndNext(
			long structuredDataId, long userId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_S_PrevAndNext(
			structuredDataId, userId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeByDataTypeId_U_S(
		long userId, long dataTypeId, int status) {

		getPersistence().removeByDataTypeId_U_S(userId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_U_S(
		long userId, long dataTypeId, int status) {

		return getPersistence().countByDataTypeId_U_S(
			userId, dataTypeId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U(
		long groupId, long userId, long dataTypeId) {

		return getPersistence().findByDataTypeId_G_U(
			groupId, userId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U(
		long groupId, long userId, long dataTypeId, int start, int end) {

		return getPersistence().findByDataTypeId_G_U(
			groupId, userId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U(
		long groupId, long userId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_G_U(
			groupId, userId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U(
		long groupId, long userId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G_U(
			groupId, userId, dataTypeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_U_First(
			long groupId, long userId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_First(
			groupId, userId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_U_First(
		long groupId, long userId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_First(
			groupId, userId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_U_Last(
			long groupId, long userId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_Last(
			groupId, userId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_U_Last(
		long groupId, long userId, long dataTypeId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_Last(
			groupId, userId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_G_U_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U(
		long groupId, long userId, long dataTypeId) {

		return getPersistence().filterFindByDataTypeId_G_U(
			groupId, userId, dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U(
		long groupId, long userId, long dataTypeId, int start, int end) {

		return getPersistence().filterFindByDataTypeId_G_U(
			groupId, userId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U(
		long groupId, long userId, long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataTypeId_G_U(
			groupId, userId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataTypeId_G_U_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataTypeId_G_U_PrevAndNext(
			structuredDataId, groupId, userId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeByDataTypeId_G_U(
		long groupId, long userId, long dataTypeId) {

		getPersistence().removeByDataTypeId_G_U(groupId, userId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_G_U(
		long groupId, long userId, long dataTypeId) {

		return getPersistence().countByDataTypeId_G_U(
			groupId, userId, dataTypeId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataTypeId_G_U(
		long groupId, long userId, long dataTypeId) {

		return getPersistence().filterCountByDataTypeId_G_U(
			groupId, userId, dataTypeId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U_S(
		long groupId, long userId, long dataTypeId, int status) {

		return getPersistence().findByDataTypeId_G_U_S(
			groupId, userId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U_S(
		long groupId, long userId, long dataTypeId, int status, int start,
		int end) {

		return getPersistence().findByDataTypeId_G_U_S(
			groupId, userId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U_S(
		long groupId, long userId, long dataTypeId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_G_U_S(
			groupId, userId, dataTypeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U_S(
		long groupId, long userId, long dataTypeId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G_U_S(
			groupId, userId, dataTypeId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_U_S_First(
			long groupId, long userId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_S_First(
			groupId, userId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_U_S_First(
		long groupId, long userId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_S_First(
			groupId, userId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_U_S_Last(
			long groupId, long userId, long dataTypeId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_S_Last(
			groupId, userId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_U_S_Last(
		long groupId, long userId, long dataTypeId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_S_Last(
			groupId, userId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_G_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataTypeId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U_S(
		long groupId, long userId, long dataTypeId, int status) {

		return getPersistence().filterFindByDataTypeId_G_U_S(
			groupId, userId, dataTypeId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U_S(
		long groupId, long userId, long dataTypeId, int status, int start,
		int end) {

		return getPersistence().filterFindByDataTypeId_G_U_S(
			groupId, userId, dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U_S(
		long groupId, long userId, long dataTypeId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataTypeId_G_U_S(
			groupId, userId, dataTypeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataTypeId_G_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, long dataTypeId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataTypeId_G_U_S_PrevAndNext(
			structuredDataId, groupId, userId, dataTypeId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeByDataTypeId_G_U_S(
		long groupId, long userId, long dataTypeId, int status) {

		getPersistence().removeByDataTypeId_G_U_S(
			groupId, userId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_G_U_S(
		long groupId, long userId, long dataTypeId, int status) {

		return getPersistence().countByDataTypeId_G_U_S(
			groupId, userId, dataTypeId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and dataTypeId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataTypeId_G_U_S(
		long groupId, long userId, long dataTypeId, int status) {

		return getPersistence().filterCountByDataTypeId_G_U_S(
			groupId, userId, dataTypeId, status);
	}

	/**
	 * Caches the structured data in the entity cache if it is enabled.
	 *
	 * @param structuredData the structured data
	 */
	public static void cacheResult(StructuredData structuredData) {
		getPersistence().cacheResult(structuredData);
	}

	/**
	 * Caches the structured datas in the entity cache if it is enabled.
	 *
	 * @param structuredDatas the structured datas
	 */
	public static void cacheResult(List<StructuredData> structuredDatas) {
		getPersistence().cacheResult(structuredDatas);
	}

	/**
	 * Creates a new structured data with the primary key. Does not add the structured data to the database.
	 *
	 * @param structuredDataId the primary key for the new structured data
	 * @return the new structured data
	 */
	public static StructuredData create(long structuredDataId) {
		return getPersistence().create(structuredDataId);
	}

	/**
	 * Removes the structured data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data that was removed
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData remove(long structuredDataId)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().remove(structuredDataId);
	}

	public static StructuredData updateImpl(StructuredData structuredData) {
		return getPersistence().updateImpl(structuredData);
	}

	/**
	 * Returns the structured data with the primary key or throws a <code>NoSuchStructuredDataException</code> if it could not be found.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData findByPrimaryKey(long structuredDataId)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByPrimaryKey(structuredDataId);
	}

	/**
	 * Returns the structured data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data, or <code>null</code> if a structured data with the primary key could not be found
	 */
	public static StructuredData fetchByPrimaryKey(long structuredDataId) {
		return getPersistence().fetchByPrimaryKey(structuredDataId);
	}

	/**
	 * Returns all the structured datas.
	 *
	 * @return the structured datas
	 */
	public static List<StructuredData> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the structured datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of structured datas
	 */
	public static List<StructuredData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of structured datas
	 */
	public static List<StructuredData> findAll(
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of structured datas
	 */
	public static List<StructuredData> findAll(
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the structured datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of structured datas.
	 *
	 * @return the number of structured datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StructuredDataPersistence getPersistence() {
		return _persistence;
	}

	private static volatile StructuredDataPersistence _persistence;

}