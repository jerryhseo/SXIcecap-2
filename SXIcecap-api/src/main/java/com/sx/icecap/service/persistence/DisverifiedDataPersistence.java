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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sx.icecap.exception.NoSuchDisverifiedDataException;
import com.sx.icecap.model.DisverifiedData;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the disverified data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DisverifiedDataUtil
 * @generated
 */
@ProviderType
public interface DisverifiedDataPersistence
	extends BasePersistence<DisverifiedData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DisverifiedDataUtil} to access the disverified data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the disverified datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByGroupId(long groupId);

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
	public java.util.List<DisverifiedData> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<DisverifiedData> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public DisverifiedData[] findByGroupId_PrevAndNext(
			long disverifiedDataId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of disverified datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching disverified datas
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the disverified datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByUserId(long userId);

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
	public java.util.List<DisverifiedData> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<DisverifiedData> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where userId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public DisverifiedData[] findByUserId_PrevAndNext(
			long disverifiedDataId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of disverified datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the disverified datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByStatus(int status);

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
	public java.util.List<DisverifiedData> findByStatus(
		int status, int start, int end);

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
	public java.util.List<DisverifiedData> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public DisverifiedData[] findByStatus_PrevAndNext(
			long disverifiedDataId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of disverified datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByG_U(long groupId, long userId);

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
	public java.util.List<DisverifiedData> findByG_U(
		long groupId, long userId, int start, int end);

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
	public java.util.List<DisverifiedData> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByG_U_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByG_U_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData[] findByG_U_PrevAndNext(
			long disverifiedDataId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByG_U(long groupId, long userId);

	/**
	 * Returns the number of disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	public int countByG_U(long groupId, long userId);

	/**
	 * Returns all the disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByG_S(long groupId, int status);

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
	public java.util.List<DisverifiedData> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<DisverifiedData> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData[] findByG_S_PrevAndNext(
			long disverifiedDataId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns all the disverified datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByU_S(long userId, int status);

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
	public java.util.List<DisverifiedData> findByU_S(
		long userId, int status, int start, int end);

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
	public java.util.List<DisverifiedData> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData[] findByU_S_PrevAndNext(
			long disverifiedDataId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of disverified datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

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
	public DisverifiedData findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData[] findByG_U_S_PrevAndNext(
			long disverifiedDataId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns all the disverified datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByDataSetId(long dataSetId);

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
	public java.util.List<DisverifiedData> findByDataSetId(
		long dataSetId, int start, int end);

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
	public java.util.List<DisverifiedData> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByDataSetId_First(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataSetId_First(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByDataSetId_Last(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataSetId_Last(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public DisverifiedData[] findByDataSetId_PrevAndNext(
			long disverifiedDataId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public void removeByDataSetId(long dataSetId);

	/**
	 * Returns the number of disverified datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching disverified datas
	 */
	public int countByDataSetId(long dataSetId);

	/**
	 * Returns all the disverified datas where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByFolderId(long folderId);

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
	public java.util.List<DisverifiedData> findByFolderId(
		long folderId, int start, int end);

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
	public java.util.List<DisverifiedData> findByFolderId(
		long folderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByFolderId(
		long folderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByFolderId_First(
			long folderId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByFolderId_First(
		long folderId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByFolderId_Last(
			long folderId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByFolderId_Last(
		long folderId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public DisverifiedData[] findByFolderId_PrevAndNext(
			long disverifiedDataId, long folderId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where folderId = &#63; from the database.
	 *
	 * @param folderId the folder ID
	 */
	public void removeByFolderId(long folderId);

	/**
	 * Returns the number of disverified datas where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @return the number of matching disverified datas
	 */
	public int countByFolderId(long folderId);

	/**
	 * Returns all the disverified datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByDataTypeId(long dataTypeId);

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
	public java.util.List<DisverifiedData> findByDataTypeId(
		long dataTypeId, int start, int end);

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
	public java.util.List<DisverifiedData> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByDataTypeId_First(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_First(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByDataTypeId_Last(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_Last(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public DisverifiedData[] findByDataTypeId_PrevAndNext(
			long disverifiedDataId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public void removeByDataTypeId(long dataTypeId);

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching disverified datas
	 */
	public int countByDataTypeId(long dataTypeId);

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByDataTypeId_G_First(
			long dataTypeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_G_First(
		long dataTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByDataTypeId_G_Last(
			long dataTypeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_G_Last(
		long dataTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData[] findByDataTypeId_G_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 */
	public void removeByDataTypeId_G(long dataTypeId, long groupId);

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the number of matching disverified datas
	 */
	public int countByDataTypeId_G(long dataTypeId, long groupId);

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId);

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
	public java.util.List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end);

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
	public java.util.List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByDataTypeId_U_First(
			long dataTypeId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_U_First(
		long dataTypeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByDataTypeId_U_Last(
			long dataTypeId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_U_Last(
		long dataTypeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData[] findByDataTypeId_U_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 */
	public void removeByDataTypeId_U(long dataTypeId, long userId);

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	public int countByDataTypeId_U(long dataTypeId, long userId);

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status);

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
	public java.util.List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end);

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
	public java.util.List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByDataTypeId_S_First(
			long dataTypeId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_S_First(
		long dataTypeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	public DisverifiedData findByDataTypeId_S_Last(
			long dataTypeId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_S_Last(
		long dataTypeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData[] findByDataTypeId_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	public void removeByDataTypeId_S(long dataTypeId, int status);

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public int countByDataTypeId_S(long dataTypeId, int status);

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

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
	public DisverifiedData findByDataTypeId_G_U_First(
			long dataTypeId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_G_U_First(
		long dataTypeId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData findByDataTypeId_G_U_Last(
			long dataTypeId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_G_U_Last(
		long dataTypeId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData[] findByDataTypeId_G_U_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId);

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	public int countByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId);

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

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
	public DisverifiedData findByDataTypeId_G_S_First(
			long dataTypeId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_G_S_First(
		long dataTypeId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData findByDataTypeId_G_S_Last(
			long dataTypeId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_G_S_Last(
		long dataTypeId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData[] findByDataTypeId_G_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByDataTypeId_G_S(
		long dataTypeId, long groupId, int status);

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public int countByDataTypeId_G_S(long dataTypeId, long groupId, int status);

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status);

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
	public java.util.List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end);

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
	public java.util.List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

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
	public DisverifiedData findByDataTypeId_U_S_First(
			long dataTypeId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_U_S_First(
		long dataTypeId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData findByDataTypeId_U_S_Last(
			long dataTypeId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	public DisverifiedData fetchByDataTypeId_U_S_Last(
		long dataTypeId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData[] findByDataTypeId_U_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByDataTypeId_U_S(
		long dataTypeId, long userId, int status);

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public int countByDataTypeId_U_S(long dataTypeId, long userId, int status);

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	public java.util.List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

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
	public DisverifiedData findByDataTypeId_G_U_S_First(
			long dataTypeId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

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
	public DisverifiedData fetchByDataTypeId_G_U_S_First(
		long dataTypeId, long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData findByDataTypeId_G_U_S_Last(
			long dataTypeId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

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
	public DisverifiedData fetchByDataTypeId_G_U_S_Last(
		long dataTypeId, long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public DisverifiedData[] findByDataTypeId_G_U_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId, long userId,
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
				orderByComparator)
		throws NoSuchDisverifiedDataException;

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status);

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	public int countByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status);

	/**
	 * Caches the disverified data in the entity cache if it is enabled.
	 *
	 * @param disverifiedData the disverified data
	 */
	public void cacheResult(DisverifiedData disverifiedData);

	/**
	 * Caches the disverified datas in the entity cache if it is enabled.
	 *
	 * @param disverifiedDatas the disverified datas
	 */
	public void cacheResult(java.util.List<DisverifiedData> disverifiedDatas);

	/**
	 * Creates a new disverified data with the primary key. Does not add the disverified data to the database.
	 *
	 * @param disverifiedDataId the primary key for the new disverified data
	 * @return the new disverified data
	 */
	public DisverifiedData create(long disverifiedDataId);

	/**
	 * Removes the disverified data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param disverifiedDataId the primary key of the disverified data
	 * @return the disverified data that was removed
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public DisverifiedData remove(long disverifiedDataId)
		throws NoSuchDisverifiedDataException;

	public DisverifiedData updateImpl(DisverifiedData disverifiedData);

	/**
	 * Returns the disverified data with the primary key or throws a <code>NoSuchDisverifiedDataException</code> if it could not be found.
	 *
	 * @param disverifiedDataId the primary key of the disverified data
	 * @return the disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	public DisverifiedData findByPrimaryKey(long disverifiedDataId)
		throws NoSuchDisverifiedDataException;

	/**
	 * Returns the disverified data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param disverifiedDataId the primary key of the disverified data
	 * @return the disverified data, or <code>null</code> if a disverified data with the primary key could not be found
	 */
	public DisverifiedData fetchByPrimaryKey(long disverifiedDataId);

	/**
	 * Returns all the disverified datas.
	 *
	 * @return the disverified datas
	 */
	public java.util.List<DisverifiedData> findAll();

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
	public java.util.List<DisverifiedData> findAll(int start, int end);

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
	public java.util.List<DisverifiedData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator);

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
	public java.util.List<DisverifiedData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DisverifiedData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the disverified datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of disverified datas.
	 *
	 * @return the number of disverified datas
	 */
	public int countAll();

}