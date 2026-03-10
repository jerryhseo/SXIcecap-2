/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sx.icecap.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.sx.icecap.exception.NoSuchCollectionSetLinkException;
import com.sx.icecap.model.CollectionSetLink;
import com.sx.icecap.service.CollectionSetLinkLocalServiceUtil;
import com.sx.icecap.service.persistence.CollectionSetLinkPersistence;
import com.sx.icecap.service.persistence.CollectionSetLinkUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CollectionSetLinkPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = CollectionSetLinkUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CollectionSetLink> iterator = _collectionSetLinks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CollectionSetLink collectionSetLink = _persistence.create(pk);

		Assert.assertNotNull(collectionSetLink);

		Assert.assertEquals(collectionSetLink.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CollectionSetLink newCollectionSetLink = addCollectionSetLink();

		_persistence.remove(newCollectionSetLink);

		CollectionSetLink existingCollectionSetLink =
			_persistence.fetchByPrimaryKey(
				newCollectionSetLink.getPrimaryKey());

		Assert.assertNull(existingCollectionSetLink);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCollectionSetLink();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CollectionSetLink newCollectionSetLink = _persistence.create(pk);

		newCollectionSetLink.setCompanyId(RandomTestUtil.nextLong());

		newCollectionSetLink.setGroupId(RandomTestUtil.nextLong());

		newCollectionSetLink.setDataCollectionId(RandomTestUtil.nextLong());

		newCollectionSetLink.setDataSetId(RandomTestUtil.nextLong());

		newCollectionSetLink.setOrder(RandomTestUtil.nextInt());

		newCollectionSetLink.setCommentable(RandomTestUtil.randomBoolean());

		newCollectionSetLink.setVerifiable(RandomTestUtil.randomBoolean());

		newCollectionSetLink.setFreezable(RandomTestUtil.randomBoolean());

		newCollectionSetLink.setFreezed(RandomTestUtil.randomBoolean());

		newCollectionSetLink.setFreezedUserId(RandomTestUtil.nextLong());

		newCollectionSetLink.setFreezedUserName(RandomTestUtil.randomString());

		newCollectionSetLink.setFreezedDate(RandomTestUtil.nextDate());

		newCollectionSetLink.setVerified(RandomTestUtil.randomBoolean());

		newCollectionSetLink.setVerifiedUserId(RandomTestUtil.nextLong());

		newCollectionSetLink.setVerifiedUserName(RandomTestUtil.randomString());

		newCollectionSetLink.setVerifiedDate(RandomTestUtil.nextDate());

		_collectionSetLinks.add(_persistence.update(newCollectionSetLink));

		CollectionSetLink existingCollectionSetLink =
			_persistence.findByPrimaryKey(newCollectionSetLink.getPrimaryKey());

		Assert.assertEquals(
			existingCollectionSetLink.getCollectionSetLinkId(),
			newCollectionSetLink.getCollectionSetLinkId());
		Assert.assertEquals(
			existingCollectionSetLink.getCompanyId(),
			newCollectionSetLink.getCompanyId());
		Assert.assertEquals(
			existingCollectionSetLink.getGroupId(),
			newCollectionSetLink.getGroupId());
		Assert.assertEquals(
			existingCollectionSetLink.getDataCollectionId(),
			newCollectionSetLink.getDataCollectionId());
		Assert.assertEquals(
			existingCollectionSetLink.getDataSetId(),
			newCollectionSetLink.getDataSetId());
		Assert.assertEquals(
			existingCollectionSetLink.getOrder(),
			newCollectionSetLink.getOrder());
		Assert.assertEquals(
			existingCollectionSetLink.isCommentable(),
			newCollectionSetLink.isCommentable());
		Assert.assertEquals(
			existingCollectionSetLink.isVerifiable(),
			newCollectionSetLink.isVerifiable());
		Assert.assertEquals(
			existingCollectionSetLink.isFreezable(),
			newCollectionSetLink.isFreezable());
		Assert.assertEquals(
			existingCollectionSetLink.isFreezed(),
			newCollectionSetLink.isFreezed());
		Assert.assertEquals(
			existingCollectionSetLink.getFreezedUserId(),
			newCollectionSetLink.getFreezedUserId());
		Assert.assertEquals(
			existingCollectionSetLink.getFreezedUserName(),
			newCollectionSetLink.getFreezedUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCollectionSetLink.getFreezedDate()),
			Time.getShortTimestamp(newCollectionSetLink.getFreezedDate()));
		Assert.assertEquals(
			existingCollectionSetLink.isVerified(),
			newCollectionSetLink.isVerified());
		Assert.assertEquals(
			existingCollectionSetLink.getVerifiedUserId(),
			newCollectionSetLink.getVerifiedUserId());
		Assert.assertEquals(
			existingCollectionSetLink.getVerifiedUserName(),
			newCollectionSetLink.getVerifiedUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCollectionSetLink.getVerifiedDate()),
			Time.getShortTimestamp(newCollectionSetLink.getVerifiedDate()));
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testCountByCollection() throws Exception {
		_persistence.countByCollection(RandomTestUtil.nextLong());

		_persistence.countByCollection(0L);
	}

	@Test
	public void testCountByCollection_G() throws Exception {
		_persistence.countByCollection_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByCollection_G(0L, 0L);
	}

	@Test
	public void testCountByCollectionSet() throws Exception {
		_persistence.countByCollectionSet(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByCollectionSet(0L, 0L);
	}

	@Test
	public void testCountByCollectionSet_G() throws Exception {
		_persistence.countByCollectionSet_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByCollectionSet_G(0L, 0L, 0L);
	}

	@Test
	public void testCountBySetId() throws Exception {
		_persistence.countBySetId(RandomTestUtil.nextLong());

		_persistence.countBySetId(0L);
	}

	@Test
	public void testCountBySetId_G() throws Exception {
		_persistence.countBySetId_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countBySetId_G(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CollectionSetLink newCollectionSetLink = addCollectionSetLink();

		CollectionSetLink existingCollectionSetLink =
			_persistence.findByPrimaryKey(newCollectionSetLink.getPrimaryKey());

		Assert.assertEquals(existingCollectionSetLink, newCollectionSetLink);
	}

	@Test(expected = NoSuchCollectionSetLinkException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CollectionSetLink> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_CollectionSetLink", "collectionSetLinkId", true,
			"companyId", true, "groupId", true, "dataCollectionId", true,
			"dataSetId", true, "order", true, "commentable", true, "verifiable",
			true, "freezable", true, "freezed", true, "freezedUserId", true,
			"freezedUserName", true, "freezedDate", true, "verified", true,
			"verifiedUserId", true, "verifiedUserName", true, "verifiedDate",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CollectionSetLink newCollectionSetLink = addCollectionSetLink();

		CollectionSetLink existingCollectionSetLink =
			_persistence.fetchByPrimaryKey(
				newCollectionSetLink.getPrimaryKey());

		Assert.assertEquals(existingCollectionSetLink, newCollectionSetLink);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CollectionSetLink missingCollectionSetLink =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCollectionSetLink);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CollectionSetLink newCollectionSetLink1 = addCollectionSetLink();
		CollectionSetLink newCollectionSetLink2 = addCollectionSetLink();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCollectionSetLink1.getPrimaryKey());
		primaryKeys.add(newCollectionSetLink2.getPrimaryKey());

		Map<Serializable, CollectionSetLink> collectionSetLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, collectionSetLinks.size());
		Assert.assertEquals(
			newCollectionSetLink1,
			collectionSetLinks.get(newCollectionSetLink1.getPrimaryKey()));
		Assert.assertEquals(
			newCollectionSetLink2,
			collectionSetLinks.get(newCollectionSetLink2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CollectionSetLink> collectionSetLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(collectionSetLinks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CollectionSetLink newCollectionSetLink = addCollectionSetLink();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCollectionSetLink.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CollectionSetLink> collectionSetLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, collectionSetLinks.size());
		Assert.assertEquals(
			newCollectionSetLink,
			collectionSetLinks.get(newCollectionSetLink.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CollectionSetLink> collectionSetLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(collectionSetLinks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CollectionSetLink newCollectionSetLink = addCollectionSetLink();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCollectionSetLink.getPrimaryKey());

		Map<Serializable, CollectionSetLink> collectionSetLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, collectionSetLinks.size());
		Assert.assertEquals(
			newCollectionSetLink,
			collectionSetLinks.get(newCollectionSetLink.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CollectionSetLinkLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<CollectionSetLink>() {

				@Override
				public void performAction(CollectionSetLink collectionSetLink) {
					Assert.assertNotNull(collectionSetLink);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CollectionSetLink newCollectionSetLink = addCollectionSetLink();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CollectionSetLink.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"collectionSetLinkId",
				newCollectionSetLink.getCollectionSetLinkId()));

		List<CollectionSetLink> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CollectionSetLink existingCollectionSetLink = result.get(0);

		Assert.assertEquals(existingCollectionSetLink, newCollectionSetLink);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CollectionSetLink.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"collectionSetLinkId", RandomTestUtil.nextLong()));

		List<CollectionSetLink> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CollectionSetLink newCollectionSetLink = addCollectionSetLink();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CollectionSetLink.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("collectionSetLinkId"));

		Object newCollectionSetLinkId =
			newCollectionSetLink.getCollectionSetLinkId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"collectionSetLinkId", new Object[] {newCollectionSetLinkId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCollectionSetLinkId = result.get(0);

		Assert.assertEquals(
			existingCollectionSetLinkId, newCollectionSetLinkId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CollectionSetLink.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("collectionSetLinkId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"collectionSetLinkId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CollectionSetLink newCollectionSetLink = addCollectionSetLink();

		_persistence.clearCache();

		CollectionSetLink existingCollectionSetLink =
			_persistence.findByPrimaryKey(newCollectionSetLink.getPrimaryKey());

		Assert.assertEquals(
			Long.valueOf(existingCollectionSetLink.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingCollectionSetLink, "getOriginalGroupId",
				new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingCollectionSetLink.getDataCollectionId()),
			ReflectionTestUtil.<Long>invoke(
				existingCollectionSetLink, "getOriginalDataCollectionId",
				new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingCollectionSetLink.getDataSetId()),
			ReflectionTestUtil.<Long>invoke(
				existingCollectionSetLink, "getOriginalDataSetId",
				new Class<?>[0]));
	}

	protected CollectionSetLink addCollectionSetLink() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CollectionSetLink collectionSetLink = _persistence.create(pk);

		collectionSetLink.setCompanyId(RandomTestUtil.nextLong());

		collectionSetLink.setGroupId(RandomTestUtil.nextLong());

		collectionSetLink.setDataCollectionId(RandomTestUtil.nextLong());

		collectionSetLink.setDataSetId(RandomTestUtil.nextLong());

		collectionSetLink.setOrder(RandomTestUtil.nextInt());

		collectionSetLink.setCommentable(RandomTestUtil.randomBoolean());

		collectionSetLink.setVerifiable(RandomTestUtil.randomBoolean());

		collectionSetLink.setFreezable(RandomTestUtil.randomBoolean());

		collectionSetLink.setFreezed(RandomTestUtil.randomBoolean());

		collectionSetLink.setFreezedUserId(RandomTestUtil.nextLong());

		collectionSetLink.setFreezedUserName(RandomTestUtil.randomString());

		collectionSetLink.setFreezedDate(RandomTestUtil.nextDate());

		collectionSetLink.setVerified(RandomTestUtil.randomBoolean());

		collectionSetLink.setVerifiedUserId(RandomTestUtil.nextLong());

		collectionSetLink.setVerifiedUserName(RandomTestUtil.randomString());

		collectionSetLink.setVerifiedDate(RandomTestUtil.nextDate());

		_collectionSetLinks.add(_persistence.update(collectionSetLink));

		return collectionSetLink;
	}

	private List<CollectionSetLink> _collectionSetLinks =
		new ArrayList<CollectionSetLink>();
	private CollectionSetLinkPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}