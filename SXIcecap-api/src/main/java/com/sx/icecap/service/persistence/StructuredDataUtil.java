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
	 * Returns all the structured datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
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
	public static List<StructuredData> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
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
	public static List<StructuredData> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByG_S(
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
	public static List<StructuredData> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
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
	public static StructuredData findByG_S_First(
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_S_First(
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
	public static StructuredData fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_S_First(
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
	public static StructuredData findByG_S_Last(
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_S_Last(
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
	public static StructuredData fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
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
	public static StructuredData[] findByG_S_PrevAndNext(
			long structuredDataId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_S_PrevAndNext(
			structuredDataId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_S(
		long groupId, int status) {

		return getPersistence().filterFindByG_S(groupId, status);
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
	public static List<StructuredData> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
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
	public static List<StructuredData> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByG_S(
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
	public static StructuredData[] filterFindByG_S_PrevAndNext(
			long structuredDataId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			structuredDataId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
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
	public static List<StructuredData> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
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
	public static List<StructuredData> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByU_S(
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
	public static List<StructuredData> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
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
	public static StructuredData findByU_S_First(
			long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByU_S_First(
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
	public static StructuredData fetchByU_S_First(
		long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByU_S_First(
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
	public static StructuredData findByU_S_Last(
			long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByU_S_Last(
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
	public static StructuredData fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
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
	public static StructuredData[] findByU_S_PrevAndNext(
			long structuredDataId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByU_S_PrevAndNext(
			structuredDataId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
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
	 * Returns all the structured datas where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G(
		long dataCollectionId, long groupId) {

		return getPersistence().findByDataCollectionId_G(
			dataCollectionId, groupId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G(
		long dataCollectionId, long groupId, int start, int end) {

		return getPersistence().findByDataCollectionId_G(
			dataCollectionId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G(
		long dataCollectionId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_G(
			dataCollectionId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G(
		long dataCollectionId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_G(
			dataCollectionId, groupId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_First(
			long dataCollectionId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_First(
			dataCollectionId, groupId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_First(
		long dataCollectionId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_First(
			dataCollectionId, groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_Last(
			long dataCollectionId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_Last(
			dataCollectionId, groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_Last(
		long dataCollectionId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_Last(
			dataCollectionId, groupId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_G_PrevAndNext(
			long structuredDataId, long dataCollectionId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_PrevAndNext(
			structuredDataId, dataCollectionId, groupId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G(
		long dataCollectionId, long groupId) {

		return getPersistence().filterFindByDataCollectionId_G(
			dataCollectionId, groupId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G(
		long dataCollectionId, long groupId, int start, int end) {

		return getPersistence().filterFindByDataCollectionId_G(
			dataCollectionId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G(
		long dataCollectionId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataCollectionId_G(
			dataCollectionId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataCollectionId_G_PrevAndNext(
			long structuredDataId, long dataCollectionId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataCollectionId_G_PrevAndNext(
			structuredDataId, dataCollectionId, groupId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and groupId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 */
	public static void removeByDataCollectionId_G(
		long dataCollectionId, long groupId) {

		getPersistence().removeByDataCollectionId_G(dataCollectionId, groupId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_G(
		long dataCollectionId, long groupId) {

		return getPersistence().countByDataCollectionId_G(
			dataCollectionId, groupId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataCollectionId_G(
		long dataCollectionId, long groupId) {

		return getPersistence().filterCountByDataCollectionId_G(
			dataCollectionId, groupId);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U(
		long dataCollectionId, long userId) {

		return getPersistence().findByDataCollectionId_U(
			dataCollectionId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U(
		long dataCollectionId, long userId, int start, int end) {

		return getPersistence().findByDataCollectionId_U(
			dataCollectionId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U(
		long dataCollectionId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_U(
			dataCollectionId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U(
		long dataCollectionId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_U(
			dataCollectionId, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_U_First(
			long dataCollectionId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_First(
			dataCollectionId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_U_First(
		long dataCollectionId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_U_First(
			dataCollectionId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_U_Last(
			long dataCollectionId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_Last(
			dataCollectionId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_U_Last(
		long dataCollectionId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_U_Last(
			dataCollectionId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_U_PrevAndNext(
			long structuredDataId, long dataCollectionId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_PrevAndNext(
			structuredDataId, dataCollectionId, userId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 */
	public static void removeByDataCollectionId_U(
		long dataCollectionId, long userId) {

		getPersistence().removeByDataCollectionId_U(dataCollectionId, userId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_U(
		long dataCollectionId, long userId) {

		return getPersistence().countByDataCollectionId_U(
			dataCollectionId, userId);
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
	 * Returns all the structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U(
		long dataCollectionId, long groupId, long userId) {

		return getPersistence().findByDataCollectionId_G_U(
			dataCollectionId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U(
		long dataCollectionId, long groupId, long userId, int start, int end) {

		return getPersistence().findByDataCollectionId_G_U(
			dataCollectionId, groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U(
		long dataCollectionId, long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_G_U(
			dataCollectionId, groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U(
		long dataCollectionId, long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_G_U(
			dataCollectionId, groupId, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_U_First(
			long dataCollectionId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_First(
			dataCollectionId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_U_First(
		long dataCollectionId, long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_U_First(
			dataCollectionId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_U_Last(
			long dataCollectionId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_Last(
			dataCollectionId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_U_Last(
		long dataCollectionId, long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_U_Last(
			dataCollectionId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_G_U_PrevAndNext(
			long structuredDataId, long dataCollectionId, long groupId,
			long userId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_PrevAndNext(
			structuredDataId, dataCollectionId, groupId, userId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U(
		long dataCollectionId, long groupId, long userId) {

		return getPersistence().filterFindByDataCollectionId_G_U(
			dataCollectionId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U(
		long dataCollectionId, long groupId, long userId, int start, int end) {

		return getPersistence().filterFindByDataCollectionId_G_U(
			dataCollectionId, groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U(
		long dataCollectionId, long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataCollectionId_G_U(
			dataCollectionId, groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataCollectionId_G_U_PrevAndNext(
			long structuredDataId, long dataCollectionId, long groupId,
			long userId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataCollectionId_G_U_PrevAndNext(
			structuredDataId, dataCollectionId, groupId, userId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByDataCollectionId_G_U(
		long dataCollectionId, long groupId, long userId) {

		getPersistence().removeByDataCollectionId_G_U(
			dataCollectionId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_G_U(
		long dataCollectionId, long groupId, long userId) {

		return getPersistence().countByDataCollectionId_G_U(
			dataCollectionId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataCollectionId_G_U(
		long dataCollectionId, long groupId, long userId) {

		return getPersistence().filterCountByDataCollectionId_G_U(
			dataCollectionId, groupId, userId);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_S(
		long dataCollectionId, long groupId, int status) {

		return getPersistence().findByDataCollectionId_G_S(
			dataCollectionId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_S(
		long dataCollectionId, long groupId, int status, int start, int end) {

		return getPersistence().findByDataCollectionId_G_S(
			dataCollectionId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_S(
		long dataCollectionId, long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_G_S(
			dataCollectionId, groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_S(
		long dataCollectionId, long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_G_S(
			dataCollectionId, groupId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_S_First(
			long dataCollectionId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_S_First(
			dataCollectionId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_S_First(
		long dataCollectionId, long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_S_First(
			dataCollectionId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_S_Last(
			long dataCollectionId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_S_Last(
			dataCollectionId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_S_Last(
		long dataCollectionId, long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_S_Last(
			dataCollectionId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_G_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long groupId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_S_PrevAndNext(
			structuredDataId, dataCollectionId, groupId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_S(
		long dataCollectionId, long groupId, int status) {

		return getPersistence().filterFindByDataCollectionId_G_S(
			dataCollectionId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_S(
		long dataCollectionId, long groupId, int status, int start, int end) {

		return getPersistence().filterFindByDataCollectionId_G_S(
			dataCollectionId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_S(
		long dataCollectionId, long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataCollectionId_G_S(
			dataCollectionId, groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataCollectionId_G_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long groupId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataCollectionId_G_S_PrevAndNext(
			structuredDataId, dataCollectionId, groupId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByDataCollectionId_G_S(
		long dataCollectionId, long groupId, int status) {

		getPersistence().removeByDataCollectionId_G_S(
			dataCollectionId, groupId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_G_S(
		long dataCollectionId, long groupId, int status) {

		return getPersistence().countByDataCollectionId_G_S(
			dataCollectionId, groupId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataCollectionId_G_S(
		long dataCollectionId, long groupId, int status) {

		return getPersistence().filterCountByDataCollectionId_G_S(
			dataCollectionId, groupId, status);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U_S(
		long dataCollectionId, long userId, int status) {

		return getPersistence().findByDataCollectionId_U_S(
			dataCollectionId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U_S(
		long dataCollectionId, long userId, int status, int start, int end) {

		return getPersistence().findByDataCollectionId_U_S(
			dataCollectionId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U_S(
		long dataCollectionId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_U_S(
			dataCollectionId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_U_S(
		long dataCollectionId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_U_S(
			dataCollectionId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_U_S_First(
			long dataCollectionId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_S_First(
			dataCollectionId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_U_S_First(
		long dataCollectionId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_U_S_First(
			dataCollectionId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_U_S_Last(
			long dataCollectionId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_S_Last(
			dataCollectionId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_U_S_Last(
		long dataCollectionId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_U_S_Last(
			dataCollectionId, userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_U_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_U_S_PrevAndNext(
			structuredDataId, dataCollectionId, userId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByDataCollectionId_U_S(
		long dataCollectionId, long userId, int status) {

		getPersistence().removeByDataCollectionId_U_S(
			dataCollectionId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_U_S(
		long dataCollectionId, long userId, int status) {

		return getPersistence().countByDataCollectionId_U_S(
			dataCollectionId, userId, status);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U_S(
		long dataCollectionId, long groupId, long userId, int status) {

		return getPersistence().findByDataCollectionId_G_U_S(
			dataCollectionId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U_S(
		long dataCollectionId, long groupId, long userId, int status, int start,
		int end) {

		return getPersistence().findByDataCollectionId_G_U_S(
			dataCollectionId, groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U_S(
		long dataCollectionId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataCollectionId_G_U_S(
			dataCollectionId, groupId, userId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataCollectionId_G_U_S(
		long dataCollectionId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId_G_U_S(
			dataCollectionId, groupId, userId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_U_S_First(
			long dataCollectionId, long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_S_First(
			dataCollectionId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_U_S_First(
		long dataCollectionId, long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_U_S_First(
			dataCollectionId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataCollectionId_G_U_S_Last(
			long dataCollectionId, long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_S_Last(
			dataCollectionId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataCollectionId_G_U_S_Last(
		long dataCollectionId, long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_G_U_S_Last(
			dataCollectionId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataCollectionId_G_U_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long groupId,
			long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataCollectionId_G_U_S_PrevAndNext(
			structuredDataId, dataCollectionId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U_S(
		long dataCollectionId, long groupId, long userId, int status) {

		return getPersistence().filterFindByDataCollectionId_G_U_S(
			dataCollectionId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U_S(
		long dataCollectionId, long groupId, long userId, int status, int start,
		int end) {

		return getPersistence().filterFindByDataCollectionId_G_U_S(
			dataCollectionId, groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataCollectionId_G_U_S(
		long dataCollectionId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataCollectionId_G_U_S(
			dataCollectionId, groupId, userId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[]
			filterFindByDataCollectionId_G_U_S_PrevAndNext(
				long structuredDataId, long dataCollectionId, long groupId,
				long userId, int status,
				OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataCollectionId_G_U_S_PrevAndNext(
			structuredDataId, dataCollectionId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByDataCollectionId_G_U_S(
		long dataCollectionId, long groupId, long userId, int status) {

		getPersistence().removeByDataCollectionId_G_U_S(
			dataCollectionId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataCollectionId_G_U_S(
		long dataCollectionId, long groupId, long userId, int status) {

		return getPersistence().countByDataCollectionId_G_U_S(
			dataCollectionId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataCollectionId_G_U_S(
		long dataCollectionId, long groupId, long userId, int status) {

		return getPersistence().filterCountByDataCollectionId_G_U_S(
			dataCollectionId, groupId, userId, status);
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
	 * Returns all the structured datas where dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G(
		long dataSetId, long groupId) {

		return getPersistence().findByDataSetId_G(dataSetId, groupId);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G(
		long dataSetId, long groupId, int start, int end) {

		return getPersistence().findByDataSetId_G(
			dataSetId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G(
		long dataSetId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_G(
			dataSetId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G(
		long dataSetId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_G(
			dataSetId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_First(
			long dataSetId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_First(
			dataSetId, groupId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_First(
		long dataSetId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_First(
			dataSetId, groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_Last(
			long dataSetId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_Last(
			dataSetId, groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_Last(
		long dataSetId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_Last(
			dataSetId, groupId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_G_PrevAndNext(
			long structuredDataId, long dataSetId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_PrevAndNext(
			structuredDataId, dataSetId, groupId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G(
		long dataSetId, long groupId) {

		return getPersistence().filterFindByDataSetId_G(dataSetId, groupId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G(
		long dataSetId, long groupId, int start, int end) {

		return getPersistence().filterFindByDataSetId_G(
			dataSetId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataSetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G(
		long dataSetId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataSetId_G(
			dataSetId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataSetId_G_PrevAndNext(
			long structuredDataId, long dataSetId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataSetId_G_PrevAndNext(
			structuredDataId, dataSetId, groupId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and groupId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 */
	public static void removeByDataSetId_G(long dataSetId, long groupId) {
		getPersistence().removeByDataSetId_G(dataSetId, groupId);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_G(long dataSetId, long groupId) {
		return getPersistence().countByDataSetId_G(dataSetId, groupId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataSetId_G(long dataSetId, long groupId) {
		return getPersistence().filterCountByDataSetId_G(dataSetId, groupId);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U(
		long dataSetId, long userId) {

		return getPersistence().findByDataSetId_U(dataSetId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U(
		long dataSetId, long userId, int start, int end) {

		return getPersistence().findByDataSetId_U(
			dataSetId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U(
		long dataSetId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_U(
			dataSetId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U(
		long dataSetId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_U(
			dataSetId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_U_First(
			long dataSetId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_First(
			dataSetId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_U_First(
		long dataSetId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_U_First(
			dataSetId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_U_Last(
			long dataSetId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_Last(
			dataSetId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_U_Last(
		long dataSetId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_U_Last(
			dataSetId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_U_PrevAndNext(
			long structuredDataId, long dataSetId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_PrevAndNext(
			structuredDataId, dataSetId, userId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 */
	public static void removeByDataSetId_U(long dataSetId, long userId) {
		getPersistence().removeByDataSetId_U(dataSetId, userId);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_U(long dataSetId, long userId) {
		return getPersistence().countByDataSetId_U(dataSetId, userId);
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
	 * Returns all the structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U(
		long dataSetId, long groupId, long userId) {

		return getPersistence().findByDataSetId_G_U(dataSetId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U(
		long dataSetId, long groupId, long userId, int start, int end) {

		return getPersistence().findByDataSetId_G_U(
			dataSetId, groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U(
		long dataSetId, long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_G_U(
			dataSetId, groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U(
		long dataSetId, long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_G_U(
			dataSetId, groupId, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_U_First(
			long dataSetId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_First(
			dataSetId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_U_First(
		long dataSetId, long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_U_First(
			dataSetId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_U_Last(
			long dataSetId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_Last(
			dataSetId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_U_Last(
		long dataSetId, long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_U_Last(
			dataSetId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_G_U_PrevAndNext(
			long structuredDataId, long dataSetId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_PrevAndNext(
			structuredDataId, dataSetId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U(
		long dataSetId, long groupId, long userId) {

		return getPersistence().filterFindByDataSetId_G_U(
			dataSetId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U(
		long dataSetId, long groupId, long userId, int start, int end) {

		return getPersistence().filterFindByDataSetId_G_U(
			dataSetId, groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U(
		long dataSetId, long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataSetId_G_U(
			dataSetId, groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataSetId_G_U_PrevAndNext(
			long structuredDataId, long dataSetId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataSetId_G_U_PrevAndNext(
			structuredDataId, dataSetId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByDataSetId_G_U(
		long dataSetId, long groupId, long userId) {

		getPersistence().removeByDataSetId_G_U(dataSetId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_G_U(
		long dataSetId, long groupId, long userId) {

		return getPersistence().countByDataSetId_G_U(
			dataSetId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataSetId_G_U(
		long dataSetId, long groupId, long userId) {

		return getPersistence().filterCountByDataSetId_G_U(
			dataSetId, groupId, userId);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_S(
		long dataSetId, long groupId, int status) {

		return getPersistence().findByDataSetId_G_S(dataSetId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_S(
		long dataSetId, long groupId, int status, int start, int end) {

		return getPersistence().findByDataSetId_G_S(
			dataSetId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_S(
		long dataSetId, long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_G_S(
			dataSetId, groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_S(
		long dataSetId, long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_G_S(
			dataSetId, groupId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_S_First(
			long dataSetId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_S_First(
			dataSetId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_S_First(
		long dataSetId, long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_S_First(
			dataSetId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_S_Last(
			long dataSetId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_S_Last(
			dataSetId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_S_Last(
		long dataSetId, long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_S_Last(
			dataSetId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_G_S_PrevAndNext(
			long structuredDataId, long dataSetId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_S_PrevAndNext(
			structuredDataId, dataSetId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_S(
		long dataSetId, long groupId, int status) {

		return getPersistence().filterFindByDataSetId_G_S(
			dataSetId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_S(
		long dataSetId, long groupId, int status, int start, int end) {

		return getPersistence().filterFindByDataSetId_G_S(
			dataSetId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_S(
		long dataSetId, long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataSetId_G_S(
			dataSetId, groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataSetId_G_S_PrevAndNext(
			long structuredDataId, long dataSetId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataSetId_G_S_PrevAndNext(
			structuredDataId, dataSetId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByDataSetId_G_S(
		long dataSetId, long groupId, int status) {

		getPersistence().removeByDataSetId_G_S(dataSetId, groupId, status);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_G_S(
		long dataSetId, long groupId, int status) {

		return getPersistence().countByDataSetId_G_S(
			dataSetId, groupId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataSetId_G_S(
		long dataSetId, long groupId, int status) {

		return getPersistence().filterCountByDataSetId_G_S(
			dataSetId, groupId, status);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U_S(
		long dataSetId, long userId, int status) {

		return getPersistence().findByDataSetId_U_S(dataSetId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U_S(
		long dataSetId, long userId, int status, int start, int end) {

		return getPersistence().findByDataSetId_U_S(
			dataSetId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U_S(
		long dataSetId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_U_S(
			dataSetId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_U_S(
		long dataSetId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_U_S(
			dataSetId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_U_S_First(
			long dataSetId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_S_First(
			dataSetId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_U_S_First(
		long dataSetId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_U_S_First(
			dataSetId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_U_S_Last(
			long dataSetId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_S_Last(
			dataSetId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_U_S_Last(
		long dataSetId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_U_S_Last(
			dataSetId, userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_U_S_PrevAndNext(
			long structuredDataId, long dataSetId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_U_S_PrevAndNext(
			structuredDataId, dataSetId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByDataSetId_U_S(
		long dataSetId, long userId, int status) {

		getPersistence().removeByDataSetId_U_S(dataSetId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_U_S(
		long dataSetId, long userId, int status) {

		return getPersistence().countByDataSetId_U_S(dataSetId, userId, status);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U_S(
		long dataSetId, long groupId, long userId, int status) {

		return getPersistence().findByDataSetId_G_U_S(
			dataSetId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U_S(
		long dataSetId, long groupId, long userId, int status, int start,
		int end) {

		return getPersistence().findByDataSetId_G_U_S(
			dataSetId, groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U_S(
		long dataSetId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId_G_U_S(
			dataSetId, groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId_G_U_S(
		long dataSetId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId_G_U_S(
			dataSetId, groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_U_S_First(
			long dataSetId, long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_S_First(
			dataSetId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_U_S_First(
		long dataSetId, long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_U_S_First(
			dataSetId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_G_U_S_Last(
			long dataSetId, long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_S_Last(
			dataSetId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_G_U_S_Last(
		long dataSetId, long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_G_U_S_Last(
			dataSetId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_G_U_S_PrevAndNext(
			long structuredDataId, long dataSetId, long groupId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_G_U_S_PrevAndNext(
			structuredDataId, dataSetId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U_S(
		long dataSetId, long groupId, long userId, int status) {

		return getPersistence().filterFindByDataSetId_G_U_S(
			dataSetId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U_S(
		long dataSetId, long groupId, long userId, int status, int start,
		int end) {

		return getPersistence().filterFindByDataSetId_G_U_S(
			dataSetId, groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataSetId_G_U_S(
		long dataSetId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataSetId_G_U_S(
			dataSetId, groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataSetId_G_U_S_PrevAndNext(
			long structuredDataId, long dataSetId, long groupId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataSetId_G_U_S_PrevAndNext(
			structuredDataId, dataSetId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByDataSetId_G_U_S(
		long dataSetId, long groupId, long userId, int status) {

		getPersistence().removeByDataSetId_G_U_S(
			dataSetId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId_G_U_S(
		long dataSetId, long groupId, long userId, int status) {

		return getPersistence().countByDataSetId_G_U_S(
			dataSetId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataSetId_G_U_S(
		long dataSetId, long groupId, long userId, int status) {

		return getPersistence().filterCountByDataSetId_G_U_S(
			dataSetId, groupId, userId, status);
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
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G(
		long dataCollectionId, long dataSetId, long groupId) {

		return getPersistence().findByCollectionSet_G(
			dataCollectionId, dataSetId, groupId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G(
		long dataCollectionId, long dataSetId, long groupId, int start,
		int end) {

		return getPersistence().findByCollectionSet_G(
			dataCollectionId, dataSetId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G(
		long dataCollectionId, long dataSetId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_G(
			dataCollectionId, dataSetId, groupId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G(
		long dataCollectionId, long dataSetId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_G(
			dataCollectionId, dataSetId, groupId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_First(
			long dataCollectionId, long dataSetId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_First(
			dataCollectionId, dataSetId, groupId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_First(
		long dataCollectionId, long dataSetId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_First(
			dataCollectionId, dataSetId, groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_Last(
			long dataCollectionId, long dataSetId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_Last(
			dataCollectionId, dataSetId, groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_Last(
		long dataCollectionId, long dataSetId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_Last(
			dataCollectionId, dataSetId, groupId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_G_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long groupId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, groupId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G(
		long dataCollectionId, long dataSetId, long groupId) {

		return getPersistence().filterFindByCollectionSet_G(
			dataCollectionId, dataSetId, groupId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G(
		long dataCollectionId, long dataSetId, long groupId, int start,
		int end) {

		return getPersistence().filterFindByCollectionSet_G(
			dataCollectionId, dataSetId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G(
		long dataCollectionId, long dataSetId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSet_G(
			dataCollectionId, dataSetId, groupId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByCollectionSet_G_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long groupId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSet_G_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, groupId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 */
	public static void removeByCollectionSet_G(
		long dataCollectionId, long dataSetId, long groupId) {

		getPersistence().removeByCollectionSet_G(
			dataCollectionId, dataSetId, groupId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_G(
		long dataCollectionId, long dataSetId, long groupId) {

		return getPersistence().countByCollectionSet_G(
			dataCollectionId, dataSetId, groupId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSet_G(
		long dataCollectionId, long dataSetId, long groupId) {

		return getPersistence().filterCountByCollectionSet_G(
			dataCollectionId, dataSetId, groupId);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U(
		long dataCollectionId, long dataSetId, long userId) {

		return getPersistence().findByCollectionSet_U(
			dataCollectionId, dataSetId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U(
		long dataCollectionId, long dataSetId, long userId, int start,
		int end) {

		return getPersistence().findByCollectionSet_U(
			dataCollectionId, dataSetId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U(
		long dataCollectionId, long dataSetId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_U(
			dataCollectionId, dataSetId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U(
		long dataCollectionId, long dataSetId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_U(
			dataCollectionId, dataSetId, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_U_First(
			long dataCollectionId, long dataSetId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_First(
			dataCollectionId, dataSetId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_U_First(
		long dataCollectionId, long dataSetId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_U_First(
			dataCollectionId, dataSetId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_U_Last(
			long dataCollectionId, long dataSetId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_Last(
			dataCollectionId, dataSetId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_U_Last(
		long dataCollectionId, long dataSetId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_U_Last(
			dataCollectionId, dataSetId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_U_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long userId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, userId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 */
	public static void removeByCollectionSet_U(
		long dataCollectionId, long dataSetId, long userId) {

		getPersistence().removeByCollectionSet_U(
			dataCollectionId, dataSetId, userId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_U(
		long dataCollectionId, long dataSetId, long userId) {

		return getPersistence().countByCollectionSet_U(
			dataCollectionId, dataSetId, userId);
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
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U(
		long dataCollectionId, long dataSetId, long groupId, long userId) {

		return getPersistence().findByCollectionSet_G_U(
			dataCollectionId, dataSetId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int start, int end) {

		return getPersistence().findByCollectionSet_G_U(
			dataCollectionId, dataSetId, groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_G_U(
			dataCollectionId, dataSetId, groupId, userId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_G_U(
			dataCollectionId, dataSetId, groupId, userId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_U_First(
			long dataCollectionId, long dataSetId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_First(
			dataCollectionId, dataSetId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_U_First(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_U_First(
			dataCollectionId, dataSetId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_U_Last(
			long dataCollectionId, long dataSetId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_Last(
			dataCollectionId, dataSetId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_U_Last(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_U_Last(
			dataCollectionId, dataSetId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_G_U_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, groupId, userId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U(
		long dataCollectionId, long dataSetId, long groupId, long userId) {

		return getPersistence().filterFindByCollectionSet_G_U(
			dataCollectionId, dataSetId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int start, int end) {

		return getPersistence().filterFindByCollectionSet_G_U(
			dataCollectionId, dataSetId, groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSet_G_U(
			dataCollectionId, dataSetId, groupId, userId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByCollectionSet_G_U_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSet_G_U_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, groupId, userId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByCollectionSet_G_U(
		long dataCollectionId, long dataSetId, long groupId, long userId) {

		getPersistence().removeByCollectionSet_G_U(
			dataCollectionId, dataSetId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_G_U(
		long dataCollectionId, long dataSetId, long groupId, long userId) {

		return getPersistence().countByCollectionSet_G_U(
			dataCollectionId, dataSetId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSet_G_U(
		long dataCollectionId, long dataSetId, long groupId, long userId) {

		return getPersistence().filterCountByCollectionSet_G_U(
			dataCollectionId, dataSetId, groupId, userId);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_S(
		long dataCollectionId, long dataSetId, long groupId, int status) {

		return getPersistence().findByCollectionSet_G_S(
			dataCollectionId, dataSetId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_S(
		long dataCollectionId, long dataSetId, long groupId, int status,
		int start, int end) {

		return getPersistence().findByCollectionSet_G_S(
			dataCollectionId, dataSetId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_S(
		long dataCollectionId, long dataSetId, long groupId, int status,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_G_S(
			dataCollectionId, dataSetId, groupId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_S(
		long dataCollectionId, long dataSetId, long groupId, int status,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_G_S(
			dataCollectionId, dataSetId, groupId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_S_First(
			long dataCollectionId, long dataSetId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_S_First(
			dataCollectionId, dataSetId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_S_First(
		long dataCollectionId, long dataSetId, long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_S_First(
			dataCollectionId, dataSetId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_S_Last(
			long dataCollectionId, long dataSetId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_S_Last(
			dataCollectionId, dataSetId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_S_Last(
		long dataCollectionId, long dataSetId, long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_S_Last(
			dataCollectionId, dataSetId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_G_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, groupId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_S(
		long dataCollectionId, long dataSetId, long groupId, int status) {

		return getPersistence().filterFindByCollectionSet_G_S(
			dataCollectionId, dataSetId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_S(
		long dataCollectionId, long dataSetId, long groupId, int status,
		int start, int end) {

		return getPersistence().filterFindByCollectionSet_G_S(
			dataCollectionId, dataSetId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_S(
		long dataCollectionId, long dataSetId, long groupId, int status,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSet_G_S(
			dataCollectionId, dataSetId, groupId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByCollectionSet_G_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSet_G_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, groupId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByCollectionSet_G_S(
		long dataCollectionId, long dataSetId, long groupId, int status) {

		getPersistence().removeByCollectionSet_G_S(
			dataCollectionId, dataSetId, groupId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_G_S(
		long dataCollectionId, long dataSetId, long groupId, int status) {

		return getPersistence().countByCollectionSet_G_S(
			dataCollectionId, dataSetId, groupId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSet_G_S(
		long dataCollectionId, long dataSetId, long groupId, int status) {

		return getPersistence().filterCountByCollectionSet_G_S(
			dataCollectionId, dataSetId, groupId, status);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U_S(
		long dataCollectionId, long dataSetId, long userId, int status) {

		return getPersistence().findByCollectionSet_U_S(
			dataCollectionId, dataSetId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U_S(
		long dataCollectionId, long dataSetId, long userId, int status,
		int start, int end) {

		return getPersistence().findByCollectionSet_U_S(
			dataCollectionId, dataSetId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U_S(
		long dataCollectionId, long dataSetId, long userId, int status,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_U_S(
			dataCollectionId, dataSetId, userId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_U_S(
		long dataCollectionId, long dataSetId, long userId, int status,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_U_S(
			dataCollectionId, dataSetId, userId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_U_S_First(
			long dataCollectionId, long dataSetId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_S_First(
			dataCollectionId, dataSetId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_U_S_First(
		long dataCollectionId, long dataSetId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_U_S_First(
			dataCollectionId, dataSetId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_U_S_Last(
			long dataCollectionId, long dataSetId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_S_Last(
			dataCollectionId, dataSetId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_U_S_Last(
		long dataCollectionId, long dataSetId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_U_S_Last(
			dataCollectionId, dataSetId, userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_U_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_U_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, userId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByCollectionSet_U_S(
		long dataCollectionId, long dataSetId, long userId, int status) {

		getPersistence().removeByCollectionSet_U_S(
			dataCollectionId, dataSetId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_U_S(
		long dataCollectionId, long dataSetId, long userId, int status) {

		return getPersistence().countByCollectionSet_U_S(
			dataCollectionId, dataSetId, userId, status);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U_S(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status) {

		return getPersistence().findByCollectionSet_G_U_S(
			dataCollectionId, dataSetId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U_S(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status, int start, int end) {

		return getPersistence().findByCollectionSet_G_U_S(
			dataCollectionId, dataSetId, groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U_S(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSet_G_U_S(
			dataCollectionId, dataSetId, groupId, userId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSet_G_U_S(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_G_U_S(
			dataCollectionId, dataSetId, groupId, userId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_U_S_First(
			long dataCollectionId, long dataSetId, long groupId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_S_First(
			dataCollectionId, dataSetId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_U_S_First(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_U_S_First(
			dataCollectionId, dataSetId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSet_G_U_S_Last(
			long dataCollectionId, long dataSetId, long groupId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_S_Last(
			dataCollectionId, dataSetId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSet_G_U_S_Last(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_U_S_Last(
			dataCollectionId, dataSetId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSet_G_U_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSet_G_U_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, groupId, userId,
			status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U_S(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status) {

		return getPersistence().filterFindByCollectionSet_G_U_S(
			dataCollectionId, dataSetId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U_S(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status, int start, int end) {

		return getPersistence().filterFindByCollectionSet_G_U_S(
			dataCollectionId, dataSetId, groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSet_G_U_S(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSet_G_U_S(
			dataCollectionId, dataSetId, groupId, userId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByCollectionSet_G_U_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSet_G_U_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, groupId, userId,
			status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByCollectionSet_G_U_S(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status) {

		getPersistence().removeByCollectionSet_G_U_S(
			dataCollectionId, dataSetId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSet_G_U_S(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status) {

		return getPersistence().countByCollectionSet_G_U_S(
			dataCollectionId, dataSetId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSet_G_U_S(
		long dataCollectionId, long dataSetId, long groupId, long userId,
		int status) {

		return getPersistence().filterCountByCollectionSet_G_U_S(
			dataCollectionId, dataSetId, groupId, userId, status);
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
	 * Returns all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_G(
		long dataSetId, long dataTypeId, long groupId) {

		return getPersistence().findBySetType_G(dataSetId, dataTypeId, groupId);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G(
		long dataSetId, long dataTypeId, long groupId, int start, int end) {

		return getPersistence().findBySetType_G(
			dataSetId, dataTypeId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G(
		long dataSetId, long dataTypeId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_G(
			dataSetId, dataTypeId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G(
		long dataSetId, long dataTypeId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_G(
			dataSetId, dataTypeId, groupId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_First(
			long dataSetId, long dataTypeId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_First(
			dataSetId, dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_First(
		long dataSetId, long dataTypeId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_First(
			dataSetId, dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_Last(
			long dataSetId, long dataTypeId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_Last(
			dataSetId, dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_Last(
		long dataSetId, long dataTypeId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_Last(
			dataSetId, dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_G_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId,
			long groupId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, groupId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G(
		long dataSetId, long dataTypeId, long groupId) {

		return getPersistence().filterFindBySetType_G(
			dataSetId, dataTypeId, groupId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G(
		long dataSetId, long dataTypeId, long groupId, int start, int end) {

		return getPersistence().filterFindBySetType_G(
			dataSetId, dataTypeId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G(
		long dataSetId, long dataTypeId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindBySetType_G(
			dataSetId, dataTypeId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindBySetType_G_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId,
			long groupId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindBySetType_G_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, groupId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 */
	public static void removeBySetType_G(
		long dataSetId, long dataTypeId, long groupId) {

		getPersistence().removeBySetType_G(dataSetId, dataTypeId, groupId);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_G(
		long dataSetId, long dataTypeId, long groupId) {

		return getPersistence().countBySetType_G(
			dataSetId, dataTypeId, groupId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountBySetType_G(
		long dataSetId, long dataTypeId, long groupId) {

		return getPersistence().filterCountBySetType_G(
			dataSetId, dataTypeId, groupId);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_U(
		long dataSetId, long dataTypeId, long userId) {

		return getPersistence().findBySetType_U(dataSetId, dataTypeId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U(
		long dataSetId, long dataTypeId, long userId, int start, int end) {

		return getPersistence().findBySetType_U(
			dataSetId, dataTypeId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U(
		long dataSetId, long dataTypeId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_U(
			dataSetId, dataTypeId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U(
		long dataSetId, long dataTypeId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_U(
			dataSetId, dataTypeId, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_U_First(
			long dataSetId, long dataTypeId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_First(
			dataSetId, dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_U_First(
		long dataSetId, long dataTypeId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_U_First(
			dataSetId, dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_U_Last(
			long dataSetId, long dataTypeId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_Last(
			dataSetId, dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_U_Last(
		long dataSetId, long dataTypeId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_U_Last(
			dataSetId, dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_U_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, userId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 */
	public static void removeBySetType_U(
		long dataSetId, long dataTypeId, long userId) {

		getPersistence().removeBySetType_U(dataSetId, dataTypeId, userId);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_U(
		long dataSetId, long dataTypeId, long userId) {

		return getPersistence().countBySetType_U(dataSetId, dataTypeId, userId);
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
	 * Returns all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U(
		long dataSetId, long dataTypeId, long groupId, long userId) {

		return getPersistence().findBySetType_G_U(
			dataSetId, dataTypeId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U(
		long dataSetId, long dataTypeId, long groupId, long userId, int start,
		int end) {

		return getPersistence().findBySetType_G_U(
			dataSetId, dataTypeId, groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U(
		long dataSetId, long dataTypeId, long groupId, long userId, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_G_U(
			dataSetId, dataTypeId, groupId, userId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U(
		long dataSetId, long dataTypeId, long groupId, long userId, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_G_U(
			dataSetId, dataTypeId, groupId, userId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_U_First(
			long dataSetId, long dataTypeId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_First(
			dataSetId, dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_U_First(
		long dataSetId, long dataTypeId, long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_U_First(
			dataSetId, dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_U_Last(
			long dataSetId, long dataTypeId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_Last(
			dataSetId, dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_U_Last(
		long dataSetId, long dataTypeId, long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_U_Last(
			dataSetId, dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_G_U_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId,
			long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, groupId, userId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U(
		long dataSetId, long dataTypeId, long groupId, long userId) {

		return getPersistence().filterFindBySetType_G_U(
			dataSetId, dataTypeId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U(
		long dataSetId, long dataTypeId, long groupId, long userId, int start,
		int end) {

		return getPersistence().filterFindBySetType_G_U(
			dataSetId, dataTypeId, groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U(
		long dataSetId, long dataTypeId, long groupId, long userId, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindBySetType_G_U(
			dataSetId, dataTypeId, groupId, userId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindBySetType_G_U_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId,
			long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindBySetType_G_U_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, groupId, userId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeBySetType_G_U(
		long dataSetId, long dataTypeId, long groupId, long userId) {

		getPersistence().removeBySetType_G_U(
			dataSetId, dataTypeId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_G_U(
		long dataSetId, long dataTypeId, long groupId, long userId) {

		return getPersistence().countBySetType_G_U(
			dataSetId, dataTypeId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountBySetType_G_U(
		long dataSetId, long dataTypeId, long groupId, long userId) {

		return getPersistence().filterCountBySetType_G_U(
			dataSetId, dataTypeId, groupId, userId);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_S(
		long dataSetId, long dataTypeId, long groupId, int status) {

		return getPersistence().findBySetType_G_S(
			dataSetId, dataTypeId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_S(
		long dataSetId, long dataTypeId, long groupId, int status, int start,
		int end) {

		return getPersistence().findBySetType_G_S(
			dataSetId, dataTypeId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_S(
		long dataSetId, long dataTypeId, long groupId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_G_S(
			dataSetId, dataTypeId, groupId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_S(
		long dataSetId, long dataTypeId, long groupId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_G_S(
			dataSetId, dataTypeId, groupId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_S_First(
			long dataSetId, long dataTypeId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_S_First(
			dataSetId, dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_S_First(
		long dataSetId, long dataTypeId, long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_S_First(
			dataSetId, dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_S_Last(
			long dataSetId, long dataTypeId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_S_Last(
			dataSetId, dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_S_Last(
		long dataSetId, long dataTypeId, long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_S_Last(
			dataSetId, dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_G_S_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId,
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_S_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, groupId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_S(
		long dataSetId, long dataTypeId, long groupId, int status) {

		return getPersistence().filterFindBySetType_G_S(
			dataSetId, dataTypeId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_S(
		long dataSetId, long dataTypeId, long groupId, int status, int start,
		int end) {

		return getPersistence().filterFindBySetType_G_S(
			dataSetId, dataTypeId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_S(
		long dataSetId, long dataTypeId, long groupId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindBySetType_G_S(
			dataSetId, dataTypeId, groupId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindBySetType_G_S_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId,
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindBySetType_G_S_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, groupId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeBySetType_G_S(
		long dataSetId, long dataTypeId, long groupId, int status) {

		getPersistence().removeBySetType_G_S(
			dataSetId, dataTypeId, groupId, status);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_G_S(
		long dataSetId, long dataTypeId, long groupId, int status) {

		return getPersistence().countBySetType_G_S(
			dataSetId, dataTypeId, groupId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountBySetType_G_S(
		long dataSetId, long dataTypeId, long groupId, int status) {

		return getPersistence().filterCountBySetType_G_S(
			dataSetId, dataTypeId, groupId, status);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_U_S(
		long dataSetId, long dataTypeId, long userId, int status) {

		return getPersistence().findBySetType_U_S(
			dataSetId, dataTypeId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U_S(
		long dataSetId, long dataTypeId, long userId, int status, int start,
		int end) {

		return getPersistence().findBySetType_U_S(
			dataSetId, dataTypeId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U_S(
		long dataSetId, long dataTypeId, long userId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_U_S(
			dataSetId, dataTypeId, userId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_U_S(
		long dataSetId, long dataTypeId, long userId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_U_S(
			dataSetId, dataTypeId, userId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_U_S_First(
			long dataSetId, long dataTypeId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_S_First(
			dataSetId, dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_U_S_First(
		long dataSetId, long dataTypeId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_U_S_First(
			dataSetId, dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_U_S_Last(
			long dataSetId, long dataTypeId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_S_Last(
			dataSetId, dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_U_S_Last(
		long dataSetId, long dataTypeId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_U_S_Last(
			dataSetId, dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_U_S_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_U_S_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, userId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeBySetType_U_S(
		long dataSetId, long dataTypeId, long userId, int status) {

		getPersistence().removeBySetType_U_S(
			dataSetId, dataTypeId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_U_S(
		long dataSetId, long dataTypeId, long userId, int status) {

		return getPersistence().countBySetType_U_S(
			dataSetId, dataTypeId, userId, status);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U_S(
		long dataSetId, long dataTypeId, long groupId, long userId,
		int status) {

		return getPersistence().findBySetType_G_U_S(
			dataSetId, dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U_S(
		long dataSetId, long dataTypeId, long groupId, long userId, int status,
		int start, int end) {

		return getPersistence().findBySetType_G_U_S(
			dataSetId, dataTypeId, groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U_S(
		long dataSetId, long dataTypeId, long groupId, long userId, int status,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBySetType_G_U_S(
			dataSetId, dataTypeId, groupId, userId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findBySetType_G_U_S(
		long dataSetId, long dataTypeId, long groupId, long userId, int status,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType_G_U_S(
			dataSetId, dataTypeId, groupId, userId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_U_S_First(
			long dataSetId, long dataTypeId, long groupId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_S_First(
			dataSetId, dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_U_S_First(
		long dataSetId, long dataTypeId, long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_U_S_First(
			dataSetId, dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBySetType_G_U_S_Last(
			long dataSetId, long dataTypeId, long groupId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_S_Last(
			dataSetId, dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBySetType_G_U_S_Last(
		long dataSetId, long dataTypeId, long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBySetType_G_U_S_Last(
			dataSetId, dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBySetType_G_U_S_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId,
			long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBySetType_G_U_S_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U_S(
		long dataSetId, long dataTypeId, long groupId, long userId,
		int status) {

		return getPersistence().filterFindBySetType_G_U_S(
			dataSetId, dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U_S(
		long dataSetId, long dataTypeId, long groupId, long userId, int status,
		int start, int end) {

		return getPersistence().filterFindBySetType_G_U_S(
			dataSetId, dataTypeId, groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindBySetType_G_U_S(
		long dataSetId, long dataTypeId, long groupId, long userId, int status,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindBySetType_G_U_S(
			dataSetId, dataTypeId, groupId, userId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindBySetType_G_U_S_PrevAndNext(
			long structuredDataId, long dataSetId, long dataTypeId,
			long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindBySetType_G_U_S_PrevAndNext(
			structuredDataId, dataSetId, dataTypeId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeBySetType_G_U_S(
		long dataSetId, long dataTypeId, long groupId, long userId,
		int status) {

		getPersistence().removeBySetType_G_U_S(
			dataSetId, dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countBySetType_G_U_S(
		long dataSetId, long dataTypeId, long groupId, long userId,
		int status) {

		return getPersistence().countBySetType_G_U_S(
			dataSetId, dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountBySetType_G_U_S(
		long dataSetId, long dataTypeId, long groupId, long userId,
		int status) {

		return getPersistence().filterCountBySetType_G_U_S(
			dataSetId, dataTypeId, groupId, userId, status);
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
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId) {

		return getPersistence().findByCollectionSetType_G(
			dataCollectionId, dataSetId, dataTypeId, groupId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int start, int end) {

		return getPersistence().findByCollectionSetType_G(
			dataCollectionId, dataSetId, dataTypeId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_G(
			dataCollectionId, dataSetId, dataTypeId, groupId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_G(
			dataCollectionId, dataSetId, dataTypeId, groupId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_First(
			long dataCollectionId, long dataSetId, long dataTypeId,
			long groupId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_First(
			dataCollectionId, dataSetId, dataTypeId, groupId,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_First(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_First(
			dataCollectionId, dataSetId, dataTypeId, groupId,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_Last(
			long dataCollectionId, long dataSetId, long dataTypeId,
			long groupId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_Last(
			dataCollectionId, dataSetId, dataTypeId, groupId,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_Last(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_Last(
			dataCollectionId, dataSetId, dataTypeId, groupId,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_G_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long dataTypeId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, groupId,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId) {

		return getPersistence().filterFindByCollectionSetType_G(
			dataCollectionId, dataSetId, dataTypeId, groupId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int start, int end) {

		return getPersistence().filterFindByCollectionSetType_G(
			dataCollectionId, dataSetId, dataTypeId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSetType_G(
			dataCollectionId, dataSetId, dataTypeId, groupId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByCollectionSetType_G_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long dataTypeId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSetType_G_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, groupId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 */
	public static void removeByCollectionSetType_G(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId) {

		getPersistence().removeByCollectionSetType_G(
			dataCollectionId, dataSetId, dataTypeId, groupId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_G(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId) {

		return getPersistence().countByCollectionSetType_G(
			dataCollectionId, dataSetId, dataTypeId, groupId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSetType_G(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId) {

		return getPersistence().filterCountByCollectionSetType_G(
			dataCollectionId, dataSetId, dataTypeId, groupId);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId) {

		return getPersistence().findByCollectionSetType_U(
			dataCollectionId, dataSetId, dataTypeId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		int start, int end) {

		return getPersistence().findByCollectionSetType_U(
			dataCollectionId, dataSetId, dataTypeId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_U(
			dataCollectionId, dataSetId, dataTypeId, userId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_U(
			dataCollectionId, dataSetId, dataTypeId, userId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_U_First(
			long dataCollectionId, long dataSetId, long dataTypeId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_First(
			dataCollectionId, dataSetId, dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_U_First(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_U_First(
			dataCollectionId, dataSetId, dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_U_Last(
			long dataCollectionId, long dataSetId, long dataTypeId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_Last(
			dataCollectionId, dataSetId, dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_U_Last(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_U_Last(
			dataCollectionId, dataSetId, dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_U_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long dataTypeId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, userId,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 */
	public static void removeByCollectionSetType_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId) {

		getPersistence().removeByCollectionSetType_U(
			dataCollectionId, dataSetId, dataTypeId, userId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId) {

		return getPersistence().countByCollectionSetType_U(
			dataCollectionId, dataSetId, dataTypeId, userId);
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
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId) {

		return getPersistence().findByCollectionSetType_G_U(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int start, int end) {

		return getPersistence().findByCollectionSetType_G_U(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, start,
			end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_G_U(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, start,
			end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_G_U(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, start,
			end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_U_First(
			long dataCollectionId, long dataSetId, long dataTypeId,
			long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_First(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_U_First(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_U_First(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_U_Last(
			long dataCollectionId, long dataSetId, long dataTypeId,
			long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_Last(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_U_Last(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_U_Last(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_G_U_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long dataTypeId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, groupId,
			userId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId) {

		return getPersistence().filterFindByCollectionSetType_G_U(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int start, int end) {

		return getPersistence().filterFindByCollectionSetType_G_U(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, start,
			end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSetType_G_U(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, start,
			end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[]
			filterFindByCollectionSetType_G_U_PrevAndNext(
				long structuredDataId, long dataCollectionId, long dataSetId,
				long dataTypeId, long groupId, long userId,
				OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSetType_G_U_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, groupId,
			userId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByCollectionSetType_G_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId) {

		getPersistence().removeByCollectionSetType_G_U(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_G_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId) {

		return getPersistence().countByCollectionSetType_G_U(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSetType_G_U(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId) {

		return getPersistence().filterCountByCollectionSetType_G_U(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status) {

		return getPersistence().findByCollectionSetType_G_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status, int start, int end) {

		return getPersistence().findByCollectionSetType_G_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, status, start,
			end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_G_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, status, start,
			end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_G_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, status, start,
			end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_S_First(
			long dataCollectionId, long dataSetId, long dataTypeId,
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_S_First(
			dataCollectionId, dataSetId, dataTypeId, groupId, status,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_S_First(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_S_First(
			dataCollectionId, dataSetId, dataTypeId, groupId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_S_Last(
			long dataCollectionId, long dataSetId, long dataTypeId,
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_S_Last(
			dataCollectionId, dataSetId, dataTypeId, groupId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_S_Last(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_S_Last(
			dataCollectionId, dataSetId, dataTypeId, groupId, status,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_G_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long dataTypeId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, groupId,
			status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status) {

		return getPersistence().filterFindByCollectionSetType_G_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status, int start, int end) {

		return getPersistence().filterFindByCollectionSetType_G_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, status, start,
			end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSetType_G_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, status, start,
			end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[]
			filterFindByCollectionSetType_G_S_PrevAndNext(
				long structuredDataId, long dataCollectionId, long dataSetId,
				long dataTypeId, long groupId, int status,
				OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSetType_G_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, groupId,
			status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByCollectionSetType_G_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status) {

		getPersistence().removeByCollectionSetType_G_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_G_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status) {

		return getPersistence().countByCollectionSetType_G_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSetType_G_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		int status) {

		return getPersistence().filterCountByCollectionSetType_G_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, status);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		int status) {

		return getPersistence().findByCollectionSetType_U_S(
			dataCollectionId, dataSetId, dataTypeId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		int status, int start, int end) {

		return getPersistence().findByCollectionSetType_U_S(
			dataCollectionId, dataSetId, dataTypeId, userId, status, start,
			end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_U_S(
			dataCollectionId, dataSetId, dataTypeId, userId, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_U_S(
			dataCollectionId, dataSetId, dataTypeId, userId, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_U_S_First(
			long dataCollectionId, long dataSetId, long dataTypeId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_S_First(
			dataCollectionId, dataSetId, dataTypeId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_U_S_First(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_U_S_First(
			dataCollectionId, dataSetId, dataTypeId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_U_S_Last(
			long dataCollectionId, long dataSetId, long dataTypeId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_S_Last(
			dataCollectionId, dataSetId, dataTypeId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_U_S_Last(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_U_S_Last(
			dataCollectionId, dataSetId, dataTypeId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_U_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long dataTypeId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_U_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, userId,
			status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByCollectionSetType_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		int status) {

		getPersistence().removeByCollectionSetType_U_S(
			dataCollectionId, dataSetId, dataTypeId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long userId,
		int status) {

		return getPersistence().countByCollectionSetType_U_S(
			dataCollectionId, dataSetId, dataTypeId, userId, status);
	}

	/**
	 * Returns all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status) {

		return getPersistence().findByCollectionSetType_G_U_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status, int start, int end) {

		return getPersistence().findByCollectionSetType_G_U_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status,
			start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCollectionSetType_G_U_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status,
			start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByCollectionSetType_G_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSetType_G_U_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status,
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_U_S_First(
			long dataCollectionId, long dataSetId, long dataTypeId,
			long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_S_First(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_U_S_First(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_U_S_First(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCollectionSetType_G_U_S_Last(
			long dataCollectionId, long dataSetId, long dataTypeId,
			long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_S_Last(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCollectionSetType_G_U_S_Last(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCollectionSetType_G_U_S_Last(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCollectionSetType_G_U_S_PrevAndNext(
			long structuredDataId, long dataCollectionId, long dataSetId,
			long dataTypeId, long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCollectionSetType_G_U_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, groupId,
			userId, status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status) {

		return getPersistence().filterFindByCollectionSetType_G_U_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status, int start, int end) {

		return getPersistence().filterFindByCollectionSetType_G_U_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status,
			start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByCollectionSetType_G_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByCollectionSetType_G_U_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status,
			start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[]
			filterFindByCollectionSetType_G_U_S_PrevAndNext(
				long structuredDataId, long dataCollectionId, long dataSetId,
				long dataTypeId, long groupId, long userId, int status,
				OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByCollectionSetType_G_U_S_PrevAndNext(
			structuredDataId, dataCollectionId, dataSetId, dataTypeId, groupId,
			userId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByCollectionSetType_G_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status) {

		getPersistence().removeByCollectionSetType_G_U_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByCollectionSetType_G_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status) {

		return getPersistence().countByCollectionSetType_G_U_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataCollectionId = &#63; and dataSetId = &#63; and dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByCollectionSetType_G_U_S(
		long dataCollectionId, long dataSetId, long dataTypeId, long groupId,
		long userId, int status) {

		return getPersistence().filterCountByCollectionSetType_G_U_S(
			dataCollectionId, dataSetId, dataTypeId, groupId, userId, status);
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
	 * Returns all the structured datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G(
		long dataTypeId, long groupId) {

		return getPersistence().findByDataTypeId_G(dataTypeId, groupId);
	}

	/**
	 * Returns a range of all the structured datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end) {

		return getPersistence().findByDataTypeId_G(
			dataTypeId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_G(
			dataTypeId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G(
			dataTypeId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_First(
			long dataTypeId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_First(
			dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_First(
		long dataTypeId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_First(
			dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_Last(
			long dataTypeId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_Last(
			dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_Last(
		long dataTypeId, long groupId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_Last(
			dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_G_PrevAndNext(
			long structuredDataId, long dataTypeId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_PrevAndNext(
			structuredDataId, dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G(
		long dataTypeId, long groupId) {

		return getPersistence().filterFindByDataTypeId_G(dataTypeId, groupId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end) {

		return getPersistence().filterFindByDataTypeId_G(
			dataTypeId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataTypeId_G(
			dataTypeId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataTypeId_G_PrevAndNext(
			long structuredDataId, long dataTypeId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataTypeId_G_PrevAndNext(
			structuredDataId, dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataTypeId = &#63; and groupId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 */
	public static void removeByDataTypeId_G(long dataTypeId, long groupId) {
		getPersistence().removeByDataTypeId_G(dataTypeId, groupId);
	}

	/**
	 * Returns the number of structured datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_G(long dataTypeId, long groupId) {
		return getPersistence().countByDataTypeId_G(dataTypeId, groupId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataTypeId_G(long dataTypeId, long groupId) {
		return getPersistence().filterCountByDataTypeId_G(dataTypeId, groupId);
	}

	/**
	 * Returns all the structured datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U(
		long dataTypeId, long userId) {

		return getPersistence().findByDataTypeId_U(dataTypeId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end) {

		return getPersistence().findByDataTypeId_U(
			dataTypeId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_U(
			dataTypeId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_U(
			dataTypeId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_U_First(
			long dataTypeId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_First(
			dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_U_First(
		long dataTypeId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_First(
			dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_U_Last(
			long dataTypeId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_Last(
			dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_U_Last(
		long dataTypeId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_Last(
			dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_U_PrevAndNext(
			long structuredDataId, long dataTypeId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_PrevAndNext(
			structuredDataId, dataTypeId, userId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataTypeId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 */
	public static void removeByDataTypeId_U(long dataTypeId, long userId) {
		getPersistence().removeByDataTypeId_U(dataTypeId, userId);
	}

	/**
	 * Returns the number of structured datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_U(long dataTypeId, long userId) {
		return getPersistence().countByDataTypeId_U(dataTypeId, userId);
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
	 * Returns all the structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId) {

		return getPersistence().findByDataTypeId_G_U(
			dataTypeId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end) {

		return getPersistence().findByDataTypeId_G_U(
			dataTypeId, groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_G_U(
			dataTypeId, groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G_U(
			dataTypeId, groupId, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_U_First(
			long dataTypeId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_First(
			dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_U_First(
		long dataTypeId, long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_First(
			dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_U_Last(
			long dataTypeId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_Last(
			dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_U_Last(
		long dataTypeId, long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_Last(
			dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_G_U_PrevAndNext(
			long structuredDataId, long dataTypeId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_PrevAndNext(
			structuredDataId, dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId) {

		return getPersistence().filterFindByDataTypeId_G_U(
			dataTypeId, groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end) {

		return getPersistence().filterFindByDataTypeId_G_U(
			dataTypeId, groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataTypeId_G_U(
			dataTypeId, groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataTypeId_G_U_PrevAndNext(
			long structuredDataId, long dataTypeId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataTypeId_G_U_PrevAndNext(
			structuredDataId, dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId) {

		getPersistence().removeByDataTypeId_G_U(dataTypeId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId) {

		return getPersistence().countByDataTypeId_G_U(
			dataTypeId, groupId, userId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId) {

		return getPersistence().filterCountByDataTypeId_G_U(
			dataTypeId, groupId, userId);
	}

	/**
	 * Returns all the structured datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status) {

		return getPersistence().findByDataTypeId_G_S(
			dataTypeId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end) {

		return getPersistence().findByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_S_First(
			long dataTypeId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_S_First(
			dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_S_First(
		long dataTypeId, long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_S_First(
			dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_S_Last(
			long dataTypeId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_S_Last(
			dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_S_Last(
		long dataTypeId, long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_S_Last(
			dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_G_S_PrevAndNext(
			long structuredDataId, long dataTypeId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_S_PrevAndNext(
			structuredDataId, dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_S(
		long dataTypeId, long groupId, int status) {

		return getPersistence().filterFindByDataTypeId_G_S(
			dataTypeId, groupId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end) {

		return getPersistence().filterFindByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataTypeId_G_S_PrevAndNext(
			long structuredDataId, long dataTypeId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataTypeId_G_S_PrevAndNext(
			structuredDataId, dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataTypeId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByDataTypeId_G_S(
		long dataTypeId, long groupId, int status) {

		getPersistence().removeByDataTypeId_G_S(dataTypeId, groupId, status);
	}

	/**
	 * Returns the number of structured datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_G_S(
		long dataTypeId, long groupId, int status) {

		return getPersistence().countByDataTypeId_G_S(
			dataTypeId, groupId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataTypeId_G_S(
		long dataTypeId, long groupId, int status) {

		return getPersistence().filterCountByDataTypeId_G_S(
			dataTypeId, groupId, status);
	}

	/**
	 * Returns all the structured datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status) {

		return getPersistence().findByDataTypeId_U_S(
			dataTypeId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end) {

		return getPersistence().findByDataTypeId_U_S(
			dataTypeId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_U_S(
			dataTypeId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_U_S(
			dataTypeId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_U_S_First(
			long dataTypeId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_S_First(
			dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_U_S_First(
		long dataTypeId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_S_First(
			dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_U_S_Last(
			long dataTypeId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_S_Last(
			dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_U_S_Last(
		long dataTypeId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_S_Last(
			dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_U_S_PrevAndNext(
			long structuredDataId, long dataTypeId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_U_S_PrevAndNext(
			structuredDataId, dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataTypeId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByDataTypeId_U_S(
		long dataTypeId, long userId, int status) {

		getPersistence().removeByDataTypeId_U_S(dataTypeId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_U_S(
		long dataTypeId, long userId, int status) {

		return getPersistence().countByDataTypeId_U_S(
			dataTypeId, userId, status);
	}

	/**
	 * Returns all the structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status) {

		return getPersistence().findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end) {

		return getPersistence().findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_U_S_First(
			long dataTypeId, long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_S_First(
			dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_U_S_First(
		long dataTypeId, long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_S_First(
			dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_G_U_S_Last(
			long dataTypeId, long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_S_Last(
			dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_G_U_S_Last(
		long dataTypeId, long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_S_Last(
			dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_G_U_S_PrevAndNext(
			long structuredDataId, long dataTypeId, long groupId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_G_U_S_PrevAndNext(
			structuredDataId, dataTypeId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status) {

		return getPersistence().filterFindByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end) {

		return getPersistence().filterFindByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByDataTypeId_G_U_S_PrevAndNext(
			long structuredDataId, long dataTypeId, long groupId, long userId,
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByDataTypeId_G_U_S_PrevAndNext(
			structuredDataId, dataTypeId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status) {

		getPersistence().removeByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status) {

		return getPersistence().countByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status) {

		return getPersistence().filterCountByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status);
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