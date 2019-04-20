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
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchCodeOrgException;
import it.ethica.esf.model.ESFCodeOrg;
import it.ethica.esf.model.impl.ESFCodeOrgImpl;
import it.ethica.esf.model.impl.ESFCodeOrgModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f code org service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFCodeOrgPersistence
 * @see ESFCodeOrgUtil
 * @generated
 */
public class ESFCodeOrgPersistenceImpl extends BasePersistenceImpl<ESFCodeOrg>
	implements ESFCodeOrgPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFCodeOrgUtil} to access the e s f code org persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFCodeOrgImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
			ESFCodeOrgModelImpl.FINDER_CACHE_ENABLED, ESFCodeOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
			ESFCodeOrgModelImpl.FINDER_CACHE_ENABLED, ESFCodeOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
			ESFCodeOrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
			ESFCodeOrgModelImpl.FINDER_CACHE_ENABLED, ESFCodeOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
			ESFCodeOrgModelImpl.FINDER_CACHE_ENABLED, ESFCodeOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFCodeOrgModelImpl.UUID_COLUMN_BITMASK |
			ESFCodeOrgModelImpl.SEQUENCE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
			ESFCodeOrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f code orgs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f code orgs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCodeOrg> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f code orgs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCodeOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f code orgs
	 * @param end the upper bound of the range of e s f code orgs (not inclusive)
	 * @return the range of matching e s f code orgs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCodeOrg> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f code orgs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCodeOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f code orgs
	 * @param end the upper bound of the range of e s f code orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f code orgs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCodeOrg> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<ESFCodeOrg> list = (List<ESFCodeOrg>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFCodeOrg esfCodeOrg : list) {
				if (!Validator.equals(uuid, esfCodeOrg.getUuid())) {
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

			query.append(_SQL_SELECT_ESFCODEORG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFCodeOrgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<ESFCodeOrg>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCodeOrg>(list);
				}
				else {
					list = (List<ESFCodeOrg>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first e s f code org in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f code org
	 * @throws it.ethica.esf.NoSuchCodeOrgException if a matching e s f code org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCodeOrgException, SystemException {
		ESFCodeOrg esfCodeOrg = fetchByUuid_First(uuid, orderByComparator);

		if (esfCodeOrg != null) {
			return esfCodeOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCodeOrgException(msg.toString());
	}

	/**
	 * Returns the first e s f code org in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f code org, or <code>null</code> if a matching e s f code org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFCodeOrg> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f code org in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f code org
	 * @throws it.ethica.esf.NoSuchCodeOrgException if a matching e s f code org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCodeOrgException, SystemException {
		ESFCodeOrg esfCodeOrg = fetchByUuid_Last(uuid, orderByComparator);

		if (esfCodeOrg != null) {
			return esfCodeOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCodeOrgException(msg.toString());
	}

	/**
	 * Returns the last e s f code org in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f code org, or <code>null</code> if a matching e s f code org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFCodeOrg> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f code orgs before and after the current e s f code org in the ordered set where uuid = &#63;.
	 *
	 * @param esfCodeOrgId the primary key of the current e s f code org
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f code org
	 * @throws it.ethica.esf.NoSuchCodeOrgException if a e s f code org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg[] findByUuid_PrevAndNext(long esfCodeOrgId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCodeOrgException, SystemException {
		ESFCodeOrg esfCodeOrg = findByPrimaryKey(esfCodeOrgId);

		Session session = null;

		try {
			session = openSession();

			ESFCodeOrg[] array = new ESFCodeOrgImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfCodeOrg, uuid,
					orderByComparator, true);

			array[1] = esfCodeOrg;

			array[2] = getByUuid_PrevAndNext(session, esfCodeOrg, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFCodeOrg getByUuid_PrevAndNext(Session session,
		ESFCodeOrg esfCodeOrg, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFCODEORG_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

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
			query.append(ESFCodeOrgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfCodeOrg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFCodeOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f code orgs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFCodeOrg esfCodeOrg : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfCodeOrg);
		}
	}

	/**
	 * Returns the number of e s f code orgs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f code orgs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFCODEORG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfCodeOrg.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfCodeOrg.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfCodeOrg.uuid IS NULL OR esfCodeOrg.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_N_C = new FinderPath(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
			ESFCodeOrgModelImpl.FINDER_CACHE_ENABLED, ESFCodeOrgImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByN_C",
			new String[] { String.class.getName(), String.class.getName() },
			ESFCodeOrgModelImpl.CLASSNAME_COLUMN_BITMASK |
			ESFCodeOrgModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_N_C = new FinderPath(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
			ESFCodeOrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByN_C",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the e s f code org where className = &#63; and code = &#63; or throws a {@link it.ethica.esf.NoSuchCodeOrgException} if it could not be found.
	 *
	 * @param className the class name
	 * @param code the code
	 * @return the matching e s f code org
	 * @throws it.ethica.esf.NoSuchCodeOrgException if a matching e s f code org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg findByN_C(String className, String code)
		throws NoSuchCodeOrgException, SystemException {
		ESFCodeOrg esfCodeOrg = fetchByN_C(className, code);

		if (esfCodeOrg == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("className=");
			msg.append(className);

			msg.append(", code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCodeOrgException(msg.toString());
		}

		return esfCodeOrg;
	}

	/**
	 * Returns the e s f code org where className = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @param code the code
	 * @return the matching e s f code org, or <code>null</code> if a matching e s f code org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg fetchByN_C(String className, String code)
		throws SystemException {
		return fetchByN_C(className, code, true);
	}

	/**
	 * Returns the e s f code org where className = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f code org, or <code>null</code> if a matching e s f code org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg fetchByN_C(String className, String code,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { className, code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_N_C,
					finderArgs, this);
		}

		if (result instanceof ESFCodeOrg) {
			ESFCodeOrg esfCodeOrg = (ESFCodeOrg)result;

			if (!Validator.equals(className, esfCodeOrg.getClassName()) ||
					!Validator.equals(code, esfCodeOrg.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFCODEORG_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_N_C_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_N_C_CLASSNAME_2);
			}

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_N_C_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_C_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_N_C_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				if (bindCode) {
					qPos.add(code);
				}

				List<ESFCodeOrg> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_N_C,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFCodeOrgPersistenceImpl.fetchByN_C(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFCodeOrg esfCodeOrg = list.get(0);

					result = esfCodeOrg;

					cacheResult(esfCodeOrg);

					if ((esfCodeOrg.getClassName() == null) ||
							!esfCodeOrg.getClassName().equals(className) ||
							(esfCodeOrg.getCode() == null) ||
							!esfCodeOrg.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_N_C,
							finderArgs, esfCodeOrg);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_N_C,
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
			return (ESFCodeOrg)result;
		}
	}

	/**
	 * Removes the e s f code org where className = &#63; and code = &#63; from the database.
	 *
	 * @param className the class name
	 * @param code the code
	 * @return the e s f code org that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg removeByN_C(String className, String code)
		throws NoSuchCodeOrgException, SystemException {
		ESFCodeOrg esfCodeOrg = findByN_C(className, code);

		return remove(esfCodeOrg);
	}

	/**
	 * Returns the number of e s f code orgs where className = &#63; and code = &#63;.
	 *
	 * @param className the class name
	 * @param code the code
	 * @return the number of matching e s f code orgs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByN_C(String className, String code)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_N_C;

		Object[] finderArgs = new Object[] { className, code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFCODEORG_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_N_C_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_N_C_CLASSNAME_2);
			}

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_N_C_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_C_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_N_C_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				if (bindCode) {
					qPos.add(code);
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

	private static final String _FINDER_COLUMN_N_C_CLASSNAME_1 = "esfCodeOrg.className IS NULL AND ";
	private static final String _FINDER_COLUMN_N_C_CLASSNAME_2 = "esfCodeOrg.className = ? AND ";
	private static final String _FINDER_COLUMN_N_C_CLASSNAME_3 = "(esfCodeOrg.className IS NULL OR esfCodeOrg.className = '') AND ";
	private static final String _FINDER_COLUMN_N_C_CODE_1 = "esfCodeOrg.code IS NULL";
	private static final String _FINDER_COLUMN_N_C_CODE_2 = "esfCodeOrg.code = ?";
	private static final String _FINDER_COLUMN_N_C_CODE_3 = "(esfCodeOrg.code IS NULL OR esfCodeOrg.code = '')";

	public ESFCodeOrgPersistenceImpl() {
		setModelClass(ESFCodeOrg.class);
	}

	/**
	 * Caches the e s f code org in the entity cache if it is enabled.
	 *
	 * @param esfCodeOrg the e s f code org
	 */
	@Override
	public void cacheResult(ESFCodeOrg esfCodeOrg) {
		EntityCacheUtil.putResult(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
			ESFCodeOrgImpl.class, esfCodeOrg.getPrimaryKey(), esfCodeOrg);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_N_C,
			new Object[] { esfCodeOrg.getClassName(), esfCodeOrg.getCode() },
			esfCodeOrg);

		esfCodeOrg.resetOriginalValues();
	}

	/**
	 * Caches the e s f code orgs in the entity cache if it is enabled.
	 *
	 * @param esfCodeOrgs the e s f code orgs
	 */
	@Override
	public void cacheResult(List<ESFCodeOrg> esfCodeOrgs) {
		for (ESFCodeOrg esfCodeOrg : esfCodeOrgs) {
			if (EntityCacheUtil.getResult(
						ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
						ESFCodeOrgImpl.class, esfCodeOrg.getPrimaryKey()) == null) {
				cacheResult(esfCodeOrg);
			}
			else {
				esfCodeOrg.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f code orgs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFCodeOrgImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFCodeOrgImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f code org.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFCodeOrg esfCodeOrg) {
		EntityCacheUtil.removeResult(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
			ESFCodeOrgImpl.class, esfCodeOrg.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfCodeOrg);
	}

	@Override
	public void clearCache(List<ESFCodeOrg> esfCodeOrgs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFCodeOrg esfCodeOrg : esfCodeOrgs) {
			EntityCacheUtil.removeResult(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
				ESFCodeOrgImpl.class, esfCodeOrg.getPrimaryKey());

			clearUniqueFindersCache(esfCodeOrg);
		}
	}

	protected void cacheUniqueFindersCache(ESFCodeOrg esfCodeOrg) {
		if (esfCodeOrg.isNew()) {
			Object[] args = new Object[] {
					esfCodeOrg.getClassName(), esfCodeOrg.getCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_N_C, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_N_C, args, esfCodeOrg);
		}
		else {
			ESFCodeOrgModelImpl esfCodeOrgModelImpl = (ESFCodeOrgModelImpl)esfCodeOrg;

			if ((esfCodeOrgModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_N_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCodeOrg.getClassName(), esfCodeOrg.getCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_N_C, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_N_C, args,
					esfCodeOrg);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFCodeOrg esfCodeOrg) {
		ESFCodeOrgModelImpl esfCodeOrgModelImpl = (ESFCodeOrgModelImpl)esfCodeOrg;

		Object[] args = new Object[] {
				esfCodeOrg.getClassName(), esfCodeOrg.getCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_C, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_N_C, args);

		if ((esfCodeOrgModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_N_C.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfCodeOrgModelImpl.getOriginalClassName(),
					esfCodeOrgModelImpl.getOriginalCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_C, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_N_C, args);
		}
	}

	/**
	 * Creates a new e s f code org with the primary key. Does not add the e s f code org to the database.
	 *
	 * @param esfCodeOrgId the primary key for the new e s f code org
	 * @return the new e s f code org
	 */
	@Override
	public ESFCodeOrg create(long esfCodeOrgId) {
		ESFCodeOrg esfCodeOrg = new ESFCodeOrgImpl();

		esfCodeOrg.setNew(true);
		esfCodeOrg.setPrimaryKey(esfCodeOrgId);

		String uuid = PortalUUIDUtil.generate();

		esfCodeOrg.setUuid(uuid);

		return esfCodeOrg;
	}

	/**
	 * Removes the e s f code org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfCodeOrgId the primary key of the e s f code org
	 * @return the e s f code org that was removed
	 * @throws it.ethica.esf.NoSuchCodeOrgException if a e s f code org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg remove(long esfCodeOrgId)
		throws NoSuchCodeOrgException, SystemException {
		return remove((Serializable)esfCodeOrgId);
	}

	/**
	 * Removes the e s f code org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f code org
	 * @return the e s f code org that was removed
	 * @throws it.ethica.esf.NoSuchCodeOrgException if a e s f code org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg remove(Serializable primaryKey)
		throws NoSuchCodeOrgException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFCodeOrg esfCodeOrg = (ESFCodeOrg)session.get(ESFCodeOrgImpl.class,
					primaryKey);

			if (esfCodeOrg == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCodeOrgException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfCodeOrg);
		}
		catch (NoSuchCodeOrgException nsee) {
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
	protected ESFCodeOrg removeImpl(ESFCodeOrg esfCodeOrg)
		throws SystemException {
		esfCodeOrg = toUnwrappedModel(esfCodeOrg);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfCodeOrg)) {
				esfCodeOrg = (ESFCodeOrg)session.get(ESFCodeOrgImpl.class,
						esfCodeOrg.getPrimaryKeyObj());
			}

			if (esfCodeOrg != null) {
				session.delete(esfCodeOrg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfCodeOrg != null) {
			clearCache(esfCodeOrg);
		}

		return esfCodeOrg;
	}

	@Override
	public ESFCodeOrg updateImpl(it.ethica.esf.model.ESFCodeOrg esfCodeOrg)
		throws SystemException {
		esfCodeOrg = toUnwrappedModel(esfCodeOrg);

		boolean isNew = esfCodeOrg.isNew();

		ESFCodeOrgModelImpl esfCodeOrgModelImpl = (ESFCodeOrgModelImpl)esfCodeOrg;

		if (Validator.isNull(esfCodeOrg.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfCodeOrg.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfCodeOrg.isNew()) {
				session.save(esfCodeOrg);

				esfCodeOrg.setNew(false);
			}
			else {
				session.merge(esfCodeOrg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFCodeOrgModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfCodeOrgModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfCodeOrgModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfCodeOrgModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
			ESFCodeOrgImpl.class, esfCodeOrg.getPrimaryKey(), esfCodeOrg);

		clearUniqueFindersCache(esfCodeOrg);
		cacheUniqueFindersCache(esfCodeOrg);

		return esfCodeOrg;
	}

	protected ESFCodeOrg toUnwrappedModel(ESFCodeOrg esfCodeOrg) {
		if (esfCodeOrg instanceof ESFCodeOrgImpl) {
			return esfCodeOrg;
		}

		ESFCodeOrgImpl esfCodeOrgImpl = new ESFCodeOrgImpl();

		esfCodeOrgImpl.setNew(esfCodeOrg.isNew());
		esfCodeOrgImpl.setPrimaryKey(esfCodeOrg.getPrimaryKey());

		esfCodeOrgImpl.setUuid(esfCodeOrg.getUuid());
		esfCodeOrgImpl.setEsfCodeOrgId(esfCodeOrg.getEsfCodeOrgId());
		esfCodeOrgImpl.setClassName(esfCodeOrg.getClassName());
		esfCodeOrgImpl.setCode(esfCodeOrg.getCode());
		esfCodeOrgImpl.setSequence(esfCodeOrg.getSequence());

		return esfCodeOrgImpl;
	}

	/**
	 * Returns the e s f code org with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f code org
	 * @return the e s f code org
	 * @throws it.ethica.esf.NoSuchCodeOrgException if a e s f code org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCodeOrgException, SystemException {
		ESFCodeOrg esfCodeOrg = fetchByPrimaryKey(primaryKey);

		if (esfCodeOrg == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCodeOrgException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfCodeOrg;
	}

	/**
	 * Returns the e s f code org with the primary key or throws a {@link it.ethica.esf.NoSuchCodeOrgException} if it could not be found.
	 *
	 * @param esfCodeOrgId the primary key of the e s f code org
	 * @return the e s f code org
	 * @throws it.ethica.esf.NoSuchCodeOrgException if a e s f code org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg findByPrimaryKey(long esfCodeOrgId)
		throws NoSuchCodeOrgException, SystemException {
		return findByPrimaryKey((Serializable)esfCodeOrgId);
	}

	/**
	 * Returns the e s f code org with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f code org
	 * @return the e s f code org, or <code>null</code> if a e s f code org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFCodeOrg esfCodeOrg = (ESFCodeOrg)EntityCacheUtil.getResult(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
				ESFCodeOrgImpl.class, primaryKey);

		if (esfCodeOrg == _nullESFCodeOrg) {
			return null;
		}

		if (esfCodeOrg == null) {
			Session session = null;

			try {
				session = openSession();

				esfCodeOrg = (ESFCodeOrg)session.get(ESFCodeOrgImpl.class,
						primaryKey);

				if (esfCodeOrg != null) {
					cacheResult(esfCodeOrg);
				}
				else {
					EntityCacheUtil.putResult(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
						ESFCodeOrgImpl.class, primaryKey, _nullESFCodeOrg);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFCodeOrgModelImpl.ENTITY_CACHE_ENABLED,
					ESFCodeOrgImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfCodeOrg;
	}

	/**
	 * Returns the e s f code org with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfCodeOrgId the primary key of the e s f code org
	 * @return the e s f code org, or <code>null</code> if a e s f code org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFCodeOrg fetchByPrimaryKey(long esfCodeOrgId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfCodeOrgId);
	}

	/**
	 * Returns all the e s f code orgs.
	 *
	 * @return the e s f code orgs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCodeOrg> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f code orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCodeOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f code orgs
	 * @param end the upper bound of the range of e s f code orgs (not inclusive)
	 * @return the range of e s f code orgs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCodeOrg> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f code orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCodeOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f code orgs
	 * @param end the upper bound of the range of e s f code orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f code orgs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFCodeOrg> findAll(int start, int end,
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

		List<ESFCodeOrg> list = (List<ESFCodeOrg>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFCODEORG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFCODEORG;

				if (pagination) {
					sql = sql.concat(ESFCodeOrgModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFCodeOrg>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFCodeOrg>(list);
				}
				else {
					list = (List<ESFCodeOrg>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the e s f code orgs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFCodeOrg esfCodeOrg : findAll()) {
			remove(esfCodeOrg);
		}
	}

	/**
	 * Returns the number of e s f code orgs.
	 *
	 * @return the number of e s f code orgs
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

				Query q = session.createQuery(_SQL_COUNT_ESFCODEORG);

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
	 * Initializes the e s f code org persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFCodeOrg")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFCodeOrg>> listenersList = new ArrayList<ModelListener<ESFCodeOrg>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFCodeOrg>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFCodeOrgImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFCODEORG = "SELECT esfCodeOrg FROM ESFCodeOrg esfCodeOrg";
	private static final String _SQL_SELECT_ESFCODEORG_WHERE = "SELECT esfCodeOrg FROM ESFCodeOrg esfCodeOrg WHERE ";
	private static final String _SQL_COUNT_ESFCODEORG = "SELECT COUNT(esfCodeOrg) FROM ESFCodeOrg esfCodeOrg";
	private static final String _SQL_COUNT_ESFCODEORG_WHERE = "SELECT COUNT(esfCodeOrg) FROM ESFCodeOrg esfCodeOrg WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfCodeOrg.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFCodeOrg exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFCodeOrg exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFCodeOrgPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ESFCodeOrg _nullESFCodeOrg = new ESFCodeOrgImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFCodeOrg> toCacheModel() {
				return _nullESFCodeOrgCacheModel;
			}
		};

	private static CacheModel<ESFCodeOrg> _nullESFCodeOrgCacheModel = new CacheModel<ESFCodeOrg>() {
			@Override
			public ESFCodeOrg toEntityModel() {
				return _nullESFCodeOrg;
			}
		};
}