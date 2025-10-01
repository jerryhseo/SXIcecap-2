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

import com.sx.icecap.model.CollectionSetLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the collection set link service. This utility wraps <code>com.sx.icecap.service.persistence.impl.CollectionSetLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CollectionSetLinkPersistence
 * @generated
 */
public class CollectionSetLinkUtil {

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
	public static void clearCache(CollectionSetLink collectionSetLink) {
		getPersistence().clearCache(collectionSetLink);
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
	public static Map<Serializable, CollectionSetLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CollectionSetLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CollectionSetLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CollectionSetLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CollectionSetLink update(
		CollectionSetLink collectionSetLink) {

		return getPersistence().update(collectionSetLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CollectionSetLink update(
		CollectionSetLink collectionSetLink, ServiceContext serviceContext) {

		return getPersistence().update(collectionSetLink, serviceContext);
	}

	/**
	 * Returns all the collection set links where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching collection set links
	 */
	public static List<CollectionSetLink> findByCollectionId(
		long dataCollectionId) {

		return getPersistence().findByCollectionId(dataCollectionId);
	}

	/**
	 * Returns a range of all the collection set links where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @return the range of matching collection set links
	 */
	public static List<CollectionSetLink> findByCollectionId(
		long dataCollectionId, int start, int end) {

		return getPersistence().findByCollectionId(
			dataCollectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the collection set links where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching collection set links
	 */
	public static List<CollectionSetLink> findByCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		return getPersistence().findByCollectionId(
			dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the collection set links where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching collection set links
	 */
	public static List<CollectionSetLink> findByCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionId(
			dataCollectionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	public static CollectionSetLink findByCollectionId_First(
			long dataCollectionId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchCollectionSetLinkException {

		return getPersistence().findByCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the first collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	public static CollectionSetLink fetchByCollectionId_First(
		long dataCollectionId,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		return getPersistence().fetchByCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	public static CollectionSetLink findByCollectionId_Last(
			long dataCollectionId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchCollectionSetLinkException {

		return getPersistence().findByCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	public static CollectionSetLink fetchByCollectionId_Last(
		long dataCollectionId,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		return getPersistence().fetchByCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the collection set links before and after the current collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param collectionSetLinkId the primary key of the current collection set link
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next collection set link
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	public static CollectionSetLink[] findByCollectionId_PrevAndNext(
			long collectionSetLinkId, long dataCollectionId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchCollectionSetLinkException {

		return getPersistence().findByCollectionId_PrevAndNext(
			collectionSetLinkId, dataCollectionId, orderByComparator);
	}

	/**
	 * Removes all the collection set links where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public static void removeByCollectionId(long dataCollectionId) {
		getPersistence().removeByCollectionId(dataCollectionId);
	}

	/**
	 * Returns the number of collection set links where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching collection set links
	 */
	public static int countByCollectionId(long dataCollectionId) {
		return getPersistence().countByCollectionId(dataCollectionId);
	}

	/**
	 * Returns all the collection set links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching collection set links
	 */
	public static List<CollectionSetLink> findByDataSetId(long dataSetId) {
		return getPersistence().findByDataSetId(dataSetId);
	}

	/**
	 * Returns a range of all the collection set links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @return the range of matching collection set links
	 */
	public static List<CollectionSetLink> findByDataSetId(
		long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId(dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the collection set links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching collection set links
	 */
	public static List<CollectionSetLink> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the collection set links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching collection set links
	 */
	public static List<CollectionSetLink> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	public static CollectionSetLink findByDataSetId_First(
			long dataSetId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchCollectionSetLinkException {

		return getPersistence().findByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the first collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	public static CollectionSetLink fetchByDataSetId_First(
		long dataSetId,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		return getPersistence().fetchByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	public static CollectionSetLink findByDataSetId_Last(
			long dataSetId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchCollectionSetLinkException {

		return getPersistence().findByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	public static CollectionSetLink fetchByDataSetId_Last(
		long dataSetId,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		return getPersistence().fetchByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the collection set links before and after the current collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param collectionSetLinkId the primary key of the current collection set link
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next collection set link
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	public static CollectionSetLink[] findByDataSetId_PrevAndNext(
			long collectionSetLinkId, long dataSetId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchCollectionSetLinkException {

		return getPersistence().findByDataSetId_PrevAndNext(
			collectionSetLinkId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the collection set links where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId(long dataSetId) {
		getPersistence().removeByDataSetId(dataSetId);
	}

	/**
	 * Returns the number of collection set links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching collection set links
	 */
	public static int countByDataSetId(long dataSetId) {
		return getPersistence().countByDataSetId(dataSetId);
	}

	/**
	 * Returns the collection set link where dataCollectionId = &#63; and dataSetId = &#63; or throws a <code>NoSuchCollectionSetLinkException</code> if it could not be found.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	public static CollectionSetLink findByCollectionSet(
			long dataCollectionId, long dataSetId)
		throws com.sx.icecap.exception.NoSuchCollectionSetLinkException {

		return getPersistence().findByCollectionSet(
			dataCollectionId, dataSetId);
	}

	/**
	 * Returns the collection set link where dataCollectionId = &#63; and dataSetId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	public static CollectionSetLink fetchByCollectionSet(
		long dataCollectionId, long dataSetId) {

		return getPersistence().fetchByCollectionSet(
			dataCollectionId, dataSetId);
	}

	/**
	 * Returns the collection set link where dataCollectionId = &#63; and dataSetId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	public static CollectionSetLink fetchByCollectionSet(
		long dataCollectionId, long dataSetId, boolean useFinderCache) {

		return getPersistence().fetchByCollectionSet(
			dataCollectionId, dataSetId, useFinderCache);
	}

	/**
	 * Removes the collection set link where dataCollectionId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the collection set link that was removed
	 */
	public static CollectionSetLink removeByCollectionSet(
			long dataCollectionId, long dataSetId)
		throws com.sx.icecap.exception.NoSuchCollectionSetLinkException {

		return getPersistence().removeByCollectionSet(
			dataCollectionId, dataSetId);
	}

	/**
	 * Returns the number of collection set links where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the number of matching collection set links
	 */
	public static int countByCollectionSet(
		long dataCollectionId, long dataSetId) {

		return getPersistence().countByCollectionSet(
			dataCollectionId, dataSetId);
	}

	/**
	 * Caches the collection set link in the entity cache if it is enabled.
	 *
	 * @param collectionSetLink the collection set link
	 */
	public static void cacheResult(CollectionSetLink collectionSetLink) {
		getPersistence().cacheResult(collectionSetLink);
	}

	/**
	 * Caches the collection set links in the entity cache if it is enabled.
	 *
	 * @param collectionSetLinks the collection set links
	 */
	public static void cacheResult(List<CollectionSetLink> collectionSetLinks) {
		getPersistence().cacheResult(collectionSetLinks);
	}

	/**
	 * Creates a new collection set link with the primary key. Does not add the collection set link to the database.
	 *
	 * @param collectionSetLinkId the primary key for the new collection set link
	 * @return the new collection set link
	 */
	public static CollectionSetLink create(long collectionSetLinkId) {
		return getPersistence().create(collectionSetLinkId);
	}

	/**
	 * Removes the collection set link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link that was removed
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	public static CollectionSetLink remove(long collectionSetLinkId)
		throws com.sx.icecap.exception.NoSuchCollectionSetLinkException {

		return getPersistence().remove(collectionSetLinkId);
	}

	public static CollectionSetLink updateImpl(
		CollectionSetLink collectionSetLink) {

		return getPersistence().updateImpl(collectionSetLink);
	}

	/**
	 * Returns the collection set link with the primary key or throws a <code>NoSuchCollectionSetLinkException</code> if it could not be found.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	public static CollectionSetLink findByPrimaryKey(long collectionSetLinkId)
		throws com.sx.icecap.exception.NoSuchCollectionSetLinkException {

		return getPersistence().findByPrimaryKey(collectionSetLinkId);
	}

	/**
	 * Returns the collection set link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link, or <code>null</code> if a collection set link with the primary key could not be found
	 */
	public static CollectionSetLink fetchByPrimaryKey(
		long collectionSetLinkId) {

		return getPersistence().fetchByPrimaryKey(collectionSetLinkId);
	}

	/**
	 * Returns all the collection set links.
	 *
	 * @return the collection set links
	 */
	public static List<CollectionSetLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the collection set links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @return the range of collection set links
	 */
	public static List<CollectionSetLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the collection set links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of collection set links
	 */
	public static List<CollectionSetLink> findAll(
		int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the collection set links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of collection set links
	 */
	public static List<CollectionSetLink> findAll(
		int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the collection set links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of collection set links.
	 *
	 * @return the number of collection set links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CollectionSetLinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CollectionSetLinkPersistence _persistence;

}