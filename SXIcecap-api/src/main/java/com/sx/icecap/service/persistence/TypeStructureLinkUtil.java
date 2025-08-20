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

import com.sx.icecap.model.TypeStructureLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the type structure link service. This utility wraps <code>com.sx.icecap.service.persistence.impl.TypeStructureLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TypeStructureLinkPersistence
 * @generated
 */
public class TypeStructureLinkUtil {

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
	public static void clearCache(TypeStructureLink typeStructureLink) {
		getPersistence().clearCache(typeStructureLink);
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
	public static Map<Serializable, TypeStructureLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TypeStructureLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TypeStructureLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TypeStructureLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TypeStructureLink update(
		TypeStructureLink typeStructureLink) {

		return getPersistence().update(typeStructureLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TypeStructureLink update(
		TypeStructureLink typeStructureLink, ServiceContext serviceContext) {

		return getPersistence().update(typeStructureLink, serviceContext);
	}

	/**
	 * Returns the type structure link where dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByDataStructureId(long dataStructureId)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByDataStructureId(dataStructureId);
	}

	/**
	 * Returns the type structure link where dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByDataStructureId(
		long dataStructureId) {

		return getPersistence().fetchByDataStructureId(dataStructureId);
	}

	/**
	 * Returns the type structure link where dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByDataStructureId(
		long dataStructureId, boolean useFinderCache) {

		return getPersistence().fetchByDataStructureId(
			dataStructureId, useFinderCache);
	}

	/**
	 * Removes the type structure link where dataStructureId = &#63; from the database.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	public static TypeStructureLink removeByDataStructureId(
			long dataStructureId)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().removeByDataStructureId(dataStructureId);
	}

	/**
	 * Returns the number of type structure links where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	public static int countByDataStructureId(long dataStructureId) {
		return getPersistence().countByDataStructureId(dataStructureId);
	}

	/**
	 * Caches the type structure link in the entity cache if it is enabled.
	 *
	 * @param typeStructureLink the type structure link
	 */
	public static void cacheResult(TypeStructureLink typeStructureLink) {
		getPersistence().cacheResult(typeStructureLink);
	}

	/**
	 * Caches the type structure links in the entity cache if it is enabled.
	 *
	 * @param typeStructureLinks the type structure links
	 */
	public static void cacheResult(List<TypeStructureLink> typeStructureLinks) {
		getPersistence().cacheResult(typeStructureLinks);
	}

	/**
	 * Creates a new type structure link with the primary key. Does not add the type structure link to the database.
	 *
	 * @param dataTypeId the primary key for the new type structure link
	 * @return the new type structure link
	 */
	public static TypeStructureLink create(long dataTypeId) {
		return getPersistence().create(dataTypeId);
	}

	/**
	 * Removes the type structure link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link that was removed
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink remove(long dataTypeId)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().remove(dataTypeId);
	}

	public static TypeStructureLink updateImpl(
		TypeStructureLink typeStructureLink) {

		return getPersistence().updateImpl(typeStructureLink);
	}

	/**
	 * Returns the type structure link with the primary key or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink findByPrimaryKey(long dataTypeId)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByPrimaryKey(dataTypeId);
	}

	/**
	 * Returns the type structure link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link, or <code>null</code> if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink fetchByPrimaryKey(long dataTypeId) {
		return getPersistence().fetchByPrimaryKey(dataTypeId);
	}

	/**
	 * Returns all the type structure links.
	 *
	 * @return the type structure links
	 */
	public static List<TypeStructureLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the type structure links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of type structure links
	 */
	public static List<TypeStructureLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of type structure links
	 */
	public static List<TypeStructureLink> findAll(
		int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of type structure links
	 */
	public static List<TypeStructureLink> findAll(
		int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the type structure links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of type structure links.
	 *
	 * @return the number of type structure links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TypeStructureLinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TypeStructureLinkPersistence _persistence;

}