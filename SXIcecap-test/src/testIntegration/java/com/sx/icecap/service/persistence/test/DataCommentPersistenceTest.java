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

import com.sx.icecap.exception.NoSuchDataCommentException;
import com.sx.icecap.model.DataComment;
import com.sx.icecap.service.DataCommentLocalServiceUtil;
import com.sx.icecap.service.persistence.DataCommentPersistence;
import com.sx.icecap.service.persistence.DataCommentUtil;

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
public class DataCommentPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = DataCommentUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DataComment> iterator = _dataComments.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataComment dataComment = _persistence.create(pk);

		Assert.assertNotNull(dataComment);

		Assert.assertEquals(dataComment.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DataComment newDataComment = addDataComment();

		_persistence.remove(newDataComment);

		DataComment existingDataComment = _persistence.fetchByPrimaryKey(
			newDataComment.getPrimaryKey());

		Assert.assertNull(existingDataComment);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDataComment();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataComment newDataComment = _persistence.create(pk);

		newDataComment.setUuid(RandomTestUtil.randomString());

		newDataComment.setCompanyId(RandomTestUtil.nextLong());

		newDataComment.setGroupId(RandomTestUtil.nextLong());

		newDataComment.setUserId(RandomTestUtil.nextLong());

		newDataComment.setUserName(RandomTestUtil.randomString());

		newDataComment.setCreateDate(RandomTestUtil.nextDate());

		newDataComment.setModifiedDate(RandomTestUtil.nextDate());

		newDataComment.setStatus(RandomTestUtil.nextInt());

		newDataComment.setStatusByUserId(RandomTestUtil.nextLong());

		newDataComment.setStatusByUserName(RandomTestUtil.randomString());

		newDataComment.setStatusDate(RandomTestUtil.nextDate());

		newDataComment.setLastPublishDate(RandomTestUtil.nextDate());

		newDataComment.setCommentModel(RandomTestUtil.randomString());

		newDataComment.setDataId(RandomTestUtil.nextLong());

		newDataComment.setParamCode(RandomTestUtil.randomString());

		newDataComment.setParentCommentId(RandomTestUtil.nextLong());

		newDataComment.setComment(RandomTestUtil.randomString());

		_dataComments.add(_persistence.update(newDataComment));

		DataComment existingDataComment = _persistence.findByPrimaryKey(
			newDataComment.getPrimaryKey());

		Assert.assertEquals(
			existingDataComment.getUuid(), newDataComment.getUuid());
		Assert.assertEquals(
			existingDataComment.getDataCommentId(),
			newDataComment.getDataCommentId());
		Assert.assertEquals(
			existingDataComment.getCompanyId(), newDataComment.getCompanyId());
		Assert.assertEquals(
			existingDataComment.getGroupId(), newDataComment.getGroupId());
		Assert.assertEquals(
			existingDataComment.getUserId(), newDataComment.getUserId());
		Assert.assertEquals(
			existingDataComment.getUserName(), newDataComment.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataComment.getCreateDate()),
			Time.getShortTimestamp(newDataComment.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataComment.getModifiedDate()),
			Time.getShortTimestamp(newDataComment.getModifiedDate()));
		Assert.assertEquals(
			existingDataComment.getStatus(), newDataComment.getStatus());
		Assert.assertEquals(
			existingDataComment.getStatusByUserId(),
			newDataComment.getStatusByUserId());
		Assert.assertEquals(
			existingDataComment.getStatusByUserName(),
			newDataComment.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataComment.getStatusDate()),
			Time.getShortTimestamp(newDataComment.getStatusDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDataComment.getLastPublishDate()),
			Time.getShortTimestamp(newDataComment.getLastPublishDate()));
		Assert.assertEquals(
			existingDataComment.getCommentModel(),
			newDataComment.getCommentModel());
		Assert.assertEquals(
			existingDataComment.getDataId(), newDataComment.getDataId());
		Assert.assertEquals(
			existingDataComment.getParamCode(), newDataComment.getParamCode());
		Assert.assertEquals(
			existingDataComment.getParentCommentId(),
			newDataComment.getParentCommentId());
		Assert.assertEquals(
			existingDataComment.getComment(), newDataComment.getComment());
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
	public void testCountByDataId() throws Exception {
		_persistence.countByDataId("", RandomTestUtil.nextLong());

		_persistence.countByDataId("null", 0L);

		_persistence.countByDataId((String)null, 0L);
	}

	@Test
	public void testCountByParamCode() throws Exception {
		_persistence.countByParamCode("", RandomTestUtil.nextLong(), "");

		_persistence.countByParamCode("null", 0L, "null");

		_persistence.countByParamCode((String)null, 0L, (String)null);
	}

	@Test
	public void testCountByModel() throws Exception {
		_persistence.countByModel("");

		_persistence.countByModel("null");

		_persistence.countByModel((String)null);
	}

	@Test
	public void testCountByModel_G() throws Exception {
		_persistence.countByModel_G(RandomTestUtil.nextLong(), "");

		_persistence.countByModel_G(0L, "null");

		_persistence.countByModel_G(0L, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DataComment newDataComment = addDataComment();

		DataComment existingDataComment = _persistence.findByPrimaryKey(
			newDataComment.getPrimaryKey());

		Assert.assertEquals(existingDataComment, newDataComment);
	}

	@Test(expected = NoSuchDataCommentException.class)
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

	protected OrderByComparator<DataComment> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_DataComment", "uuid", true, "dataCommentId", true,
			"companyId", true, "groupId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "status", true,
			"statusByUserId", true, "statusByUserName", true, "statusDate",
			true, "lastPublishDate", true, "commentModel", true, "dataId", true,
			"paramCode", true, "parentCommentId", true, "comment", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DataComment newDataComment = addDataComment();

		DataComment existingDataComment = _persistence.fetchByPrimaryKey(
			newDataComment.getPrimaryKey());

		Assert.assertEquals(existingDataComment, newDataComment);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataComment missingDataComment = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDataComment);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DataComment newDataComment1 = addDataComment();
		DataComment newDataComment2 = addDataComment();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataComment1.getPrimaryKey());
		primaryKeys.add(newDataComment2.getPrimaryKey());

		Map<Serializable, DataComment> dataComments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, dataComments.size());
		Assert.assertEquals(
			newDataComment1, dataComments.get(newDataComment1.getPrimaryKey()));
		Assert.assertEquals(
			newDataComment2, dataComments.get(newDataComment2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DataComment> dataComments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dataComments.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DataComment newDataComment = addDataComment();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataComment.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DataComment> dataComments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dataComments.size());
		Assert.assertEquals(
			newDataComment, dataComments.get(newDataComment.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DataComment> dataComments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dataComments.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DataComment newDataComment = addDataComment();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDataComment.getPrimaryKey());

		Map<Serializable, DataComment> dataComments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dataComments.size());
		Assert.assertEquals(
			newDataComment, dataComments.get(newDataComment.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DataCommentLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DataComment>() {

				@Override
				public void performAction(DataComment dataComment) {
					Assert.assertNotNull(dataComment);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DataComment newDataComment = addDataComment();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataComment.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"dataCommentId", newDataComment.getDataCommentId()));

		List<DataComment> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		DataComment existingDataComment = result.get(0);

		Assert.assertEquals(existingDataComment, newDataComment);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataComment.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"dataCommentId", RandomTestUtil.nextLong()));

		List<DataComment> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DataComment newDataComment = addDataComment();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataComment.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("dataCommentId"));

		Object newDataCommentId = newDataComment.getDataCommentId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dataCommentId", new Object[] {newDataCommentId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDataCommentId = result.get(0);

		Assert.assertEquals(existingDataCommentId, newDataCommentId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DataComment.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("dataCommentId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dataCommentId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		DataComment newDataComment = addDataComment();

		_persistence.clearCache();

		DataComment existingDataComment = _persistence.findByPrimaryKey(
			newDataComment.getPrimaryKey());

		Assert.assertEquals(
			existingDataComment.getUuid(),
			ReflectionTestUtil.invoke(
				existingDataComment, "getOriginalUuid", new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingDataComment.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingDataComment, "getOriginalGroupId", new Class<?>[0]));
	}

	protected DataComment addDataComment() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DataComment dataComment = _persistence.create(pk);

		dataComment.setUuid(RandomTestUtil.randomString());

		dataComment.setCompanyId(RandomTestUtil.nextLong());

		dataComment.setGroupId(RandomTestUtil.nextLong());

		dataComment.setUserId(RandomTestUtil.nextLong());

		dataComment.setUserName(RandomTestUtil.randomString());

		dataComment.setCreateDate(RandomTestUtil.nextDate());

		dataComment.setModifiedDate(RandomTestUtil.nextDate());

		dataComment.setStatus(RandomTestUtil.nextInt());

		dataComment.setStatusByUserId(RandomTestUtil.nextLong());

		dataComment.setStatusByUserName(RandomTestUtil.randomString());

		dataComment.setStatusDate(RandomTestUtil.nextDate());

		dataComment.setLastPublishDate(RandomTestUtil.nextDate());

		dataComment.setCommentModel(RandomTestUtil.randomString());

		dataComment.setDataId(RandomTestUtil.nextLong());

		dataComment.setParamCode(RandomTestUtil.randomString());

		dataComment.setParentCommentId(RandomTestUtil.nextLong());

		dataComment.setComment(RandomTestUtil.randomString());

		_dataComments.add(_persistence.update(dataComment));

		return dataComment;
	}

	private List<DataComment> _dataComments = new ArrayList<DataComment>();
	private DataCommentPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}