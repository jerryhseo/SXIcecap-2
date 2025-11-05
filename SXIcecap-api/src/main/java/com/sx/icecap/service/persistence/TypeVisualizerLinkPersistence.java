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

import com.sx.icecap.exception.NoSuchTypeVisualizerLinkException;
import com.sx.icecap.model.TypeVisualizerLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the type visualizer link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TypeVisualizerLinkUtil
 * @generated
 */
@ProviderType
public interface TypeVisualizerLinkPersistence
	extends BasePersistence<TypeVisualizerLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TypeVisualizerLinkUtil} to access the type visualizer link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching type visualizer links
	 */
	public java.util.List<TypeVisualizerLink> findByDataTypeId(long dataTypeId);

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
	public java.util.List<TypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end);

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
	public java.util.List<TypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
			orderByComparator);

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
	public java.util.List<TypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	public TypeVisualizerLink findByDataTypeId_First(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
				orderByComparator)
		throws NoSuchTypeVisualizerLinkException;

	/**
	 * Returns the first type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	public TypeVisualizerLink fetchByDataTypeId_First(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns the last type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	public TypeVisualizerLink findByDataTypeId_Last(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
				orderByComparator)
		throws NoSuchTypeVisualizerLinkException;

	/**
	 * Returns the last type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	public TypeVisualizerLink fetchByDataTypeId_Last(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns the type visualizer links before and after the current type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param typeVisualizerLinkId the primary key of the current type visualizer link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	public TypeVisualizerLink[] findByDataTypeId_PrevAndNext(
			long typeVisualizerLinkId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
				orderByComparator)
		throws NoSuchTypeVisualizerLinkException;

	/**
	 * Removes all the type visualizer links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public void removeByDataTypeId(long dataTypeId);

	/**
	 * Returns the number of type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching type visualizer links
	 */
	public int countByDataTypeId(long dataTypeId);

	/**
	 * Returns all the type visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the matching type visualizer links
	 */
	public java.util.List<TypeVisualizerLink> findByVisualizerId(
		long visualizerId);

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
	public java.util.List<TypeVisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end);

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
	public java.util.List<TypeVisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
			orderByComparator);

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
	public java.util.List<TypeVisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	public TypeVisualizerLink findByVisualizerId_First(
			long visualizerId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
				orderByComparator)
		throws NoSuchTypeVisualizerLinkException;

	/**
	 * Returns the first type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	public TypeVisualizerLink fetchByVisualizerId_First(
		long visualizerId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns the last type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	public TypeVisualizerLink findByVisualizerId_Last(
			long visualizerId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
				orderByComparator)
		throws NoSuchTypeVisualizerLinkException;

	/**
	 * Returns the last type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	public TypeVisualizerLink fetchByVisualizerId_Last(
		long visualizerId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
			orderByComparator);

	/**
	 * Returns the type visualizer links before and after the current type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param typeVisualizerLinkId the primary key of the current type visualizer link
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	public TypeVisualizerLink[] findByVisualizerId_PrevAndNext(
			long typeVisualizerLinkId, long visualizerId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
				orderByComparator)
		throws NoSuchTypeVisualizerLinkException;

	/**
	 * Removes all the type visualizer links where visualizerId = &#63; from the database.
	 *
	 * @param visualizerId the visualizer ID
	 */
	public void removeByVisualizerId(long visualizerId);

	/**
	 * Returns the number of type visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the number of matching type visualizer links
	 */
	public int countByVisualizerId(long visualizerId);

	/**
	 * Returns the type visualizer link where dataTypeId = &#63; and visualizerId = &#63; or throws a <code>NoSuchTypeVisualizerLinkException</code> if it could not be found.
	 *
	 * @param dataTypeId the data type ID
	 * @param visualizerId the visualizer ID
	 * @return the matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	public TypeVisualizerLink findByDataTypeVisualizer(
			long dataTypeId, long visualizerId)
		throws NoSuchTypeVisualizerLinkException;

	/**
	 * Returns the type visualizer link where dataTypeId = &#63; and visualizerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataTypeId the data type ID
	 * @param visualizerId the visualizer ID
	 * @return the matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	public TypeVisualizerLink fetchByDataTypeVisualizer(
		long dataTypeId, long visualizerId);

	/**
	 * Returns the type visualizer link where dataTypeId = &#63; and visualizerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataTypeId the data type ID
	 * @param visualizerId the visualizer ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	public TypeVisualizerLink fetchByDataTypeVisualizer(
		long dataTypeId, long visualizerId, boolean useFinderCache);

	/**
	 * Removes the type visualizer link where dataTypeId = &#63; and visualizerId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param visualizerId the visualizer ID
	 * @return the type visualizer link that was removed
	 */
	public TypeVisualizerLink removeByDataTypeVisualizer(
			long dataTypeId, long visualizerId)
		throws NoSuchTypeVisualizerLinkException;

	/**
	 * Returns the number of type visualizer links where dataTypeId = &#63; and visualizerId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param visualizerId the visualizer ID
	 * @return the number of matching type visualizer links
	 */
	public int countByDataTypeVisualizer(long dataTypeId, long visualizerId);

	/**
	 * Caches the type visualizer link in the entity cache if it is enabled.
	 *
	 * @param typeVisualizerLink the type visualizer link
	 */
	public void cacheResult(TypeVisualizerLink typeVisualizerLink);

	/**
	 * Caches the type visualizer links in the entity cache if it is enabled.
	 *
	 * @param typeVisualizerLinks the type visualizer links
	 */
	public void cacheResult(
		java.util.List<TypeVisualizerLink> typeVisualizerLinks);

	/**
	 * Creates a new type visualizer link with the primary key. Does not add the type visualizer link to the database.
	 *
	 * @param typeVisualizerLinkId the primary key for the new type visualizer link
	 * @return the new type visualizer link
	 */
	public TypeVisualizerLink create(long typeVisualizerLinkId);

	/**
	 * Removes the type visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeVisualizerLinkId the primary key of the type visualizer link
	 * @return the type visualizer link that was removed
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	public TypeVisualizerLink remove(long typeVisualizerLinkId)
		throws NoSuchTypeVisualizerLinkException;

	public TypeVisualizerLink updateImpl(TypeVisualizerLink typeVisualizerLink);

	/**
	 * Returns the type visualizer link with the primary key or throws a <code>NoSuchTypeVisualizerLinkException</code> if it could not be found.
	 *
	 * @param typeVisualizerLinkId the primary key of the type visualizer link
	 * @return the type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	public TypeVisualizerLink findByPrimaryKey(long typeVisualizerLinkId)
		throws NoSuchTypeVisualizerLinkException;

	/**
	 * Returns the type visualizer link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeVisualizerLinkId the primary key of the type visualizer link
	 * @return the type visualizer link, or <code>null</code> if a type visualizer link with the primary key could not be found
	 */
	public TypeVisualizerLink fetchByPrimaryKey(long typeVisualizerLinkId);

	/**
	 * Returns all the type visualizer links.
	 *
	 * @return the type visualizer links
	 */
	public java.util.List<TypeVisualizerLink> findAll();

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
	public java.util.List<TypeVisualizerLink> findAll(int start, int end);

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
	public java.util.List<TypeVisualizerLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
			orderByComparator);

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
	public java.util.List<TypeVisualizerLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeVisualizerLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the type visualizer links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of type visualizer links.
	 *
	 * @return the number of type visualizer links
	 */
	public int countAll();

}