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

import it.ethica.esf.NoSuchAddressException;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.impl.ESFAddressImpl;
import it.ethica.esf.model.impl.ESFAddressModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFAddressPersistence
 * @see ESFAddressUtil
 * @generated
 */
public class ESFAddressPersistenceImpl extends BasePersistenceImpl<ESFAddress>
	implements ESFAddressPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFAddressUtil} to access the e s f address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFAddressImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, ESFAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, ESFAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, ESFAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, ESFAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFAddressModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f addresses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAddress> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f addresses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f addresses
	 * @param end the upper bound of the range of e s f addresses (not inclusive)
	 * @return the range of matching e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAddress> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f addresses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f addresses
	 * @param end the upper bound of the range of e s f addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAddress> findByUuid(String uuid, int start, int end,
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

		List<ESFAddress> list = (List<ESFAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFAddress esfAddress : list) {
				if (!Validator.equals(uuid, esfAddress.getUuid())) {
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

			query.append(_SQL_SELECT_ESFADDRESS_WHERE);

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
				query.append(ESFAddressModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFAddress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFAddress>(list);
				}
				else {
					list = (List<ESFAddress>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f address
	 * @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAddressException, SystemException {
		ESFAddress esfAddress = fetchByUuid_First(uuid, orderByComparator);

		if (esfAddress != null) {
			return esfAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressException(msg.toString());
	}

	/**
	 * Returns the first e s f address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f address, or <code>null</code> if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFAddress> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f address
	 * @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAddressException, SystemException {
		ESFAddress esfAddress = fetchByUuid_Last(uuid, orderByComparator);

		if (esfAddress != null) {
			return esfAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressException(msg.toString());
	}

	/**
	 * Returns the last e s f address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f address, or <code>null</code> if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFAddress> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f addresses before and after the current e s f address in the ordered set where uuid = &#63;.
	 *
	 * @param esfAddressId the primary key of the current e s f address
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f address
	 * @throws it.ethica.esf.NoSuchAddressException if a e s f address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress[] findByUuid_PrevAndNext(long esfAddressId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAddressException, SystemException {
		ESFAddress esfAddress = findByPrimaryKey(esfAddressId);

		Session session = null;

		try {
			session = openSession();

			ESFAddress[] array = new ESFAddressImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfAddress, uuid,
					orderByComparator, true);

			array[1] = esfAddress;

			array[2] = getByUuid_PrevAndNext(session, esfAddress, uuid,
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

	protected ESFAddress getByUuid_PrevAndNext(Session session,
		ESFAddress esfAddress, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFADDRESS_WHERE);

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
			query.append(ESFAddressModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f addresses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFAddress esfAddress : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfAddress);
		}
	}

	/**
	 * Returns the number of e s f addresses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f addresses
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

			query.append(_SQL_COUNT_ESFADDRESS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfAddress.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfAddress.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfAddress.uuid IS NULL OR esfAddress.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, ESFAddressImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFAddressModelImpl.UUID_COLUMN_BITMASK |
			ESFAddressModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f address where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchAddressException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f address
	 * @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress findByUUID_G(String uuid, long groupId)
		throws NoSuchAddressException, SystemException {
		ESFAddress esfAddress = fetchByUUID_G(uuid, groupId);

		if (esfAddress == null) {
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

			throw new NoSuchAddressException(msg.toString());
		}

		return esfAddress;
	}

	/**
	 * Returns the e s f address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f address, or <code>null</code> if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f address, or <code>null</code> if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFAddress) {
			ESFAddress esfAddress = (ESFAddress)result;

			if (!Validator.equals(uuid, esfAddress.getUuid()) ||
					(groupId != esfAddress.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFADDRESS_WHERE);

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

				List<ESFAddress> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFAddress esfAddress = list.get(0);

					result = esfAddress;

					cacheResult(esfAddress);

					if ((esfAddress.getUuid() == null) ||
							!esfAddress.getUuid().equals(uuid) ||
							(esfAddress.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfAddress);
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
			return (ESFAddress)result;
		}
	}

	/**
	 * Removes the e s f address where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f address that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress removeByUUID_G(String uuid, long groupId)
		throws NoSuchAddressException, SystemException {
		ESFAddress esfAddress = findByUUID_G(uuid, groupId);

		return remove(esfAddress);
	}

	/**
	 * Returns the number of e s f addresses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f addresses
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

			query.append(_SQL_COUNT_ESFADDRESS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfAddress.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfAddress.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfAddress.uuid IS NULL OR esfAddress.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfAddress.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, ESFAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, ESFAddressImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ESFAddressModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f addresses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAddress> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f addresses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f addresses
	 * @param end the upper bound of the range of e s f addresses (not inclusive)
	 * @return the range of matching e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAddress> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f addresses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f addresses
	 * @param end the upper bound of the range of e s f addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAddress> findByGroupId(long groupId, int start, int end,
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

		List<ESFAddress> list = (List<ESFAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFAddress esfAddress : list) {
				if ((groupId != esfAddress.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFADDRESS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFAddressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFAddress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFAddress>(list);
				}
				else {
					list = (List<ESFAddress>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f address in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f address
	 * @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressException, SystemException {
		ESFAddress esfAddress = fetchByGroupId_First(groupId, orderByComparator);

		if (esfAddress != null) {
			return esfAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressException(msg.toString());
	}

	/**
	 * Returns the first e s f address in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f address, or <code>null</code> if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFAddress> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f address in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f address
	 * @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAddressException, SystemException {
		ESFAddress esfAddress = fetchByGroupId_Last(groupId, orderByComparator);

		if (esfAddress != null) {
			return esfAddress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAddressException(msg.toString());
	}

	/**
	 * Returns the last e s f address in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f address, or <code>null</code> if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ESFAddress> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f addresses before and after the current e s f address in the ordered set where groupId = &#63;.
	 *
	 * @param esfAddressId the primary key of the current e s f address
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f address
	 * @throws it.ethica.esf.NoSuchAddressException if a e s f address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress[] findByGroupId_PrevAndNext(long esfAddressId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchAddressException, SystemException {
		ESFAddress esfAddress = findByPrimaryKey(esfAddressId);

		Session session = null;

		try {
			session = openSession();

			ESFAddress[] array = new ESFAddressImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, esfAddress, groupId,
					orderByComparator, true);

			array[1] = esfAddress;

			array[2] = getByGroupId_PrevAndNext(session, esfAddress, groupId,
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

	protected ESFAddress getByGroupId_PrevAndNext(Session session,
		ESFAddress esfAddress, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFADDRESS_WHERE);

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
			query.append(ESFAddressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfAddress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFAddress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f addresses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESFAddress esfAddress : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfAddress);
		}
	}

	/**
	 * Returns the number of e s f addresses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f addresses
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

			query.append(_SQL_COUNT_ESFADDRESS_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esfAddress.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_L_L = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, ESFAddressImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByL_L",
			new String[] { Double.class.getName(), Double.class.getName() },
			ESFAddressModelImpl.LONGITUDE_COLUMN_BITMASK |
			ESFAddressModelImpl.LATITUDE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_L_L = new FinderPath(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByL_L",
			new String[] { Double.class.getName(), Double.class.getName() });

	/**
	 * Returns the e s f address where longitude = &#63; and latitude = &#63; or throws a {@link it.ethica.esf.NoSuchAddressException} if it could not be found.
	 *
	 * @param longitude the longitude
	 * @param latitude the latitude
	 * @return the matching e s f address
	 * @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress findByL_L(double longitude, double latitude)
		throws NoSuchAddressException, SystemException {
		ESFAddress esfAddress = fetchByL_L(longitude, latitude);

		if (esfAddress == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("longitude=");
			msg.append(longitude);

			msg.append(", latitude=");
			msg.append(latitude);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAddressException(msg.toString());
		}

		return esfAddress;
	}

	/**
	 * Returns the e s f address where longitude = &#63; and latitude = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param longitude the longitude
	 * @param latitude the latitude
	 * @return the matching e s f address, or <code>null</code> if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress fetchByL_L(double longitude, double latitude)
		throws SystemException {
		return fetchByL_L(longitude, latitude, true);
	}

	/**
	 * Returns the e s f address where longitude = &#63; and latitude = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param longitude the longitude
	 * @param latitude the latitude
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f address, or <code>null</code> if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress fetchByL_L(double longitude, double latitude,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { longitude, latitude };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_L_L,
					finderArgs, this);
		}

		if (result instanceof ESFAddress) {
			ESFAddress esfAddress = (ESFAddress)result;

			if ((longitude != esfAddress.getLongitude()) ||
					(latitude != esfAddress.getLatitude())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFADDRESS_WHERE);

			query.append(_FINDER_COLUMN_L_L_LONGITUDE_2);

			query.append(_FINDER_COLUMN_L_L_LATITUDE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(longitude);

				qPos.add(latitude);

				List<ESFAddress> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_L_L,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFAddressPersistenceImpl.fetchByL_L(double, double, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFAddress esfAddress = list.get(0);

					result = esfAddress;

					cacheResult(esfAddress);

					if ((esfAddress.getLongitude() != longitude) ||
							(esfAddress.getLatitude() != latitude)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_L_L,
							finderArgs, esfAddress);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_L_L,
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
			return (ESFAddress)result;
		}
	}

	/**
	 * Removes the e s f address where longitude = &#63; and latitude = &#63; from the database.
	 *
	 * @param longitude the longitude
	 * @param latitude the latitude
	 * @return the e s f address that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress removeByL_L(double longitude, double latitude)
		throws NoSuchAddressException, SystemException {
		ESFAddress esfAddress = findByL_L(longitude, latitude);

		return remove(esfAddress);
	}

	/**
	 * Returns the number of e s f addresses where longitude = &#63; and latitude = &#63;.
	 *
	 * @param longitude the longitude
	 * @param latitude the latitude
	 * @return the number of matching e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByL_L(double longitude, double latitude)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_L_L;

		Object[] finderArgs = new Object[] { longitude, latitude };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFADDRESS_WHERE);

			query.append(_FINDER_COLUMN_L_L_LONGITUDE_2);

			query.append(_FINDER_COLUMN_L_L_LATITUDE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(longitude);

				qPos.add(latitude);

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

	private static final String _FINDER_COLUMN_L_L_LONGITUDE_2 = "esfAddress.longitude = ? AND ";
	private static final String _FINDER_COLUMN_L_L_LATITUDE_2 = "esfAddress.latitude = ?";

	public ESFAddressPersistenceImpl() {
		setModelClass(ESFAddress.class);
	}

	/**
	 * Caches the e s f address in the entity cache if it is enabled.
	 *
	 * @param esfAddress the e s f address
	 */
	@Override
	public void cacheResult(ESFAddress esfAddress) {
		EntityCacheUtil.putResult(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressImpl.class, esfAddress.getPrimaryKey(), esfAddress);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfAddress.getUuid(), esfAddress.getGroupId() },
			esfAddress);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_L_L,
			new Object[] { esfAddress.getLongitude(), esfAddress.getLatitude() },
			esfAddress);

		esfAddress.resetOriginalValues();
	}

	/**
	 * Caches the e s f addresses in the entity cache if it is enabled.
	 *
	 * @param esfAddresses the e s f addresses
	 */
	@Override
	public void cacheResult(List<ESFAddress> esfAddresses) {
		for (ESFAddress esfAddress : esfAddresses) {
			if (EntityCacheUtil.getResult(
						ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
						ESFAddressImpl.class, esfAddress.getPrimaryKey()) == null) {
				cacheResult(esfAddress);
			}
			else {
				esfAddress.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f addresses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFAddressImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFAddressImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f address.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFAddress esfAddress) {
		EntityCacheUtil.removeResult(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressImpl.class, esfAddress.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfAddress);
	}

	@Override
	public void clearCache(List<ESFAddress> esfAddresses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFAddress esfAddress : esfAddresses) {
			EntityCacheUtil.removeResult(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
				ESFAddressImpl.class, esfAddress.getPrimaryKey());

			clearUniqueFindersCache(esfAddress);
		}
	}

	protected void cacheUniqueFindersCache(ESFAddress esfAddress) {
		if (esfAddress.isNew()) {
			Object[] args = new Object[] {
					esfAddress.getUuid(), esfAddress.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfAddress);

			args = new Object[] {
					esfAddress.getLongitude(), esfAddress.getLatitude()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_L_L, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_L_L, args, esfAddress);
		}
		else {
			ESFAddressModelImpl esfAddressModelImpl = (ESFAddressModelImpl)esfAddress;

			if ((esfAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfAddress.getUuid(), esfAddress.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfAddress);
			}

			if ((esfAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_L_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfAddress.getLongitude(), esfAddress.getLatitude()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_L_L, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_L_L, args,
					esfAddress);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFAddress esfAddress) {
		ESFAddressModelImpl esfAddressModelImpl = (ESFAddressModelImpl)esfAddress;

		Object[] args = new Object[] {
				esfAddress.getUuid(), esfAddress.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfAddressModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfAddressModelImpl.getOriginalUuid(),
					esfAddressModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { esfAddress.getLongitude(), esfAddress.getLatitude() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_L_L, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_L_L, args);

		if ((esfAddressModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_L_L.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfAddressModelImpl.getOriginalLongitude(),
					esfAddressModelImpl.getOriginalLatitude()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_L_L, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_L_L, args);
		}
	}

	/**
	 * Creates a new e s f address with the primary key. Does not add the e s f address to the database.
	 *
	 * @param esfAddressId the primary key for the new e s f address
	 * @return the new e s f address
	 */
	@Override
	public ESFAddress create(long esfAddressId) {
		ESFAddress esfAddress = new ESFAddressImpl();

		esfAddress.setNew(true);
		esfAddress.setPrimaryKey(esfAddressId);

		String uuid = PortalUUIDUtil.generate();

		esfAddress.setUuid(uuid);

		return esfAddress;
	}

	/**
	 * Removes the e s f address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfAddressId the primary key of the e s f address
	 * @return the e s f address that was removed
	 * @throws it.ethica.esf.NoSuchAddressException if a e s f address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress remove(long esfAddressId)
		throws NoSuchAddressException, SystemException {
		return remove((Serializable)esfAddressId);
	}

	/**
	 * Removes the e s f address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f address
	 * @return the e s f address that was removed
	 * @throws it.ethica.esf.NoSuchAddressException if a e s f address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress remove(Serializable primaryKey)
		throws NoSuchAddressException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFAddress esfAddress = (ESFAddress)session.get(ESFAddressImpl.class,
					primaryKey);

			if (esfAddress == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfAddress);
		}
		catch (NoSuchAddressException nsee) {
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
	protected ESFAddress removeImpl(ESFAddress esfAddress)
		throws SystemException {
		esfAddress = toUnwrappedModel(esfAddress);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfAddress)) {
				esfAddress = (ESFAddress)session.get(ESFAddressImpl.class,
						esfAddress.getPrimaryKeyObj());
			}

			if (esfAddress != null) {
				session.delete(esfAddress);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfAddress != null) {
			clearCache(esfAddress);
		}

		return esfAddress;
	}

	@Override
	public ESFAddress updateImpl(it.ethica.esf.model.ESFAddress esfAddress)
		throws SystemException {
		esfAddress = toUnwrappedModel(esfAddress);

		boolean isNew = esfAddress.isNew();

		ESFAddressModelImpl esfAddressModelImpl = (ESFAddressModelImpl)esfAddress;

		if (Validator.isNull(esfAddress.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfAddress.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfAddress.isNew()) {
				session.save(esfAddress);

				esfAddress.setNew(false);
			}
			else {
				session.merge(esfAddress);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFAddressModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfAddressModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfAddressModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfAddressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfAddressModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { esfAddressModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
			ESFAddressImpl.class, esfAddress.getPrimaryKey(), esfAddress);

		clearUniqueFindersCache(esfAddress);
		cacheUniqueFindersCache(esfAddress);

		return esfAddress;
	}

	protected ESFAddress toUnwrappedModel(ESFAddress esfAddress) {
		if (esfAddress instanceof ESFAddressImpl) {
			return esfAddress;
		}

		ESFAddressImpl esfAddressImpl = new ESFAddressImpl();

		esfAddressImpl.setNew(esfAddress.isNew());
		esfAddressImpl.setPrimaryKey(esfAddress.getPrimaryKey());

		esfAddressImpl.setUuid(esfAddress.getUuid());
		esfAddressImpl.setEsfAddressId(esfAddress.getEsfAddressId());
		esfAddressImpl.setLongitude(esfAddress.getLongitude());
		esfAddressImpl.setLatitude(esfAddress.getLatitude());
		esfAddressImpl.setEsfCountryId(esfAddress.getEsfCountryId());
		esfAddressImpl.setEsfRegionId(esfAddress.getEsfRegionId());
		esfAddressImpl.setEsfProvinceId(esfAddress.getEsfProvinceId());
		esfAddressImpl.setEsfCityId(esfAddress.getEsfCityId());
		esfAddressImpl.setGroupId(esfAddress.getGroupId());
		esfAddressImpl.setType(esfAddress.getType());
		esfAddressImpl.setListTypeId(esfAddress.getListTypeId());

		return esfAddressImpl;
	}

	/**
	 * Returns the e s f address with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f address
	 * @return the e s f address
	 * @throws it.ethica.esf.NoSuchAddressException if a e s f address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressException, SystemException {
		ESFAddress esfAddress = fetchByPrimaryKey(primaryKey);

		if (esfAddress == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfAddress;
	}

	/**
	 * Returns the e s f address with the primary key or throws a {@link it.ethica.esf.NoSuchAddressException} if it could not be found.
	 *
	 * @param esfAddressId the primary key of the e s f address
	 * @return the e s f address
	 * @throws it.ethica.esf.NoSuchAddressException if a e s f address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress findByPrimaryKey(long esfAddressId)
		throws NoSuchAddressException, SystemException {
		return findByPrimaryKey((Serializable)esfAddressId);
	}

	/**
	 * Returns the e s f address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f address
	 * @return the e s f address, or <code>null</code> if a e s f address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFAddress esfAddress = (ESFAddress)EntityCacheUtil.getResult(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
				ESFAddressImpl.class, primaryKey);

		if (esfAddress == _nullESFAddress) {
			return null;
		}

		if (esfAddress == null) {
			Session session = null;

			try {
				session = openSession();

				esfAddress = (ESFAddress)session.get(ESFAddressImpl.class,
						primaryKey);

				if (esfAddress != null) {
					cacheResult(esfAddress);
				}
				else {
					EntityCacheUtil.putResult(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
						ESFAddressImpl.class, primaryKey, _nullESFAddress);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFAddressModelImpl.ENTITY_CACHE_ENABLED,
					ESFAddressImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfAddress;
	}

	/**
	 * Returns the e s f address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfAddressId the primary key of the e s f address
	 * @return the e s f address, or <code>null</code> if a e s f address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress fetchByPrimaryKey(long esfAddressId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfAddressId);
	}

	/**
	 * Returns all the e s f addresses.
	 *
	 * @return the e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAddress> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f addresses
	 * @param end the upper bound of the range of e s f addresses (not inclusive)
	 * @return the range of e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAddress> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f addresses
	 * @param end the upper bound of the range of e s f addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAddress> findAll(int start, int end,
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

		List<ESFAddress> list = (List<ESFAddress>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFADDRESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFADDRESS;

				if (pagination) {
					sql = sql.concat(ESFAddressModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFAddress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFAddress>(list);
				}
				else {
					list = (List<ESFAddress>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f addresses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFAddress esfAddress : findAll()) {
			remove(esfAddress);
		}
	}

	/**
	 * Returns the number of e s f addresses.
	 *
	 * @return the number of e s f addresses
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

				Query q = session.createQuery(_SQL_COUNT_ESFADDRESS);

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
	 * Initializes the e s f address persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFAddress")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFAddress>> listenersList = new ArrayList<ModelListener<ESFAddress>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFAddress>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFAddressImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFADDRESS = "SELECT esfAddress FROM ESFAddress esfAddress";
	private static final String _SQL_SELECT_ESFADDRESS_WHERE = "SELECT esfAddress FROM ESFAddress esfAddress WHERE ";
	private static final String _SQL_COUNT_ESFADDRESS = "SELECT COUNT(esfAddress) FROM ESFAddress esfAddress";
	private static final String _SQL_COUNT_ESFADDRESS_WHERE = "SELECT COUNT(esfAddress) FROM ESFAddress esfAddress WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfAddress.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFAddress exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFAddress exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFAddressPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "type"
			});
	private static ESFAddress _nullESFAddress = new ESFAddressImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFAddress> toCacheModel() {
				return _nullESFAddressCacheModel;
			}
		};

	private static CacheModel<ESFAddress> _nullESFAddressCacheModel = new CacheModel<ESFAddress>() {
			@Override
			public ESFAddress toEntityModel() {
				return _nullESFAddress;
			}
		};
}