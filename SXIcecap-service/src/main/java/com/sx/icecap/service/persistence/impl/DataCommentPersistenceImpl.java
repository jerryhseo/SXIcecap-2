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
import com.liferay.portal.kernel.util.SetUtil;

import com.sx.icecap.exception.NoSuchDataCommentException;
import com.sx.icecap.model.DataComment;
import com.sx.icecap.model.impl.DataCommentImpl;
import com.sx.icecap.model.impl.DataCommentModelImpl;
import com.sx.icecap.service.persistence.DataCommentPersistence;
import com.sx.icecap.service.persistence.DataCommentUtil;
import com.sx.icecap.service.persistence.impl.constants.SX_ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the data comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DataCommentPersistence.class)
public class DataCommentPersistenceImpl
	extends BasePersistenceImpl<DataComment> implements DataCommentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataCommentUtil</code> to access the data comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataCommentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByparamName;
	private FinderPath _finderPathWithoutPaginationFindByparamName;
	private FinderPath _finderPathCountByparamName;

	/**
	 * Returns all the data comments where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @return the matching data comments
	 */
	@Override
	public List<DataComment> findByparamName(
		long structuredDataId, String paramName) {

		return findByparamName(
			structuredDataId, paramName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the data comments where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	@Override
	public List<DataComment> findByparamName(
		long structuredDataId, String paramName, int start, int end) {

		return findByparamName(structuredDataId, paramName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data comments where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByparamName(
		long structuredDataId, String paramName, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return findByparamName(
			structuredDataId, paramName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data comments where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByparamName(
		long structuredDataId, String paramName, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		paramName = Objects.toString(paramName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByparamName;
				finderArgs = new Object[] {structuredDataId, paramName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByparamName;
			finderArgs = new Object[] {
				structuredDataId, paramName, start, end, orderByComparator
			};
		}

		List<DataComment> list = null;

		if (useFinderCache) {
			list = (List<DataComment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataComment dataComment : list) {
					if ((structuredDataId !=
							dataComment.getStructuredDataId()) ||
						!paramName.equals(dataComment.getParamName())) {

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

			sb.append(_SQL_SELECT_DATACOMMENT_WHERE);

			sb.append(_FINDER_COLUMN_PARAMNAME_STRUCTUREDDATAID_2);

			boolean bindParamName = false;

			if (paramName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARAMNAME_PARAMNAME_3);
			}
			else {
				bindParamName = true;

				sb.append(_FINDER_COLUMN_PARAMNAME_PARAMNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataCommentModelImpl.ORDER_BY_JPQL);
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

				list = (List<DataComment>)QueryUtil.list(
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
	 * Returns the first data comment in the ordered set where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByparamName_First(
			long structuredDataId, String paramName,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByparamName_First(
			structuredDataId, paramName, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("structuredDataId=");
		sb.append(structuredDataId);

		sb.append(", paramName=");
		sb.append(paramName);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the first data comment in the ordered set where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByparamName_First(
		long structuredDataId, String paramName,
		OrderByComparator<DataComment> orderByComparator) {

		List<DataComment> list = findByparamName(
			structuredDataId, paramName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data comment in the ordered set where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByparamName_Last(
			long structuredDataId, String paramName,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByparamName_Last(
			structuredDataId, paramName, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("structuredDataId=");
		sb.append(structuredDataId);

		sb.append(", paramName=");
		sb.append(paramName);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the last data comment in the ordered set where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByparamName_Last(
		long structuredDataId, String paramName,
		OrderByComparator<DataComment> orderByComparator) {

		int count = countByparamName(structuredDataId, paramName);

		if (count == 0) {
			return null;
		}

		List<DataComment> list = findByparamName(
			structuredDataId, paramName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment[] findByparamName_PrevAndNext(
			long dataCommentId, long structuredDataId, String paramName,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		paramName = Objects.toString(paramName, "");

		DataComment dataComment = findByPrimaryKey(dataCommentId);

		Session session = null;

		try {
			session = openSession();

			DataComment[] array = new DataCommentImpl[3];

			array[0] = getByparamName_PrevAndNext(
				session, dataComment, structuredDataId, paramName,
				orderByComparator, true);

			array[1] = dataComment;

			array[2] = getByparamName_PrevAndNext(
				session, dataComment, structuredDataId, paramName,
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

	protected DataComment getByparamName_PrevAndNext(
		Session session, DataComment dataComment, long structuredDataId,
		String paramName, OrderByComparator<DataComment> orderByComparator,
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

		sb.append(_SQL_SELECT_DATACOMMENT_WHERE);

		sb.append(_FINDER_COLUMN_PARAMNAME_STRUCTUREDDATAID_2);

		boolean bindParamName = false;

		if (paramName.isEmpty()) {
			sb.append(_FINDER_COLUMN_PARAMNAME_PARAMNAME_3);
		}
		else {
			bindParamName = true;

			sb.append(_FINDER_COLUMN_PARAMNAME_PARAMNAME_2);
		}

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
			sb.append(DataCommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(structuredDataId);

		if (bindParamName) {
			queryPos.add(paramName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataComment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataComment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data comments where structuredDataId = &#63; and paramName = &#63; from the database.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 */
	@Override
	public void removeByparamName(long structuredDataId, String paramName) {
		for (DataComment dataComment :
				findByparamName(
					structuredDataId, paramName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dataComment);
		}
	}

	/**
	 * Returns the number of data comments where structuredDataId = &#63; and paramName = &#63;.
	 *
	 * @param structuredDataId the structured data ID
	 * @param paramName the param name
	 * @return the number of matching data comments
	 */
	@Override
	public int countByparamName(long structuredDataId, String paramName) {
		paramName = Objects.toString(paramName, "");

		FinderPath finderPath = _finderPathCountByparamName;

		Object[] finderArgs = new Object[] {structuredDataId, paramName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATACOMMENT_WHERE);

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
		"dataComment.structuredDataId = ? AND ";

	private static final String _FINDER_COLUMN_PARAMNAME_PARAMNAME_2 =
		"dataComment.paramName = ?";

	private static final String _FINDER_COLUMN_PARAMNAME_PARAMNAME_3 =
		"(dataComment.paramName IS NULL OR dataComment.paramName = '')";

	public DataCommentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DataComment.class);

		setModelImplClass(DataCommentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the data comment in the entity cache if it is enabled.
	 *
	 * @param dataComment the data comment
	 */
	@Override
	public void cacheResult(DataComment dataComment) {
		entityCache.putResult(
			entityCacheEnabled, DataCommentImpl.class,
			dataComment.getPrimaryKey(), dataComment);

		dataComment.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the data comments in the entity cache if it is enabled.
	 *
	 * @param dataComments the data comments
	 */
	@Override
	public void cacheResult(List<DataComment> dataComments) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dataComments.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DataComment dataComment : dataComments) {
			if (entityCache.getResult(
					entityCacheEnabled, DataCommentImpl.class,
					dataComment.getPrimaryKey()) == null) {

				cacheResult(dataComment);
			}
			else {
				dataComment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data comments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataCommentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data comment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataComment dataComment) {
		entityCache.removeResult(
			entityCacheEnabled, DataCommentImpl.class,
			dataComment.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DataComment> dataComments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataComment dataComment : dataComments) {
			entityCache.removeResult(
				entityCacheEnabled, DataCommentImpl.class,
				dataComment.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, DataCommentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new data comment with the primary key. Does not add the data comment to the database.
	 *
	 * @param dataCommentId the primary key for the new data comment
	 * @return the new data comment
	 */
	@Override
	public DataComment create(long dataCommentId) {
		DataComment dataComment = new DataCommentImpl();

		dataComment.setNew(true);
		dataComment.setPrimaryKey(dataCommentId);

		dataComment.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dataComment;
	}

	/**
	 * Removes the data comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment that was removed
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment remove(long dataCommentId)
		throws NoSuchDataCommentException {

		return remove((Serializable)dataCommentId);
	}

	/**
	 * Removes the data comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data comment
	 * @return the data comment that was removed
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment remove(Serializable primaryKey)
		throws NoSuchDataCommentException {

		Session session = null;

		try {
			session = openSession();

			DataComment dataComment = (DataComment)session.get(
				DataCommentImpl.class, primaryKey);

			if (dataComment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataCommentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataComment);
		}
		catch (NoSuchDataCommentException noSuchEntityException) {
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
	protected DataComment removeImpl(DataComment dataComment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataComment)) {
				dataComment = (DataComment)session.get(
					DataCommentImpl.class, dataComment.getPrimaryKeyObj());
			}

			if (dataComment != null) {
				session.delete(dataComment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dataComment != null) {
			clearCache(dataComment);
		}

		return dataComment;
	}

	@Override
	public DataComment updateImpl(DataComment dataComment) {
		boolean isNew = dataComment.isNew();

		if (!(dataComment instanceof DataCommentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dataComment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dataComment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dataComment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DataComment implementation " +
					dataComment.getClass());
		}

		DataCommentModelImpl dataCommentModelImpl =
			(DataCommentModelImpl)dataComment;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dataComment.getCreateDate() == null)) {
			if (serviceContext == null) {
				dataComment.setCreateDate(date);
			}
			else {
				dataComment.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!dataCommentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dataComment.setModifiedDate(date);
			}
			else {
				dataComment.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dataComment);

				dataComment.setNew(false);
			}
			else {
				dataComment = (DataComment)session.merge(dataComment);
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
				dataCommentModelImpl.getStructuredDataId(),
				dataCommentModelImpl.getParamName()
			};

			finderCache.removeResult(_finderPathCountByparamName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByparamName, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dataCommentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByparamName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataCommentModelImpl.getOriginalStructuredDataId(),
					dataCommentModelImpl.getOriginalParamName()
				};

				finderCache.removeResult(_finderPathCountByparamName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByparamName, args);

				args = new Object[] {
					dataCommentModelImpl.getStructuredDataId(),
					dataCommentModelImpl.getParamName()
				};

				finderCache.removeResult(_finderPathCountByparamName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByparamName, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DataCommentImpl.class,
			dataComment.getPrimaryKey(), dataComment, false);

		dataComment.resetOriginalValues();

		return dataComment;
	}

	/**
	 * Returns the data comment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data comment
	 * @return the data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByPrimaryKey(primaryKey);

		if (dataComment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataCommentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataComment;
	}

	/**
	 * Returns the data comment with the primary key or throws a <code>NoSuchDataCommentException</code> if it could not be found.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment findByPrimaryKey(long dataCommentId)
		throws NoSuchDataCommentException {

		return findByPrimaryKey((Serializable)dataCommentId);
	}

	/**
	 * Returns the data comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataCommentId the primary key of the data comment
	 * @return the data comment, or <code>null</code> if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment fetchByPrimaryKey(long dataCommentId) {
		return fetchByPrimaryKey((Serializable)dataCommentId);
	}

	/**
	 * Returns all the data comments.
	 *
	 * @return the data comments
	 */
	@Override
	public List<DataComment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of data comments
	 */
	@Override
	public List<DataComment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data comments
	 */
	@Override
	public List<DataComment> findAll(
		int start, int end, OrderByComparator<DataComment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data comments
	 */
	@Override
	public List<DataComment> findAll(
		int start, int end, OrderByComparator<DataComment> orderByComparator,
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

		List<DataComment> list = null;

		if (useFinderCache) {
			list = (List<DataComment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DATACOMMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DATACOMMENT;

				sql = sql.concat(DataCommentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DataComment>)QueryUtil.list(
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
	 * Removes all the data comments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataComment dataComment : findAll()) {
			remove(dataComment);
		}
	}

	/**
	 * Returns the number of data comments.
	 *
	 * @return the number of data comments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DATACOMMENT);

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
		return "dataCommentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATACOMMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataCommentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data comment persistence.
	 */
	@Activate
	public void activate() {
		DataCommentModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DataCommentModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByparamName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByparamName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByparamName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByparamName",
			new String[] {Long.class.getName(), String.class.getName()},
			DataCommentModelImpl.STRUCTUREDDATAID_COLUMN_BITMASK |
			DataCommentModelImpl.PARAMNAME_COLUMN_BITMASK);

		_finderPathCountByparamName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByparamName",
			new String[] {Long.class.getName(), String.class.getName()});

		_setDataCommentUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDataCommentUtilPersistence(null);

		entityCache.removeCache(DataCommentImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setDataCommentUtilPersistence(
		DataCommentPersistence dataCommentPersistence) {

		try {
			Field field = DataCommentUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dataCommentPersistence);
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
				"value.object.column.bitmask.enabled.com.sx.icecap.model.DataComment"),
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

	private static final String _SQL_SELECT_DATACOMMENT =
		"SELECT dataComment FROM DataComment dataComment";

	private static final String _SQL_SELECT_DATACOMMENT_WHERE =
		"SELECT dataComment FROM DataComment dataComment WHERE ";

	private static final String _SQL_COUNT_DATACOMMENT =
		"SELECT COUNT(dataComment) FROM DataComment dataComment";

	private static final String _SQL_COUNT_DATACOMMENT_WHERE =
		"SELECT COUNT(dataComment) FROM DataComment dataComment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataComment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataComment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DataComment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DataCommentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"comment"});

}