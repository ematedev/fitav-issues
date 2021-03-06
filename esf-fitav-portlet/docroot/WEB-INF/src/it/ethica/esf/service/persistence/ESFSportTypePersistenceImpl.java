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
import com.liferay.portal.kernel.util.CharPool;
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

import it.ethica.esf.NoSuchSportTypeException;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.model.impl.ESFSportTypeImpl;
import it.ethica.esf.model.impl.ESFSportTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f sport type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFSportTypePersistence
 * @see ESFSportTypeUtil
 * @generated
 */
public class ESFSportTypePersistenceImpl extends BasePersistenceImpl<ESFSportType>
	implements ESFSportTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFSportTypeUtil} to access the e s f sport type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFSportTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFSportTypeModelImpl.UUID_COLUMN_BITMASK |
			ESFSportTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f sport types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f sport types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @return the range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f sport types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByUuid(String uuid, int start, int end,
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

		List<ESFSportType> list = (List<ESFSportType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSportType esfSportType : list) {
				if (!Validator.equals(uuid, esfSportType.getUuid())) {
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

			query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

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
				query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSportType>(list);
				}
				else {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f sport type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByUuid_First(uuid, orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f sport type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFSportType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f sport type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByUuid_Last(uuid, orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f sport type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFSportType> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f sport types before and after the current e s f sport type in the ordered set where uuid = &#63;.
	 *
	 * @param esfSportTypeId the primary key of the current e s f sport type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType[] findByUuid_PrevAndNext(long esfSportTypeId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = findByPrimaryKey(esfSportTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFSportType[] array = new ESFSportTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfSportType, uuid,
					orderByComparator, true);

			array[1] = esfSportType;

			array[2] = getByUuid_PrevAndNext(session, esfSportType, uuid,
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

	protected ESFSportType getByUuid_PrevAndNext(Session session,
		ESFSportType esfSportType, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

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
			query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfSportType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSportType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f sport types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFSportType esfSportType : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfSportType);
		}
	}

	/**
	 * Returns the number of e s f sport types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f sport types
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

			query.append(_SQL_COUNT_ESFSPORTTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfSportType.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfSportType.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfSportType.uuid IS NULL OR esfSportType.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFSportTypeModelImpl.UUID_COLUMN_BITMASK |
			ESFSportTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f sport type where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchSportTypeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByUUID_G(String uuid, long groupId)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByUUID_G(uuid, groupId);

		if (esfSportType == null) {
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

			throw new NoSuchSportTypeException(msg.toString());
		}

		return esfSportType;
	}

	/**
	 * Returns the e s f sport type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f sport type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFSportType) {
			ESFSportType esfSportType = (ESFSportType)result;

			if (!Validator.equals(uuid, esfSportType.getUuid()) ||
					(groupId != esfSportType.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

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

				List<ESFSportType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFSportType esfSportType = list.get(0);

					result = esfSportType;

					cacheResult(esfSportType);

					if ((esfSportType.getUuid() == null) ||
							!esfSportType.getUuid().equals(uuid) ||
							(esfSportType.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfSportType);
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
			return (ESFSportType)result;
		}
	}

	/**
	 * Removes the e s f sport type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f sport type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType removeByUUID_G(String uuid, long groupId)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = findByUUID_G(uuid, groupId);

		return remove(esfSportType);
	}

	/**
	 * Returns the number of e s f sport types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f sport types
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

			query.append(_SQL_COUNT_ESFSPORTTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfSportType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfSportType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfSportType.uuid IS NULL OR esfSportType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfSportType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFSportTypeModelImpl.UUID_COLUMN_BITMASK |
			ESFSportTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			ESFSportTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f sport types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f sport types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @return the range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f sport types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByUuid_C(String uuid, long companyId,
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

		List<ESFSportType> list = (List<ESFSportType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSportType esfSportType : list) {
				if (!Validator.equals(uuid, esfSportType.getUuid()) ||
						(companyId != esfSportType.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

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
				query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSportType>(list);
				}
				else {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f sport type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f sport type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFSportType> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f sport type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f sport type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFSportType> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f sport types before and after the current e s f sport type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfSportTypeId the primary key of the current e s f sport type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType[] findByUuid_C_PrevAndNext(long esfSportTypeId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = findByPrimaryKey(esfSportTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFSportType[] array = new ESFSportTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfSportType, uuid,
					companyId, orderByComparator, true);

			array[1] = esfSportType;

			array[2] = getByUuid_C_PrevAndNext(session, esfSportType, uuid,
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

	protected ESFSportType getByUuid_C_PrevAndNext(Session session,
		ESFSportType esfSportType, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

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
			query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfSportType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSportType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f sport types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFSportType esfSportType : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfSportType);
		}
	}

	/**
	 * Returns the number of e s f sport types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f sport types
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

			query.append(_SQL_COUNT_ESFSPORTTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfSportType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfSportType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfSportType.uuid IS NULL OR esfSportType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfSportType.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ESFSportTypeModelImpl.GROUPID_COLUMN_BITMASK |
			ESFSportTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f sport types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f sport types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @return the range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f sport types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByGroupId(long groupId, int start, int end,
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

		List<ESFSportType> list = (List<ESFSportType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSportType esfSportType : list) {
				if ((groupId != esfSportType.getGroupId())) {
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

			query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSportType>(list);
				}
				else {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f sport type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByGroupId_First(groupId,
				orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f sport type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFSportType> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f sport type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f sport type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ESFSportType> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f sport types before and after the current e s f sport type in the ordered set where groupId = &#63;.
	 *
	 * @param esfSportTypeId the primary key of the current e s f sport type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType[] findByGroupId_PrevAndNext(long esfSportTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = findByPrimaryKey(esfSportTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFSportType[] array = new ESFSportTypeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, esfSportType, groupId,
					orderByComparator, true);

			array[1] = esfSportType;

			array[2] = getByGroupId_PrevAndNext(session, esfSportType, groupId,
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

	protected ESFSportType getByGroupId_PrevAndNext(Session session,
		ESFSportType esfSportType, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

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
			query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfSportType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSportType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f sport types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ESFSportType esfSportType : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfSportType);
		}
	}

	/**
	 * Returns the number of e s f sport types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e s f sport types
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

			query.append(_SQL_COUNT_ESFSPORTTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "esfSportType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f sport types where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f sport types where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @return the range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f sport types where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
		finderArgs = new Object[] { name, start, end, orderByComparator };

		List<ESFSportType> list = (List<ESFSportType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSportType esfSportType : list) {
				if (!StringUtil.wildcardMatches(esfSportType.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSportType>(list);
				}
				else {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f sport type in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByName_First(name, orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f sport type in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFSportType> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f sport type in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByName_Last(name, orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f sport type in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ESFSportType> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f sport types before and after the current e s f sport type in the ordered set where name LIKE &#63;.
	 *
	 * @param esfSportTypeId the primary key of the current e s f sport type
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType[] findByName_PrevAndNext(long esfSportTypeId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = findByPrimaryKey(esfSportTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFSportType[] array = new ESFSportTypeImpl[3];

			array[0] = getByName_PrevAndNext(session, esfSportType, name,
					orderByComparator, true);

			array[1] = esfSportType;

			array[2] = getByName_PrevAndNext(session, esfSportType, name,
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

	protected ESFSportType getByName_PrevAndNext(Session session,
		ESFSportType esfSportType, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
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
			query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfSportType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSportType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f sport types where name LIKE &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (ESFSportType esfSportType : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfSportType);
		}
	}

	/**
	 * Returns the number of e s f sport types where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSPORTTYPE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "esfSportType.name LIKE NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "esfSportType.name LIKE ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(esfSportType.name IS NULL OR esfSportType.name LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NATIONAL = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNational",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONAL =
		new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNational",
			new String[] { Boolean.class.getName(), Boolean.class.getName() },
			ESFSportTypeModelImpl.NATIONAL_COLUMN_BITMASK |
			ESFSportTypeModelImpl.ISOLIMPIC_COLUMN_BITMASK |
			ESFSportTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NATIONAL = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNational",
			new String[] { Boolean.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the e s f sport types where national = &#63; and isOlimpic = &#63;.
	 *
	 * @param national the national
	 * @param isOlimpic the is olimpic
	 * @return the matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByNational(boolean national, boolean isOlimpic)
		throws SystemException {
		return findByNational(national, isOlimpic, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f sport types where national = &#63; and isOlimpic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param national the national
	 * @param isOlimpic the is olimpic
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @return the range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByNational(boolean national,
		boolean isOlimpic, int start, int end) throws SystemException {
		return findByNational(national, isOlimpic, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f sport types where national = &#63; and isOlimpic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param national the national
	 * @param isOlimpic the is olimpic
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByNational(boolean national,
		boolean isOlimpic, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONAL;
			finderArgs = new Object[] { national, isOlimpic };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NATIONAL;
			finderArgs = new Object[] {
					national, isOlimpic,
					
					start, end, orderByComparator
				};
		}

		List<ESFSportType> list = (List<ESFSportType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSportType esfSportType : list) {
				if ((national != esfSportType.getNational()) ||
						(isOlimpic != esfSportType.getIsOlimpic())) {
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

			query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

			query.append(_FINDER_COLUMN_NATIONAL_NATIONAL_2);

			query.append(_FINDER_COLUMN_NATIONAL_ISOLIMPIC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(national);

				qPos.add(isOlimpic);

				if (!pagination) {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSportType>(list);
				}
				else {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f sport type in the ordered set where national = &#63; and isOlimpic = &#63;.
	 *
	 * @param national the national
	 * @param isOlimpic the is olimpic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByNational_First(boolean national,
		boolean isOlimpic, OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByNational_First(national, isOlimpic,
				orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("national=");
		msg.append(national);

		msg.append(", isOlimpic=");
		msg.append(isOlimpic);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f sport type in the ordered set where national = &#63; and isOlimpic = &#63;.
	 *
	 * @param national the national
	 * @param isOlimpic the is olimpic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByNational_First(boolean national,
		boolean isOlimpic, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFSportType> list = findByNational(national, isOlimpic, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f sport type in the ordered set where national = &#63; and isOlimpic = &#63;.
	 *
	 * @param national the national
	 * @param isOlimpic the is olimpic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByNational_Last(boolean national,
		boolean isOlimpic, OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByNational_Last(national, isOlimpic,
				orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("national=");
		msg.append(national);

		msg.append(", isOlimpic=");
		msg.append(isOlimpic);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f sport type in the ordered set where national = &#63; and isOlimpic = &#63;.
	 *
	 * @param national the national
	 * @param isOlimpic the is olimpic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByNational_Last(boolean national,
		boolean isOlimpic, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByNational(national, isOlimpic);

		if (count == 0) {
			return null;
		}

		List<ESFSportType> list = findByNational(national, isOlimpic,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f sport types before and after the current e s f sport type in the ordered set where national = &#63; and isOlimpic = &#63;.
	 *
	 * @param esfSportTypeId the primary key of the current e s f sport type
	 * @param national the national
	 * @param isOlimpic the is olimpic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType[] findByNational_PrevAndNext(long esfSportTypeId,
		boolean national, boolean isOlimpic, OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = findByPrimaryKey(esfSportTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFSportType[] array = new ESFSportTypeImpl[3];

			array[0] = getByNational_PrevAndNext(session, esfSportType,
					national, isOlimpic, orderByComparator, true);

			array[1] = esfSportType;

			array[2] = getByNational_PrevAndNext(session, esfSportType,
					national, isOlimpic, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFSportType getByNational_PrevAndNext(Session session,
		ESFSportType esfSportType, boolean national, boolean isOlimpic,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

		query.append(_FINDER_COLUMN_NATIONAL_NATIONAL_2);

		query.append(_FINDER_COLUMN_NATIONAL_ISOLIMPIC_2);

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
			query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(national);

		qPos.add(isOlimpic);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfSportType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSportType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f sport types where national = &#63; and isOlimpic = &#63; from the database.
	 *
	 * @param national the national
	 * @param isOlimpic the is olimpic
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNational(boolean national, boolean isOlimpic)
		throws SystemException {
		for (ESFSportType esfSportType : findByNational(national, isOlimpic,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfSportType);
		}
	}

	/**
	 * Returns the number of e s f sport types where national = &#63; and isOlimpic = &#63;.
	 *
	 * @param national the national
	 * @param isOlimpic the is olimpic
	 * @return the number of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNational(boolean national, boolean isOlimpic)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NATIONAL;

		Object[] finderArgs = new Object[] { national, isOlimpic };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFSPORTTYPE_WHERE);

			query.append(_FINDER_COLUMN_NATIONAL_NATIONAL_2);

			query.append(_FINDER_COLUMN_NATIONAL_ISOLIMPIC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(national);

				qPos.add(isOlimpic);

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

	private static final String _FINDER_COLUMN_NATIONAL_NATIONAL_2 = "esfSportType.national = ? AND ";
	private static final String _FINDER_COLUMN_NATIONAL_ISOLIMPIC_2 = "esfSportType.isOlimpic = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISOLIMPIC =
		new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByisOlimpic",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISOLIMPIC =
		new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByisOlimpic",
			new String[] { Boolean.class.getName() },
			ESFSportTypeModelImpl.ISOLIMPIC_COLUMN_BITMASK |
			ESFSportTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISOLIMPIC = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByisOlimpic",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the e s f sport types where isOlimpic = &#63;.
	 *
	 * @param isOlimpic the is olimpic
	 * @return the matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByisOlimpic(boolean isOlimpic)
		throws SystemException {
		return findByisOlimpic(isOlimpic, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f sport types where isOlimpic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isOlimpic the is olimpic
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @return the range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByisOlimpic(boolean isOlimpic, int start,
		int end) throws SystemException {
		return findByisOlimpic(isOlimpic, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f sport types where isOlimpic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isOlimpic the is olimpic
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByisOlimpic(boolean isOlimpic, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISOLIMPIC;
			finderArgs = new Object[] { isOlimpic };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISOLIMPIC;
			finderArgs = new Object[] { isOlimpic, start, end, orderByComparator };
		}

		List<ESFSportType> list = (List<ESFSportType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSportType esfSportType : list) {
				if ((isOlimpic != esfSportType.getIsOlimpic())) {
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

			query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

			query.append(_FINDER_COLUMN_ISOLIMPIC_ISOLIMPIC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isOlimpic);

				if (!pagination) {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSportType>(list);
				}
				else {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f sport type in the ordered set where isOlimpic = &#63;.
	 *
	 * @param isOlimpic the is olimpic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByisOlimpic_First(boolean isOlimpic,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByisOlimpic_First(isOlimpic,
				orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isOlimpic=");
		msg.append(isOlimpic);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f sport type in the ordered set where isOlimpic = &#63;.
	 *
	 * @param isOlimpic the is olimpic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByisOlimpic_First(boolean isOlimpic,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFSportType> list = findByisOlimpic(isOlimpic, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f sport type in the ordered set where isOlimpic = &#63;.
	 *
	 * @param isOlimpic the is olimpic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByisOlimpic_Last(boolean isOlimpic,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByisOlimpic_Last(isOlimpic,
				orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isOlimpic=");
		msg.append(isOlimpic);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f sport type in the ordered set where isOlimpic = &#63;.
	 *
	 * @param isOlimpic the is olimpic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByisOlimpic_Last(boolean isOlimpic,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByisOlimpic(isOlimpic);

		if (count == 0) {
			return null;
		}

		List<ESFSportType> list = findByisOlimpic(isOlimpic, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f sport types before and after the current e s f sport type in the ordered set where isOlimpic = &#63;.
	 *
	 * @param esfSportTypeId the primary key of the current e s f sport type
	 * @param isOlimpic the is olimpic
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType[] findByisOlimpic_PrevAndNext(long esfSportTypeId,
		boolean isOlimpic, OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = findByPrimaryKey(esfSportTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFSportType[] array = new ESFSportTypeImpl[3];

			array[0] = getByisOlimpic_PrevAndNext(session, esfSportType,
					isOlimpic, orderByComparator, true);

			array[1] = esfSportType;

			array[2] = getByisOlimpic_PrevAndNext(session, esfSportType,
					isOlimpic, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFSportType getByisOlimpic_PrevAndNext(Session session,
		ESFSportType esfSportType, boolean isOlimpic,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

		query.append(_FINDER_COLUMN_ISOLIMPIC_ISOLIMPIC_2);

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
			query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isOlimpic);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfSportType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSportType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f sport types where isOlimpic = &#63; from the database.
	 *
	 * @param isOlimpic the is olimpic
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByisOlimpic(boolean isOlimpic) throws SystemException {
		for (ESFSportType esfSportType : findByisOlimpic(isOlimpic,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfSportType);
		}
	}

	/**
	 * Returns the number of e s f sport types where isOlimpic = &#63;.
	 *
	 * @param isOlimpic the is olimpic
	 * @return the number of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByisOlimpic(boolean isOlimpic) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISOLIMPIC;

		Object[] finderArgs = new Object[] { isOlimpic };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSPORTTYPE_WHERE);

			query.append(_FINDER_COLUMN_ISOLIMPIC_ISOLIMPIC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isOlimpic);

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

	private static final String _FINDER_COLUMN_ISOLIMPIC_ISOLIMPIC_2 = "esfSportType.isOlimpic = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODE = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, ESFSportTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] { String.class.getName() },
			ESFSportTypeModelImpl.CODE_COLUMN_BITMASK |
			ESFSportTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f sport types where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByCode(String code) throws SystemException {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f sport types where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @return the range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByCode(String code, int start, int end)
		throws SystemException {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f sport types where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findByCode(String code, int start, int end,
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

		List<ESFSportType> list = (List<ESFSportType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFSportType esfSportType : list) {
				if (!Validator.equals(code, esfSportType.getCode())) {
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

			query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

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
				query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSportType>(list);
				}
				else {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f sport type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByCode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByCode_First(code, orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f sport type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFSportType> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f sport type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByCode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByCode_Last(code, orderByComparator);

		if (esfSportType != null) {
			return esfSportType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSportTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f sport type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByCode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<ESFSportType> list = findByCode(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f sport types before and after the current e s f sport type in the ordered set where code = &#63;.
	 *
	 * @param esfSportTypeId the primary key of the current e s f sport type
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType[] findByCode_PrevAndNext(long esfSportTypeId,
		String code, OrderByComparator orderByComparator)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = findByPrimaryKey(esfSportTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFSportType[] array = new ESFSportTypeImpl[3];

			array[0] = getByCode_PrevAndNext(session, esfSportType, code,
					orderByComparator, true);

			array[1] = esfSportType;

			array[2] = getByCode_PrevAndNext(session, esfSportType, code,
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

	protected ESFSportType getByCode_PrevAndNext(Session session,
		ESFSportType esfSportType, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSPORTTYPE_WHERE);

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
			query.append(ESFSportTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfSportType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFSportType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f sport types where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCode(String code) throws SystemException {
		for (ESFSportType esfSportType : findByCode(code, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfSportType);
		}
	}

	/**
	 * Returns the number of e s f sport types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f sport types
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

			query.append(_SQL_COUNT_ESFSPORTTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfSportType.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfSportType.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfSportType.code IS NULL OR esfSportType.code = '')";

	public ESFSportTypePersistenceImpl() {
		setModelClass(ESFSportType.class);
	}

	/**
	 * Caches the e s f sport type in the entity cache if it is enabled.
	 *
	 * @param esfSportType the e s f sport type
	 */
	@Override
	public void cacheResult(ESFSportType esfSportType) {
		EntityCacheUtil.putResult(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeImpl.class, esfSportType.getPrimaryKey(), esfSportType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfSportType.getUuid(), esfSportType.getGroupId() },
			esfSportType);

		esfSportType.resetOriginalValues();
	}

	/**
	 * Caches the e s f sport types in the entity cache if it is enabled.
	 *
	 * @param esfSportTypes the e s f sport types
	 */
	@Override
	public void cacheResult(List<ESFSportType> esfSportTypes) {
		for (ESFSportType esfSportType : esfSportTypes) {
			if (EntityCacheUtil.getResult(
						ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFSportTypeImpl.class, esfSportType.getPrimaryKey()) == null) {
				cacheResult(esfSportType);
			}
			else {
				esfSportType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f sport types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFSportTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFSportTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f sport type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFSportType esfSportType) {
		EntityCacheUtil.removeResult(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeImpl.class, esfSportType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfSportType);
	}

	@Override
	public void clearCache(List<ESFSportType> esfSportTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFSportType esfSportType : esfSportTypes) {
			EntityCacheUtil.removeResult(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFSportTypeImpl.class, esfSportType.getPrimaryKey());

			clearUniqueFindersCache(esfSportType);
		}
	}

	protected void cacheUniqueFindersCache(ESFSportType esfSportType) {
		if (esfSportType.isNew()) {
			Object[] args = new Object[] {
					esfSportType.getUuid(), esfSportType.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfSportType);
		}
		else {
			ESFSportTypeModelImpl esfSportTypeModelImpl = (ESFSportTypeModelImpl)esfSportType;

			if ((esfSportTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSportType.getUuid(), esfSportType.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfSportType);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFSportType esfSportType) {
		ESFSportTypeModelImpl esfSportTypeModelImpl = (ESFSportTypeModelImpl)esfSportType;

		Object[] args = new Object[] {
				esfSportType.getUuid(), esfSportType.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfSportTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfSportTypeModelImpl.getOriginalUuid(),
					esfSportTypeModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f sport type with the primary key. Does not add the e s f sport type to the database.
	 *
	 * @param esfSportTypeId the primary key for the new e s f sport type
	 * @return the new e s f sport type
	 */
	@Override
	public ESFSportType create(long esfSportTypeId) {
		ESFSportType esfSportType = new ESFSportTypeImpl();

		esfSportType.setNew(true);
		esfSportType.setPrimaryKey(esfSportTypeId);

		String uuid = PortalUUIDUtil.generate();

		esfSportType.setUuid(uuid);

		return esfSportType;
	}

	/**
	 * Removes the e s f sport type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfSportTypeId the primary key of the e s f sport type
	 * @return the e s f sport type that was removed
	 * @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType remove(long esfSportTypeId)
		throws NoSuchSportTypeException, SystemException {
		return remove((Serializable)esfSportTypeId);
	}

	/**
	 * Removes the e s f sport type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f sport type
	 * @return the e s f sport type that was removed
	 * @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType remove(Serializable primaryKey)
		throws NoSuchSportTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFSportType esfSportType = (ESFSportType)session.get(ESFSportTypeImpl.class,
					primaryKey);

			if (esfSportType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSportTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfSportType);
		}
		catch (NoSuchSportTypeException nsee) {
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
	protected ESFSportType removeImpl(ESFSportType esfSportType)
		throws SystemException {
		esfSportType = toUnwrappedModel(esfSportType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfSportType)) {
				esfSportType = (ESFSportType)session.get(ESFSportTypeImpl.class,
						esfSportType.getPrimaryKeyObj());
			}

			if (esfSportType != null) {
				session.delete(esfSportType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfSportType != null) {
			clearCache(esfSportType);
		}

		return esfSportType;
	}

	@Override
	public ESFSportType updateImpl(
		it.ethica.esf.model.ESFSportType esfSportType)
		throws SystemException {
		esfSportType = toUnwrappedModel(esfSportType);

		boolean isNew = esfSportType.isNew();

		ESFSportTypeModelImpl esfSportTypeModelImpl = (ESFSportTypeModelImpl)esfSportType;

		if (Validator.isNull(esfSportType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfSportType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfSportType.isNew()) {
				session.save(esfSportType);

				esfSportType.setNew(false);
			}
			else {
				session.merge(esfSportType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFSportTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfSportTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSportTypeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfSportTypeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfSportTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSportTypeModelImpl.getOriginalUuid(),
						esfSportTypeModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfSportTypeModelImpl.getUuid(),
						esfSportTypeModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfSportTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSportTypeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { esfSportTypeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((esfSportTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSportTypeModelImpl.getOriginalNational(),
						esfSportTypeModelImpl.getOriginalIsOlimpic()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NATIONAL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONAL,
					args);

				args = new Object[] {
						esfSportTypeModelImpl.getNational(),
						esfSportTypeModelImpl.getIsOlimpic()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NATIONAL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NATIONAL,
					args);
			}

			if ((esfSportTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISOLIMPIC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSportTypeModelImpl.getOriginalIsOlimpic()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISOLIMPIC,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISOLIMPIC,
					args);

				args = new Object[] { esfSportTypeModelImpl.getIsOlimpic() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISOLIMPIC,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISOLIMPIC,
					args);
			}

			if ((esfSportTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfSportTypeModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);

				args = new Object[] { esfSportTypeModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFSportTypeImpl.class, esfSportType.getPrimaryKey(), esfSportType);

		clearUniqueFindersCache(esfSportType);
		cacheUniqueFindersCache(esfSportType);

		return esfSportType;
	}

	protected ESFSportType toUnwrappedModel(ESFSportType esfSportType) {
		if (esfSportType instanceof ESFSportTypeImpl) {
			return esfSportType;
		}

		ESFSportTypeImpl esfSportTypeImpl = new ESFSportTypeImpl();

		esfSportTypeImpl.setNew(esfSportType.isNew());
		esfSportTypeImpl.setPrimaryKey(esfSportType.getPrimaryKey());

		esfSportTypeImpl.setUuid(esfSportType.getUuid());
		esfSportTypeImpl.setEsfSportTypeId(esfSportType.getEsfSportTypeId());
		esfSportTypeImpl.setGroupId(esfSportType.getGroupId());
		esfSportTypeImpl.setCompanyId(esfSportType.getCompanyId());
		esfSportTypeImpl.setUserId(esfSportType.getUserId());
		esfSportTypeImpl.setUserName(esfSportType.getUserName());
		esfSportTypeImpl.setCreateDate(esfSportType.getCreateDate());
		esfSportTypeImpl.setModifiedDate(esfSportType.getModifiedDate());
		esfSportTypeImpl.setName(esfSportType.getName());
		esfSportTypeImpl.setDescription(esfSportType.getDescription());
		esfSportTypeImpl.setNational(esfSportType.isNational());
		esfSportTypeImpl.setCode(esfSportType.getCode());
		esfSportTypeImpl.setIsChangeCategory(esfSportType.isIsChangeCategory());
		esfSportTypeImpl.setIsOlimpic(esfSportType.isIsOlimpic());

		return esfSportTypeImpl;
	}

	/**
	 * Returns the e s f sport type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f sport type
	 * @return the e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSportTypeException, SystemException {
		ESFSportType esfSportType = fetchByPrimaryKey(primaryKey);

		if (esfSportType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSportTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfSportType;
	}

	/**
	 * Returns the e s f sport type with the primary key or throws a {@link it.ethica.esf.NoSuchSportTypeException} if it could not be found.
	 *
	 * @param esfSportTypeId the primary key of the e s f sport type
	 * @return the e s f sport type
	 * @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType findByPrimaryKey(long esfSportTypeId)
		throws NoSuchSportTypeException, SystemException {
		return findByPrimaryKey((Serializable)esfSportTypeId);
	}

	/**
	 * Returns the e s f sport type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f sport type
	 * @return the e s f sport type, or <code>null</code> if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFSportType esfSportType = (ESFSportType)EntityCacheUtil.getResult(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFSportTypeImpl.class, primaryKey);

		if (esfSportType == _nullESFSportType) {
			return null;
		}

		if (esfSportType == null) {
			Session session = null;

			try {
				session = openSession();

				esfSportType = (ESFSportType)session.get(ESFSportTypeImpl.class,
						primaryKey);

				if (esfSportType != null) {
					cacheResult(esfSportType);
				}
				else {
					EntityCacheUtil.putResult(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFSportTypeImpl.class, primaryKey, _nullESFSportType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFSportTypeModelImpl.ENTITY_CACHE_ENABLED,
					ESFSportTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfSportType;
	}

	/**
	 * Returns the e s f sport type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfSportTypeId the primary key of the e s f sport type
	 * @return the e s f sport type, or <code>null</code> if a e s f sport type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFSportType fetchByPrimaryKey(long esfSportTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfSportTypeId);
	}

	/**
	 * Returns all the e s f sport types.
	 *
	 * @return the e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f sport types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @return the range of e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f sport types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f sport types
	 * @param end the upper bound of the range of e s f sport types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f sport types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFSportType> findAll(int start, int end,
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

		List<ESFSportType> list = (List<ESFSportType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSPORTTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSPORTTYPE;

				if (pagination) {
					sql = sql.concat(ESFSportTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFSportType>(list);
				}
				else {
					list = (List<ESFSportType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f sport types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFSportType esfSportType : findAll()) {
			remove(esfSportType);
		}
	}

	/**
	 * Returns the number of e s f sport types.
	 *
	 * @return the number of e s f sport types
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

				Query q = session.createQuery(_SQL_COUNT_ESFSPORTTYPE);

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
	 * Initializes the e s f sport type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFSportType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFSportType>> listenersList = new ArrayList<ModelListener<ESFSportType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFSportType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFSportTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSPORTTYPE = "SELECT esfSportType FROM ESFSportType esfSportType";
	private static final String _SQL_SELECT_ESFSPORTTYPE_WHERE = "SELECT esfSportType FROM ESFSportType esfSportType WHERE ";
	private static final String _SQL_COUNT_ESFSPORTTYPE = "SELECT COUNT(esfSportType) FROM ESFSportType esfSportType";
	private static final String _SQL_COUNT_ESFSPORTTYPE_WHERE = "SELECT COUNT(esfSportType) FROM ESFSportType esfSportType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfSportType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFSportType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFSportType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFSportTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ESFSportType _nullESFSportType = new ESFSportTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFSportType> toCacheModel() {
				return _nullESFSportTypeCacheModel;
			}
		};

	private static CacheModel<ESFSportType> _nullESFSportTypeCacheModel = new CacheModel<ESFSportType>() {
			@Override
			public ESFSportType toEntityModel() {
				return _nullESFSportType;
			}
		};
}