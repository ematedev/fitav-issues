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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchUserESFFederalRoleException;
import it.ethica.esf.model.ESFUserESFFederalRole;
import it.ethica.esf.model.impl.ESFUserESFFederalRoleImpl;
import it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f user e s f federal role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserESFFederalRolePersistence
 * @see ESFUserESFFederalRoleUtil
 * @generated
 */
public class ESFUserESFFederalRolePersistenceImpl extends BasePersistenceImpl<ESFUserESFFederalRole>
	implements ESFUserESFFederalRolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFUserESFFederalRoleUtil} to access the e s f user e s f federal role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFUserESFFederalRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE =
		new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserAndFederalRoleActive",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			ESFUserESFFederalRoleModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFUserESFFederalRoleModelImpl.ESFFEDERALROLEID_COLUMN_BITMASK |
			ESFUserESFFederalRoleModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERANDFEDERALROLEACTIVE =
		new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserAndFederalRoleActive",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns the e s f user e s f federal role where esfUserId = &#63; and esfFederalRoleId = &#63; and active = &#63; or throws a {@link it.ethica.esf.NoSuchUserESFFederalRoleException} if it could not be found.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfFederalRoleId the esf federal role ID
	 * @param active the active
	 * @return the matching e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole findByUserAndFederalRoleActive(
		long esfUserId, long esfFederalRoleId, boolean active)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = fetchByUserAndFederalRoleActive(esfUserId,
				esfFederalRoleId, active);

		if (esfUserESFFederalRole == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfUserId=");
			msg.append(esfUserId);

			msg.append(", esfFederalRoleId=");
			msg.append(esfFederalRoleId);

			msg.append(", active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserESFFederalRoleException(msg.toString());
		}

		return esfUserESFFederalRole;
	}

	/**
	 * Returns the e s f user e s f federal role where esfUserId = &#63; and esfFederalRoleId = &#63; and active = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfFederalRoleId the esf federal role ID
	 * @param active the active
	 * @return the matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole fetchByUserAndFederalRoleActive(
		long esfUserId, long esfFederalRoleId, boolean active)
		throws SystemException {
		return fetchByUserAndFederalRoleActive(esfUserId, esfFederalRoleId,
			active, true);
	}

	/**
	 * Returns the e s f user e s f federal role where esfUserId = &#63; and esfFederalRoleId = &#63; and active = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfFederalRoleId the esf federal role ID
	 * @param active the active
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole fetchByUserAndFederalRoleActive(
		long esfUserId, long esfFederalRoleId, boolean active,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { esfUserId, esfFederalRoleId, active };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE,
					finderArgs, this);
		}

		if (result instanceof ESFUserESFFederalRole) {
			ESFUserESFFederalRole esfUserESFFederalRole = (ESFUserESFFederalRole)result;

			if ((esfUserId != esfUserESFFederalRole.getEsfUserId()) ||
					(esfFederalRoleId != esfUserESFFederalRole.getEsfFederalRoleId()) ||
					(active != esfUserESFFederalRole.getActive())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_ESFUSERESFFEDERALROLE_WHERE);

			query.append(_FINDER_COLUMN_USERANDFEDERALROLEACTIVE_ESFUSERID_2);

			query.append(_FINDER_COLUMN_USERANDFEDERALROLEACTIVE_ESFFEDERALROLEID_2);

			query.append(_FINDER_COLUMN_USERANDFEDERALROLEACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(esfFederalRoleId);

				qPos.add(active);

				List<ESFUserESFFederalRole> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFUserESFFederalRolePersistenceImpl.fetchByUserAndFederalRoleActive(long, long, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFUserESFFederalRole esfUserESFFederalRole = list.get(0);

					result = esfUserESFFederalRole;

					cacheResult(esfUserESFFederalRole);

					if ((esfUserESFFederalRole.getEsfUserId() != esfUserId) ||
							(esfUserESFFederalRole.getEsfFederalRoleId() != esfFederalRoleId) ||
							(esfUserESFFederalRole.getActive() != active)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE,
							finderArgs, esfUserESFFederalRole);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE,
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
			return (ESFUserESFFederalRole)result;
		}
	}

	/**
	 * Removes the e s f user e s f federal role where esfUserId = &#63; and esfFederalRoleId = &#63; and active = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfFederalRoleId the esf federal role ID
	 * @param active the active
	 * @return the e s f user e s f federal role that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole removeByUserAndFederalRoleActive(
		long esfUserId, long esfFederalRoleId, boolean active)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = findByUserAndFederalRoleActive(esfUserId,
				esfFederalRoleId, active);

		return remove(esfUserESFFederalRole);
	}

	/**
	 * Returns the number of e s f user e s f federal roles where esfUserId = &#63; and esfFederalRoleId = &#63; and active = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param esfFederalRoleId the esf federal role ID
	 * @param active the active
	 * @return the number of matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserAndFederalRoleActive(long esfUserId,
		long esfFederalRoleId, boolean active) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERANDFEDERALROLEACTIVE;

		Object[] finderArgs = new Object[] { esfUserId, esfFederalRoleId, active };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFUSERESFFEDERALROLE_WHERE);

			query.append(_FINDER_COLUMN_USERANDFEDERALROLEACTIVE_ESFUSERID_2);

			query.append(_FINDER_COLUMN_USERANDFEDERALROLEACTIVE_ESFFEDERALROLEID_2);

			query.append(_FINDER_COLUMN_USERANDFEDERALROLEACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(esfFederalRoleId);

				qPos.add(active);

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

	private static final String _FINDER_COLUMN_USERANDFEDERALROLEACTIVE_ESFUSERID_2 =
		"esfUserESFFederalRole.id.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_USERANDFEDERALROLEACTIVE_ESFFEDERALROLEID_2 =
		"esfUserESFFederalRole.id.esfFederalRoleId = ? AND ";
	private static final String _FINDER_COLUMN_USERANDFEDERALROLEACTIVE_ACTIVE_2 =
		"esfUserESFFederalRole.active = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			ESFUserESFFederalRoleModelImpl.ESFUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f user e s f federal roles where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findByUser(long esfUserId)
		throws SystemException {
		return findByUser(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user e s f federal roles where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f user e s f federal roles
	 * @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	 * @return the range of matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findByUser(long esfUserId, int start,
		int end) throws SystemException {
		return findByUser(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f federal roles where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f user e s f federal roles
	 * @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findByUser(long esfUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFUserESFFederalRole> list = (List<ESFUserESFFederalRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserESFFederalRole esfUserESFFederalRole : list) {
				if ((esfUserId != esfUserESFFederalRole.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFUSERESFFEDERALROLE_WHERE);

			query.append(_FINDER_COLUMN_USER_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserESFFederalRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFUserESFFederalRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFFederalRole>(list);
				}
				else {
					list = (List<ESFUserESFFederalRole>)QueryUtil.list(q,
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
	 * Returns the first e s f user e s f federal role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole findByUser_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = fetchByUser_First(esfUserId,
				orderByComparator);

		if (esfUserESFFederalRole != null) {
			return esfUserESFFederalRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFFederalRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user e s f federal role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole fetchByUser_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFUserESFFederalRole> list = findByUser(esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user e s f federal role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole findByUser_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = fetchByUser_Last(esfUserId,
				orderByComparator);

		if (esfUserESFFederalRole != null) {
			return esfUserESFFederalRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFFederalRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user e s f federal role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole fetchByUser_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFUserESFFederalRole> list = findByUser(esfUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user e s f federal roles before and after the current e s f user e s f federal role in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserESFFederalRolePK the primary key of the current e s f user e s f federal role
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole[] findByUser_PrevAndNext(
		ESFUserESFFederalRolePK esfUserESFFederalRolePK, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = findByPrimaryKey(esfUserESFFederalRolePK);

		Session session = null;

		try {
			session = openSession();

			ESFUserESFFederalRole[] array = new ESFUserESFFederalRoleImpl[3];

			array[0] = getByUser_PrevAndNext(session, esfUserESFFederalRole,
					esfUserId, orderByComparator, true);

			array[1] = esfUserESFFederalRole;

			array[2] = getByUser_PrevAndNext(session, esfUserESFFederalRole,
					esfUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFUserESFFederalRole getByUser_PrevAndNext(Session session,
		ESFUserESFFederalRole esfUserESFFederalRole, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERESFFEDERALROLE_WHERE);

		query.append(_FINDER_COLUMN_USER_ESFUSERID_2);

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
			query.append(ESFUserESFFederalRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserESFFederalRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserESFFederalRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user e s f federal roles where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long esfUserId) throws SystemException {
		for (ESFUserESFFederalRole esfUserESFFederalRole : findByUser(
				esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUserESFFederalRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f federal roles where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUser(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSERESFFEDERALROLE_WHERE);

			query.append(_FINDER_COLUMN_USER_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

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

	private static final String _FINDER_COLUMN_USER_ESFUSERID_2 = "esfUserESFFederalRole.id.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERACTIVE =
		new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserActive",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERACTIVE =
		new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserActive",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ESFUserESFFederalRoleModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFUserESFFederalRoleModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERACTIVE = new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserActive",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the e s f user e s f federal roles where esfUserId = &#63; and active = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param active the active
	 * @return the matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findByUserActive(long esfUserId,
		boolean active) throws SystemException {
		return findByUserActive(esfUserId, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user e s f federal roles where esfUserId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param active the active
	 * @param start the lower bound of the range of e s f user e s f federal roles
	 * @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	 * @return the range of matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findByUserActive(long esfUserId,
		boolean active, int start, int end) throws SystemException {
		return findByUserActive(esfUserId, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f federal roles where esfUserId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param active the active
	 * @param start the lower bound of the range of e s f user e s f federal roles
	 * @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findByUserActive(long esfUserId,
		boolean active, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERACTIVE;
			finderArgs = new Object[] { esfUserId, active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERACTIVE;
			finderArgs = new Object[] {
					esfUserId, active,
					
					start, end, orderByComparator
				};
		}

		List<ESFUserESFFederalRole> list = (List<ESFUserESFFederalRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserESFFederalRole esfUserESFFederalRole : list) {
				if ((esfUserId != esfUserESFFederalRole.getEsfUserId()) ||
						(active != esfUserESFFederalRole.getActive())) {
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

			query.append(_SQL_SELECT_ESFUSERESFFEDERALROLE_WHERE);

			query.append(_FINDER_COLUMN_USERACTIVE_ESFUSERID_2);

			query.append(_FINDER_COLUMN_USERACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserESFFederalRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(active);

				if (!pagination) {
					list = (List<ESFUserESFFederalRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFFederalRole>(list);
				}
				else {
					list = (List<ESFUserESFFederalRole>)QueryUtil.list(q,
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
	 * Returns the first e s f user e s f federal role in the ordered set where esfUserId = &#63; and active = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole findByUserActive_First(long esfUserId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = fetchByUserActive_First(esfUserId,
				active, orderByComparator);

		if (esfUserESFFederalRole != null) {
			return esfUserESFFederalRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFFederalRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user e s f federal role in the ordered set where esfUserId = &#63; and active = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole fetchByUserActive_First(long esfUserId,
		boolean active, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFUserESFFederalRole> list = findByUserActive(esfUserId, active,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user e s f federal role in the ordered set where esfUserId = &#63; and active = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole findByUserActive_Last(long esfUserId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = fetchByUserActive_Last(esfUserId,
				active, orderByComparator);

		if (esfUserESFFederalRole != null) {
			return esfUserESFFederalRole;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFFederalRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user e s f federal role in the ordered set where esfUserId = &#63; and active = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole fetchByUserActive_Last(long esfUserId,
		boolean active, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserActive(esfUserId, active);

		if (count == 0) {
			return null;
		}

		List<ESFUserESFFederalRole> list = findByUserActive(esfUserId, active,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user e s f federal roles before and after the current e s f user e s f federal role in the ordered set where esfUserId = &#63; and active = &#63;.
	 *
	 * @param esfUserESFFederalRolePK the primary key of the current e s f user e s f federal role
	 * @param esfUserId the esf user ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole[] findByUserActive_PrevAndNext(
		ESFUserESFFederalRolePK esfUserESFFederalRolePK, long esfUserId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = findByPrimaryKey(esfUserESFFederalRolePK);

		Session session = null;

		try {
			session = openSession();

			ESFUserESFFederalRole[] array = new ESFUserESFFederalRoleImpl[3];

			array[0] = getByUserActive_PrevAndNext(session,
					esfUserESFFederalRole, esfUserId, active,
					orderByComparator, true);

			array[1] = esfUserESFFederalRole;

			array[2] = getByUserActive_PrevAndNext(session,
					esfUserESFFederalRole, esfUserId, active,
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

	protected ESFUserESFFederalRole getByUserActive_PrevAndNext(
		Session session, ESFUserESFFederalRole esfUserESFFederalRole,
		long esfUserId, boolean active, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERESFFEDERALROLE_WHERE);

		query.append(_FINDER_COLUMN_USERACTIVE_ESFUSERID_2);

		query.append(_FINDER_COLUMN_USERACTIVE_ACTIVE_2);

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
			query.append(ESFUserESFFederalRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserESFFederalRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserESFFederalRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user e s f federal roles where esfUserId = &#63; and active = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserActive(long esfUserId, boolean active)
		throws SystemException {
		for (ESFUserESFFederalRole esfUserESFFederalRole : findByUserActive(
				esfUserId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUserESFFederalRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f federal roles where esfUserId = &#63; and active = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param active the active
	 * @return the number of matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserActive(long esfUserId, boolean active)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERACTIVE;

		Object[] finderArgs = new Object[] { esfUserId, active };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFUSERESFFEDERALROLE_WHERE);

			query.append(_FINDER_COLUMN_USERACTIVE_ESFUSERID_2);

			query.append(_FINDER_COLUMN_USERACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				qPos.add(active);

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

	private static final String _FINDER_COLUMN_USERACTIVE_ESFUSERID_2 = "esfUserESFFederalRole.id.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_USERACTIVE_ACTIVE_2 = "esfUserESFFederalRole.active = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FEDERALROLE =
		new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFederalRole",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEDERALROLE =
		new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFederalRole",
			new String[] { Long.class.getName() },
			ESFUserESFFederalRoleModelImpl.ESFFEDERALROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FEDERALROLE = new FinderPath(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFederalRole",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f user e s f federal roles where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @return the matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findByFederalRole(long esfFederalRoleId)
		throws SystemException {
		return findByFederalRole(esfFederalRoleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user e s f federal roles where esfFederalRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param start the lower bound of the range of e s f user e s f federal roles
	 * @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	 * @return the range of matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findByFederalRole(
		long esfFederalRoleId, int start, int end) throws SystemException {
		return findByFederalRole(esfFederalRoleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f federal roles where esfFederalRoleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param start the lower bound of the range of e s f user e s f federal roles
	 * @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findByFederalRole(
		long esfFederalRoleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEDERALROLE;
			finderArgs = new Object[] { esfFederalRoleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FEDERALROLE;
			finderArgs = new Object[] {
					esfFederalRoleId,
					
					start, end, orderByComparator
				};
		}

		List<ESFUserESFFederalRole> list = (List<ESFUserESFFederalRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFUserESFFederalRole esfUserESFFederalRole : list) {
				if ((esfFederalRoleId != esfUserESFFederalRole.getEsfFederalRoleId())) {
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

			query.append(_SQL_SELECT_ESFUSERESFFEDERALROLE_WHERE);

			query.append(_FINDER_COLUMN_FEDERALROLE_ESFFEDERALROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFUserESFFederalRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfFederalRoleId);

				if (!pagination) {
					list = (List<ESFUserESFFederalRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFFederalRole>(list);
				}
				else {
					list = (List<ESFUserESFFederalRole>)QueryUtil.list(q,
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
	 * Returns the first e s f user e s f federal role in the ordered set where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole findByFederalRole_First(
		long esfFederalRoleId, OrderByComparator orderByComparator)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = fetchByFederalRole_First(esfFederalRoleId,
				orderByComparator);

		if (esfUserESFFederalRole != null) {
			return esfUserESFFederalRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfFederalRoleId=");
		msg.append(esfFederalRoleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFFederalRoleException(msg.toString());
	}

	/**
	 * Returns the first e s f user e s f federal role in the ordered set where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole fetchByFederalRole_First(
		long esfFederalRoleId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFUserESFFederalRole> list = findByFederalRole(esfFederalRoleId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f user e s f federal role in the ordered set where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole findByFederalRole_Last(long esfFederalRoleId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = fetchByFederalRole_Last(esfFederalRoleId,
				orderByComparator);

		if (esfUserESFFederalRole != null) {
			return esfUserESFFederalRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfFederalRoleId=");
		msg.append(esfFederalRoleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserESFFederalRoleException(msg.toString());
	}

	/**
	 * Returns the last e s f user e s f federal role in the ordered set where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole fetchByFederalRole_Last(
		long esfFederalRoleId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFederalRole(esfFederalRoleId);

		if (count == 0) {
			return null;
		}

		List<ESFUserESFFederalRole> list = findByFederalRole(esfFederalRoleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f user e s f federal roles before and after the current e s f user e s f federal role in the ordered set where esfFederalRoleId = &#63;.
	 *
	 * @param esfUserESFFederalRolePK the primary key of the current e s f user e s f federal role
	 * @param esfFederalRoleId the esf federal role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole[] findByFederalRole_PrevAndNext(
		ESFUserESFFederalRolePK esfUserESFFederalRolePK, long esfFederalRoleId,
		OrderByComparator orderByComparator)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = findByPrimaryKey(esfUserESFFederalRolePK);

		Session session = null;

		try {
			session = openSession();

			ESFUserESFFederalRole[] array = new ESFUserESFFederalRoleImpl[3];

			array[0] = getByFederalRole_PrevAndNext(session,
					esfUserESFFederalRole, esfFederalRoleId, orderByComparator,
					true);

			array[1] = esfUserESFFederalRole;

			array[2] = getByFederalRole_PrevAndNext(session,
					esfUserESFFederalRole, esfFederalRoleId, orderByComparator,
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

	protected ESFUserESFFederalRole getByFederalRole_PrevAndNext(
		Session session, ESFUserESFFederalRole esfUserESFFederalRole,
		long esfFederalRoleId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFUSERESFFEDERALROLE_WHERE);

		query.append(_FINDER_COLUMN_FEDERALROLE_ESFFEDERALROLEID_2);

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
			query.append(ESFUserESFFederalRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfFederalRoleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfUserESFFederalRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFUserESFFederalRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f user e s f federal roles where esfFederalRoleId = &#63; from the database.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFederalRole(long esfFederalRoleId)
		throws SystemException {
		for (ESFUserESFFederalRole esfUserESFFederalRole : findByFederalRole(
				esfFederalRoleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfUserESFFederalRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f federal roles where esfFederalRoleId = &#63;.
	 *
	 * @param esfFederalRoleId the esf federal role ID
	 * @return the number of matching e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFederalRole(long esfFederalRoleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FEDERALROLE;

		Object[] finderArgs = new Object[] { esfFederalRoleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFUSERESFFEDERALROLE_WHERE);

			query.append(_FINDER_COLUMN_FEDERALROLE_ESFFEDERALROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfFederalRoleId);

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

	private static final String _FINDER_COLUMN_FEDERALROLE_ESFFEDERALROLEID_2 = "esfUserESFFederalRole.id.esfFederalRoleId = ?";

	public ESFUserESFFederalRolePersistenceImpl() {
		setModelClass(ESFUserESFFederalRole.class);
	}

	/**
	 * Caches the e s f user e s f federal role in the entity cache if it is enabled.
	 *
	 * @param esfUserESFFederalRole the e s f user e s f federal role
	 */
	@Override
	public void cacheResult(ESFUserESFFederalRole esfUserESFFederalRole) {
		EntityCacheUtil.putResult(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class,
			esfUserESFFederalRole.getPrimaryKey(), esfUserESFFederalRole);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE,
			new Object[] {
				esfUserESFFederalRole.getEsfUserId(),
				esfUserESFFederalRole.getEsfFederalRoleId(),
				esfUserESFFederalRole.getActive()
			}, esfUserESFFederalRole);

		esfUserESFFederalRole.resetOriginalValues();
	}

	/**
	 * Caches the e s f user e s f federal roles in the entity cache if it is enabled.
	 *
	 * @param esfUserESFFederalRoles the e s f user e s f federal roles
	 */
	@Override
	public void cacheResult(List<ESFUserESFFederalRole> esfUserESFFederalRoles) {
		for (ESFUserESFFederalRole esfUserESFFederalRole : esfUserESFFederalRoles) {
			if (EntityCacheUtil.getResult(
						ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserESFFederalRoleImpl.class,
						esfUserESFFederalRole.getPrimaryKey()) == null) {
				cacheResult(esfUserESFFederalRole);
			}
			else {
				esfUserESFFederalRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f user e s f federal roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFUserESFFederalRoleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFUserESFFederalRoleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f user e s f federal role.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFUserESFFederalRole esfUserESFFederalRole) {
		EntityCacheUtil.removeResult(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class,
			esfUserESFFederalRole.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfUserESFFederalRole);
	}

	@Override
	public void clearCache(List<ESFUserESFFederalRole> esfUserESFFederalRoles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFUserESFFederalRole esfUserESFFederalRole : esfUserESFFederalRoles) {
			EntityCacheUtil.removeResult(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserESFFederalRoleImpl.class,
				esfUserESFFederalRole.getPrimaryKey());

			clearUniqueFindersCache(esfUserESFFederalRole);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFUserESFFederalRole esfUserESFFederalRole) {
		if (esfUserESFFederalRole.isNew()) {
			Object[] args = new Object[] {
					esfUserESFFederalRole.getEsfUserId(),
					esfUserESFFederalRole.getEsfFederalRoleId(),
					esfUserESFFederalRole.getActive()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERANDFEDERALROLEACTIVE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE,
				args, esfUserESFFederalRole);
		}
		else {
			ESFUserESFFederalRoleModelImpl esfUserESFFederalRoleModelImpl = (ESFUserESFFederalRoleModelImpl)esfUserESFFederalRole;

			if ((esfUserESFFederalRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFFederalRole.getEsfUserId(),
						esfUserESFFederalRole.getEsfFederalRoleId(),
						esfUserESFFederalRole.getActive()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERANDFEDERALROLEACTIVE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE,
					args, esfUserESFFederalRole);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFUserESFFederalRole esfUserESFFederalRole) {
		ESFUserESFFederalRoleModelImpl esfUserESFFederalRoleModelImpl = (ESFUserESFFederalRoleModelImpl)esfUserESFFederalRole;

		Object[] args = new Object[] {
				esfUserESFFederalRole.getEsfUserId(),
				esfUserESFFederalRole.getEsfFederalRoleId(),
				esfUserESFFederalRole.getActive()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERANDFEDERALROLEACTIVE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE,
			args);

		if ((esfUserESFFederalRoleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfUserESFFederalRoleModelImpl.getOriginalEsfUserId(),
					esfUserESFFederalRoleModelImpl.getOriginalEsfFederalRoleId(),
					esfUserESFFederalRoleModelImpl.getOriginalActive()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERANDFEDERALROLEACTIVE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERANDFEDERALROLEACTIVE,
				args);
		}
	}

	/**
	 * Creates a new e s f user e s f federal role with the primary key. Does not add the e s f user e s f federal role to the database.
	 *
	 * @param esfUserESFFederalRolePK the primary key for the new e s f user e s f federal role
	 * @return the new e s f user e s f federal role
	 */
	@Override
	public ESFUserESFFederalRole create(
		ESFUserESFFederalRolePK esfUserESFFederalRolePK) {
		ESFUserESFFederalRole esfUserESFFederalRole = new ESFUserESFFederalRoleImpl();

		esfUserESFFederalRole.setNew(true);
		esfUserESFFederalRole.setPrimaryKey(esfUserESFFederalRolePK);

		return esfUserESFFederalRole;
	}

	/**
	 * Removes the e s f user e s f federal role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserESFFederalRolePK the primary key of the e s f user e s f federal role
	 * @return the e s f user e s f federal role that was removed
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole remove(
		ESFUserESFFederalRolePK esfUserESFFederalRolePK)
		throws NoSuchUserESFFederalRoleException, SystemException {
		return remove((Serializable)esfUserESFFederalRolePK);
	}

	/**
	 * Removes the e s f user e s f federal role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f user e s f federal role
	 * @return the e s f user e s f federal role that was removed
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole remove(Serializable primaryKey)
		throws NoSuchUserESFFederalRoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFUserESFFederalRole esfUserESFFederalRole = (ESFUserESFFederalRole)session.get(ESFUserESFFederalRoleImpl.class,
					primaryKey);

			if (esfUserESFFederalRole == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserESFFederalRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfUserESFFederalRole);
		}
		catch (NoSuchUserESFFederalRoleException nsee) {
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
	protected ESFUserESFFederalRole removeImpl(
		ESFUserESFFederalRole esfUserESFFederalRole) throws SystemException {
		esfUserESFFederalRole = toUnwrappedModel(esfUserESFFederalRole);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfUserESFFederalRole)) {
				esfUserESFFederalRole = (ESFUserESFFederalRole)session.get(ESFUserESFFederalRoleImpl.class,
						esfUserESFFederalRole.getPrimaryKeyObj());
			}

			if (esfUserESFFederalRole != null) {
				session.delete(esfUserESFFederalRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfUserESFFederalRole != null) {
			clearCache(esfUserESFFederalRole);
		}

		return esfUserESFFederalRole;
	}

	@Override
	public ESFUserESFFederalRole updateImpl(
		it.ethica.esf.model.ESFUserESFFederalRole esfUserESFFederalRole)
		throws SystemException {
		esfUserESFFederalRole = toUnwrappedModel(esfUserESFFederalRole);

		boolean isNew = esfUserESFFederalRole.isNew();

		ESFUserESFFederalRoleModelImpl esfUserESFFederalRoleModelImpl = (ESFUserESFFederalRoleModelImpl)esfUserESFFederalRole;

		Session session = null;

		try {
			session = openSession();

			if (esfUserESFFederalRole.isNew()) {
				session.save(esfUserESFFederalRole);

				esfUserESFFederalRole.setNew(false);
			}
			else {
				session.merge(esfUserESFFederalRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFUserESFFederalRoleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfUserESFFederalRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFFederalRoleModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] {
						esfUserESFFederalRoleModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((esfUserESFFederalRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFFederalRoleModelImpl.getOriginalEsfUserId(),
						esfUserESFFederalRoleModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERACTIVE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERACTIVE,
					args);

				args = new Object[] {
						esfUserESFFederalRoleModelImpl.getEsfUserId(),
						esfUserESFFederalRoleModelImpl.getActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERACTIVE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERACTIVE,
					args);
			}

			if ((esfUserESFFederalRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEDERALROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfUserESFFederalRoleModelImpl.getOriginalEsfFederalRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEDERALROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEDERALROLE,
					args);

				args = new Object[] {
						esfUserESFFederalRoleModelImpl.getEsfFederalRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEDERALROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEDERALROLE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
			ESFUserESFFederalRoleImpl.class,
			esfUserESFFederalRole.getPrimaryKey(), esfUserESFFederalRole);

		clearUniqueFindersCache(esfUserESFFederalRole);
		cacheUniqueFindersCache(esfUserESFFederalRole);

		return esfUserESFFederalRole;
	}

	protected ESFUserESFFederalRole toUnwrappedModel(
		ESFUserESFFederalRole esfUserESFFederalRole) {
		if (esfUserESFFederalRole instanceof ESFUserESFFederalRoleImpl) {
			return esfUserESFFederalRole;
		}

		ESFUserESFFederalRoleImpl esfUserESFFederalRoleImpl = new ESFUserESFFederalRoleImpl();

		esfUserESFFederalRoleImpl.setNew(esfUserESFFederalRole.isNew());
		esfUserESFFederalRoleImpl.setPrimaryKey(esfUserESFFederalRole.getPrimaryKey());

		esfUserESFFederalRoleImpl.setEsfUserId(esfUserESFFederalRole.getEsfUserId());
		esfUserESFFederalRoleImpl.setEsfFederalRoleId(esfUserESFFederalRole.getEsfFederalRoleId());
		esfUserESFFederalRoleImpl.setStartDate(esfUserESFFederalRole.getStartDate());
		esfUserESFFederalRoleImpl.setEndDate(esfUserESFFederalRole.getEndDate());
		esfUserESFFederalRoleImpl.setModifiedDate(esfUserESFFederalRole.getModifiedDate());
		esfUserESFFederalRoleImpl.setActive(esfUserESFFederalRole.isActive());
		esfUserESFFederalRoleImpl.setEsfSpecificId(esfUserESFFederalRole.getEsfSpecificId());
		esfUserESFFederalRoleImpl.setRegionId(esfUserESFFederalRole.getRegionId());
		esfUserESFFederalRoleImpl.setProvinceId(esfUserESFFederalRole.getProvinceId());
		esfUserESFFederalRoleImpl.setNotes(esfUserESFFederalRole.getNotes());

		return esfUserESFFederalRoleImpl;
	}

	/**
	 * Returns the e s f user e s f federal role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user e s f federal role
	 * @return the e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserESFFederalRoleException, SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = fetchByPrimaryKey(primaryKey);

		if (esfUserESFFederalRole == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserESFFederalRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfUserESFFederalRole;
	}

	/**
	 * Returns the e s f user e s f federal role with the primary key or throws a {@link it.ethica.esf.NoSuchUserESFFederalRoleException} if it could not be found.
	 *
	 * @param esfUserESFFederalRolePK the primary key of the e s f user e s f federal role
	 * @return the e s f user e s f federal role
	 * @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole findByPrimaryKey(
		ESFUserESFFederalRolePK esfUserESFFederalRolePK)
		throws NoSuchUserESFFederalRoleException, SystemException {
		return findByPrimaryKey((Serializable)esfUserESFFederalRolePK);
	}

	/**
	 * Returns the e s f user e s f federal role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f user e s f federal role
	 * @return the e s f user e s f federal role, or <code>null</code> if a e s f user e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFUserESFFederalRole esfUserESFFederalRole = (ESFUserESFFederalRole)EntityCacheUtil.getResult(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
				ESFUserESFFederalRoleImpl.class, primaryKey);

		if (esfUserESFFederalRole == _nullESFUserESFFederalRole) {
			return null;
		}

		if (esfUserESFFederalRole == null) {
			Session session = null;

			try {
				session = openSession();

				esfUserESFFederalRole = (ESFUserESFFederalRole)session.get(ESFUserESFFederalRoleImpl.class,
						primaryKey);

				if (esfUserESFFederalRole != null) {
					cacheResult(esfUserESFFederalRole);
				}
				else {
					EntityCacheUtil.putResult(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
						ESFUserESFFederalRoleImpl.class, primaryKey,
						_nullESFUserESFFederalRole);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFUserESFFederalRoleModelImpl.ENTITY_CACHE_ENABLED,
					ESFUserESFFederalRoleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfUserESFFederalRole;
	}

	/**
	 * Returns the e s f user e s f federal role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfUserESFFederalRolePK the primary key of the e s f user e s f federal role
	 * @return the e s f user e s f federal role, or <code>null</code> if a e s f user e s f federal role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFFederalRole fetchByPrimaryKey(
		ESFUserESFFederalRolePK esfUserESFFederalRolePK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfUserESFFederalRolePK);
	}

	/**
	 * Returns all the e s f user e s f federal roles.
	 *
	 * @return the e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f user e s f federal roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f user e s f federal roles
	 * @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	 * @return the range of e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f user e s f federal roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f user e s f federal roles
	 * @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f user e s f federal roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFFederalRole> findAll(int start, int end,
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

		List<ESFUserESFFederalRole> list = (List<ESFUserESFFederalRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFUSERESFFEDERALROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFUSERESFFEDERALROLE;

				if (pagination) {
					sql = sql.concat(ESFUserESFFederalRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFUserESFFederalRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFUserESFFederalRole>(list);
				}
				else {
					list = (List<ESFUserESFFederalRole>)QueryUtil.list(q,
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
	 * Removes all the e s f user e s f federal roles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFUserESFFederalRole esfUserESFFederalRole : findAll()) {
			remove(esfUserESFFederalRole);
		}
	}

	/**
	 * Returns the number of e s f user e s f federal roles.
	 *
	 * @return the number of e s f user e s f federal roles
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

				Query q = session.createQuery(_SQL_COUNT_ESFUSERESFFEDERALROLE);

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
	 * Initializes the e s f user e s f federal role persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFUserESFFederalRole")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFUserESFFederalRole>> listenersList = new ArrayList<ModelListener<ESFUserESFFederalRole>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFUserESFFederalRole>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFUserESFFederalRoleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFUSERESFFEDERALROLE = "SELECT esfUserESFFederalRole FROM ESFUserESFFederalRole esfUserESFFederalRole";
	private static final String _SQL_SELECT_ESFUSERESFFEDERALROLE_WHERE = "SELECT esfUserESFFederalRole FROM ESFUserESFFederalRole esfUserESFFederalRole WHERE ";
	private static final String _SQL_COUNT_ESFUSERESFFEDERALROLE = "SELECT COUNT(esfUserESFFederalRole) FROM ESFUserESFFederalRole esfUserESFFederalRole";
	private static final String _SQL_COUNT_ESFUSERESFFEDERALROLE_WHERE = "SELECT COUNT(esfUserESFFederalRole) FROM ESFUserESFFederalRole esfUserESFFederalRole WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfUserESFFederalRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFUserESFFederalRole exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFUserESFFederalRole exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFUserESFFederalRolePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static ESFUserESFFederalRole _nullESFUserESFFederalRole = new ESFUserESFFederalRoleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFUserESFFederalRole> toCacheModel() {
				return _nullESFUserESFFederalRoleCacheModel;
			}
		};

	private static CacheModel<ESFUserESFFederalRole> _nullESFUserESFFederalRoleCacheModel =
		new CacheModel<ESFUserESFFederalRole>() {
			@Override
			public ESFUserESFFederalRole toEntityModel() {
				return _nullESFUserESFFederalRole;
			}
		};
}