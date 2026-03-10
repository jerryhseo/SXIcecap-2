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

import com.sx.icecap.exception.NoSuchDataCollectionException;
import com.sx.icecap.model.DataCollection;
import com.sx.icecap.service.DataCollectionLocalServiceUtil;
import com.sx.icecap.service.persistence.DataCollectionPersistence;
import com.sx.icecap.service.persistence.DataCollectionUtil;

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
public class DataCollectionPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = DataCollectionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DataCollection> iterator = _dataCollections.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataCollection dataCollection = _persistence.create(pk);

		Assert.assertNotNull(dataCollection);

		Assert.assertEquals(dataCollection.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DataCollection newDataCollection = addDataCollection();

		_persistence.remove(newDataCollection);

		DataCollection existingDataCollection = _persistence.fetchByPrimaryKey(
			newDataCollection.getPrimaryKey());

		Assert.assertNull(existingDataCollection);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDataCollection();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataCollection newDataCollection = _persistence.create(pk);

		newDataCollection.setUuid(RandomTestUtil.randomString());

		newDataCollection.setGroupId(RandomTestUtil.nextLong());

		newDataCollection.setCompanyId(RandomTestUtil.nextLong());

		newDataCollection.setUserId(RandomTestUtil.nextLong());

		newDataCollection.setUserName(RandomTestUtil.randomString());

		newDataCollection.setCreateDate(RandomTestUtil.nextDate());

		newDataCollection.setModifiedDate(RandomTestUtil.nextDate());

		newDataCollection.setLastPublishDate(RandomTestUtil.nextDate());

		newDataCollection.setStatus(RandomTestUtil.nextInt());

		newDataCollection.setStatusByUserId(RandomTestUtil.nextLong());

		newDataCollection.setStatusByUserName(RandomTestUtil.randomString());

		newDataCollection.setStatusDate(RandomTestUtil.nextDate());

		newDataCollection.setDataCollectionCode(RandomTestUtil.randomString());

		newDataCollection.setDataCollectionVersion(
			RandomTestUtil.randomString());

		newDataCollection.setDisplayName(RandomTestUtil.randomString());

		newDataCollection.setDescription(RandomTestUtil.randomString());

		newDataCollection.setVerified(RandomTestUtil.randomString());

		newDataCollection.setFreezed(RandomTestUtil.randomString());

		_dataCollections.add(_persistence.update(newDataCollection));

		DataCollection existingDataCollection = _persistence.findByPrimaryKey(
			newDataCollection.getPrimaryKey());

		Assert.assertEquals(
			existingDataCollection.getUuid(), newDataCollection.getUuid());
		Assert.assertEquals(
			existingDataCollection.getDataCollectionId(),
			newDataCollection.getDataCollectionId());
		Assert.assertEquals(
			existingDataCollection.getGroupId(),
			newDataCollection.getGroupId());
		Assert.assertEquals(
			existingDataCollection.getCompanyId(),
			newDataCollection.getCompanyId());
		Assert.assertEquals(
			existingDataCollection.getUserId(), newDataCollection.getUserId());
		Assert.assertEquals(
			existingDataCollection.getUserName(),
			newDataCollection.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataCollection.getCreateDate()),
			Time.getShortTimestamp(newDataCollection.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataCollection.getModifiedDate()),
			Time.getShortTimestamp(newDataCollection.getModifiedDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataCollection.getLastPublishDate()),
			Time.getShortTimestamp(newDataCollection.getLastPublishDate()));
		Assert.assertEquals(
			existingDataCollection.getStatus(), newDataCollection.getStatus());
		Assert.assertEquals(
			existingDataCollection.getStatusByUserId(),
			newDataCollection.getStatusByUserId());
		Assert.assertEquals(
			existingDataCollection.getStatusByUserName(),
			newDataCollection.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataCollection.getStatusDate()),
			Time.getShortTimestamp(newDataCollection.getStatusDate()));
		Assert.assertEquals(
			existingDataCollection.getDataCollectionCode(),
			newDataCollection.getDataCollectionCode());
		Assert.assertEquals(
			existingDataCollection.getDataCollectionVersion(),
			newDataCollection.getDataCollectionVersion());
		Assert.assertEquals(
			existingDataCollection.getDisplayName(),
			newDataCollection.getDisplayName());
		Assert.assertEquals(
			existingDataCollection.getDescription(),
			newDataCollection.getDescription());
		Assert.assertEquals(
			existingDataCollection.getVerified(),
			newDataCollection.getVerified());
		Assert.assertEquals(
			existingDataCollection.getFreezed(),
			newDataCollection.getFreezed());
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
		DataCollection newDataCollection = addDataCollection();

		DataCollection existingDataCollection = _persistence.findByPrimaryKey(
			newDataCollection.getPrimaryKey());

		Assert.assertEquals(existingDataCollection, newDataCollection);
	}

	@Test(expected = NoSuchDataCollectionException.class)
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

	protected OrderByComparator<DataCollection> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_DataCollection", "uuid", true, "dataCollectionId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "lastPublishDate",
			true, "status", true, "statusByUserId", true, "statusByUserName",
			true, "statusDate", true, "dataCollectionCode", true,
			"dataCollectionVersion", true, "displayName", true, "description",
			true, "verified", true, "freezed", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DataCollection newDataCollection = addDataCollection();

		DataCollection existingDataCollection = _persistence.fetchByPrimaryKey(
			newDataCollection.getPrimaryKey());

		Assert.assertEquals(existingDataCollection, newDataCollection);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataCollection missingDataCollection = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingDataCollection);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DataCollection newDataCollection1 = addDataCollection();
		DataCollection newDataCollection2 = addDataCollection();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataCollection1.getPrimaryKey());
		primaryKeys.add(newDataCollection2.getPrimaryKey());

		Map<Serializable, DataCollection> dataCollections =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, dataCollections.size());
		Assert.assertEquals(
			newDataCollection1,
			dataCollections.get(newDataCollection1.getPrimaryKey()));
		Assert.assertEquals(
			newDataCollection2,
			dataCollections.get(newDataCollection2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DataCollection> dataCollections =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dataCollections.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DataCollection newDataCollection = addDataCollection();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataCollection.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DataCollection> dataCollections =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dataCollections.size());
		Assert.assertEquals(
			newDataCollection,
			dataCollections.get(newDataCollection.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DataCollection> dataCollections =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dataCollections.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DataCollection newDataCollection = addDataCollection();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataCollection.getPrimaryKey());

		Map<Serializable, DataCollection> dataCollections =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dataCollections.size());
		Assert.assertEquals(
			newDataCollection,
			dataCollections.get(newDataCollection.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DataCollectionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DataCollection>() {

				@Override
				public void performAction(DataCollection dataCollection) {
					Assert.assertNotNull(dataCollection);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DataCollection newDataCollection = addDataCollection();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataCollection.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"dataCollectionId", newDataCollection.getDataCollectionId()));

		List<DataCollection> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		DataCollection existingDataCollection = result.get(0);

		Assert.assertEquals(existingDataCollection, newDataCollection);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataCollection.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"dataCollectionId", RandomTestUtil.nextLong()));

		List<DataCollection> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DataCollection newDataCollection = addDataCollection();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataCollection.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("dataCollectionId"));

		Object newDataCollectionId = newDataCollection.getDataCollectionId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dataCollectionId", new Object[] {newDataCollectionId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDataCollectionId = result.get(0);

		Assert.assertEquals(existingDataCollectionId, newDataCollectionId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataCollection.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("dataCollectionId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dataCollectionId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		DataCollection newDataCollection = addDataCollection();

		_persistence.clearCache();

		DataCollection existingDataCollection = _persistence.findByPrimaryKey(
			newDataCollection.getPrimaryKey());

		Assert.assertEquals(
			existingDataCollection.getUuid(),
			ReflectionTestUtil.invoke(
				existingDataCollection, "getOriginalUuid", new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingDataCollection.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingDataCollection, "getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(
			existingDataCollection.getDataCollectionCode(),
			ReflectionTestUtil.invoke(
				existingDataCollection, "getOriginalDataCollectionCode",
				new Class<?>[0]));
		Assert.assertEquals(
			existingDataCollection.getDataCollectionVersion(),
			ReflectionTestUtil.invoke(
				existingDataCollection, "getOriginalDataCollectionVersion",
				new Class<?>[0]));
	}

	protected DataCollection addDataCollection() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataCollection dataCollection = _persistence.create(pk);

		dataCollection.setUuid(RandomTestUtil.randomString());

		dataCollection.setGroupId(RandomTestUtil.nextLong());

		dataCollection.setCompanyId(RandomTestUtil.nextLong());

		dataCollection.setUserId(RandomTestUtil.nextLong());

		dataCollection.setUserName(RandomTestUtil.randomString());

		dataCollection.setCreateDate(RandomTestUtil.nextDate());

		dataCollection.setModifiedDate(RandomTestUtil.nextDate());

		dataCollection.setLastPublishDate(RandomTestUtil.nextDate());

		dataCollection.setStatus(RandomTestUtil.nextInt());

		dataCollection.setStatusByUserId(RandomTestUtil.nextLong());

		dataCollection.setStatusByUserName(RandomTestUtil.randomString());

		dataCollection.setStatusDate(RandomTestUtil.nextDate());

		dataCollection.setDataCollectionCode(RandomTestUtil.randomString());

		dataCollection.setDataCollectionVersion(RandomTestUtil.randomString());

		dataCollection.setDisplayName(RandomTestUtil.randomString());

		dataCollection.setDescription(RandomTestUtil.randomString());

		dataCollection.setVerified(RandomTestUtil.randomString());

		dataCollection.setFreezed(RandomTestUtil.randomString());

		_dataCollections.add(_persistence.update(dataCollection));

		return dataCollection;
	}

	private List<DataCollection> _dataCollections =
		new ArrayList<DataCollection>();
	private DataCollectionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}