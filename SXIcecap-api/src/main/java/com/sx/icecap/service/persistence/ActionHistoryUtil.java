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

import com.sx.icecap.model.ActionHistory;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the action history service. This utility wraps <code>com.sx.icecap.service.persistence.impl.ActionHistoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActionHistoryPersistence
 * @generated
 */
public class ActionHistoryUtil {

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
	public static void clearCache(ActionHistory actionHistory) {
		getPersistence().clearCache(actionHistory);
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
	public static Map<Serializable, ActionHistory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ActionHistory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ActionHistory update(ActionHistory actionHistory) {
		return getPersistence().update(actionHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ActionHistory update(
		ActionHistory actionHistory, ServiceContext serviceContext) {

		return getPersistence().update(actionHistory, serviceContext);
	}

	/**
	 * Returns all the action histories where actionModel = &#63; and dataId = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @return the matching action histories
	 */
	public static List<ActionHistory> findByDataId(
		String actionModel, long dataId) {

		return getPersistence().findByDataId(actionModel, dataId);
	}

	/**
	 * Returns a range of all the action histories where actionModel = &#63; and dataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @return the range of matching action histories
	 */
	public static List<ActionHistory> findByDataId(
		String actionModel, long dataId, int start, int end) {

		return getPersistence().findByDataId(actionModel, dataId, start, end);
	}

	/**
	 * Returns an ordered range of all the action histories where actionModel = &#63; and dataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching action histories
	 */
	public static List<ActionHistory> findByDataId(
		String actionModel, long dataId, int start, int end,
		OrderByComparator<ActionHistory> orderByComparator) {

		return getPersistence().findByDataId(
			actionModel, dataId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the action histories where actionModel = &#63; and dataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching action histories
	 */
	public static List<ActionHistory> findByDataId(
		String actionModel, long dataId, int start, int end,
		OrderByComparator<ActionHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataId(
			actionModel, dataId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first action history in the ordered set where actionModel = &#63; and dataId = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action history
	 * @throws NoSuchActionHistoryException if a matching action history could not be found
	 */
	public static ActionHistory findByDataId_First(
			String actionModel, long dataId,
			OrderByComparator<ActionHistory> orderByComparator)
		throws com.sx.icecap.exception.NoSuchActionHistoryException {

		return getPersistence().findByDataId_First(
			actionModel, dataId, orderByComparator);
	}

	/**
	 * Returns the first action history in the ordered set where actionModel = &#63; and dataId = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action history, or <code>null</code> if a matching action history could not be found
	 */
	public static ActionHistory fetchByDataId_First(
		String actionModel, long dataId,
		OrderByComparator<ActionHistory> orderByComparator) {

		return getPersistence().fetchByDataId_First(
			actionModel, dataId, orderByComparator);
	}

	/**
	 * Returns the last action history in the ordered set where actionModel = &#63; and dataId = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action history
	 * @throws NoSuchActionHistoryException if a matching action history could not be found
	 */
	public static ActionHistory findByDataId_Last(
			String actionModel, long dataId,
			OrderByComparator<ActionHistory> orderByComparator)
		throws com.sx.icecap.exception.NoSuchActionHistoryException {

		return getPersistence().findByDataId_Last(
			actionModel, dataId, orderByComparator);
	}

	/**
	 * Returns the last action history in the ordered set where actionModel = &#63; and dataId = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action history, or <code>null</code> if a matching action history could not be found
	 */
	public static ActionHistory fetchByDataId_Last(
		String actionModel, long dataId,
		OrderByComparator<ActionHistory> orderByComparator) {

		return getPersistence().fetchByDataId_Last(
			actionModel, dataId, orderByComparator);
	}

	/**
	 * Returns the action histories before and after the current action history in the ordered set where actionModel = &#63; and dataId = &#63;.
	 *
	 * @param actionHistoryId the primary key of the current action history
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next action history
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	public static ActionHistory[] findByDataId_PrevAndNext(
			long actionHistoryId, String actionModel, long dataId,
			OrderByComparator<ActionHistory> orderByComparator)
		throws com.sx.icecap.exception.NoSuchActionHistoryException {

		return getPersistence().findByDataId_PrevAndNext(
			actionHistoryId, actionModel, dataId, orderByComparator);
	}

	/**
	 * Removes all the action histories where actionModel = &#63; and dataId = &#63; from the database.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 */
	public static void removeByDataId(String actionModel, long dataId) {
		getPersistence().removeByDataId(actionModel, dataId);
	}

	/**
	 * Returns the number of action histories where actionModel = &#63; and dataId = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @return the number of matching action histories
	 */
	public static int countByDataId(String actionModel, long dataId) {
		return getPersistence().countByDataId(actionModel, dataId);
	}

	/**
	 * Returns all the action histories where actionModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @return the matching action histories
	 */
	public static List<ActionHistory> findByParamCode(
		String actionModel, long dataId, String paramCode) {

		return getPersistence().findByParamCode(actionModel, dataId, paramCode);
	}

	/**
	 * Returns a range of all the action histories where actionModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @return the range of matching action histories
	 */
	public static List<ActionHistory> findByParamCode(
		String actionModel, long dataId, String paramCode, int start, int end) {

		return getPersistence().findByParamCode(
			actionModel, dataId, paramCode, start, end);
	}

	/**
	 * Returns an ordered range of all the action histories where actionModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching action histories
	 */
	public static List<ActionHistory> findByParamCode(
		String actionModel, long dataId, String paramCode, int start, int end,
		OrderByComparator<ActionHistory> orderByComparator) {

		return getPersistence().findByParamCode(
			actionModel, dataId, paramCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the action histories where actionModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching action histories
	 */
	public static List<ActionHistory> findByParamCode(
		String actionModel, long dataId, String paramCode, int start, int end,
		OrderByComparator<ActionHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParamCode(
			actionModel, dataId, paramCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first action history in the ordered set where actionModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action history
	 * @throws NoSuchActionHistoryException if a matching action history could not be found
	 */
	public static ActionHistory findByParamCode_First(
			String actionModel, long dataId, String paramCode,
			OrderByComparator<ActionHistory> orderByComparator)
		throws com.sx.icecap.exception.NoSuchActionHistoryException {

		return getPersistence().findByParamCode_First(
			actionModel, dataId, paramCode, orderByComparator);
	}

	/**
	 * Returns the first action history in the ordered set where actionModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action history, or <code>null</code> if a matching action history could not be found
	 */
	public static ActionHistory fetchByParamCode_First(
		String actionModel, long dataId, String paramCode,
		OrderByComparator<ActionHistory> orderByComparator) {

		return getPersistence().fetchByParamCode_First(
			actionModel, dataId, paramCode, orderByComparator);
	}

	/**
	 * Returns the last action history in the ordered set where actionModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action history
	 * @throws NoSuchActionHistoryException if a matching action history could not be found
	 */
	public static ActionHistory findByParamCode_Last(
			String actionModel, long dataId, String paramCode,
			OrderByComparator<ActionHistory> orderByComparator)
		throws com.sx.icecap.exception.NoSuchActionHistoryException {

		return getPersistence().findByParamCode_Last(
			actionModel, dataId, paramCode, orderByComparator);
	}

	/**
	 * Returns the last action history in the ordered set where actionModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action history, or <code>null</code> if a matching action history could not be found
	 */
	public static ActionHistory fetchByParamCode_Last(
		String actionModel, long dataId, String paramCode,
		OrderByComparator<ActionHistory> orderByComparator) {

		return getPersistence().fetchByParamCode_Last(
			actionModel, dataId, paramCode, orderByComparator);
	}

	/**
	 * Returns the action histories before and after the current action history in the ordered set where actionModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param actionHistoryId the primary key of the current action history
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next action history
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	public static ActionHistory[] findByParamCode_PrevAndNext(
			long actionHistoryId, String actionModel, long dataId,
			String paramCode,
			OrderByComparator<ActionHistory> orderByComparator)
		throws com.sx.icecap.exception.NoSuchActionHistoryException {

		return getPersistence().findByParamCode_PrevAndNext(
			actionHistoryId, actionModel, dataId, paramCode, orderByComparator);
	}

	/**
	 * Removes all the action histories where actionModel = &#63; and dataId = &#63; and paramCode = &#63; from the database.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 */
	public static void removeByParamCode(
		String actionModel, long dataId, String paramCode) {

		getPersistence().removeByParamCode(actionModel, dataId, paramCode);
	}

	/**
	 * Returns the number of action histories where actionModel = &#63; and dataId = &#63; and paramCode = &#63;.
	 *
	 * @param actionModel the action model
	 * @param dataId the data ID
	 * @param paramCode the param code
	 * @return the number of matching action histories
	 */
	public static int countByParamCode(
		String actionModel, long dataId, String paramCode) {

		return getPersistence().countByParamCode(
			actionModel, dataId, paramCode);
	}

	/**
	 * Caches the action history in the entity cache if it is enabled.
	 *
	 * @param actionHistory the action history
	 */
	public static void cacheResult(ActionHistory actionHistory) {
		getPersistence().cacheResult(actionHistory);
	}

	/**
	 * Caches the action histories in the entity cache if it is enabled.
	 *
	 * @param actionHistories the action histories
	 */
	public static void cacheResult(List<ActionHistory> actionHistories) {
		getPersistence().cacheResult(actionHistories);
	}

	/**
	 * Creates a new action history with the primary key. Does not add the action history to the database.
	 *
	 * @param actionHistoryId the primary key for the new action history
	 * @return the new action history
	 */
	public static ActionHistory create(long actionHistoryId) {
		return getPersistence().create(actionHistoryId);
	}

	/**
	 * Removes the action history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history that was removed
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	public static ActionHistory remove(long actionHistoryId)
		throws com.sx.icecap.exception.NoSuchActionHistoryException {

		return getPersistence().remove(actionHistoryId);
	}

	public static ActionHistory updateImpl(ActionHistory actionHistory) {
		return getPersistence().updateImpl(actionHistory);
	}

	/**
	 * Returns the action history with the primary key or throws a <code>NoSuchActionHistoryException</code> if it could not be found.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	public static ActionHistory findByPrimaryKey(long actionHistoryId)
		throws com.sx.icecap.exception.NoSuchActionHistoryException {

		return getPersistence().findByPrimaryKey(actionHistoryId);
	}

	/**
	 * Returns the action history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history, or <code>null</code> if a action history with the primary key could not be found
	 */
	public static ActionHistory fetchByPrimaryKey(long actionHistoryId) {
		return getPersistence().fetchByPrimaryKey(actionHistoryId);
	}

	/**
	 * Returns all the action histories.
	 *
	 * @return the action histories
	 */
	public static List<ActionHistory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @return the range of action histories
	 */
	public static List<ActionHistory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of action histories
	 */
	public static List<ActionHistory> findAll(
		int start, int end,
		OrderByComparator<ActionHistory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of action histories
	 */
	public static List<ActionHistory> findAll(
		int start, int end, OrderByComparator<ActionHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the action histories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of action histories.
	 *
	 * @return the number of action histories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ActionHistoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ActionHistoryPersistence _persistence;

}