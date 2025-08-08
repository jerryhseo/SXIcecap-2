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

import com.sx.icecap.exception.NoSuchTypeParamLinkException;
import com.sx.icecap.model.TypeParamLink;
import com.sx.icecap.model.impl.TypeParamLinkImpl;
import com.sx.icecap.model.impl.TypeParamLinkModelImpl;
import com.sx.icecap.service.persistence.TypeParamLinkPersistence;
import com.sx.icecap.service.persistence.TypeParamLinkUtil;
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
 * The persistence implementation for the type param link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TypeParamLinkPersistence.class)
public class TypeParamLinkPersistenceImpl
	extends BasePersistenceImpl<TypeParamLink>
	implements TypeParamLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TypeParamLinkUtil</code> to access the type param link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TypeParamLinkImpl.class.getName();

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
	 * Returns all the type param links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching type param links
	 */
	@Override
	public List<TypeParamLink> findByDataTypeId(long dataTypeId) {
		return findByDataTypeId(
			dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type param links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @return the range of matching type param links
	 */
	@Override
	public List<TypeParamLink> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return findByDataTypeId(dataTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type param links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type param links
	 */
	@Override
	public List<TypeParamLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<TypeParamLink> orderByComparator) {

		return findByDataTypeId(
			dataTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type param links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type param links
	 */
	@Override
	public List<TypeParamLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<TypeParamLink> orderByComparator,
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

		List<TypeParamLink> list = null;

		if (useFinderCache) {
			list = (List<TypeParamLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeParamLink typeParamLink : list) {
					if (dataTypeId != typeParamLink.getDataTypeId()) {
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

			sb.append(_SQL_SELECT_TYPEPARAMLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeParamLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				list = (List<TypeParamLink>)QueryUtil.list(
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
	 * Returns the first type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	@Override
	public TypeParamLink findByDataTypeId_First(
			long dataTypeId, OrderByComparator<TypeParamLink> orderByComparator)
		throws NoSuchTypeParamLinkException {

		TypeParamLink typeParamLink = fetchByDataTypeId_First(
			dataTypeId, orderByComparator);

		if (typeParamLink != null) {
			return typeParamLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchTypeParamLinkException(sb.toString());
	}

	/**
	 * Returns the first type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	@Override
	public TypeParamLink fetchByDataTypeId_First(
		long dataTypeId, OrderByComparator<TypeParamLink> orderByComparator) {

		List<TypeParamLink> list = findByDataTypeId(
			dataTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	@Override
	public TypeParamLink findByDataTypeId_Last(
			long dataTypeId, OrderByComparator<TypeParamLink> orderByComparator)
		throws NoSuchTypeParamLinkException {

		TypeParamLink typeParamLink = fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);

		if (typeParamLink != null) {
			return typeParamLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchTypeParamLinkException(sb.toString());
	}

	/**
	 * Returns the last type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	@Override
	public TypeParamLink fetchByDataTypeId_Last(
		long dataTypeId, OrderByComparator<TypeParamLink> orderByComparator) {

		int count = countByDataTypeId(dataTypeId);

		if (count == 0) {
			return null;
		}

		List<TypeParamLink> list = findByDataTypeId(
			dataTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type param links before and after the current type param link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param typeParamLinkId the primary key of the current type param link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type param link
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	@Override
	public TypeParamLink[] findByDataTypeId_PrevAndNext(
			long typeParamLinkId, long dataTypeId,
			OrderByComparator<TypeParamLink> orderByComparator)
		throws NoSuchTypeParamLinkException {

		TypeParamLink typeParamLink = findByPrimaryKey(typeParamLinkId);

		Session session = null;

		try {
			session = openSession();

			TypeParamLink[] array = new TypeParamLinkImpl[3];

			array[0] = getByDataTypeId_PrevAndNext(
				session, typeParamLink, dataTypeId, orderByComparator, true);

			array[1] = typeParamLink;

			array[2] = getByDataTypeId_PrevAndNext(
				session, typeParamLink, dataTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeParamLink getByDataTypeId_PrevAndNext(
		Session session, TypeParamLink typeParamLink, long dataTypeId,
		OrderByComparator<TypeParamLink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TYPEPARAMLINK_WHERE);

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
			sb.append(TypeParamLinkModelImpl.ORDER_BY_JPQL);
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
						typeParamLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeParamLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type param links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	@Override
	public void removeByDataTypeId(long dataTypeId) {
		for (TypeParamLink typeParamLink :
				findByDataTypeId(
					dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(typeParamLink);
		}
	}

	/**
	 * Returns the number of type param links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching type param links
	 */
	@Override
	public int countByDataTypeId(long dataTypeId) {
		FinderPath finderPath = _finderPathCountByDataTypeId;

		Object[] finderArgs = new Object[] {dataTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TYPEPARAMLINK_WHERE);

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
		"typeParamLink.dataTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByParamId;
	private FinderPath _finderPathWithoutPaginationFindByParamId;
	private FinderPath _finderPathCountByParamId;

	/**
	 * Returns all the type param links where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @return the matching type param links
	 */
	@Override
	public List<TypeParamLink> findByParamId(long paramId) {
		return findByParamId(
			paramId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type param links where paramId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param paramId the param ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @return the range of matching type param links
	 */
	@Override
	public List<TypeParamLink> findByParamId(long paramId, int start, int end) {
		return findByParamId(paramId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type param links where paramId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param paramId the param ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type param links
	 */
	@Override
	public List<TypeParamLink> findByParamId(
		long paramId, int start, int end,
		OrderByComparator<TypeParamLink> orderByComparator) {

		return findByParamId(paramId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type param links where paramId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param paramId the param ID
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type param links
	 */
	@Override
	public List<TypeParamLink> findByParamId(
		long paramId, int start, int end,
		OrderByComparator<TypeParamLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParamId;
				finderArgs = new Object[] {paramId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParamId;
			finderArgs = new Object[] {paramId, start, end, orderByComparator};
		}

		List<TypeParamLink> list = null;

		if (useFinderCache) {
			list = (List<TypeParamLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeParamLink typeParamLink : list) {
					if (paramId != typeParamLink.getParamId()) {
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

			sb.append(_SQL_SELECT_TYPEPARAMLINK_WHERE);

			sb.append(_FINDER_COLUMN_PARAMID_PARAMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeParamLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(paramId);

				list = (List<TypeParamLink>)QueryUtil.list(
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
	 * Returns the first type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	@Override
	public TypeParamLink findByParamId_First(
			long paramId, OrderByComparator<TypeParamLink> orderByComparator)
		throws NoSuchTypeParamLinkException {

		TypeParamLink typeParamLink = fetchByParamId_First(
			paramId, orderByComparator);

		if (typeParamLink != null) {
			return typeParamLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("paramId=");
		sb.append(paramId);

		sb.append("}");

		throw new NoSuchTypeParamLinkException(sb.toString());
	}

	/**
	 * Returns the first type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	@Override
	public TypeParamLink fetchByParamId_First(
		long paramId, OrderByComparator<TypeParamLink> orderByComparator) {

		List<TypeParamLink> list = findByParamId(
			paramId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link
	 * @throws NoSuchTypeParamLinkException if a matching type param link could not be found
	 */
	@Override
	public TypeParamLink findByParamId_Last(
			long paramId, OrderByComparator<TypeParamLink> orderByComparator)
		throws NoSuchTypeParamLinkException {

		TypeParamLink typeParamLink = fetchByParamId_Last(
			paramId, orderByComparator);

		if (typeParamLink != null) {
			return typeParamLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("paramId=");
		sb.append(paramId);

		sb.append("}");

		throw new NoSuchTypeParamLinkException(sb.toString());
	}

	/**
	 * Returns the last type param link in the ordered set where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type param link, or <code>null</code> if a matching type param link could not be found
	 */
	@Override
	public TypeParamLink fetchByParamId_Last(
		long paramId, OrderByComparator<TypeParamLink> orderByComparator) {

		int count = countByParamId(paramId);

		if (count == 0) {
			return null;
		}

		List<TypeParamLink> list = findByParamId(
			paramId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type param links before and after the current type param link in the ordered set where paramId = &#63;.
	 *
	 * @param typeParamLinkId the primary key of the current type param link
	 * @param paramId the param ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type param link
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	@Override
	public TypeParamLink[] findByParamId_PrevAndNext(
			long typeParamLinkId, long paramId,
			OrderByComparator<TypeParamLink> orderByComparator)
		throws NoSuchTypeParamLinkException {

		TypeParamLink typeParamLink = findByPrimaryKey(typeParamLinkId);

		Session session = null;

		try {
			session = openSession();

			TypeParamLink[] array = new TypeParamLinkImpl[3];

			array[0] = getByParamId_PrevAndNext(
				session, typeParamLink, paramId, orderByComparator, true);

			array[1] = typeParamLink;

			array[2] = getByParamId_PrevAndNext(
				session, typeParamLink, paramId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeParamLink getByParamId_PrevAndNext(
		Session session, TypeParamLink typeParamLink, long paramId,
		OrderByComparator<TypeParamLink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TYPEPARAMLINK_WHERE);

		sb.append(_FINDER_COLUMN_PARAMID_PARAMID_2);

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
			sb.append(TypeParamLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(paramId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						typeParamLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeParamLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type param links where paramId = &#63; from the database.
	 *
	 * @param paramId the param ID
	 */
	@Override
	public void removeByParamId(long paramId) {
		for (TypeParamLink typeParamLink :
				findByParamId(
					paramId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(typeParamLink);
		}
	}

	/**
	 * Returns the number of type param links where paramId = &#63;.
	 *
	 * @param paramId the param ID
	 * @return the number of matching type param links
	 */
	@Override
	public int countByParamId(long paramId) {
		FinderPath finderPath = _finderPathCountByParamId;

		Object[] finderArgs = new Object[] {paramId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TYPEPARAMLINK_WHERE);

			sb.append(_FINDER_COLUMN_PARAMID_PARAMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(paramId);

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

	private static final String _FINDER_COLUMN_PARAMID_PARAMID_2 =
		"typeParamLink.paramId = ?";

	public TypeParamLinkPersistenceImpl() {
		setModelClass(TypeParamLink.class);

		setModelImplClass(TypeParamLinkImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the type param link in the entity cache if it is enabled.
	 *
	 * @param typeParamLink the type param link
	 */
	@Override
	public void cacheResult(TypeParamLink typeParamLink) {
		entityCache.putResult(
			entityCacheEnabled, TypeParamLinkImpl.class,
			typeParamLink.getPrimaryKey(), typeParamLink);

		typeParamLink.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the type param links in the entity cache if it is enabled.
	 *
	 * @param typeParamLinks the type param links
	 */
	@Override
	public void cacheResult(List<TypeParamLink> typeParamLinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (typeParamLinks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TypeParamLink typeParamLink : typeParamLinks) {
			if (entityCache.getResult(
					entityCacheEnabled, TypeParamLinkImpl.class,
					typeParamLink.getPrimaryKey()) == null) {

				cacheResult(typeParamLink);
			}
			else {
				typeParamLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all type param links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TypeParamLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the type param link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TypeParamLink typeParamLink) {
		entityCache.removeResult(
			entityCacheEnabled, TypeParamLinkImpl.class,
			typeParamLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TypeParamLink> typeParamLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TypeParamLink typeParamLink : typeParamLinks) {
			entityCache.removeResult(
				entityCacheEnabled, TypeParamLinkImpl.class,
				typeParamLink.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TypeParamLinkImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new type param link with the primary key. Does not add the type param link to the database.
	 *
	 * @param typeParamLinkId the primary key for the new type param link
	 * @return the new type param link
	 */
	@Override
	public TypeParamLink create(long typeParamLinkId) {
		TypeParamLink typeParamLink = new TypeParamLinkImpl();

		typeParamLink.setNew(true);
		typeParamLink.setPrimaryKey(typeParamLinkId);

		return typeParamLink;
	}

	/**
	 * Removes the type param link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeParamLinkId the primary key of the type param link
	 * @return the type param link that was removed
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	@Override
	public TypeParamLink remove(long typeParamLinkId)
		throws NoSuchTypeParamLinkException {

		return remove((Serializable)typeParamLinkId);
	}

	/**
	 * Removes the type param link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the type param link
	 * @return the type param link that was removed
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	@Override
	public TypeParamLink remove(Serializable primaryKey)
		throws NoSuchTypeParamLinkException {

		Session session = null;

		try {
			session = openSession();

			TypeParamLink typeParamLink = (TypeParamLink)session.get(
				TypeParamLinkImpl.class, primaryKey);

			if (typeParamLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTypeParamLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(typeParamLink);
		}
		catch (NoSuchTypeParamLinkException noSuchEntityException) {
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
	protected TypeParamLink removeImpl(TypeParamLink typeParamLink) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(typeParamLink)) {
				typeParamLink = (TypeParamLink)session.get(
					TypeParamLinkImpl.class, typeParamLink.getPrimaryKeyObj());
			}

			if (typeParamLink != null) {
				session.delete(typeParamLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (typeParamLink != null) {
			clearCache(typeParamLink);
		}

		return typeParamLink;
	}

	@Override
	public TypeParamLink updateImpl(TypeParamLink typeParamLink) {
		boolean isNew = typeParamLink.isNew();

		if (!(typeParamLink instanceof TypeParamLinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(typeParamLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					typeParamLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in typeParamLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TypeParamLink implementation " +
					typeParamLink.getClass());
		}

		TypeParamLinkModelImpl typeParamLinkModelImpl =
			(TypeParamLinkModelImpl)typeParamLink;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(typeParamLink);

				typeParamLink.setNew(false);
			}
			else {
				typeParamLink = (TypeParamLink)session.merge(typeParamLink);
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
				typeParamLinkModelImpl.getDataTypeId()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId, args);

			args = new Object[] {typeParamLinkModelImpl.getParamId()};

			finderCache.removeResult(_finderPathCountByParamId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByParamId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((typeParamLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeParamLinkModelImpl.getOriginalDataTypeId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);

				args = new Object[] {typeParamLinkModelImpl.getDataTypeId()};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);
			}

			if ((typeParamLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByParamId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeParamLinkModelImpl.getOriginalParamId()
				};

				finderCache.removeResult(_finderPathCountByParamId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByParamId, args);

				args = new Object[] {typeParamLinkModelImpl.getParamId()};

				finderCache.removeResult(_finderPathCountByParamId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByParamId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TypeParamLinkImpl.class,
			typeParamLink.getPrimaryKey(), typeParamLink, false);

		typeParamLink.resetOriginalValues();

		return typeParamLink;
	}

	/**
	 * Returns the type param link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the type param link
	 * @return the type param link
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	@Override
	public TypeParamLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTypeParamLinkException {

		TypeParamLink typeParamLink = fetchByPrimaryKey(primaryKey);

		if (typeParamLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTypeParamLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return typeParamLink;
	}

	/**
	 * Returns the type param link with the primary key or throws a <code>NoSuchTypeParamLinkException</code> if it could not be found.
	 *
	 * @param typeParamLinkId the primary key of the type param link
	 * @return the type param link
	 * @throws NoSuchTypeParamLinkException if a type param link with the primary key could not be found
	 */
	@Override
	public TypeParamLink findByPrimaryKey(long typeParamLinkId)
		throws NoSuchTypeParamLinkException {

		return findByPrimaryKey((Serializable)typeParamLinkId);
	}

	/**
	 * Returns the type param link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeParamLinkId the primary key of the type param link
	 * @return the type param link, or <code>null</code> if a type param link with the primary key could not be found
	 */
	@Override
	public TypeParamLink fetchByPrimaryKey(long typeParamLinkId) {
		return fetchByPrimaryKey((Serializable)typeParamLinkId);
	}

	/**
	 * Returns all the type param links.
	 *
	 * @return the type param links
	 */
	@Override
	public List<TypeParamLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @return the range of type param links
	 */
	@Override
	public List<TypeParamLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the type param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of type param links
	 */
	@Override
	public List<TypeParamLink> findAll(
		int start, int end,
		OrderByComparator<TypeParamLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type param links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeParamLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type param links
	 * @param end the upper bound of the range of type param links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of type param links
	 */
	@Override
	public List<TypeParamLink> findAll(
		int start, int end, OrderByComparator<TypeParamLink> orderByComparator,
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

		List<TypeParamLink> list = null;

		if (useFinderCache) {
			list = (List<TypeParamLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TYPEPARAMLINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TYPEPARAMLINK;

				sql = sql.concat(TypeParamLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TypeParamLink>)QueryUtil.list(
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
	 * Removes all the type param links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TypeParamLink typeParamLink : findAll()) {
			remove(typeParamLink);
		}
	}

	/**
	 * Returns the number of type param links.
	 *
	 * @return the number of type param links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TYPEPARAMLINK);

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
		return "typeParamLinkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TYPEPARAMLINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TypeParamLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the type param link persistence.
	 */
	@Activate
	public void activate() {
		TypeParamLinkModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TypeParamLinkModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId",
			new String[] {Long.class.getName()},
			TypeParamLinkModelImpl.DATATYPEID_COLUMN_BITMASK);

		_finderPathCountByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByParamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParamId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByParamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeParamLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParamId",
			new String[] {Long.class.getName()},
			TypeParamLinkModelImpl.PARAMID_COLUMN_BITMASK);

		_finderPathCountByParamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParamId",
			new String[] {Long.class.getName()});

		_setTypeParamLinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTypeParamLinkUtilPersistence(null);

		entityCache.removeCache(TypeParamLinkImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setTypeParamLinkUtilPersistence(
		TypeParamLinkPersistence typeParamLinkPersistence) {

		try {
			Field field = TypeParamLinkUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, typeParamLinkPersistence);
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
				"value.object.column.bitmask.enabled.com.sx.icecap.model.TypeParamLink"),
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

	private static final String _SQL_SELECT_TYPEPARAMLINK =
		"SELECT typeParamLink FROM TypeParamLink typeParamLink";

	private static final String _SQL_SELECT_TYPEPARAMLINK_WHERE =
		"SELECT typeParamLink FROM TypeParamLink typeParamLink WHERE ";

	private static final String _SQL_COUNT_TYPEPARAMLINK =
		"SELECT COUNT(typeParamLink) FROM TypeParamLink typeParamLink";

	private static final String _SQL_COUNT_TYPEPARAMLINK_WHERE =
		"SELECT COUNT(typeParamLink) FROM TypeParamLink typeParamLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "typeParamLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TypeParamLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TypeParamLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TypeParamLinkPersistenceImpl.class);

}