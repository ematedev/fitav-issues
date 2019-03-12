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

import it.ethica.esf.NoSuchShooterCategoryESFMatchException;
import it.ethica.esf.model.ESFShooterCategoryESFMatch;
import it.ethica.esf.model.impl.ESFShooterCategoryESFMatchImpl;
import it.ethica.esf.model.impl.ESFShooterCategoryESFMatchModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f shooter category e s f match service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShooterCategoryESFMatchPersistence
 * @see ESFShooterCategoryESFMatchUtil
 * @generated
 */
public class ESFShooterCategoryESFMatchPersistenceImpl
	extends BasePersistenceImpl<ESFShooterCategoryESFMatch>
	implements ESFShooterCategoryESFMatchPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFShooterCategoryESFMatchUtil} to access the e s f shooter category e s f match persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFShooterCategoryESFMatchImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFShooterCategoryESFMatchModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the e s f shooter category e s f matchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter category e s f matchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f shooter category e s f matchs
	 * @param end the upper bound of the range of e s f shooter category e s f matchs (not inclusive)
	 * @return the range of matching e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter category e s f matchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f shooter category e s f matchs
	 * @param end the upper bound of the range of e s f shooter category e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFShooterCategoryESFMatch> list = (List<ESFShooterCategoryESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterCategoryESFMatch esfShooterCategoryESFMatch : list) {
				if (!Validator.equals(uuid, esfShooterCategoryESFMatch.getUuid())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFMATCH_WHERE);

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
				query.append(ESFShooterCategoryESFMatchModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFShooterCategoryESFMatch>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterCategoryESFMatch>(list);
				}
				else {
					list = (List<ESFShooterCategoryESFMatch>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter category e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfShooterCategoryESFMatch != null) {
			return esfShooterCategoryESFMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterCategoryESFMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter category e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter category e s f match, or <code>null</code> if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShooterCategoryESFMatch> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter category e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = fetchByUuid_Last(uuid,
				orderByComparator);

		if (esfShooterCategoryESFMatch != null) {
			return esfShooterCategoryESFMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterCategoryESFMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter category e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter category e s f match, or <code>null</code> if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFShooterCategoryESFMatch> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter category e s f matchs before and after the current e s f shooter category e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param esfShooterCategoryESFMatchPK the primary key of the current e s f shooter category e s f match
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a e s f shooter category e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch[] findByUuid_PrevAndNext(
		ESFShooterCategoryESFMatchPK esfShooterCategoryESFMatchPK, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = findByPrimaryKey(esfShooterCategoryESFMatchPK);

		Session session = null;

		try {
			session = openSession();

			ESFShooterCategoryESFMatch[] array = new ESFShooterCategoryESFMatchImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					esfShooterCategoryESFMatch, uuid, orderByComparator, true);

			array[1] = esfShooterCategoryESFMatch;

			array[2] = getByUuid_PrevAndNext(session,
					esfShooterCategoryESFMatch, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFShooterCategoryESFMatch getByUuid_PrevAndNext(
		Session session, ESFShooterCategoryESFMatch esfShooterCategoryESFMatch,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFMATCH_WHERE);

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
			query.append(ESFShooterCategoryESFMatchModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterCategoryESFMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterCategoryESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter category e s f matchs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFShooterCategoryESFMatch esfShooterCategoryESFMatch : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterCategoryESFMatch);
		}
	}

	/**
	 * Returns the number of e s f shooter category e s f matchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f shooter category e s f matchs
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

			query.append(_SQL_COUNT_ESFSHOOTERCATEGORYESFMATCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfShooterCategoryESFMatch.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfShooterCategoryESFMatch.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfShooterCategoryESFMatch.uuid IS NULL OR esfShooterCategoryESFMatch.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFShooterCategoryESFMatchModelImpl.UUID_COLUMN_BITMASK |
			ESFShooterCategoryESFMatchModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f shooter category e s f match where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchShooterCategoryESFMatchException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch findByUUID_G(String uuid, long groupId)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = fetchByUUID_G(uuid,
				groupId);

		if (esfShooterCategoryESFMatch == null) {
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

			throw new NoSuchShooterCategoryESFMatchException(msg.toString());
		}

		return esfShooterCategoryESFMatch;
	}

	/**
	 * Returns the e s f shooter category e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f shooter category e s f match, or <code>null</code> if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f shooter category e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f shooter category e s f match, or <code>null</code> if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFShooterCategoryESFMatch) {
			ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = (ESFShooterCategoryESFMatch)result;

			if (!Validator.equals(uuid, esfShooterCategoryESFMatch.getUuid()) ||
					(groupId != esfShooterCategoryESFMatch.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFMATCH_WHERE);

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

				List<ESFShooterCategoryESFMatch> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = list.get(0);

					result = esfShooterCategoryESFMatch;

					cacheResult(esfShooterCategoryESFMatch);

					if ((esfShooterCategoryESFMatch.getUuid() == null) ||
							!esfShooterCategoryESFMatch.getUuid().equals(uuid) ||
							(esfShooterCategoryESFMatch.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfShooterCategoryESFMatch);
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
			return (ESFShooterCategoryESFMatch)result;
		}
	}

	/**
	 * Removes the e s f shooter category e s f match where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f shooter category e s f match that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch removeByUUID_G(String uuid, long groupId)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = findByUUID_G(uuid,
				groupId);

		return remove(esfShooterCategoryESFMatch);
	}

	/**
	 * Returns the number of e s f shooter category e s f matchs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f shooter category e s f matchs
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

			query.append(_SQL_COUNT_ESFSHOOTERCATEGORYESFMATCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfShooterCategoryESFMatch.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfShooterCategoryESFMatch.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfShooterCategoryESFMatch.uuid IS NULL OR esfShooterCategoryESFMatch.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfShooterCategoryESFMatch.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFShooterCategoryESFMatchModelImpl.UUID_COLUMN_BITMASK |
			ESFShooterCategoryESFMatchModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f shooter category e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findByUuid_C(String uuid,
		long companyId) throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter category e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f shooter category e s f matchs
	 * @param end the upper bound of the range of e s f shooter category e s f matchs (not inclusive)
	 * @return the range of matching e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findByUuid_C(String uuid,
		long companyId, int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter category e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f shooter category e s f matchs
	 * @param end the upper bound of the range of e s f shooter category e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findByUuid_C(String uuid,
		long companyId, int start, int end, OrderByComparator orderByComparator)
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

		List<ESFShooterCategoryESFMatch> list = (List<ESFShooterCategoryESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterCategoryESFMatch esfShooterCategoryESFMatch : list) {
				if (!Validator.equals(uuid, esfShooterCategoryESFMatch.getUuid()) ||
						(companyId != esfShooterCategoryESFMatch.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFMATCH_WHERE);

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
				query.append(ESFShooterCategoryESFMatchModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFShooterCategoryESFMatch>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterCategoryESFMatch>(list);
				}
				else {
					list = (List<ESFShooterCategoryESFMatch>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter category e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch findByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (esfShooterCategoryESFMatch != null) {
			return esfShooterCategoryESFMatch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterCategoryESFMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter category e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter category e s f match, or <code>null</code> if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFShooterCategoryESFMatch> list = findByUuid_C(uuid, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter category e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch findByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (esfShooterCategoryESFMatch != null) {
			return esfShooterCategoryESFMatch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterCategoryESFMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter category e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter category e s f match, or <code>null</code> if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFShooterCategoryESFMatch> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter category e s f matchs before and after the current e s f shooter category e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfShooterCategoryESFMatchPK the primary key of the current e s f shooter category e s f match
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a e s f shooter category e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch[] findByUuid_C_PrevAndNext(
		ESFShooterCategoryESFMatchPK esfShooterCategoryESFMatchPK, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = findByPrimaryKey(esfShooterCategoryESFMatchPK);

		Session session = null;

		try {
			session = openSession();

			ESFShooterCategoryESFMatch[] array = new ESFShooterCategoryESFMatchImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session,
					esfShooterCategoryESFMatch, uuid, companyId,
					orderByComparator, true);

			array[1] = esfShooterCategoryESFMatch;

			array[2] = getByUuid_C_PrevAndNext(session,
					esfShooterCategoryESFMatch, uuid, companyId,
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

	protected ESFShooterCategoryESFMatch getByUuid_C_PrevAndNext(
		Session session, ESFShooterCategoryESFMatch esfShooterCategoryESFMatch,
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

		query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFMATCH_WHERE);

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
			query.append(ESFShooterCategoryESFMatchModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterCategoryESFMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterCategoryESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter category e s f matchs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFShooterCategoryESFMatch esfShooterCategoryESFMatch : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterCategoryESFMatch);
		}
	}

	/**
	 * Returns the number of e s f shooter category e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f shooter category e s f matchs
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

			query.append(_SQL_COUNT_ESFSHOOTERCATEGORYESFMATCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfShooterCategoryESFMatch.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfShooterCategoryESFMatch.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfShooterCategoryESFMatch.uuid IS NULL OR esfShooterCategoryESFMatch.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfShooterCategoryESFMatch.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCH = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFMatch",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH =
		new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFMatch",
			new String[] { Long.class.getName() },
			ESFShooterCategoryESFMatchModelImpl.ESFMATCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCH = new FinderPath(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMatch", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f shooter category e s f matchs where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findByESFMatch(long esfMatchId)
		throws SystemException {
		return findByESFMatch(esfMatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f shooter category e s f matchs where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f shooter category e s f matchs
	 * @param end the upper bound of the range of e s f shooter category e s f matchs (not inclusive)
	 * @return the range of matching e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findByESFMatch(long esfMatchId,
		int start, int end) throws SystemException {
		return findByESFMatch(esfMatchId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter category e s f matchs where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f shooter category e s f matchs
	 * @param end the upper bound of the range of e s f shooter category e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findByESFMatch(long esfMatchId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH;
			finderArgs = new Object[] { esfMatchId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCH;
			finderArgs = new Object[] { esfMatchId, start, end, orderByComparator };
		}

		List<ESFShooterCategoryESFMatch> list = (List<ESFShooterCategoryESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterCategoryESFMatch esfShooterCategoryESFMatch : list) {
				if ((esfMatchId != esfShooterCategoryESFMatch.getEsfMatchId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCH_ESFMATCHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShooterCategoryESFMatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (!pagination) {
					list = (List<ESFShooterCategoryESFMatch>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterCategoryESFMatch>(list);
				}
				else {
					list = (List<ESFShooterCategoryESFMatch>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter category e s f match in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch findByESFMatch_First(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = fetchByESFMatch_First(esfMatchId,
				orderByComparator);

		if (esfShooterCategoryESFMatch != null) {
			return esfShooterCategoryESFMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterCategoryESFMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter category e s f match in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter category e s f match, or <code>null</code> if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch fetchByESFMatch_First(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShooterCategoryESFMatch> list = findByESFMatch(esfMatchId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter category e s f match in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch findByESFMatch_Last(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = fetchByESFMatch_Last(esfMatchId,
				orderByComparator);

		if (esfShooterCategoryESFMatch != null) {
			return esfShooterCategoryESFMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterCategoryESFMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter category e s f match in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter category e s f match, or <code>null</code> if a matching e s f shooter category e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch fetchByESFMatch_Last(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMatch(esfMatchId);

		if (count == 0) {
			return null;
		}

		List<ESFShooterCategoryESFMatch> list = findByESFMatch(esfMatchId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter category e s f matchs before and after the current e s f shooter category e s f match in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfShooterCategoryESFMatchPK the primary key of the current e s f shooter category e s f match
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a e s f shooter category e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch[] findByESFMatch_PrevAndNext(
		ESFShooterCategoryESFMatchPK esfShooterCategoryESFMatchPK,
		long esfMatchId, OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = findByPrimaryKey(esfShooterCategoryESFMatchPK);

		Session session = null;

		try {
			session = openSession();

			ESFShooterCategoryESFMatch[] array = new ESFShooterCategoryESFMatchImpl[3];

			array[0] = getByESFMatch_PrevAndNext(session,
					esfShooterCategoryESFMatch, esfMatchId, orderByComparator,
					true);

			array[1] = esfShooterCategoryESFMatch;

			array[2] = getByESFMatch_PrevAndNext(session,
					esfShooterCategoryESFMatch, esfMatchId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFShooterCategoryESFMatch getByESFMatch_PrevAndNext(
		Session session, ESFShooterCategoryESFMatch esfShooterCategoryESFMatch,
		long esfMatchId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFMATCH_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCH_ESFMATCHID_2);

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
			query.append(ESFShooterCategoryESFMatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterCategoryESFMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterCategoryESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter category e s f matchs where esfMatchId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatch(long esfMatchId) throws SystemException {
		for (ESFShooterCategoryESFMatch esfShooterCategoryESFMatch : findByESFMatch(
				esfMatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterCategoryESFMatch);
		}
	}

	/**
	 * Returns the number of e s f shooter category e s f matchs where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the number of matching e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMatch(long esfMatchId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCH;

		Object[] finderArgs = new Object[] { esfMatchId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSHOOTERCATEGORYESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCH_ESFMATCHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

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

	private static final String _FINDER_COLUMN_ESFMATCH_ESFMATCHID_2 = "esfShooterCategoryESFMatch.id.esfMatchId = ?";

	public ESFShooterCategoryESFMatchPersistenceImpl() {
		setModelClass(ESFShooterCategoryESFMatch.class);
	}

	/**
	 * Caches the e s f shooter category e s f match in the entity cache if it is enabled.
	 *
	 * @param esfShooterCategoryESFMatch the e s f shooter category e s f match
	 */
	@Override
	public void cacheResult(
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch) {
		EntityCacheUtil.putResult(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class,
			esfShooterCategoryESFMatch.getPrimaryKey(),
			esfShooterCategoryESFMatch);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				esfShooterCategoryESFMatch.getUuid(),
				esfShooterCategoryESFMatch.getGroupId()
			}, esfShooterCategoryESFMatch);

		esfShooterCategoryESFMatch.resetOriginalValues();
	}

	/**
	 * Caches the e s f shooter category e s f matchs in the entity cache if it is enabled.
	 *
	 * @param esfShooterCategoryESFMatchs the e s f shooter category e s f matchs
	 */
	@Override
	public void cacheResult(
		List<ESFShooterCategoryESFMatch> esfShooterCategoryESFMatchs) {
		for (ESFShooterCategoryESFMatch esfShooterCategoryESFMatch : esfShooterCategoryESFMatchs) {
			if (EntityCacheUtil.getResult(
						ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterCategoryESFMatchImpl.class,
						esfShooterCategoryESFMatch.getPrimaryKey()) == null) {
				cacheResult(esfShooterCategoryESFMatch);
			}
			else {
				esfShooterCategoryESFMatch.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f shooter category e s f matchs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFShooterCategoryESFMatchImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFShooterCategoryESFMatchImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f shooter category e s f match.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch) {
		EntityCacheUtil.removeResult(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class,
			esfShooterCategoryESFMatch.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfShooterCategoryESFMatch);
	}

	@Override
	public void clearCache(
		List<ESFShooterCategoryESFMatch> esfShooterCategoryESFMatchs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFShooterCategoryESFMatch esfShooterCategoryESFMatch : esfShooterCategoryESFMatchs) {
			EntityCacheUtil.removeResult(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterCategoryESFMatchImpl.class,
				esfShooterCategoryESFMatch.getPrimaryKey());

			clearUniqueFindersCache(esfShooterCategoryESFMatch);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch) {
		if (esfShooterCategoryESFMatch.isNew()) {
			Object[] args = new Object[] {
					esfShooterCategoryESFMatch.getUuid(),
					esfShooterCategoryESFMatch.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfShooterCategoryESFMatch);
		}
		else {
			ESFShooterCategoryESFMatchModelImpl esfShooterCategoryESFMatchModelImpl =
				(ESFShooterCategoryESFMatchModelImpl)esfShooterCategoryESFMatch;

			if ((esfShooterCategoryESFMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterCategoryESFMatch.getUuid(),
						esfShooterCategoryESFMatch.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfShooterCategoryESFMatch);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch) {
		ESFShooterCategoryESFMatchModelImpl esfShooterCategoryESFMatchModelImpl = (ESFShooterCategoryESFMatchModelImpl)esfShooterCategoryESFMatch;

		Object[] args = new Object[] {
				esfShooterCategoryESFMatch.getUuid(),
				esfShooterCategoryESFMatch.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfShooterCategoryESFMatchModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfShooterCategoryESFMatchModelImpl.getOriginalUuid(),
					esfShooterCategoryESFMatchModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f shooter category e s f match with the primary key. Does not add the e s f shooter category e s f match to the database.
	 *
	 * @param esfShooterCategoryESFMatchPK the primary key for the new e s f shooter category e s f match
	 * @return the new e s f shooter category e s f match
	 */
	@Override
	public ESFShooterCategoryESFMatch create(
		ESFShooterCategoryESFMatchPK esfShooterCategoryESFMatchPK) {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = new ESFShooterCategoryESFMatchImpl();

		esfShooterCategoryESFMatch.setNew(true);
		esfShooterCategoryESFMatch.setPrimaryKey(esfShooterCategoryESFMatchPK);

		String uuid = PortalUUIDUtil.generate();

		esfShooterCategoryESFMatch.setUuid(uuid);

		return esfShooterCategoryESFMatch;
	}

	/**
	 * Removes the e s f shooter category e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfShooterCategoryESFMatchPK the primary key of the e s f shooter category e s f match
	 * @return the e s f shooter category e s f match that was removed
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a e s f shooter category e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch remove(
		ESFShooterCategoryESFMatchPK esfShooterCategoryESFMatchPK)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		return remove((Serializable)esfShooterCategoryESFMatchPK);
	}

	/**
	 * Removes the e s f shooter category e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f shooter category e s f match
	 * @return the e s f shooter category e s f match that was removed
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a e s f shooter category e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch remove(Serializable primaryKey)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = (ESFShooterCategoryESFMatch)session.get(ESFShooterCategoryESFMatchImpl.class,
					primaryKey);

			if (esfShooterCategoryESFMatch == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShooterCategoryESFMatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfShooterCategoryESFMatch);
		}
		catch (NoSuchShooterCategoryESFMatchException nsee) {
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
	protected ESFShooterCategoryESFMatch removeImpl(
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch)
		throws SystemException {
		esfShooterCategoryESFMatch = toUnwrappedModel(esfShooterCategoryESFMatch);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfShooterCategoryESFMatch)) {
				esfShooterCategoryESFMatch = (ESFShooterCategoryESFMatch)session.get(ESFShooterCategoryESFMatchImpl.class,
						esfShooterCategoryESFMatch.getPrimaryKeyObj());
			}

			if (esfShooterCategoryESFMatch != null) {
				session.delete(esfShooterCategoryESFMatch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfShooterCategoryESFMatch != null) {
			clearCache(esfShooterCategoryESFMatch);
		}

		return esfShooterCategoryESFMatch;
	}

	@Override
	public ESFShooterCategoryESFMatch updateImpl(
		it.ethica.esf.model.ESFShooterCategoryESFMatch esfShooterCategoryESFMatch)
		throws SystemException {
		esfShooterCategoryESFMatch = toUnwrappedModel(esfShooterCategoryESFMatch);

		boolean isNew = esfShooterCategoryESFMatch.isNew();

		ESFShooterCategoryESFMatchModelImpl esfShooterCategoryESFMatchModelImpl = (ESFShooterCategoryESFMatchModelImpl)esfShooterCategoryESFMatch;

		if (Validator.isNull(esfShooterCategoryESFMatch.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfShooterCategoryESFMatch.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfShooterCategoryESFMatch.isNew()) {
				session.save(esfShooterCategoryESFMatch);

				esfShooterCategoryESFMatch.setNew(false);
			}
			else {
				session.merge(esfShooterCategoryESFMatch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!ESFShooterCategoryESFMatchModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfShooterCategoryESFMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterCategoryESFMatchModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						esfShooterCategoryESFMatchModelImpl.getUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfShooterCategoryESFMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterCategoryESFMatchModelImpl.getOriginalUuid(),
						esfShooterCategoryESFMatchModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfShooterCategoryESFMatchModelImpl.getUuid(),
						esfShooterCategoryESFMatchModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfShooterCategoryESFMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterCategoryESFMatchModelImpl.getOriginalEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH,
					args);

				args = new Object[] {
						esfShooterCategoryESFMatchModelImpl.getEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFMatchImpl.class,
			esfShooterCategoryESFMatch.getPrimaryKey(),
			esfShooterCategoryESFMatch);

		clearUniqueFindersCache(esfShooterCategoryESFMatch);
		cacheUniqueFindersCache(esfShooterCategoryESFMatch);

		return esfShooterCategoryESFMatch;
	}

	protected ESFShooterCategoryESFMatch toUnwrappedModel(
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch) {
		if (esfShooterCategoryESFMatch instanceof ESFShooterCategoryESFMatchImpl) {
			return esfShooterCategoryESFMatch;
		}

		ESFShooterCategoryESFMatchImpl esfShooterCategoryESFMatchImpl = new ESFShooterCategoryESFMatchImpl();

		esfShooterCategoryESFMatchImpl.setNew(esfShooterCategoryESFMatch.isNew());
		esfShooterCategoryESFMatchImpl.setPrimaryKey(esfShooterCategoryESFMatch.getPrimaryKey());

		esfShooterCategoryESFMatchImpl.setUuid(esfShooterCategoryESFMatch.getUuid());
		esfShooterCategoryESFMatchImpl.setEsfShooterCategoryId(esfShooterCategoryESFMatch.getEsfShooterCategoryId());
		esfShooterCategoryESFMatchImpl.setEsfMatchId(esfShooterCategoryESFMatch.getEsfMatchId());
		esfShooterCategoryESFMatchImpl.setGroupId(esfShooterCategoryESFMatch.getGroupId());
		esfShooterCategoryESFMatchImpl.setCompanyId(esfShooterCategoryESFMatch.getCompanyId());
		esfShooterCategoryESFMatchImpl.setUserId(esfShooterCategoryESFMatch.getUserId());
		esfShooterCategoryESFMatchImpl.setUserName(esfShooterCategoryESFMatch.getUserName());
		esfShooterCategoryESFMatchImpl.setCreateDate(esfShooterCategoryESFMatch.getCreateDate());
		esfShooterCategoryESFMatchImpl.setModifiedDate(esfShooterCategoryESFMatch.getModifiedDate());

		return esfShooterCategoryESFMatchImpl;
	}

	/**
	 * Returns the e s f shooter category e s f match with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter category e s f match
	 * @return the e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a e s f shooter category e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = fetchByPrimaryKey(primaryKey);

		if (esfShooterCategoryESFMatch == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShooterCategoryESFMatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfShooterCategoryESFMatch;
	}

	/**
	 * Returns the e s f shooter category e s f match with the primary key or throws a {@link it.ethica.esf.NoSuchShooterCategoryESFMatchException} if it could not be found.
	 *
	 * @param esfShooterCategoryESFMatchPK the primary key of the e s f shooter category e s f match
	 * @return the e s f shooter category e s f match
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFMatchException if a e s f shooter category e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch findByPrimaryKey(
		ESFShooterCategoryESFMatchPK esfShooterCategoryESFMatchPK)
		throws NoSuchShooterCategoryESFMatchException, SystemException {
		return findByPrimaryKey((Serializable)esfShooterCategoryESFMatchPK);
	}

	/**
	 * Returns the e s f shooter category e s f match with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter category e s f match
	 * @return the e s f shooter category e s f match, or <code>null</code> if a e s f shooter category e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch = (ESFShooterCategoryESFMatch)EntityCacheUtil.getResult(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterCategoryESFMatchImpl.class, primaryKey);

		if (esfShooterCategoryESFMatch == _nullESFShooterCategoryESFMatch) {
			return null;
		}

		if (esfShooterCategoryESFMatch == null) {
			Session session = null;

			try {
				session = openSession();

				esfShooterCategoryESFMatch = (ESFShooterCategoryESFMatch)session.get(ESFShooterCategoryESFMatchImpl.class,
						primaryKey);

				if (esfShooterCategoryESFMatch != null) {
					cacheResult(esfShooterCategoryESFMatch);
				}
				else {
					EntityCacheUtil.putResult(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterCategoryESFMatchImpl.class, primaryKey,
						_nullESFShooterCategoryESFMatch);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFShooterCategoryESFMatchModelImpl.ENTITY_CACHE_ENABLED,
					ESFShooterCategoryESFMatchImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfShooterCategoryESFMatch;
	}

	/**
	 * Returns the e s f shooter category e s f match with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfShooterCategoryESFMatchPK the primary key of the e s f shooter category e s f match
	 * @return the e s f shooter category e s f match, or <code>null</code> if a e s f shooter category e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFMatch fetchByPrimaryKey(
		ESFShooterCategoryESFMatchPK esfShooterCategoryESFMatchPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfShooterCategoryESFMatchPK);
	}

	/**
	 * Returns all the e s f shooter category e s f matchs.
	 *
	 * @return the e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter category e s f matchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter category e s f matchs
	 * @param end the upper bound of the range of e s f shooter category e s f matchs (not inclusive)
	 * @return the range of e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter category e s f matchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter category e s f matchs
	 * @param end the upper bound of the range of e s f shooter category e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f shooter category e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFMatch> findAll(int start, int end,
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

		List<ESFShooterCategoryESFMatch> list = (List<ESFShooterCategoryESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFMATCH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSHOOTERCATEGORYESFMATCH;

				if (pagination) {
					sql = sql.concat(ESFShooterCategoryESFMatchModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFShooterCategoryESFMatch>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterCategoryESFMatch>(list);
				}
				else {
					list = (List<ESFShooterCategoryESFMatch>)QueryUtil.list(q,
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
	 * Removes all the e s f shooter category e s f matchs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFShooterCategoryESFMatch esfShooterCategoryESFMatch : findAll()) {
			remove(esfShooterCategoryESFMatch);
		}
	}

	/**
	 * Returns the number of e s f shooter category e s f matchs.
	 *
	 * @return the number of e s f shooter category e s f matchs
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

				Query q = session.createQuery(_SQL_COUNT_ESFSHOOTERCATEGORYESFMATCH);

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
	 * Initializes the e s f shooter category e s f match persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFShooterCategoryESFMatch")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFShooterCategoryESFMatch>> listenersList = new ArrayList<ModelListener<ESFShooterCategoryESFMatch>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFShooterCategoryESFMatch>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFShooterCategoryESFMatchImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSHOOTERCATEGORYESFMATCH = "SELECT esfShooterCategoryESFMatch FROM ESFShooterCategoryESFMatch esfShooterCategoryESFMatch";
	private static final String _SQL_SELECT_ESFSHOOTERCATEGORYESFMATCH_WHERE = "SELECT esfShooterCategoryESFMatch FROM ESFShooterCategoryESFMatch esfShooterCategoryESFMatch WHERE ";
	private static final String _SQL_COUNT_ESFSHOOTERCATEGORYESFMATCH = "SELECT COUNT(esfShooterCategoryESFMatch) FROM ESFShooterCategoryESFMatch esfShooterCategoryESFMatch";
	private static final String _SQL_COUNT_ESFSHOOTERCATEGORYESFMATCH_WHERE = "SELECT COUNT(esfShooterCategoryESFMatch) FROM ESFShooterCategoryESFMatch esfShooterCategoryESFMatch WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfShooterCategoryESFMatch.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFShooterCategoryESFMatch exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFShooterCategoryESFMatch exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFShooterCategoryESFMatchPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFShooterCategoryESFMatch _nullESFShooterCategoryESFMatch = new ESFShooterCategoryESFMatchImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFShooterCategoryESFMatch> toCacheModel() {
				return _nullESFShooterCategoryESFMatchCacheModel;
			}
		};

	private static CacheModel<ESFShooterCategoryESFMatch> _nullESFShooterCategoryESFMatchCacheModel =
		new CacheModel<ESFShooterCategoryESFMatch>() {
			@Override
			public ESFShooterCategoryESFMatch toEntityModel() {
				return _nullESFShooterCategoryESFMatch;
			}
		};
}