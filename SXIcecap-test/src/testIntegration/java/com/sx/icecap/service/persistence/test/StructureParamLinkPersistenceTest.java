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
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.sx.icecap.exception.NoSuchStructureParamLinkException;
import com.sx.icecap.model.StructureParamLink;
import com.sx.icecap.service.StructureParamLinkLocalServiceUtil;
import com.sx.icecap.service.persistence.StructureParamLinkPersistence;
import com.sx.icecap.service.persistence.StructureParamLinkUtil;

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
public class StructureParamLinkPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = StructureParamLinkUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<StructureParamLink> iterator = _structureParamLinks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StructureParamLink structureParamLink = _persistence.create(pk);

		Assert.assertNotNull(structureParamLink);

		Assert.assertEquals(structureParamLink.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		StructureParamLink newStructureParamLink = addStructureParamLink();

		_persistence.remove(newStructureParamLink);

		StructureParamLink existingStructureParamLink =
			_persistence.fetchByPrimaryKey(
				newStructureParamLink.getPrimaryKey());

		Assert.assertNull(existingStructureParamLink);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addStructureParamLink();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StructureParamLink newStructureParamLink = _persistence.create(pk);

		newStructureParamLink.setDataStructureId(RandomTestUtil.nextLong());

		newStructureParamLink.setParameterId(RandomTestUtil.nextLong());

		newStructureParamLink.setOrder(RandomTestUtil.nextInt());

		_structureParamLinks.add(_persistence.update(newStructureParamLink));

		StructureParamLink existingStructureParamLink =
			_persistence.findByPrimaryKey(
				newStructureParamLink.getPrimaryKey());

		Assert.assertEquals(
			existingStructureParamLink.getStructureParamLinkId(),
			newStructureParamLink.getStructureParamLinkId());
		Assert.assertEquals(
			existingStructureParamLink.getDataStructureId(),
			newStructureParamLink.getDataStructureId());
		Assert.assertEquals(
			existingStructureParamLink.getParameterId(),
			newStructureParamLink.getParameterId());
		Assert.assertEquals(
			existingStructureParamLink.getOrder(),
			newStructureParamLink.getOrder());
	}

	@Test
	public void testCountByDataStructureId() throws Exception {
		_persistence.countByDataStructureId(RandomTestUtil.nextLong());

		_persistence.countByDataStructureId(0L);
	}

	@Test
	public void testCountByParameterId() throws Exception {
		_persistence.countByParameterId(RandomTestUtil.nextLong());

		_persistence.countByParameterId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		StructureParamLink newStructureParamLink = addStructureParamLink();

		StructureParamLink existingStructureParamLink =
			_persistence.findByPrimaryKey(
				newStructureParamLink.getPrimaryKey());

		Assert.assertEquals(existingStructureParamLink, newStructureParamLink);
	}

	@Test(expected = NoSuchStructureParamLinkException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<StructureParamLink> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_StructureParamLink", "structureParamLinkId", true,
			"dataStructureId", true, "parameterId", true, "order", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		StructureParamLink newStructureParamLink = addStructureParamLink();

		StructureParamLink existingStructureParamLink =
			_persistence.fetchByPrimaryKey(
				newStructureParamLink.getPrimaryKey());

		Assert.assertEquals(existingStructureParamLink, newStructureParamLink);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StructureParamLink missingStructureParamLink =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingStructureParamLink);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		StructureParamLink newStructureParamLink1 = addStructureParamLink();
		StructureParamLink newStructureParamLink2 = addStructureParamLink();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStructureParamLink1.getPrimaryKey());
		primaryKeys.add(newStructureParamLink2.getPrimaryKey());

		Map<Serializable, StructureParamLink> structureParamLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, structureParamLinks.size());
		Assert.assertEquals(
			newStructureParamLink1,
			structureParamLinks.get(newStructureParamLink1.getPrimaryKey()));
		Assert.assertEquals(
			newStructureParamLink2,
			structureParamLinks.get(newStructureParamLink2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, StructureParamLink> structureParamLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(structureParamLinks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		StructureParamLink newStructureParamLink = addStructureParamLink();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStructureParamLink.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, StructureParamLink> structureParamLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, structureParamLinks.size());
		Assert.assertEquals(
			newStructureParamLink,
			structureParamLinks.get(newStructureParamLink.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, StructureParamLink> structureParamLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(structureParamLinks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		StructureParamLink newStructureParamLink = addStructureParamLink();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStructureParamLink.getPrimaryKey());

		Map<Serializable, StructureParamLink> structureParamLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, structureParamLinks.size());
		Assert.assertEquals(
			newStructureParamLink,
			structureParamLinks.get(newStructureParamLink.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			StructureParamLinkLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<StructureParamLink>() {

				@Override
				public void performAction(
					StructureParamLink structureParamLink) {

					Assert.assertNotNull(structureParamLink);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		StructureParamLink newStructureParamLink = addStructureParamLink();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StructureParamLink.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"structureParamLinkId",
				newStructureParamLink.getStructureParamLinkId()));

		List<StructureParamLink> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		StructureParamLink existingStructureParamLink = result.get(0);

		Assert.assertEquals(existingStructureParamLink, newStructureParamLink);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StructureParamLink.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"structureParamLinkId", RandomTestUtil.nextLong()));

		List<StructureParamLink> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		StructureParamLink newStructureParamLink = addStructureParamLink();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StructureParamLink.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("structureParamLinkId"));

		Object newStructureParamLinkId =
			newStructureParamLink.getStructureParamLinkId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"structureParamLinkId",
				new Object[] {newStructureParamLinkId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingStructureParamLinkId = result.get(0);

		Assert.assertEquals(
			existingStructureParamLinkId, newStructureParamLinkId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StructureParamLink.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("structureParamLinkId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"structureParamLinkId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected StructureParamLink addStructureParamLink() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StructureParamLink structureParamLink = _persistence.create(pk);

		structureParamLink.setDataStructureId(RandomTestUtil.nextLong());

		structureParamLink.setParameterId(RandomTestUtil.nextLong());

		structureParamLink.setOrder(RandomTestUtil.nextInt());

		_structureParamLinks.add(_persistence.update(structureParamLink));

		return structureParamLink;
	}

	private List<StructureParamLink> _structureParamLinks =
		new ArrayList<StructureParamLink>();
	private StructureParamLinkPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}