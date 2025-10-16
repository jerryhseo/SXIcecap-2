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
 * Provides a wrapper for {@link DataCommentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataCommentLocalService
 * @generated
 */
public class DataCommentLocalServiceWrapper
	implements DataCommentLocalService,
			   ServiceWrapper<DataCommentLocalService> {

	public DataCommentLocalServiceWrapper(
		DataCommentLocalService dataCommentLocalService) {

		_dataCommentLocalService = dataCommentLocalService;
	}

	/**
	 * Adds the data comment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataComment the data comment
	 * @return the data comment that was added
	 */
	@Override
	public com.sx.icecap.model.DataComment addDataComment(
		com.sx.icecap.model.DataComment dataComment) {

		return _dataCommentLocalService.addDataComment(dataComment);
	}

	@Override
	public com.sx.icecap.model.DataComment addDataComment(
			String commentModel, long commentModelId, long parentCommentId,
			String comment, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCommentLocalService.addDataComment(
			commentModel, commentModelId, parentCommentId, comment, sc);
	}

	@Override
	public int countDataComments(String commentModel, long commentModelId) {
		return _dataCommentLocalService.countDataComments(
			commentModel, commentModelId);
	}

	/**
	 * Creates a new data comment with the primary key. Does not add the data comment to the database.
	 *
	 * @param dataCommentId the primary key for the new data comment
	 * @return the new data comment
	 */
	@Override
	public com.sx.icecap.model.DataComment createDataComment(
		long dataCommentId) {

		return _dataCommentLocalService.createDataComment(dataCommentId);
	}

	/**
	 * Deletes the data comment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataComment the data comment
	 * @return the data comment that was removed
	 */
	@Override
	public com.sx.icecap.model.DataComment deleteDataComment(
		com.sx.icecap.model.DataComment dataComment) {

		return _dataCommentLocalService.deleteDataComment(dataComment);
	}

	/**
	 * Deletes the data comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment that was removed
	 * @throws PortalException if a data comment with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataComment deleteDataComment(long dataCommentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCommentLocalService.deleteDataComment(dataCommentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCommentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataCommentLocalService.dynamicQuery();
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

		return _dataCommentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataCommentModelImpl</code>.
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

		return _dataCommentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataCommentModelImpl</code>.
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

		return _dataCommentLocalService.dynamicQuery(
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

		return _dataCommentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataCommentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.DataComment fetchDataComment(
		long dataCommentId) {

		return _dataCommentLocalService.fetchDataComment(dataCommentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataCommentLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the data comment with the primary key.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment
	 * @throws PortalException if a data comment with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataComment getDataComment(long dataCommentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCommentLocalService.getDataComment(dataCommentId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataComment> getDataCommentList(
		String commentModel, long commentModelId) {

		return _dataCommentLocalService.getDataCommentList(
			commentModel, commentModelId);
	}

	/**
	 * Returns a range of all the data comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of data comments
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataComment> getDataComments(
		int start, int end) {

		return _dataCommentLocalService.getDataComments(start, end);
	}

	/**
	 * Returns the number of data comments.
	 *
	 * @return the number of data comments
	 */
	@Override
	public int getDataCommentsCount() {
		return _dataCommentLocalService.getDataCommentsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataCommentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataCommentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCommentLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasComments(String commentModel, long commentModelId) {
		return _dataCommentLocalService.hasComments(
			commentModel, commentModelId);
	}

	@Override
	public com.sx.icecap.model.DataComment removeDataComment(long dataCommentId)
		throws com.sx.icecap.exception.NoSuchDataCommentException {

		return _dataCommentLocalService.removeDataComment(dataCommentId);
	}

	@Override
	public void removeDataComment(String commentModel) {
		_dataCommentLocalService.removeDataComment(commentModel);
	}

	@Override
	public void removeDataCommentByModelId(
		String commentModel, long commentModelId) {

		_dataCommentLocalService.removeDataCommentByModelId(
			commentModel, commentModelId);
	}

	/**
	 * Updates the data comment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataComment the data comment
	 * @return the data comment that was updated
	 */
	@Override
	public com.sx.icecap.model.DataComment updateDataComment(
		com.sx.icecap.model.DataComment dataComment) {

		return _dataCommentLocalService.updateDataComment(dataComment);
	}

	@Override
	public com.sx.icecap.model.DataComment updateDataComment(
			long dataCommentId, String commentModel, long commentModelId,
			long parentCommentId, String comment,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataCommentLocalService.updateDataComment(
			dataCommentId, commentModel, commentModelId, parentCommentId,
			comment, sc);
	}

	@Override
	public DataCommentLocalService getWrappedService() {
		return _dataCommentLocalService;
	}

	@Override
	public void setWrappedService(
		DataCommentLocalService dataCommentLocalService) {

		_dataCommentLocalService = dataCommentLocalService;
	}

	private DataCommentLocalService _dataCommentLocalService;

}