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

package com.sx.icecap.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.sx.icecap.exception.NoSuchCollectionSetLinkException;
import com.sx.icecap.model.CollectionSetLink;
import com.sx.icecap.model.impl.CollectionSetLinkImpl;
import com.sx.icecap.model.impl.CollectionSetLinkModelImpl;
import com.sx.icecap.service.persistence.CollectionSetLinkPersistence;
import com.sx.icecap.service.persistence.CollectionSetLinkUtil;
import com.sx.icecap.service.persistence.impl.constants.SX_ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the collection set link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CollectionSetLinkPersistence.class)
public class CollectionSetLinkPersistenceImpl
	extends BasePersistenceImpl<CollectionSetLink>
	implements CollectionSetLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CollectionSetLinkUtil</code> to access the collection set link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CollectionSetLinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCollectionId;
	private FinderPath _finderPathWithoutPaginationFindByCollectionId;
	private FinderPath _finderPathCountByCollectionId;

	/**
	 * Returns all the collection set links where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the matching collection set links
	 */
	@Override
	public List<CollectionSetLink> findByCollectionId(long dataCollectionId) {
		return findByCollectionId(
			dataCollectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the collection set links where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @return the range of matching collection set links
	 */
	@Override
	public List<CollectionSetLink> findByCollectionId(
		long dataCollectionId, int start, int end) {

		return findByCollectionId(dataCollectionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the collection set links where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching collection set links
	 */
	@Override
	public List<CollectionSetLink> findByCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		return findByCollectionId(
			dataCollectionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the collection set links where dataCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataCollectionId the data collection ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching collection set links
	 */
	@Override
	public List<CollectionSetLink> findByCollectionId(
		long dataCollectionId, int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCollectionId;
				finderArgs = new Object[] {dataCollectionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCollectionId;
			finderArgs = new Object[] {
				dataCollectionId, start, end, orderByComparator
			};
		}

		List<CollectionSetLink> list = null;

		if (useFinderCache) {
			list = (List<CollectionSetLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CollectionSetLink collectionSetLink : list) {
					if (dataCollectionId !=
							collectionSetLink.getDataCollectionId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_COLLECTIONSETLINK_WHERE);

			sb.append(_FINDER_COLUMN_COLLECTIONID_DATACOLLECTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CollectionSetLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataCollectionId);

				list = (List<CollectionSetLink>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	@Override
	public CollectionSetLink findByCollectionId_First(
			long dataCollectionId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws NoSuchCollectionSetLinkException {

		CollectionSetLink collectionSetLink = fetchByCollectionId_First(
			dataCollectionId, orderByComparator);

		if (collectionSetLink != null) {
			return collectionSetLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataCollectionId=");
		sb.append(dataCollectionId);

		sb.append("}");

		throw new NoSuchCollectionSetLinkException(sb.toString());
	}

	/**
	 * Returns the first collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	@Override
	public CollectionSetLink fetchByCollectionId_First(
		long dataCollectionId,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		List<CollectionSetLink> list = findByCollectionId(
			dataCollectionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	@Override
	public CollectionSetLink findByCollectionId_Last(
			long dataCollectionId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws NoSuchCollectionSetLinkException {

		CollectionSetLink collectionSetLink = fetchByCollectionId_Last(
			dataCollectionId, orderByComparator);

		if (collectionSetLink != null) {
			return collectionSetLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataCollectionId=");
		sb.append(dataCollectionId);

		sb.append("}");

		throw new NoSuchCollectionSetLinkException(sb.toString());
	}

	/**
	 * Returns the last collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	@Override
	public CollectionSetLink fetchByCollectionId_Last(
		long dataCollectionId,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		int count = countByCollectionId(dataCollectionId);

		if (count == 0) {
			return null;
		}

		List<CollectionSetLink> list = findByCollectionId(
			dataCollectionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the collection set links before and after the current collection set link in the ordered set where dataCollectionId = &#63;.
	 *
	 * @param collectionSetLinkId the primary key of the current collection set link
	 * @param dataCollectionId the data collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next collection set link
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	@Override
	public CollectionSetLink[] findByCollectionId_PrevAndNext(
			long collectionSetLinkId, long dataCollectionId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws NoSuchCollectionSetLinkException {

		CollectionSetLink collectionSetLink = findByPrimaryKey(
			collectionSetLinkId);

		Session session = null;

		try {
			session = openSession();

			CollectionSetLink[] array = new CollectionSetLinkImpl[3];

			array[0] = getByCollectionId_PrevAndNext(
				session, collectionSetLink, dataCollectionId, orderByComparator,
				true);

			array[1] = collectionSetLink;

			array[2] = getByCollectionId_PrevAndNext(
				session, collectionSetLink, dataCollectionId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CollectionSetLink getByCollectionId_PrevAndNext(
		Session session, CollectionSetLink collectionSetLink,
		long dataCollectionId,
		OrderByComparator<CollectionSetLink> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLLECTIONSETLINK_WHERE);

		sb.append(_FINDER_COLUMN_COLLECTIONID_DATACOLLECTIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CollectionSetLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataCollectionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						collectionSetLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CollectionSetLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the collection set links where dataCollectionId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 */
	@Override
	public void removeByCollectionId(long dataCollectionId) {
		for (CollectionSetLink collectionSetLink :
				findByCollectionId(
					dataCollectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(collectionSetLink);
		}
	}

	/**
	 * Returns the number of collection set links where dataCollectionId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @return the number of matching collection set links
	 */
	@Override
	public int countByCollectionId(long dataCollectionId) {
		FinderPath finderPath = _finderPathCountByCollectionId;

		Object[] finderArgs = new Object[] {dataCollectionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLLECTIONSETLINK_WHERE);

			sb.append(_FINDER_COLUMN_COLLECTIONID_DATACOLLECTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataCollectionId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COLLECTIONID_DATACOLLECTIONID_2 =
		"collectionSetLink.dataCollectionId = ?";

	private FinderPath _finderPathWithPaginationFindByDataSetId;
	private FinderPath _finderPathWithoutPaginationFindByDataSetId;
	private FinderPath _finderPathCountByDataSetId;

	/**
	 * Returns all the collection set links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching collection set links
	 */
	@Override
	public List<CollectionSetLink> findByDataSetId(long dataSetId) {
		return findByDataSetId(
			dataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the collection set links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @return the range of matching collection set links
	 */
	@Override
	public List<CollectionSetLink> findByDataSetId(
		long dataSetId, int start, int end) {

		return findByDataSetId(dataSetId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the collection set links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching collection set links
	 */
	@Override
	public List<CollectionSetLink> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		return findByDataSetId(dataSetId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the collection set links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching collection set links
	 */
	@Override
	public List<CollectionSetLink> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataSetId;
				finderArgs = new Object[] {dataSetId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataSetId;
			finderArgs = new Object[] {
				dataSetId, start, end, orderByComparator
			};
		}

		List<CollectionSetLink> list = null;

		if (useFinderCache) {
			list = (List<CollectionSetLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CollectionSetLink collectionSetLink : list) {
					if (dataSetId != collectionSetLink.getDataSetId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_COLLECTIONSETLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASETID_DATASETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CollectionSetLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataSetId);

				list = (List<CollectionSetLink>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	@Override
	public CollectionSetLink findByDataSetId_First(
			long dataSetId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws NoSuchCollectionSetLinkException {

		CollectionSetLink collectionSetLink = fetchByDataSetId_First(
			dataSetId, orderByComparator);

		if (collectionSetLink != null) {
			return collectionSetLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataSetId=");
		sb.append(dataSetId);

		sb.append("}");

		throw new NoSuchCollectionSetLinkException(sb.toString());
	}

	/**
	 * Returns the first collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	@Override
	public CollectionSetLink fetchByDataSetId_First(
		long dataSetId,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		List<CollectionSetLink> list = findByDataSetId(
			dataSetId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	@Override
	public CollectionSetLink findByDataSetId_Last(
			long dataSetId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws NoSuchCollectionSetLinkException {

		CollectionSetLink collectionSetLink = fetchByDataSetId_Last(
			dataSetId, orderByComparator);

		if (collectionSetLink != null) {
			return collectionSetLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataSetId=");
		sb.append(dataSetId);

		sb.append("}");

		throw new NoSuchCollectionSetLinkException(sb.toString());
	}

	/**
	 * Returns the last collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	@Override
	public CollectionSetLink fetchByDataSetId_Last(
		long dataSetId,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		int count = countByDataSetId(dataSetId);

		if (count == 0) {
			return null;
		}

		List<CollectionSetLink> list = findByDataSetId(
			dataSetId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the collection set links before and after the current collection set link in the ordered set where dataSetId = &#63;.
	 *
	 * @param collectionSetLinkId the primary key of the current collection set link
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next collection set link
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	@Override
	public CollectionSetLink[] findByDataSetId_PrevAndNext(
			long collectionSetLinkId, long dataSetId,
			OrderByComparator<CollectionSetLink> orderByComparator)
		throws NoSuchCollectionSetLinkException {

		CollectionSetLink collectionSetLink = findByPrimaryKey(
			collectionSetLinkId);

		Session session = null;

		try {
			session = openSession();

			CollectionSetLink[] array = new CollectionSetLinkImpl[3];

			array[0] = getByDataSetId_PrevAndNext(
				session, collectionSetLink, dataSetId, orderByComparator, true);

			array[1] = collectionSetLink;

			array[2] = getByDataSetId_PrevAndNext(
				session, collectionSetLink, dataSetId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CollectionSetLink getByDataSetId_PrevAndNext(
		Session session, CollectionSetLink collectionSetLink, long dataSetId,
		OrderByComparator<CollectionSetLink> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLLECTIONSETLINK_WHERE);

		sb.append(_FINDER_COLUMN_DATASETID_DATASETID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CollectionSetLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataSetId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						collectionSetLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CollectionSetLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the collection set links where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	@Override
	public void removeByDataSetId(long dataSetId) {
		for (CollectionSetLink collectionSetLink :
				findByDataSetId(
					dataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(collectionSetLink);
		}
	}

	/**
	 * Returns the number of collection set links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching collection set links
	 */
	@Override
	public int countByDataSetId(long dataSetId) {
		FinderPath finderPath = _finderPathCountByDataSetId;

		Object[] finderArgs = new Object[] {dataSetId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLLECTIONSETLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASETID_DATASETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataSetId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DATASETID_DATASETID_2 =
		"collectionSetLink.dataSetId = ?";

	private FinderPath _finderPathFetchByCollectionSet;
	private FinderPath _finderPathCountByCollectionSet;

	/**
	 * Returns the collection set link where dataCollectionId = &#63; and dataSetId = &#63; or throws a <code>NoSuchCollectionSetLinkException</code> if it could not be found.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching collection set link
	 * @throws NoSuchCollectionSetLinkException if a matching collection set link could not be found
	 */
	@Override
	public CollectionSetLink findByCollectionSet(
			long dataCollectionId, long dataSetId)
		throws NoSuchCollectionSetLinkException {

		CollectionSetLink collectionSetLink = fetchByCollectionSet(
			dataCollectionId, dataSetId);

		if (collectionSetLink == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("dataCollectionId=");
			sb.append(dataCollectionId);

			sb.append(", dataSetId=");
			sb.append(dataSetId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCollectionSetLinkException(sb.toString());
		}

		return collectionSetLink;
	}

	/**
	 * Returns the collection set link where dataCollectionId = &#63; and dataSetId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	@Override
	public CollectionSetLink fetchByCollectionSet(
		long dataCollectionId, long dataSetId) {

		return fetchByCollectionSet(dataCollectionId, dataSetId, true);
	}

	/**
	 * Returns the collection set link where dataCollectionId = &#63; and dataSetId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching collection set link, or <code>null</code> if a matching collection set link could not be found
	 */
	@Override
	public CollectionSetLink fetchByCollectionSet(
		long dataCollectionId, long dataSetId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {dataCollectionId, dataSetId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCollectionSet, finderArgs, this);
		}

		if (result instanceof CollectionSetLink) {
			CollectionSetLink collectionSetLink = (CollectionSetLink)result;

			if ((dataCollectionId != collectionSetLink.getDataCollectionId()) ||
				(dataSetId != collectionSetLink.getDataSetId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COLLECTIONSETLINK_WHERE);

			sb.append(_FINDER_COLUMN_COLLECTIONSET_DATACOLLECTIONID_2);

			sb.append(_FINDER_COLUMN_COLLECTIONSET_DATASETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataCollectionId);

				queryPos.add(dataSetId);

				List<CollectionSetLink> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCollectionSet, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									dataCollectionId, dataSetId
								};
							}

							_log.warn(
								"CollectionSetLinkPersistenceImpl.fetchByCollectionSet(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CollectionSetLink collectionSetLink = list.get(0);

					result = collectionSetLink;

					cacheResult(collectionSetLink);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByCollectionSet, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CollectionSetLink)result;
		}
	}

	/**
	 * Removes the collection set link where dataCollectionId = &#63; and dataSetId = &#63; from the database.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the collection set link that was removed
	 */
	@Override
	public CollectionSetLink removeByCollectionSet(
			long dataCollectionId, long dataSetId)
		throws NoSuchCollectionSetLinkException {

		CollectionSetLink collectionSetLink = findByCollectionSet(
			dataCollectionId, dataSetId);

		return remove(collectionSetLink);
	}

	/**
	 * Returns the number of collection set links where dataCollectionId = &#63; and dataSetId = &#63;.
	 *
	 * @param dataCollectionId the data collection ID
	 * @param dataSetId the data set ID
	 * @return the number of matching collection set links
	 */
	@Override
	public int countByCollectionSet(long dataCollectionId, long dataSetId) {
		FinderPath finderPath = _finderPathCountByCollectionSet;

		Object[] finderArgs = new Object[] {dataCollectionId, dataSetId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COLLECTIONSETLINK_WHERE);

			sb.append(_FINDER_COLUMN_COLLECTIONSET_DATACOLLECTIONID_2);

			sb.append(_FINDER_COLUMN_COLLECTIONSET_DATASETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataCollectionId);

				queryPos.add(dataSetId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_COLLECTIONSET_DATACOLLECTIONID_2 =
			"collectionSetLink.dataCollectionId = ? AND ";

	private static final String _FINDER_COLUMN_COLLECTIONSET_DATASETID_2 =
		"collectionSetLink.dataSetId = ?";

	public CollectionSetLinkPersistenceImpl() {
		setModelClass(CollectionSetLink.class);

		setModelImplClass(CollectionSetLinkImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the collection set link in the entity cache if it is enabled.
	 *
	 * @param collectionSetLink the collection set link
	 */
	@Override
	public void cacheResult(CollectionSetLink collectionSetLink) {
		entityCache.putResult(
			entityCacheEnabled, CollectionSetLinkImpl.class,
			collectionSetLink.getPrimaryKey(), collectionSetLink);

		finderCache.putResult(
			_finderPathFetchByCollectionSet,
			new Object[] {
				collectionSetLink.getDataCollectionId(),
				collectionSetLink.getDataSetId()
			},
			collectionSetLink);

		collectionSetLink.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the collection set links in the entity cache if it is enabled.
	 *
	 * @param collectionSetLinks the collection set links
	 */
	@Override
	public void cacheResult(List<CollectionSetLink> collectionSetLinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (collectionSetLinks.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CollectionSetLink collectionSetLink : collectionSetLinks) {
			if (entityCache.getResult(
					entityCacheEnabled, CollectionSetLinkImpl.class,
					collectionSetLink.getPrimaryKey()) == null) {

				cacheResult(collectionSetLink);
			}
			else {
				collectionSetLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all collection set links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CollectionSetLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the collection set link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CollectionSetLink collectionSetLink) {
		entityCache.removeResult(
			entityCacheEnabled, CollectionSetLinkImpl.class,
			collectionSetLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(CollectionSetLinkModelImpl)collectionSetLink, true);
	}

	@Override
	public void clearCache(List<CollectionSetLink> collectionSetLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CollectionSetLink collectionSetLink : collectionSetLinks) {
			entityCache.removeResult(
				entityCacheEnabled, CollectionSetLinkImpl.class,
				collectionSetLink.getPrimaryKey());

			clearUniqueFindersCache(
				(CollectionSetLinkModelImpl)collectionSetLink, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CollectionSetLinkImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CollectionSetLinkModelImpl collectionSetLinkModelImpl) {

		Object[] args = new Object[] {
			collectionSetLinkModelImpl.getDataCollectionId(),
			collectionSetLinkModelImpl.getDataSetId()
		};

		finderCache.putResult(
			_finderPathCountByCollectionSet, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCollectionSet, args, collectionSetLinkModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		CollectionSetLinkModelImpl collectionSetLinkModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				collectionSetLinkModelImpl.getDataCollectionId(),
				collectionSetLinkModelImpl.getDataSetId()
			};

			finderCache.removeResult(_finderPathCountByCollectionSet, args);
			finderCache.removeResult(_finderPathFetchByCollectionSet, args);
		}

		if ((collectionSetLinkModelImpl.getColumnBitmask() &
			 _finderPathFetchByCollectionSet.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				collectionSetLinkModelImpl.getOriginalDataCollectionId(),
				collectionSetLinkModelImpl.getOriginalDataSetId()
			};

			finderCache.removeResult(_finderPathCountByCollectionSet, args);
			finderCache.removeResult(_finderPathFetchByCollectionSet, args);
		}
	}

	/**
	 * Creates a new collection set link with the primary key. Does not add the collection set link to the database.
	 *
	 * @param collectionSetLinkId the primary key for the new collection set link
	 * @return the new collection set link
	 */
	@Override
	public CollectionSetLink create(long collectionSetLinkId) {
		CollectionSetLink collectionSetLink = new CollectionSetLinkImpl();

		collectionSetLink.setNew(true);
		collectionSetLink.setPrimaryKey(collectionSetLinkId);

		return collectionSetLink;
	}

	/**
	 * Removes the collection set link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link that was removed
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	@Override
	public CollectionSetLink remove(long collectionSetLinkId)
		throws NoSuchCollectionSetLinkException {

		return remove((Serializable)collectionSetLinkId);
	}

	/**
	 * Removes the collection set link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the collection set link
	 * @return the collection set link that was removed
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	@Override
	public CollectionSetLink remove(Serializable primaryKey)
		throws NoSuchCollectionSetLinkException {

		Session session = null;

		try {
			session = openSession();

			CollectionSetLink collectionSetLink =
				(CollectionSetLink)session.get(
					CollectionSetLinkImpl.class, primaryKey);

			if (collectionSetLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCollectionSetLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(collectionSetLink);
		}
		catch (NoSuchCollectionSetLinkException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CollectionSetLink removeImpl(
		CollectionSetLink collectionSetLink) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(collectionSetLink)) {
				collectionSetLink = (CollectionSetLink)session.get(
					CollectionSetLinkImpl.class,
					collectionSetLink.getPrimaryKeyObj());
			}

			if (collectionSetLink != null) {
				session.delete(collectionSetLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (collectionSetLink != null) {
			clearCache(collectionSetLink);
		}

		return collectionSetLink;
	}

	@Override
	public CollectionSetLink updateImpl(CollectionSetLink collectionSetLink) {
		boolean isNew = collectionSetLink.isNew();

		if (!(collectionSetLink instanceof CollectionSetLinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(collectionSetLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					collectionSetLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in collectionSetLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CollectionSetLink implementation " +
					collectionSetLink.getClass());
		}

		CollectionSetLinkModelImpl collectionSetLinkModelImpl =
			(CollectionSetLinkModelImpl)collectionSetLink;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(collectionSetLink);

				collectionSetLink.setNew(false);
			}
			else {
				collectionSetLink = (CollectionSetLink)session.merge(
					collectionSetLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				collectionSetLinkModelImpl.getDataCollectionId()
			};

			finderCache.removeResult(_finderPathCountByCollectionId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCollectionId, args);

			args = new Object[] {collectionSetLinkModelImpl.getDataSetId()};

			finderCache.removeResult(_finderPathCountByDataSetId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataSetId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((collectionSetLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCollectionId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					collectionSetLinkModelImpl.getOriginalDataCollectionId()
				};

				finderCache.removeResult(_finderPathCountByCollectionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCollectionId, args);

				args = new Object[] {
					collectionSetLinkModelImpl.getDataCollectionId()
				};

				finderCache.removeResult(_finderPathCountByCollectionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCollectionId, args);
			}

			if ((collectionSetLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataSetId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					collectionSetLinkModelImpl.getOriginalDataSetId()
				};

				finderCache.removeResult(_finderPathCountByDataSetId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSetId, args);

				args = new Object[] {collectionSetLinkModelImpl.getDataSetId()};

				finderCache.removeResult(_finderPathCountByDataSetId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSetId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CollectionSetLinkImpl.class,
			collectionSetLink.getPrimaryKey(), collectionSetLink, false);

		clearUniqueFindersCache(collectionSetLinkModelImpl, false);
		cacheUniqueFindersCache(collectionSetLinkModelImpl);

		collectionSetLink.resetOriginalValues();

		return collectionSetLink;
	}

	/**
	 * Returns the collection set link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the collection set link
	 * @return the collection set link
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	@Override
	public CollectionSetLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCollectionSetLinkException {

		CollectionSetLink collectionSetLink = fetchByPrimaryKey(primaryKey);

		if (collectionSetLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCollectionSetLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return collectionSetLink;
	}

	/**
	 * Returns the collection set link with the primary key or throws a <code>NoSuchCollectionSetLinkException</code> if it could not be found.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link
	 * @throws NoSuchCollectionSetLinkException if a collection set link with the primary key could not be found
	 */
	@Override
	public CollectionSetLink findByPrimaryKey(long collectionSetLinkId)
		throws NoSuchCollectionSetLinkException {

		return findByPrimaryKey((Serializable)collectionSetLinkId);
	}

	/**
	 * Returns the collection set link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param collectionSetLinkId the primary key of the collection set link
	 * @return the collection set link, or <code>null</code> if a collection set link with the primary key could not be found
	 */
	@Override
	public CollectionSetLink fetchByPrimaryKey(long collectionSetLinkId) {
		return fetchByPrimaryKey((Serializable)collectionSetLinkId);
	}

	/**
	 * Returns all the collection set links.
	 *
	 * @return the collection set links
	 */
	@Override
	public List<CollectionSetLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the collection set links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @return the range of collection set links
	 */
	@Override
	public List<CollectionSetLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the collection set links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of collection set links
	 */
	@Override
	public List<CollectionSetLink> findAll(
		int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the collection set links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionSetLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of collection set links
	 * @param end the upper bound of the range of collection set links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of collection set links
	 */
	@Override
	public List<CollectionSetLink> findAll(
		int start, int end,
		OrderByComparator<CollectionSetLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CollectionSetLink> list = null;

		if (useFinderCache) {
			list = (List<CollectionSetLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COLLECTIONSETLINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COLLECTIONSETLINK;

				sql = sql.concat(CollectionSetLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CollectionSetLink>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the collection set links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CollectionSetLink collectionSetLink : findAll()) {
			remove(collectionSetLink);
		}
	}

	/**
	 * Returns the number of collection set links.
	 *
	 * @return the number of collection set links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COLLECTIONSETLINK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "collectionSetLinkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COLLECTIONSETLINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CollectionSetLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the collection set link persistence.
	 */
	@Activate
	public void activate() {
		CollectionSetLinkModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CollectionSetLinkModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CollectionSetLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CollectionSetLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByCollectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CollectionSetLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCollectionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCollectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CollectionSetLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCollectionId",
			new String[] {Long.class.getName()},
			CollectionSetLinkModelImpl.DATACOLLECTIONID_COLUMN_BITMASK);

		_finderPathCountByCollectionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCollectionId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CollectionSetLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataSetId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CollectionSetLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataSetId",
			new String[] {Long.class.getName()},
			CollectionSetLinkModelImpl.DATASETID_COLUMN_BITMASK);

		_finderPathCountByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataSetId",
			new String[] {Long.class.getName()});

		_finderPathFetchByCollectionSet = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CollectionSetLinkImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCollectionSet",
			new String[] {Long.class.getName(), Long.class.getName()},
			CollectionSetLinkModelImpl.DATACOLLECTIONID_COLUMN_BITMASK |
			CollectionSetLinkModelImpl.DATASETID_COLUMN_BITMASK);

		_finderPathCountByCollectionSet = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCollectionSet",
			new String[] {Long.class.getName(), Long.class.getName()});

		_setCollectionSetLinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCollectionSetLinkUtilPersistence(null);

		entityCache.removeCache(CollectionSetLinkImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setCollectionSetLinkUtilPersistence(
		CollectionSetLinkPersistence collectionSetLinkPersistence) {

		try {
			Field field = CollectionSetLinkUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, collectionSetLinkPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SX_ICECAPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.sx.icecap.model.CollectionSetLink"),
			true);
	}

	@Override
	@Reference(
		target = SX_ICECAPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SX_ICECAPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COLLECTIONSETLINK =
		"SELECT collectionSetLink FROM CollectionSetLink collectionSetLink";

	private static final String _SQL_SELECT_COLLECTIONSETLINK_WHERE =
		"SELECT collectionSetLink FROM CollectionSetLink collectionSetLink WHERE ";

	private static final String _SQL_COUNT_COLLECTIONSETLINK =
		"SELECT COUNT(collectionSetLink) FROM CollectionSetLink collectionSetLink";

	private static final String _SQL_COUNT_COLLECTIONSETLINK_WHERE =
		"SELECT COUNT(collectionSetLink) FROM CollectionSetLink collectionSetLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "collectionSetLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CollectionSetLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CollectionSetLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CollectionSetLinkPersistenceImpl.class);

}