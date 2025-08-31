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

import com.sx.icecap.exception.NoSuchTypeStructureLinkException;
import com.sx.icecap.model.TypeStructureLink;
import com.sx.icecap.model.impl.TypeStructureLinkImpl;
import com.sx.icecap.model.impl.TypeStructureLinkModelImpl;
import com.sx.icecap.service.persistence.TypeStructureLinkPersistence;
import com.sx.icecap.service.persistence.TypeStructureLinkUtil;
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
 * The persistence implementation for the type structure link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TypeStructureLinkPersistence.class)
public class TypeStructureLinkPersistenceImpl
	extends BasePersistenceImpl<TypeStructureLink>
	implements TypeStructureLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TypeStructureLinkUtil</code> to access the type structure link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TypeStructureLinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the type structure links where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type structure links where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByUserId(
		long userId, int start, int end) {

		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeStructureLink typeStructureLink : list) {
					if (userId != typeStructureLink.getUserId()) {
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

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Returns the first type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByUserId_First(
			long userId, OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByUserId_First(
			userId, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByUserId_First(
		long userId, OrderByComparator<TypeStructureLink> orderByComparator) {

		List<TypeStructureLink> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByUserId_Last(
			long userId, OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByUserId_Last(
			userId, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByUserId_Last(
		long userId, OrderByComparator<TypeStructureLink> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<TypeStructureLink> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where userId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink[] findByUserId_PrevAndNext(
			long dataTypeId, long userId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink[] array = new TypeStructureLinkImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, typeStructureLink, userId, orderByComparator, true);

			array[1] = typeStructureLink;

			array[2] = getByUserId_PrevAndNext(
				session, typeStructureLink, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeStructureLink getByUserId_PrevAndNext(
		Session session, TypeStructureLink typeStructureLink, long userId,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

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
			sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
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
						typeStructureLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeStructureLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type structure links where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (TypeStructureLink typeStructureLink :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

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
		"typeStructureLink.userId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the type structure links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeStructureLink typeStructureLink : list) {
					if (groupId != typeStructureLink.getGroupId()) {
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

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Returns the first type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByGroupId_First(
			long groupId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByGroupId_First(
			groupId, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByGroupId_First(
		long groupId, OrderByComparator<TypeStructureLink> orderByComparator) {

		List<TypeStructureLink> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByGroupId_Last(
			long groupId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByGroupId_Last(
		long groupId, OrderByComparator<TypeStructureLink> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<TypeStructureLink> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink[] findByGroupId_PrevAndNext(
			long dataTypeId, long groupId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink[] array = new TypeStructureLinkImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, typeStructureLink, groupId, orderByComparator, true);

			array[1] = typeStructureLink;

			array[2] = getByGroupId_PrevAndNext(
				session, typeStructureLink, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeStructureLink getByGroupId_PrevAndNext(
		Session session, TypeStructureLink typeStructureLink, long groupId,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

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
			sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
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
						typeStructureLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeStructureLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type structure links where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (TypeStructureLink typeStructureLink :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

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
		"typeStructureLink.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByG_U;
	private FinderPath _finderPathWithoutPaginationFindByG_U;
	private FinderPath _finderPathCountByG_U;

	/**
	 * Returns all the type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByG_U(long groupId, long userId) {
		return findByG_U(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByG_U(
		long groupId, long userId, int start, int end) {

		return findByG_U(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findByG_U(groupId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeStructureLink typeStructureLink : list) {
					if ((groupId != typeStructureLink.getGroupId()) ||
						(userId != typeStructureLink.getUserId())) {

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

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByG_U_First(
			long groupId, long userId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByG_U_First(
			groupId, userId, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		List<TypeStructureLink> list = findByG_U(
			groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByG_U_Last(
			groupId, userId, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		int count = countByG_U(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<TypeStructureLink> list = findByG_U(
			groupId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink[] findByG_U_PrevAndNext(
			long dataTypeId, long groupId, long userId,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink[] array = new TypeStructureLinkImpl[3];

			array[0] = getByG_U_PrevAndNext(
				session, typeStructureLink, groupId, userId, orderByComparator,
				true);

			array[1] = typeStructureLink;

			array[2] = getByG_U_PrevAndNext(
				session, typeStructureLink, groupId, userId, orderByComparator,
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

	protected TypeStructureLink getByG_U_PrevAndNext(
		Session session, TypeStructureLink typeStructureLink, long groupId,
		long userId, OrderByComparator<TypeStructureLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

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
			sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
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
						typeStructureLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeStructureLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type structure links where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByG_U(long groupId, long userId) {
		for (TypeStructureLink typeStructureLink :
				findByG_U(
					groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByG_U(long groupId, long userId) {
		FinderPath finderPath = _finderPathCountByG_U;

		Object[] finderArgs = new Object[] {groupId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

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
		"typeStructureLink.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_USERID_2 =
		"typeStructureLink.userId = ?";

	private FinderPath _finderPathFetchByDataStructureId;
	private FinderPath _finderPathCountByDataStructureId;

	/**
	 * Returns the type structure link where dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByDataStructureId(long dataStructureId)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByDataStructureId(
			dataStructureId);

		if (typeStructureLink == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("dataStructureId=");
			sb.append(dataStructureId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTypeStructureLinkException(sb.toString());
		}

		return typeStructureLink;
	}

	/**
	 * Returns the type structure link where dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByDataStructureId(long dataStructureId) {
		return fetchByDataStructureId(dataStructureId, true);
	}

	/**
	 * Returns the type structure link where dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByDataStructureId(
		long dataStructureId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {dataStructureId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDataStructureId, finderArgs, this);
		}

		if (result instanceof TypeStructureLink) {
			TypeStructureLink typeStructureLink = (TypeStructureLink)result;

			if (dataStructureId != typeStructureLink.getDataStructureId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_DATASTRUCTUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataStructureId);

				List<TypeStructureLink> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDataStructureId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {dataStructureId};
							}

							_log.warn(
								"TypeStructureLinkPersistenceImpl.fetchByDataStructureId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TypeStructureLink typeStructureLink = list.get(0);

					result = typeStructureLink;

					cacheResult(typeStructureLink);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByDataStructureId, finderArgs);
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
			return (TypeStructureLink)result;
		}
	}

	/**
	 * Removes the type structure link where dataStructureId = &#63; from the database.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	@Override
	public TypeStructureLink removeByDataStructureId(long dataStructureId)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByDataStructureId(
			dataStructureId);

		return remove(typeStructureLink);
	}

	/**
	 * Returns the number of type structure links where dataStructureId = &#63;.
	 *
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByDataStructureId(long dataStructureId) {
		FinderPath finderPath = _finderPathCountByDataStructureId;

		Object[] finderArgs = new Object[] {dataStructureId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

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
			"typeStructureLink.dataStructureId = ?";

	private FinderPath _finderPathFetchByDataStructureId_G;
	private FinderPath _finderPathCountByDataStructureId_G;

	/**
	 * Returns the type structure link where groupId = &#63; and dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByDataStructureId_G(
			long groupId, long dataStructureId)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByDataStructureId_G(
			groupId, dataStructureId);

		if (typeStructureLink == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", dataStructureId=");
			sb.append(dataStructureId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTypeStructureLinkException(sb.toString());
		}

		return typeStructureLink;
	}

	/**
	 * Returns the type structure link where groupId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByDataStructureId_G(
		long groupId, long dataStructureId) {

		return fetchByDataStructureId_G(groupId, dataStructureId, true);
	}

	/**
	 * Returns the type structure link where groupId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByDataStructureId_G(
		long groupId, long dataStructureId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, dataStructureId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDataStructureId_G, finderArgs, this);
		}

		if (result instanceof TypeStructureLink) {
			TypeStructureLink typeStructureLink = (TypeStructureLink)result;

			if ((groupId != typeStructureLink.getGroupId()) ||
				(dataStructureId != typeStructureLink.getDataStructureId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_G_GROUPID_2);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_G_DATASTRUCTUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(dataStructureId);

				List<TypeStructureLink> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDataStructureId_G, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, dataStructureId
								};
							}

							_log.warn(
								"TypeStructureLinkPersistenceImpl.fetchByDataStructureId_G(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TypeStructureLink typeStructureLink = list.get(0);

					result = typeStructureLink;

					cacheResult(typeStructureLink);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByDataStructureId_G, finderArgs);
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
			return (TypeStructureLink)result;
		}
	}

	/**
	 * Removes the type structure link where groupId = &#63; and dataStructureId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	@Override
	public TypeStructureLink removeByDataStructureId_G(
			long groupId, long dataStructureId)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByDataStructureId_G(
			groupId, dataStructureId);

		return remove(typeStructureLink);
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and dataStructureId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByDataStructureId_G(long groupId, long dataStructureId) {
		FinderPath finderPath = _finderPathCountByDataStructureId_G;

		Object[] finderArgs = new Object[] {groupId, dataStructureId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_G_GROUPID_2);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_G_DATASTRUCTUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_DATASTRUCTUREID_G_GROUPID_2 =
		"typeStructureLink.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_DATASTRUCTUREID_G_DATASTRUCTUREID_2 =
			"typeStructureLink.dataStructureId = ?";

	private FinderPath _finderPathFetchByDataStructureId_U;
	private FinderPath _finderPathCountByDataStructureId_U;

	/**
	 * Returns the type structure link where userId = &#63; and dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByDataStructureId_U(
			long userId, long dataStructureId)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByDataStructureId_U(
			userId, dataStructureId);

		if (typeStructureLink == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append(", dataStructureId=");
			sb.append(dataStructureId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTypeStructureLinkException(sb.toString());
		}

		return typeStructureLink;
	}

	/**
	 * Returns the type structure link where userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByDataStructureId_U(
		long userId, long dataStructureId) {

		return fetchByDataStructureId_U(userId, dataStructureId, true);
	}

	/**
	 * Returns the type structure link where userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByDataStructureId_U(
		long userId, long dataStructureId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId, dataStructureId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDataStructureId_U, finderArgs, this);
		}

		if (result instanceof TypeStructureLink) {
			TypeStructureLink typeStructureLink = (TypeStructureLink)result;

			if ((userId != typeStructureLink.getUserId()) ||
				(dataStructureId != typeStructureLink.getDataStructureId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_U_USERID_2);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_U_DATASTRUCTUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(dataStructureId);

				List<TypeStructureLink> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDataStructureId_U, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									userId, dataStructureId
								};
							}

							_log.warn(
								"TypeStructureLinkPersistenceImpl.fetchByDataStructureId_U(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TypeStructureLink typeStructureLink = list.get(0);

					result = typeStructureLink;

					cacheResult(typeStructureLink);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByDataStructureId_U, finderArgs);
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
			return (TypeStructureLink)result;
		}
	}

	/**
	 * Removes the type structure link where userId = &#63; and dataStructureId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	@Override
	public TypeStructureLink removeByDataStructureId_U(
			long userId, long dataStructureId)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByDataStructureId_U(
			userId, dataStructureId);

		return remove(typeStructureLink);
	}

	/**
	 * Returns the number of type structure links where userId = &#63; and dataStructureId = &#63;.
	 *
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByDataStructureId_U(long userId, long dataStructureId) {
		FinderPath finderPath = _finderPathCountByDataStructureId_U;

		Object[] finderArgs = new Object[] {userId, dataStructureId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_U_USERID_2);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_U_DATASTRUCTUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_DATASTRUCTUREID_U_USERID_2 =
		"typeStructureLink.userId = ? AND ";

	private static final String
		_FINDER_COLUMN_DATASTRUCTUREID_U_DATASTRUCTUREID_2 =
			"typeStructureLink.dataStructureId = ?";

	private FinderPath _finderPathFetchByDataStructureId_G_U;
	private FinderPath _finderPathCountByDataStructureId_G_U;

	/**
	 * Returns the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByDataStructureId_G_U(
			long groupId, long userId, long dataStructureId)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByDataStructureId_G_U(
			groupId, userId, dataStructureId);

		if (typeStructureLink == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", userId=");
			sb.append(userId);

			sb.append(", dataStructureId=");
			sb.append(dataStructureId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTypeStructureLinkException(sb.toString());
		}

		return typeStructureLink;
	}

	/**
	 * Returns the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByDataStructureId_G_U(
		long groupId, long userId, long dataStructureId) {

		return fetchByDataStructureId_G_U(
			groupId, userId, dataStructureId, true);
	}

	/**
	 * Returns the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByDataStructureId_G_U(
		long groupId, long userId, long dataStructureId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, userId, dataStructureId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDataStructureId_G_U, finderArgs, this);
		}

		if (result instanceof TypeStructureLink) {
			TypeStructureLink typeStructureLink = (TypeStructureLink)result;

			if ((groupId != typeStructureLink.getGroupId()) ||
				(userId != typeStructureLink.getUserId()) ||
				(dataStructureId != typeStructureLink.getDataStructureId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_G_U_USERID_2);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_G_U_DATASTRUCTUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(dataStructureId);

				List<TypeStructureLink> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDataStructureId_G_U, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, userId, dataStructureId
								};
							}

							_log.warn(
								"TypeStructureLinkPersistenceImpl.fetchByDataStructureId_G_U(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TypeStructureLink typeStructureLink = list.get(0);

					result = typeStructureLink;

					cacheResult(typeStructureLink);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByDataStructureId_G_U, finderArgs);
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
			return (TypeStructureLink)result;
		}
	}

	/**
	 * Removes the type structure link where groupId = &#63; and userId = &#63; and dataStructureId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the type structure link that was removed
	 */
	@Override
	public TypeStructureLink removeByDataStructureId_G_U(
			long groupId, long userId, long dataStructureId)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByDataStructureId_G_U(
			groupId, userId, dataStructureId);

		return remove(typeStructureLink);
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63; and dataStructureId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param dataStructureId the data structure ID
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByDataStructureId_G_U(
		long groupId, long userId, long dataStructureId) {

		FinderPath finderPath = _finderPathCountByDataStructureId_G_U;

		Object[] finderArgs = new Object[] {groupId, userId, dataStructureId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_G_U_USERID_2);

			sb.append(_FINDER_COLUMN_DATASTRUCTUREID_G_U_DATASTRUCTUREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_DATASTRUCTUREID_G_U_GROUPID_2 =
		"typeStructureLink.groupId = ? AND ";

	private static final String _FINDER_COLUMN_DATASTRUCTUREID_G_U_USERID_2 =
		"typeStructureLink.userId = ? AND ";

	private static final String
		_FINDER_COLUMN_DATASTRUCTUREID_G_U_DATASTRUCTUREID_2 =
			"typeStructureLink.dataStructureId = ?";

	private FinderPath _finderPathWithPaginationFindByVerified;
	private FinderPath _finderPathWithoutPaginationFindByVerified;
	private FinderPath _finderPathCountByVerified;

	/**
	 * Returns all the type structure links where verified = &#63;.
	 *
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified(boolean verified) {
		return findByVerified(
			verified, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type structure links where verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified(
		boolean verified, int start, int end) {

		return findByVerified(verified, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links where verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified(
		boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findByVerified(verified, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links where verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified(
		boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVerified;
				finderArgs = new Object[] {verified};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVerified;
			finderArgs = new Object[] {verified, start, end, orderByComparator};
		}

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeStructureLink typeStructureLink : list) {
					if (verified != typeStructureLink.isVerified()) {
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

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_VERIFIED_VERIFIED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(verified);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Returns the first type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByVerified_First(
			boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByVerified_First(
			verified, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("verified=");
		sb.append(verified);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the first type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByVerified_First(
		boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		List<TypeStructureLink> list = findByVerified(
			verified, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByVerified_Last(
			boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByVerified_Last(
			verified, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("verified=");
		sb.append(verified);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the last type structure link in the ordered set where verified = &#63;.
	 *
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByVerified_Last(
		boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		int count = countByVerified(verified);

		if (count == 0) {
			return null;
		}

		List<TypeStructureLink> list = findByVerified(
			verified, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where verified = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink[] findByVerified_PrevAndNext(
			long dataTypeId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink[] array = new TypeStructureLinkImpl[3];

			array[0] = getByVerified_PrevAndNext(
				session, typeStructureLink, verified, orderByComparator, true);

			array[1] = typeStructureLink;

			array[2] = getByVerified_PrevAndNext(
				session, typeStructureLink, verified, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeStructureLink getByVerified_PrevAndNext(
		Session session, TypeStructureLink typeStructureLink, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

		sb.append(_FINDER_COLUMN_VERIFIED_VERIFIED_2);

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
			sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(verified);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						typeStructureLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeStructureLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type structure links where verified = &#63; from the database.
	 *
	 * @param verified the verified
	 */
	@Override
	public void removeByVerified(boolean verified) {
		for (TypeStructureLink typeStructureLink :
				findByVerified(
					verified, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links where verified = &#63;.
	 *
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByVerified(boolean verified) {
		FinderPath finderPath = _finderPathCountByVerified;

		Object[] finderArgs = new Object[] {verified};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_VERIFIED_VERIFIED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(verified);

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

	private static final String _FINDER_COLUMN_VERIFIED_VERIFIED_2 =
		"typeStructureLink.verified = ?";

	private FinderPath _finderPathWithPaginationFindByVerified_G;
	private FinderPath _finderPathWithoutPaginationFindByVerified_G;
	private FinderPath _finderPathCountByVerified_G;

	/**
	 * Returns all the type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified) {

		return findByVerified_G(
			groupId, verified, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified, int start, int end) {

		return findByVerified_G(groupId, verified, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findByVerified_G(
			groupId, verified, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_G(
		long groupId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVerified_G;
				finderArgs = new Object[] {groupId, verified};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVerified_G;
			finderArgs = new Object[] {
				groupId, verified, start, end, orderByComparator
			};
		}

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeStructureLink typeStructureLink : list) {
					if ((groupId != typeStructureLink.getGroupId()) ||
						(verified != typeStructureLink.isVerified())) {

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

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_VERIFIED_G_GROUPID_2);

			sb.append(_FINDER_COLUMN_VERIFIED_G_VERIFIED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(verified);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Returns the first type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByVerified_G_First(
			long groupId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByVerified_G_First(
			groupId, verified, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", verified=");
		sb.append(verified);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByVerified_G_First(
		long groupId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		List<TypeStructureLink> list = findByVerified_G(
			groupId, verified, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByVerified_G_Last(
			long groupId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByVerified_G_Last(
			groupId, verified, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", verified=");
		sb.append(verified);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByVerified_G_Last(
		long groupId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		int count = countByVerified_G(groupId, verified);

		if (count == 0) {
			return null;
		}

		List<TypeStructureLink> list = findByVerified_G(
			groupId, verified, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63; and verified = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink[] findByVerified_G_PrevAndNext(
			long dataTypeId, long groupId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink[] array = new TypeStructureLinkImpl[3];

			array[0] = getByVerified_G_PrevAndNext(
				session, typeStructureLink, groupId, verified,
				orderByComparator, true);

			array[1] = typeStructureLink;

			array[2] = getByVerified_G_PrevAndNext(
				session, typeStructureLink, groupId, verified,
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

	protected TypeStructureLink getByVerified_G_PrevAndNext(
		Session session, TypeStructureLink typeStructureLink, long groupId,
		boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

		sb.append(_FINDER_COLUMN_VERIFIED_G_GROUPID_2);

		sb.append(_FINDER_COLUMN_VERIFIED_G_VERIFIED_2);

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
			sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(verified);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						typeStructureLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeStructureLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type structure links where groupId = &#63; and verified = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 */
	@Override
	public void removeByVerified_G(long groupId, boolean verified) {
		for (TypeStructureLink typeStructureLink :
				findByVerified_G(
					groupId, verified, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByVerified_G(long groupId, boolean verified) {
		FinderPath finderPath = _finderPathCountByVerified_G;

		Object[] finderArgs = new Object[] {groupId, verified};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_VERIFIED_G_GROUPID_2);

			sb.append(_FINDER_COLUMN_VERIFIED_G_VERIFIED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(verified);

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

	private static final String _FINDER_COLUMN_VERIFIED_G_GROUPID_2 =
		"typeStructureLink.groupId = ? AND ";

	private static final String _FINDER_COLUMN_VERIFIED_G_VERIFIED_2 =
		"typeStructureLink.verified = ?";

	private FinderPath _finderPathWithPaginationFindByVerified_U;
	private FinderPath _finderPathWithoutPaginationFindByVerified_U;
	private FinderPath _finderPathCountByVerified_U;

	/**
	 * Returns all the type structure links where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified) {

		return findByVerified_U(
			userId, verified, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type structure links where userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified, int start, int end) {

		return findByVerified_U(userId, verified, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findByVerified_U(
			userId, verified, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_U(
		long userId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVerified_U;
				finderArgs = new Object[] {userId, verified};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVerified_U;
			finderArgs = new Object[] {
				userId, verified, start, end, orderByComparator
			};
		}

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeStructureLink typeStructureLink : list) {
					if ((userId != typeStructureLink.getUserId()) ||
						(verified != typeStructureLink.isVerified())) {

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

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_VERIFIED_U_USERID_2);

			sb.append(_FINDER_COLUMN_VERIFIED_U_VERIFIED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(verified);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Returns the first type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByVerified_U_First(
			long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByVerified_U_First(
			userId, verified, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", verified=");
		sb.append(verified);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByVerified_U_First(
		long userId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		List<TypeStructureLink> list = findByVerified_U(
			userId, verified, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByVerified_U_Last(
			long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByVerified_U_Last(
			userId, verified, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", verified=");
		sb.append(verified);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByVerified_U_Last(
		long userId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		int count = countByVerified_U(userId, verified);

		if (count == 0) {
			return null;
		}

		List<TypeStructureLink> list = findByVerified_U(
			userId, verified, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where userId = &#63; and verified = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink[] findByVerified_U_PrevAndNext(
			long dataTypeId, long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink[] array = new TypeStructureLinkImpl[3];

			array[0] = getByVerified_U_PrevAndNext(
				session, typeStructureLink, userId, verified, orderByComparator,
				true);

			array[1] = typeStructureLink;

			array[2] = getByVerified_U_PrevAndNext(
				session, typeStructureLink, userId, verified, orderByComparator,
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

	protected TypeStructureLink getByVerified_U_PrevAndNext(
		Session session, TypeStructureLink typeStructureLink, long userId,
		boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

		sb.append(_FINDER_COLUMN_VERIFIED_U_USERID_2);

		sb.append(_FINDER_COLUMN_VERIFIED_U_VERIFIED_2);

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
			sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(verified);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						typeStructureLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeStructureLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type structure links where userId = &#63; and verified = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 */
	@Override
	public void removeByVerified_U(long userId, boolean verified) {
		for (TypeStructureLink typeStructureLink :
				findByVerified_U(
					userId, verified, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links where userId = &#63; and verified = &#63;.
	 *
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByVerified_U(long userId, boolean verified) {
		FinderPath finderPath = _finderPathCountByVerified_U;

		Object[] finderArgs = new Object[] {userId, verified};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_VERIFIED_U_USERID_2);

			sb.append(_FINDER_COLUMN_VERIFIED_U_VERIFIED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(verified);

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

	private static final String _FINDER_COLUMN_VERIFIED_U_USERID_2 =
		"typeStructureLink.userId = ? AND ";

	private static final String _FINDER_COLUMN_VERIFIED_U_VERIFIED_2 =
		"typeStructureLink.verified = ?";

	private FinderPath _finderPathWithPaginationFindByVerified_G_U;
	private FinderPath _finderPathWithoutPaginationFindByVerified_G_U;
	private FinderPath _finderPathCountByVerified_G_U;

	/**
	 * Returns all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified) {

		return findByVerified_G_U(
			groupId, userId, verified, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified, int start, int end) {

		return findByVerified_G_U(groupId, userId, verified, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findByVerified_G_U(
			groupId, userId, verified, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByVerified_G_U(
		long groupId, long userId, boolean verified, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVerified_G_U;
				finderArgs = new Object[] {groupId, userId, verified};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVerified_G_U;
			finderArgs = new Object[] {
				groupId, userId, verified, start, end, orderByComparator
			};
		}

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeStructureLink typeStructureLink : list) {
					if ((groupId != typeStructureLink.getGroupId()) ||
						(userId != typeStructureLink.getUserId()) ||
						(verified != typeStructureLink.isVerified())) {

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

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_VERIFIED_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_VERIFIED_G_U_USERID_2);

			sb.append(_FINDER_COLUMN_VERIFIED_G_U_VERIFIED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(verified);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByVerified_G_U_First(
			long groupId, long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByVerified_G_U_First(
			groupId, userId, verified, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", verified=");
		sb.append(verified);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByVerified_G_U_First(
		long groupId, long userId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		List<TypeStructureLink> list = findByVerified_G_U(
			groupId, userId, verified, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByVerified_G_U_Last(
			long groupId, long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByVerified_G_U_Last(
			groupId, userId, verified, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", verified=");
		sb.append(verified);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByVerified_G_U_Last(
		long groupId, long userId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		int count = countByVerified_G_U(groupId, userId, verified);

		if (count == 0) {
			return null;
		}

		List<TypeStructureLink> list = findByVerified_G_U(
			groupId, userId, verified, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink[] findByVerified_G_U_PrevAndNext(
			long dataTypeId, long groupId, long userId, boolean verified,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink[] array = new TypeStructureLinkImpl[3];

			array[0] = getByVerified_G_U_PrevAndNext(
				session, typeStructureLink, groupId, userId, verified,
				orderByComparator, true);

			array[1] = typeStructureLink;

			array[2] = getByVerified_G_U_PrevAndNext(
				session, typeStructureLink, groupId, userId, verified,
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

	protected TypeStructureLink getByVerified_G_U_PrevAndNext(
		Session session, TypeStructureLink typeStructureLink, long groupId,
		long userId, boolean verified,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

		sb.append(_FINDER_COLUMN_VERIFIED_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_VERIFIED_G_U_USERID_2);

		sb.append(_FINDER_COLUMN_VERIFIED_G_U_VERIFIED_2);

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
			sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(verified);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						typeStructureLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeStructureLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type structure links where groupId = &#63; and userId = &#63; and verified = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 */
	@Override
	public void removeByVerified_G_U(
		long groupId, long userId, boolean verified) {

		for (TypeStructureLink typeStructureLink :
				findByVerified_G_U(
					groupId, userId, verified, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63; and verified = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param verified the verified
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByVerified_G_U(
		long groupId, long userId, boolean verified) {

		FinderPath finderPath = _finderPathCountByVerified_G_U;

		Object[] finderArgs = new Object[] {groupId, userId, verified};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_VERIFIED_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_VERIFIED_G_U_USERID_2);

			sb.append(_FINDER_COLUMN_VERIFIED_G_U_VERIFIED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(verified);

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

	private static final String _FINDER_COLUMN_VERIFIED_G_U_GROUPID_2 =
		"typeStructureLink.groupId = ? AND ";

	private static final String _FINDER_COLUMN_VERIFIED_G_U_USERID_2 =
		"typeStructureLink.userId = ? AND ";

	private static final String _FINDER_COLUMN_VERIFIED_G_U_VERIFIED_2 =
		"typeStructureLink.verified = ?";

	private FinderPath _finderPathWithPaginationFindByFreezed;
	private FinderPath _finderPathWithoutPaginationFindByFreezed;
	private FinderPath _finderPathCountByFreezed;

	/**
	 * Returns all the type structure links where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed(boolean freezed) {
		return findByFreezed(
			freezed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type structure links where freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed(
		boolean freezed, int start, int end) {

		return findByFreezed(freezed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links where freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed(
		boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findByFreezed(freezed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links where freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed(
		boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFreezed;
				finderArgs = new Object[] {freezed};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFreezed;
			finderArgs = new Object[] {freezed, start, end, orderByComparator};
		}

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeStructureLink typeStructureLink : list) {
					if (freezed != typeStructureLink.isFreezed()) {
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

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_FREEZED_FREEZED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(freezed);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Returns the first type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByFreezed_First(
			boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByFreezed_First(
			freezed, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("freezed=");
		sb.append(freezed);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the first type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByFreezed_First(
		boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		List<TypeStructureLink> list = findByFreezed(
			freezed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByFreezed_Last(
			boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByFreezed_Last(
			freezed, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("freezed=");
		sb.append(freezed);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the last type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByFreezed_Last(
		boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		int count = countByFreezed(freezed);

		if (count == 0) {
			return null;
		}

		List<TypeStructureLink> list = findByFreezed(
			freezed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where freezed = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink[] findByFreezed_PrevAndNext(
			long dataTypeId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink[] array = new TypeStructureLinkImpl[3];

			array[0] = getByFreezed_PrevAndNext(
				session, typeStructureLink, freezed, orderByComparator, true);

			array[1] = typeStructureLink;

			array[2] = getByFreezed_PrevAndNext(
				session, typeStructureLink, freezed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TypeStructureLink getByFreezed_PrevAndNext(
		Session session, TypeStructureLink typeStructureLink, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

		sb.append(_FINDER_COLUMN_FREEZED_FREEZED_2);

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
			sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(freezed);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						typeStructureLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeStructureLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type structure links where freezed = &#63; from the database.
	 *
	 * @param freezed the freezed
	 */
	@Override
	public void removeByFreezed(boolean freezed) {
		for (TypeStructureLink typeStructureLink :
				findByFreezed(
					freezed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links where freezed = &#63;.
	 *
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByFreezed(boolean freezed) {
		FinderPath finderPath = _finderPathCountByFreezed;

		Object[] finderArgs = new Object[] {freezed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_FREEZED_FREEZED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(freezed);

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

	private static final String _FINDER_COLUMN_FREEZED_FREEZED_2 =
		"typeStructureLink.freezed = ?";

	private FinderPath _finderPathWithPaginationFindByFreezed_G;
	private FinderPath _finderPathWithoutPaginationFindByFreezed_G;
	private FinderPath _finderPathCountByFreezed_G;

	/**
	 * Returns all the type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed) {

		return findByFreezed_G(
			groupId, freezed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed, int start, int end) {

		return findByFreezed_G(groupId, freezed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findByFreezed_G(
			groupId, freezed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_G(
		long groupId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFreezed_G;
				finderArgs = new Object[] {groupId, freezed};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFreezed_G;
			finderArgs = new Object[] {
				groupId, freezed, start, end, orderByComparator
			};
		}

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeStructureLink typeStructureLink : list) {
					if ((groupId != typeStructureLink.getGroupId()) ||
						(freezed != typeStructureLink.isFreezed())) {

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

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_FREEZED_G_GROUPID_2);

			sb.append(_FINDER_COLUMN_FREEZED_G_FREEZED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(freezed);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Returns the first type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByFreezed_G_First(
			long groupId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByFreezed_G_First(
			groupId, freezed, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", freezed=");
		sb.append(freezed);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByFreezed_G_First(
		long groupId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		List<TypeStructureLink> list = findByFreezed_G(
			groupId, freezed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByFreezed_G_Last(
			long groupId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByFreezed_G_Last(
			groupId, freezed, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", freezed=");
		sb.append(freezed);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByFreezed_G_Last(
		long groupId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		int count = countByFreezed_G(groupId, freezed);

		if (count == 0) {
			return null;
		}

		List<TypeStructureLink> list = findByFreezed_G(
			groupId, freezed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63; and freezed = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink[] findByFreezed_G_PrevAndNext(
			long dataTypeId, long groupId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink[] array = new TypeStructureLinkImpl[3];

			array[0] = getByFreezed_G_PrevAndNext(
				session, typeStructureLink, groupId, freezed, orderByComparator,
				true);

			array[1] = typeStructureLink;

			array[2] = getByFreezed_G_PrevAndNext(
				session, typeStructureLink, groupId, freezed, orderByComparator,
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

	protected TypeStructureLink getByFreezed_G_PrevAndNext(
		Session session, TypeStructureLink typeStructureLink, long groupId,
		boolean freezed, OrderByComparator<TypeStructureLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

		sb.append(_FINDER_COLUMN_FREEZED_G_GROUPID_2);

		sb.append(_FINDER_COLUMN_FREEZED_G_FREEZED_2);

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
			sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(freezed);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						typeStructureLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeStructureLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type structure links where groupId = &#63; and freezed = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 */
	@Override
	public void removeByFreezed_G(long groupId, boolean freezed) {
		for (TypeStructureLink typeStructureLink :
				findByFreezed_G(
					groupId, freezed, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByFreezed_G(long groupId, boolean freezed) {
		FinderPath finderPath = _finderPathCountByFreezed_G;

		Object[] finderArgs = new Object[] {groupId, freezed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_FREEZED_G_GROUPID_2);

			sb.append(_FINDER_COLUMN_FREEZED_G_FREEZED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(freezed);

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

	private static final String _FINDER_COLUMN_FREEZED_G_GROUPID_2 =
		"typeStructureLink.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FREEZED_G_FREEZED_2 =
		"typeStructureLink.freezed = ?";

	private FinderPath _finderPathWithPaginationFindByFreezed_U;
	private FinderPath _finderPathWithoutPaginationFindByFreezed_U;
	private FinderPath _finderPathCountByFreezed_U;

	/**
	 * Returns all the type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed) {

		return findByFreezed_U(
			userId, freezed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed, int start, int end) {

		return findByFreezed_U(userId, freezed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findByFreezed_U(
			userId, freezed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_U(
		long userId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFreezed_U;
				finderArgs = new Object[] {userId, freezed};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFreezed_U;
			finderArgs = new Object[] {
				userId, freezed, start, end, orderByComparator
			};
		}

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeStructureLink typeStructureLink : list) {
					if ((userId != typeStructureLink.getUserId()) ||
						(freezed != typeStructureLink.isFreezed())) {

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

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_FREEZED_U_USERID_2);

			sb.append(_FINDER_COLUMN_FREEZED_U_FREEZED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(freezed);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Returns the first type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByFreezed_U_First(
			long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByFreezed_U_First(
			userId, freezed, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", freezed=");
		sb.append(freezed);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the first type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByFreezed_U_First(
		long userId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		List<TypeStructureLink> list = findByFreezed_U(
			userId, freezed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByFreezed_U_Last(
			long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByFreezed_U_Last(
			userId, freezed, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", freezed=");
		sb.append(freezed);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the last type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByFreezed_U_Last(
		long userId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		int count = countByFreezed_U(userId, freezed);

		if (count == 0) {
			return null;
		}

		List<TypeStructureLink> list = findByFreezed_U(
			userId, freezed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where userId = &#63; and freezed = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink[] findByFreezed_U_PrevAndNext(
			long dataTypeId, long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink[] array = new TypeStructureLinkImpl[3];

			array[0] = getByFreezed_U_PrevAndNext(
				session, typeStructureLink, userId, freezed, orderByComparator,
				true);

			array[1] = typeStructureLink;

			array[2] = getByFreezed_U_PrevAndNext(
				session, typeStructureLink, userId, freezed, orderByComparator,
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

	protected TypeStructureLink getByFreezed_U_PrevAndNext(
		Session session, TypeStructureLink typeStructureLink, long userId,
		boolean freezed, OrderByComparator<TypeStructureLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

		sb.append(_FINDER_COLUMN_FREEZED_U_USERID_2);

		sb.append(_FINDER_COLUMN_FREEZED_U_FREEZED_2);

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
			sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(freezed);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						typeStructureLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeStructureLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type structure links where userId = &#63; and freezed = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 */
	@Override
	public void removeByFreezed_U(long userId, boolean freezed) {
		for (TypeStructureLink typeStructureLink :
				findByFreezed_U(
					userId, freezed, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links where userId = &#63; and freezed = &#63;.
	 *
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByFreezed_U(long userId, boolean freezed) {
		FinderPath finderPath = _finderPathCountByFreezed_U;

		Object[] finderArgs = new Object[] {userId, freezed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_FREEZED_U_USERID_2);

			sb.append(_FINDER_COLUMN_FREEZED_U_FREEZED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(freezed);

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

	private static final String _FINDER_COLUMN_FREEZED_U_USERID_2 =
		"typeStructureLink.userId = ? AND ";

	private static final String _FINDER_COLUMN_FREEZED_U_FREEZED_2 =
		"typeStructureLink.freezed = ?";

	private FinderPath _finderPathWithPaginationFindByFreezed_G_U;
	private FinderPath _finderPathWithoutPaginationFindByFreezed_G_U;
	private FinderPath _finderPathCountByFreezed_G_U;

	/**
	 * Returns all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed) {

		return findByFreezed_G_U(
			groupId, userId, freezed, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed, int start, int end) {

		return findByFreezed_G_U(groupId, userId, freezed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findByFreezed_G_U(
			groupId, userId, freezed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching type structure links
	 */
	@Override
	public List<TypeStructureLink> findByFreezed_G_U(
		long groupId, long userId, boolean freezed, int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFreezed_G_U;
				finderArgs = new Object[] {groupId, userId, freezed};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFreezed_G_U;
			finderArgs = new Object[] {
				groupId, userId, freezed, start, end, orderByComparator
			};
		}

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TypeStructureLink typeStructureLink : list) {
					if ((groupId != typeStructureLink.getGroupId()) ||
						(userId != typeStructureLink.getUserId()) ||
						(freezed != typeStructureLink.isFreezed())) {

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

			sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_FREEZED_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_FREEZED_G_U_USERID_2);

			sb.append(_FINDER_COLUMN_FREEZED_G_U_FREEZED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(freezed);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByFreezed_G_U_First(
			long groupId, long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByFreezed_G_U_First(
			groupId, userId, freezed, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", freezed=");
		sb.append(freezed);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the first type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByFreezed_G_U_First(
		long groupId, long userId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		List<TypeStructureLink> list = findByFreezed_G_U(
			groupId, userId, freezed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link
	 * @throws NoSuchTypeStructureLinkException if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink findByFreezed_G_U_Last(
			long groupId, long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByFreezed_G_U_Last(
			groupId, userId, freezed, orderByComparator);

		if (typeStructureLink != null) {
			return typeStructureLink;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", freezed=");
		sb.append(freezed);

		sb.append("}");

		throw new NoSuchTypeStructureLinkException(sb.toString());
	}

	/**
	 * Returns the last type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching type structure link, or <code>null</code> if a matching type structure link could not be found
	 */
	@Override
	public TypeStructureLink fetchByFreezed_G_U_Last(
		long groupId, long userId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		int count = countByFreezed_G_U(groupId, userId, freezed);

		if (count == 0) {
			return null;
		}

		List<TypeStructureLink> list = findByFreezed_G_U(
			groupId, userId, freezed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the type structure links before and after the current type structure link in the ordered set where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param dataTypeId the primary key of the current type structure link
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink[] findByFreezed_G_U_PrevAndNext(
			long dataTypeId, long groupId, long userId, boolean freezed,
			OrderByComparator<TypeStructureLink> orderByComparator)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = findByPrimaryKey(dataTypeId);

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink[] array = new TypeStructureLinkImpl[3];

			array[0] = getByFreezed_G_U_PrevAndNext(
				session, typeStructureLink, groupId, userId, freezed,
				orderByComparator, true);

			array[1] = typeStructureLink;

			array[2] = getByFreezed_G_U_PrevAndNext(
				session, typeStructureLink, groupId, userId, freezed,
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

	protected TypeStructureLink getByFreezed_G_U_PrevAndNext(
		Session session, TypeStructureLink typeStructureLink, long groupId,
		long userId, boolean freezed,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		sb.append(_SQL_SELECT_TYPESTRUCTURELINK_WHERE);

		sb.append(_FINDER_COLUMN_FREEZED_G_U_GROUPID_2);

		sb.append(_FINDER_COLUMN_FREEZED_G_U_USERID_2);

		sb.append(_FINDER_COLUMN_FREEZED_G_U_FREEZED_2);

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
			sb.append(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		queryPos.add(freezed);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						typeStructureLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TypeStructureLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the type structure links where groupId = &#63; and userId = &#63; and freezed = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 */
	@Override
	public void removeByFreezed_G_U(
		long groupId, long userId, boolean freezed) {

		for (TypeStructureLink typeStructureLink :
				findByFreezed_G_U(
					groupId, userId, freezed, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links where groupId = &#63; and userId = &#63; and freezed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param freezed the freezed
	 * @return the number of matching type structure links
	 */
	@Override
	public int countByFreezed_G_U(long groupId, long userId, boolean freezed) {
		FinderPath finderPath = _finderPathCountByFreezed_G_U;

		Object[] finderArgs = new Object[] {groupId, userId, freezed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TYPESTRUCTURELINK_WHERE);

			sb.append(_FINDER_COLUMN_FREEZED_G_U_GROUPID_2);

			sb.append(_FINDER_COLUMN_FREEZED_G_U_USERID_2);

			sb.append(_FINDER_COLUMN_FREEZED_G_U_FREEZED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(freezed);

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

	private static final String _FINDER_COLUMN_FREEZED_G_U_GROUPID_2 =
		"typeStructureLink.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FREEZED_G_U_USERID_2 =
		"typeStructureLink.userId = ? AND ";

	private static final String _FINDER_COLUMN_FREEZED_G_U_FREEZED_2 =
		"typeStructureLink.freezed = ?";

	public TypeStructureLinkPersistenceImpl() {
		setModelClass(TypeStructureLink.class);

		setModelImplClass(TypeStructureLinkImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the type structure link in the entity cache if it is enabled.
	 *
	 * @param typeStructureLink the type structure link
	 */
	@Override
	public void cacheResult(TypeStructureLink typeStructureLink) {
		entityCache.putResult(
			entityCacheEnabled, TypeStructureLinkImpl.class,
			typeStructureLink.getPrimaryKey(), typeStructureLink);

		finderCache.putResult(
			_finderPathFetchByDataStructureId,
			new Object[] {typeStructureLink.getDataStructureId()},
			typeStructureLink);

		finderCache.putResult(
			_finderPathFetchByDataStructureId_G,
			new Object[] {
				typeStructureLink.getGroupId(),
				typeStructureLink.getDataStructureId()
			},
			typeStructureLink);

		finderCache.putResult(
			_finderPathFetchByDataStructureId_U,
			new Object[] {
				typeStructureLink.getUserId(),
				typeStructureLink.getDataStructureId()
			},
			typeStructureLink);

		finderCache.putResult(
			_finderPathFetchByDataStructureId_G_U,
			new Object[] {
				typeStructureLink.getGroupId(), typeStructureLink.getUserId(),
				typeStructureLink.getDataStructureId()
			},
			typeStructureLink);

		typeStructureLink.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the type structure links in the entity cache if it is enabled.
	 *
	 * @param typeStructureLinks the type structure links
	 */
	@Override
	public void cacheResult(List<TypeStructureLink> typeStructureLinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (typeStructureLinks.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TypeStructureLink typeStructureLink : typeStructureLinks) {
			if (entityCache.getResult(
					entityCacheEnabled, TypeStructureLinkImpl.class,
					typeStructureLink.getPrimaryKey()) == null) {

				cacheResult(typeStructureLink);
			}
			else {
				typeStructureLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all type structure links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TypeStructureLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the type structure link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TypeStructureLink typeStructureLink) {
		entityCache.removeResult(
			entityCacheEnabled, TypeStructureLinkImpl.class,
			typeStructureLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(TypeStructureLinkModelImpl)typeStructureLink, true);
	}

	@Override
	public void clearCache(List<TypeStructureLink> typeStructureLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TypeStructureLink typeStructureLink : typeStructureLinks) {
			entityCache.removeResult(
				entityCacheEnabled, TypeStructureLinkImpl.class,
				typeStructureLink.getPrimaryKey());

			clearUniqueFindersCache(
				(TypeStructureLinkModelImpl)typeStructureLink, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TypeStructureLinkImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TypeStructureLinkModelImpl typeStructureLinkModelImpl) {

		Object[] args = new Object[] {
			typeStructureLinkModelImpl.getDataStructureId()
		};

		finderCache.putResult(
			_finderPathCountByDataStructureId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDataStructureId, args, typeStructureLinkModelImpl,
			false);

		args = new Object[] {
			typeStructureLinkModelImpl.getGroupId(),
			typeStructureLinkModelImpl.getDataStructureId()
		};

		finderCache.putResult(
			_finderPathCountByDataStructureId_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDataStructureId_G, args,
			typeStructureLinkModelImpl, false);

		args = new Object[] {
			typeStructureLinkModelImpl.getUserId(),
			typeStructureLinkModelImpl.getDataStructureId()
		};

		finderCache.putResult(
			_finderPathCountByDataStructureId_U, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDataStructureId_U, args,
			typeStructureLinkModelImpl, false);

		args = new Object[] {
			typeStructureLinkModelImpl.getGroupId(),
			typeStructureLinkModelImpl.getUserId(),
			typeStructureLinkModelImpl.getDataStructureId()
		};

		finderCache.putResult(
			_finderPathCountByDataStructureId_G_U, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByDataStructureId_G_U, args,
			typeStructureLinkModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TypeStructureLinkModelImpl typeStructureLinkModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				typeStructureLinkModelImpl.getDataStructureId()
			};

			finderCache.removeResult(_finderPathCountByDataStructureId, args);
			finderCache.removeResult(_finderPathFetchByDataStructureId, args);
		}

		if ((typeStructureLinkModelImpl.getColumnBitmask() &
			 _finderPathFetchByDataStructureId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				typeStructureLinkModelImpl.getOriginalDataStructureId()
			};

			finderCache.removeResult(_finderPathCountByDataStructureId, args);
			finderCache.removeResult(_finderPathFetchByDataStructureId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				typeStructureLinkModelImpl.getGroupId(),
				typeStructureLinkModelImpl.getDataStructureId()
			};

			finderCache.removeResult(_finderPathCountByDataStructureId_G, args);
			finderCache.removeResult(_finderPathFetchByDataStructureId_G, args);
		}

		if ((typeStructureLinkModelImpl.getColumnBitmask() &
			 _finderPathFetchByDataStructureId_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				typeStructureLinkModelImpl.getOriginalGroupId(),
				typeStructureLinkModelImpl.getOriginalDataStructureId()
			};

			finderCache.removeResult(_finderPathCountByDataStructureId_G, args);
			finderCache.removeResult(_finderPathFetchByDataStructureId_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				typeStructureLinkModelImpl.getUserId(),
				typeStructureLinkModelImpl.getDataStructureId()
			};

			finderCache.removeResult(_finderPathCountByDataStructureId_U, args);
			finderCache.removeResult(_finderPathFetchByDataStructureId_U, args);
		}

		if ((typeStructureLinkModelImpl.getColumnBitmask() &
			 _finderPathFetchByDataStructureId_U.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				typeStructureLinkModelImpl.getOriginalUserId(),
				typeStructureLinkModelImpl.getOriginalDataStructureId()
			};

			finderCache.removeResult(_finderPathCountByDataStructureId_U, args);
			finderCache.removeResult(_finderPathFetchByDataStructureId_U, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				typeStructureLinkModelImpl.getGroupId(),
				typeStructureLinkModelImpl.getUserId(),
				typeStructureLinkModelImpl.getDataStructureId()
			};

			finderCache.removeResult(
				_finderPathCountByDataStructureId_G_U, args);
			finderCache.removeResult(
				_finderPathFetchByDataStructureId_G_U, args);
		}

		if ((typeStructureLinkModelImpl.getColumnBitmask() &
			 _finderPathFetchByDataStructureId_G_U.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				typeStructureLinkModelImpl.getOriginalGroupId(),
				typeStructureLinkModelImpl.getOriginalUserId(),
				typeStructureLinkModelImpl.getOriginalDataStructureId()
			};

			finderCache.removeResult(
				_finderPathCountByDataStructureId_G_U, args);
			finderCache.removeResult(
				_finderPathFetchByDataStructureId_G_U, args);
		}
	}

	/**
	 * Creates a new type structure link with the primary key. Does not add the type structure link to the database.
	 *
	 * @param dataTypeId the primary key for the new type structure link
	 * @return the new type structure link
	 */
	@Override
	public TypeStructureLink create(long dataTypeId) {
		TypeStructureLink typeStructureLink = new TypeStructureLinkImpl();

		typeStructureLink.setNew(true);
		typeStructureLink.setPrimaryKey(dataTypeId);

		return typeStructureLink;
	}

	/**
	 * Removes the type structure link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link that was removed
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink remove(long dataTypeId)
		throws NoSuchTypeStructureLinkException {

		return remove((Serializable)dataTypeId);
	}

	/**
	 * Removes the type structure link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the type structure link
	 * @return the type structure link that was removed
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink remove(Serializable primaryKey)
		throws NoSuchTypeStructureLinkException {

		Session session = null;

		try {
			session = openSession();

			TypeStructureLink typeStructureLink =
				(TypeStructureLink)session.get(
					TypeStructureLinkImpl.class, primaryKey);

			if (typeStructureLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTypeStructureLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(typeStructureLink);
		}
		catch (NoSuchTypeStructureLinkException noSuchEntityException) {
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
	protected TypeStructureLink removeImpl(
		TypeStructureLink typeStructureLink) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(typeStructureLink)) {
				typeStructureLink = (TypeStructureLink)session.get(
					TypeStructureLinkImpl.class,
					typeStructureLink.getPrimaryKeyObj());
			}

			if (typeStructureLink != null) {
				session.delete(typeStructureLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (typeStructureLink != null) {
			clearCache(typeStructureLink);
		}

		return typeStructureLink;
	}

	@Override
	public TypeStructureLink updateImpl(TypeStructureLink typeStructureLink) {
		boolean isNew = typeStructureLink.isNew();

		if (!(typeStructureLink instanceof TypeStructureLinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(typeStructureLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					typeStructureLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in typeStructureLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TypeStructureLink implementation " +
					typeStructureLink.getClass());
		}

		TypeStructureLinkModelImpl typeStructureLinkModelImpl =
			(TypeStructureLinkModelImpl)typeStructureLink;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(typeStructureLink);

				typeStructureLink.setNew(false);
			}
			else {
				typeStructureLink = (TypeStructureLink)session.merge(
					typeStructureLink);
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
				typeStructureLinkModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {typeStructureLinkModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				typeStructureLinkModelImpl.getGroupId(),
				typeStructureLinkModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByG_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_U, args);

			args = new Object[] {typeStructureLinkModelImpl.isVerified()};

			finderCache.removeResult(_finderPathCountByVerified, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVerified, args);

			args = new Object[] {
				typeStructureLinkModelImpl.getGroupId(),
				typeStructureLinkModelImpl.isVerified()
			};

			finderCache.removeResult(_finderPathCountByVerified_G, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVerified_G, args);

			args = new Object[] {
				typeStructureLinkModelImpl.getUserId(),
				typeStructureLinkModelImpl.isVerified()
			};

			finderCache.removeResult(_finderPathCountByVerified_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVerified_U, args);

			args = new Object[] {
				typeStructureLinkModelImpl.getGroupId(),
				typeStructureLinkModelImpl.getUserId(),
				typeStructureLinkModelImpl.isVerified()
			};

			finderCache.removeResult(_finderPathCountByVerified_G_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVerified_G_U, args);

			args = new Object[] {typeStructureLinkModelImpl.isFreezed()};

			finderCache.removeResult(_finderPathCountByFreezed, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFreezed, args);

			args = new Object[] {
				typeStructureLinkModelImpl.getGroupId(),
				typeStructureLinkModelImpl.isFreezed()
			};

			finderCache.removeResult(_finderPathCountByFreezed_G, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFreezed_G, args);

			args = new Object[] {
				typeStructureLinkModelImpl.getUserId(),
				typeStructureLinkModelImpl.isFreezed()
			};

			finderCache.removeResult(_finderPathCountByFreezed_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFreezed_U, args);

			args = new Object[] {
				typeStructureLinkModelImpl.getGroupId(),
				typeStructureLinkModelImpl.getUserId(),
				typeStructureLinkModelImpl.isFreezed()
			};

			finderCache.removeResult(_finderPathCountByFreezed_G_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFreezed_G_U, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((typeStructureLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					typeStructureLinkModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {typeStructureLinkModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((typeStructureLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeStructureLinkModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {typeStructureLinkModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((typeStructureLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_U.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					typeStructureLinkModelImpl.getOriginalGroupId(),
					typeStructureLinkModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByG_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U, args);

				args = new Object[] {
					typeStructureLinkModelImpl.getGroupId(),
					typeStructureLinkModelImpl.getUserId()
				};

				finderCache.removeResult(_finderPathCountByG_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_U, args);
			}

			if ((typeStructureLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVerified.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeStructureLinkModelImpl.getOriginalVerified()
				};

				finderCache.removeResult(_finderPathCountByVerified, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVerified, args);

				args = new Object[] {typeStructureLinkModelImpl.isVerified()};

				finderCache.removeResult(_finderPathCountByVerified, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVerified, args);
			}

			if ((typeStructureLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVerified_G.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeStructureLinkModelImpl.getOriginalGroupId(),
					typeStructureLinkModelImpl.getOriginalVerified()
				};

				finderCache.removeResult(_finderPathCountByVerified_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVerified_G, args);

				args = new Object[] {
					typeStructureLinkModelImpl.getGroupId(),
					typeStructureLinkModelImpl.isVerified()
				};

				finderCache.removeResult(_finderPathCountByVerified_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVerified_G, args);
			}

			if ((typeStructureLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVerified_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeStructureLinkModelImpl.getOriginalUserId(),
					typeStructureLinkModelImpl.getOriginalVerified()
				};

				finderCache.removeResult(_finderPathCountByVerified_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVerified_U, args);

				args = new Object[] {
					typeStructureLinkModelImpl.getUserId(),
					typeStructureLinkModelImpl.isVerified()
				};

				finderCache.removeResult(_finderPathCountByVerified_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVerified_U, args);
			}

			if ((typeStructureLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVerified_G_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeStructureLinkModelImpl.getOriginalGroupId(),
					typeStructureLinkModelImpl.getOriginalUserId(),
					typeStructureLinkModelImpl.getOriginalVerified()
				};

				finderCache.removeResult(_finderPathCountByVerified_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVerified_G_U, args);

				args = new Object[] {
					typeStructureLinkModelImpl.getGroupId(),
					typeStructureLinkModelImpl.getUserId(),
					typeStructureLinkModelImpl.isVerified()
				};

				finderCache.removeResult(_finderPathCountByVerified_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVerified_G_U, args);
			}

			if ((typeStructureLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFreezed.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeStructureLinkModelImpl.getOriginalFreezed()
				};

				finderCache.removeResult(_finderPathCountByFreezed, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFreezed, args);

				args = new Object[] {typeStructureLinkModelImpl.isFreezed()};

				finderCache.removeResult(_finderPathCountByFreezed, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFreezed, args);
			}

			if ((typeStructureLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFreezed_G.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeStructureLinkModelImpl.getOriginalGroupId(),
					typeStructureLinkModelImpl.getOriginalFreezed()
				};

				finderCache.removeResult(_finderPathCountByFreezed_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFreezed_G, args);

				args = new Object[] {
					typeStructureLinkModelImpl.getGroupId(),
					typeStructureLinkModelImpl.isFreezed()
				};

				finderCache.removeResult(_finderPathCountByFreezed_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFreezed_G, args);
			}

			if ((typeStructureLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFreezed_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeStructureLinkModelImpl.getOriginalUserId(),
					typeStructureLinkModelImpl.getOriginalFreezed()
				};

				finderCache.removeResult(_finderPathCountByFreezed_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFreezed_U, args);

				args = new Object[] {
					typeStructureLinkModelImpl.getUserId(),
					typeStructureLinkModelImpl.isFreezed()
				};

				finderCache.removeResult(_finderPathCountByFreezed_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFreezed_U, args);
			}

			if ((typeStructureLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFreezed_G_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					typeStructureLinkModelImpl.getOriginalGroupId(),
					typeStructureLinkModelImpl.getOriginalUserId(),
					typeStructureLinkModelImpl.getOriginalFreezed()
				};

				finderCache.removeResult(_finderPathCountByFreezed_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFreezed_G_U, args);

				args = new Object[] {
					typeStructureLinkModelImpl.getGroupId(),
					typeStructureLinkModelImpl.getUserId(),
					typeStructureLinkModelImpl.isFreezed()
				};

				finderCache.removeResult(_finderPathCountByFreezed_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFreezed_G_U, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TypeStructureLinkImpl.class,
			typeStructureLink.getPrimaryKey(), typeStructureLink, false);

		clearUniqueFindersCache(typeStructureLinkModelImpl, false);
		cacheUniqueFindersCache(typeStructureLinkModelImpl);

		typeStructureLink.resetOriginalValues();

		return typeStructureLink;
	}

	/**
	 * Returns the type structure link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the type structure link
	 * @return the type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTypeStructureLinkException {

		TypeStructureLink typeStructureLink = fetchByPrimaryKey(primaryKey);

		if (typeStructureLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTypeStructureLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return typeStructureLink;
	}

	/**
	 * Returns the type structure link with the primary key or throws a <code>NoSuchTypeStructureLinkException</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link
	 * @throws NoSuchTypeStructureLinkException if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink findByPrimaryKey(long dataTypeId)
		throws NoSuchTypeStructureLinkException {

		return findByPrimaryKey((Serializable)dataTypeId);
	}

	/**
	 * Returns the type structure link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the type structure link
	 * @return the type structure link, or <code>null</code> if a type structure link with the primary key could not be found
	 */
	@Override
	public TypeStructureLink fetchByPrimaryKey(long dataTypeId) {
		return fetchByPrimaryKey((Serializable)dataTypeId);
	}

	/**
	 * Returns all the type structure links.
	 *
	 * @return the type structure links
	 */
	@Override
	public List<TypeStructureLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the type structure links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @return the range of type structure links
	 */
	@Override
	public List<TypeStructureLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the type structure links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of type structure links
	 */
	@Override
	public List<TypeStructureLink> findAll(
		int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the type structure links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TypeStructureLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of type structure links
	 * @param end the upper bound of the range of type structure links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of type structure links
	 */
	@Override
	public List<TypeStructureLink> findAll(
		int start, int end,
		OrderByComparator<TypeStructureLink> orderByComparator,
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

		List<TypeStructureLink> list = null;

		if (useFinderCache) {
			list = (List<TypeStructureLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TYPESTRUCTURELINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TYPESTRUCTURELINK;

				sql = sql.concat(TypeStructureLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TypeStructureLink>)QueryUtil.list(
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
	 * Removes all the type structure links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TypeStructureLink typeStructureLink : findAll()) {
			remove(typeStructureLink);
		}
	}

	/**
	 * Returns the number of type structure links.
	 *
	 * @return the number of type structure links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TYPESTRUCTURELINK);

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
		return "dataTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TYPESTRUCTURELINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TypeStructureLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the type structure link persistence.
	 */
	@Activate
	public void activate() {
		TypeStructureLinkModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TypeStructureLinkModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			TypeStructureLinkModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			TypeStructureLinkModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			TypeStructureLinkModelImpl.GROUPID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByDataStructureId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDataStructureId",
			new String[] {Long.class.getName()},
			TypeStructureLinkModelImpl.DATASTRUCTUREID_COLUMN_BITMASK);

		_finderPathCountByDataStructureId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataStructureId",
			new String[] {Long.class.getName()});

		_finderPathFetchByDataStructureId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDataStructureId_G",
			new String[] {Long.class.getName(), Long.class.getName()},
			TypeStructureLinkModelImpl.GROUPID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.DATASTRUCTUREID_COLUMN_BITMASK);

		_finderPathCountByDataStructureId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataStructureId_G",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByDataStructureId_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDataStructureId_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			TypeStructureLinkModelImpl.USERID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.DATASTRUCTUREID_COLUMN_BITMASK);

		_finderPathCountByDataStructureId_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataStructureId_U",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByDataStructureId_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDataStructureId_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			TypeStructureLinkModelImpl.GROUPID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.USERID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.DATASTRUCTUREID_COLUMN_BITMASK);

		_finderPathCountByDataStructureId_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataStructureId_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByVerified = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVerified",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVerified = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVerified",
			new String[] {Boolean.class.getName()},
			TypeStructureLinkModelImpl.VERIFIED_COLUMN_BITMASK);

		_finderPathCountByVerified = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVerified",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByVerified_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVerified_G",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVerified_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVerified_G",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			TypeStructureLinkModelImpl.GROUPID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.VERIFIED_COLUMN_BITMASK);

		_finderPathCountByVerified_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVerified_G",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByVerified_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVerified_U",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVerified_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVerified_U",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			TypeStructureLinkModelImpl.USERID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.VERIFIED_COLUMN_BITMASK);

		_finderPathCountByVerified_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVerified_U",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByVerified_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVerified_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVerified_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVerified_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			TypeStructureLinkModelImpl.GROUPID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.USERID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.VERIFIED_COLUMN_BITMASK);

		_finderPathCountByVerified_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVerified_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByFreezed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFreezed",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFreezed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFreezed",
			new String[] {Boolean.class.getName()},
			TypeStructureLinkModelImpl.FREEZED_COLUMN_BITMASK);

		_finderPathCountByFreezed = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFreezed",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByFreezed_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFreezed_G",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFreezed_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFreezed_G",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			TypeStructureLinkModelImpl.GROUPID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.FREEZED_COLUMN_BITMASK);

		_finderPathCountByFreezed_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFreezed_G",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByFreezed_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFreezed_U",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFreezed_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFreezed_U",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			TypeStructureLinkModelImpl.USERID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.FREEZED_COLUMN_BITMASK);

		_finderPathCountByFreezed_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFreezed_U",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByFreezed_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFreezed_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFreezed_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFreezed_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			TypeStructureLinkModelImpl.GROUPID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.USERID_COLUMN_BITMASK |
			TypeStructureLinkModelImpl.FREEZED_COLUMN_BITMASK);

		_finderPathCountByFreezed_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFreezed_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

		_setTypeStructureLinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTypeStructureLinkUtilPersistence(null);

		entityCache.removeCache(TypeStructureLinkImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setTypeStructureLinkUtilPersistence(
		TypeStructureLinkPersistence typeStructureLinkPersistence) {

		try {
			Field field = TypeStructureLinkUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, typeStructureLinkPersistence);
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
				"value.object.column.bitmask.enabled.com.sx.icecap.model.TypeStructureLink"),
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

	private static final String _SQL_SELECT_TYPESTRUCTURELINK =
		"SELECT typeStructureLink FROM TypeStructureLink typeStructureLink";

	private static final String _SQL_SELECT_TYPESTRUCTURELINK_WHERE =
		"SELECT typeStructureLink FROM TypeStructureLink typeStructureLink WHERE ";

	private static final String _SQL_COUNT_TYPESTRUCTURELINK =
		"SELECT COUNT(typeStructureLink) FROM TypeStructureLink typeStructureLink";

	private static final String _SQL_COUNT_TYPESTRUCTURELINK_WHERE =
		"SELECT COUNT(typeStructureLink) FROM TypeStructureLink typeStructureLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "typeStructureLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TypeStructureLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TypeStructureLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TypeStructureLinkPersistenceImpl.class);

}