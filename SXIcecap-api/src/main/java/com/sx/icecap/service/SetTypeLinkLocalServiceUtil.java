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

import com.sx.icecap.model.SetTypeLink;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SetTypeLink. This utility wraps
 * <code>com.sx.icecap.service.impl.SetTypeLinkLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SetTypeLinkLocalService
 * @generated
 */
public class SetTypeLinkLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.SetTypeLinkLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SetTypeLink addSetTypeLink(long dataSetId, long dataTypeId) {
		return getService().addSetTypeLink(dataSetId, dataTypeId);
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
	public static SetTypeLink addSetTypeLink(SetTypeLink setTypeLink) {
		return getService().addSetTypeLink(setTypeLink);
	}

	public static int countAllSetTypeLinkList() {
		return getService().countAllSetTypeLinkList();
	}

	public static int countSetTypeLinkListBySet(long dataSetId) {
		return getService().countSetTypeLinkListBySet(dataSetId);
	}

	public static int countSetTypeLinkListByType(long dataTypeId) {
		return getService().countSetTypeLinkListByType(dataTypeId);
	}

	/**
	 * Creates a new set type link with the primary key. Does not add the set type link to the database.
	 *
	 * @param setTypeLinkId the primary key for the new set type link
	 * @return the new set type link
	 */
	public static SetTypeLink createSetTypeLink(long setTypeLinkId) {
		return getService().createSetTypeLink(setTypeLinkId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static SetTypeLink deleteSetTypeLink(long setTypeLinkId)
		throws PortalException {

		return getService().deleteSetTypeLink(setTypeLinkId);
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
	public static SetTypeLink deleteSetTypeLink(SetTypeLink setTypeLink) {
		return getService().deleteSetTypeLink(setTypeLink);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.SetTypeLinkModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.SetTypeLinkModelImpl</code>.
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

	public static SetTypeLink fetchSetTypeLink(long setTypeLinkId) {
		return getService().fetchSetTypeLink(setTypeLinkId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SetTypeLink> getAllSetTypeLinkList() {
		return getService().getAllSetTypeLinkList();
	}

	public static List<SetTypeLink> getAllSetTypeLinkList(int start, int end) {
		return getService().getAllSetTypeLinkList(start, end);
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

	/**
	 * Returns the set type link with the primary key.
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link
	 * @throws PortalException if a set type link with the primary key could not be found
	 */
	public static SetTypeLink getSetTypeLink(long setTypeLinkId)
		throws PortalException {

		return getService().getSetTypeLink(setTypeLinkId);
	}

	public static SetTypeLink getSetTypeLink(long dataSetId, long dataTypeId)
		throws com.sx.icecap.exception.NoSuchSetTypeLinkException {

		return getService().getSetTypeLink(dataSetId, dataTypeId);
	}

	public static List<SetTypeLink> getSetTypeLinkListBySet(long dataSetId) {
		return getService().getSetTypeLinkListBySet(dataSetId);
	}

	public static List<SetTypeLink> getSetTypeLinkListBySet(
		long dataSetId, int start, int end) {

		return getService().getSetTypeLinkListBySet(dataSetId, start, end);
	}

	public static List<SetTypeLink> getSetTypeLinkListByType(long dataTypeId) {
		return getService().getSetTypeLinkListByType(dataTypeId);
	}

	public static List<SetTypeLink> getSetTypeLinkListByType(
		long dataTypeId, int start, int end) {

		return getService().getSetTypeLinkListByType(dataTypeId, start, end);
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
	public static List<SetTypeLink> getSetTypeLinks(int start, int end) {
		return getService().getSetTypeLinks(start, end);
	}

	/**
	 * Returns the number of set type links.
	 *
	 * @return the number of set type links
	 */
	public static int getSetTypeLinksCount() {
		return getService().getSetTypeLinksCount();
	}

	public static SetTypeLink removeSetTypeLink(long setTypeLinkId) {
		return getService().removeSetTypeLink(setTypeLinkId);
	}

	public static void removeSetTypeLinkBySet(long dataSetId) {
		getService().removeSetTypeLinkBySet(dataSetId);
	}

	public static void removeSetTypeLinkByType(long dataTypeId) {
		getService().removeSetTypeLinkByType(dataTypeId);
	}

	public static SetTypeLink setFreezed(
			long setTypeLinkId, boolean freezed,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().setFreezed(setTypeLinkId, freezed, sc);
	}

	public static SetTypeLink setVerified(
			long setTypeLinkId, boolean verified,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().setVerified(setTypeLinkId, verified, sc);
	}

	public static SetTypeLink updateSetTypeLink(
		long setTypeLinkId, long dataSetId, long dataTypeId) {

		return getService().updateSetTypeLink(
			setTypeLinkId, dataSetId, dataTypeId);
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
	public static SetTypeLink updateSetTypeLink(SetTypeLink setTypeLink) {
		return getService().updateSetTypeLink(setTypeLink);
	}

	public static SetTypeLinkLocalService getService() {
		return _service;
	}

	private static volatile SetTypeLinkLocalService _service;

}