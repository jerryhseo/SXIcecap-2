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

import com.sx.icecap.exception.NoSuchActionHistoryException;
import com.sx.icecap.model.ActionHistory;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the action history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActionHistoryUtil
 * @generated
 */
@ProviderType
public interface ActionHistoryPersistence
	extends BasePersistence<ActionHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ActionHistoryUtil} to access the action history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the action histories where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching action histories
	 */
	public java.util.List<ActionHistory> findByDataId(long structuredDataId);

	/**
	 * Returns a range of all the action histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @return the range of matching action histories
	 */
	public java.util.List<ActionHistory> findByDataId(
		long structuredDataId, int start, int end);

	/**
	 * Returns an ordered range of all the action histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching action histories
	 */
	public java.util.List<ActionHistory> findByDataId(
		long structuredDataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActionHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the action histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching action histories
	 */
	public java.util.List<ActionHistory> findByDataId(
		long structuredDataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActionHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first action history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action history
	 * @throws NoSuchActionHistoryException if a matching action history could not be found
	 */
	public ActionHistory findByDataId_First(
			long structuredDataId,
			com.liferay.portal.kernel.util.OrderByComparator<ActionHistory>
				orderByComparator)
		throws NoSuchActionHistoryException;

	/**
	 * Returns the first action history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action history, or <code>null</code> if a matching action history could not be found
	 */
	public ActionHistory fetchByDataId_First(
		long structuredDataId,
		com.liferay.portal.kernel.util.OrderByComparator<ActionHistory>
			orderByComparator);

	/**
	 * Returns the last action history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action history
	 * @throws NoSuchActionHistoryException if a matching action history could not be found
	 */
	public ActionHistory findByDataId_Last(
			long structuredDataId,
			com.liferay.portal.kernel.util.OrderByComparator<ActionHistory>
				orderByComparator)
		throws NoSuchActionHistoryException;

	/**
	 * Returns the last action history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action history, or <code>null</code> if a matching action history could not be found
	 */
	public ActionHistory fetchByDataId_Last(
		long structuredDataId,
		com.liferay.portal.kernel.util.OrderByComparator<ActionHistory>
			orderByComparator);

	/**
	 * Returns the action histories before and after the current action history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param actionHistoryId the primary key of the current action history
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next action history
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	public ActionHistory[] findByDataId_PrevAndNext(
			long actionHistoryId, long structuredDataId,
			com.liferay.portal.kernel.util.OrderByComparator<ActionHistory>
				orderByComparator)
		throws NoSuchActionHistoryException;

	/**
	 * Removes all the action histories where structuredDataId = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 */
	public void removeByDataId(long structuredDataId);

	/**
	 * Returns the number of action histories where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the number of matching action histories
	 */
	public int countByDataId(long structuredDataId);

	/**
	 * Returns the action history where structuredDataId = &#63; and paramCode = &#63; or throws a <code>NoSuchActionHistoryException</code> if it could not be found.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramCode the param code
	 * @return the matching action history
	 * @throws NoSuchActionHistoryException if a matching action history could not be found
	 */
	public ActionHistory findByParamCode(
			long structuredDataId, String paramCode)
		throws NoSuchActionHistoryException;

	/**
	 * Returns the action history where structuredDataId = &#63; and paramCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramCode the param code
	 * @return the matching action history, or <code>null</code> if a matching action history could not be found
	 */
	public ActionHistory fetchByParamCode(
		long structuredDataId, String paramCode);

	/**
	 * Returns the action history where structuredDataId = &#63; and paramCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramCode the param code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching action history, or <code>null</code> if a matching action history could not be found
	 */
	public ActionHistory fetchByParamCode(
		long structuredDataId, String paramCode, boolean useFinderCache);

	/**
	 * Removes the action history where structuredDataId = &#63; and paramCode = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramCode the param code
	 * @return the action history that was removed
	 */
	public ActionHistory removeByParamCode(
			long structuredDataId, String paramCode)
		throws NoSuchActionHistoryException;

	/**
	 * Returns the number of action histories where structuredDataId = &#63; and paramCode = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramCode the param code
	 * @return the number of matching action histories
	 */
	public int countByParamCode(long structuredDataId, String paramCode);

	/**
	 * Caches the action history in the entity cache if it is enabled.
	 *
	 * @param actionHistory the action history
	 */
	public void cacheResult(ActionHistory actionHistory);

	/**
	 * Caches the action histories in the entity cache if it is enabled.
	 *
	 * @param actionHistories the action histories
	 */
	public void cacheResult(java.util.List<ActionHistory> actionHistories);

	/**
	 * Creates a new action history with the primary key. Does not add the action history to the database.
	 *
	 * @param actionHistoryId the primary key for the new action history
	 * @return the new action history
	 */
	public ActionHistory create(long actionHistoryId);

	/**
	 * Removes the action history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history that was removed
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	public ActionHistory remove(long actionHistoryId)
		throws NoSuchActionHistoryException;

	public ActionHistory updateImpl(ActionHistory actionHistory);

	/**
	 * Returns the action history with the primary key or throws a <code>NoSuchActionHistoryException</code> if it could not be found.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	public ActionHistory findByPrimaryKey(long actionHistoryId)
		throws NoSuchActionHistoryException;

	/**
	 * Returns the action history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history, or <code>null</code> if a action history with the primary key could not be found
	 */
	public ActionHistory fetchByPrimaryKey(long actionHistoryId);

	/**
	 * Returns all the action histories.
	 *
	 * @return the action histories
	 */
	public java.util.List<ActionHistory> findAll();

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
	public java.util.List<ActionHistory> findAll(int start, int end);

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
	public java.util.List<ActionHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActionHistory>
			orderByComparator);

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
	public java.util.List<ActionHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ActionHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the action histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of action histories.
	 *
	 * @return the number of action histories
	 */
	public int countAll();

}