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

import it.ethica.esf.NoSuchSpecificException;
import it.ethica.esf.model.ESFSpecific;
import it.ethica.esf.model.impl.ESFSpecificImpl;
import it.ethica.esf.model.impl.ESFSpecificModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f specific service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFSpecificPersistence
 * @see ESFSpecificUtil
 * @generated
 */
public class ESFSpecificPersistenceImpl extends BasePersistenceImpl<ESFSpecific>
	implements ESFSpecificPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFSpecificUtil} to access the e s f specific persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFSpecificImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, ESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, ESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, ESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, ESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFSpecificModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f specifics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f specifics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f specifics
	 * @param end the upper bound of the range of e s f specifics (not inclusive)
	 * @return the range of matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f specifics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f specifics
	 * @param end the upper bound of the range of e s f specifics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findByUuid(String uuid, int start, int end,
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

		List<ESFSpecific> list = (List<ESFSpecific>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSpecific esfSpecific : list) {
				if (!Validator.equals(uuid, esfSpecific.getUuid())) {
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

			query.append(_SQL_SELECT_ESFSPECIFIC_WHERE);

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
				query.append(ESFSpecificModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFSpecific>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSpecific>(list);
				}
				else {
					list = (List<ESFSpecific>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f specific in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = fetchByUuid_First(uuid, orderByComparator);

		if (esfSpecific != null) {
			return esfSpecific;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecificException(msg.toString());
	}

	/**
	 * Returns the first e s f specific in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFSpecific> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f specific in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = fetchByUuid_Last(uuid, orderByComparator);

		if (esfSpecific != null) {
			return esfSpecific;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecificException(msg.toString());
	}

	/**
	 * Returns the last e s f specific in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFSpecific> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f specifics before and after the current e s f specific in the ordered set where uuid = &#63;.
	 *
	 * @param esfSpecificId the primary key of the current e s f specific
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific[] findByUuid_PrevAndNext(long esfSpecificId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = findByPrimaryKey(esfSpecificId);

		Session session = null;

		try {
			session = openSession();

			ESFSpecific[] array = new ESFSpecificImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfSpecific, uuid,
					orderByComparator, true);

			array[1] = esfSpecific;

			array[2] = getByUuid_PrevAndNext(session, esfSpecific, uuid,
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

	protected ESFSpecific getByUuid_PrevAndNext(Session session,
		ESFSpecific esfSpecific, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSPECIFIC_WHERE);

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
			query.append(ESFSpecificModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfSpecific);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSpecific> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f specifics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFSpecific esfSpecific : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfSpecific);
		}
	}

	/**
	 * Returns the number of e s f specifics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f specifics
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

			query.append(_SQL_COUNT_ESFSPECIFIC_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfSpecific.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfSpecific.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfSpecific.uuid IS NULL OR esfSpecific.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, ESFSpecificImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFSpecificModelImpl.UUID_COLUMN_BITMASK |
			ESFSpecificModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f specific where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchSpecificException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific findByUUID_G(String uuid, long groupId)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = fetchByUUID_G(uuid, groupId);

		if (esfSpecific == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSpecificException(msg.toString());
		}

		return esfSpecific;
	}

	/**
	 * Returns the e s f specific where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f specific where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFSpecific) {
			ESFSpecific esfSpecific = (ESFSpecific)result;

			if (!Validator.equals(uuid, esfSpecific.getUuid()) ||
					(groupId != esfSpecific.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFSPECIFIC_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<ESFSpecific> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFSpecific esfSpecific = list.get(0);

					result = esfSpecific;

					cacheResult(esfSpecific);

					if ((esfSpecific.getUuid() == null) ||
							!esfSpecific.getUuid().equals(uuid) ||
							(esfSpecific.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfSpecific);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			return (ESFSpecific)result;
		}
	}

	/**
	 * Removes the e s f specific where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f specific that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific removeByUUID_G(String uuid, long groupId)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = findByUUID_G(uuid, groupId);

		return remove(esfSpecific);
	}

	/**
	 * Returns the number of e s f specifics where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFSPECIFIC_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfSpecific.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfSpecific.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfSpecific.uuid IS NULL OR esfSpecific.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfSpecific.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, ESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, ESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFSpecificModelImpl.UUID_COLUMN_BITMASK |
			ESFSpecificModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f specifics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f specifics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f specifics
	 * @param end the upper bound of the range of e s f specifics (not inclusive)
	 * @return the range of matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f specifics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f specifics
	 * @param end the upper bound of the range of e s f specifics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<ESFSpecific> list = (List<ESFSpecific>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSpecific esfSpecific : list) {
				if (!Validator.equals(uuid, esfSpecific.getUuid()) ||
						(companyId != esfSpecific.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ESFSPECIFIC_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFSpecificModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<ESFSpecific>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSpecific>(list);
				}
				else {
					list = (List<ESFSpecific>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f specific in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfSpecific != null) {
			return esfSpecific;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecificException(msg.toString());
	}

	/**
	 * Returns the first e s f specific in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFSpecific> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f specific in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfSpecific != null) {
			return esfSpecific;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecificException(msg.toString());
	}

	/**
	 * Returns the last e s f specific in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFSpecific> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f specifics before and after the current e s f specific in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfSpecificId the primary key of the current e s f specific
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific[] findByUuid_C_PrevAndNext(long esfSpecificId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = findByPrimaryKey(esfSpecificId);

		Session session = null;

		try {
			session = openSession();

			ESFSpecific[] array = new ESFSpecificImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfSpecific, uuid,
					companyId, orderByComparator, true);

			array[1] = esfSpecific;

			array[2] = getByUuid_C_PrevAndNext(session, esfSpecific, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFSpecific getByUuid_C_PrevAndNext(Session session,
		ESFSpecific esfSpecific, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSPECIFIC_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(ESFSpecificModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfSpecific);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSpecific> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f specifics where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFSpecific esfSpecific : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfSpecific);
		}
	}

	/**
	 * Returns the number of e s f specifics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFSPECIFIC_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfSpecific.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfSpecific.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfSpecific.uuid IS NULL OR esfSpecific.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfSpecific.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, ESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, ESFSpecificImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] { String.class.getName() },
			ESFSpecificModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f specifics where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findByCode(String code) throws SystemException {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f specifics where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f specifics
	 * @param end the upper bound of the range of e s f specifics (not inclusive)
	 * @return the range of matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findByCode(String code, int start, int end)
		throws SystemException {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f specifics where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f specifics
	 * @param end the upper bound of the range of e s f specifics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findByCode(String code, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE;
			finderArgs = new Object[] { code };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE;
			finderArgs = new Object[] { code, start, end, orderByComparator };
		}

		List<ESFSpecific> list = (List<ESFSpecific>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSpecific esfSpecific : list) {
				if (!Validator.equals(code, esfSpecific.getCode())) {
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

			query.append(_SQL_SELECT_ESFSPECIFIC_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFSpecificModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				if (!pagination) {
					list = (List<ESFSpecific>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSpecific>(list);
				}
				else {
					list = (List<ESFSpecific>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f specific in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific findByCode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = fetchByCode_First(code, orderByComparator);

		if (esfSpecific != null) {
			return esfSpecific;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecificException(msg.toString());
	}

	/**
	 * Returns the first e s f specific in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific fetchByCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFSpecific> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f specific in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific findByCode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = fetchByCode_Last(code, orderByComparator);

		if (esfSpecific != null) {
			return esfSpecific;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecificException(msg.toString());
	}

	/**
	 * Returns the last e s f specific in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific fetchByCode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<ESFSpecific> list = findByCode(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f specifics before and after the current e s f specific in the ordered set where code = &#63;.
	 *
	 * @param esfSpecificId the primary key of the current e s f specific
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific[] findByCode_PrevAndNext(long esfSpecificId,
		String code, OrderByComparator orderByComparator)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = findByPrimaryKey(esfSpecificId);

		Session session = null;

		try {
			session = openSession();

			ESFSpecific[] array = new ESFSpecificImpl[3];

			array[0] = getByCode_PrevAndNext(session, esfSpecific, code,
					orderByComparator, true);

			array[1] = esfSpecific;

			array[2] = getByCode_PrevAndNext(session, esfSpecific, code,
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

	protected ESFSpecific getByCode_PrevAndNext(Session session,
		ESFSpecific esfSpecific, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSPECIFIC_WHERE);

		boolean bindCode = false;

		if (code == null) {
			query.append(_FINDER_COLUMN_CODE_CODE_1);
		}
		else if (code.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CODE_CODE_3);
		}
		else {
			bindCode = true;

			query.append(_FINDER_COLUMN_CODE_CODE_2);
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
			query.append(ESFSpecificModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCode) {
			qPos.add(code);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfSpecific);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSpecific> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f specifics where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCode(String code) throws SystemException {
		for (ESFSpecific esfSpecific : findByCode(code, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfSpecific);
		}
	}

	/**
	 * Returns the number of e s f specifics where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSPECIFIC_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfSpecific.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfSpecific.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfSpecific.code IS NULL OR esfSpecific.code = '')";

	public ESFSpecificPersistenceImpl() {
		setModelClass(ESFSpecific.class);
	}

	/**
	 * Caches the e s f specific in the entity cache if it is enabled.
	 *
	 * @param esfSpecific the e s f specific
	 */
	@Override
	public void cacheResult(ESFSpecific esfSpecific) {
		EntityCacheUtil.putResult(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificImpl.class, esfSpecific.getPrimaryKey(), esfSpecific);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfSpecific.getUuid(), esfSpecific.getGroupId() },
			esfSpecific);

		esfSpecific.resetOriginalValues();
	}

	/**
	 * Caches the e s f specifics in the entity cache if it is enabled.
	 *
	 * @param esfSpecifics the e s f specifics
	 */
	@Override
	public void cacheResult(List<ESFSpecific> esfSpecifics) {
		for (ESFSpecific esfSpecific : esfSpecifics) {
			if (EntityCacheUtil.getResult(
						ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
						ESFSpecificImpl.class, esfSpecific.getPrimaryKey()) == null) {
				cacheResult(esfSpecific);
			}
			else {
				esfSpecific.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f specifics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFSpecificImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFSpecificImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f specific.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFSpecific esfSpecific) {
		EntityCacheUtil.removeResult(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificImpl.class, esfSpecific.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfSpecific);
	}

	@Override
	public void clearCache(List<ESFSpecific> esfSpecifics) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFSpecific esfSpecific : esfSpecifics) {
			EntityCacheUtil.removeResult(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
				ESFSpecificImpl.class, esfSpecific.getPrimaryKey());

			clearUniqueFindersCache(esfSpecific);
		}
	}

	protected void cacheUniqueFindersCache(ESFSpecific esfSpecific) {
		if (esfSpecific.isNew()) {
			Object[] args = new Object[] {
					esfSpecific.getUuid(), esfSpecific.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfSpecific);
		}
		else {
			ESFSpecificModelImpl esfSpecificModelImpl = (ESFSpecificModelImpl)esfSpecific;

			if ((esfSpecificModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSpecific.getUuid(), esfSpecific.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfSpecific);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFSpecific esfSpecific) {
		ESFSpecificModelImpl esfSpecificModelImpl = (ESFSpecificModelImpl)esfSpecific;

		Object[] args = new Object[] {
				esfSpecific.getUuid(), esfSpecific.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfSpecificModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfSpecificModelImpl.getOriginalUuid(),
					esfSpecificModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f specific with the primary key. Does not add the e s f specific to the database.
	 *
	 * @param esfSpecificId the primary key for the new e s f specific
	 * @return the new e s f specific
	 */
	@Override
	public ESFSpecific create(long esfSpecificId) {
		ESFSpecific esfSpecific = new ESFSpecificImpl();

		esfSpecific.setNew(true);
		esfSpecific.setPrimaryKey(esfSpecificId);

		String uuid = PortalUUIDUtil.generate();

		esfSpecific.setUuid(uuid);

		return esfSpecific;
	}

	/**
	 * Removes the e s f specific with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfSpecificId the primary key of the e s f specific
	 * @return the e s f specific that was removed
	 * @throws it.ethica.esf.NoSuchSpecificException if a e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific remove(long esfSpecificId)
		throws NoSuchSpecificException, SystemException {
		return remove((Serializable)esfSpecificId);
	}

	/**
	 * Removes the e s f specific with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f specific
	 * @return the e s f specific that was removed
	 * @throws it.ethica.esf.NoSuchSpecificException if a e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific remove(Serializable primaryKey)
		throws NoSuchSpecificException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFSpecific esfSpecific = (ESFSpecific)session.get(ESFSpecificImpl.class,
					primaryKey);

			if (esfSpecific == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpecificException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfSpecific);
		}
		catch (NoSuchSpecificException nsee) {
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
	protected ESFSpecific removeImpl(ESFSpecific esfSpecific)
		throws SystemException {
		esfSpecific = toUnwrappedModel(esfSpecific);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfSpecific)) {
				esfSpecific = (ESFSpecific)session.get(ESFSpecificImpl.class,
						esfSpecific.getPrimaryKeyObj());
			}

			if (esfSpecific != null) {
				session.delete(esfSpecific);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfSpecific != null) {
			clearCache(esfSpecific);
		}

		return esfSpecific;
	}

	@Override
	public ESFSpecific updateImpl(it.ethica.esf.model.ESFSpecific esfSpecific)
		throws SystemException {
		esfSpecific = toUnwrappedModel(esfSpecific);

		boolean isNew = esfSpecific.isNew();

		ESFSpecificModelImpl esfSpecificModelImpl = (ESFSpecificModelImpl)esfSpecific;

		if (Validator.isNull(esfSpecific.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfSpecific.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfSpecific.isNew()) {
				session.save(esfSpecific);

				esfSpecific.setNew(false);
			}
			else {
				session.merge(esfSpecific);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFSpecificModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfSpecificModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSpecificModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfSpecificModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfSpecificModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSpecificModelImpl.getOriginalUuid(),
						esfSpecificModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfSpecificModelImpl.getUuid(),
						esfSpecificModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfSpecificModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSpecificModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { esfSpecificModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
			ESFSpecificImpl.class, esfSpecific.getPrimaryKey(), esfSpecific);

		clearUniqueFindersCache(esfSpecific);
		cacheUniqueFindersCache(esfSpecific);

		return esfSpecific;
	}

	protected ESFSpecific toUnwrappedModel(ESFSpecific esfSpecific) {
		if (esfSpecific instanceof ESFSpecificImpl) {
			return esfSpecific;
		}

		ESFSpecificImpl esfSpecificImpl = new ESFSpecificImpl();

		esfSpecificImpl.setNew(esfSpecific.isNew());
		esfSpecificImpl.setPrimaryKey(esfSpecific.getPrimaryKey());

		esfSpecificImpl.setUuid(esfSpecific.getUuid());
		esfSpecificImpl.setEsfSpecificId(esfSpecific.getEsfSpecificId());
		esfSpecificImpl.setGroupId(esfSpecific.getGroupId());
		esfSpecificImpl.setCompanyId(esfSpecific.getCompanyId());
		esfSpecificImpl.setUserId(esfSpecific.getUserId());
		esfSpecificImpl.setUserName(esfSpecific.getUserName());
		esfSpecificImpl.setCreateDate(esfSpecific.getCreateDate());
		esfSpecificImpl.setModifiedDate(esfSpecific.getModifiedDate());
		esfSpecificImpl.setCode(esfSpecific.getCode());
		esfSpecificImpl.setDescription(esfSpecific.getDescription());

		return esfSpecificImpl;
	}

	/**
	 * Returns the e s f specific with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f specific
	 * @return the e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpecificException, SystemException {
		ESFSpecific esfSpecific = fetchByPrimaryKey(primaryKey);

		if (esfSpecific == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpecificException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfSpecific;
	}

	/**
	 * Returns the e s f specific with the primary key or throws a {@link it.ethica.esf.NoSuchSpecificException} if it could not be found.
	 *
	 * @param esfSpecificId the primary key of the e s f specific
	 * @return the e s f specific
	 * @throws it.ethica.esf.NoSuchSpecificException if a e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific findByPrimaryKey(long esfSpecificId)
		throws NoSuchSpecificException, SystemException {
		return findByPrimaryKey((Serializable)esfSpecificId);
	}

	/**
	 * Returns the e s f specific with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f specific
	 * @return the e s f specific, or <code>null</code> if a e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFSpecific esfSpecific = (ESFSpecific)EntityCacheUtil.getResult(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
				ESFSpecificImpl.class, primaryKey);

		if (esfSpecific == _nullESFSpecific) {
			return null;
		}

		if (esfSpecific == null) {
			Session session = null;

			try {
				session = openSession();

				esfSpecific = (ESFSpecific)session.get(ESFSpecificImpl.class,
						primaryKey);

				if (esfSpecific != null) {
					cacheResult(esfSpecific);
				}
				else {
					EntityCacheUtil.putResult(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
						ESFSpecificImpl.class, primaryKey, _nullESFSpecific);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFSpecificModelImpl.ENTITY_CACHE_ENABLED,
					ESFSpecificImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfSpecific;
	}

	/**
	 * Returns the e s f specific with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfSpecificId the primary key of the e s f specific
	 * @return the e s f specific, or <code>null</code> if a e s f specific with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSpecific fetchByPrimaryKey(long esfSpecificId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfSpecificId);
	}

	/**
	 * Returns all the e s f specifics.
	 *
	 * @return the e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f specifics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f specifics
	 * @param end the upper bound of the range of e s f specifics (not inclusive)
	 * @return the range of e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f specifics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f specifics
	 * @param end the upper bound of the range of e s f specifics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f specifics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSpecific> findAll(int start, int end,
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

		List<ESFSpecific> list = (List<ESFSpecific>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSPECIFIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSPECIFIC;

				if (pagination) {
					sql = sql.concat(ESFSpecificModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFSpecific>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSpecific>(list);
				}
				else {
					list = (List<ESFSpecific>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f specifics from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFSpecific esfSpecific : findAll()) {
			remove(esfSpecific);
		}
	}

	/**
	 * Returns the number of e s f specifics.
	 *
	 * @return the number of e s f specifics
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

				Query q = session.createQuery(_SQL_COUNT_ESFSPECIFIC);

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
	 * Initializes the e s f specific persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFSpecific")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFSpecific>> listenersList = new ArrayList<ModelListener<ESFSpecific>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFSpecific>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFSpecificImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSPECIFIC = "SELECT esfSpecific FROM ESFSpecific esfSpecific";
	private static final String _SQL_SELECT_ESFSPECIFIC_WHERE = "SELECT esfSpecific FROM ESFSpecific esfSpecific WHERE ";
	private static final String _SQL_COUNT_ESFSPECIFIC = "SELECT COUNT(esfSpecific) FROM ESFSpecific esfSpecific";
	private static final String _SQL_COUNT_ESFSPECIFIC_WHERE = "SELECT COUNT(esfSpecific) FROM ESFSpecific esfSpecific WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfSpecific.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFSpecific exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFSpecific exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFSpecificPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ESFSpecific _nullESFSpecific = new ESFSpecificImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFSpecific> toCacheModel() {
				return _nullESFSpecificCacheModel;
			}
		};

	private static CacheModel<ESFSpecific> _nullESFSpecificCacheModel = new CacheModel<ESFSpecific>() {
			@Override
			public ESFSpecific toEntityModel() {
				return _nullESFSpecific;
			}
		};
}