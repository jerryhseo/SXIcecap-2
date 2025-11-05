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
 * Provides a wrapper for {@link SetTypeLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SetTypeLinkLocalService
 * @generated
 */
public class SetTypeLinkLocalServiceWrapper
	implements ServiceWrapper<SetTypeLinkLocalService>,
			   SetTypeLinkLocalService {

	public SetTypeLinkLocalServiceWrapper(
		SetTypeLinkLocalService setTypeLinkLocalService) {

		_setTypeLinkLocalService = setTypeLinkLocalService;
	}

	@Override
	public com.sx.icecap.model.SetTypeLink addSetTypeLink(
		long dataSetId, long dataTypeId, int order) {

		return _setTypeLinkLocalService.addSetTypeLink(
			dataSetId, dataTypeId, order);
	}

	/**
	 * Adds the set type link to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SetTypeLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param setTypeLink the set type link
	 * @return the set type link that was added
	 */
	@Override
	public com.sx.icecap.model.SetTypeLink addSetTypeLink(
		com.sx.icecap.model.SetTypeLink setTypeLink) {

		return _setTypeLinkLocalService.addSetTypeLink(setTypeLink);
	}

	@Override
	public int countAllSetTypeLinkList() {
		return _setTypeLinkLocalService.countAllSetTypeLinkList();
	}

	@Override
	public int countSetTypeLinkListBySet(long dataSetId) {
		return _setTypeLinkLocalService.countSetTypeLinkListBySet(dataSetId);
	}

	@Override
	public int countSetTypeLinkListByType(long dataTypeId) {
		return _setTypeLinkLocalService.countSetTypeLinkListByType(dataTypeId);
	}

	/**
	 * Creates a new set type link with the primary key. Does not add the set type link to the database.
	 *
	 * @param setTypeLinkId the primary key for the new set type link
	 * @return the new set type link
	 */
	@Override
	public com.sx.icecap.model.SetTypeLink createSetTypeLink(
		long setTypeLinkId) {

		return _setTypeLinkLocalService.createSetTypeLink(setTypeLinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _setTypeLinkLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the set type link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SetTypeLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link that was removed
	 * @throws PortalException if a set type link with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.SetTypeLink deleteSetTypeLink(long setTypeLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _setTypeLinkLocalService.deleteSetTypeLink(setTypeLinkId);
	}

	/**
	 * Deletes the set type link from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SetTypeLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param setTypeLink the set type link
	 * @return the set type link that was removed
	 */
	@Override
	public com.sx.icecap.model.SetTypeLink deleteSetTypeLink(
		com.sx.icecap.model.SetTypeLink setTypeLink) {

		return _setTypeLinkLocalService.deleteSetTypeLink(setTypeLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _setTypeLinkLocalService.dynamicQuery();
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

		return _setTypeLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.SetTypeLinkModelImpl</code>.
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

		return _setTypeLinkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.SetTypeLinkModelImpl</code>.
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

		return _setTypeLinkLocalService.dynamicQuery(
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

		return _setTypeLinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _setTypeLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.SetTypeLink fetchSetTypeLink(
		long setTypeLinkId) {

		return _setTypeLinkLocalService.fetchSetTypeLink(setTypeLinkId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _setTypeLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.sx.icecap.model.SetTypeLink>
		getAllSetTypeLinkList() {

		return _setTypeLinkLocalService.getAllSetTypeLinkList();
	}

	@Override
	public java.util.List<com.sx.icecap.model.SetTypeLink>
		getAllSetTypeLinkList(int start, int end) {

		return _setTypeLinkLocalService.getAllSetTypeLinkList(start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _setTypeLinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _setTypeLinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _setTypeLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the set type link with the primary key.
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link
	 * @throws PortalException if a set type link with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.SetTypeLink getSetTypeLink(long setTypeLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _setTypeLinkLocalService.getSetTypeLink(setTypeLinkId);
	}

	@Override
	public com.sx.icecap.model.SetTypeLink getSetTypeLink(
		long dataSetId, long dataTypeId) {

		return _setTypeLinkLocalService.getSetTypeLink(dataSetId, dataTypeId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.SetTypeLink>
		getSetTypeLinkListBySet(long dataSetId) {

		return _setTypeLinkLocalService.getSetTypeLinkListBySet(dataSetId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.SetTypeLink>
		getSetTypeLinkListBySet(long dataSetId, int start, int end) {

		return _setTypeLinkLocalService.getSetTypeLinkListBySet(
			dataSetId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.SetTypeLink>
		getSetTypeLinkListByType(long dataTypeId) {

		return _setTypeLinkLocalService.getSetTypeLinkListByType(dataTypeId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.SetTypeLink>
		getSetTypeLinkListByType(long dataTypeId, int start, int end) {

		return _setTypeLinkLocalService.getSetTypeLinkListByType(
			dataTypeId, start, end);
	}

	/**
	 * Returns a range of all the set type links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of set type links
	 */
	@Override
	public java.util.List<com.sx.icecap.model.SetTypeLink> getSetTypeLinks(
		int start, int end) {

		return _setTypeLinkLocalService.getSetTypeLinks(start, end);
	}

	/**
	 * Returns the number of set type links.
	 *
	 * @return the number of set type links
	 */
	@Override
	public int getSetTypeLinksCount() {
		return _setTypeLinkLocalService.getSetTypeLinksCount();
	}

	@Override
	public com.sx.icecap.model.SetTypeLink removeSetTypeLink(
		long setTypeLinkId) {

		return _setTypeLinkLocalService.removeSetTypeLink(setTypeLinkId);
	}

	@Override
	public void removeSetTypeLinkBySet(long dataSetId) {
		_setTypeLinkLocalService.removeSetTypeLinkBySet(dataSetId);
	}

	@Override
	public void removeSetTypeLinkByType(long dataTypeId) {
		_setTypeLinkLocalService.removeSetTypeLinkByType(dataTypeId);
	}

	@Override
	public com.sx.icecap.model.SetTypeLink setFreezed(
			long setTypeLinkId, boolean freezed,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _setTypeLinkLocalService.setFreezed(setTypeLinkId, freezed, sc);
	}

	@Override
	public com.sx.icecap.model.SetTypeLink setVerified(
			long setTypeLinkId, boolean verified,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _setTypeLinkLocalService.setVerified(
			setTypeLinkId, verified, sc);
	}

	@Override
	public com.sx.icecap.model.SetTypeLink updateSetTypeLink(
		long setTypeLinkId, long dataSetId, long dataTypeId, int order) {

		return _setTypeLinkLocalService.updateSetTypeLink(
			setTypeLinkId, dataSetId, dataTypeId, order);
	}

	/**
	 * Updates the set type link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SetTypeLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param setTypeLink the set type link
	 * @return the set type link that was updated
	 */
	@Override
	public com.sx.icecap.model.SetTypeLink updateSetTypeLink(
		com.sx.icecap.model.SetTypeLink setTypeLink) {

		return _setTypeLinkLocalService.updateSetTypeLink(setTypeLink);
	}

	@Override
	public SetTypeLinkLocalService getWrappedService() {
		return _setTypeLinkLocalService;
	}

	@Override
	public void setWrappedService(
		SetTypeLinkLocalService setTypeLinkLocalService) {

		_setTypeLinkLocalService = setTypeLinkLocalService;
	}

	private SetTypeLinkLocalService _setTypeLinkLocalService;

}