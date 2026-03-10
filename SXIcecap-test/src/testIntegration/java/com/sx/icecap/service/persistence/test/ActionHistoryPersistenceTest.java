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
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.sx.icecap.exception.NoSuchActionHistoryException;
import com.sx.icecap.model.ActionHistory;
import com.sx.icecap.service.ActionHistoryLocalServiceUtil;
import com.sx.icecap.service.persistence.ActionHistoryPersistence;
import com.sx.icecap.service.persistence.ActionHistoryUtil;

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
public class ActionHistoryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = ActionHistoryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ActionHistory> iterator = _actionHistories.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ActionHistory actionHistory = _persistence.create(pk);

		Assert.assertNotNull(actionHistory);

		Assert.assertEquals(actionHistory.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ActionHistory newActionHistory = addActionHistory();

		_persistence.remove(newActionHistory);

		ActionHistory existingActionHistory = _persistence.fetchByPrimaryKey(
			newActionHistory.getPrimaryKey());

		Assert.assertNull(existingActionHistory);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addActionHistory();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ActionHistory newActionHistory = _persistence.create(pk);

		newActionHistory.setUserId(RandomTestUtil.nextLong());

		newActionHistory.setUserName(RandomTestUtil.randomString());

		newActionHistory.setCreateDate(RandomTestUtil.nextDate());

		newActionHistory.setActionModel(RandomTestUtil.randomString());

		newActionHistory.setDataId(RandomTestUtil.nextLong());

		newActionHistory.setParamCode(RandomTestUtil.randomString());

		newActionHistory.setActionCommand(RandomTestUtil.randomString());

		newActionHistory.setPrevValue(RandomTestUtil.randomString());

		newActionHistory.setModifiedValue(RandomTestUtil.randomString());

		newActionHistory.setComment(RandomTestUtil.randomString());

		_actionHistories.add(_persistence.update(newActionHistory));

		ActionHistory existingActionHistory = _persistence.findByPrimaryKey(
			newActionHistory.getPrimaryKey());

		Assert.assertEquals(
			existingActionHistory.getActionHistoryId(),
			newActionHistory.getActionHistoryId());
		Assert.assertEquals(
			existingActionHistory.getUserId(), newActionHistory.getUserId());
		Assert.assertEquals(
			existingActionHistory.getUserName(),
			newActionHistory.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingActionHistory.getCreateDate()),
			Time.getShortTimestamp(newActionHistory.getCreateDate()));
		Assert.assertEquals(
			existingActionHistory.getActionModel(),
			newActionHistory.getActionModel());
		Assert.assertEquals(
			existingActionHistory.getDataId(), newActionHistory.getDataId());
		Assert.assertEquals(
			existingActionHistory.getParamCode(),
			newActionHistory.getParamCode());
		Assert.assertEquals(
			existingActionHistory.getActionCommand(),
			newActionHistory.getActionCommand());
		Assert.assertEquals(
			existingActionHistory.getPrevValue(),
			newActionHistory.getPrevValue());
		Assert.assertEquals(
			existingActionHistory.getModifiedValue(),
			newActionHistory.getModifiedValue());
		Assert.assertEquals(
			existingActionHistory.getComment(), newActionHistory.getComment());
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
	public void testFindByPrimaryKeyExisting() throws Exception {
		ActionHistory newActionHistory = addActionHistory();

		ActionHistory existingActionHistory = _persistence.findByPrimaryKey(
			newActionHistory.getPrimaryKey());

		Assert.assertEquals(existingActionHistory, newActionHistory);
	}

	@Test(expected = NoSuchActionHistoryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ActionHistory> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_ActionHistory", "actionHistoryId", true, "userId", true,
			"userName", true, "createDate", true, "actionModel", true, "dataId",
			true, "paramCode", true, "actionCommand", true, "prevValue", true,
			"modifiedValue", true, "comment", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ActionHistory newActionHistory = addActionHistory();

		ActionHistory existingActionHistory = _persistence.fetchByPrimaryKey(
			newActionHistory.getPrimaryKey());

		Assert.assertEquals(existingActionHistory, newActionHistory);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ActionHistory missingActionHistory = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingActionHistory);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ActionHistory newActionHistory1 = addActionHistory();
		ActionHistory newActionHistory2 = addActionHistory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newActionHistory1.getPrimaryKey());
		primaryKeys.add(newActionHistory2.getPrimaryKey());

		Map<Serializable, ActionHistory> actionHistories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, actionHistories.size());
		Assert.assertEquals(
			newActionHistory1,
			actionHistories.get(newActionHistory1.getPrimaryKey()));
		Assert.assertEquals(
			newActionHistory2,
			actionHistories.get(newActionHistory2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ActionHistory> actionHistories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(actionHistories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ActionHistory newActionHistory = addActionHistory();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newActionHistory.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ActionHistory> actionHistories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, actionHistories.size());
		Assert.assertEquals(
			newActionHistory,
			actionHistories.get(newActionHistory.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ActionHistory> actionHistories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(actionHistories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ActionHistory newActionHistory = addActionHistory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newActionHistory.getPrimaryKey());

		Map<Serializable, ActionHistory> actionHistories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, actionHistories.size());
		Assert.assertEquals(
			newActionHistory,
			actionHistories.get(newActionHistory.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ActionHistoryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ActionHistory>() {

				@Override
				public void performAction(ActionHistory actionHistory) {
					Assert.assertNotNull(actionHistory);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ActionHistory newActionHistory = addActionHistory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ActionHistory.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"actionHistoryId", newActionHistory.getActionHistoryId()));

		List<ActionHistory> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ActionHistory existingActionHistory = result.get(0);

		Assert.assertEquals(existingActionHistory, newActionHistory);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ActionHistory.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"actionHistoryId", RandomTestUtil.nextLong()));

		List<ActionHistory> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ActionHistory newActionHistory = addActionHistory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ActionHistory.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("actionHistoryId"));

		Object newActionHistoryId = newActionHistory.getActionHistoryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"actionHistoryId", new Object[] {newActionHistoryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingActionHistoryId = result.get(0);

		Assert.assertEquals(existingActionHistoryId, newActionHistoryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ActionHistory.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("actionHistoryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"actionHistoryId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ActionHistory addActionHistory() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ActionHistory actionHistory = _persistence.create(pk);

		actionHistory.setUserId(RandomTestUtil.nextLong());

		actionHistory.setUserName(RandomTestUtil.randomString());

		actionHistory.setCreateDate(RandomTestUtil.nextDate());

		actionHistory.setActionModel(RandomTestUtil.randomString());

		actionHistory.setDataId(RandomTestUtil.nextLong());

		actionHistory.setParamCode(RandomTestUtil.randomString());

		actionHistory.setActionCommand(RandomTestUtil.randomString());

		actionHistory.setPrevValue(RandomTestUtil.randomString());

		actionHistory.setModifiedValue(RandomTestUtil.randomString());

		actionHistory.setComment(RandomTestUtil.randomString());

		_actionHistories.add(_persistence.update(actionHistory));

		return actionHistory;
	}

	private List<ActionHistory> _actionHistories =
		new ArrayList<ActionHistory>();
	private ActionHistoryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}