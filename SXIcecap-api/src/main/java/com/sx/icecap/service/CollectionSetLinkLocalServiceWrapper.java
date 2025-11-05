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
 * Provides a wrapper for {@link CollectionSetLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CollectionSetLinkLocalService
 * @generated
 */
public class CollectionSetLinkLocalServiceWrapper
	implements CollectionSetLinkLocalService,
			   ServiceWrapper<CollectionSetLinkLocalService> {

	public CollectionSetLinkLocalServiceWrapper(
		CollectionSetLinkLocalService collectionSetLinkLocalService) {

		_collectionSetLinkLocalService = collectionSetLinkLocalService;
	}

	/**
	 * Adds the collection set link to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CollectionSetLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param collectionSetLink the collection set link
	 * @return the collection set link that was added
	 */
	@Override
	public com.sx.icecap.model.CollectionSetLink addCollectionSetLink(
		com.sx.icecap.model.CollectionSetLink collectionSetLink) {

		return _collectionSetLinkLocalService.addCollectionSetLink(
			collectionSetLink);
	}

	@Override
	public com.sx.icecap.model.CollectionSetLink addCollectionSetLink(
		long dataCollectionId, long dataSetId, int order) {

		return _collectionSetLinkLocalService.addCollectionSetLink(
			dataCollectionId, dataSetId, order);
	}

	@Override
	public int countAllCollectionSetLinkList() {
		return _collectionSetLinkLocalService.countAllCollectionSetLinkList();
	}

	@Override
	public int countCollectionSetLinkListByCollection(long dataCollectionId) {
		return _collectionSetLinkLocalService.
			countCollectionSetLinkListByCollection(dataCollectionId);
	}

	@Override
	public int countCollectionSetLinkListBySet(long dataSetId) {
		return _collectionSetLinkLocalService.countCollectionSetLinkListBySet(
			dataSetId);
	}

	/**
	 * Creates a new collection set link with the primary key. Does not add the collection set link to the database.
	 *
	 * @param collectionSetLinkId the primary key for the new collection set link
	 * @return the new collection set link
	 */
	@Override
	public com.sx.icecap.model.CollectionSetLink createCollectionSetLink(
		long collectionSetLinkId) {

		return _collectionSetLinkLocalService.createCollectionSetLink(
			collectionSetLinkId);
	}

	/**
	 * Deletes the collection set link from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CollectionSetLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param collectionSetLink the collection set link
	 * @return the collection set link that was removed
	 */
	@Override
	public com.sx.icecap.model.CollectionSetLink deleteCollectionSetLink(
		com.sx.icecap.model.CollectionSetLink collectionSetLink) {

		return _collectionSetLinkLocalService.deleteCollectionSetLink(
			collectionSetLink);
	}

	/**
	 * Deletes the collection set link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CollectionSetLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link that was removed
	 * @throws PortalException if a collection set link with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.CollectionSetLink deleteCollectionSetLink(
			long collectionSetLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionSetLinkLocalService.deleteCollectionSetLink(
			collectionSetLinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionSetLinkLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _collectionSetLinkLocalService.dynamicQuery();
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

		return _collectionSetLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.CollectionSetLinkModelImpl</code>.
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

		return _collectionSetLinkLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.CollectionSetLinkModelImpl</code>.
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

		return _collectionSetLinkLocalService.dynamicQuery(
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

		return _collectionSetLinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _collectionSetLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.CollectionSetLink fetchCollectionSetLink(
		long collectionSetLinkId) {

		return _collectionSetLinkLocalService.fetchCollectionSetLink(
			collectionSetLinkId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _collectionSetLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.sx.icecap.model.CollectionSetLink>
		getAllCollectionSetLinkList() {

		return _collectionSetLinkLocalService.getAllCollectionSetLinkList();
	}

	@Override
	public java.util.List<com.sx.icecap.model.CollectionSetLink>
		getAllCollectionSetLinkList(int start, int end) {

		return _collectionSetLinkLocalService.getAllCollectionSetLinkList(
			start, end);
	}

	/**
	 * Returns the collection set link with the primary key.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link
	 * @throws PortalException if a collection set link with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.CollectionSetLink getCollectionSetLink(
			long collectionSetLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionSetLinkLocalService.getCollectionSetLink(
			collectionSetLinkId);
	}

	@Override
	public com.sx.icecap.model.CollectionSetLink getCollectionSetLink(
		long dataCollectionId, long dataSetId) {

		return _collectionSetLinkLocalService.getCollectionSetLink(
			dataCollectionId, dataSetId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.CollectionSetLink>
		getCollectionSetLinkListByCollection(long dataCollectionId) {

		return _collectionSetLinkLocalService.
			getCollectionSetLinkListByCollection(dataCollectionId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.CollectionSetLink>
		getCollectionSetLinkListByCollection(
			long dataCollectionId, int start, int end) {

		return _collectionSetLinkLocalService.
			getCollectionSetLinkListByCollection(dataCollectionId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.CollectionSetLink>
		getCollectionSetLinkListBySet(long dataSetId) {

		return _collectionSetLinkLocalService.getCollectionSetLinkListBySet(
			dataSetId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.CollectionSetLink>
		getCollectionSetLinkListBySet(long dataSetId, int start, int end) {

		return _collectionSetLinkLocalService.getCollectionSetLinkListBySet(
			dataSetId, start, end);
	}

	/**
	 * Returns a range of all the collection set links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @return the range of collection set links
	 */
	@Override
	public java.util.List<com.sx.icecap.model.CollectionSetLink>
		getCollectionSetLinks(int start, int end) {

		return _collectionSetLinkLocalService.getCollectionSetLinks(start, end);
	}

	/**
	 * Returns the number of collection set links.
	 *
	 * @return the number of collection set links
	 */
	@Override
	public int getCollectionSetLinksCount() {
		return _collectionSetLinkLocalService.getCollectionSetLinksCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _collectionSetLinkLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _collectionSetLinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionSetLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.sx.icecap.model.CollectionSetLink removeCollectionSetLink(
		long collectionSetLinkId) {

		return _collectionSetLinkLocalService.removeCollectionSetLink(
			collectionSetLinkId);
	}

	@Override
	public void removeCollectionSetLinkByCollection(long dataCollectionId) {
		_collectionSetLinkLocalService.removeCollectionSetLinkByCollection(
			dataCollectionId);
	}

	@Override
	public void removeCollectionSetLinkBySet(long dataSetId) {
		_collectionSetLinkLocalService.removeCollectionSetLinkBySet(dataSetId);
	}

	@Override
	public com.sx.icecap.model.CollectionSetLink setFreezed(
			long collectionSetLinkId, boolean freezed,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionSetLinkLocalService.setFreezed(
			collectionSetLinkId, freezed, sc);
	}

	@Override
	public com.sx.icecap.model.CollectionSetLink setVerified(
			long collectionSetLinkId, boolean verified,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionSetLinkLocalService.setVerified(
			collectionSetLinkId, verified, sc);
	}

	/**
	 * Updates the collection set link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CollectionSetLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param collectionSetLink the collection set link
	 * @return the collection set link that was updated
	 */
	@Override
	public com.sx.icecap.model.CollectionSetLink updateCollectionSetLink(
		com.sx.icecap.model.CollectionSetLink collectionSetLink) {

		return _collectionSetLinkLocalService.updateCollectionSetLink(
			collectionSetLink);
	}

	@Override
	public com.sx.icecap.model.CollectionSetLink updateCollectionSetLink(
		long collectionSetLinkId, long dataCollectionId, long dataSetId,
		int order) {

		return _collectionSetLinkLocalService.updateCollectionSetLink(
			collectionSetLinkId, dataCollectionId, dataSetId, order);
	}

	@Override
	public CollectionSetLinkLocalService getWrappedService() {
		return _collectionSetLinkLocalService;
	}

	@Override
	public void setWrappedService(
		CollectionSetLinkLocalService collectionSetLinkLocalService) {

		_collectionSetLinkLocalService = collectionSetLinkLocalService;
	}

	private CollectionSetLinkLocalService _collectionSetLinkLocalService;

}