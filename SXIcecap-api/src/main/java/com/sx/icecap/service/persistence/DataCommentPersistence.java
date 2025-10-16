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
	 * Returns all the data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByModelId(
		String commentModel, long commentModelId);

	/**
	 * Returns a range of all the data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public java.util.List<DataComment> findByModelId(
		String commentModel, long commentModelId, int start, int end);

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByModelId(
		String commentModel, long commentModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByModelId(
		String commentModel, long commentModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModelId_First(
			String commentModel, long commentModelId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModelId_First(
		String commentModel, long commentModelId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModelId_Last(
			String commentModel, long commentModelId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModelId_Last(
		String commentModel, long commentModelId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByModelId_PrevAndNext(
			long dataCommentId, String commentModel, long commentModelId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where commentModel = &#63; and commentModelId = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 */
	public void removeByModelId(String commentModel, long commentModelId);

	/**
	 * Returns the number of data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the number of matching data comments
	 */
	public int countByModelId(String commentModel, long commentModelId);

	/**
	 * Returns all the data comments where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByModel(String commentModel);

	/**
	 * Returns a range of all the data comments where commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public java.util.List<DataComment> findByModel(
		String commentModel, int start, int end);

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByModel(
		String commentModel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByModel(
		String commentModel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModel_First(
			String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModel_First(
		String commentModel,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModel_Last(
			String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModel_Last(
		String commentModel,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByModel_PrevAndNext(
			long dataCommentId, String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where commentModel = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 */
	public void removeByModel(String commentModel);

	/**
	 * Returns the number of data comments where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @return the number of matching data comments
	 */
	public int countByModel(String commentModel);

	/**
	 * Returns all the data comments where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByParentComment(
		long parentCommentId);

	/**
	 * Returns a range of all the data comments where parentCommentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param parentCommentId the parent comment ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public java.util.List<DataComment> findByParentComment(
		long parentCommentId, int start, int end);

	/**
	 * Returns an ordered range of all the data comments where parentCommentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param parentCommentId the parent comment ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByParentComment(
		long parentCommentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data comments where parentCommentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param parentCommentId the parent comment ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByParentComment(
		long parentCommentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByParentComment_First(
			long parentCommentId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByParentComment_First(
		long parentCommentId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByParentComment_Last(
			long parentCommentId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByParentComment_Last(
		long parentCommentId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByParentComment_PrevAndNext(
			long dataCommentId, long parentCommentId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where parentCommentId = &#63; from the database.
	 *
	 * @param parentCommentId the parent comment ID
	 */
	public void removeByParentComment(long parentCommentId);

	/**
	 * Returns the number of data comments where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @return the number of matching data comments
	 */
	public int countByParentComment(long parentCommentId);

	/**
	 * Returns all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId);

	/**
	 * Returns a range of all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public java.util.List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId, int start,
		int end);

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModelId_G_First(
			long groupId, String commentModel, long commentModelId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModelId_G_First(
		long groupId, String commentModel, long commentModelId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModelId_G_Last(
			long groupId, String commentModel, long commentModelId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModelId_G_Last(
		long groupId, String commentModel, long commentModelId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByModelId_G_PrevAndNext(
			long dataCommentId, long groupId, String commentModel,
			long commentModelId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 */
	public void removeByModelId_G(
		long groupId, String commentModel, long commentModelId);

	/**
	 * Returns the number of data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the number of matching data comments
	 */
	public int countByModelId_G(
		long groupId, String commentModel, long commentModelId);

	/**
	 * Returns all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByModel_G(
		long groupId, String commentModel);

	/**
	 * Returns a range of all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public java.util.List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end);

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModel_G_First(
			long groupId, String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModel_G_First(
		long groupId, String commentModel,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByModel_G_Last(
			long groupId, String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByModel_G_Last(
		long groupId, String commentModel,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByModel_G_PrevAndNext(
			long dataCommentId, long groupId, String commentModel,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where groupId = &#63; and commentModel = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 */
	public void removeByModel_G(long groupId, String commentModel);

	/**
	 * Returns the number of data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the number of matching data comments
	 */
	public int countByModel_G(long groupId, String commentModel);

	/**
	 * Returns all the data comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data comments
	 */
	public java.util.List<DataComment> findByGroupId(long groupId);

	/**
	 * Returns a range of all the data comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	public java.util.List<DataComment> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	public java.util.List<DataComment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public DataComment findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public DataComment fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataComment>
			orderByComparator);

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public DataComment[] findByGroupId_PrevAndNext(
			long dataCommentId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataComment>
				orderByComparator)
		throws NoSuchDataCommentException;

	/**
	 * Removes all the data comments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of data comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data comments
	 */
	public int countByGroupId(long groupId);

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