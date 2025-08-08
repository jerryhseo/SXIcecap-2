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
 * Provides a wrapper for {@link ParameterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ParameterLocalService
 * @generated
 */
public class ParameterLocalServiceWrapper
	implements ParameterLocalService, ServiceWrapper<ParameterLocalService> {

	public ParameterLocalServiceWrapper(
		ParameterLocalService parameterLocalService) {

		_parameterLocalService = parameterLocalService;
	}

	/**
	 * Adds the parameter to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParameterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param parameter the parameter
	 * @return the parameter that was added
	 */
	@Override
	public com.sx.icecap.model.Parameter addParameter(
		com.sx.icecap.model.Parameter parameter) {

		return _parameterLocalService.addParameter(parameter);
	}

	@Override
	public com.sx.icecap.model.Parameter addParameter(
			String paramType, String paramName, String paramVersion,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> definitionMap,
			java.util.Map<java.util.Locale, String> tooltipMap, String synonyms,
			String typeProperties, boolean standard, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parameterLocalService.addParameter(
			paramType, paramName, paramVersion, displayNameMap, definitionMap,
			tooltipMap, synonyms, typeProperties, standard, status, sc);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray convertListToJSONArray(
			java.util.List<com.sx.icecap.model.Parameter> list)
		throws com.liferay.portal.kernel.json.JSONException {

		return _parameterLocalService.convertListToJSONArray(list);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject convertModelToJSONObject(
			com.sx.icecap.model.Parameter parameter)
		throws com.liferay.portal.kernel.json.JSONException {

		return _parameterLocalService.convertModelToJSONObject(parameter);
	}

	/**
	 * Creates a new parameter with the primary key. Does not add the parameter to the database.
	 *
	 * @param parameterId the primary key for the new parameter
	 * @return the new parameter
	 */
	@Override
	public com.sx.icecap.model.Parameter createParameter(long parameterId) {
		return _parameterLocalService.createParameter(parameterId);
	}

	/**
	 * Deletes the parameter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParameterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param parameterId the primary key of the parameter
	 * @return the parameter that was removed
	 * @throws PortalException if a parameter with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.Parameter deleteParameter(long parameterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parameterLocalService.deleteParameter(parameterId);
	}

	/**
	 * Deletes the parameter from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParameterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param parameter the parameter
	 * @return the parameter that was removed
	 */
	@Override
	public com.sx.icecap.model.Parameter deleteParameter(
		com.sx.icecap.model.Parameter parameter) {

		return _parameterLocalService.deleteParameter(parameter);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parameterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _parameterLocalService.dynamicQuery();
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

		return _parameterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.ParameterModelImpl</code>.
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

		return _parameterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.ParameterModelImpl</code>.
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

		return _parameterLocalService.dynamicQuery(
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

		return _parameterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _parameterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.Parameter fetchParameter(long parameterId) {
		return _parameterLocalService.fetchParameter(parameterId);
	}

	/**
	 * Returns the parameter matching the UUID and group.
	 *
	 * @param uuid the parameter's UUID
	 * @param groupId the primary key of the group
	 * @return the matching parameter, or <code>null</code> if a matching parameter could not be found
	 */
	@Override
	public com.sx.icecap.model.Parameter fetchParameterByUuidAndGroupId(
		String uuid, long groupId) {

		return _parameterLocalService.fetchParameterByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _parameterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _parameterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _parameterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _parameterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the parameter with the primary key.
	 *
	 * @param parameterId the primary key of the parameter
	 * @return the parameter
	 * @throws PortalException if a parameter with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.Parameter getParameter(long parameterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parameterLocalService.getParameter(parameterId);
	}

	/**
	 * Returns the parameter matching the UUID and group.
	 *
	 * @param uuid the parameter's UUID
	 * @param groupId the primary key of the group
	 * @return the matching parameter
	 * @throws PortalException if a matching parameter could not be found
	 */
	@Override
	public com.sx.icecap.model.Parameter getParameterByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parameterLocalService.getParameterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the parameters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.ParameterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @return the range of parameters
	 */
	@Override
	public java.util.List<com.sx.icecap.model.Parameter> getParameters(
		int start, int end) {

		return _parameterLocalService.getParameters(start, end);
	}

	/**
	 * Returns all the parameters matching the UUID and company.
	 *
	 * @param uuid the UUID of the parameters
	 * @param companyId the primary key of the company
	 * @return the matching parameters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.Parameter>
		getParametersByUuidAndCompanyId(String uuid, long companyId) {

		return _parameterLocalService.getParametersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of parameters matching the UUID and company.
	 *
	 * @param uuid the UUID of the parameters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of parameters
	 * @param end the upper bound of the range of parameters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching parameters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.Parameter>
		getParametersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.Parameter> orderByComparator) {

		return _parameterLocalService.getParametersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of parameters.
	 *
	 * @return the number of parameters
	 */
	@Override
	public int getParametersCount() {
		return _parameterLocalService.getParametersCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parameterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.sx.icecap.model.Parameter removeParameter(long parameterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parameterLocalService.removeParameter(parameterId);
	}

	@Override
	public void removeParameters(long[] parameterIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_parameterLocalService.removeParameters(parameterIds);
	}

	@Override
	public com.sx.icecap.model.Parameter updateParameter(
			long parameterId, String paramType, String paramName,
			String paramVersion,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> definitionMap,
			java.util.Map<java.util.Locale, String> tooltipMap, String synonyms,
			String typeProperties, boolean standard, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parameterLocalService.updateParameter(
			parameterId, paramType, paramName, paramVersion, displayNameMap,
			definitionMap, tooltipMap, synonyms, typeProperties, standard,
			status, sc);
	}

	/**
	 * Updates the parameter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParameterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param parameter the parameter
	 * @return the parameter that was updated
	 */
	@Override
	public com.sx.icecap.model.Parameter updateParameter(
		com.sx.icecap.model.Parameter parameter) {

		return _parameterLocalService.updateParameter(parameter);
	}

	@Override
	public com.sx.icecap.model.Parameter updateStatus(
			long userId, long parameterId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _parameterLocalService.updateStatus(
			userId, parameterId, status, sc);
	}

	@Override
	public ParameterLocalService getWrappedService() {
		return _parameterLocalService;
	}

	@Override
	public void setWrappedService(ParameterLocalService parameterLocalService) {
		_parameterLocalService = parameterLocalService;
	}

	private ParameterLocalService _parameterLocalService;

}