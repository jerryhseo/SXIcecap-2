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
import com.liferay.portal.kernel.util.SetUtil;

import com.sx.icecap.exception.NoSuchStructureParamLinkException;
import com.sx.icecap.model.StructureParamLink;
import com.sx.icecap.model.impl.StructureParamLinkImpl;
import com.sx.icecap.model.impl.StructureParamLinkModelImpl;
import com.sx.icecap.service.persistence.StructureParamLinkPersistence;
import com.sx.icecap.service.persistence.StructureParamLinkUtil;
import com.sx.icecap.service.persistence.impl.constants.SX_ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the structure param link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StructureParamLinkPersistence.class)
public class StructureParamLinkPersistenceImpl
	extends BasePersistenceImpl<StructureParamLink>
	implements StructureParamLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StructureParamLinkUtil</code> to access the structure param link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StructureParamLinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDataStructureId;
	private FinderPath _finderPathWithoutPaginationFindByDataStructureId;
	private FinderPath _finderPathCountByDataStructureId;

	/**
	 * Returns all the structure param links where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the matching structure param links
	 */
	@Override
	public List<StructureParamLink> findByDataStructureId(
		long dataStructureId) {

		return findByDataStructureId(
			dataStructureId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the structure param links where dataStructureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataStructureId the data structure ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @return the range of matching structure param links
	 */
	@Override
	public List<StructureParamLink> findByDataStructureId(
		long dataStructureId, int start, int end) {

		return findByDataStructureId(dataStructureId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the structure param links where dataStructureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataStructureId the data structure ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structure param links
	 */
	@Override
	public List<StructureParamLink> findByDataStructureId(
		long dataStructureId, int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator) {

		return findByDataStructureId(
			dataStructureId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the structure param links where dataStructureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataStructureId the data structure ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structure param links
	 */
	@Override
	public List<StructureParamLink> findByDataStructureId(
		long dataStructureId, int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataStructureId;
				finderArgs = new Object[] {dataStructureId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataStructureId;
			finderArgs = new Object[] {
				dataStructureId, start, end, orderByComparator
			};
		}

		List<StructureParamLink> list = null;

		if (useFinderCache) {
			list = (List<StructureParamLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StructureParamLink structureParamLink : list) {
					if (dataStructureId !=
							structureParamLink.getDataStructureId()) {

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

			sb.append(_SQL_SELECT_STRUCTUREPARAMLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_DATASTRUCTUREID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StructureParamLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataStructureId);

				list = (List<StructureParamLink>)QueryUtil.list(
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
	 * Returns the first structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	@Override
	public StructureParamLink findByDataStructureId_First(
			long dataStructureId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws NoSuchStructureParamLinkException {

		StructureParamLink structureParamLink = fetchByDataStructureId_First(
			dataStructureId, orderByComparator);

		if (structureParamLink != null) {
			return structureParamLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataStructureId=");
		sb.append(dataStructureId);

		sb.append("}");

		throw new NoSuchStructureParamLinkException(sb.toString());
	}

	/**
	 * Returns the first structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	@Override
	public StructureParamLink fetchByDataStructureId_First(
		long dataStructureId,
		OrderByComparator<StructureParamLink> orderByComparator) {

		List<StructureParamLink> list = findByDataStructureId(
			dataStructureId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	@Override
	public StructureParamLink findByDataStructureId_Last(
			long dataStructureId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws NoSuchStructureParamLinkException {

		StructureParamLink structureParamLink = fetchByDataStructureId_Last(
			dataStructureId, orderByComparator);

		if (structureParamLink != null) {
			return structureParamLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataStructureId=");
		sb.append(dataStructureId);

		sb.append("}");

		throw new NoSuchStructureParamLinkException(sb.toString());
	}

	/**
	 * Returns the last structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	@Override
	public StructureParamLink fetchByDataStructureId_Last(
		long dataStructureId,
		OrderByComparator<StructureParamLink> orderByComparator) {

		int count = countByDataStructureId(dataStructureId);

		if (count == 0) {
			return null;
		}

		List<StructureParamLink> list = findByDataStructureId(
			dataStructureId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the structure param links before and after the current structure param link in the ordered set where dataStructureId = &#63;.
	 *
	 * @param structureParamLinkId the primary key of the current structure param link
	 * @param dataStructureId the data structure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structure param link
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	@Override
	public StructureParamLink[] findByDataStructureId_PrevAndNext(
			long structureParamLinkId, long dataStructureId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws NoSuchStructureParamLinkException {

		StructureParamLink structureParamLink = findByPrimaryKey(
			structureParamLinkId);

		Session session = null;

		try {
			session = openSession();

			StructureParamLink[] array = new StructureParamLinkImpl[3];

			array[0] = getByDataStructureId_PrevAndNext(
				session, structureParamLink, dataStructureId, orderByComparator,
				true);

			array[1] = structureParamLink;

			array[2] = getByDataStructureId_PrevAndNext(
				session, structureParamLink, dataStructureId, orderByComparator,
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

	protected StructureParamLink getByDataStructureId_PrevAndNext(
		Session session, StructureParamLink structureParamLink,
		long dataStructureId,
		OrderByComparator<StructureParamLink> orderByComparator,
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

		sb.append(_SQL_SELECT_STRUCTUREPARAMLINK_WHERE);

		sb.append(_FINDER_COLUMN_DATASTRUCTUREID_DATASTRUCTUREID_2);

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
			sb.append(StructureParamLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataStructureId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						structureParamLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StructureParamLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the structure param links where dataStructureId = &#63; from the database.
	 *
	 * @param dataStructureId the data structure ID
	 */
	@Override
	public void removeByDataStructureId(long dataStructureId) {
		for (StructureParamLink structureParamLink :
				findByDataStructureId(
					dataStructureId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(structureParamLink);
		}
	}

	/**
	 * Returns the number of structure param links where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the number of matching structure param links
	 */
	@Override
	public int countByDataStructureId(long dataStructureId) {
		FinderPath finderPath = _finderPathCountByDataStructureId;

		Object[] finderArgs = new Object[] {dataStructureId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STRUCTUREPARAMLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_DATASTRUCTUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataStructureId);

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
		_FINDER_COLUMN_DATASTRUCTUREID_DATASTRUCTUREID_2 =
			"structureParamLink.dataStructureId = ?";

	private FinderPath _finderPathWithPaginationFindByParameterId;
	private FinderPath _finderPathWithoutPaginationFindByParameterId;
	private FinderPath _finderPathCountByParameterId;

	/**
	 * Returns all the structure param links where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @return the matching structure param links
	 */
	@Override
	public List<StructureParamLink> findByParameterId(long parameterId) {
		return findByParameterId(
			parameterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the structure param links where parameterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param parameterId the parameter ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @return the range of matching structure param links
	 */
	@Override
	public List<StructureParamLink> findByParameterId(
		long parameterId, int start, int end) {

		return findByParameterId(parameterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the structure param links where parameterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param parameterId the parameter ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structure param links
	 */
	@Override
	public List<StructureParamLink> findByParameterId(
		long parameterId, int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator) {

		return findByParameterId(
			parameterId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the structure param links where parameterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param parameterId the parameter ID
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structure param links
	 */
	@Override
	public List<StructureParamLink> findByParameterId(
		long parameterId, int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParameterId;
				finderArgs = new Object[] {parameterId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParameterId;
			finderArgs = new Object[] {
				parameterId, start, end, orderByComparator
			};
		}

		List<StructureParamLink> list = null;

		if (useFinderCache) {
			list = (List<StructureParamLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StructureParamLink structureParamLink : list) {
					if (parameterId != structureParamLink.getParameterId()) {
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

			sb.append(_SQL_SELECT_STRUCTUREPARAMLINK_WHERE);

			sb.append(_FINDER_COLUMN_PARAMETERID_PARAMETERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StructureParamLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parameterId);

				list = (List<StructureParamLink>)QueryUtil.list(
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
	 * Returns the first structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	@Override
	public StructureParamLink findByParameterId_First(
			long parameterId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws NoSuchStructureParamLinkException {

		StructureParamLink structureParamLink = fetchByParameterId_First(
			parameterId, orderByComparator);

		if (structureParamLink != null) {
			return structureParamLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parameterId=");
		sb.append(parameterId);

		sb.append("}");

		throw new NoSuchStructureParamLinkException(sb.toString());
	}

	/**
	 * Returns the first structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	@Override
	public StructureParamLink fetchByParameterId_First(
		long parameterId,
		OrderByComparator<StructureParamLink> orderByComparator) {

		List<StructureParamLink> list = findByParameterId(
			parameterId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link
	 * @throws NoSuchStructureParamLinkException if a matching structure param link could not be found
	 */
	@Override
	public StructureParamLink findByParameterId_Last(
			long parameterId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws NoSuchStructureParamLinkException {

		StructureParamLink structureParamLink = fetchByParameterId_Last(
			parameterId, orderByComparator);

		if (structureParamLink != null) {
			return structureParamLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parameterId=");
		sb.append(parameterId);

		sb.append("}");

		throw new NoSuchStructureParamLinkException(sb.toString());
	}

	/**
	 * Returns the last structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structure param link, or <code>null</code> if a matching structure param link could not be found
	 */
	@Override
	public StructureParamLink fetchByParameterId_Last(
		long parameterId,
		OrderByComparator<StructureParamLink> orderByComparator) {

		int count = countByParameterId(parameterId);

		if (count == 0) {
			return null;
		}

		List<StructureParamLink> list = findByParameterId(
			parameterId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the structure param links before and after the current structure param link in the ordered set where parameterId = &#63;.
	 *
	 * @param structureParamLinkId the primary key of the current structure param link
	 * @param parameterId the parameter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structure param link
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	@Override
	public StructureParamLink[] findByParameterId_PrevAndNext(
			long structureParamLinkId, long parameterId,
			OrderByComparator<StructureParamLink> orderByComparator)
		throws NoSuchStructureParamLinkException {

		StructureParamLink structureParamLink = findByPrimaryKey(
			structureParamLinkId);

		Session session = null;

		try {
			session = openSession();

			StructureParamLink[] array = new StructureParamLinkImpl[3];

			array[0] = getByParameterId_PrevAndNext(
				session, structureParamLink, parameterId, orderByComparator,
				true);

			array[1] = structureParamLink;

			array[2] = getByParameterId_PrevAndNext(
				session, structureParamLink, parameterId, orderByComparator,
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

	protected StructureParamLink getByParameterId_PrevAndNext(
		Session session, StructureParamLink structureParamLink,
		long parameterId,
		OrderByComparator<StructureParamLink> orderByComparator,
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

		sb.append(_SQL_SELECT_STRUCTUREPARAMLINK_WHERE);

		sb.append(_FINDER_COLUMN_PARAMETERID_PARAMETERID_2);

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
			sb.append(StructureParamLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parameterId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						structureParamLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StructureParamLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the structure param links where parameterId = &#63; from the database.
	 *
	 * @param parameterId the parameter ID
	 */
	@Override
	public void removeByParameterId(long parameterId) {
		for (StructureParamLink structureParamLink :
				findByParameterId(
					parameterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(structureParamLink);
		}
	}

	/**
	 * Returns the number of structure param links where parameterId = &#63;.
	 *
	 * @param parameterId the parameter ID
	 * @return the number of matching structure param links
	 */
	@Override
	public int countByParameterId(long parameterId) {
		FinderPath finderPath = _finderPathCountByParameterId;

		Object[] finderArgs = new Object[] {parameterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STRUCTUREPARAMLINK_WHERE);

			sb.append(_FINDER_COLUMN_PARAMETERID_PARAMETERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parameterId);

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

	private static final String _FINDER_COLUMN_PARAMETERID_PARAMETERID_2 =
		"structureParamLink.parameterId = ?";

	public StructureParamLinkPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("order", "order_");

		setDBColumnNames(dbColumnNames);

		setModelClass(StructureParamLink.class);

		setModelImplClass(StructureParamLinkImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the structure param link in the entity cache if it is enabled.
	 *
	 * @param structureParamLink the structure param link
	 */
	@Override
	public void cacheResult(StructureParamLink structureParamLink) {
		entityCache.putResult(
			entityCacheEnabled, StructureParamLinkImpl.class,
			structureParamLink.getPrimaryKey(), structureParamLink);

		structureParamLink.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the structure param links in the entity cache if it is enabled.
	 *
	 * @param structureParamLinks the structure param links
	 */
	@Override
	public void cacheResult(List<StructureParamLink> structureParamLinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (structureParamLinks.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (StructureParamLink structureParamLink : structureParamLinks) {
			if (entityCache.getResult(
					entityCacheEnabled, StructureParamLinkImpl.class,
					structureParamLink.getPrimaryKey()) == null) {

				cacheResult(structureParamLink);
			}
			else {
				structureParamLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all structure param links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StructureParamLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the structure param link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StructureParamLink structureParamLink) {
		entityCache.removeResult(
			entityCacheEnabled, StructureParamLinkImpl.class,
			structureParamLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StructureParamLink> structureParamLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StructureParamLink structureParamLink : structureParamLinks) {
			entityCache.removeResult(
				entityCacheEnabled, StructureParamLinkImpl.class,
				structureParamLink.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StructureParamLinkImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new structure param link with the primary key. Does not add the structure param link to the database.
	 *
	 * @param structureParamLinkId the primary key for the new structure param link
	 * @return the new structure param link
	 */
	@Override
	public StructureParamLink create(long structureParamLinkId) {
		StructureParamLink structureParamLink = new StructureParamLinkImpl();

		structureParamLink.setNew(true);
		structureParamLink.setPrimaryKey(structureParamLinkId);

		return structureParamLink;
	}

	/**
	 * Removes the structure param link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param structureParamLinkId the primary key of the structure param link
	 * @return the structure param link that was removed
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	@Override
	public StructureParamLink remove(long structureParamLinkId)
		throws NoSuchStructureParamLinkException {

		return remove((Serializable)structureParamLinkId);
	}

	/**
	 * Removes the structure param link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the structure param link
	 * @return the structure param link that was removed
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	@Override
	public StructureParamLink remove(Serializable primaryKey)
		throws NoSuchStructureParamLinkException {

		Session session = null;

		try {
			session = openSession();

			StructureParamLink structureParamLink =
				(StructureParamLink)session.get(
					StructureParamLinkImpl.class, primaryKey);

			if (structureParamLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStructureParamLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(structureParamLink);
		}
		catch (NoSuchStructureParamLinkException noSuchEntityException) {
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
	protected StructureParamLink removeImpl(
		StructureParamLink structureParamLink) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(structureParamLink)) {
				structureParamLink = (StructureParamLink)session.get(
					StructureParamLinkImpl.class,
					structureParamLink.getPrimaryKeyObj());
			}

			if (structureParamLink != null) {
				session.delete(structureParamLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (structureParamLink != null) {
			clearCache(structureParamLink);
		}

		return structureParamLink;
	}

	@Override
	public StructureParamLink updateImpl(
		StructureParamLink structureParamLink) {

		boolean isNew = structureParamLink.isNew();

		if (!(structureParamLink instanceof StructureParamLinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(structureParamLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					structureParamLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in structureParamLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StructureParamLink implementation " +
					structureParamLink.getClass());
		}

		StructureParamLinkModelImpl structureParamLinkModelImpl =
			(StructureParamLinkModelImpl)structureParamLink;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(structureParamLink);

				structureParamLink.setNew(false);
			}
			else {
				structureParamLink = (StructureParamLink)session.merge(
					structureParamLink);
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
				structureParamLinkModelImpl.getDataStructureId()
			};

			finderCache.removeResult(_finderPathCountByDataStructureId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataStructureId, args);

			args = new Object[] {structureParamLinkModelImpl.getParameterId()};

			finderCache.removeResult(_finderPathCountByParameterId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByParameterId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((structureParamLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataStructureId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					structureParamLinkModelImpl.getOriginalDataStructureId()
				};

				finderCache.removeResult(
					_finderPathCountByDataStructureId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataStructureId, args);

				args = new Object[] {
					structureParamLinkModelImpl.getDataStructureId()
				};

				finderCache.removeResult(
					_finderPathCountByDataStructureId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataStructureId, args);
			}

			if ((structureParamLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByParameterId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					structureParamLinkModelImpl.getOriginalParameterId()
				};

				finderCache.removeResult(_finderPathCountByParameterId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByParameterId, args);

				args = new Object[] {
					structureParamLinkModelImpl.getParameterId()
				};

				finderCache.removeResult(_finderPathCountByParameterId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByParameterId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, StructureParamLinkImpl.class,
			structureParamLink.getPrimaryKey(), structureParamLink, false);

		structureParamLink.resetOriginalValues();

		return structureParamLink;
	}

	/**
	 * Returns the structure param link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the structure param link
	 * @return the structure param link
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	@Override
	public StructureParamLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStructureParamLinkException {

		StructureParamLink structureParamLink = fetchByPrimaryKey(primaryKey);

		if (structureParamLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStructureParamLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return structureParamLink;
	}

	/**
	 * Returns the structure param link with the primary key or throws a <code>NoSuchStructureParamLinkException</code> if it could not be found.
	 *
	 * @param structureParamLinkId the primary key of the structure param link
	 * @return the structure param link
	 * @throws NoSuchStructureParamLinkException if a structure param link with the primary key could not be found
	 */
	@Override
	public StructureParamLink findByPrimaryKey(long structureParamLinkId)
		throws NoSuchStructureParamLinkException {

		return findByPrimaryKey((Serializable)structureParamLinkId);
	}

	/**
	 * Returns the structure param link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param structureParamLinkId the primary key of the structure param link
	 * @return the structure param link, or <code>null</code> if a structure param link with the primary key could not be found
	 */
	@Override
	public StructureParamLink fetchByPrimaryKey(long structureParamLinkId) {
		return fetchByPrimaryKey((Serializable)structureParamLinkId);
	}

	/**
	 * Returns all the structure param links.
	 *
	 * @return the structure param links
	 */
	@Override
	public List<StructureParamLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the structure param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @return the range of structure param links
	 */
	@Override
	public List<StructureParamLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the structure param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of structure param links
	 */
	@Override
	public List<StructureParamLink> findAll(
		int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the structure param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructureParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structure param links
	 * @param end the upper bound of the range of structure param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of structure param links
	 */
	@Override
	public List<StructureParamLink> findAll(
		int start, int end,
		OrderByComparator<StructureParamLink> orderByComparator,
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

		List<StructureParamLink> list = null;

		if (useFinderCache) {
			list = (List<StructureParamLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STRUCTUREPARAMLINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STRUCTUREPARAMLINK;

				sql = sql.concat(StructureParamLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StructureParamLink>)QueryUtil.list(
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
	 * Removes all the structure param links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StructureParamLink structureParamLink : findAll()) {
			remove(structureParamLink);
		}
	}

	/**
	 * Returns the number of structure param links.
	 *
	 * @return the number of structure param links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_STRUCTUREPARAMLINK);

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
		return "structureParamLinkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STRUCTUREPARAMLINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StructureParamLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the structure param link persistence.
	 */
	@Activate
	public void activate() {
		StructureParamLinkModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StructureParamLinkModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StructureParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StructureParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDataStructureId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StructureParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataStructureId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataStructureId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StructureParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataStructureId",
			new String[] {Long.class.getName()},
			StructureParamLinkModelImpl.DATASTRUCTUREID_COLUMN_BITMASK);

		_finderPathCountByDataStructureId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataStructureId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByParameterId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StructureParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParameterId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByParameterId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			StructureParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParameterId",
			new String[] {Long.class.getName()},
			StructureParamLinkModelImpl.PARAMETERID_COLUMN_BITMASK);

		_finderPathCountByParameterId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParameterId",
			new String[] {Long.class.getName()});

		_setStructureParamLinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setStructureParamLinkUtilPersistence(null);

		entityCache.removeCache(StructureParamLinkImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setStructureParamLinkUtilPersistence(
		StructureParamLinkPersistence structureParamLinkPersistence) {

		try {
			Field field = StructureParamLinkUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, structureParamLinkPersistence);
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
				"value.object.column.bitmask.enabled.com.sx.icecap.model.StructureParamLink"),
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

	private static final String _SQL_SELECT_STRUCTUREPARAMLINK =
		"SELECT structureParamLink FROM StructureParamLink structureParamLink";

	private static final String _SQL_SELECT_STRUCTUREPARAMLINK_WHERE =
		"SELECT structureParamLink FROM StructureParamLink structureParamLink WHERE ";

	private static final String _SQL_COUNT_STRUCTUREPARAMLINK =
		"SELECT COUNT(structureParamLink) FROM StructureParamLink structureParamLink";

	private static final String _SQL_COUNT_STRUCTUREPARAMLINK_WHERE =
		"SELECT COUNT(structureParamLink) FROM StructureParamLink structureParamLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "structureParamLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StructureParamLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StructureParamLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StructureParamLinkPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"order"});

}