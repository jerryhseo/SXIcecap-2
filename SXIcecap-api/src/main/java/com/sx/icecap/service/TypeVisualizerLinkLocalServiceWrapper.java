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
 * Provides a wrapper for {@link TypeVisualizerLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TypeVisualizerLinkLocalService
 * @generated
 */
public class TypeVisualizerLinkLocalServiceWrapper
	implements ServiceWrapper<TypeVisualizerLinkLocalService>,
			   TypeVisualizerLinkLocalService {

	public TypeVisualizerLinkLocalServiceWrapper(
		TypeVisualizerLinkLocalService typeVisualizerLinkLocalService) {

		_typeVisualizerLinkLocalService = typeVisualizerLinkLocalService;
	}

	@Override
	public com.sx.icecap.model.TypeVisualizerLink addTypeVisualizerLink(
		long dataTypeId, long visualizerId) {

		return _typeVisualizerLinkLocalService.addTypeVisualizerLink(
			dataTypeId, visualizerId);
	}

	/**
	 * Adds the type visualizer link to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeVisualizerLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeVisualizerLink the type visualizer link
	 * @return the type visualizer link that was added
	 */
	@Override
	public com.sx.icecap.model.TypeVisualizerLink addTypeVisualizerLink(
		com.sx.icecap.model.TypeVisualizerLink typeVisualizerLink) {

		return _typeVisualizerLinkLocalService.addTypeVisualizerLink(
			typeVisualizerLink);
	}

	/**
	 * Creates a new type visualizer link with the primary key. Does not add the type visualizer link to the database.
	 *
	 * @param typeVisualizerLinkId the primary key for the new type visualizer link
	 * @return the new type visualizer link
	 */
	@Override
	public com.sx.icecap.model.TypeVisualizerLink createTypeVisualizerLink(
		long typeVisualizerLinkId) {

		return _typeVisualizerLinkLocalService.createTypeVisualizerLink(
			typeVisualizerLinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeVisualizerLinkLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the type visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeVisualizerLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeVisualizerLinkId the primary key of the type visualizer link
	 * @return the type visualizer link that was removed
	 * @throws PortalException if a type visualizer link with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.TypeVisualizerLink deleteTypeVisualizerLink(
			long typeVisualizerLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeVisualizerLinkLocalService.deleteTypeVisualizerLink(
			typeVisualizerLinkId);
	}

	/**
	 * Deletes the type visualizer link from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeVisualizerLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeVisualizerLink the type visualizer link
	 * @return the type visualizer link that was removed
	 */
	@Override
	public com.sx.icecap.model.TypeVisualizerLink deleteTypeVisualizerLink(
		com.sx.icecap.model.TypeVisualizerLink typeVisualizerLink) {

		return _typeVisualizerLinkLocalService.deleteTypeVisualizerLink(
			typeVisualizerLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _typeVisualizerLinkLocalService.dynamicQuery();
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

		return _typeVisualizerLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TypeVisualizerLinkModelImpl</code>.
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

		return _typeVisualizerLinkLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TypeVisualizerLinkModelImpl</code>.
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

		return _typeVisualizerLinkLocalService.dynamicQuery(
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

		return _typeVisualizerLinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _typeVisualizerLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.TypeVisualizerLink fetchTypeVisualizerLink(
		long typeVisualizerLinkId) {

		return _typeVisualizerLinkLocalService.fetchTypeVisualizerLink(
			typeVisualizerLinkId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _typeVisualizerLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _typeVisualizerLinkLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _typeVisualizerLinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeVisualizerLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the type visualizer link with the primary key.
	 *
	 * @param typeVisualizerLinkId the primary key of the type visualizer link
	 * @return the type visualizer link
	 * @throws PortalException if a type visualizer link with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.TypeVisualizerLink getTypeVisualizerLink(
			long typeVisualizerLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeVisualizerLinkLocalService.getTypeVisualizerLink(
			typeVisualizerLinkId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.TypeVisualizerLink>
		getTypeVisualizerLinkList(long dataTypeId) {

		return _typeVisualizerLinkLocalService.getTypeVisualizerLinkList(
			dataTypeId);
	}

	/**
	 * Returns a range of all the type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @return the range of type visualizer links
	 */
	@Override
	public java.util.List<com.sx.icecap.model.TypeVisualizerLink>
		getTypeVisualizerLinks(int start, int end) {

		return _typeVisualizerLinkLocalService.getTypeVisualizerLinks(
			start, end);
	}

	/**
	 * Returns the number of type visualizer links.
	 *
	 * @return the number of type visualizer links
	 */
	@Override
	public int getTypeVisualizerLinksCount() {
		return _typeVisualizerLinkLocalService.getTypeVisualizerLinksCount();
	}

	@Override
	public void removeByDataTypeId(long dataTypeId) {
		_typeVisualizerLinkLocalService.removeByDataTypeId(dataTypeId);
	}

	@Override
	public com.sx.icecap.model.TypeVisualizerLink removeTypeVisualizerLink(
			long linkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeVisualizerLinkLocalService.removeTypeVisualizerLink(linkId);
	}

	@Override
	public com.sx.icecap.model.TypeVisualizerLink updateTypeVisualizerLink(
			long linkId, long dataTypeId, long visualizerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeVisualizerLinkLocalService.updateTypeVisualizerLink(
			linkId, dataTypeId, visualizerId);
	}

	/**
	 * Updates the type visualizer link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeVisualizerLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeVisualizerLink the type visualizer link
	 * @return the type visualizer link that was updated
	 */
	@Override
	public com.sx.icecap.model.TypeVisualizerLink updateTypeVisualizerLink(
		com.sx.icecap.model.TypeVisualizerLink typeVisualizerLink) {

		return _typeVisualizerLinkLocalService.updateTypeVisualizerLink(
			typeVisualizerLink);
	}

	@Override
	public TypeVisualizerLinkLocalService getWrappedService() {
		return _typeVisualizerLinkLocalService;
	}

	@Override
	public void setWrappedService(
		TypeVisualizerLinkLocalService typeVisualizerLinkLocalService) {

		_typeVisualizerLinkLocalService = typeVisualizerLinkLocalService;
	}

	private TypeVisualizerLinkLocalService _typeVisualizerLinkLocalService;

}