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
 * Provides a wrapper for {@link TypeStructureLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TypeStructureLinkLocalService
 * @generated
 */
public class TypeStructureLinkLocalServiceWrapper
	implements ServiceWrapper<TypeStructureLinkLocalService>,
			   TypeStructureLinkLocalService {

	public TypeStructureLinkLocalServiceWrapper(
		TypeStructureLinkLocalService typeStructureLinkLocalService) {

		_typeStructureLinkLocalService = typeStructureLinkLocalService;
	}

	@Override
	public com.sx.icecap.model.TypeStructureLink addTypeDataStructureLink(
			com.liferay.portal.kernel.json.JSONObject jsonLink,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeStructureLinkLocalService.addTypeDataStructureLink(
			jsonLink, sc);
	}

	@Override
	public com.sx.icecap.model.TypeStructureLink addTypeDataStructureLink(
			long dataTypeId, long dataStructureId, boolean commentable,
			boolean verifiable, boolean freezable, boolean verified,
			boolean freezed, boolean inputStatus, boolean jumpTo,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeStructureLinkLocalService.addTypeDataStructureLink(
			dataTypeId, dataStructureId, commentable, verifiable, freezable,
			verified, freezed, inputStatus, jumpTo, sc);
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
	@Override
	public com.sx.icecap.model.TypeStructureLink addTypeStructureLink(
		com.sx.icecap.model.TypeStructureLink typeStructureLink) {

		return _typeStructureLinkLocalService.addTypeStructureLink(
			typeStructureLink);
	}

	@Override
	public int countTypeStructureLinkByGroup(long groupId) {
		return _typeStructureLinkLocalService.countTypeStructureLinkByGroup(
			groupId);
	}

	@Override
	public int countTypeStructureLinkByUser(long userId) {
		return _typeStructureLinkLocalService.countTypeStructureLinkByUser(
			userId);
	}

	/**
	 * Creates a new type structure link with the primary key. Does not add the type structure link to the database.
	 *
	 * @param dataTypeId the primary key for the new type structure link
	 * @return the new type structure link
	 */
	@Override
	public com.sx.icecap.model.TypeStructureLink createTypeStructureLink(
		long dataTypeId) {

		return _typeStructureLinkLocalService.createTypeStructureLink(
			dataTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeStructureLinkLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.sx.icecap.model.TypeStructureLink deleteTypeStructureLink(
			long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeStructureLinkLocalService.deleteTypeStructureLink(
			dataTypeId);
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
	@Override
	public com.sx.icecap.model.TypeStructureLink deleteTypeStructureLink(
		com.sx.icecap.model.TypeStructureLink typeStructureLink) {

		return _typeStructureLinkLocalService.deleteTypeStructureLink(
			typeStructureLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _typeStructureLinkLocalService.dynamicQuery();
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

		return _typeStructureLinkLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _typeStructureLinkLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _typeStructureLinkLocalService.dynamicQuery(
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

		return _typeStructureLinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _typeStructureLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.TypeStructureLink fetchTypeStructureLink(
		long dataTypeId) {

		return _typeStructureLinkLocalService.fetchTypeStructureLink(
			dataTypeId);
	}

	@Override
	public com.sx.icecap.model.TypeStructureLink freezeLink(
			long dataTypeId, long userId, boolean freeze)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeStructureLinkLocalService.freezeLink(
			dataTypeId, userId, freeze);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _typeStructureLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _typeStructureLinkLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _typeStructureLinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeStructureLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the type structure link with the primary key.
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link
	 * @throws PortalException if a type structure link with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.TypeStructureLink getTypeStructureLink(
			long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeStructureLinkLocalService.getTypeStructureLink(dataTypeId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.TypeStructureLink>
		getTypeStructureLinkByGroup(long groupId) {

		return _typeStructureLinkLocalService.getTypeStructureLinkByGroup(
			groupId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.TypeStructureLink>
		getTypeStructureLinkByGroup(long groupId, int start, int end) {

		return _typeStructureLinkLocalService.getTypeStructureLinkByGroup(
			groupId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.TypeStructureLink>
		getTypeStructureLinkByUser(long userId) {

		return _typeStructureLinkLocalService.getTypeStructureLinkByUser(
			userId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.TypeStructureLink>
		getTypeStructureLinkByUser(long userId, int start, int end) {

		return _typeStructureLinkLocalService.getTypeStructureLinkByUser(
			userId, start, end);
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
	@Override
	public java.util.List<com.sx.icecap.model.TypeStructureLink>
		getTypeStructureLinks(int start, int end) {

		return _typeStructureLinkLocalService.getTypeStructureLinks(start, end);
	}

	/**
	 * Returns the number of type structure links.
	 *
	 * @return the number of type structure links
	 */
	@Override
	public int getTypeStructureLinksCount() {
		return _typeStructureLinkLocalService.getTypeStructureLinksCount();
	}

	@Override
	public com.sx.icecap.model.TypeStructureLink removeTypeStructureLink(
			long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeStructureLinkLocalService.removeTypeStructureLink(
			dataTypeId);
	}

	@Override
	public com.sx.icecap.model.TypeStructureLink updateTypeDataStructureLink(
			long dataTypeId, long dataStructureId, boolean commentable,
			boolean verifiable, boolean freezable, boolean verified,
			boolean freezed, boolean inputStatus, boolean jumpTo,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeStructureLinkLocalService.updateTypeDataStructureLink(
			dataTypeId, dataStructureId, commentable, verifiable, freezable,
			verified, freezed, inputStatus, jumpTo, sc);
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
	@Override
	public com.sx.icecap.model.TypeStructureLink updateTypeStructureLink(
		com.sx.icecap.model.TypeStructureLink typeStructureLink) {

		return _typeStructureLinkLocalService.updateTypeStructureLink(
			typeStructureLink);
	}

	@Override
	public com.sx.icecap.model.TypeStructureLink verifyLink(
			long dataTypeId, long userId, boolean veryfication)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _typeStructureLinkLocalService.verifyLink(
			dataTypeId, userId, veryfication);
	}

	@Override
	public TypeStructureLinkLocalService getWrappedService() {
		return _typeStructureLinkLocalService;
	}

	@Override
	public void setWrappedService(
		TypeStructureLinkLocalService typeStructureLinkLocalService) {

		_typeStructureLinkLocalService = typeStructureLinkLocalService;
	}

	private TypeStructureLinkLocalService _typeStructureLinkLocalService;

}