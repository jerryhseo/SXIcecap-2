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

import com.sx.icecap.exception.NoSuchDataCollectionException;
import com.sx.icecap.model.DataCollection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataCollectionUtil
 * @generated
 */
@ProviderType
public interface DataCollectionPersistence
	extends BasePersistence<DataCollection> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataCollectionUtil} to access the data collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data collections where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data collections
	 */
	public java.util.List<DataCollection> findByUuid(String uuid);

	/**
	 * Returns a range of all the data collections where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	public java.util.List<DataCollection> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the data collections where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data collections where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the first data collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the last data collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the last data collection in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where uuid = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] findByUuid_PrevAndNext(
			long dataCollectionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Removes all the data collections where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of data collections where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data collections
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the data collection where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataCollectionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByUUID_G(String uuid, long groupId)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the data collection where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the data collection where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the data collection where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data collection that was removed
	 */
	public DataCollection removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the number of data collections where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data collections
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the data collections where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data collections
	 */
	public java.util.List<DataCollection> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the data collections where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	public java.util.List<DataCollection> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the data collections where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data collections where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the first data collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the last data collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the last data collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] findByUuid_C_PrevAndNext(
			long dataCollectionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Removes all the data collections where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of data collections where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data collections
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the data collections where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data collections
	 */
	public java.util.List<DataCollection> findByGroupId(long groupId);

	/**
	 * Returns a range of all the data collections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	public java.util.List<DataCollection> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where groupId = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] findByGroupId_PrevAndNext(
			long dataCollectionId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns all the data collections that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the data collections that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the data collections that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set of data collections that the user has permission to view where groupId = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] filterFindByGroupId_PrevAndNext(
			long dataCollectionId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Removes all the data collections where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of data collections where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data collections
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of data collections that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data collections that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the data collections where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data collections
	 */
	public java.util.List<DataCollection> findByUserId(long userId);

	/**
	 * Returns a range of all the data collections where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	public java.util.List<DataCollection> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the data collections where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data collections where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data collection in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the first data collection in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the last data collection in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the last data collection in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where userId = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] findByUserId_PrevAndNext(
			long dataCollectionId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Removes all the data collections where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of data collections where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data collections
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the data collections where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data collections
	 */
	public java.util.List<DataCollection> findByStatus(int status);

	/**
	 * Returns a range of all the data collections where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	public java.util.List<DataCollection> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the data collections where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data collections where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data collection in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the first data collection in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the last data collection in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the last data collection in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where status = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] findByStatus_PrevAndNext(
			long dataCollectionId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Removes all the data collections where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of data collections where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data collections
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the data collections where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data collections
	 */
	public java.util.List<DataCollection> findByG_U(long groupId, long userId);

	/**
	 * Returns a range of all the data collections where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	public java.util.List<DataCollection> findByG_U(
		long groupId, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByG_U_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByG_U_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] findByG_U_PrevAndNext(
			long dataCollectionId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns all the data collections that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByG_U(
		long groupId, long userId);

	/**
	 * Returns a range of all the data collections that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByG_U(
		long groupId, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the data collections that the user has permissions to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set of data collections that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] filterFindByG_U_PrevAndNext(
			long dataCollectionId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Removes all the data collections where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByG_U(long groupId, long userId);

	/**
	 * Returns the number of data collections where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data collections
	 */
	public int countByG_U(long groupId, long userId);

	/**
	 * Returns the number of data collections that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data collections that the user has permission to view
	 */
	public int filterCountByG_U(long groupId, long userId);

	/**
	 * Returns all the data collections where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data collections
	 */
	public java.util.List<DataCollection> findByG_S(long groupId, int status);

	/**
	 * Returns a range of all the data collections where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	public java.util.List<DataCollection> findByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] findByG_S_PrevAndNext(
			long dataCollectionId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns all the data collections that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByG_S(
		long groupId, int status);

	/**
	 * Returns a range of all the data collections that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the data collections that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set of data collections that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] filterFindByG_S_PrevAndNext(
			long dataCollectionId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Removes all the data collections where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of data collections where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data collections
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of data collections that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data collections that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns all the data collections where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data collections
	 */
	public java.util.List<DataCollection> findByU_S(long userId, int status);

	/**
	 * Returns a range of all the data collections where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	public java.util.List<DataCollection> findByU_S(
		long userId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the data collections where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data collections where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data collection in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the first data collection in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the last data collection in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the last data collection in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] findByU_S_PrevAndNext(
			long dataCollectionId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Removes all the data collections where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of data collections where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data collections
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns all the data collections where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data collections
	 */
	public java.util.List<DataCollection> findByG_U_S(
		long groupId, long userId, int status);

	/**
	 * Returns a range of all the data collections where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	public java.util.List<DataCollection> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data collections where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the first data collection in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the last data collection in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] findByG_U_S_PrevAndNext(
			long dataCollectionId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns all the data collections that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByG_U_S(
		long groupId, long userId, int status);

	/**
	 * Returns a range of all the data collections that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the data collections that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections that the user has permission to view
	 */
	public java.util.List<DataCollection> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set of data collections that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] filterFindByG_U_S_PrevAndNext(
			long dataCollectionId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Removes all the data collections where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of data collections where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data collections
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of data collections that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data collections that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns all the data collections where dataCollectionName = &#63;.
	 *
	 * @param dataCollectionName the data collection name
	 * @return the matching data collections
	 */
	public java.util.List<DataCollection> findByName(String dataCollectionName);

	/**
	 * Returns a range of all the data collections where dataCollectionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionName the data collection name
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of matching data collections
	 */
	public java.util.List<DataCollection> findByName(
		String dataCollectionName, int start, int end);

	/**
	 * Returns an ordered range of all the data collections where dataCollectionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionName the data collection name
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByName(
		String dataCollectionName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data collections where dataCollectionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionName the data collection name
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data collections
	 */
	public java.util.List<DataCollection> findByName(
		String dataCollectionName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data collection in the ordered set where dataCollectionName = &#63;.
	 *
	 * @param dataCollectionName the data collection name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByName_First(
			String dataCollectionName,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the first data collection in the ordered set where dataCollectionName = &#63;.
	 *
	 * @param dataCollectionName the data collection name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByName_First(
		String dataCollectionName,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the last data collection in the ordered set where dataCollectionName = &#63;.
	 *
	 * @param dataCollectionName the data collection name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection
	 * @throws NoSuchDataCollectionException if a matching data collection could not be found
	 */
	public DataCollection findByName_Last(
			String dataCollectionName,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the last data collection in the ordered set where dataCollectionName = &#63;.
	 *
	 * @param dataCollectionName the data collection name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data collection, or <code>null</code> if a matching data collection could not be found
	 */
	public DataCollection fetchByName_Last(
		String dataCollectionName,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns the data collections before and after the current data collection in the ordered set where dataCollectionName = &#63;.
	 *
	 * @param dataCollectionId the primary key of the current data collection
	 * @param dataCollectionName the data collection name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection[] findByName_PrevAndNext(
			long dataCollectionId, String dataCollectionName,
			com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
				orderByComparator)
		throws NoSuchDataCollectionException;

	/**
	 * Removes all the data collections where dataCollectionName = &#63; from the database.
	 *
	 * @param dataCollectionName the data collection name
	 */
	public void removeByName(String dataCollectionName);

	/**
	 * Returns the number of data collections where dataCollectionName = &#63;.
	 *
	 * @param dataCollectionName the data collection name
	 * @return the number of matching data collections
	 */
	public int countByName(String dataCollectionName);

	/**
	 * Caches the data collection in the entity cache if it is enabled.
	 *
	 * @param dataCollection the data collection
	 */
	public void cacheResult(DataCollection dataCollection);

	/**
	 * Caches the data collections in the entity cache if it is enabled.
	 *
	 * @param dataCollections the data collections
	 */
	public void cacheResult(java.util.List<DataCollection> dataCollections);

	/**
	 * Creates a new data collection with the primary key. Does not add the data collection to the database.
	 *
	 * @param dataCollectionId the primary key for the new data collection
	 * @return the new data collection
	 */
	public DataCollection create(long dataCollectionId);

	/**
	 * Removes the data collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection that was removed
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection remove(long dataCollectionId)
		throws NoSuchDataCollectionException;

	public DataCollection updateImpl(DataCollection dataCollection);

	/**
	 * Returns the data collection with the primary key or throws a <code>NoSuchDataCollectionException</code> if it could not be found.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection
	 * @throws NoSuchDataCollectionException if a data collection with the primary key could not be found
	 */
	public DataCollection findByPrimaryKey(long dataCollectionId)
		throws NoSuchDataCollectionException;

	/**
	 * Returns the data collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataCollectionId the primary key of the data collection
	 * @return the data collection, or <code>null</code> if a data collection with the primary key could not be found
	 */
	public DataCollection fetchByPrimaryKey(long dataCollectionId);

	/**
	 * Returns all the data collections.
	 *
	 * @return the data collections
	 */
	public java.util.List<DataCollection> findAll();

	/**
	 * Returns a range of all the data collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @return the range of data collections
	 */
	public java.util.List<DataCollection> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data collections
	 */
	public java.util.List<DataCollection> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCollectionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data collections
	 * @param end the upper bound of the range of data collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data collections
	 */
	public java.util.List<DataCollection> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataCollection>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data collections from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data collections.
	 *
	 * @return the number of data collections
	 */
	public int countAll();

}