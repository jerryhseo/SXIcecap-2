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

import com.sx.icecap.model.StructureParamLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the structure param link service. This utility wraps <code>com.sx.icecap.service.persistence.impl.StructureParamLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StructureParamLinkPersistence
 * @generated
 */
public class StructureParamLinkUtil {

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
	public static void clearCache(StructureParamLink structureParamLink) {
		getPersistence().clearCache(structureParamLink);
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
	public static Map<Serializable, StructureParamLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StructureParamLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StructureParamLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StructureParamLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StructureParamLink update(
		StructureParamLink structureParamLink) {

		return getPersistence().update(structureParamLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StructureParamLink update(
		StructureParamLink structureParamLink, ServiceContext serviceContext) {

		return getPersistence().update(structureParamLink, serviceContext);
	}

	/**
	 * Returns all the structure param links where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the matching structure param links
	 */
	public static List<StructureParamLink> findByDataStructureId(
		long dataStructureId) {

		return getPersistence().findByDataStructureId(dataStructureId);
	}

	/**
	 * Returns a range of all the structure param links where dataStructureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataStructureId the data structure ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @return the range of matching structure param links
	 */
	public static List<StructureParamLink> findByDataStructureId(
		long dataStructureId, int start, int end) {

		return getPersistence().findByDataStructureId(
			dataStructureId, start, end);
	}

	/**
	 * Returns an ordered range of all the structure param links where dataStructureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataStructureId the data structure ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structure param links
	 */
	public static List<StructureParamLink> findByDataStructureId(
		long dataStructureId, int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator) {

		return getPersistence().findByDataStructureId(
			dataStructureId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structure param links where dataStructureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataStructureId the data structure ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structure param links
	 */
	public static List<StructureParamLink> findByDataStructureId(
		long dataStructureId, int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataStructureId(
			dataStructureId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	public static StructureParamLink findByDataStructureId_First(
			long dataStructureId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructureParamLinkException {

		return getPersistence().findByDataStructureId_First(
			dataStructureId, orderByComparator);
	}

	/**
	 * Returns the first structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	public static StructureParamLink fetchByDataStructureId_First(
		long dataStructureId,
		OrderByComparator<StructureParamLink> orderByComparator) {

		return getPersistence().fetchByDataStructureId_First(
			dataStructureId, orderByComparator);
	}

	/**
	 * Returns the last structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	public static StructureParamLink findByDataStructureId_Last(
			long dataStructureId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructureParamLinkException {

		return getPersistence().findByDataStructureId_Last(
			dataStructureId, orderByComparator);
	}

	/**
	 * Returns the last structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	public static StructureParamLink fetchByDataStructureId_Last(
		long dataStructureId,
		OrderByComparator<StructureParamLink> orderByComparator) {

		return getPersistence().fetchByDataStructureId_Last(
			dataStructureId, orderByComparator);
	}

	/**
	 * Returns the structure param links before and after the current structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param structureParamLinkId the primary key of the current structure param link
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structure param link
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	public static StructureParamLink[] findByDataStructureId_PrevAndNext(
			long structureParamLinkId, long dataStructureId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructureParamLinkException {

		return getPersistence().findByDataStructureId_PrevAndNext(
			structureParamLinkId, dataStructureId, orderByComparator);
	}

	/**
	 * Removes all the structure param links where dataStructureId = &#63; from the database.
	 *
	 * @param dataStructureId the data structure ID
	 */
	public static void removeByDataStructureId(long dataStructureId) {
		getPersistence().removeByDataStructureId(dataStructureId);
	}

	/**
	 * Returns the number of structure param links where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the number of matching structure param links
	 */
	public static int countByDataStructureId(long dataStructureId) {
		return getPersistence().countByDataStructureId(dataStructureId);
	}

	/**
	 * Returns all the structure param links where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @return the matching structure param links
	 */
	public static List<StructureParamLink> findByParameterId(long parameterId) {
		return getPersistence().findByParameterId(parameterId);
	}

	/**
	 * Returns a range of all the structure param links where parameterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param parameterId the parameter ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @return the range of matching structure param links
	 */
	public static List<StructureParamLink> findByParameterId(
		long parameterId, int start, int end) {

		return getPersistence().findByParameterId(parameterId, start, end);
	}

	/**
	 * Returns an ordered range of all the structure param links where parameterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param parameterId the parameter ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structure param links
	 */
	public static List<StructureParamLink> findByParameterId(
		long parameterId, int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator) {

		return getPersistence().findByParameterId(
			parameterId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structure param links where parameterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param parameterId the parameter ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structure param links
	 */
	public static List<StructureParamLink> findByParameterId(
		long parameterId, int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParameterId(
			parameterId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	public static StructureParamLink findByParameterId_First(
			long parameterId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructureParamLinkException {

		return getPersistence().findByParameterId_First(
			parameterId, orderByComparator);
	}

	/**
	 * Returns the first structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	public static StructureParamLink fetchByParameterId_First(
		long parameterId,
		OrderByComparator<StructureParamLink> orderByComparator) {

		return getPersistence().fetchByParameterId_First(
			parameterId, orderByComparator);
	}

	/**
	 * Returns the last structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	public static StructureParamLink findByParameterId_Last(
			long parameterId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructureParamLinkException {

		return getPersistence().findByParameterId_Last(
			parameterId, orderByComparator);
	}

	/**
	 * Returns the last structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	public static StructureParamLink fetchByParameterId_Last(
		long parameterId,
		OrderByComparator<StructureParamLink> orderByComparator) {

		return getPersistence().fetchByParameterId_Last(
			parameterId, orderByComparator);
	}

	/**
	 * Returns the structure param links before and after the current structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param structureParamLinkId the primary key of the current structure param link
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structure param link
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	public static StructureParamLink[] findByParameterId_PrevAndNext(
			long structureParamLinkId, long parameterId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructureParamLinkException {

		return getPersistence().findByParameterId_PrevAndNext(
			structureParamLinkId, parameterId, orderByComparator);
	}

	/**
	 * Removes all the structure param links where parameterId = &#63; from the database.
	 *
	 * @param parameterId the parameter ID
	 */
	public static void removeByParameterId(long parameterId) {
		getPersistence().removeByParameterId(parameterId);
	}

	/**
	 * Returns the number of structure param links where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @return the number of matching structure param links
	 */
	public static int countByParameterId(long parameterId) {
		return getPersistence().countByParameterId(parameterId);
	}

	/**
	 * Caches the structure param link in the entity cache if it is enabled.
	 *
	 * @param structureParamLink the structure param link
	 */
	public static void cacheResult(StructureParamLink structureParamLink) {
		getPersistence().cacheResult(structureParamLink);
	}

	/**
	 * Caches the structure param links in the entity cache if it is enabled.
	 *
	 * @param structureParamLinks the structure param links
	 */
	public static void cacheResult(
		List<StructureParamLink> structureParamLinks) {

		getPersistence().cacheResult(structureParamLinks);
	}

	/**
	 * Creates a new structure param link with the primary key. Does not add the structure param link to the database.
	 *
	 * @param structureParamLinkId the primary key for the new structure param link
	 * @return the new structure param link
	 */
	public static StructureParamLink create(long structureParamLinkId) {
		return getPersistence().create(structureParamLinkId);
	}

	/**
	 * Removes the structure param link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param structureParamLinkId the primary key of the structure param link
	 * @return the structure param link that was removed
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	public static StructureParamLink remove(long structureParamLinkId)
		throws com.sx.icecap.exception.NoSuchStructureParamLinkException {

		return getPersistence().remove(structureParamLinkId);
	}

	public static StructureParamLink updateImpl(
		StructureParamLink structureParamLink) {

		return getPersistence().updateImpl(structureParamLink);
	}

	/**
	 * Returns the structure param link with the primary key or throws a <code>NoSuchStructureParamLinkException</code> if it could not be found.
	 *
	 * @param structureParamLinkId the primary key of the structure param link
	 * @return the structure param link
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	public static StructureParamLink findByPrimaryKey(long structureParamLinkId)
		throws com.sx.icecap.exception.NoSuchStructureParamLinkException {

		return getPersistence().findByPrimaryKey(structureParamLinkId);
	}

	/**
	 * Returns the structure param link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param structureParamLinkId the primary key of the structure param link
	 * @return the structure param link, or <code>null</code> if a structure param link with the primary key could not be found
	 */
	public static StructureParamLink fetchByPrimaryKey(
		long structureParamLinkId) {

		return getPersistence().fetchByPrimaryKey(structureParamLinkId);
	}

	/**
	 * Returns all the structure param links.
	 *
	 * @return the structure param links
	 */
	public static List<StructureParamLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the structure param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @return the range of structure param links
	 */
	public static List<StructureParamLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the structure param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of structure param links
	 */
	public static List<StructureParamLink> findAll(
		int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structure param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of structure param links
	 */
	public static List<StructureParamLink> findAll(
		int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the structure param links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of structure param links.
	 *
	 * @return the number of structure param links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StructureParamLinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile StructureParamLinkPersistence _persistence;

}