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