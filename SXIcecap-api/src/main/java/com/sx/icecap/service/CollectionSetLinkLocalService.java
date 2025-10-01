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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
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

import com.sx.icecap.exception.NoSuchCollectionSetLinkException;
import com.sx.icecap.model.CollectionSetLink;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for CollectionSetLink. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CollectionSetLinkLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CollectionSetLinkLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.sx.icecap.service.impl.CollectionSetLinkLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the collection set link local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CollectionSetLinkLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink addCollectionSetLink(
		CollectionSetLink collectionSetLink);

	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink addCollectionSetLink(
		long dataCollectionId, long dataSetId);

	public int countAllCollectionSetLinkList();

	public int countCollectionSetLinkListByCollection(long dataCollectionId);

	public int countCollectionSetLinkListByType(long dataSetId);

	/**
	 * Creates a new collection set link with the primary key. Does not add the collection set link to the database.
	 *
	 * @param collectionSetLinkId the primary key for the new collection set link
	 * @return the new collection set link
	 */
	@Transactional(enabled = false)
	public CollectionSetLink createCollectionSetLink(long collectionSetLinkId);

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
	@Indexable(type = IndexableType.DELETE)
	public CollectionSetLink deleteCollectionSetLink(
		CollectionSetLink collectionSetLink);

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
	@Indexable(type = IndexableType.DELETE)
	public CollectionSetLink deleteCollectionSetLink(long collectionSetLinkId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.CollectionSetLinkModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.CollectionSetLinkModelImpl</code>.
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
	public CollectionSetLink fetchCollectionSetLink(long collectionSetLinkId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CollectionSetLink> getAllCollectionSetLinkList();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CollectionSetLink> getAllCollectionSetLinkList(
		int start, int end);

	/**
	 * Returns the collection set link with the primary key.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link
	 * @throws PortalException if a collection set link with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CollectionSetLink getCollectionSetLink(long collectionSetLinkId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CollectionSetLink getCollectionSetLink(
			long dataCollectionId, long dataSetId)
		throws NoSuchCollectionSetLinkException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CollectionSetLink> getCollectionSetLinkListByCollection(
		long dataCollectionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CollectionSetLink> getCollectionSetLinkListByCollection(
		long dataCollectionId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CollectionSetLink> getCollectionSetLinkListByType(
		long dataSetId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CollectionSetLink> getCollectionSetLinkListByType(
		long dataSetId, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CollectionSetLink> getCollectionSetLinks(int start, int end);

	/**
	 * Returns the number of collection set links.
	 *
	 * @return the number of collection set links
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCollectionSetLinksCount();

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

	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink removeCollectionSetLink(long collectionSetLinkId);

	@Indexable(type = IndexableType.REINDEX)
	public void removeCollectionSetLinkByCollection(long dataCollectionId);

	@Indexable(type = IndexableType.REINDEX)
	public void removeCollectionSetLinkBySet(long dataSetId);

	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink setFreezed(
			long collectionSetLinkId, boolean freezed, ServiceContext sc)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink setVerified(
			long collectionSetLinkId, boolean verified, ServiceContext sc)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink updateCollectionSetLink(
		CollectionSetLink collectionSetLink);

	@Indexable(type = IndexableType.REINDEX)
	public CollectionSetLink updateCollectionSetLink(
		long collectionSetLinkId, long dataCollectionId, long dataSetId);

}