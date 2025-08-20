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
 * Provides a wrapper for {@link StructureParamLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StructureParamLinkLocalService
 * @generated
 */
public class StructureParamLinkLocalServiceWrapper
	implements ServiceWrapper<StructureParamLinkLocalService>,
			   StructureParamLinkLocalService {

	public StructureParamLinkLocalServiceWrapper(
		StructureParamLinkLocalService structureParamLinkLocalService) {

		_structureParamLinkLocalService = structureParamLinkLocalService;
	}

	/**
	 * Adds the structure param link to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructureParamLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structureParamLink the structure param link
	 * @return the structure param link that was added
	 */
	@Override
	public com.sx.icecap.model.StructureParamLink addStructureParamLink(
		com.sx.icecap.model.StructureParamLink structureParamLink) {

		return _structureParamLinkLocalService.addStructureParamLink(
			structureParamLink);
	}

	/**
	 * Creates a new structure param link with the primary key. Does not add the structure param link to the database.
	 *
	 * @param structureParamLinkId the primary key for the new structure param link
	 * @return the new structure param link
	 */
	@Override
	public com.sx.icecap.model.StructureParamLink createStructureParamLink(
		long structureParamLinkId) {

		return _structureParamLinkLocalService.createStructureParamLink(
			structureParamLinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structureParamLinkLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the structure param link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructureParamLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structureParamLinkId the primary key of the structure param link
	 * @return the structure param link that was removed
	 * @throws PortalException if a structure param link with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.StructureParamLink deleteStructureParamLink(
			long structureParamLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structureParamLinkLocalService.deleteStructureParamLink(
			structureParamLinkId);
	}

	/**
	 * Deletes the structure param link from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructureParamLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structureParamLink the structure param link
	 * @return the structure param link that was removed
	 */
	@Override
	public com.sx.icecap.model.StructureParamLink deleteStructureParamLink(
		com.sx.icecap.model.StructureParamLink structureParamLink) {

		return _structureParamLinkLocalService.deleteStructureParamLink(
			structureParamLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _structureParamLinkLocalService.dynamicQuery();
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

		return _structureParamLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.StructureParamLinkModelImpl</code>.
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

		return _structureParamLinkLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.StructureParamLinkModelImpl</code>.
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

		return _structureParamLinkLocalService.dynamicQuery(
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

		return _structureParamLinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _structureParamLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.StructureParamLink fetchStructureParamLink(
		long structureParamLinkId) {

		return _structureParamLinkLocalService.fetchStructureParamLink(
			structureParamLinkId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _structureParamLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _structureParamLinkLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _structureParamLinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structureParamLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the structure param link with the primary key.
	 *
	 * @param structureParamLinkId the primary key of the structure param link
	 * @return the structure param link
	 * @throws PortalException if a structure param link with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.StructureParamLink getStructureParamLink(
			long structureParamLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structureParamLinkLocalService.getStructureParamLink(
			structureParamLinkId);
	}

	/**
	 * Returns a range of all the structure param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @return the range of structure param links
	 */
	@Override
	public java.util.List<com.sx.icecap.model.StructureParamLink>
		getStructureParamLinks(int start, int end) {

		return _structureParamLinkLocalService.getStructureParamLinks(
			start, end);
	}

	/**
	 * Returns the number of structure param links.
	 *
	 * @return the number of structure param links
	 */
	@Override
	public int getStructureParamLinksCount() {
		return _structureParamLinkLocalService.getStructureParamLinksCount();
	}

	/**
	 * Updates the structure param link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructureParamLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structureParamLink the structure param link
	 * @return the structure param link that was updated
	 */
	@Override
	public com.sx.icecap.model.StructureParamLink updateStructureParamLink(
		com.sx.icecap.model.StructureParamLink structureParamLink) {

		return _structureParamLinkLocalService.updateStructureParamLink(
			structureParamLink);
	}

	@Override
	public StructureParamLinkLocalService getWrappedService() {
		return _structureParamLinkLocalService;
	}

	@Override
	public void setWrappedService(
		StructureParamLinkLocalService structureParamLinkLocalService) {

		_structureParamLinkLocalService = structureParamLinkLocalService;
	}

	private StructureParamLinkLocalService _structureParamLinkLocalService;

}