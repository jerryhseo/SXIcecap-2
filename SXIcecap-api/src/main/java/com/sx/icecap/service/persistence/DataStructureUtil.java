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
	 * @param dataTypeId the primary key for the new data structure
	 * @return the new data structure
	 */
	public static DataStructure create(long dataTypeId) {
		return getPersistence().create(dataTypeId);
	}

	/**
	 * Removes the data structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeId the primary key of the data structure
	 * @return the data structure that was removed
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure remove(long dataTypeId)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().remove(dataTypeId);
	}

	public static DataStructure updateImpl(DataStructure dataStructure) {
		return getPersistence().updateImpl(dataStructure);
	}

	/**
	 * Returns the data structure with the primary key or throws a <code>NoSuchDataStructureException</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the data structure
	 * @return the data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	public static DataStructure findByPrimaryKey(long dataTypeId)
		throws com.sx.icecap.exception.NoSuchDataStructureException {

		return getPersistence().findByPrimaryKey(dataTypeId);
	}

	/**
	 * Returns the data structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the data structure
	 * @return the data structure, or <code>null</code> if a data structure with the primary key could not be found
	 */
	public static DataStructure fetchByPrimaryKey(long dataTypeId) {
		return getPersistence().fetchByPrimaryKey(dataTypeId);
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