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
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
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

		_finderPathFetchByDataStructureId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TypeStructureLinkImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDataStructureId",
			new String[] {Long.class.getName()},
			TypeStructureLinkModelImpl.DATASTRUCTUREID_COLUMN_BITMASK);

		_finderPathCountByDataStructureId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataStructureId",
			new String[] {Long.class.getName()});

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