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
 * Provides a wrapper for {@link DataStructureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataStructureLocalService
 * @generated
 */
public class DataStructureLocalServiceWrapper
	implements DataStructureLocalService,
			   ServiceWrapper<DataStructureLocalService> {

	public DataStructureLocalServiceWrapper(
		DataStructureLocalService dataStructureLocalService) {

		_dataStructureLocalService = dataStructureLocalService;
	}

	/**
	 * Adds the data structure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataStructure the data structure
	 * @return the data structure that was added
	 */
	@Override
	public com.sx.icecap.model.DataStructure addDataStructure(
		com.sx.icecap.model.DataStructure dataStructure) {

		return _dataStructureLocalService.addDataStructure(dataStructure);
	}

	/**
	 * Creates a new data structure with the primary key. Does not add the data structure to the database.
	 *
	 * @param dataTypeId the primary key for the new data structure
	 * @return the new data structure
	 */
	@Override
	public com.sx.icecap.model.DataStructure createDataStructure(
		long dataTypeId) {

		return _dataStructureLocalService.createDataStructure(dataTypeId);
	}

	/**
	 * Deletes the data structure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataStructure the data structure
	 * @return the data structure that was removed
	 */
	@Override
	public com.sx.icecap.model.DataStructure deleteDataStructure(
		com.sx.icecap.model.DataStructure dataStructure) {

		return _dataStructureLocalService.deleteDataStructure(dataStructure);
	}

	/**
	 * Deletes the data structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataTypeId the primary key of the data structure
	 * @return the data structure that was removed
	 * @throws PortalException if a data structure with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataStructure deleteDataStructure(
			long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataStructureLocalService.deleteDataStructure(dataTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataStructureLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataStructureLocalService.dynamicQuery();
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

		return _dataStructureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataStructureModelImpl</code>.
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

		return _dataStructureLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataStructureModelImpl</code>.
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

		return _dataStructureLocalService.dynamicQuery(
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

		return _dataStructureLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataStructureLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.DataStructure fetchDataStructure(
		long dataTypeId) {

		return _dataStructureLocalService.fetchDataStructure(dataTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataStructureLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the data structure with the primary key.
	 *
	 * @param dataTypeId the primary key of the data structure
	 * @return the data structure
	 * @throws PortalException if a data structure with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataStructure getDataStructure(long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataStructureLocalService.getDataStructure(dataTypeId);
	}

	/**
	 * Returns a range of all the data structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of data structures
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataStructure> getDataStructures(
		int start, int end) {

		return _dataStructureLocalService.getDataStructures(start, end);
	}

	/**
	 * Returns the number of data structures.
	 *
	 * @return the number of data structures
	 */
	@Override
	public int getDataStructuresCount() {
		return _dataStructureLocalService.getDataStructuresCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataStructureLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataStructureLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataStructureLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the data structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataStructure the data structure
	 * @return the data structure that was updated
	 */
	@Override
	public com.sx.icecap.model.DataStructure updateDataStructure(
		com.sx.icecap.model.DataStructure dataStructure) {

		return _dataStructureLocalService.updateDataStructure(dataStructure);
	}

	@Override
	public DataStructureLocalService getWrappedService() {
		return _dataStructureLocalService;
	}

	@Override
	public void setWrappedService(
		DataStructureLocalService dataStructureLocalService) {

		_dataStructureLocalService = dataStructureLocalService;
	}

	private DataStructureLocalService _dataStructureLocalService;

}