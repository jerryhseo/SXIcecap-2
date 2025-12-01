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

import com.sx.icecap.model.DataComment;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DataComment. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DataCommentLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DataCommentLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.sx.icecap.service.impl.DataCommentLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the data comment local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DataCommentLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the data comment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataComment the data comment
	 * @return the data comment that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataComment addDataComment(DataComment dataComment);

	@Indexable(type = IndexableType.REINDEX)
	public DataComment addDataComment(
			String commentModel, long dataId, String paramCode,
			long parentCommentId, String comment, int status, ServiceContext sc)
		throws PortalException;

	public int countDataComments(String commentModel, long dataId);

	public int countDataCommentsByParamCode(
		String commentModel, long dataId, String paramCode);

	/**
	 * Creates a new data comment with the primary key. Does not add the data comment to the database.
	 *
	 * @param dataCommentId the primary key for the new data comment
	 * @return the new data comment
	 */
	@Transactional(enabled = false)
	public DataComment createDataComment(long dataCommentId);

	/**
	 * Deletes the data comment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataComment the data comment
	 * @return the data comment that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataComment deleteDataComment(DataComment dataComment);

	/**
	 * Deletes the data comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment that was removed
	 * @throws PortalException if a data comment with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataComment deleteDataComment(long dataCommentId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataCommentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataCommentModelImpl</code>.
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
	public DataComment fetchDataComment(long dataCommentId);

	/**
	 * Returns the data comment matching the UUID and group.
	 *
	 * @param uuid the data comment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataComment fetchDataCommentByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the data comment with the primary key.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment
	 * @throws PortalException if a data comment with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataComment getDataComment(long dataCommentId)
		throws PortalException;

	/**
	 * Returns the data comment matching the UUID and group.
	 *
	 * @param uuid the data comment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data comment
	 * @throws PortalException if a matching data comment could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataComment getDataCommentByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataComment> getDataCommentList(
		String commentModel, long dataId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataComment> getDataCommentListByParamCode(
		String commentModel, long dataId, String paramCode);

	/**
	 * Returns a range of all the data comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of data comments
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataComment> getDataComments(int start, int end);

	/**
	 * Returns all the data comments matching the UUID and company.
	 *
	 * @param uuid the UUID of the data comments
	 * @param companyId the primary key of the company
	 * @return the matching data comments, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataComment> getDataCommentsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of data comments matching the UUID and company.
	 *
	 * @param uuid the UUID of the data comments
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data comments, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataComment> getDataCommentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataComment> orderByComparator);

	/**
	 * Returns the number of data comments.
	 *
	 * @return the number of data comments
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataCommentsCount();

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasComments(String commentModel, long dataId);

	@Indexable(type = IndexableType.DELETE)
	public DataComment removeDataComment(long dataCommentId)
		throws PortalException;

	public void removeDataComments(String commentModel, long dataId)
		throws PortalException;

	public void removeDataCommentsByParamCode(
			String commentModel, long dataId, String paramCode)
		throws PortalException;

	/**
	 * Updates the data comment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataCommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataComment the data comment
	 * @return the data comment that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataComment updateDataComment(DataComment dataComment);

	@Indexable(type = IndexableType.REINDEX)
	public DataComment updateDataComment(
			long dataCommentId, String commentModel, long dataId,
			String paramCode, long parentCommentId, String comment, int status,
			ServiceContext sc)
		throws PortalException;

}