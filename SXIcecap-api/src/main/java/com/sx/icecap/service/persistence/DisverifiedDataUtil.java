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

import com.sx.icecap.model.DisverifiedData;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the disverified data service. This utility wraps <code>com.sx.icecap.service.persistence.impl.DisverifiedDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DisverifiedDataPersistence
 * @generated
 */
public class DisverifiedDataUtil {

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
	public static void clearCache(DisverifiedData disverifiedData) {
		getPersistence().clearCache(disverifiedData);
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
	public static Map<Serializable, DisverifiedData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DisverifiedData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DisverifiedData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DisverifiedData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DisverifiedData update(DisverifiedData disverifiedData) {
		return getPersistence().update(disverifiedData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DisverifiedData update(
		DisverifiedData disverifiedData, ServiceContext serviceContext) {

		return getPersistence().update(disverifiedData, serviceContext);
	}

	/**
	 * Returns all the disverified datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the disverified datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByGroupId_First(
			long groupId, OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByGroupId_First(
		long groupId, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByGroupId_Last(
			long groupId, OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByGroupId_Last(
		long groupId, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByGroupId_PrevAndNext(
			long disverifiedDataId, long groupId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByGroupId_PrevAndNext(
			disverifiedDataId, groupId, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of disverified datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching disverified datas
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the disverified datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the disverified datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByUserId_First(
			long userId, OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByUserId_First(
		long userId, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByUserId_Last(
			long userId, OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByUserId_Last(
		long userId, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where userId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByUserId_PrevAndNext(
			long disverifiedDataId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByUserId_PrevAndNext(
			disverifiedDataId, userId, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of disverified datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the disverified datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the disverified datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByStatus(
		int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByStatus(
		int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByStatus_First(
			int status, OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByStatus_First(
		int status, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByStatus_Last(
			int status, OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByStatus_Last(
		int status, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByStatus_PrevAndNext(
			long disverifiedDataId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByStatus_PrevAndNext(
			disverifiedDataId, status, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of disverified datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByG_U_First(
			long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByG_U_PrevAndNext(
			long disverifiedDataId, long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByG_U_PrevAndNext(
			disverifiedDataId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	 * Returns the number of disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	 * Returns all the disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByG_S_First(
			long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByG_S_Last(
			long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByG_S_PrevAndNext(
			long disverifiedDataId, long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByG_S_PrevAndNext(
			disverifiedDataId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns all the disverified datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the disverified datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByU_S_First(
			long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByU_S_First(
		long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByU_S_Last(
			long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByU_S_PrevAndNext(
			long disverifiedDataId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByU_S_PrevAndNext(
			disverifiedDataId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of disverified datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByG_U_S_PrevAndNext(
			long disverifiedDataId, long groupId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByG_U_S_PrevAndNext(
			disverifiedDataId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns all the disverified datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByDataSetId(long dataSetId) {
		return getPersistence().findByDataSetId(dataSetId);
	}

	/**
	 * Returns a range of all the disverified datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataSetId(
		long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId(dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataSetId_First(
			long dataSetId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataSetId_First(
		long dataSetId, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataSetId_Last(
			long dataSetId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataSetId_Last(
		long dataSetId, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByDataSetId_PrevAndNext(
			long disverifiedDataId, long dataSetId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataSetId_PrevAndNext(
			disverifiedDataId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId(long dataSetId) {
		getPersistence().removeByDataSetId(dataSetId);
	}

	/**
	 * Returns the number of disverified datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching disverified datas
	 */
	public static int countByDataSetId(long dataSetId) {
		return getPersistence().countByDataSetId(dataSetId);
	}

	/**
	 * Returns all the disverified datas where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByFolderId(long folderId) {
		return getPersistence().findByFolderId(folderId);
	}

	/**
	 * Returns a range of all the disverified datas where folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param folderId the folder ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByFolderId(
		long folderId, int start, int end) {

		return getPersistence().findByFolderId(folderId, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param folderId the folder ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByFolderId(
		long folderId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByFolderId(
			folderId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param folderId the folder ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByFolderId(
		long folderId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFolderId(
			folderId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByFolderId_First(
			long folderId, OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByFolderId_First(
			folderId, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByFolderId_First(
		long folderId, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByFolderId_First(
			folderId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByFolderId_Last(
			long folderId, OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByFolderId_Last(
			folderId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByFolderId_Last(
		long folderId, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByFolderId_Last(
			folderId, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByFolderId_PrevAndNext(
			long disverifiedDataId, long folderId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByFolderId_PrevAndNext(
			disverifiedDataId, folderId, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where folderId = &#63; from the database.
	 *
	 * @param folderId the folder ID
	 */
	public static void removeByFolderId(long folderId) {
		getPersistence().removeByFolderId(folderId);
	}

	/**
	 * Returns the number of disverified datas where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @return the number of matching disverified datas
	 */
	public static int countByFolderId(long folderId) {
		return getPersistence().countByFolderId(folderId);
	}

	/**
	 * Returns all the disverified datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId(long dataTypeId) {
		return getPersistence().findByDataTypeId(dataTypeId);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return getPersistence().findByDataTypeId(dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_First(
			long dataTypeId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_First(
		long dataTypeId, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_Last(
			long dataTypeId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_Last(
		long dataTypeId, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByDataTypeId_PrevAndNext(
			long disverifiedDataId, long dataTypeId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_PrevAndNext(
			disverifiedDataId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public static void removeByDataTypeId(long dataTypeId) {
		getPersistence().removeByDataTypeId(dataTypeId);
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching disverified datas
	 */
	public static int countByDataTypeId(long dataTypeId) {
		return getPersistence().countByDataTypeId(dataTypeId);
	}

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId) {

		return getPersistence().findByDataTypeId_G(dataTypeId, groupId);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end) {

		return getPersistence().findByDataTypeId_G(
			dataTypeId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByDataTypeId_G(
			dataTypeId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G(
			dataTypeId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_G_First(
			long dataTypeId, long groupId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_First(
			dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_G_First(
		long dataTypeId, long groupId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_First(
			dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_G_Last(
			long dataTypeId, long groupId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_Last(
			dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_G_Last(
		long dataTypeId, long groupId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_Last(
			dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByDataTypeId_G_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_PrevAndNext(
			disverifiedDataId, dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 */
	public static void removeByDataTypeId_G(long dataTypeId, long groupId) {
		getPersistence().removeByDataTypeId_G(dataTypeId, groupId);
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the number of matching disverified datas
	 */
	public static int countByDataTypeId_G(long dataTypeId, long groupId) {
		return getPersistence().countByDataTypeId_G(dataTypeId, groupId);
	}

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId) {

		return getPersistence().findByDataTypeId_U(dataTypeId, userId);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end) {

		return getPersistence().findByDataTypeId_U(
			dataTypeId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByDataTypeId_U(
			dataTypeId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_U(
			dataTypeId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_U_First(
			long dataTypeId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_U_First(
			dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_U_First(
		long dataTypeId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_First(
			dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_U_Last(
			long dataTypeId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_U_Last(
			dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_U_Last(
		long dataTypeId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_Last(
			dataTypeId, userId, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByDataTypeId_U_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_U_PrevAndNext(
			disverifiedDataId, dataTypeId, userId, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 */
	public static void removeByDataTypeId_U(long dataTypeId, long userId) {
		getPersistence().removeByDataTypeId_U(dataTypeId, userId);
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	public static int countByDataTypeId_U(long dataTypeId, long userId) {
		return getPersistence().countByDataTypeId_U(dataTypeId, userId);
	}

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status) {

		return getPersistence().findByDataTypeId_S(dataTypeId, status);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end) {

		return getPersistence().findByDataTypeId_S(
			dataTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByDataTypeId_S(
			dataTypeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_S(
			dataTypeId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_S_First(
			long dataTypeId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_S_First(
			dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_S_First(
		long dataTypeId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_S_First(
			dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_S_Last(
			long dataTypeId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_S_Last(
			dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_S_Last(
		long dataTypeId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_S_Last(
			dataTypeId, status, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByDataTypeId_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_S_PrevAndNext(
			disverifiedDataId, dataTypeId, status, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public static void removeByDataTypeId_S(long dataTypeId, int status) {
		getPersistence().removeByDataTypeId_S(dataTypeId, status);
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public static int countByDataTypeId_S(long dataTypeId, int status) {
		return getPersistence().countByDataTypeId_S(dataTypeId, status);
	}

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId) {

		return getPersistence().findByDataTypeId_G_U(
			dataTypeId, groupId, userId);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end) {

		return getPersistence().findByDataTypeId_G_U(
			dataTypeId, groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByDataTypeId_G_U(
			dataTypeId, groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G_U(
			dataTypeId, groupId, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_G_U_First(
			long dataTypeId, long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_U_First(
			dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_G_U_First(
		long dataTypeId, long groupId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_First(
			dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_G_U_Last(
			long dataTypeId, long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_U_Last(
			dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_G_U_Last(
		long dataTypeId, long groupId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_Last(
			dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByDataTypeId_G_U_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_U_PrevAndNext(
			disverifiedDataId, dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; from the database.
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
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	public static int countByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId) {

		return getPersistence().countByDataTypeId_G_U(
			dataTypeId, groupId, userId);
	}

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status) {

		return getPersistence().findByDataTypeId_G_S(
			dataTypeId, groupId, status);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end) {

		return getPersistence().findByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_G_S_First(
			long dataTypeId, long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_S_First(
			dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_G_S_First(
		long dataTypeId, long groupId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_S_First(
			dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_G_S_Last(
			long dataTypeId, long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_S_Last(
			dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_G_S_Last(
		long dataTypeId, long groupId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_S_Last(
			dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByDataTypeId_G_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_S_PrevAndNext(
			disverifiedDataId, dataTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63; from the database.
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
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public static int countByDataTypeId_G_S(
		long dataTypeId, long groupId, int status) {

		return getPersistence().countByDataTypeId_G_S(
			dataTypeId, groupId, status);
	}

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status) {

		return getPersistence().findByDataTypeId_U_S(
			dataTypeId, userId, status);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end) {

		return getPersistence().findByDataTypeId_U_S(
			dataTypeId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByDataTypeId_U_S(
			dataTypeId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_U_S(
			dataTypeId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_U_S_First(
			long dataTypeId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_U_S_First(
			dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_U_S_First(
		long dataTypeId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_S_First(
			dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_U_S_Last(
			long dataTypeId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_U_S_Last(
			dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_U_S_Last(
		long dataTypeId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_U_S_Last(
			dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByDataTypeId_U_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_U_S_PrevAndNext(
			disverifiedDataId, dataTypeId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63; from the database.
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
	 * Returns the number of disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public static int countByDataTypeId_U_S(
		long dataTypeId, long userId, int status) {

		return getPersistence().countByDataTypeId_U_S(
			dataTypeId, userId, status);
	}

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status) {

		return getPersistence().findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end) {

		return getPersistence().findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	public static List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_G_U_S_First(
			long dataTypeId, long groupId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_U_S_First(
			dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_G_U_S_First(
		long dataTypeId, long groupId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_S_First(
			dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public static DisverifiedData findByDataTypeId_G_U_S_Last(
			long dataTypeId, long groupId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_U_S_Last(
			dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public static DisverifiedData fetchByDataTypeId_G_U_S_Last(
		long dataTypeId, long groupId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_G_U_S_Last(
			dataTypeId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData[] findByDataTypeId_G_U_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId, long userId,
			int status, OrderByComparator<DisverifiedData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByDataTypeId_G_U_S_PrevAndNext(
			disverifiedDataId, dataTypeId, groupId, userId, status,
			orderByComparator);
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63; from the database.
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
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public static int countByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status) {

		return getPersistence().countByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status);
	}

	/**
	 * Caches the disverified data in the entity cache if it is enabled.
	 *
	 * @param disverifiedData the disverified data
	 */
	public static void cacheResult(DisverifiedData disverifiedData) {
		getPersistence().cacheResult(disverifiedData);
	}

	/**
	 * Caches the disverified datas in the entity cache if it is enabled.
	 *
	 * @param disverifiedDatas the disverified datas
	 */
	public static void cacheResult(List<DisverifiedData> disverifiedDatas) {
		getPersistence().cacheResult(disverifiedDatas);
	}

	/**
	 * Creates a new disverified data with the primary key. Does not add the disverified data to the database.
	 *
	 * @param disverifiedDataId the primary key for the new disverified data
	 * @return the new disverified data
	 */
	public static DisverifiedData create(long disverifiedDataId) {
		return getPersistence().create(disverifiedDataId);
	}

	/**
	 * Removes the disverified data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param disverifiedDataId the primary key of the disverified data
	 * @return the disverified data that was removed
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData remove(long disverifiedDataId)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().remove(disverifiedDataId);
	}

	public static DisverifiedData updateImpl(DisverifiedData disverifiedData) {
		return getPersistence().updateImpl(disverifiedData);
	}

	/**
	 * Returns the disverified data with the primary key or throws a <code>NoSuchDisverifiedDataException</code> if it could not be found.
	 *
	 * @param disverifiedDataId the primary key of the disverified data
	 * @return the disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData findByPrimaryKey(long disverifiedDataId)
		throws com.sx.icecap.exception.NoSuchDisverifiedDataException {

		return getPersistence().findByPrimaryKey(disverifiedDataId);
	}

	/**
	 * Returns the disverified data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param disverifiedDataId the primary key of the disverified data
	 * @return the disverified data, or <code>null</code> if a disverified data with the primary key could not be found
	 */
	public static DisverifiedData fetchByPrimaryKey(long disverifiedDataId) {
		return getPersistence().fetchByPrimaryKey(disverifiedDataId);
	}

	/**
	 * Returns all the disverified datas.
	 *
	 * @return the disverified datas
	 */
	public static List<DisverifiedData> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the disverified datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of disverified datas
	 */
	public static List<DisverifiedData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the disverified datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of disverified datas
	 */
	public static List<DisverifiedData> findAll(
		int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the disverified datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of disverified datas
	 */
	public static List<DisverifiedData> findAll(
		int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the disverified datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of disverified datas.
	 *
	 * @return the number of disverified datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DisverifiedDataPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DisverifiedDataPersistence _persistence;

}