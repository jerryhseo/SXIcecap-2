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

import com.sx.icecap.exception.NoSuchTypeVisualizerLinkException;
import com.sx.icecap.model.TypeVisualizerLink;
import com.sx.icecap.model.impl.TypeVisualizerLinkImpl;
import com.sx.icecap.model.impl.TypeVisualizerLinkModelImpl;
import com.sx.icecap.service.persistence.TypeVisualizerLinkPersistence;
import com.sx.icecap.service.persistence.TypeVisualizerLinkUtil;
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
 * The persistence implementation for the type visualizer link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TypeVisualizerLinkPersistence.class)
public class TypeVisualizerLinkPersistenceImpl
	extends BasePersistenceImpl<TypeVisualizerLink>
	implements TypeVisualizerLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TypeVisualizerLinkUtil</code> to access the type visualizer link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TypeVisualizerLinkImpl.class.getName();

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
	 * Returns all the type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findByDataTypeId(long dataTypeId) {
		return findByDataTypeId(
			dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @return the range of matching type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return findByDataTypeId(dataTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		return findByDataTypeId(
			dataTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator,
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

		List<TypeVisualizerLink> list = null;

		if (useFinderCache) {
			list = (List<TypeVisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeVisualizerLink typeVisualizerLink : list) {
					if (dataTypeId != typeVisualizerLink.getDataTypeId()) {
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

			sb.append(_SQL_SELECT_TYPEVISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				list = (List<TypeVisualizerLink>)QueryUtil.list(
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
	 * Returns the first type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	@Override
	public TypeVisualizerLink findByDataTypeId_First(
			long dataTypeId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws NoSuchTypeVisualizerLinkException {

		TypeVisualizerLink typeVisualizerLink = fetchByDataTypeId_First(
			dataTypeId, orderByComparator);

		if (typeVisualizerLink != null) {
			return typeVisualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the first type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	@Override
	public TypeVisualizerLink fetchByDataTypeId_First(
		long dataTypeId,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		List<TypeVisualizerLink> list = findByDataTypeId(
			dataTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	@Override
	public TypeVisualizerLink findByDataTypeId_Last(
			long dataTypeId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws NoSuchTypeVisualizerLinkException {

		TypeVisualizerLink typeVisualizerLink = fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);

		if (typeVisualizerLink != null) {
			return typeVisualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the last type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	@Override
	public TypeVisualizerLink fetchByDataTypeId_Last(
		long dataTypeId,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		int count = countByDataTypeId(dataTypeId);

		if (count == 0) {
			return null;
		}

		List<TypeVisualizerLink> list = findByDataTypeId(
			dataTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type visualizer links before and after the current type visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param typeVisualizerLinkId the primary key of the current type visualizer link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	@Override
	public TypeVisualizerLink[] findByDataTypeId_PrevAndNext(
			long typeVisualizerLinkId, long dataTypeId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws NoSuchTypeVisualizerLinkException {

		TypeVisualizerLink typeVisualizerLink = findByPrimaryKey(
			typeVisualizerLinkId);

		Session session = null;

		try {
			session = openSession();

			TypeVisualizerLink[] array = new TypeVisualizerLinkImpl[3];

			array[0] = getByDataTypeId_PrevAndNext(
				session, typeVisualizerLink, dataTypeId, orderByComparator,
				true);

			array[1] = typeVisualizerLink;

			array[2] = getByDataTypeId_PrevAndNext(
				session, typeVisualizerLink, dataTypeId, orderByComparator,
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

	protected TypeVisualizerLink getByDataTypeId_PrevAndNext(
		Session session, TypeVisualizerLink typeVisualizerLink, long dataTypeId,
		OrderByComparator<TypeVisualizerLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPEVISUALIZERLINK_WHERE);

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
			sb.append(TypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
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
						typeVisualizerLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeVisualizerLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type visualizer links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	@Override
	public void removeByDataTypeId(long dataTypeId) {
		for (TypeVisualizerLink typeVisualizerLink :
				findByDataTypeId(
					dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(typeVisualizerLink);
		}
	}

	/**
	 * Returns the number of type visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching type visualizer links
	 */
	@Override
	public int countByDataTypeId(long dataTypeId) {
		FinderPath finderPath = _finderPathCountByDataTypeId;

		Object[] finderArgs = new Object[] {dataTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TYPEVISUALIZERLINK_WHERE);

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
		"typeVisualizerLink.dataTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByVisualizerId;
	private FinderPath _finderPathWithoutPaginationFindByVisualizerId;
	private FinderPath _finderPathCountByVisualizerId;

	/**
	 * Returns all the type visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the matching type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findByVisualizerId(long visualizerId) {
		return findByVisualizerId(
			visualizerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @return the range of matching type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end) {

		return findByVisualizerId(visualizerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		return findByVisualizerId(
			visualizerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVisualizerId;
				finderArgs = new Object[] {visualizerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVisualizerId;
			finderArgs = new Object[] {
				visualizerId, start, end, orderByComparator
			};
		}

		List<TypeVisualizerLink> list = null;

		if (useFinderCache) {
			list = (List<TypeVisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeVisualizerLink typeVisualizerLink : list) {
					if (visualizerId != typeVisualizerLink.getVisualizerId()) {
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

			sb.append(_SQL_SELECT_TYPEVISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_VISUALIZERID_VISUALIZERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(visualizerId);

				list = (List<TypeVisualizerLink>)QueryUtil.list(
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
	 * Returns the first type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	@Override
	public TypeVisualizerLink findByVisualizerId_First(
			long visualizerId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws NoSuchTypeVisualizerLinkException {

		TypeVisualizerLink typeVisualizerLink = fetchByVisualizerId_First(
			visualizerId, orderByComparator);

		if (typeVisualizerLink != null) {
			return typeVisualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("visualizerId=");
		sb.append(visualizerId);

		sb.append("}");

		throw new NoSuchTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the first type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	@Override
	public TypeVisualizerLink fetchByVisualizerId_First(
		long visualizerId,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		List<TypeVisualizerLink> list = findByVisualizerId(
			visualizerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a matching type visualizer link could not be found
	 */
	@Override
	public TypeVisualizerLink findByVisualizerId_Last(
			long visualizerId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws NoSuchTypeVisualizerLinkException {

		TypeVisualizerLink typeVisualizerLink = fetchByVisualizerId_Last(
			visualizerId, orderByComparator);

		if (typeVisualizerLink != null) {
			return typeVisualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("visualizerId=");
		sb.append(visualizerId);

		sb.append("}");

		throw new NoSuchTypeVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the last type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type visualizer link, or <code>null</code> if a matching type visualizer link could not be found
	 */
	@Override
	public TypeVisualizerLink fetchByVisualizerId_Last(
		long visualizerId,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		int count = countByVisualizerId(visualizerId);

		if (count == 0) {
			return null;
		}

		List<TypeVisualizerLink> list = findByVisualizerId(
			visualizerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type visualizer links before and after the current type visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param typeVisualizerLinkId the primary key of the current type visualizer link
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	@Override
	public TypeVisualizerLink[] findByVisualizerId_PrevAndNext(
			long typeVisualizerLinkId, long visualizerId,
			OrderByComparator<TypeVisualizerLink> orderByComparator)
		throws NoSuchTypeVisualizerLinkException {

		TypeVisualizerLink typeVisualizerLink = findByPrimaryKey(
			typeVisualizerLinkId);

		Session session = null;

		try {
			session = openSession();

			TypeVisualizerLink[] array = new TypeVisualizerLinkImpl[3];

			array[0] = getByVisualizerId_PrevAndNext(
				session, typeVisualizerLink, visualizerId, orderByComparator,
				true);

			array[1] = typeVisualizerLink;

			array[2] = getByVisualizerId_PrevAndNext(
				session, typeVisualizerLink, visualizerId, orderByComparator,
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

	protected TypeVisualizerLink getByVisualizerId_PrevAndNext(
		Session session, TypeVisualizerLink typeVisualizerLink,
		long visualizerId,
		OrderByComparator<TypeVisualizerLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPEVISUALIZERLINK_WHERE);

		sb.append(_FINDER_COLUMN_VISUALIZERID_VISUALIZERID_2);

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
			sb.append(TypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(visualizerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						typeVisualizerLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeVisualizerLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type visualizer links where visualizerId = &#63; from the database.
	 *
	 * @param visualizerId the visualizer ID
	 */
	@Override
	public void removeByVisualizerId(long visualizerId) {
		for (TypeVisualizerLink typeVisualizerLink :
				findByVisualizerId(
					visualizerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(typeVisualizerLink);
		}
	}

	/**
	 * Returns the number of type visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the number of matching type visualizer links
	 */
	@Override
	public int countByVisualizerId(long visualizerId) {
		FinderPath finderPath = _finderPathCountByVisualizerId;

		Object[] finderArgs = new Object[] {visualizerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TYPEVISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_VISUALIZERID_VISUALIZERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(visualizerId);

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

	private static final String _FINDER_COLUMN_VISUALIZERID_VISUALIZERID_2 =
		"typeVisualizerLink.visualizerId = ?";

	public TypeVisualizerLinkPersistenceImpl() {
		setModelClass(TypeVisualizerLink.class);

		setModelImplClass(TypeVisualizerLinkImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the type visualizer link in the entity cache if it is enabled.
	 *
	 * @param typeVisualizerLink the type visualizer link
	 */
	@Override
	public void cacheResult(TypeVisualizerLink typeVisualizerLink) {
		entityCache.putResult(
			entityCacheEnabled, TypeVisualizerLinkImpl.class,
			typeVisualizerLink.getPrimaryKey(), typeVisualizerLink);

		typeVisualizerLink.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the type visualizer links in the entity cache if it is enabled.
	 *
	 * @param typeVisualizerLinks the type visualizer links
	 */
	@Override
	public void cacheResult(List<TypeVisualizerLink> typeVisualizerLinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (typeVisualizerLinks.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TypeVisualizerLink typeVisualizerLink : typeVisualizerLinks) {
			if (entityCache.getResult(
					entityCacheEnabled, TypeVisualizerLinkImpl.class,
					typeVisualizerLink.getPrimaryKey()) == null) {

				cacheResult(typeVisualizerLink);
			}
			else {
				typeVisualizerLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all type visualizer links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TypeVisualizerLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the type visualizer link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TypeVisualizerLink typeVisualizerLink) {
		entityCache.removeResult(
			entityCacheEnabled, TypeVisualizerLinkImpl.class,
			typeVisualizerLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TypeVisualizerLink> typeVisualizerLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TypeVisualizerLink typeVisualizerLink : typeVisualizerLinks) {
			entityCache.removeResult(
				entityCacheEnabled, TypeVisualizerLinkImpl.class,
				typeVisualizerLink.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TypeVisualizerLinkImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new type visualizer link with the primary key. Does not add the type visualizer link to the database.
	 *
	 * @param typeVisualizerLinkId the primary key for the new type visualizer link
	 * @return the new type visualizer link
	 */
	@Override
	public TypeVisualizerLink create(long typeVisualizerLinkId) {
		TypeVisualizerLink typeVisualizerLink = new TypeVisualizerLinkImpl();

		typeVisualizerLink.setNew(true);
		typeVisualizerLink.setPrimaryKey(typeVisualizerLinkId);

		return typeVisualizerLink;
	}

	/**
	 * Removes the type visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeVisualizerLinkId the primary key of the type visualizer link
	 * @return the type visualizer link that was removed
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	@Override
	public TypeVisualizerLink remove(long typeVisualizerLinkId)
		throws NoSuchTypeVisualizerLinkException {

		return remove((Serializable)typeVisualizerLinkId);
	}

	/**
	 * Removes the type visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the type visualizer link
	 * @return the type visualizer link that was removed
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	@Override
	public TypeVisualizerLink remove(Serializable primaryKey)
		throws NoSuchTypeVisualizerLinkException {

		Session session = null;

		try {
			session = openSession();

			TypeVisualizerLink typeVisualizerLink =
				(TypeVisualizerLink)session.get(
					TypeVisualizerLinkImpl.class, primaryKey);

			if (typeVisualizerLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTypeVisualizerLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(typeVisualizerLink);
		}
		catch (NoSuchTypeVisualizerLinkException noSuchEntityException) {
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
	protected TypeVisualizerLink removeImpl(
		TypeVisualizerLink typeVisualizerLink) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(typeVisualizerLink)) {
				typeVisualizerLink = (TypeVisualizerLink)session.get(
					TypeVisualizerLinkImpl.class,
					typeVisualizerLink.getPrimaryKeyObj());
			}

			if (typeVisualizerLink != null) {
				session.delete(typeVisualizerLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (typeVisualizerLink != null) {
			clearCache(typeVisualizerLink);
		}

		return typeVisualizerLink;
	}

	@Override
	public TypeVisualizerLink updateImpl(
		TypeVisualizerLink typeVisualizerLink) {

		boolean isNew = typeVisualizerLink.isNew();

		if (!(typeVisualizerLink instanceof TypeVisualizerLinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(typeVisualizerLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					typeVisualizerLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in typeVisualizerLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TypeVisualizerLink implementation " +
					typeVisualizerLink.getClass());
		}

		TypeVisualizerLinkModelImpl typeVisualizerLinkModelImpl =
			(TypeVisualizerLinkModelImpl)typeVisualizerLink;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(typeVisualizerLink);

				typeVisualizerLink.setNew(false);
			}
			else {
				typeVisualizerLink = (TypeVisualizerLink)session.merge(
					typeVisualizerLink);
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
				typeVisualizerLinkModelImpl.getDataTypeId()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId, args);

			args = new Object[] {typeVisualizerLinkModelImpl.getVisualizerId()};

			finderCache.removeResult(_finderPathCountByVisualizerId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVisualizerId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((typeVisualizerLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeVisualizerLinkModelImpl.getOriginalDataTypeId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);

				args = new Object[] {
					typeVisualizerLinkModelImpl.getDataTypeId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);
			}

			if ((typeVisualizerLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVisualizerId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeVisualizerLinkModelImpl.getOriginalVisualizerId()
				};

				finderCache.removeResult(_finderPathCountByVisualizerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVisualizerId, args);

				args = new Object[] {
					typeVisualizerLinkModelImpl.getVisualizerId()
				};

				finderCache.removeResult(_finderPathCountByVisualizerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVisualizerId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TypeVisualizerLinkImpl.class,
			typeVisualizerLink.getPrimaryKey(), typeVisualizerLink, false);

		typeVisualizerLink.resetOriginalValues();

		return typeVisualizerLink;
	}

	/**
	 * Returns the type visualizer link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the type visualizer link
	 * @return the type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	@Override
	public TypeVisualizerLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTypeVisualizerLinkException {

		TypeVisualizerLink typeVisualizerLink = fetchByPrimaryKey(primaryKey);

		if (typeVisualizerLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTypeVisualizerLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return typeVisualizerLink;
	}

	/**
	 * Returns the type visualizer link with the primary key or throws a <code>NoSuchTypeVisualizerLinkException</code> if it could not be found.
	 *
	 * @param typeVisualizerLinkId the primary key of the type visualizer link
	 * @return the type visualizer link
	 * @throws NoSuchTypeVisualizerLinkException if a type visualizer link with the primary key could not be found
	 */
	@Override
	public TypeVisualizerLink findByPrimaryKey(long typeVisualizerLinkId)
		throws NoSuchTypeVisualizerLinkException {

		return findByPrimaryKey((Serializable)typeVisualizerLinkId);
	}

	/**
	 * Returns the type visualizer link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeVisualizerLinkId the primary key of the type visualizer link
	 * @return the type visualizer link, or <code>null</code> if a type visualizer link with the primary key could not be found
	 */
	@Override
	public TypeVisualizerLink fetchByPrimaryKey(long typeVisualizerLinkId) {
		return fetchByPrimaryKey((Serializable)typeVisualizerLinkId);
	}

	/**
	 * Returns all the type visualizer links.
	 *
	 * @return the type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @return the range of type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findAll(
		int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeVisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type visualizer links
	 * @param end the upper bound of the range of type visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of type visualizer links
	 */
	@Override
	public List<TypeVisualizerLink> findAll(
		int start, int end,
		OrderByComparator<TypeVisualizerLink> orderByComparator,
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

		List<TypeVisualizerLink> list = null;

		if (useFinderCache) {
			list = (List<TypeVisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TYPEVISUALIZERLINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TYPEVISUALIZERLINK;

				sql = sql.concat(TypeVisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TypeVisualizerLink>)QueryUtil.list(
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
	 * Removes all the type visualizer links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TypeVisualizerLink typeVisualizerLink : findAll()) {
			remove(typeVisualizerLink);
		}
	}

	/**
	 * Returns the number of type visualizer links.
	 *
	 * @return the number of type visualizer links
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
					_SQL_COUNT_TYPEVISUALIZERLINK);

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
		return "typeVisualizerLinkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TYPEVISUALIZERLINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TypeVisualizerLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the type visualizer link persistence.
	 */
	@Activate
	public void activate() {
		TypeVisualizerLinkModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TypeVisualizerLinkModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId",
			new String[] {Long.class.getName()},
			TypeVisualizerLinkModelImpl.DATATYPEID_COLUMN_BITMASK);

		_finderPathCountByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByVisualizerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVisualizerId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVisualizerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TypeVisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVisualizerId",
			new String[] {Long.class.getName()},
			TypeVisualizerLinkModelImpl.VISUALIZERID_COLUMN_BITMASK);

		_finderPathCountByVisualizerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVisualizerId",
			new String[] {Long.class.getName()});

		_setTypeVisualizerLinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTypeVisualizerLinkUtilPersistence(null);

		entityCache.removeCache(TypeVisualizerLinkImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setTypeVisualizerLinkUtilPersistence(
		TypeVisualizerLinkPersistence typeVisualizerLinkPersistence) {

		try {
			Field field = TypeVisualizerLinkUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, typeVisualizerLinkPersistence);
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
				"value.object.column.bitmask.enabled.com.sx.icecap.model.TypeVisualizerLink"),
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

	private static final String _SQL_SELECT_TYPEVISUALIZERLINK =
		"SELECT typeVisualizerLink FROM TypeVisualizerLink typeVisualizerLink";

	private static final String _SQL_SELECT_TYPEVISUALIZERLINK_WHERE =
		"SELECT typeVisualizerLink FROM TypeVisualizerLink typeVisualizerLink WHERE ";

	private static final String _SQL_COUNT_TYPEVISUALIZERLINK =
		"SELECT COUNT(typeVisualizerLink) FROM TypeVisualizerLink typeVisualizerLink";

	private static final String _SQL_COUNT_TYPEVISUALIZERLINK_WHERE =
		"SELECT COUNT(typeVisualizerLink) FROM TypeVisualizerLink typeVisualizerLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "typeVisualizerLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TypeVisualizerLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TypeVisualizerLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TypeVisualizerLinkPersistenceImpl.class);

}