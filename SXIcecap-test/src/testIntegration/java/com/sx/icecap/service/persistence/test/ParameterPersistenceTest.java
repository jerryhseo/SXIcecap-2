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

import com.sx.icecap.exception.NoSuchParameterException;
import com.sx.icecap.model.Parameter;
import com.sx.icecap.service.ParameterLocalServiceUtil;
import com.sx.icecap.service.persistence.ParameterPersistence;
import com.sx.icecap.service.persistence.ParameterUtil;

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
public class ParameterPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.sx.icecap.service"));

	@Before
	public void setUp() {
		_persistence = ParameterUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Parameter> iterator = _parameters.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Parameter parameter = _persistence.create(pk);

		Assert.assertNotNull(parameter);

		Assert.assertEquals(parameter.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Parameter newParameter = addParameter();

		_persistence.remove(newParameter);

		Parameter existingParameter = _persistence.fetchByPrimaryKey(
			newParameter.getPrimaryKey());

		Assert.assertNull(existingParameter);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addParameter();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Parameter newParameter = _persistence.create(pk);

		newParameter.setUuid(RandomTestUtil.randomString());

		newParameter.setCompanyId(RandomTestUtil.nextLong());

		newParameter.setGroupId(RandomTestUtil.nextLong());

		newParameter.setUserId(RandomTestUtil.nextLong());

		newParameter.setUserName(RandomTestUtil.randomString());

		newParameter.setCreateDate(RandomTestUtil.nextDate());

		newParameter.setModifiedDate(RandomTestUtil.nextDate());

		newParameter.setStatus(RandomTestUtil.nextInt());

		newParameter.setStatusByUserId(RandomTestUtil.nextLong());

		newParameter.setStatusByUserName(RandomTestUtil.randomString());

		newParameter.setStatusDate(RandomTestUtil.nextDate());

		newParameter.setLastPublishDate(RandomTestUtil.nextDate());

		newParameter.setParamCode(RandomTestUtil.randomString());

		newParameter.setParamVersion(RandomTestUtil.randomString());

		newParameter.setParamType(RandomTestUtil.randomString());

		newParameter.setDisplayName(RandomTestUtil.randomString());

		newParameter.setDefinition(RandomTestUtil.randomString());

		newParameter.setTooltip(RandomTestUtil.randomString());

		newParameter.setSynonyms(RandomTestUtil.randomString());

		newParameter.setTypeProperties(RandomTestUtil.randomString());

		newParameter.setStandard(RandomTestUtil.randomBoolean());

		_parameters.add(_persistence.update(newParameter));

		Parameter existingParameter = _persistence.findByPrimaryKey(
			newParameter.getPrimaryKey());

		Assert.assertEquals(
			existingParameter.getUuid(), newParameter.getUuid());
		Assert.assertEquals(
			existingParameter.getParameterId(), newParameter.getParameterId());
		Assert.assertEquals(
			existingParameter.getCompanyId(), newParameter.getCompanyId());
		Assert.assertEquals(
			existingParameter.getGroupId(), newParameter.getGroupId());
		Assert.assertEquals(
			existingParameter.getUserId(), newParameter.getUserId());
		Assert.assertEquals(
			existingParameter.getUserName(), newParameter.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingParameter.getCreateDate()),
			Time.getShortTimestamp(newParameter.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingParameter.getModifiedDate()),
			Time.getShortTimestamp(newParameter.getModifiedDate()));
		Assert.assertEquals(
			existingParameter.getStatus(), newParameter.getStatus());
		Assert.assertEquals(
			existingParameter.getStatusByUserId(),
			newParameter.getStatusByUserId());
		Assert.assertEquals(
			existingParameter.getStatusByUserName(),
			newParameter.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingParameter.getStatusDate()),
			Time.getShortTimestamp(newParameter.getStatusDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingParameter.getLastPublishDate()),
			Time.getShortTimestamp(newParameter.getLastPublishDate()));
		Assert.assertEquals(
			existingParameter.getParamCode(), newParameter.getParamCode());
		Assert.assertEquals(
			existingParameter.getParamVersion(),
			newParameter.getParamVersion());
		Assert.assertEquals(
			existingParameter.getParamType(), newParameter.getParamType());
		Assert.assertEquals(
			existingParameter.getDisplayName(), newParameter.getDisplayName());
		Assert.assertEquals(
			existingParameter.getDefinition(), newParameter.getDefinition());
		Assert.assertEquals(
			existingParameter.getTooltip(), newParameter.getTooltip());
		Assert.assertEquals(
			existingParameter.getSynonyms(), newParameter.getSynonyms());
		Assert.assertEquals(
			existingParameter.getTypeProperties(),
			newParameter.getTypeProperties());
		Assert.assertEquals(
			existingParameter.isStandard(), newParameter.isStandard());
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
		Parameter newParameter = addParameter();

		Parameter existingParameter = _persistence.findByPrimaryKey(
			newParameter.getPrimaryKey());

		Assert.assertEquals(existingParameter, newParameter);
	}

	@Test(expected = NoSuchParameterException.class)
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

	protected OrderByComparator<Parameter> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SX_ICECAP_Parameter", "uuid", true, "parameterId", true,
			"companyId", true, "groupId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "status", true,
			"statusByUserId", true, "statusByUserName", true, "statusDate",
			true, "lastPublishDate", true, "paramCode", true, "paramVersion",
			true, "paramType", true, "displayName", true, "definition", true,
			"tooltip", true, "synonyms", true, "typeProperties", true,
			"standard", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Parameter newParameter = addParameter();

		Parameter existingParameter = _persistence.fetchByPrimaryKey(
			newParameter.getPrimaryKey());

		Assert.assertEquals(existingParameter, newParameter);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Parameter missingParameter = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingParameter);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Parameter newParameter1 = addParameter();
		Parameter newParameter2 = addParameter();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParameter1.getPrimaryKey());
		primaryKeys.add(newParameter2.getPrimaryKey());

		Map<Serializable, Parameter> parameters =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, parameters.size());
		Assert.assertEquals(
			newParameter1, parameters.get(newParameter1.getPrimaryKey()));
		Assert.assertEquals(
			newParameter2, parameters.get(newParameter2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Parameter> parameters =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(parameters.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Parameter newParameter = addParameter();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParameter.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Parameter> parameters =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, parameters.size());
		Assert.assertEquals(
			newParameter, parameters.get(newParameter.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Parameter> parameters =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(parameters.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Parameter newParameter = addParameter();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newParameter.getPrimaryKey());

		Map<Serializable, Parameter> parameters =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, parameters.size());
		Assert.assertEquals(
			newParameter, parameters.get(newParameter.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ParameterLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Parameter>() {

				@Override
				public void performAction(Parameter parameter) {
					Assert.assertNotNull(parameter);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Parameter newParameter = addParameter();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parameter.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"parameterId", newParameter.getParameterId()));

		List<Parameter> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Parameter existingParameter = result.get(0);

		Assert.assertEquals(existingParameter, newParameter);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parameter.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"parameterId", RandomTestUtil.nextLong()));

		List<Parameter> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Parameter newParameter = addParameter();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parameter.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("parameterId"));

		Object newParameterId = newParameter.getParameterId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"parameterId", new Object[] {newParameterId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingParameterId = result.get(0);

		Assert.assertEquals(existingParameterId, newParameterId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Parameter.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("parameterId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"parameterId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Parameter newParameter = addParameter();

		_persistence.clearCache();

		Parameter existingParameter = _persistence.findByPrimaryKey(
			newParameter.getPrimaryKey());

		Assert.assertEquals(
			existingParameter.getUuid(),
			ReflectionTestUtil.invoke(
				existingParameter, "getOriginalUuid", new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingParameter.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingParameter, "getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(
			existingParameter.getParamCode(),
			ReflectionTestUtil.invoke(
				existingParameter, "getOriginalParamCode", new Class<?>[0]));
		Assert.assertEquals(
			existingParameter.getParamVersion(),
			ReflectionTestUtil.invoke(
				existingParameter, "getOriginalParamVersion", new Class<?>[0]));
	}

	protected Parameter addParameter() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Parameter parameter = _persistence.create(pk);

		parameter.setUuid(RandomTestUtil.randomString());

		parameter.setCompanyId(RandomTestUtil.nextLong());

		parameter.setGroupId(RandomTestUtil.nextLong());

		parameter.setUserId(RandomTestUtil.nextLong());

		parameter.setUserName(RandomTestUtil.randomString());

		parameter.setCreateDate(RandomTestUtil.nextDate());

		parameter.setModifiedDate(RandomTestUtil.nextDate());

		parameter.setStatus(RandomTestUtil.nextInt());

		parameter.setStatusByUserId(RandomTestUtil.nextLong());

		parameter.setStatusByUserName(RandomTestUtil.randomString());

		parameter.setStatusDate(RandomTestUtil.nextDate());

		parameter.setLastPublishDate(RandomTestUtil.nextDate());

		parameter.setParamCode(RandomTestUtil.randomString());

		parameter.setParamVersion(RandomTestUtil.randomString());

		parameter.setParamType(RandomTestUtil.randomString());

		parameter.setDisplayName(RandomTestUtil.randomString());

		parameter.setDefinition(RandomTestUtil.randomString());

		parameter.setTooltip(RandomTestUtil.randomString());

		parameter.setSynonyms(RandomTestUtil.randomString());

		parameter.setTypeProperties(RandomTestUtil.randomString());

		parameter.setStandard(RandomTestUtil.randomBoolean());

		_parameters.add(_persistence.update(parameter));

		return parameter;
	}

	private List<Parameter> _parameters = new ArrayList<Parameter>();
	private ParameterPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}