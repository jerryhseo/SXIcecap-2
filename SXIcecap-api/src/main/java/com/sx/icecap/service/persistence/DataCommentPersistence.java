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

import com.sx.icecap.exception.NoSuchDataCommentException;
import com.sx.icecap.model.DataComment;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataCommentUtil
 * @generated
 */
@ProviderType
public interface DataCommentPersistence extends BasePersistence<DataComment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataCommentUtil} to access the data comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByUuid(String uuid);

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
	public java.util.List<DataComment> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<DataComment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where uuid = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByUuid_PrevAndNext(
			long dataCommentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of data comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data comments
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the data comment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataCommentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByUUID_G(String uuid, long groupId)
		throws NoSuchDataCommentException;

	/**
	 * Returns the data comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the data comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the data comment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data comment that was removed
	 */
	public DataComment removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataCommentException;

	/**
	 * Returns the number of data comments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data comments
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the data comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<DataComment> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<DataComment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] findByUuid_C_PrevAndNext(
			long dataCommentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of data comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data comments
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the data comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByGroupId(long groupId);

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
	public java.util.List<DataComment> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<DataComment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByGroupId_PrevAndNext(
			long dataCommentId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns all the data comments that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data comments that the user has permission to view
	 */
	public java.util.List<DataComment> filterFindByGroupId(long groupId);

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
	public java.util.List<DataComment> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<DataComment> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set of data comments that the user has permission to view where groupId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] filterFindByGroupId_PrevAndNext(
			long dataCommentId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of data comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data comments
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of data comments that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data comments that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the data comments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByUserId(long userId);

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
	public java.util.List<DataComment> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<DataComment> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where userId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByUserId_PrevAndNext(
			long dataCommentId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of data comments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data comments
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the data comments where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByStatus(int status);

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
	public java.util.List<DataComment> findByStatus(
		int status, int start, int end);

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
	public java.util.List<DataComment> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where status = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByStatus_PrevAndNext(
			long dataCommentId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of data comments where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data comments
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the data comments where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByG_U(long groupId, long userId);

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
	public java.util.List<DataComment> findByG_U(
		long groupId, long userId, int start, int end);

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
	public java.util.List<DataComment> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByG_U_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByG_U_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] findByG_U_PrevAndNext(
			long dataCommentId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns all the data comments that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data comments that the user has permission to view
	 */
	public java.util.List<DataComment> filterFindByG_U(
		long groupId, long userId);

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
	public java.util.List<DataComment> filterFindByG_U(
		long groupId, long userId, int start, int end);

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
	public java.util.List<DataComment> filterFindByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] filterFindByG_U_PrevAndNext(
			long dataCommentId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByG_U(long groupId, long userId);

	/**
	 * Returns the number of data comments where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data comments
	 */
	public int countByG_U(long groupId, long userId);

	/**
	 * Returns the number of data comments that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data comments that the user has permission to view
	 */
	public int filterCountByG_U(long groupId, long userId);

	/**
	 * Returns all the data comments where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByG_S(long groupId, int status);

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
	public java.util.List<DataComment> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<DataComment> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] findByG_S_PrevAndNext(
			long dataCommentId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns all the data comments that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data comments that the user has permission to view
	 */
	public java.util.List<DataComment> filterFindByG_S(
		long groupId, int status);

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
	public java.util.List<DataComment> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<DataComment> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] filterFindByG_S_PrevAndNext(
			long dataCommentId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of data comments where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data comments
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of data comments that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data comments that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns all the data comments where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByU_S(long userId, int status);

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
	public java.util.List<DataComment> findByU_S(
		long userId, int status, int start, int end);

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
	public java.util.List<DataComment> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] findByU_S_PrevAndNext(
			long dataCommentId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of data comments where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data comments
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns all the data comments where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<DataComment> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<DataComment> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

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
	public DataComment findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] findByG_U_S_PrevAndNext(
			long dataCommentId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns all the data comments that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data comments that the user has permission to view
	 */
	public java.util.List<DataComment> filterFindByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<DataComment> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<DataComment> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] filterFindByG_U_S_PrevAndNext(
			long dataCommentId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of data comments where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data comments
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of data comments that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data comments that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns all the data comments where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByDataId(
		String commentModel, long dataId);

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
	public java.util.List<DataComment> findByDataId(
		String commentModel, long dataId, int start, int end);

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
	public java.util.List<DataComment> findByDataId(
		String commentModel, long dataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByDataId(
		String commentModel, long dataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByDataId_First(
			String commentModel, long dataId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByDataId_First(
		String commentModel, long dataId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByDataId_Last(
			String commentModel, long dataId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByDataId_Last(
		String commentModel, long dataId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] findByDataId_PrevAndNext(
			long dataCommentId, String commentModel, long dataId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where commentModel = &#63; and dataId = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 */
	public void removeByDataId(String commentModel, long dataId);

	/**
	 * Returns the number of data comments where commentModel = &#63; and dataId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @return the number of matching data comments
	 */
	public int countByDataId(String commentModel, long dataId);

	/**
	 * Returns all the data comments where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByParamCode(
		String commentModel, long dataId, String paramCode);

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
	public java.util.List<DataComment> findByParamCode(
		String commentModel, long dataId, String paramCode, int start, int end);

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
	public java.util.List<DataComment> findByParamCode(
		String commentModel, long dataId, String paramCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByParamCode(
		String commentModel, long dataId, String paramCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

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
	public DataComment findByParamCode_First(
			String commentModel, long dataId, String paramCode,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByParamCode_First(
		String commentModel, long dataId, String paramCode,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment findByParamCode_Last(
			String commentModel, long dataId, String paramCode,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByParamCode_Last(
		String commentModel, long dataId, String paramCode,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] findByParamCode_PrevAndNext(
			long dataCommentId, String commentModel, long dataId,
			String paramCode,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where commentModel = &#63; and dataId = &#63; and paramCode = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 */
	public void removeByParamCode(
		String commentModel, long dataId, String paramCode);

	/**
	 * Returns the number of data comments where commentModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @return the number of matching data comments
	 */
	public int countByParamCode(
		String commentModel, long dataId, String paramCode);

	/**
	 * Returns all the data comments where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByModel(String commentModel);

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
	public java.util.List<DataComment> findByModel(
		String commentModel, int start, int end);

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
	public java.util.List<DataComment> findByModel(
		String commentModel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByModel(
		String commentModel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModel_First(
			String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModel_First(
		String commentModel,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModel_Last(
			String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModel_Last(
		String commentModel,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByModel_PrevAndNext(
			long dataCommentId, String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where commentModel = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 */
	public void removeByModel(String commentModel);

	/**
	 * Returns the number of data comments where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @return the number of matching data comments
	 */
	public int countByModel(String commentModel);

	/**
	 * Returns all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByModel_G(
		long groupId, String commentModel);

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
	public java.util.List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end);

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
	public java.util.List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModel_G_First(
			long groupId, String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModel_G_First(
		long groupId, String commentModel,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModel_G_Last(
			long groupId, String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModel_G_Last(
		long groupId, String commentModel,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] findByModel_G_PrevAndNext(
			long dataCommentId, long groupId, String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns all the data comments that the user has permission to view where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the matching data comments that the user has permission to view
	 */
	public java.util.List<DataComment> filterFindByModel_G(
		long groupId, String commentModel);

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
	public java.util.List<DataComment> filterFindByModel_G(
		long groupId, String commentModel, int start, int end);

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
	public java.util.List<DataComment> filterFindByModel_G(
		long groupId, String commentModel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public DataComment[] filterFindByModel_G_PrevAndNext(
			long dataCommentId, long groupId, String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where groupId = &#63; and commentModel = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 */
	public void removeByModel_G(long groupId, String commentModel);

	/**
	 * Returns the number of data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the number of matching data comments
	 */
	public int countByModel_G(long groupId, String commentModel);

	/**
	 * Returns the number of data comments that the user has permission to view where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the number of matching data comments that the user has permission to view
	 */
	public int filterCountByModel_G(long groupId, String commentModel);

	/**
	 * Caches the data comment in the entity cache if it is enabled.
	 *
	 * @param dataComment the data comment
	 */
	public void cacheResult(DataComment dataComment);

	/**
	 * Caches the data comments in the entity cache if it is enabled.
	 *
	 * @param dataComments the data comments
	 */
	public void cacheResult(java.util.List<DataComment> dataComments);

	/**
	 * Creates a new data comment with the primary key. Does not add the data comment to the database.
	 *
	 * @param dataCommentId the primary key for the new data comment
	 * @return the new data comment
	 */
	public DataComment create(long dataCommentId);

	/**
	 * Removes the data comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment that was removed
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment remove(long dataCommentId)
		throws NoSuchDataCommentException;

	public DataComment updateImpl(DataComment dataComment);

	/**
	 * Returns the data comment with the primary key or throws a <code>NoSuchDataCommentException</code> if it could not be found.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment findByPrimaryKey(long dataCommentId)
		throws NoSuchDataCommentException;

	/**
	 * Returns the data comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment, or <code>null</code> if a data comment with the primary key could not be found
	 */
	public DataComment fetchByPrimaryKey(long dataCommentId);

	/**
	 * Returns all the data comments.
	 *
	 * @return the data comments
	 */
	public java.util.List<DataComment> findAll();

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
	public java.util.List<DataComment> findAll(int start, int end);

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
	public java.util.List<DataComment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

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
	public java.util.List<DataComment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data comments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data comments.
	 *
	 * @return the number of data comments
	 */
	public int countAll();

}