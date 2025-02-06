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

import com.sx.icecap.model.Parameter;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the parameter service. This utility wraps <code>com.sx.icecap.service.persistence.impl.ParameterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ParameterPersistence
 * @generated
 */
public class ParameterUtil {

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
	public static void clearCache(Parameter parameter) {
		getPersistence().clearCache(parameter);
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
	public static Map<Serializable, Parameter> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Parameter> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Parameter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Parameter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Parameter update(Parameter parameter) {
		return getPersistence().update(parameter);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Parameter update(
		Parameter parameter, ServiceContext serviceContext) {

		return getPersistence().update(parameter, serviceContext);
	}

	/**
	 * Returns all the parameters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching parameters
	 */
	public static List<Parameter> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the parameters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters
	 */
	public static List<Parameter> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parameters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Parameter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first parameter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByUuid_First(
			String uuid, OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first parameter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByUuid_First(
		String uuid, OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByUuid_Last(
			String uuid, OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByUuid_Last(
		String uuid, OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where uuid = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] findByUuid_PrevAndNext(
			long parameterId, String uuid,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByUuid_PrevAndNext(
			parameterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the parameters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of parameters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching parameters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the parameter where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchParameterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the parameter where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the parameter where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the parameter where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the parameter that was removed
	 */
	public static Parameter removeByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of parameters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching parameters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the parameters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching parameters
	 */
	public static List<Parameter> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the parameters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters
	 */
	public static List<Parameter> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parameters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Parameter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first parameter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first parameter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] findByUuid_C_PrevAndNext(
			long parameterId, String uuid, long companyId,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			parameterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the parameters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of parameters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching parameters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the parameters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching parameters
	 */
	public static List<Parameter> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the parameters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters
	 */
	public static List<Parameter> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parameters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Parameter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByGroupId_First(
			long groupId, OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByGroupId_First(
		long groupId, OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByGroupId_Last(
			long groupId, OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByGroupId_Last(
		long groupId, OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where groupId = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] findByGroupId_PrevAndNext(
			long parameterId, long groupId,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByGroupId_PrevAndNext(
			parameterId, groupId, orderByComparator);
	}

	/**
	 * Returns all the parameters that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the parameters that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set of parameters that the user has permission to view where groupId = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] filterFindByGroupId_PrevAndNext(
			long parameterId, long groupId,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			parameterId, groupId, orderByComparator);
	}

	/**
	 * Removes all the parameters where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of parameters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching parameters
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of parameters that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching parameters that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the parameters where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching parameters
	 */
	public static List<Parameter> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the parameters where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters
	 */
	public static List<Parameter> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parameters where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Parameter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first parameter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByUserId_First(
			long userId, OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first parameter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByUserId_First(
		long userId, OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByUserId_Last(
			long userId, OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByUserId_Last(
		long userId, OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where userId = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] findByUserId_PrevAndNext(
			long parameterId, long userId,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByUserId_PrevAndNext(
			parameterId, userId, orderByComparator);
	}

	/**
	 * Removes all the parameters where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of parameters where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching parameters
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the parameters where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching parameters
	 */
	public static List<Parameter> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the parameters where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters
	 */
	public static List<Parameter> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByStatus(
		int status, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parameters where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByStatus(
		int status, int start, int end,
		OrderByComparator<Parameter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first parameter in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByStatus_First(
			int status, OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first parameter in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByStatus_First(
		int status, OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByStatus_Last(
			int status, OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByStatus_Last(
		int status, OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where status = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] findByStatus_PrevAndNext(
			long parameterId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByStatus_PrevAndNext(
			parameterId, status, orderByComparator);
	}

	/**
	 * Removes all the parameters where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of parameters where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching parameters
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the parameters where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching parameters
	 */
	public static List<Parameter> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the parameters where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters
	 */
	public static List<Parameter> findByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parameters where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<Parameter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByG_U_First(
			long groupId, long userId,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] findByG_U_PrevAndNext(
			long parameterId, long groupId, long userId,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByG_U_PrevAndNext(
			parameterId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns all the parameters that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByG_U(long groupId, long userId) {
		return getPersistence().filterFindByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the parameters that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().filterFindByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters that the user has permissions to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().filterFindByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set of parameters that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] filterFindByG_U_PrevAndNext(
			long parameterId, long groupId, long userId,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().filterFindByG_U_PrevAndNext(
			parameterId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the parameters where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	 * Returns the number of parameters where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching parameters
	 */
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	 * Returns the number of parameters that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching parameters that the user has permission to view
	 */
	public static int filterCountByG_U(long groupId, long userId) {
		return getPersistence().filterCountByG_U(groupId, userId);
	}

	/**
	 * Returns all the parameters where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching parameters
	 */
	public static List<Parameter> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the parameters where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters
	 */
	public static List<Parameter> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parameters where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Parameter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByG_S_First(
			long groupId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByG_S_Last(
			long groupId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] findByG_S_PrevAndNext(
			long parameterId, long groupId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByG_S_PrevAndNext(
			parameterId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the parameters that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the parameters that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set of parameters that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] filterFindByG_S_PrevAndNext(
			long parameterId, long groupId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			parameterId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the parameters where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of parameters where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching parameters
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of parameters that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching parameters that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns all the parameters where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching parameters
	 */
	public static List<Parameter> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the parameters where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters
	 */
	public static List<Parameter> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parameters where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<Parameter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first parameter in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByU_S_First(
			long userId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first parameter in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByU_S_First(
		long userId, int status,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByU_S_Last(
			long userId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] findByU_S_PrevAndNext(
			long parameterId, long userId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByU_S_PrevAndNext(
			parameterId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the parameters where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of parameters where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching parameters
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns all the parameters where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching parameters
	 */
	public static List<Parameter> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the parameters where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters
	 */
	public static List<Parameter> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parameters where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Parameter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] findByG_U_S_PrevAndNext(
			long parameterId, long groupId, long userId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByG_U_S_PrevAndNext(
			parameterId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the parameters that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterFindByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the parameters that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters that the user has permission to view
	 */
	public static List<Parameter> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set of parameters that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] filterFindByG_U_S_PrevAndNext(
			long parameterId, long groupId, long userId, int status,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().filterFindByG_U_S_PrevAndNext(
			parameterId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the parameters where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of parameters where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching parameters
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of parameters that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching parameters that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterCountByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns all the parameters where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @return the matching parameters
	 */
	public static List<Parameter> findByName(String paramName) {
		return getPersistence().findByName(paramName);
	}

	/**
	 * Returns a range of all the parameters where paramName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param paramName the param name
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of matching parameters
	 */
	public static List<Parameter> findByName(
		String paramName, int start, int end) {

		return getPersistence().findByName(paramName, start, end);
	}

	/**
	 * Returns an ordered range of all the parameters where paramName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param paramName the param name
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByName(
		String paramName, int start, int end,
		OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findByName(
			paramName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parameters where paramName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param paramName the param name
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching parameters
	 */
	public static List<Parameter> findByName(
		String paramName, int start, int end,
		OrderByComparator<Parameter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			paramName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first parameter in the ordered set where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByName_First(
			String paramName, OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByName_First(paramName, orderByComparator);
	}

	/**
	 * Returns the first parameter in the ordered set where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByName_First(
		String paramName, OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByName_First(paramName, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByName_Last(
			String paramName, OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByName_Last(paramName, orderByComparator);
	}

	/**
	 * Returns the last parameter in the ordered set where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByName_Last(
		String paramName, OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().fetchByName_Last(paramName, orderByComparator);
	}

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where paramName = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter[] findByName_PrevAndNext(
			long parameterId, String paramName,
			OrderByComparator<Parameter> orderByComparator)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByName_PrevAndNext(
			parameterId, paramName, orderByComparator);
	}

	/**
	 * Removes all the parameters where paramName = &#63; from the database.
	 *
	 * @param paramName the param name
	 */
	public static void removeByName(String paramName) {
		getPersistence().removeByName(paramName);
	}

	/**
	 * Returns the number of parameters where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @return the number of matching parameters
	 */
	public static int countByName(String paramName) {
		return getPersistence().countByName(paramName);
	}

	/**
	 * Returns the parameter where paramName = &#63; and paramVersion = &#63; or throws a <code>NoSuchParameterException</code> if it could not be found.
	 *
	 * @param paramName the param name
	 * @param paramVersion the param version
	 * @return the matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public static Parameter findByNameVersion(
			String paramName, String paramVersion)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByNameVersion(paramName, paramVersion);
	}

	/**
	 * Returns the parameter where paramName = &#63; and paramVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param paramName the param name
	 * @param paramVersion the param version
	 * @return the matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByNameVersion(
		String paramName, String paramVersion) {

		return getPersistence().fetchByNameVersion(paramName, paramVersion);
	}

	/**
	 * Returns the parameter where paramName = &#63; and paramVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param paramName the param name
	 * @param paramVersion the param version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public static Parameter fetchByNameVersion(
		String paramName, String paramVersion, boolean useFinderCache) {

		return getPersistence().fetchByNameVersion(
			paramName, paramVersion, useFinderCache);
	}

	/**
	 * Removes the parameter where paramName = &#63; and paramVersion = &#63; from the database.
	 *
	 * @param paramName the param name
	 * @param paramVersion the param version
	 * @return the parameter that was removed
	 */
	public static Parameter removeByNameVersion(
			String paramName, String paramVersion)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().removeByNameVersion(paramName, paramVersion);
	}

	/**
	 * Returns the number of parameters where paramName = &#63; and paramVersion = &#63;.
	 *
	 * @param paramName the param name
	 * @param paramVersion the param version
	 * @return the number of matching parameters
	 */
	public static int countByNameVersion(
		String paramName, String paramVersion) {

		return getPersistence().countByNameVersion(paramName, paramVersion);
	}

	/**
	 * Caches the parameter in the entity cache if it is enabled.
	 *
	 * @param parameter the parameter
	 */
	public static void cacheResult(Parameter parameter) {
		getPersistence().cacheResult(parameter);
	}

	/**
	 * Caches the parameters in the entity cache if it is enabled.
	 *
	 * @param parameters the parameters
	 */
	public static void cacheResult(List<Parameter> parameters) {
		getPersistence().cacheResult(parameters);
	}

	/**
	 * Creates a new parameter with the primary key. Does not add the parameter to the database.
	 *
	 * @param parameterId the primary key for the new parameter
	 * @return the new parameter
	 */
	public static Parameter create(long parameterId) {
		return getPersistence().create(parameterId);
	}

	/**
	 * Removes the parameter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parameterId the primary key of the parameter
	 * @return the parameter that was removed
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter remove(long parameterId)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().remove(parameterId);
	}

	public static Parameter updateImpl(Parameter parameter) {
		return getPersistence().updateImpl(parameter);
	}

	/**
	 * Returns the parameter with the primary key or throws a <code>NoSuchParameterException</code> if it could not be found.
	 *
	 * @param parameterId the primary key of the parameter
	 * @return the parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public static Parameter findByPrimaryKey(long parameterId)
		throws com.sx.icecap.exception.NoSuchParameterException {

		return getPersistence().findByPrimaryKey(parameterId);
	}

	/**
	 * Returns the parameter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parameterId the primary key of the parameter
	 * @return the parameter, or <code>null</code> if a parameter with the primary key could not be found
	 */
	public static Parameter fetchByPrimaryKey(long parameterId) {
		return getPersistence().fetchByPrimaryKey(parameterId);
	}

	/**
	 * Returns all the parameters.
	 *
	 * @return the parameters
	 */
	public static List<Parameter> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the parameters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of parameters
	 */
	public static List<Parameter> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the parameters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parameters
	 */
	public static List<Parameter> findAll(
		int start, int end, OrderByComparator<Parameter> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parameters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of parameters
	 */
	public static List<Parameter> findAll(
		int start, int end, OrderByComparator<Parameter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the parameters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of parameters.
	 *
	 * @return the number of parameters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ParameterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ParameterPersistence _persistence;

}