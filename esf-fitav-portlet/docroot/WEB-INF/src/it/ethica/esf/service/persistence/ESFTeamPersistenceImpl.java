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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchTeamException;
import it.ethica.esf.model.ESFTeam;
import it.ethica.esf.model.impl.ESFTeamImpl;
import it.ethica.esf.model.impl.ESFTeamModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f team service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFTeamPersistence
 * @see ESFTeamUtil
 * @generated
 */
public class ESFTeamPersistenceImpl extends BasePersistenceImpl<ESFTeam>
	implements ESFTeamPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFTeamUtil} to access the e s f team persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFTeamImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
			ESFTeamModelImpl.FINDER_CACHE_ENABLED, ESFTeamImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
			ESFTeamModelImpl.FINDER_CACHE_ENABLED, ESFTeamImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
			ESFTeamModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TOURNAMENT =
		new FinderPath(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
			ESFTeamModelImpl.FINDER_CACHE_ENABLED, ESFTeamImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTournament",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOURNAMENT =
		new FinderPath(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
			ESFTeamModelImpl.FINDER_CACHE_ENABLED, ESFTeamImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTournament",
			new String[] { Long.class.getName() },
			ESFTeamModelImpl.ESFTOURNAMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TOURNAMENT = new FinderPath(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
			ESFTeamModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTournament",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f teams where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @return the matching e s f teams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTeam> findByTournament(long esfTournamentId)
		throws SystemException {
		return findByTournament(esfTournamentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f teams where esfTournamentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTeamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param start the lower bound of the range of e s f teams
	 * @param end the upper bound of the range of e s f teams (not inclusive)
	 * @return the range of matching e s f teams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTeam> findByTournament(long esfTournamentId, int start,
		int end) throws SystemException {
		return findByTournament(esfTournamentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f teams where esfTournamentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTeamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param start the lower bound of the range of e s f teams
	 * @param end the upper bound of the range of e s f teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f teams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTeam> findByTournament(long esfTournamentId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOURNAMENT;
			finderArgs = new Object[] { esfTournamentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TOURNAMENT;
			finderArgs = new Object[] {
					esfTournamentId,
					
					start, end, orderByComparator
				};
		}

		List<ESFTeam> list = (List<ESFTeam>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFTeam esfTeam : list) {
				if ((esfTournamentId != esfTeam.getEsfTournamentId())) {
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

			query.append(_SQL_SELECT_ESFTEAM_WHERE);

			query.append(_FINDER_COLUMN_TOURNAMENT_ESFTOURNAMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFTeamModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfTournamentId);

				if (!pagination) {
					list = (List<ESFTeam>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTeam>(list);
				}
				else {
					list = (List<ESFTeam>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f team in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f team
	 * @throws it.ethica.esf.NoSuchTeamException if a matching e s f team could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTeam findByTournament_First(long esfTournamentId,
		OrderByComparator orderByComparator)
		throws NoSuchTeamException, SystemException {
		ESFTeam esfTeam = fetchByTournament_First(esfTournamentId,
				orderByComparator);

		if (esfTeam != null) {
			return esfTeam;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfTournamentId=");
		msg.append(esfTournamentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTeamException(msg.toString());
	}

	/**
	 * Returns the first e s f team in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f team, or <code>null</code> if a matching e s f team could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTeam fetchByTournament_First(long esfTournamentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFTeam> list = findByTournament(esfTournamentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f team in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f team
	 * @throws it.ethica.esf.NoSuchTeamException if a matching e s f team could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTeam findByTournament_Last(long esfTournamentId,
		OrderByComparator orderByComparator)
		throws NoSuchTeamException, SystemException {
		ESFTeam esfTeam = fetchByTournament_Last(esfTournamentId,
				orderByComparator);

		if (esfTeam != null) {
			return esfTeam;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfTournamentId=");
		msg.append(esfTournamentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTeamException(msg.toString());
	}

	/**
	 * Returns the last e s f team in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f team, or <code>null</code> if a matching e s f team could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTeam fetchByTournament_Last(long esfTournamentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTournament(esfTournamentId);

		if (count == 0) {
			return null;
		}

		List<ESFTeam> list = findByTournament(esfTournamentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f teams before and after the current e s f team in the ordered set where esfTournamentId = &#63;.
	 *
	 * @param esfTeamId the primary key of the current e s f team
	 * @param esfTournamentId the esf tournament ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f team
	 * @throws it.ethica.esf.NoSuchTeamException if a e s f team with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTeam[] findByTournament_PrevAndNext(long esfTeamId,
		long esfTournamentId, OrderByComparator orderByComparator)
		throws NoSuchTeamException, SystemException {
		ESFTeam esfTeam = findByPrimaryKey(esfTeamId);

		Session session = null;

		try {
			session = openSession();

			ESFTeam[] array = new ESFTeamImpl[3];

			array[0] = getByTournament_PrevAndNext(session, esfTeam,
					esfTournamentId, orderByComparator, true);

			array[1] = esfTeam;

			array[2] = getByTournament_PrevAndNext(session, esfTeam,
					esfTournamentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFTeam getByTournament_PrevAndNext(Session session,
		ESFTeam esfTeam, long esfTournamentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTEAM_WHERE);

		query.append(_FINDER_COLUMN_TOURNAMENT_ESFTOURNAMENTID_2);

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
			query.append(ESFTeamModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfTournamentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfTeam);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFTeam> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f teams where esfTournamentId = &#63; from the database.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTournament(long esfTournamentId)
		throws SystemException {
		for (ESFTeam esfTeam : findByTournament(esfTournamentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfTeam);
		}
	}

	/**
	 * Returns the number of e s f teams where esfTournamentId = &#63;.
	 *
	 * @param esfTournamentId the esf tournament ID
	 * @return the number of matching e s f teams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTournament(long esfTournamentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TOURNAMENT;

		Object[] finderArgs = new Object[] { esfTournamentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFTEAM_WHERE);

			query.append(_FINDER_COLUMN_TOURNAMENT_ESFTOURNAMENTID_2);

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

	private static final String _FINDER_COLUMN_TOURNAMENT_ESFTOURNAMENTID_2 = "esfTeam.esfTournamentId = ?";

	public ESFTeamPersistenceImpl() {
		setModelClass(ESFTeam.class);
	}

	/**
	 * Caches the e s f team in the entity cache if it is enabled.
	 *
	 * @param esfTeam the e s f team
	 */
	@Override
	public void cacheResult(ESFTeam esfTeam) {
		EntityCacheUtil.putResult(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
			ESFTeamImpl.class, esfTeam.getPrimaryKey(), esfTeam);

		esfTeam.resetOriginalValues();
	}

	/**
	 * Caches the e s f teams in the entity cache if it is enabled.
	 *
	 * @param esfTeams the e s f teams
	 */
	@Override
	public void cacheResult(List<ESFTeam> esfTeams) {
		for (ESFTeam esfTeam : esfTeams) {
			if (EntityCacheUtil.getResult(
						ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
						ESFTeamImpl.class, esfTeam.getPrimaryKey()) == null) {
				cacheResult(esfTeam);
			}
			else {
				esfTeam.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f teams.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFTeamImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFTeamImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f team.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFTeam esfTeam) {
		EntityCacheUtil.removeResult(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
			ESFTeamImpl.class, esfTeam.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFTeam> esfTeams) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFTeam esfTeam : esfTeams) {
			EntityCacheUtil.removeResult(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
				ESFTeamImpl.class, esfTeam.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f team with the primary key. Does not add the e s f team to the database.
	 *
	 * @param esfTeamId the primary key for the new e s f team
	 * @return the new e s f team
	 */
	@Override
	public ESFTeam create(long esfTeamId) {
		ESFTeam esfTeam = new ESFTeamImpl();

		esfTeam.setNew(true);
		esfTeam.setPrimaryKey(esfTeamId);

		return esfTeam;
	}

	/**
	 * Removes the e s f team with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfTeamId the primary key of the e s f team
	 * @return the e s f team that was removed
	 * @throws it.ethica.esf.NoSuchTeamException if a e s f team with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTeam remove(long esfTeamId)
		throws NoSuchTeamException, SystemException {
		return remove((Serializable)esfTeamId);
	}

	/**
	 * Removes the e s f team with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f team
	 * @return the e s f team that was removed
	 * @throws it.ethica.esf.NoSuchTeamException if a e s f team with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTeam remove(Serializable primaryKey)
		throws NoSuchTeamException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFTeam esfTeam = (ESFTeam)session.get(ESFTeamImpl.class, primaryKey);

			if (esfTeam == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTeamException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfTeam);
		}
		catch (NoSuchTeamException nsee) {
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
	protected ESFTeam removeImpl(ESFTeam esfTeam) throws SystemException {
		esfTeam = toUnwrappedModel(esfTeam);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfTeam)) {
				esfTeam = (ESFTeam)session.get(ESFTeamImpl.class,
						esfTeam.getPrimaryKeyObj());
			}

			if (esfTeam != null) {
				session.delete(esfTeam);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfTeam != null) {
			clearCache(esfTeam);
		}

		return esfTeam;
	}

	@Override
	public ESFTeam updateImpl(it.ethica.esf.model.ESFTeam esfTeam)
		throws SystemException {
		esfTeam = toUnwrappedModel(esfTeam);

		boolean isNew = esfTeam.isNew();

		ESFTeamModelImpl esfTeamModelImpl = (ESFTeamModelImpl)esfTeam;

		Session session = null;

		try {
			session = openSession();

			if (esfTeam.isNew()) {
				session.save(esfTeam);

				esfTeam.setNew(false);
			}
			else {
				session.merge(esfTeam);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFTeamModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfTeamModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOURNAMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfTeamModelImpl.getOriginalEsfTournamentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOURNAMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOURNAMENT,
					args);

				args = new Object[] { esfTeamModelImpl.getEsfTournamentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOURNAMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOURNAMENT,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
			ESFTeamImpl.class, esfTeam.getPrimaryKey(), esfTeam);

		return esfTeam;
	}

	protected ESFTeam toUnwrappedModel(ESFTeam esfTeam) {
		if (esfTeam instanceof ESFTeamImpl) {
			return esfTeam;
		}

		ESFTeamImpl esfTeamImpl = new ESFTeamImpl();

		esfTeamImpl.setNew(esfTeam.isNew());
		esfTeamImpl.setPrimaryKey(esfTeam.getPrimaryKey());

		esfTeamImpl.setEsfTeamId(esfTeam.getEsfTeamId());
		esfTeamImpl.setEsfTournamentId(esfTeam.getEsfTournamentId());
		esfTeamImpl.setName(esfTeam.getName());

		return esfTeamImpl;
	}

	/**
	 * Returns the e s f team with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f team
	 * @return the e s f team
	 * @throws it.ethica.esf.NoSuchTeamException if a e s f team with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTeam findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTeamException, SystemException {
		ESFTeam esfTeam = fetchByPrimaryKey(primaryKey);

		if (esfTeam == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTeamException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfTeam;
	}

	/**
	 * Returns the e s f team with the primary key or throws a {@link it.ethica.esf.NoSuchTeamException} if it could not be found.
	 *
	 * @param esfTeamId the primary key of the e s f team
	 * @return the e s f team
	 * @throws it.ethica.esf.NoSuchTeamException if a e s f team with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTeam findByPrimaryKey(long esfTeamId)
		throws NoSuchTeamException, SystemException {
		return findByPrimaryKey((Serializable)esfTeamId);
	}

	/**
	 * Returns the e s f team with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f team
	 * @return the e s f team, or <code>null</code> if a e s f team with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTeam fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFTeam esfTeam = (ESFTeam)EntityCacheUtil.getResult(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
				ESFTeamImpl.class, primaryKey);

		if (esfTeam == _nullESFTeam) {
			return null;
		}

		if (esfTeam == null) {
			Session session = null;

			try {
				session = openSession();

				esfTeam = (ESFTeam)session.get(ESFTeamImpl.class, primaryKey);

				if (esfTeam != null) {
					cacheResult(esfTeam);
				}
				else {
					EntityCacheUtil.putResult(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
						ESFTeamImpl.class, primaryKey, _nullESFTeam);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFTeamModelImpl.ENTITY_CACHE_ENABLED,
					ESFTeamImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfTeam;
	}

	/**
	 * Returns the e s f team with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfTeamId the primary key of the e s f team
	 * @return the e s f team, or <code>null</code> if a e s f team with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFTeam fetchByPrimaryKey(long esfTeamId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfTeamId);
	}

	/**
	 * Returns all the e s f teams.
	 *
	 * @return the e s f teams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTeam> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTeamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f teams
	 * @param end the upper bound of the range of e s f teams (not inclusive)
	 * @return the range of e s f teams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTeam> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTeamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f teams
	 * @param end the upper bound of the range of e s f teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f teams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFTeam> findAll(int start, int end,
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

		List<ESFTeam> list = (List<ESFTeam>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFTEAM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFTEAM;

				if (pagination) {
					sql = sql.concat(ESFTeamModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFTeam>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFTeam>(list);
				}
				else {
					list = (List<ESFTeam>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f teams from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFTeam esfTeam : findAll()) {
			remove(esfTeam);
		}
	}

	/**
	 * Returns the number of e s f teams.
	 *
	 * @return the number of e s f teams
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

				Query q = session.createQuery(_SQL_COUNT_ESFTEAM);

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
	 * Initializes the e s f team persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFTeam")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFTeam>> listenersList = new ArrayList<ModelListener<ESFTeam>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFTeam>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFTeamImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFTEAM = "SELECT esfTeam FROM ESFTeam esfTeam";
	private static final String _SQL_SELECT_ESFTEAM_WHERE = "SELECT esfTeam FROM ESFTeam esfTeam WHERE ";
	private static final String _SQL_COUNT_ESFTEAM = "SELECT COUNT(esfTeam) FROM ESFTeam esfTeam";
	private static final String _SQL_COUNT_ESFTEAM_WHERE = "SELECT COUNT(esfTeam) FROM ESFTeam esfTeam WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfTeam.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFTeam exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFTeam exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFTeamPersistenceImpl.class);
	private static ESFTeam _nullESFTeam = new ESFTeamImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFTeam> toCacheModel() {
				return _nullESFTeamCacheModel;
			}
		};

	private static CacheModel<ESFTeam> _nullESFTeamCacheModel = new CacheModel<ESFTeam>() {
			@Override
			public ESFTeam toEntityModel() {
				return _nullESFTeam;
			}
		};
}