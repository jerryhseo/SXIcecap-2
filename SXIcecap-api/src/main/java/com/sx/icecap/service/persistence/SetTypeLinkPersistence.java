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

import com.sx.icecap.exception.NoSuchSetTypeLinkException;
import com.sx.icecap.model.SetTypeLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the set type link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SetTypeLinkUtil
 * @generated
 */
@ProviderType
public interface SetTypeLinkPersistence extends BasePersistence<SetTypeLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SetTypeLinkUtil} to access the set type link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the set type links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching set type links
	 */
	public java.util.List<SetTypeLink> findByGroupId(long groupId);

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
	public java.util.List<SetTypeLink> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<SetTypeLink> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public java.util.List<SetTypeLink> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where groupId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public SetTypeLink[] findByGroupId_PrevAndNext(
			long setTypeLinkId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Removes all the set type links where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of set type links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching set type links
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the set type links where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching set type links
	 */
	public java.util.List<SetTypeLink> findByDataCollectionId(
		long dataCollectionId);

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
	public java.util.List<SetTypeLink> findByDataCollectionId(
		long dataCollectionId, int start, int end);

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
	public java.util.List<SetTypeLink> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public java.util.List<SetTypeLink> findByDataCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first set type link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByDataCollectionId_First(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the first set type link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByDataCollectionId_First(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the last set type link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByDataCollectionId_Last(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the last set type link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByDataCollectionId_Last(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public SetTypeLink[] findByDataCollectionId_PrevAndNext(
			long setTypeLinkId, long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Removes all the set type links where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public void removeByDataCollectionId(long dataCollectionId);

	/**
	 * Returns the number of set type links where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching set type links
	 */
	public int countByDataCollectionId(long dataCollectionId);

	/**
	 * Returns all the set type links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching set type links
	 */
	public java.util.List<SetTypeLink> findByDataSetId(long dataSetId);

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
	public java.util.List<SetTypeLink> findByDataSetId(
		long dataSetId, int start, int end);

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
	public java.util.List<SetTypeLink> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public java.util.List<SetTypeLink> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByDataSetId_First(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the first set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByDataSetId_First(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the last set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByDataSetId_Last(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the last set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByDataSetId_Last(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public SetTypeLink[] findByDataSetId_PrevAndNext(
			long setTypeLinkId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Removes all the set type links where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public void removeByDataSetId(long dataSetId);

	/**
	 * Returns the number of set type links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching set type links
	 */
	public int countByDataSetId(long dataSetId);

	/**
	 * Returns all the set type links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching set type links
	 */
	public java.util.List<SetTypeLink> findByDataTypeId(long dataTypeId);

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
	public java.util.List<SetTypeLink> findByDataTypeId(
		long dataTypeId, int start, int end);

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
	public java.util.List<SetTypeLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public java.util.List<SetTypeLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByDataTypeId_First(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the first set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByDataTypeId_First(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the last set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByDataTypeId_Last(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the last set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByDataTypeId_Last(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public SetTypeLink[] findByDataTypeId_PrevAndNext(
			long setTypeLinkId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Removes all the set type links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public void removeByDataTypeId(long dataTypeId);

	/**
	 * Returns the number of set type links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching set type links
	 */
	public int countByDataTypeId(long dataTypeId);

	/**
	 * Returns all the set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the matching set type links
	 */
	public java.util.List<SetTypeLink> findByCollection_G(
		long groupId, long dataTypeId);

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
	public java.util.List<SetTypeLink> findByCollection_G(
		long groupId, long dataTypeId, int start, int end);

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
	public java.util.List<SetTypeLink> findByCollection_G(
		long groupId, long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public java.util.List<SetTypeLink> findByCollection_G(
		long groupId, long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByCollection_G_First(
			long groupId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByCollection_G_First(
		long groupId, long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByCollection_G_Last(
			long groupId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByCollection_G_Last(
		long groupId, long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public SetTypeLink[] findByCollection_G_PrevAndNext(
			long setTypeLinkId, long groupId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Removes all the set type links where groupId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 */
	public void removeByCollection_G(long groupId, long dataTypeId);

	/**
	 * Returns the number of set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching set type links
	 */
	public int countByCollection_G(long groupId, long dataTypeId);

	/**
	 * Returns all the set type links where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @return the matching set type links
	 */
	public java.util.List<SetTypeLink> findBySet_G(
		long groupId, long dataSetId);

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
	public java.util.List<SetTypeLink> findBySet_G(
		long groupId, long dataSetId, int start, int end);

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
	public java.util.List<SetTypeLink> findBySet_G(
		long groupId, long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public java.util.List<SetTypeLink> findBySet_G(
		long groupId, long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findBySet_G_First(
			long groupId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchBySet_G_First(
		long groupId, long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findBySet_G_Last(
			long groupId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchBySet_G_Last(
		long groupId, long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public SetTypeLink[] findBySet_G_PrevAndNext(
			long setTypeLinkId, long groupId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Removes all the set type links where groupId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 */
	public void removeBySet_G(long groupId, long dataSetId);

	/**
	 * Returns the number of set type links where groupId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @return the number of matching set type links
	 */
	public int countBySet_G(long groupId, long dataSetId);

	/**
	 * Returns all the set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the matching set type links
	 */
	public java.util.List<SetTypeLink> findByType_G(
		long groupId, long dataTypeId);

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
	public java.util.List<SetTypeLink> findByType_G(
		long groupId, long dataTypeId, int start, int end);

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
	public java.util.List<SetTypeLink> findByType_G(
		long groupId, long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public java.util.List<SetTypeLink> findByType_G(
		long groupId, long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByType_G_First(
			long groupId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByType_G_First(
		long groupId, long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findByType_G_Last(
			long groupId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByType_G_Last(
		long groupId, long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public SetTypeLink[] findByType_G_PrevAndNext(
			long setTypeLinkId, long groupId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Removes all the set type links where groupId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 */
	public void removeByType_G(long groupId, long dataTypeId);

	/**
	 * Returns the number of set type links where groupId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching set type links
	 */
	public int countByType_G(long groupId, long dataTypeId);

	/**
	 * Returns all the set type links where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching set type links
	 */
	public java.util.List<SetTypeLink> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId);

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
	public java.util.List<SetTypeLink> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId, int start,
		int end);

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
	public java.util.List<SetTypeLink> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public java.util.List<SetTypeLink> findByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator,
		boolean useFinderCache);

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
	public SetTypeLink findByCollectionSet_G_First(
			long groupId, long dataCollectionId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the first set type link in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByCollectionSet_G_First(
		long groupId, long dataCollectionId, long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public SetTypeLink findByCollectionSet_G_Last(
			long groupId, long dataCollectionId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the last set type link in the ordered set where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByCollectionSet_G_Last(
		long groupId, long dataCollectionId, long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public SetTypeLink[] findByCollectionSet_G_PrevAndNext(
			long setTypeLinkId, long groupId, long dataCollectionId,
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Removes all the set type links where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 */
	public void removeByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId);

	/**
	 * Returns the number of set type links where groupId = &#63; and dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the number of matching set type links
	 */
	public int countByCollectionSet_G(
		long groupId, long dataCollectionId, long dataSetId);

	/**
	 * Returns all the set type links where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the matching set type links
	 */
	public java.util.List<SetTypeLink> findBySetType(
		long dataSetId, long dataTypeId);

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
	public java.util.List<SetTypeLink> findBySetType(
		long dataSetId, long dataTypeId, int start, int end);

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
	public java.util.List<SetTypeLink> findBySetType(
		long dataSetId, long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public java.util.List<SetTypeLink> findBySetType(
		long dataSetId, long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first set type link in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findBySetType_First(
			long dataSetId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the first set type link in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchBySetType_First(
		long dataSetId, long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

	/**
	 * Returns the last set type link in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	public SetTypeLink findBySetType_Last(
			long dataSetId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the last set type link in the ordered set where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchBySetType_Last(
		long dataSetId, long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public SetTypeLink[] findBySetType_PrevAndNext(
			long setTypeLinkId, long dataSetId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
				orderByComparator)
		throws NoSuchSetTypeLinkException;

	/**
	 * Removes all the set type links where dataSetId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 */
	public void removeBySetType(long dataSetId, long dataTypeId);

	/**
	 * Returns the number of set type links where dataSetId = &#63; and dataTypeId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching set type links
	 */
	public int countBySetType(long dataSetId, long dataTypeId);

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
	public SetTypeLink findByCollectionSetType_G(
			long groupId, long dataSetId, long dataCollectionId,
			long dataTypeId)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the set type link where groupId = &#63; and dataSetId = &#63; and dataCollectionId = &#63; and dataTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataCollectionId the data collection ID
	 * @param dataTypeId the data type ID
	 * @return the matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	public SetTypeLink fetchByCollectionSetType_G(
		long groupId, long dataSetId, long dataCollectionId, long dataTypeId);

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
	public SetTypeLink fetchByCollectionSetType_G(
		long groupId, long dataSetId, long dataCollectionId, long dataTypeId,
		boolean useFinderCache);

	/**
	 * Removes the set type link where groupId = &#63; and dataSetId = &#63; and dataCollectionId = &#63; and dataTypeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataCollectionId the data collection ID
	 * @param dataTypeId the data type ID
	 * @return the set type link that was removed
	 */
	public SetTypeLink removeByCollectionSetType_G(
			long groupId, long dataSetId, long dataCollectionId,
			long dataTypeId)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the number of set type links where groupId = &#63; and dataSetId = &#63; and dataCollectionId = &#63; and dataTypeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataSetId the data set ID
	 * @param dataCollectionId the data collection ID
	 * @param dataTypeId the data type ID
	 * @return the number of matching set type links
	 */
	public int countByCollectionSetType_G(
		long groupId, long dataSetId, long dataCollectionId, long dataTypeId);

	/**
	 * Caches the set type link in the entity cache if it is enabled.
	 *
	 * @param setTypeLink the set type link
	 */
	public void cacheResult(SetTypeLink setTypeLink);

	/**
	 * Caches the set type links in the entity cache if it is enabled.
	 *
	 * @param setTypeLinks the set type links
	 */
	public void cacheResult(java.util.List<SetTypeLink> setTypeLinks);

	/**
	 * Creates a new set type link with the primary key. Does not add the set type link to the database.
	 *
	 * @param setTypeLinkId the primary key for the new set type link
	 * @return the new set type link
	 */
	public SetTypeLink create(long setTypeLinkId);

	/**
	 * Removes the set type link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link that was removed
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public SetTypeLink remove(long setTypeLinkId)
		throws NoSuchSetTypeLinkException;

	public SetTypeLink updateImpl(SetTypeLink setTypeLink);

	/**
	 * Returns the set type link with the primary key or throws a <code>NoSuchSetTypeLinkException</code> if it could not be found.
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	public SetTypeLink findByPrimaryKey(long setTypeLinkId)
		throws NoSuchSetTypeLinkException;

	/**
	 * Returns the set type link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link, or <code>null</code> if a set type link with the primary key could not be found
	 */
	public SetTypeLink fetchByPrimaryKey(long setTypeLinkId);

	/**
	 * Returns all the set type links.
	 *
	 * @return the set type links
	 */
	public java.util.List<SetTypeLink> findAll();

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
	public java.util.List<SetTypeLink> findAll(int start, int end);

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
	public java.util.List<SetTypeLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator);

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
	public java.util.List<SetTypeLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SetTypeLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the set type links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of set type links.
	 *
	 * @return the number of set type links
	 */
	public int countAll();

}