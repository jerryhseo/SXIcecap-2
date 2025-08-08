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

import com.sx.icecap.exception.NoSuchDataCommentException;
import com.sx.icecap.model.DataComment;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataCommentUtil
 * @generated
 */
@ProviderType
public interface DataCommentPersistence extends BasePersistence<DataComment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataCommentUtil} to access the data comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data comments where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByparamName(
		long structuredDataId, String paramName);

	/**
	 * Returns a range of all the data comments where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public java.util.List<DataComment> findByparamName(
		long structuredDataId, String paramName, int start, int end);

	/**
	 * Returns an ordered range of all the data comments where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByparamName(
		long structuredDataId, String paramName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data comments where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByparamName(
		long structuredDataId, String paramName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByparamName_First(
			long structuredDataId, String paramName,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByparamName_First(
		long structuredDataId, String paramName,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByparamName_Last(
			long structuredDataId, String paramName,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByparamName_Last(
		long structuredDataId, String paramName,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByparamName_PrevAndNext(
			long dataCommentId, long structuredDataId, String paramName,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where structuredDataId = &#63; and paramName = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 */
	public void removeByparamName(long structuredDataId, String paramName);

	/**
	 * Returns the number of data comments where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @return the number of matching data comments
	 */
	public int countByparamName(long structuredDataId, String paramName);

	/**
	 * Caches the data comment in the entity cache if it is enabled.
	 *
	 * @param dataComment the data comment
	 */
	public void cacheResult(DataComment dataComment);

	/**
	 * Caches the data comments in the entity cache if it is enabled.
	 *
	 * @param dataComments the data comments
	 */
	public void cacheResult(java.util.List<DataComment> dataComments);

	/**
	 * Creates a new data comment with the primary key. Does not add the data comment to the database.
	 *
	 * @param dataCommentId the primary key for the new data comment
	 * @return the new data comment
	 */
	public DataComment create(long dataCommentId);

	/**
	 * Removes the data comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment that was removed
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment remove(long dataCommentId)
		throws NoSuchDataCommentException;

	public DataComment updateImpl(DataComment dataComment);

	/**
	 * Returns the data comment with the primary key or throws a <code>NoSuchDataCommentException</code> if it could not be found.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment findByPrimaryKey(long dataCommentId)
		throws NoSuchDataCommentException;

	/**
	 * Returns the data comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment, or <code>null</code> if a data comment with the primary key could not be found
	 */
	public DataComment fetchByPrimaryKey(long dataCommentId);

	/**
	 * Returns all the data comments.
	 *
	 * @return the data comments
	 */
	public java.util.List<DataComment> findAll();

	/**
	 * Returns a range of all the data comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of data comments
	 */
	public java.util.List<DataComment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data comments
	 */
	public java.util.List<DataComment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data comments
	 */
	public java.util.List<DataComment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data comments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data comments.
	 *
	 * @return the number of data comments
	 */
	public int countAll();

}