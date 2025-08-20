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

import com.sx.icecap.exception.NoSuchStructureParamLinkException;
import com.sx.icecap.model.StructureParamLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the structure param link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StructureParamLinkUtil
 * @generated
 */
@ProviderType
public interface StructureParamLinkPersistence
	extends BasePersistence<StructureParamLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StructureParamLinkUtil} to access the structure param link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the structure param links where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the matching structure param links
	 */
	public java.util.List<StructureParamLink> findByDataStructureId(
		long dataStructureId);

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
	public java.util.List<StructureParamLink> findByDataStructureId(
		long dataStructureId, int start, int end);

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
	public java.util.List<StructureParamLink> findByDataStructureId(
		long dataStructureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
			orderByComparator);

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
	public java.util.List<StructureParamLink> findByDataStructureId(
		long dataStructureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	public StructureParamLink findByDataStructureId_First(
			long dataStructureId,
			com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
				orderByComparator)
		throws NoSuchStructureParamLinkException;

	/**
	 * Returns the first structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	public StructureParamLink fetchByDataStructureId_First(
		long dataStructureId,
		com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
			orderByComparator);

	/**
	 * Returns the last structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	public StructureParamLink findByDataStructureId_Last(
			long dataStructureId,
			com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
				orderByComparator)
		throws NoSuchStructureParamLinkException;

	/**
	 * Returns the last structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	public StructureParamLink fetchByDataStructureId_Last(
		long dataStructureId,
		com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
			orderByComparator);

	/**
	 * Returns the structure param links before and after the current structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param structureParamLinkId the primary key of the current structure param link
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structure param link
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	public StructureParamLink[] findByDataStructureId_PrevAndNext(
			long structureParamLinkId, long dataStructureId,
			com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
				orderByComparator)
		throws NoSuchStructureParamLinkException;

	/**
	 * Removes all the structure param links where dataStructureId = &#63; from the database.
	 *
	 * @param dataStructureId the data structure ID
	 */
	public void removeByDataStructureId(long dataStructureId);

	/**
	 * Returns the number of structure param links where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the number of matching structure param links
	 */
	public int countByDataStructureId(long dataStructureId);

	/**
	 * Returns all the structure param links where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @return the matching structure param links
	 */
	public java.util.List<StructureParamLink> findByParameterId(
		long parameterId);

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
	public java.util.List<StructureParamLink> findByParameterId(
		long parameterId, int start, int end);

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
	public java.util.List<StructureParamLink> findByParameterId(
		long parameterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
			orderByComparator);

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
	public java.util.List<StructureParamLink> findByParameterId(
		long parameterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	public StructureParamLink findByParameterId_First(
			long parameterId,
			com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
				orderByComparator)
		throws NoSuchStructureParamLinkException;

	/**
	 * Returns the first structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	public StructureParamLink fetchByParameterId_First(
		long parameterId,
		com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
			orderByComparator);

	/**
	 * Returns the last structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	public StructureParamLink findByParameterId_Last(
			long parameterId,
			com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
				orderByComparator)
		throws NoSuchStructureParamLinkException;

	/**
	 * Returns the last structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	public StructureParamLink fetchByParameterId_Last(
		long parameterId,
		com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
			orderByComparator);

	/**
	 * Returns the structure param links before and after the current structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param structureParamLinkId the primary key of the current structure param link
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structure param link
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	public StructureParamLink[] findByParameterId_PrevAndNext(
			long structureParamLinkId, long parameterId,
			com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
				orderByComparator)
		throws NoSuchStructureParamLinkException;

	/**
	 * Removes all the structure param links where parameterId = &#63; from the database.
	 *
	 * @param parameterId the parameter ID
	 */
	public void removeByParameterId(long parameterId);

	/**
	 * Returns the number of structure param links where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @return the number of matching structure param links
	 */
	public int countByParameterId(long parameterId);

	/**
	 * Caches the structure param link in the entity cache if it is enabled.
	 *
	 * @param structureParamLink the structure param link
	 */
	public void cacheResult(StructureParamLink structureParamLink);

	/**
	 * Caches the structure param links in the entity cache if it is enabled.
	 *
	 * @param structureParamLinks the structure param links
	 */
	public void cacheResult(
		java.util.List<StructureParamLink> structureParamLinks);

	/**
	 * Creates a new structure param link with the primary key. Does not add the structure param link to the database.
	 *
	 * @param structureParamLinkId the primary key for the new structure param link
	 * @return the new structure param link
	 */
	public StructureParamLink create(long structureParamLinkId);

	/**
	 * Removes the structure param link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param structureParamLinkId the primary key of the structure param link
	 * @return the structure param link that was removed
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	public StructureParamLink remove(long structureParamLinkId)
		throws NoSuchStructureParamLinkException;

	public StructureParamLink updateImpl(StructureParamLink structureParamLink);

	/**
	 * Returns the structure param link with the primary key or throws a <code>NoSuchStructureParamLinkException</code> if it could not be found.
	 *
	 * @param structureParamLinkId the primary key of the structure param link
	 * @return the structure param link
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	public StructureParamLink findByPrimaryKey(long structureParamLinkId)
		throws NoSuchStructureParamLinkException;

	/**
	 * Returns the structure param link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param structureParamLinkId the primary key of the structure param link
	 * @return the structure param link, or <code>null</code> if a structure param link with the primary key could not be found
	 */
	public StructureParamLink fetchByPrimaryKey(long structureParamLinkId);

	/**
	 * Returns all the structure param links.
	 *
	 * @return the structure param links
	 */
	public java.util.List<StructureParamLink> findAll();

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
	public java.util.List<StructureParamLink> findAll(int start, int end);

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
	public java.util.List<StructureParamLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
			orderByComparator);

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
	public java.util.List<StructureParamLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructureParamLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the structure param links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of structure param links.
	 *
	 * @return the number of structure param links
	 */
	public int countAll();

}