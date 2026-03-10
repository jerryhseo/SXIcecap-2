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

import com.sx.icecap.exception.NoSuchStructuredDataException;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.StructuredDataLocalServiceUtil;
import com.sx.icecap.service.persistence.StructuredDataPersistence;
import com.sx.icecap.service.persistence.StructuredDataUtil;

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
public class StructuredDataPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = StructuredDataUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<StructuredData> iterator = _structuredDatas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StructuredData structuredData = _persistence.create(pk);

		Assert.assertNotNull(structuredData);

		Assert.assertEquals(structuredData.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		StructuredData newStructuredData = addStructuredData();

		_persistence.remove(newStructuredData);

		StructuredData existingStructuredData = _persistence.fetchByPrimaryKey(
			newStructuredData.getPrimaryKey());

		Assert.assertNull(existingStructuredData);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addStructuredData();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StructuredData newStructuredData = _persistence.create(pk);

		newStructuredData.setUuid(RandomTestUtil.randomString());

		newStructuredData.setGroupId(RandomTestUtil.nextLong());

		newStructuredData.setCompanyId(RandomTestUtil.nextLong());

		newStructuredData.setUserId(RandomTestUtil.nextLong());

		newStructuredData.setUserName(RandomTestUtil.randomString());

		newStructuredData.setCreateDate(RandomTestUtil.nextDate());

		newStructuredData.setModifiedDate(RandomTestUtil.nextDate());

		newStructuredData.setStatus(RandomTestUtil.nextInt());

		newStructuredData.setStatusByUserId(RandomTestUtil.nextLong());

		newStructuredData.setStatusByUserName(RandomTestUtil.randomString());

		newStructuredData.setStatusDate(RandomTestUtil.nextDate());

		newStructuredData.setDataCollectionId(RandomTestUtil.nextLong());

		newStructuredData.setDataSetId(RandomTestUtil.nextLong());

		newStructuredData.setDataTypeId(RandomTestUtil.nextLong());

		newStructuredData.setMultiple(RandomTestUtil.randomBoolean());

		newStructuredData.setStartIndex(RandomTestUtil.nextLong());

		newStructuredData.setCount(RandomTestUtil.nextInt());

		newStructuredData.setFreezed(RandomTestUtil.randomString());

		newStructuredData.setFreezedUserId(RandomTestUtil.nextLong());

		newStructuredData.setFreezedUserName(RandomTestUtil.randomString());

		newStructuredData.setFreezedDate(RandomTestUtil.nextDate());

		newStructuredData.setVerified(RandomTestUtil.randomBoolean());

		newStructuredData.setVerifiedUserId(RandomTestUtil.nextLong());

		newStructuredData.setVerifiedUserName(RandomTestUtil.randomString());

		newStructuredData.setVerifiedDate(RandomTestUtil.nextDate());

		newStructuredData.setData(RandomTestUtil.randomString());

		_structuredDatas.add(_persistence.update(newStructuredData));

		StructuredData existingStructuredData = _persistence.findByPrimaryKey(
			newStructuredData.getPrimaryKey());

		Assert.assertEquals(
			existingStructuredData.getUuid(), newStructuredData.getUuid());
		Assert.assertEquals(
			existingStructuredData.getStructuredDataId(),
			newStructuredData.getStructuredDataId());
		Assert.assertEquals(
			existingStructuredData.getGroupId(),
			newStructuredData.getGroupId());
		Assert.assertEquals(
			existingStructuredData.getCompanyId(),
			newStructuredData.getCompanyId());
		Assert.assertEquals(
			existingStructuredData.getUserId(), newStructuredData.getUserId());
		Assert.assertEquals(
			existingStructuredData.getUserName(),
			newStructuredData.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingStructuredData.getCreateDate()),
			Time.getShortTimestamp(newStructuredData.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingStructuredData.getModifiedDate()),
			Time.getShortTimestamp(newStructuredData.getModifiedDate()));
		Assert.assertEquals(
			existingStructuredData.getStatus(), newStructuredData.getStatus());
		Assert.assertEquals(
			existingStructuredData.getStatusByUserId(),
			newStructuredData.getStatusByUserId());
		Assert.assertEquals(
			existingStructuredData.getStatusByUserName(),
			newStructuredData.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingStructuredData.getStatusDate()),
			Time.getShortTimestamp(newStructuredData.getStatusDate()));
		Assert.assertEquals(
			existingStructuredData.getDataCollectionId(),
			newStructuredData.getDataCollectionId());
		Assert.assertEquals(
			existingStructuredData.getDataSetId(),
			newStructuredData.getDataSetId());
		Assert.assertEquals(
			existingStructuredData.getDataTypeId(),
			newStructuredData.getDataTypeId());
		Assert.assertEquals(
			existingStructuredData.isMultiple(),
			newStructuredData.isMultiple());
		Assert.assertEquals(
			existingStructuredData.getStartIndex(),
			newStructuredData.getStartIndex());
		Assert.assertEquals(
			existingStructuredData.getCount(), newStructuredData.getCount());
		Assert.assertEquals(
			existingStructuredData.getFreezed(),
			newStructuredData.getFreezed());
		Assert.assertEquals(
			existingStructuredData.getFreezedUserId(),
			newStructuredData.getFreezedUserId());
		Assert.assertEquals(
			existingStructuredData.getFreezedUserName(),
			newStructuredData.getFreezedUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingStructuredData.getFreezedDate()),
			Time.getShortTimestamp(newStructuredData.getFreezedDate()));
		Assert.assertEquals(
			existingStructuredData.isVerified(),
			newStructuredData.isVerified());
		Assert.assertEquals(
			existingStructuredData.getVerifiedUserId(),
			newStructuredData.getVerifiedUserId());
		Assert.assertEquals(
			existingStructuredData.getVerifiedUserName(),
			newStructuredData.getVerifiedUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingStructuredData.getVerifiedDate()),
			Time.getShortTimestamp(newStructuredData.getVerifiedDate()));
		Assert.assertEquals(
			existingStructuredData.getData(), newStructuredData.getData());
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
	public void testCountByGroupId_S() throws Exception {
		_persistence.countByGroupId_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByGroupId_S(0L, 0);
	}

	@Test
	public void testCountByUserId() throws Exception {
		_persistence.countByUserId(RandomTestUtil.nextLong());

		_persistence.countByUserId(0L);
	}

	@Test
	public void testCountByUserId_S() throws Exception {
		_persistence.countByUserId_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByUserId_S(0L, 0);
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
	public void testCountByG_U_S() throws Exception {
		_persistence.countByG_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByG_U_S(0L, 0L, 0);
	}

	@Test
	public void testCountByDataCollectionId() throws Exception {
		_persistence.countByDataCollectionId(RandomTestUtil.nextLong());

		_persistence.countByDataCollectionId(0L);
	}

	@Test
	public void testCountByDataCollectionId_S() throws Exception {
		_persistence.countByDataCollectionId_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByDataCollectionId_S(0L, 0);
	}

	@Test
	public void testCountByDataCollectionId_G() throws Exception {
		_persistence.countByDataCollectionId_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByDataCollectionId_G(0L, 0L);
	}

	@Test
	public void testCountByDataCollectionId_G_S() throws Exception {
		_persistence.countByDataCollectionId_G_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByDataCollectionId_G_S(0L, 0L, 0);
	}

	@Test
	public void testCountByDataCollectionId_U() throws Exception {
		_persistence.countByDataCollectionId_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByDataCollectionId_U(0L, 0L);
	}

	@Test
	public void testCountByDataCollectionId_U_S() throws Exception {
		_persistence.countByDataCollectionId_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByDataCollectionId_U_S(0L, 0L, 0);
	}

	@Test
	public void testCountByDataCollectionId_G_U() throws Exception {
		_persistence.countByDataCollectionId_G_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByDataCollectionId_G_U(0L, 0L, 0L);
	}

	@Test
	public void testCountByDataCollectionId_G_U_S() throws Exception {
		_persistence.countByDataCollectionId_G_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByDataCollectionId_G_U_S(0L, 0L, 0L, 0);
	}

	@Test
	public void testCountByDataSetId() throws Exception {
		_persistence.countByDataSetId(RandomTestUtil.nextLong());

		_persistence.countByDataSetId(0L);
	}

	@Test
	public void testCountByDataSetId_S() throws Exception {
		_persistence.countByDataSetId_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByDataSetId_S(0L, 0);
	}

	@Test
	public void testCountByDataSetId_G() throws Exception {
		_persistence.countByDataSetId_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByDataSetId_G(0L, 0L);
	}

	@Test
	public void testCountByDataSetId_G_S() throws Exception {
		_persistence.countByDataSetId_G_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByDataSetId_G_S(0L, 0L, 0);
	}

	@Test
	public void testCountByDataSetId_U() throws Exception {
		_persistence.countByDataSetId_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByDataSetId_U(0L, 0L);
	}

	@Test
	public void testCountByDataSetId_U_S() throws Exception {
		_persistence.countByDataSetId_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByDataSetId_U_S(0L, 0L, 0);
	}

	@Test
	public void testCountByDataSetId_G_U() throws Exception {
		_persistence.countByDataSetId_G_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByDataSetId_G_U(0L, 0L, 0L);
	}

	@Test
	public void testCountByDataSetId_G_U_S() throws Exception {
		_persistence.countByDataSetId_G_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByDataSetId_G_U_S(0L, 0L, 0L, 0);
	}

	@Test
	public void testCountByCollectionSet() throws Exception {
		_persistence.countByCollectionSet(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByCollectionSet(0L, 0L);
	}

	@Test
	public void testCountByCollectionSet_S() throws Exception {
		_persistence.countByCollectionSet_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByCollectionSet_S(0L, 0L, 0);
	}

	@Test
	public void testCountByCollectionSet_G() throws Exception {
		_persistence.countByCollectionSet_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByCollectionSet_G(0L, 0L, 0L);
	}

	@Test
	public void testCountByCollectionSet_G_S() throws Exception {
		_persistence.countByCollectionSet_G_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByCollectionSet_G_S(0L, 0L, 0L, 0);
	}

	@Test
	public void testCountByCollectionSet_U() throws Exception {
		_persistence.countByCollectionSet_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByCollectionSet_U(0L, 0L, 0L);
	}

	@Test
	public void testCountByCollectionSet_U_S() throws Exception {
		_persistence.countByCollectionSet_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByCollectionSet_U_S(0L, 0L, 0L, 0);
	}

	@Test
	public void testCountByCollectionSet_G_U() throws Exception {
		_persistence.countByCollectionSet_G_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByCollectionSet_G_U(0L, 0L, 0L, 0L);
	}

	@Test
	public void testCountByCollectionSet_G_U_S() throws Exception {
		_persistence.countByCollectionSet_G_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByCollectionSet_G_U_S(0L, 0L, 0L, 0L, 0);
	}

	@Test
	public void testCountBySetType() throws Exception {
		_persistence.countBySetType(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countBySetType(0L, 0L);
	}

	@Test
	public void testCountBySetType_S() throws Exception {
		_persistence.countBySetType_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countBySetType_S(0L, 0L, 0);
	}

	@Test
	public void testCountBySetType_G() throws Exception {
		_persistence.countBySetType_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countBySetType_G(0L, 0L, 0L);
	}

	@Test
	public void testCountBySetType_G_S() throws Exception {
		_persistence.countBySetType_G_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countBySetType_G_S(0L, 0L, 0L, 0);
	}

	@Test
	public void testCountBySetType_U() throws Exception {
		_persistence.countBySetType_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countBySetType_U(0L, 0L, 0L);
	}

	@Test
	public void testCountBySetType_U_S() throws Exception {
		_persistence.countBySetType_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countBySetType_U_S(0L, 0L, 0L, 0);
	}

	@Test
	public void testCountBySetType_G_U() throws Exception {
		_persistence.countBySetType_G_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countBySetType_G_U(0L, 0L, 0L, 0L);
	}

	@Test
	public void testCountBySetType_G_U_S() throws Exception {
		_persistence.countBySetType_G_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countBySetType_G_U_S(0L, 0L, 0L, 0L, 0);
	}

	@Test
	public void testCountByCollectionSetType() throws Exception {
		_persistence.countByCollectionSetType(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByCollectionSetType(0L, 0L, 0L);
	}

	@Test
	public void testCountByCollectionSetType_S() throws Exception {
		_persistence.countByCollectionSetType_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByCollectionSetType_S(0L, 0L, 0L, 0);
	}

	@Test
	public void testCountByCollectionSetType_G() throws Exception {
		_persistence.countByCollectionSetType_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByCollectionSetType_G(0L, 0L, 0L, 0L);
	}

	@Test
	public void testCountByCollectionSetType_G_S() throws Exception {
		_persistence.countByCollectionSetType_G_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByCollectionSetType_G_S(0L, 0L, 0L, 0L, 0);
	}

	@Test
	public void testCountByCollectionSetType_U() throws Exception {
		_persistence.countByCollectionSetType_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByCollectionSetType_U(0L, 0L, 0L, 0L);
	}

	@Test
	public void testCountByCollectionSetType_U_S() throws Exception {
		_persistence.countByCollectionSetType_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByCollectionSetType_U_S(0L, 0L, 0L, 0L, 0);
	}

	@Test
	public void testCountByCollectionSetType_G_U() throws Exception {
		_persistence.countByCollectionSetType_G_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByCollectionSetType_G_U(0L, 0L, 0L, 0L, 0L);
	}

	@Test
	public void testCountByCollectionSetType_G_U_S() throws Exception {
		_persistence.countByCollectionSetType_G_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByCollectionSetType_G_U_S(0L, 0L, 0L, 0L, 0L, 0);
	}

	@Test
	public void testCountByDataTypeId() throws Exception {
		_persistence.countByDataTypeId(RandomTestUtil.nextLong());

		_persistence.countByDataTypeId(0L);
	}

	@Test
	public void testCountByDataTypeId_S() throws Exception {
		_persistence.countByDataTypeId_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByDataTypeId_S(0L, 0);
	}

	@Test
	public void testCountByDataTypeId_G() throws Exception {
		_persistence.countByDataTypeId_G(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByDataTypeId_G(0L, 0L);
	}

	@Test
	public void testCountByDataTypeId_G_S() throws Exception {
		_persistence.countByDataTypeId_G_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByDataTypeId_G_S(0L, 0L, 0);
	}

	@Test
	public void testCountByDataTypeId_U() throws Exception {
		_persistence.countByDataTypeId_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByDataTypeId_U(0L, 0L);
	}

	@Test
	public void testCountByDataTypeId_U_S() throws Exception {
		_persistence.countByDataTypeId_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByDataTypeId_U_S(0L, 0L, 0);
	}

	@Test
	public void testCountByDataTypeId_G_U() throws Exception {
		_persistence.countByDataTypeId_G_U(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByDataTypeId_G_U(0L, 0L, 0L);
	}

	@Test
	public void testCountByDataTypeId_G_U_S() throws Exception {
		_persistence.countByDataTypeId_G_U_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByDataTypeId_G_U_S(0L, 0L, 0L, 0);
	}

	@Test
	public void testCountByCollectionId_G_F() throws Exception {
		_persistence.countByCollectionId_G_F(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(), "");

		_persistence.countByCollectionId_G_F(0L, 0L, "null");

		_persistence.countByCollectionId_G_F(0L, 0L, (String)null);
	}

	@Test
	public void testCountByCollectionId_G_S_F() throws Exception {
		_persistence.countByCollectionId_G_S_F(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(), "",
			RandomTestUtil.nextInt());

		_persistence.countByCollectionId_G_S_F(0L, 0L, "null", 0);

		_persistence.countByCollectionId_G_S_F(0L, 0L, (String)null, 0);
	}

	@Test
	public void testCountByCollectionSet_G_F() throws Exception {
		_persistence.countByCollectionSet_G_F(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), "");

		_persistence.countByCollectionSet_G_F(0L, 0L, 0L, "null");

		_persistence.countByCollectionSet_G_F(0L, 0L, 0L, (String)null);
	}

	@Test
	public void testCountByCollectionSet_G_S_F() throws Exception {
		_persistence.countByCollectionSet_G_S_F(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), "", RandomTestUtil.nextInt());

		_persistence.countByCollectionSet_G_S_F(0L, 0L, 0L, "null", 0);

		_persistence.countByCollectionSet_G_S_F(0L, 0L, 0L, (String)null, 0);
	}

	@Test
	public void testCountByCollectionSetType_G_F() throws Exception {
		_persistence.countByCollectionSetType_G_F(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(), "");

		_persistence.countByCollectionSetType_G_F(0L, 0L, 0L, 0L, "null");

		_persistence.countByCollectionSetType_G_F(0L, 0L, 0L, 0L, (String)null);
	}

	@Test
	public void testCountByCollectionSetType_G_S_F() throws Exception {
		_persistence.countByCollectionSetType_G_S_F(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(), "",
			RandomTestUtil.nextInt());

		_persistence.countByCollectionSetType_G_S_F(0L, 0L, 0L, 0L, "null", 0);

		_persistence.countByCollectionSetType_G_S_F(
			0L, 0L, 0L, 0L, (String)null, 0);
	}

	@Test
	public void testCountByCollectionId_G_V() throws Exception {
		_persistence.countByCollectionId_G_V(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.randomBoolean());

		_persistence.countByCollectionId_G_V(
			0L, 0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByCollectionId_G_S_V() throws Exception {
		_persistence.countByCollectionId_G_S_V(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.randomBoolean(),
			RandomTestUtil.nextInt());

		_persistence.countByCollectionId_G_S_V(
			0L, 0L, 0L, RandomTestUtil.randomBoolean(), 0);
	}

	@Test
	public void testCountByCollectionSet_G_V() throws Exception {
		_persistence.countByCollectionSet_G_V(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), "");

		_persistence.countByCollectionSet_G_V(0L, 0L, 0L, "null");

		_persistence.countByCollectionSet_G_V(0L, 0L, 0L, (String)null);
	}

	@Test
	public void testCountByCollectionSet_G_S_V() throws Exception {
		_persistence.countByCollectionSet_G_S_V(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), "", RandomTestUtil.nextInt());

		_persistence.countByCollectionSet_G_S_V(0L, 0L, 0L, "null", 0);

		_persistence.countByCollectionSet_G_S_V(0L, 0L, 0L, (String)null, 0);
	}

	@Test
	public void testCountByCollectionSetType_G_V() throws Exception {
		_persistence.countByCollectionSetType_G_V(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(), "");

		_persistence.countByCollectionSetType_G_V(0L, 0L, 0L, 0L, "null");

		_persistence.countByCollectionSetType_G_V(0L, 0L, 0L, 0L, (String)null);
	}

	@Test
	public void testCountByCollectionSetType_G_S_V() throws Exception {
		_persistence.countByCollectionSetType_G_S_V(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(), "",
			RandomTestUtil.nextInt());

		_persistence.countByCollectionSetType_G_S_V(0L, 0L, 0L, 0L, "null", 0);

		_persistence.countByCollectionSetType_G_S_V(
			0L, 0L, 0L, 0L, (String)null, 0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		StructuredData newStructuredData = addStructuredData();

		StructuredData existingStructuredData = _persistence.findByPrimaryKey(
			newStructuredData.getPrimaryKey());

		Assert.assertEquals(existingStructuredData, newStructuredData);
	}

	@Test(expected = NoSuchStructuredDataException.class)
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

	protected OrderByComparator<StructuredData> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_StructuredData", "uuid", true, "structuredDataId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "status", true,
			"statusByUserId", true, "statusByUserName", true, "statusDate",
			true, "dataCollectionId", true, "dataSetId", true, "dataTypeId",
			true, "multiple", true, "startIndex", true, "count", true,
			"freezed", true, "freezedUserId", true, "freezedUserName", true,
			"freezedDate", true, "verified", true, "verifiedUserId", true,
			"verifiedUserName", true, "verifiedDate", true, "data", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		StructuredData newStructuredData = addStructuredData();

		StructuredData existingStructuredData = _persistence.fetchByPrimaryKey(
			newStructuredData.getPrimaryKey());

		Assert.assertEquals(existingStructuredData, newStructuredData);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StructuredData missingStructuredData = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingStructuredData);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		StructuredData newStructuredData1 = addStructuredData();
		StructuredData newStructuredData2 = addStructuredData();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStructuredData1.getPrimaryKey());
		primaryKeys.add(newStructuredData2.getPrimaryKey());

		Map<Serializable, StructuredData> structuredDatas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, structuredDatas.size());
		Assert.assertEquals(
			newStructuredData1,
			structuredDatas.get(newStructuredData1.getPrimaryKey()));
		Assert.assertEquals(
			newStructuredData2,
			structuredDatas.get(newStructuredData2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, StructuredData> structuredDatas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(structuredDatas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		StructuredData newStructuredData = addStructuredData();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStructuredData.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, StructuredData> structuredDatas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, structuredDatas.size());
		Assert.assertEquals(
			newStructuredData,
			structuredDatas.get(newStructuredData.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, StructuredData> structuredDatas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(structuredDatas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		StructuredData newStructuredData = addStructuredData();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStructuredData.getPrimaryKey());

		Map<Serializable, StructuredData> structuredDatas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, structuredDatas.size());
		Assert.assertEquals(
			newStructuredData,
			structuredDatas.get(newStructuredData.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			StructuredDataLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<StructuredData>() {

				@Override
				public void performAction(StructuredData structuredData) {
					Assert.assertNotNull(structuredData);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		StructuredData newStructuredData = addStructuredData();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StructuredData.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"structuredDataId", newStructuredData.getStructuredDataId()));

		List<StructuredData> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		StructuredData existingStructuredData = result.get(0);

		Assert.assertEquals(existingStructuredData, newStructuredData);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StructuredData.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"structuredDataId", RandomTestUtil.nextLong()));

		List<StructuredData> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		StructuredData newStructuredData = addStructuredData();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StructuredData.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("structuredDataId"));

		Object newStructuredDataId = newStructuredData.getStructuredDataId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"structuredDataId", new Object[] {newStructuredDataId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingStructuredDataId = result.get(0);

		Assert.assertEquals(existingStructuredDataId, newStructuredDataId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StructuredData.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("structuredDataId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"structuredDataId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		StructuredData newStructuredData = addStructuredData();

		_persistence.clearCache();

		StructuredData existingStructuredData = _persistence.findByPrimaryKey(
			newStructuredData.getPrimaryKey());

		Assert.assertEquals(
			existingStructuredData.getUuid(),
			ReflectionTestUtil.invoke(
				existingStructuredData, "getOriginalUuid", new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingStructuredData.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingStructuredData, "getOriginalGroupId", new Class<?>[0]));
	}

	protected StructuredData addStructuredData() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StructuredData structuredData = _persistence.create(pk);

		structuredData.setUuid(RandomTestUtil.randomString());

		structuredData.setGroupId(RandomTestUtil.nextLong());

		structuredData.setCompanyId(RandomTestUtil.nextLong());

		structuredData.setUserId(RandomTestUtil.nextLong());

		structuredData.setUserName(RandomTestUtil.randomString());

		structuredData.setCreateDate(RandomTestUtil.nextDate());

		structuredData.setModifiedDate(RandomTestUtil.nextDate());

		structuredData.setStatus(RandomTestUtil.nextInt());

		structuredData.setStatusByUserId(RandomTestUtil.nextLong());

		structuredData.setStatusByUserName(RandomTestUtil.randomString());

		structuredData.setStatusDate(RandomTestUtil.nextDate());

		structuredData.setDataCollectionId(RandomTestUtil.nextLong());

		structuredData.setDataSetId(RandomTestUtil.nextLong());

		structuredData.setDataTypeId(RandomTestUtil.nextLong());

		structuredData.setMultiple(RandomTestUtil.randomBoolean());

		structuredData.setStartIndex(RandomTestUtil.nextLong());

		structuredData.setCount(RandomTestUtil.nextInt());

		structuredData.setFreezed(RandomTestUtil.randomString());

		structuredData.setFreezedUserId(RandomTestUtil.nextLong());

		structuredData.setFreezedUserName(RandomTestUtil.randomString());

		structuredData.setFreezedDate(RandomTestUtil.nextDate());

		structuredData.setVerified(RandomTestUtil.randomBoolean());

		structuredData.setVerifiedUserId(RandomTestUtil.nextLong());

		structuredData.setVerifiedUserName(RandomTestUtil.randomString());

		structuredData.setVerifiedDate(RandomTestUtil.nextDate());

		structuredData.setData(RandomTestUtil.randomString());

		_structuredDatas.add(_persistence.update(structuredData));

		return structuredData;
	}

	private List<StructuredData> _structuredDatas =
		new ArrayList<StructuredData>();
	private StructuredDataPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}