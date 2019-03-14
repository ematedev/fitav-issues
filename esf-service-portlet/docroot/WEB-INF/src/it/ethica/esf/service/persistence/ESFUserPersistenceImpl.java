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

import it.ethica.esf.NoSuchUserException;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.model.impl.ESFUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserPersistence
 * @see ESFUserUtil
 * @generated
 */
public class ESFUserPersistenceImpl extends BasePersistenceImpl<ESFUser>
	implements ESFUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFUserUtil} to access the e s f user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFUserModelImpl.UUID_COLUMN_BITMASK |
			ESFUserModelImpl.PORTALUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @return the range of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByUuid(String uuid, int start, int end,
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

		List<ESFUser> list = (List<ESFUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUser esfUser : list) {
				if (!Validator.equals(uuid, esfUser.getUuid())) {
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

			query.append(_SQL_SELECT_ESFUSER_WHERE);

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
				query.append(ESFUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUser>(list);
				}
				else {
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByUuid_First(uuid, orderByComparator);

		if (esfUser != null) {
			return esfUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first e s f user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByUuid_Last(uuid, orderByComparator);

		if (esfUser != null) {
			return esfUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last e s f user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFUser> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f users before and after the current e s f user in the ordered set where uuid = &#63;.
	 *
	 * @param esfUserId the primary key of the current e s f user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser[] findByUuid_PrevAndNext(long esfUserId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = findByPrimaryKey(esfUserId);

		Session session = null;

		try {
			session = openSession();

			ESFUser[] array = new ESFUserImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfUser, uuid,
					orderByComparator, true);

			array[1] = esfUser;

			array[2] = getByUuid_PrevAndNext(session, esfUser, uuid,
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

	protected ESFUser getByUuid_PrevAndNext(Session session, ESFUser esfUser,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSER_WHERE);

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
			query.append(ESFUserModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFUser esfUser : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfUser);
		}
	}

	/**
	 * Returns the number of e s f users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f users
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

			query.append(_SQL_COUNT_ESFUSER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfUser.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfUser.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfUser.uuid IS NULL OR esfUser.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFUserModelImpl.UUID_COLUMN_BITMASK |
			ESFUserModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f user where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByUUID_G(String uuid, long groupId)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByUUID_G(uuid, groupId);

		if (esfUser == null) {
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

			throw new NoSuchUserException(msg.toString());
		}

		return esfUser;
	}

	/**
	 * Returns the e s f user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFUser) {
			ESFUser esfUser = (ESFUser)result;

			if (!Validator.equals(uuid, esfUser.getUuid()) ||
					(groupId != esfUser.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFUSER_WHERE);

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

				List<ESFUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFUser esfUser = list.get(0);

					result = esfUser;

					cacheResult(esfUser);

					if ((esfUser.getUuid() == null) ||
							!esfUser.getUuid().equals(uuid) ||
							(esfUser.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfUser);
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
			return (ESFUser)result;
		}
	}

	/**
	 * Removes the e s f user where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = findByUUID_G(uuid, groupId);

		return remove(esfUser);
	}

	/**
	 * Returns the number of e s f users where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f users
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

			query.append(_SQL_COUNT_ESFUSER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfUser.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfUser.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfUser.uuid IS NULL OR esfUser.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfUser.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFUserModelImpl.UUID_COLUMN_BITMASK |
			ESFUserModelImpl.COMPANYID_COLUMN_BITMASK |
			ESFUserModelImpl.PORTALUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @return the range of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByUuid_C(String uuid, long companyId, int start,
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

		List<ESFUser> list = (List<ESFUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUser esfUser : list) {
				if (!Validator.equals(uuid, esfUser.getUuid()) ||
						(companyId != esfUser.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFUSER_WHERE);

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
				query.append(ESFUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUser>(list);
				}
				else {
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (esfUser != null) {
			return esfUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first e s f user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUser> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (esfUser != null) {
			return esfUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last e s f user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFUser> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f users before and after the current e s f user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfUserId the primary key of the current e s f user
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser[] findByUuid_C_PrevAndNext(long esfUserId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = findByPrimaryKey(esfUserId);

		Session session = null;

		try {
			session = openSession();

			ESFUser[] array = new ESFUserImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfUser, uuid,
					companyId, orderByComparator, true);

			array[1] = esfUser;

			array[2] = getByUuid_C_PrevAndNext(session, esfUser, uuid,
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

	protected ESFUser getByUuid_C_PrevAndNext(Session session, ESFUser esfUser,
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

		query.append(_SQL_SELECT_ESFUSER_WHERE);

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
			query.append(ESFUserModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFUser esfUser : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfUser);
		}
	}

	/**
	 * Returns the number of e s f users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f users
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

			query.append(_SQL_COUNT_ESFUSER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfUser.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfUser.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfUser.uuid IS NULL OR esfUser.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfUser.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTALUSERID =
		new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPortalUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTALUSERID =
		new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPortalUserId",
			new String[] { Long.class.getName() },
			ESFUserModelImpl.PORTALUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORTALUSERID = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPortalUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f users where portalUserId = &#63;.
	 *
	 * @param portalUserId the portal user ID
	 * @return the matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByPortalUserId(long portalUserId)
		throws SystemException {
		return findByPortalUserId(portalUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f users where portalUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param portalUserId the portal user ID
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @return the range of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByPortalUserId(long portalUserId, int start,
		int end) throws SystemException {
		return findByPortalUserId(portalUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f users where portalUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param portalUserId the portal user ID
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findByPortalUserId(long portalUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTALUSERID;
			finderArgs = new Object[] { portalUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTALUSERID;
			finderArgs = new Object[] {
					portalUserId,
					
					start, end, orderByComparator
				};
		}

		List<ESFUser> list = (List<ESFUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUser esfUser : list) {
				if ((portalUserId != esfUser.getPortalUserId())) {
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

			query.append(_SQL_SELECT_ESFUSER_WHERE);

			query.append(_FINDER_COLUMN_PORTALUSERID_PORTALUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(portalUserId);

				if (!pagination) {
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUser>(list);
				}
				else {
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f user in the ordered set where portalUserId = &#63;.
	 *
	 * @param portalUserId the portal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByPortalUserId_First(long portalUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByPortalUserId_First(portalUserId,
				orderByComparator);

		if (esfUser != null) {
			return esfUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("portalUserId=");
		msg.append(portalUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first e s f user in the ordered set where portalUserId = &#63;.
	 *
	 * @param portalUserId the portal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByPortalUserId_First(long portalUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUser> list = findByPortalUserId(portalUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user in the ordered set where portalUserId = &#63;.
	 *
	 * @param portalUserId the portal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByPortalUserId_Last(long portalUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByPortalUserId_Last(portalUserId,
				orderByComparator);

		if (esfUser != null) {
			return esfUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("portalUserId=");
		msg.append(portalUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last e s f user in the ordered set where portalUserId = &#63;.
	 *
	 * @param portalUserId the portal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByPortalUserId_Last(long portalUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPortalUserId(portalUserId);

		if (count == 0) {
			return null;
		}

		List<ESFUser> list = findByPortalUserId(portalUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f users before and after the current e s f user in the ordered set where portalUserId = &#63;.
	 *
	 * @param esfUserId the primary key of the current e s f user
	 * @param portalUserId the portal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser[] findByPortalUserId_PrevAndNext(long esfUserId,
		long portalUserId, OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = findByPrimaryKey(esfUserId);

		Session session = null;

		try {
			session = openSession();

			ESFUser[] array = new ESFUserImpl[3];

			array[0] = getByPortalUserId_PrevAndNext(session, esfUser,
					portalUserId, orderByComparator, true);

			array[1] = esfUser;

			array[2] = getByPortalUserId_PrevAndNext(session, esfUser,
					portalUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFUser getByPortalUserId_PrevAndNext(Session session,
		ESFUser esfUser, long portalUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSER_WHERE);

		query.append(_FINDER_COLUMN_PORTALUSERID_PORTALUSERID_2);

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
			query.append(ESFUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(portalUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f users where portalUserId = &#63; from the database.
	 *
	 * @param portalUserId the portal user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPortalUserId(long portalUserId)
		throws SystemException {
		for (ESFUser esfUser : findByPortalUserId(portalUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUser);
		}
	}

	/**
	 * Returns the number of e s f users where portalUserId = &#63;.
	 *
	 * @param portalUserId the portal user ID
	 * @return the number of matching e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPortalUserId(long portalUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PORTALUSERID;

		Object[] finderArgs = new Object[] { portalUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSER_WHERE);

			query.append(_FINDER_COLUMN_PORTALUSERID_PORTALUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(portalUserId);

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

	private static final String _FINDER_COLUMN_PORTALUSERID_PORTALUSERID_2 = "esfUser.portalUserId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, ESFUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			ESFUserModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f user where code = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByCode(String code)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByCode(code);

		if (esfUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserException(msg.toString());
		}

		return esfUser;
	}

	/**
	 * Returns the e s f user where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the e s f user where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ESFUser) {
			ESFUser esfUser = (ESFUser)result;

			if (!Validator.equals(code, esfUser.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFUSER_WHERE);

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

				List<ESFUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFUserPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFUser esfUser = list.get(0);

					result = esfUser;

					cacheResult(esfUser);

					if ((esfUser.getCode() == null) ||
							!esfUser.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, esfUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
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
			return (ESFUser)result;
		}
	}

	/**
	 * Removes the e s f user where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the e s f user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser removeByCode(String code)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = findByCode(code);

		return remove(esfUser);
	}

	/**
	 * Returns the number of e s f users where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f users
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

			query.append(_SQL_COUNT_ESFUSER_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfUser.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfUser.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfUser.code IS NULL OR esfUser.code = '')";

	public ESFUserPersistenceImpl() {
		setModelClass(ESFUser.class);
	}

	/**
	 * Caches the e s f user in the entity cache if it is enabled.
	 *
	 * @param esfUser the e s f user
	 */
	@Override
	public void cacheResult(ESFUser esfUser) {
		EntityCacheUtil.putResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserImpl.class, esfUser.getPrimaryKey(), esfUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfUser.getUuid(), esfUser.getGroupId() }, esfUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { esfUser.getCode() }, esfUser);

		esfUser.resetOriginalValues();
	}

	/**
	 * Caches the e s f users in the entity cache if it is enabled.
	 *
	 * @param esfUsers the e s f users
	 */
	@Override
	public void cacheResult(List<ESFUser> esfUsers) {
		for (ESFUser esfUser : esfUsers) {
			if (EntityCacheUtil.getResult(
						ESFUserModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserImpl.class, esfUser.getPrimaryKey()) == null) {
				cacheResult(esfUser);
			}
			else {
				esfUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFUser esfUser) {
		EntityCacheUtil.removeResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserImpl.class, esfUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfUser);
	}

	@Override
	public void clearCache(List<ESFUser> esfUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFUser esfUser : esfUsers) {
			EntityCacheUtil.removeResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserImpl.class, esfUser.getPrimaryKey());

			clearUniqueFindersCache(esfUser);
		}
	}

	protected void cacheUniqueFindersCache(ESFUser esfUser) {
		if (esfUser.isNew()) {
			Object[] args = new Object[] { esfUser.getUuid(), esfUser.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, esfUser);

			args = new Object[] { esfUser.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args, esfUser);
		}
		else {
			ESFUserModelImpl esfUserModelImpl = (ESFUserModelImpl)esfUser;

			if ((esfUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUser.getUuid(), esfUser.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfUser);
			}

			if ((esfUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfUser.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					esfUser);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFUser esfUser) {
		ESFUserModelImpl esfUserModelImpl = (ESFUserModelImpl)esfUser;

		Object[] args = new Object[] { esfUser.getUuid(), esfUser.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfUserModelImpl.getOriginalUuid(),
					esfUserModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { esfUser.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((esfUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfUserModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new e s f user with the primary key. Does not add the e s f user to the database.
	 *
	 * @param esfUserId the primary key for the new e s f user
	 * @return the new e s f user
	 */
	@Override
	public ESFUser create(long esfUserId) {
		ESFUser esfUser = new ESFUserImpl();

		esfUser.setNew(true);
		esfUser.setPrimaryKey(esfUserId);

		String uuid = PortalUUIDUtil.generate();

		esfUser.setUuid(uuid);

		return esfUser;
	}

	/**
	 * Removes the e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserId the primary key of the e s f user
	 * @return the e s f user that was removed
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser remove(long esfUserId)
		throws NoSuchUserException, SystemException {
		return remove((Serializable)esfUserId);
	}

	/**
	 * Removes the e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f user
	 * @return the e s f user that was removed
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser remove(Serializable primaryKey)
		throws NoSuchUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFUser esfUser = (ESFUser)session.get(ESFUserImpl.class, primaryKey);

			if (esfUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfUser);
		}
		catch (NoSuchUserException nsee) {
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
	protected ESFUser removeImpl(ESFUser esfUser) throws SystemException {
		esfUser = toUnwrappedModel(esfUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfUser)) {
				esfUser = (ESFUser)session.get(ESFUserImpl.class,
						esfUser.getPrimaryKeyObj());
			}

			if (esfUser != null) {
				session.delete(esfUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfUser != null) {
			clearCache(esfUser);
		}

		return esfUser;
	}

	@Override
	public ESFUser updateImpl(it.ethica.esf.model.ESFUser esfUser)
		throws SystemException {
		esfUser = toUnwrappedModel(esfUser);

		boolean isNew = esfUser.isNew();

		ESFUserModelImpl esfUserModelImpl = (ESFUserModelImpl)esfUser;

		if (Validator.isNull(esfUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfUser.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfUser.isNew()) {
				session.save(esfUser);

				esfUser.setNew(false);
			}
			else {
				session.merge(esfUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfUserModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfUserModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserModelImpl.getOriginalUuid(),
						esfUserModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfUserModelImpl.getUuid(),
						esfUserModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTALUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserModelImpl.getOriginalPortalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTALUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTALUSERID,
					args);

				args = new Object[] { esfUserModelImpl.getPortalUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTALUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTALUSERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserImpl.class, esfUser.getPrimaryKey(), esfUser);

		clearUniqueFindersCache(esfUser);
		cacheUniqueFindersCache(esfUser);

		return esfUser;
	}

	protected ESFUser toUnwrappedModel(ESFUser esfUser) {
		if (esfUser instanceof ESFUserImpl) {
			return esfUser;
		}

		ESFUserImpl esfUserImpl = new ESFUserImpl();

		esfUserImpl.setNew(esfUser.isNew());
		esfUserImpl.setPrimaryKey(esfUser.getPrimaryKey());

		esfUserImpl.setUuid(esfUser.getUuid());
		esfUserImpl.setEsfUserId(esfUser.getEsfUserId());
		esfUserImpl.setGroupId(esfUser.getGroupId());
		esfUserImpl.setCompanyId(esfUser.getCompanyId());
		esfUserImpl.setUserId(esfUser.getUserId());
		esfUserImpl.setUserName(esfUser.getUserName());
		esfUserImpl.setCreateDate(esfUser.getCreateDate());
		esfUserImpl.setModifiedDate(esfUser.getModifiedDate());
		esfUserImpl.setPortalUserId(esfUser.getPortalUserId());
		esfUserImpl.setCode(esfUser.getCode());

		return esfUserImpl;
	}

	/**
	 * Returns the e s f user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user
	 * @return the e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserException, SystemException {
		ESFUser esfUser = fetchByPrimaryKey(primaryKey);

		if (esfUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfUser;
	}

	/**
	 * Returns the e s f user with the primary key or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	 *
	 * @param esfUserId the primary key of the e s f user
	 * @return the e s f user
	 * @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser findByPrimaryKey(long esfUserId)
		throws NoSuchUserException, SystemException {
		return findByPrimaryKey((Serializable)esfUserId);
	}

	/**
	 * Returns the e s f user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user
	 * @return the e s f user, or <code>null</code> if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFUser esfUser = (ESFUser)EntityCacheUtil.getResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserImpl.class, primaryKey);

		if (esfUser == _nullESFUser) {
			return null;
		}

		if (esfUser == null) {
			Session session = null;

			try {
				session = openSession();

				esfUser = (ESFUser)session.get(ESFUserImpl.class, primaryKey);

				if (esfUser != null) {
					cacheResult(esfUser);
				}
				else {
					EntityCacheUtil.putResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserImpl.class, primaryKey, _nullESFUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFUserModelImpl.ENTITY_CACHE_ENABLED,
					ESFUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfUser;
	}

	/**
	 * Returns the e s f user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfUserId the primary key of the e s f user
	 * @return the e s f user, or <code>null</code> if a e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUser fetchByPrimaryKey(long esfUserId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfUserId);
	}

	/**
	 * Returns all the e s f users.
	 *
	 * @return the e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @return the range of e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f users
	 * @param end the upper bound of the range of e s f users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUser> findAll(int start, int end,
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

		List<ESFUser> list = (List<ESFUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFUSER;

				if (pagination) {
					sql = sql.concat(ESFUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUser>(list);
				}
				else {
					list = (List<ESFUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFUser esfUser : findAll()) {
			remove(esfUser);
		}
	}

	/**
	 * Returns the number of e s f users.
	 *
	 * @return the number of e s f users
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

				Query q = session.createQuery(_SQL_COUNT_ESFUSER);

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
	 * Initializes the e s f user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFUser>> listenersList = new ArrayList<ModelListener<ESFUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFUSER = "SELECT esfUser FROM ESFUser esfUser";
	private static final String _SQL_SELECT_ESFUSER_WHERE = "SELECT esfUser FROM ESFUser esfUser WHERE ";
	private static final String _SQL_COUNT_ESFUSER = "SELECT COUNT(esfUser) FROM ESFUser esfUser";
	private static final String _SQL_COUNT_ESFUSER_WHERE = "SELECT COUNT(esfUser) FROM ESFUser esfUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFUserPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ESFUser _nullESFUser = new ESFUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFUser> toCacheModel() {
				return _nullESFUserCacheModel;
			}
		};

	private static CacheModel<ESFUser> _nullESFUserCacheModel = new CacheModel<ESFUser>() {
			@Override
			public ESFUser toEntityModel() {
				return _nullESFUser;
			}
		};
}