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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.sx.icecap.exception.NoSuchActionHistoryException;
import com.sx.icecap.model.ActionHistory;
import com.sx.icecap.model.impl.ActionHistoryImpl;
import com.sx.icecap.model.impl.ActionHistoryModelImpl;
import com.sx.icecap.service.persistence.ActionHistoryPersistence;
import com.sx.icecap.service.persistence.ActionHistoryUtil;
import com.sx.icecap.service.persistence.impl.constants.SX_ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the action history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ActionHistoryPersistence.class)
public class ActionHistoryPersistenceImpl
	extends BasePersistenceImpl<ActionHistory>
	implements ActionHistoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ActionHistoryUtil</code> to access the action history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ActionHistoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDataId;
	private FinderPath _finderPathWithoutPaginationFindByDataId;
	private FinderPath _finderPathCountByDataId;

	/**
	 * Returns all the action histories where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the matching action histories
	 */
	@Override
	public List<ActionHistory> findByDataId(long structuredDataId) {
		return findByDataId(
			structuredDataId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the action histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @return the range of matching action histories
	 */
	@Override
	public List<ActionHistory> findByDataId(
		long structuredDataId, int start, int end) {

		return findByDataId(structuredDataId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the action histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching action histories
	 */
	@Override
	public List<ActionHistory> findByDataId(
		long structuredDataId, int start, int end,
		OrderByComparator<ActionHistory> orderByComparator) {

		return findByDataId(
			structuredDataId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the action histories where structuredDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching action histories
	 */
	@Override
	public List<ActionHistory> findByDataId(
		long structuredDataId, int start, int end,
		OrderByComparator<ActionHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataId;
				finderArgs = new Object[] {structuredDataId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataId;
			finderArgs = new Object[] {
				structuredDataId, start, end, orderByComparator
			};
		}

		List<ActionHistory> list = null;

		if (useFinderCache) {
			list = (List<ActionHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActionHistory actionHistory : list) {
					if (structuredDataId !=
							actionHistory.getStructuredDataId()) {

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

			sb.append(_SQL_SELECT_ACTIONHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_DATAID_STRUCTUREDDATAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ActionHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(structuredDataId);

				list = (List<ActionHistory>)QueryUtil.list(
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
	 * Returns the first action history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action history
	 * @throws NoSuchActionHistoryException if a matching action history could not be found
	 */
	@Override
	public ActionHistory findByDataId_First(
			long structuredDataId,
			OrderByComparator<ActionHistory> orderByComparator)
		throws NoSuchActionHistoryException {

		ActionHistory actionHistory = fetchByDataId_First(
			structuredDataId, orderByComparator);

		if (actionHistory != null) {
			return actionHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("structuredDataId=");
		sb.append(structuredDataId);

		sb.append("}");

		throw new NoSuchActionHistoryException(sb.toString());
	}

	/**
	 * Returns the first action history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action history, or <code>null</code> if a matching action history could not be found
	 */
	@Override
	public ActionHistory fetchByDataId_First(
		long structuredDataId,
		OrderByComparator<ActionHistory> orderByComparator) {

		List<ActionHistory> list = findByDataId(
			structuredDataId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last action history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action history
	 * @throws NoSuchActionHistoryException if a matching action history could not be found
	 */
	@Override
	public ActionHistory findByDataId_Last(
			long structuredDataId,
			OrderByComparator<ActionHistory> orderByComparator)
		throws NoSuchActionHistoryException {

		ActionHistory actionHistory = fetchByDataId_Last(
			structuredDataId, orderByComparator);

		if (actionHistory != null) {
			return actionHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("structuredDataId=");
		sb.append(structuredDataId);

		sb.append("}");

		throw new NoSuchActionHistoryException(sb.toString());
	}

	/**
	 * Returns the last action history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action history, or <code>null</code> if a matching action history could not be found
	 */
	@Override
	public ActionHistory fetchByDataId_Last(
		long structuredDataId,
		OrderByComparator<ActionHistory> orderByComparator) {

		int count = countByDataId(structuredDataId);

		if (count == 0) {
			return null;
		}

		List<ActionHistory> list = findByDataId(
			structuredDataId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the action histories before and after the current action history in the ordered set where structuredDataId = &#63;.
	 *
	 * @param actionHistoryId the primary key of the current action history
	 * @param structuredDataId the structured data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next action history
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	@Override
	public ActionHistory[] findByDataId_PrevAndNext(
			long actionHistoryId, long structuredDataId,
			OrderByComparator<ActionHistory> orderByComparator)
		throws NoSuchActionHistoryException {

		ActionHistory actionHistory = findByPrimaryKey(actionHistoryId);

		Session session = null;

		try {
			session = openSession();

			ActionHistory[] array = new ActionHistoryImpl[3];

			array[0] = getByDataId_PrevAndNext(
				session, actionHistory, structuredDataId, orderByComparator,
				true);

			array[1] = actionHistory;

			array[2] = getByDataId_PrevAndNext(
				session, actionHistory, structuredDataId, orderByComparator,
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

	protected ActionHistory getByDataId_PrevAndNext(
		Session session, ActionHistory actionHistory, long structuredDataId,
		OrderByComparator<ActionHistory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACTIONHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_DATAID_STRUCTUREDDATAID_2);

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
			sb.append(ActionHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(structuredDataId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						actionHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActionHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the action histories where structuredDataId = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 */
	@Override
	public void removeByDataId(long structuredDataId) {
		for (ActionHistory actionHistory :
				findByDataId(
					structuredDataId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(actionHistory);
		}
	}

	/**
	 * Returns the number of action histories where structuredDataId = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @return the number of matching action histories
	 */
	@Override
	public int countByDataId(long structuredDataId) {
		FinderPath finderPath = _finderPathCountByDataId;

		Object[] finderArgs = new Object[] {structuredDataId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTIONHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_DATAID_STRUCTUREDDATAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(structuredDataId);

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

	private static final String _FINDER_COLUMN_DATAID_STRUCTUREDDATAID_2 =
		"actionHistory.structuredDataId = ?";

	private FinderPath _finderPathFetchByParamName;
	private FinderPath _finderPathCountByParamName;

	/**
	 * Returns the action history where structuredDataId = &#63; and paramName = &#63; or throws a <code>NoSuchActionHistoryException</code> if it could not be found.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @return the matching action history
	 * @throws NoSuchActionHistoryException if a matching action history could not be found
	 */
	@Override
	public ActionHistory findByParamName(
			long structuredDataId, String paramName)
		throws NoSuchActionHistoryException {

		ActionHistory actionHistory = fetchByParamName(
			structuredDataId, paramName);

		if (actionHistory == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("structuredDataId=");
			sb.append(structuredDataId);

			sb.append(", paramName=");
			sb.append(paramName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchActionHistoryException(sb.toString());
		}

		return actionHistory;
	}

	/**
	 * Returns the action history where structuredDataId = &#63; and paramName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @return the matching action history, or <code>null</code> if a matching action history could not be found
	 */
	@Override
	public ActionHistory fetchByParamName(
		long structuredDataId, String paramName) {

		return fetchByParamName(structuredDataId, paramName, true);
	}

	/**
	 * Returns the action history where structuredDataId = &#63; and paramName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching action history, or <code>null</code> if a matching action history could not be found
	 */
	@Override
	public ActionHistory fetchByParamName(
		long structuredDataId, String paramName, boolean useFinderCache) {

		paramName = Objects.toString(paramName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {structuredDataId, paramName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByParamName, finderArgs, this);
		}

		if (result instanceof ActionHistory) {
			ActionHistory actionHistory = (ActionHistory)result;

			if ((structuredDataId != actionHistory.getStructuredDataId()) ||
				!Objects.equals(paramName, actionHistory.getParamName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ACTIONHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_PARAMNAME_STRUCTUREDDATAID_2);

			boolean bindParamName = false;

			if (paramName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARAMNAME_PARAMNAME_3);
			}
			else {
				bindParamName = true;

				sb.append(_FINDER_COLUMN_PARAMNAME_PARAMNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(structuredDataId);

				if (bindParamName) {
					queryPos.add(paramName);
				}

				List<ActionHistory> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByParamName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									structuredDataId, paramName
								};
							}

							_log.warn(
								"ActionHistoryPersistenceImpl.fetchByParamName(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ActionHistory actionHistory = list.get(0);

					result = actionHistory;

					cacheResult(actionHistory);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByParamName, finderArgs);
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
			return (ActionHistory)result;
		}
	}

	/**
	 * Removes the action history where structuredDataId = &#63; and paramName = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @return the action history that was removed
	 */
	@Override
	public ActionHistory removeByParamName(
			long structuredDataId, String paramName)
		throws NoSuchActionHistoryException {

		ActionHistory actionHistory = findByParamName(
			structuredDataId, paramName);

		return remove(actionHistory);
	}

	/**
	 * Returns the number of action histories where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @return the number of matching action histories
	 */
	@Override
	public int countByParamName(long structuredDataId, String paramName) {
		paramName = Objects.toString(paramName, "");

		FinderPath finderPath = _finderPathCountByParamName;

		Object[] finderArgs = new Object[] {structuredDataId, paramName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACTIONHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_PARAMNAME_STRUCTUREDDATAID_2);

			boolean bindParamName = false;

			if (paramName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARAMNAME_PARAMNAME_3);
			}
			else {
				bindParamName = true;

				sb.append(_FINDER_COLUMN_PARAMNAME_PARAMNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(structuredDataId);

				if (bindParamName) {
					queryPos.add(paramName);
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

	private static final String _FINDER_COLUMN_PARAMNAME_STRUCTUREDDATAID_2 =
		"actionHistory.structuredDataId = ? AND ";

	private static final String _FINDER_COLUMN_PARAMNAME_PARAMNAME_2 =
		"actionHistory.paramName = ?";

	private static final String _FINDER_COLUMN_PARAMNAME_PARAMNAME_3 =
		"(actionHistory.paramName IS NULL OR actionHistory.paramName = '')";

	public ActionHistoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ActionHistory.class);

		setModelImplClass(ActionHistoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the action history in the entity cache if it is enabled.
	 *
	 * @param actionHistory the action history
	 */
	@Override
	public void cacheResult(ActionHistory actionHistory) {
		entityCache.putResult(
			entityCacheEnabled, ActionHistoryImpl.class,
			actionHistory.getPrimaryKey(), actionHistory);

		finderCache.putResult(
			_finderPathFetchByParamName,
			new Object[] {
				actionHistory.getStructuredDataId(),
				actionHistory.getParamName()
			},
			actionHistory);

		actionHistory.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the action histories in the entity cache if it is enabled.
	 *
	 * @param actionHistories the action histories
	 */
	@Override
	public void cacheResult(List<ActionHistory> actionHistories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (actionHistories.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ActionHistory actionHistory : actionHistories) {
			if (entityCache.getResult(
					entityCacheEnabled, ActionHistoryImpl.class,
					actionHistory.getPrimaryKey()) == null) {

				cacheResult(actionHistory);
			}
			else {
				actionHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all action histories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ActionHistoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the action history.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ActionHistory actionHistory) {
		entityCache.removeResult(
			entityCacheEnabled, ActionHistoryImpl.class,
			actionHistory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ActionHistoryModelImpl)actionHistory, true);
	}

	@Override
	public void clearCache(List<ActionHistory> actionHistories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ActionHistory actionHistory : actionHistories) {
			entityCache.removeResult(
				entityCacheEnabled, ActionHistoryImpl.class,
				actionHistory.getPrimaryKey());

			clearUniqueFindersCache(
				(ActionHistoryModelImpl)actionHistory, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ActionHistoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ActionHistoryModelImpl actionHistoryModelImpl) {

		Object[] args = new Object[] {
			actionHistoryModelImpl.getStructuredDataId(),
			actionHistoryModelImpl.getParamName()
		};

		finderCache.putResult(
			_finderPathCountByParamName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByParamName, args, actionHistoryModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ActionHistoryModelImpl actionHistoryModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				actionHistoryModelImpl.getStructuredDataId(),
				actionHistoryModelImpl.getParamName()
			};

			finderCache.removeResult(_finderPathCountByParamName, args);
			finderCache.removeResult(_finderPathFetchByParamName, args);
		}

		if ((actionHistoryModelImpl.getColumnBitmask() &
			 _finderPathFetchByParamName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				actionHistoryModelImpl.getOriginalStructuredDataId(),
				actionHistoryModelImpl.getOriginalParamName()
			};

			finderCache.removeResult(_finderPathCountByParamName, args);
			finderCache.removeResult(_finderPathFetchByParamName, args);
		}
	}

	/**
	 * Creates a new action history with the primary key. Does not add the action history to the database.
	 *
	 * @param actionHistoryId the primary key for the new action history
	 * @return the new action history
	 */
	@Override
	public ActionHistory create(long actionHistoryId) {
		ActionHistory actionHistory = new ActionHistoryImpl();

		actionHistory.setNew(true);
		actionHistory.setPrimaryKey(actionHistoryId);

		return actionHistory;
	}

	/**
	 * Removes the action history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history that was removed
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	@Override
	public ActionHistory remove(long actionHistoryId)
		throws NoSuchActionHistoryException {

		return remove((Serializable)actionHistoryId);
	}

	/**
	 * Removes the action history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the action history
	 * @return the action history that was removed
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	@Override
	public ActionHistory remove(Serializable primaryKey)
		throws NoSuchActionHistoryException {

		Session session = null;

		try {
			session = openSession();

			ActionHistory actionHistory = (ActionHistory)session.get(
				ActionHistoryImpl.class, primaryKey);

			if (actionHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActionHistoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(actionHistory);
		}
		catch (NoSuchActionHistoryException noSuchEntityException) {
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
	protected ActionHistory removeImpl(ActionHistory actionHistory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(actionHistory)) {
				actionHistory = (ActionHistory)session.get(
					ActionHistoryImpl.class, actionHistory.getPrimaryKeyObj());
			}

			if (actionHistory != null) {
				session.delete(actionHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (actionHistory != null) {
			clearCache(actionHistory);
		}

		return actionHistory;
	}

	@Override
	public ActionHistory updateImpl(ActionHistory actionHistory) {
		boolean isNew = actionHistory.isNew();

		if (!(actionHistory instanceof ActionHistoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(actionHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					actionHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in actionHistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ActionHistory implementation " +
					actionHistory.getClass());
		}

		ActionHistoryModelImpl actionHistoryModelImpl =
			(ActionHistoryModelImpl)actionHistory;

		if (isNew && (actionHistory.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				actionHistory.setCreateDate(date);
			}
			else {
				actionHistory.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(actionHistory);

				actionHistory.setNew(false);
			}
			else {
				actionHistory = (ActionHistory)session.merge(actionHistory);
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
				actionHistoryModelImpl.getStructuredDataId()
			};

			finderCache.removeResult(_finderPathCountByDataId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((actionHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					actionHistoryModelImpl.getOriginalStructuredDataId()
				};

				finderCache.removeResult(_finderPathCountByDataId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataId, args);

				args = new Object[] {
					actionHistoryModelImpl.getStructuredDataId()
				};

				finderCache.removeResult(_finderPathCountByDataId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ActionHistoryImpl.class,
			actionHistory.getPrimaryKey(), actionHistory, false);

		clearUniqueFindersCache(actionHistoryModelImpl, false);
		cacheUniqueFindersCache(actionHistoryModelImpl);

		actionHistory.resetOriginalValues();

		return actionHistory;
	}

	/**
	 * Returns the action history with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the action history
	 * @return the action history
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	@Override
	public ActionHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActionHistoryException {

		ActionHistory actionHistory = fetchByPrimaryKey(primaryKey);

		if (actionHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActionHistoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return actionHistory;
	}

	/**
	 * Returns the action history with the primary key or throws a <code>NoSuchActionHistoryException</code> if it could not be found.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history
	 * @throws NoSuchActionHistoryException if a action history with the primary key could not be found
	 */
	@Override
	public ActionHistory findByPrimaryKey(long actionHistoryId)
		throws NoSuchActionHistoryException {

		return findByPrimaryKey((Serializable)actionHistoryId);
	}

	/**
	 * Returns the action history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history, or <code>null</code> if a action history with the primary key could not be found
	 */
	@Override
	public ActionHistory fetchByPrimaryKey(long actionHistoryId) {
		return fetchByPrimaryKey((Serializable)actionHistoryId);
	}

	/**
	 * Returns all the action histories.
	 *
	 * @return the action histories
	 */
	@Override
	public List<ActionHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @return the range of action histories
	 */
	@Override
	public List<ActionHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of action histories
	 */
	@Override
	public List<ActionHistory> findAll(
		int start, int end,
		OrderByComparator<ActionHistory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActionHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of action histories
	 */
	@Override
	public List<ActionHistory> findAll(
		int start, int end, OrderByComparator<ActionHistory> orderByComparator,
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

		List<ActionHistory> list = null;

		if (useFinderCache) {
			list = (List<ActionHistory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ACTIONHISTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ACTIONHISTORY;

				sql = sql.concat(ActionHistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ActionHistory>)QueryUtil.list(
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
	 * Removes all the action histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ActionHistory actionHistory : findAll()) {
			remove(actionHistory);
		}
	}

	/**
	 * Returns the number of action histories.
	 *
	 * @return the number of action histories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ACTIONHISTORY);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "actionHistoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ACTIONHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ActionHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the action history persistence.
	 */
	@Activate
	public void activate() {
		ActionHistoryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ActionHistoryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDataId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataId",
			new String[] {Long.class.getName()},
			ActionHistoryModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK);

		_finderPathCountByDataId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataId",
			new String[] {Long.class.getName()});

		_finderPathFetchByParamName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActionHistoryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByParamName",
			new String[] {Long.class.getName(), String.class.getName()},
			ActionHistoryModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			ActionHistoryModelImpl.PARAMNAME_COLUMN_BITMASK);

		_finderPathCountByParamName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParamName",
			new String[] {Long.class.getName(), String.class.getName()});

		_setActionHistoryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setActionHistoryUtilPersistence(null);

		entityCache.removeCache(ActionHistoryImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setActionHistoryUtilPersistence(
		ActionHistoryPersistence actionHistoryPersistence) {

		try {
			Field field = ActionHistoryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, actionHistoryPersistence);
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
				"value.object.column.bitmask.enabled.com.sx.icecap.model.ActionHistory"),
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

	private static final String _SQL_SELECT_ACTIONHISTORY =
		"SELECT actionHistory FROM ActionHistory actionHistory";

	private static final String _SQL_SELECT_ACTIONHISTORY_WHERE =
		"SELECT actionHistory FROM ActionHistory actionHistory WHERE ";

	private static final String _SQL_COUNT_ACTIONHISTORY =
		"SELECT COUNT(actionHistory) FROM ActionHistory actionHistory";

	private static final String _SQL_COUNT_ACTIONHISTORY_WHERE =
		"SELECT COUNT(actionHistory) FROM ActionHistory actionHistory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "actionHistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ActionHistory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ActionHistory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ActionHistoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"comment"});

}