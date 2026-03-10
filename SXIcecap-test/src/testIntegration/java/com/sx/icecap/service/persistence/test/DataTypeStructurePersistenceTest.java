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

import com.sx.icecap.exception.NoSuchDataTypeStructureException;
import com.sx.icecap.model.DataTypeStructure;
import com.sx.icecap.service.DataTypeStructureLocalServiceUtil;
import com.sx.icecap.service.persistence.DataTypeStructurePersistence;
import com.sx.icecap.service.persistence.DataTypeStructureUtil;

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
public class DataTypeStructurePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = DataTypeStructureUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DataTypeStructure> iterator = _dataTypeStructures.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataTypeStructure dataTypeStructure = _persistence.create(pk);

		Assert.assertNotNull(dataTypeStructure);

		Assert.assertEquals(dataTypeStructure.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DataTypeStructure newDataTypeStructure = addDataTypeStructure();

		_persistence.remove(newDataTypeStructure);

		DataTypeStructure existingDataTypeStructure =
			_persistence.fetchByPrimaryKey(
				newDataTypeStructure.getPrimaryKey());

		Assert.assertNull(existingDataTypeStructure);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDataTypeStructure();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataTypeStructure newDataTypeStructure = _persistence.create(pk);

		newDataTypeStructure.setStructure(RandomTestUtil.randomString());

		_dataTypeStructures.add(_persistence.update(newDataTypeStructure));

		DataTypeStructure existingDataTypeStructure =
			_persistence.findByPrimaryKey(newDataTypeStructure.getPrimaryKey());

		Assert.assertEquals(
			existingDataTypeStructure.getDataTypeId(),
			newDataTypeStructure.getDataTypeId());
		Assert.assertEquals(
			existingDataTypeStructure.getStructure(),
			newDataTypeStructure.getStructure());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DataTypeStructure newDataTypeStructure = addDataTypeStructure();

		DataTypeStructure existingDataTypeStructure =
			_persistence.findByPrimaryKey(newDataTypeStructure.getPrimaryKey());

		Assert.assertEquals(existingDataTypeStructure, newDataTypeStructure);
	}

	@Test(expected = NoSuchDataTypeStructureException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<DataTypeStructure> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_DataTypeStructure", "dataTypeId", true, "structure",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DataTypeStructure newDataTypeStructure = addDataTypeStructure();

		DataTypeStructure existingDataTypeStructure =
			_persistence.fetchByPrimaryKey(
				newDataTypeStructure.getPrimaryKey());

		Assert.assertEquals(existingDataTypeStructure, newDataTypeStructure);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataTypeStructure missingDataTypeStructure =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDataTypeStructure);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DataTypeStructure newDataTypeStructure1 = addDataTypeStructure();
		DataTypeStructure newDataTypeStructure2 = addDataTypeStructure();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataTypeStructure1.getPrimaryKey());
		primaryKeys.add(newDataTypeStructure2.getPrimaryKey());

		Map<Serializable, DataTypeStructure> dataTypeStructures =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, dataTypeStructures.size());
		Assert.assertEquals(
			newDataTypeStructure1,
			dataTypeStructures.get(newDataTypeStructure1.getPrimaryKey()));
		Assert.assertEquals(
			newDataTypeStructure2,
			dataTypeStructures.get(newDataTypeStructure2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DataTypeStructure> dataTypeStructures =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dataTypeStructures.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DataTypeStructure newDataTypeStructure = addDataTypeStructure();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataTypeStructure.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DataTypeStructure> dataTypeStructures =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dataTypeStructures.size());
		Assert.assertEquals(
			newDataTypeStructure,
			dataTypeStructures.get(newDataTypeStructure.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DataTypeStructure> dataTypeStructures =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dataTypeStructures.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DataTypeStructure newDataTypeStructure = addDataTypeStructure();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataTypeStructure.getPrimaryKey());

		Map<Serializable, DataTypeStructure> dataTypeStructures =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dataTypeStructures.size());
		Assert.assertEquals(
			newDataTypeStructure,
			dataTypeStructures.get(newDataTypeStructure.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DataTypeStructureLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<DataTypeStructure>() {

				@Override
				public void performAction(DataTypeStructure dataTypeStructure) {
					Assert.assertNotNull(dataTypeStructure);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DataTypeStructure newDataTypeStructure = addDataTypeStructure();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataTypeStructure.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"dataTypeId", newDataTypeStructure.getDataTypeId()));

		List<DataTypeStructure> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		DataTypeStructure existingDataTypeStructure = result.get(0);

		Assert.assertEquals(existingDataTypeStructure, newDataTypeStructure);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataTypeStructure.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"dataTypeId", RandomTestUtil.nextLong()));

		List<DataTypeStructure> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DataTypeStructure newDataTypeStructure = addDataTypeStructure();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataTypeStructure.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("dataTypeId"));

		Object newDataTypeId = newDataTypeStructure.getDataTypeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dataTypeId", new Object[] {newDataTypeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDataTypeId = result.get(0);

		Assert.assertEquals(existingDataTypeId, newDataTypeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataTypeStructure.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("dataTypeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dataTypeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected DataTypeStructure addDataTypeStructure() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataTypeStructure dataTypeStructure = _persistence.create(pk);

		dataTypeStructure.setStructure(RandomTestUtil.randomString());

		_dataTypeStructures.add(_persistence.update(dataTypeStructure));

		return dataTypeStructure;
	}

	private List<DataTypeStructure> _dataTypeStructures =
		new ArrayList<DataTypeStructure>();
	private DataTypeStructurePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}