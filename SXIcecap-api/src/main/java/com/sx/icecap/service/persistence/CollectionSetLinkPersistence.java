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

import com.sx.icecap.exception.NoSuchCollectionSetLinkException;
import com.sx.icecap.model.CollectionSetLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the collection set link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CollectionSetLinkUtil
 * @generated
 */
@ProviderType
public interface CollectionSetLinkPersistence
	extends BasePersistence<CollectionSetLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CollectionSetLinkUtil} to access the collection set link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the collection set links where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching collection set links
	 */
	public java.util.List<CollectionSetLink> findByCollectionId(
		long dataCollectionId);

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
	public java.util.List<CollectionSetLink> findByCollectionId(
		long dataCollectionId, int start, int end);

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
	public java.util.List<CollectionSetLink> findByCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
			orderByComparator);

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
	public java.util.List<CollectionSetLink> findByCollectionId(
		long dataCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	public CollectionSetLink findByCollectionId_First(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
				orderByComparator)
		throws NoSuchCollectionSetLinkException;

	/**
	 * Returns the first collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	public CollectionSetLink fetchByCollectionId_First(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
			orderByComparator);

	/**
	 * Returns the last collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	public CollectionSetLink findByCollectionId_Last(
			long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
				orderByComparator)
		throws NoSuchCollectionSetLinkException;

	/**
	 * Returns the last collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	public CollectionSetLink fetchByCollectionId_Last(
		long dataCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
			orderByComparator);

	/**
	 * Returns the collection set links before and after the current collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param collectionSetLinkId the primary key of the current collection set link
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next collection set link
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	public CollectionSetLink[] findByCollectionId_PrevAndNext(
			long collectionSetLinkId, long dataCollectionId,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
				orderByComparator)
		throws NoSuchCollectionSetLinkException;

	/**
	 * Removes all the collection set links where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	public void removeByCollectionId(long dataCollectionId);

	/**
	 * Returns the number of collection set links where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching collection set links
	 */
	public int countByCollectionId(long dataCollectionId);

	/**
	 * Returns all the collection set links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching collection set links
	 */
	public java.util.List<CollectionSetLink> findByDataSetId(long dataSetId);

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
	public java.util.List<CollectionSetLink> findByDataSetId(
		long dataSetId, int start, int end);

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
	public java.util.List<CollectionSetLink> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
			orderByComparator);

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
	public java.util.List<CollectionSetLink> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	public CollectionSetLink findByDataSetId_First(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
				orderByComparator)
		throws NoSuchCollectionSetLinkException;

	/**
	 * Returns the first collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	public CollectionSetLink fetchByDataSetId_First(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
			orderByComparator);

	/**
	 * Returns the last collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	public CollectionSetLink findByDataSetId_Last(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
				orderByComparator)
		throws NoSuchCollectionSetLinkException;

	/**
	 * Returns the last collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	public CollectionSetLink fetchByDataSetId_Last(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
			orderByComparator);

	/**
	 * Returns the collection set links before and after the current collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param collectionSetLinkId the primary key of the current collection set link
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next collection set link
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	public CollectionSetLink[] findByDataSetId_PrevAndNext(
			long collectionSetLinkId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
				orderByComparator)
		throws NoSuchCollectionSetLinkException;

	/**
	 * Removes all the collection set links where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public void removeByDataSetId(long dataSetId);

	/**
	 * Returns the number of collection set links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching collection set links
	 */
	public int countByDataSetId(long dataSetId);

	/**
	 * Caches the collection set link in the entity cache if it is enabled.
	 *
	 * @param collectionSetLink the collection set link
	 */
	public void cacheResult(CollectionSetLink collectionSetLink);

	/**
	 * Caches the collection set links in the entity cache if it is enabled.
	 *
	 * @param collectionSetLinks the collection set links
	 */
	public void cacheResult(
		java.util.List<CollectionSetLink> collectionSetLinks);

	/**
	 * Creates a new collection set link with the primary key. Does not add the collection set link to the database.
	 *
	 * @param collectionSetLinkId the primary key for the new collection set link
	 * @return the new collection set link
	 */
	public CollectionSetLink create(long collectionSetLinkId);

	/**
	 * Removes the collection set link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link that was removed
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	public CollectionSetLink remove(long collectionSetLinkId)
		throws NoSuchCollectionSetLinkException;

	public CollectionSetLink updateImpl(CollectionSetLink collectionSetLink);

	/**
	 * Returns the collection set link with the primary key or throws a <code>NoSuchCollectionSetLinkException</code> if it could not be found.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	public CollectionSetLink findByPrimaryKey(long collectionSetLinkId)
		throws NoSuchCollectionSetLinkException;

	/**
	 * Returns the collection set link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link, or <code>null</code> if a collection set link with the primary key could not be found
	 */
	public CollectionSetLink fetchByPrimaryKey(long collectionSetLinkId);

	/**
	 * Returns all the collection set links.
	 *
	 * @return the collection set links
	 */
	public java.util.List<CollectionSetLink> findAll();

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
	public java.util.List<CollectionSetLink> findAll(int start, int end);

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
	public java.util.List<CollectionSetLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
			orderByComparator);

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
	public java.util.List<CollectionSetLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionSetLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the collection set links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of collection set links.
	 *
	 * @return the number of collection set links
	 */
	public int countAll();

}