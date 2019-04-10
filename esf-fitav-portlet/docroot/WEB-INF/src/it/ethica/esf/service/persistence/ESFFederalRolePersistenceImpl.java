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

import it.ethica.esf.NoSuchFederalRoleException;
import it.ethica.esf.model.ESFFederalRole;
import it.ethica.esf.model.impl.ESFFederalRoleImpl;
import it.ethica.esf.model.impl.ESFFederalRoleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f federal role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFederalRolePersistence
 * @see ESFFederalRoleUtil
 * @generated
 */
public class ESFFederalRolePersistenceImpl extends BasePersistenceImpl<ESFFederalRole>
	implements ESFFederalRolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFFederalRoleUtil} to access the e s f federal role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFFederalRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFFederalRoleModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f federal roles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f federal roles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f federal roles
	 * @param end the upper bound of the range of e s f federal roles (not inclusive)
	 * @return the range of matching e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f federal roles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f federal roles
	 * @param end the upper bound of the range of e s f federal roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findByUuid(String uuid, int start, int end,
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

		List<ESFFederalRole> list = (List<ESFFederalRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFederalRole esfFederalRole : list) {
				if (!Validator.equals(uuid, esfFederalRole.getUuid())) {
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

			query.append(_SQL_SELECT_ESFFEDERALROLE_WHERE);

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
				query.append(ESFFederalRoleModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFFederalRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFederalRole>(list);
				}
				else {
					list = (List<ESFFederalRole>)QueryUtil.list(q,
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
	 * Returns the first e s f federal role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfFederalRole != null) {
			return esfFederalRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f federal role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role, or <code>null</code> if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFederalRole> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f federal role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = fetchByUuid_Last(uuid, orderByComparator);

		if (esfFederalRole != null) {
			return esfFederalRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f federal role in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role, or <code>null</code> if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFFederalRole> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f federal roles before and after the current e s f federal role in the ordered set where uuid = &#63;.
	 *
	 * @param esfFederalRoleId the primary key of the current e s f federal role
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole[] findByUuid_PrevAndNext(long esfFederalRoleId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = findByPrimaryKey(esfFederalRoleId);

		Session session = null;

		try {
			session = openSession();

			ESFFederalRole[] array = new ESFFederalRoleImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfFederalRole, uuid,
					orderByComparator, true);

			array[1] = esfFederalRole;

			array[2] = getByUuid_PrevAndNext(session, esfFederalRole, uuid,
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

	protected ESFFederalRole getByUuid_PrevAndNext(Session session,
		ESFFederalRole esfFederalRole, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFEDERALROLE_WHERE);

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
			query.append(ESFFederalRoleModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfFederalRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFederalRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f federal roles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFFederalRole esfFederalRole : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFederalRole);
		}
	}

	/**
	 * Returns the number of e s f federal roles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f federal roles
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

			query.append(_SQL_COUNT_ESFFEDERALROLE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfFederalRole.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfFederalRole.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfFederalRole.uuid IS NULL OR esfFederalRole.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFFederalRoleModelImpl.UUID_COLUMN_BITMASK |
			ESFFederalRoleModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f federal role where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchFederalRoleException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole findByUUID_G(String uuid, long groupId)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = fetchByUUID_G(uuid, groupId);

		if (esfFederalRole == null) {
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

			throw new NoSuchFederalRoleException(msg.toString());
		}

		return esfFederalRole;
	}

	/**
	 * Returns the e s f federal role where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f federal role, or <code>null</code> if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f federal role where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f federal role, or <code>null</code> if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFFederalRole) {
			ESFFederalRole esfFederalRole = (ESFFederalRole)result;

			if (!Validator.equals(uuid, esfFederalRole.getUuid()) ||
					(groupId != esfFederalRole.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFFEDERALROLE_WHERE);

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

				List<ESFFederalRole> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFFederalRole esfFederalRole = list.get(0);

					result = esfFederalRole;

					cacheResult(esfFederalRole);

					if ((esfFederalRole.getUuid() == null) ||
							!esfFederalRole.getUuid().equals(uuid) ||
							(esfFederalRole.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfFederalRole);
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
			return (ESFFederalRole)result;
		}
	}

	/**
	 * Removes the e s f federal role where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f federal role that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole removeByUUID_G(String uuid, long groupId)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = findByUUID_G(uuid, groupId);

		return remove(esfFederalRole);
	}

	/**
	 * Returns the number of e s f federal roles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f federal roles
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

			query.append(_SQL_COUNT_ESFFEDERALROLE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfFederalRole.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfFederalRole.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfFederalRole.uuid IS NULL OR esfFederalRole.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfFederalRole.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFFederalRoleModelImpl.UUID_COLUMN_BITMASK |
			ESFFederalRoleModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f federal roles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f federal roles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f federal roles
	 * @param end the upper bound of the range of e s f federal roles (not inclusive)
	 * @return the range of matching e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f federal roles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f federal roles
	 * @param end the upper bound of the range of e s f federal roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findByUuid_C(String uuid, long companyId,
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

		List<ESFFederalRole> list = (List<ESFFederalRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFederalRole esfFederalRole : list) {
				if (!Validator.equals(uuid, esfFederalRole.getUuid()) ||
						(companyId != esfFederalRole.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFFEDERALROLE_WHERE);

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
				query.append(ESFFederalRoleModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFFederalRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFederalRole>(list);
				}
				else {
					list = (List<ESFFederalRole>)QueryUtil.list(q,
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
	 * Returns the first e s f federal role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfFederalRole != null) {
			return esfFederalRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f federal role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role, or <code>null</code> if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFederalRole> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f federal role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfFederalRole != null) {
			return esfFederalRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f federal role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role, or <code>null</code> if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFFederalRole> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f federal roles before and after the current e s f federal role in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfFederalRoleId the primary key of the current e s f federal role
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole[] findByUuid_C_PrevAndNext(long esfFederalRoleId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = findByPrimaryKey(esfFederalRoleId);

		Session session = null;

		try {
			session = openSession();

			ESFFederalRole[] array = new ESFFederalRoleImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfFederalRole, uuid,
					companyId, orderByComparator, true);

			array[1] = esfFederalRole;

			array[2] = getByUuid_C_PrevAndNext(session, esfFederalRole, uuid,
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

	protected ESFFederalRole getByUuid_C_PrevAndNext(Session session,
		ESFFederalRole esfFederalRole, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFEDERALROLE_WHERE);

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
			query.append(ESFFederalRoleModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfFederalRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFederalRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f federal roles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFFederalRole esfFederalRole : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFederalRole);
		}
	}

	/**
	 * Returns the number of e s f federal roles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f federal roles
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

			query.append(_SQL_COUNT_ESFFEDERALROLE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfFederalRole.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfFederalRole.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfFederalRole.uuid IS NULL OR esfFederalRole.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfFederalRole.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] { String.class.getName() },
			ESFFederalRoleModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f federal roles where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findByCode(String code)
		throws SystemException {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f federal roles where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f federal roles
	 * @param end the upper bound of the range of e s f federal roles (not inclusive)
	 * @return the range of matching e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findByCode(String code, int start, int end)
		throws SystemException {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f federal roles where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f federal roles
	 * @param end the upper bound of the range of e s f federal roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findByCode(String code, int start, int end,
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

		List<ESFFederalRole> list = (List<ESFFederalRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFFederalRole esfFederalRole : list) {
				if (!Validator.equals(code, esfFederalRole.getCode())) {
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

			query.append(_SQL_SELECT_ESFFEDERALROLE_WHERE);

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
				query.append(ESFFederalRoleModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFFederalRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFederalRole>(list);
				}
				else {
					list = (List<ESFFederalRole>)QueryUtil.list(q,
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
	 * Returns the first e s f federal role in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole findByCode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = fetchByCode_First(code,
				orderByComparator);

		if (esfFederalRole != null) {
			return esfFederalRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f federal role in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f federal role, or <code>null</code> if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole fetchByCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFFederalRole> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f federal role in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole findByCode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = fetchByCode_Last(code, orderByComparator);

		if (esfFederalRole != null) {
			return esfFederalRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFederalRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f federal role in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f federal role, or <code>null</code> if a matching e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole fetchByCode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<ESFFederalRole> list = findByCode(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f federal roles before and after the current e s f federal role in the ordered set where code = &#63;.
	 *
	 * @param esfFederalRoleId the primary key of the current e s f federal role
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole[] findByCode_PrevAndNext(long esfFederalRoleId,
		String code, OrderByComparator orderByComparator)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = findByPrimaryKey(esfFederalRoleId);

		Session session = null;

		try {
			session = openSession();

			ESFFederalRole[] array = new ESFFederalRoleImpl[3];

			array[0] = getByCode_PrevAndNext(session, esfFederalRole, code,
					orderByComparator, true);

			array[1] = esfFederalRole;

			array[2] = getByCode_PrevAndNext(session, esfFederalRole, code,
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

	protected ESFFederalRole getByCode_PrevAndNext(Session session,
		ESFFederalRole esfFederalRole, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFFEDERALROLE_WHERE);

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
			query.append(ESFFederalRoleModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfFederalRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFFederalRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f federal roles where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCode(String code) throws SystemException {
		for (ESFFederalRole esfFederalRole : findByCode(code,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfFederalRole);
		}
	}

	/**
	 * Returns the number of e s f federal roles where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f federal roles
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

			query.append(_SQL_COUNT_ESFFEDERALROLE_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfFederalRole.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfFederalRole.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfFederalRole.code IS NULL OR esfFederalRole.code = '')";

	public ESFFederalRolePersistenceImpl() {
		setModelClass(ESFFederalRole.class);
	}

	/**
	 * Caches the e s f federal role in the entity cache if it is enabled.
	 *
	 * @param esfFederalRole the e s f federal role
	 */
	@Override
	public void cacheResult(ESFFederalRole esfFederalRole) {
		EntityCacheUtil.putResult(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleImpl.class, esfFederalRole.getPrimaryKey(),
			esfFederalRole);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfFederalRole.getUuid(), esfFederalRole.getGroupId() },
			esfFederalRole);

		esfFederalRole.resetOriginalValues();
	}

	/**
	 * Caches the e s f federal roles in the entity cache if it is enabled.
	 *
	 * @param esfFederalRoles the e s f federal roles
	 */
	@Override
	public void cacheResult(List<ESFFederalRole> esfFederalRoles) {
		for (ESFFederalRole esfFederalRole : esfFederalRoles) {
			if (EntityCacheUtil.getResult(
						ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
						ESFFederalRoleImpl.class, esfFederalRole.getPrimaryKey()) == null) {
				cacheResult(esfFederalRole);
			}
			else {
				esfFederalRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f federal roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFFederalRoleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFFederalRoleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f federal role.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFFederalRole esfFederalRole) {
		EntityCacheUtil.removeResult(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleImpl.class, esfFederalRole.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfFederalRole);
	}

	@Override
	public void clearCache(List<ESFFederalRole> esfFederalRoles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFFederalRole esfFederalRole : esfFederalRoles) {
			EntityCacheUtil.removeResult(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
				ESFFederalRoleImpl.class, esfFederalRole.getPrimaryKey());

			clearUniqueFindersCache(esfFederalRole);
		}
	}

	protected void cacheUniqueFindersCache(ESFFederalRole esfFederalRole) {
		if (esfFederalRole.isNew()) {
			Object[] args = new Object[] {
					esfFederalRole.getUuid(), esfFederalRole.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfFederalRole);
		}
		else {
			ESFFederalRoleModelImpl esfFederalRoleModelImpl = (ESFFederalRoleModelImpl)esfFederalRole;

			if ((esfFederalRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFederalRole.getUuid(), esfFederalRole.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfFederalRole);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFFederalRole esfFederalRole) {
		ESFFederalRoleModelImpl esfFederalRoleModelImpl = (ESFFederalRoleModelImpl)esfFederalRole;

		Object[] args = new Object[] {
				esfFederalRole.getUuid(), esfFederalRole.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfFederalRoleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfFederalRoleModelImpl.getOriginalUuid(),
					esfFederalRoleModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f federal role with the primary key. Does not add the e s f federal role to the database.
	 *
	 * @param esfFederalRoleId the primary key for the new e s f federal role
	 * @return the new e s f federal role
	 */
	@Override
	public ESFFederalRole create(long esfFederalRoleId) {
		ESFFederalRole esfFederalRole = new ESFFederalRoleImpl();

		esfFederalRole.setNew(true);
		esfFederalRole.setPrimaryKey(esfFederalRoleId);

		String uuid = PortalUUIDUtil.generate();

		esfFederalRole.setUuid(uuid);

		return esfFederalRole;
	}

	/**
	 * Removes the e s f federal role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfFederalRoleId the primary key of the e s f federal role
	 * @return the e s f federal role that was removed
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole remove(long esfFederalRoleId)
		throws NoSuchFederalRoleException, SystemException {
		return remove((Serializable)esfFederalRoleId);
	}

	/**
	 * Removes the e s f federal role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f federal role
	 * @return the e s f federal role that was removed
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole remove(Serializable primaryKey)
		throws NoSuchFederalRoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFFederalRole esfFederalRole = (ESFFederalRole)session.get(ESFFederalRoleImpl.class,
					primaryKey);

			if (esfFederalRole == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFederalRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfFederalRole);
		}
		catch (NoSuchFederalRoleException nsee) {
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
	protected ESFFederalRole removeImpl(ESFFederalRole esfFederalRole)
		throws SystemException {
		esfFederalRole = toUnwrappedModel(esfFederalRole);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfFederalRole)) {
				esfFederalRole = (ESFFederalRole)session.get(ESFFederalRoleImpl.class,
						esfFederalRole.getPrimaryKeyObj());
			}

			if (esfFederalRole != null) {
				session.delete(esfFederalRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfFederalRole != null) {
			clearCache(esfFederalRole);
		}

		return esfFederalRole;
	}

	@Override
	public ESFFederalRole updateImpl(
		it.ethica.esf.model.ESFFederalRole esfFederalRole)
		throws SystemException {
		esfFederalRole = toUnwrappedModel(esfFederalRole);

		boolean isNew = esfFederalRole.isNew();

		ESFFederalRoleModelImpl esfFederalRoleModelImpl = (ESFFederalRoleModelImpl)esfFederalRole;

		if (Validator.isNull(esfFederalRole.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfFederalRole.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfFederalRole.isNew()) {
				session.save(esfFederalRole);

				esfFederalRole.setNew(false);
			}
			else {
				session.merge(esfFederalRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFFederalRoleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfFederalRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFederalRoleModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfFederalRoleModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfFederalRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFederalRoleModelImpl.getOriginalUuid(),
						esfFederalRoleModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfFederalRoleModelImpl.getUuid(),
						esfFederalRoleModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfFederalRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfFederalRoleModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { esfFederalRoleModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFFederalRoleImpl.class, esfFederalRole.getPrimaryKey(),
			esfFederalRole);

		clearUniqueFindersCache(esfFederalRole);
		cacheUniqueFindersCache(esfFederalRole);

		return esfFederalRole;
	}

	protected ESFFederalRole toUnwrappedModel(ESFFederalRole esfFederalRole) {
		if (esfFederalRole instanceof ESFFederalRoleImpl) {
			return esfFederalRole;
		}

		ESFFederalRoleImpl esfFederalRoleImpl = new ESFFederalRoleImpl();

		esfFederalRoleImpl.setNew(esfFederalRole.isNew());
		esfFederalRoleImpl.setPrimaryKey(esfFederalRole.getPrimaryKey());

		esfFederalRoleImpl.setUuid(esfFederalRole.getUuid());
		esfFederalRoleImpl.setEsfFederalRoleId(esfFederalRole.getEsfFederalRoleId());
		esfFederalRoleImpl.setGroupId(esfFederalRole.getGroupId());
		esfFederalRoleImpl.setCompanyId(esfFederalRole.getCompanyId());
		esfFederalRoleImpl.setUserId(esfFederalRole.getUserId());
		esfFederalRoleImpl.setUserName(esfFederalRole.getUserName());
		esfFederalRoleImpl.setCreateDate(esfFederalRole.getCreateDate());
		esfFederalRoleImpl.setModifiedDate(esfFederalRole.getModifiedDate());
		esfFederalRoleImpl.setCode(esfFederalRole.getCode());
		esfFederalRoleImpl.setDescription(esfFederalRole.getDescription());
		esfFederalRoleImpl.setRegional(esfFederalRole.isRegional());
		esfFederalRoleImpl.setProvincial(esfFederalRole.isProvincial());

		return esfFederalRoleImpl;
	}

	/**
	 * Returns the e s f federal role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f federal role
	 * @return the e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFederalRoleException, SystemException {
		ESFFederalRole esfFederalRole = fetchByPrimaryKey(primaryKey);

		if (esfFederalRole == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFederalRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfFederalRole;
	}

	/**
	 * Returns the e s f federal role with the primary key or throws a {@link it.ethica.esf.NoSuchFederalRoleException} if it could not be found.
	 *
	 * @param esfFederalRoleId the primary key of the e s f federal role
	 * @return the e s f federal role
	 * @throws it.ethica.esf.NoSuchFederalRoleException if a e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole findByPrimaryKey(long esfFederalRoleId)
		throws NoSuchFederalRoleException, SystemException {
		return findByPrimaryKey((Serializable)esfFederalRoleId);
	}

	/**
	 * Returns the e s f federal role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f federal role
	 * @return the e s f federal role, or <code>null</code> if a e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFFederalRole esfFederalRole = (ESFFederalRole)EntityCacheUtil.getResult(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
				ESFFederalRoleImpl.class, primaryKey);

		if (esfFederalRole == _nullESFFederalRole) {
			return null;
		}

		if (esfFederalRole == null) {
			Session session = null;

			try {
				session = openSession();

				esfFederalRole = (ESFFederalRole)session.get(ESFFederalRoleImpl.class,
						primaryKey);

				if (esfFederalRole != null) {
					cacheResult(esfFederalRole);
				}
				else {
					EntityCacheUtil.putResult(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
						ESFFederalRoleImpl.class, primaryKey,
						_nullESFFederalRole);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
					ESFFederalRoleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfFederalRole;
	}

	/**
	 * Returns the e s f federal role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfFederalRoleId the primary key of the e s f federal role
	 * @return the e s f federal role, or <code>null</code> if a e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFFederalRole fetchByPrimaryKey(long esfFederalRoleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfFederalRoleId);
	}

	/**
	 * Returns all the e s f federal roles.
	 *
	 * @return the e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f federal roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f federal roles
	 * @param end the upper bound of the range of e s f federal roles (not inclusive)
	 * @return the range of e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f federal roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f federal roles
	 * @param end the upper bound of the range of e s f federal roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFFederalRole> findAll(int start, int end,
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

		List<ESFFederalRole> list = (List<ESFFederalRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFFEDERALROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFFEDERALROLE;

				if (pagination) {
					sql = sql.concat(ESFFederalRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFFederalRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFFederalRole>(list);
				}
				else {
					list = (List<ESFFederalRole>)QueryUtil.list(q,
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
	 * Removes all the e s f federal roles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFFederalRole esfFederalRole : findAll()) {
			remove(esfFederalRole);
		}
	}

	/**
	 * Returns the number of e s f federal roles.
	 *
	 * @return the number of e s f federal roles
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

				Query q = session.createQuery(_SQL_COUNT_ESFFEDERALROLE);

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
	 * Initializes the e s f federal role persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFFederalRole")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFFederalRole>> listenersList = new ArrayList<ModelListener<ESFFederalRole>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFFederalRole>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFFederalRoleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFFEDERALROLE = "SELECT esfFederalRole FROM ESFFederalRole esfFederalRole";
	private static final String _SQL_SELECT_ESFFEDERALROLE_WHERE = "SELECT esfFederalRole FROM ESFFederalRole esfFederalRole WHERE ";
	private static final String _SQL_COUNT_ESFFEDERALROLE = "SELECT COUNT(esfFederalRole) FROM ESFFederalRole esfFederalRole";
	private static final String _SQL_COUNT_ESFFEDERALROLE_WHERE = "SELECT COUNT(esfFederalRole) FROM ESFFederalRole esfFederalRole WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfFederalRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFFederalRole exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFFederalRole exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFFederalRolePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ESFFederalRole _nullESFFederalRole = new ESFFederalRoleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFFederalRole> toCacheModel() {
				return _nullESFFederalRoleCacheModel;
			}
		};

	private static CacheModel<ESFFederalRole> _nullESFFederalRoleCacheModel = new CacheModel<ESFFederalRole>() {
			@Override
			public ESFFederalRole toEntityModel() {
				return _nullESFFederalRole;
			}
		};
}