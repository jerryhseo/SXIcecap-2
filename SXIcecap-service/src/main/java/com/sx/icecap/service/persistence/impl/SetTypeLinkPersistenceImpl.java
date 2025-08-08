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

import com.sx.icecap.exception.NoSuchSetTypeLinkException;
import com.sx.icecap.model.SetTypeLink;
import com.sx.icecap.model.impl.SetTypeLinkImpl;
import com.sx.icecap.model.impl.SetTypeLinkModelImpl;
import com.sx.icecap.service.persistence.SetTypeLinkPersistence;
import com.sx.icecap.service.persistence.SetTypeLinkUtil;
import com.sx.icecap.service.persistence.impl.constants.SX_ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the set type link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SetTypeLinkPersistence.class)
public class SetTypeLinkPersistenceImpl
	extends BasePersistenceImpl<SetTypeLink> implements SetTypeLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SetTypeLinkUtil</code> to access the set type link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SetTypeLinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDataSetId;
	private FinderPath _finderPathWithoutPaginationFindByDataSetId;
	private FinderPath _finderPathCountByDataSetId;

	/**
	 * Returns all the set type links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching set type links
	 */
	@Override
	public List<SetTypeLink> findByDataSetId(long dataSetId) {
		return findByDataSetId(
			dataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the set type links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of matching set type links
	 */
	@Override
	public List<SetTypeLink> findByDataSetId(
		long dataSetId, int start, int end) {

		return findByDataSetId(dataSetId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the set type links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching set type links
	 */
	@Override
	public List<SetTypeLink> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return findByDataSetId(dataSetId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the set type links where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching set type links
	 */
	@Override
	public List<SetTypeLink> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator,
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

		List<SetTypeLink> list = null;

		if (useFinderCache) {
			list = (List<SetTypeLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SetTypeLink setTypeLink : list) {
					if (dataSetId != setTypeLink.getDataSetId()) {
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

			sb.append(_SQL_SELECT_SETTYPELINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASETID_DATASETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SetTypeLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataSetId);

				list = (List<SetTypeLink>)QueryUtil.list(
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
	 * Returns the first set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	@Override
	public SetTypeLink findByDataSetId_First(
			long dataSetId, OrderByComparator<SetTypeLink> orderByComparator)
		throws NoSuchSetTypeLinkException {

		SetTypeLink setTypeLink = fetchByDataSetId_First(
			dataSetId, orderByComparator);

		if (setTypeLink != null) {
			return setTypeLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataSetId=");
		sb.append(dataSetId);

		sb.append("}");

		throw new NoSuchSetTypeLinkException(sb.toString());
	}

	/**
	 * Returns the first set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	@Override
	public SetTypeLink fetchByDataSetId_First(
		long dataSetId, OrderByComparator<SetTypeLink> orderByComparator) {

		List<SetTypeLink> list = findByDataSetId(
			dataSetId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	@Override
	public SetTypeLink findByDataSetId_Last(
			long dataSetId, OrderByComparator<SetTypeLink> orderByComparator)
		throws NoSuchSetTypeLinkException {

		SetTypeLink setTypeLink = fetchByDataSetId_Last(
			dataSetId, orderByComparator);

		if (setTypeLink != null) {
			return setTypeLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataSetId=");
		sb.append(dataSetId);

		sb.append("}");

		throw new NoSuchSetTypeLinkException(sb.toString());
	}

	/**
	 * Returns the last set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	@Override
	public SetTypeLink fetchByDataSetId_Last(
		long dataSetId, OrderByComparator<SetTypeLink> orderByComparator) {

		int count = countByDataSetId(dataSetId);

		if (count == 0) {
			return null;
		}

		List<SetTypeLink> list = findByDataSetId(
			dataSetId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where dataSetId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	@Override
	public SetTypeLink[] findByDataSetId_PrevAndNext(
			long setTypeLinkId, long dataSetId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws NoSuchSetTypeLinkException {

		SetTypeLink setTypeLink = findByPrimaryKey(setTypeLinkId);

		Session session = null;

		try {
			session = openSession();

			SetTypeLink[] array = new SetTypeLinkImpl[3];

			array[0] = getByDataSetId_PrevAndNext(
				session, setTypeLink, dataSetId, orderByComparator, true);

			array[1] = setTypeLink;

			array[2] = getByDataSetId_PrevAndNext(
				session, setTypeLink, dataSetId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SetTypeLink getByDataSetId_PrevAndNext(
		Session session, SetTypeLink setTypeLink, long dataSetId,
		OrderByComparator<SetTypeLink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SETTYPELINK_WHERE);

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
			sb.append(SetTypeLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataSetId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(setTypeLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SetTypeLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the set type links where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	@Override
	public void removeByDataSetId(long dataSetId) {
		for (SetTypeLink setTypeLink :
				findByDataSetId(
					dataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(setTypeLink);
		}
	}

	/**
	 * Returns the number of set type links where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching set type links
	 */
	@Override
	public int countByDataSetId(long dataSetId) {
		FinderPath finderPath = _finderPathCountByDataSetId;

		Object[] finderArgs = new Object[] {dataSetId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SETTYPELINK_WHERE);

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
		"setTypeLink.dataSetId = ?";

	private FinderPath _finderPathWithPaginationFindByDataTypeId;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId;
	private FinderPath _finderPathCountByDataTypeId;

	/**
	 * Returns all the set type links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching set type links
	 */
	@Override
	public List<SetTypeLink> findByDataTypeId(long dataTypeId) {
		return findByDataTypeId(
			dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the set type links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of matching set type links
	 */
	@Override
	public List<SetTypeLink> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return findByDataTypeId(dataTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the set type links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching set type links
	 */
	@Override
	public List<SetTypeLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator) {

		return findByDataTypeId(
			dataTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the set type links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching set type links
	 */
	@Override
	public List<SetTypeLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<SetTypeLink> orderByComparator,
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

		List<SetTypeLink> list = null;

		if (useFinderCache) {
			list = (List<SetTypeLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SetTypeLink setTypeLink : list) {
					if (dataTypeId != setTypeLink.getDataTypeId()) {
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

			sb.append(_SQL_SELECT_SETTYPELINK_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SetTypeLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				list = (List<SetTypeLink>)QueryUtil.list(
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
	 * Returns the first set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	@Override
	public SetTypeLink findByDataTypeId_First(
			long dataTypeId, OrderByComparator<SetTypeLink> orderByComparator)
		throws NoSuchSetTypeLinkException {

		SetTypeLink setTypeLink = fetchByDataTypeId_First(
			dataTypeId, orderByComparator);

		if (setTypeLink != null) {
			return setTypeLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchSetTypeLinkException(sb.toString());
	}

	/**
	 * Returns the first set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	@Override
	public SetTypeLink fetchByDataTypeId_First(
		long dataTypeId, OrderByComparator<SetTypeLink> orderByComparator) {

		List<SetTypeLink> list = findByDataTypeId(
			dataTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link
	 * @throws NoSuchSetTypeLinkException if a matching set type link could not be found
	 */
	@Override
	public SetTypeLink findByDataTypeId_Last(
			long dataTypeId, OrderByComparator<SetTypeLink> orderByComparator)
		throws NoSuchSetTypeLinkException {

		SetTypeLink setTypeLink = fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);

		if (setTypeLink != null) {
			return setTypeLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchSetTypeLinkException(sb.toString());
	}

	/**
	 * Returns the last set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching set type link, or <code>null</code> if a matching set type link could not be found
	 */
	@Override
	public SetTypeLink fetchByDataTypeId_Last(
		long dataTypeId, OrderByComparator<SetTypeLink> orderByComparator) {

		int count = countByDataTypeId(dataTypeId);

		if (count == 0) {
			return null;
		}

		List<SetTypeLink> list = findByDataTypeId(
			dataTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the set type links before and after the current set type link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param setTypeLinkId the primary key of the current set type link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	@Override
	public SetTypeLink[] findByDataTypeId_PrevAndNext(
			long setTypeLinkId, long dataTypeId,
			OrderByComparator<SetTypeLink> orderByComparator)
		throws NoSuchSetTypeLinkException {

		SetTypeLink setTypeLink = findByPrimaryKey(setTypeLinkId);

		Session session = null;

		try {
			session = openSession();

			SetTypeLink[] array = new SetTypeLinkImpl[3];

			array[0] = getByDataTypeId_PrevAndNext(
				session, setTypeLink, dataTypeId, orderByComparator, true);

			array[1] = setTypeLink;

			array[2] = getByDataTypeId_PrevAndNext(
				session, setTypeLink, dataTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SetTypeLink getByDataTypeId_PrevAndNext(
		Session session, SetTypeLink setTypeLink, long dataTypeId,
		OrderByComparator<SetTypeLink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SETTYPELINK_WHERE);

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
			sb.append(SetTypeLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(setTypeLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SetTypeLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the set type links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	@Override
	public void removeByDataTypeId(long dataTypeId) {
		for (SetTypeLink setTypeLink :
				findByDataTypeId(
					dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(setTypeLink);
		}
	}

	/**
	 * Returns the number of set type links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching set type links
	 */
	@Override
	public int countByDataTypeId(long dataTypeId) {
		FinderPath finderPath = _finderPathCountByDataTypeId;

		Object[] finderArgs = new Object[] {dataTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SETTYPELINK_WHERE);

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
		"setTypeLink.dataTypeId = ?";

	public SetTypeLinkPersistenceImpl() {
		setModelClass(SetTypeLink.class);

		setModelImplClass(SetTypeLinkImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the set type link in the entity cache if it is enabled.
	 *
	 * @param setTypeLink the set type link
	 */
	@Override
	public void cacheResult(SetTypeLink setTypeLink) {
		entityCache.putResult(
			entityCacheEnabled, SetTypeLinkImpl.class,
			setTypeLink.getPrimaryKey(), setTypeLink);

		setTypeLink.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the set type links in the entity cache if it is enabled.
	 *
	 * @param setTypeLinks the set type links
	 */
	@Override
	public void cacheResult(List<SetTypeLink> setTypeLinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (setTypeLinks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SetTypeLink setTypeLink : setTypeLinks) {
			if (entityCache.getResult(
					entityCacheEnabled, SetTypeLinkImpl.class,
					setTypeLink.getPrimaryKey()) == null) {

				cacheResult(setTypeLink);
			}
			else {
				setTypeLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all set type links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SetTypeLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the set type link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SetTypeLink setTypeLink) {
		entityCache.removeResult(
			entityCacheEnabled, SetTypeLinkImpl.class,
			setTypeLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SetTypeLink> setTypeLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SetTypeLink setTypeLink : setTypeLinks) {
			entityCache.removeResult(
				entityCacheEnabled, SetTypeLinkImpl.class,
				setTypeLink.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, SetTypeLinkImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new set type link with the primary key. Does not add the set type link to the database.
	 *
	 * @param setTypeLinkId the primary key for the new set type link
	 * @return the new set type link
	 */
	@Override
	public SetTypeLink create(long setTypeLinkId) {
		SetTypeLink setTypeLink = new SetTypeLinkImpl();

		setTypeLink.setNew(true);
		setTypeLink.setPrimaryKey(setTypeLinkId);

		return setTypeLink;
	}

	/**
	 * Removes the set type link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link that was removed
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	@Override
	public SetTypeLink remove(long setTypeLinkId)
		throws NoSuchSetTypeLinkException {

		return remove((Serializable)setTypeLinkId);
	}

	/**
	 * Removes the set type link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the set type link
	 * @return the set type link that was removed
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	@Override
	public SetTypeLink remove(Serializable primaryKey)
		throws NoSuchSetTypeLinkException {

		Session session = null;

		try {
			session = openSession();

			SetTypeLink setTypeLink = (SetTypeLink)session.get(
				SetTypeLinkImpl.class, primaryKey);

			if (setTypeLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSetTypeLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(setTypeLink);
		}
		catch (NoSuchSetTypeLinkException noSuchEntityException) {
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
	protected SetTypeLink removeImpl(SetTypeLink setTypeLink) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(setTypeLink)) {
				setTypeLink = (SetTypeLink)session.get(
					SetTypeLinkImpl.class, setTypeLink.getPrimaryKeyObj());
			}

			if (setTypeLink != null) {
				session.delete(setTypeLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (setTypeLink != null) {
			clearCache(setTypeLink);
		}

		return setTypeLink;
	}

	@Override
	public SetTypeLink updateImpl(SetTypeLink setTypeLink) {
		boolean isNew = setTypeLink.isNew();

		if (!(setTypeLink instanceof SetTypeLinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(setTypeLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(setTypeLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in setTypeLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SetTypeLink implementation " +
					setTypeLink.getClass());
		}

		SetTypeLinkModelImpl setTypeLinkModelImpl =
			(SetTypeLinkModelImpl)setTypeLink;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(setTypeLink);

				setTypeLink.setNew(false);
			}
			else {
				setTypeLink = (SetTypeLink)session.merge(setTypeLink);
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
			Object[] args = new Object[] {setTypeLinkModelImpl.getDataSetId()};

			finderCache.removeResult(_finderPathCountByDataSetId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataSetId, args);

			args = new Object[] {setTypeLinkModelImpl.getDataTypeId()};

			finderCache.removeResult(_finderPathCountByDataTypeId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((setTypeLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataSetId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					setTypeLinkModelImpl.getOriginalDataSetId()
				};

				finderCache.removeResult(_finderPathCountByDataSetId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSetId, args);

				args = new Object[] {setTypeLinkModelImpl.getDataSetId()};

				finderCache.removeResult(_finderPathCountByDataSetId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSetId, args);
			}

			if ((setTypeLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					setTypeLinkModelImpl.getOriginalDataTypeId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);

				args = new Object[] {setTypeLinkModelImpl.getDataTypeId()};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, SetTypeLinkImpl.class,
			setTypeLink.getPrimaryKey(), setTypeLink, false);

		setTypeLink.resetOriginalValues();

		return setTypeLink;
	}

	/**
	 * Returns the set type link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the set type link
	 * @return the set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	@Override
	public SetTypeLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSetTypeLinkException {

		SetTypeLink setTypeLink = fetchByPrimaryKey(primaryKey);

		if (setTypeLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSetTypeLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return setTypeLink;
	}

	/**
	 * Returns the set type link with the primary key or throws a <code>NoSuchSetTypeLinkException</code> if it could not be found.
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link
	 * @throws NoSuchSetTypeLinkException if a set type link with the primary key could not be found
	 */
	@Override
	public SetTypeLink findByPrimaryKey(long setTypeLinkId)
		throws NoSuchSetTypeLinkException {

		return findByPrimaryKey((Serializable)setTypeLinkId);
	}

	/**
	 * Returns the set type link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param setTypeLinkId the primary key of the set type link
	 * @return the set type link, or <code>null</code> if a set type link with the primary key could not be found
	 */
	@Override
	public SetTypeLink fetchByPrimaryKey(long setTypeLinkId) {
		return fetchByPrimaryKey((Serializable)setTypeLinkId);
	}

	/**
	 * Returns all the set type links.
	 *
	 * @return the set type links
	 */
	@Override
	public List<SetTypeLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the set type links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @return the range of set type links
	 */
	@Override
	public List<SetTypeLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the set type links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of set type links
	 */
	@Override
	public List<SetTypeLink> findAll(
		int start, int end, OrderByComparator<SetTypeLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the set type links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SetTypeLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of set type links
	 * @param end the upper bound of the range of set type links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of set type links
	 */
	@Override
	public List<SetTypeLink> findAll(
		int start, int end, OrderByComparator<SetTypeLink> orderByComparator,
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

		List<SetTypeLink> list = null;

		if (useFinderCache) {
			list = (List<SetTypeLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SETTYPELINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SETTYPELINK;

				sql = sql.concat(SetTypeLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SetTypeLink>)QueryUtil.list(
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
	 * Removes all the set type links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SetTypeLink setTypeLink : findAll()) {
			remove(setTypeLink);
		}
	}

	/**
	 * Returns the number of set type links.
	 *
	 * @return the number of set type links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SETTYPELINK);

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
		return "setTypeLinkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SETTYPELINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SetTypeLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the set type link persistence.
	 */
	@Activate
	public void activate() {
		SetTypeLinkModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		SetTypeLinkModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SetTypeLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SetTypeLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SetTypeLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataSetId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SetTypeLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataSetId",
			new String[] {Long.class.getName()},
			SetTypeLinkModelImpl.DATASETID_COLUMN_BITMASK);

		_finderPathCountByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataSetId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SetTypeLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SetTypeLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId",
			new String[] {Long.class.getName()},
			SetTypeLinkModelImpl.DATATYPEID_COLUMN_BITMASK);

		_finderPathCountByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId",
			new String[] {Long.class.getName()});

		_setSetTypeLinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSetTypeLinkUtilPersistence(null);

		entityCache.removeCache(SetTypeLinkImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setSetTypeLinkUtilPersistence(
		SetTypeLinkPersistence setTypeLinkPersistence) {

		try {
			Field field = SetTypeLinkUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, setTypeLinkPersistence);
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
				"value.object.column.bitmask.enabled.com.sx.icecap.model.SetTypeLink"),
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

	private static final String _SQL_SELECT_SETTYPELINK =
		"SELECT setTypeLink FROM SetTypeLink setTypeLink";

	private static final String _SQL_SELECT_SETTYPELINK_WHERE =
		"SELECT setTypeLink FROM SetTypeLink setTypeLink WHERE ";

	private static final String _SQL_COUNT_SETTYPELINK =
		"SELECT COUNT(setTypeLink) FROM SetTypeLink setTypeLink";

	private static final String _SQL_COUNT_SETTYPELINK_WHERE =
		"SELECT COUNT(setTypeLink) FROM SetTypeLink setTypeLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "setTypeLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SetTypeLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SetTypeLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SetTypeLinkPersistenceImpl.class);

}