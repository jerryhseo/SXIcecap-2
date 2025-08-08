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

import com.sx.icecap.exception.NoSuchDataStructureException;
import com.sx.icecap.model.DataStructure;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataStructureUtil
 * @generated
 */
@ProviderType
public interface DataStructurePersistence
	extends BasePersistence<DataStructure> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataStructureUtil} to access the data structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data structures where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data structures
	 */
	public java.util.List<DataStructure> findByUuid(String uuid);

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
	public java.util.List<DataStructure> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<DataStructure> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public java.util.List<DataStructure> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data structure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the first data structure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the last data structure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the last data structure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where uuid = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public DataStructure[] findByUuid_PrevAndNext(
			long dataStructureId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Removes all the data structures where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of data structures where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data structures
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the data structure where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataStructureException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByUUID_G(String uuid, long groupId)
		throws NoSuchDataStructureException;

	/**
	 * Returns the data structure where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the data structure where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the data structure where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data structure that was removed
	 */
	public DataStructure removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataStructureException;

	/**
	 * Returns the number of data structures where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data structures
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the data structures where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data structures
	 */
	public java.util.List<DataStructure> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<DataStructure> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<DataStructure> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public java.util.List<DataStructure> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data structure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the first data structure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the last data structure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the last data structure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public DataStructure[] findByUuid_C_PrevAndNext(
			long dataStructureId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Removes all the data structures where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of data structures where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data structures
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the data structures where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data structures
	 */
	public java.util.List<DataStructure> findByGroupId(long groupId);

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
	public java.util.List<DataStructure> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<DataStructure> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public java.util.List<DataStructure> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where groupId = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public DataStructure[] findByGroupId_PrevAndNext(
			long dataStructureId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns all the data structures that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data structures that the user has permission to view
	 */
	public java.util.List<DataStructure> filterFindByGroupId(long groupId);

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
	public java.util.List<DataStructure> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<DataStructure> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the data structures before and after the current data structure in the ordered set of data structures that the user has permission to view where groupId = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public DataStructure[] filterFindByGroupId_PrevAndNext(
			long dataStructureId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Removes all the data structures where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of data structures where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data structures
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of data structures that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data structures that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the data structures where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data structures
	 */
	public java.util.List<DataStructure> findByUserId(long userId);

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
	public java.util.List<DataStructure> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<DataStructure> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public java.util.List<DataStructure> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data structure in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the first data structure in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the last data structure in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the last data structure in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where userId = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public DataStructure[] findByUserId_PrevAndNext(
			long dataStructureId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Removes all the data structures where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of data structures where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data structures
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the data structures where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data structures
	 */
	public java.util.List<DataStructure> findByStatus(int status);

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
	public java.util.List<DataStructure> findByStatus(
		int status, int start, int end);

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
	public java.util.List<DataStructure> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public java.util.List<DataStructure> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data structure in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the first data structure in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the last data structure in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the last data structure in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where status = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public DataStructure[] findByStatus_PrevAndNext(
			long dataStructureId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Removes all the data structures where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of data structures where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data structures
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the data structures where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data structures
	 */
	public java.util.List<DataStructure> findByG_U(long groupId, long userId);

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
	public java.util.List<DataStructure> findByG_U(
		long groupId, long userId, int start, int end);

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
	public java.util.List<DataStructure> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public java.util.List<DataStructure> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByG_U_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByG_U_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public DataStructure[] findByG_U_PrevAndNext(
			long dataStructureId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns all the data structures that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data structures that the user has permission to view
	 */
	public java.util.List<DataStructure> filterFindByG_U(
		long groupId, long userId);

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
	public java.util.List<DataStructure> filterFindByG_U(
		long groupId, long userId, int start, int end);

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
	public java.util.List<DataStructure> filterFindByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public DataStructure[] filterFindByG_U_PrevAndNext(
			long dataStructureId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Removes all the data structures where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByG_U(long groupId, long userId);

	/**
	 * Returns the number of data structures where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data structures
	 */
	public int countByG_U(long groupId, long userId);

	/**
	 * Returns the number of data structures that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data structures that the user has permission to view
	 */
	public int filterCountByG_U(long groupId, long userId);

	/**
	 * Returns all the data structures where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data structures
	 */
	public java.util.List<DataStructure> findByG_S(long groupId, int status);

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
	public java.util.List<DataStructure> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<DataStructure> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public java.util.List<DataStructure> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public DataStructure[] findByG_S_PrevAndNext(
			long dataStructureId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns all the data structures that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data structures that the user has permission to view
	 */
	public java.util.List<DataStructure> filterFindByG_S(
		long groupId, int status);

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
	public java.util.List<DataStructure> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<DataStructure> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public DataStructure[] filterFindByG_S_PrevAndNext(
			long dataStructureId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Removes all the data structures where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of data structures where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data structures
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of data structures that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data structures that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns all the data structures where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data structures
	 */
	public java.util.List<DataStructure> findByU_S(long userId, int status);

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
	public java.util.List<DataStructure> findByU_S(
		long userId, int status, int start, int end);

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
	public java.util.List<DataStructure> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public java.util.List<DataStructure> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data structure in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the first data structure in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the last data structure in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the last data structure in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public DataStructure[] findByU_S_PrevAndNext(
			long dataStructureId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Removes all the data structures where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of data structures where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data structures
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns all the data structures where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data structures
	 */
	public java.util.List<DataStructure> findByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<DataStructure> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<DataStructure> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public java.util.List<DataStructure> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

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
	public DataStructure findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the first data structure in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public DataStructure findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the last data structure in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public DataStructure[] findByG_U_S_PrevAndNext(
			long dataStructureId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns all the data structures that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data structures that the user has permission to view
	 */
	public java.util.List<DataStructure> filterFindByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<DataStructure> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<DataStructure> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public DataStructure[] filterFindByG_U_S_PrevAndNext(
			long dataStructureId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Removes all the data structures where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of data structures where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data structures
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of data structures that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data structures that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns all the data structures where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @return the matching data structures
	 */
	public java.util.List<DataStructure> findByName(String dataStructureName);

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
	public java.util.List<DataStructure> findByName(
		String dataStructureName, int start, int end);

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
	public java.util.List<DataStructure> findByName(
		String dataStructureName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public java.util.List<DataStructure> findByName(
		String dataStructureName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data structure in the ordered set where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByName_First(
			String dataStructureName,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the first data structure in the ordered set where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByName_First(
		String dataStructureName,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the last data structure in the ordered set where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByName_Last(
			String dataStructureName,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the last data structure in the ordered set where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByName_Last(
		String dataStructureName,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where dataStructureName = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param dataStructureName the data structure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public DataStructure[] findByName_PrevAndNext(
			long dataStructureId, String dataStructureName,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Removes all the data structures where dataStructureName = &#63; from the database.
	 *
	 * @param dataStructureName the data structure name
	 */
	public void removeByName(String dataStructureName);

	/**
	 * Returns the number of data structures where dataStructureName = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @return the number of matching data structures
	 */
	public int countByName(String dataStructureName);

	/**
	 * Returns the data structure where dataStructureName = &#63; and dataStructureVersion = &#63; or throws a <code>NoSuchDataStructureException</code> if it could not be found.
	 *
	 * @param dataStructureName the data structure name
	 * @param dataStructureVersion the data structure version
	 * @return the matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByNameVersion(
			String dataStructureName, String dataStructureVersion)
		throws NoSuchDataStructureException;

	/**
	 * Returns the data structure where dataStructureName = &#63; and dataStructureVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataStructureName the data structure name
	 * @param dataStructureVersion the data structure version
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByNameVersion(
		String dataStructureName, String dataStructureVersion);

	/**
	 * Returns the data structure where dataStructureName = &#63; and dataStructureVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataStructureName the data structure name
	 * @param dataStructureVersion the data structure version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByNameVersion(
		String dataStructureName, String dataStructureVersion,
		boolean useFinderCache);

	/**
	 * Removes the data structure where dataStructureName = &#63; and dataStructureVersion = &#63; from the database.
	 *
	 * @param dataStructureName the data structure name
	 * @param dataStructureVersion the data structure version
	 * @return the data structure that was removed
	 */
	public DataStructure removeByNameVersion(
			String dataStructureName, String dataStructureVersion)
		throws NoSuchDataStructureException;

	/**
	 * Returns the number of data structures where dataStructureName = &#63; and dataStructureVersion = &#63;.
	 *
	 * @param dataStructureName the data structure name
	 * @param dataStructureVersion the data structure version
	 * @return the number of matching data structures
	 */
	public int countByNameVersion(
		String dataStructureName, String dataStructureVersion);

	/**
	 * Caches the data structure in the entity cache if it is enabled.
	 *
	 * @param dataStructure the data structure
	 */
	public void cacheResult(DataStructure dataStructure);

	/**
	 * Caches the data structures in the entity cache if it is enabled.
	 *
	 * @param dataStructures the data structures
	 */
	public void cacheResult(java.util.List<DataStructure> dataStructures);

	/**
	 * Creates a new data structure with the primary key. Does not add the data structure to the database.
	 *
	 * @param dataStructureId the primary key for the new data structure
	 * @return the new data structure
	 */
	public DataStructure create(long dataStructureId);

	/**
	 * Removes the data structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure that was removed
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public DataStructure remove(long dataStructureId)
		throws NoSuchDataStructureException;

	public DataStructure updateImpl(DataStructure dataStructure);

	/**
	 * Returns the data structure with the primary key or throws a <code>NoSuchDataStructureException</code> if it could not be found.
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public DataStructure findByPrimaryKey(long dataStructureId)
		throws NoSuchDataStructureException;

	/**
	 * Returns the data structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure, or <code>null</code> if a data structure with the primary key could not be found
	 */
	public DataStructure fetchByPrimaryKey(long dataStructureId);

	/**
	 * Returns all the data structures.
	 *
	 * @return the data structures
	 */
	public java.util.List<DataStructure> findAll();

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
	public java.util.List<DataStructure> findAll(int start, int end);

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
	public java.util.List<DataStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

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
	public java.util.List<DataStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data structures from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data structures.
	 *
	 * @return the number of data structures
	 */
	public int countAll();

}