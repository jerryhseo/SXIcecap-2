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

import com.sx.icecap.exception.NoSuchTypeParamLinkException;
import com.sx.icecap.model.TypeParamLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the type param link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TypeParamLinkUtil
 * @generated
 */
@ProviderType
public interface TypeParamLinkPersistence
	extends BasePersistence<TypeParamLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TypeParamLinkUtil} to access the type param link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the type param links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching type param links
	 */
	public java.util.List<TypeParamLink> findByDataTypeId(long dataTypeId);

	/**
	 * Returns a range of all the type param links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @return the range of matching type param links
	 */
	public java.util.List<TypeParamLink> findByDataTypeId(
		long dataTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the type param links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type param links
	 */
	public java.util.List<TypeParamLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
			orderByComparator);

	/**
	 * Returns an ordered range of all the type param links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type param links
	 */
	public java.util.List<TypeParamLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	public TypeParamLink findByDataTypeId_First(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
				orderByComparator)
		throws NoSuchTypeParamLinkException;

	/**
	 * Returns the first type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	public TypeParamLink fetchByDataTypeId_First(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
			orderByComparator);

	/**
	 * Returns the last type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	public TypeParamLink findByDataTypeId_Last(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
				orderByComparator)
		throws NoSuchTypeParamLinkException;

	/**
	 * Returns the last type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	public TypeParamLink fetchByDataTypeId_Last(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
			orderByComparator);

	/**
	 * Returns the type param links before and after the current type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param typeParamLinkId the primary key of the current type param link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type param link
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	public TypeParamLink[] findByDataTypeId_PrevAndNext(
			long typeParamLinkId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
				orderByComparator)
		throws NoSuchTypeParamLinkException;

	/**
	 * Removes all the type param links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public void removeByDataTypeId(long dataTypeId);

	/**
	 * Returns the number of type param links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching type param links
	 */
	public int countByDataTypeId(long dataTypeId);

	/**
	 * Returns all the type param links where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @return the matching type param links
	 */
	public java.util.List<TypeParamLink> findByParamId(long paramId);

	/**
	 * Returns a range of all the type param links where paramId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param paramId the param ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @return the range of matching type param links
	 */
	public java.util.List<TypeParamLink> findByParamId(
		long paramId, int start, int end);

	/**
	 * Returns an ordered range of all the type param links where paramId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param paramId the param ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type param links
	 */
	public java.util.List<TypeParamLink> findByParamId(
		long paramId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
			orderByComparator);

	/**
	 * Returns an ordered range of all the type param links where paramId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param paramId the param ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type param links
	 */
	public java.util.List<TypeParamLink> findByParamId(
		long paramId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	public TypeParamLink findByParamId_First(
			long paramId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
				orderByComparator)
		throws NoSuchTypeParamLinkException;

	/**
	 * Returns the first type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	public TypeParamLink fetchByParamId_First(
		long paramId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
			orderByComparator);

	/**
	 * Returns the last type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	public TypeParamLink findByParamId_Last(
			long paramId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
				orderByComparator)
		throws NoSuchTypeParamLinkException;

	/**
	 * Returns the last type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	public TypeParamLink fetchByParamId_Last(
		long paramId,
		com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
			orderByComparator);

	/**
	 * Returns the type param links before and after the current type param link in the ordered set where paramId = &#63;.
	 *
	 * @param typeParamLinkId the primary key of the current type param link
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type param link
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	public TypeParamLink[] findByParamId_PrevAndNext(
			long typeParamLinkId, long paramId,
			com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
				orderByComparator)
		throws NoSuchTypeParamLinkException;

	/**
	 * Removes all the type param links where paramId = &#63; from the database.
	 *
	 * @param paramId the param ID
	 */
	public void removeByParamId(long paramId);

	/**
	 * Returns the number of type param links where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @return the number of matching type param links
	 */
	public int countByParamId(long paramId);

	/**
	 * Caches the type param link in the entity cache if it is enabled.
	 *
	 * @param typeParamLink the type param link
	 */
	public void cacheResult(TypeParamLink typeParamLink);

	/**
	 * Caches the type param links in the entity cache if it is enabled.
	 *
	 * @param typeParamLinks the type param links
	 */
	public void cacheResult(java.util.List<TypeParamLink> typeParamLinks);

	/**
	 * Creates a new type param link with the primary key. Does not add the type param link to the database.
	 *
	 * @param typeParamLinkId the primary key for the new type param link
	 * @return the new type param link
	 */
	public TypeParamLink create(long typeParamLinkId);

	/**
	 * Removes the type param link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeParamLinkId the primary key of the type param link
	 * @return the type param link that was removed
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	public TypeParamLink remove(long typeParamLinkId)
		throws NoSuchTypeParamLinkException;

	public TypeParamLink updateImpl(TypeParamLink typeParamLink);

	/**
	 * Returns the type param link with the primary key or throws a <code>NoSuchTypeParamLinkException</code> if it could not be found.
	 *
	 * @param typeParamLinkId the primary key of the type param link
	 * @return the type param link
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	public TypeParamLink findByPrimaryKey(long typeParamLinkId)
		throws NoSuchTypeParamLinkException;

	/**
	 * Returns the type param link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeParamLinkId the primary key of the type param link
	 * @return the type param link, or <code>null</code> if a type param link with the primary key could not be found
	 */
	public TypeParamLink fetchByPrimaryKey(long typeParamLinkId);

	/**
	 * Returns all the type param links.
	 *
	 * @return the type param links
	 */
	public java.util.List<TypeParamLink> findAll();

	/**
	 * Returns a range of all the type param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @return the range of type param links
	 */
	public java.util.List<TypeParamLink> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the type param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of type param links
	 */
	public java.util.List<TypeParamLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
			orderByComparator);

	/**
	 * Returns an ordered range of all the type param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of type param links
	 */
	public java.util.List<TypeParamLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TypeParamLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the type param links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of type param links.
	 *
	 * @return the number of type param links
	 */
	public int countAll();

}