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

import com.sx.icecap.model.TypeVisualizerLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the type visualizer link service. This utility wraps <code>com.sx.icecap.service.persistence.impl.TypeVisualizerLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TypeVisualizerLinkPersistence
 * @generated
 */
public class TypeVisualizerLinkUtil {

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
	public static void clearCache(TypeVisualizerLink typeVisualizerLink) {
		getPersistence().clearCache(typeVisualizerLink);
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
	public static Map<Serializable, TypeVisualizerLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TypeVisualizerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TypeVisualizerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TypeVisualizerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TypeVisualizerLink update(
		TypeVisualizerLink typeVisualizerLink) {

		return getPersistence().update(typeVisualizerLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TypeVisualizerLink update(
		TypeVisualizerLink typeVisualizerLink, ServiceContext serviceContext) {

		return getPersistence().update(typeVisualizerLink, serviceContext);
	}

	/**
	 * Returns all the type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching type visualizer links
	 */
	public static List<TypeVisualizerLink> findByDataTypeId(long dataTypeId) {
		return getPersistence().findByDataTypeId(dataTypeId);
	}

	/**
	 * Returns a range of all the type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @return the range of matching type visualizer links
	 */
	public static List<TypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return getPersistence().findByDataTypeId(dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type visualizer links
	 */
	public static List<TypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type visualizer links
	 */
	public static List<TypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	public static TypeVisualizerLink findByDataTypeId_First(
			long dataTypeId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeVisualizerLinkException {

		return getPersistence().findByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	public static TypeVisualizerLink fetchByDataTypeId_First(
		long dataTypeId,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		return getPersistence().fetchByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	public static TypeVisualizerLink findByDataTypeId_Last(
			long dataTypeId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeVisualizerLinkException {

		return getPersistence().findByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	public static TypeVisualizerLink fetchByDataTypeId_Last(
		long dataTypeId,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		return getPersistence().fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the type visualizer links before and after the current type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param typeVisualizerLinkId the primary key of the current type visualizer link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	public static TypeVisualizerLink[] findByDataTypeId_PrevAndNext(
			long typeVisualizerLinkId, long dataTypeId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeVisualizerLinkException {

		return getPersistence().findByDataTypeId_PrevAndNext(
			typeVisualizerLinkId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the type visualizer links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public static void removeByDataTypeId(long dataTypeId) {
		getPersistence().removeByDataTypeId(dataTypeId);
	}

	/**
	 * Returns the number of type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching type visualizer links
	 */
	public static int countByDataTypeId(long dataTypeId) {
		return getPersistence().countByDataTypeId(dataTypeId);
	}

	/**
	 * Returns all the type visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the matching type visualizer links
	 */
	public static List<TypeVisualizerLink> findByVisualizerId(
		long visualizerId) {

		return getPersistence().findByVisualizerId(visualizerId);
	}

	/**
	 * Returns a range of all the type visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @return the range of matching type visualizer links
	 */
	public static List<TypeVisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end) {

		return getPersistence().findByVisualizerId(visualizerId, start, end);
	}

	/**
	 * Returns an ordered range of all the type visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type visualizer links
	 */
	public static List<TypeVisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		return getPersistence().findByVisualizerId(
			visualizerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type visualizer links
	 */
	public static List<TypeVisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVisualizerId(
			visualizerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	public static TypeVisualizerLink findByVisualizerId_First(
			long visualizerId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeVisualizerLinkException {

		return getPersistence().findByVisualizerId_First(
			visualizerId, orderByComparator);
	}

	/**
	 * Returns the first type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	public static TypeVisualizerLink fetchByVisualizerId_First(
		long visualizerId,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		return getPersistence().fetchByVisualizerId_First(
			visualizerId, orderByComparator);
	}

	/**
	 * Returns the last type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	public static TypeVisualizerLink findByVisualizerId_Last(
			long visualizerId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeVisualizerLinkException {

		return getPersistence().findByVisualizerId_Last(
			visualizerId, orderByComparator);
	}

	/**
	 * Returns the last type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	public static TypeVisualizerLink fetchByVisualizerId_Last(
		long visualizerId,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		return getPersistence().fetchByVisualizerId_Last(
			visualizerId, orderByComparator);
	}

	/**
	 * Returns the type visualizer links before and after the current type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param typeVisualizerLinkId the primary key of the current type visualizer link
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	public static TypeVisualizerLink[] findByVisualizerId_PrevAndNext(
			long typeVisualizerLinkId, long visualizerId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeVisualizerLinkException {

		return getPersistence().findByVisualizerId_PrevAndNext(
			typeVisualizerLinkId, visualizerId, orderByComparator);
	}

	/**
	 * Removes all the type visualizer links where visualizerId = &#63; from the database.
	 *
	 * @param visualizerId the visualizer ID
	 */
	public static void removeByVisualizerId(long visualizerId) {
		getPersistence().removeByVisualizerId(visualizerId);
	}

	/**
	 * Returns the number of type visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the number of matching type visualizer links
	 */
	public static int countByVisualizerId(long visualizerId) {
		return getPersistence().countByVisualizerId(visualizerId);
	}

	/**
	 * Caches the type visualizer link in the entity cache if it is enabled.
	 *
	 * @param typeVisualizerLink the type visualizer link
	 */
	public static void cacheResult(TypeVisualizerLink typeVisualizerLink) {
		getPersistence().cacheResult(typeVisualizerLink);
	}

	/**
	 * Caches the type visualizer links in the entity cache if it is enabled.
	 *
	 * @param typeVisualizerLinks the type visualizer links
	 */
	public static void cacheResult(
		List<TypeVisualizerLink> typeVisualizerLinks) {

		getPersistence().cacheResult(typeVisualizerLinks);
	}

	/**
	 * Creates a new type visualizer link with the primary key. Does not add the type visualizer link to the database.
	 *
	 * @param typeVisualizerLinkId the primary key for the new type visualizer link
	 * @return the new type visualizer link
	 */
	public static TypeVisualizerLink create(long typeVisualizerLinkId) {
		return getPersistence().create(typeVisualizerLinkId);
	}

	/**
	 * Removes the type visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeVisualizerLinkId the primary key of the type visualizer link
	 * @return the type visualizer link that was removed
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	public static TypeVisualizerLink remove(long typeVisualizerLinkId)
		throws com.sx.icecap.exception.NoSuchTypeVisualizerLinkException {

		return getPersistence().remove(typeVisualizerLinkId);
	}

	public static TypeVisualizerLink updateImpl(
		TypeVisualizerLink typeVisualizerLink) {

		return getPersistence().updateImpl(typeVisualizerLink);
	}

	/**
	 * Returns the type visualizer link with the primary key or throws a <code>NoSuchTypeVisualizerLinkException</code> if it could not be found.
	 *
	 * @param typeVisualizerLinkId the primary key of the type visualizer link
	 * @return the type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	public static TypeVisualizerLink findByPrimaryKey(long typeVisualizerLinkId)
		throws com.sx.icecap.exception.NoSuchTypeVisualizerLinkException {

		return getPersistence().findByPrimaryKey(typeVisualizerLinkId);
	}

	/**
	 * Returns the type visualizer link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeVisualizerLinkId the primary key of the type visualizer link
	 * @return the type visualizer link, or <code>null</code> if a type visualizer link with the primary key could not be found
	 */
	public static TypeVisualizerLink fetchByPrimaryKey(
		long typeVisualizerLinkId) {

		return getPersistence().fetchByPrimaryKey(typeVisualizerLinkId);
	}

	/**
	 * Returns all the type visualizer links.
	 *
	 * @return the type visualizer links
	 */
	public static List<TypeVisualizerLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @return the range of type visualizer links
	 */
	public static List<TypeVisualizerLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of type visualizer links
	 */
	public static List<TypeVisualizerLink> findAll(
		int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of type visualizer links
	 */
	public static List<TypeVisualizerLink> findAll(
		int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the type visualizer links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of type visualizer links.
	 *
	 * @return the number of type visualizer links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TypeVisualizerLinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TypeVisualizerLinkPersistence _persistence;

}