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

import com.sx.icecap.exception.NoSuchDataStructureException;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.model.impl.DataStructureImpl;
import com.sx.icecap.model.impl.DataStructureModelImpl;
import com.sx.icecap.service.persistence.DataStructurePersistence;
import com.sx.icecap.service.persistence.DataStructureUtil;
import com.sx.icecap.service.persistence.impl.constants.SX_ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the data structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DataStructurePersistence.class)
public class DataStructurePersistenceImpl
	extends BasePersistenceImpl<DataStructure>
	implements DataStructurePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataStructureUtil</code> to access the data structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataStructureImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDataTypeId;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId;
	private FinderPath _finderPathCountByDataTypeId;

	/**
	 * Returns all the data structures where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching data structures
	 */
	@Override
	public List<DataStructure> findByDataTypeId(long dataTypeId) {
		return findByDataTypeId(
			dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data structures where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of matching data structures
	 */
	@Override
	public List<DataStructure> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return findByDataTypeId(dataTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data structures where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data structures
	 */
	@Override
	public List<DataStructure> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return findByDataTypeId(
			dataTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data structures where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data structures
	 */
	@Override
	public List<DataStructure> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<DataStructure> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataTypeId;
				finderArgs = new Object[] {dataTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataTypeId;
			finderArgs = new Object[] {
				dataTypeId, start, end, orderByComparator
			};
		}

		List<DataStructure> list = null;

		if (useFinderCache) {
			list = (List<DataStructure>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataStructure dataStructure : list) {
					if (dataTypeId != dataStructure.getDataTypeId()) {
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

			sb.append(_SQL_SELECT_DATASTRUCTURE_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataStructureModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				list = (List<DataStructure>)QueryUtil.list(
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
	 * Returns the first data structure in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	@Override
	public DataStructure findByDataTypeId_First(
			long dataTypeId, OrderByComparator<DataStructure> orderByComparator)
		throws NoSuchDataStructureException {

		DataStructure dataStructure = fetchByDataTypeId_First(
			dataTypeId, orderByComparator);

		if (dataStructure != null) {
			return dataStructure;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchDataStructureException(sb.toString());
	}

	/**
	 * Returns the first data structure in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	@Override
	public DataStructure fetchByDataTypeId_First(
		long dataTypeId, OrderByComparator<DataStructure> orderByComparator) {

		List<DataStructure> list = findByDataTypeId(
			dataTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data structure in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	@Override
	public DataStructure findByDataTypeId_Last(
			long dataTypeId, OrderByComparator<DataStructure> orderByComparator)
		throws NoSuchDataStructureException {

		DataStructure dataStructure = fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);

		if (dataStructure != null) {
			return dataStructure;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchDataStructureException(sb.toString());
	}

	/**
	 * Returns the last data structure in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	@Override
	public DataStructure fetchByDataTypeId_Last(
		long dataTypeId, OrderByComparator<DataStructure> orderByComparator) {

		int count = countByDataTypeId(dataTypeId);

		if (count == 0) {
			return null;
		}

		List<DataStructure> list = findByDataTypeId(
			dataTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data structures before and after the current data structure in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataStructureId the primary key of the current data structure
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	@Override
	public DataStructure[] findByDataTypeId_PrevAndNext(
			long dataStructureId, long dataTypeId,
			OrderByComparator<DataStructure> orderByComparator)
		throws NoSuchDataStructureException {

		DataStructure dataStructure = findByPrimaryKey(dataStructureId);

		Session session = null;

		try {
			session = openSession();

			DataStructure[] array = new DataStructureImpl[3];

			array[0] = getByDataTypeId_PrevAndNext(
				session, dataStructure, dataTypeId, orderByComparator, true);

			array[1] = dataStructure;

			array[2] = getByDataTypeId_PrevAndNext(
				session, dataStructure, dataTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataStructure getByDataTypeId_PrevAndNext(
		Session session, DataStructure dataStructure, long dataTypeId,
		OrderByComparator<DataStructure> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATASTRUCTURE_WHERE);

		sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

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
			sb.append(DataStructureModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dataStructure)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataStructure> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data structures where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	@Override
	public void removeByDataTypeId(long dataTypeId) {
		for (DataStructure dataStructure :
				findByDataTypeId(
					dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataStructure);
		}
	}

	/**
	 * Returns the number of data structures where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching data structures
	 */
	@Override
	public int countByDataTypeId(long dataTypeId) {
		FinderPath finderPath = _finderPathCountByDataTypeId;

		Object[] finderArgs = new Object[] {dataTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATASTRUCTURE_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

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

	private static final String _FINDER_COLUMN_DATATYPEID_DATATYPEID_2 =
		"dataStructure.dataTypeId = ?";

	private FinderPath _finderPathFetchByDataTypeIdVersion;
	private FinderPath _finderPathCountByDataTypeIdVersion;

	/**
	 * Returns the data structure where dataTypeId = &#63; and version = &#63; or throws a <code>NoSuchDataStructureException</code> if it could not be found.
	 *
	 * @param dataTypeId the data type ID
	 * @param version the version
	 * @return the matching data structure
	 * @throws NoSuchDataStructureException if a matching data structure could not be found
	 */
	@Override
	public DataStructure findByDataTypeIdVersion(
			long dataTypeId, String version)
		throws NoSuchDataStructureException {

		DataStructure dataStructure = fetchByDataTypeIdVersion(
			dataTypeId, version);

		if (dataStructure == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("dataTypeId=");
			sb.append(dataTypeId);

			sb.append(", version=");
			sb.append(version);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDataStructureException(sb.toString());
		}

		return dataStructure;
	}

	/**
	 * Returns the data structure where dataTypeId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataTypeId the data type ID
	 * @param version the version
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	@Override
	public DataStructure fetchByDataTypeIdVersion(
		long dataTypeId, String version) {

		return fetchByDataTypeIdVersion(dataTypeId, version, true);
	}

	/**
	 * Returns the data structure where dataTypeId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataTypeId the data type ID
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data structure, or <code>null</code> if a matching data structure could not be found
	 */
	@Override
	public DataStructure fetchByDataTypeIdVersion(
		long dataTypeId, String version, boolean useFinderCache) {

		version = Objects.toString(version, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {dataTypeId, version};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDataTypeIdVersion, finderArgs, this);
		}

		if (result instanceof DataStructure) {
			DataStructure dataStructure = (DataStructure)result;

			if ((dataTypeId != dataStructure.getDataTypeId()) ||
				!Objects.equals(version, dataStructure.getVersion())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DATASTRUCTURE_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEIDVERSION_DATATYPEID_2);

			boolean bindVersion = false;

			if (version.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATATYPEIDVERSION_VERSION_3);
			}
			else {
				bindVersion = true;

				sb.append(_FINDER_COLUMN_DATATYPEIDVERSION_VERSION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				if (bindVersion) {
					queryPos.add(version);
				}

				List<DataStructure> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDataTypeIdVersion, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {dataTypeId, version};
							}

							_log.warn(
								"DataStructurePersistenceImpl.fetchByDataTypeIdVersion(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DataStructure dataStructure = list.get(0);

					result = dataStructure;

					cacheResult(dataStructure);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByDataTypeIdVersion, finderArgs);
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
			return (DataStructure)result;
		}
	}

	/**
	 * Removes the data structure where dataTypeId = &#63; and version = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param version the version
	 * @return the data structure that was removed
	 */
	@Override
	public DataStructure removeByDataTypeIdVersion(
			long dataTypeId, String version)
		throws NoSuchDataStructureException {

		DataStructure dataStructure = findByDataTypeIdVersion(
			dataTypeId, version);

		return remove(dataStructure);
	}

	/**
	 * Returns the number of data structures where dataTypeId = &#63; and version = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param version the version
	 * @return the number of matching data structures
	 */
	@Override
	public int countByDataTypeIdVersion(long dataTypeId, String version) {
		version = Objects.toString(version, "");

		FinderPath finderPath = _finderPathCountByDataTypeIdVersion;

		Object[] finderArgs = new Object[] {dataTypeId, version};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATASTRUCTURE_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEIDVERSION_DATATYPEID_2);

			boolean bindVersion = false;

			if (version.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATATYPEIDVERSION_VERSION_3);
			}
			else {
				bindVersion = true;

				sb.append(_FINDER_COLUMN_DATATYPEIDVERSION_VERSION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				if (bindVersion) {
					queryPos.add(version);
				}

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

	private static final String _FINDER_COLUMN_DATATYPEIDVERSION_DATATYPEID_2 =
		"dataStructure.dataTypeId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEIDVERSION_VERSION_2 =
		"dataStructure.version = ?";

	private static final String _FINDER_COLUMN_DATATYPEIDVERSION_VERSION_3 =
		"(dataStructure.version IS NULL OR dataStructure.version = '')";

	public DataStructurePersistenceImpl() {
		setModelClass(DataStructure.class);

		setModelImplClass(DataStructureImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the data structure in the entity cache if it is enabled.
	 *
	 * @param dataStructure the data structure
	 */
	@Override
	public void cacheResult(DataStructure dataStructure) {
		entityCache.putResult(
			entityCacheEnabled, DataStructureImpl.class,
			dataStructure.getPrimaryKey(), dataStructure);

		finderCache.putResult(
			_finderPathFetchByDataTypeIdVersion,
			new Object[] {
				dataStructure.getDataTypeId(), dataStructure.getVersion()
			},
			dataStructure);

		dataStructure.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the data structures in the entity cache if it is enabled.
	 *
	 * @param dataStructures the data structures
	 */
	@Override
	public void cacheResult(List<DataStructure> dataStructures) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dataStructures.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DataStructure dataStructure : dataStructures) {
			if (entityCache.getResult(
					entityCacheEnabled, DataStructureImpl.class,
					dataStructure.getPrimaryKey()) == null) {

				cacheResult(dataStructure);
			}
			else {
				dataStructure.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data structures.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataStructureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data structure.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataStructure dataStructure) {
		entityCache.removeResult(
			entityCacheEnabled, DataStructureImpl.class,
			dataStructure.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DataStructureModelImpl)dataStructure, true);
	}

	@Override
	public void clearCache(List<DataStructure> dataStructures) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataStructure dataStructure : dataStructures) {
			entityCache.removeResult(
				entityCacheEnabled, DataStructureImpl.class,
				dataStructure.getPrimaryKey());

			clearUniqueFindersCache(
				(DataStructureModelImpl)dataStructure, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, DataStructureImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DataStructureModelImpl dataStructureModelImpl) {

		Object[] args = new Object[] {
			dataStructureModelImpl.getDataTypeId(),
			dataStructureModelImpl.getVersion()
		};

		finderCache.putResult(
			_finderPathCountByDataTypeIdVersion, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDataTypeIdVersion, args, dataStructureModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		DataStructureModelImpl dataStructureModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				dataStructureModelImpl.getDataTypeId(),
				dataStructureModelImpl.getVersion()
			};

			finderCache.removeResult(_finderPathCountByDataTypeIdVersion, args);
			finderCache.removeResult(_finderPathFetchByDataTypeIdVersion, args);
		}

		if ((dataStructureModelImpl.getColumnBitmask() &
			 _finderPathFetchByDataTypeIdVersion.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				dataStructureModelImpl.getOriginalDataTypeId(),
				dataStructureModelImpl.getOriginalVersion()
			};

			finderCache.removeResult(_finderPathCountByDataTypeIdVersion, args);
			finderCache.removeResult(_finderPathFetchByDataTypeIdVersion, args);
		}
	}

	/**
	 * Creates a new data structure with the primary key. Does not add the data structure to the database.
	 *
	 * @param dataStructureId the primary key for the new data structure
	 * @return the new data structure
	 */
	@Override
	public DataStructure create(long dataStructureId) {
		DataStructure dataStructure = new DataStructureImpl();

		dataStructure.setNew(true);
		dataStructure.setPrimaryKey(dataStructureId);

		return dataStructure;
	}

	/**
	 * Removes the data structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure that was removed
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	@Override
	public DataStructure remove(long dataStructureId)
		throws NoSuchDataStructureException {

		return remove((Serializable)dataStructureId);
	}

	/**
	 * Removes the data structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data structure
	 * @return the data structure that was removed
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	@Override
	public DataStructure remove(Serializable primaryKey)
		throws NoSuchDataStructureException {

		Session session = null;

		try {
			session = openSession();

			DataStructure dataStructure = (DataStructure)session.get(
				DataStructureImpl.class, primaryKey);

			if (dataStructure == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataStructureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataStructure);
		}
		catch (NoSuchDataStructureException noSuchEntityException) {
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
	protected DataStructure removeImpl(DataStructure dataStructure) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataStructure)) {
				dataStructure = (DataStructure)session.get(
					DataStructureImpl.class, dataStructure.getPrimaryKeyObj());
			}

			if (dataStructure != null) {
				session.delete(dataStructure);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dataStructure != null) {
			clearCache(dataStructure);
		}

		return dataStructure;
	}

	@Override
	public DataStructure updateImpl(DataStructure dataStructure) {
		boolean isNew = dataStructure.isNew();

		if (!(dataStructure instanceof DataStructureModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dataStructure.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dataStructure);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dataStructure proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DataStructure implementation " +
					dataStructure.getClass());
		}

		DataStructureModelImpl dataStructureModelImpl =
			(DataStructureModelImpl)dataStructure;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dataStructure);

				dataStructure.setNew(false);
			}
			else {
				dataStructure = (DataStructure)session.merge(dataStructure);
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
				dataStructureModelImpl.getDataTypeId()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dataStructureModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataStructureModelImpl.getOriginalDataTypeId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);

				args = new Object[] {dataStructureModelImpl.getDataTypeId()};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DataStructureImpl.class,
			dataStructure.getPrimaryKey(), dataStructure, false);

		clearUniqueFindersCache(dataStructureModelImpl, false);
		cacheUniqueFindersCache(dataStructureModelImpl);

		dataStructure.resetOriginalValues();

		return dataStructure;
	}

	/**
	 * Returns the data structure with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data structure
	 * @return the data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	@Override
	public DataStructure findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataStructureException {

		DataStructure dataStructure = fetchByPrimaryKey(primaryKey);

		if (dataStructure == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataStructureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataStructure;
	}

	/**
	 * Returns the data structure with the primary key or throws a <code>NoSuchDataStructureException</code> if it could not be found.
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure
	 * @throws NoSuchDataStructureException if a data structure with the primary key could not be found
	 */
	@Override
	public DataStructure findByPrimaryKey(long dataStructureId)
		throws NoSuchDataStructureException {

		return findByPrimaryKey((Serializable)dataStructureId);
	}

	/**
	 * Returns the data structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataStructureId the primary key of the data structure
	 * @return the data structure, or <code>null</code> if a data structure with the primary key could not be found
	 */
	@Override
	public DataStructure fetchByPrimaryKey(long dataStructureId) {
		return fetchByPrimaryKey((Serializable)dataStructureId);
	}

	/**
	 * Returns all the data structures.
	 *
	 * @return the data structures
	 */
	@Override
	public List<DataStructure> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @return the range of data structures
	 */
	@Override
	public List<DataStructure> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data structures
	 */
	@Override
	public List<DataStructure> findAll(
		int start, int end,
		OrderByComparator<DataStructure> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data structures
	 * @param end the upper bound of the range of data structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data structures
	 */
	@Override
	public List<DataStructure> findAll(
		int start, int end, OrderByComparator<DataStructure> orderByComparator,
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

		List<DataStructure> list = null;

		if (useFinderCache) {
			list = (List<DataStructure>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DATASTRUCTURE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DATASTRUCTURE;

				sql = sql.concat(DataStructureModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DataStructure>)QueryUtil.list(
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
	 * Removes all the data structures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataStructure dataStructure : findAll()) {
			remove(dataStructure);
		}
	}

	/**
	 * Returns the number of data structures.
	 *
	 * @return the number of data structures
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DATASTRUCTURE);

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
		return "dataStructureId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATASTRUCTURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataStructureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data structure persistence.
	 */
	@Activate
	public void activate() {
		DataStructureModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DataStructureModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId",
			new String[] {Long.class.getName()},
			DataStructureModelImpl.DATATYPEID_COLUMN_BITMASK);

		_finderPathCountByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId",
			new String[] {Long.class.getName()});

		_finderPathFetchByDataTypeIdVersion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataStructureImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDataTypeIdVersion",
			new String[] {Long.class.getName(), String.class.getName()},
			DataStructureModelImpl.DATATYPEID_COLUMN_BITMASK |
			DataStructureModelImpl.VERSION_COLUMN_BITMASK);

		_finderPathCountByDataTypeIdVersion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataTypeIdVersion",
			new String[] {Long.class.getName(), String.class.getName()});

		_setDataStructureUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDataStructureUtilPersistence(null);

		entityCache.removeCache(DataStructureImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setDataStructureUtilPersistence(
		DataStructurePersistence dataStructurePersistence) {

		try {
			Field field = DataStructureUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dataStructurePersistence);
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
				"value.object.column.bitmask.enabled.com.sx.icecap.model.DataStructure"),
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

	private static final String _SQL_SELECT_DATASTRUCTURE =
		"SELECT dataStructure FROM DataStructure dataStructure";

	private static final String _SQL_SELECT_DATASTRUCTURE_WHERE =
		"SELECT dataStructure FROM DataStructure dataStructure WHERE ";

	private static final String _SQL_COUNT_DATASTRUCTURE =
		"SELECT COUNT(dataStructure) FROM DataStructure dataStructure";

	private static final String _SQL_COUNT_DATASTRUCTURE_WHERE =
		"SELECT COUNT(dataStructure) FROM DataStructure dataStructure WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataStructure.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataStructure exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DataStructure exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DataStructurePersistenceImpl.class);

}