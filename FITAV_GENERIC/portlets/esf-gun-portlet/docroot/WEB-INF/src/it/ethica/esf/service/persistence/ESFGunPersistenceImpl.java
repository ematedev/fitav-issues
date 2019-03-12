/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import it.ethica.esf.NoSuchGunException;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.impl.ESFGunImpl;
import it.ethica.esf.model.impl.ESFGunModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f gun service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFGunPersistence
 * @see ESFGunUtil
 * @generated
 */
public class ESFGunPersistenceImpl extends BasePersistenceImpl<ESFGun>
	implements ESFGunPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFGunUtil} to access the e s f gun persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFGunImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFGunModelImpl.UUID_COLUMN_BITMASK |
			ESFGunModelImpl.ESFGUNKINDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f guns where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f guns where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @return the range of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f guns where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByUuid(String uuid, int start, int end,
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

		List<ESFGun> list = (List<ESFGun>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFGun esfGun : list) {
				if (!Validator.equals(uuid, esfGun.getUuid())) {
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

			query.append(_SQL_SELECT_ESFGUN_WHERE);

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
				query.append(ESFGunModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGun>(list);
				}
				else {
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first e s f gun in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByUuid_First(uuid, orderByComparator);

		if (esfGun != null) {
			return esfGun;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunException(msg.toString());
	}

	/**
	 * Returns the first e s f gun in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFGun> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f gun in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByUuid_Last(uuid, orderByComparator);

		if (esfGun != null) {
			return esfGun;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunException(msg.toString());
	}

	/**
	 * Returns the last e s f gun in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFGun> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f guns before and after the current e s f gun in the ordered set where uuid = &#63;.
	 *
	 * @param esfGunId the primary key of the current e s f gun
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun[] findByUuid_PrevAndNext(long esfGunId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = findByPrimaryKey(esfGunId);

		Session session = null;

		try {
			session = openSession();

			ESFGun[] array = new ESFGunImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfGun, uuid,
					orderByComparator, true);

			array[1] = esfGun;

			array[2] = getByUuid_PrevAndNext(session, esfGun, uuid,
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

	protected ESFGun getByUuid_PrevAndNext(Session session, ESFGun esfGun,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUN_WHERE);

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
			query.append(ESFGunModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfGun);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFGun> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f guns where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFGun esfGun : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfGun);
		}
	}

	/**
	 * Returns the number of e s f guns where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f guns
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

			query.append(_SQL_COUNT_ESFGUN_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfGun.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfGun.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfGun.uuid IS NULL OR esfGun.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFGunModelImpl.UUID_COLUMN_BITMASK |
			ESFGunModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f gun where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchGunException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByUUID_G(String uuid, long groupId)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByUUID_G(uuid, groupId);

		if (esfGun == null) {
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

			throw new NoSuchGunException(msg.toString());
		}

		return esfGun;
	}

	/**
	 * Returns the e s f gun where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f gun where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFGun) {
			ESFGun esfGun = (ESFGun)result;

			if (!Validator.equals(uuid, esfGun.getUuid()) ||
					(groupId != esfGun.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFGUN_WHERE);

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

				List<ESFGun> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFGun esfGun = list.get(0);

					result = esfGun;

					cacheResult(esfGun);

					if ((esfGun.getUuid() == null) ||
							!esfGun.getUuid().equals(uuid) ||
							(esfGun.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfGun);
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
			return (ESFGun)result;
		}
	}

	/**
	 * Removes the e s f gun where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f gun that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun removeByUUID_G(String uuid, long groupId)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = findByUUID_G(uuid, groupId);

		return remove(esfGun);
	}

	/**
	 * Returns the number of e s f guns where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f guns
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

			query.append(_SQL_COUNT_ESFGUN_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfGun.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfGun.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfGun.uuid IS NULL OR esfGun.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfGun.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFGunModelImpl.UUID_COLUMN_BITMASK |
			ESFGunModelImpl.COMPANYID_COLUMN_BITMASK |
			ESFGunModelImpl.ESFGUNKINDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f guns where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f guns where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @return the range of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f guns where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFGun> list = (List<ESFGun>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFGun esfGun : list) {
				if (!Validator.equals(uuid, esfGun.getUuid()) ||
						(companyId != esfGun.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFGUN_WHERE);

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
				query.append(ESFGunModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGun>(list);
				}
				else {
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first e s f gun in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (esfGun != null) {
			return esfGun;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunException(msg.toString());
	}

	/**
	 * Returns the first e s f gun in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFGun> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f gun in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (esfGun != null) {
			return esfGun;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunException(msg.toString());
	}

	/**
	 * Returns the last e s f gun in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFGun> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f guns before and after the current e s f gun in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfGunId the primary key of the current e s f gun
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun[] findByUuid_C_PrevAndNext(long esfGunId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = findByPrimaryKey(esfGunId);

		Session session = null;

		try {
			session = openSession();

			ESFGun[] array = new ESFGunImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfGun, uuid,
					companyId, orderByComparator, true);

			array[1] = esfGun;

			array[2] = getByUuid_C_PrevAndNext(session, esfGun, uuid,
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

	protected ESFGun getByUuid_C_PrevAndNext(Session session, ESFGun esfGun,
		String uuid, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUN_WHERE);

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
			query.append(ESFGunModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfGun);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFGun> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f guns where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFGun esfGun : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfGun);
		}
	}

	/**
	 * Returns the number of e s f guns where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f guns
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

			query.append(_SQL_COUNT_ESFGUN_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfGun.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfGun.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfGun.uuid IS NULL OR esfGun.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfGun.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEsfUserId",
			new String[] { Long.class.getName() },
			ESFGunModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFGunModelImpl.ESFGUNKINDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSERID = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEsfUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f guns where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByEsfUserId(long esfUserId)
		throws SystemException {
		return findByEsfUserId(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f guns where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @return the range of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByEsfUserId(long esfUserId, int start, int end)
		throws SystemException {
		return findByEsfUserId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f guns where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByEsfUserId(long esfUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFGun> list = (List<ESFGun>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFGun esfGun : list) {
				if ((esfUserId != esfGun.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFGUN_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFGunModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGun>(list);
				}
				else {
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first e s f gun in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByEsfUserId_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByEsfUserId_First(esfUserId, orderByComparator);

		if (esfGun != null) {
			return esfGun;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunException(msg.toString());
	}

	/**
	 * Returns the first e s f gun in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByEsfUserId_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFGun> list = findByEsfUserId(esfUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f gun in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByEsfUserId_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByEsfUserId_Last(esfUserId, orderByComparator);

		if (esfGun != null) {
			return esfGun;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunException(msg.toString());
	}

	/**
	 * Returns the last e s f gun in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByEsfUserId_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfUserId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFGun> list = findByEsfUserId(esfUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f guns before and after the current e s f gun in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfGunId the primary key of the current e s f gun
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun[] findByEsfUserId_PrevAndNext(long esfGunId, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = findByPrimaryKey(esfGunId);

		Session session = null;

		try {
			session = openSession();

			ESFGun[] array = new ESFGunImpl[3];

			array[0] = getByEsfUserId_PrevAndNext(session, esfGun, esfUserId,
					orderByComparator, true);

			array[1] = esfGun;

			array[2] = getByEsfUserId_PrevAndNext(session, esfGun, esfUserId,
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

	protected ESFGun getByEsfUserId_PrevAndNext(Session session, ESFGun esfGun,
		long esfUserId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUN_WHERE);

		query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

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
			query.append(ESFGunModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfGun);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFGun> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f guns where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfUserId(long esfUserId) throws SystemException {
		for (ESFGun esfGun : findByEsfUserId(esfUserId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfGun);
		}
	}

	/**
	 * Returns the number of e s f guns where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfUserId(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUSERID;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFGUN_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

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

	private static final String _FINDER_COLUMN_ESFUSERID_ESFUSERID_2 = "esfGun.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFORGANIZATIONID =
		new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID =
		new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEsfOrganizationId", new String[] { Long.class.getName() },
			ESFGunModelImpl.ESFORGANIZATIONID_COLUMN_BITMASK |
			ESFGunModelImpl.ESFGUNKINDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFORGANIZATIONID = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEsfOrganizationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f guns where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByEsfOrganizationId(long esfOrganizationId)
		throws SystemException {
		return findByEsfOrganizationId(esfOrganizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f guns where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @return the range of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByEsfOrganizationId(long esfOrganizationId,
		int start, int end) throws SystemException {
		return findByEsfOrganizationId(esfOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f guns where esfOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByEsfOrganizationId(long esfOrganizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID;
			finderArgs = new Object[] { esfOrganizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFORGANIZATIONID;
			finderArgs = new Object[] {
					esfOrganizationId,
					
					start, end, orderByComparator
				};
		}

		List<ESFGun> list = (List<ESFGun>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFGun esfGun : list) {
				if ((esfOrganizationId != esfGun.getEsfOrganizationId())) {
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

			query.append(_SQL_SELECT_ESFGUN_WHERE);

			query.append(_FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFGunModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

				if (!pagination) {
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGun>(list);
				}
				else {
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first e s f gun in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByEsfOrganizationId_First(long esfOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByEsfOrganizationId_First(esfOrganizationId,
				orderByComparator);

		if (esfGun != null) {
			return esfGun;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunException(msg.toString());
	}

	/**
	 * Returns the first e s f gun in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByEsfOrganizationId_First(long esfOrganizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFGun> list = findByEsfOrganizationId(esfOrganizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f gun in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByEsfOrganizationId_Last(long esfOrganizationId,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByEsfOrganizationId_Last(esfOrganizationId,
				orderByComparator);

		if (esfGun != null) {
			return esfGun;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrganizationId=");
		msg.append(esfOrganizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunException(msg.toString());
	}

	/**
	 * Returns the last e s f gun in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByEsfOrganizationId_Last(long esfOrganizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfOrganizationId(esfOrganizationId);

		if (count == 0) {
			return null;
		}

		List<ESFGun> list = findByEsfOrganizationId(esfOrganizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f guns before and after the current e s f gun in the ordered set where esfOrganizationId = &#63;.
	 *
	 * @param esfGunId the primary key of the current e s f gun
	 * @param esfOrganizationId the esf organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun[] findByEsfOrganizationId_PrevAndNext(long esfGunId,
		long esfOrganizationId, OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = findByPrimaryKey(esfGunId);

		Session session = null;

		try {
			session = openSession();

			ESFGun[] array = new ESFGunImpl[3];

			array[0] = getByEsfOrganizationId_PrevAndNext(session, esfGun,
					esfOrganizationId, orderByComparator, true);

			array[1] = esfGun;

			array[2] = getByEsfOrganizationId_PrevAndNext(session, esfGun,
					esfOrganizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFGun getByEsfOrganizationId_PrevAndNext(Session session,
		ESFGun esfGun, long esfOrganizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUN_WHERE);

		query.append(_FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2);

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
			query.append(ESFGunModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfOrganizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfGun);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFGun> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f guns where esfOrganizationId = &#63; from the database.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfOrganizationId(long esfOrganizationId)
		throws SystemException {
		for (ESFGun esfGun : findByEsfOrganizationId(esfOrganizationId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfGun);
		}
	}

	/**
	 * Returns the number of e s f guns where esfOrganizationId = &#63;.
	 *
	 * @param esfOrganizationId the esf organization ID
	 * @return the number of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfOrganizationId(long esfOrganizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFORGANIZATIONID;

		Object[] finderArgs = new Object[] { esfOrganizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFGUN_WHERE);

			query.append(_FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrganizationId);

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

	private static final String _FINDER_COLUMN_ESFORGANIZATIONID_ESFORGANIZATIONID_2 =
		"esfGun.esfOrganizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFGUNKINDID =
		new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfGunKindId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNKINDID =
		new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, ESFGunImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEsfGunKindId",
			new String[] { Long.class.getName() },
			ESFGunModelImpl.ESFGUNKINDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFGUNKINDID = new FinderPath(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEsfGunKindId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f guns where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @return the matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByEsfGunKindId(long esfGunKindId)
		throws SystemException {
		return findByEsfGunKindId(esfGunKindId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f guns where esfGunKindId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @return the range of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByEsfGunKindId(long esfGunKindId, int start, int end)
		throws SystemException {
		return findByEsfGunKindId(esfGunKindId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f guns where esfGunKindId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findByEsfGunKindId(long esfGunKindId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNKINDID;
			finderArgs = new Object[] { esfGunKindId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFGUNKINDID;
			finderArgs = new Object[] {
					esfGunKindId,
					
					start, end, orderByComparator
				};
		}

		List<ESFGun> list = (List<ESFGun>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFGun esfGun : list) {
				if ((esfGunKindId != esfGun.getEsfGunKindId())) {
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

			query.append(_SQL_SELECT_ESFGUN_WHERE);

			query.append(_FINDER_COLUMN_ESFGUNKINDID_ESFGUNKINDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFGunModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunKindId);

				if (!pagination) {
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGun>(list);
				}
				else {
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first e s f gun in the ordered set where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByEsfGunKindId_First(long esfGunKindId,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByEsfGunKindId_First(esfGunKindId,
				orderByComparator);

		if (esfGun != null) {
			return esfGun;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunKindId=");
		msg.append(esfGunKindId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunException(msg.toString());
	}

	/**
	 * Returns the first e s f gun in the ordered set where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByEsfGunKindId_First(long esfGunKindId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFGun> list = findByEsfGunKindId(esfGunKindId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f gun in the ordered set where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByEsfGunKindId_Last(long esfGunKindId,
		OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByEsfGunKindId_Last(esfGunKindId, orderByComparator);

		if (esfGun != null) {
			return esfGun;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunKindId=");
		msg.append(esfGunKindId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunException(msg.toString());
	}

	/**
	 * Returns the last e s f gun in the ordered set where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByEsfGunKindId_Last(long esfGunKindId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfGunKindId(esfGunKindId);

		if (count == 0) {
			return null;
		}

		List<ESFGun> list = findByEsfGunKindId(esfGunKindId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f guns before and after the current e s f gun in the ordered set where esfGunKindId = &#63;.
	 *
	 * @param esfGunId the primary key of the current e s f gun
	 * @param esfGunKindId the esf gun kind ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun[] findByEsfGunKindId_PrevAndNext(long esfGunId,
		long esfGunKindId, OrderByComparator orderByComparator)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = findByPrimaryKey(esfGunId);

		Session session = null;

		try {
			session = openSession();

			ESFGun[] array = new ESFGunImpl[3];

			array[0] = getByEsfGunKindId_PrevAndNext(session, esfGun,
					esfGunKindId, orderByComparator, true);

			array[1] = esfGun;

			array[2] = getByEsfGunKindId_PrevAndNext(session, esfGun,
					esfGunKindId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFGun getByEsfGunKindId_PrevAndNext(Session session,
		ESFGun esfGun, long esfGunKindId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUN_WHERE);

		query.append(_FINDER_COLUMN_ESFGUNKINDID_ESFGUNKINDID_2);

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
			query.append(ESFGunModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfGunKindId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfGun);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFGun> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f guns where esfGunKindId = &#63; from the database.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfGunKindId(long esfGunKindId)
		throws SystemException {
		for (ESFGun esfGun : findByEsfGunKindId(esfGunKindId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfGun);
		}
	}

	/**
	 * Returns the number of e s f guns where esfGunKindId = &#63;.
	 *
	 * @param esfGunKindId the esf gun kind ID
	 * @return the number of matching e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfGunKindId(long esfGunKindId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFGUNKINDID;

		Object[] finderArgs = new Object[] { esfGunKindId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFGUN_WHERE);

			query.append(_FINDER_COLUMN_ESFGUNKINDID_ESFGUNKINDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunKindId);

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

	private static final String _FINDER_COLUMN_ESFGUNKINDID_ESFGUNKINDID_2 = "esfGun.esfGunKindId = ?";

	public ESFGunPersistenceImpl() {
		setModelClass(ESFGun.class);
	}

	/**
	 * Caches the e s f gun in the entity cache if it is enabled.
	 *
	 * @param esfGun the e s f gun
	 */
	@Override
	public void cacheResult(ESFGun esfGun) {
		EntityCacheUtil.putResult(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunImpl.class, esfGun.getPrimaryKey(), esfGun);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfGun.getUuid(), esfGun.getGroupId() }, esfGun);

		esfGun.resetOriginalValues();
	}

	/**
	 * Caches the e s f guns in the entity cache if it is enabled.
	 *
	 * @param esfGuns the e s f guns
	 */
	@Override
	public void cacheResult(List<ESFGun> esfGuns) {
		for (ESFGun esfGun : esfGuns) {
			if (EntityCacheUtil.getResult(
						ESFGunModelImpl.ENTITY_CACHE_ENABLED, ESFGunImpl.class,
						esfGun.getPrimaryKey()) == null) {
				cacheResult(esfGun);
			}
			else {
				esfGun.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f guns.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFGunImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFGunImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f gun.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFGun esfGun) {
		EntityCacheUtil.removeResult(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunImpl.class, esfGun.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfGun);
	}

	@Override
	public void clearCache(List<ESFGun> esfGuns) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFGun esfGun : esfGuns) {
			EntityCacheUtil.removeResult(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
				ESFGunImpl.class, esfGun.getPrimaryKey());

			clearUniqueFindersCache(esfGun);
		}
	}

	protected void cacheUniqueFindersCache(ESFGun esfGun) {
		if (esfGun.isNew()) {
			Object[] args = new Object[] { esfGun.getUuid(), esfGun.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, esfGun);
		}
		else {
			ESFGunModelImpl esfGunModelImpl = (ESFGunModelImpl)esfGun;

			if ((esfGunModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGun.getUuid(), esfGun.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfGun);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFGun esfGun) {
		ESFGunModelImpl esfGunModelImpl = (ESFGunModelImpl)esfGun;

		Object[] args = new Object[] { esfGun.getUuid(), esfGun.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfGunModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfGunModelImpl.getOriginalUuid(),
					esfGunModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f gun with the primary key. Does not add the e s f gun to the database.
	 *
	 * @param esfGunId the primary key for the new e s f gun
	 * @return the new e s f gun
	 */
	@Override
	public ESFGun create(long esfGunId) {
		ESFGun esfGun = new ESFGunImpl();

		esfGun.setNew(true);
		esfGun.setPrimaryKey(esfGunId);

		String uuid = PortalUUIDUtil.generate();

		esfGun.setUuid(uuid);

		return esfGun;
	}

	/**
	 * Removes the e s f gun with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfGunId the primary key of the e s f gun
	 * @return the e s f gun that was removed
	 * @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun remove(long esfGunId)
		throws NoSuchGunException, SystemException {
		return remove((Serializable)esfGunId);
	}

	/**
	 * Removes the e s f gun with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f gun
	 * @return the e s f gun that was removed
	 * @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun remove(Serializable primaryKey)
		throws NoSuchGunException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFGun esfGun = (ESFGun)session.get(ESFGunImpl.class, primaryKey);

			if (esfGun == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGunException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfGun);
		}
		catch (NoSuchGunException nsee) {
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
	protected ESFGun removeImpl(ESFGun esfGun) throws SystemException {
		esfGun = toUnwrappedModel(esfGun);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfGun)) {
				esfGun = (ESFGun)session.get(ESFGunImpl.class,
						esfGun.getPrimaryKeyObj());
			}

			if (esfGun != null) {
				session.delete(esfGun);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfGun != null) {
			clearCache(esfGun);
		}

		return esfGun;
	}

	@Override
	public ESFGun updateImpl(it.ethica.esf.model.ESFGun esfGun)
		throws SystemException {
		esfGun = toUnwrappedModel(esfGun);

		boolean isNew = esfGun.isNew();

		ESFGunModelImpl esfGunModelImpl = (ESFGunModelImpl)esfGun;

		if (Validator.isNull(esfGun.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfGun.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfGun.isNew()) {
				session.save(esfGun);

				esfGun.setNew(false);
			}
			else {
				session.merge(esfGun);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFGunModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfGunModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfGunModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfGunModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfGunModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGunModelImpl.getOriginalUuid(),
						esfGunModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfGunModelImpl.getUuid(),
						esfGunModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfGunModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGunModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);

				args = new Object[] { esfGunModelImpl.getEsfUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);
			}

			if ((esfGunModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGunModelImpl.getOriginalEsfOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID,
					args);

				args = new Object[] { esfGunModelImpl.getEsfOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORGANIZATIONID,
					args);
			}

			if ((esfGunModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNKINDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGunModelImpl.getOriginalEsfGunKindId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFGUNKINDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNKINDID,
					args);

				args = new Object[] { esfGunModelImpl.getEsfGunKindId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFGUNKINDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNKINDID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunImpl.class, esfGun.getPrimaryKey(), esfGun);

		clearUniqueFindersCache(esfGun);
		cacheUniqueFindersCache(esfGun);

		return esfGun;
	}

	protected ESFGun toUnwrappedModel(ESFGun esfGun) {
		if (esfGun instanceof ESFGunImpl) {
			return esfGun;
		}

		ESFGunImpl esfGunImpl = new ESFGunImpl();

		esfGunImpl.setNew(esfGun.isNew());
		esfGunImpl.setPrimaryKey(esfGun.getPrimaryKey());

		esfGunImpl.setUuid(esfGun.getUuid());
		esfGunImpl.setEsfGunId(esfGun.getEsfGunId());
		esfGunImpl.setGroupId(esfGun.getGroupId());
		esfGunImpl.setCompanyId(esfGun.getCompanyId());
		esfGunImpl.setUserId(esfGun.getUserId());
		esfGunImpl.setUserName(esfGun.getUserName());
		esfGunImpl.setCreateDate(esfGun.getCreateDate());
		esfGunImpl.setModifiedDate(esfGun.getModifiedDate());
		esfGunImpl.setEsfUserId(esfGun.getEsfUserId());
		esfGunImpl.setCode(esfGun.getCode());
		esfGunImpl.setEsfGunKindId(esfGun.getEsfGunKindId());
		esfGunImpl.setEsfOrganizationId(esfGun.getEsfOrganizationId());

		return esfGunImpl;
	}

	/**
	 * Returns the e s f gun with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f gun
	 * @return the e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGunException, SystemException {
		ESFGun esfGun = fetchByPrimaryKey(primaryKey);

		if (esfGun == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGunException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfGun;
	}

	/**
	 * Returns the e s f gun with the primary key or throws a {@link it.ethica.esf.NoSuchGunException} if it could not be found.
	 *
	 * @param esfGunId the primary key of the e s f gun
	 * @return the e s f gun
	 * @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun findByPrimaryKey(long esfGunId)
		throws NoSuchGunException, SystemException {
		return findByPrimaryKey((Serializable)esfGunId);
	}

	/**
	 * Returns the e s f gun with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f gun
	 * @return the e s f gun, or <code>null</code> if a e s f gun with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFGun esfGun = (ESFGun)EntityCacheUtil.getResult(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
				ESFGunImpl.class, primaryKey);

		if (esfGun == _nullESFGun) {
			return null;
		}

		if (esfGun == null) {
			Session session = null;

			try {
				session = openSession();

				esfGun = (ESFGun)session.get(ESFGunImpl.class, primaryKey);

				if (esfGun != null) {
					cacheResult(esfGun);
				}
				else {
					EntityCacheUtil.putResult(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
						ESFGunImpl.class, primaryKey, _nullESFGun);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFGunModelImpl.ENTITY_CACHE_ENABLED,
					ESFGunImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfGun;
	}

	/**
	 * Returns the e s f gun with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfGunId the primary key of the e s f gun
	 * @return the e s f gun, or <code>null</code> if a e s f gun with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGun fetchByPrimaryKey(long esfGunId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfGunId);
	}

	/**
	 * Returns all the e s f guns.
	 *
	 * @return the e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f guns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @return the range of e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f guns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f guns
	 * @param end the upper bound of the range of e s f guns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f guns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGun> findAll(int start, int end,
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

		List<ESFGun> list = (List<ESFGun>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFGUN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFGUN;

				if (pagination) {
					sql = sql.concat(ESFGunModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGun>(list);
				}
				else {
					list = (List<ESFGun>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the e s f guns from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFGun esfGun : findAll()) {
			remove(esfGun);
		}
	}

	/**
	 * Returns the number of e s f guns.
	 *
	 * @return the number of e s f guns
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

				Query q = session.createQuery(_SQL_COUNT_ESFGUN);

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
	 * Initializes the e s f gun persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFGun")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFGun>> listenersList = new ArrayList<ModelListener<ESFGun>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFGun>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFGunImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFGUN = "SELECT esfGun FROM ESFGun esfGun";
	private static final String _SQL_SELECT_ESFGUN_WHERE = "SELECT esfGun FROM ESFGun esfGun WHERE ";
	private static final String _SQL_COUNT_ESFGUN = "SELECT COUNT(esfGun) FROM ESFGun esfGun";
	private static final String _SQL_COUNT_ESFGUN_WHERE = "SELECT COUNT(esfGun) FROM ESFGun esfGun WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfGun.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFGun exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFGun exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFGunPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ESFGun _nullESFGun = new ESFGunImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFGun> toCacheModel() {
				return _nullESFGunCacheModel;
			}
		};

	private static CacheModel<ESFGun> _nullESFGunCacheModel = new CacheModel<ESFGun>() {
			@Override
			public ESFGun toEntityModel() {
				return _nullESFGun;
			}
		};
}