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
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.sx.icecap.exception.NoSuchTypeVisualizerLinkException;
import com.sx.icecap.model.TypeVisualizerLink;
import com.sx.icecap.service.TypeVisualizerLinkLocalServiceUtil;
import com.sx.icecap.service.persistence.TypeVisualizerLinkPersistence;
import com.sx.icecap.service.persistence.TypeVisualizerLinkUtil;

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
public class TypeVisualizerLinkPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = TypeVisualizerLinkUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<TypeVisualizerLink> iterator = _typeVisualizerLinks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TypeVisualizerLink typeVisualizerLink = _persistence.create(pk);

		Assert.assertNotNull(typeVisualizerLink);

		Assert.assertEquals(typeVisualizerLink.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		TypeVisualizerLink newTypeVisualizerLink = addTypeVisualizerLink();

		_persistence.remove(newTypeVisualizerLink);

		TypeVisualizerLink existingTypeVisualizerLink =
			_persistence.fetchByPrimaryKey(
				newTypeVisualizerLink.getPrimaryKey());

		Assert.assertNull(existingTypeVisualizerLink);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTypeVisualizerLink();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TypeVisualizerLink newTypeVisualizerLink = _persistence.create(pk);

		newTypeVisualizerLink.setDataTypeId(RandomTestUtil.nextLong());

		newTypeVisualizerLink.setVisualizerId(RandomTestUtil.nextLong());

		_typeVisualizerLinks.add(_persistence.update(newTypeVisualizerLink));

		TypeVisualizerLink existingTypeVisualizerLink =
			_persistence.findByPrimaryKey(
				newTypeVisualizerLink.getPrimaryKey());

		Assert.assertEquals(
			existingTypeVisualizerLink.getTypeVisualizerLinkId(),
			newTypeVisualizerLink.getTypeVisualizerLinkId());
		Assert.assertEquals(
			existingTypeVisualizerLink.getDataTypeId(),
			newTypeVisualizerLink.getDataTypeId());
		Assert.assertEquals(
			existingTypeVisualizerLink.getVisualizerId(),
			newTypeVisualizerLink.getVisualizerId());
	}

	@Test
	public void testCountByDataTypeId() throws Exception {
		_persistence.countByDataTypeId(RandomTestUtil.nextLong());

		_persistence.countByDataTypeId(0L);
	}

	@Test
	public void testCountByVisualizerId() throws Exception {
		_persistence.countByVisualizerId(RandomTestUtil.nextLong());

		_persistence.countByVisualizerId(0L);
	}

	@Test
	public void testCountByDataTypeVisualizer() throws Exception {
		_persistence.countByDataTypeVisualizer(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByDataTypeVisualizer(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		TypeVisualizerLink newTypeVisualizerLink = addTypeVisualizerLink();

		TypeVisualizerLink existingTypeVisualizerLink =
			_persistence.findByPrimaryKey(
				newTypeVisualizerLink.getPrimaryKey());

		Assert.assertEquals(existingTypeVisualizerLink, newTypeVisualizerLink);
	}

	@Test(expected = NoSuchTypeVisualizerLinkException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<TypeVisualizerLink> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_TypeVisualizerLink", "typeVisualizerLinkId", true,
			"dataTypeId", true, "visualizerId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		TypeVisualizerLink newTypeVisualizerLink = addTypeVisualizerLink();

		TypeVisualizerLink existingTypeVisualizerLink =
			_persistence.fetchByPrimaryKey(
				newTypeVisualizerLink.getPrimaryKey());

		Assert.assertEquals(existingTypeVisualizerLink, newTypeVisualizerLink);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TypeVisualizerLink missingTypeVisualizerLink =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTypeVisualizerLink);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		TypeVisualizerLink newTypeVisualizerLink1 = addTypeVisualizerLink();
		TypeVisualizerLink newTypeVisualizerLink2 = addTypeVisualizerLink();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTypeVisualizerLink1.getPrimaryKey());
		primaryKeys.add(newTypeVisualizerLink2.getPrimaryKey());

		Map<Serializable, TypeVisualizerLink> typeVisualizerLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, typeVisualizerLinks.size());
		Assert.assertEquals(
			newTypeVisualizerLink1,
			typeVisualizerLinks.get(newTypeVisualizerLink1.getPrimaryKey()));
		Assert.assertEquals(
			newTypeVisualizerLink2,
			typeVisualizerLinks.get(newTypeVisualizerLink2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, TypeVisualizerLink> typeVisualizerLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(typeVisualizerLinks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		TypeVisualizerLink newTypeVisualizerLink = addTypeVisualizerLink();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTypeVisualizerLink.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, TypeVisualizerLink> typeVisualizerLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, typeVisualizerLinks.size());
		Assert.assertEquals(
			newTypeVisualizerLink,
			typeVisualizerLinks.get(newTypeVisualizerLink.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, TypeVisualizerLink> typeVisualizerLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(typeVisualizerLinks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		TypeVisualizerLink newTypeVisualizerLink = addTypeVisualizerLink();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTypeVisualizerLink.getPrimaryKey());

		Map<Serializable, TypeVisualizerLink> typeVisualizerLinks =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, typeVisualizerLinks.size());
		Assert.assertEquals(
			newTypeVisualizerLink,
			typeVisualizerLinks.get(newTypeVisualizerLink.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TypeVisualizerLinkLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<TypeVisualizerLink>() {

				@Override
				public void performAction(
					TypeVisualizerLink typeVisualizerLink) {

					Assert.assertNotNull(typeVisualizerLink);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		TypeVisualizerLink newTypeVisualizerLink = addTypeVisualizerLink();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TypeVisualizerLink.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"typeVisualizerLinkId",
				newTypeVisualizerLink.getTypeVisualizerLinkId()));

		List<TypeVisualizerLink> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		TypeVisualizerLink existingTypeVisualizerLink = result.get(0);

		Assert.assertEquals(existingTypeVisualizerLink, newTypeVisualizerLink);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TypeVisualizerLink.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"typeVisualizerLinkId", RandomTestUtil.nextLong()));

		List<TypeVisualizerLink> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		TypeVisualizerLink newTypeVisualizerLink = addTypeVisualizerLink();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TypeVisualizerLink.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("typeVisualizerLinkId"));

		Object newTypeVisualizerLinkId =
			newTypeVisualizerLink.getTypeVisualizerLinkId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"typeVisualizerLinkId",
				new Object[] {newTypeVisualizerLinkId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTypeVisualizerLinkId = result.get(0);

		Assert.assertEquals(
			existingTypeVisualizerLinkId, newTypeVisualizerLinkId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TypeVisualizerLink.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("typeVisualizerLinkId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"typeVisualizerLinkId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		TypeVisualizerLink newTypeVisualizerLink = addTypeVisualizerLink();

		_persistence.clearCache();

		TypeVisualizerLink existingTypeVisualizerLink =
			_persistence.findByPrimaryKey(
				newTypeVisualizerLink.getPrimaryKey());

		Assert.assertEquals(
			Long.valueOf(existingTypeVisualizerLink.getDataTypeId()),
			ReflectionTestUtil.<Long>invoke(
				existingTypeVisualizerLink, "getOriginalDataTypeId",
				new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingTypeVisualizerLink.getVisualizerId()),
			ReflectionTestUtil.<Long>invoke(
				existingTypeVisualizerLink, "getOriginalVisualizerId",
				new Class<?>[0]));
	}

	protected TypeVisualizerLink addTypeVisualizerLink() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TypeVisualizerLink typeVisualizerLink = _persistence.create(pk);

		typeVisualizerLink.setDataTypeId(RandomTestUtil.nextLong());

		typeVisualizerLink.setVisualizerId(RandomTestUtil.nextLong());

		_typeVisualizerLinks.add(_persistence.update(typeVisualizerLink));

		return typeVisualizerLink;
	}

	private List<TypeVisualizerLink> _typeVisualizerLinks =
		new ArrayList<TypeVisualizerLink>();
	private TypeVisualizerLinkPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}