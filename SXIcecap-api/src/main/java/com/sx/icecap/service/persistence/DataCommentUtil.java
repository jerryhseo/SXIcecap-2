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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sx.icecap.model.DataComment;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the data comment service. This utility wraps <code>com.sx.icecap.service.persistence.impl.DataCommentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataCommentPersistence
 * @generated
 */
public class DataCommentUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DataComment dataComment) {
		getPersistence().clearCache(dataComment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DataComment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataComment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataComment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataComment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataComment update(DataComment dataComment) {
		return getPersistence().update(dataComment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataComment update(
		DataComment dataComment, ServiceContext serviceContext) {

		return getPersistence().update(dataComment, serviceContext);
	}

	/**
	 * Returns all the data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the matching data comments
	 */
	public static List<DataComment> findByModelId(
		String commentModel, long commentModelId) {

		return getPersistence().findByModelId(commentModel, commentModelId);
	}

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
	public static List<DataComment> findByModelId(
		String commentModel, long commentModelId, int start, int end) {

		return getPersistence().findByModelId(
			commentModel, commentModelId, start, end);
	}

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
	public static List<DataComment> findByModelId(
		String commentModel, long commentModelId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByModelId(
			commentModel, commentModelId, start, end, orderByComparator);
	}

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
	public static List<DataComment> findByModelId(
		String commentModel, long commentModelId, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByModelId(
			commentModel, commentModelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByModelId_First(
			String commentModel, long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModelId_First(
			commentModel, commentModelId, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModelId_First(
		String commentModel, long commentModelId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModelId_First(
			commentModel, commentModelId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByModelId_Last(
			String commentModel, long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModelId_Last(
			commentModel, commentModelId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModelId_Last(
		String commentModel, long commentModelId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModelId_Last(
			commentModel, commentModelId, orderByComparator);
	}

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
	public static DataComment[] findByModelId_PrevAndNext(
			long dataCommentId, String commentModel, long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModelId_PrevAndNext(
			dataCommentId, commentModel, commentModelId, orderByComparator);
	}

	/**
	 * Removes all the data comments where commentModel = &#63; and commentModelId = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 */
	public static void removeByModelId(
		String commentModel, long commentModelId) {

		getPersistence().removeByModelId(commentModel, commentModelId);
	}

	/**
	 * Returns the number of data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the number of matching data comments
	 */
	public static int countByModelId(String commentModel, long commentModelId) {
		return getPersistence().countByModelId(commentModel, commentModelId);
	}

	/**
	 * Returns all the data comments where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @return the matching data comments
	 */
	public static List<DataComment> findByModel(String commentModel) {
		return getPersistence().findByModel(commentModel);
	}

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
	public static List<DataComment> findByModel(
		String commentModel, int start, int end) {

		return getPersistence().findByModel(commentModel, start, end);
	}

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
	public static List<DataComment> findByModel(
		String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByModel(
			commentModel, start, end, orderByComparator);
	}

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
	public static List<DataComment> findByModel(
		String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByModel(
			commentModel, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByModel_First(
			String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_First(
			commentModel, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModel_First(
		String commentModel, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModel_First(
			commentModel, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByModel_Last(
			String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_Last(
			commentModel, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModel_Last(
		String commentModel, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModel_Last(
			commentModel, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByModel_PrevAndNext(
			long dataCommentId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_PrevAndNext(
			dataCommentId, commentModel, orderByComparator);
	}

	/**
	 * Removes all the data comments where commentModel = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 */
	public static void removeByModel(String commentModel) {
		getPersistence().removeByModel(commentModel);
	}

	/**
	 * Returns the number of data comments where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @return the number of matching data comments
	 */
	public static int countByModel(String commentModel) {
		return getPersistence().countByModel(commentModel);
	}

	/**
	 * Returns all the data comments where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @return the matching data comments
	 */
	public static List<DataComment> findByParentComment(long parentCommentId) {
		return getPersistence().findByParentComment(parentCommentId);
	}

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
	public static List<DataComment> findByParentComment(
		long parentCommentId, int start, int end) {

		return getPersistence().findByParentComment(
			parentCommentId, start, end);
	}

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
	public static List<DataComment> findByParentComment(
		long parentCommentId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByParentComment(
			parentCommentId, start, end, orderByComparator);
	}

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
	public static List<DataComment> findByParentComment(
		long parentCommentId, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentComment(
			parentCommentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByParentComment_First(
			long parentCommentId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByParentComment_First(
			parentCommentId, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByParentComment_First(
		long parentCommentId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByParentComment_First(
			parentCommentId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByParentComment_Last(
			long parentCommentId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByParentComment_Last(
			parentCommentId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByParentComment_Last(
		long parentCommentId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByParentComment_Last(
			parentCommentId, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByParentComment_PrevAndNext(
			long dataCommentId, long parentCommentId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByParentComment_PrevAndNext(
			dataCommentId, parentCommentId, orderByComparator);
	}

	/**
	 * Removes all the data comments where parentCommentId = &#63; from the database.
	 *
	 * @param parentCommentId the parent comment ID
	 */
	public static void removeByParentComment(long parentCommentId) {
		getPersistence().removeByParentComment(parentCommentId);
	}

	/**
	 * Returns the number of data comments where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @return the number of matching data comments
	 */
	public static int countByParentComment(long parentCommentId) {
		return getPersistence().countByParentComment(parentCommentId);
	}

	/**
	 * Returns all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the matching data comments
	 */
	public static List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId) {

		return getPersistence().findByModelId_G(
			groupId, commentModel, commentModelId);
	}

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
	public static List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId, int start,
		int end) {

		return getPersistence().findByModelId_G(
			groupId, commentModel, commentModelId, start, end);
	}

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
	public static List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId, int start,
		int end, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByModelId_G(
			groupId, commentModel, commentModelId, start, end,
			orderByComparator);
	}

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
	public static List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId, int start,
		int end, OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByModelId_G(
			groupId, commentModel, commentModelId, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static DataComment findByModelId_G_First(
			long groupId, String commentModel, long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModelId_G_First(
			groupId, commentModel, commentModelId, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModelId_G_First(
		long groupId, String commentModel, long commentModelId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModelId_G_First(
			groupId, commentModel, commentModelId, orderByComparator);
	}

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
	public static DataComment findByModelId_G_Last(
			long groupId, String commentModel, long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModelId_G_Last(
			groupId, commentModel, commentModelId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModelId_G_Last(
		long groupId, String commentModel, long commentModelId,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModelId_G_Last(
			groupId, commentModel, commentModelId, orderByComparator);
	}

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
	public static DataComment[] findByModelId_G_PrevAndNext(
			long dataCommentId, long groupId, String commentModel,
			long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModelId_G_PrevAndNext(
			dataCommentId, groupId, commentModel, commentModelId,
			orderByComparator);
	}

	/**
	 * Removes all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 */
	public static void removeByModelId_G(
		long groupId, String commentModel, long commentModelId) {

		getPersistence().removeByModelId_G(
			groupId, commentModel, commentModelId);
	}

	/**
	 * Returns the number of data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the number of matching data comments
	 */
	public static int countByModelId_G(
		long groupId, String commentModel, long commentModelId) {

		return getPersistence().countByModelId_G(
			groupId, commentModel, commentModelId);
	}

	/**
	 * Returns all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the matching data comments
	 */
	public static List<DataComment> findByModel_G(
		long groupId, String commentModel) {

		return getPersistence().findByModel_G(groupId, commentModel);
	}

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
	public static List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end) {

		return getPersistence().findByModel_G(
			groupId, commentModel, start, end);
	}

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
	public static List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByModel_G(
			groupId, commentModel, start, end, orderByComparator);
	}

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
	public static List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByModel_G(
			groupId, commentModel, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByModel_G_First(
			long groupId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_G_First(
			groupId, commentModel, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModel_G_First(
		long groupId, String commentModel,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModel_G_First(
			groupId, commentModel, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByModel_G_Last(
			long groupId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_G_Last(
			groupId, commentModel, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByModel_G_Last(
		long groupId, String commentModel,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByModel_G_Last(
			groupId, commentModel, orderByComparator);
	}

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
	public static DataComment[] findByModel_G_PrevAndNext(
			long dataCommentId, long groupId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByModel_G_PrevAndNext(
			dataCommentId, groupId, commentModel, orderByComparator);
	}

	/**
	 * Removes all the data comments where groupId = &#63; and commentModel = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 */
	public static void removeByModel_G(long groupId, String commentModel) {
		getPersistence().removeByModel_G(groupId, commentModel);
	}

	/**
	 * Returns the number of data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the number of matching data comments
	 */
	public static int countByModel_G(long groupId, String commentModel) {
		return getPersistence().countByModel_G(groupId, commentModel);
	}

	/**
	 * Returns all the data comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data comments
	 */
	public static List<DataComment> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<DataComment> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<DataComment> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<DataComment> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByGroupId_First(
			long groupId, OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByGroupId_First(
		long groupId, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	public static DataComment findByGroupId_Last(
			long groupId, OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	public static DataComment fetchByGroupId_Last(
		long groupId, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment[] findByGroupId_PrevAndNext(
			long dataCommentId, long groupId,
			OrderByComparator<DataComment> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByGroupId_PrevAndNext(
			dataCommentId, groupId, orderByComparator);
	}

	/**
	 * Removes all the data comments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of data comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data comments
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the data comment in the entity cache if it is enabled.
	 *
	 * @param dataComment the data comment
	 */
	public static void cacheResult(DataComment dataComment) {
		getPersistence().cacheResult(dataComment);
	}

	/**
	 * Caches the data comments in the entity cache if it is enabled.
	 *
	 * @param dataComments the data comments
	 */
	public static void cacheResult(List<DataComment> dataComments) {
		getPersistence().cacheResult(dataComments);
	}

	/**
	 * Creates a new data comment with the primary key. Does not add the data comment to the database.
	 *
	 * @param dataCommentId the primary key for the new data comment
	 * @return the new data comment
	 */
	public static DataComment create(long dataCommentId) {
		return getPersistence().create(dataCommentId);
	}

	/**
	 * Removes the data comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment that was removed
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment remove(long dataCommentId)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().remove(dataCommentId);
	}

	public static DataComment updateImpl(DataComment dataComment) {
		return getPersistence().updateImpl(dataComment);
	}

	/**
	 * Returns the data comment with the primary key or throws a <code>NoSuchDataCommentException</code> if it could not be found.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	public static DataComment findByPrimaryKey(long dataCommentId)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return getPersistence().findByPrimaryKey(dataCommentId);
	}

	/**
	 * Returns the data comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment, or <code>null</code> if a data comment with the primary key could not be found
	 */
	public static DataComment fetchByPrimaryKey(long dataCommentId) {
		return getPersistence().fetchByPrimaryKey(dataCommentId);
	}

	/**
	 * Returns all the data comments.
	 *
	 * @return the data comments
	 */
	public static List<DataComment> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DataComment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DataComment> findAll(
		int start, int end, OrderByComparator<DataComment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DataComment> findAll(
		int start, int end, OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the data comments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data comments.
	 *
	 * @return the number of data comments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataCommentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DataCommentPersistence _persistence;

}