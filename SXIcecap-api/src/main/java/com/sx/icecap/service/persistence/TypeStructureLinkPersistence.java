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

import com.sx.icecap.exception.NoSuchTypeStructureLinkException;
import com.sx.icecap.model.TypeStructureLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the type structure link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TypeStructureLinkUtil
 * @generated
 */
@ProviderType
public interface TypeStructureLinkPersistence
	extends BasePersistence<TypeStructureLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TypeStructureLinkUtil} to access the type structure link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the type structure links where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching type structure links
	 */
	public java.util.List<TypeStructureLink> findByUserId(long userId);

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
	public java.util.List<TypeStructureLink> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<TypeStructureLink> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where userId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public TypeStructureLink[] findByUserId_PrevAndNext(
			long dataTypeId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Removes all the type structure links where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of type structure links where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching type structure links
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the type structure links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching type structure links
	 */
	public java.util.List<TypeStructureLink> findByGroupId(long groupId);

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
	public java.util.List<TypeStructureLink> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<TypeStructureLink> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public TypeStructureLink[] findByGroupId_PrevAndNext(
			long dataTypeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Removes all the type structure links where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of type structure links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching type structure links
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching type structure links
	 */
	public java.util.List<TypeStructureLink> findByG_U(
		long groupId, long userId);

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
	public java.util.List<TypeStructureLink> findByG_U(
		long groupId, long userId, int start, int end);

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
	public java.util.List<TypeStructureLink> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByG_U_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByG_U_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public TypeStructureLink[] findByG_U_PrevAndNext(
			long dataTypeId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Removes all the type structure links where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByG_U(long groupId, long userId);

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching type structure links
	 */
	public int countByG_U(long groupId, long userId);

	/**
	 * Returns the type structure link where dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByDataStructureId(long dataStructureId)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the type structure link where dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByDataStructureId(long dataStructureId);

	/**
	 * Returns the type structure link where dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByDataStructureId(
		long dataStructureId, boolean useFinderCache);

	/**
	 * Removes the type structure link where dataStructureId = &#63; from the database.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	public TypeStructureLink removeByDataStructureId(long dataStructureId)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the number of type structure links where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	public int countByDataStructureId(long dataStructureId);

	/**
	 * Returns the type structure link where groupId = &#63; and dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByDataStructureId_G(
			long groupId, long dataStructureId)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the type structure link where groupId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByDataStructureId_G(
		long groupId, long dataStructureId);

	/**
	 * Returns the type structure link where groupId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByDataStructureId_G(
		long groupId, long dataStructureId, boolean useFinderCache);

	/**
	 * Removes the type structure link where groupId = &#63; and dataStructureId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	public TypeStructureLink removeByDataStructureId_G(
			long groupId, long dataStructureId)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the number of type structure links where groupId = &#63; and dataStructureId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	public int countByDataStructureId_G(long groupId, long dataStructureId);

	/**
	 * Returns the type structure link where userId = &#63; and dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByDataStructureId_U(
			long userId, long dataStructureId)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the type structure link where userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByDataStructureId_U(
		long userId, long dataStructureId);

	/**
	 * Returns the type structure link where userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByDataStructureId_U(
		long userId, long dataStructureId, boolean useFinderCache);

	/**
	 * Removes the type structure link where userId = &#63; and dataStructureId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	public TypeStructureLink removeByDataStructureId_U(
			long userId, long dataStructureId)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the number of type structure links where userId = &#63; and dataStructureId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	public int countByDataStructureId_U(long userId, long dataStructureId);

	/**
	 * Returns the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByDataStructureId_G_U(
			long groupId, long userId, long dataStructureId)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByDataStructureId_G_U(
		long groupId, long userId, long dataStructureId);

	/**
	 * Returns the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByDataStructureId_G_U(
		long groupId, long userId, long dataStructureId,
		boolean useFinderCache);

	/**
	 * Removes the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	public TypeStructureLink removeByDataStructureId_G_U(
			long groupId, long userId, long dataStructureId)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63; and dataStructureId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	public int countByDataStructureId_G_U(
		long groupId, long userId, long dataStructureId);

	/**
	 * Returns all the type structure links where verified = &#63;.
	 *
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	public java.util.List<TypeStructureLink> findByVerified(boolean verified);

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
	public java.util.List<TypeStructureLink> findByVerified(
		boolean verified, int start, int end);

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
	public java.util.List<TypeStructureLink> findByVerified(
		boolean verified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findByVerified(
		boolean verified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByVerified_First(
			boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the first type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByVerified_First(
		boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the last type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByVerified_Last(
			boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the last type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByVerified_Last(
		boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where verified = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public TypeStructureLink[] findByVerified_PrevAndNext(
			long dataTypeId, boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Removes all the type structure links where verified = &#63; from the database.
	 *
	 * @param verified the verified
	 */
	public void removeByVerified(boolean verified);

	/**
	 * Returns the number of type structure links where verified = &#63;.
	 *
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	public int countByVerified(boolean verified);

	/**
	 * Returns all the type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	public java.util.List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified);

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
	public java.util.List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified, int start, int end);

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
	public java.util.List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByVerified_G_First(
			long groupId, boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByVerified_G_First(
		long groupId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByVerified_G_Last(
			long groupId, boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByVerified_G_Last(
		long groupId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public TypeStructureLink[] findByVerified_G_PrevAndNext(
			long dataTypeId, long groupId, boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Removes all the type structure links where groupId = &#63; and verified = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 */
	public void removeByVerified_G(long groupId, boolean verified);

	/**
	 * Returns the number of type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	public int countByVerified_G(long groupId, boolean verified);

	/**
	 * Returns all the type structure links where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	public java.util.List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified);

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
	public java.util.List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified, int start, int end);

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
	public java.util.List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByVerified_U_First(
			long userId, boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByVerified_U_First(
		long userId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByVerified_U_Last(
			long userId, boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByVerified_U_Last(
		long userId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public TypeStructureLink[] findByVerified_U_PrevAndNext(
			long dataTypeId, long userId, boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Removes all the type structure links where userId = &#63; and verified = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 */
	public void removeByVerified_U(long userId, boolean verified);

	/**
	 * Returns the number of type structure links where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	public int countByVerified_U(long userId, boolean verified);

	/**
	 * Returns all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	public java.util.List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified);

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
	public java.util.List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified, int start, int end);

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
	public java.util.List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

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
	public TypeStructureLink findByVerified_G_U_First(
			long groupId, long userId, boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByVerified_G_U_First(
		long groupId, long userId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public TypeStructureLink findByVerified_G_U_Last(
			long groupId, long userId, boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByVerified_G_U_Last(
		long groupId, long userId, boolean verified,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public TypeStructureLink[] findByVerified_G_U_PrevAndNext(
			long dataTypeId, long groupId, long userId, boolean verified,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Removes all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 */
	public void removeByVerified_G_U(
		long groupId, long userId, boolean verified);

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	public int countByVerified_G_U(long groupId, long userId, boolean verified);

	/**
	 * Returns all the type structure links where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	public java.util.List<TypeStructureLink> findByFreezed(boolean freezed);

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
	public java.util.List<TypeStructureLink> findByFreezed(
		boolean freezed, int start, int end);

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
	public java.util.List<TypeStructureLink> findByFreezed(
		boolean freezed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findByFreezed(
		boolean freezed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByFreezed_First(
			boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the first type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByFreezed_First(
		boolean freezed,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the last type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByFreezed_Last(
			boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the last type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByFreezed_Last(
		boolean freezed,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public TypeStructureLink[] findByFreezed_PrevAndNext(
			long dataTypeId, boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Removes all the type structure links where freezed = &#63; from the database.
	 *
	 * @param freezed the freezed
	 */
	public void removeByFreezed(boolean freezed);

	/**
	 * Returns the number of type structure links where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	public int countByFreezed(boolean freezed);

	/**
	 * Returns all the type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	public java.util.List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed);

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
	public java.util.List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed, int start, int end);

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
	public java.util.List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByFreezed_G_First(
			long groupId, boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByFreezed_G_First(
		long groupId, boolean freezed,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByFreezed_G_Last(
			long groupId, boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByFreezed_G_Last(
		long groupId, boolean freezed,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public TypeStructureLink[] findByFreezed_G_PrevAndNext(
			long dataTypeId, long groupId, boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Removes all the type structure links where groupId = &#63; and freezed = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 */
	public void removeByFreezed_G(long groupId, boolean freezed);

	/**
	 * Returns the number of type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	public int countByFreezed_G(long groupId, boolean freezed);

	/**
	 * Returns all the type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	public java.util.List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed);

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
	public java.util.List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed, int start, int end);

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
	public java.util.List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByFreezed_U_First(
			long userId, boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByFreezed_U_First(
		long userId, boolean freezed,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	public TypeStructureLink findByFreezed_U_Last(
			long userId, boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByFreezed_U_Last(
		long userId, boolean freezed,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public TypeStructureLink[] findByFreezed_U_PrevAndNext(
			long dataTypeId, long userId, boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Removes all the type structure links where userId = &#63; and freezed = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 */
	public void removeByFreezed_U(long userId, boolean freezed);

	/**
	 * Returns the number of type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	public int countByFreezed_U(long userId, boolean freezed);

	/**
	 * Returns all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	public java.util.List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed);

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
	public java.util.List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed, int start, int end);

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
	public java.util.List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

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
	public TypeStructureLink findByFreezed_G_U_First(
			long groupId, long userId, boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByFreezed_G_U_First(
		long groupId, long userId, boolean freezed,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public TypeStructureLink findByFreezed_G_U_Last(
			long groupId, long userId, boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	public TypeStructureLink fetchByFreezed_G_U_Last(
		long groupId, long userId, boolean freezed,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public TypeStructureLink[] findByFreezed_G_U_PrevAndNext(
			long dataTypeId, long groupId, long userId, boolean freezed,
			com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
				orderByComparator)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Removes all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 */
	public void removeByFreezed_G_U(long groupId, long userId, boolean freezed);

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	public int countByFreezed_G_U(long groupId, long userId, boolean freezed);

	/**
	 * Caches the type structure link in the entity cache if it is enabled.
	 *
	 * @param typeStructureLink the type structure link
	 */
	public void cacheResult(TypeStructureLink typeStructureLink);

	/**
	 * Caches the type structure links in the entity cache if it is enabled.
	 *
	 * @param typeStructureLinks the type structure links
	 */
	public void cacheResult(
		java.util.List<TypeStructureLink> typeStructureLinks);

	/**
	 * Creates a new type structure link with the primary key. Does not add the type structure link to the database.
	 *
	 * @param dataTypeId the primary key for the new type structure link
	 * @return the new type structure link
	 */
	public TypeStructureLink create(long dataTypeId);

	/**
	 * Removes the type structure link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link that was removed
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public TypeStructureLink remove(long dataTypeId)
		throws NoSuchTypeStructureLinkException;

	public TypeStructureLink updateImpl(TypeStructureLink typeStructureLink);

	/**
	 * Returns the type structure link with the primary key or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	public TypeStructureLink findByPrimaryKey(long dataTypeId)
		throws NoSuchTypeStructureLinkException;

	/**
	 * Returns the type structure link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link, or <code>null</code> if a type structure link with the primary key could not be found
	 */
	public TypeStructureLink fetchByPrimaryKey(long dataTypeId);

	/**
	 * Returns all the type structure links.
	 *
	 * @return the type structure links
	 */
	public java.util.List<TypeStructureLink> findAll();

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
	public java.util.List<TypeStructureLink> findAll(int start, int end);

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
	public java.util.List<TypeStructureLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator);

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
	public java.util.List<TypeStructureLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeStructureLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the type structure links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of type structure links.
	 *
	 * @return the number of type structure links
	 */
	public int countAll();

}