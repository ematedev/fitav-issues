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

import it.ethica.esf.NoSuchGunKindException;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.impl.ESFGunKindImpl;
import it.ethica.esf.model.impl.ESFGunKindModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f gun kind service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFGunKindPersistence
 * @see ESFGunKindUtil
 * @generated
 */
public class ESFGunKindPersistenceImpl extends BasePersistenceImpl<ESFGunKind>
	implements ESFGunKindPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFGunKindUtil} to access the e s f gun kind persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFGunKindImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, ESFGunKindImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, ESFGunKindImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, ESFGunKindImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, ESFGunKindImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFGunKindModelImpl.UUID_COLUMN_BITMASK |
			ESFGunKindModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f gun kinds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f gun kinds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f gun kinds
	 * @param end the upper bound of the range of e s f gun kinds (not inclusive)
	 * @return the range of matching e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f gun kinds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f gun kinds
	 * @param end the upper bound of the range of e s f gun kinds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findByUuid(String uuid, int start, int end,
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

		List<ESFGunKind> list = (List<ESFGunKind>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFGunKind esfGunKind : list) {
				if (!Validator.equals(uuid, esfGunKind.getUuid())) {
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

			query.append(_SQL_SELECT_ESFGUNKIND_WHERE);

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
				query.append(ESFGunKindModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFGunKind>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGunKind>(list);
				}
				else {
					list = (List<ESFGunKind>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f gun kind in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = fetchByUuid_First(uuid, orderByComparator);

		if (esfGunKind != null) {
			return esfGunKind;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunKindException(msg.toString());
	}

	/**
	 * Returns the first e s f gun kind in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFGunKind> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f gun kind in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = fetchByUuid_Last(uuid, orderByComparator);

		if (esfGunKind != null) {
			return esfGunKind;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunKindException(msg.toString());
	}

	/**
	 * Returns the last e s f gun kind in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFGunKind> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f gun kinds before and after the current e s f gun kind in the ordered set where uuid = &#63;.
	 *
	 * @param esfGunKindId the primary key of the current e s f gun kind
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind[] findByUuid_PrevAndNext(long esfGunKindId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = findByPrimaryKey(esfGunKindId);

		Session session = null;

		try {
			session = openSession();

			ESFGunKind[] array = new ESFGunKindImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfGunKind, uuid,
					orderByComparator, true);

			array[1] = esfGunKind;

			array[2] = getByUuid_PrevAndNext(session, esfGunKind, uuid,
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

	protected ESFGunKind getByUuid_PrevAndNext(Session session,
		ESFGunKind esfGunKind, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNKIND_WHERE);

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
			query.append(ESFGunKindModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfGunKind);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFGunKind> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f gun kinds where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFGunKind esfGunKind : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfGunKind);
		}
	}

	/**
	 * Returns the number of e s f gun kinds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f gun kinds
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

			query.append(_SQL_COUNT_ESFGUNKIND_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfGunKind.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfGunKind.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfGunKind.uuid IS NULL OR esfGunKind.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, ESFGunKindImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFGunKindModelImpl.UUID_COLUMN_BITMASK |
			ESFGunKindModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f gun kind where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchGunKindException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind findByUUID_G(String uuid, long groupId)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = fetchByUUID_G(uuid, groupId);

		if (esfGunKind == null) {
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

			throw new NoSuchGunKindException(msg.toString());
		}

		return esfGunKind;
	}

	/**
	 * Returns the e s f gun kind where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f gun kind where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFGunKind) {
			ESFGunKind esfGunKind = (ESFGunKind)result;

			if (!Validator.equals(uuid, esfGunKind.getUuid()) ||
					(groupId != esfGunKind.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFGUNKIND_WHERE);

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

				List<ESFGunKind> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFGunKind esfGunKind = list.get(0);

					result = esfGunKind;

					cacheResult(esfGunKind);

					if ((esfGunKind.getUuid() == null) ||
							!esfGunKind.getUuid().equals(uuid) ||
							(esfGunKind.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfGunKind);
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
			return (ESFGunKind)result;
		}
	}

	/**
	 * Removes the e s f gun kind where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f gun kind that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind removeByUUID_G(String uuid, long groupId)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = findByUUID_G(uuid, groupId);

		return remove(esfGunKind);
	}

	/**
	 * Returns the number of e s f gun kinds where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f gun kinds
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

			query.append(_SQL_COUNT_ESFGUNKIND_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfGunKind.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfGunKind.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfGunKind.uuid IS NULL OR esfGunKind.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfGunKind.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, ESFGunKindImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, ESFGunKindImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFGunKindModelImpl.UUID_COLUMN_BITMASK |
			ESFGunKindModelImpl.COMPANYID_COLUMN_BITMASK |
			ESFGunKindModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f gun kinds where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f gun kinds where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f gun kinds
	 * @param end the upper bound of the range of e s f gun kinds (not inclusive)
	 * @return the range of matching e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f gun kinds where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f gun kinds
	 * @param end the upper bound of the range of e s f gun kinds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findByUuid_C(String uuid, long companyId,
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

		List<ESFGunKind> list = (List<ESFGunKind>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFGunKind esfGunKind : list) {
				if (!Validator.equals(uuid, esfGunKind.getUuid()) ||
						(companyId != esfGunKind.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFGUNKIND_WHERE);

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
				query.append(ESFGunKindModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFGunKind>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGunKind>(list);
				}
				else {
					list = (List<ESFGunKind>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f gun kind in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfGunKind != null) {
			return esfGunKind;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunKindException(msg.toString());
	}

	/**
	 * Returns the first e s f gun kind in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFGunKind> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f gun kind in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfGunKind != null) {
			return esfGunKind;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunKindException(msg.toString());
	}

	/**
	 * Returns the last e s f gun kind in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFGunKind> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f gun kinds before and after the current e s f gun kind in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfGunKindId the primary key of the current e s f gun kind
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind[] findByUuid_C_PrevAndNext(long esfGunKindId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = findByPrimaryKey(esfGunKindId);

		Session session = null;

		try {
			session = openSession();

			ESFGunKind[] array = new ESFGunKindImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfGunKind, uuid,
					companyId, orderByComparator, true);

			array[1] = esfGunKind;

			array[2] = getByUuid_C_PrevAndNext(session, esfGunKind, uuid,
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

	protected ESFGunKind getByUuid_C_PrevAndNext(Session session,
		ESFGunKind esfGunKind, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNKIND_WHERE);

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
			query.append(ESFGunKindModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfGunKind);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFGunKind> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f gun kinds where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFGunKind esfGunKind : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfGunKind);
		}
	}

	/**
	 * Returns the number of e s f gun kinds where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f gun kinds
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

			query.append(_SQL_COUNT_ESFGUNKIND_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfGunKind.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfGunKind.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfGunKind.uuid IS NULL OR esfGunKind.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfGunKind.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFGUNTYPEID =
		new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, ESFGunKindImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfGunTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNTYPEID =
		new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, ESFGunKindImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEsfGunTypeId",
			new String[] { Long.class.getName() },
			ESFGunKindModelImpl.ESFGUNTYPEID_COLUMN_BITMASK |
			ESFGunKindModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFGUNTYPEID = new FinderPath(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEsfGunTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f gun kinds where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @return the matching e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findByEsfGunTypeId(long esfGunTypeId)
		throws SystemException {
		return findByEsfGunTypeId(esfGunTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f gun kinds where esfGunTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param start the lower bound of the range of e s f gun kinds
	 * @param end the upper bound of the range of e s f gun kinds (not inclusive)
	 * @return the range of matching e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findByEsfGunTypeId(long esfGunTypeId, int start,
		int end) throws SystemException {
		return findByEsfGunTypeId(esfGunTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f gun kinds where esfGunTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param start the lower bound of the range of e s f gun kinds
	 * @param end the upper bound of the range of e s f gun kinds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findByEsfGunTypeId(long esfGunTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNTYPEID;
			finderArgs = new Object[] { esfGunTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFGUNTYPEID;
			finderArgs = new Object[] {
					esfGunTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFGunKind> list = (List<ESFGunKind>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFGunKind esfGunKind : list) {
				if ((esfGunTypeId != esfGunKind.getEsfGunTypeId())) {
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

			query.append(_SQL_SELECT_ESFGUNKIND_WHERE);

			query.append(_FINDER_COLUMN_ESFGUNTYPEID_ESFGUNTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFGunKindModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunTypeId);

				if (!pagination) {
					list = (List<ESFGunKind>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGunKind>(list);
				}
				else {
					list = (List<ESFGunKind>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f gun kind in the ordered set where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind findByEsfGunTypeId_First(long esfGunTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = fetchByEsfGunTypeId_First(esfGunTypeId,
				orderByComparator);

		if (esfGunKind != null) {
			return esfGunKind;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunTypeId=");
		msg.append(esfGunTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunKindException(msg.toString());
	}

	/**
	 * Returns the first e s f gun kind in the ordered set where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchByEsfGunTypeId_First(long esfGunTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFGunKind> list = findByEsfGunTypeId(esfGunTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f gun kind in the ordered set where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind findByEsfGunTypeId_Last(long esfGunTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = fetchByEsfGunTypeId_Last(esfGunTypeId,
				orderByComparator);

		if (esfGunKind != null) {
			return esfGunKind;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfGunTypeId=");
		msg.append(esfGunTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGunKindException(msg.toString());
	}

	/**
	 * Returns the last e s f gun kind in the ordered set where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchByEsfGunTypeId_Last(long esfGunTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfGunTypeId(esfGunTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFGunKind> list = findByEsfGunTypeId(esfGunTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f gun kinds before and after the current e s f gun kind in the ordered set where esfGunTypeId = &#63;.
	 *
	 * @param esfGunKindId the primary key of the current e s f gun kind
	 * @param esfGunTypeId the esf gun type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind[] findByEsfGunTypeId_PrevAndNext(long esfGunKindId,
		long esfGunTypeId, OrderByComparator orderByComparator)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = findByPrimaryKey(esfGunKindId);

		Session session = null;

		try {
			session = openSession();

			ESFGunKind[] array = new ESFGunKindImpl[3];

			array[0] = getByEsfGunTypeId_PrevAndNext(session, esfGunKind,
					esfGunTypeId, orderByComparator, true);

			array[1] = esfGunKind;

			array[2] = getByEsfGunTypeId_PrevAndNext(session, esfGunKind,
					esfGunTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFGunKind getByEsfGunTypeId_PrevAndNext(Session session,
		ESFGunKind esfGunKind, long esfGunTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFGUNKIND_WHERE);

		query.append(_FINDER_COLUMN_ESFGUNTYPEID_ESFGUNTYPEID_2);

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
			query.append(ESFGunKindModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfGunTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfGunKind);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFGunKind> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f gun kinds where esfGunTypeId = &#63; from the database.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfGunTypeId(long esfGunTypeId)
		throws SystemException {
		for (ESFGunKind esfGunKind : findByEsfGunTypeId(esfGunTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfGunKind);
		}
	}

	/**
	 * Returns the number of e s f gun kinds where esfGunTypeId = &#63;.
	 *
	 * @param esfGunTypeId the esf gun type ID
	 * @return the number of matching e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfGunTypeId(long esfGunTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFGUNTYPEID;

		Object[] finderArgs = new Object[] { esfGunTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFGUNKIND_WHERE);

			query.append(_FINDER_COLUMN_ESFGUNTYPEID_ESFGUNTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfGunTypeId);

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

	private static final String _FINDER_COLUMN_ESFGUNTYPEID_ESFGUNTYPEID_2 = "esfGunKind.esfGunTypeId = ?";

	public ESFGunKindPersistenceImpl() {
		setModelClass(ESFGunKind.class);
	}

	/**
	 * Caches the e s f gun kind in the entity cache if it is enabled.
	 *
	 * @param esfGunKind the e s f gun kind
	 */
	@Override
	public void cacheResult(ESFGunKind esfGunKind) {
		EntityCacheUtil.putResult(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindImpl.class, esfGunKind.getPrimaryKey(), esfGunKind);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfGunKind.getUuid(), esfGunKind.getGroupId() },
			esfGunKind);

		esfGunKind.resetOriginalValues();
	}

	/**
	 * Caches the e s f gun kinds in the entity cache if it is enabled.
	 *
	 * @param esfGunKinds the e s f gun kinds
	 */
	@Override
	public void cacheResult(List<ESFGunKind> esfGunKinds) {
		for (ESFGunKind esfGunKind : esfGunKinds) {
			if (EntityCacheUtil.getResult(
						ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
						ESFGunKindImpl.class, esfGunKind.getPrimaryKey()) == null) {
				cacheResult(esfGunKind);
			}
			else {
				esfGunKind.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f gun kinds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFGunKindImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFGunKindImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f gun kind.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFGunKind esfGunKind) {
		EntityCacheUtil.removeResult(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindImpl.class, esfGunKind.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfGunKind);
	}

	@Override
	public void clearCache(List<ESFGunKind> esfGunKinds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFGunKind esfGunKind : esfGunKinds) {
			EntityCacheUtil.removeResult(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
				ESFGunKindImpl.class, esfGunKind.getPrimaryKey());

			clearUniqueFindersCache(esfGunKind);
		}
	}

	protected void cacheUniqueFindersCache(ESFGunKind esfGunKind) {
		if (esfGunKind.isNew()) {
			Object[] args = new Object[] {
					esfGunKind.getUuid(), esfGunKind.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfGunKind);
		}
		else {
			ESFGunKindModelImpl esfGunKindModelImpl = (ESFGunKindModelImpl)esfGunKind;

			if ((esfGunKindModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGunKind.getUuid(), esfGunKind.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfGunKind);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFGunKind esfGunKind) {
		ESFGunKindModelImpl esfGunKindModelImpl = (ESFGunKindModelImpl)esfGunKind;

		Object[] args = new Object[] {
				esfGunKind.getUuid(), esfGunKind.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfGunKindModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfGunKindModelImpl.getOriginalUuid(),
					esfGunKindModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f gun kind with the primary key. Does not add the e s f gun kind to the database.
	 *
	 * @param esfGunKindId the primary key for the new e s f gun kind
	 * @return the new e s f gun kind
	 */
	@Override
	public ESFGunKind create(long esfGunKindId) {
		ESFGunKind esfGunKind = new ESFGunKindImpl();

		esfGunKind.setNew(true);
		esfGunKind.setPrimaryKey(esfGunKindId);

		String uuid = PortalUUIDUtil.generate();

		esfGunKind.setUuid(uuid);

		return esfGunKind;
	}

	/**
	 * Removes the e s f gun kind with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfGunKindId the primary key of the e s f gun kind
	 * @return the e s f gun kind that was removed
	 * @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind remove(long esfGunKindId)
		throws NoSuchGunKindException, SystemException {
		return remove((Serializable)esfGunKindId);
	}

	/**
	 * Removes the e s f gun kind with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f gun kind
	 * @return the e s f gun kind that was removed
	 * @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind remove(Serializable primaryKey)
		throws NoSuchGunKindException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFGunKind esfGunKind = (ESFGunKind)session.get(ESFGunKindImpl.class,
					primaryKey);

			if (esfGunKind == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGunKindException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfGunKind);
		}
		catch (NoSuchGunKindException nsee) {
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
	protected ESFGunKind removeImpl(ESFGunKind esfGunKind)
		throws SystemException {
		esfGunKind = toUnwrappedModel(esfGunKind);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfGunKind)) {
				esfGunKind = (ESFGunKind)session.get(ESFGunKindImpl.class,
						esfGunKind.getPrimaryKeyObj());
			}

			if (esfGunKind != null) {
				session.delete(esfGunKind);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfGunKind != null) {
			clearCache(esfGunKind);
		}

		return esfGunKind;
	}

	@Override
	public ESFGunKind updateImpl(it.ethica.esf.model.ESFGunKind esfGunKind)
		throws SystemException {
		esfGunKind = toUnwrappedModel(esfGunKind);

		boolean isNew = esfGunKind.isNew();

		ESFGunKindModelImpl esfGunKindModelImpl = (ESFGunKindModelImpl)esfGunKind;

		if (Validator.isNull(esfGunKind.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfGunKind.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfGunKind.isNew()) {
				session.save(esfGunKind);

				esfGunKind.setNew(false);
			}
			else {
				session.merge(esfGunKind);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFGunKindModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfGunKindModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGunKindModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfGunKindModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfGunKindModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGunKindModelImpl.getOriginalUuid(),
						esfGunKindModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfGunKindModelImpl.getUuid(),
						esfGunKindModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfGunKindModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfGunKindModelImpl.getOriginalEsfGunTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFGUNTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNTYPEID,
					args);

				args = new Object[] { esfGunKindModelImpl.getEsfGunTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFGUNTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFGUNTYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
			ESFGunKindImpl.class, esfGunKind.getPrimaryKey(), esfGunKind);

		clearUniqueFindersCache(esfGunKind);
		cacheUniqueFindersCache(esfGunKind);

		return esfGunKind;
	}

	protected ESFGunKind toUnwrappedModel(ESFGunKind esfGunKind) {
		if (esfGunKind instanceof ESFGunKindImpl) {
			return esfGunKind;
		}

		ESFGunKindImpl esfGunKindImpl = new ESFGunKindImpl();

		esfGunKindImpl.setNew(esfGunKind.isNew());
		esfGunKindImpl.setPrimaryKey(esfGunKind.getPrimaryKey());

		esfGunKindImpl.setUuid(esfGunKind.getUuid());
		esfGunKindImpl.setEsfGunKindId(esfGunKind.getEsfGunKindId());
		esfGunKindImpl.setGroupId(esfGunKind.getGroupId());
		esfGunKindImpl.setCompanyId(esfGunKind.getCompanyId());
		esfGunKindImpl.setUserId(esfGunKind.getUserId());
		esfGunKindImpl.setUserName(esfGunKind.getUserName());
		esfGunKindImpl.setCreateDate(esfGunKind.getCreateDate());
		esfGunKindImpl.setModifiedDate(esfGunKind.getModifiedDate());
		esfGunKindImpl.setName(esfGunKind.getName());
		esfGunKindImpl.setDescription(esfGunKind.getDescription());
		esfGunKindImpl.setEsfGunTypeId(esfGunKind.getEsfGunTypeId());

		return esfGunKindImpl;
	}

	/**
	 * Returns the e s f gun kind with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f gun kind
	 * @return the e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGunKindException, SystemException {
		ESFGunKind esfGunKind = fetchByPrimaryKey(primaryKey);

		if (esfGunKind == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGunKindException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfGunKind;
	}

	/**
	 * Returns the e s f gun kind with the primary key or throws a {@link it.ethica.esf.NoSuchGunKindException} if it could not be found.
	 *
	 * @param esfGunKindId the primary key of the e s f gun kind
	 * @return the e s f gun kind
	 * @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind findByPrimaryKey(long esfGunKindId)
		throws NoSuchGunKindException, SystemException {
		return findByPrimaryKey((Serializable)esfGunKindId);
	}

	/**
	 * Returns the e s f gun kind with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f gun kind
	 * @return the e s f gun kind, or <code>null</code> if a e s f gun kind with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFGunKind esfGunKind = (ESFGunKind)EntityCacheUtil.getResult(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
				ESFGunKindImpl.class, primaryKey);

		if (esfGunKind == _nullESFGunKind) {
			return null;
		}

		if (esfGunKind == null) {
			Session session = null;

			try {
				session = openSession();

				esfGunKind = (ESFGunKind)session.get(ESFGunKindImpl.class,
						primaryKey);

				if (esfGunKind != null) {
					cacheResult(esfGunKind);
				}
				else {
					EntityCacheUtil.putResult(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
						ESFGunKindImpl.class, primaryKey, _nullESFGunKind);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFGunKindModelImpl.ENTITY_CACHE_ENABLED,
					ESFGunKindImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfGunKind;
	}

	/**
	 * Returns the e s f gun kind with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfGunKindId the primary key of the e s f gun kind
	 * @return the e s f gun kind, or <code>null</code> if a e s f gun kind with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchByPrimaryKey(long esfGunKindId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfGunKindId);
	}

	/**
	 * Returns all the e s f gun kinds.
	 *
	 * @return the e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f gun kinds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f gun kinds
	 * @param end the upper bound of the range of e s f gun kinds (not inclusive)
	 * @return the range of e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f gun kinds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f gun kinds
	 * @param end the upper bound of the range of e s f gun kinds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> findAll(int start, int end,
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

		List<ESFGunKind> list = (List<ESFGunKind>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFGUNKIND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFGUNKIND;

				if (pagination) {
					sql = sql.concat(ESFGunKindModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFGunKind>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFGunKind>(list);
				}
				else {
					list = (List<ESFGunKind>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f gun kinds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFGunKind esfGunKind : findAll()) {
			remove(esfGunKind);
		}
	}

	/**
	 * Returns the number of e s f gun kinds.
	 *
	 * @return the number of e s f gun kinds
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

				Query q = session.createQuery(_SQL_COUNT_ESFGUNKIND);

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
	 * Initializes the e s f gun kind persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFGunKind")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFGunKind>> listenersList = new ArrayList<ModelListener<ESFGunKind>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFGunKind>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFGunKindImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFGUNKIND = "SELECT esfGunKind FROM ESFGunKind esfGunKind";
	private static final String _SQL_SELECT_ESFGUNKIND_WHERE = "SELECT esfGunKind FROM ESFGunKind esfGunKind WHERE ";
	private static final String _SQL_COUNT_ESFGUNKIND = "SELECT COUNT(esfGunKind) FROM ESFGunKind esfGunKind";
	private static final String _SQL_COUNT_ESFGUNKIND_WHERE = "SELECT COUNT(esfGunKind) FROM ESFGunKind esfGunKind WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfGunKind.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFGunKind exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFGunKind exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFGunKindPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFGunKind _nullESFGunKind = new ESFGunKindImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFGunKind> toCacheModel() {
				return _nullESFGunKindCacheModel;
			}
		};

	private static CacheModel<ESFGunKind> _nullESFGunKindCacheModel = new CacheModel<ESFGunKind>() {
			@Override
			public ESFGunKind toEntityModel() {
				return _nullESFGunKind;
			}
		};
}