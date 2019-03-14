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

import it.ethica.esf.NoSuchGunTypeException;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.model.impl.ESFGunTypeImpl;
import it.ethica.esf.model.impl.ESFGunTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f gun type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFGunTypePersistence
 * @see ESFGunTypeUtil
 * @generated
 */
public class ESFGunTypePersistenceImpl extends BasePersistenceImpl<ESFGunType>
	implements ESFGunTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFGunTypeUtil} to access the e s f gun type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFGunTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeModelImpl.FINDER_CACHE_ENABLED, ESFGunTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeModelImpl.FINDER_CACHE_ENABLED, ESFGunTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeModelImpl.FINDER_CACHE_ENABLED, ESFGunTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeModelImpl.FINDER_CACHE_ENABLED, ESFGunTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFGunTypeModelImpl.UUID_COLUMN_BITMASK |
			ESFGunTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f gun types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f gun types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunType> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f gun types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f gun types
	 * @param end the upper bound of the range of e s f gun types (not inclusive)
	 * @return the range of matching e s f gun types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunType> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f gun types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f gun types
	 * @param end the upper bound of the range of e s f gun types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f gun types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunType> findByUuid(String uuid, int start, int end,
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

		List<ESFGunType> list = (List<ESFGunType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFGunType esfGunType : list) {
				if (!Validator.equals(uuid, esfGunType.getUuid())) {
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

			query.append(_SQL_SELECT_ESFGUNTYPE_WHERE);

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
				query.append(ESFGunTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFGunType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGunType>(list);
				}
				else {
					list = (List<ESFGunType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f gun type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun type
	 * @throws it.ethica.esf.NoSuchGunTypeException if a matching e s f gun type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGunTypeException, SystemException {
		ESFGunType esfGunType = fetchByUuid_First(uuid, orderByComparator);

		if (esfGunType != null) {
			return esfGunType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f gun type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun type, or <code>null</code> if a matching e s f gun type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFGunType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f gun type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun type
	 * @throws it.ethica.esf.NoSuchGunTypeException if a matching e s f gun type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGunTypeException, SystemException {
		ESFGunType esfGunType = fetchByUuid_Last(uuid, orderByComparator);

		if (esfGunType != null) {
			return esfGunType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f gun type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun type, or <code>null</code> if a matching e s f gun type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFGunType> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f gun types before and after the current e s f gun type in the ordered set where uuid = &#63;.
	 *
	 * @param esfGunTypeId the primary key of the current e s f gun type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f gun type
	 * @throws it.ethica.esf.NoSuchGunTypeException if a e s f gun type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType[] findByUuid_PrevAndNext(long esfGunTypeId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGunTypeException, SystemException {
		ESFGunType esfGunType = findByPrimaryKey(esfGunTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFGunType[] array = new ESFGunTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfGunType, uuid,
					orderByComparator, true);

			array[1] = esfGunType;

			array[2] = getByUuid_PrevAndNext(session, esfGunType, uuid,
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

	protected ESFGunType getByUuid_PrevAndNext(Session session,
		ESFGunType esfGunType, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNTYPE_WHERE);

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
			query.append(ESFGunTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfGunType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFGunType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f gun types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFGunType esfGunType : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfGunType);
		}
	}

	/**
	 * Returns the number of e s f gun types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f gun types
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

			query.append(_SQL_COUNT_ESFGUNTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfGunType.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfGunType.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfGunType.uuid IS NULL OR esfGunType.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeModelImpl.FINDER_CACHE_ENABLED, ESFGunTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFGunTypeModelImpl.UUID_COLUMN_BITMASK |
			ESFGunTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f gun type where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchGunTypeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f gun type
	 * @throws it.ethica.esf.NoSuchGunTypeException if a matching e s f gun type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType findByUUID_G(String uuid, long groupId)
		throws NoSuchGunTypeException, SystemException {
		ESFGunType esfGunType = fetchByUUID_G(uuid, groupId);

		if (esfGunType == null) {
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

			throw new NoSuchGunTypeException(msg.toString());
		}

		return esfGunType;
	}

	/**
	 * Returns the e s f gun type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f gun type, or <code>null</code> if a matching e s f gun type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f gun type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f gun type, or <code>null</code> if a matching e s f gun type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFGunType) {
			ESFGunType esfGunType = (ESFGunType)result;

			if (!Validator.equals(uuid, esfGunType.getUuid()) ||
					(groupId != esfGunType.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFGUNTYPE_WHERE);

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

				List<ESFGunType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFGunType esfGunType = list.get(0);

					result = esfGunType;

					cacheResult(esfGunType);

					if ((esfGunType.getUuid() == null) ||
							!esfGunType.getUuid().equals(uuid) ||
							(esfGunType.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfGunType);
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
			return (ESFGunType)result;
		}
	}

	/**
	 * Removes the e s f gun type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f gun type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType removeByUUID_G(String uuid, long groupId)
		throws NoSuchGunTypeException, SystemException {
		ESFGunType esfGunType = findByUUID_G(uuid, groupId);

		return remove(esfGunType);
	}

	/**
	 * Returns the number of e s f gun types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f gun types
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

			query.append(_SQL_COUNT_ESFGUNTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfGunType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfGunType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfGunType.uuid IS NULL OR esfGunType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfGunType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeModelImpl.FINDER_CACHE_ENABLED, ESFGunTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeModelImpl.FINDER_CACHE_ENABLED, ESFGunTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFGunTypeModelImpl.UUID_COLUMN_BITMASK |
			ESFGunTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			ESFGunTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f gun types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f gun types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunType> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f gun types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f gun types
	 * @param end the upper bound of the range of e s f gun types (not inclusive)
	 * @return the range of matching e s f gun types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunType> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f gun types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f gun types
	 * @param end the upper bound of the range of e s f gun types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f gun types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunType> findByUuid_C(String uuid, long companyId,
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

		List<ESFGunType> list = (List<ESFGunType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFGunType esfGunType : list) {
				if (!Validator.equals(uuid, esfGunType.getUuid()) ||
						(companyId != esfGunType.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFGUNTYPE_WHERE);

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
				query.append(ESFGunTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFGunType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGunType>(list);
				}
				else {
					list = (List<ESFGunType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f gun type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun type
	 * @throws it.ethica.esf.NoSuchGunTypeException if a matching e s f gun type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchGunTypeException, SystemException {
		ESFGunType esfGunType = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfGunType != null) {
			return esfGunType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f gun type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun type, or <code>null</code> if a matching e s f gun type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFGunType> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f gun type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun type
	 * @throws it.ethica.esf.NoSuchGunTypeException if a matching e s f gun type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchGunTypeException, SystemException {
		ESFGunType esfGunType = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfGunType != null) {
			return esfGunType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f gun type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun type, or <code>null</code> if a matching e s f gun type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFGunType> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f gun types before and after the current e s f gun type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfGunTypeId the primary key of the current e s f gun type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f gun type
	 * @throws it.ethica.esf.NoSuchGunTypeException if a e s f gun type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType[] findByUuid_C_PrevAndNext(long esfGunTypeId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchGunTypeException, SystemException {
		ESFGunType esfGunType = findByPrimaryKey(esfGunTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFGunType[] array = new ESFGunTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfGunType, uuid,
					companyId, orderByComparator, true);

			array[1] = esfGunType;

			array[2] = getByUuid_C_PrevAndNext(session, esfGunType, uuid,
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

	protected ESFGunType getByUuid_C_PrevAndNext(Session session,
		ESFGunType esfGunType, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNTYPE_WHERE);

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
			query.append(ESFGunTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfGunType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFGunType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f gun types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFGunType esfGunType : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfGunType);
		}
	}

	/**
	 * Returns the number of e s f gun types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f gun types
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

			query.append(_SQL_COUNT_ESFGUNTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfGunType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfGunType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfGunType.uuid IS NULL OR esfGunType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfGunType.companyId = ?";

	public ESFGunTypePersistenceImpl() {
		setModelClass(ESFGunType.class);
	}

	/**
	 * Caches the e s f gun type in the entity cache if it is enabled.
	 *
	 * @param esfGunType the e s f gun type
	 */
	@Override
	public void cacheResult(ESFGunType esfGunType) {
		EntityCacheUtil.putResult(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeImpl.class, esfGunType.getPrimaryKey(), esfGunType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfGunType.getUuid(), esfGunType.getGroupId() },
			esfGunType);

		esfGunType.resetOriginalValues();
	}

	/**
	 * Caches the e s f gun types in the entity cache if it is enabled.
	 *
	 * @param esfGunTypes the e s f gun types
	 */
	@Override
	public void cacheResult(List<ESFGunType> esfGunTypes) {
		for (ESFGunType esfGunType : esfGunTypes) {
			if (EntityCacheUtil.getResult(
						ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFGunTypeImpl.class, esfGunType.getPrimaryKey()) == null) {
				cacheResult(esfGunType);
			}
			else {
				esfGunType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f gun types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFGunTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFGunTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f gun type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFGunType esfGunType) {
		EntityCacheUtil.removeResult(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeImpl.class, esfGunType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfGunType);
	}

	@Override
	public void clearCache(List<ESFGunType> esfGunTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFGunType esfGunType : esfGunTypes) {
			EntityCacheUtil.removeResult(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFGunTypeImpl.class, esfGunType.getPrimaryKey());

			clearUniqueFindersCache(esfGunType);
		}
	}

	protected void cacheUniqueFindersCache(ESFGunType esfGunType) {
		if (esfGunType.isNew()) {
			Object[] args = new Object[] {
					esfGunType.getUuid(), esfGunType.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfGunType);
		}
		else {
			ESFGunTypeModelImpl esfGunTypeModelImpl = (ESFGunTypeModelImpl)esfGunType;

			if ((esfGunTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGunType.getUuid(), esfGunType.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfGunType);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFGunType esfGunType) {
		ESFGunTypeModelImpl esfGunTypeModelImpl = (ESFGunTypeModelImpl)esfGunType;

		Object[] args = new Object[] {
				esfGunType.getUuid(), esfGunType.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfGunTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfGunTypeModelImpl.getOriginalUuid(),
					esfGunTypeModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f gun type with the primary key. Does not add the e s f gun type to the database.
	 *
	 * @param esfGunTypeId the primary key for the new e s f gun type
	 * @return the new e s f gun type
	 */
	@Override
	public ESFGunType create(long esfGunTypeId) {
		ESFGunType esfGunType = new ESFGunTypeImpl();

		esfGunType.setNew(true);
		esfGunType.setPrimaryKey(esfGunTypeId);

		String uuid = PortalUUIDUtil.generate();

		esfGunType.setUuid(uuid);

		return esfGunType;
	}

	/**
	 * Removes the e s f gun type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfGunTypeId the primary key of the e s f gun type
	 * @return the e s f gun type that was removed
	 * @throws it.ethica.esf.NoSuchGunTypeException if a e s f gun type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType remove(long esfGunTypeId)
		throws NoSuchGunTypeException, SystemException {
		return remove((Serializable)esfGunTypeId);
	}

	/**
	 * Removes the e s f gun type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f gun type
	 * @return the e s f gun type that was removed
	 * @throws it.ethica.esf.NoSuchGunTypeException if a e s f gun type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType remove(Serializable primaryKey)
		throws NoSuchGunTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFGunType esfGunType = (ESFGunType)session.get(ESFGunTypeImpl.class,
					primaryKey);

			if (esfGunType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGunTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfGunType);
		}
		catch (NoSuchGunTypeException nsee) {
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
	protected ESFGunType removeImpl(ESFGunType esfGunType)
		throws SystemException {
		esfGunType = toUnwrappedModel(esfGunType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfGunType)) {
				esfGunType = (ESFGunType)session.get(ESFGunTypeImpl.class,
						esfGunType.getPrimaryKeyObj());
			}

			if (esfGunType != null) {
				session.delete(esfGunType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfGunType != null) {
			clearCache(esfGunType);
		}

		return esfGunType;
	}

	@Override
	public ESFGunType updateImpl(it.ethica.esf.model.ESFGunType esfGunType)
		throws SystemException {
		esfGunType = toUnwrappedModel(esfGunType);

		boolean isNew = esfGunType.isNew();

		ESFGunTypeModelImpl esfGunTypeModelImpl = (ESFGunTypeModelImpl)esfGunType;

		if (Validator.isNull(esfGunType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfGunType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfGunType.isNew()) {
				session.save(esfGunType);

				esfGunType.setNew(false);
			}
			else {
				session.merge(esfGunType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFGunTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfGunTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGunTypeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfGunTypeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfGunTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGunTypeModelImpl.getOriginalUuid(),
						esfGunTypeModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfGunTypeModelImpl.getUuid(),
						esfGunTypeModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunTypeImpl.class, esfGunType.getPrimaryKey(), esfGunType);

		clearUniqueFindersCache(esfGunType);
		cacheUniqueFindersCache(esfGunType);

		return esfGunType;
	}

	protected ESFGunType toUnwrappedModel(ESFGunType esfGunType) {
		if (esfGunType instanceof ESFGunTypeImpl) {
			return esfGunType;
		}

		ESFGunTypeImpl esfGunTypeImpl = new ESFGunTypeImpl();

		esfGunTypeImpl.setNew(esfGunType.isNew());
		esfGunTypeImpl.setPrimaryKey(esfGunType.getPrimaryKey());

		esfGunTypeImpl.setUuid(esfGunType.getUuid());
		esfGunTypeImpl.setEsfGunTypeId(esfGunType.getEsfGunTypeId());
		esfGunTypeImpl.setGroupId(esfGunType.getGroupId());
		esfGunTypeImpl.setCompanyId(esfGunType.getCompanyId());
		esfGunTypeImpl.setUserId(esfGunType.getUserId());
		esfGunTypeImpl.setUserName(esfGunType.getUserName());
		esfGunTypeImpl.setCreateDate(esfGunType.getCreateDate());
		esfGunTypeImpl.setModifiedDate(esfGunType.getModifiedDate());
		esfGunTypeImpl.setName(esfGunType.getName());
		esfGunTypeImpl.setDescription(esfGunType.getDescription());

		return esfGunTypeImpl;
	}

	/**
	 * Returns the e s f gun type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f gun type
	 * @return the e s f gun type
	 * @throws it.ethica.esf.NoSuchGunTypeException if a e s f gun type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGunTypeException, SystemException {
		ESFGunType esfGunType = fetchByPrimaryKey(primaryKey);

		if (esfGunType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGunTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfGunType;
	}

	/**
	 * Returns the e s f gun type with the primary key or throws a {@link it.ethica.esf.NoSuchGunTypeException} if it could not be found.
	 *
	 * @param esfGunTypeId the primary key of the e s f gun type
	 * @return the e s f gun type
	 * @throws it.ethica.esf.NoSuchGunTypeException if a e s f gun type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType findByPrimaryKey(long esfGunTypeId)
		throws NoSuchGunTypeException, SystemException {
		return findByPrimaryKey((Serializable)esfGunTypeId);
	}

	/**
	 * Returns the e s f gun type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f gun type
	 * @return the e s f gun type, or <code>null</code> if a e s f gun type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFGunType esfGunType = (ESFGunType)EntityCacheUtil.getResult(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFGunTypeImpl.class, primaryKey);

		if (esfGunType == _nullESFGunType) {
			return null;
		}

		if (esfGunType == null) {
			Session session = null;

			try {
				session = openSession();

				esfGunType = (ESFGunType)session.get(ESFGunTypeImpl.class,
						primaryKey);

				if (esfGunType != null) {
					cacheResult(esfGunType);
				}
				else {
					EntityCacheUtil.putResult(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFGunTypeImpl.class, primaryKey, _nullESFGunType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFGunTypeModelImpl.ENTITY_CACHE_ENABLED,
					ESFGunTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfGunType;
	}

	/**
	 * Returns the e s f gun type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfGunTypeId the primary key of the e s f gun type
	 * @return the e s f gun type, or <code>null</code> if a e s f gun type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunType fetchByPrimaryKey(long esfGunTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfGunTypeId);
	}

	/**
	 * Returns all the e s f gun types.
	 *
	 * @return the e s f gun types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f gun types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f gun types
	 * @param end the upper bound of the range of e s f gun types (not inclusive)
	 * @return the range of e s f gun types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f gun types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f gun types
	 * @param end the upper bound of the range of e s f gun types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f gun types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunType> findAll(int start, int end,
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

		List<ESFGunType> list = (List<ESFGunType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFGUNTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFGUNTYPE;

				if (pagination) {
					sql = sql.concat(ESFGunTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFGunType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGunType>(list);
				}
				else {
					list = (List<ESFGunType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f gun types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFGunType esfGunType : findAll()) {
			remove(esfGunType);
		}
	}

	/**
	 * Returns the number of e s f gun types.
	 *
	 * @return the number of e s f gun types
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

				Query q = session.createQuery(_SQL_COUNT_ESFGUNTYPE);

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
	 * Initializes the e s f gun type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFGunType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFGunType>> listenersList = new ArrayList<ModelListener<ESFGunType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFGunType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFGunTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFGUNTYPE = "SELECT esfGunType FROM ESFGunType esfGunType";
	private static final String _SQL_SELECT_ESFGUNTYPE_WHERE = "SELECT esfGunType FROM ESFGunType esfGunType WHERE ";
	private static final String _SQL_COUNT_ESFGUNTYPE = "SELECT COUNT(esfGunType) FROM ESFGunType esfGunType";
	private static final String _SQL_COUNT_ESFGUNTYPE_WHERE = "SELECT COUNT(esfGunType) FROM ESFGunType esfGunType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfGunType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFGunType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFGunType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFGunTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFGunType _nullESFGunType = new ESFGunTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFGunType> toCacheModel() {
				return _nullESFGunTypeCacheModel;
			}
		};

	private static CacheModel<ESFGunType> _nullESFGunTypeCacheModel = new CacheModel<ESFGunType>() {
			@Override
			public ESFGunType toEntityModel() {
				return _nullESFGunType;
			}
		};
}