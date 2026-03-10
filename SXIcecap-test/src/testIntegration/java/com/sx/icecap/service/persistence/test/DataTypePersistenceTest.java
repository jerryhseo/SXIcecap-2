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

import com.sx.icecap.exception.NoSuchDataTypeException;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalServiceUtil;
import com.sx.icecap.service.persistence.DataTypePersistence;
import com.sx.icecap.service.persistence.DataTypeUtil;

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
public class DataTypePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = DataTypeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DataType> iterator = _dataTypes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataType dataType = _persistence.create(pk);

		Assert.assertNotNull(dataType);

		Assert.assertEquals(dataType.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DataType newDataType = addDataType();

		_persistence.remove(newDataType);

		DataType existingDataType = _persistence.fetchByPrimaryKey(
			newDataType.getPrimaryKey());

		Assert.assertNull(existingDataType);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDataType();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataType newDataType = _persistence.create(pk);

		newDataType.setUuid(RandomTestUtil.randomString());

		newDataType.setCompanyId(RandomTestUtil.nextLong());

		newDataType.setGroupId(RandomTestUtil.nextLong());

		newDataType.setUserId(RandomTestUtil.nextLong());

		newDataType.setUserName(RandomTestUtil.randomString());

		newDataType.setCreateDate(RandomTestUtil.nextDate());

		newDataType.setModifiedDate(RandomTestUtil.nextDate());

		newDataType.setLastPublishDate(RandomTestUtil.nextDate());

		newDataType.setStatus(RandomTestUtil.nextInt());

		newDataType.setStatusByUserId(RandomTestUtil.nextLong());

		newDataType.setStatusByUserName(RandomTestUtil.randomString());

		newDataType.setStatusDate(RandomTestUtil.nextDate());

		newDataType.setDataTypeCode(RandomTestUtil.randomString());

		newDataType.setDataTypeVersion(RandomTestUtil.randomString());

		newDataType.setDisplayName(RandomTestUtil.randomString());

		newDataType.setExtension(RandomTestUtil.randomString());

		newDataType.setSampleFileId(RandomTestUtil.nextLong());

		newDataType.setDescription(RandomTestUtil.randomString());

		newDataType.setInputStatus(RandomTestUtil.randomBoolean());

		newDataType.setJumpTo(RandomTestUtil.randomBoolean());

		newDataType.setVerified(RandomTestUtil.randomString());

		newDataType.setFreezed(RandomTestUtil.randomString());

		_dataTypes.add(_persistence.update(newDataType));

		DataType existingDataType = _persistence.findByPrimaryKey(
			newDataType.getPrimaryKey());

		Assert.assertEquals(existingDataType.getUuid(), newDataType.getUuid());
		Assert.assertEquals(
			existingDataType.getDataTypeId(), newDataType.getDataTypeId());
		Assert.assertEquals(
			existingDataType.getCompanyId(), newDataType.getCompanyId());
		Assert.assertEquals(
			existingDataType.getGroupId(), newDataType.getGroupId());
		Assert.assertEquals(
			existingDataType.getUserId(), newDataType.getUserId());
		Assert.assertEquals(
			existingDataType.getUserName(), newDataType.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataType.getCreateDate()),
			Time.getShortTimestamp(newDataType.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataType.getModifiedDate()),
			Time.getShortTimestamp(newDataType.getModifiedDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataType.getLastPublishDate()),
			Time.getShortTimestamp(newDataType.getLastPublishDate()));
		Assert.assertEquals(
			existingDataType.getStatus(), newDataType.getStatus());
		Assert.assertEquals(
			existingDataType.getStatusByUserId(),
			newDataType.getStatusByUserId());
		Assert.assertEquals(
			existingDataType.getStatusByUserName(),
			newDataType.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataType.getStatusDate()),
			Time.getShortTimestamp(newDataType.getStatusDate()));
		Assert.assertEquals(
			existingDataType.getDataTypeCode(), newDataType.getDataTypeCode());
		Assert.assertEquals(
			existingDataType.getDataTypeVersion(),
			newDataType.getDataTypeVersion());
		Assert.assertEquals(
			existingDataType.getDisplayName(), newDataType.getDisplayName());
		Assert.assertEquals(
			existingDataType.getExtension(), newDataType.getExtension());
		Assert.assertEquals(
			existingDataType.getSampleFileId(), newDataType.getSampleFileId());
		Assert.assertEquals(
			existingDataType.getDescription(), newDataType.getDescription());
		Assert.assertEquals(
			existingDataType.isInputStatus(), newDataType.isInputStatus());
		Assert.assertEquals(
			existingDataType.isJumpTo(), newDataType.isJumpTo());
		Assert.assertEquals(
			existingDataType.getVerified(), newDataType.getVerified());
		Assert.assertEquals(
			existingDataType.getFreezed(), newDataType.getFreezed());
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
		DataType newDataType = addDataType();

		DataType existingDataType = _persistence.findByPrimaryKey(
			newDataType.getPrimaryKey());

		Assert.assertEquals(existingDataType, newDataType);
	}

	@Test(expected = NoSuchDataTypeException.class)
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

	protected OrderByComparator<DataType> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_DataType", "uuid", true, "dataTypeId", true, "companyId",
			true, "groupId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "lastPublishDate", true,
			"status", true, "statusByUserId", true, "statusByUserName", true,
			"statusDate", true, "dataTypeCode", true, "dataTypeVersion", true,
			"displayName", true, "extension", true, "sampleFileId", true,
			"description", true, "inputStatus", true, "jumpTo", true,
			"verified", true, "freezed", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DataType newDataType = addDataType();

		DataType existingDataType = _persistence.fetchByPrimaryKey(
			newDataType.getPrimaryKey());

		Assert.assertEquals(existingDataType, newDataType);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataType missingDataType = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDataType);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DataType newDataType1 = addDataType();
		DataType newDataType2 = addDataType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataType1.getPrimaryKey());
		primaryKeys.add(newDataType2.getPrimaryKey());

		Map<Serializable, DataType> dataTypes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, dataTypes.size());
		Assert.assertEquals(
			newDataType1, dataTypes.get(newDataType1.getPrimaryKey()));
		Assert.assertEquals(
			newDataType2, dataTypes.get(newDataType2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DataType> dataTypes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(dataTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DataType newDataType = addDataType();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataType.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DataType> dataTypes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, dataTypes.size());
		Assert.assertEquals(
			newDataType, dataTypes.get(newDataType.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DataType> dataTypes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(dataTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DataType newDataType = addDataType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataType.getPrimaryKey());

		Map<Serializable, DataType> dataTypes = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, dataTypes.size());
		Assert.assertEquals(
			newDataType, dataTypes.get(newDataType.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DataTypeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DataType>() {

				@Override
				public void performAction(DataType dataType) {
					Assert.assertNotNull(dataType);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DataType newDataType = addDataType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"dataTypeId", newDataType.getDataTypeId()));

		List<DataType> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		DataType existingDataType = result.get(0);

		Assert.assertEquals(existingDataType, newDataType);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"dataTypeId", RandomTestUtil.nextLong()));

		List<DataType> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DataType newDataType = addDataType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("dataTypeId"));

		Object newDataTypeId = newDataType.getDataTypeId();

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
			DataType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("dataTypeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dataTypeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		DataType newDataType = addDataType();

		_persistence.clearCache();

		DataType existingDataType = _persistence.findByPrimaryKey(
			newDataType.getPrimaryKey());

		Assert.assertEquals(
			existingDataType.getUuid(),
			ReflectionTestUtil.invoke(
				existingDataType, "getOriginalUuid", new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingDataType.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingDataType, "getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(
			existingDataType.getDataTypeCode(),
			ReflectionTestUtil.invoke(
				existingDataType, "getOriginalDataTypeCode", new Class<?>[0]));
		Assert.assertEquals(
			existingDataType.getDataTypeVersion(),
			ReflectionTestUtil.invoke(
				existingDataType, "getOriginalDataTypeVersion",
				new Class<?>[0]));
	}

	protected DataType addDataType() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataType dataType = _persistence.create(pk);

		dataType.setUuid(RandomTestUtil.randomString());

		dataType.setCompanyId(RandomTestUtil.nextLong());

		dataType.setGroupId(RandomTestUtil.nextLong());

		dataType.setUserId(RandomTestUtil.nextLong());

		dataType.setUserName(RandomTestUtil.randomString());

		dataType.setCreateDate(RandomTestUtil.nextDate());

		dataType.setModifiedDate(RandomTestUtil.nextDate());

		dataType.setLastPublishDate(RandomTestUtil.nextDate());

		dataType.setStatus(RandomTestUtil.nextInt());

		dataType.setStatusByUserId(RandomTestUtil.nextLong());

		dataType.setStatusByUserName(RandomTestUtil.randomString());

		dataType.setStatusDate(RandomTestUtil.nextDate());

		dataType.setDataTypeCode(RandomTestUtil.randomString());

		dataType.setDataTypeVersion(RandomTestUtil.randomString());

		dataType.setDisplayName(RandomTestUtil.randomString());

		dataType.setExtension(RandomTestUtil.randomString());

		dataType.setSampleFileId(RandomTestUtil.nextLong());

		dataType.setDescription(RandomTestUtil.randomString());

		dataType.setInputStatus(RandomTestUtil.randomBoolean());

		dataType.setJumpTo(RandomTestUtil.randomBoolean());

		dataType.setVerified(RandomTestUtil.randomString());

		dataType.setFreezed(RandomTestUtil.randomString());

		_dataTypes.add(_persistence.update(dataType));

		return dataType;
	}

	private List<DataType> _dataTypes = new ArrayList<DataType>();
	private DataTypePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}