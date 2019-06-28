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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchEsfRadunoShootersException;
import it.ethica.esf.model.EsfRadunoShooters;
import it.ethica.esf.model.impl.EsfRadunoShootersImpl;
import it.ethica.esf.model.impl.EsfRadunoShootersModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the esf raduno shooters service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see EsfRadunoShootersPersistence
 * @see EsfRadunoShootersUtil
 * @generated
 */
public class EsfRadunoShootersPersistenceImpl extends BasePersistenceImpl<EsfRadunoShooters>
	implements EsfRadunoShootersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EsfRadunoShootersUtil} to access the esf raduno shooters persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EsfRadunoShootersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
			EsfRadunoShootersModelImpl.FINDER_CACHE_ENABLED,
			EsfRadunoShootersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
			EsfRadunoShootersModelImpl.FINDER_CACHE_ENABLED,
			EsfRadunoShootersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
			EsfRadunoShootersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS = new FinderPath(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
			EsfRadunoShootersModelImpl.FINDER_CACHE_ENABLED,
			EsfRadunoShootersImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByfindRadunoShooters",
			new String[] { Long.class.getName(), Long.class.getName() },
			EsfRadunoShootersModelImpl.ID_ESF_RADUNO_COLUMN_BITMASK |
			EsfRadunoShootersModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDRADUNOSHOOTERS = new FinderPath(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
			EsfRadunoShootersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindRadunoShooters",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; or throws a {@link it.ethica.esf.NoSuchEsfRadunoShootersException} if it could not be found.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param userId the user ID
	 * @return the matching esf raduno shooters
	 * @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a matching esf raduno shooters could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters findByfindRadunoShooters(long id_esf_raduno,
		long userId) throws NoSuchEsfRadunoShootersException, SystemException {
		EsfRadunoShooters esfRadunoShooters = fetchByfindRadunoShooters(id_esf_raduno,
				userId);

		if (esfRadunoShooters == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id_esf_raduno=");
			msg.append(id_esf_raduno);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEsfRadunoShootersException(msg.toString());
		}

		return esfRadunoShooters;
	}

	/**
	 * Returns the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param userId the user ID
	 * @return the matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters fetchByfindRadunoShooters(long id_esf_raduno,
		long userId) throws SystemException {
		return fetchByfindRadunoShooters(id_esf_raduno, userId, true);
	}

	/**
	 * Returns the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters fetchByfindRadunoShooters(long id_esf_raduno,
		long userId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { id_esf_raduno, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS,
					finderArgs, this);
		}

		if (result instanceof EsfRadunoShooters) {
			EsfRadunoShooters esfRadunoShooters = (EsfRadunoShooters)result;

			if ((id_esf_raduno != esfRadunoShooters.getId_esf_raduno()) ||
					(userId != esfRadunoShooters.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ESFRADUNOSHOOTERS_WHERE);

			query.append(_FINDER_COLUMN_FINDRADUNOSHOOTERS_ID_ESF_RADUNO_2);

			query.append(_FINDER_COLUMN_FINDRADUNOSHOOTERS_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

				qPos.add(userId);

				List<EsfRadunoShooters> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EsfRadunoShootersPersistenceImpl.fetchByfindRadunoShooters(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EsfRadunoShooters esfRadunoShooters = list.get(0);

					result = esfRadunoShooters;

					cacheResult(esfRadunoShooters);

					if ((esfRadunoShooters.getId_esf_raduno() != id_esf_raduno) ||
							(esfRadunoShooters.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS,
							finderArgs, esfRadunoShooters);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS,
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
			return (EsfRadunoShooters)result;
		}
	}

	/**
	 * Removes the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; from the database.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param userId the user ID
	 * @return the esf raduno shooters that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters removeByfindRadunoShooters(long id_esf_raduno,
		long userId) throws NoSuchEsfRadunoShootersException, SystemException {
		EsfRadunoShooters esfRadunoShooters = findByfindRadunoShooters(id_esf_raduno,
				userId);

		return remove(esfRadunoShooters);
	}

	/**
	 * Returns the number of esf raduno shooterses where id_esf_raduno = &#63; and userId = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param userId the user ID
	 * @return the number of matching esf raduno shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindRadunoShooters(long id_esf_raduno, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDRADUNOSHOOTERS;

		Object[] finderArgs = new Object[] { id_esf_raduno, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFRADUNOSHOOTERS_WHERE);

			query.append(_FINDER_COLUMN_FINDRADUNOSHOOTERS_ID_ESF_RADUNO_2);

			query.append(_FINDER_COLUMN_FINDRADUNOSHOOTERS_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_FINDRADUNOSHOOTERS_ID_ESF_RADUNO_2 =
		"esfRadunoShooters.id.id_esf_raduno = ? AND ";
	private static final String _FINDER_COLUMN_FINDRADUNOSHOOTERS_USERID_2 = "esfRadunoShooters.id.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYRADUNO =
		new FinderPath(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
			EsfRadunoShootersModelImpl.FINDER_CACHE_ENABLED,
			EsfRadunoShootersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByRaduno",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYRADUNO =
		new FinderPath(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
			EsfRadunoShootersModelImpl.FINDER_CACHE_ENABLED,
			EsfRadunoShootersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByRaduno",
			new String[] { Long.class.getName() },
			EsfRadunoShootersModelImpl.ID_ESF_RADUNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYRADUNO = new FinderPath(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
			EsfRadunoShootersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByRaduno",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the esf raduno shooterses where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @return the matching esf raduno shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EsfRadunoShooters> findByfindByRaduno(long id_esf_raduno)
		throws SystemException {
		return findByfindByRaduno(id_esf_raduno, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the esf raduno shooterses where id_esf_raduno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.EsfRadunoShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param start the lower bound of the range of esf raduno shooterses
	 * @param end the upper bound of the range of esf raduno shooterses (not inclusive)
	 * @return the range of matching esf raduno shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EsfRadunoShooters> findByfindByRaduno(long id_esf_raduno,
		int start, int end) throws SystemException {
		return findByfindByRaduno(id_esf_raduno, start, end, null);
	}

	/**
	 * Returns an ordered range of all the esf raduno shooterses where id_esf_raduno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.EsfRadunoShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param start the lower bound of the range of esf raduno shooterses
	 * @param end the upper bound of the range of esf raduno shooterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching esf raduno shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EsfRadunoShooters> findByfindByRaduno(long id_esf_raduno,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYRADUNO;
			finderArgs = new Object[] { id_esf_raduno };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYRADUNO;
			finderArgs = new Object[] {
					id_esf_raduno,
					
					start, end, orderByComparator
				};
		}

		List<EsfRadunoShooters> list = (List<EsfRadunoShooters>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EsfRadunoShooters esfRadunoShooters : list) {
				if ((id_esf_raduno != esfRadunoShooters.getId_esf_raduno())) {
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

			query.append(_SQL_SELECT_ESFRADUNOSHOOTERS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYRADUNO_ID_ESF_RADUNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EsfRadunoShootersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

				if (!pagination) {
					list = (List<EsfRadunoShooters>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EsfRadunoShooters>(list);
				}
				else {
					list = (List<EsfRadunoShooters>)QueryUtil.list(q,
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
	 * Returns the first esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esf raduno shooters
	 * @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a matching esf raduno shooters could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters findByfindByRaduno_First(long id_esf_raduno,
		OrderByComparator orderByComparator)
		throws NoSuchEsfRadunoShootersException, SystemException {
		EsfRadunoShooters esfRadunoShooters = fetchByfindByRaduno_First(id_esf_raduno,
				orderByComparator);

		if (esfRadunoShooters != null) {
			return esfRadunoShooters;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_esf_raduno=");
		msg.append(id_esf_raduno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEsfRadunoShootersException(msg.toString());
	}

	/**
	 * Returns the first esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters fetchByfindByRaduno_First(long id_esf_raduno,
		OrderByComparator orderByComparator) throws SystemException {
		List<EsfRadunoShooters> list = findByfindByRaduno(id_esf_raduno, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esf raduno shooters
	 * @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a matching esf raduno shooters could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters findByfindByRaduno_Last(long id_esf_raduno,
		OrderByComparator orderByComparator)
		throws NoSuchEsfRadunoShootersException, SystemException {
		EsfRadunoShooters esfRadunoShooters = fetchByfindByRaduno_Last(id_esf_raduno,
				orderByComparator);

		if (esfRadunoShooters != null) {
			return esfRadunoShooters;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_esf_raduno=");
		msg.append(id_esf_raduno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEsfRadunoShootersException(msg.toString());
	}

	/**
	 * Returns the last esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters fetchByfindByRaduno_Last(long id_esf_raduno,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByfindByRaduno(id_esf_raduno);

		if (count == 0) {
			return null;
		}

		List<EsfRadunoShooters> list = findByfindByRaduno(id_esf_raduno,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the esf raduno shooterses before and after the current esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	 *
	 * @param esfRadunoShootersPK the primary key of the current esf raduno shooters
	 * @param id_esf_raduno the id_esf_raduno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next esf raduno shooters
	 * @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a esf raduno shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters[] findByfindByRaduno_PrevAndNext(
		EsfRadunoShootersPK esfRadunoShootersPK, long id_esf_raduno,
		OrderByComparator orderByComparator)
		throws NoSuchEsfRadunoShootersException, SystemException {
		EsfRadunoShooters esfRadunoShooters = findByPrimaryKey(esfRadunoShootersPK);

		Session session = null;

		try {
			session = openSession();

			EsfRadunoShooters[] array = new EsfRadunoShootersImpl[3];

			array[0] = getByfindByRaduno_PrevAndNext(session,
					esfRadunoShooters, id_esf_raduno, orderByComparator, true);

			array[1] = esfRadunoShooters;

			array[2] = getByfindByRaduno_PrevAndNext(session,
					esfRadunoShooters, id_esf_raduno, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EsfRadunoShooters getByfindByRaduno_PrevAndNext(Session session,
		EsfRadunoShooters esfRadunoShooters, long id_esf_raduno,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRADUNOSHOOTERS_WHERE);

		query.append(_FINDER_COLUMN_FINDBYRADUNO_ID_ESF_RADUNO_2);

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
			query.append(EsfRadunoShootersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_esf_raduno);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfRadunoShooters);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EsfRadunoShooters> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the esf raduno shooterses where id_esf_raduno = &#63; from the database.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByfindByRaduno(long id_esf_raduno)
		throws SystemException {
		for (EsfRadunoShooters esfRadunoShooters : findByfindByRaduno(
				id_esf_raduno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfRadunoShooters);
		}
	}

	/**
	 * Returns the number of esf raduno shooterses where id_esf_raduno = &#63;.
	 *
	 * @param id_esf_raduno the id_esf_raduno
	 * @return the number of matching esf raduno shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindByRaduno(long id_esf_raduno)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYRADUNO;

		Object[] finderArgs = new Object[] { id_esf_raduno };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFRADUNOSHOOTERS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYRADUNO_ID_ESF_RADUNO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_esf_raduno);

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

	private static final String _FINDER_COLUMN_FINDBYRADUNO_ID_ESF_RADUNO_2 = "esfRadunoShooters.id.id_esf_raduno = ?";

	public EsfRadunoShootersPersistenceImpl() {
		setModelClass(EsfRadunoShooters.class);
	}

	/**
	 * Caches the esf raduno shooters in the entity cache if it is enabled.
	 *
	 * @param esfRadunoShooters the esf raduno shooters
	 */
	@Override
	public void cacheResult(EsfRadunoShooters esfRadunoShooters) {
		EntityCacheUtil.putResult(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
			EsfRadunoShootersImpl.class, esfRadunoShooters.getPrimaryKey(),
			esfRadunoShooters);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS,
			new Object[] {
				esfRadunoShooters.getId_esf_raduno(),
				esfRadunoShooters.getUserId()
			}, esfRadunoShooters);

		esfRadunoShooters.resetOriginalValues();
	}

	/**
	 * Caches the esf raduno shooterses in the entity cache if it is enabled.
	 *
	 * @param esfRadunoShooterses the esf raduno shooterses
	 */
	@Override
	public void cacheResult(List<EsfRadunoShooters> esfRadunoShooterses) {
		for (EsfRadunoShooters esfRadunoShooters : esfRadunoShooterses) {
			if (EntityCacheUtil.getResult(
						EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
						EsfRadunoShootersImpl.class,
						esfRadunoShooters.getPrimaryKey()) == null) {
				cacheResult(esfRadunoShooters);
			}
			else {
				esfRadunoShooters.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all esf raduno shooterses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EsfRadunoShootersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EsfRadunoShootersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the esf raduno shooters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EsfRadunoShooters esfRadunoShooters) {
		EntityCacheUtil.removeResult(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
			EsfRadunoShootersImpl.class, esfRadunoShooters.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfRadunoShooters);
	}

	@Override
	public void clearCache(List<EsfRadunoShooters> esfRadunoShooterses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EsfRadunoShooters esfRadunoShooters : esfRadunoShooterses) {
			EntityCacheUtil.removeResult(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
				EsfRadunoShootersImpl.class, esfRadunoShooters.getPrimaryKey());

			clearUniqueFindersCache(esfRadunoShooters);
		}
	}

	protected void cacheUniqueFindersCache(EsfRadunoShooters esfRadunoShooters) {
		if (esfRadunoShooters.isNew()) {
			Object[] args = new Object[] {
					esfRadunoShooters.getId_esf_raduno(),
					esfRadunoShooters.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDRADUNOSHOOTERS,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS,
				args, esfRadunoShooters);
		}
		else {
			EsfRadunoShootersModelImpl esfRadunoShootersModelImpl = (EsfRadunoShootersModelImpl)esfRadunoShooters;

			if ((esfRadunoShootersModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRadunoShooters.getId_esf_raduno(),
						esfRadunoShooters.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDRADUNOSHOOTERS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS,
					args, esfRadunoShooters);
			}
		}
	}

	protected void clearUniqueFindersCache(EsfRadunoShooters esfRadunoShooters) {
		EsfRadunoShootersModelImpl esfRadunoShootersModelImpl = (EsfRadunoShootersModelImpl)esfRadunoShooters;

		Object[] args = new Object[] {
				esfRadunoShooters.getId_esf_raduno(),
				esfRadunoShooters.getUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDRADUNOSHOOTERS,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS,
			args);

		if ((esfRadunoShootersModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfRadunoShootersModelImpl.getOriginalId_esf_raduno(),
					esfRadunoShootersModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDRADUNOSHOOTERS,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDRADUNOSHOOTERS,
				args);
		}
	}

	/**
	 * Creates a new esf raduno shooters with the primary key. Does not add the esf raduno shooters to the database.
	 *
	 * @param esfRadunoShootersPK the primary key for the new esf raduno shooters
	 * @return the new esf raduno shooters
	 */
	@Override
	public EsfRadunoShooters create(EsfRadunoShootersPK esfRadunoShootersPK) {
		EsfRadunoShooters esfRadunoShooters = new EsfRadunoShootersImpl();

		esfRadunoShooters.setNew(true);
		esfRadunoShooters.setPrimaryKey(esfRadunoShootersPK);

		return esfRadunoShooters;
	}

	/**
	 * Removes the esf raduno shooters with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfRadunoShootersPK the primary key of the esf raduno shooters
	 * @return the esf raduno shooters that was removed
	 * @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a esf raduno shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters remove(EsfRadunoShootersPK esfRadunoShootersPK)
		throws NoSuchEsfRadunoShootersException, SystemException {
		return remove((Serializable)esfRadunoShootersPK);
	}

	/**
	 * Removes the esf raduno shooters with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the esf raduno shooters
	 * @return the esf raduno shooters that was removed
	 * @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a esf raduno shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters remove(Serializable primaryKey)
		throws NoSuchEsfRadunoShootersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EsfRadunoShooters esfRadunoShooters = (EsfRadunoShooters)session.get(EsfRadunoShootersImpl.class,
					primaryKey);

			if (esfRadunoShooters == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEsfRadunoShootersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfRadunoShooters);
		}
		catch (NoSuchEsfRadunoShootersException nsee) {
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
	protected EsfRadunoShooters removeImpl(EsfRadunoShooters esfRadunoShooters)
		throws SystemException {
		esfRadunoShooters = toUnwrappedModel(esfRadunoShooters);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfRadunoShooters)) {
				esfRadunoShooters = (EsfRadunoShooters)session.get(EsfRadunoShootersImpl.class,
						esfRadunoShooters.getPrimaryKeyObj());
			}

			if (esfRadunoShooters != null) {
				session.delete(esfRadunoShooters);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfRadunoShooters != null) {
			clearCache(esfRadunoShooters);
		}

		return esfRadunoShooters;
	}

	@Override
	public EsfRadunoShooters updateImpl(
		it.ethica.esf.model.EsfRadunoShooters esfRadunoShooters)
		throws SystemException {
		esfRadunoShooters = toUnwrappedModel(esfRadunoShooters);

		boolean isNew = esfRadunoShooters.isNew();

		EsfRadunoShootersModelImpl esfRadunoShootersModelImpl = (EsfRadunoShootersModelImpl)esfRadunoShooters;

		Session session = null;

		try {
			session = openSession();

			if (esfRadunoShooters.isNew()) {
				session.save(esfRadunoShooters);

				esfRadunoShooters.setNew(false);
			}
			else {
				session.merge(esfRadunoShooters);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EsfRadunoShootersModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfRadunoShootersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYRADUNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfRadunoShootersModelImpl.getOriginalId_esf_raduno()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYRADUNO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYRADUNO,
					args);

				args = new Object[] {
						esfRadunoShootersModelImpl.getId_esf_raduno()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYRADUNO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYRADUNO,
					args);
			}
		}

		EntityCacheUtil.putResult(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
			EsfRadunoShootersImpl.class, esfRadunoShooters.getPrimaryKey(),
			esfRadunoShooters);

		clearUniqueFindersCache(esfRadunoShooters);
		cacheUniqueFindersCache(esfRadunoShooters);

		return esfRadunoShooters;
	}

	protected EsfRadunoShooters toUnwrappedModel(
		EsfRadunoShooters esfRadunoShooters) {
		if (esfRadunoShooters instanceof EsfRadunoShootersImpl) {
			return esfRadunoShooters;
		}

		EsfRadunoShootersImpl esfRadunoShootersImpl = new EsfRadunoShootersImpl();

		esfRadunoShootersImpl.setNew(esfRadunoShooters.isNew());
		esfRadunoShootersImpl.setPrimaryKey(esfRadunoShooters.getPrimaryKey());

		esfRadunoShootersImpl.setId_esf_raduno_shooters(esfRadunoShooters.getId_esf_raduno_shooters());
		esfRadunoShootersImpl.setId_esf_raduno(esfRadunoShooters.getId_esf_raduno());
		esfRadunoShootersImpl.setUserId(esfRadunoShooters.getUserId());

		return esfRadunoShootersImpl;
	}

	/**
	 * Returns the esf raduno shooters with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the esf raduno shooters
	 * @return the esf raduno shooters
	 * @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a esf raduno shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEsfRadunoShootersException, SystemException {
		EsfRadunoShooters esfRadunoShooters = fetchByPrimaryKey(primaryKey);

		if (esfRadunoShooters == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEsfRadunoShootersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfRadunoShooters;
	}

	/**
	 * Returns the esf raduno shooters with the primary key or throws a {@link it.ethica.esf.NoSuchEsfRadunoShootersException} if it could not be found.
	 *
	 * @param esfRadunoShootersPK the primary key of the esf raduno shooters
	 * @return the esf raduno shooters
	 * @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a esf raduno shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters findByPrimaryKey(
		EsfRadunoShootersPK esfRadunoShootersPK)
		throws NoSuchEsfRadunoShootersException, SystemException {
		return findByPrimaryKey((Serializable)esfRadunoShootersPK);
	}

	/**
	 * Returns the esf raduno shooters with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the esf raduno shooters
	 * @return the esf raduno shooters, or <code>null</code> if a esf raduno shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EsfRadunoShooters esfRadunoShooters = (EsfRadunoShooters)EntityCacheUtil.getResult(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
				EsfRadunoShootersImpl.class, primaryKey);

		if (esfRadunoShooters == _nullEsfRadunoShooters) {
			return null;
		}

		if (esfRadunoShooters == null) {
			Session session = null;

			try {
				session = openSession();

				esfRadunoShooters = (EsfRadunoShooters)session.get(EsfRadunoShootersImpl.class,
						primaryKey);

				if (esfRadunoShooters != null) {
					cacheResult(esfRadunoShooters);
				}
				else {
					EntityCacheUtil.putResult(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
						EsfRadunoShootersImpl.class, primaryKey,
						_nullEsfRadunoShooters);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EsfRadunoShootersModelImpl.ENTITY_CACHE_ENABLED,
					EsfRadunoShootersImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfRadunoShooters;
	}

	/**
	 * Returns the esf raduno shooters with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfRadunoShootersPK the primary key of the esf raduno shooters
	 * @return the esf raduno shooters, or <code>null</code> if a esf raduno shooters with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EsfRadunoShooters fetchByPrimaryKey(
		EsfRadunoShootersPK esfRadunoShootersPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfRadunoShootersPK);
	}

	/**
	 * Returns all the esf raduno shooterses.
	 *
	 * @return the esf raduno shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EsfRadunoShooters> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the esf raduno shooterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.EsfRadunoShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of esf raduno shooterses
	 * @param end the upper bound of the range of esf raduno shooterses (not inclusive)
	 * @return the range of esf raduno shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EsfRadunoShooters> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the esf raduno shooterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.EsfRadunoShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of esf raduno shooterses
	 * @param end the upper bound of the range of esf raduno shooterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of esf raduno shooterses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EsfRadunoShooters> findAll(int start, int end,
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

		List<EsfRadunoShooters> list = (List<EsfRadunoShooters>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFRADUNOSHOOTERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFRADUNOSHOOTERS;

				if (pagination) {
					sql = sql.concat(EsfRadunoShootersModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EsfRadunoShooters>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EsfRadunoShooters>(list);
				}
				else {
					list = (List<EsfRadunoShooters>)QueryUtil.list(q,
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
	 * Removes all the esf raduno shooterses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EsfRadunoShooters esfRadunoShooters : findAll()) {
			remove(esfRadunoShooters);
		}
	}

	/**
	 * Returns the number of esf raduno shooterses.
	 *
	 * @return the number of esf raduno shooterses
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

				Query q = session.createQuery(_SQL_COUNT_ESFRADUNOSHOOTERS);

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

	/**
	 * Initializes the esf raduno shooters persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.EsfRadunoShooters")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EsfRadunoShooters>> listenersList = new ArrayList<ModelListener<EsfRadunoShooters>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EsfRadunoShooters>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EsfRadunoShootersImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFRADUNOSHOOTERS = "SELECT esfRadunoShooters FROM EsfRadunoShooters esfRadunoShooters";
	private static final String _SQL_SELECT_ESFRADUNOSHOOTERS_WHERE = "SELECT esfRadunoShooters FROM EsfRadunoShooters esfRadunoShooters WHERE ";
	private static final String _SQL_COUNT_ESFRADUNOSHOOTERS = "SELECT COUNT(esfRadunoShooters) FROM EsfRadunoShooters esfRadunoShooters";
	private static final String _SQL_COUNT_ESFRADUNOSHOOTERS_WHERE = "SELECT COUNT(esfRadunoShooters) FROM EsfRadunoShooters esfRadunoShooters WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfRadunoShooters.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EsfRadunoShooters exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EsfRadunoShooters exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EsfRadunoShootersPersistenceImpl.class);
	private static EsfRadunoShooters _nullEsfRadunoShooters = new EsfRadunoShootersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EsfRadunoShooters> toCacheModel() {
				return _nullEsfRadunoShootersCacheModel;
			}
		};

	private static CacheModel<EsfRadunoShooters> _nullEsfRadunoShootersCacheModel =
		new CacheModel<EsfRadunoShooters>() {
			@Override
			public EsfRadunoShooters toEntityModel() {
				return _nullEsfRadunoShooters;
			}
		};
}