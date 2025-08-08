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

package com.sx.icecap.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActionHistoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActionHistoryLocalService
 * @generated
 */
public class ActionHistoryLocalServiceWrapper
	implements ActionHistoryLocalService,
			   ServiceWrapper<ActionHistoryLocalService> {

	public ActionHistoryLocalServiceWrapper(
		ActionHistoryLocalService actionHistoryLocalService) {

		_actionHistoryLocalService = actionHistoryLocalService;
	}

	/**
	 * Adds the action history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActionHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param actionHistory the action history
	 * @return the action history that was added
	 */
	@Override
	public com.sx.icecap.model.ActionHistory addActionHistory(
		com.sx.icecap.model.ActionHistory actionHistory) {

		return _actionHistoryLocalService.addActionHistory(actionHistory);
	}

	/**
	 * Creates a new action history with the primary key. Does not add the action history to the database.
	 *
	 * @param actionHistoryId the primary key for the new action history
	 * @return the new action history
	 */
	@Override
	public com.sx.icecap.model.ActionHistory createActionHistory(
		long actionHistoryId) {

		return _actionHistoryLocalService.createActionHistory(actionHistoryId);
	}

	/**
	 * Deletes the action history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActionHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param actionHistory the action history
	 * @return the action history that was removed
	 */
	@Override
	public com.sx.icecap.model.ActionHistory deleteActionHistory(
		com.sx.icecap.model.ActionHistory actionHistory) {

		return _actionHistoryLocalService.deleteActionHistory(actionHistory);
	}

	/**
	 * Deletes the action history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActionHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history that was removed
	 * @throws PortalException if a action history with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.ActionHistory deleteActionHistory(
			long actionHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actionHistoryLocalService.deleteActionHistory(actionHistoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actionHistoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _actionHistoryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _actionHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _actionHistoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _actionHistoryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _actionHistoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _actionHistoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.ActionHistory fetchActionHistory(
		long actionHistoryId) {

		return _actionHistoryLocalService.fetchActionHistory(actionHistoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _actionHistoryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @return the range of action histories
	 */
	@Override
	public java.util.List<com.sx.icecap.model.ActionHistory> getActionHistories(
		int start, int end) {

		return _actionHistoryLocalService.getActionHistories(start, end);
	}

	/**
	 * Returns the number of action histories.
	 *
	 * @return the number of action histories
	 */
	@Override
	public int getActionHistoriesCount() {
		return _actionHistoryLocalService.getActionHistoriesCount();
	}

	/**
	 * Returns the action history with the primary key.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history
	 * @throws PortalException if a action history with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.ActionHistory getActionHistory(
			long actionHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actionHistoryLocalService.getActionHistory(actionHistoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _actionHistoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _actionHistoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actionHistoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the action history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActionHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param actionHistory the action history
	 * @return the action history that was updated
	 */
	@Override
	public com.sx.icecap.model.ActionHistory updateActionHistory(
		com.sx.icecap.model.ActionHistory actionHistory) {

		return _actionHistoryLocalService.updateActionHistory(actionHistory);
	}

	@Override
	public ActionHistoryLocalService getWrappedService() {
		return _actionHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		ActionHistoryLocalService actionHistoryLocalService) {

		_actionHistoryLocalService = actionHistoryLocalService;
	}

	private ActionHistoryLocalService _actionHistoryLocalService;

}