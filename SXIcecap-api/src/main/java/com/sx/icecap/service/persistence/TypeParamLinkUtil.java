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

import com.sx.icecap.model.TypeParamLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the type param link service. This utility wraps <code>com.sx.icecap.service.persistence.impl.TypeParamLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TypeParamLinkPersistence
 * @generated
 */
public class TypeParamLinkUtil {

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
	public static void clearCache(TypeParamLink typeParamLink) {
		getPersistence().clearCache(typeParamLink);
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
	public static Map<Serializable, TypeParamLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TypeParamLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TypeParamLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TypeParamLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TypeParamLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TypeParamLink update(TypeParamLink typeParamLink) {
		return getPersistence().update(typeParamLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TypeParamLink update(
		TypeParamLink typeParamLink, ServiceContext serviceContext) {

		return getPersistence().update(typeParamLink, serviceContext);
	}

	/**
	 * Returns all the type param links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching type param links
	 */
	public static List<TypeParamLink> findByDataTypeId(long dataTypeId) {
		return getPersistence().findByDataTypeId(dataTypeId);
	}

	/**
	 * Returns a range of all the type param links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @return the range of matching type param links
	 */
	public static List<TypeParamLink> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return getPersistence().findByDataTypeId(dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the type param links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type param links
	 */
	public static List<TypeParamLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<TypeParamLink> orderByComparator) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type param links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type param links
	 */
	public static List<TypeParamLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<TypeParamLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	public static TypeParamLink findByDataTypeId_First(
			long dataTypeId, OrderByComparator<TypeParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeParamLinkException {

		return getPersistence().findByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	public static TypeParamLink fetchByDataTypeId_First(
		long dataTypeId, OrderByComparator<TypeParamLink> orderByComparator) {

		return getPersistence().fetchByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	public static TypeParamLink findByDataTypeId_Last(
			long dataTypeId, OrderByComparator<TypeParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeParamLinkException {

		return getPersistence().findByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	public static TypeParamLink fetchByDataTypeId_Last(
		long dataTypeId, OrderByComparator<TypeParamLink> orderByComparator) {

		return getPersistence().fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the type param links before and after the current type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param typeParamLinkId the primary key of the current type param link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type param link
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	public static TypeParamLink[] findByDataTypeId_PrevAndNext(
			long typeParamLinkId, long dataTypeId,
			OrderByComparator<TypeParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeParamLinkException {

		return getPersistence().findByDataTypeId_PrevAndNext(
			typeParamLinkId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the type param links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public static void removeByDataTypeId(long dataTypeId) {
		getPersistence().removeByDataTypeId(dataTypeId);
	}

	/**
	 * Returns the number of type param links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching type param links
	 */
	public static int countByDataTypeId(long dataTypeId) {
		return getPersistence().countByDataTypeId(dataTypeId);
	}

	/**
	 * Returns all the type param links where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @return the matching type param links
	 */
	public static List<TypeParamLink> findByParamId(long paramId) {
		return getPersistence().findByParamId(paramId);
	}

	/**
	 * Returns a range of all the type param links where paramId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param paramId the param ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @return the range of matching type param links
	 */
	public static List<TypeParamLink> findByParamId(
		long paramId, int start, int end) {

		return getPersistence().findByParamId(paramId, start, end);
	}

	/**
	 * Returns an ordered range of all the type param links where paramId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param paramId the param ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type param links
	 */
	public static List<TypeParamLink> findByParamId(
		long paramId, int start, int end,
		OrderByComparator<TypeParamLink> orderByComparator) {

		return getPersistence().findByParamId(
			paramId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type param links where paramId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param paramId the param ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type param links
	 */
	public static List<TypeParamLink> findByParamId(
		long paramId, int start, int end,
		OrderByComparator<TypeParamLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParamId(
			paramId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	public static TypeParamLink findByParamId_First(
			long paramId, OrderByComparator<TypeParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeParamLinkException {

		return getPersistence().findByParamId_First(paramId, orderByComparator);
	}

	/**
	 * Returns the first type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	public static TypeParamLink fetchByParamId_First(
		long paramId, OrderByComparator<TypeParamLink> orderByComparator) {

		return getPersistence().fetchByParamId_First(
			paramId, orderByComparator);
	}

	/**
	 * Returns the last type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	public static TypeParamLink findByParamId_Last(
			long paramId, OrderByComparator<TypeParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeParamLinkException {

		return getPersistence().findByParamId_Last(paramId, orderByComparator);
	}

	/**
	 * Returns the last type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	public static TypeParamLink fetchByParamId_Last(
		long paramId, OrderByComparator<TypeParamLink> orderByComparator) {

		return getPersistence().fetchByParamId_Last(paramId, orderByComparator);
	}

	/**
	 * Returns the type param links before and after the current type param link in the ordered set where paramId = &#63;.
	 *
	 * @param typeParamLinkId the primary key of the current type param link
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type param link
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	public static TypeParamLink[] findByParamId_PrevAndNext(
			long typeParamLinkId, long paramId,
			OrderByComparator<TypeParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeParamLinkException {

		return getPersistence().findByParamId_PrevAndNext(
			typeParamLinkId, paramId, orderByComparator);
	}

	/**
	 * Removes all the type param links where paramId = &#63; from the database.
	 *
	 * @param paramId the param ID
	 */
	public static void removeByParamId(long paramId) {
		getPersistence().removeByParamId(paramId);
	}

	/**
	 * Returns the number of type param links where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @return the number of matching type param links
	 */
	public static int countByParamId(long paramId) {
		return getPersistence().countByParamId(paramId);
	}

	/**
	 * Caches the type param link in the entity cache if it is enabled.
	 *
	 * @param typeParamLink the type param link
	 */
	public static void cacheResult(TypeParamLink typeParamLink) {
		getPersistence().cacheResult(typeParamLink);
	}

	/**
	 * Caches the type param links in the entity cache if it is enabled.
	 *
	 * @param typeParamLinks the type param links
	 */
	public static void cacheResult(List<TypeParamLink> typeParamLinks) {
		getPersistence().cacheResult(typeParamLinks);
	}

	/**
	 * Creates a new type param link with the primary key. Does not add the type param link to the database.
	 *
	 * @param typeParamLinkId the primary key for the new type param link
	 * @return the new type param link
	 */
	public static TypeParamLink create(long typeParamLinkId) {
		return getPersistence().create(typeParamLinkId);
	}

	/**
	 * Removes the type param link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeParamLinkId the primary key of the type param link
	 * @return the type param link that was removed
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	public static TypeParamLink remove(long typeParamLinkId)
		throws com.sx.icecap.exception.NoSuchTypeParamLinkException {

		return getPersistence().remove(typeParamLinkId);
	}

	public static TypeParamLink updateImpl(TypeParamLink typeParamLink) {
		return getPersistence().updateImpl(typeParamLink);
	}

	/**
	 * Returns the type param link with the primary key or throws a <code>NoSuchTypeParamLinkException</code> if it could not be found.
	 *
	 * @param typeParamLinkId the primary key of the type param link
	 * @return the type param link
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	public static TypeParamLink findByPrimaryKey(long typeParamLinkId)
		throws com.sx.icecap.exception.NoSuchTypeParamLinkException {

		return getPersistence().findByPrimaryKey(typeParamLinkId);
	}

	/**
	 * Returns the type param link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeParamLinkId the primary key of the type param link
	 * @return the type param link, or <code>null</code> if a type param link with the primary key could not be found
	 */
	public static TypeParamLink fetchByPrimaryKey(long typeParamLinkId) {
		return getPersistence().fetchByPrimaryKey(typeParamLinkId);
	}

	/**
	 * Returns all the type param links.
	 *
	 * @return the type param links
	 */
	public static List<TypeParamLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the type param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @return the range of type param links
	 */
	public static List<TypeParamLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the type param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of type param links
	 */
	public static List<TypeParamLink> findAll(
		int start, int end,
		OrderByComparator<TypeParamLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of type param links
	 */
	public static List<TypeParamLink> findAll(
		int start, int end, OrderByComparator<TypeParamLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the type param links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of type param links.
	 *
	 * @return the number of type param links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TypeParamLinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TypeParamLinkPersistence _persistence;

}