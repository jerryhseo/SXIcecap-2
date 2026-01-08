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

import com.sx.icecap.model.SetTypeLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the set type link service. This utility wraps <code>com.sx.icecap.service.persistence.impl.SetTypeLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SetTypeLinkPersistence
 * @generated
 */
public class SetTypeLinkUtil {

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
	public static void clearCache(SetTypeLink setTypeLink) {
		getPersistence().clearCache(setTypeLink);
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
	public static Map<Serializable, SetTypeLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SetTypeLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SetTypeLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SetTypeLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SetTypeLink update(SetTypeLink setTypeLink) {
		return getPersistence().update(setTypeLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SetTypeLink update(
		SetTypeLink setTypeLink, ServiceContext serviceContext) {

		return getPersistence().update(setTypeLink, serviceContext);
	}

	/**
	 * Returns all the set type links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching set type links
	 */
	public static List<SetTypeLink> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the set type links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of matching set type links
	 */
	public static List<SetTypeLink> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the set type links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the set type links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByGroupId_First(
			long groupId, OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByGroupId_First(
		long groupId, OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByGroupId_Last(
			long groupId, OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByGroupId_Last(
		long groupId, OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where groupId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink[] findByGroupId_PrevAndNext(
			long setTypeLinkId, long groupId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByGroupId_PrevAndNext(
			setTypeLinkId, groupId, orderByComparator);
	}

	/**
	 * Removes all the set type links where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of set type links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching set type links
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the set type links where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching set type links
	 */
	public static List<SetTypeLink> findByDataCollectionId(
		long dataCollectionId) {

		return getPersistence().findByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns a range of all the set type links where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of matching set type links
	 */
	public static List<SetTypeLink> findByDataCollectionId(
		long dataCollectionId, int start, int end) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end);
	}

	/**
	 * Returns an ordered range of all the set type links where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the set type links where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataCollectionId(
			dataCollectionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first set type link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByDataCollectionId_First(
			long dataCollectionId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByDataCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the first set type link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByDataCollectionId_First(
		long dataCollectionId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_First(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByDataCollectionId_Last(
			long dataCollectionId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByDataCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByDataCollectionId_Last(
		long dataCollectionId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByDataCollectionId_Last(
			dataCollectionId, orderByComparator);
	}

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink[] findByDataCollectionId_PrevAndNext(
			long setTypeLinkId, long dataCollectionId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByDataCollectionId_PrevAndNext(
			setTypeLinkId, dataCollectionId, orderByComparator);
	}

	/**
	 * Removes all the set type links where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public static void removeByDataCollectionId(long dataCollectionId) {
		getPersistence().removeByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns the number of set type links where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching set type links
	 */
	public static int countByDataCollectionId(long dataCollectionId) {
		return getPersistence().countByDataCollectionId(dataCollectionId);
	}

	/**
	 * Returns all the set type links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching set type links
	 */
	public static List<SetTypeLink> findByDataSetId(long dataSetId) {
		return getPersistence().findByDataSetId(dataSetId);
	}

	/**
	 * Returns a range of all the set type links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of matching set type links
	 */
	public static List<SetTypeLink> findByDataSetId(
		long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId(dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the set type links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the set type links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByDataSetId_First(
			long dataSetId, OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the first set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByDataSetId_First(
		long dataSetId, OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByDataSetId_Last(
			long dataSetId, OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByDataSetId_Last(
		long dataSetId, OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink[] findByDataSetId_PrevAndNext(
			long setTypeLinkId, long dataSetId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByDataSetId_PrevAndNext(
			setTypeLinkId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the set type links where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId(long dataSetId) {
		getPersistence().removeByDataSetId(dataSetId);
	}

	/**
	 * Returns the number of set type links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching set type links
	 */
	public static int countByDataSetId(long dataSetId) {
		return getPersistence().countByDataSetId(dataSetId);
	}

	/**
	 * Returns all the set type links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching set type links
	 */
	public static List<SetTypeLink> findByDataTypeId(long dataTypeId) {
		return getPersistence().findByDataTypeId(dataTypeId);
	}

	/**
	 * Returns a range of all the set type links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of matching set type links
	 */
	public static List<SetTypeLink> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return getPersistence().findByDataTypeId(dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the set type links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the set type links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByDataTypeId_First(
			long dataTypeId, OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByDataTypeId_First(
		long dataTypeId, OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByDataTypeId_Last(
			long dataTypeId, OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByDataTypeId_Last(
		long dataTypeId, OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink[] findByDataTypeId_PrevAndNext(
			long setTypeLinkId, long dataTypeId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByDataTypeId_PrevAndNext(
			setTypeLinkId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the set type links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public static void removeByDataTypeId(long dataTypeId) {
		getPersistence().removeByDataTypeId(dataTypeId);
	}

	/**
	 * Returns the number of set type links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching set type links
	 */
	public static int countByDataTypeId(long dataTypeId) {
		return getPersistence().countByDataTypeId(dataTypeId);
	}

	/**
	 * Returns all the set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the matching set type links
	 */
	public static List<SetTypeLink> findByCollection_G(
		long groupId, long dataTypeId) {

		return getPersistence().findByCollection_G(groupId, dataTypeId);
	}

	/**
	 * Returns a range of all the set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of matching set type links
	 */
	public static List<SetTypeLink> findByCollection_G(
		long groupId, long dataTypeId, int start, int end) {

		return getPersistence().findByCollection_G(
			groupId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByCollection_G(
		long groupId, long dataTypeId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().findByCollection_G(
			groupId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByCollection_G(
		long groupId, long dataTypeId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollection_G(
			groupId, dataTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByCollection_G_First(
			long groupId, long dataTypeId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByCollection_G_First(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByCollection_G_First(
		long groupId, long dataTypeId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByCollection_G_First(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByCollection_G_Last(
			long groupId, long dataTypeId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByCollection_G_Last(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByCollection_G_Last(
		long groupId, long dataTypeId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByCollection_G_Last(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink[] findByCollection_G_PrevAndNext(
			long setTypeLinkId, long groupId, long dataTypeId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByCollection_G_PrevAndNext(
			setTypeLinkId, groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the set type links where groupId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeByCollection_G(long groupId, long dataTypeId) {
		getPersistence().removeByCollection_G(groupId, dataTypeId);
	}

	/**
	 * Returns the number of set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching set type links
	 */
	public static int countByCollection_G(long groupId, long dataTypeId) {
		return getPersistence().countByCollection_G(groupId, dataTypeId);
	}

	/**
	 * Returns all the set type links where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @return the matching set type links
	 */
	public static List<SetTypeLink> findBySet_G(long groupId, long dataSetId) {
		return getPersistence().findBySet_G(groupId, dataSetId);
	}

	/**
	 * Returns a range of all the set type links where groupId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of matching set type links
	 */
	public static List<SetTypeLink> findBySet_G(
		long groupId, long dataSetId, int start, int end) {

		return getPersistence().findBySet_G(groupId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the set type links where groupId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findBySet_G(
		long groupId, long dataSetId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().findBySet_G(
			groupId, dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the set type links where groupId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findBySet_G(
		long groupId, long dataSetId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySet_G(
			groupId, dataSetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findBySet_G_First(
			long groupId, long dataSetId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findBySet_G_First(
			groupId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchBySet_G_First(
		long groupId, long dataSetId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchBySet_G_First(
			groupId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findBySet_G_Last(
			long groupId, long dataSetId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findBySet_G_Last(
			groupId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchBySet_G_Last(
		long groupId, long dataSetId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchBySet_G_Last(
			groupId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink[] findBySet_G_PrevAndNext(
			long setTypeLinkId, long groupId, long dataSetId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findBySet_G_PrevAndNext(
			setTypeLinkId, groupId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the set type links where groupId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 */
	public static void removeBySet_G(long groupId, long dataSetId) {
		getPersistence().removeBySet_G(groupId, dataSetId);
	}

	/**
	 * Returns the number of set type links where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @return the number of matching set type links
	 */
	public static int countBySet_G(long groupId, long dataSetId) {
		return getPersistence().countBySet_G(groupId, dataSetId);
	}

	/**
	 * Returns all the set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the matching set type links
	 */
	public static List<SetTypeLink> findByType_G(
		long groupId, long dataTypeId) {

		return getPersistence().findByType_G(groupId, dataTypeId);
	}

	/**
	 * Returns a range of all the set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of matching set type links
	 */
	public static List<SetTypeLink> findByType_G(
		long groupId, long dataTypeId, int start, int end) {

		return getPersistence().findByType_G(groupId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByType_G(
		long groupId, long dataTypeId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().findByType_G(
			groupId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByType_G(
		long groupId, long dataTypeId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByType_G(
			groupId, dataTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByType_G_First(
			long groupId, long dataTypeId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByType_G_First(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByType_G_First(
		long groupId, long dataTypeId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByType_G_First(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByType_G_Last(
			long groupId, long dataTypeId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByType_G_Last(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByType_G_Last(
		long groupId, long dataTypeId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByType_G_Last(
			groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink[] findByType_G_PrevAndNext(
			long setTypeLinkId, long groupId, long dataTypeId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByType_G_PrevAndNext(
			setTypeLinkId, groupId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the set type links where groupId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeByType_G(long groupId, long dataTypeId) {
		getPersistence().removeByType_G(groupId, dataTypeId);
	}

	/**
	 * Returns the number of set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching set type links
	 */
	public static int countByType_G(long groupId, long dataTypeId) {
		return getPersistence().countByType_G(groupId, dataTypeId);
	}

	/**
	 * Returns all the set type links where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching set type links
	 */
	public static List<SetTypeLink> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId) {

		return getPersistence().findByCollectionSet_G(
			groupId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns a range of all the set type links where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of matching set type links
	 */
	public static List<SetTypeLink> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId, int start,
		int end) {

		return getPersistence().findByCollectionSet_G(
			groupId, dataCollectionId, dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the set type links where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().findByCollectionSet_G(
			groupId, dataCollectionId, dataSetId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the set type links where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCollectionSet_G(
			groupId, dataCollectionId, dataSetId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByCollectionSet_G_First(
			long groupId, long dataCollectionId, long dataSetId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByCollectionSet_G_First(
			groupId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByCollectionSet_G_First(
		long groupId, long dataCollectionId, long dataSetId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_First(
			groupId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByCollectionSet_G_Last(
			long groupId, long dataCollectionId, long dataSetId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByCollectionSet_G_Last(
			groupId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByCollectionSet_G_Last(
		long groupId, long dataCollectionId, long dataSetId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchByCollectionSet_G_Last(
			groupId, dataCollectionId, dataSetId, orderByComparator);
	}

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink[] findByCollectionSet_G_PrevAndNext(
			long setTypeLinkId, long groupId, long dataCollectionId,
			long dataSetId, OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByCollectionSet_G_PrevAndNext(
			setTypeLinkId, groupId, dataCollectionId, dataSetId,
			orderByComparator);
	}

	/**
	 * Removes all the set type links where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 */
	public static void removeByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId) {

		getPersistence().removeByCollectionSet_G(
			groupId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns the number of set type links where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the number of matching set type links
	 */
	public static int countByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId) {

		return getPersistence().countByCollectionSet_G(
			groupId, dataCollectionId, dataSetId);
	}

	/**
	 * Returns all the set type links where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching set type links
	 */
	public static List<SetTypeLink> findBySetType(
		long dataSetId, long dataTypeId) {

		return getPersistence().findBySetType(dataSetId, dataTypeId);
	}

	/**
	 * Returns a range of all the set type links where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of matching set type links
	 */
	public static List<SetTypeLink> findBySetType(
		long dataSetId, long dataTypeId, int start, int end) {

		return getPersistence().findBySetType(
			dataSetId, dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the set type links where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findBySetType(
		long dataSetId, long dataTypeId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().findBySetType(
			dataSetId, dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the set type links where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching set type links
	 */
	public static List<SetTypeLink> findBySetType(
		long dataSetId, long dataTypeId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySetType(
			dataSetId, dataTypeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first set type link in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findBySetType_First(
			long dataSetId, long dataTypeId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findBySetType_First(
			dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first set type link in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchBySetType_First(
		long dataSetId, long dataTypeId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchBySetType_First(
			dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findBySetType_Last(
			long dataSetId, long dataTypeId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findBySetType_Last(
			dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last set type link in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchBySetType_Last(
		long dataSetId, long dataTypeId,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().fetchBySetType_Last(
			dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink[] findBySetType_PrevAndNext(
			long setTypeLinkId, long dataSetId, long dataTypeId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findBySetType_PrevAndNext(
			setTypeLinkId, dataSetId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the set type links where dataSetId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 */
	public static void removeBySetType(long dataSetId, long dataTypeId) {
		getPersistence().removeBySetType(dataSetId, dataTypeId);
	}

	/**
	 * Returns the number of set type links where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching set type links
	 */
	public static int countBySetType(long dataSetId, long dataTypeId) {
		return getPersistence().countBySetType(dataSetId, dataTypeId);
	}

	/**
	 * Returns the set type link where groupId = &#63; and dataSetId = &#63; and dataCollectionId = &#63; and dataTypeId = &#63; or throws a <code>NoSuchSetTypeLinkException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataCollectionId the data collection ID
	 * @param dataTypeId the data type ID
	 * @return the matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public static SetTypeLink findByCollectionSetType_G(
			long groupId, long dataSetId, long dataCollectionId,
			long dataTypeId)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByCollectionSetType_G(
			groupId, dataSetId, dataCollectionId, dataTypeId);
	}

	/**
	 * Returns the set type link where groupId = &#63; and dataSetId = &#63; and dataCollectionId = &#63; and dataTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataCollectionId the data collection ID
	 * @param dataTypeId the data type ID
	 * @return the matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByCollectionSetType_G(
		long groupId, long dataSetId, long dataCollectionId, long dataTypeId) {

		return getPersistence().fetchByCollectionSetType_G(
			groupId, dataSetId, dataCollectionId, dataTypeId);
	}

	/**
	 * Returns the set type link where groupId = &#63; and dataSetId = &#63; and dataCollectionId = &#63; and dataTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataCollectionId the data collection ID
	 * @param dataTypeId the data type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public static SetTypeLink fetchByCollectionSetType_G(
		long groupId, long dataSetId, long dataCollectionId, long dataTypeId,
		boolean useFinderCache) {

		return getPersistence().fetchByCollectionSetType_G(
			groupId, dataSetId, dataCollectionId, dataTypeId, useFinderCache);
	}

	/**
	 * Removes the set type link where groupId = &#63; and dataSetId = &#63; and dataCollectionId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataCollectionId the data collection ID
	 * @param dataTypeId the data type ID
	 * @return the set type link that was removed
	 */
	public static SetTypeLink removeByCollectionSetType_G(
			long groupId, long dataSetId, long dataCollectionId,
			long dataTypeId)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().removeByCollectionSetType_G(
			groupId, dataSetId, dataCollectionId, dataTypeId);
	}

	/**
	 * Returns the number of set type links where groupId = &#63; and dataSetId = &#63; and dataCollectionId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataCollectionId the data collection ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching set type links
	 */
	public static int countByCollectionSetType_G(
		long groupId, long dataSetId, long dataCollectionId, long dataTypeId) {

		return getPersistence().countByCollectionSetType_G(
			groupId, dataSetId, dataCollectionId, dataTypeId);
	}

	/**
	 * Caches the set type link in the entity cache if it is enabled.
	 *
	 * @param setTypeLink the set type link
	 */
	public static void cacheResult(SetTypeLink setTypeLink) {
		getPersistence().cacheResult(setTypeLink);
	}

	/**
	 * Caches the set type links in the entity cache if it is enabled.
	 *
	 * @param setTypeLinks the set type links
	 */
	public static void cacheResult(List<SetTypeLink> setTypeLinks) {
		getPersistence().cacheResult(setTypeLinks);
	}

	/**
	 * Creates a new set type link with the primary key. Does not add the set type link to the database.
	 *
	 * @param setTypeLinkId the primary key for the new set type link
	 * @return the new set type link
	 */
	public static SetTypeLink create(long setTypeLinkId) {
		return getPersistence().create(setTypeLinkId);
	}

	/**
	 * Removes the set type link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link that was removed
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink remove(long setTypeLinkId)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().remove(setTypeLinkId);
	}

	public static SetTypeLink updateImpl(SetTypeLink setTypeLink) {
		return getPersistence().updateImpl(setTypeLink);
	}

	/**
	 * Returns the set type link with the primary key or throws a <code>NoSuchSetTypeLinkException</code> if it could not be found.
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink findByPrimaryKey(long setTypeLinkId)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getPersistence().findByPrimaryKey(setTypeLinkId);
	}

	/**
	 * Returns the set type link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link, or <code>null</code> if a set type link with the primary key could not be found
	 */
	public static SetTypeLink fetchByPrimaryKey(long setTypeLinkId) {
		return getPersistence().fetchByPrimaryKey(setTypeLinkId);
	}

	/**
	 * Returns all the set type links.
	 *
	 * @return the set type links
	 */
	public static List<SetTypeLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the set type links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of set type links
	 */
	public static List<SetTypeLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the set type links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of set type links
	 */
	public static List<SetTypeLink> findAll(
		int start, int end, OrderByComparator<SetTypeLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the set type links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of set type links
	 */
	public static List<SetTypeLink> findAll(
		int start, int end, OrderByComparator<SetTypeLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the set type links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of set type links.
	 *
	 * @return the number of set type links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SetTypeLinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SetTypeLinkPersistence _persistence;

}