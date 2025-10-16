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
	private FinderPath _finderPathWithPaginationFindByModelId;
	private FinderPath _finderPathWithoutPaginationFindByModelId;
	private FinderPath _finderPathCountByModelId;

	/**
	 * Returns all the data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the matching data comments
	 */
	@Override
	public List<DataComment> findByModelId(
		String commentModel, long commentModelId) {

		return findByModelId(
			commentModel, commentModelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	@Override
	public List<DataComment> findByModelId(
		String commentModel, long commentModelId, int start, int end) {

		return findByModelId(commentModel, commentModelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByModelId(
		String commentModel, long commentModelId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return findByModelId(
			commentModel, commentModelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByModelId(
		String commentModel, long commentModelId, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		commentModel = Objects.toString(commentModel, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByModelId;
				finderArgs = new Object[] {commentModel, commentModelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByModelId;
			finderArgs = new Object[] {
				commentModel, commentModelId, start, end, orderByComparator
			};
		}

		List<DataComment> list = null;

		if (useFinderCache) {
			list = (List<DataComment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataComment dataComment : list) {
					if (!commentModel.equals(dataComment.getCommentModel()) ||
						(commentModelId != dataComment.getCommentModelId())) {

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

			boolean bindCommentModel = false;

			if (commentModel.isEmpty()) {
				sb.append(_FINDER_COLUMN_MODELID_COMMENTMODEL_3);
			}
			else {
				bindCommentModel = true;

				sb.append(_FINDER_COLUMN_MODELID_COMMENTMODEL_2);
			}

			sb.append(_FINDER_COLUMN_MODELID_COMMENTMODELID_2);

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

				if (bindCommentModel) {
					queryPos.add(commentModel);
				}

				queryPos.add(commentModelId);

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
	 * Returns the first data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByModelId_First(
			String commentModel, long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByModelId_First(
			commentModel, commentModelId, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commentModel=");
		sb.append(commentModel);

		sb.append(", commentModelId=");
		sb.append(commentModelId);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByModelId_First(
		String commentModel, long commentModelId,
		OrderByComparator<DataComment> orderByComparator) {

		List<DataComment> list = findByModelId(
			commentModel, commentModelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByModelId_Last(
			String commentModel, long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByModelId_Last(
			commentModel, commentModelId, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commentModel=");
		sb.append(commentModel);

		sb.append(", commentModelId=");
		sb.append(commentModelId);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByModelId_Last(
		String commentModel, long commentModelId,
		OrderByComparator<DataComment> orderByComparator) {

		int count = countByModelId(commentModel, commentModelId);

		if (count == 0) {
			return null;
		}

		List<DataComment> list = findByModelId(
			commentModel, commentModelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment[] findByModelId_PrevAndNext(
			long dataCommentId, String commentModel, long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		commentModel = Objects.toString(commentModel, "");

		DataComment dataComment = findByPrimaryKey(dataCommentId);

		Session session = null;

		try {
			session = openSession();

			DataComment[] array = new DataCommentImpl[3];

			array[0] = getByModelId_PrevAndNext(
				session, dataComment, commentModel, commentModelId,
				orderByComparator, true);

			array[1] = dataComment;

			array[2] = getByModelId_PrevAndNext(
				session, dataComment, commentModel, commentModelId,
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

	protected DataComment getByModelId_PrevAndNext(
		Session session, DataComment dataComment, String commentModel,
		long commentModelId, OrderByComparator<DataComment> orderByComparator,
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

		boolean bindCommentModel = false;

		if (commentModel.isEmpty()) {
			sb.append(_FINDER_COLUMN_MODELID_COMMENTMODEL_3);
		}
		else {
			bindCommentModel = true;

			sb.append(_FINDER_COLUMN_MODELID_COMMENTMODEL_2);
		}

		sb.append(_FINDER_COLUMN_MODELID_COMMENTMODELID_2);

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

		if (bindCommentModel) {
			queryPos.add(commentModel);
		}

		queryPos.add(commentModelId);

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
	 * Removes all the data comments where commentModel = &#63; and commentModelId = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 */
	@Override
	public void removeByModelId(String commentModel, long commentModelId) {
		for (DataComment dataComment :
				findByModelId(
					commentModel, commentModelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dataComment);
		}
	}

	/**
	 * Returns the number of data comments where commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the number of matching data comments
	 */
	@Override
	public int countByModelId(String commentModel, long commentModelId) {
		commentModel = Objects.toString(commentModel, "");

		FinderPath finderPath = _finderPathCountByModelId;

		Object[] finderArgs = new Object[] {commentModel, commentModelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATACOMMENT_WHERE);

			boolean bindCommentModel = false;

			if (commentModel.isEmpty()) {
				sb.append(_FINDER_COLUMN_MODELID_COMMENTMODEL_3);
			}
			else {
				bindCommentModel = true;

				sb.append(_FINDER_COLUMN_MODELID_COMMENTMODEL_2);
			}

			sb.append(_FINDER_COLUMN_MODELID_COMMENTMODELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCommentModel) {
					queryPos.add(commentModel);
				}

				queryPos.add(commentModelId);

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

	private static final String _FINDER_COLUMN_MODELID_COMMENTMODEL_2 =
		"dataComment.commentModel = ? AND ";

	private static final String _FINDER_COLUMN_MODELID_COMMENTMODEL_3 =
		"(dataComment.commentModel IS NULL OR dataComment.commentModel = '') AND ";

	private static final String _FINDER_COLUMN_MODELID_COMMENTMODELID_2 =
		"dataComment.commentModelId = ?";

	private FinderPath _finderPathWithPaginationFindByModel;
	private FinderPath _finderPathWithoutPaginationFindByModel;
	private FinderPath _finderPathCountByModel;

	/**
	 * Returns all the data comments where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @return the matching data comments
	 */
	@Override
	public List<DataComment> findByModel(String commentModel) {
		return findByModel(
			commentModel, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data comments where commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	@Override
	public List<DataComment> findByModel(
		String commentModel, int start, int end) {

		return findByModel(commentModel, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByModel(
		String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return findByModel(commentModel, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data comments where commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByModel(
		String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		commentModel = Objects.toString(commentModel, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByModel;
				finderArgs = new Object[] {commentModel};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByModel;
			finderArgs = new Object[] {
				commentModel, start, end, orderByComparator
			};
		}

		List<DataComment> list = null;

		if (useFinderCache) {
			list = (List<DataComment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataComment dataComment : list) {
					if (!commentModel.equals(dataComment.getCommentModel())) {
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

			sb.append(_SQL_SELECT_DATACOMMENT_WHERE);

			boolean bindCommentModel = false;

			if (commentModel.isEmpty()) {
				sb.append(_FINDER_COLUMN_MODEL_COMMENTMODEL_3);
			}
			else {
				bindCommentModel = true;

				sb.append(_FINDER_COLUMN_MODEL_COMMENTMODEL_2);
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

				if (bindCommentModel) {
					queryPos.add(commentModel);
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
	 * Returns the first data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByModel_First(
			String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByModel_First(
			commentModel, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commentModel=");
		sb.append(commentModel);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the first data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByModel_First(
		String commentModel, OrderByComparator<DataComment> orderByComparator) {

		List<DataComment> list = findByModel(
			commentModel, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByModel_Last(
			String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByModel_Last(
			commentModel, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commentModel=");
		sb.append(commentModel);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the last data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByModel_Last(
		String commentModel, OrderByComparator<DataComment> orderByComparator) {

		int count = countByModel(commentModel);

		if (count == 0) {
			return null;
		}

		List<DataComment> list = findByModel(
			commentModel, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where commentModel = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment[] findByModel_PrevAndNext(
			long dataCommentId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		commentModel = Objects.toString(commentModel, "");

		DataComment dataComment = findByPrimaryKey(dataCommentId);

		Session session = null;

		try {
			session = openSession();

			DataComment[] array = new DataCommentImpl[3];

			array[0] = getByModel_PrevAndNext(
				session, dataComment, commentModel, orderByComparator, true);

			array[1] = dataComment;

			array[2] = getByModel_PrevAndNext(
				session, dataComment, commentModel, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataComment getByModel_PrevAndNext(
		Session session, DataComment dataComment, String commentModel,
		OrderByComparator<DataComment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATACOMMENT_WHERE);

		boolean bindCommentModel = false;

		if (commentModel.isEmpty()) {
			sb.append(_FINDER_COLUMN_MODEL_COMMENTMODEL_3);
		}
		else {
			bindCommentModel = true;

			sb.append(_FINDER_COLUMN_MODEL_COMMENTMODEL_2);
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

		if (bindCommentModel) {
			queryPos.add(commentModel);
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
	 * Removes all the data comments where commentModel = &#63; from the database.
	 *
	 * @param commentModel the comment model
	 */
	@Override
	public void removeByModel(String commentModel) {
		for (DataComment dataComment :
				findByModel(
					commentModel, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataComment);
		}
	}

	/**
	 * Returns the number of data comments where commentModel = &#63;.
	 *
	 * @param commentModel the comment model
	 * @return the number of matching data comments
	 */
	@Override
	public int countByModel(String commentModel) {
		commentModel = Objects.toString(commentModel, "");

		FinderPath finderPath = _finderPathCountByModel;

		Object[] finderArgs = new Object[] {commentModel};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATACOMMENT_WHERE);

			boolean bindCommentModel = false;

			if (commentModel.isEmpty()) {
				sb.append(_FINDER_COLUMN_MODEL_COMMENTMODEL_3);
			}
			else {
				bindCommentModel = true;

				sb.append(_FINDER_COLUMN_MODEL_COMMENTMODEL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCommentModel) {
					queryPos.add(commentModel);
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

	private static final String _FINDER_COLUMN_MODEL_COMMENTMODEL_2 =
		"dataComment.commentModel = ?";

	private static final String _FINDER_COLUMN_MODEL_COMMENTMODEL_3 =
		"(dataComment.commentModel IS NULL OR dataComment.commentModel = '')";

	private FinderPath _finderPathWithPaginationFindByParentComment;
	private FinderPath _finderPathWithoutPaginationFindByParentComment;
	private FinderPath _finderPathCountByParentComment;

	/**
	 * Returns all the data comments where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @return the matching data comments
	 */
	@Override
	public List<DataComment> findByParentComment(long parentCommentId) {
		return findByParentComment(
			parentCommentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data comments where parentCommentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param parentCommentId the parent comment ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	@Override
	public List<DataComment> findByParentComment(
		long parentCommentId, int start, int end) {

		return findByParentComment(parentCommentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data comments where parentCommentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param parentCommentId the parent comment ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByParentComment(
		long parentCommentId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return findByParentComment(
			parentCommentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data comments where parentCommentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param parentCommentId the parent comment ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByParentComment(
		long parentCommentId, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParentComment;
				finderArgs = new Object[] {parentCommentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentComment;
			finderArgs = new Object[] {
				parentCommentId, start, end, orderByComparator
			};
		}

		List<DataComment> list = null;

		if (useFinderCache) {
			list = (List<DataComment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataComment dataComment : list) {
					if (parentCommentId != dataComment.getParentCommentId()) {
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

			sb.append(_SQL_SELECT_DATACOMMENT_WHERE);

			sb.append(_FINDER_COLUMN_PARENTCOMMENT_PARENTCOMMENTID_2);

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

				queryPos.add(parentCommentId);

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
	 * Returns the first data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByParentComment_First(
			long parentCommentId,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByParentComment_First(
			parentCommentId, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCommentId=");
		sb.append(parentCommentId);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the first data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByParentComment_First(
		long parentCommentId,
		OrderByComparator<DataComment> orderByComparator) {

		List<DataComment> list = findByParentComment(
			parentCommentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByParentComment_Last(
			long parentCommentId,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByParentComment_Last(
			parentCommentId, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCommentId=");
		sb.append(parentCommentId);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the last data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByParentComment_Last(
		long parentCommentId,
		OrderByComparator<DataComment> orderByComparator) {

		int count = countByParentComment(parentCommentId);

		if (count == 0) {
			return null;
		}

		List<DataComment> list = findByParentComment(
			parentCommentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where parentCommentId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param parentCommentId the parent comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment[] findByParentComment_PrevAndNext(
			long dataCommentId, long parentCommentId,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = findByPrimaryKey(dataCommentId);

		Session session = null;

		try {
			session = openSession();

			DataComment[] array = new DataCommentImpl[3];

			array[0] = getByParentComment_PrevAndNext(
				session, dataComment, parentCommentId, orderByComparator, true);

			array[1] = dataComment;

			array[2] = getByParentComment_PrevAndNext(
				session, dataComment, parentCommentId, orderByComparator,
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

	protected DataComment getByParentComment_PrevAndNext(
		Session session, DataComment dataComment, long parentCommentId,
		OrderByComparator<DataComment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATACOMMENT_WHERE);

		sb.append(_FINDER_COLUMN_PARENTCOMMENT_PARENTCOMMENTID_2);

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

		queryPos.add(parentCommentId);

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
	 * Removes all the data comments where parentCommentId = &#63; from the database.
	 *
	 * @param parentCommentId the parent comment ID
	 */
	@Override
	public void removeByParentComment(long parentCommentId) {
		for (DataComment dataComment :
				findByParentComment(
					parentCommentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataComment);
		}
	}

	/**
	 * Returns the number of data comments where parentCommentId = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @return the number of matching data comments
	 */
	@Override
	public int countByParentComment(long parentCommentId) {
		FinderPath finderPath = _finderPathCountByParentComment;

		Object[] finderArgs = new Object[] {parentCommentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATACOMMENT_WHERE);

			sb.append(_FINDER_COLUMN_PARENTCOMMENT_PARENTCOMMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentCommentId);

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

	private static final String _FINDER_COLUMN_PARENTCOMMENT_PARENTCOMMENTID_2 =
		"dataComment.parentCommentId = ?";

	private FinderPath _finderPathWithPaginationFindByModelId_G;
	private FinderPath _finderPathWithoutPaginationFindByModelId_G;
	private FinderPath _finderPathCountByModelId_G;

	/**
	 * Returns all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the matching data comments
	 */
	@Override
	public List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId) {

		return findByModelId_G(
			groupId, commentModel, commentModelId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	@Override
	public List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId, int start,
		int end) {

		return findByModelId_G(
			groupId, commentModel, commentModelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId, int start,
		int end, OrderByComparator<DataComment> orderByComparator) {

		return findByModelId_G(
			groupId, commentModel, commentModelId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByModelId_G(
		long groupId, String commentModel, long commentModelId, int start,
		int end, OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		commentModel = Objects.toString(commentModel, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByModelId_G;
				finderArgs = new Object[] {
					groupId, commentModel, commentModelId
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByModelId_G;
			finderArgs = new Object[] {
				groupId, commentModel, commentModelId, start, end,
				orderByComparator
			};
		}

		List<DataComment> list = null;

		if (useFinderCache) {
			list = (List<DataComment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataComment dataComment : list) {
					if ((groupId != dataComment.getGroupId()) ||
						!commentModel.equals(dataComment.getCommentModel()) ||
						(commentModelId != dataComment.getCommentModelId())) {

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

			sb.append(_SQL_SELECT_DATACOMMENT_WHERE);

			sb.append(_FINDER_COLUMN_MODELID_G_GROUPID_2);

			boolean bindCommentModel = false;

			if (commentModel.isEmpty()) {
				sb.append(_FINDER_COLUMN_MODELID_G_COMMENTMODEL_3);
			}
			else {
				bindCommentModel = true;

				sb.append(_FINDER_COLUMN_MODELID_G_COMMENTMODEL_2);
			}

			sb.append(_FINDER_COLUMN_MODELID_G_COMMENTMODELID_2);

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

				queryPos.add(groupId);

				if (bindCommentModel) {
					queryPos.add(commentModel);
				}

				queryPos.add(commentModelId);

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
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByModelId_G_First(
			long groupId, String commentModel, long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByModelId_G_First(
			groupId, commentModel, commentModelId, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", commentModel=");
		sb.append(commentModel);

		sb.append(", commentModelId=");
		sb.append(commentModelId);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByModelId_G_First(
		long groupId, String commentModel, long commentModelId,
		OrderByComparator<DataComment> orderByComparator) {

		List<DataComment> list = findByModelId_G(
			groupId, commentModel, commentModelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByModelId_G_Last(
			long groupId, String commentModel, long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByModelId_G_Last(
			groupId, commentModel, commentModelId, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", commentModel=");
		sb.append(commentModel);

		sb.append(", commentModelId=");
		sb.append(commentModelId);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByModelId_G_Last(
		long groupId, String commentModel, long commentModelId,
		OrderByComparator<DataComment> orderByComparator) {

		int count = countByModelId_G(groupId, commentModel, commentModelId);

		if (count == 0) {
			return null;
		}

		List<DataComment> list = findByModelId_G(
			groupId, commentModel, commentModelId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment[] findByModelId_G_PrevAndNext(
			long dataCommentId, long groupId, String commentModel,
			long commentModelId,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		commentModel = Objects.toString(commentModel, "");

		DataComment dataComment = findByPrimaryKey(dataCommentId);

		Session session = null;

		try {
			session = openSession();

			DataComment[] array = new DataCommentImpl[3];

			array[0] = getByModelId_G_PrevAndNext(
				session, dataComment, groupId, commentModel, commentModelId,
				orderByComparator, true);

			array[1] = dataComment;

			array[2] = getByModelId_G_PrevAndNext(
				session, dataComment, groupId, commentModel, commentModelId,
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

	protected DataComment getByModelId_G_PrevAndNext(
		Session session, DataComment dataComment, long groupId,
		String commentModel, long commentModelId,
		OrderByComparator<DataComment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DATACOMMENT_WHERE);

		sb.append(_FINDER_COLUMN_MODELID_G_GROUPID_2);

		boolean bindCommentModel = false;

		if (commentModel.isEmpty()) {
			sb.append(_FINDER_COLUMN_MODELID_G_COMMENTMODEL_3);
		}
		else {
			bindCommentModel = true;

			sb.append(_FINDER_COLUMN_MODELID_G_COMMENTMODEL_2);
		}

		sb.append(_FINDER_COLUMN_MODELID_G_COMMENTMODELID_2);

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

		queryPos.add(groupId);

		if (bindCommentModel) {
			queryPos.add(commentModel);
		}

		queryPos.add(commentModelId);

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
	 * Removes all the data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 */
	@Override
	public void removeByModelId_G(
		long groupId, String commentModel, long commentModelId) {

		for (DataComment dataComment :
				findByModelId_G(
					groupId, commentModel, commentModelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dataComment);
		}
	}

	/**
	 * Returns the number of data comments where groupId = &#63; and commentModel = &#63; and commentModelId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param commentModelId the comment model ID
	 * @return the number of matching data comments
	 */
	@Override
	public int countByModelId_G(
		long groupId, String commentModel, long commentModelId) {

		commentModel = Objects.toString(commentModel, "");

		FinderPath finderPath = _finderPathCountByModelId_G;

		Object[] finderArgs = new Object[] {
			groupId, commentModel, commentModelId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DATACOMMENT_WHERE);

			sb.append(_FINDER_COLUMN_MODELID_G_GROUPID_2);

			boolean bindCommentModel = false;

			if (commentModel.isEmpty()) {
				sb.append(_FINDER_COLUMN_MODELID_G_COMMENTMODEL_3);
			}
			else {
				bindCommentModel = true;

				sb.append(_FINDER_COLUMN_MODELID_G_COMMENTMODEL_2);
			}

			sb.append(_FINDER_COLUMN_MODELID_G_COMMENTMODELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindCommentModel) {
					queryPos.add(commentModel);
				}

				queryPos.add(commentModelId);

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

	private static final String _FINDER_COLUMN_MODELID_G_GROUPID_2 =
		"dataComment.groupId = ? AND ";

	private static final String _FINDER_COLUMN_MODELID_G_COMMENTMODEL_2 =
		"dataComment.commentModel = ? AND ";

	private static final String _FINDER_COLUMN_MODELID_G_COMMENTMODEL_3 =
		"(dataComment.commentModel IS NULL OR dataComment.commentModel = '') AND ";

	private static final String _FINDER_COLUMN_MODELID_G_COMMENTMODELID_2 =
		"dataComment.commentModelId = ?";

	private FinderPath _finderPathWithPaginationFindByModel_G;
	private FinderPath _finderPathWithoutPaginationFindByModel_G;
	private FinderPath _finderPathCountByModel_G;

	/**
	 * Returns all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the matching data comments
	 */
	@Override
	public List<DataComment> findByModel_G(long groupId, String commentModel) {
		return findByModel_G(
			groupId, commentModel, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	@Override
	public List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end) {

		return findByModel_G(groupId, commentModel, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return findByModel_G(
			groupId, commentModel, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByModel_G(
		long groupId, String commentModel, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
		boolean useFinderCache) {

		commentModel = Objects.toString(commentModel, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByModel_G;
				finderArgs = new Object[] {groupId, commentModel};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByModel_G;
			finderArgs = new Object[] {
				groupId, commentModel, start, end, orderByComparator
			};
		}

		List<DataComment> list = null;

		if (useFinderCache) {
			list = (List<DataComment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataComment dataComment : list) {
					if ((groupId != dataComment.getGroupId()) ||
						!commentModel.equals(dataComment.getCommentModel())) {

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

			sb.append(_FINDER_COLUMN_MODEL_G_GROUPID_2);

			boolean bindCommentModel = false;

			if (commentModel.isEmpty()) {
				sb.append(_FINDER_COLUMN_MODEL_G_COMMENTMODEL_3);
			}
			else {
				bindCommentModel = true;

				sb.append(_FINDER_COLUMN_MODEL_G_COMMENTMODEL_2);
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

				queryPos.add(groupId);

				if (bindCommentModel) {
					queryPos.add(commentModel);
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
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByModel_G_First(
			long groupId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByModel_G_First(
			groupId, commentModel, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", commentModel=");
		sb.append(commentModel);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByModel_G_First(
		long groupId, String commentModel,
		OrderByComparator<DataComment> orderByComparator) {

		List<DataComment> list = findByModel_G(
			groupId, commentModel, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByModel_G_Last(
			long groupId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByModel_G_Last(
			groupId, commentModel, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", commentModel=");
		sb.append(commentModel);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByModel_G_Last(
		long groupId, String commentModel,
		OrderByComparator<DataComment> orderByComparator) {

		int count = countByModel_G(groupId, commentModel);

		if (count == 0) {
			return null;
		}

		List<DataComment> list = findByModel_G(
			groupId, commentModel, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment[] findByModel_G_PrevAndNext(
			long dataCommentId, long groupId, String commentModel,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		commentModel = Objects.toString(commentModel, "");

		DataComment dataComment = findByPrimaryKey(dataCommentId);

		Session session = null;

		try {
			session = openSession();

			DataComment[] array = new DataCommentImpl[3];

			array[0] = getByModel_G_PrevAndNext(
				session, dataComment, groupId, commentModel, orderByComparator,
				true);

			array[1] = dataComment;

			array[2] = getByModel_G_PrevAndNext(
				session, dataComment, groupId, commentModel, orderByComparator,
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

	protected DataComment getByModel_G_PrevAndNext(
		Session session, DataComment dataComment, long groupId,
		String commentModel, OrderByComparator<DataComment> orderByComparator,
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

		sb.append(_FINDER_COLUMN_MODEL_G_GROUPID_2);

		boolean bindCommentModel = false;

		if (commentModel.isEmpty()) {
			sb.append(_FINDER_COLUMN_MODEL_G_COMMENTMODEL_3);
		}
		else {
			bindCommentModel = true;

			sb.append(_FINDER_COLUMN_MODEL_G_COMMENTMODEL_2);
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

		queryPos.add(groupId);

		if (bindCommentModel) {
			queryPos.add(commentModel);
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
	 * Removes all the data comments where groupId = &#63; and commentModel = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 */
	@Override
	public void removeByModel_G(long groupId, String commentModel) {
		for (DataComment dataComment :
				findByModel_G(
					groupId, commentModel, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataComment);
		}
	}

	/**
	 * Returns the number of data comments where groupId = &#63; and commentModel = &#63;.
	 *
	 * @param groupId the group ID
	 * @param commentModel the comment model
	 * @return the number of matching data comments
	 */
	@Override
	public int countByModel_G(long groupId, String commentModel) {
		commentModel = Objects.toString(commentModel, "");

		FinderPath finderPath = _finderPathCountByModel_G;

		Object[] finderArgs = new Object[] {groupId, commentModel};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DATACOMMENT_WHERE);

			sb.append(_FINDER_COLUMN_MODEL_G_GROUPID_2);

			boolean bindCommentModel = false;

			if (commentModel.isEmpty()) {
				sb.append(_FINDER_COLUMN_MODEL_G_COMMENTMODEL_3);
			}
			else {
				bindCommentModel = true;

				sb.append(_FINDER_COLUMN_MODEL_G_COMMENTMODEL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindCommentModel) {
					queryPos.add(commentModel);
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

	private static final String _FINDER_COLUMN_MODEL_G_GROUPID_2 =
		"dataComment.groupId = ? AND ";

	private static final String _FINDER_COLUMN_MODEL_G_COMMENTMODEL_2 =
		"dataComment.commentModel = ?";

	private static final String _FINDER_COLUMN_MODEL_G_COMMENTMODEL_3 =
		"(dataComment.commentModel IS NULL OR dataComment.commentModel = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the data comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data comments
	 */
	@Override
	public List<DataComment> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @return the range of matching data comments
	 */
	@Override
	public List<DataComment> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataComment> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataCommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data comments
	 * @param end the upper bound of the range of data comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data comments
	 */
	@Override
	public List<DataComment> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataComment> orderByComparator,
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

		List<DataComment> list = null;

		if (useFinderCache) {
			list = (List<DataComment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataComment dataComment : list) {
					if (groupId != dataComment.getGroupId()) {
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

			sb.append(_SQL_SELECT_DATACOMMENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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

				queryPos.add(groupId);

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
	 * Returns the first data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByGroupId_First(
			long groupId, OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByGroupId_First(
			groupId, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the first data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByGroupId_First(
		long groupId, OrderByComparator<DataComment> orderByComparator) {

		List<DataComment> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment
	 * @throws NoSuchDataCommentException if a matching data comment could not be found
	 */
	@Override
	public DataComment findByGroupId_Last(
			long groupId, OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (dataComment != null) {
			return dataComment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDataCommentException(sb.toString());
	}

	/**
	 * Returns the last data comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data comment, or <code>null</code> if a matching data comment could not be found
	 */
	@Override
	public DataComment fetchByGroupId_Last(
		long groupId, OrderByComparator<DataComment> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DataComment> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data comments before and after the current data comment in the ordered set where groupId = &#63;.
	 *
	 * @param dataCommentId the primary key of the current data comment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data comment
	 * @throws NoSuchDataCommentException if a data comment with the primary key could not be found
	 */
	@Override
	public DataComment[] findByGroupId_PrevAndNext(
			long dataCommentId, long groupId,
			OrderByComparator<DataComment> orderByComparator)
		throws NoSuchDataCommentException {

		DataComment dataComment = findByPrimaryKey(dataCommentId);

		Session session = null;

		try {
			session = openSession();

			DataComment[] array = new DataCommentImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, dataComment, groupId, orderByComparator, true);

			array[1] = dataComment;

			array[2] = getByGroupId_PrevAndNext(
				session, dataComment, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataComment getByGroupId_PrevAndNext(
		Session session, DataComment dataComment, long groupId,
		OrderByComparator<DataComment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATACOMMENT_WHERE);

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
			sb.append(DataCommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

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
	 * Removes all the data comments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (DataComment dataComment :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataComment);
		}
	}

	/**
	 * Returns the number of data comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data comments
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATACOMMENT_WHERE);

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
		"dataComment.groupId = ?";

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
				dataCommentModelImpl.getCommentModel(),
				dataCommentModelImpl.getCommentModelId()
			};

			finderCache.removeResult(_finderPathCountByModelId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByModelId, args);

			args = new Object[] {dataCommentModelImpl.getCommentModel()};

			finderCache.removeResult(_finderPathCountByModel, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByModel, args);

			args = new Object[] {dataCommentModelImpl.getParentCommentId()};

			finderCache.removeResult(_finderPathCountByParentComment, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByParentComment, args);

			args = new Object[] {
				dataCommentModelImpl.getGroupId(),
				dataCommentModelImpl.getCommentModel(),
				dataCommentModelImpl.getCommentModelId()
			};

			finderCache.removeResult(_finderPathCountByModelId_G, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByModelId_G, args);

			args = new Object[] {
				dataCommentModelImpl.getGroupId(),
				dataCommentModelImpl.getCommentModel()
			};

			finderCache.removeResult(_finderPathCountByModel_G, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByModel_G, args);

			args = new Object[] {dataCommentModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dataCommentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByModelId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataCommentModelImpl.getOriginalCommentModel(),
					dataCommentModelImpl.getOriginalCommentModelId()
				};

				finderCache.removeResult(_finderPathCountByModelId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByModelId, args);

				args = new Object[] {
					dataCommentModelImpl.getCommentModel(),
					dataCommentModelImpl.getCommentModelId()
				};

				finderCache.removeResult(_finderPathCountByModelId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByModelId, args);
			}

			if ((dataCommentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByModel.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataCommentModelImpl.getOriginalCommentModel()
				};

				finderCache.removeResult(_finderPathCountByModel, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByModel, args);

				args = new Object[] {dataCommentModelImpl.getCommentModel()};

				finderCache.removeResult(_finderPathCountByModel, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByModel, args);
			}

			if ((dataCommentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByParentComment.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataCommentModelImpl.getOriginalParentCommentId()
				};

				finderCache.removeResult(_finderPathCountByParentComment, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByParentComment, args);

				args = new Object[] {dataCommentModelImpl.getParentCommentId()};

				finderCache.removeResult(_finderPathCountByParentComment, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByParentComment, args);
			}

			if ((dataCommentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByModelId_G.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataCommentModelImpl.getOriginalGroupId(),
					dataCommentModelImpl.getOriginalCommentModel(),
					dataCommentModelImpl.getOriginalCommentModelId()
				};

				finderCache.removeResult(_finderPathCountByModelId_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByModelId_G, args);

				args = new Object[] {
					dataCommentModelImpl.getGroupId(),
					dataCommentModelImpl.getCommentModel(),
					dataCommentModelImpl.getCommentModelId()
				};

				finderCache.removeResult(_finderPathCountByModelId_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByModelId_G, args);
			}

			if ((dataCommentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByModel_G.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataCommentModelImpl.getOriginalGroupId(),
					dataCommentModelImpl.getOriginalCommentModel()
				};

				finderCache.removeResult(_finderPathCountByModel_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByModel_G, args);

				args = new Object[] {
					dataCommentModelImpl.getGroupId(),
					dataCommentModelImpl.getCommentModel()
				};

				finderCache.removeResult(_finderPathCountByModel_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByModel_G, args);
			}

			if ((dataCommentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataCommentModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {dataCommentModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
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

		_finderPathWithPaginationFindByModelId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModelId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByModelId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModelId",
			new String[] {String.class.getName(), Long.class.getName()},
			DataCommentModelImpl.COMMENTMODEL_COLUMN_BITMASK |
			DataCommentModelImpl.COMMENTMODELID_COLUMN_BITMASK);

		_finderPathCountByModelId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModelId",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByModel = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModel",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByModel = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModel",
			new String[] {String.class.getName()},
			DataCommentModelImpl.COMMENTMODEL_COLUMN_BITMASK);

		_finderPathCountByModel = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModel",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByParentComment = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentComment",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByParentComment = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentComment",
			new String[] {Long.class.getName()},
			DataCommentModelImpl.PARENTCOMMENTID_COLUMN_BITMASK);

		_finderPathCountByParentComment = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentComment",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByModelId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModelId_G",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByModelId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModelId_G",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			DataCommentModelImpl.GROUPID_COLUMN_BITMASK |
			DataCommentModelImpl.COMMENTMODEL_COLUMN_BITMASK |
			DataCommentModelImpl.COMMENTMODELID_COLUMN_BITMASK);

		_finderPathCountByModelId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModelId_G",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByModel_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModel_G",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByModel_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModel_G",
			new String[] {Long.class.getName(), String.class.getName()},
			DataCommentModelImpl.GROUPID_COLUMN_BITMASK |
			DataCommentModelImpl.COMMENTMODEL_COLUMN_BITMASK);

		_finderPathCountByModel_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModel_G",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			DataCommentModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

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