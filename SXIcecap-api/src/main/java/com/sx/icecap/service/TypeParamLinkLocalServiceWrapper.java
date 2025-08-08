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
 * Provides a wrapper for {@link TypeParamLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TypeParamLinkLocalService
 * @generated
 */
public class TypeParamLinkLocalServiceWrapper
	implements ServiceWrapper<TypeParamLinkLocalService>,
			   TypeParamLinkLocalService {

	public TypeParamLinkLocalServiceWrapper(
		TypeParamLinkLocalService typeParamLinkLocalService) {

		_typeParamLinkLocalService = typeParamLinkLocalService;
	}

	/**
	 * Adds the type param link to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeParamLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeParamLink the type param link
	 * @return the type param link that was added
	 */
	@Override
	public com.sx.icecap.model.TypeParamLink addTypeParamLink(
		com.sx.icecap.model.TypeParamLink typeParamLink) {

		return _typeParamLinkLocalService.addTypeParamLink(typeParamLink);
	}

	/**
	 * Creates a new type param link with the primary key. Does not add the type param link to the database.
	 *
	 * @param typeParamLinkId the primary key for the new type param link
	 * @return the new type param link
	 */
	@Override
	public com.sx.icecap.model.TypeParamLink createTypeParamLink(
		long typeParamLinkId) {

		return _typeParamLinkLocalService.createTypeParamLink(typeParamLinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeParamLinkLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the type param link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeParamLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeParamLinkId the primary key of the type param link
	 * @return the type param link that was removed
	 * @throws PortalException if a type param link with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.TypeParamLink deleteTypeParamLink(
			long typeParamLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeParamLinkLocalService.deleteTypeParamLink(typeParamLinkId);
	}

	/**
	 * Deletes the type param link from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeParamLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeParamLink the type param link
	 * @return the type param link that was removed
	 */
	@Override
	public com.sx.icecap.model.TypeParamLink deleteTypeParamLink(
		com.sx.icecap.model.TypeParamLink typeParamLink) {

		return _typeParamLinkLocalService.deleteTypeParamLink(typeParamLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _typeParamLinkLocalService.dynamicQuery();
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

		return _typeParamLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TypeParamLinkModelImpl</code>.
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

		return _typeParamLinkLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TypeParamLinkModelImpl</code>.
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

		return _typeParamLinkLocalService.dynamicQuery(
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

		return _typeParamLinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _typeParamLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.TypeParamLink fetchTypeParamLink(
		long typeParamLinkId) {

		return _typeParamLinkLocalService.fetchTypeParamLink(typeParamLinkId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _typeParamLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _typeParamLinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _typeParamLinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeParamLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the type param link with the primary key.
	 *
	 * @param typeParamLinkId the primary key of the type param link
	 * @return the type param link
	 * @throws PortalException if a type param link with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.TypeParamLink getTypeParamLink(
			long typeParamLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeParamLinkLocalService.getTypeParamLink(typeParamLinkId);
	}

	/**
	 * Returns a range of all the type param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @return the range of type param links
	 */
	@Override
	public java.util.List<com.sx.icecap.model.TypeParamLink> getTypeParamLinks(
		int start, int end) {

		return _typeParamLinkLocalService.getTypeParamLinks(start, end);
	}

	/**
	 * Returns the number of type param links.
	 *
	 * @return the number of type param links
	 */
	@Override
	public int getTypeParamLinksCount() {
		return _typeParamLinkLocalService.getTypeParamLinksCount();
	}

	/**
	 * Updates the type param link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeParamLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeParamLink the type param link
	 * @return the type param link that was updated
	 */
	@Override
	public com.sx.icecap.model.TypeParamLink updateTypeParamLink(
		com.sx.icecap.model.TypeParamLink typeParamLink) {

		return _typeParamLinkLocalService.updateTypeParamLink(typeParamLink);
	}

	@Override
	public TypeParamLinkLocalService getWrappedService() {
		return _typeParamLinkLocalService;
	}

	@Override
	public void setWrappedService(
		TypeParamLinkLocalService typeParamLinkLocalService) {

		_typeParamLinkLocalService = typeParamLinkLocalService;
	}

	private TypeParamLinkLocalService _typeParamLinkLocalService;

}