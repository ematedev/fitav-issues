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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import it.ethica.esf.NoSuchMatchException;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.impl.ESFMatchImpl;
import it.ethica.esf.model.impl.ESFMatchModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f match service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFMatchPersistence
 * @see ESFMatchUtil
 * @generated
 */
public class ESFMatchPersistenceImpl extends BasePersistenceImpl<ESFMatch>
	implements ESFMatchPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFMatchUtil} to access the e s f match persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFMatchImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFMatchModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f matchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f matchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByUuid(String uuid, int start, int end,
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

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if (!Validator.equals(uuid, esfMatch.getUuid())) {
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

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

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
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByUuid_First(uuid, orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatch> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByUuid_Last(uuid, orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findByUuid_PrevAndNext(long esfMatchId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfMatch, uuid,
					orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getByUuid_PrevAndNext(session, esfMatch, uuid,
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

	protected ESFMatch getByUuid_PrevAndNext(Session session,
		ESFMatch esfMatch, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFMatch esfMatch : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f matchs
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

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfMatch.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfMatch.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfMatch.uuid IS NULL OR esfMatch.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFMatchModelImpl.UUID_COLUMN_BITMASK |
			ESFMatchModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f match where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByUUID_G(String uuid, long groupId)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByUUID_G(uuid, groupId);

		if (esfMatch == null) {
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

			throw new NoSuchMatchException(msg.toString());
		}

		return esfMatch;
	}

	/**
	 * Returns the e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFMatch) {
			ESFMatch esfMatch = (ESFMatch)result;

			if (!Validator.equals(uuid, esfMatch.getUuid()) ||
					(groupId != esfMatch.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

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

				List<ESFMatch> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFMatch esfMatch = list.get(0);

					result = esfMatch;

					cacheResult(esfMatch);

					if ((esfMatch.getUuid() == null) ||
							!esfMatch.getUuid().equals(uuid) ||
							(esfMatch.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfMatch);
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
			return (ESFMatch)result;
		}
	}

	/**
	 * Removes the e s f match where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f match that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch removeByUUID_G(String uuid, long groupId)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByUUID_G(uuid, groupId);

		return remove(esfMatch);
	}

	/**
	 * Returns the number of e s f matchs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f matchs
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

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfMatch.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfMatch.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfMatch.uuid IS NULL OR esfMatch.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfMatch.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFMatchModelImpl.UUID_COLUMN_BITMASK |
			ESFMatchModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByUuid_C(String uuid, long companyId, int start,
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

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if (!Validator.equals(uuid, esfMatch.getUuid()) ||
						(companyId != esfMatch.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

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
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatch> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findByUuid_C_PrevAndNext(long esfMatchId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfMatch, uuid,
					companyId, orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getByUuid_C_PrevAndNext(session, esfMatch, uuid,
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

	protected ESFMatch getByUuid_C_PrevAndNext(Session session,
		ESFMatch esfMatch, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFMatch esfMatch : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f matchs
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

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfMatch.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfMatch.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfMatch.uuid IS NULL OR esfMatch.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfMatch.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MATCHTYPEID =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMatchTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHTYPEID =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMatchTypeId",
			new String[] { Long.class.getName() },
			ESFMatchModelImpl.ESFMATCHTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MATCHTYPEID = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMatchTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f matchs where esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchTypeId the esf match type ID
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByMatchTypeId(long esfMatchTypeId)
		throws SystemException {
		return findByMatchTypeId(esfMatchTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f matchs where esfMatchTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchTypeId the esf match type ID
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByMatchTypeId(long esfMatchTypeId, int start,
		int end) throws SystemException {
		return findByMatchTypeId(esfMatchTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where esfMatchTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchTypeId the esf match type ID
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByMatchTypeId(long esfMatchTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHTYPEID;
			finderArgs = new Object[] { esfMatchTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MATCHTYPEID;
			finderArgs = new Object[] {
					esfMatchTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if ((esfMatchTypeId != esfMatch.getEsfMatchTypeId())) {
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

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_MATCHTYPEID_ESFMATCHTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchTypeId);

				if (!pagination) {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchTypeId the esf match type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByMatchTypeId_First(long esfMatchTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByMatchTypeId_First(esfMatchTypeId,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchTypeId the esf match type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByMatchTypeId_First(long esfMatchTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatch> list = findByMatchTypeId(esfMatchTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchTypeId the esf match type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByMatchTypeId_Last(long esfMatchTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByMatchTypeId_Last(esfMatchTypeId,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchTypeId the esf match type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByMatchTypeId_Last(long esfMatchTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMatchTypeId(esfMatchTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findByMatchTypeId(esfMatchTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param esfMatchTypeId the esf match type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findByMatchTypeId_PrevAndNext(long esfMatchId,
		long esfMatchTypeId, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getByMatchTypeId_PrevAndNext(session, esfMatch,
					esfMatchTypeId, orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getByMatchTypeId_PrevAndNext(session, esfMatch,
					esfMatchTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFMatch getByMatchTypeId_PrevAndNext(Session session,
		ESFMatch esfMatch, long esfMatchTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

		query.append(_FINDER_COLUMN_MATCHTYPEID_ESFMATCHTYPEID_2);

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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where esfMatchTypeId = &#63; from the database.
	 *
	 * @param esfMatchTypeId the esf match type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMatchTypeId(long esfMatchTypeId)
		throws SystemException {
		for (ESFMatch esfMatch : findByMatchTypeId(esfMatchTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchTypeId the esf match type ID
	 * @return the number of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMatchTypeId(long esfMatchTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MATCHTYPEID;

		Object[] finderArgs = new Object[] { esfMatchTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_MATCHTYPEID_ESFMATCHTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchTypeId);

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

	private static final String _FINDER_COLUMN_MATCHTYPEID_ESFMATCHTYPEID_2 = "esfMatch.esfMatchTypeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMatchStartDate_T_A_D_N",
			new String[] {
				Date.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			},
			ESFMatchModelImpl.STARTDATE_COLUMN_BITMASK |
			ESFMatchModelImpl.ESFMATCHTYPEID_COLUMN_BITMASK |
			ESFMatchModelImpl.ESFASSOCIATIONID_COLUMN_BITMASK |
			ESFMatchModelImpl.DESCRIPTION_COLUMN_BITMASK |
			ESFMatchModelImpl.ISNATIONAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MATCHSTARTDATE_T_A_D_N = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMatchStartDate_T_A_D_N",
			new String[] {
				Date.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			});

	/**
	 * Returns the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	 *
	 * @param startDate the start date
	 * @param esfMatchTypeId the esf match type ID
	 * @param esfAssociationId the esf association ID
	 * @param description the description
	 * @param isNational the is national
	 * @return the matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByMatchStartDate_T_A_D_N(Date startDate,
		long esfMatchTypeId, long esfAssociationId, long description,
		boolean isNational) throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByMatchStartDate_T_A_D_N(startDate,
				esfMatchTypeId, esfAssociationId, description, isNational);

		if (esfMatch == null) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("startDate=");
			msg.append(startDate);

			msg.append(", esfMatchTypeId=");
			msg.append(esfMatchTypeId);

			msg.append(", esfAssociationId=");
			msg.append(esfAssociationId);

			msg.append(", description=");
			msg.append(description);

			msg.append(", isNational=");
			msg.append(isNational);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMatchException(msg.toString());
		}

		return esfMatch;
	}

	/**
	 * Returns the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param startDate the start date
	 * @param esfMatchTypeId the esf match type ID
	 * @param esfAssociationId the esf association ID
	 * @param description the description
	 * @param isNational the is national
	 * @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByMatchStartDate_T_A_D_N(Date startDate,
		long esfMatchTypeId, long esfAssociationId, long description,
		boolean isNational) throws SystemException {
		return fetchByMatchStartDate_T_A_D_N(startDate, esfMatchTypeId,
			esfAssociationId, description, isNational, true);
	}

	/**
	 * Returns the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param startDate the start date
	 * @param esfMatchTypeId the esf match type ID
	 * @param esfAssociationId the esf association ID
	 * @param description the description
	 * @param isNational the is national
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByMatchStartDate_T_A_D_N(Date startDate,
		long esfMatchTypeId, long esfAssociationId, long description,
		boolean isNational, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				startDate, esfMatchTypeId, esfAssociationId, description,
				isNational
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N,
					finderArgs, this);
		}

		if (result instanceof ESFMatch) {
			ESFMatch esfMatch = (ESFMatch)result;

			if (!Validator.equals(startDate, esfMatch.getStartDate()) ||
					(esfMatchTypeId != esfMatch.getEsfMatchTypeId()) ||
					(esfAssociationId != esfMatch.getEsfAssociationId()) ||
					(description != esfMatch.getDescription()) ||
					(isNational != esfMatch.getIsNational())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_ESFMATCHTYPEID_2);

			query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_ESFASSOCIATIONID_2);

			query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_DESCRIPTION_2);

			query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_ISNATIONAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(esfMatchTypeId);

				qPos.add(esfAssociationId);

				qPos.add(description);

				qPos.add(isNational);

				List<ESFMatch> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFMatchPersistenceImpl.fetchByMatchStartDate_T_A_D_N(Date, long, long, long, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFMatch esfMatch = list.get(0);

					result = esfMatch;

					cacheResult(esfMatch);

					if ((esfMatch.getStartDate() == null) ||
							!esfMatch.getStartDate().equals(startDate) ||
							(esfMatch.getEsfMatchTypeId() != esfMatchTypeId) ||
							(esfMatch.getEsfAssociationId() != esfAssociationId) ||
							(esfMatch.getDescription() != description) ||
							(esfMatch.getIsNational() != isNational)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N,
							finderArgs, esfMatch);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N,
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
			return (ESFMatch)result;
		}
	}

	/**
	 * Removes the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param esfMatchTypeId the esf match type ID
	 * @param esfAssociationId the esf association ID
	 * @param description the description
	 * @param isNational the is national
	 * @return the e s f match that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch removeByMatchStartDate_T_A_D_N(Date startDate,
		long esfMatchTypeId, long esfAssociationId, long description,
		boolean isNational) throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByMatchStartDate_T_A_D_N(startDate,
				esfMatchTypeId, esfAssociationId, description, isNational);

		return remove(esfMatch);
	}

	/**
	 * Returns the number of e s f matchs where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63;.
	 *
	 * @param startDate the start date
	 * @param esfMatchTypeId the esf match type ID
	 * @param esfAssociationId the esf association ID
	 * @param description the description
	 * @param isNational the is national
	 * @return the number of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMatchStartDate_T_A_D_N(Date startDate,
		long esfMatchTypeId, long esfAssociationId, long description,
		boolean isNational) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MATCHSTARTDATE_T_A_D_N;

		Object[] finderArgs = new Object[] {
				startDate, esfMatchTypeId, esfAssociationId, description,
				isNational
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_ESFMATCHTYPEID_2);

			query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_ESFASSOCIATIONID_2);

			query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_DESCRIPTION_2);

			query.append(_FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_ISNATIONAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(esfMatchTypeId);

				qPos.add(esfAssociationId);

				qPos.add(description);

				qPos.add(isNational);

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

	private static final String _FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_STARTDATE_1 =
		"esfMatch.startDate IS NULL AND ";
	private static final String _FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_STARTDATE_2 =
		"esfMatch.startDate = ? AND ";
	private static final String _FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_ESFMATCHTYPEID_2 =
		"esfMatch.esfMatchTypeId = ? AND ";
	private static final String _FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_ESFASSOCIATIONID_2 =
		"esfMatch.esfAssociationId = ? AND ";
	private static final String _FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_DESCRIPTION_2 =
		"esfMatch.description = ? AND ";
	private static final String _FINDER_COLUMN_MATCHSTARTDATE_T_A_D_N_ISNATIONAL_2 =
		"esfMatch.isNational = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID_ISNAT =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId_IsNat",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_ISNAT =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId_IsNat",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ESFMatchModelImpl.USERID_COLUMN_BITMASK |
			ESFMatchModelImpl.ISNATIONAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID_ISNAT = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId_IsNat",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the e s f matchs where userId = &#63; and isNational = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByUserId_IsNat(long userId, boolean isNational)
		throws SystemException {
		return findByUserId_IsNat(userId, isNational, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f matchs where userId = &#63; and isNational = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByUserId_IsNat(long userId, boolean isNational,
		int start, int end) throws SystemException {
		return findByUserId_IsNat(userId, isNational, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where userId = &#63; and isNational = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByUserId_IsNat(long userId, boolean isNational,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_ISNAT;
			finderArgs = new Object[] { userId, isNational };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID_ISNAT;
			finderArgs = new Object[] {
					userId, isNational,
					
					start, end, orderByComparator
				};
		}

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if ((userId != esfMatch.getUserId()) ||
						(isNational != esfMatch.getIsNational())) {
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

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_USERID_ISNAT_USERID_2);

			query.append(_FINDER_COLUMN_USERID_ISNAT_ISNATIONAL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(isNational);

				if (!pagination) {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByUserId_IsNat_First(long userId, boolean isNational,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByUserId_IsNat_First(userId, isNational,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", isNational=");
		msg.append(isNational);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByUserId_IsNat_First(long userId, boolean isNational,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatch> list = findByUserId_IsNat(userId, isNational, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByUserId_IsNat_Last(long userId, boolean isNational,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByUserId_IsNat_Last(userId, isNational,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", isNational=");
		msg.append(isNational);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByUserId_IsNat_Last(long userId, boolean isNational,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId_IsNat(userId, isNational);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findByUserId_IsNat(userId, isNational, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findByUserId_IsNat_PrevAndNext(long esfMatchId,
		long userId, boolean isNational, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getByUserId_IsNat_PrevAndNext(session, esfMatch, userId,
					isNational, orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getByUserId_IsNat_PrevAndNext(session, esfMatch, userId,
					isNational, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFMatch getByUserId_IsNat_PrevAndNext(Session session,
		ESFMatch esfMatch, long userId, boolean isNational,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

		query.append(_FINDER_COLUMN_USERID_ISNAT_USERID_2);

		query.append(_FINDER_COLUMN_USERID_ISNAT_ISNATIONAL_2);

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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(isNational);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where userId = &#63; and isNational = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId_IsNat(long userId, boolean isNational)
		throws SystemException {
		for (ESFMatch esfMatch : findByUserId_IsNat(userId, isNational,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where userId = &#63; and isNational = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @return the number of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId_IsNat(long userId, boolean isNational)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID_ISNAT;

		Object[] finderArgs = new Object[] { userId, isNational };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_USERID_ISNAT_USERID_2);

			query.append(_FINDER_COLUMN_USERID_ISNAT_ISNATIONAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(isNational);

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

	private static final String _FINDER_COLUMN_USERID_ISNAT_USERID_2 = "esfMatch.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_ISNAT_ISNATIONAL_2 = "esfMatch.isNational = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MYMATCH = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymyMatch",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MYMATCH =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymyMatch",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			ESFMatchModelImpl.USERID_COLUMN_BITMASK |
			ESFMatchModelImpl.ISNATIONAL_COLUMN_BITMASK |
			ESFMatchModelImpl.ESFASSOCIATIONID_COLUMN_BITMASK |
			ESFMatchModelImpl.STARTDATE_COLUMN_BITMASK |
			ESFMatchModelImpl.DESCRIPTION_COLUMN_BITMASK |
			ESFMatchModelImpl.ESFSPORTTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MYMATCH = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymyMatch",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param esfAssociationId the esf association ID
	 * @param startDate the start date
	 * @param description the description
	 * @param esfSportTypeId the esf sport type ID
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findBymyMatch(long userId, boolean isNational,
		long esfAssociationId, Date startDate, long description,
		long esfSportTypeId) throws SystemException {
		return findBymyMatch(userId, isNational, esfAssociationId, startDate,
			description, esfSportTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param esfAssociationId the esf association ID
	 * @param startDate the start date
	 * @param description the description
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findBymyMatch(long userId, boolean isNational,
		long esfAssociationId, Date startDate, long description,
		long esfSportTypeId, int start, int end) throws SystemException {
		return findBymyMatch(userId, isNational, esfAssociationId, startDate,
			description, esfSportTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param esfAssociationId the esf association ID
	 * @param startDate the start date
	 * @param description the description
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findBymyMatch(long userId, boolean isNational,
		long esfAssociationId, Date startDate, long description,
		long esfSportTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MYMATCH;
			finderArgs = new Object[] {
					userId, isNational, esfAssociationId, startDate, description,
					esfSportTypeId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MYMATCH;
			finderArgs = new Object[] {
					userId, isNational, esfAssociationId, startDate, description,
					esfSportTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if ((userId != esfMatch.getUserId()) ||
						(isNational != esfMatch.getIsNational()) ||
						(esfAssociationId != esfMatch.getEsfAssociationId()) ||
						!Validator.equals(startDate, esfMatch.getStartDate()) ||
						(description != esfMatch.getDescription()) ||
						(esfSportTypeId != esfMatch.getEsfSportTypeId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(8 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(8);
			}

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_MYMATCH_USERID_2);

			query.append(_FINDER_COLUMN_MYMATCH_ISNATIONAL_2);

			query.append(_FINDER_COLUMN_MYMATCH_ESFASSOCIATIONID_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_MYMATCH_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_MYMATCH_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_MYMATCH_DESCRIPTION_2);

			query.append(_FINDER_COLUMN_MYMATCH_ESFSPORTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(isNational);

				qPos.add(esfAssociationId);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(description);

				qPos.add(esfSportTypeId);

				if (!pagination) {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param esfAssociationId the esf association ID
	 * @param startDate the start date
	 * @param description the description
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findBymyMatch_First(long userId, boolean isNational,
		long esfAssociationId, Date startDate, long description,
		long esfSportTypeId, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchBymyMatch_First(userId, isNational,
				esfAssociationId, startDate, description, esfSportTypeId,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", isNational=");
		msg.append(isNational);

		msg.append(", esfAssociationId=");
		msg.append(esfAssociationId);

		msg.append(", startDate=");
		msg.append(startDate);

		msg.append(", description=");
		msg.append(description);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param esfAssociationId the esf association ID
	 * @param startDate the start date
	 * @param description the description
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchBymyMatch_First(long userId, boolean isNational,
		long esfAssociationId, Date startDate, long description,
		long esfSportTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFMatch> list = findBymyMatch(userId, isNational,
				esfAssociationId, startDate, description, esfSportTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param esfAssociationId the esf association ID
	 * @param startDate the start date
	 * @param description the description
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findBymyMatch_Last(long userId, boolean isNational,
		long esfAssociationId, Date startDate, long description,
		long esfSportTypeId, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchBymyMatch_Last(userId, isNational,
				esfAssociationId, startDate, description, esfSportTypeId,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", isNational=");
		msg.append(isNational);

		msg.append(", esfAssociationId=");
		msg.append(esfAssociationId);

		msg.append(", startDate=");
		msg.append(startDate);

		msg.append(", description=");
		msg.append(description);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param esfAssociationId the esf association ID
	 * @param startDate the start date
	 * @param description the description
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchBymyMatch_Last(long userId, boolean isNational,
		long esfAssociationId, Date startDate, long description,
		long esfSportTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBymyMatch(userId, isNational, esfAssociationId,
				startDate, description, esfSportTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findBymyMatch(userId, isNational,
				esfAssociationId, startDate, description, esfSportTypeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param esfAssociationId the esf association ID
	 * @param startDate the start date
	 * @param description the description
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findBymyMatch_PrevAndNext(long esfMatchId, long userId,
		boolean isNational, long esfAssociationId, Date startDate,
		long description, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getBymyMatch_PrevAndNext(session, esfMatch, userId,
					isNational, esfAssociationId, startDate, description,
					esfSportTypeId, orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getBymyMatch_PrevAndNext(session, esfMatch, userId,
					isNational, esfAssociationId, startDate, description,
					esfSportTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFMatch getBymyMatch_PrevAndNext(Session session,
		ESFMatch esfMatch, long userId, boolean isNational,
		long esfAssociationId, Date startDate, long description,
		long esfSportTypeId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

		query.append(_FINDER_COLUMN_MYMATCH_USERID_2);

		query.append(_FINDER_COLUMN_MYMATCH_ISNATIONAL_2);

		query.append(_FINDER_COLUMN_MYMATCH_ESFASSOCIATIONID_2);

		boolean bindStartDate = false;

		if (startDate == null) {
			query.append(_FINDER_COLUMN_MYMATCH_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			query.append(_FINDER_COLUMN_MYMATCH_STARTDATE_2);
		}

		query.append(_FINDER_COLUMN_MYMATCH_DESCRIPTION_2);

		query.append(_FINDER_COLUMN_MYMATCH_ESFSPORTTYPEID_2);

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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(isNational);

		qPos.add(esfAssociationId);

		if (bindStartDate) {
			qPos.add(CalendarUtil.getTimestamp(startDate));
		}

		qPos.add(description);

		qPos.add(esfSportTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param esfAssociationId the esf association ID
	 * @param startDate the start date
	 * @param description the description
	 * @param esfSportTypeId the esf sport type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBymyMatch(long userId, boolean isNational,
		long esfAssociationId, Date startDate, long description,
		long esfSportTypeId) throws SystemException {
		for (ESFMatch esfMatch : findBymyMatch(userId, isNational,
				esfAssociationId, startDate, description, esfSportTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param isNational the is national
	 * @param esfAssociationId the esf association ID
	 * @param startDate the start date
	 * @param description the description
	 * @param esfSportTypeId the esf sport type ID
	 * @return the number of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBymyMatch(long userId, boolean isNational,
		long esfAssociationId, Date startDate, long description,
		long esfSportTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MYMATCH;

		Object[] finderArgs = new Object[] {
				userId, isNational, esfAssociationId, startDate, description,
				esfSportTypeId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_MYMATCH_USERID_2);

			query.append(_FINDER_COLUMN_MYMATCH_ISNATIONAL_2);

			query.append(_FINDER_COLUMN_MYMATCH_ESFASSOCIATIONID_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_MYMATCH_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_MYMATCH_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_MYMATCH_DESCRIPTION_2);

			query.append(_FINDER_COLUMN_MYMATCH_ESFSPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(isNational);

				qPos.add(esfAssociationId);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(description);

				qPos.add(esfSportTypeId);

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

	private static final String _FINDER_COLUMN_MYMATCH_USERID_2 = "esfMatch.userId = ? AND ";
	private static final String _FINDER_COLUMN_MYMATCH_ISNATIONAL_2 = "esfMatch.isNational = ? AND ";
	private static final String _FINDER_COLUMN_MYMATCH_ESFASSOCIATIONID_2 = "esfMatch.esfAssociationId = ? AND ";
	private static final String _FINDER_COLUMN_MYMATCH_STARTDATE_1 = "esfMatch.startDate IS NULL AND ";
	private static final String _FINDER_COLUMN_MYMATCH_STARTDATE_2 = "esfMatch.startDate = ? AND ";
	private static final String _FINDER_COLUMN_MYMATCH_DESCRIPTION_2 = "esfMatch.description = ? AND ";
	private static final String _FINDER_COLUMN_MYMATCH_ESFSPORTTYPEID_2 = "esfMatch.esfSportTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventType",
			new String[] { String.class.getName() },
			ESFMatchModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTTYPE = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f matchs where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByEventType(String eventType)
		throws SystemException {
		return findByEventType(eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f matchs where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByEventType(String eventType, int start, int end)
		throws SystemException {
		return findByEventType(eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByEventType(String eventType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType, start, end, orderByComparator };
		}

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if (!Validator.equals(eventType, esfMatch.getEventType())) {
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

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (!pagination) {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByEventType_First(String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByEventType_First(eventType, orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByEventType_First(String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatch> list = findByEventType(eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByEventType_Last(String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByEventType_Last(eventType, orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByEventType_Last(String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventType(eventType);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findByEventType(eventType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where eventType = &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findByEventType_PrevAndNext(long esfMatchId,
		String eventType, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getByEventType_PrevAndNext(session, esfMatch, eventType,
					orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getByEventType_PrevAndNext(session, esfMatch, eventType,
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

	protected ESFMatch getByEventType_PrevAndNext(Session session,
		ESFMatch esfMatch, String eventType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventType(String eventType) throws SystemException {
		for (ESFMatch esfMatch : findByEventType(eventType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventType(String eventType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTTYPE;

		Object[] finderArgs = new Object[] { eventType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(eventType);
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

	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1 = "esfMatch.eventType IS NULL";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2 = "esfMatch.eventType = ?";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3 = "(esfMatch.eventType IS NULL OR esfMatch.eventType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISCHANGECATEGORY =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsChangeCategory",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISCHANGECATEGORY =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIsChangeCategory", new String[] { Boolean.class.getName() },
			ESFMatchModelImpl.ISCHANGECATEGORYMATCH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISCHANGECATEGORY = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIsChangeCategory", new String[] { Boolean.class.getName() });

	/**
	 * Returns all the e s f matchs where isChangeCategoryMatch = &#63;.
	 *
	 * @param isChangeCategoryMatch the is change category match
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByIsChangeCategory(boolean isChangeCategoryMatch)
		throws SystemException {
		return findByIsChangeCategory(isChangeCategoryMatch, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f matchs where isChangeCategoryMatch = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isChangeCategoryMatch the is change category match
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByIsChangeCategory(
		boolean isChangeCategoryMatch, int start, int end)
		throws SystemException {
		return findByIsChangeCategory(isChangeCategoryMatch, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where isChangeCategoryMatch = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isChangeCategoryMatch the is change category match
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByIsChangeCategory(
		boolean isChangeCategoryMatch, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISCHANGECATEGORY;
			finderArgs = new Object[] { isChangeCategoryMatch };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISCHANGECATEGORY;
			finderArgs = new Object[] {
					isChangeCategoryMatch,
					
					start, end, orderByComparator
				};
		}

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if ((isChangeCategoryMatch != esfMatch.getIsChangeCategoryMatch())) {
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

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_ISCHANGECATEGORY_ISCHANGECATEGORYMATCH_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isChangeCategoryMatch);

				if (!pagination) {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	 *
	 * @param isChangeCategoryMatch the is change category match
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByIsChangeCategory_First(
		boolean isChangeCategoryMatch, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByIsChangeCategory_First(isChangeCategoryMatch,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isChangeCategoryMatch=");
		msg.append(isChangeCategoryMatch);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	 *
	 * @param isChangeCategoryMatch the is change category match
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByIsChangeCategory_First(
		boolean isChangeCategoryMatch, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFMatch> list = findByIsChangeCategory(isChangeCategoryMatch, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	 *
	 * @param isChangeCategoryMatch the is change category match
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByIsChangeCategory_Last(boolean isChangeCategoryMatch,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByIsChangeCategory_Last(isChangeCategoryMatch,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isChangeCategoryMatch=");
		msg.append(isChangeCategoryMatch);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	 *
	 * @param isChangeCategoryMatch the is change category match
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByIsChangeCategory_Last(
		boolean isChangeCategoryMatch, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByIsChangeCategory(isChangeCategoryMatch);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findByIsChangeCategory(isChangeCategoryMatch,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param isChangeCategoryMatch the is change category match
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findByIsChangeCategory_PrevAndNext(long esfMatchId,
		boolean isChangeCategoryMatch, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getByIsChangeCategory_PrevAndNext(session, esfMatch,
					isChangeCategoryMatch, orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getByIsChangeCategory_PrevAndNext(session, esfMatch,
					isChangeCategoryMatch, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFMatch getByIsChangeCategory_PrevAndNext(Session session,
		ESFMatch esfMatch, boolean isChangeCategoryMatch,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

		query.append(_FINDER_COLUMN_ISCHANGECATEGORY_ISCHANGECATEGORYMATCH_2);

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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isChangeCategoryMatch);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where isChangeCategoryMatch = &#63; from the database.
	 *
	 * @param isChangeCategoryMatch the is change category match
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIsChangeCategory(boolean isChangeCategoryMatch)
		throws SystemException {
		for (ESFMatch esfMatch : findByIsChangeCategory(isChangeCategoryMatch,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where isChangeCategoryMatch = &#63;.
	 *
	 * @param isChangeCategoryMatch the is change category match
	 * @return the number of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIsChangeCategory(boolean isChangeCategoryMatch)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISCHANGECATEGORY;

		Object[] finderArgs = new Object[] { isChangeCategoryMatch };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_ISCHANGECATEGORY_ISCHANGECATEGORYMATCH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isChangeCategoryMatch);

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

	private static final String _FINDER_COLUMN_ISCHANGECATEGORY_ISCHANGECATEGORYMATCH_2 =
		"esfMatch.isChangeCategoryMatch = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDescription",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDescription",
			new String[] { Long.class.getName() },
			ESFMatchModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDescription",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f matchs where description = &#63;.
	 *
	 * @param description the description
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByDescription(long description)
		throws SystemException {
		return findByDescription(description, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f matchs where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByDescription(long description, int start, int end)
		throws SystemException {
		return findByDescription(description, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByDescription(long description, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION;
			finderArgs = new Object[] { description };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION;
			finderArgs = new Object[] { description, start, end, orderByComparator };
		}

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if ((description != esfMatch.getDescription())) {
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

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(description);

				if (!pagination) {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByDescription_First(long description,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByDescription_First(description,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByDescription_First(long description,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatch> list = findByDescription(description, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByDescription_Last(long description,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByDescription_Last(description,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByDescription_Last(long description,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDescription(description);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findByDescription(description, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where description = &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findByDescription_PrevAndNext(long esfMatchId,
		long description, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getByDescription_PrevAndNext(session, esfMatch,
					description, orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getByDescription_PrevAndNext(session, esfMatch,
					description, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFMatch getByDescription_PrevAndNext(Session session,
		ESFMatch esfMatch, long description,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

		query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);

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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(description);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where description = &#63; from the database.
	 *
	 * @param description the description
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDescription(long description) throws SystemException {
		for (ESFMatch esfMatch : findByDescription(description,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDescription(long description) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESCRIPTION;

		Object[] finderArgs = new Object[] { description };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(description);

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

	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2 = "esfMatch.description = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			ESFMatchModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f match where code = &#63; or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByCode(String code)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByCode(code);

		if (esfMatch == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMatchException(msg.toString());
		}

		return esfMatch;
	}

	/**
	 * Returns the e s f match where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the e s f match where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ESFMatch) {
			ESFMatch esfMatch = (ESFMatch)result;

			if (!Validator.equals(code, esfMatch.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

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

				List<ESFMatch> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					ESFMatch esfMatch = list.get(0);

					result = esfMatch;

					cacheResult(esfMatch);

					if ((esfMatch.getCode() == null) ||
							!esfMatch.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, esfMatch);
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
			return (ESFMatch)result;
		}
	}

	/**
	 * Removes the e s f match where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the e s f match that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch removeByCode(String code)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByCode(code);

		return remove(esfMatch);
	}

	/**
	 * Returns the number of e s f matchs where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f matchs
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

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfMatch.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfMatch.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfMatch.code IS NULL OR esfMatch.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIKECODE = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLikeCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_LIKECODE =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByLikeCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f matchs where code LIKE &#63;.
	 *
	 * @param code the code
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByLikeCode(String code) throws SystemException {
		return findByLikeCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f matchs where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByLikeCode(String code, int start, int end)
		throws SystemException {
		return findByLikeCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByLikeCode(String code, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LIKECODE;
		finderArgs = new Object[] { code, start, end, orderByComparator };

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if (!StringUtil.wildcardMatches(esfMatch.getCode(), code,
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

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_LIKECODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIKECODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_LIKECODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByLikeCode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByLikeCode_First(code, orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByLikeCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatch> list = findByLikeCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByLikeCode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByLikeCode_Last(code, orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByLikeCode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLikeCode(code);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findByLikeCode(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where code LIKE &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findByLikeCode_PrevAndNext(long esfMatchId, String code,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getByLikeCode_PrevAndNext(session, esfMatch, code,
					orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getByLikeCode_PrevAndNext(session, esfMatch, code,
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

	protected ESFMatch getByLikeCode_PrevAndNext(Session session,
		ESFMatch esfMatch, String code, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

		boolean bindCode = false;

		if (code == null) {
			query.append(_FINDER_COLUMN_LIKECODE_CODE_1);
		}
		else if (code.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LIKECODE_CODE_3);
		}
		else {
			bindCode = true;

			query.append(_FINDER_COLUMN_LIKECODE_CODE_2);
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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where code LIKE &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLikeCode(String code) throws SystemException {
		for (ESFMatch esfMatch : findByLikeCode(code, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where code LIKE &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLikeCode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_LIKECODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_LIKECODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIKECODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_LIKECODE_CODE_2);
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

	private static final String _FINDER_COLUMN_LIKECODE_CODE_1 = "esfMatch.code LIKE NULL";
	private static final String _FINDER_COLUMN_LIKECODE_CODE_2 = "esfMatch.code LIKE ?";
	private static final String _FINDER_COLUMN_LIKECODE_CODE_3 = "(esfMatch.code IS NULL OR esfMatch.code LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MATCHYEAR =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMatchYear",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHYEAR =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMatchYear",
			new String[] { Integer.class.getName() },
			ESFMatchModelImpl.MATCHYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MATCHYEAR = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMatchYear",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the e s f matchs where matchYear = &#63;.
	 *
	 * @param matchYear the match year
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByMatchYear(int matchYear)
		throws SystemException {
		return findByMatchYear(matchYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f matchs where matchYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param matchYear the match year
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByMatchYear(int matchYear, int start, int end)
		throws SystemException {
		return findByMatchYear(matchYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where matchYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param matchYear the match year
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByMatchYear(int matchYear, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHYEAR;
			finderArgs = new Object[] { matchYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MATCHYEAR;
			finderArgs = new Object[] { matchYear, start, end, orderByComparator };
		}

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if ((matchYear != esfMatch.getMatchYear())) {
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

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_MATCHYEAR_MATCHYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(matchYear);

				if (!pagination) {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where matchYear = &#63;.
	 *
	 * @param matchYear the match year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByMatchYear_First(int matchYear,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByMatchYear_First(matchYear, orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("matchYear=");
		msg.append(matchYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where matchYear = &#63;.
	 *
	 * @param matchYear the match year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByMatchYear_First(int matchYear,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatch> list = findByMatchYear(matchYear, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where matchYear = &#63;.
	 *
	 * @param matchYear the match year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByMatchYear_Last(int matchYear,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByMatchYear_Last(matchYear, orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("matchYear=");
		msg.append(matchYear);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where matchYear = &#63;.
	 *
	 * @param matchYear the match year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByMatchYear_Last(int matchYear,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMatchYear(matchYear);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findByMatchYear(matchYear, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where matchYear = &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param matchYear the match year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findByMatchYear_PrevAndNext(long esfMatchId,
		int matchYear, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getByMatchYear_PrevAndNext(session, esfMatch, matchYear,
					orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getByMatchYear_PrevAndNext(session, esfMatch, matchYear,
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

	protected ESFMatch getByMatchYear_PrevAndNext(Session session,
		ESFMatch esfMatch, int matchYear, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

		query.append(_FINDER_COLUMN_MATCHYEAR_MATCHYEAR_2);

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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(matchYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where matchYear = &#63; from the database.
	 *
	 * @param matchYear the match year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMatchYear(int matchYear) throws SystemException {
		for (ESFMatch esfMatch : findByMatchYear(matchYear, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where matchYear = &#63;.
	 *
	 * @param matchYear the match year
	 * @return the number of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMatchYear(int matchYear) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MATCHYEAR;

		Object[] finderArgs = new Object[] { matchYear };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_MATCHYEAR_MATCHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(matchYear);

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

	private static final String _FINDER_COLUMN_MATCHYEAR_MATCHYEAR_2 = "esfMatch.matchYear = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEARCODE = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYearCode",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARCODE =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYearCode",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			ESFMatchModelImpl.MATCHYEAR_COLUMN_BITMASK |
			ESFMatchModelImpl.MATCHYEARSEQ_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEARCODE = new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYearCode",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the e s f matchs where matchYear = &#63; and matchYearSeq = &#63;.
	 *
	 * @param matchYear the match year
	 * @param matchYearSeq the match year seq
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByYearCode(int matchYear, int matchYearSeq)
		throws SystemException {
		return findByYearCode(matchYear, matchYearSeq, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f matchs where matchYear = &#63; and matchYearSeq = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param matchYear the match year
	 * @param matchYearSeq the match year seq
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByYearCode(int matchYear, int matchYearSeq,
		int start, int end) throws SystemException {
		return findByYearCode(matchYear, matchYearSeq, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where matchYear = &#63; and matchYearSeq = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param matchYear the match year
	 * @param matchYearSeq the match year seq
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByYearCode(int matchYear, int matchYearSeq,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARCODE;
			finderArgs = new Object[] { matchYear, matchYearSeq };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YEARCODE;
			finderArgs = new Object[] {
					matchYear, matchYearSeq,
					
					start, end, orderByComparator
				};
		}

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if ((matchYear != esfMatch.getMatchYear()) ||
						(matchYearSeq != esfMatch.getMatchYearSeq())) {
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

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_YEARCODE_MATCHYEAR_2);

			query.append(_FINDER_COLUMN_YEARCODE_MATCHYEARSEQ_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(matchYear);

				qPos.add(matchYearSeq);

				if (!pagination) {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where matchYear = &#63; and matchYearSeq = &#63;.
	 *
	 * @param matchYear the match year
	 * @param matchYearSeq the match year seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByYearCode_First(int matchYear, int matchYearSeq,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByYearCode_First(matchYear, matchYearSeq,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("matchYear=");
		msg.append(matchYear);

		msg.append(", matchYearSeq=");
		msg.append(matchYearSeq);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where matchYear = &#63; and matchYearSeq = &#63;.
	 *
	 * @param matchYear the match year
	 * @param matchYearSeq the match year seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByYearCode_First(int matchYear, int matchYearSeq,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatch> list = findByYearCode(matchYear, matchYearSeq, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where matchYear = &#63; and matchYearSeq = &#63;.
	 *
	 * @param matchYear the match year
	 * @param matchYearSeq the match year seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByYearCode_Last(int matchYear, int matchYearSeq,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByYearCode_Last(matchYear, matchYearSeq,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("matchYear=");
		msg.append(matchYear);

		msg.append(", matchYearSeq=");
		msg.append(matchYearSeq);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where matchYear = &#63; and matchYearSeq = &#63;.
	 *
	 * @param matchYear the match year
	 * @param matchYearSeq the match year seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByYearCode_Last(int matchYear, int matchYearSeq,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByYearCode(matchYear, matchYearSeq);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findByYearCode(matchYear, matchYearSeq,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where matchYear = &#63; and matchYearSeq = &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param matchYear the match year
	 * @param matchYearSeq the match year seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findByYearCode_PrevAndNext(long esfMatchId,
		int matchYear, int matchYearSeq, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getByYearCode_PrevAndNext(session, esfMatch, matchYear,
					matchYearSeq, orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getByYearCode_PrevAndNext(session, esfMatch, matchYear,
					matchYearSeq, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFMatch getByYearCode_PrevAndNext(Session session,
		ESFMatch esfMatch, int matchYear, int matchYearSeq,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

		query.append(_FINDER_COLUMN_YEARCODE_MATCHYEAR_2);

		query.append(_FINDER_COLUMN_YEARCODE_MATCHYEARSEQ_2);

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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(matchYear);

		qPos.add(matchYearSeq);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where matchYear = &#63; and matchYearSeq = &#63; from the database.
	 *
	 * @param matchYear the match year
	 * @param matchYearSeq the match year seq
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByYearCode(int matchYear, int matchYearSeq)
		throws SystemException {
		for (ESFMatch esfMatch : findByYearCode(matchYear, matchYearSeq,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where matchYear = &#63; and matchYearSeq = &#63;.
	 *
	 * @param matchYear the match year
	 * @param matchYearSeq the match year seq
	 * @return the number of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByYearCode(int matchYear, int matchYearSeq)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_YEARCODE;

		Object[] finderArgs = new Object[] { matchYear, matchYearSeq };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_YEARCODE_MATCHYEAR_2);

			query.append(_FINDER_COLUMN_YEARCODE_MATCHYEARSEQ_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(matchYear);

				qPos.add(matchYearSeq);

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

	private static final String _FINDER_COLUMN_YEARCODE_MATCHYEAR_2 = "esfMatch.matchYear = ? AND ";
	private static final String _FINDER_COLUMN_YEARCODE_MATCHYEARSEQ_2 = "esfMatch.matchYearSeq = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE_CODE =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, ESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDate_Code",
			new String[] {
				Date.class.getName(), Boolean.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATE_CODE =
		new FinderPath(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDate_Code",
			new String[] {
				Date.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	 *
	 * @param startDate the start date
	 * @param isNational the is national
	 * @param code the code
	 * @return the matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByDate_Code(Date startDate, boolean isNational,
		String code) throws SystemException {
		return findByDate_Code(startDate, isNational, code, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param isNational the is national
	 * @param code the code
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByDate_Code(Date startDate, boolean isNational,
		String code, int start, int end) throws SystemException {
		return findByDate_Code(startDate, isNational, code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param isNational the is national
	 * @param code the code
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findByDate_Code(Date startDate, boolean isNational,
		String code, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE_CODE;
		finderArgs = new Object[] {
				startDate, isNational, code,
				
				start, end, orderByComparator
			};

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatch esfMatch : list) {
				if ((startDate.getTime() >= esfMatch.getStartDate().getTime()) ||
						(isNational != esfMatch.getIsNational()) ||
						!StringUtil.wildcardMatches(esfMatch.getCode(), code,
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
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ESFMATCH_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_DATE_CODE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_DATE_CODE_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_DATE_CODE_ISNATIONAL_2);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_DATE_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DATE_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_DATE_CODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(isNational);

				if (bindCode) {
					qPos.add(code);
				}

				if (!pagination) {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	 *
	 * @param startDate the start date
	 * @param isNational the is national
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByDate_Code_First(Date startDate, boolean isNational,
		String code, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByDate_Code_First(startDate, isNational, code,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startDate=");
		msg.append(startDate);

		msg.append(", isNational=");
		msg.append(isNational);

		msg.append(", code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	 *
	 * @param startDate the start date
	 * @param isNational the is national
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByDate_Code_First(Date startDate, boolean isNational,
		String code, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFMatch> list = findByDate_Code(startDate, isNational, code, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	 *
	 * @param startDate the start date
	 * @param isNational the is national
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByDate_Code_Last(Date startDate, boolean isNational,
		String code, OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByDate_Code_Last(startDate, isNational, code,
				orderByComparator);

		if (esfMatch != null) {
			return esfMatch;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startDate=");
		msg.append(startDate);

		msg.append(", isNational=");
		msg.append(isNational);

		msg.append(", code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	 *
	 * @param startDate the start date
	 * @param isNational the is national
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByDate_Code_Last(Date startDate, boolean isNational,
		String code, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDate_Code(startDate, isNational, code);

		if (count == 0) {
			return null;
		}

		List<ESFMatch> list = findByDate_Code(startDate, isNational, code,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f matchs before and after the current e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	 *
	 * @param esfMatchId the primary key of the current e s f match
	 * @param startDate the start date
	 * @param isNational the is national
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch[] findByDate_Code_PrevAndNext(long esfMatchId,
		Date startDate, boolean isNational, String code,
		OrderByComparator orderByComparator)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = findByPrimaryKey(esfMatchId);

		Session session = null;

		try {
			session = openSession();

			ESFMatch[] array = new ESFMatchImpl[3];

			array[0] = getByDate_Code_PrevAndNext(session, esfMatch, startDate,
					isNational, code, orderByComparator, true);

			array[1] = esfMatch;

			array[2] = getByDate_Code_PrevAndNext(session, esfMatch, startDate,
					isNational, code, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFMatch getByDate_Code_PrevAndNext(Session session,
		ESFMatch esfMatch, Date startDate, boolean isNational, String code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCH_WHERE);

		boolean bindStartDate = false;

		if (startDate == null) {
			query.append(_FINDER_COLUMN_DATE_CODE_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			query.append(_FINDER_COLUMN_DATE_CODE_STARTDATE_2);
		}

		query.append(_FINDER_COLUMN_DATE_CODE_ISNATIONAL_2);

		boolean bindCode = false;

		if (code == null) {
			query.append(_FINDER_COLUMN_DATE_CODE_CODE_1);
		}
		else if (code.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DATE_CODE_CODE_3);
		}
		else {
			bindCode = true;

			query.append(_FINDER_COLUMN_DATE_CODE_CODE_2);
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
			query.append(ESFMatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStartDate) {
			qPos.add(CalendarUtil.getTimestamp(startDate));
		}

		qPos.add(isNational);

		if (bindCode) {
			qPos.add(code);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param isNational the is national
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDate_Code(Date startDate, boolean isNational,
		String code) throws SystemException {
		for (ESFMatch esfMatch : findByDate_Code(startDate, isNational, code,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	 *
	 * @param startDate the start date
	 * @param isNational the is national
	 * @param code the code
	 * @return the number of matching e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDate_Code(Date startDate, boolean isNational, String code)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATE_CODE;

		Object[] finderArgs = new Object[] { startDate, isNational, code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFMATCH_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_DATE_CODE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_DATE_CODE_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_DATE_CODE_ISNATIONAL_2);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_DATE_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DATE_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_DATE_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(isNational);

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

	private static final String _FINDER_COLUMN_DATE_CODE_STARTDATE_1 = "esfMatch.startDate > NULL AND ";
	private static final String _FINDER_COLUMN_DATE_CODE_STARTDATE_2 = "esfMatch.startDate > ? AND ";
	private static final String _FINDER_COLUMN_DATE_CODE_ISNATIONAL_2 = "esfMatch.isNational = ? AND ";
	private static final String _FINDER_COLUMN_DATE_CODE_CODE_1 = "esfMatch.code LIKE NULL";
	private static final String _FINDER_COLUMN_DATE_CODE_CODE_2 = "esfMatch.code LIKE ?";
	private static final String _FINDER_COLUMN_DATE_CODE_CODE_3 = "(esfMatch.code IS NULL OR esfMatch.code LIKE '')";

	public ESFMatchPersistenceImpl() {
		setModelClass(ESFMatch.class);
	}

	/**
	 * Caches the e s f match in the entity cache if it is enabled.
	 *
	 * @param esfMatch the e s f match
	 */
	@Override
	public void cacheResult(ESFMatch esfMatch) {
		EntityCacheUtil.putResult(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchImpl.class, esfMatch.getPrimaryKey(), esfMatch);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfMatch.getUuid(), esfMatch.getGroupId() }, esfMatch);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N,
			new Object[] {
				esfMatch.getStartDate(), esfMatch.getEsfMatchTypeId(),
				esfMatch.getEsfAssociationId(), esfMatch.getDescription(),
				esfMatch.getIsNational()
			}, esfMatch);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { esfMatch.getCode() }, esfMatch);

		esfMatch.resetOriginalValues();
	}

	/**
	 * Caches the e s f matchs in the entity cache if it is enabled.
	 *
	 * @param esfMatchs the e s f matchs
	 */
	@Override
	public void cacheResult(List<ESFMatch> esfMatchs) {
		for (ESFMatch esfMatch : esfMatchs) {
			if (EntityCacheUtil.getResult(
						ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
						ESFMatchImpl.class, esfMatch.getPrimaryKey()) == null) {
				cacheResult(esfMatch);
			}
			else {
				esfMatch.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f matchs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFMatchImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFMatchImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f match.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFMatch esfMatch) {
		EntityCacheUtil.removeResult(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchImpl.class, esfMatch.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfMatch);
	}

	@Override
	public void clearCache(List<ESFMatch> esfMatchs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFMatch esfMatch : esfMatchs) {
			EntityCacheUtil.removeResult(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
				ESFMatchImpl.class, esfMatch.getPrimaryKey());

			clearUniqueFindersCache(esfMatch);
		}
	}

	protected void cacheUniqueFindersCache(ESFMatch esfMatch) {
		if (esfMatch.isNew()) {
			Object[] args = new Object[] {
					esfMatch.getUuid(), esfMatch.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfMatch);

			args = new Object[] {
					esfMatch.getStartDate(), esfMatch.getEsfMatchTypeId(),
					esfMatch.getEsfAssociationId(), esfMatch.getDescription(),
					esfMatch.getIsNational()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MATCHSTARTDATE_T_A_D_N,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N,
				args, esfMatch);

			args = new Object[] { esfMatch.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args, esfMatch);
		}
		else {
			ESFMatchModelImpl esfMatchModelImpl = (ESFMatchModelImpl)esfMatch;

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatch.getUuid(), esfMatch.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfMatch);
			}

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatch.getStartDate(), esfMatch.getEsfMatchTypeId(),
						esfMatch.getEsfAssociationId(),
						esfMatch.getDescription(), esfMatch.getIsNational()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MATCHSTARTDATE_T_A_D_N,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N,
					args, esfMatch);
			}

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfMatch.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					esfMatch);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFMatch esfMatch) {
		ESFMatchModelImpl esfMatchModelImpl = (ESFMatchModelImpl)esfMatch;

		Object[] args = new Object[] { esfMatch.getUuid(), esfMatch.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfMatchModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfMatchModelImpl.getOriginalUuid(),
					esfMatchModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				esfMatch.getStartDate(), esfMatch.getEsfMatchTypeId(),
				esfMatch.getEsfAssociationId(), esfMatch.getDescription(),
				esfMatch.getIsNational()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATCHSTARTDATE_T_A_D_N,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N,
			args);

		if ((esfMatchModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfMatchModelImpl.getOriginalStartDate(),
					esfMatchModelImpl.getOriginalEsfMatchTypeId(),
					esfMatchModelImpl.getOriginalEsfAssociationId(),
					esfMatchModelImpl.getOriginalDescription(),
					esfMatchModelImpl.getOriginalIsNational()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATCHSTARTDATE_T_A_D_N,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MATCHSTARTDATE_T_A_D_N,
				args);
		}

		args = new Object[] { esfMatch.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((esfMatchModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfMatchModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new e s f match with the primary key. Does not add the e s f match to the database.
	 *
	 * @param esfMatchId the primary key for the new e s f match
	 * @return the new e s f match
	 */
	@Override
	public ESFMatch create(long esfMatchId) {
		ESFMatch esfMatch = new ESFMatchImpl();

		esfMatch.setNew(true);
		esfMatch.setPrimaryKey(esfMatchId);

		String uuid = PortalUUIDUtil.generate();

		esfMatch.setUuid(uuid);

		return esfMatch;
	}

	/**
	 * Removes the e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfMatchId the primary key of the e s f match
	 * @return the e s f match that was removed
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch remove(long esfMatchId)
		throws NoSuchMatchException, SystemException {
		return remove((Serializable)esfMatchId);
	}

	/**
	 * Removes the e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f match
	 * @return the e s f match that was removed
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch remove(Serializable primaryKey)
		throws NoSuchMatchException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFMatch esfMatch = (ESFMatch)session.get(ESFMatchImpl.class,
					primaryKey);

			if (esfMatch == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfMatch);
		}
		catch (NoSuchMatchException nsee) {
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
	protected ESFMatch removeImpl(ESFMatch esfMatch) throws SystemException {
		esfMatch = toUnwrappedModel(esfMatch);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfMatch)) {
				esfMatch = (ESFMatch)session.get(ESFMatchImpl.class,
						esfMatch.getPrimaryKeyObj());
			}

			if (esfMatch != null) {
				session.delete(esfMatch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfMatch != null) {
			clearCache(esfMatch);
		}

		return esfMatch;
	}

	@Override
	public ESFMatch updateImpl(it.ethica.esf.model.ESFMatch esfMatch)
		throws SystemException {
		esfMatch = toUnwrappedModel(esfMatch);

		boolean isNew = esfMatch.isNew();

		ESFMatchModelImpl esfMatchModelImpl = (ESFMatchModelImpl)esfMatch;

		if (Validator.isNull(esfMatch.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfMatch.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfMatch.isNew()) {
				session.save(esfMatch);

				esfMatch.setNew(false);
			}
			else {
				session.merge(esfMatch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFMatchModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfMatchModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfMatchModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchModelImpl.getOriginalUuid(),
						esfMatchModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfMatchModelImpl.getUuid(),
						esfMatchModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchModelImpl.getOriginalEsfMatchTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATCHTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHTYPEID,
					args);

				args = new Object[] { esfMatchModelImpl.getEsfMatchTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATCHTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHTYPEID,
					args);
			}

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_ISNAT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchModelImpl.getOriginalUserId(),
						esfMatchModelImpl.getOriginalIsNational()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_ISNAT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_ISNAT,
					args);

				args = new Object[] {
						esfMatchModelImpl.getUserId(),
						esfMatchModelImpl.getIsNational()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_ISNAT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_ISNAT,
					args);
			}

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MYMATCH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchModelImpl.getOriginalUserId(),
						esfMatchModelImpl.getOriginalIsNational(),
						esfMatchModelImpl.getOriginalEsfAssociationId(),
						esfMatchModelImpl.getOriginalStartDate(),
						esfMatchModelImpl.getOriginalDescription(),
						esfMatchModelImpl.getOriginalEsfSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MYMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MYMATCH,
					args);

				args = new Object[] {
						esfMatchModelImpl.getUserId(),
						esfMatchModelImpl.getIsNational(),
						esfMatchModelImpl.getEsfAssociationId(),
						esfMatchModelImpl.getStartDate(),
						esfMatchModelImpl.getDescription(),
						esfMatchModelImpl.getEsfSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MYMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MYMATCH,
					args);
			}

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchModelImpl.getOriginalEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);

				args = new Object[] { esfMatchModelImpl.getEventType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);
			}

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISCHANGECATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchModelImpl.getOriginalIsChangeCategoryMatch()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISCHANGECATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISCHANGECATEGORY,
					args);

				args = new Object[] { esfMatchModelImpl.getIsChangeCategoryMatch() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISCHANGECATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISCHANGECATEGORY,
					args);
			}

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchModelImpl.getOriginalDescription()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);

				args = new Object[] { esfMatchModelImpl.getDescription() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);
			}

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchModelImpl.getOriginalMatchYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATCHYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHYEAR,
					args);

				args = new Object[] { esfMatchModelImpl.getMatchYear() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATCHYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHYEAR,
					args);
			}

			if ((esfMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchModelImpl.getOriginalMatchYear(),
						esfMatchModelImpl.getOriginalMatchYearSeq()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEARCODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARCODE,
					args);

				args = new Object[] {
						esfMatchModelImpl.getMatchYear(),
						esfMatchModelImpl.getMatchYearSeq()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEARCODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARCODE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchImpl.class, esfMatch.getPrimaryKey(), esfMatch);

		clearUniqueFindersCache(esfMatch);
		cacheUniqueFindersCache(esfMatch);

		return esfMatch;
	}

	protected ESFMatch toUnwrappedModel(ESFMatch esfMatch) {
		if (esfMatch instanceof ESFMatchImpl) {
			return esfMatch;
		}

		ESFMatchImpl esfMatchImpl = new ESFMatchImpl();

		esfMatchImpl.setNew(esfMatch.isNew());
		esfMatchImpl.setPrimaryKey(esfMatch.getPrimaryKey());

		esfMatchImpl.setUuid(esfMatch.getUuid());
		esfMatchImpl.setEsfMatchId(esfMatch.getEsfMatchId());
		esfMatchImpl.setStartDate(esfMatch.getStartDate());
		esfMatchImpl.setStartHour(esfMatch.getStartHour());
		esfMatchImpl.setEsfSportTypeId(esfMatch.getEsfSportTypeId());
		esfMatchImpl.setEsfMatchTypeId(esfMatch.getEsfMatchTypeId());
		esfMatchImpl.setIsDraft(esfMatch.isIsDraft());
		esfMatchImpl.setIsTeamMatch(esfMatch.isIsTeamMatch());
		esfMatchImpl.setIsIndividualMatch(esfMatch.isIsIndividualMatch());
		esfMatchImpl.setIsJuniorMatch(esfMatch.isIsJuniorMatch());
		esfMatchImpl.setNumDisk(esfMatch.getNumDisk());
		esfMatchImpl.setNumDiskTeam(esfMatch.getNumDiskTeam());
		esfMatchImpl.setEsfAssociationId(esfMatch.getEsfAssociationId());
		esfMatchImpl.setNotes(esfMatch.getNotes());
		esfMatchImpl.setDescription(esfMatch.getDescription());
		esfMatchImpl.setEndDate(esfMatch.getEndDate());
		esfMatchImpl.setNumFields(esfMatch.getNumFields());
		esfMatchImpl.setGroupId(esfMatch.getGroupId());
		esfMatchImpl.setCompanyId(esfMatch.getCompanyId());
		esfMatchImpl.setUserId(esfMatch.getUserId());
		esfMatchImpl.setUserName(esfMatch.getUserName());
		esfMatchImpl.setCreateDate(esfMatch.getCreateDate());
		esfMatchImpl.setModifiedDate(esfMatch.getModifiedDate());
		esfMatchImpl.setIsSingleMatch(esfMatch.isIsSingleMatch());
		esfMatchImpl.setSite(esfMatch.getSite());
		esfMatchImpl.setCountryId(esfMatch.getCountryId());
		esfMatchImpl.setCode(esfMatch.getCode());
		esfMatchImpl.setIsNational(esfMatch.isIsNational());
		esfMatchImpl.setHasPenality(esfMatch.isHasPenality());
		esfMatchImpl.setIsOlimpicQualificationMatch(esfMatch.isIsOlimpicQualificationMatch());
		esfMatchImpl.setEventType(esfMatch.getEventType());
		esfMatchImpl.setNotNationalAssotiation(esfMatch.getNotNationalAssotiation());
		esfMatchImpl.setIsChangeCategoryMatch(esfMatch.isIsChangeCategoryMatch());
		esfMatchImpl.setEsfNationalSportTypeId(esfMatch.getEsfNationalSportTypeId());
		esfMatchImpl.setOldCode(esfMatch.getOldCode());
		esfMatchImpl.setMatchYear(esfMatch.getMatchYear());
		esfMatchImpl.setMatchYearSeq(esfMatch.getMatchYearSeq());

		return esfMatchImpl;
	}

	/**
	 * Returns the e s f match with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f match
	 * @return the e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMatchException, SystemException {
		ESFMatch esfMatch = fetchByPrimaryKey(primaryKey);

		if (esfMatch == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfMatch;
	}

	/**
	 * Returns the e s f match with the primary key or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	 *
	 * @param esfMatchId the primary key of the e s f match
	 * @return the e s f match
	 * @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch findByPrimaryKey(long esfMatchId)
		throws NoSuchMatchException, SystemException {
		return findByPrimaryKey((Serializable)esfMatchId);
	}

	/**
	 * Returns the e s f match with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f match
	 * @return the e s f match, or <code>null</code> if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFMatch esfMatch = (ESFMatch)EntityCacheUtil.getResult(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
				ESFMatchImpl.class, primaryKey);

		if (esfMatch == _nullESFMatch) {
			return null;
		}

		if (esfMatch == null) {
			Session session = null;

			try {
				session = openSession();

				esfMatch = (ESFMatch)session.get(ESFMatchImpl.class, primaryKey);

				if (esfMatch != null) {
					cacheResult(esfMatch);
				}
				else {
					EntityCacheUtil.putResult(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
						ESFMatchImpl.class, primaryKey, _nullESFMatch);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFMatchModelImpl.ENTITY_CACHE_ENABLED,
					ESFMatchImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfMatch;
	}

	/**
	 * Returns the e s f match with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfMatchId the primary key of the e s f match
	 * @return the e s f match, or <code>null</code> if a e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatch fetchByPrimaryKey(long esfMatchId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfMatchId);
	}

	/**
	 * Returns all the e s f matchs.
	 *
	 * @return the e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f matchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @return the range of e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f matchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f matchs
	 * @param end the upper bound of the range of e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatch> findAll(int start, int end,
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

		List<ESFMatch> list = (List<ESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFMATCH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFMATCH;

				if (pagination) {
					sql = sql.concat(ESFMatchModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatch>(list);
				}
				else {
					list = (List<ESFMatch>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f matchs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFMatch esfMatch : findAll()) {
			remove(esfMatch);
		}
	}

	/**
	 * Returns the number of e s f matchs.
	 *
	 * @return the number of e s f matchs
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

				Query q = session.createQuery(_SQL_COUNT_ESFMATCH);

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
	 * Initializes the e s f match persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFMatch")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFMatch>> listenersList = new ArrayList<ModelListener<ESFMatch>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFMatch>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFMatchImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFMATCH = "SELECT esfMatch FROM ESFMatch esfMatch";
	private static final String _SQL_SELECT_ESFMATCH_WHERE = "SELECT esfMatch FROM ESFMatch esfMatch WHERE ";
	private static final String _SQL_COUNT_ESFMATCH = "SELECT COUNT(esfMatch) FROM ESFMatch esfMatch";
	private static final String _SQL_COUNT_ESFMATCH_WHERE = "SELECT COUNT(esfMatch) FROM ESFMatch esfMatch WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfMatch.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFMatch exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFMatch exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFMatchPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ESFMatch _nullESFMatch = new ESFMatchImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFMatch> toCacheModel() {
				return _nullESFMatchCacheModel;
			}
		};

	private static CacheModel<ESFMatch> _nullESFMatchCacheModel = new CacheModel<ESFMatch>() {
			@Override
			public ESFMatch toEntityModel() {
				return _nullESFMatch;
			}
		};
}