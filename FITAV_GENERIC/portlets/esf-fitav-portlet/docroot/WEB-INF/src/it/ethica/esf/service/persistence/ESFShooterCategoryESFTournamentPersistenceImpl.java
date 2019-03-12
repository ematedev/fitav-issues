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

import it.ethica.esf.NoSuchShooterCategoryESFTournamentException;
import it.ethica.esf.model.ESFShooterCategoryESFTournament;
import it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentImpl;
import it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f shooter category e s f tournament service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShooterCategoryESFTournamentPersistence
 * @see ESFShooterCategoryESFTournamentUtil
 * @generated
 */
public class ESFShooterCategoryESFTournamentPersistenceImpl
	extends BasePersistenceImpl<ESFShooterCategoryESFTournament>
	implements ESFShooterCategoryESFTournamentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFShooterCategoryESFTournamentUtil} to access the e s f shooter category e s f tournament persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFShooterCategoryESFTournamentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFShooterCategoryESFTournamentModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the e s f shooter category e s f tournaments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f shooter category e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFTournament> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter category e s f tournaments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f shooter category e s f tournaments
	 * @param end the upper bound of the range of e s f shooter category e s f tournaments (not inclusive)
	 * @return the range of matching e s f shooter category e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFTournament> findByUuid(String uuid,
		int start, int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter category e s f tournaments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f shooter category e s f tournaments
	 * @param end the upper bound of the range of e s f shooter category e s f tournaments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter category e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFTournament> findByUuid(String uuid,
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

		List<ESFShooterCategoryESFTournament> list = (List<ESFShooterCategoryESFTournament>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterCategoryESFTournament esfShooterCategoryESFTournament : list) {
				if (!Validator.equals(uuid,
							esfShooterCategoryESFTournament.getUuid())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFTOURNAMENT_WHERE);

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
				query.append(ESFShooterCategoryESFTournamentModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFShooterCategoryESFTournament>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterCategoryESFTournament>(list);
				}
				else {
					list = (List<ESFShooterCategoryESFTournament>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter category e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter category e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFTournamentException if a matching e s f shooter category e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = fetchByUuid_First(uuid,
				orderByComparator);

		if (esfShooterCategoryESFTournament != null) {
			return esfShooterCategoryESFTournament;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterCategoryESFTournamentException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter category e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter category e s f tournament, or <code>null</code> if a matching e s f shooter category e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShooterCategoryESFTournament> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter category e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter category e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFTournamentException if a matching e s f shooter category e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = fetchByUuid_Last(uuid,
				orderByComparator);

		if (esfShooterCategoryESFTournament != null) {
			return esfShooterCategoryESFTournament;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterCategoryESFTournamentException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter category e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter category e s f tournament, or <code>null</code> if a matching e s f shooter category e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFShooterCategoryESFTournament> list = findByUuid(uuid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter category e s f tournaments before and after the current e s f shooter category e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param esfShooterCategoryESFTournamentPK the primary key of the current e s f shooter category e s f tournament
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter category e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFTournamentException if a e s f shooter category e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament[] findByUuid_PrevAndNext(
		ESFShooterCategoryESFTournamentPK esfShooterCategoryESFTournamentPK,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = findByPrimaryKey(esfShooterCategoryESFTournamentPK);

		Session session = null;

		try {
			session = openSession();

			ESFShooterCategoryESFTournament[] array = new ESFShooterCategoryESFTournamentImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					esfShooterCategoryESFTournament, uuid, orderByComparator,
					true);

			array[1] = esfShooterCategoryESFTournament;

			array[2] = getByUuid_PrevAndNext(session,
					esfShooterCategoryESFTournament, uuid, orderByComparator,
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

	protected ESFShooterCategoryESFTournament getByUuid_PrevAndNext(
		Session session,
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFTOURNAMENT_WHERE);

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
			query.append(ESFShooterCategoryESFTournamentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterCategoryESFTournament);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterCategoryESFTournament> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter category e s f tournaments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFShooterCategoryESFTournament esfShooterCategoryESFTournament : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterCategoryESFTournament);
		}
	}

	/**
	 * Returns the number of e s f shooter category e s f tournaments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f shooter category e s f tournaments
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

			query.append(_SQL_COUNT_ESFSHOOTERCATEGORYESFTOURNAMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfShooterCategoryESFTournament.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfShooterCategoryESFTournament.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfShooterCategoryESFTournament.uuid IS NULL OR esfShooterCategoryESFTournament.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFShooterCategoryESFTournamentModelImpl.UUID_COLUMN_BITMASK |
			ESFShooterCategoryESFTournamentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f shooter category e s f tournament where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchShooterCategoryESFTournamentException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f shooter category e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFTournamentException if a matching e s f shooter category e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament findByUUID_G(String uuid,
		long groupId)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = fetchByUUID_G(uuid,
				groupId);

		if (esfShooterCategoryESFTournament == null) {
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

			throw new NoSuchShooterCategoryESFTournamentException(msg.toString());
		}

		return esfShooterCategoryESFTournament;
	}

	/**
	 * Returns the e s f shooter category e s f tournament where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f shooter category e s f tournament, or <code>null</code> if a matching e s f shooter category e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament fetchByUUID_G(String uuid,
		long groupId) throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f shooter category e s f tournament where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f shooter category e s f tournament, or <code>null</code> if a matching e s f shooter category e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament fetchByUUID_G(String uuid,
		long groupId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFShooterCategoryESFTournament) {
			ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = (ESFShooterCategoryESFTournament)result;

			if (!Validator.equals(uuid,
						esfShooterCategoryESFTournament.getUuid()) ||
					(groupId != esfShooterCategoryESFTournament.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFTOURNAMENT_WHERE);

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

				List<ESFShooterCategoryESFTournament> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFShooterCategoryESFTournament esfShooterCategoryESFTournament =
						list.get(0);

					result = esfShooterCategoryESFTournament;

					cacheResult(esfShooterCategoryESFTournament);

					if ((esfShooterCategoryESFTournament.getUuid() == null) ||
							!esfShooterCategoryESFTournament.getUuid()
																.equals(uuid) ||
							(esfShooterCategoryESFTournament.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfShooterCategoryESFTournament);
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
			return (ESFShooterCategoryESFTournament)result;
		}
	}

	/**
	 * Removes the e s f shooter category e s f tournament where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f shooter category e s f tournament that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament removeByUUID_G(String uuid,
		long groupId)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = findByUUID_G(uuid,
				groupId);

		return remove(esfShooterCategoryESFTournament);
	}

	/**
	 * Returns the number of e s f shooter category e s f tournaments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f shooter category e s f tournaments
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

			query.append(_SQL_COUNT_ESFSHOOTERCATEGORYESFTOURNAMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfShooterCategoryESFTournament.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfShooterCategoryESFTournament.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfShooterCategoryESFTournament.uuid IS NULL OR esfShooterCategoryESFTournament.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfShooterCategoryESFTournament.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFTOURNAMENT =
		new FinderPath(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFTournament",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOURNAMENT =
		new FinderPath(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFTournament",
			new String[] { Long.class.getName() },
			ESFShooterCategoryESFTournamentModelImpl.ESFTOURNAMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFTOURNAMENT = new FinderPath(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFTournament", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f shooter category e s f tournaments where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @return the matching e s f shooter category e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFTournament> findByESFTournament(
		long esfTournamentId) throws SystemException {
		return findByESFTournament(esfTournamentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter category e s f tournaments where esfTournamentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param start the lower bound of the range of e s f shooter category e s f tournaments
	 * @param end the upper bound of the range of e s f shooter category e s f tournaments (not inclusive)
	 * @return the range of matching e s f shooter category e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFTournament> findByESFTournament(
		long esfTournamentId, int start, int end) throws SystemException {
		return findByESFTournament(esfTournamentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter category e s f tournaments where esfTournamentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param start the lower bound of the range of e s f shooter category e s f tournaments
	 * @param end the upper bound of the range of e s f shooter category e s f tournaments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter category e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFTournament> findByESFTournament(
		long esfTournamentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOURNAMENT;
			finderArgs = new Object[] { esfTournamentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFTOURNAMENT;
			finderArgs = new Object[] {
					esfTournamentId,
					
					start, end, orderByComparator
				};
		}

		List<ESFShooterCategoryESFTournament> list = (List<ESFShooterCategoryESFTournament>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterCategoryESFTournament esfShooterCategoryESFTournament : list) {
				if ((esfTournamentId != esfShooterCategoryESFTournament.getEsfTournamentId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFTOURNAMENT_WHERE);

			query.append(_FINDER_COLUMN_ESFTOURNAMENT_ESFTOURNAMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShooterCategoryESFTournamentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfTournamentId);

				if (!pagination) {
					list = (List<ESFShooterCategoryESFTournament>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterCategoryESFTournament>(list);
				}
				else {
					list = (List<ESFShooterCategoryESFTournament>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter category e s f tournament in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter category e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFTournamentException if a matching e s f shooter category e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament findByESFTournament_First(
		long esfTournamentId, OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = fetchByESFTournament_First(esfTournamentId,
				orderByComparator);

		if (esfShooterCategoryESFTournament != null) {
			return esfShooterCategoryESFTournament;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfTournamentId=");
		msg.append(esfTournamentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterCategoryESFTournamentException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter category e s f tournament in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter category e s f tournament, or <code>null</code> if a matching e s f shooter category e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament fetchByESFTournament_First(
		long esfTournamentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFShooterCategoryESFTournament> list = findByESFTournament(esfTournamentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter category e s f tournament in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter category e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFTournamentException if a matching e s f shooter category e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament findByESFTournament_Last(
		long esfTournamentId, OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = fetchByESFTournament_Last(esfTournamentId,
				orderByComparator);

		if (esfShooterCategoryESFTournament != null) {
			return esfShooterCategoryESFTournament;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfTournamentId=");
		msg.append(esfTournamentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterCategoryESFTournamentException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter category e s f tournament in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter category e s f tournament, or <code>null</code> if a matching e s f shooter category e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament fetchByESFTournament_Last(
		long esfTournamentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFTournament(esfTournamentId);

		if (count == 0) {
			return null;
		}

		List<ESFShooterCategoryESFTournament> list = findByESFTournament(esfTournamentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter category e s f tournaments before and after the current e s f shooter category e s f tournament in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfShooterCategoryESFTournamentPK the primary key of the current e s f shooter category e s f tournament
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter category e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFTournamentException if a e s f shooter category e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament[] findByESFTournament_PrevAndNext(
		ESFShooterCategoryESFTournamentPK esfShooterCategoryESFTournamentPK,
		long esfTournamentId, OrderByComparator orderByComparator)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = findByPrimaryKey(esfShooterCategoryESFTournamentPK);

		Session session = null;

		try {
			session = openSession();

			ESFShooterCategoryESFTournament[] array = new ESFShooterCategoryESFTournamentImpl[3];

			array[0] = getByESFTournament_PrevAndNext(session,
					esfShooterCategoryESFTournament, esfTournamentId,
					orderByComparator, true);

			array[1] = esfShooterCategoryESFTournament;

			array[2] = getByESFTournament_PrevAndNext(session,
					esfShooterCategoryESFTournament, esfTournamentId,
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

	protected ESFShooterCategoryESFTournament getByESFTournament_PrevAndNext(
		Session session,
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament,
		long esfTournamentId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFTOURNAMENT_WHERE);

		query.append(_FINDER_COLUMN_ESFTOURNAMENT_ESFTOURNAMENTID_2);

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
			query.append(ESFShooterCategoryESFTournamentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfTournamentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterCategoryESFTournament);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterCategoryESFTournament> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter category e s f tournaments where esfTournamentId = &#63; from the database.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFTournament(long esfTournamentId)
		throws SystemException {
		for (ESFShooterCategoryESFTournament esfShooterCategoryESFTournament : findByESFTournament(
				esfTournamentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterCategoryESFTournament);
		}
	}

	/**
	 * Returns the number of e s f shooter category e s f tournaments where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @return the number of matching e s f shooter category e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFTournament(long esfTournamentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFTOURNAMENT;

		Object[] finderArgs = new Object[] { esfTournamentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSHOOTERCATEGORYESFTOURNAMENT_WHERE);

			query.append(_FINDER_COLUMN_ESFTOURNAMENT_ESFTOURNAMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfTournamentId);

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

	private static final String _FINDER_COLUMN_ESFTOURNAMENT_ESFTOURNAMENTID_2 = "esfShooterCategoryESFTournament.id.esfTournamentId = ?";

	public ESFShooterCategoryESFTournamentPersistenceImpl() {
		setModelClass(ESFShooterCategoryESFTournament.class);
	}

	/**
	 * Caches the e s f shooter category e s f tournament in the entity cache if it is enabled.
	 *
	 * @param esfShooterCategoryESFTournament the e s f shooter category e s f tournament
	 */
	@Override
	public void cacheResult(
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament) {
		EntityCacheUtil.putResult(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentImpl.class,
			esfShooterCategoryESFTournament.getPrimaryKey(),
			esfShooterCategoryESFTournament);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				esfShooterCategoryESFTournament.getUuid(),
				esfShooterCategoryESFTournament.getGroupId()
			}, esfShooterCategoryESFTournament);

		esfShooterCategoryESFTournament.resetOriginalValues();
	}

	/**
	 * Caches the e s f shooter category e s f tournaments in the entity cache if it is enabled.
	 *
	 * @param esfShooterCategoryESFTournaments the e s f shooter category e s f tournaments
	 */
	@Override
	public void cacheResult(
		List<ESFShooterCategoryESFTournament> esfShooterCategoryESFTournaments) {
		for (ESFShooterCategoryESFTournament esfShooterCategoryESFTournament : esfShooterCategoryESFTournaments) {
			if (EntityCacheUtil.getResult(
						ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterCategoryESFTournamentImpl.class,
						esfShooterCategoryESFTournament.getPrimaryKey()) == null) {
				cacheResult(esfShooterCategoryESFTournament);
			}
			else {
				esfShooterCategoryESFTournament.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f shooter category e s f tournaments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFShooterCategoryESFTournamentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFShooterCategoryESFTournamentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f shooter category e s f tournament.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament) {
		EntityCacheUtil.removeResult(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentImpl.class,
			esfShooterCategoryESFTournament.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfShooterCategoryESFTournament);
	}

	@Override
	public void clearCache(
		List<ESFShooterCategoryESFTournament> esfShooterCategoryESFTournaments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFShooterCategoryESFTournament esfShooterCategoryESFTournament : esfShooterCategoryESFTournaments) {
			EntityCacheUtil.removeResult(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterCategoryESFTournamentImpl.class,
				esfShooterCategoryESFTournament.getPrimaryKey());

			clearUniqueFindersCache(esfShooterCategoryESFTournament);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament) {
		if (esfShooterCategoryESFTournament.isNew()) {
			Object[] args = new Object[] {
					esfShooterCategoryESFTournament.getUuid(),
					esfShooterCategoryESFTournament.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfShooterCategoryESFTournament);
		}
		else {
			ESFShooterCategoryESFTournamentModelImpl esfShooterCategoryESFTournamentModelImpl =
				(ESFShooterCategoryESFTournamentModelImpl)esfShooterCategoryESFTournament;

			if ((esfShooterCategoryESFTournamentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterCategoryESFTournament.getUuid(),
						esfShooterCategoryESFTournament.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfShooterCategoryESFTournament);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament) {
		ESFShooterCategoryESFTournamentModelImpl esfShooterCategoryESFTournamentModelImpl =
			(ESFShooterCategoryESFTournamentModelImpl)esfShooterCategoryESFTournament;

		Object[] args = new Object[] {
				esfShooterCategoryESFTournament.getUuid(),
				esfShooterCategoryESFTournament.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfShooterCategoryESFTournamentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfShooterCategoryESFTournamentModelImpl.getOriginalUuid(),
					esfShooterCategoryESFTournamentModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f shooter category e s f tournament with the primary key. Does not add the e s f shooter category e s f tournament to the database.
	 *
	 * @param esfShooterCategoryESFTournamentPK the primary key for the new e s f shooter category e s f tournament
	 * @return the new e s f shooter category e s f tournament
	 */
	@Override
	public ESFShooterCategoryESFTournament create(
		ESFShooterCategoryESFTournamentPK esfShooterCategoryESFTournamentPK) {
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = new ESFShooterCategoryESFTournamentImpl();

		esfShooterCategoryESFTournament.setNew(true);
		esfShooterCategoryESFTournament.setPrimaryKey(esfShooterCategoryESFTournamentPK);

		String uuid = PortalUUIDUtil.generate();

		esfShooterCategoryESFTournament.setUuid(uuid);

		return esfShooterCategoryESFTournament;
	}

	/**
	 * Removes the e s f shooter category e s f tournament with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfShooterCategoryESFTournamentPK the primary key of the e s f shooter category e s f tournament
	 * @return the e s f shooter category e s f tournament that was removed
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFTournamentException if a e s f shooter category e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament remove(
		ESFShooterCategoryESFTournamentPK esfShooterCategoryESFTournamentPK)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		return remove((Serializable)esfShooterCategoryESFTournamentPK);
	}

	/**
	 * Removes the e s f shooter category e s f tournament with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f shooter category e s f tournament
	 * @return the e s f shooter category e s f tournament that was removed
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFTournamentException if a e s f shooter category e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament remove(Serializable primaryKey)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = (ESFShooterCategoryESFTournament)session.get(ESFShooterCategoryESFTournamentImpl.class,
					primaryKey);

			if (esfShooterCategoryESFTournament == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShooterCategoryESFTournamentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfShooterCategoryESFTournament);
		}
		catch (NoSuchShooterCategoryESFTournamentException nsee) {
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
	protected ESFShooterCategoryESFTournament removeImpl(
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament)
		throws SystemException {
		esfShooterCategoryESFTournament = toUnwrappedModel(esfShooterCategoryESFTournament);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfShooterCategoryESFTournament)) {
				esfShooterCategoryESFTournament = (ESFShooterCategoryESFTournament)session.get(ESFShooterCategoryESFTournamentImpl.class,
						esfShooterCategoryESFTournament.getPrimaryKeyObj());
			}

			if (esfShooterCategoryESFTournament != null) {
				session.delete(esfShooterCategoryESFTournament);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfShooterCategoryESFTournament != null) {
			clearCache(esfShooterCategoryESFTournament);
		}

		return esfShooterCategoryESFTournament;
	}

	@Override
	public ESFShooterCategoryESFTournament updateImpl(
		it.ethica.esf.model.ESFShooterCategoryESFTournament esfShooterCategoryESFTournament)
		throws SystemException {
		esfShooterCategoryESFTournament = toUnwrappedModel(esfShooterCategoryESFTournament);

		boolean isNew = esfShooterCategoryESFTournament.isNew();

		ESFShooterCategoryESFTournamentModelImpl esfShooterCategoryESFTournamentModelImpl =
			(ESFShooterCategoryESFTournamentModelImpl)esfShooterCategoryESFTournament;

		if (Validator.isNull(esfShooterCategoryESFTournament.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfShooterCategoryESFTournament.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfShooterCategoryESFTournament.isNew()) {
				session.save(esfShooterCategoryESFTournament);

				esfShooterCategoryESFTournament.setNew(false);
			}
			else {
				session.merge(esfShooterCategoryESFTournament);
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
				!ESFShooterCategoryESFTournamentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfShooterCategoryESFTournamentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterCategoryESFTournamentModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						esfShooterCategoryESFTournamentModelImpl.getUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfShooterCategoryESFTournamentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOURNAMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterCategoryESFTournamentModelImpl.getOriginalEsfTournamentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFTOURNAMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOURNAMENT,
					args);

				args = new Object[] {
						esfShooterCategoryESFTournamentModelImpl.getEsfTournamentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFTOURNAMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOURNAMENT,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterCategoryESFTournamentImpl.class,
			esfShooterCategoryESFTournament.getPrimaryKey(),
			esfShooterCategoryESFTournament);

		clearUniqueFindersCache(esfShooterCategoryESFTournament);
		cacheUniqueFindersCache(esfShooterCategoryESFTournament);

		return esfShooterCategoryESFTournament;
	}

	protected ESFShooterCategoryESFTournament toUnwrappedModel(
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament) {
		if (esfShooterCategoryESFTournament instanceof ESFShooterCategoryESFTournamentImpl) {
			return esfShooterCategoryESFTournament;
		}

		ESFShooterCategoryESFTournamentImpl esfShooterCategoryESFTournamentImpl = new ESFShooterCategoryESFTournamentImpl();

		esfShooterCategoryESFTournamentImpl.setNew(esfShooterCategoryESFTournament.isNew());
		esfShooterCategoryESFTournamentImpl.setPrimaryKey(esfShooterCategoryESFTournament.getPrimaryKey());

		esfShooterCategoryESFTournamentImpl.setUuid(esfShooterCategoryESFTournament.getUuid());
		esfShooterCategoryESFTournamentImpl.setEsfShooterCategoryId(esfShooterCategoryESFTournament.getEsfShooterCategoryId());
		esfShooterCategoryESFTournamentImpl.setEsfTournamentId(esfShooterCategoryESFTournament.getEsfTournamentId());
		esfShooterCategoryESFTournamentImpl.setGroupId(esfShooterCategoryESFTournament.getGroupId());

		return esfShooterCategoryESFTournamentImpl;
	}

	/**
	 * Returns the e s f shooter category e s f tournament with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter category e s f tournament
	 * @return the e s f shooter category e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFTournamentException if a e s f shooter category e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = fetchByPrimaryKey(primaryKey);

		if (esfShooterCategoryESFTournament == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShooterCategoryESFTournamentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfShooterCategoryESFTournament;
	}

	/**
	 * Returns the e s f shooter category e s f tournament with the primary key or throws a {@link it.ethica.esf.NoSuchShooterCategoryESFTournamentException} if it could not be found.
	 *
	 * @param esfShooterCategoryESFTournamentPK the primary key of the e s f shooter category e s f tournament
	 * @return the e s f shooter category e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterCategoryESFTournamentException if a e s f shooter category e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament findByPrimaryKey(
		ESFShooterCategoryESFTournamentPK esfShooterCategoryESFTournamentPK)
		throws NoSuchShooterCategoryESFTournamentException, SystemException {
		return findByPrimaryKey((Serializable)esfShooterCategoryESFTournamentPK);
	}

	/**
	 * Returns the e s f shooter category e s f tournament with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter category e s f tournament
	 * @return the e s f shooter category e s f tournament, or <code>null</code> if a e s f shooter category e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament = (ESFShooterCategoryESFTournament)EntityCacheUtil.getResult(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterCategoryESFTournamentImpl.class, primaryKey);

		if (esfShooterCategoryESFTournament == _nullESFShooterCategoryESFTournament) {
			return null;
		}

		if (esfShooterCategoryESFTournament == null) {
			Session session = null;

			try {
				session = openSession();

				esfShooterCategoryESFTournament = (ESFShooterCategoryESFTournament)session.get(ESFShooterCategoryESFTournamentImpl.class,
						primaryKey);

				if (esfShooterCategoryESFTournament != null) {
					cacheResult(esfShooterCategoryESFTournament);
				}
				else {
					EntityCacheUtil.putResult(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterCategoryESFTournamentImpl.class, primaryKey,
						_nullESFShooterCategoryESFTournament);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFShooterCategoryESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
					ESFShooterCategoryESFTournamentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfShooterCategoryESFTournament;
	}

	/**
	 * Returns the e s f shooter category e s f tournament with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfShooterCategoryESFTournamentPK the primary key of the e s f shooter category e s f tournament
	 * @return the e s f shooter category e s f tournament, or <code>null</code> if a e s f shooter category e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterCategoryESFTournament fetchByPrimaryKey(
		ESFShooterCategoryESFTournamentPK esfShooterCategoryESFTournamentPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfShooterCategoryESFTournamentPK);
	}

	/**
	 * Returns all the e s f shooter category e s f tournaments.
	 *
	 * @return the e s f shooter category e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFTournament> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter category e s f tournaments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter category e s f tournaments
	 * @param end the upper bound of the range of e s f shooter category e s f tournaments (not inclusive)
	 * @return the range of e s f shooter category e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFTournament> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter category e s f tournaments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter category e s f tournaments
	 * @param end the upper bound of the range of e s f shooter category e s f tournaments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f shooter category e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterCategoryESFTournament> findAll(int start, int end,
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

		List<ESFShooterCategoryESFTournament> list = (List<ESFShooterCategoryESFTournament>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSHOOTERCATEGORYESFTOURNAMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSHOOTERCATEGORYESFTOURNAMENT;

				if (pagination) {
					sql = sql.concat(ESFShooterCategoryESFTournamentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFShooterCategoryESFTournament>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterCategoryESFTournament>(list);
				}
				else {
					list = (List<ESFShooterCategoryESFTournament>)QueryUtil.list(q,
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
	 * Removes all the e s f shooter category e s f tournaments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFShooterCategoryESFTournament esfShooterCategoryESFTournament : findAll()) {
			remove(esfShooterCategoryESFTournament);
		}
	}

	/**
	 * Returns the number of e s f shooter category e s f tournaments.
	 *
	 * @return the number of e s f shooter category e s f tournaments
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

				Query q = session.createQuery(_SQL_COUNT_ESFSHOOTERCATEGORYESFTOURNAMENT);

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
	 * Initializes the e s f shooter category e s f tournament persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFShooterCategoryESFTournament")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFShooterCategoryESFTournament>> listenersList =
					new ArrayList<ModelListener<ESFShooterCategoryESFTournament>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFShooterCategoryESFTournament>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFShooterCategoryESFTournamentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSHOOTERCATEGORYESFTOURNAMENT = "SELECT esfShooterCategoryESFTournament FROM ESFShooterCategoryESFTournament esfShooterCategoryESFTournament";
	private static final String _SQL_SELECT_ESFSHOOTERCATEGORYESFTOURNAMENT_WHERE =
		"SELECT esfShooterCategoryESFTournament FROM ESFShooterCategoryESFTournament esfShooterCategoryESFTournament WHERE ";
	private static final String _SQL_COUNT_ESFSHOOTERCATEGORYESFTOURNAMENT = "SELECT COUNT(esfShooterCategoryESFTournament) FROM ESFShooterCategoryESFTournament esfShooterCategoryESFTournament";
	private static final String _SQL_COUNT_ESFSHOOTERCATEGORYESFTOURNAMENT_WHERE =
		"SELECT COUNT(esfShooterCategoryESFTournament) FROM ESFShooterCategoryESFTournament esfShooterCategoryESFTournament WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfShooterCategoryESFTournament.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFShooterCategoryESFTournament exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFShooterCategoryESFTournament exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFShooterCategoryESFTournamentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFShooterCategoryESFTournament _nullESFShooterCategoryESFTournament =
		new ESFShooterCategoryESFTournamentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFShooterCategoryESFTournament> toCacheModel() {
				return _nullESFShooterCategoryESFTournamentCacheModel;
			}
		};

	private static CacheModel<ESFShooterCategoryESFTournament> _nullESFShooterCategoryESFTournamentCacheModel =
		new CacheModel<ESFShooterCategoryESFTournament>() {
			@Override
			public ESFShooterCategoryESFTournament toEntityModel() {
				return _nullESFShooterCategoryESFTournament;
			}
		};
}