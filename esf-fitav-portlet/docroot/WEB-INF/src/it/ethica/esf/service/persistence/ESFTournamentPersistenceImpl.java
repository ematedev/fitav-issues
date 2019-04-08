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

import it.ethica.esf.NoSuchTournamentException;
import it.ethica.esf.model.ESFTournament;
import it.ethica.esf.model.impl.ESFTournamentImpl;
import it.ethica.esf.model.impl.ESFTournamentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f tournament service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFTournamentPersistence
 * @see ESFTournamentUtil
 * @generated
 */
public class ESFTournamentPersistenceImpl extends BasePersistenceImpl<ESFTournament>
	implements ESFTournamentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFTournamentUtil} to access the e s f tournament persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFTournamentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFTournamentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFTournamentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFTournamentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFTournamentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			ESFTournamentModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f tournaments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTournament> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tournaments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f tournaments
	 * @param end the upper bound of the range of e s f tournaments (not inclusive)
	 * @return the range of matching e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTournament> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tournaments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f tournaments
	 * @param end the upper bound of the range of e s f tournaments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTournament> findByUuid(String uuid, int start, int end,
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

		List<ESFTournament> list = (List<ESFTournament>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFTournament esfTournament : list) {
				if (!Validator.equals(uuid, esfTournament.getUuid())) {
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

			query.append(_SQL_SELECT_ESFTOURNAMENT_WHERE);

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
				query.append(ESFTournamentModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFTournament>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTournament>(list);
				}
				else {
					list = (List<ESFTournament>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tournament
	 * @throws it.ethica.esf.NoSuchTournamentException if a matching e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTournamentException, SystemException {
		ESFTournament esfTournament = fetchByUuid_First(uuid, orderByComparator);

		if (esfTournament != null) {
			return esfTournament;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTournamentException(msg.toString());
	}

	/**
	 * Returns the first e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tournament, or <code>null</code> if a matching e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFTournament> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tournament
	 * @throws it.ethica.esf.NoSuchTournamentException if a matching e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTournamentException, SystemException {
		ESFTournament esfTournament = fetchByUuid_Last(uuid, orderByComparator);

		if (esfTournament != null) {
			return esfTournament;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTournamentException(msg.toString());
	}

	/**
	 * Returns the last e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tournament, or <code>null</code> if a matching e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFTournament> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f tournaments before and after the current e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param esfTournamentId the primary key of the current e s f tournament
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tournament
	 * @throws it.ethica.esf.NoSuchTournamentException if a e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament[] findByUuid_PrevAndNext(long esfTournamentId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchTournamentException, SystemException {
		ESFTournament esfTournament = findByPrimaryKey(esfTournamentId);

		Session session = null;

		try {
			session = openSession();

			ESFTournament[] array = new ESFTournamentImpl[3];

			array[0] = getByUuid_PrevAndNext(session, esfTournament, uuid,
					orderByComparator, true);

			array[1] = esfTournament;

			array[2] = getByUuid_PrevAndNext(session, esfTournament, uuid,
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

	protected ESFTournament getByUuid_PrevAndNext(Session session,
		ESFTournament esfTournament, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTOURNAMENT_WHERE);

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
			query.append(ESFTournamentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfTournament);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFTournament> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f tournaments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFTournament esfTournament : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfTournament);
		}
	}

	/**
	 * Returns the number of e s f tournaments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f tournaments
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

			query.append(_SQL_COUNT_ESFTOURNAMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfTournament.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfTournament.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfTournament.uuid IS NULL OR esfTournament.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFTournamentImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFTournamentModelImpl.UUID_COLUMN_BITMASK |
			ESFTournamentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f tournament where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchTournamentException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f tournament
	 * @throws it.ethica.esf.NoSuchTournamentException if a matching e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament findByUUID_G(String uuid, long groupId)
		throws NoSuchTournamentException, SystemException {
		ESFTournament esfTournament = fetchByUUID_G(uuid, groupId);

		if (esfTournament == null) {
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

			throw new NoSuchTournamentException(msg.toString());
		}

		return esfTournament;
	}

	/**
	 * Returns the e s f tournament where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f tournament, or <code>null</code> if a matching e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f tournament where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f tournament, or <code>null</code> if a matching e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFTournament) {
			ESFTournament esfTournament = (ESFTournament)result;

			if (!Validator.equals(uuid, esfTournament.getUuid()) ||
					(groupId != esfTournament.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFTOURNAMENT_WHERE);

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

				List<ESFTournament> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFTournament esfTournament = list.get(0);

					result = esfTournament;

					cacheResult(esfTournament);

					if ((esfTournament.getUuid() == null) ||
							!esfTournament.getUuid().equals(uuid) ||
							(esfTournament.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfTournament);
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
			return (ESFTournament)result;
		}
	}

	/**
	 * Removes the e s f tournament where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f tournament that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament removeByUUID_G(String uuid, long groupId)
		throws NoSuchTournamentException, SystemException {
		ESFTournament esfTournament = findByUUID_G(uuid, groupId);

		return remove(esfTournament);
	}

	/**
	 * Returns the number of e s f tournaments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f tournaments
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

			query.append(_SQL_COUNT_ESFTOURNAMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfTournament.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfTournament.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfTournament.uuid IS NULL OR esfTournament.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfTournament.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFTournamentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFTournamentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFTournamentModelImpl.UUID_COLUMN_BITMASK |
			ESFTournamentModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f tournaments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTournament> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tournaments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f tournaments
	 * @param end the upper bound of the range of e s f tournaments (not inclusive)
	 * @return the range of matching e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTournament> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tournaments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of e s f tournaments
	 * @param end the upper bound of the range of e s f tournaments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTournament> findByUuid_C(String uuid, long companyId,
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

		List<ESFTournament> list = (List<ESFTournament>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFTournament esfTournament : list) {
				if (!Validator.equals(uuid, esfTournament.getUuid()) ||
						(companyId != esfTournament.getCompanyId())) {
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

			query.append(_SQL_SELECT_ESFTOURNAMENT_WHERE);

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
				query.append(ESFTournamentModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFTournament>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTournament>(list);
				}
				else {
					list = (List<ESFTournament>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f tournament in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tournament
	 * @throws it.ethica.esf.NoSuchTournamentException if a matching e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTournamentException, SystemException {
		ESFTournament esfTournament = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (esfTournament != null) {
			return esfTournament;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTournamentException(msg.toString());
	}

	/**
	 * Returns the first e s f tournament in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f tournament, or <code>null</code> if a matching e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFTournament> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f tournament in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tournament
	 * @throws it.ethica.esf.NoSuchTournamentException if a matching e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTournamentException, SystemException {
		ESFTournament esfTournament = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (esfTournament != null) {
			return esfTournament;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTournamentException(msg.toString());
	}

	/**
	 * Returns the last e s f tournament in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f tournament, or <code>null</code> if a matching e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ESFTournament> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f tournaments before and after the current e s f tournament in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param esfTournamentId the primary key of the current e s f tournament
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f tournament
	 * @throws it.ethica.esf.NoSuchTournamentException if a e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament[] findByUuid_C_PrevAndNext(long esfTournamentId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTournamentException, SystemException {
		ESFTournament esfTournament = findByPrimaryKey(esfTournamentId);

		Session session = null;

		try {
			session = openSession();

			ESFTournament[] array = new ESFTournamentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, esfTournament, uuid,
					companyId, orderByComparator, true);

			array[1] = esfTournament;

			array[2] = getByUuid_C_PrevAndNext(session, esfTournament, uuid,
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

	protected ESFTournament getByUuid_C_PrevAndNext(Session session,
		ESFTournament esfTournament, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTOURNAMENT_WHERE);

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
			query.append(ESFTournamentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfTournament);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFTournament> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f tournaments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ESFTournament esfTournament : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfTournament);
		}
	}

	/**
	 * Returns the number of e s f tournaments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching e s f tournaments
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

			query.append(_SQL_COUNT_ESFTOURNAMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "esfTournament.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "esfTournament.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(esfTournament.uuid IS NULL OR esfTournament.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "esfTournament.companyId = ?";

	public ESFTournamentPersistenceImpl() {
		setModelClass(ESFTournament.class);
	}

	/**
	 * Caches the e s f tournament in the entity cache if it is enabled.
	 *
	 * @param esfTournament the e s f tournament
	 */
	@Override
	public void cacheResult(ESFTournament esfTournament) {
		EntityCacheUtil.putResult(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentImpl.class, esfTournament.getPrimaryKey(),
			esfTournament);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { esfTournament.getUuid(), esfTournament.getGroupId() },
			esfTournament);

		esfTournament.resetOriginalValues();
	}

	/**
	 * Caches the e s f tournaments in the entity cache if it is enabled.
	 *
	 * @param esfTournaments the e s f tournaments
	 */
	@Override
	public void cacheResult(List<ESFTournament> esfTournaments) {
		for (ESFTournament esfTournament : esfTournaments) {
			if (EntityCacheUtil.getResult(
						ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
						ESFTournamentImpl.class, esfTournament.getPrimaryKey()) == null) {
				cacheResult(esfTournament);
			}
			else {
				esfTournament.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f tournaments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFTournamentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFTournamentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f tournament.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFTournament esfTournament) {
		EntityCacheUtil.removeResult(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentImpl.class, esfTournament.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfTournament);
	}

	@Override
	public void clearCache(List<ESFTournament> esfTournaments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFTournament esfTournament : esfTournaments) {
			EntityCacheUtil.removeResult(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
				ESFTournamentImpl.class, esfTournament.getPrimaryKey());

			clearUniqueFindersCache(esfTournament);
		}
	}

	protected void cacheUniqueFindersCache(ESFTournament esfTournament) {
		if (esfTournament.isNew()) {
			Object[] args = new Object[] {
					esfTournament.getUuid(), esfTournament.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfTournament);
		}
		else {
			ESFTournamentModelImpl esfTournamentModelImpl = (ESFTournamentModelImpl)esfTournament;

			if ((esfTournamentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfTournament.getUuid(), esfTournament.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfTournament);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFTournament esfTournament) {
		ESFTournamentModelImpl esfTournamentModelImpl = (ESFTournamentModelImpl)esfTournament;

		Object[] args = new Object[] {
				esfTournament.getUuid(), esfTournament.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfTournamentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfTournamentModelImpl.getOriginalUuid(),
					esfTournamentModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f tournament with the primary key. Does not add the e s f tournament to the database.
	 *
	 * @param esfTournamentId the primary key for the new e s f tournament
	 * @return the new e s f tournament
	 */
	@Override
	public ESFTournament create(long esfTournamentId) {
		ESFTournament esfTournament = new ESFTournamentImpl();

		esfTournament.setNew(true);
		esfTournament.setPrimaryKey(esfTournamentId);

		String uuid = PortalUUIDUtil.generate();

		esfTournament.setUuid(uuid);

		return esfTournament;
	}

	/**
	 * Removes the e s f tournament with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfTournamentId the primary key of the e s f tournament
	 * @return the e s f tournament that was removed
	 * @throws it.ethica.esf.NoSuchTournamentException if a e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament remove(long esfTournamentId)
		throws NoSuchTournamentException, SystemException {
		return remove((Serializable)esfTournamentId);
	}

	/**
	 * Removes the e s f tournament with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f tournament
	 * @return the e s f tournament that was removed
	 * @throws it.ethica.esf.NoSuchTournamentException if a e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament remove(Serializable primaryKey)
		throws NoSuchTournamentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFTournament esfTournament = (ESFTournament)session.get(ESFTournamentImpl.class,
					primaryKey);

			if (esfTournament == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTournamentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfTournament);
		}
		catch (NoSuchTournamentException nsee) {
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
	protected ESFTournament removeImpl(ESFTournament esfTournament)
		throws SystemException {
		esfTournament = toUnwrappedModel(esfTournament);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfTournament)) {
				esfTournament = (ESFTournament)session.get(ESFTournamentImpl.class,
						esfTournament.getPrimaryKeyObj());
			}

			if (esfTournament != null) {
				session.delete(esfTournament);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfTournament != null) {
			clearCache(esfTournament);
		}

		return esfTournament;
	}

	@Override
	public ESFTournament updateImpl(
		it.ethica.esf.model.ESFTournament esfTournament)
		throws SystemException {
		esfTournament = toUnwrappedModel(esfTournament);

		boolean isNew = esfTournament.isNew();

		ESFTournamentModelImpl esfTournamentModelImpl = (ESFTournamentModelImpl)esfTournament;

		if (Validator.isNull(esfTournament.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfTournament.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfTournament.isNew()) {
				session.save(esfTournament);

				esfTournament.setNew(false);
			}
			else {
				session.merge(esfTournament);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFTournamentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfTournamentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfTournamentModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { esfTournamentModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfTournamentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfTournamentModelImpl.getOriginalUuid(),
						esfTournamentModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						esfTournamentModelImpl.getUuid(),
						esfTournamentModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFTournamentImpl.class, esfTournament.getPrimaryKey(),
			esfTournament);

		clearUniqueFindersCache(esfTournament);
		cacheUniqueFindersCache(esfTournament);

		return esfTournament;
	}

	protected ESFTournament toUnwrappedModel(ESFTournament esfTournament) {
		if (esfTournament instanceof ESFTournamentImpl) {
			return esfTournament;
		}

		ESFTournamentImpl esfTournamentImpl = new ESFTournamentImpl();

		esfTournamentImpl.setNew(esfTournament.isNew());
		esfTournamentImpl.setPrimaryKey(esfTournament.getPrimaryKey());

		esfTournamentImpl.setUuid(esfTournament.getUuid());
		esfTournamentImpl.setEsfTournamentId(esfTournament.getEsfTournamentId());
		esfTournamentImpl.setEsfOrganizationId(esfTournament.getEsfOrganizationId());
		esfTournamentImpl.setTitle(esfTournament.getTitle());
		esfTournamentImpl.setDescription(esfTournament.getDescription());
		esfTournamentImpl.setMaxnum(esfTournament.getMaxnum());
		esfTournamentImpl.setMinnum(esfTournament.getMinnum());
		esfTournamentImpl.setIsSingleMatch(esfTournament.isIsSingleMatch());
		esfTournamentImpl.setIsTeamMatch(esfTournament.isIsTeamMatch());
		esfTournamentImpl.setIsIndividualMatch(esfTournament.isIsIndividualMatch());
		esfTournamentImpl.setIsJuniorMatch(esfTournament.isIsJuniorMatch());
		esfTournamentImpl.setIsNationalMatch(esfTournament.isIsNationalMatch());
		esfTournamentImpl.setIsFinal(esfTournament.isIsFinal());
		esfTournamentImpl.setStartDate(esfTournament.getStartDate());
		esfTournamentImpl.setEndDate(esfTournament.getEndDate());
		esfTournamentImpl.setGroupId(esfTournament.getGroupId());
		esfTournamentImpl.setCompanyId(esfTournament.getCompanyId());
		esfTournamentImpl.setUserId(esfTournament.getUserId());
		esfTournamentImpl.setUserName(esfTournament.getUserName());
		esfTournamentImpl.setCreateDate(esfTournament.getCreateDate());
		esfTournamentImpl.setModifiedDate(esfTournament.getModifiedDate());

		return esfTournamentImpl;
	}

	/**
	 * Returns the e s f tournament with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f tournament
	 * @return the e s f tournament
	 * @throws it.ethica.esf.NoSuchTournamentException if a e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTournamentException, SystemException {
		ESFTournament esfTournament = fetchByPrimaryKey(primaryKey);

		if (esfTournament == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTournamentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfTournament;
	}

	/**
	 * Returns the e s f tournament with the primary key or throws a {@link it.ethica.esf.NoSuchTournamentException} if it could not be found.
	 *
	 * @param esfTournamentId the primary key of the e s f tournament
	 * @return the e s f tournament
	 * @throws it.ethica.esf.NoSuchTournamentException if a e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament findByPrimaryKey(long esfTournamentId)
		throws NoSuchTournamentException, SystemException {
		return findByPrimaryKey((Serializable)esfTournamentId);
	}

	/**
	 * Returns the e s f tournament with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f tournament
	 * @return the e s f tournament, or <code>null</code> if a e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFTournament esfTournament = (ESFTournament)EntityCacheUtil.getResult(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
				ESFTournamentImpl.class, primaryKey);

		if (esfTournament == _nullESFTournament) {
			return null;
		}

		if (esfTournament == null) {
			Session session = null;

			try {
				session = openSession();

				esfTournament = (ESFTournament)session.get(ESFTournamentImpl.class,
						primaryKey);

				if (esfTournament != null) {
					cacheResult(esfTournament);
				}
				else {
					EntityCacheUtil.putResult(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
						ESFTournamentImpl.class, primaryKey, _nullESFTournament);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
					ESFTournamentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfTournament;
	}

	/**
	 * Returns the e s f tournament with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfTournamentId the primary key of the e s f tournament
	 * @return the e s f tournament, or <code>null</code> if a e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTournament fetchByPrimaryKey(long esfTournamentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfTournamentId);
	}

	/**
	 * Returns all the e s f tournaments.
	 *
	 * @return the e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTournament> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f tournaments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f tournaments
	 * @param end the upper bound of the range of e s f tournaments (not inclusive)
	 * @return the range of e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTournament> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f tournaments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f tournaments
	 * @param end the upper bound of the range of e s f tournaments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTournament> findAll(int start, int end,
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

		List<ESFTournament> list = (List<ESFTournament>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFTOURNAMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFTOURNAMENT;

				if (pagination) {
					sql = sql.concat(ESFTournamentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFTournament>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTournament>(list);
				}
				else {
					list = (List<ESFTournament>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f tournaments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFTournament esfTournament : findAll()) {
			remove(esfTournament);
		}
	}

	/**
	 * Returns the number of e s f tournaments.
	 *
	 * @return the number of e s f tournaments
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

				Query q = session.createQuery(_SQL_COUNT_ESFTOURNAMENT);

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
	 * Initializes the e s f tournament persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFTournament")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFTournament>> listenersList = new ArrayList<ModelListener<ESFTournament>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFTournament>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFTournamentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFTOURNAMENT = "SELECT esfTournament FROM ESFTournament esfTournament";
	private static final String _SQL_SELECT_ESFTOURNAMENT_WHERE = "SELECT esfTournament FROM ESFTournament esfTournament WHERE ";
	private static final String _SQL_COUNT_ESFTOURNAMENT = "SELECT COUNT(esfTournament) FROM ESFTournament esfTournament";
	private static final String _SQL_COUNT_ESFTOURNAMENT_WHERE = "SELECT COUNT(esfTournament) FROM ESFTournament esfTournament WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfTournament.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFTournament exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFTournament exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFTournamentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFTournament _nullESFTournament = new ESFTournamentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFTournament> toCacheModel() {
				return _nullESFTournamentCacheModel;
			}
		};

	private static CacheModel<ESFTournament> _nullESFTournamentCacheModel = new CacheModel<ESFTournament>() {
			@Override
			public ESFTournament toEntityModel() {
				return _nullESFTournament;
			}
		};
}