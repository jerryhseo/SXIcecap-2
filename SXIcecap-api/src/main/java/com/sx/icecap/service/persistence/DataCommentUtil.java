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

import com.sx.icecap.model.DataComment;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the data comment service. This utility wraps <code>com.sx.icecap.service.persistence.impl.DataCommentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataCommentPersistence
 * @generated
 */
public class DataCommentUtil {

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
	public static void clearCache(DataComment dataComment) {
		getPersistence().clearCache(dataComment);
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
	public static Map<Serializable, DataComment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataComment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataComment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataComment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataComment update(DataComment dataComment) {
		return getPersistence().update(dataComment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataComment update(
		DataComment dataComment, ServiceContext serviceContext) {

		return getPersistence().update(dataComment, serviceContext);
	}

	/**
	 * Returns all the data comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data comments
	 */
	public static List<DataComment> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the data comments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByUuid_First(
			String uuid, OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByUuid_First(
		String uuid, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByUuid_Last(
			String uuid, OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByUuid_Last(
		String uuid, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where uuid = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByUuid_PrevAndNext(
			long dataCommentId, String uuid,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByUuid_PrevAndNext(
			dataCommentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the data comments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of data comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data comments
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the data comment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataCommentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the data comment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data comment that was removed
	 */
	public static DataComment removeByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of data comments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data comments
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the data comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data comments
	 */
	public static List<DataComment> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the data comments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByUuid_C_PrevAndNext(
			long dataCommentId, String uuid, long companyId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByUuid_C_PrevAndNext(
			dataCommentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the data comments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of data comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data comments
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the data comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data comments
	 */
	public static List<DataComment> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the data comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByGroupId_First(
			long groupId, OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByGroupId_First(
		long groupId, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByGroupId_Last(
			long groupId, OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByGroupId_Last(
		long groupId, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByGroupId_PrevAndNext(
			long dataCommentId, long groupId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByGroupId_PrevAndNext(
			dataCommentId, groupId, orderByComparator);
	}

	/**
	 * Returns all the data comments that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the data comments that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set of data comments that the user has permission to view where groupId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] filterFindByGroupId_PrevAndNext(
			long dataCommentId, long groupId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			dataCommentId, groupId, orderByComparator);
	}

	/**
	 * Removes all the data comments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of data comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data comments
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of data comments that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data comments that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the data comments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data comments
	 */
	public static List<DataComment> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the data comments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByUserId_First(
			long userId, OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByUserId_First(
		long userId, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByUserId_Last(
			long userId, OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByUserId_Last(
		long userId, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where userId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByUserId_PrevAndNext(
			long dataCommentId, long userId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByUserId_PrevAndNext(
			dataCommentId, userId, orderByComparator);
	}

	/**
	 * Removes all the data comments where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of data comments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data comments
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the data comments where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data comments
	 */
	public static List<DataComment> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the data comments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByStatus_First(
			int status, OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByStatus_First(
		int status, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByStatus_Last(
			int status, OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByStatus_Last(
		int status, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where status = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByStatus_PrevAndNext(
			long dataCommentId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByStatus_PrevAndNext(
			dataCommentId, status, orderByComparator);
	}

	/**
	 * Removes all the data comments where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of data comments where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data comments
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the data comments where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data comments
	 */
	public static List<DataComment> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the data comments where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByG_U_First(
			long groupId, long userId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByG_U_PrevAndNext(
			long dataCommentId, long groupId, long userId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByG_U_PrevAndNext(
			dataCommentId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns all the data comments that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByG_U(long groupId, long userId) {
		return getPersistence().filterFindByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the data comments that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().filterFindByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments that the user has permissions to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().filterFindByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set of data comments that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] filterFindByG_U_PrevAndNext(
			long dataCommentId, long groupId, long userId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().filterFindByG_U_PrevAndNext(
			dataCommentId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the data comments where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	 * Returns the number of data comments where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data comments
	 */
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	 * Returns the number of data comments that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data comments that the user has permission to view
	 */
	public static int filterCountByG_U(long groupId, long userId) {
		return getPersistence().filterCountByG_U(groupId, userId);
	}

	/**
	 * Returns all the data comments where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data comments
	 */
	public static List<DataComment> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the data comments where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByG_S_First(
			long groupId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByG_S_Last(
			long groupId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByG_S_PrevAndNext(
			long dataCommentId, long groupId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByG_S_PrevAndNext(
			dataCommentId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the data comments that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the data comments that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set of data comments that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] filterFindByG_S_PrevAndNext(
			long dataCommentId, long groupId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			dataCommentId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the data comments where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of data comments where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data comments
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of data comments that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data comments that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns all the data comments where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data comments
	 */
	public static List<DataComment> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the data comments where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByU_S_First(
			long userId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByU_S_First(
		long userId, int status,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByU_S_Last(
			long userId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByU_S_PrevAndNext(
			long dataCommentId, long userId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByU_S_PrevAndNext(
			dataCommentId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the data comments where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of data comments where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data comments
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns all the data comments where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data comments
	 */
	public static List<DataComment> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the data comments where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByG_U_S_PrevAndNext(
			long dataCommentId, long groupId, long userId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByG_U_S_PrevAndNext(
			dataCommentId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the data comments that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterFindByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the data comments that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set of data comments that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] filterFindByG_U_S_PrevAndNext(
			long dataCommentId, long groupId, long userId, int status,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().filterFindByG_U_S_PrevAndNext(
			dataCommentId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the data comments where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of data comments where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data comments
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of data comments that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data comments that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterCountByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns all the data comments where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @return the matching data comments
	 */
	public static List<DataComment> findByDataId(
		String commentModel, long dataId) {

		return getPersistence().findByDataId(commentModel, dataId);
	}

	/**
	 * Returns a range of all the data comments where commentModel = &#63; and dataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByDataId(
		String commentModel, long dataId, int start, int end) {

		return getPersistence().findByDataId(commentModel, dataId, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63; and dataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByDataId(
		String commentModel, long dataId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByDataId(
			commentModel, dataId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63; and dataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByDataId(
		String commentModel, long dataId, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataId(
			commentModel, dataId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByDataId_First(
			String commentModel, long dataId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByDataId_First(
			commentModel, dataId, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByDataId_First(
		String commentModel, long dataId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByDataId_First(
			commentModel, dataId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByDataId_Last(
			String commentModel, long dataId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByDataId_Last(
			commentModel, dataId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByDataId_Last(
		String commentModel, long dataId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByDataId_Last(
			commentModel, dataId, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByDataId_PrevAndNext(
			long dataCommentId, String commentModel, long dataId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByDataId_PrevAndNext(
			dataCommentId, commentModel, dataId, orderByComparator);
	}

	/**
	 * Removes all the data comments where commentModel = &#63; and dataId = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 */
	public static void removeByDataId(String commentModel, long dataId) {
		getPersistence().removeByDataId(commentModel, dataId);
	}

	/**
	 * Returns the number of data comments where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @return the number of matching data comments
	 */
	public static int countByDataId(String commentModel, long dataId) {
		return getPersistence().countByDataId(commentModel, dataId);
	}

	/**
	 * Returns all the data comments where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @return the matching data comments
	 */
	public static List<DataComment> findByParamCode(
		String commentModel, long dataId, String paramCode) {

		return getPersistence().findByParamCode(
			commentModel, dataId, paramCode);
	}

	/**
	 * Returns a range of all the data comments where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByParamCode(
		String commentModel, long dataId, String paramCode, int start,
		int end) {

		return getPersistence().findByParamCode(
			commentModel, dataId, paramCode, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByParamCode(
		String commentModel, long dataId, String paramCode, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByParamCode(
			commentModel, dataId, paramCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByParamCode(
		String commentModel, long dataId, String paramCode, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParamCode(
			commentModel, dataId, paramCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByParamCode_First(
			String commentModel, long dataId, String paramCode,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByParamCode_First(
			commentModel, dataId, paramCode, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByParamCode_First(
		String commentModel, long dataId, String paramCode,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByParamCode_First(
			commentModel, dataId, paramCode, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByParamCode_Last(
			String commentModel, long dataId, String paramCode,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByParamCode_Last(
			commentModel, dataId, paramCode, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByParamCode_Last(
		String commentModel, long dataId, String paramCode,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByParamCode_Last(
			commentModel, dataId, paramCode, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByParamCode_PrevAndNext(
			long dataCommentId, String commentModel, long dataId,
			String paramCode, OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByParamCode_PrevAndNext(
			dataCommentId, commentModel, dataId, paramCode, orderByComparator);
	}

	/**
	 * Removes all the data comments where commentModel = &#63; and dataId = &#63; and paramCode = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 */
	public static void removeByParamCode(
		String commentModel, long dataId, String paramCode) {

		getPersistence().removeByParamCode(commentModel, dataId, paramCode);
	}

	/**
	 * Returns the number of data comments where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @return the number of matching data comments
	 */
	public static int countByParamCode(
		String commentModel, long dataId, String paramCode) {

		return getPersistence().countByParamCode(
			commentModel, dataId, paramCode);
	}

	/**
	 * Returns all the data comments where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @return the matching data comments
	 */
	public static List<DataComment> findByModel(String commentModel) {
		return getPersistence().findByModel(commentModel);
	}

	/**
	 * Returns a range of all the data comments where commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByModel(
		String commentModel, int start, int end) {

		return getPersistence().findByModel(commentModel, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByModel(
		String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByModel(
			commentModel, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByModel(
		String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByModel(
			commentModel, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByModel_First(
			String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_First(
			commentModel, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModel_First(
		String commentModel, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModel_First(
			commentModel, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByModel_Last(
			String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_Last(
			commentModel, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModel_Last(
		String commentModel, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModel_Last(
			commentModel, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByModel_PrevAndNext(
			long dataCommentId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_PrevAndNext(
			dataCommentId, commentModel, orderByComparator);
	}

	/**
	 * Removes all the data comments where commentModel = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 */
	public static void removeByModel(String commentModel) {
		getPersistence().removeByModel(commentModel);
	}

	/**
	 * Returns the number of data comments where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @return the number of matching data comments
	 */
	public static int countByModel(String commentModel) {
		return getPersistence().countByModel(commentModel);
	}

	/**
	 * Returns all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the matching data comments
	 */
	public static List<DataComment> findByModel_G(
		long groupId, String commentModel) {

		return getPersistence().findByModel_G(groupId, commentModel);
	}

	/**
	 * Returns a range of all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public static List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end) {

		return getPersistence().findByModel_G(
			groupId, commentModel, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByModel_G(
			groupId, commentModel, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public static List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByModel_G(
			groupId, commentModel, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByModel_G_First(
			long groupId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_G_First(
			groupId, commentModel, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModel_G_First(
		long groupId, String commentModel,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModel_G_First(
			groupId, commentModel, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByModel_G_Last(
			long groupId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_G_Last(
			groupId, commentModel, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModel_G_Last(
		long groupId, String commentModel,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModel_G_Last(
			groupId, commentModel, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByModel_G_PrevAndNext(
			long dataCommentId, long groupId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_G_PrevAndNext(
			dataCommentId, groupId, commentModel, orderByComparator);
	}

	/**
	 * Returns all the data comments that the user has permission to view where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByModel_G(
		long groupId, String commentModel) {

		return getPersistence().filterFindByModel_G(groupId, commentModel);
	}

	/**
	 * Returns a range of all the data comments that the user has permission to view where groupId = &#63; and commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByModel_G(
		long groupId, String commentModel, int start, int end) {

		return getPersistence().filterFindByModel_G(
			groupId, commentModel, start, end);
	}

	/**
	 * Returns an ordered range of all the data comments that the user has permissions to view where groupId = &#63; and commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments that the user has permission to view
	 */
	public static List<DataComment> filterFindByModel_G(
		long groupId, String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().filterFindByModel_G(
			groupId, commentModel, start, end, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set of data comments that the user has permission to view where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] filterFindByModel_G_PrevAndNext(
			long dataCommentId, long groupId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().filterFindByModel_G_PrevAndNext(
			dataCommentId, groupId, commentModel, orderByComparator);
	}

	/**
	 * Removes all the data comments where groupId = &#63; and commentModel = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 */
	public static void removeByModel_G(long groupId, String commentModel) {
		getPersistence().removeByModel_G(groupId, commentModel);
	}

	/**
	 * Returns the number of data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the number of matching data comments
	 */
	public static int countByModel_G(long groupId, String commentModel) {
		return getPersistence().countByModel_G(groupId, commentModel);
	}

	/**
	 * Returns the number of data comments that the user has permission to view where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the number of matching data comments that the user has permission to view
	 */
	public static int filterCountByModel_G(long groupId, String commentModel) {
		return getPersistence().filterCountByModel_G(groupId, commentModel);
	}

	/**
	 * Caches the data comment in the entity cache if it is enabled.
	 *
	 * @param dataComment the data comment
	 */
	public static void cacheResult(DataComment dataComment) {
		getPersistence().cacheResult(dataComment);
	}

	/**
	 * Caches the data comments in the entity cache if it is enabled.
	 *
	 * @param dataComments the data comments
	 */
	public static void cacheResult(List<DataComment> dataComments) {
		getPersistence().cacheResult(dataComments);
	}

	/**
	 * Creates a new data comment with the primary key. Does not add the data comment to the database.
	 *
	 * @param dataCommentId the primary key for the new data comment
	 * @return the new data comment
	 */
	public static DataComment create(long dataCommentId) {
		return getPersistence().create(dataCommentId);
	}

	/**
	 * Removes the data comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment that was removed
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment remove(long dataCommentId)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().remove(dataCommentId);
	}

	public static DataComment updateImpl(DataComment dataComment) {
		return getPersistence().updateImpl(dataComment);
	}

	/**
	 * Returns the data comment with the primary key or throws a <code>NoSuchDataCommentException</code> if it could not be found.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment findByPrimaryKey(long dataCommentId)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByPrimaryKey(dataCommentId);
	}

	/**
	 * Returns the data comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment, or <code>null</code> if a data comment with the primary key could not be found
	 */
	public static DataComment fetchByPrimaryKey(long dataCommentId) {
		return getPersistence().fetchByPrimaryKey(dataCommentId);
	}

	/**
	 * Returns all the data comments.
	 *
	 * @return the data comments
	 */
	public static List<DataComment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the data comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of data comments
	 */
	public static List<DataComment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the data comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data comments
	 */
	public static List<DataComment> findAll(
		int start, int end, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data comments
	 */
	public static List<DataComment> findAll(
		int start, int end, OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the data comments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data comments.
	 *
	 * @return the number of data comments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataCommentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DataCommentPersistence _persistence;

}