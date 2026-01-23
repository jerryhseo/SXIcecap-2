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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sx.icecap.model.CollectionSetLink;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CollectionSetLink. This utility wraps
 * <code>com.sx.icecap.service.impl.CollectionSetLinkLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CollectionSetLinkLocalService
 * @generated
 */
public class CollectionSetLinkLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.CollectionSetLinkLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static CollectionSetLink addCollectionSetLink(
		CollectionSetLink collectionSetLink) {

		return getService().addCollectionSetLink(collectionSetLink);
	}

	public static CollectionSetLink addCollectionSetLink(
		long dataCollectionId, long dataSetId, int order,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().addCollectionSetLink(
			dataCollectionId, dataSetId, order, sc);
	}

	public static int countAllCollectionSetLinkList() {
		return getService().countAllCollectionSetLinkList();
	}

	public static int countCollectionSetLinkListByCollection(
		long groupId, long dataCollectionId) {

		return getService().countCollectionSetLinkListByCollection(
			groupId, dataCollectionId);
	}

	public static int countCollectionSetLinkListBySet(
		long dataCollectionId, long dataSetId) {

		return getService().countCollectionSetLinkListBySet(
			dataCollectionId, dataSetId);
	}

	/**
	 * Creates a new collection set link with the primary key. Does not add the collection set link to the database.
	 *
	 * @param collectionSetLinkId the primary key for the new collection set link
	 * @return the new collection set link
	 */
	public static CollectionSetLink createCollectionSetLink(
		long collectionSetLinkId) {

		return getService().createCollectionSetLink(collectionSetLinkId);
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
	public static CollectionSetLink deleteCollectionSetLink(
		CollectionSetLink collectionSetLink) {

		return getService().deleteCollectionSetLink(collectionSetLink);
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
	public static CollectionSetLink deleteCollectionSetLink(
			long collectionSetLinkId)
		throws PortalException {

		return getService().deleteCollectionSetLink(collectionSetLinkId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CollectionSetLink fetchCollectionSetLink(
		long collectionSetLinkId) {

		return getService().fetchCollectionSetLink(collectionSetLinkId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<CollectionSetLink> getAllCollectionSetLinkList() {
		return getService().getAllCollectionSetLinkList();
	}

	public static List<CollectionSetLink> getAllCollectionSetLinkList(
		int start, int end) {

		return getService().getAllCollectionSetLinkList(start, end);
	}

	/**
	 * Returns the collection set link with the primary key.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link
	 * @throws PortalException if a collection set link with the primary key could not be found
	 */
	public static CollectionSetLink getCollectionSetLink(
			long collectionSetLinkId)
		throws PortalException {

		return getService().getCollectionSetLink(collectionSetLinkId);
	}

	public static CollectionSetLink getCollectionSetLink(
		long groupId, long dataCollectionId, long dataSetId) {

		return getService().getCollectionSetLink(
			groupId, dataCollectionId, dataSetId);
	}

	public static List<CollectionSetLink> getCollectionSetLinkListByCollection(
		long groupId, long dataCollectionId) {

		return getService().getCollectionSetLinkListByCollection(
			groupId, dataCollectionId);
	}

	public static List<CollectionSetLink> getCollectionSetLinkListByCollection(
		long groupId, long dataCollectionId, int start, int end) {

		return getService().getCollectionSetLinkListByCollection(
			groupId, dataCollectionId, start, end);
	}

	public static List<CollectionSetLink> getCollectionSetLinkListBySet(
		long dataCollectionId, long dataSetId) {

		return getService().getCollectionSetLinkListBySet(
			dataCollectionId, dataSetId);
	}

	public static List<CollectionSetLink> getCollectionSetLinkListBySet(
		long dataCollectionId, long dataSetId, int start, int end) {

		return getService().getCollectionSetLinkListBySet(
			dataCollectionId, dataSetId, start, end);
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
	public static List<CollectionSetLink> getCollectionSetLinks(
		int start, int end) {

		return getService().getCollectionSetLinks(start, end);
	}

	/**
	 * Returns the number of collection set links.
	 *
	 * @return the number of collection set links
	 */
	public static int getCollectionSetLinksCount() {
		return getService().getCollectionSetLinksCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static CollectionSetLink removeCollectionSetLink(
		long collectionSetLinkId) {

		return getService().removeCollectionSetLink(collectionSetLinkId);
	}

	public static void removeCollectionSetLinkByCollection(
		long groupId, long dataCollectionId) {

		getService().removeCollectionSetLinkByCollection(
			groupId, dataCollectionId);
	}

	public static void removeCollectionSetLinkBySet(
			long groupId, long dataCollectionId, long dataSetId)
		throws com.sx.icecap.exception.NoSuchCollectionSetLinkException {

		getService().removeCollectionSetLinkBySet(
			groupId, dataCollectionId, dataSetId);
	}

	public static void removeCollectionSetLinksByCollection(
		long groupId, long dataCollectionId) {

		getService().removeCollectionSetLinksByCollection(
			groupId, dataCollectionId);
	}

	public static CollectionSetLink setFreezed(
			long collectionSetLinkId, boolean freezed,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().setFreezed(collectionSetLinkId, freezed, sc);
	}

	public static CollectionSetLink setVerified(
			long collectionSetLinkId, boolean verified,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().setVerified(collectionSetLinkId, verified, sc);
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
	public static CollectionSetLink updateCollectionSetLink(
		CollectionSetLink collectionSetLink) {

		return getService().updateCollectionSetLink(collectionSetLink);
	}

	public static CollectionSetLink updateCollectionSetLink(
		long collectionSetLinkId, long dataCollectionId, long dataSetId,
		int order) {

		return getService().updateCollectionSetLink(
			collectionSetLinkId, dataCollectionId, dataSetId, order);
	}

	public static CollectionSetLinkLocalService getService() {
		return _service;
	}

	private static volatile CollectionSetLinkLocalService _service;

}