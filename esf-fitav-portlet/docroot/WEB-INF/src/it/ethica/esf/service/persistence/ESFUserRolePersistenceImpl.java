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

import it.ethica.esf.NoSuchUserRoleException;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.impl.ESFUserRoleImpl;
import it.ethica.esf.model.impl.ESFUserRoleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f user role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserRolePersistence
 * @see ESFUserRoleUtil
 * @generated
 */
public class ESFUserRolePersistenceImpl extends BasePersistenceImpl<ESFUserRole>
	implements ESFUserRolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFUserRoleUtil} to access the e s f user role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFUserRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFUserRoleModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f user roles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user roles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @return the range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user roles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByUuid(String uuid, int start, int end,
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

		List<ESFUserRole> list = (List<ESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserRole esfUserRole : list) {
				if (!Validator.equals(uuid, esfUserRole.getUuid())) {
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

			query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

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
				query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserRole>(list);
				}
				else {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f user role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByUuid_First(uuid, orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserRole> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByUuid_Last(uuid, orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFUserRole> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user roles before and after the current e s f user role in the ordered set where uuid = &#63;.
	 *
	 * @param esfUserRoleId the primary key of the current e s f user role
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole[] findByUuid_PrevAndNext(long esfUserRoleId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = findByPrimaryKey(esfUserRoleId);

		Session session = null;

		try {
			session = openSession();

			ESFUserRole[] array = new ESFUserRoleImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfUserRole, uuid,
					orderByComparator, true);

			array[1] = esfUserRole;

			array[2] = getByUuid_PrevAndNext(session, esfUserRole, uuid,
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

	protected ESFUserRole getByUuid_PrevAndNext(Session session,
		ESFUserRole esfUserRole, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

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
			query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user roles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFUserRole esfUserRole : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfUserRole);
		}
	}

	/**
	 * Returns the number of e s f user roles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f user roles
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

			query.append(_SQL_COUNT_ESFUSERROLE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfUserRole.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfUserRole.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfUserRole.uuid IS NULL OR esfUserRole.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFUserRoleModelImpl.UUID_COLUMN_BITMASK |
			ESFUserRoleModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f user role where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchUserRoleException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByUUID_G(String uuid, long groupId)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByUUID_G(uuid, groupId);

		if (esfUserRole == null) {
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

			throw new NoSuchUserRoleException(msg.toString());
		}

		return esfUserRole;
	}

	/**
	 * Returns the e s f user role where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f user role where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFUserRole) {
			ESFUserRole esfUserRole = (ESFUserRole)result;

			if (!Validator.equals(uuid, esfUserRole.getUuid()) ||
					(groupId != esfUserRole.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

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

				List<ESFUserRole> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFUserRole esfUserRole = list.get(0);

					result = esfUserRole;

					cacheResult(esfUserRole);

					if ((esfUserRole.getUuid() == null) ||
							!esfUserRole.getUuid().equals(uuid) ||
							(esfUserRole.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfUserRole);
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
			return (ESFUserRole)result;
		}
	}

	/**
	 * Removes the e s f user role where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f user role that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = findByUUID_G(uuid, groupId);

		return remove(esfUserRole);
	}

	/**
	 * Returns the number of e s f user roles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f user roles
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

			query.append(_SQL_COUNT_ESFUSERROLE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfUserRole.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfUserRole.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfUserRole.uuid IS NULL OR esfUserRole.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfUserRole.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFUserRoleModelImpl.UUID_COLUMN_BITMASK |
			ESFUserRoleModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f user roles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user roles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @return the range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user roles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByUuid_C(String uuid, long companyId,
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

		List<ESFUserRole> list = (List<ESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserRole esfUserRole : list) {
				if (!Validator.equals(uuid, esfUserRole.getUuid()) ||
						(companyId != esfUserRole.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

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
				query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserRole>(list);
				}
				else {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f user role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserRole> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFUserRole> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user roles before and after the current e s f user role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfUserRoleId the primary key of the current e s f user role
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole[] findByUuid_C_PrevAndNext(long esfUserRoleId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = findByPrimaryKey(esfUserRoleId);

		Session session = null;

		try {
			session = openSession();

			ESFUserRole[] array = new ESFUserRoleImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfUserRole, uuid,
					companyId, orderByComparator, true);

			array[1] = esfUserRole;

			array[2] = getByUuid_C_PrevAndNext(session, esfUserRole, uuid,
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

	protected ESFUserRole getByUuid_C_PrevAndNext(Session session,
		ESFUserRole esfUserRole, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

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
			query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user roles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFUserRole esfUserRole : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUserRole);
		}
	}

	/**
	 * Returns the number of e s f user roles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f user roles
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

			query.append(_SQL_COUNT_ESFUSERROLE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfUserRole.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfUserRole.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfUserRole.uuid IS NULL OR esfUserRole.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfUserRole.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ESFUserRoleModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f user roles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user roles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @return the range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user roles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFUserRole> list = (List<ESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserRole esfUserRole : list) {
				if ((groupId != esfUserRole.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserRole>(list);
				}
				else {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f user role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByGroupId_First(groupId,
				orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserRole> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByGroupId_Last(groupId, orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user role in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ESFUserRole> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user roles before and after the current e s f user role in the ordered set where groupId = &#63;.
	 *
	 * @param esfUserRoleId the primary key of the current e s f user role
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole[] findByGroupId_PrevAndNext(long esfUserRoleId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = findByPrimaryKey(esfUserRoleId);

		Session session = null;

		try {
			session = openSession();

			ESFUserRole[] array = new ESFUserRoleImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, esfUserRole, groupId,
					orderByComparator, true);

			array[1] = esfUserRole;

			array[2] = getByGroupId_PrevAndNext(session, esfUserRole, groupId,
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

	protected ESFUserRole getByGroupId_PrevAndNext(Session session,
		ESFUserRole esfUserRole, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

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
			query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user roles where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESFUserRole esfUserRole : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUserRole);
		}
	}

	/**
	 * Returns the number of e s f user roles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f user roles
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

			query.append(_SQL_COUNT_ESFUSERROLE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esfUserRole.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { Integer.class.getName() },
			ESFUserRoleModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the e s f user roles where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByType(int type) throws SystemException {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user roles where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @return the range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByType(int type, int start, int end)
		throws SystemException {
		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user roles where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByType(int type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<ESFUserRole> list = (List<ESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserRole esfUserRole : list) {
				if ((type != esfUserRole.getType())) {
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

			query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				if (!pagination) {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserRole>(list);
				}
				else {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f user role in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByType_First(int type,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByType_First(type, orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user role in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByType_First(int type,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserRole> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user role in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByType_Last(int type,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByType_Last(type, orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user role in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByType_Last(int type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<ESFUserRole> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user roles before and after the current e s f user role in the ordered set where type = &#63;.
	 *
	 * @param esfUserRoleId the primary key of the current e s f user role
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole[] findByType_PrevAndNext(long esfUserRoleId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = findByPrimaryKey(esfUserRoleId);

		Session session = null;

		try {
			session = openSession();

			ESFUserRole[] array = new ESFUserRoleImpl[3];

			array[0] = getByType_PrevAndNext(session, esfUserRole, type,
					orderByComparator, true);

			array[1] = esfUserRole;

			array[2] = getByType_PrevAndNext(session, esfUserRole, type,
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

	protected ESFUserRole getByType_PrevAndNext(Session session,
		ESFUserRole esfUserRole, int type, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_TYPE_TYPE_2);

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
			query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user roles where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByType(int type) throws SystemException {
		for (ESFUserRole esfUserRole : findByType(type, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfUserRole);
		}
	}

	/**
	 * Returns the number of e s f user roles where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByType(int type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

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

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "esfUserRole.type = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BDO = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBDO",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BDO = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBDO",
			new String[] { Boolean.class.getName() },
			ESFUserRoleModelImpl.ISBDO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BDO = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBDO",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the e s f user roles where isBDO = &#63;.
	 *
	 * @param isBDO the is b d o
	 * @return the matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByBDO(boolean isBDO) throws SystemException {
		return findByBDO(isBDO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user roles where isBDO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isBDO the is b d o
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @return the range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByBDO(boolean isBDO, int start, int end)
		throws SystemException {
		return findByBDO(isBDO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user roles where isBDO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isBDO the is b d o
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByBDO(boolean isBDO, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BDO;
			finderArgs = new Object[] { isBDO };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BDO;
			finderArgs = new Object[] { isBDO, start, end, orderByComparator };
		}

		List<ESFUserRole> list = (List<ESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserRole esfUserRole : list) {
				if ((isBDO != esfUserRole.getIsBDO())) {
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

			query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_BDO_ISBDO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isBDO);

				if (!pagination) {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserRole>(list);
				}
				else {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f user role in the ordered set where isBDO = &#63;.
	 *
	 * @param isBDO the is b d o
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByBDO_First(boolean isBDO,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByBDO_First(isBDO, orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isBDO=");
		msg.append(isBDO);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user role in the ordered set where isBDO = &#63;.
	 *
	 * @param isBDO the is b d o
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByBDO_First(boolean isBDO,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserRole> list = findByBDO(isBDO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user role in the ordered set where isBDO = &#63;.
	 *
	 * @param isBDO the is b d o
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByBDO_Last(boolean isBDO,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByBDO_Last(isBDO, orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isBDO=");
		msg.append(isBDO);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user role in the ordered set where isBDO = &#63;.
	 *
	 * @param isBDO the is b d o
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByBDO_Last(boolean isBDO,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBDO(isBDO);

		if (count == 0) {
			return null;
		}

		List<ESFUserRole> list = findByBDO(isBDO, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user roles before and after the current e s f user role in the ordered set where isBDO = &#63;.
	 *
	 * @param esfUserRoleId the primary key of the current e s f user role
	 * @param isBDO the is b d o
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole[] findByBDO_PrevAndNext(long esfUserRoleId,
		boolean isBDO, OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = findByPrimaryKey(esfUserRoleId);

		Session session = null;

		try {
			session = openSession();

			ESFUserRole[] array = new ESFUserRoleImpl[3];

			array[0] = getByBDO_PrevAndNext(session, esfUserRole, isBDO,
					orderByComparator, true);

			array[1] = esfUserRole;

			array[2] = getByBDO_PrevAndNext(session, esfUserRole, isBDO,
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

	protected ESFUserRole getByBDO_PrevAndNext(Session session,
		ESFUserRole esfUserRole, boolean isBDO,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_BDO_ISBDO_2);

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
			query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isBDO);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user roles where isBDO = &#63; from the database.
	 *
	 * @param isBDO the is b d o
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBDO(boolean isBDO) throws SystemException {
		for (ESFUserRole esfUserRole : findByBDO(isBDO, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfUserRole);
		}
	}

	/**
	 * Returns the number of e s f user roles where isBDO = &#63;.
	 *
	 * @param isBDO the is b d o
	 * @return the number of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBDO(boolean isBDO) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BDO;

		Object[] finderArgs = new Object[] { isBDO };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_BDO_ISBDO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isBDO);

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

	private static final String _FINDER_COLUMN_BDO_ISBDO_2 = "esfUserRole.isBDO = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEA = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLEA",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEA = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, ESFUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLEA",
			new String[] { Boolean.class.getName() },
			ESFUserRoleModelImpl.ISLEA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEA = new FinderPath(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLEA",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the e s f user roles where isLEA = &#63;.
	 *
	 * @param isLEA the is l e a
	 * @return the matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByLEA(boolean isLEA) throws SystemException {
		return findByLEA(isLEA, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user roles where isLEA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isLEA the is l e a
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @return the range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByLEA(boolean isLEA, int start, int end)
		throws SystemException {
		return findByLEA(isLEA, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user roles where isLEA = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isLEA the is l e a
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findByLEA(boolean isLEA, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEA;
			finderArgs = new Object[] { isLEA };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEA;
			finderArgs = new Object[] { isLEA, start, end, orderByComparator };
		}

		List<ESFUserRole> list = (List<ESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserRole esfUserRole : list) {
				if ((isLEA != esfUserRole.getIsLEA())) {
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

			query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_LEA_ISLEA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isLEA);

				if (!pagination) {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserRole>(list);
				}
				else {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f user role in the ordered set where isLEA = &#63;.
	 *
	 * @param isLEA the is l e a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByLEA_First(boolean isLEA,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByLEA_First(isLEA, orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isLEA=");
		msg.append(isLEA);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user role in the ordered set where isLEA = &#63;.
	 *
	 * @param isLEA the is l e a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByLEA_First(boolean isLEA,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserRole> list = findByLEA(isLEA, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user role in the ordered set where isLEA = &#63;.
	 *
	 * @param isLEA the is l e a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByLEA_Last(boolean isLEA,
		OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByLEA_Last(isLEA, orderByComparator);

		if (esfUserRole != null) {
			return esfUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isLEA=");
		msg.append(isLEA);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user role in the ordered set where isLEA = &#63;.
	 *
	 * @param isLEA the is l e a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByLEA_Last(boolean isLEA,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLEA(isLEA);

		if (count == 0) {
			return null;
		}

		List<ESFUserRole> list = findByLEA(isLEA, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user roles before and after the current e s f user role in the ordered set where isLEA = &#63;.
	 *
	 * @param esfUserRoleId the primary key of the current e s f user role
	 * @param isLEA the is l e a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole[] findByLEA_PrevAndNext(long esfUserRoleId,
		boolean isLEA, OrderByComparator orderByComparator)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = findByPrimaryKey(esfUserRoleId);

		Session session = null;

		try {
			session = openSession();

			ESFUserRole[] array = new ESFUserRoleImpl[3];

			array[0] = getByLEA_PrevAndNext(session, esfUserRole, isLEA,
					orderByComparator, true);

			array[1] = esfUserRole;

			array[2] = getByLEA_PrevAndNext(session, esfUserRole, isLEA,
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

	protected ESFUserRole getByLEA_PrevAndNext(Session session,
		ESFUserRole esfUserRole, boolean isLEA,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_LEA_ISLEA_2);

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
			query.append(ESFUserRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isLEA);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user roles where isLEA = &#63; from the database.
	 *
	 * @param isLEA the is l e a
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLEA(boolean isLEA) throws SystemException {
		for (ESFUserRole esfUserRole : findByLEA(isLEA, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfUserRole);
		}
	}

	/**
	 * Returns the number of e s f user roles where isLEA = &#63;.
	 *
	 * @param isLEA the is l e a
	 * @return the number of matching e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLEA(boolean isLEA) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEA;

		Object[] finderArgs = new Object[] { isLEA };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_LEA_ISLEA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isLEA);

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

	private static final String _FINDER_COLUMN_LEA_ISLEA_2 = "esfUserRole.isLEA = ?";

	public ESFUserRolePersistenceImpl() {
		setModelClass(ESFUserRole.class);
	}

	/**
	 * Caches the e s f user role in the entity cache if it is enabled.
	 *
	 * @param esfUserRole the e s f user role
	 */
	@Override
	public void cacheResult(ESFUserRole esfUserRole) {
		EntityCacheUtil.putResult(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleImpl.class, esfUserRole.getPrimaryKey(), esfUserRole);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfUserRole.getUuid(), esfUserRole.getGroupId() },
			esfUserRole);

		esfUserRole.resetOriginalValues();
	}

	/**
	 * Caches the e s f user roles in the entity cache if it is enabled.
	 *
	 * @param esfUserRoles the e s f user roles
	 */
	@Override
	public void cacheResult(List<ESFUserRole> esfUserRoles) {
		for (ESFUserRole esfUserRole : esfUserRoles) {
			if (EntityCacheUtil.getResult(
						ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserRoleImpl.class, esfUserRole.getPrimaryKey()) == null) {
				cacheResult(esfUserRole);
			}
			else {
				esfUserRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f user roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFUserRoleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFUserRoleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f user role.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFUserRole esfUserRole) {
		EntityCacheUtil.removeResult(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleImpl.class, esfUserRole.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfUserRole);
	}

	@Override
	public void clearCache(List<ESFUserRole> esfUserRoles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFUserRole esfUserRole : esfUserRoles) {
			EntityCacheUtil.removeResult(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserRoleImpl.class, esfUserRole.getPrimaryKey());

			clearUniqueFindersCache(esfUserRole);
		}
	}

	protected void cacheUniqueFindersCache(ESFUserRole esfUserRole) {
		if (esfUserRole.isNew()) {
			Object[] args = new Object[] {
					esfUserRole.getUuid(), esfUserRole.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfUserRole);
		}
		else {
			ESFUserRoleModelImpl esfUserRoleModelImpl = (ESFUserRoleModelImpl)esfUserRole;

			if ((esfUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserRole.getUuid(), esfUserRole.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfUserRole);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFUserRole esfUserRole) {
		ESFUserRoleModelImpl esfUserRoleModelImpl = (ESFUserRoleModelImpl)esfUserRole;

		Object[] args = new Object[] {
				esfUserRole.getUuid(), esfUserRole.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfUserRoleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfUserRoleModelImpl.getOriginalUuid(),
					esfUserRoleModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f user role with the primary key. Does not add the e s f user role to the database.
	 *
	 * @param esfUserRoleId the primary key for the new e s f user role
	 * @return the new e s f user role
	 */
	@Override
	public ESFUserRole create(long esfUserRoleId) {
		ESFUserRole esfUserRole = new ESFUserRoleImpl();

		esfUserRole.setNew(true);
		esfUserRole.setPrimaryKey(esfUserRoleId);

		String uuid = PortalUUIDUtil.generate();

		esfUserRole.setUuid(uuid);

		return esfUserRole;
	}

	/**
	 * Removes the e s f user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserRoleId the primary key of the e s f user role
	 * @return the e s f user role that was removed
	 * @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole remove(long esfUserRoleId)
		throws NoSuchUserRoleException, SystemException {
		return remove((Serializable)esfUserRoleId);
	}

	/**
	 * Removes the e s f user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f user role
	 * @return the e s f user role that was removed
	 * @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole remove(Serializable primaryKey)
		throws NoSuchUserRoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFUserRole esfUserRole = (ESFUserRole)session.get(ESFUserRoleImpl.class,
					primaryKey);

			if (esfUserRole == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfUserRole);
		}
		catch (NoSuchUserRoleException nsee) {
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
	protected ESFUserRole removeImpl(ESFUserRole esfUserRole)
		throws SystemException {
		esfUserRole = toUnwrappedModel(esfUserRole);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfUserRole)) {
				esfUserRole = (ESFUserRole)session.get(ESFUserRoleImpl.class,
						esfUserRole.getPrimaryKeyObj());
			}

			if (esfUserRole != null) {
				session.delete(esfUserRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfUserRole != null) {
			clearCache(esfUserRole);
		}

		return esfUserRole;
	}

	@Override
	public ESFUserRole updateImpl(it.ethica.esf.model.ESFUserRole esfUserRole)
		throws SystemException {
		esfUserRole = toUnwrappedModel(esfUserRole);

		boolean isNew = esfUserRole.isNew();

		ESFUserRoleModelImpl esfUserRoleModelImpl = (ESFUserRoleModelImpl)esfUserRole;

		if (Validator.isNull(esfUserRole.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfUserRole.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfUserRole.isNew()) {
				session.save(esfUserRole);

				esfUserRole.setNew(false);
			}
			else {
				session.merge(esfUserRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFUserRoleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserRoleModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfUserRoleModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserRoleModelImpl.getOriginalUuid(),
						esfUserRoleModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfUserRoleModelImpl.getUuid(),
						esfUserRoleModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserRoleModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { esfUserRoleModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((esfUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserRoleModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { esfUserRoleModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}

			if ((esfUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BDO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserRoleModelImpl.getOriginalIsBDO()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BDO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BDO,
					args);

				args = new Object[] { esfUserRoleModelImpl.getIsBDO() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BDO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BDO,
					args);
			}

			if ((esfUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserRoleModelImpl.getOriginalIsLEA()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEA,
					args);

				args = new Object[] { esfUserRoleModelImpl.getIsLEA() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEA,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserRoleImpl.class, esfUserRole.getPrimaryKey(), esfUserRole);

		clearUniqueFindersCache(esfUserRole);
		cacheUniqueFindersCache(esfUserRole);

		return esfUserRole;
	}

	protected ESFUserRole toUnwrappedModel(ESFUserRole esfUserRole) {
		if (esfUserRole instanceof ESFUserRoleImpl) {
			return esfUserRole;
		}

		ESFUserRoleImpl esfUserRoleImpl = new ESFUserRoleImpl();

		esfUserRoleImpl.setNew(esfUserRole.isNew());
		esfUserRoleImpl.setPrimaryKey(esfUserRole.getPrimaryKey());

		esfUserRoleImpl.setUuid(esfUserRole.getUuid());
		esfUserRoleImpl.setEsfUserRoleId(esfUserRole.getEsfUserRoleId());
		esfUserRoleImpl.setGroupId(esfUserRole.getGroupId());
		esfUserRoleImpl.setCompanyId(esfUserRole.getCompanyId());
		esfUserRoleImpl.setUserId(esfUserRole.getUserId());
		esfUserRoleImpl.setUserName(esfUserRole.getUserName());
		esfUserRoleImpl.setCreateDate(esfUserRole.getCreateDate());
		esfUserRoleImpl.setModifiedDate(esfUserRole.getModifiedDate());
		esfUserRoleImpl.setIsBDO(esfUserRole.isIsBDO());
		esfUserRoleImpl.setIsLEA(esfUserRole.isIsLEA());
		esfUserRoleImpl.setType(esfUserRole.getType());
		esfUserRoleImpl.setMaxUser(esfUserRole.getMaxUser());
		esfUserRoleImpl.setIsOrgAdmin(esfUserRole.isIsOrgAdmin());
		esfUserRoleImpl.setIsEditable(esfUserRole.isIsEditable());

		return esfUserRoleImpl;
	}

	/**
	 * Returns the e s f user role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user role
	 * @return the e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserRoleException, SystemException {
		ESFUserRole esfUserRole = fetchByPrimaryKey(primaryKey);

		if (esfUserRole == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfUserRole;
	}

	/**
	 * Returns the e s f user role with the primary key or throws a {@link it.ethica.esf.NoSuchUserRoleException} if it could not be found.
	 *
	 * @param esfUserRoleId the primary key of the e s f user role
	 * @return the e s f user role
	 * @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole findByPrimaryKey(long esfUserRoleId)
		throws NoSuchUserRoleException, SystemException {
		return findByPrimaryKey((Serializable)esfUserRoleId);
	}

	/**
	 * Returns the e s f user role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user role
	 * @return the e s f user role, or <code>null</code> if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFUserRole esfUserRole = (ESFUserRole)EntityCacheUtil.getResult(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserRoleImpl.class, primaryKey);

		if (esfUserRole == _nullESFUserRole) {
			return null;
		}

		if (esfUserRole == null) {
			Session session = null;

			try {
				session = openSession();

				esfUserRole = (ESFUserRole)session.get(ESFUserRoleImpl.class,
						primaryKey);

				if (esfUserRole != null) {
					cacheResult(esfUserRole);
				}
				else {
					EntityCacheUtil.putResult(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserRoleImpl.class, primaryKey, _nullESFUserRole);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFUserRoleModelImpl.ENTITY_CACHE_ENABLED,
					ESFUserRoleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfUserRole;
	}

	/**
	 * Returns the e s f user role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfUserRoleId the primary key of the e s f user role
	 * @return the e s f user role, or <code>null</code> if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchByPrimaryKey(long esfUserRoleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfUserRoleId);
	}

	/**
	 * Returns all the e s f user roles.
	 *
	 * @return the e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @return the range of e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> findAll(int start, int end,
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

		List<ESFUserRole> list = (List<ESFUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFUSERROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFUSERROLE;

				if (pagination) {
					sql = sql.concat(ESFUserRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserRole>(list);
				}
				else {
					list = (List<ESFUserRole>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f user roles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFUserRole esfUserRole : findAll()) {
			remove(esfUserRole);
		}
	}

	/**
	 * Returns the number of e s f user roles.
	 *
	 * @return the number of e s f user roles
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

				Query q = session.createQuery(_SQL_COUNT_ESFUSERROLE);

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
	 * Initializes the e s f user role persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFUserRole")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFUserRole>> listenersList = new ArrayList<ModelListener<ESFUserRole>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFUserRole>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFUserRoleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFUSERROLE = "SELECT esfUserRole FROM ESFUserRole esfUserRole";
	private static final String _SQL_SELECT_ESFUSERROLE_WHERE = "SELECT esfUserRole FROM ESFUserRole esfUserRole WHERE ";
	private static final String _SQL_COUNT_ESFUSERROLE = "SELECT COUNT(esfUserRole) FROM ESFUserRole esfUserRole";
	private static final String _SQL_COUNT_ESFUSERROLE_WHERE = "SELECT COUNT(esfUserRole) FROM ESFUserRole esfUserRole WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfUserRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFUserRole exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFUserRole exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFUserRolePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "type"
			});
	private static ESFUserRole _nullESFUserRole = new ESFUserRoleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFUserRole> toCacheModel() {
				return _nullESFUserRoleCacheModel;
			}
		};

	private static CacheModel<ESFUserRole> _nullESFUserRoleCacheModel = new CacheModel<ESFUserRole>() {
			@Override
			public ESFUserRole toEntityModel() {
				return _nullESFUserRole;
			}
		};
}