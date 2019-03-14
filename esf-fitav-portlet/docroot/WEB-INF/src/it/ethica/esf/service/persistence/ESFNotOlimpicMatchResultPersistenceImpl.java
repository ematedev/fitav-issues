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

import it.ethica.esf.NoSuchNotOlimpicMatchResultException;
import it.ethica.esf.model.ESFNotOlimpicMatchResult;
import it.ethica.esf.model.impl.ESFNotOlimpicMatchResultImpl;
import it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f not olimpic match result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFNotOlimpicMatchResultPersistence
 * @see ESFNotOlimpicMatchResultUtil
 * @generated
 */
public class ESFNotOlimpicMatchResultPersistenceImpl extends BasePersistenceImpl<ESFNotOlimpicMatchResult>
	implements ESFNotOlimpicMatchResultPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFNotOlimpicMatchResultUtil} to access the e s f not olimpic match result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFNotOlimpicMatchResultImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFMatchId_ESFUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMatchId_ESFUserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFNotOlimpicMatchResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID_ESFUSERID = new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMatchId_ESFUserId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f not olimpic match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @return the matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId) throws SystemException {
		return findByESFMatchId_ESFUserId(esfMatchId, esfUserId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f not olimpic match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @return the range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId, int start, int end)
		throws SystemException {
		return findByESFMatchId_ESFUserId(esfMatchId, esfUserId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the e s f not olimpic match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID;
			finderArgs = new Object[] { esfMatchId, esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID;
			finderArgs = new Object[] {
					esfMatchId, esfUserId,
					
					start, end, orderByComparator
				};
		}

		List<ESFNotOlimpicMatchResult> list = (List<ESFNotOlimpicMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : list) {
				if ((esfMatchId != esfNotOlimpicMatchResult.getEsfMatchId()) ||
						(esfUserId != esfNotOlimpicMatchResult.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFUSERID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNotOlimpicMatchResult>(list);
				}
				else {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFMatchId_ESFUserId_First(
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFMatchId_ESFUserId_First(esfMatchId,
				esfUserId, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId_ESFUserId_First(
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFNotOlimpicMatchResult> list = findByESFMatchId_ESFUserId(esfMatchId,
				esfUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFMatchId_ESFUserId_Last(
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFMatchId_ESFUserId_Last(esfMatchId,
				esfUserId, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId_ESFUserId_Last(
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFMatchId_ESFUserId(esfMatchId, esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFNotOlimpicMatchResult> list = findByESFMatchId_ESFUserId(esfMatchId,
				esfUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f not olimpic match results before and after the current e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param ESFNotOlimpicMatchResultId the primary key of the current e s f not olimpic match result
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult[] findByESFMatchId_ESFUserId_PrevAndNext(
		long ESFNotOlimpicMatchResultId, long esfMatchId, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = findByPrimaryKey(ESFNotOlimpicMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFNotOlimpicMatchResult[] array = new ESFNotOlimpicMatchResultImpl[3];

			array[0] = getByESFMatchId_ESFUserId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, esfUserId,
					orderByComparator, true);

			array[1] = esfNotOlimpicMatchResult;

			array[2] = getByESFMatchId_ESFUserId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, esfUserId,
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

	protected ESFNotOlimpicMatchResult getByESFMatchId_ESFUserId_PrevAndNext(
		Session session, ESFNotOlimpicMatchResult esfNotOlimpicMatchResult,
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCHID_ESFUSERID_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMATCHID_ESFUSERID_ESFUSERID_2);

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
			query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNotOlimpicMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNotOlimpicMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f not olimpic match results where esfMatchId = &#63; and esfUserId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatchId_ESFUserId(long esfMatchId, long esfUserId)
		throws SystemException {
		for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : findByESFMatchId_ESFUserId(
				esfMatchId, esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(esfNotOlimpicMatchResult);
		}
	}

	/**
	 * Returns the number of e s f not olimpic match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMatchId_ESFUserId(long esfMatchId, long esfUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCHID_ESFUSERID;

		Object[] finderArgs = new Object[] { esfMatchId, esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFUSERID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFUSERID_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

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

	private static final String _FINDER_COLUMN_ESFMATCHID_ESFUSERID_ESFMATCHID_2 =
		"esfNotOlimpicMatchResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_ESFUSERID_ESFUSERID_2 = "esfNotOlimpicMatchResult.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFUserId",
			new String[] { Long.class.getName() },
			ESFNotOlimpicMatchResultModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSERID = new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f not olimpic match results where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFUserId(long esfUserId)
		throws SystemException {
		return findByESFUserId(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f not olimpic match results where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @return the range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFUserId(long esfUserId,
		int start, int end) throws SystemException {
		return findByESFUserId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f not olimpic match results where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFUserId(long esfUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFNotOlimpicMatchResult> list = (List<ESFNotOlimpicMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : list) {
				if ((esfUserId != esfNotOlimpicMatchResult.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNotOlimpicMatchResult>(list);
				}
				else {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f not olimpic match result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFUserId_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFUserId_First(esfUserId,
				orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f not olimpic match result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFUserId_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNotOlimpicMatchResult> list = findByESFUserId(esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFUserId_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFUserId_Last(esfUserId,
				orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFUserId_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFUserId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFNotOlimpicMatchResult> list = findByESFUserId(esfUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f not olimpic match results before and after the current e s f not olimpic match result in the ordered set where esfUserId = &#63;.
	 *
	 * @param ESFNotOlimpicMatchResultId the primary key of the current e s f not olimpic match result
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult[] findByESFUserId_PrevAndNext(
		long ESFNotOlimpicMatchResultId, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = findByPrimaryKey(ESFNotOlimpicMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFNotOlimpicMatchResult[] array = new ESFNotOlimpicMatchResultImpl[3];

			array[0] = getByESFUserId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfUserId, orderByComparator, true);

			array[1] = esfNotOlimpicMatchResult;

			array[2] = getByESFUserId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfUserId, orderByComparator,
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

	protected ESFNotOlimpicMatchResult getByESFUserId_PrevAndNext(
		Session session, ESFNotOlimpicMatchResult esfNotOlimpicMatchResult,
		long esfUserId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

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
			query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNotOlimpicMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNotOlimpicMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f not olimpic match results where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFUserId(long esfUserId) throws SystemException {
		for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : findByESFUserId(
				esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfNotOlimpicMatchResult);
		}
	}

	/**
	 * Returns the number of e s f not olimpic match results where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFUserId(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFUSERID;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

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

	private static final String _FINDER_COLUMN_ESFUSERID_ESFUSERID_2 = "esfNotOlimpicMatchResult.esfUserId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ESFMATCHID = new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByESFMatchId", new String[] { Long.class.getName() },
			ESFNotOlimpicMatchResultModelImpl.ESFMATCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID = new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFMatchId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the e s f not olimpic match result where esfMatchId = &#63; or throws a {@link it.ethica.esf.NoSuchNotOlimpicMatchResultException} if it could not be found.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFMatchId(long esfMatchId)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFMatchId(esfMatchId);

		if (esfNotOlimpicMatchResult == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfMatchId=");
			msg.append(esfMatchId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNotOlimpicMatchResultException(msg.toString());
		}

		return esfNotOlimpicMatchResult;
	}

	/**
	 * Returns the e s f not olimpic match result where esfMatchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId(long esfMatchId)
		throws SystemException {
		return fetchByESFMatchId(esfMatchId, true);
	}

	/**
	 * Returns the e s f not olimpic match result where esfMatchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfMatchId the esf match ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId(long esfMatchId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { esfMatchId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ESFMATCHID,
					finderArgs, this);
		}

		if (result instanceof ESFNotOlimpicMatchResult) {
			ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = (ESFNotOlimpicMatchResult)result;

			if ((esfMatchId != esfNotOlimpicMatchResult.getEsfMatchId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFMATCHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				List<ESFNotOlimpicMatchResult> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFMATCHID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFNotOlimpicMatchResultPersistenceImpl.fetchByESFMatchId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = list.get(0);

					result = esfNotOlimpicMatchResult;

					cacheResult(esfNotOlimpicMatchResult);

					if ((esfNotOlimpicMatchResult.getEsfMatchId() != esfMatchId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFMATCHID,
							finderArgs, esfNotOlimpicMatchResult);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFMATCHID,
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
			return (ESFNotOlimpicMatchResult)result;
		}
	}

	/**
	 * Removes the e s f not olimpic match result where esfMatchId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the e s f not olimpic match result that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult removeByESFMatchId(long esfMatchId)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = findByESFMatchId(esfMatchId);

		return remove(esfNotOlimpicMatchResult);
	}

	/**
	 * Returns the number of e s f not olimpic match results where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the number of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMatchId(long esfMatchId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCHID;

		Object[] finderArgs = new Object[] { esfMatchId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFMATCHID_2);

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

	private static final String _FINDER_COLUMN_ESFMATCHID_ESFMATCHID_2 = "esfNotOlimpicMatchResult.esfMatchId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFMatchId_ExternalShooter",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMatchId_ExternalShooter",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ESFNotOlimpicMatchResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.EXTERNALSHOOTER_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID_EXTERNALSHOOTER =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMatchId_ExternalShooter",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the e s f not olimpic match results where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @return the matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ExternalShooter(
		long esfMatchId, boolean externalShooter) throws SystemException {
		return findByESFMatchId_ExternalShooter(esfMatchId, externalShooter,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f not olimpic match results where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @return the range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ExternalShooter(
		long esfMatchId, boolean externalShooter, int start, int end)
		throws SystemException {
		return findByESFMatchId_ExternalShooter(esfMatchId, externalShooter,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f not olimpic match results where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ExternalShooter(
		long esfMatchId, boolean externalShooter, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER;
			finderArgs = new Object[] { esfMatchId, externalShooter };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER;
			finderArgs = new Object[] {
					esfMatchId, externalShooter,
					
					start, end, orderByComparator
				};
		}

		List<ESFNotOlimpicMatchResult> list = (List<ESFNotOlimpicMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : list) {
				if ((esfMatchId != esfNotOlimpicMatchResult.getEsfMatchId()) ||
						(externalShooter != esfNotOlimpicMatchResult.getExternalShooter())) {
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

			query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_EXTERNALSHOOTER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(externalShooter);

				if (!pagination) {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNotOlimpicMatchResult>(list);
				}
				else {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFMatchId_ExternalShooter_First(
		long esfMatchId, boolean externalShooter,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFMatchId_ExternalShooter_First(esfMatchId,
				externalShooter, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", externalShooter=");
		msg.append(externalShooter);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId_ExternalShooter_First(
		long esfMatchId, boolean externalShooter,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNotOlimpicMatchResult> list = findByESFMatchId_ExternalShooter(esfMatchId,
				externalShooter, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFMatchId_ExternalShooter_Last(
		long esfMatchId, boolean externalShooter,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFMatchId_ExternalShooter_Last(esfMatchId,
				externalShooter, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", externalShooter=");
		msg.append(externalShooter);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId_ExternalShooter_Last(
		long esfMatchId, boolean externalShooter,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMatchId_ExternalShooter(esfMatchId,
				externalShooter);

		if (count == 0) {
			return null;
		}

		List<ESFNotOlimpicMatchResult> list = findByESFMatchId_ExternalShooter(esfMatchId,
				externalShooter, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f not olimpic match results before and after the current e s f not olimpic match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param ESFNotOlimpicMatchResultId the primary key of the current e s f not olimpic match result
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult[] findByESFMatchId_ExternalShooter_PrevAndNext(
		long ESFNotOlimpicMatchResultId, long esfMatchId,
		boolean externalShooter, OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = findByPrimaryKey(ESFNotOlimpicMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFNotOlimpicMatchResult[] array = new ESFNotOlimpicMatchResultImpl[3];

			array[0] = getByESFMatchId_ExternalShooter_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, externalShooter,
					orderByComparator, true);

			array[1] = esfNotOlimpicMatchResult;

			array[2] = getByESFMatchId_ExternalShooter_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, externalShooter,
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

	protected ESFNotOlimpicMatchResult getByESFMatchId_ExternalShooter_PrevAndNext(
		Session session, ESFNotOlimpicMatchResult esfNotOlimpicMatchResult,
		long esfMatchId, boolean externalShooter,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_EXTERNALSHOOTER_2);

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
			query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(externalShooter);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNotOlimpicMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNotOlimpicMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f not olimpic match results where esfMatchId = &#63; and externalShooter = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatchId_ExternalShooter(long esfMatchId,
		boolean externalShooter) throws SystemException {
		for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : findByESFMatchId_ExternalShooter(
				esfMatchId, externalShooter, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfNotOlimpicMatchResult);
		}
	}

	/**
	 * Returns the number of e s f not olimpic match results where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @return the number of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMatchId_ExternalShooter(long esfMatchId,
		boolean externalShooter) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCHID_EXTERNALSHOOTER;

		Object[] finderArgs = new Object[] { esfMatchId, externalShooter };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_EXTERNALSHOOTER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(externalShooter);

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

	private static final String _FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFMATCHID_2 =
		"esfNotOlimpicMatchResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_EXTERNALSHOOTER_2 =
		"esfNotOlimpicMatchResult.externalShooter = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_ESFSPORTTYPEID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFMatchId_ESFSportTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFSPORTTYPEID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMatchId_ESFSportTypeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFNotOlimpicMatchResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.ESFSPORTTYPEID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID_ESFSPORTTYPEID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMatchId_ESFSportTypeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f not olimpic match results where esfMatchId = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfSportTypeId the esf sport type ID
	 * @return the matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ESFSportTypeId(
		long esfMatchId, long esfSportTypeId) throws SystemException {
		return findByESFMatchId_ESFSportTypeId(esfMatchId, esfSportTypeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f not olimpic match results where esfMatchId = &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @return the range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ESFSportTypeId(
		long esfMatchId, long esfSportTypeId, int start, int end)
		throws SystemException {
		return findByESFMatchId_ESFSportTypeId(esfMatchId, esfSportTypeId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f not olimpic match results where esfMatchId = &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ESFSportTypeId(
		long esfMatchId, long esfSportTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFSPORTTYPEID;
			finderArgs = new Object[] { esfMatchId, esfSportTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_ESFSPORTTYPEID;
			finderArgs = new Object[] {
					esfMatchId, esfSportTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFNotOlimpicMatchResult> list = (List<ESFNotOlimpicMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : list) {
				if ((esfMatchId != esfNotOlimpicMatchResult.getEsfMatchId()) ||
						(esfSportTypeId != esfNotOlimpicMatchResult.getEsfSportTypeId())) {
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

			query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFSPORTTYPEID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfSportTypeId);

				if (!pagination) {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNotOlimpicMatchResult>(list);
				}
				else {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFMatchId_ESFSportTypeId_First(
		long esfMatchId, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFMatchId_ESFSportTypeId_First(esfMatchId,
				esfSportTypeId, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId_ESFSportTypeId_First(
		long esfMatchId, long esfSportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNotOlimpicMatchResult> list = findByESFMatchId_ESFSportTypeId(esfMatchId,
				esfSportTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFMatchId_ESFSportTypeId_Last(
		long esfMatchId, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFMatchId_ESFSportTypeId_Last(esfMatchId,
				esfSportTypeId, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId_ESFSportTypeId_Last(
		long esfMatchId, long esfSportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMatchId_ESFSportTypeId(esfMatchId, esfSportTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFNotOlimpicMatchResult> list = findByESFMatchId_ESFSportTypeId(esfMatchId,
				esfSportTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f not olimpic match results before and after the current e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param ESFNotOlimpicMatchResultId the primary key of the current e s f not olimpic match result
	 * @param esfMatchId the esf match ID
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult[] findByESFMatchId_ESFSportTypeId_PrevAndNext(
		long ESFNotOlimpicMatchResultId, long esfMatchId, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = findByPrimaryKey(ESFNotOlimpicMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFNotOlimpicMatchResult[] array = new ESFNotOlimpicMatchResultImpl[3];

			array[0] = getByESFMatchId_ESFSportTypeId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, esfSportTypeId,
					orderByComparator, true);

			array[1] = esfNotOlimpicMatchResult;

			array[2] = getByESFMatchId_ESFSportTypeId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, esfSportTypeId,
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

	protected ESFNotOlimpicMatchResult getByESFMatchId_ESFSportTypeId_PrevAndNext(
		Session session, ESFNotOlimpicMatchResult esfNotOlimpicMatchResult,
		long esfMatchId, long esfSportTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCHID_ESFSPORTTYPEID_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMATCHID_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

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
			query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfSportTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNotOlimpicMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNotOlimpicMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f not olimpic match results where esfMatchId = &#63; and esfSportTypeId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfSportTypeId the esf sport type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatchId_ESFSportTypeId(long esfMatchId,
		long esfSportTypeId) throws SystemException {
		for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : findByESFMatchId_ESFSportTypeId(
				esfMatchId, esfSportTypeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfNotOlimpicMatchResult);
		}
	}

	/**
	 * Returns the number of e s f not olimpic match results where esfMatchId = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfSportTypeId the esf sport type ID
	 * @return the number of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMatchId_ESFSportTypeId(long esfMatchId,
		long esfSportTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCHID_ESFSPORTTYPEID;

		Object[] finderArgs = new Object[] { esfMatchId, esfSportTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFSPORTTYPEID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

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

	private static final String _FINDER_COLUMN_ESFMATCHID_ESFSPORTTYPEID_ESFMATCHID_2 =
		"esfNotOlimpicMatchResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_ESFSPORTTYPEID_ESFSPORTTYPEID_2 =
		"esfNotOlimpicMatchResult.esfSportTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MATCHID_USERID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymatchId_userId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHID_USERID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymatchId_userId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFNotOlimpicMatchResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MATCHID_USERID = new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymatchId_userId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f not olimpic match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @return the matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findBymatchId_userId(
		long esfMatchId, long esfUserId) throws SystemException {
		return findBymatchId_userId(esfMatchId, esfUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f not olimpic match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @return the range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findBymatchId_userId(
		long esfMatchId, long esfUserId, int start, int end)
		throws SystemException {
		return findBymatchId_userId(esfMatchId, esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f not olimpic match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findBymatchId_userId(
		long esfMatchId, long esfUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHID_USERID;
			finderArgs = new Object[] { esfMatchId, esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MATCHID_USERID;
			finderArgs = new Object[] {
					esfMatchId, esfUserId,
					
					start, end, orderByComparator
				};
		}

		List<ESFNotOlimpicMatchResult> list = (List<ESFNotOlimpicMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : list) {
				if ((esfMatchId != esfNotOlimpicMatchResult.getEsfMatchId()) ||
						(esfUserId != esfNotOlimpicMatchResult.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_MATCHID_USERID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_MATCHID_USERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNotOlimpicMatchResult>(list);
				}
				else {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findBymatchId_userId_First(
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchBymatchId_userId_First(esfMatchId,
				esfUserId, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchBymatchId_userId_First(
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFNotOlimpicMatchResult> list = findBymatchId_userId(esfMatchId,
				esfUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findBymatchId_userId_Last(long esfMatchId,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchBymatchId_userId_Last(esfMatchId,
				esfUserId, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchBymatchId_userId_Last(
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBymatchId_userId(esfMatchId, esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFNotOlimpicMatchResult> list = findBymatchId_userId(esfMatchId,
				esfUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f not olimpic match results before and after the current e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param ESFNotOlimpicMatchResultId the primary key of the current e s f not olimpic match result
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult[] findBymatchId_userId_PrevAndNext(
		long ESFNotOlimpicMatchResultId, long esfMatchId, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = findByPrimaryKey(ESFNotOlimpicMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFNotOlimpicMatchResult[] array = new ESFNotOlimpicMatchResultImpl[3];

			array[0] = getBymatchId_userId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, esfUserId,
					orderByComparator, true);

			array[1] = esfNotOlimpicMatchResult;

			array[2] = getBymatchId_userId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, esfUserId,
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

	protected ESFNotOlimpicMatchResult getBymatchId_userId_PrevAndNext(
		Session session, ESFNotOlimpicMatchResult esfNotOlimpicMatchResult,
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

		query.append(_FINDER_COLUMN_MATCHID_USERID_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_MATCHID_USERID_ESFUSERID_2);

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
			query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNotOlimpicMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNotOlimpicMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f not olimpic match results where esfMatchId = &#63; and esfUserId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBymatchId_userId(long esfMatchId, long esfUserId)
		throws SystemException {
		for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : findBymatchId_userId(
				esfMatchId, esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(esfNotOlimpicMatchResult);
		}
	}

	/**
	 * Returns the number of e s f not olimpic match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBymatchId_userId(long esfMatchId, long esfUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MATCHID_USERID;

		Object[] finderArgs = new Object[] { esfMatchId, esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_MATCHID_USERID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_MATCHID_USERID_ESFUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

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

	private static final String _FINDER_COLUMN_MATCHID_USERID_ESFMATCHID_2 = "esfNotOlimpicMatchResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_MATCHID_USERID_ESFUSERID_2 = "esfNotOlimpicMatchResult.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFMatchId_ExternalShooter_ESFSportTypeId",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMatchId_ExternalShooter_ESFSportTypeId",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			},
			ESFNotOlimpicMatchResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.EXTERNALSHOOTER_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.ESFSPORTTYPEID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMatchId_ExternalShooter_ESFSportTypeId",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the e s f not olimpic match results where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param esfSportTypeId the esf sport type ID
	 * @return the matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ExternalShooter_ESFSportTypeId(
		long esfMatchId, boolean externalShooter, long esfSportTypeId)
		throws SystemException {
		return findByESFMatchId_ExternalShooter_ESFSportTypeId(esfMatchId,
			externalShooter, esfSportTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f not olimpic match results where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @return the range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ExternalShooter_ESFSportTypeId(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		int start, int end) throws SystemException {
		return findByESFMatchId_ExternalShooter_ESFSportTypeId(esfMatchId,
			externalShooter, esfSportTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f not olimpic match results where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_ExternalShooter_ESFSportTypeId(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID;
			finderArgs = new Object[] {
					esfMatchId, externalShooter, esfSportTypeId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID;
			finderArgs = new Object[] {
					esfMatchId, externalShooter, esfSportTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFNotOlimpicMatchResult> list = (List<ESFNotOlimpicMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : list) {
				if ((esfMatchId != esfNotOlimpicMatchResult.getEsfMatchId()) ||
						(externalShooter != esfNotOlimpicMatchResult.getExternalShooter()) ||
						(esfSportTypeId != esfNotOlimpicMatchResult.getEsfSportTypeId())) {
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

			query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_EXTERNALSHOOTER_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(externalShooter);

				qPos.add(esfSportTypeId);

				if (!pagination) {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNotOlimpicMatchResult>(list);
				}
				else {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFMatchId_ExternalShooter_ESFSportTypeId_First(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFMatchId_ExternalShooter_ESFSportTypeId_First(esfMatchId,
				externalShooter, esfSportTypeId, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", externalShooter=");
		msg.append(externalShooter);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId_ExternalShooter_ESFSportTypeId_First(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNotOlimpicMatchResult> list = findByESFMatchId_ExternalShooter_ESFSportTypeId(esfMatchId,
				externalShooter, esfSportTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFMatchId_ExternalShooter_ESFSportTypeId_Last(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFMatchId_ExternalShooter_ESFSportTypeId_Last(esfMatchId,
				externalShooter, esfSportTypeId, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", externalShooter=");
		msg.append(externalShooter);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId_ExternalShooter_ESFSportTypeId_Last(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMatchId_ExternalShooter_ESFSportTypeId(esfMatchId,
				externalShooter, esfSportTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFNotOlimpicMatchResult> list = findByESFMatchId_ExternalShooter_ESFSportTypeId(esfMatchId,
				externalShooter, esfSportTypeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f not olimpic match results before and after the current e s f not olimpic match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param ESFNotOlimpicMatchResultId the primary key of the current e s f not olimpic match result
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult[] findByESFMatchId_ExternalShooter_ESFSportTypeId_PrevAndNext(
		long ESFNotOlimpicMatchResultId, long esfMatchId,
		boolean externalShooter, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = findByPrimaryKey(ESFNotOlimpicMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFNotOlimpicMatchResult[] array = new ESFNotOlimpicMatchResultImpl[3];

			array[0] = getByESFMatchId_ExternalShooter_ESFSportTypeId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, externalShooter,
					esfSportTypeId, orderByComparator, true);

			array[1] = esfNotOlimpicMatchResult;

			array[2] = getByESFMatchId_ExternalShooter_ESFSportTypeId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, externalShooter,
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

	protected ESFNotOlimpicMatchResult getByESFMatchId_ExternalShooter_ESFSportTypeId_PrevAndNext(
		Session session, ESFNotOlimpicMatchResult esfNotOlimpicMatchResult,
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_EXTERNALSHOOTER_2);

		query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

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
			query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(externalShooter);

		qPos.add(esfSportTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNotOlimpicMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNotOlimpicMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f not olimpic match results where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param esfSportTypeId the esf sport type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatchId_ExternalShooter_ESFSportTypeId(
		long esfMatchId, boolean externalShooter, long esfSportTypeId)
		throws SystemException {
		for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : findByESFMatchId_ExternalShooter_ESFSportTypeId(
				esfMatchId, externalShooter, esfSportTypeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfNotOlimpicMatchResult);
		}
	}

	/**
	 * Returns the number of e s f not olimpic match results where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param esfSportTypeId the esf sport type ID
	 * @return the number of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMatchId_ExternalShooter_ESFSportTypeId(
		long esfMatchId, boolean externalShooter, long esfSportTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID;

		Object[] finderArgs = new Object[] {
				esfMatchId, externalShooter, esfSportTypeId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_EXTERNALSHOOTER_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(externalShooter);

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

	private static final String _FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_ESFMATCHID_2 =
		"esfNotOlimpicMatchResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_EXTERNALSHOOTER_2 =
		"esfNotOlimpicMatchResult.externalShooter = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID_ESFSPORTTYPEID_2 =
		"esfNotOlimpicMatchResult.esfSportTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFMatchId_QualificationId_ESFSportTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMatchId_QualificationId_ESFSportTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ESFNotOlimpicMatchResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.ESFUSERQUALIFICATION_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.ESFSPORTTYPEID_COLUMN_BITMASK |
			ESFNotOlimpicMatchResultModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID =
		new FinderPath(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMatchId_QualificationId_ESFSportTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the e s f not olimpic match results where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserQualification the esf user qualification
	 * @param esfSportTypeId the esf sport type ID
	 * @return the matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_QualificationId_ESFSportTypeId(
		long esfMatchId, long esfUserQualification, long esfSportTypeId)
		throws SystemException {
		return findByESFMatchId_QualificationId_ESFSportTypeId(esfMatchId,
			esfUserQualification, esfSportTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f not olimpic match results where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserQualification the esf user qualification
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @return the range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_QualificationId_ESFSportTypeId(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		int start, int end) throws SystemException {
		return findByESFMatchId_QualificationId_ESFSportTypeId(esfMatchId,
			esfUserQualification, esfSportTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f not olimpic match results where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserQualification the esf user qualification
	 * @param esfSportTypeId the esf sport type ID
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findByESFMatchId_QualificationId_ESFSportTypeId(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID;
			finderArgs = new Object[] {
					esfMatchId, esfUserQualification, esfSportTypeId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID;
			finderArgs = new Object[] {
					esfMatchId, esfUserQualification, esfSportTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFNotOlimpicMatchResult> list = (List<ESFNotOlimpicMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : list) {
				if ((esfMatchId != esfNotOlimpicMatchResult.getEsfMatchId()) ||
						(esfUserQualification != esfNotOlimpicMatchResult.getEsfUserQualification()) ||
						(esfSportTypeId != esfNotOlimpicMatchResult.getEsfSportTypeId())) {
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

			query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFUSERQUALIFICATION_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfUserQualification);

				qPos.add(esfSportTypeId);

				if (!pagination) {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNotOlimpicMatchResult>(list);
				}
				else {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserQualification the esf user qualification
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFMatchId_QualificationId_ESFSportTypeId_First(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFMatchId_QualificationId_ESFSportTypeId_First(esfMatchId,
				esfUserQualification, esfSportTypeId, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserQualification=");
		msg.append(esfUserQualification);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserQualification the esf user qualification
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId_QualificationId_ESFSportTypeId_First(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNotOlimpicMatchResult> list = findByESFMatchId_QualificationId_ESFSportTypeId(esfMatchId,
				esfUserQualification, esfSportTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserQualification the esf user qualification
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByESFMatchId_QualificationId_ESFSportTypeId_Last(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByESFMatchId_QualificationId_ESFSportTypeId_Last(esfMatchId,
				esfUserQualification, esfSportTypeId, orderByComparator);

		if (esfNotOlimpicMatchResult != null) {
			return esfNotOlimpicMatchResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserQualification=");
		msg.append(esfUserQualification);

		msg.append(", esfSportTypeId=");
		msg.append(esfSportTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotOlimpicMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserQualification the esf user qualification
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f not olimpic match result, or <code>null</code> if a matching e s f not olimpic match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByESFMatchId_QualificationId_ESFSportTypeId_Last(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMatchId_QualificationId_ESFSportTypeId(esfMatchId,
				esfUserQualification, esfSportTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFNotOlimpicMatchResult> list = findByESFMatchId_QualificationId_ESFSportTypeId(esfMatchId,
				esfUserQualification, esfSportTypeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f not olimpic match results before and after the current e s f not olimpic match result in the ordered set where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param ESFNotOlimpicMatchResultId the primary key of the current e s f not olimpic match result
	 * @param esfMatchId the esf match ID
	 * @param esfUserQualification the esf user qualification
	 * @param esfSportTypeId the esf sport type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult[] findByESFMatchId_QualificationId_ESFSportTypeId_PrevAndNext(
		long ESFNotOlimpicMatchResultId, long esfMatchId,
		long esfUserQualification, long esfSportTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = findByPrimaryKey(ESFNotOlimpicMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFNotOlimpicMatchResult[] array = new ESFNotOlimpicMatchResultImpl[3];

			array[0] = getByESFMatchId_QualificationId_ESFSportTypeId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, esfUserQualification,
					esfSportTypeId, orderByComparator, true);

			array[1] = esfNotOlimpicMatchResult;

			array[2] = getByESFMatchId_QualificationId_ESFSportTypeId_PrevAndNext(session,
					esfNotOlimpicMatchResult, esfMatchId, esfUserQualification,
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

	protected ESFNotOlimpicMatchResult getByESFMatchId_QualificationId_ESFSportTypeId_PrevAndNext(
		Session session, ESFNotOlimpicMatchResult esfNotOlimpicMatchResult,
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFUSERQUALIFICATION_2);

		query.append(_FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

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
			query.append(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfUserQualification);

		qPos.add(esfSportTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNotOlimpicMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNotOlimpicMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f not olimpic match results where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserQualification the esf user qualification
	 * @param esfSportTypeId the esf sport type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatchId_QualificationId_ESFSportTypeId(
		long esfMatchId, long esfUserQualification, long esfSportTypeId)
		throws SystemException {
		for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : findByESFMatchId_QualificationId_ESFSportTypeId(
				esfMatchId, esfUserQualification, esfSportTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfNotOlimpicMatchResult);
		}
	}

	/**
	 * Returns the number of e s f not olimpic match results where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserQualification the esf user qualification
	 * @param esfSportTypeId the esf sport type ID
	 * @return the number of matching e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMatchId_QualificationId_ESFSportTypeId(
		long esfMatchId, long esfUserQualification, long esfSportTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID;

		Object[] finderArgs = new Object[] {
				esfMatchId, esfUserQualification, esfSportTypeId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFNOTOLIMPICMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFUSERQUALIFICATION_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFSPORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfUserQualification);

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

	private static final String _FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFMATCHID_2 =
		"esfNotOlimpicMatchResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFUSERQUALIFICATION_2 =
		"esfNotOlimpicMatchResult.esfUserQualification = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID_ESFSPORTTYPEID_2 =
		"esfNotOlimpicMatchResult.esfSportTypeId = ?";

	public ESFNotOlimpicMatchResultPersistenceImpl() {
		setModelClass(ESFNotOlimpicMatchResult.class);
	}

	/**
	 * Caches the e s f not olimpic match result in the entity cache if it is enabled.
	 *
	 * @param esfNotOlimpicMatchResult the e s f not olimpic match result
	 */
	@Override
	public void cacheResult(ESFNotOlimpicMatchResult esfNotOlimpicMatchResult) {
		EntityCacheUtil.putResult(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			esfNotOlimpicMatchResult.getPrimaryKey(), esfNotOlimpicMatchResult);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFMATCHID,
			new Object[] { esfNotOlimpicMatchResult.getEsfMatchId() },
			esfNotOlimpicMatchResult);

		esfNotOlimpicMatchResult.resetOriginalValues();
	}

	/**
	 * Caches the e s f not olimpic match results in the entity cache if it is enabled.
	 *
	 * @param esfNotOlimpicMatchResults the e s f not olimpic match results
	 */
	@Override
	public void cacheResult(
		List<ESFNotOlimpicMatchResult> esfNotOlimpicMatchResults) {
		for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : esfNotOlimpicMatchResults) {
			if (EntityCacheUtil.getResult(
						ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
						ESFNotOlimpicMatchResultImpl.class,
						esfNotOlimpicMatchResult.getPrimaryKey()) == null) {
				cacheResult(esfNotOlimpicMatchResult);
			}
			else {
				esfNotOlimpicMatchResult.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f not olimpic match results.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFNotOlimpicMatchResultImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFNotOlimpicMatchResultImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f not olimpic match result.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFNotOlimpicMatchResult esfNotOlimpicMatchResult) {
		EntityCacheUtil.removeResult(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			esfNotOlimpicMatchResult.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfNotOlimpicMatchResult);
	}

	@Override
	public void clearCache(
		List<ESFNotOlimpicMatchResult> esfNotOlimpicMatchResults) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : esfNotOlimpicMatchResults) {
			EntityCacheUtil.removeResult(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
				ESFNotOlimpicMatchResultImpl.class,
				esfNotOlimpicMatchResult.getPrimaryKey());

			clearUniqueFindersCache(esfNotOlimpicMatchResult);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult) {
		if (esfNotOlimpicMatchResult.isNew()) {
			Object[] args = new Object[] {
					esfNotOlimpicMatchResult.getEsfMatchId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFMATCHID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFMATCHID, args,
				esfNotOlimpicMatchResult);
		}
		else {
			ESFNotOlimpicMatchResultModelImpl esfNotOlimpicMatchResultModelImpl = (ESFNotOlimpicMatchResultModelImpl)esfNotOlimpicMatchResult;

			if ((esfNotOlimpicMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ESFMATCHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNotOlimpicMatchResult.getEsfMatchId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFMATCHID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFMATCHID,
					args, esfNotOlimpicMatchResult);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult) {
		ESFNotOlimpicMatchResultModelImpl esfNotOlimpicMatchResultModelImpl = (ESFNotOlimpicMatchResultModelImpl)esfNotOlimpicMatchResult;

		Object[] args = new Object[] { esfNotOlimpicMatchResult.getEsfMatchId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFMATCHID, args);

		if ((esfNotOlimpicMatchResultModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ESFMATCHID.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfNotOlimpicMatchResultModelImpl.getOriginalEsfMatchId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFMATCHID, args);
		}
	}

	/**
	 * Creates a new e s f not olimpic match result with the primary key. Does not add the e s f not olimpic match result to the database.
	 *
	 * @param ESFNotOlimpicMatchResultId the primary key for the new e s f not olimpic match result
	 * @return the new e s f not olimpic match result
	 */
	@Override
	public ESFNotOlimpicMatchResult create(long ESFNotOlimpicMatchResultId) {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = new ESFNotOlimpicMatchResultImpl();

		esfNotOlimpicMatchResult.setNew(true);
		esfNotOlimpicMatchResult.setPrimaryKey(ESFNotOlimpicMatchResultId);

		return esfNotOlimpicMatchResult;
	}

	/**
	 * Removes the e s f not olimpic match result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ESFNotOlimpicMatchResultId the primary key of the e s f not olimpic match result
	 * @return the e s f not olimpic match result that was removed
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult remove(long ESFNotOlimpicMatchResultId)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		return remove((Serializable)ESFNotOlimpicMatchResultId);
	}

	/**
	 * Removes the e s f not olimpic match result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f not olimpic match result
	 * @return the e s f not olimpic match result that was removed
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult remove(Serializable primaryKey)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = (ESFNotOlimpicMatchResult)session.get(ESFNotOlimpicMatchResultImpl.class,
					primaryKey);

			if (esfNotOlimpicMatchResult == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotOlimpicMatchResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfNotOlimpicMatchResult);
		}
		catch (NoSuchNotOlimpicMatchResultException nsee) {
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
	protected ESFNotOlimpicMatchResult removeImpl(
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult)
		throws SystemException {
		esfNotOlimpicMatchResult = toUnwrappedModel(esfNotOlimpicMatchResult);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfNotOlimpicMatchResult)) {
				esfNotOlimpicMatchResult = (ESFNotOlimpicMatchResult)session.get(ESFNotOlimpicMatchResultImpl.class,
						esfNotOlimpicMatchResult.getPrimaryKeyObj());
			}

			if (esfNotOlimpicMatchResult != null) {
				session.delete(esfNotOlimpicMatchResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfNotOlimpicMatchResult != null) {
			clearCache(esfNotOlimpicMatchResult);
		}

		return esfNotOlimpicMatchResult;
	}

	@Override
	public ESFNotOlimpicMatchResult updateImpl(
		it.ethica.esf.model.ESFNotOlimpicMatchResult esfNotOlimpicMatchResult)
		throws SystemException {
		esfNotOlimpicMatchResult = toUnwrappedModel(esfNotOlimpicMatchResult);

		boolean isNew = esfNotOlimpicMatchResult.isNew();

		ESFNotOlimpicMatchResultModelImpl esfNotOlimpicMatchResultModelImpl = (ESFNotOlimpicMatchResultModelImpl)esfNotOlimpicMatchResult;

		Session session = null;

		try {
			session = openSession();

			if (esfNotOlimpicMatchResult.isNew()) {
				session.save(esfNotOlimpicMatchResult);

				esfNotOlimpicMatchResult.setNew(false);
			}
			else {
				session.merge(esfNotOlimpicMatchResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFNotOlimpicMatchResultModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfNotOlimpicMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID,
					args);

				args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID,
					args);
			}

			if ((esfNotOlimpicMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);

				args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);
			}

			if ((esfNotOlimpicMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getOriginalExternalShooter()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_EXTERNALSHOOTER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER,
					args);

				args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getExternalShooter()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_EXTERNALSHOOTER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER,
					args);
			}

			if ((esfNotOlimpicMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFSPORTTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_ESFSPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFSPORTTYPEID,
					args);

				args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getEsfSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_ESFSPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFSPORTTYPEID,
					args);
			}

			if ((esfNotOlimpicMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHID_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATCHID_USERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHID_USERID,
					args);

				args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATCHID_USERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATCHID_USERID,
					args);
			}

			if ((esfNotOlimpicMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getOriginalExternalShooter(),
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID,
					args);

				args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getExternalShooter(),
						esfNotOlimpicMatchResultModelImpl.getEsfSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER_ESFSPORTTYPEID,
					args);
			}

			if ((esfNotOlimpicMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfUserQualification(),
						esfNotOlimpicMatchResultModelImpl.getOriginalEsfSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID,
					args);

				args = new Object[] {
						esfNotOlimpicMatchResultModelImpl.getEsfMatchId(),
						esfNotOlimpicMatchResultModelImpl.getEsfUserQualification(),
						esfNotOlimpicMatchResultModelImpl.getEsfSportTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_QUALIFICATIONID_ESFSPORTTYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNotOlimpicMatchResultImpl.class,
			esfNotOlimpicMatchResult.getPrimaryKey(), esfNotOlimpicMatchResult);

		clearUniqueFindersCache(esfNotOlimpicMatchResult);
		cacheUniqueFindersCache(esfNotOlimpicMatchResult);

		return esfNotOlimpicMatchResult;
	}

	protected ESFNotOlimpicMatchResult toUnwrappedModel(
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult) {
		if (esfNotOlimpicMatchResult instanceof ESFNotOlimpicMatchResultImpl) {
			return esfNotOlimpicMatchResult;
		}

		ESFNotOlimpicMatchResultImpl esfNotOlimpicMatchResultImpl = new ESFNotOlimpicMatchResultImpl();

		esfNotOlimpicMatchResultImpl.setNew(esfNotOlimpicMatchResult.isNew());
		esfNotOlimpicMatchResultImpl.setPrimaryKey(esfNotOlimpicMatchResult.getPrimaryKey());

		esfNotOlimpicMatchResultImpl.setESFNotOlimpicMatchResultId(esfNotOlimpicMatchResult.getESFNotOlimpicMatchResultId());
		esfNotOlimpicMatchResultImpl.setGroupId(esfNotOlimpicMatchResult.getGroupId());
		esfNotOlimpicMatchResultImpl.setCompanyId(esfNotOlimpicMatchResult.getCompanyId());
		esfNotOlimpicMatchResultImpl.setUserId(esfNotOlimpicMatchResult.getUserId());
		esfNotOlimpicMatchResultImpl.setUserName(esfNotOlimpicMatchResult.getUserName());
		esfNotOlimpicMatchResultImpl.setCreateDate(esfNotOlimpicMatchResult.getCreateDate());
		esfNotOlimpicMatchResultImpl.setModifiedDate(esfNotOlimpicMatchResult.getModifiedDate());
		esfNotOlimpicMatchResultImpl.setEsfMatchId(esfNotOlimpicMatchResult.getEsfMatchId());
		esfNotOlimpicMatchResultImpl.setEsfUserId(esfNotOlimpicMatchResult.getEsfUserId());
		esfNotOlimpicMatchResultImpl.setPosition(esfNotOlimpicMatchResult.getPosition());
		esfNotOlimpicMatchResultImpl.setQualification(esfNotOlimpicMatchResult.getQualification());
		esfNotOlimpicMatchResultImpl.setShootOff(esfNotOlimpicMatchResult.getShootOff());
		esfNotOlimpicMatchResultImpl.setClayPigeonTotal(esfNotOlimpicMatchResult.getClayPigeonTotal());
		esfNotOlimpicMatchResultImpl.setFinalResult(esfNotOlimpicMatchResult.getFinalResult());
		esfNotOlimpicMatchResultImpl.setShootOffFinal(esfNotOlimpicMatchResult.getShootOffFinal());
		esfNotOlimpicMatchResultImpl.setExternalShooter(esfNotOlimpicMatchResult.isExternalShooter());
		esfNotOlimpicMatchResultImpl.setExternalName(esfNotOlimpicMatchResult.getExternalName());
		esfNotOlimpicMatchResultImpl.setEsfSportTypeId(esfNotOlimpicMatchResult.getEsfSportTypeId());
		esfNotOlimpicMatchResultImpl.setUserNationality(esfNotOlimpicMatchResult.getUserNationality());
		esfNotOlimpicMatchResultImpl.setEsfUserQualification(esfNotOlimpicMatchResult.getEsfUserQualification());

		return esfNotOlimpicMatchResultImpl;
	}

	/**
	 * Returns the e s f not olimpic match result with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f not olimpic match result
	 * @return the e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = fetchByPrimaryKey(primaryKey);

		if (esfNotOlimpicMatchResult == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotOlimpicMatchResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfNotOlimpicMatchResult;
	}

	/**
	 * Returns the e s f not olimpic match result with the primary key or throws a {@link it.ethica.esf.NoSuchNotOlimpicMatchResultException} if it could not be found.
	 *
	 * @param ESFNotOlimpicMatchResultId the primary key of the e s f not olimpic match result
	 * @return the e s f not olimpic match result
	 * @throws it.ethica.esf.NoSuchNotOlimpicMatchResultException if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult findByPrimaryKey(
		long ESFNotOlimpicMatchResultId)
		throws NoSuchNotOlimpicMatchResultException, SystemException {
		return findByPrimaryKey((Serializable)ESFNotOlimpicMatchResultId);
	}

	/**
	 * Returns the e s f not olimpic match result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f not olimpic match result
	 * @return the e s f not olimpic match result, or <code>null</code> if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFNotOlimpicMatchResult esfNotOlimpicMatchResult = (ESFNotOlimpicMatchResult)EntityCacheUtil.getResult(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
				ESFNotOlimpicMatchResultImpl.class, primaryKey);

		if (esfNotOlimpicMatchResult == _nullESFNotOlimpicMatchResult) {
			return null;
		}

		if (esfNotOlimpicMatchResult == null) {
			Session session = null;

			try {
				session = openSession();

				esfNotOlimpicMatchResult = (ESFNotOlimpicMatchResult)session.get(ESFNotOlimpicMatchResultImpl.class,
						primaryKey);

				if (esfNotOlimpicMatchResult != null) {
					cacheResult(esfNotOlimpicMatchResult);
				}
				else {
					EntityCacheUtil.putResult(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
						ESFNotOlimpicMatchResultImpl.class, primaryKey,
						_nullESFNotOlimpicMatchResult);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFNotOlimpicMatchResultModelImpl.ENTITY_CACHE_ENABLED,
					ESFNotOlimpicMatchResultImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfNotOlimpicMatchResult;
	}

	/**
	 * Returns the e s f not olimpic match result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ESFNotOlimpicMatchResultId the primary key of the e s f not olimpic match result
	 * @return the e s f not olimpic match result, or <code>null</code> if a e s f not olimpic match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNotOlimpicMatchResult fetchByPrimaryKey(
		long ESFNotOlimpicMatchResultId) throws SystemException {
		return fetchByPrimaryKey((Serializable)ESFNotOlimpicMatchResultId);
	}

	/**
	 * Returns all the e s f not olimpic match results.
	 *
	 * @return the e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f not olimpic match results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @return the range of e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f not olimpic match results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNotOlimpicMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f not olimpic match results
	 * @param end the upper bound of the range of e s f not olimpic match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f not olimpic match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNotOlimpicMatchResult> findAll(int start, int end,
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

		List<ESFNotOlimpicMatchResult> list = (List<ESFNotOlimpicMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFNOTOLIMPICMATCHRESULT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFNOTOLIMPICMATCHRESULT;

				if (pagination) {
					sql = sql.concat(ESFNotOlimpicMatchResultModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNotOlimpicMatchResult>(list);
				}
				else {
					list = (List<ESFNotOlimpicMatchResult>)QueryUtil.list(q,
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
	 * Removes all the e s f not olimpic match results from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFNotOlimpicMatchResult esfNotOlimpicMatchResult : findAll()) {
			remove(esfNotOlimpicMatchResult);
		}
	}

	/**
	 * Returns the number of e s f not olimpic match results.
	 *
	 * @return the number of e s f not olimpic match results
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

				Query q = session.createQuery(_SQL_COUNT_ESFNOTOLIMPICMATCHRESULT);

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
	 * Initializes the e s f not olimpic match result persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFNotOlimpicMatchResult")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFNotOlimpicMatchResult>> listenersList = new ArrayList<ModelListener<ESFNotOlimpicMatchResult>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFNotOlimpicMatchResult>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFNotOlimpicMatchResultImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFNOTOLIMPICMATCHRESULT = "SELECT esfNotOlimpicMatchResult FROM ESFNotOlimpicMatchResult esfNotOlimpicMatchResult";
	private static final String _SQL_SELECT_ESFNOTOLIMPICMATCHRESULT_WHERE = "SELECT esfNotOlimpicMatchResult FROM ESFNotOlimpicMatchResult esfNotOlimpicMatchResult WHERE ";
	private static final String _SQL_COUNT_ESFNOTOLIMPICMATCHRESULT = "SELECT COUNT(esfNotOlimpicMatchResult) FROM ESFNotOlimpicMatchResult esfNotOlimpicMatchResult";
	private static final String _SQL_COUNT_ESFNOTOLIMPICMATCHRESULT_WHERE = "SELECT COUNT(esfNotOlimpicMatchResult) FROM ESFNotOlimpicMatchResult esfNotOlimpicMatchResult WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfNotOlimpicMatchResult.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFNotOlimpicMatchResult exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFNotOlimpicMatchResult exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFNotOlimpicMatchResultPersistenceImpl.class);
	private static ESFNotOlimpicMatchResult _nullESFNotOlimpicMatchResult = new ESFNotOlimpicMatchResultImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFNotOlimpicMatchResult> toCacheModel() {
				return _nullESFNotOlimpicMatchResultCacheModel;
			}
		};

	private static CacheModel<ESFNotOlimpicMatchResult> _nullESFNotOlimpicMatchResultCacheModel =
		new CacheModel<ESFNotOlimpicMatchResult>() {
			@Override
			public ESFNotOlimpicMatchResult toEntityModel() {
				return _nullESFNotOlimpicMatchResult;
			}
		};
}