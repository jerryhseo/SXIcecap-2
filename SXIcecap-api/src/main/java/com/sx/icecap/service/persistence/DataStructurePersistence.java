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
	 * Returns all the data structures where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching data structures
	 */
	public java.util.List<DataStructure> findByDataTypeId(long dataTypeId);

	/**
	 * Returns a range of all the data structures where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	public java.util.List<DataStructure> findByDataTypeId(
		long dataTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the data structures where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	public java.util.List<DataStructure> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data structures where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	public java.util.List<DataStructure> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data structure in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByDataTypeId_First(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the first data structure in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByDataTypeId_First(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the last data structure in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByDataTypeId_Last(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Returns the last data structure in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByDataTypeId_Last(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
			orderByComparator);

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public DataStructure[] findByDataTypeId_PrevAndNext(
			long dataStructureId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DataStructure>
				orderByComparator)
		throws NoSuchDataStructureException;

	/**
	 * Removes all the data structures where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public void removeByDataTypeId(long dataTypeId);

	/**
	 * Returns the number of data structures where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching data structures
	 */
	public int countByDataTypeId(long dataTypeId);

	/**
	 * Returns the data structure where dataTypeId = &#63; and version = &#63; or throws a <code>NoSuchDataStructureException</code> if it could not be found.
	 *
	 * @param dataTypeId the data type ID
	 * @param version the version
	 * @return the matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	public DataStructure findByDataTypeIdVersion(
			long dataTypeId, String version)
		throws NoSuchDataStructureException;

	/**
	 * Returns the data structure where dataTypeId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataTypeId the data type ID
	 * @param version the version
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByDataTypeIdVersion(
		long dataTypeId, String version);

	/**
	 * Returns the data structure where dataTypeId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataTypeId the data type ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	public DataStructure fetchByDataTypeIdVersion(
		long dataTypeId, String version, boolean useFinderCache);

	/**
	 * Removes the data structure where dataTypeId = &#63; and version = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param version the version
	 * @return the data structure that was removed
	 */
	public DataStructure removeByDataTypeIdVersion(
			long dataTypeId, String version)
		throws NoSuchDataStructureException;

	/**
	 * Returns the number of data structures where dataTypeId = &#63; and version = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param version the version
	 * @return the number of matching data structures
	 */
	public int countByDataTypeIdVersion(long dataTypeId, String version);

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