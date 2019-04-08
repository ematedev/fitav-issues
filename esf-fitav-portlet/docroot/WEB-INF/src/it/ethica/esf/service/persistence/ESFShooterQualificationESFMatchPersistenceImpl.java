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

import it.ethica.esf.NoSuchShooterQualificationESFMatchException;
import it.ethica.esf.model.ESFShooterQualificationESFMatch;
import it.ethica.esf.model.impl.ESFShooterQualificationESFMatchImpl;
import it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f shooter qualification e s f match service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShooterQualificationESFMatchPersistence
 * @see ESFShooterQualificationESFMatchUtil
 * @generated
 */
public class ESFShooterQualificationESFMatchPersistenceImpl
	extends BasePersistenceImpl<ESFShooterQualificationESFMatch>
	implements ESFShooterQualificationESFMatchPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFShooterQualificationESFMatchUtil} to access the e s f shooter qualification e s f match persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFShooterQualificationESFMatchImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFShooterQualificationESFMatchModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the e s f shooter qualification e s f matchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter qualification e s f matchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f shooter qualification e s f matchs
	 * @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	 * @return the range of matching e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findByUuid(String uuid,
		int start, int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter qualification e s f matchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f shooter qualification e s f matchs
	 * @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findByUuid(String uuid,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ESFShooterQualificationESFMatch> list = (List<ESFShooterQualificationESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterQualificationESFMatch esfShooterQualificationESFMatch : list) {
				if (!Validator.equals(uuid,
							esfShooterQualificationESFMatch.getUuid())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE);

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
				query.append(ESFShooterQualificationESFMatchModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFShooterQualificationESFMatch>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterQualificationESFMatch>(list);
				}
				else {
					list = (List<ESFShooterQualificationESFMatch>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter qualification e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfShooterQualificationESFMatch != null) {
			return esfShooterQualificationESFMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationESFMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter qualification e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShooterQualificationESFMatch> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter qualification e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = fetchByUuid_Last(uuid,
				orderByComparator);

		if (esfShooterQualificationESFMatch != null) {
			return esfShooterQualificationESFMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationESFMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter qualification e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFShooterQualificationESFMatch> list = findByUuid(uuid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter qualification e s f matchs before and after the current e s f shooter qualification e s f match in the ordered set where uuid = &#63;.
	 *
	 * @param esfShooterQualificationESFMatchPK the primary key of the current e s f shooter qualification e s f match
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch[] findByUuid_PrevAndNext(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = findByPrimaryKey(esfShooterQualificationESFMatchPK);

		Session session = null;

		try {
			session = openSession();

			ESFShooterQualificationESFMatch[] array = new ESFShooterQualificationESFMatchImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					esfShooterQualificationESFMatch, uuid, orderByComparator,
					true);

			array[1] = esfShooterQualificationESFMatch;

			array[2] = getByUuid_PrevAndNext(session,
					esfShooterQualificationESFMatch, uuid, orderByComparator,
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

	protected ESFShooterQualificationESFMatch getByUuid_PrevAndNext(
		Session session,
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE);

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
			query.append(ESFShooterQualificationESFMatchModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterQualificationESFMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterQualificationESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter qualification e s f matchs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFShooterQualificationESFMatch esfShooterQualificationESFMatch : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterQualificationESFMatch);
		}
	}

	/**
	 * Returns the number of e s f shooter qualification e s f matchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f shooter qualification e s f matchs
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

			query.append(_SQL_COUNT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfShooterQualificationESFMatch.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfShooterQualificationESFMatch.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfShooterQualificationESFMatch.uuid IS NULL OR esfShooterQualificationESFMatch.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFShooterQualificationESFMatchModelImpl.UUID_COLUMN_BITMASK |
			ESFShooterQualificationESFMatchModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f shooter qualification e s f match where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchShooterQualificationESFMatchException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch findByUUID_G(String uuid,
		long groupId)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = fetchByUUID_G(uuid,
				groupId);

		if (esfShooterQualificationESFMatch == null) {
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

			throw new NoSuchShooterQualificationESFMatchException(msg.toString());
		}

		return esfShooterQualificationESFMatch;
	}

	/**
	 * Returns the e s f shooter qualification e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch fetchByUUID_G(String uuid,
		long groupId) throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f shooter qualification e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch fetchByUUID_G(String uuid,
		long groupId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFShooterQualificationESFMatch) {
			ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = (ESFShooterQualificationESFMatch)result;

			if (!Validator.equals(uuid,
						esfShooterQualificationESFMatch.getUuid()) ||
					(groupId != esfShooterQualificationESFMatch.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE);

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

				List<ESFShooterQualificationESFMatch> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFShooterQualificationESFMatch esfShooterQualificationESFMatch =
						list.get(0);

					result = esfShooterQualificationESFMatch;

					cacheResult(esfShooterQualificationESFMatch);

					if ((esfShooterQualificationESFMatch.getUuid() == null) ||
							!esfShooterQualificationESFMatch.getUuid()
																.equals(uuid) ||
							(esfShooterQualificationESFMatch.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfShooterQualificationESFMatch);
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
			return (ESFShooterQualificationESFMatch)result;
		}
	}

	/**
	 * Removes the e s f shooter qualification e s f match where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f shooter qualification e s f match that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch removeByUUID_G(String uuid,
		long groupId)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = findByUUID_G(uuid,
				groupId);

		return remove(esfShooterQualificationESFMatch);
	}

	/**
	 * Returns the number of e s f shooter qualification e s f matchs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f shooter qualification e s f matchs
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

			query.append(_SQL_COUNT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfShooterQualificationESFMatch.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfShooterQualificationESFMatch.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfShooterQualificationESFMatch.uuid IS NULL OR esfShooterQualificationESFMatch.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfShooterQualificationESFMatch.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFShooterQualificationESFMatchModelImpl.UUID_COLUMN_BITMASK |
			ESFShooterQualificationESFMatchModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f shooter qualification e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findByUuid_C(String uuid,
		long companyId) throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter qualification e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f shooter qualification e s f matchs
	 * @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	 * @return the range of matching e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findByUuid_C(String uuid,
		long companyId, int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter qualification e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f shooter qualification e s f matchs
	 * @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findByUuid_C(String uuid,
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

		List<ESFShooterQualificationESFMatch> list = (List<ESFShooterQualificationESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterQualificationESFMatch esfShooterQualificationESFMatch : list) {
				if (!Validator.equals(uuid,
							esfShooterQualificationESFMatch.getUuid()) ||
						(companyId != esfShooterQualificationESFMatch.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE);

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
				query.append(ESFShooterQualificationESFMatchModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFShooterQualificationESFMatch>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterQualificationESFMatch>(list);
				}
				else {
					list = (List<ESFShooterQualificationESFMatch>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter qualification e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch findByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (esfShooterQualificationESFMatch != null) {
			return esfShooterQualificationESFMatch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationESFMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter qualification e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFShooterQualificationESFMatch> list = findByUuid_C(uuid,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter qualification e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch findByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (esfShooterQualificationESFMatch != null) {
			return esfShooterQualificationESFMatch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationESFMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter qualification e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFShooterQualificationESFMatch> list = findByUuid_C(uuid,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter qualification e s f matchs before and after the current e s f shooter qualification e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfShooterQualificationESFMatchPK the primary key of the current e s f shooter qualification e s f match
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch[] findByUuid_C_PrevAndNext(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = findByPrimaryKey(esfShooterQualificationESFMatchPK);

		Session session = null;

		try {
			session = openSession();

			ESFShooterQualificationESFMatch[] array = new ESFShooterQualificationESFMatchImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session,
					esfShooterQualificationESFMatch, uuid, companyId,
					orderByComparator, true);

			array[1] = esfShooterQualificationESFMatch;

			array[2] = getByUuid_C_PrevAndNext(session,
					esfShooterQualificationESFMatch, uuid, companyId,
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

	protected ESFShooterQualificationESFMatch getByUuid_C_PrevAndNext(
		Session session,
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch,
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

		query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE);

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
			query.append(ESFShooterQualificationESFMatchModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterQualificationESFMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterQualificationESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter qualification e s f matchs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFShooterQualificationESFMatch esfShooterQualificationESFMatch : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterQualificationESFMatch);
		}
	}

	/**
	 * Returns the number of e s f shooter qualification e s f matchs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f shooter qualification e s f matchs
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

			query.append(_SQL_COUNT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfShooterQualificationESFMatch.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfShooterQualificationESFMatch.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfShooterQualificationESFMatch.uuid IS NULL OR esfShooterQualificationESFMatch.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfShooterQualificationESFMatch.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCH = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFMatch",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH =
		new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFMatch",
			new String[] { Long.class.getName() },
			ESFShooterQualificationESFMatchModelImpl.ESFMATCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCH = new FinderPath(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMatch", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f shooter qualification e s f matchs where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findByESFMatch(long esfMatchId)
		throws SystemException {
		return findByESFMatch(esfMatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f shooter qualification e s f matchs where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f shooter qualification e s f matchs
	 * @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	 * @return the range of matching e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findByESFMatch(
		long esfMatchId, int start, int end) throws SystemException {
		return findByESFMatch(esfMatchId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter qualification e s f matchs where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f shooter qualification e s f matchs
	 * @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findByESFMatch(
		long esfMatchId, int start, int end, OrderByComparator orderByComparator)
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

		List<ESFShooterQualificationESFMatch> list = (List<ESFShooterQualificationESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterQualificationESFMatch esfShooterQualificationESFMatch : list) {
				if ((esfMatchId != esfShooterQualificationESFMatch.getEsfMatchId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCH_ESFMATCHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShooterQualificationESFMatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (!pagination) {
					list = (List<ESFShooterQualificationESFMatch>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterQualificationESFMatch>(list);
				}
				else {
					list = (List<ESFShooterQualificationESFMatch>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter qualification e s f match in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch findByESFMatch_First(
		long esfMatchId, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = fetchByESFMatch_First(esfMatchId,
				orderByComparator);

		if (esfShooterQualificationESFMatch != null) {
			return esfShooterQualificationESFMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationESFMatchException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter qualification e s f match in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch fetchByESFMatch_First(
		long esfMatchId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFShooterQualificationESFMatch> list = findByESFMatch(esfMatchId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter qualification e s f match in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch findByESFMatch_Last(
		long esfMatchId, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = fetchByESFMatch_Last(esfMatchId,
				orderByComparator);

		if (esfShooterQualificationESFMatch != null) {
			return esfShooterQualificationESFMatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationESFMatchException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter qualification e s f match in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch fetchByESFMatch_Last(
		long esfMatchId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFMatch(esfMatchId);

		if (count == 0) {
			return null;
		}

		List<ESFShooterQualificationESFMatch> list = findByESFMatch(esfMatchId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter qualification e s f matchs before and after the current e s f shooter qualification e s f match in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfShooterQualificationESFMatchPK the primary key of the current e s f shooter qualification e s f match
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch[] findByESFMatch_PrevAndNext(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK,
		long esfMatchId, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = findByPrimaryKey(esfShooterQualificationESFMatchPK);

		Session session = null;

		try {
			session = openSession();

			ESFShooterQualificationESFMatch[] array = new ESFShooterQualificationESFMatchImpl[3];

			array[0] = getByESFMatch_PrevAndNext(session,
					esfShooterQualificationESFMatch, esfMatchId,
					orderByComparator, true);

			array[1] = esfShooterQualificationESFMatch;

			array[2] = getByESFMatch_PrevAndNext(session,
					esfShooterQualificationESFMatch, esfMatchId,
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

	protected ESFShooterQualificationESFMatch getByESFMatch_PrevAndNext(
		Session session,
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch,
		long esfMatchId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE);

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
			query.append(ESFShooterQualificationESFMatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterQualificationESFMatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterQualificationESFMatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter qualification e s f matchs where esfMatchId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatch(long esfMatchId) throws SystemException {
		for (ESFShooterQualificationESFMatch esfShooterQualificationESFMatch : findByESFMatch(
				esfMatchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterQualificationESFMatch);
		}
	}

	/**
	 * Returns the number of e s f shooter qualification e s f matchs where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the number of matching e s f shooter qualification e s f matchs
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

			query.append(_SQL_COUNT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE);

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

	private static final String _FINDER_COLUMN_ESFMATCH_ESFMATCHID_2 = "esfShooterQualificationESFMatch.id.esfMatchId = ?";

	public ESFShooterQualificationESFMatchPersistenceImpl() {
		setModelClass(ESFShooterQualificationESFMatch.class);
	}

	/**
	 * Caches the e s f shooter qualification e s f match in the entity cache if it is enabled.
	 *
	 * @param esfShooterQualificationESFMatch the e s f shooter qualification e s f match
	 */
	@Override
	public void cacheResult(
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch) {
		EntityCacheUtil.putResult(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			esfShooterQualificationESFMatch.getPrimaryKey(),
			esfShooterQualificationESFMatch);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				esfShooterQualificationESFMatch.getUuid(),
				esfShooterQualificationESFMatch.getGroupId()
			}, esfShooterQualificationESFMatch);

		esfShooterQualificationESFMatch.resetOriginalValues();
	}

	/**
	 * Caches the e s f shooter qualification e s f matchs in the entity cache if it is enabled.
	 *
	 * @param esfShooterQualificationESFMatchs the e s f shooter qualification e s f matchs
	 */
	@Override
	public void cacheResult(
		List<ESFShooterQualificationESFMatch> esfShooterQualificationESFMatchs) {
		for (ESFShooterQualificationESFMatch esfShooterQualificationESFMatch : esfShooterQualificationESFMatchs) {
			if (EntityCacheUtil.getResult(
						ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterQualificationESFMatchImpl.class,
						esfShooterQualificationESFMatch.getPrimaryKey()) == null) {
				cacheResult(esfShooterQualificationESFMatch);
			}
			else {
				esfShooterQualificationESFMatch.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f shooter qualification e s f matchs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFShooterQualificationESFMatchImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFShooterQualificationESFMatchImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f shooter qualification e s f match.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch) {
		EntityCacheUtil.removeResult(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			esfShooterQualificationESFMatch.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfShooterQualificationESFMatch);
	}

	@Override
	public void clearCache(
		List<ESFShooterQualificationESFMatch> esfShooterQualificationESFMatchs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFShooterQualificationESFMatch esfShooterQualificationESFMatch : esfShooterQualificationESFMatchs) {
			EntityCacheUtil.removeResult(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterQualificationESFMatchImpl.class,
				esfShooterQualificationESFMatch.getPrimaryKey());

			clearUniqueFindersCache(esfShooterQualificationESFMatch);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch) {
		if (esfShooterQualificationESFMatch.isNew()) {
			Object[] args = new Object[] {
					esfShooterQualificationESFMatch.getUuid(),
					esfShooterQualificationESFMatch.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfShooterQualificationESFMatch);
		}
		else {
			ESFShooterQualificationESFMatchModelImpl esfShooterQualificationESFMatchModelImpl =
				(ESFShooterQualificationESFMatchModelImpl)esfShooterQualificationESFMatch;

			if ((esfShooterQualificationESFMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterQualificationESFMatch.getUuid(),
						esfShooterQualificationESFMatch.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfShooterQualificationESFMatch);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch) {
		ESFShooterQualificationESFMatchModelImpl esfShooterQualificationESFMatchModelImpl =
			(ESFShooterQualificationESFMatchModelImpl)esfShooterQualificationESFMatch;

		Object[] args = new Object[] {
				esfShooterQualificationESFMatch.getUuid(),
				esfShooterQualificationESFMatch.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfShooterQualificationESFMatchModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfShooterQualificationESFMatchModelImpl.getOriginalUuid(),
					esfShooterQualificationESFMatchModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f shooter qualification e s f match with the primary key. Does not add the e s f shooter qualification e s f match to the database.
	 *
	 * @param esfShooterQualificationESFMatchPK the primary key for the new e s f shooter qualification e s f match
	 * @return the new e s f shooter qualification e s f match
	 */
	@Override
	public ESFShooterQualificationESFMatch create(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK) {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = new ESFShooterQualificationESFMatchImpl();

		esfShooterQualificationESFMatch.setNew(true);
		esfShooterQualificationESFMatch.setPrimaryKey(esfShooterQualificationESFMatchPK);

		String uuid = PortalUUIDUtil.generate();

		esfShooterQualificationESFMatch.setUuid(uuid);

		return esfShooterQualificationESFMatch;
	}

	/**
	 * Removes the e s f shooter qualification e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfShooterQualificationESFMatchPK the primary key of the e s f shooter qualification e s f match
	 * @return the e s f shooter qualification e s f match that was removed
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch remove(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		return remove((Serializable)esfShooterQualificationESFMatchPK);
	}

	/**
	 * Removes the e s f shooter qualification e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f shooter qualification e s f match
	 * @return the e s f shooter qualification e s f match that was removed
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch remove(Serializable primaryKey)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = (ESFShooterQualificationESFMatch)session.get(ESFShooterQualificationESFMatchImpl.class,
					primaryKey);

			if (esfShooterQualificationESFMatch == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShooterQualificationESFMatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfShooterQualificationESFMatch);
		}
		catch (NoSuchShooterQualificationESFMatchException nsee) {
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
	protected ESFShooterQualificationESFMatch removeImpl(
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch)
		throws SystemException {
		esfShooterQualificationESFMatch = toUnwrappedModel(esfShooterQualificationESFMatch);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfShooterQualificationESFMatch)) {
				esfShooterQualificationESFMatch = (ESFShooterQualificationESFMatch)session.get(ESFShooterQualificationESFMatchImpl.class,
						esfShooterQualificationESFMatch.getPrimaryKeyObj());
			}

			if (esfShooterQualificationESFMatch != null) {
				session.delete(esfShooterQualificationESFMatch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfShooterQualificationESFMatch != null) {
			clearCache(esfShooterQualificationESFMatch);
		}

		return esfShooterQualificationESFMatch;
	}

	@Override
	public ESFShooterQualificationESFMatch updateImpl(
		it.ethica.esf.model.ESFShooterQualificationESFMatch esfShooterQualificationESFMatch)
		throws SystemException {
		esfShooterQualificationESFMatch = toUnwrappedModel(esfShooterQualificationESFMatch);

		boolean isNew = esfShooterQualificationESFMatch.isNew();

		ESFShooterQualificationESFMatchModelImpl esfShooterQualificationESFMatchModelImpl =
			(ESFShooterQualificationESFMatchModelImpl)esfShooterQualificationESFMatch;

		if (Validator.isNull(esfShooterQualificationESFMatch.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfShooterQualificationESFMatch.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfShooterQualificationESFMatch.isNew()) {
				session.save(esfShooterQualificationESFMatch);

				esfShooterQualificationESFMatch.setNew(false);
			}
			else {
				session.merge(esfShooterQualificationESFMatch);
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
				!ESFShooterQualificationESFMatchModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfShooterQualificationESFMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterQualificationESFMatchModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						esfShooterQualificationESFMatchModelImpl.getUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfShooterQualificationESFMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterQualificationESFMatchModelImpl.getOriginalUuid(),
						esfShooterQualificationESFMatchModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfShooterQualificationESFMatchModelImpl.getUuid(),
						esfShooterQualificationESFMatchModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((esfShooterQualificationESFMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterQualificationESFMatchModelImpl.getOriginalEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH,
					args);

				args = new Object[] {
						esfShooterQualificationESFMatchModelImpl.getEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCH,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFMatchImpl.class,
			esfShooterQualificationESFMatch.getPrimaryKey(),
			esfShooterQualificationESFMatch);

		clearUniqueFindersCache(esfShooterQualificationESFMatch);
		cacheUniqueFindersCache(esfShooterQualificationESFMatch);

		return esfShooterQualificationESFMatch;
	}

	protected ESFShooterQualificationESFMatch toUnwrappedModel(
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch) {
		if (esfShooterQualificationESFMatch instanceof ESFShooterQualificationESFMatchImpl) {
			return esfShooterQualificationESFMatch;
		}

		ESFShooterQualificationESFMatchImpl esfShooterQualificationESFMatchImpl = new ESFShooterQualificationESFMatchImpl();

		esfShooterQualificationESFMatchImpl.setNew(esfShooterQualificationESFMatch.isNew());
		esfShooterQualificationESFMatchImpl.setPrimaryKey(esfShooterQualificationESFMatch.getPrimaryKey());

		esfShooterQualificationESFMatchImpl.setUuid(esfShooterQualificationESFMatch.getUuid());
		esfShooterQualificationESFMatchImpl.setEsfShooterQualificationId(esfShooterQualificationESFMatch.getEsfShooterQualificationId());
		esfShooterQualificationESFMatchImpl.setEsfMatchId(esfShooterQualificationESFMatch.getEsfMatchId());
		esfShooterQualificationESFMatchImpl.setGroupId(esfShooterQualificationESFMatch.getGroupId());
		esfShooterQualificationESFMatchImpl.setCompanyId(esfShooterQualificationESFMatch.getCompanyId());
		esfShooterQualificationESFMatchImpl.setUserId(esfShooterQualificationESFMatch.getUserId());
		esfShooterQualificationESFMatchImpl.setUserName(esfShooterQualificationESFMatch.getUserName());
		esfShooterQualificationESFMatchImpl.setCreateDate(esfShooterQualificationESFMatch.getCreateDate());
		esfShooterQualificationESFMatchImpl.setModifiedDate(esfShooterQualificationESFMatch.getModifiedDate());

		return esfShooterQualificationESFMatchImpl;
	}

	/**
	 * Returns the e s f shooter qualification e s f match with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter qualification e s f match
	 * @return the e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = fetchByPrimaryKey(primaryKey);

		if (esfShooterQualificationESFMatch == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShooterQualificationESFMatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfShooterQualificationESFMatch;
	}

	/**
	 * Returns the e s f shooter qualification e s f match with the primary key or throws a {@link it.ethica.esf.NoSuchShooterQualificationESFMatchException} if it could not be found.
	 *
	 * @param esfShooterQualificationESFMatchPK the primary key of the e s f shooter qualification e s f match
	 * @return the e s f shooter qualification e s f match
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch findByPrimaryKey(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK)
		throws NoSuchShooterQualificationESFMatchException, SystemException {
		return findByPrimaryKey((Serializable)esfShooterQualificationESFMatchPK);
	}

	/**
	 * Returns the e s f shooter qualification e s f match with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter qualification e s f match
	 * @return the e s f shooter qualification e s f match, or <code>null</code> if a e s f shooter qualification e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch = (ESFShooterQualificationESFMatch)EntityCacheUtil.getResult(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterQualificationESFMatchImpl.class, primaryKey);

		if (esfShooterQualificationESFMatch == _nullESFShooterQualificationESFMatch) {
			return null;
		}

		if (esfShooterQualificationESFMatch == null) {
			Session session = null;

			try {
				session = openSession();

				esfShooterQualificationESFMatch = (ESFShooterQualificationESFMatch)session.get(ESFShooterQualificationESFMatchImpl.class,
						primaryKey);

				if (esfShooterQualificationESFMatch != null) {
					cacheResult(esfShooterQualificationESFMatch);
				}
				else {
					EntityCacheUtil.putResult(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterQualificationESFMatchImpl.class, primaryKey,
						_nullESFShooterQualificationESFMatch);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFShooterQualificationESFMatchModelImpl.ENTITY_CACHE_ENABLED,
					ESFShooterQualificationESFMatchImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfShooterQualificationESFMatch;
	}

	/**
	 * Returns the e s f shooter qualification e s f match with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfShooterQualificationESFMatchPK the primary key of the e s f shooter qualification e s f match
	 * @return the e s f shooter qualification e s f match, or <code>null</code> if a e s f shooter qualification e s f match with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFMatch fetchByPrimaryKey(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfShooterQualificationESFMatchPK);
	}

	/**
	 * Returns all the e s f shooter qualification e s f matchs.
	 *
	 * @return the e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter qualification e s f matchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter qualification e s f matchs
	 * @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	 * @return the range of e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter qualification e s f matchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter qualification e s f matchs
	 * @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f shooter qualification e s f matchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFMatch> findAll(int start, int end,
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

		List<ESFShooterQualificationESFMatch> list = (List<ESFShooterQualificationESFMatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFMATCH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSHOOTERQUALIFICATIONESFMATCH;

				if (pagination) {
					sql = sql.concat(ESFShooterQualificationESFMatchModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFShooterQualificationESFMatch>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterQualificationESFMatch>(list);
				}
				else {
					list = (List<ESFShooterQualificationESFMatch>)QueryUtil.list(q,
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
	 * Removes all the e s f shooter qualification e s f matchs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFShooterQualificationESFMatch esfShooterQualificationESFMatch : findAll()) {
			remove(esfShooterQualificationESFMatch);
		}
	}

	/**
	 * Returns the number of e s f shooter qualification e s f matchs.
	 *
	 * @return the number of e s f shooter qualification e s f matchs
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

				Query q = session.createQuery(_SQL_COUNT_ESFSHOOTERQUALIFICATIONESFMATCH);

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
	 * Initializes the e s f shooter qualification e s f match persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFShooterQualificationESFMatch")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFShooterQualificationESFMatch>> listenersList =
					new ArrayList<ModelListener<ESFShooterQualificationESFMatch>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFShooterQualificationESFMatch>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFShooterQualificationESFMatchImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSHOOTERQUALIFICATIONESFMATCH = "SELECT esfShooterQualificationESFMatch FROM ESFShooterQualificationESFMatch esfShooterQualificationESFMatch";
	private static final String _SQL_SELECT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE =
		"SELECT esfShooterQualificationESFMatch FROM ESFShooterQualificationESFMatch esfShooterQualificationESFMatch WHERE ";
	private static final String _SQL_COUNT_ESFSHOOTERQUALIFICATIONESFMATCH = "SELECT COUNT(esfShooterQualificationESFMatch) FROM ESFShooterQualificationESFMatch esfShooterQualificationESFMatch";
	private static final String _SQL_COUNT_ESFSHOOTERQUALIFICATIONESFMATCH_WHERE =
		"SELECT COUNT(esfShooterQualificationESFMatch) FROM ESFShooterQualificationESFMatch esfShooterQualificationESFMatch WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfShooterQualificationESFMatch.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFShooterQualificationESFMatch exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFShooterQualificationESFMatch exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFShooterQualificationESFMatchPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFShooterQualificationESFMatch _nullESFShooterQualificationESFMatch =
		new ESFShooterQualificationESFMatchImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFShooterQualificationESFMatch> toCacheModel() {
				return _nullESFShooterQualificationESFMatchCacheModel;
			}
		};

	private static CacheModel<ESFShooterQualificationESFMatch> _nullESFShooterQualificationESFMatchCacheModel =
		new CacheModel<ESFShooterQualificationESFMatch>() {
			@Override
			public ESFShooterQualificationESFMatch toEntityModel() {
				return _nullESFShooterQualificationESFMatch;
			}
		};
}