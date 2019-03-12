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

import it.ethica.esf.NoSuchShooterQualificationESFTournamentException;
import it.ethica.esf.model.ESFShooterQualificationESFTournament;
import it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentImpl;
import it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f shooter qualification e s f tournament service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShooterQualificationESFTournamentPersistence
 * @see ESFShooterQualificationESFTournamentUtil
 * @generated
 */
public class ESFShooterQualificationESFTournamentPersistenceImpl
	extends BasePersistenceImpl<ESFShooterQualificationESFTournament>
	implements ESFShooterQualificationESFTournamentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFShooterQualificationESFTournamentUtil} to access the e s f shooter qualification e s f tournament persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFShooterQualificationESFTournamentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ESFShooterQualificationESFTournamentModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the e s f shooter qualification e s f tournaments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e s f shooter qualification e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFTournament> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter qualification e s f tournaments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	 * @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	 * @return the range of matching e s f shooter qualification e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFTournament> findByUuid(String uuid,
		int start, int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter qualification e s f tournaments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	 * @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter qualification e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFTournament> findByUuid(String uuid,
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

		List<ESFShooterQualificationESFTournament> list = (List<ESFShooterQualificationESFTournament>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterQualificationESFTournament esfShooterQualificationESFTournament : list) {
				if (!Validator.equals(uuid,
							esfShooterQualificationESFTournament.getUuid())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT_WHERE);

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
				query.append(ESFShooterQualificationESFTournamentModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFShooterQualificationESFTournament>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterQualificationESFTournament>(list);
				}
				else {
					list = (List<ESFShooterQualificationESFTournament>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			fetchByUuid_First(uuid, orderByComparator);

		if (esfShooterQualificationESFTournament != null) {
			return esfShooterQualificationESFTournament;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationESFTournamentException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFShooterQualificationESFTournament> list = findByUuid(uuid, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			fetchByUuid_Last(uuid, orderByComparator);

		if (esfShooterQualificationESFTournament != null) {
			return esfShooterQualificationESFTournament;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationESFTournamentException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ESFShooterQualificationESFTournament> list = findByUuid(uuid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter qualification e s f tournaments before and after the current e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	 *
	 * @param esfShooterQualificationESFTournamentPK the primary key of the current e s f shooter qualification e s f tournament
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter qualification e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament[] findByUuid_PrevAndNext(
		ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			findByPrimaryKey(esfShooterQualificationESFTournamentPK);

		Session session = null;

		try {
			session = openSession();

			ESFShooterQualificationESFTournament[] array = new ESFShooterQualificationESFTournamentImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					esfShooterQualificationESFTournament, uuid,
					orderByComparator, true);

			array[1] = esfShooterQualificationESFTournament;

			array[2] = getByUuid_PrevAndNext(session,
					esfShooterQualificationESFTournament, uuid,
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

	protected ESFShooterQualificationESFTournament getByUuid_PrevAndNext(
		Session session,
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT_WHERE);

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
			query.append(ESFShooterQualificationESFTournamentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterQualificationESFTournament);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterQualificationESFTournament> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter qualification e s f tournaments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ESFShooterQualificationESFTournament esfShooterQualificationESFTournament : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterQualificationESFTournament);
		}
	}

	/**
	 * Returns the number of e s f shooter qualification e s f tournaments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e s f shooter qualification e s f tournaments
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

			query.append(_SQL_COUNT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "esfShooterQualificationESFTournament.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "esfShooterQualificationESFTournament.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(esfShooterQualificationESFTournament.uuid IS NULL OR esfShooterQualificationESFTournament.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ESFShooterQualificationESFTournamentModelImpl.UUID_COLUMN_BITMASK |
			ESFShooterQualificationESFTournamentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchShooterQualificationESFTournamentException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f shooter qualification e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament findByUUID_G(String uuid,
		long groupId)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			fetchByUUID_G(uuid, groupId);

		if (esfShooterQualificationESFTournament == null) {
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

			throw new NoSuchShooterQualificationESFTournamentException(msg.toString());
		}

		return esfShooterQualificationESFTournament;
	}

	/**
	 * Returns the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament fetchByUUID_G(String uuid,
		long groupId) throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament fetchByUUID_G(String uuid,
		long groupId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ESFShooterQualificationESFTournament) {
			ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
				(ESFShooterQualificationESFTournament)result;

			if (!Validator.equals(uuid,
						esfShooterQualificationESFTournament.getUuid()) ||
					(groupId != esfShooterQualificationESFTournament.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT_WHERE);

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

				List<ESFShooterQualificationESFTournament> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
						list.get(0);

					result = esfShooterQualificationESFTournament;

					cacheResult(esfShooterQualificationESFTournament);

					if ((esfShooterQualificationESFTournament.getUuid() == null) ||
							!esfShooterQualificationESFTournament.getUuid()
																	 .equals(uuid) ||
							(esfShooterQualificationESFTournament.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, esfShooterQualificationESFTournament);
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
			return (ESFShooterQualificationESFTournament)result;
		}
	}

	/**
	 * Removes the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the e s f shooter qualification e s f tournament that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament removeByUUID_G(String uuid,
		long groupId)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			findByUUID_G(uuid, groupId);

		return remove(esfShooterQualificationESFTournament);
	}

	/**
	 * Returns the number of e s f shooter qualification e s f tournaments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching e s f shooter qualification e s f tournaments
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

			query.append(_SQL_COUNT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "esfShooterQualificationESFTournament.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "esfShooterQualificationESFTournament.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(esfShooterQualificationESFTournament.uuid IS NULL OR esfShooterQualificationESFTournament.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "esfShooterQualificationESFTournament.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFTOURNAMENT =
		new FinderPath(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFTournament",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOURNAMENT =
		new FinderPath(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFTournament",
			new String[] { Long.class.getName() },
			ESFShooterQualificationESFTournamentModelImpl.ESFTOURNAMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFTOURNAMENT = new FinderPath(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFTournament", new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @return the matching e s f shooter qualification e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFTournament> findByESFTournament(
		long esfTournamentId) throws SystemException {
		return findByESFTournament(esfTournamentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	 * @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	 * @return the range of matching e s f shooter qualification e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFTournament> findByESFTournament(
		long esfTournamentId, int start, int end) throws SystemException {
		return findByESFTournament(esfTournamentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	 * @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f shooter qualification e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFTournament> findByESFTournament(
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

		List<ESFShooterQualificationESFTournament> list = (List<ESFShooterQualificationESFTournament>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFShooterQualificationESFTournament esfShooterQualificationESFTournament : list) {
				if ((esfTournamentId != esfShooterQualificationESFTournament.getEsfTournamentId())) {
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

			query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT_WHERE);

			query.append(_FINDER_COLUMN_ESFTOURNAMENT_ESFTOURNAMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFShooterQualificationESFTournamentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfTournamentId);

				if (!pagination) {
					list = (List<ESFShooterQualificationESFTournament>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterQualificationESFTournament>(list);
				}
				else {
					list = (List<ESFShooterQualificationESFTournament>)QueryUtil.list(q,
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
	 * Returns the first e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament findByESFTournament_First(
		long esfTournamentId, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			fetchByESFTournament_First(esfTournamentId, orderByComparator);

		if (esfShooterQualificationESFTournament != null) {
			return esfShooterQualificationESFTournament;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfTournamentId=");
		msg.append(esfTournamentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationESFTournamentException(msg.toString());
	}

	/**
	 * Returns the first e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament fetchByESFTournament_First(
		long esfTournamentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFShooterQualificationESFTournament> list = findByESFTournament(esfTournamentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament findByESFTournament_Last(
		long esfTournamentId, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			fetchByESFTournament_Last(esfTournamentId, orderByComparator);

		if (esfShooterQualificationESFTournament != null) {
			return esfShooterQualificationESFTournament;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfTournamentId=");
		msg.append(esfTournamentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShooterQualificationESFTournamentException(msg.toString());
	}

	/**
	 * Returns the last e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament fetchByESFTournament_Last(
		long esfTournamentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFTournament(esfTournamentId);

		if (count == 0) {
			return null;
		}

		List<ESFShooterQualificationESFTournament> list = findByESFTournament(esfTournamentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f shooter qualification e s f tournaments before and after the current e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfShooterQualificationESFTournamentPK the primary key of the current e s f shooter qualification e s f tournament
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f shooter qualification e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament[] findByESFTournament_PrevAndNext(
		ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK,
		long esfTournamentId, OrderByComparator orderByComparator)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			findByPrimaryKey(esfShooterQualificationESFTournamentPK);

		Session session = null;

		try {
			session = openSession();

			ESFShooterQualificationESFTournament[] array = new ESFShooterQualificationESFTournamentImpl[3];

			array[0] = getByESFTournament_PrevAndNext(session,
					esfShooterQualificationESFTournament, esfTournamentId,
					orderByComparator, true);

			array[1] = esfShooterQualificationESFTournament;

			array[2] = getByESFTournament_PrevAndNext(session,
					esfShooterQualificationESFTournament, esfTournamentId,
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

	protected ESFShooterQualificationESFTournament getByESFTournament_PrevAndNext(
		Session session,
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament,
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

		query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT_WHERE);

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
			query.append(ESFShooterQualificationESFTournamentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfTournamentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfShooterQualificationESFTournament);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFShooterQualificationESFTournament> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63; from the database.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFTournament(long esfTournamentId)
		throws SystemException {
		for (ESFShooterQualificationESFTournament esfShooterQualificationESFTournament : findByESFTournament(
				esfTournamentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfShooterQualificationESFTournament);
		}
	}

	/**
	 * Returns the number of e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @return the number of matching e s f shooter qualification e s f tournaments
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

			query.append(_SQL_COUNT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT_WHERE);

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

	private static final String _FINDER_COLUMN_ESFTOURNAMENT_ESFTOURNAMENTID_2 = "esfShooterQualificationESFTournament.id.esfTournamentId = ?";

	public ESFShooterQualificationESFTournamentPersistenceImpl() {
		setModelClass(ESFShooterQualificationESFTournament.class);
	}

	/**
	 * Caches the e s f shooter qualification e s f tournament in the entity cache if it is enabled.
	 *
	 * @param esfShooterQualificationESFTournament the e s f shooter qualification e s f tournament
	 */
	@Override
	public void cacheResult(
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament) {
		EntityCacheUtil.putResult(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentImpl.class,
			esfShooterQualificationESFTournament.getPrimaryKey(),
			esfShooterQualificationESFTournament);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				esfShooterQualificationESFTournament.getUuid(),
				esfShooterQualificationESFTournament.getGroupId()
			}, esfShooterQualificationESFTournament);

		esfShooterQualificationESFTournament.resetOriginalValues();
	}

	/**
	 * Caches the e s f shooter qualification e s f tournaments in the entity cache if it is enabled.
	 *
	 * @param esfShooterQualificationESFTournaments the e s f shooter qualification e s f tournaments
	 */
	@Override
	public void cacheResult(
		List<ESFShooterQualificationESFTournament> esfShooterQualificationESFTournaments) {
		for (ESFShooterQualificationESFTournament esfShooterQualificationESFTournament : esfShooterQualificationESFTournaments) {
			if (EntityCacheUtil.getResult(
						ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterQualificationESFTournamentImpl.class,
						esfShooterQualificationESFTournament.getPrimaryKey()) == null) {
				cacheResult(esfShooterQualificationESFTournament);
			}
			else {
				esfShooterQualificationESFTournament.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f shooter qualification e s f tournaments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFShooterQualificationESFTournamentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFShooterQualificationESFTournamentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f shooter qualification e s f tournament.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament) {
		EntityCacheUtil.removeResult(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentImpl.class,
			esfShooterQualificationESFTournament.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfShooterQualificationESFTournament);
	}

	@Override
	public void clearCache(
		List<ESFShooterQualificationESFTournament> esfShooterQualificationESFTournaments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFShooterQualificationESFTournament esfShooterQualificationESFTournament : esfShooterQualificationESFTournaments) {
			EntityCacheUtil.removeResult(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterQualificationESFTournamentImpl.class,
				esfShooterQualificationESFTournament.getPrimaryKey());

			clearUniqueFindersCache(esfShooterQualificationESFTournament);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament) {
		if (esfShooterQualificationESFTournament.isNew()) {
			Object[] args = new Object[] {
					esfShooterQualificationESFTournament.getUuid(),
					esfShooterQualificationESFTournament.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				esfShooterQualificationESFTournament);
		}
		else {
			ESFShooterQualificationESFTournamentModelImpl esfShooterQualificationESFTournamentModelImpl =
				(ESFShooterQualificationESFTournamentModelImpl)esfShooterQualificationESFTournament;

			if ((esfShooterQualificationESFTournamentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterQualificationESFTournament.getUuid(),
						esfShooterQualificationESFTournament.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					esfShooterQualificationESFTournament);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament) {
		ESFShooterQualificationESFTournamentModelImpl esfShooterQualificationESFTournamentModelImpl =
			(ESFShooterQualificationESFTournamentModelImpl)esfShooterQualificationESFTournament;

		Object[] args = new Object[] {
				esfShooterQualificationESFTournament.getUuid(),
				esfShooterQualificationESFTournament.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((esfShooterQualificationESFTournamentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfShooterQualificationESFTournamentModelImpl.getOriginalUuid(),
					esfShooterQualificationESFTournamentModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new e s f shooter qualification e s f tournament with the primary key. Does not add the e s f shooter qualification e s f tournament to the database.
	 *
	 * @param esfShooterQualificationESFTournamentPK the primary key for the new e s f shooter qualification e s f tournament
	 * @return the new e s f shooter qualification e s f tournament
	 */
	@Override
	public ESFShooterQualificationESFTournament create(
		ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK) {
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			new ESFShooterQualificationESFTournamentImpl();

		esfShooterQualificationESFTournament.setNew(true);
		esfShooterQualificationESFTournament.setPrimaryKey(esfShooterQualificationESFTournamentPK);

		String uuid = PortalUUIDUtil.generate();

		esfShooterQualificationESFTournament.setUuid(uuid);

		return esfShooterQualificationESFTournament;
	}

	/**
	 * Removes the e s f shooter qualification e s f tournament with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfShooterQualificationESFTournamentPK the primary key of the e s f shooter qualification e s f tournament
	 * @return the e s f shooter qualification e s f tournament that was removed
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament remove(
		ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		return remove((Serializable)esfShooterQualificationESFTournamentPK);
	}

	/**
	 * Removes the e s f shooter qualification e s f tournament with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f shooter qualification e s f tournament
	 * @return the e s f shooter qualification e s f tournament that was removed
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament remove(Serializable primaryKey)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
				(ESFShooterQualificationESFTournament)session.get(ESFShooterQualificationESFTournamentImpl.class,
					primaryKey);

			if (esfShooterQualificationESFTournament == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShooterQualificationESFTournamentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfShooterQualificationESFTournament);
		}
		catch (NoSuchShooterQualificationESFTournamentException nsee) {
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
	protected ESFShooterQualificationESFTournament removeImpl(
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament)
		throws SystemException {
		esfShooterQualificationESFTournament = toUnwrappedModel(esfShooterQualificationESFTournament);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfShooterQualificationESFTournament)) {
				esfShooterQualificationESFTournament = (ESFShooterQualificationESFTournament)session.get(ESFShooterQualificationESFTournamentImpl.class,
						esfShooterQualificationESFTournament.getPrimaryKeyObj());
			}

			if (esfShooterQualificationESFTournament != null) {
				session.delete(esfShooterQualificationESFTournament);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfShooterQualificationESFTournament != null) {
			clearCache(esfShooterQualificationESFTournament);
		}

		return esfShooterQualificationESFTournament;
	}

	@Override
	public ESFShooterQualificationESFTournament updateImpl(
		it.ethica.esf.model.ESFShooterQualificationESFTournament esfShooterQualificationESFTournament)
		throws SystemException {
		esfShooterQualificationESFTournament = toUnwrappedModel(esfShooterQualificationESFTournament);

		boolean isNew = esfShooterQualificationESFTournament.isNew();

		ESFShooterQualificationESFTournamentModelImpl esfShooterQualificationESFTournamentModelImpl =
			(ESFShooterQualificationESFTournamentModelImpl)esfShooterQualificationESFTournament;

		if (Validator.isNull(esfShooterQualificationESFTournament.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			esfShooterQualificationESFTournament.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (esfShooterQualificationESFTournament.isNew()) {
				session.save(esfShooterQualificationESFTournament);

				esfShooterQualificationESFTournament.setNew(false);
			}
			else {
				session.merge(esfShooterQualificationESFTournament);
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
				!ESFShooterQualificationESFTournamentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfShooterQualificationESFTournamentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterQualificationESFTournamentModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						esfShooterQualificationESFTournamentModelImpl.getUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((esfShooterQualificationESFTournamentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOURNAMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfShooterQualificationESFTournamentModelImpl.getOriginalEsfTournamentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFTOURNAMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOURNAMENT,
					args);

				args = new Object[] {
						esfShooterQualificationESFTournamentModelImpl.getEsfTournamentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFTOURNAMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFTOURNAMENT,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
			ESFShooterQualificationESFTournamentImpl.class,
			esfShooterQualificationESFTournament.getPrimaryKey(),
			esfShooterQualificationESFTournament);

		clearUniqueFindersCache(esfShooterQualificationESFTournament);
		cacheUniqueFindersCache(esfShooterQualificationESFTournament);

		return esfShooterQualificationESFTournament;
	}

	protected ESFShooterQualificationESFTournament toUnwrappedModel(
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament) {
		if (esfShooterQualificationESFTournament instanceof ESFShooterQualificationESFTournamentImpl) {
			return esfShooterQualificationESFTournament;
		}

		ESFShooterQualificationESFTournamentImpl esfShooterQualificationESFTournamentImpl =
			new ESFShooterQualificationESFTournamentImpl();

		esfShooterQualificationESFTournamentImpl.setNew(esfShooterQualificationESFTournament.isNew());
		esfShooterQualificationESFTournamentImpl.setPrimaryKey(esfShooterQualificationESFTournament.getPrimaryKey());

		esfShooterQualificationESFTournamentImpl.setUuid(esfShooterQualificationESFTournament.getUuid());
		esfShooterQualificationESFTournamentImpl.setEsfShooterQualificationId(esfShooterQualificationESFTournament.getEsfShooterQualificationId());
		esfShooterQualificationESFTournamentImpl.setEsfTournamentId(esfShooterQualificationESFTournament.getEsfTournamentId());
		esfShooterQualificationESFTournamentImpl.setGroupId(esfShooterQualificationESFTournament.getGroupId());

		return esfShooterQualificationESFTournamentImpl;
	}

	/**
	 * Returns the e s f shooter qualification e s f tournament with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter qualification e s f tournament
	 * @return the e s f shooter qualification e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			fetchByPrimaryKey(primaryKey);

		if (esfShooterQualificationESFTournament == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShooterQualificationESFTournamentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfShooterQualificationESFTournament;
	}

	/**
	 * Returns the e s f shooter qualification e s f tournament with the primary key or throws a {@link it.ethica.esf.NoSuchShooterQualificationESFTournamentException} if it could not be found.
	 *
	 * @param esfShooterQualificationESFTournamentPK the primary key of the e s f shooter qualification e s f tournament
	 * @return the e s f shooter qualification e s f tournament
	 * @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament findByPrimaryKey(
		ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK)
		throws NoSuchShooterQualificationESFTournamentException, SystemException {
		return findByPrimaryKey((Serializable)esfShooterQualificationESFTournamentPK);
	}

	/**
	 * Returns the e s f shooter qualification e s f tournament with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f shooter qualification e s f tournament
	 * @return the e s f shooter qualification e s f tournament, or <code>null</code> if a e s f shooter qualification e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament =
			(ESFShooterQualificationESFTournament)EntityCacheUtil.getResult(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
				ESFShooterQualificationESFTournamentImpl.class, primaryKey);

		if (esfShooterQualificationESFTournament == _nullESFShooterQualificationESFTournament) {
			return null;
		}

		if (esfShooterQualificationESFTournament == null) {
			Session session = null;

			try {
				session = openSession();

				esfShooterQualificationESFTournament = (ESFShooterQualificationESFTournament)session.get(ESFShooterQualificationESFTournamentImpl.class,
						primaryKey);

				if (esfShooterQualificationESFTournament != null) {
					cacheResult(esfShooterQualificationESFTournament);
				}
				else {
					EntityCacheUtil.putResult(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
						ESFShooterQualificationESFTournamentImpl.class,
						primaryKey, _nullESFShooterQualificationESFTournament);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFShooterQualificationESFTournamentModelImpl.ENTITY_CACHE_ENABLED,
					ESFShooterQualificationESFTournamentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfShooterQualificationESFTournament;
	}

	/**
	 * Returns the e s f shooter qualification e s f tournament with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfShooterQualificationESFTournamentPK the primary key of the e s f shooter qualification e s f tournament
	 * @return the e s f shooter qualification e s f tournament, or <code>null</code> if a e s f shooter qualification e s f tournament with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFShooterQualificationESFTournament fetchByPrimaryKey(
		ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfShooterQualificationESFTournamentPK);
	}

	/**
	 * Returns all the e s f shooter qualification e s f tournaments.
	 *
	 * @return the e s f shooter qualification e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFTournament> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f shooter qualification e s f tournaments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	 * @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	 * @return the range of e s f shooter qualification e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFTournament> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f shooter qualification e s f tournaments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	 * @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f shooter qualification e s f tournaments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFShooterQualificationESFTournament> findAll(int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ESFShooterQualificationESFTournament> list = (List<ESFShooterQualificationESFTournament>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT;

				if (pagination) {
					sql = sql.concat(ESFShooterQualificationESFTournamentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFShooterQualificationESFTournament>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFShooterQualificationESFTournament>(list);
				}
				else {
					list = (List<ESFShooterQualificationESFTournament>)QueryUtil.list(q,
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
	 * Removes all the e s f shooter qualification e s f tournaments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFShooterQualificationESFTournament esfShooterQualificationESFTournament : findAll()) {
			remove(esfShooterQualificationESFTournament);
		}
	}

	/**
	 * Returns the number of e s f shooter qualification e s f tournaments.
	 *
	 * @return the number of e s f shooter qualification e s f tournaments
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

				Query q = session.createQuery(_SQL_COUNT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT);

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
	 * Initializes the e s f shooter qualification e s f tournament persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFShooterQualificationESFTournament")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFShooterQualificationESFTournament>> listenersList =
					new ArrayList<ModelListener<ESFShooterQualificationESFTournament>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFShooterQualificationESFTournament>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFShooterQualificationESFTournamentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT =
		"SELECT esfShooterQualificationESFTournament FROM ESFShooterQualificationESFTournament esfShooterQualificationESFTournament";
	private static final String _SQL_SELECT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT_WHERE =
		"SELECT esfShooterQualificationESFTournament FROM ESFShooterQualificationESFTournament esfShooterQualificationESFTournament WHERE ";
	private static final String _SQL_COUNT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT = "SELECT COUNT(esfShooterQualificationESFTournament) FROM ESFShooterQualificationESFTournament esfShooterQualificationESFTournament";
	private static final String _SQL_COUNT_ESFSHOOTERQUALIFICATIONESFTOURNAMENT_WHERE =
		"SELECT COUNT(esfShooterQualificationESFTournament) FROM ESFShooterQualificationESFTournament esfShooterQualificationESFTournament WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfShooterQualificationESFTournament.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFShooterQualificationESFTournament exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFShooterQualificationESFTournament exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFShooterQualificationESFTournamentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ESFShooterQualificationESFTournament _nullESFShooterQualificationESFTournament =
		new ESFShooterQualificationESFTournamentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFShooterQualificationESFTournament> toCacheModel() {
				return _nullESFShooterQualificationESFTournamentCacheModel;
			}
		};

	private static CacheModel<ESFShooterQualificationESFTournament> _nullESFShooterQualificationESFTournamentCacheModel =
		new CacheModel<ESFShooterQualificationESFTournament>() {
			@Override
			public ESFShooterQualificationESFTournament toEntityModel() {
				return _nullESFShooterQualificationESFTournament;
			}
		};
}