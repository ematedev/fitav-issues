/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.ethica.esf.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchConfigurationException;
import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.impl.ESFConfigurationImpl;
import it.ethica.esf.model.impl.ESFConfigurationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFConfigurationPersistence
 * @see ESFConfigurationUtil
 * @generated
 */
public class ESFConfigurationPersistenceImpl extends BasePersistenceImpl<ESFConfiguration>
	implements ESFConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFConfigurationUtil} to access the e s f configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ESFConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ESFConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ESFConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ESFConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ESFConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ESFConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ESFConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ESFConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ESFConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ESFConfigurationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ESFConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f configurations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFConfiguration> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f configurations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f configurations
	 * @param end the upper bound of the range of e s f configurations (not inclusive)
	 * @return the range of matching e s f configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFConfiguration> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f configurations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f configurations
	 * @param end the upper bound of the range of e s f configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFConfiguration> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ESFConfiguration> list = (List<ESFConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFConfiguration esfConfiguration : list) {
				if ((groupId != esfConfiguration.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ESFCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFConfiguration>(list);
				}
				else {
					list = (List<ESFConfiguration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first e s f configuration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f configuration
	 * @throws it.ethica.esf.NoSuchConfigurationException if a matching e s f configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		ESFConfiguration esfConfiguration = fetchByGroupId_First(groupId,
				orderByComparator);

		if (esfConfiguration != null) {
			return esfConfiguration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationException(msg.toString());
	}

	/**
	 * Returns the first e s f configuration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFConfiguration> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f configuration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f configuration
	 * @throws it.ethica.esf.NoSuchConfigurationException if a matching e s f configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		ESFConfiguration esfConfiguration = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (esfConfiguration != null) {
			return esfConfiguration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationException(msg.toString());
	}

	/**
	 * Returns the last e s f configuration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ESFConfiguration> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f configurations before and after the current e s f configuration in the ordered set where groupId = &#63;.
	 *
	 * @param esfConfigurationId the primary key of the current e s f configuration
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f configuration
	 * @throws it.ethica.esf.NoSuchConfigurationException if a e s f configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration[] findByGroupId_PrevAndNext(
		long esfConfigurationId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationException, SystemException {
		ESFConfiguration esfConfiguration = findByPrimaryKey(esfConfigurationId);

		Session session = null;

		try {
			session = openSession();

			ESFConfiguration[] array = new ESFConfigurationImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, esfConfiguration,
					groupId, orderByComparator, true);

			array[1] = esfConfiguration;

			array[2] = getByGroupId_PrevAndNext(session, esfConfiguration,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFConfiguration getByGroupId_PrevAndNext(Session session,
		ESFConfiguration esfConfiguration, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCONFIGURATION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ESFConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfConfiguration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFConfiguration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f configurations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESFConfiguration esfConfiguration : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfConfiguration);
		}
	}

	/**
	 * Returns the number of e s f configurations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esfConfiguration.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ESFKEY = new FinderPath(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ESFConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ESFConfigurationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByESFKey", new String[] { String.class.getName() },
			ESFConfigurationModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFKEY = new FinderPath(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ESFConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFKey",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f configuration where key = &#63; or throws a {@link it.ethica.esf.NoSuchConfigurationException} if it could not be found.
	 *
	 * @param key the key
	 * @return the matching e s f configuration
	 * @throws it.ethica.esf.NoSuchConfigurationException if a matching e s f configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration findByESFKey(String key)
		throws NoSuchConfigurationException, SystemException {
		ESFConfiguration esfConfiguration = fetchByESFKey(key);

		if (esfConfiguration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("key=");
			msg.append(key);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchConfigurationException(msg.toString());
		}

		return esfConfiguration;
	}

	/**
	 * Returns the e s f configuration where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration fetchByESFKey(String key) throws SystemException {
		return fetchByESFKey(key, true);
	}

	/**
	 * Returns the e s f configuration where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration fetchByESFKey(String key, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { key };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ESFKEY,
					finderArgs, this);
		}

		if (result instanceof ESFConfiguration) {
			ESFConfiguration esfConfiguration = (ESFConfiguration)result;

			if (!Validator.equals(key, esfConfiguration.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFCONFIGURATION_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_ESFKEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFKEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_ESFKEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				List<ESFConfiguration> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFKEY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFConfigurationPersistenceImpl.fetchByESFKey(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFConfiguration esfConfiguration = list.get(0);

					result = esfConfiguration;

					cacheResult(esfConfiguration);

					if ((esfConfiguration.getKey() == null) ||
							!esfConfiguration.getKey().equals(key)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFKEY,
							finderArgs, esfConfiguration);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFKEY,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ESFConfiguration)result;
		}
	}

	/**
	 * Removes the e s f configuration where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the e s f configuration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration removeByESFKey(String key)
		throws NoSuchConfigurationException, SystemException {
		ESFConfiguration esfConfiguration = findByESFKey(key);

		return remove(esfConfiguration);
	}

	/**
	 * Returns the number of e s f configurations where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching e s f configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFKey(String key) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFKEY;

		Object[] finderArgs = new Object[] { key };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCONFIGURATION_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_ESFKEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ESFKEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_ESFKEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ESFKEY_KEY_1 = "esfConfiguration.key IS NULL";
	private static final String _FINDER_COLUMN_ESFKEY_KEY_2 = "esfConfiguration.key = ?";
	private static final String _FINDER_COLUMN_ESFKEY_KEY_3 = "(esfConfiguration.key IS NULL OR esfConfiguration.key = '')";

	public ESFConfigurationPersistenceImpl() {
		setModelClass(ESFConfiguration.class);
	}

	/**
	 * Caches the e s f configuration in the entity cache if it is enabled.
	 *
	 * @param esfConfiguration the e s f configuration
	 */
	@Override
	public void cacheResult(ESFConfiguration esfConfiguration) {
		EntityCacheUtil.putResult(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ESFConfigurationImpl.class, esfConfiguration.getPrimaryKey(),
			esfConfiguration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFKEY,
			new Object[] { esfConfiguration.getKey() }, esfConfiguration);

		esfConfiguration.resetOriginalValues();
	}

	/**
	 * Caches the e s f configurations in the entity cache if it is enabled.
	 *
	 * @param esfConfigurations the e s f configurations
	 */
	@Override
	public void cacheResult(List<ESFConfiguration> esfConfigurations) {
		for (ESFConfiguration esfConfiguration : esfConfigurations) {
			if (EntityCacheUtil.getResult(
						ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						ESFConfigurationImpl.class,
						esfConfiguration.getPrimaryKey()) == null) {
				cacheResult(esfConfiguration);
			}
			else {
				esfConfiguration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFConfiguration esfConfiguration) {
		EntityCacheUtil.removeResult(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ESFConfigurationImpl.class, esfConfiguration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfConfiguration);
	}

	@Override
	public void clearCache(List<ESFConfiguration> esfConfigurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFConfiguration esfConfiguration : esfConfigurations) {
			EntityCacheUtil.removeResult(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				ESFConfigurationImpl.class, esfConfiguration.getPrimaryKey());

			clearUniqueFindersCache(esfConfiguration);
		}
	}

	protected void cacheUniqueFindersCache(ESFConfiguration esfConfiguration) {
		if (esfConfiguration.isNew()) {
			Object[] args = new Object[] { esfConfiguration.getKey() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFKEY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFKEY, args,
				esfConfiguration);
		}
		else {
			ESFConfigurationModelImpl esfConfigurationModelImpl = (ESFConfigurationModelImpl)esfConfiguration;

			if ((esfConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ESFKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfConfiguration.getKey() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFKEY, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFKEY, args,
					esfConfiguration);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFConfiguration esfConfiguration) {
		ESFConfigurationModelImpl esfConfigurationModelImpl = (ESFConfigurationModelImpl)esfConfiguration;

		Object[] args = new Object[] { esfConfiguration.getKey() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFKEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFKEY, args);

		if ((esfConfigurationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ESFKEY.getColumnBitmask()) != 0) {
			args = new Object[] { esfConfigurationModelImpl.getOriginalKey() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFKEY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFKEY, args);
		}
	}

	/**
	 * Creates a new e s f configuration with the primary key. Does not add the e s f configuration to the database.
	 *
	 * @param esfConfigurationId the primary key for the new e s f configuration
	 * @return the new e s f configuration
	 */
	@Override
	public ESFConfiguration create(long esfConfigurationId) {
		ESFConfiguration esfConfiguration = new ESFConfigurationImpl();

		esfConfiguration.setNew(true);
		esfConfiguration.setPrimaryKey(esfConfigurationId);

		return esfConfiguration;
	}

	/**
	 * Removes the e s f configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfConfigurationId the primary key of the e s f configuration
	 * @return the e s f configuration that was removed
	 * @throws it.ethica.esf.NoSuchConfigurationException if a e s f configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration remove(long esfConfigurationId)
		throws NoSuchConfigurationException, SystemException {
		return remove((Serializable)esfConfigurationId);
	}

	/**
	 * Removes the e s f configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f configuration
	 * @return the e s f configuration that was removed
	 * @throws it.ethica.esf.NoSuchConfigurationException if a e s f configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration remove(Serializable primaryKey)
		throws NoSuchConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFConfiguration esfConfiguration = (ESFConfiguration)session.get(ESFConfigurationImpl.class,
					primaryKey);

			if (esfConfiguration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfConfiguration);
		}
		catch (NoSuchConfigurationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ESFConfiguration removeImpl(ESFConfiguration esfConfiguration)
		throws SystemException {
		esfConfiguration = toUnwrappedModel(esfConfiguration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfConfiguration)) {
				esfConfiguration = (ESFConfiguration)session.get(ESFConfigurationImpl.class,
						esfConfiguration.getPrimaryKeyObj());
			}

			if (esfConfiguration != null) {
				session.delete(esfConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfConfiguration != null) {
			clearCache(esfConfiguration);
		}

		return esfConfiguration;
	}

	@Override
	public ESFConfiguration updateImpl(
		it.ethica.esf.model.ESFConfiguration esfConfiguration)
		throws SystemException {
		esfConfiguration = toUnwrappedModel(esfConfiguration);

		boolean isNew = esfConfiguration.isNew();

		ESFConfigurationModelImpl esfConfigurationModelImpl = (ESFConfigurationModelImpl)esfConfiguration;

		Session session = null;

		try {
			session = openSession();

			if (esfConfiguration.isNew()) {
				session.save(esfConfiguration);

				esfConfiguration.setNew(false);
			}
			else {
				session.merge(esfConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFConfigurationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfConfigurationModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { esfConfigurationModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ESFConfigurationImpl.class, esfConfiguration.getPrimaryKey(),
			esfConfiguration);

		clearUniqueFindersCache(esfConfiguration);
		cacheUniqueFindersCache(esfConfiguration);

		return esfConfiguration;
	}

	protected ESFConfiguration toUnwrappedModel(
		ESFConfiguration esfConfiguration) {
		if (esfConfiguration instanceof ESFConfigurationImpl) {
			return esfConfiguration;
		}

		ESFConfigurationImpl esfConfigurationImpl = new ESFConfigurationImpl();

		esfConfigurationImpl.setNew(esfConfiguration.isNew());
		esfConfigurationImpl.setPrimaryKey(esfConfiguration.getPrimaryKey());

		esfConfigurationImpl.setEsfConfigurationId(esfConfiguration.getEsfConfigurationId());
		esfConfigurationImpl.setGroupId(esfConfiguration.getGroupId());
		esfConfigurationImpl.setCompanyId(esfConfiguration.getCompanyId());
		esfConfigurationImpl.setUserId(esfConfiguration.getUserId());
		esfConfigurationImpl.setUserName(esfConfiguration.getUserName());
		esfConfigurationImpl.setCreateDate(esfConfiguration.getCreateDate());
		esfConfigurationImpl.setModifiedDate(esfConfiguration.getModifiedDate());
		esfConfigurationImpl.setKey(esfConfiguration.getKey());
		esfConfigurationImpl.setValue(esfConfiguration.getValue());

		return esfConfigurationImpl;
	}

	/**
	 * Returns the e s f configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f configuration
	 * @return the e s f configuration
	 * @throws it.ethica.esf.NoSuchConfigurationException if a e s f configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConfigurationException, SystemException {
		ESFConfiguration esfConfiguration = fetchByPrimaryKey(primaryKey);

		if (esfConfiguration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfConfiguration;
	}

	/**
	 * Returns the e s f configuration with the primary key or throws a {@link it.ethica.esf.NoSuchConfigurationException} if it could not be found.
	 *
	 * @param esfConfigurationId the primary key of the e s f configuration
	 * @return the e s f configuration
	 * @throws it.ethica.esf.NoSuchConfigurationException if a e s f configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration findByPrimaryKey(long esfConfigurationId)
		throws NoSuchConfigurationException, SystemException {
		return findByPrimaryKey((Serializable)esfConfigurationId);
	}

	/**
	 * Returns the e s f configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f configuration
	 * @return the e s f configuration, or <code>null</code> if a e s f configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFConfiguration esfConfiguration = (ESFConfiguration)EntityCacheUtil.getResult(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				ESFConfigurationImpl.class, primaryKey);

		if (esfConfiguration == _nullESFConfiguration) {
			return null;
		}

		if (esfConfiguration == null) {
			Session session = null;

			try {
				session = openSession();

				esfConfiguration = (ESFConfiguration)session.get(ESFConfigurationImpl.class,
						primaryKey);

				if (esfConfiguration != null) {
					cacheResult(esfConfiguration);
				}
				else {
					EntityCacheUtil.putResult(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						ESFConfigurationImpl.class, primaryKey,
						_nullESFConfiguration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFConfigurationModelImpl.ENTITY_CACHE_ENABLED,
					ESFConfigurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfConfiguration;
	}

	/**
	 * Returns the e s f configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfConfigurationId the primary key of the e s f configuration
	 * @return the e s f configuration, or <code>null</code> if a e s f configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFConfiguration fetchByPrimaryKey(long esfConfigurationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfConfigurationId);
	}

	/**
	 * Returns all the e s f configurations.
	 *
	 * @return the e s f configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFConfiguration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f configurations
	 * @param end the upper bound of the range of e s f configurations (not inclusive)
	 * @return the range of e s f configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFConfiguration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f configurations
	 * @param end the upper bound of the range of e s f configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFConfiguration> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ESFConfiguration> list = (List<ESFConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFCONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFCONFIGURATION;

				if (pagination) {
					sql = sql.concat(ESFConfigurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFConfiguration>(list);
				}
				else {
					list = (List<ESFConfiguration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the e s f configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFConfiguration esfConfiguration : findAll()) {
			remove(esfConfiguration);
		}
	}

	/**
	 * Returns the number of e s f configurations.
	 *
	 * @return the number of e s f configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ESFCONFIGURATION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the e s f configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFConfiguration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFConfiguration>> listenersList = new ArrayList<ModelListener<ESFConfiguration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFConfiguration>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ESFConfigurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFCONFIGURATION = "SELECT esfConfiguration FROM ESFConfiguration esfConfiguration";
	private static final String _SQL_SELECT_ESFCONFIGURATION_WHERE = "SELECT esfConfiguration FROM ESFConfiguration esfConfiguration WHERE ";
	private static final String _SQL_COUNT_ESFCONFIGURATION = "SELECT COUNT(esfConfiguration) FROM ESFConfiguration esfConfiguration";
	private static final String _SQL_COUNT_ESFCONFIGURATION_WHERE = "SELECT COUNT(esfConfiguration) FROM ESFConfiguration esfConfiguration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfConfiguration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFConfiguration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFConfiguration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFConfigurationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"key"
			});
	private static ESFConfiguration _nullESFConfiguration = new ESFConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFConfiguration> toCacheModel() {
				return _nullESFConfigurationCacheModel;
			}
		};

	private static CacheModel<ESFConfiguration> _nullESFConfigurationCacheModel = new CacheModel<ESFConfiguration>() {
			@Override
			public ESFConfiguration toEntityModel() {
				return _nullESFConfiguration;
			}
		};
}