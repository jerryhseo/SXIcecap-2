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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sx.icecap.exception.NoSuchDataStructureException;
import com.sx.icecap.model.DataStructure;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DataStructure. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DataStructureLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DataStructureLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.sx.icecap.service.impl.DataStructureLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the data structure local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DataStructureLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the data structure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataStructure the data structure
	 * @return the data structure that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataStructure addDataStructure(DataStructure dataStructure);

	@Indexable(type = IndexableType.REINDEX)
	public DataStructure addDataStructure(
			String dataStructureName, String dataStructureVersion,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap, String structure, int status,
			ServiceContext sc)
		throws PortalException;

	public JSONArray convertListToJSONArray(List<DataStructure> list)
		throws JSONException;

	public JSONObject convertModelToJSONObject(DataStructure structure)
		throws JSONException;

	/**
	 * Creates a new data structure with the primary key. Does not add the data structure to the database.
	 *
	 * @param dataStructureId the primary key for the new data structure
	 * @return the new data structure
	 */
	@Transactional(enabled = false)
	public DataStructure createDataStructure(long dataStructureId);

	/**
	 * Deletes the data structure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataStructure the data structure
	 * @return the data structure that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataStructure deleteDataStructure(DataStructure dataStructure);

	/**
	 * Deletes the data structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure that was removed
	 * @throws PortalException if a data structure with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataStructure deleteDataStructure(long dataStructureId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataStructure fetchDataStructure(long dataStructureId);

	/**
	 * Returns the data structure matching the UUID and group.
	 *
	 * @param uuid the data structure's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataStructure fetchDataStructureByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the data structure with the primary key.
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure
	 * @throws PortalException if a data structure with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataStructure getDataStructure(long dataStructureId)
		throws PortalException;

	/**
	 * Returns the data structure matching the UUID and group.
	 *
	 * @param uuid the data structure's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data structure
	 * @throws PortalException if a matching data structure could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataStructure getDataStructureByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the data structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of data structures
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataStructure> getDataStructures(int start, int end);

	/**
	 * Returns all the data structures matching the UUID and company.
	 *
	 * @param uuid the UUID of the data structures
	 * @param companyId the primary key of the company
	 * @return the matching data structures, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataStructure> getDataStructuresByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of data structures matching the UUID and company.
	 *
	 * @param uuid the UUID of the data structures
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data structures, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataStructure> getDataStructuresByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator);

	/**
	 * Returns the number of data structures.
	 *
	 * @return the number of data structures
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataStructuresCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Indexable(type = IndexableType.DELETE)
	public DataStructure removeDataStructure(long dataStructureId)
		throws PortalException;

	public void removeDataStructures(long[] dataStructureIds)
		throws PortalException;

	/**
	 * Updates the data structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataStructure the data structure
	 * @return the data structure that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataStructure updateDataStructure(DataStructure dataStructure);

	@Indexable(type = IndexableType.REINDEX)
	public DataStructure updateDataStructure(
			long dataStructureId, String dataStructureName,
			String dataStructureVersion, Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap, String structure, int status,
			ServiceContext sc)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public DataStructure updateStatus(
			long userId, long dataStructureId, Integer status,
			ServiceContext sc)
		throws PortalException, SystemException;

	public DataStructure updateStructure(long dataStructureId, String structure)
		throws NoSuchDataStructureException;

}