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

import com.sx.icecap.exception.NoSuchParameterException;
import com.sx.icecap.model.Parameter;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the parameter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ParameterUtil
 * @generated
 */
@ProviderType
public interface ParameterPersistence extends BasePersistence<Parameter> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ParameterUtil} to access the parameter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the parameters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching parameters
	 */
	public java.util.List<Parameter> findByUuid(String uuid);

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
	public java.util.List<Parameter> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Parameter> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public java.util.List<Parameter> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first parameter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the first parameter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the last parameter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the last parameter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where uuid = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public Parameter[] findByUuid_PrevAndNext(
			long parameterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Removes all the parameters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of parameters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching parameters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the parameter where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchParameterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByUUID_G(String uuid, long groupId)
		throws NoSuchParameterException;

	/**
	 * Returns the parameter where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the parameter where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the parameter where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the parameter that was removed
	 */
	public Parameter removeByUUID_G(String uuid, long groupId)
		throws NoSuchParameterException;

	/**
	 * Returns the number of parameters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching parameters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the parameters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching parameters
	 */
	public java.util.List<Parameter> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Parameter> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Parameter> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public java.util.List<Parameter> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first parameter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the first parameter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the last parameter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the last parameter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public Parameter[] findByUuid_C_PrevAndNext(
			long parameterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Removes all the parameters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of parameters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching parameters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the parameters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching parameters
	 */
	public java.util.List<Parameter> findByGroupId(long groupId);

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
	public java.util.List<Parameter> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Parameter> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public java.util.List<Parameter> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where groupId = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public Parameter[] findByGroupId_PrevAndNext(
			long parameterId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns all the parameters that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching parameters that the user has permission to view
	 */
	public java.util.List<Parameter> filterFindByGroupId(long groupId);

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
	public java.util.List<Parameter> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Parameter> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the parameters before and after the current parameter in the ordered set of parameters that the user has permission to view where groupId = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public Parameter[] filterFindByGroupId_PrevAndNext(
			long parameterId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Removes all the parameters where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of parameters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching parameters
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of parameters that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching parameters that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the parameters where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching parameters
	 */
	public java.util.List<Parameter> findByUserId(long userId);

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
	public java.util.List<Parameter> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<Parameter> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public java.util.List<Parameter> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first parameter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the first parameter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the last parameter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the last parameter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where userId = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public Parameter[] findByUserId_PrevAndNext(
			long parameterId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Removes all the parameters where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of parameters where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching parameters
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the parameters where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching parameters
	 */
	public java.util.List<Parameter> findByStatus(int status);

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
	public java.util.List<Parameter> findByStatus(
		int status, int start, int end);

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
	public java.util.List<Parameter> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public java.util.List<Parameter> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first parameter in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the first parameter in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the last parameter in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the last parameter in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where status = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public Parameter[] findByStatus_PrevAndNext(
			long parameterId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Removes all the parameters where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of parameters where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching parameters
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the parameters where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching parameters
	 */
	public java.util.List<Parameter> findByG_U(long groupId, long userId);

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
	public java.util.List<Parameter> findByG_U(
		long groupId, long userId, int start, int end);

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
	public java.util.List<Parameter> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public java.util.List<Parameter> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByG_U_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByG_U_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public Parameter[] findByG_U_PrevAndNext(
			long parameterId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns all the parameters that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching parameters that the user has permission to view
	 */
	public java.util.List<Parameter> filterFindByG_U(long groupId, long userId);

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
	public java.util.List<Parameter> filterFindByG_U(
		long groupId, long userId, int start, int end);

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
	public java.util.List<Parameter> filterFindByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public Parameter[] filterFindByG_U_PrevAndNext(
			long parameterId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Removes all the parameters where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByG_U(long groupId, long userId);

	/**
	 * Returns the number of parameters where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching parameters
	 */
	public int countByG_U(long groupId, long userId);

	/**
	 * Returns the number of parameters that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching parameters that the user has permission to view
	 */
	public int filterCountByG_U(long groupId, long userId);

	/**
	 * Returns all the parameters where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching parameters
	 */
	public java.util.List<Parameter> findByG_S(long groupId, int status);

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
	public java.util.List<Parameter> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<Parameter> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public java.util.List<Parameter> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public Parameter[] findByG_S_PrevAndNext(
			long parameterId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns all the parameters that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching parameters that the user has permission to view
	 */
	public java.util.List<Parameter> filterFindByG_S(long groupId, int status);

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
	public java.util.List<Parameter> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<Parameter> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public Parameter[] filterFindByG_S_PrevAndNext(
			long parameterId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Removes all the parameters where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of parameters where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching parameters
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of parameters that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching parameters that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns all the parameters where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching parameters
	 */
	public java.util.List<Parameter> findByU_S(long userId, int status);

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
	public java.util.List<Parameter> findByU_S(
		long userId, int status, int start, int end);

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
	public java.util.List<Parameter> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public java.util.List<Parameter> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first parameter in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the first parameter in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the last parameter in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the last parameter in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public Parameter[] findByU_S_PrevAndNext(
			long parameterId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Removes all the parameters where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of parameters where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching parameters
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns all the parameters where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching parameters
	 */
	public java.util.List<Parameter> findByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<Parameter> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<Parameter> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public java.util.List<Parameter> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator,
		boolean useFinderCache);

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
	public Parameter findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the first parameter in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public Parameter findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the last parameter in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public Parameter[] findByG_U_S_PrevAndNext(
			long parameterId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns all the parameters that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching parameters that the user has permission to view
	 */
	public java.util.List<Parameter> filterFindByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<Parameter> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<Parameter> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public Parameter[] filterFindByG_U_S_PrevAndNext(
			long parameterId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Removes all the parameters where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of parameters where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching parameters
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of parameters that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching parameters that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns all the parameters where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @return the matching parameters
	 */
	public java.util.List<Parameter> findByName(String paramName);

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
	public java.util.List<Parameter> findByName(
		String paramName, int start, int end);

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
	public java.util.List<Parameter> findByName(
		String paramName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public java.util.List<Parameter> findByName(
		String paramName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first parameter in the ordered set where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByName_First(
			String paramName,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the first parameter in the ordered set where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByName_First(
		String paramName,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the last parameter in the ordered set where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByName_Last(
			String paramName,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Returns the last parameter in the ordered set where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByName_Last(
		String paramName,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

	/**
	 * Returns the parameters before and after the current parameter in the ordered set where paramName = &#63;.
	 *
	 * @param parameterId the primary key of the current parameter
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public Parameter[] findByName_PrevAndNext(
			long parameterId, String paramName,
			com.liferay.portal.kernel.util.OrderByComparator<Parameter>
				orderByComparator)
		throws NoSuchParameterException;

	/**
	 * Removes all the parameters where paramName = &#63; from the database.
	 *
	 * @param paramName the param name
	 */
	public void removeByName(String paramName);

	/**
	 * Returns the number of parameters where paramName = &#63;.
	 *
	 * @param paramName the param name
	 * @return the number of matching parameters
	 */
	public int countByName(String paramName);

	/**
	 * Returns the parameter where paramName = &#63; and paramVersion = &#63; or throws a <code>NoSuchParameterException</code> if it could not be found.
	 *
	 * @param paramName the param name
	 * @param paramVersion the param version
	 * @return the matching parameter
	 * @throws NoSuchParameterException if a matching parameter could not be found
	 */
	public Parameter findByNameVersion(String paramName, String paramVersion)
		throws NoSuchParameterException;

	/**
	 * Returns the parameter where paramName = &#63; and paramVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param paramName the param name
	 * @param paramVersion the param version
	 * @return the matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByNameVersion(String paramName, String paramVersion);

	/**
	 * Returns the parameter where paramName = &#63; and paramVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param paramName the param name
	 * @param paramVersion the param version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	public Parameter fetchByNameVersion(
		String paramName, String paramVersion, boolean useFinderCache);

	/**
	 * Removes the parameter where paramName = &#63; and paramVersion = &#63; from the database.
	 *
	 * @param paramName the param name
	 * @param paramVersion the param version
	 * @return the parameter that was removed
	 */
	public Parameter removeByNameVersion(String paramName, String paramVersion)
		throws NoSuchParameterException;

	/**
	 * Returns the number of parameters where paramName = &#63; and paramVersion = &#63;.
	 *
	 * @param paramName the param name
	 * @param paramVersion the param version
	 * @return the number of matching parameters
	 */
	public int countByNameVersion(String paramName, String paramVersion);

	/**
	 * Caches the parameter in the entity cache if it is enabled.
	 *
	 * @param parameter the parameter
	 */
	public void cacheResult(Parameter parameter);

	/**
	 * Caches the parameters in the entity cache if it is enabled.
	 *
	 * @param parameters the parameters
	 */
	public void cacheResult(java.util.List<Parameter> parameters);

	/**
	 * Creates a new parameter with the primary key. Does not add the parameter to the database.
	 *
	 * @param parameterId the primary key for the new parameter
	 * @return the new parameter
	 */
	public Parameter create(long parameterId);

	/**
	 * Removes the parameter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parameterId the primary key of the parameter
	 * @return the parameter that was removed
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public Parameter remove(long parameterId) throws NoSuchParameterException;

	public Parameter updateImpl(Parameter parameter);

	/**
	 * Returns the parameter with the primary key or throws a <code>NoSuchParameterException</code> if it could not be found.
	 *
	 * @param parameterId the primary key of the parameter
	 * @return the parameter
	 * @throws NoSuchParameterException if a parameter with the primary key could not be found
	 */
	public Parameter findByPrimaryKey(long parameterId)
		throws NoSuchParameterException;

	/**
	 * Returns the parameter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parameterId the primary key of the parameter
	 * @return the parameter, or <code>null</code> if a parameter with the primary key could not be found
	 */
	public Parameter fetchByPrimaryKey(long parameterId);

	/**
	 * Returns all the parameters.
	 *
	 * @return the parameters
	 */
	public java.util.List<Parameter> findAll();

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
	public java.util.List<Parameter> findAll(int start, int end);

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
	public java.util.List<Parameter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator);

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
	public java.util.List<Parameter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parameter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the parameters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of parameters.
	 *
	 * @return the number of parameters
	 */
	public int countAll();

}