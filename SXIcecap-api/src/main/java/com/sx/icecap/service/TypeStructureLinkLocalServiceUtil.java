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

import com.sx.icecap.model.TypeStructureLink;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TypeStructureLink. This utility wraps
 * <code>com.sx.icecap.service.impl.TypeStructureLinkLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TypeStructureLinkLocalService
 * @generated
 */
public class TypeStructureLinkLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.TypeStructureLinkLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static TypeStructureLink addTypeDataStructureLink(
		long dataTypeId, long dataStructureId, boolean commentable,
		boolean verifiable, boolean freezable, boolean verified,
		long verifiedUserId, boolean freezed, long freezedUserId) {

		return getService().addTypeDataStructureLink(
			dataTypeId, dataStructureId, commentable, verifiable, freezable,
			verified, verifiedUserId, freezed, freezedUserId);
	}

	/**
	 * Adds the type structure link to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeStructureLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeStructureLink the type structure link
	 * @return the type structure link that was added
	 */
	public static TypeStructureLink addTypeStructureLink(
		TypeStructureLink typeStructureLink) {

		return getService().addTypeStructureLink(typeStructureLink);
	}

	/**
	 * Creates a new type structure link with the primary key. Does not add the type structure link to the database.
	 *
	 * @param dataTypeId the primary key for the new type structure link
	 * @return the new type structure link
	 */
	public static TypeStructureLink createTypeStructureLink(long dataTypeId) {
		return getService().createTypeStructureLink(dataTypeId);
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
	 * Deletes the type structure link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeStructureLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link that was removed
	 * @throws PortalException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink deleteTypeStructureLink(long dataTypeId)
		throws PortalException {

		return getService().deleteTypeStructureLink(dataTypeId);
	}

	/**
	 * Deletes the type structure link from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeStructureLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeStructureLink the type structure link
	 * @return the type structure link that was removed
	 */
	public static TypeStructureLink deleteTypeStructureLink(
		TypeStructureLink typeStructureLink) {

		return getService().deleteTypeStructureLink(typeStructureLink);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TypeStructureLinkModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TypeStructureLinkModelImpl</code>.
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

	public static TypeStructureLink fetchTypeStructureLink(long dataTypeId) {
		return getService().fetchTypeStructureLink(dataTypeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the type structure link with the primary key.
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link
	 * @throws PortalException if a type structure link with the primary key could not be found
	 */
	public static TypeStructureLink getTypeStructureLink(long dataTypeId)
		throws PortalException {

		return getService().getTypeStructureLink(dataTypeId);
	}

	/**
	 * Returns a range of all the type structure links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of type structure links
	 */
	public static List<TypeStructureLink> getTypeStructureLinks(
		int start, int end) {

		return getService().getTypeStructureLinks(start, end);
	}

	/**
	 * Returns the number of type structure links.
	 *
	 * @return the number of type structure links
	 */
	public static int getTypeStructureLinksCount() {
		return getService().getTypeStructureLinksCount();
	}

	public static TypeStructureLink removeTypeStructureLink(long dataTypeId)
		throws PortalException {

		return getService().removeTypeStructureLink(dataTypeId);
	}

	public static TypeStructureLink updateTypeDataStructureLink(
			long dataTypeId, long dataStructureId, boolean commentable,
			boolean verifiable, boolean freezable, boolean verified,
			long verifiedUserId, boolean freezed, long freezedUserId)
		throws PortalException {

		return getService().updateTypeDataStructureLink(
			dataTypeId, dataStructureId, commentable, verifiable, freezable,
			verified, verifiedUserId, freezed, freezedUserId);
	}

	/**
	 * Updates the type structure link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TypeStructureLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param typeStructureLink the type structure link
	 * @return the type structure link that was updated
	 */
	public static TypeStructureLink updateTypeStructureLink(
		TypeStructureLink typeStructureLink) {

		return getService().updateTypeStructureLink(typeStructureLink);
	}

	public static TypeStructureLinkLocalService getService() {
		return _service;
	}

	private static volatile TypeStructureLinkLocalService _service;

}