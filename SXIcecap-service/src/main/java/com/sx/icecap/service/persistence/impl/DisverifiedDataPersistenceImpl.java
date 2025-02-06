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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.sx.icecap.exception.NoSuchDisverifiedDataException;
import com.sx.icecap.model.DisverifiedData;
import com.sx.icecap.model.impl.DisverifiedDataImpl;
import com.sx.icecap.model.impl.DisverifiedDataModelImpl;
import com.sx.icecap.service.persistence.DisverifiedDataPersistence;
import com.sx.icecap.service.persistence.DisverifiedDataUtil;
import com.sx.icecap.service.persistence.impl.constants.SX_ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the disverified data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DisverifiedDataPersistence.class)
public class DisverifiedDataPersistenceImpl
	extends BasePersistenceImpl<DisverifiedData>
	implements DisverifiedDataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DisverifiedDataUtil</code> to access the disverified data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DisverifiedDataImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the disverified datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if (groupId != disverifiedData.getGroupId()) {
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

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByGroupId_First(
			long groupId, OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByGroupId_First(
			groupId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByGroupId_First(
		long groupId, OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByGroupId_Last(
			long groupId, OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByGroupId_Last(
		long groupId, OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where groupId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByGroupId_PrevAndNext(
			long disverifiedDataId, long groupId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, disverifiedData, groupId, orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByGroupId_PrevAndNext(
				session, disverifiedData, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByGroupId_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long groupId,
		OrderByComparator<DisverifiedData> orderByComparator,
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

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (DisverifiedData disverifiedData :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"disverifiedData.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the disverified datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if (userId != disverifiedData.getUserId()) {
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

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByUserId_First(
			long userId, OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByUserId_First(
			userId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByUserId_First(
		long userId, OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByUserId_Last(
			long userId, OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByUserId_Last(
			userId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByUserId_Last(
		long userId, OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where userId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByUserId_PrevAndNext(
			long disverifiedDataId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, disverifiedData, userId, orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByUserId_PrevAndNext(
				session, disverifiedData, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByUserId_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long userId,
		OrderByComparator<DisverifiedData> orderByComparator,
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

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (DisverifiedData disverifiedData :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"disverifiedData.userId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the disverified datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByStatus(
		int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByStatus(
		int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if (status != disverifiedData.getStatus()) {
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

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByStatus_First(
			int status, OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByStatus_First(
			status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByStatus_First(
		int status, OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByStatus_Last(
			int status, OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByStatus_Last(
			status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByStatus_Last(
		int status, OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByStatus_PrevAndNext(
			long disverifiedDataId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, disverifiedData, status, orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByStatus_PrevAndNext(
				session, disverifiedData, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByStatus_PrevAndNext(
		Session session, DisverifiedData disverifiedData, int status,
		OrderByComparator<DisverifiedData> orderByComparator,
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

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (DisverifiedData disverifiedData :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"disverifiedData.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_U;
	private FinderPath _finderPathWithoutPaginationFindByG_U;
	private FinderPath _finderPathCountByG_U;

	/**
	 * Returns all the disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_U(long groupId, long userId) {
		return findByG_U(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_U(
		long groupId, long userId, int start, int end) {

		return findByG_U(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByG_U(groupId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_U;
				finderArgs = new Object[] {groupId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_U;
			finderArgs = new Object[] {
				groupId, userId, start, end, orderByComparator
			};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if ((groupId != disverifiedData.getGroupId()) ||
						(userId != disverifiedData.getUserId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByG_U_First(
			long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByG_U_First(
			groupId, userId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByG_U(
			groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByG_U_Last(
			groupId, userId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByG_U(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByG_U(
			groupId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByG_U_PrevAndNext(
			long disverifiedDataId, long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByG_U_PrevAndNext(
				session, disverifiedData, groupId, userId, orderByComparator,
				true);

			array[1] = disverifiedData;

			array[2] = getByG_U_PrevAndNext(
				session, disverifiedData, groupId, userId, orderByComparator,
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

	protected DisverifiedData getByG_U_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long groupId,
		long userId, OrderByComparator<DisverifiedData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_USERID_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByG_U(long groupId, long userId) {
		for (DisverifiedData disverifiedData :
				findByG_U(
					groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByG_U(long groupId, long userId) {
		FinderPath finderPath = _finderPathCountByG_U;

		Object[] finderArgs = new Object[] {groupId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_G_U_GROUPID_2 =
		"disverifiedData.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_USERID_2 =
		"disverifiedData.userId = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if ((groupId != disverifiedData.getGroupId()) ||
						(status != disverifiedData.getStatus())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByG_S_First(
			long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByG_S_Last(
			long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByG_S_PrevAndNext(
			long disverifiedDataId, long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, disverifiedData, groupId, status, orderByComparator,
				true);

			array[1] = disverifiedData;

			array[2] = getByG_S_PrevAndNext(
				session, disverifiedData, groupId, status, orderByComparator,
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

	protected DisverifiedData getByG_S_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long groupId,
		int status, OrderByComparator<DisverifiedData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (DisverifiedData disverifiedData :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"disverifiedData.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"disverifiedData.status = ?";

	private FinderPath _finderPathWithPaginationFindByU_S;
	private FinderPath _finderPathWithoutPaginationFindByU_S;
	private FinderPath _finderPathCountByU_S;

	/**
	 * Returns all the disverified datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByU_S(long userId, int status) {
		return findByU_S(
			userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByU_S(
		long userId, int status, int start, int end) {

		return findByU_S(userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByU_S(userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByU_S;
				finderArgs = new Object[] {userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByU_S;
			finderArgs = new Object[] {
				userId, status, start, end, orderByComparator
			};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if ((userId != disverifiedData.getUserId()) ||
						(status != disverifiedData.getStatus())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByU_S_First(
			long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByU_S_First(
			userId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByU_S_First(
		long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByU_S(
			userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByU_S_Last(
			long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByU_S_Last(
			userId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByU_S(userId, status);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByU_S(
			userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByU_S_PrevAndNext(
			long disverifiedDataId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByU_S_PrevAndNext(
				session, disverifiedData, userId, status, orderByComparator,
				true);

			array[1] = disverifiedData;

			array[2] = getByU_S_PrevAndNext(
				session, disverifiedData, userId, status, orderByComparator,
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

	protected DisverifiedData getByU_S_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long userId,
		int status, OrderByComparator<DisverifiedData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_U_S_STATUS_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByU_S(long userId, int status) {
		for (DisverifiedData disverifiedData :
				findByU_S(
					userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByU_S(long userId, int status) {
		FinderPath finderPath = _finderPathCountByU_S;

		Object[] finderArgs = new Object[] {userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_U_S_USERID_2 =
		"disverifiedData.userId = ? AND ";

	private static final String _FINDER_COLUMN_U_S_STATUS_2 =
		"disverifiedData.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_U_S;
	private FinderPath _finderPathWithoutPaginationFindByG_U_S;
	private FinderPath _finderPathCountByG_U_S;

	/**
	 * Returns all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status) {

		return findByG_U_S(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return findByG_U_S(groupId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByG_U_S(
			groupId, userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_U_S;
				finderArgs = new Object[] {groupId, userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_U_S;
			finderArgs = new Object[] {
				groupId, userId, status, start, end, orderByComparator
			};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if ((groupId != disverifiedData.getGroupId()) ||
						(userId != disverifiedData.getUserId()) ||
						(status != disverifiedData.getStatus())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByG_U_S(
			groupId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByG_U_S(groupId, userId, status);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByG_U_S(
			groupId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByG_U_S_PrevAndNext(
			long disverifiedDataId, long groupId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByG_U_S_PrevAndNext(
				session, disverifiedData, groupId, userId, status,
				orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByG_U_S_PrevAndNext(
				session, disverifiedData, groupId, userId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByG_U_S_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long groupId,
		long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByG_U_S(long groupId, long userId, int status) {
		for (DisverifiedData disverifiedData :
				findByG_U_S(
					groupId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByG_U_S(long groupId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByG_U_S;

		Object[] finderArgs = new Object[] {groupId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_G_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_G_U_S_GROUPID_2 =
		"disverifiedData.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_USERID_2 =
		"disverifiedData.userId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_S_STATUS_2 =
		"disverifiedData.status = ?";

	private FinderPath _finderPathWithPaginationFindByDataSetId;
	private FinderPath _finderPathWithoutPaginationFindByDataSetId;
	private FinderPath _finderPathCountByDataSetId;

	/**
	 * Returns all the disverified datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataSetId(long dataSetId) {
		return findByDataSetId(
			dataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataSetId(
		long dataSetId, int start, int end) {

		return findByDataSetId(dataSetId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByDataSetId(dataSetId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
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

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if (dataSetId != disverifiedData.getDataSetId()) {
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

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATASETID_DATASETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataSetId);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataSetId_First(
			long dataSetId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataSetId_First(
			dataSetId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataSetId=");
		sb.append(dataSetId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataSetId_First(
		long dataSetId, OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByDataSetId(
			dataSetId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataSetId_Last(
			long dataSetId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataSetId_Last(
			dataSetId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataSetId=");
		sb.append(dataSetId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataSetId_Last(
		long dataSetId, OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByDataSetId(dataSetId);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByDataSetId(
			dataSetId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataSetId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByDataSetId_PrevAndNext(
			long disverifiedDataId, long dataSetId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByDataSetId_PrevAndNext(
				session, disverifiedData, dataSetId, orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByDataSetId_PrevAndNext(
				session, disverifiedData, dataSetId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByDataSetId_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long dataSetId,
		OrderByComparator<DisverifiedData> orderByComparator,
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

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
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
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	@Override
	public void removeByDataSetId(long dataSetId) {
		for (DisverifiedData disverifiedData :
				findByDataSetId(
					dataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByDataSetId(long dataSetId) {
		FinderPath finderPath = _finderPathCountByDataSetId;

		Object[] finderArgs = new Object[] {dataSetId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

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
		"disverifiedData.dataSetId = ?";

	private FinderPath _finderPathWithPaginationFindByFolderId;
	private FinderPath _finderPathWithoutPaginationFindByFolderId;
	private FinderPath _finderPathCountByFolderId;

	/**
	 * Returns all the disverified datas where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByFolderId(long folderId) {
		return findByFolderId(
			folderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param folderId the folder ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByFolderId(
		long folderId, int start, int end) {

		return findByFolderId(folderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param folderId the folder ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByFolderId(
		long folderId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByFolderId(folderId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param folderId the folder ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByFolderId(
		long folderId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFolderId;
				finderArgs = new Object[] {folderId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFolderId;
			finderArgs = new Object[] {folderId, start, end, orderByComparator};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if (folderId != disverifiedData.getFolderId()) {
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

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_FOLDERID_FOLDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(folderId);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByFolderId_First(
			long folderId, OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByFolderId_First(
			folderId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("folderId=");
		sb.append(folderId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByFolderId_First(
		long folderId, OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByFolderId(
			folderId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByFolderId_Last(
			long folderId, OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByFolderId_Last(
			folderId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("folderId=");
		sb.append(folderId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByFolderId_Last(
		long folderId, OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByFolderId(folderId);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByFolderId(
			folderId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where folderId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByFolderId_PrevAndNext(
			long disverifiedDataId, long folderId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByFolderId_PrevAndNext(
				session, disverifiedData, folderId, orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByFolderId_PrevAndNext(
				session, disverifiedData, folderId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByFolderId_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long folderId,
		OrderByComparator<DisverifiedData> orderByComparator,
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

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_FOLDERID_FOLDERID_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(folderId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where folderId = &#63; from the database.
	 *
	 * @param folderId the folder ID
	 */
	@Override
	public void removeByFolderId(long folderId) {
		for (DisverifiedData disverifiedData :
				findByFolderId(
					folderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where folderId = &#63;.
	 *
	 * @param folderId the folder ID
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByFolderId(long folderId) {
		FinderPath finderPath = _finderPathCountByFolderId;

		Object[] finderArgs = new Object[] {folderId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_FOLDERID_FOLDERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(folderId);

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

	private static final String _FINDER_COLUMN_FOLDERID_FOLDERID_2 =
		"disverifiedData.folderId = ?";

	private FinderPath _finderPathWithPaginationFindByDataTypeId;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId;
	private FinderPath _finderPathCountByDataTypeId;

	/**
	 * Returns all the disverified datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId(long dataTypeId) {
		return findByDataTypeId(
			dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return findByDataTypeId(dataTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByDataTypeId(
			dataTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
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

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if (dataTypeId != disverifiedData.getDataTypeId()) {
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

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_First(
			long dataTypeId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_First(
			dataTypeId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_First(
		long dataTypeId, OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByDataTypeId(
			dataTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_Last(
			long dataTypeId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_Last(
		long dataTypeId, OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByDataTypeId(dataTypeId);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByDataTypeId(
			dataTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByDataTypeId_PrevAndNext(
			long disverifiedDataId, long dataTypeId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByDataTypeId_PrevAndNext(
				session, disverifiedData, dataTypeId, orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByDataTypeId_PrevAndNext(
				session, disverifiedData, dataTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByDataTypeId_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long dataTypeId,
		OrderByComparator<DisverifiedData> orderByComparator,
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

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
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
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	@Override
	public void removeByDataTypeId(long dataTypeId) {
		for (DisverifiedData disverifiedData :
				findByDataTypeId(
					dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByDataTypeId(long dataTypeId) {
		FinderPath finderPath = _finderPathCountByDataTypeId;

		Object[] finderArgs = new Object[] {dataTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

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
		"disverifiedData.dataTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByDataTypeId_G;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId_G;
	private FinderPath _finderPathCountByDataTypeId_G;

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId) {

		return findByDataTypeId_G(
			dataTypeId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end) {

		return findByDataTypeId_G(dataTypeId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByDataTypeId_G(
			dataTypeId, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G(
		long dataTypeId, long groupId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataTypeId_G;
				finderArgs = new Object[] {dataTypeId, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataTypeId_G;
			finderArgs = new Object[] {
				dataTypeId, groupId, start, end, orderByComparator
			};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if ((dataTypeId != disverifiedData.getDataTypeId()) ||
						(groupId != disverifiedData.getGroupId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(groupId);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_G_First(
			long dataTypeId, long groupId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_G_First(
			dataTypeId, groupId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_G_First(
		long dataTypeId, long groupId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByDataTypeId_G(
			dataTypeId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_G_Last(
			long dataTypeId, long groupId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_G_Last(
			dataTypeId, groupId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_G_Last(
		long dataTypeId, long groupId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByDataTypeId_G(dataTypeId, groupId);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByDataTypeId_G(
			dataTypeId, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByDataTypeId_G_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByDataTypeId_G_PrevAndNext(
				session, disverifiedData, dataTypeId, groupId,
				orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByDataTypeId_G_PrevAndNext(
				session, disverifiedData, dataTypeId, groupId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByDataTypeId_G_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long dataTypeId,
		long groupId, OrderByComparator<DisverifiedData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_DATATYPEID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_GROUPID_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByDataTypeId_G(long dataTypeId, long groupId) {
		for (DisverifiedData disverifiedData :
				findByDataTypeId_G(
					dataTypeId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByDataTypeId_G(long dataTypeId, long groupId) {
		FinderPath finderPath = _finderPathCountByDataTypeId_G;

		Object[] finderArgs = new Object[] {dataTypeId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_DATATYPEID_G_DATATYPEID_2 =
		"disverifiedData.dataTypeId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_G_GROUPID_2 =
		"disverifiedData.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByDataTypeId_U;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId_U;
	private FinderPath _finderPathCountByDataTypeId_U;

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId) {

		return findByDataTypeId_U(
			dataTypeId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end) {

		return findByDataTypeId_U(dataTypeId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByDataTypeId_U(
			dataTypeId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_U(
		long dataTypeId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataTypeId_U;
				finderArgs = new Object[] {dataTypeId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataTypeId_U;
			finderArgs = new Object[] {
				dataTypeId, userId, start, end, orderByComparator
			};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if ((dataTypeId != disverifiedData.getDataTypeId()) ||
						(userId != disverifiedData.getUserId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_U_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(userId);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_U_First(
			long dataTypeId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_U_First(
			dataTypeId, userId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_U_First(
		long dataTypeId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByDataTypeId_U(
			dataTypeId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_U_Last(
			long dataTypeId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_U_Last(
			dataTypeId, userId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_U_Last(
		long dataTypeId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByDataTypeId_U(dataTypeId, userId);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByDataTypeId_U(
			dataTypeId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByDataTypeId_U_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByDataTypeId_U_PrevAndNext(
				session, disverifiedData, dataTypeId, userId, orderByComparator,
				true);

			array[1] = disverifiedData;

			array[2] = getByDataTypeId_U_PrevAndNext(
				session, disverifiedData, dataTypeId, userId, orderByComparator,
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

	protected DisverifiedData getByDataTypeId_U_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long dataTypeId,
		long userId, OrderByComparator<DisverifiedData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_DATATYPEID_U_DATATYPEID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_U_USERID_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByDataTypeId_U(long dataTypeId, long userId) {
		for (DisverifiedData disverifiedData :
				findByDataTypeId_U(
					dataTypeId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByDataTypeId_U(long dataTypeId, long userId) {
		FinderPath finderPath = _finderPathCountByDataTypeId_U;

		Object[] finderArgs = new Object[] {dataTypeId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_U_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_U_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_DATATYPEID_U_DATATYPEID_2 =
		"disverifiedData.dataTypeId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_U_USERID_2 =
		"disverifiedData.userId = ?";

	private FinderPath _finderPathWithPaginationFindByDataTypeId_S;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId_S;
	private FinderPath _finderPathCountByDataTypeId_S;

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status) {

		return findByDataTypeId_S(
			dataTypeId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end) {

		return findByDataTypeId_S(dataTypeId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByDataTypeId_S(
			dataTypeId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_S(
		long dataTypeId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataTypeId_S;
				finderArgs = new Object[] {dataTypeId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataTypeId_S;
			finderArgs = new Object[] {
				dataTypeId, status, start, end, orderByComparator
			};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if ((dataTypeId != disverifiedData.getDataTypeId()) ||
						(status != disverifiedData.getStatus())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_S_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(status);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_S_First(
			long dataTypeId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_S_First(
			dataTypeId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_S_First(
		long dataTypeId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByDataTypeId_S(
			dataTypeId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_S_Last(
			long dataTypeId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_S_Last(
			dataTypeId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_S_Last(
		long dataTypeId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByDataTypeId_S(dataTypeId, status);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByDataTypeId_S(
			dataTypeId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByDataTypeId_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByDataTypeId_S_PrevAndNext(
				session, disverifiedData, dataTypeId, status, orderByComparator,
				true);

			array[1] = disverifiedData;

			array[2] = getByDataTypeId_S_PrevAndNext(
				session, disverifiedData, dataTypeId, status, orderByComparator,
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

	protected DisverifiedData getByDataTypeId_S_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long dataTypeId,
		int status, OrderByComparator<DisverifiedData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_DATATYPEID_S_DATATYPEID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_S_STATUS_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 */
	@Override
	public void removeByDataTypeId_S(long dataTypeId, int status) {
		for (DisverifiedData disverifiedData :
				findByDataTypeId_S(
					dataTypeId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByDataTypeId_S(long dataTypeId, int status) {
		FinderPath finderPath = _finderPathCountByDataTypeId_S;

		Object[] finderArgs = new Object[] {dataTypeId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_S_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_DATATYPEID_S_DATATYPEID_2 =
		"disverifiedData.dataTypeId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_S_STATUS_2 =
		"disverifiedData.status = ?";

	private FinderPath _finderPathWithPaginationFindByDataTypeId_G_U;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId_G_U;
	private FinderPath _finderPathCountByDataTypeId_G_U;

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId) {

		return findByDataTypeId_G_U(
			dataTypeId, groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end) {

		return findByDataTypeId_G_U(
			dataTypeId, groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByDataTypeId_G_U(
			dataTypeId, groupId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataTypeId_G_U;
				finderArgs = new Object[] {dataTypeId, groupId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataTypeId_G_U;
			finderArgs = new Object[] {
				dataTypeId, groupId, userId, start, end, orderByComparator
			};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if ((dataTypeId != disverifiedData.getDataTypeId()) ||
						(groupId != disverifiedData.getGroupId()) ||
						(userId != disverifiedData.getUserId())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_G_U_First(
			long dataTypeId, long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_G_U_First(
			dataTypeId, groupId, userId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_G_U_First(
		long dataTypeId, long groupId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByDataTypeId_G_U(
			dataTypeId, groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_G_U_Last(
			long dataTypeId, long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_G_U_Last(
			dataTypeId, groupId, userId, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_G_U_Last(
		long dataTypeId, long groupId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByDataTypeId_G_U(dataTypeId, groupId, userId);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByDataTypeId_G_U(
			dataTypeId, groupId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByDataTypeId_G_U_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId, long userId,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByDataTypeId_G_U_PrevAndNext(
				session, disverifiedData, dataTypeId, groupId, userId,
				orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByDataTypeId_G_U_PrevAndNext(
				session, disverifiedData, dataTypeId, groupId, userId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByDataTypeId_G_U_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long dataTypeId,
		long groupId, long userId,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_U_DATATYPEID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_U_USERID_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId) {

		for (DisverifiedData disverifiedData :
				findByDataTypeId_G_U(
					dataTypeId, groupId, userId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByDataTypeId_G_U(
		long dataTypeId, long groupId, long userId) {

		FinderPath finderPath = _finderPathCountByDataTypeId_G_U;

		Object[] finderArgs = new Object[] {dataTypeId, groupId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(groupId);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_DATATYPEID_G_U_DATATYPEID_2 =
		"disverifiedData.dataTypeId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_G_U_GROUPID_2 =
		"disverifiedData.groupId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_G_U_USERID_2 =
		"disverifiedData.userId = ?";

	private FinderPath _finderPathWithPaginationFindByDataTypeId_G_S;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId_G_S;
	private FinderPath _finderPathCountByDataTypeId_G_S;

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status) {

		return findByDataTypeId_G_S(
			dataTypeId, groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end) {

		return findByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_S(
		long dataTypeId, long groupId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataTypeId_G_S;
				finderArgs = new Object[] {dataTypeId, groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataTypeId_G_S;
			finderArgs = new Object[] {
				dataTypeId, groupId, status, start, end, orderByComparator
			};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if ((dataTypeId != disverifiedData.getDataTypeId()) ||
						(groupId != disverifiedData.getGroupId()) ||
						(status != disverifiedData.getStatus())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_S_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_G_S_First(
			long dataTypeId, long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_G_S_First(
			dataTypeId, groupId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_G_S_First(
		long dataTypeId, long groupId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByDataTypeId_G_S(
			dataTypeId, groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_G_S_Last(
			long dataTypeId, long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_G_S_Last(
			dataTypeId, groupId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_G_S_Last(
		long dataTypeId, long groupId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByDataTypeId_G_S(dataTypeId, groupId, status);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByDataTypeId_G_S(
			dataTypeId, groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByDataTypeId_G_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByDataTypeId_G_S_PrevAndNext(
				session, disverifiedData, dataTypeId, groupId, status,
				orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByDataTypeId_G_S_PrevAndNext(
				session, disverifiedData, dataTypeId, groupId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByDataTypeId_G_S_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long dataTypeId,
		long groupId, int status,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_S_DATATYPEID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_S_STATUS_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByDataTypeId_G_S(
		long dataTypeId, long groupId, int status) {

		for (DisverifiedData disverifiedData :
				findByDataTypeId_G_S(
					dataTypeId, groupId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByDataTypeId_G_S(
		long dataTypeId, long groupId, int status) {

		FinderPath finderPath = _finderPathCountByDataTypeId_G_S;

		Object[] finderArgs = new Object[] {dataTypeId, groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_S_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(groupId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_DATATYPEID_G_S_DATATYPEID_2 =
		"disverifiedData.dataTypeId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_G_S_GROUPID_2 =
		"disverifiedData.groupId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_G_S_STATUS_2 =
		"disverifiedData.status = ?";

	private FinderPath _finderPathWithPaginationFindByDataTypeId_U_S;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId_U_S;
	private FinderPath _finderPathCountByDataTypeId_U_S;

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status) {

		return findByDataTypeId_U_S(
			dataTypeId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end) {

		return findByDataTypeId_U_S(
			dataTypeId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findByDataTypeId_U_S(
			dataTypeId, userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_U_S(
		long dataTypeId, long userId, int status, int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataTypeId_U_S;
				finderArgs = new Object[] {dataTypeId, userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataTypeId_U_S;
			finderArgs = new Object[] {
				dataTypeId, userId, status, start, end, orderByComparator
			};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if ((dataTypeId != disverifiedData.getDataTypeId()) ||
						(userId != disverifiedData.getUserId()) ||
						(status != disverifiedData.getStatus())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_U_S_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_U_S_First(
			long dataTypeId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_U_S_First(
			dataTypeId, userId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_U_S_First(
		long dataTypeId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByDataTypeId_U_S(
			dataTypeId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_U_S_Last(
			long dataTypeId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_U_S_Last(
			dataTypeId, userId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_U_S_Last(
		long dataTypeId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByDataTypeId_U_S(dataTypeId, userId, status);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByDataTypeId_U_S(
			dataTypeId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByDataTypeId_U_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByDataTypeId_U_S_PrevAndNext(
				session, disverifiedData, dataTypeId, userId, status,
				orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByDataTypeId_U_S_PrevAndNext(
				session, disverifiedData, dataTypeId, userId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByDataTypeId_U_S_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long dataTypeId,
		long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_DATATYPEID_U_S_DATATYPEID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_U_S_STATUS_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByDataTypeId_U_S(
		long dataTypeId, long userId, int status) {

		for (DisverifiedData disverifiedData :
				findByDataTypeId_U_S(
					dataTypeId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByDataTypeId_U_S(long dataTypeId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByDataTypeId_U_S;

		Object[] finderArgs = new Object[] {dataTypeId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_U_S_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(userId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_DATATYPEID_U_S_DATATYPEID_2 =
		"disverifiedData.dataTypeId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_U_S_USERID_2 =
		"disverifiedData.userId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_U_S_STATUS_2 =
		"disverifiedData.status = ?";

	private FinderPath _finderPathWithPaginationFindByDataTypeId_G_U_S;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId_G_U_S;
	private FinderPath _finderPathCountByDataTypeId_G_U_S;

	/**
	 * Returns all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status) {

		return findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end) {

		return findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<DisverifiedData> orderByComparator) {

		return findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching disverified datas
	 */
	@Override
	public List<DisverifiedData> findByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status, int start,
		int end, OrderByComparator<DisverifiedData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataTypeId_G_U_S;
				finderArgs = new Object[] {dataTypeId, groupId, userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataTypeId_G_U_S;
			finderArgs = new Object[] {
				dataTypeId, groupId, userId, status, start, end,
				orderByComparator
			};
		}

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DisverifiedData disverifiedData : list) {
					if ((dataTypeId != disverifiedData.getDataTypeId()) ||
						(groupId != disverifiedData.getGroupId()) ||
						(userId != disverifiedData.getUserId()) ||
						(status != disverifiedData.getStatus())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_G_U_S_First(
			long dataTypeId, long groupId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_G_U_S_First(
			dataTypeId, groupId, userId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the first disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_G_U_S_First(
		long dataTypeId, long groupId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		List<DisverifiedData> list = findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data
	 * @throws NoSuchDisverifiedDataException if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData findByDataTypeId_G_U_S_Last(
			long dataTypeId, long groupId, long userId, int status,
			OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByDataTypeId_G_U_S_Last(
			dataTypeId, groupId, userId, status, orderByComparator);

		if (disverifiedData != null) {
			return disverifiedData;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDisverifiedDataException(sb.toString());
	}

	/**
	 * Returns the last disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching disverified data, or <code>null</code> if a matching disverified data could not be found
	 */
	@Override
	public DisverifiedData fetchByDataTypeId_G_U_S_Last(
		long dataTypeId, long groupId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator) {

		int count = countByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status);

		if (count == 0) {
			return null;
		}

		List<DisverifiedData> list = findByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the disverified datas before and after the current disverified data in the ordered set where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param disverifiedDataId the primary key of the current disverified data
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData[] findByDataTypeId_G_U_S_PrevAndNext(
			long disverifiedDataId, long dataTypeId, long groupId, long userId,
			int status, OrderByComparator<DisverifiedData> orderByComparator)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = findByPrimaryKey(disverifiedDataId);

		Session session = null;

		try {
			session = openSession();

			DisverifiedData[] array = new DisverifiedDataImpl[3];

			array[0] = getByDataTypeId_G_U_S_PrevAndNext(
				session, disverifiedData, dataTypeId, groupId, userId, status,
				orderByComparator, true);

			array[1] = disverifiedData;

			array[2] = getByDataTypeId_G_U_S_PrevAndNext(
				session, disverifiedData, dataTypeId, groupId, userId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DisverifiedData getByDataTypeId_G_U_S_PrevAndNext(
		Session session, DisverifiedData disverifiedData, long dataTypeId,
		long groupId, long userId, int status,
		OrderByComparator<DisverifiedData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_DISVERIFIEDDATA_WHERE);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_DATATYPEID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_USERID_2);

		sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_STATUS_2);

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
			sb.append(DisverifiedDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						disverifiedData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DisverifiedData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status) {

		for (DisverifiedData disverifiedData :
				findByDataTypeId_G_U_S(
					dataTypeId, groupId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas where dataTypeId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching disverified datas
	 */
	@Override
	public int countByDataTypeId_G_U_S(
		long dataTypeId, long groupId, long userId, int status) {

		FinderPath finderPath = _finderPathCountByDataTypeId_G_U_S;

		Object[] finderArgs = new Object[] {
			dataTypeId, groupId, userId, status
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_DISVERIFIEDDATA_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_DATATYPEID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_USERID_2);

			sb.append(_FINDER_COLUMN_DATATYPEID_G_U_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_DATATYPEID_G_U_S_DATATYPEID_2 =
		"disverifiedData.dataTypeId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_G_U_S_GROUPID_2 =
		"disverifiedData.groupId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_G_U_S_USERID_2 =
		"disverifiedData.userId = ? AND ";

	private static final String _FINDER_COLUMN_DATATYPEID_G_U_S_STATUS_2 =
		"disverifiedData.status = ?";

	public DisverifiedDataPersistenceImpl() {
		setModelClass(DisverifiedData.class);

		setModelImplClass(DisverifiedDataImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the disverified data in the entity cache if it is enabled.
	 *
	 * @param disverifiedData the disverified data
	 */
	@Override
	public void cacheResult(DisverifiedData disverifiedData) {
		entityCache.putResult(
			entityCacheEnabled, DisverifiedDataImpl.class,
			disverifiedData.getPrimaryKey(), disverifiedData);

		disverifiedData.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the disverified datas in the entity cache if it is enabled.
	 *
	 * @param disverifiedDatas the disverified datas
	 */
	@Override
	public void cacheResult(List<DisverifiedData> disverifiedDatas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (disverifiedDatas.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DisverifiedData disverifiedData : disverifiedDatas) {
			if (entityCache.getResult(
					entityCacheEnabled, DisverifiedDataImpl.class,
					disverifiedData.getPrimaryKey()) == null) {

				cacheResult(disverifiedData);
			}
			else {
				disverifiedData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all disverified datas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DisverifiedDataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the disverified data.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DisverifiedData disverifiedData) {
		entityCache.removeResult(
			entityCacheEnabled, DisverifiedDataImpl.class,
			disverifiedData.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DisverifiedData> disverifiedDatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DisverifiedData disverifiedData : disverifiedDatas) {
			entityCache.removeResult(
				entityCacheEnabled, DisverifiedDataImpl.class,
				disverifiedData.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, DisverifiedDataImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new disverified data with the primary key. Does not add the disverified data to the database.
	 *
	 * @param disverifiedDataId the primary key for the new disverified data
	 * @return the new disverified data
	 */
	@Override
	public DisverifiedData create(long disverifiedDataId) {
		DisverifiedData disverifiedData = new DisverifiedDataImpl();

		disverifiedData.setNew(true);
		disverifiedData.setPrimaryKey(disverifiedDataId);

		disverifiedData.setCompanyId(CompanyThreadLocal.getCompanyId());

		return disverifiedData;
	}

	/**
	 * Removes the disverified data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param disverifiedDataId the primary key of the disverified data
	 * @return the disverified data that was removed
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData remove(long disverifiedDataId)
		throws NoSuchDisverifiedDataException {

		return remove((Serializable)disverifiedDataId);
	}

	/**
	 * Removes the disverified data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the disverified data
	 * @return the disverified data that was removed
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData remove(Serializable primaryKey)
		throws NoSuchDisverifiedDataException {

		Session session = null;

		try {
			session = openSession();

			DisverifiedData disverifiedData = (DisverifiedData)session.get(
				DisverifiedDataImpl.class, primaryKey);

			if (disverifiedData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDisverifiedDataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(disverifiedData);
		}
		catch (NoSuchDisverifiedDataException noSuchEntityException) {
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
	protected DisverifiedData removeImpl(DisverifiedData disverifiedData) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(disverifiedData)) {
				disverifiedData = (DisverifiedData)session.get(
					DisverifiedDataImpl.class,
					disverifiedData.getPrimaryKeyObj());
			}

			if (disverifiedData != null) {
				session.delete(disverifiedData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (disverifiedData != null) {
			clearCache(disverifiedData);
		}

		return disverifiedData;
	}

	@Override
	public DisverifiedData updateImpl(DisverifiedData disverifiedData) {
		boolean isNew = disverifiedData.isNew();

		if (!(disverifiedData instanceof DisverifiedDataModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(disverifiedData.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					disverifiedData);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in disverifiedData proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DisverifiedData implementation " +
					disverifiedData.getClass());
		}

		DisverifiedDataModelImpl disverifiedDataModelImpl =
			(DisverifiedDataModelImpl)disverifiedData;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (disverifiedData.getCreateDate() == null)) {
			if (serviceContext == null) {
				disverifiedData.setCreateDate(date);
			}
			else {
				disverifiedData.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!disverifiedDataModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				disverifiedData.setModifiedDate(date);
			}
			else {
				disverifiedData.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(disverifiedData);

				disverifiedData.setNew(false);
			}
			else {
				disverifiedData = (DisverifiedData)session.merge(
					disverifiedData);
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
				disverifiedDataModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {disverifiedDataModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {disverifiedDataModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			args = new Object[] {
				disverifiedDataModelImpl.getGroupId(),
				disverifiedDataModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByG_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_U, args);

			args = new Object[] {
				disverifiedDataModelImpl.getGroupId(),
				disverifiedDataModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_S, args);

			args = new Object[] {
				disverifiedDataModelImpl.getUserId(),
				disverifiedDataModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByU_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByU_S, args);

			args = new Object[] {
				disverifiedDataModelImpl.getGroupId(),
				disverifiedDataModelImpl.getUserId(),
				disverifiedDataModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_U_S, args);

			args = new Object[] {disverifiedDataModelImpl.getDataSetId()};

			finderCache.removeResult(_finderPathCountByDataSetId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataSetId, args);

			args = new Object[] {disverifiedDataModelImpl.getFolderId()};

			finderCache.removeResult(_finderPathCountByFolderId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFolderId, args);

			args = new Object[] {disverifiedDataModelImpl.getDataTypeId()};

			finderCache.removeResult(_finderPathCountByDataTypeId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId, args);

			args = new Object[] {
				disverifiedDataModelImpl.getDataTypeId(),
				disverifiedDataModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId_G, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId_G, args);

			args = new Object[] {
				disverifiedDataModelImpl.getDataTypeId(),
				disverifiedDataModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId_U, args);

			args = new Object[] {
				disverifiedDataModelImpl.getDataTypeId(),
				disverifiedDataModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId_S, args);

			args = new Object[] {
				disverifiedDataModelImpl.getDataTypeId(),
				disverifiedDataModelImpl.getGroupId(),
				disverifiedDataModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId_G_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId_G_U, args);

			args = new Object[] {
				disverifiedDataModelImpl.getDataTypeId(),
				disverifiedDataModelImpl.getGroupId(),
				disverifiedDataModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId_G_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId_G_S, args);

			args = new Object[] {
				disverifiedDataModelImpl.getDataTypeId(),
				disverifiedDataModelImpl.getUserId(),
				disverifiedDataModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId_U_S, args);

			args = new Object[] {
				disverifiedDataModelImpl.getDataTypeId(),
				disverifiedDataModelImpl.getGroupId(),
				disverifiedDataModelImpl.getUserId(),
				disverifiedDataModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId_G_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId_G_U_S, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {disverifiedDataModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {disverifiedDataModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {disverifiedDataModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_U.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalGroupId(),
					disverifiedDataModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByG_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U, args);

				args = new Object[] {
					disverifiedDataModelImpl.getGroupId(),
					disverifiedDataModelImpl.getUserId()
				};

				finderCache.removeResult(_finderPathCountByG_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalGroupId(),
					disverifiedDataModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);

				args = new Object[] {
					disverifiedDataModelImpl.getGroupId(),
					disverifiedDataModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_S, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByU_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalUserId(),
					disverifiedDataModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByU_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_S, args);

				args = new Object[] {
					disverifiedDataModelImpl.getUserId(),
					disverifiedDataModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByU_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_S, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_U_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalGroupId(),
					disverifiedDataModelImpl.getOriginalUserId(),
					disverifiedDataModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U_S, args);

				args = new Object[] {
					disverifiedDataModelImpl.getGroupId(),
					disverifiedDataModelImpl.getUserId(),
					disverifiedDataModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U_S, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataSetId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalDataSetId()
				};

				finderCache.removeResult(_finderPathCountByDataSetId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSetId, args);

				args = new Object[] {disverifiedDataModelImpl.getDataSetId()};

				finderCache.removeResult(_finderPathCountByDataSetId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataSetId, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFolderId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalFolderId()
				};

				finderCache.removeResult(_finderPathCountByFolderId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFolderId, args);

				args = new Object[] {disverifiedDataModelImpl.getFolderId()};

				finderCache.removeResult(_finderPathCountByFolderId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFolderId, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalDataTypeId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);

				args = new Object[] {disverifiedDataModelImpl.getDataTypeId()};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId_G.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalDataTypeId(),
					disverifiedDataModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_G, args);

				args = new Object[] {
					disverifiedDataModelImpl.getDataTypeId(),
					disverifiedDataModelImpl.getGroupId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_G, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalDataTypeId(),
					disverifiedDataModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_U, args);

				args = new Object[] {
					disverifiedDataModelImpl.getDataTypeId(),
					disverifiedDataModelImpl.getUserId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_U, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalDataTypeId(),
					disverifiedDataModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_S, args);

				args = new Object[] {
					disverifiedDataModelImpl.getDataTypeId(),
					disverifiedDataModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_S, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId_G_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalDataTypeId(),
					disverifiedDataModelImpl.getOriginalGroupId(),
					disverifiedDataModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(
					_finderPathCountByDataTypeId_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_G_U, args);

				args = new Object[] {
					disverifiedDataModelImpl.getDataTypeId(),
					disverifiedDataModelImpl.getGroupId(),
					disverifiedDataModelImpl.getUserId()
				};

				finderCache.removeResult(
					_finderPathCountByDataTypeId_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_G_U, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId_G_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalDataTypeId(),
					disverifiedDataModelImpl.getOriginalGroupId(),
					disverifiedDataModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(
					_finderPathCountByDataTypeId_G_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_G_S, args);

				args = new Object[] {
					disverifiedDataModelImpl.getDataTypeId(),
					disverifiedDataModelImpl.getGroupId(),
					disverifiedDataModelImpl.getStatus()
				};

				finderCache.removeResult(
					_finderPathCountByDataTypeId_G_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_G_S, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId_U_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalDataTypeId(),
					disverifiedDataModelImpl.getOriginalUserId(),
					disverifiedDataModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(
					_finderPathCountByDataTypeId_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_U_S, args);

				args = new Object[] {
					disverifiedDataModelImpl.getDataTypeId(),
					disverifiedDataModelImpl.getUserId(),
					disverifiedDataModelImpl.getStatus()
				};

				finderCache.removeResult(
					_finderPathCountByDataTypeId_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_U_S, args);
			}

			if ((disverifiedDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId_G_U_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					disverifiedDataModelImpl.getOriginalDataTypeId(),
					disverifiedDataModelImpl.getOriginalGroupId(),
					disverifiedDataModelImpl.getOriginalUserId(),
					disverifiedDataModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(
					_finderPathCountByDataTypeId_G_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_G_U_S, args);

				args = new Object[] {
					disverifiedDataModelImpl.getDataTypeId(),
					disverifiedDataModelImpl.getGroupId(),
					disverifiedDataModelImpl.getUserId(),
					disverifiedDataModelImpl.getStatus()
				};

				finderCache.removeResult(
					_finderPathCountByDataTypeId_G_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId_G_U_S, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DisverifiedDataImpl.class,
			disverifiedData.getPrimaryKey(), disverifiedData, false);

		disverifiedData.resetOriginalValues();

		return disverifiedData;
	}

	/**
	 * Returns the disverified data with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the disverified data
	 * @return the disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDisverifiedDataException {

		DisverifiedData disverifiedData = fetchByPrimaryKey(primaryKey);

		if (disverifiedData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDisverifiedDataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return disverifiedData;
	}

	/**
	 * Returns the disverified data with the primary key or throws a <code>NoSuchDisverifiedDataException</code> if it could not be found.
	 *
	 * @param disverifiedDataId the primary key of the disverified data
	 * @return the disverified data
	 * @throws NoSuchDisverifiedDataException if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData findByPrimaryKey(long disverifiedDataId)
		throws NoSuchDisverifiedDataException {

		return findByPrimaryKey((Serializable)disverifiedDataId);
	}

	/**
	 * Returns the disverified data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param disverifiedDataId the primary key of the disverified data
	 * @return the disverified data, or <code>null</code> if a disverified data with the primary key could not be found
	 */
	@Override
	public DisverifiedData fetchByPrimaryKey(long disverifiedDataId) {
		return fetchByPrimaryKey((Serializable)disverifiedDataId);
	}

	/**
	 * Returns all the disverified datas.
	 *
	 * @return the disverified datas
	 */
	@Override
	public List<DisverifiedData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the disverified datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @return the range of disverified datas
	 */
	@Override
	public List<DisverifiedData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the disverified datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of disverified datas
	 */
	@Override
	public List<DisverifiedData> findAll(
		int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the disverified datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DisverifiedDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of disverified datas
	 * @param end the upper bound of the range of disverified datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of disverified datas
	 */
	@Override
	public List<DisverifiedData> findAll(
		int start, int end,
		OrderByComparator<DisverifiedData> orderByComparator,
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

		List<DisverifiedData> list = null;

		if (useFinderCache) {
			list = (List<DisverifiedData>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DISVERIFIEDDATA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DISVERIFIEDDATA;

				sql = sql.concat(DisverifiedDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DisverifiedData>)QueryUtil.list(
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
	 * Removes all the disverified datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DisverifiedData disverifiedData : findAll()) {
			remove(disverifiedData);
		}
	}

	/**
	 * Returns the number of disverified datas.
	 *
	 * @return the number of disverified datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DISVERIFIEDDATA);

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
		return "disverifiedDataId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DISVERIFIEDDATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DisverifiedDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the disverified data persistence.
	 */
	@Activate
	public void activate() {
		DisverifiedDataModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DisverifiedDataModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			DisverifiedDataModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			DisverifiedDataModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()},
			DisverifiedDataModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			DisverifiedDataModelImpl.GROUPID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			DisverifiedDataModelImpl.GROUPID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			DisverifiedDataModelImpl.USERID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByU_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			DisverifiedDataModelImpl.GROUPID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.USERID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByG_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataSetId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataSetId",
			new String[] {Long.class.getName()},
			DisverifiedDataModelImpl.DATASETID_COLUMN_BITMASK);

		_finderPathCountByDataSetId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataSetId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByFolderId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFolderId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFolderId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFolderId",
			new String[] {Long.class.getName()},
			DisverifiedDataModelImpl.FOLDERID_COLUMN_BITMASK);

		_finderPathCountByFolderId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFolderId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId",
			new String[] {Long.class.getName()},
			DisverifiedDataModelImpl.DATATYPEID_COLUMN_BITMASK);

		_finderPathCountByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDataTypeId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId_G",
			new String[] {Long.class.getName(), Long.class.getName()},
			DisverifiedDataModelImpl.DATATYPEID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByDataTypeId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId_G",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByDataTypeId_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			DisverifiedDataModelImpl.DATATYPEID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByDataTypeId_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId_U",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByDataTypeId_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			DisverifiedDataModelImpl.DATATYPEID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByDataTypeId_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByDataTypeId_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			DisverifiedDataModelImpl.DATATYPEID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.GROUPID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByDataTypeId_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByDataTypeId_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			DisverifiedDataModelImpl.DATATYPEID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.GROUPID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByDataTypeId_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByDataTypeId_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			DisverifiedDataModelImpl.DATATYPEID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.USERID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByDataTypeId_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByDataTypeId_G_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId_G_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId_G_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DisverifiedDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId_G_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName()
			},
			DisverifiedDataModelImpl.DATATYPEID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.GROUPID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.USERID_COLUMN_BITMASK |
			DisverifiedDataModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByDataTypeId_G_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataTypeId_G_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName()
			});

		_setDisverifiedDataUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDisverifiedDataUtilPersistence(null);

		entityCache.removeCache(DisverifiedDataImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setDisverifiedDataUtilPersistence(
		DisverifiedDataPersistence disverifiedDataPersistence) {

		try {
			Field field = DisverifiedDataUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, disverifiedDataPersistence);
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
				"value.object.column.bitmask.enabled.com.sx.icecap.model.DisverifiedData"),
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

	private static final String _SQL_SELECT_DISVERIFIEDDATA =
		"SELECT disverifiedData FROM DisverifiedData disverifiedData";

	private static final String _SQL_SELECT_DISVERIFIEDDATA_WHERE =
		"SELECT disverifiedData FROM DisverifiedData disverifiedData WHERE ";

	private static final String _SQL_COUNT_DISVERIFIEDDATA =
		"SELECT COUNT(disverifiedData) FROM DisverifiedData disverifiedData";

	private static final String _SQL_COUNT_DISVERIFIEDDATA_WHERE =
		"SELECT COUNT(disverifiedData) FROM DisverifiedData disverifiedData WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "disverifiedData.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DisverifiedData exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DisverifiedData exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DisverifiedDataPersistenceImpl.class);

}