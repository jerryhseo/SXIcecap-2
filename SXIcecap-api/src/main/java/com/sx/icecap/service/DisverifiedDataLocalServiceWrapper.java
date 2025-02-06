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
 * Provides a wrapper for {@link DisverifiedDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DisverifiedDataLocalService
 * @generated
 */
public class DisverifiedDataLocalServiceWrapper
	implements DisverifiedDataLocalService,
			   ServiceWrapper<DisverifiedDataLocalService> {

	public DisverifiedDataLocalServiceWrapper(
		DisverifiedDataLocalService disverifiedDataLocalService) {

		_disverifiedDataLocalService = disverifiedDataLocalService;
	}

	/**
	 * Adds the disverified data to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DisverifiedDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param disverifiedData the disverified data
	 * @return the disverified data that was added
	 */
	@Override
	public com.sx.icecap.model.DisverifiedData addDisverifiedData(
		com.sx.icecap.model.DisverifiedData disverifiedData) {

		return _disverifiedDataLocalService.addDisverifiedData(disverifiedData);
	}

	/**
	 * Creates a new disverified data with the primary key. Does not add the disverified data to the database.
	 *
	 * @param disverifiedDataId the primary key for the new disverified data
	 * @return the new disverified data
	 */
	@Override
	public com.sx.icecap.model.DisverifiedData createDisverifiedData(
		long disverifiedDataId) {

		return _disverifiedDataLocalService.createDisverifiedData(
			disverifiedDataId);
	}

	/**
	 * Deletes the disverified data from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DisverifiedDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param disverifiedData the disverified data
	 * @return the disverified data that was removed
	 */
	@Override
	public com.sx.icecap.model.DisverifiedData deleteDisverifiedData(
		com.sx.icecap.model.DisverifiedData disverifiedData) {

		return _disverifiedDataLocalService.deleteDisverifiedData(
			disverifiedData);
	}

	/**
	 * Deletes the disverified data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DisverifiedDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param disverifiedDataId the primary key of the disverified data
	 * @return the disverified data that was removed
	 * @throws PortalException if a disverified data with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DisverifiedData deleteDisverifiedData(
			long disverifiedDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _disverifiedDataLocalService.deleteDisverifiedData(
			disverifiedDataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _disverifiedDataLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _disverifiedDataLocalService.dynamicQuery();
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

		return _disverifiedDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DisverifiedDataModelImpl</code>.
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

		return _disverifiedDataLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DisverifiedDataModelImpl</code>.
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

		return _disverifiedDataLocalService.dynamicQuery(
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

		return _disverifiedDataLocalService.dynamicQueryCount(dynamicQuery);
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

		return _disverifiedDataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.DisverifiedData fetchDisverifiedData(
		long disverifiedDataId) {

		return _disverifiedDataLocalService.fetchDisverifiedData(
			disverifiedDataId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _disverifiedDataLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the disverified data with the primary key.
	 *
	 * @param disverifiedDataId the primary key of the disverified data
	 * @return the disverified data
	 * @throws PortalException if a disverified data with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DisverifiedData getDisverifiedData(
			long disverifiedDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _disverifiedDataLocalService.getDisverifiedData(
			disverifiedDataId);
	}

	/**
	 * Returns a range of all the disverified datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of disverified datas
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DisverifiedData>
		getDisverifiedDatas(int start, int end) {

		return _disverifiedDataLocalService.getDisverifiedDatas(start, end);
	}

	/**
	 * Returns the number of disverified datas.
	 *
	 * @return the number of disverified datas
	 */
	@Override
	public int getDisverifiedDatasCount() {
		return _disverifiedDataLocalService.getDisverifiedDatasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _disverifiedDataLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _disverifiedDataLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _disverifiedDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the disverified data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DisverifiedDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param disverifiedData the disverified data
	 * @return the disverified data that was updated
	 */
	@Override
	public com.sx.icecap.model.DisverifiedData updateDisverifiedData(
		com.sx.icecap.model.DisverifiedData disverifiedData) {

		return _disverifiedDataLocalService.updateDisverifiedData(
			disverifiedData);
	}

	@Override
	public DisverifiedDataLocalService getWrappedService() {
		return _disverifiedDataLocalService;
	}

	@Override
	public void setWrappedService(
		DisverifiedDataLocalService disverifiedDataLocalService) {

		_disverifiedDataLocalService = disverifiedDataLocalService;
	}

	private DisverifiedDataLocalService _disverifiedDataLocalService;

}