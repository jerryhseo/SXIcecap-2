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
	 * Returns all the type structure links where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching type structure links
	 */
	public static List<TypeStructureLink> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the type structure links where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	public static List<TypeStructureLink> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByUserId_First(
			long userId, OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByUserId_First(
		long userId, OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByUserId_Last(
			long userId, OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByUserId_Last(
		long userId, OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where userId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink[] findByUserId_PrevAndNext(
			long dataTypeId, long userId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByUserId_PrevAndNext(
			dataTypeId, userId, orderByComparator);
	}

	/**
	 * Removes all the type structure links where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of type structure links where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching type structure links
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the type structure links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching type structure links
	 */
	public static List<TypeStructureLink> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	public static List<TypeStructureLink> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByGroupId_First(
			long groupId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByGroupId_First(
		long groupId, OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByGroupId_Last(
			long groupId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByGroupId_Last(
		long groupId, OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink[] findByGroupId_PrevAndNext(
			long dataTypeId, long groupId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByGroupId_PrevAndNext(
			dataTypeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the type structure links where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of type structure links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching type structure links
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching type structure links
	 */
	public static List<TypeStructureLink> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	public static List<TypeStructureLink> findByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByG_U_First(
			long groupId, long userId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink[] findByG_U_PrevAndNext(
			long dataTypeId, long groupId, long userId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByG_U_PrevAndNext(
			dataTypeId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the type structure links where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching type structure links
	 */
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
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
	 * Returns the type structure link where groupId = &#63; and dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByDataStructureId_G(
			long groupId, long dataStructureId)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByDataStructureId_G(
			groupId, dataStructureId);
	}

	/**
	 * Returns the type structure link where groupId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByDataStructureId_G(
		long groupId, long dataStructureId) {

		return getPersistence().fetchByDataStructureId_G(
			groupId, dataStructureId);
	}

	/**
	 * Returns the type structure link where groupId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByDataStructureId_G(
		long groupId, long dataStructureId, boolean useFinderCache) {

		return getPersistence().fetchByDataStructureId_G(
			groupId, dataStructureId, useFinderCache);
	}

	/**
	 * Removes the type structure link where groupId = &#63; and dataStructureId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	public static TypeStructureLink removeByDataStructureId_G(
			long groupId, long dataStructureId)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().removeByDataStructureId_G(
			groupId, dataStructureId);
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and dataStructureId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	public static int countByDataStructureId_G(
		long groupId, long dataStructureId) {

		return getPersistence().countByDataStructureId_G(
			groupId, dataStructureId);
	}

	/**
	 * Returns the type structure link where userId = &#63; and dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByDataStructureId_U(
			long userId, long dataStructureId)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByDataStructureId_U(
			userId, dataStructureId);
	}

	/**
	 * Returns the type structure link where userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByDataStructureId_U(
		long userId, long dataStructureId) {

		return getPersistence().fetchByDataStructureId_U(
			userId, dataStructureId);
	}

	/**
	 * Returns the type structure link where userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByDataStructureId_U(
		long userId, long dataStructureId, boolean useFinderCache) {

		return getPersistence().fetchByDataStructureId_U(
			userId, dataStructureId, useFinderCache);
	}

	/**
	 * Removes the type structure link where userId = &#63; and dataStructureId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	public static TypeStructureLink removeByDataStructureId_U(
			long userId, long dataStructureId)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().removeByDataStructureId_U(
			userId, dataStructureId);
	}

	/**
	 * Returns the number of type structure links where userId = &#63; and dataStructureId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	public static int countByDataStructureId_U(
		long userId, long dataStructureId) {

		return getPersistence().countByDataStructureId_U(
			userId, dataStructureId);
	}

	/**
	 * Returns the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByDataStructureId_G_U(
			long groupId, long userId, long dataStructureId)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByDataStructureId_G_U(
			groupId, userId, dataStructureId);
	}

	/**
	 * Returns the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByDataStructureId_G_U(
		long groupId, long userId, long dataStructureId) {

		return getPersistence().fetchByDataStructureId_G_U(
			groupId, userId, dataStructureId);
	}

	/**
	 * Returns the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByDataStructureId_G_U(
		long groupId, long userId, long dataStructureId,
		boolean useFinderCache) {

		return getPersistence().fetchByDataStructureId_G_U(
			groupId, userId, dataStructureId, useFinderCache);
	}

	/**
	 * Removes the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	public static TypeStructureLink removeByDataStructureId_G_U(
			long groupId, long userId, long dataStructureId)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().removeByDataStructureId_G_U(
			groupId, userId, dataStructureId);
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63; and dataStructureId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	public static int countByDataStructureId_G_U(
		long groupId, long userId, long dataStructureId) {

		return getPersistence().countByDataStructureId_G_U(
			groupId, userId, dataStructureId);
	}

	/**
	 * Returns all the type structure links where verified = &#63;.
	 *
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified(boolean verified) {
		return getPersistence().findByVerified(verified);
	}

	/**
	 * Returns a range of all the type structure links where verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified(
		boolean verified, int start, int end) {

		return getPersistence().findByVerified(verified, start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links where verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified(
		boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findByVerified(
			verified, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links where verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified(
		boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVerified(
			verified, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByVerified_First(
			boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_First(
			verified, orderByComparator);
	}

	/**
	 * Returns the first type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByVerified_First(
		boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByVerified_First(
			verified, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByVerified_Last(
			boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_Last(
			verified, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByVerified_Last(
		boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByVerified_Last(
			verified, orderByComparator);
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where verified = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink[] findByVerified_PrevAndNext(
			long dataTypeId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_PrevAndNext(
			dataTypeId, verified, orderByComparator);
	}

	/**
	 * Removes all the type structure links where verified = &#63; from the database.
	 *
	 * @param verified the verified
	 */
	public static void removeByVerified(boolean verified) {
		getPersistence().removeByVerified(verified);
	}

	/**
	 * Returns the number of type structure links where verified = &#63;.
	 *
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	public static int countByVerified(boolean verified) {
		return getPersistence().countByVerified(verified);
	}

	/**
	 * Returns all the type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified) {

		return getPersistence().findByVerified_G(groupId, verified);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified, int start, int end) {

		return getPersistence().findByVerified_G(groupId, verified, start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findByVerified_G(
			groupId, verified, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVerified_G(
			groupId, verified, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByVerified_G_First(
			long groupId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_G_First(
			groupId, verified, orderByComparator);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByVerified_G_First(
		long groupId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByVerified_G_First(
			groupId, verified, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByVerified_G_Last(
			long groupId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_G_Last(
			groupId, verified, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByVerified_G_Last(
		long groupId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByVerified_G_Last(
			groupId, verified, orderByComparator);
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink[] findByVerified_G_PrevAndNext(
			long dataTypeId, long groupId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_G_PrevAndNext(
			dataTypeId, groupId, verified, orderByComparator);
	}

	/**
	 * Removes all the type structure links where groupId = &#63; and verified = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 */
	public static void removeByVerified_G(long groupId, boolean verified) {
		getPersistence().removeByVerified_G(groupId, verified);
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	public static int countByVerified_G(long groupId, boolean verified) {
		return getPersistence().countByVerified_G(groupId, verified);
	}

	/**
	 * Returns all the type structure links where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified) {

		return getPersistence().findByVerified_U(userId, verified);
	}

	/**
	 * Returns a range of all the type structure links where userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified, int start, int end) {

		return getPersistence().findByVerified_U(userId, verified, start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findByVerified_U(
			userId, verified, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVerified_U(
			userId, verified, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByVerified_U_First(
			long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_U_First(
			userId, verified, orderByComparator);
	}

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByVerified_U_First(
		long userId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByVerified_U_First(
			userId, verified, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByVerified_U_Last(
			long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_U_Last(
			userId, verified, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByVerified_U_Last(
		long userId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByVerified_U_Last(
			userId, verified, orderByComparator);
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink[] findByVerified_U_PrevAndNext(
			long dataTypeId, long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_U_PrevAndNext(
			dataTypeId, userId, verified, orderByComparator);
	}

	/**
	 * Removes all the type structure links where userId = &#63; and verified = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 */
	public static void removeByVerified_U(long userId, boolean verified) {
		getPersistence().removeByVerified_U(userId, verified);
	}

	/**
	 * Returns the number of type structure links where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	public static int countByVerified_U(long userId, boolean verified) {
		return getPersistence().countByVerified_U(userId, verified);
	}

	/**
	 * Returns all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified) {

		return getPersistence().findByVerified_G_U(groupId, userId, verified);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified, int start, int end) {

		return getPersistence().findByVerified_G_U(
			groupId, userId, verified, start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findByVerified_G_U(
			groupId, userId, verified, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVerified_G_U(
			groupId, userId, verified, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByVerified_G_U_First(
			long groupId, long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_G_U_First(
			groupId, userId, verified, orderByComparator);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByVerified_G_U_First(
		long groupId, long userId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByVerified_G_U_First(
			groupId, userId, verified, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByVerified_G_U_Last(
			long groupId, long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_G_U_Last(
			groupId, userId, verified, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByVerified_G_U_Last(
		long groupId, long userId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByVerified_G_U_Last(
			groupId, userId, verified, orderByComparator);
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink[] findByVerified_G_U_PrevAndNext(
			long dataTypeId, long groupId, long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByVerified_G_U_PrevAndNext(
			dataTypeId, groupId, userId, verified, orderByComparator);
	}

	/**
	 * Removes all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 */
	public static void removeByVerified_G_U(
		long groupId, long userId, boolean verified) {

		getPersistence().removeByVerified_G_U(groupId, userId, verified);
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	public static int countByVerified_G_U(
		long groupId, long userId, boolean verified) {

		return getPersistence().countByVerified_G_U(groupId, userId, verified);
	}

	/**
	 * Returns all the type structure links where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed(boolean freezed) {
		return getPersistence().findByFreezed(freezed);
	}

	/**
	 * Returns a range of all the type structure links where freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed(
		boolean freezed, int start, int end) {

		return getPersistence().findByFreezed(freezed, start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links where freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed(
		boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findByFreezed(
			freezed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links where freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed(
		boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFreezed(
			freezed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByFreezed_First(
			boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_First(freezed, orderByComparator);
	}

	/**
	 * Returns the first type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByFreezed_First(
		boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByFreezed_First(
			freezed, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByFreezed_Last(
			boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_Last(freezed, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByFreezed_Last(
		boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByFreezed_Last(freezed, orderByComparator);
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink[] findByFreezed_PrevAndNext(
			long dataTypeId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_PrevAndNext(
			dataTypeId, freezed, orderByComparator);
	}

	/**
	 * Removes all the type structure links where freezed = &#63; from the database.
	 *
	 * @param freezed the freezed
	 */
	public static void removeByFreezed(boolean freezed) {
		getPersistence().removeByFreezed(freezed);
	}

	/**
	 * Returns the number of type structure links where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	public static int countByFreezed(boolean freezed) {
		return getPersistence().countByFreezed(freezed);
	}

	/**
	 * Returns all the type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed) {

		return getPersistence().findByFreezed_G(groupId, freezed);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed, int start, int end) {

		return getPersistence().findByFreezed_G(groupId, freezed, start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findByFreezed_G(
			groupId, freezed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFreezed_G(
			groupId, freezed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByFreezed_G_First(
			long groupId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_G_First(
			groupId, freezed, orderByComparator);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByFreezed_G_First(
		long groupId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByFreezed_G_First(
			groupId, freezed, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByFreezed_G_Last(
			long groupId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_G_Last(
			groupId, freezed, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByFreezed_G_Last(
		long groupId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByFreezed_G_Last(
			groupId, freezed, orderByComparator);
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink[] findByFreezed_G_PrevAndNext(
			long dataTypeId, long groupId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_G_PrevAndNext(
			dataTypeId, groupId, freezed, orderByComparator);
	}

	/**
	 * Removes all the type structure links where groupId = &#63; and freezed = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 */
	public static void removeByFreezed_G(long groupId, boolean freezed) {
		getPersistence().removeByFreezed_G(groupId, freezed);
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	public static int countByFreezed_G(long groupId, boolean freezed) {
		return getPersistence().countByFreezed_G(groupId, freezed);
	}

	/**
	 * Returns all the type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed) {

		return getPersistence().findByFreezed_U(userId, freezed);
	}

	/**
	 * Returns a range of all the type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed, int start, int end) {

		return getPersistence().findByFreezed_U(userId, freezed, start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findByFreezed_U(
			userId, freezed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFreezed_U(
			userId, freezed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByFreezed_U_First(
			long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_U_First(
			userId, freezed, orderByComparator);
	}

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByFreezed_U_First(
		long userId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByFreezed_U_First(
			userId, freezed, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByFreezed_U_Last(
			long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_U_Last(
			userId, freezed, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByFreezed_U_Last(
		long userId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByFreezed_U_Last(
			userId, freezed, orderByComparator);
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink[] findByFreezed_U_PrevAndNext(
			long dataTypeId, long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_U_PrevAndNext(
			dataTypeId, userId, freezed, orderByComparator);
	}

	/**
	 * Removes all the type structure links where userId = &#63; and freezed = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 */
	public static void removeByFreezed_U(long userId, boolean freezed) {
		getPersistence().removeByFreezed_U(userId, freezed);
	}

	/**
	 * Returns the number of type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	public static int countByFreezed_U(long userId, boolean freezed) {
		return getPersistence().countByFreezed_U(userId, freezed);
	}

	/**
	 * Returns all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed) {

		return getPersistence().findByFreezed_G_U(groupId, userId, freezed);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed, int start, int end) {

		return getPersistence().findByFreezed_G_U(
			groupId, userId, freezed, start, end);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().findByFreezed_G_U(
			groupId, userId, freezed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	public static List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFreezed_G_U(
			groupId, userId, freezed, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByFreezed_G_U_First(
			long groupId, long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_G_U_First(
			groupId, userId, freezed, orderByComparator);
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByFreezed_G_U_First(
		long groupId, long userId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByFreezed_G_U_First(
			groupId, userId, freezed, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public static TypeStructureLink findByFreezed_G_U_Last(
			long groupId, long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_G_U_Last(
			groupId, userId, freezed, orderByComparator);
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public static TypeStructureLink fetchByFreezed_G_U_Last(
		long groupId, long userId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return getPersistence().fetchByFreezed_G_U_Last(
			groupId, userId, freezed, orderByComparator);
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink[] findByFreezed_G_U_PrevAndNext(
			long dataTypeId, long groupId, long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchTypeStructureLinkException {

		return getPersistence().findByFreezed_G_U_PrevAndNext(
			dataTypeId, groupId, userId, freezed, orderByComparator);
	}

	/**
	 * Removes all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 */
	public static void removeByFreezed_G_U(
		long groupId, long userId, boolean freezed) {

		getPersistence().removeByFreezed_G_U(groupId, userId, freezed);
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	public static int countByFreezed_G_U(
		long groupId, long userId, boolean freezed) {

		return getPersistence().countByFreezed_G_U(groupId, userId, freezed);
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