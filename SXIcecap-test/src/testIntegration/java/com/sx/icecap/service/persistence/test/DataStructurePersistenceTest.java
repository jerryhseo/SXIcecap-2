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

import com.sx.icecap.exception.NoSuchDataStructureException;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.service.DataStructureLocalServiceUtil;
import com.sx.icecap.service.persistence.DataStructurePersistence;
import com.sx.icecap.service.persistence.DataStructureUtil;

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
public class DataStructurePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = DataStructureUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DataStructure> iterator = _dataStructures.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataStructure dataStructure = _persistence.create(pk);

		Assert.assertNotNull(dataStructure);

		Assert.assertEquals(dataStructure.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DataStructure newDataStructure = addDataStructure();

		_persistence.remove(newDataStructure);

		DataStructure existingDataStructure = _persistence.fetchByPrimaryKey(
			newDataStructure.getPrimaryKey());

		Assert.assertNull(existingDataStructure);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDataStructure();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataStructure newDataStructure = _persistence.create(pk);

		newDataStructure.setUuid(RandomTestUtil.randomString());

		newDataStructure.setCompanyId(RandomTestUtil.nextLong());

		newDataStructure.setGroupId(RandomTestUtil.nextLong());

		newDataStructure.setUserId(RandomTestUtil.nextLong());

		newDataStructure.setUserName(RandomTestUtil.randomString());

		newDataStructure.setCreateDate(RandomTestUtil.nextDate());

		newDataStructure.setModifiedDate(RandomTestUtil.nextDate());

		newDataStructure.setLastPublishDate(RandomTestUtil.nextDate());

		newDataStructure.setStatus(RandomTestUtil.nextInt());

		newDataStructure.setStatusByUserId(RandomTestUtil.nextLong());

		newDataStructure.setStatusByUserName(RandomTestUtil.randomString());

		newDataStructure.setStatusDate(RandomTestUtil.nextDate());

		newDataStructure.setDataStructureCode(RandomTestUtil.randomString());

		newDataStructure.setDataStructureVersion(RandomTestUtil.randomString());

		newDataStructure.setDisplayName(RandomTestUtil.randomString());

		newDataStructure.setDescription(RandomTestUtil.randomString());

		newDataStructure.setStructure(RandomTestUtil.randomString());

		_dataStructures.add(_persistence.update(newDataStructure));

		DataStructure existingDataStructure = _persistence.findByPrimaryKey(
			newDataStructure.getPrimaryKey());

		Assert.assertEquals(
			existingDataStructure.getUuid(), newDataStructure.getUuid());
		Assert.assertEquals(
			existingDataStructure.getCompanyId(),
			newDataStructure.getCompanyId());
		Assert.assertEquals(
			existingDataStructure.getGroupId(), newDataStructure.getGroupId());
		Assert.assertEquals(
			existingDataStructure.getUserId(), newDataStructure.getUserId());
		Assert.assertEquals(
			existingDataStructure.getUserName(),
			newDataStructure.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataStructure.getCreateDate()),
			Time.getShortTimestamp(newDataStructure.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataStructure.getModifiedDate()),
			Time.getShortTimestamp(newDataStructure.getModifiedDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataStructure.getLastPublishDate()),
			Time.getShortTimestamp(newDataStructure.getLastPublishDate()));
		Assert.assertEquals(
			existingDataStructure.getStatus(), newDataStructure.getStatus());
		Assert.assertEquals(
			existingDataStructure.getStatusByUserId(),
			newDataStructure.getStatusByUserId());
		Assert.assertEquals(
			existingDataStructure.getStatusByUserName(),
			newDataStructure.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataStructure.getStatusDate()),
			Time.getShortTimestamp(newDataStructure.getStatusDate()));
		Assert.assertEquals(
			existingDataStructure.getDataStructureId(),
			newDataStructure.getDataStructureId());
		Assert.assertEquals(
			existingDataStructure.getDataStructureCode(),
			newDataStructure.getDataStructureCode());
		Assert.assertEquals(
			existingDataStructure.getDataStructureVersion(),
			newDataStructure.getDataStructureVersion());
		Assert.assertEquals(
			existingDataStructure.getDisplayName(),
			newDataStructure.getDisplayName());
		Assert.assertEquals(
			existingDataStructure.getDescription(),
			newDataStructure.getDescription());
		Assert.assertEquals(
			existingDataStructure.getStructure(),
			newDataStructure.getStructure());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testCountByUserId() throws Exception {
		_persistence.countByUserId(RandomTestUtil.nextLong());

		_persistence.countByUserId(0L);
	}

	@Test
	public void testCountByStatus() throws Exception {
		_persistence.countByStatus(RandomTestUtil.nextInt());

		_persistence.countByStatus(0);
	}

	@Test
	public void testCountByG_U() throws Exception {
		_persistence.countByG_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByG_U(0L, 0L);
	}

	@Test
	public void testCountByG_S() throws Exception {
		_persistence.countByG_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByG_S(0L, 0);
	}

	@Test
	public void testCountByU_S() throws Exception {
		_persistence.countByU_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByU_S(0L, 0);
	}

	@Test
	public void testCountByG_U_S() throws Exception {
		_persistence.countByG_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByG_U_S(0L, 0L, 0);
	}

	@Test
	public void testCountByCode() throws Exception {
		_persistence.countByCode("");

		_persistence.countByCode("null");

		_persistence.countByCode((String)null);
	}

	@Test
	public void testCountByCodeVersion() throws Exception {
		_persistence.countByCodeVersion("", "");

		_persistence.countByCodeVersion("null", "null");

		_persistence.countByCodeVersion((String)null, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DataStructure newDataStructure = addDataStructure();

		DataStructure existingDataStructure = _persistence.findByPrimaryKey(
			newDataStructure.getPrimaryKey());

		Assert.assertEquals(existingDataStructure, newDataStructure);
	}

	@Test(expected = NoSuchDataStructureException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	@Test
	public void testFilterFindByGroupId() throws Exception {
		_persistence.filterFindByGroupId(
			0, QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<DataStructure> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_DataStructure", "uuid", true, "companyId", true,
			"groupId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "lastPublishDate", true, "status", true,
			"statusByUserId", true, "statusByUserName", true, "statusDate",
			true, "dataStructureId", true, "dataStructureCode", true,
			"dataStructureVersion", true, "displayName", true, "description",
			true, "structure", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DataStructure newDataStructure = addDataStructure();

		DataStructure existingDataStructure = _persistence.fetchByPrimaryKey(
			newDataStructure.getPrimaryKey());

		Assert.assertEquals(existingDataStructure, newDataStructure);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataStructure missingDataStructure = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDataStructure);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DataStructure newDataStructure1 = addDataStructure();
		DataStructure newDataStructure2 = addDataStructure();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataStructure1.getPrimaryKey());
		primaryKeys.add(newDataStructure2.getPrimaryKey());

		Map<Serializable, DataStructure> dataStructures =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, dataStructures.size());
		Assert.assertEquals(
			newDataStructure1,
			dataStructures.get(newDataStructure1.getPrimaryKey()));
		Assert.assertEquals(
			newDataStructure2,
			dataStructures.get(newDataStructure2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DataStructure> dataStructures =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dataStructures.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DataStructure newDataStructure = addDataStructure();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataStructure.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DataStructure> dataStructures =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dataStructures.size());
		Assert.assertEquals(
			newDataStructure,
			dataStructures.get(newDataStructure.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DataStructure> dataStructures =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dataStructures.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DataStructure newDataStructure = addDataStructure();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataStructure.getPrimaryKey());

		Map<Serializable, DataStructure> dataStructures =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dataStructures.size());
		Assert.assertEquals(
			newDataStructure,
			dataStructures.get(newDataStructure.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DataStructureLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DataStructure>() {

				@Override
				public void performAction(DataStructure dataStructure) {
					Assert.assertNotNull(dataStructure);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DataStructure newDataStructure = addDataStructure();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataStructure.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"dataStructureId", newDataStructure.getDataStructureId()));

		List<DataStructure> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		DataStructure existingDataStructure = result.get(0);

		Assert.assertEquals(existingDataStructure, newDataStructure);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataStructure.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"dataStructureId", RandomTestUtil.nextLong()));

		List<DataStructure> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DataStructure newDataStructure = addDataStructure();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataStructure.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("dataStructureId"));

		Object newDataStructureId = newDataStructure.getDataStructureId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dataStructureId", new Object[] {newDataStructureId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDataStructureId = result.get(0);

		Assert.assertEquals(existingDataStructureId, newDataStructureId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataStructure.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("dataStructureId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dataStructureId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		DataStructure newDataStructure = addDataStructure();

		_persistence.clearCache();

		DataStructure existingDataStructure = _persistence.findByPrimaryKey(
			newDataStructure.getPrimaryKey());

		Assert.assertEquals(
			existingDataStructure.getUuid(),
			ReflectionTestUtil.invoke(
				existingDataStructure, "getOriginalUuid", new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingDataStructure.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingDataStructure, "getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(
			existingDataStructure.getDataStructureCode(),
			ReflectionTestUtil.invoke(
				existingDataStructure, "getOriginalDataStructureCode",
				new Class<?>[0]));
		Assert.assertEquals(
			existingDataStructure.getDataStructureVersion(),
			ReflectionTestUtil.invoke(
				existingDataStructure, "getOriginalDataStructureVersion",
				new Class<?>[0]));
	}

	protected DataStructure addDataStructure() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataStructure dataStructure = _persistence.create(pk);

		dataStructure.setUuid(RandomTestUtil.randomString());

		dataStructure.setCompanyId(RandomTestUtil.nextLong());

		dataStructure.setGroupId(RandomTestUtil.nextLong());

		dataStructure.setUserId(RandomTestUtil.nextLong());

		dataStructure.setUserName(RandomTestUtil.randomString());

		dataStructure.setCreateDate(RandomTestUtil.nextDate());

		dataStructure.setModifiedDate(RandomTestUtil.nextDate());

		dataStructure.setLastPublishDate(RandomTestUtil.nextDate());

		dataStructure.setStatus(RandomTestUtil.nextInt());

		dataStructure.setStatusByUserId(RandomTestUtil.nextLong());

		dataStructure.setStatusByUserName(RandomTestUtil.randomString());

		dataStructure.setStatusDate(RandomTestUtil.nextDate());

		dataStructure.setDataStructureCode(RandomTestUtil.randomString());

		dataStructure.setDataStructureVersion(RandomTestUtil.randomString());

		dataStructure.setDisplayName(RandomTestUtil.randomString());

		dataStructure.setDescription(RandomTestUtil.randomString());

		dataStructure.setStructure(RandomTestUtil.randomString());

		_dataStructures.add(_persistence.update(dataStructure));

		return dataStructure;
	}

	private List<DataStructure> _dataStructures =
		new ArrayList<DataStructure>();
	private DataStructurePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}