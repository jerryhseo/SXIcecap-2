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

import com.sx.icecap.exception.NoSuchDataSetException;
import com.sx.icecap.model.DataSet;
import com.sx.icecap.service.DataSetLocalServiceUtil;
import com.sx.icecap.service.persistence.DataSetPersistence;
import com.sx.icecap.service.persistence.DataSetUtil;

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
public class DataSetPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = DataSetUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DataSet> iterator = _dataSets.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataSet dataSet = _persistence.create(pk);

		Assert.assertNotNull(dataSet);

		Assert.assertEquals(dataSet.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DataSet newDataSet = addDataSet();

		_persistence.remove(newDataSet);

		DataSet existingDataSet = _persistence.fetchByPrimaryKey(
			newDataSet.getPrimaryKey());

		Assert.assertNull(existingDataSet);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDataSet();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataSet newDataSet = _persistence.create(pk);

		newDataSet.setUuid(RandomTestUtil.randomString());

		newDataSet.setCompanyId(RandomTestUtil.nextLong());

		newDataSet.setGroupId(RandomTestUtil.nextLong());

		newDataSet.setUserId(RandomTestUtil.nextLong());

		newDataSet.setUserName(RandomTestUtil.randomString());

		newDataSet.setCreateDate(RandomTestUtil.nextDate());

		newDataSet.setModifiedDate(RandomTestUtil.nextDate());

		newDataSet.setLastPublishDate(RandomTestUtil.nextDate());

		newDataSet.setStatus(RandomTestUtil.nextInt());

		newDataSet.setStatusByUserId(RandomTestUtil.nextLong());

		newDataSet.setStatusByUserName(RandomTestUtil.randomString());

		newDataSet.setStatusDate(RandomTestUtil.nextDate());

		newDataSet.setDataSetCode(RandomTestUtil.randomString());

		newDataSet.setDataSetVersion(RandomTestUtil.randomString());

		newDataSet.setDisplayName(RandomTestUtil.randomString());

		newDataSet.setDescription(RandomTestUtil.randomString());

		newDataSet.setVerified(RandomTestUtil.randomString());

		newDataSet.setFreezed(RandomTestUtil.randomString());

		_dataSets.add(_persistence.update(newDataSet));

		DataSet existingDataSet = _persistence.findByPrimaryKey(
			newDataSet.getPrimaryKey());

		Assert.assertEquals(existingDataSet.getUuid(), newDataSet.getUuid());
		Assert.assertEquals(
			existingDataSet.getDataSetId(), newDataSet.getDataSetId());
		Assert.assertEquals(
			existingDataSet.getCompanyId(), newDataSet.getCompanyId());
		Assert.assertEquals(
			existingDataSet.getGroupId(), newDataSet.getGroupId());
		Assert.assertEquals(
			existingDataSet.getUserId(), newDataSet.getUserId());
		Assert.assertEquals(
			existingDataSet.getUserName(), newDataSet.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataSet.getCreateDate()),
			Time.getShortTimestamp(newDataSet.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataSet.getModifiedDate()),
			Time.getShortTimestamp(newDataSet.getModifiedDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataSet.getLastPublishDate()),
			Time.getShortTimestamp(newDataSet.getLastPublishDate()));
		Assert.assertEquals(
			existingDataSet.getStatus(), newDataSet.getStatus());
		Assert.assertEquals(
			existingDataSet.getStatusByUserId(),
			newDataSet.getStatusByUserId());
		Assert.assertEquals(
			existingDataSet.getStatusByUserName(),
			newDataSet.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataSet.getStatusDate()),
			Time.getShortTimestamp(newDataSet.getStatusDate()));
		Assert.assertEquals(
			existingDataSet.getDataSetCode(), newDataSet.getDataSetCode());
		Assert.assertEquals(
			existingDataSet.getDataSetVersion(),
			newDataSet.getDataSetVersion());
		Assert.assertEquals(
			existingDataSet.getDisplayName(), newDataSet.getDisplayName());
		Assert.assertEquals(
			existingDataSet.getDescription(), newDataSet.getDescription());
		Assert.assertEquals(
			existingDataSet.getVerified(), newDataSet.getVerified());
		Assert.assertEquals(
			existingDataSet.getFreezed(), newDataSet.getFreezed());
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
		DataSet newDataSet = addDataSet();

		DataSet existingDataSet = _persistence.findByPrimaryKey(
			newDataSet.getPrimaryKey());

		Assert.assertEquals(existingDataSet, newDataSet);
	}

	@Test(expected = NoSuchDataSetException.class)
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

	protected OrderByComparator<DataSet> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_DataSet", "uuid", true, "dataSetId", true, "companyId",
			true, "groupId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "lastPublishDate", true,
			"status", true, "statusByUserId", true, "statusByUserName", true,
			"statusDate", true, "dataSetCode", true, "dataSetVersion", true,
			"displayName", true, "description", true, "verified", true,
			"freezed", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DataSet newDataSet = addDataSet();

		DataSet existingDataSet = _persistence.fetchByPrimaryKey(
			newDataSet.getPrimaryKey());

		Assert.assertEquals(existingDataSet, newDataSet);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataSet missingDataSet = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDataSet);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DataSet newDataSet1 = addDataSet();
		DataSet newDataSet2 = addDataSet();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataSet1.getPrimaryKey());
		primaryKeys.add(newDataSet2.getPrimaryKey());

		Map<Serializable, DataSet> dataSets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, dataSets.size());
		Assert.assertEquals(
			newDataSet1, dataSets.get(newDataSet1.getPrimaryKey()));
		Assert.assertEquals(
			newDataSet2, dataSets.get(newDataSet2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DataSet> dataSets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(dataSets.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DataSet newDataSet = addDataSet();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataSet.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DataSet> dataSets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, dataSets.size());
		Assert.assertEquals(
			newDataSet, dataSets.get(newDataSet.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DataSet> dataSets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(dataSets.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DataSet newDataSet = addDataSet();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataSet.getPrimaryKey());

		Map<Serializable, DataSet> dataSets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, dataSets.size());
		Assert.assertEquals(
			newDataSet, dataSets.get(newDataSet.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DataSetLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DataSet>() {

				@Override
				public void performAction(DataSet dataSet) {
					Assert.assertNotNull(dataSet);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DataSet newDataSet = addDataSet();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataSet.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("dataSetId", newDataSet.getDataSetId()));

		List<DataSet> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		DataSet existingDataSet = result.get(0);

		Assert.assertEquals(existingDataSet, newDataSet);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataSet.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("dataSetId", RandomTestUtil.nextLong()));

		List<DataSet> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DataSet newDataSet = addDataSet();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataSet.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("dataSetId"));

		Object newDataSetId = newDataSet.getDataSetId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dataSetId", new Object[] {newDataSetId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDataSetId = result.get(0);

		Assert.assertEquals(existingDataSetId, newDataSetId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataSet.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("dataSetId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dataSetId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		DataSet newDataSet = addDataSet();

		_persistence.clearCache();

		DataSet existingDataSet = _persistence.findByPrimaryKey(
			newDataSet.getPrimaryKey());

		Assert.assertEquals(
			existingDataSet.getUuid(),
			ReflectionTestUtil.invoke(
				existingDataSet, "getOriginalUuid", new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingDataSet.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingDataSet, "getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(
			existingDataSet.getDataSetCode(),
			ReflectionTestUtil.invoke(
				existingDataSet, "getOriginalDataSetCode", new Class<?>[0]));
		Assert.assertEquals(
			existingDataSet.getDataSetVersion(),
			ReflectionTestUtil.invoke(
				existingDataSet, "getOriginalDataSetVersion", new Class<?>[0]));
	}

	protected DataSet addDataSet() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataSet dataSet = _persistence.create(pk);

		dataSet.setUuid(RandomTestUtil.randomString());

		dataSet.setCompanyId(RandomTestUtil.nextLong());

		dataSet.setGroupId(RandomTestUtil.nextLong());

		dataSet.setUserId(RandomTestUtil.nextLong());

		dataSet.setUserName(RandomTestUtil.randomString());

		dataSet.setCreateDate(RandomTestUtil.nextDate());

		dataSet.setModifiedDate(RandomTestUtil.nextDate());

		dataSet.setLastPublishDate(RandomTestUtil.nextDate());

		dataSet.setStatus(RandomTestUtil.nextInt());

		dataSet.setStatusByUserId(RandomTestUtil.nextLong());

		dataSet.setStatusByUserName(RandomTestUtil.randomString());

		dataSet.setStatusDate(RandomTestUtil.nextDate());

		dataSet.setDataSetCode(RandomTestUtil.randomString());

		dataSet.setDataSetVersion(RandomTestUtil.randomString());

		dataSet.setDisplayName(RandomTestUtil.randomString());

		dataSet.setDescription(RandomTestUtil.randomString());

		dataSet.setVerified(RandomTestUtil.randomString());

		dataSet.setFreezed(RandomTestUtil.randomString());

		_dataSets.add(_persistence.update(dataSet));

		return dataSet;
	}

	private List<DataSet> _dataSets = new ArrayList<DataSet>();
	private DataSetPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}