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

import com.sx.icecap.exception.NoSuchSetTypeLinkException;
import com.sx.icecap.model.SetTypeLink;
import com.sx.icecap.service.SetTypeLinkLocalServiceUtil;
import com.sx.icecap.service.persistence.SetTypeLinkPersistence;
import com.sx.icecap.service.persistence.SetTypeLinkUtil;

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
public class SetTypeLinkPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = SetTypeLinkUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SetTypeLink> iterator = _setTypeLinks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SetTypeLink setTypeLink = _persistence.create(pk);

		Assert.assertNotNull(setTypeLink);

		Assert.assertEquals(setTypeLink.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SetTypeLink newSetTypeLink = addSetTypeLink();

		_persistence.remove(newSetTypeLink);

		SetTypeLink existingSetTypeLink = _persistence.fetchByPrimaryKey(
			newSetTypeLink.getPrimaryKey());

		Assert.assertNull(existingSetTypeLink);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSetTypeLink();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SetTypeLink newSetTypeLink = _persistence.create(pk);

		newSetTypeLink.setCompanyId(RandomTestUtil.nextLong());

		newSetTypeLink.setGroupId(RandomTestUtil.nextLong());

		newSetTypeLink.setDataCollectionId(RandomTestUtil.nextLong());

		newSetTypeLink.setDataSetId(RandomTestUtil.nextLong());

		newSetTypeLink.setDataTypeId(RandomTestUtil.nextLong());

		newSetTypeLink.setOrder(RandomTestUtil.nextInt());

		newSetTypeLink.setCommentable(RandomTestUtil.randomBoolean());

		newSetTypeLink.setVerifiable(RandomTestUtil.randomBoolean());

		newSetTypeLink.setFreezable(RandomTestUtil.randomBoolean());

		newSetTypeLink.setFreezed(RandomTestUtil.randomBoolean());

		newSetTypeLink.setFreezedUserId(RandomTestUtil.nextLong());

		newSetTypeLink.setFreezedUserName(RandomTestUtil.randomString());

		newSetTypeLink.setFreezedDate(RandomTestUtil.nextDate());

		newSetTypeLink.setVerified(RandomTestUtil.randomBoolean());

		newSetTypeLink.setVerifiedUserId(RandomTestUtil.nextLong());

		newSetTypeLink.setVerifiedUserName(RandomTestUtil.randomString());

		newSetTypeLink.setVerifiedDate(RandomTestUtil.nextDate());

		_setTypeLinks.add(_persistence.update(newSetTypeLink));

		SetTypeLink existingSetTypeLink = _persistence.findByPrimaryKey(
			newSetTypeLink.getPrimaryKey());

		Assert.assertEquals(
			existingSetTypeLink.getSetTypeLinkId(),
			newSetTypeLink.getSetTypeLinkId());
		Assert.assertEquals(
			existingSetTypeLink.getCompanyId(), newSetTypeLink.getCompanyId());
		Assert.assertEquals(
			existingSetTypeLink.getGroupId(), newSetTypeLink.getGroupId());
		Assert.assertEquals(
			existingSetTypeLink.getDataCollectionId(),
			newSetTypeLink.getDataCollectionId());
		Assert.assertEquals(
			existingSetTypeLink.getDataSetId(), newSetTypeLink.getDataSetId());
		Assert.assertEquals(
			existingSetTypeLink.getDataTypeId(),
			newSetTypeLink.getDataTypeId());
		Assert.assertEquals(
			existingSetTypeLink.getOrder(), newSetTypeLink.getOrder());
		Assert.assertEquals(
			existingSetTypeLink.isCommentable(),
			newSetTypeLink.isCommentable());
		Assert.assertEquals(
			existingSetTypeLink.isVerifiable(), newSetTypeLink.isVerifiable());
		Assert.assertEquals(
			existingSetTypeLink.isFreezable(), newSetTypeLink.isFreezable());
		Assert.assertEquals(
			existingSetTypeLink.isFreezed(), newSetTypeLink.isFreezed());
		Assert.assertEquals(
			existingSetTypeLink.getFreezedUserId(),
			newSetTypeLink.getFreezedUserId());
		Assert.assertEquals(
			existingSetTypeLink.getFreezedUserName(),
			newSetTypeLink.getFreezedUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSetTypeLink.getFreezedDate()),
			Time.getShortTimestamp(newSetTypeLink.getFreezedDate()));
		Assert.assertEquals(
			existingSetTypeLink.isVerified(), newSetTypeLink.isVerified());
		Assert.assertEquals(
			existingSetTypeLink.getVerifiedUserId(),
			newSetTypeLink.getVerifiedUserId());
		Assert.assertEquals(
			existingSetTypeLink.getVerifiedUserName(),
			newSetTypeLink.getVerifiedUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSetTypeLink.getVerifiedDate()),
			Time.getShortTimestamp(newSetTypeLink.getVerifiedDate()));
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testCountByDataCollectionId() throws Exception {
		_persistence.countByDataCollectionId(RandomTestUtil.nextLong());

		_persistence.countByDataCollectionId(0L);
	}

	@Test
	public void testCountByDataSetId() throws Exception {
		_persistence.countByDataSetId(RandomTestUtil.nextLong());

		_persistence.countByDataSetId(0L);
	}

	@Test
	public void testCountByDataTypeId() throws Exception {
		_persistence.countByDataTypeId(RandomTestUtil.nextLong());

		_persistence.countByDataTypeId(0L);
	}

	@Test
	public void testCountByCollection_G() throws Exception {
		_persistence.countByCollection_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByCollection_G(0L, 0L);
	}

	@Test
	public void testCountBySet_G() throws Exception {
		_persistence.countBySet_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countBySet_G(0L, 0L);
	}

	@Test
	public void testCountByType_G() throws Exception {
		_persistence.countByType_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByType_G(0L, 0L);
	}

	@Test
	public void testCountByCollectionSet_G() throws Exception {
		_persistence.countByCollectionSet_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByCollectionSet_G(0L, 0L, 0L);
	}

	@Test
	public void testCountBySetType() throws Exception {
		_persistence.countBySetType(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countBySetType(0L, 0L);
	}

	@Test
	public void testCountByCollectionSetType_G() throws Exception {
		_persistence.countByCollectionSetType_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByCollectionSetType_G(0L, 0L, 0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SetTypeLink newSetTypeLink = addSetTypeLink();

		SetTypeLink existingSetTypeLink = _persistence.findByPrimaryKey(
			newSetTypeLink.getPrimaryKey());

		Assert.assertEquals(existingSetTypeLink, newSetTypeLink);
	}

	@Test(expected = NoSuchSetTypeLinkException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SetTypeLink> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_SetTypeLink", "setTypeLinkId", true, "companyId", true,
			"groupId", true, "dataCollectionId", true, "dataSetId", true,
			"dataTypeId", true, "order", true, "commentable", true,
			"verifiable", true, "freezable", true, "freezed", true,
			"freezedUserId", true, "freezedUserName", true, "freezedDate", true,
			"verified", true, "verifiedUserId", true, "verifiedUserName", true,
			"verifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SetTypeLink newSetTypeLink = addSetTypeLink();

		SetTypeLink existingSetTypeLink = _persistence.fetchByPrimaryKey(
			newSetTypeLink.getPrimaryKey());

		Assert.assertEquals(existingSetTypeLink, newSetTypeLink);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SetTypeLink missingSetTypeLink = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSetTypeLink);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SetTypeLink newSetTypeLink1 = addSetTypeLink();
		SetTypeLink newSetTypeLink2 = addSetTypeLink();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSetTypeLink1.getPrimaryKey());
		primaryKeys.add(newSetTypeLink2.getPrimaryKey());

		Map<Serializable, SetTypeLink> setTypeLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, setTypeLinks.size());
		Assert.assertEquals(
			newSetTypeLink1, setTypeLinks.get(newSetTypeLink1.getPrimaryKey()));
		Assert.assertEquals(
			newSetTypeLink2, setTypeLinks.get(newSetTypeLink2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SetTypeLink> setTypeLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(setTypeLinks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SetTypeLink newSetTypeLink = addSetTypeLink();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSetTypeLink.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SetTypeLink> setTypeLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, setTypeLinks.size());
		Assert.assertEquals(
			newSetTypeLink, setTypeLinks.get(newSetTypeLink.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SetTypeLink> setTypeLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(setTypeLinks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SetTypeLink newSetTypeLink = addSetTypeLink();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSetTypeLink.getPrimaryKey());

		Map<Serializable, SetTypeLink> setTypeLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, setTypeLinks.size());
		Assert.assertEquals(
			newSetTypeLink, setTypeLinks.get(newSetTypeLink.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SetTypeLinkLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SetTypeLink>() {

				@Override
				public void performAction(SetTypeLink setTypeLink) {
					Assert.assertNotNull(setTypeLink);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SetTypeLink newSetTypeLink = addSetTypeLink();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SetTypeLink.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"setTypeLinkId", newSetTypeLink.getSetTypeLinkId()));

		List<SetTypeLink> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SetTypeLink existingSetTypeLink = result.get(0);

		Assert.assertEquals(existingSetTypeLink, newSetTypeLink);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SetTypeLink.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"setTypeLinkId", RandomTestUtil.nextLong()));

		List<SetTypeLink> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SetTypeLink newSetTypeLink = addSetTypeLink();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SetTypeLink.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("setTypeLinkId"));

		Object newSetTypeLinkId = newSetTypeLink.getSetTypeLinkId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"setTypeLinkId", new Object[] {newSetTypeLinkId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSetTypeLinkId = result.get(0);

		Assert.assertEquals(existingSetTypeLinkId, newSetTypeLinkId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SetTypeLink.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("setTypeLinkId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"setTypeLinkId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		SetTypeLink newSetTypeLink = addSetTypeLink();

		_persistence.clearCache();

		SetTypeLink existingSetTypeLink = _persistence.findByPrimaryKey(
			newSetTypeLink.getPrimaryKey());

		Assert.assertEquals(
			Long.valueOf(existingSetTypeLink.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingSetTypeLink, "getOriginalGroupId", new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingSetTypeLink.getDataCollectionId()),
			ReflectionTestUtil.<Long>invoke(
				existingSetTypeLink, "getOriginalDataCollectionId",
				new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingSetTypeLink.getDataSetId()),
			ReflectionTestUtil.<Long>invoke(
				existingSetTypeLink, "getOriginalDataSetId", new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingSetTypeLink.getDataTypeId()),
			ReflectionTestUtil.<Long>invoke(
				existingSetTypeLink, "getOriginalDataTypeId", new Class<?>[0]));
	}

	protected SetTypeLink addSetTypeLink() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SetTypeLink setTypeLink = _persistence.create(pk);

		setTypeLink.setCompanyId(RandomTestUtil.nextLong());

		setTypeLink.setGroupId(RandomTestUtil.nextLong());

		setTypeLink.setDataCollectionId(RandomTestUtil.nextLong());

		setTypeLink.setDataSetId(RandomTestUtil.nextLong());

		setTypeLink.setDataTypeId(RandomTestUtil.nextLong());

		setTypeLink.setOrder(RandomTestUtil.nextInt());

		setTypeLink.setCommentable(RandomTestUtil.randomBoolean());

		setTypeLink.setVerifiable(RandomTestUtil.randomBoolean());

		setTypeLink.setFreezable(RandomTestUtil.randomBoolean());

		setTypeLink.setFreezed(RandomTestUtil.randomBoolean());

		setTypeLink.setFreezedUserId(RandomTestUtil.nextLong());

		setTypeLink.setFreezedUserName(RandomTestUtil.randomString());

		setTypeLink.setFreezedDate(RandomTestUtil.nextDate());

		setTypeLink.setVerified(RandomTestUtil.randomBoolean());

		setTypeLink.setVerifiedUserId(RandomTestUtil.nextLong());

		setTypeLink.setVerifiedUserName(RandomTestUtil.randomString());

		setTypeLink.setVerifiedDate(RandomTestUtil.nextDate());

		_setTypeLinks.add(_persistence.update(setTypeLink));

		return setTypeLink;
	}

	private List<SetTypeLink> _setTypeLinks = new ArrayList<SetTypeLink>();
	private SetTypeLinkPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}