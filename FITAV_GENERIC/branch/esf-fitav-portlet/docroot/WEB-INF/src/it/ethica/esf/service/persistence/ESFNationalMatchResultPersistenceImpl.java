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

import it.ethica.esf.NoSuchNationalMatchResultException;
import it.ethica.esf.model.ESFNationalMatchResult;
import it.ethica.esf.model.impl.ESFNationalMatchResultImpl;
import it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f national match result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFNationalMatchResultPersistence
 * @see ESFNationalMatchResultUtil
 * @generated
 */
public class ESFNationalMatchResultPersistenceImpl extends BasePersistenceImpl<ESFNationalMatchResult>
	implements ESFNationalMatchResultPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFNationalMatchResultUtil} to access the e s f national match result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFNationalMatchResultImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID =
		new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFMatchId_ESFUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID =
		new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMatchId_ESFUserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFNationalMatchResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFNationalMatchResultModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFNationalMatchResultModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID_ESFUSERID = new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMatchId_ESFUserId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @return the matching e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId) throws SystemException {
		return findByESFMatchId_ESFUserId(esfMatchId, esfUserId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f national match results
	 * @param end the upper bound of the range of e s f national match results (not inclusive)
	 * @return the range of matching e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId, int start, int end)
		throws SystemException {
		return findByESFMatchId_ESFUserId(esfMatchId, esfUserId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f national match results
	 * @param end the upper bound of the range of e s f national match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findByESFMatchId_ESFUserId(
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

		List<ESFNationalMatchResult> list = (List<ESFNationalMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNationalMatchResult esfNationalMatchResult : list) {
				if ((esfMatchId != esfNationalMatchResult.getEsfMatchId()) ||
						(esfUserId != esfNationalMatchResult.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFNATIONALMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFUSERID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalMatchResultModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFNationalMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalMatchResult>(list);
				}
				else {
					list = (List<ESFNationalMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult findByESFMatchId_ESFUserId_First(
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = fetchByESFMatchId_ESFUserId_First(esfMatchId,
				esfUserId, orderByComparator);

		if (esfNationalMatchResult != null) {
			return esfNationalMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult fetchByESFMatchId_ESFUserId_First(
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFNationalMatchResult> list = findByESFMatchId_ESFUserId(esfMatchId,
				esfUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult findByESFMatchId_ESFUserId_Last(
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = fetchByESFMatchId_ESFUserId_Last(esfMatchId,
				esfUserId, orderByComparator);

		if (esfNationalMatchResult != null) {
			return esfNationalMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult fetchByESFMatchId_ESFUserId_Last(
		long esfMatchId, long esfUserId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFMatchId_ESFUserId(esfMatchId, esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFNationalMatchResult> list = findByESFMatchId_ESFUserId(esfMatchId,
				esfUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfNationalMatchResultId the primary key of the current e s f national match result
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult[] findByESFMatchId_ESFUserId_PrevAndNext(
		long esfNationalMatchResultId, long esfMatchId, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = findByPrimaryKey(esfNationalMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFNationalMatchResult[] array = new ESFNationalMatchResultImpl[3];

			array[0] = getByESFMatchId_ESFUserId_PrevAndNext(session,
					esfNationalMatchResult, esfMatchId, esfUserId,
					orderByComparator, true);

			array[1] = esfNationalMatchResult;

			array[2] = getByESFMatchId_ESFUserId_PrevAndNext(session,
					esfNationalMatchResult, esfMatchId, esfUserId,
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

	protected ESFNationalMatchResult getByESFMatchId_ESFUserId_PrevAndNext(
		Session session, ESFNationalMatchResult esfNationalMatchResult,
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

		query.append(_SQL_SELECT_ESFNATIONALMATCHRESULT_WHERE);

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
			query.append(ESFNationalMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNationalMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNationalMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatchId_ESFUserId(long esfMatchId, long esfUserId)
		throws SystemException {
		for (ESFNationalMatchResult esfNationalMatchResult : findByESFMatchId_ESFUserId(
				esfMatchId, esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(esfNationalMatchResult);
		}
	}

	/**
	 * Returns the number of e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f national match results
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

			query.append(_SQL_COUNT_ESFNATIONALMATCHRESULT_WHERE);

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
		"esfNationalMatchResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_ESFUSERID_ESFUSERID_2 = "esfNationalMatchResult.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID =
		new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFUserId",
			new String[] { Long.class.getName() },
			ESFNationalMatchResultModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFNationalMatchResultModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFUSERID = new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f national match results where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findByESFUserId(long esfUserId)
		throws SystemException {
		return findByESFUserId(esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f national match results where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f national match results
	 * @param end the upper bound of the range of e s f national match results (not inclusive)
	 * @return the range of matching e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findByESFUserId(long esfUserId,
		int start, int end) throws SystemException {
		return findByESFUserId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f national match results where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f national match results
	 * @param end the upper bound of the range of e s f national match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findByESFUserId(long esfUserId,
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

		List<ESFNationalMatchResult> list = (List<ESFNationalMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNationalMatchResult esfNationalMatchResult : list) {
				if ((esfUserId != esfNationalMatchResult.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFNATIONALMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFUSERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalMatchResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFNationalMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalMatchResult>(list);
				}
				else {
					list = (List<ESFNationalMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f national match result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult findByESFUserId_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = fetchByESFUserId_First(esfUserId,
				orderByComparator);

		if (esfNationalMatchResult != null) {
			return esfNationalMatchResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f national match result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult fetchByESFUserId_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNationalMatchResult> list = findByESFUserId(esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national match result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult findByESFUserId_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = fetchByESFUserId_Last(esfUserId,
				orderByComparator);

		if (esfNationalMatchResult != null) {
			return esfNationalMatchResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f national match result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult fetchByESFUserId_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFUserId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFNationalMatchResult> list = findByESFUserId(esfUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfNationalMatchResultId the primary key of the current e s f national match result
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult[] findByESFUserId_PrevAndNext(
		long esfNationalMatchResultId, long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = findByPrimaryKey(esfNationalMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFNationalMatchResult[] array = new ESFNationalMatchResultImpl[3];

			array[0] = getByESFUserId_PrevAndNext(session,
					esfNationalMatchResult, esfUserId, orderByComparator, true);

			array[1] = esfNationalMatchResult;

			array[2] = getByESFUserId_PrevAndNext(session,
					esfNationalMatchResult, esfUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFNationalMatchResult getByESFUserId_PrevAndNext(
		Session session, ESFNationalMatchResult esfNationalMatchResult,
		long esfUserId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFNATIONALMATCHRESULT_WHERE);

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
			query.append(ESFNationalMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNationalMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNationalMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f national match results where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFUserId(long esfUserId) throws SystemException {
		for (ESFNationalMatchResult esfNationalMatchResult : findByESFUserId(
				esfUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfNationalMatchResult);
		}
	}

	/**
	 * Returns the number of e s f national match results where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f national match results
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

			query.append(_SQL_COUNT_ESFNATIONALMATCHRESULT_WHERE);

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

	private static final String _FINDER_COLUMN_ESFUSERID_ESFUSERID_2 = "esfNationalMatchResult.esfUserId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ESFMATCHID = new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByESFMatchId", new String[] { Long.class.getName() },
			ESFNationalMatchResultModelImpl.ESFMATCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID = new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFMatchId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the e s f national match result where esfMatchId = &#63; or throws a {@link it.ethica.esf.NoSuchNationalMatchResultException} if it could not be found.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult findByESFMatchId(long esfMatchId)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = fetchByESFMatchId(esfMatchId);

		if (esfNationalMatchResult == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("esfMatchId=");
			msg.append(esfMatchId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNationalMatchResultException(msg.toString());
		}

		return esfNationalMatchResult;
	}

	/**
	 * Returns the e s f national match result where esfMatchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult fetchByESFMatchId(long esfMatchId)
		throws SystemException {
		return fetchByESFMatchId(esfMatchId, true);
	}

	/**
	 * Returns the e s f national match result where esfMatchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param esfMatchId the esf match ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult fetchByESFMatchId(long esfMatchId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { esfMatchId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ESFMATCHID,
					finderArgs, this);
		}

		if (result instanceof ESFNationalMatchResult) {
			ESFNationalMatchResult esfNationalMatchResult = (ESFNationalMatchResult)result;

			if ((esfMatchId != esfNationalMatchResult.getEsfMatchId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFNATIONALMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFMATCHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				List<ESFNationalMatchResult> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFMATCHID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFNationalMatchResultPersistenceImpl.fetchByESFMatchId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFNationalMatchResult esfNationalMatchResult = list.get(0);

					result = esfNationalMatchResult;

					cacheResult(esfNationalMatchResult);

					if ((esfNationalMatchResult.getEsfMatchId() != esfMatchId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFMATCHID,
							finderArgs, esfNationalMatchResult);
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
			return (ESFNationalMatchResult)result;
		}
	}

	/**
	 * Removes the e s f national match result where esfMatchId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the e s f national match result that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult removeByESFMatchId(long esfMatchId)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = findByESFMatchId(esfMatchId);

		return remove(esfNationalMatchResult);
	}

	/**
	 * Returns the number of e s f national match results where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the number of matching e s f national match results
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

			query.append(_SQL_COUNT_ESFNATIONALMATCHRESULT_WHERE);

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

	private static final String _FINDER_COLUMN_ESFMATCHID_ESFMATCHID_2 = "esfNationalMatchResult.esfMatchId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER =
		new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFMatchId_ExternalShooter",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER =
		new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMatchId_ExternalShooter",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ESFNationalMatchResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFNationalMatchResultModelImpl.EXTERNALSHOOTER_COLUMN_BITMASK |
			ESFNationalMatchResultModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID_EXTERNALSHOOTER =
		new FinderPath(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMatchId_ExternalShooter",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @return the matching e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findByESFMatchId_ExternalShooter(
		long esfMatchId, boolean externalShooter) throws SystemException {
		return findByESFMatchId_ExternalShooter(esfMatchId, externalShooter,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param start the lower bound of the range of e s f national match results
	 * @param end the upper bound of the range of e s f national match results (not inclusive)
	 * @return the range of matching e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findByESFMatchId_ExternalShooter(
		long esfMatchId, boolean externalShooter, int start, int end)
		throws SystemException {
		return findByESFMatchId_ExternalShooter(esfMatchId, externalShooter,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param start the lower bound of the range of e s f national match results
	 * @param end the upper bound of the range of e s f national match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findByESFMatchId_ExternalShooter(
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

		List<ESFNationalMatchResult> list = (List<ESFNationalMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFNationalMatchResult esfNationalMatchResult : list) {
				if ((esfMatchId != esfNationalMatchResult.getEsfMatchId()) ||
						(externalShooter != esfNationalMatchResult.getExternalShooter())) {
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

			query.append(_SQL_SELECT_ESFNATIONALMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_EXTERNALSHOOTER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFNationalMatchResultModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFNationalMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalMatchResult>(list);
				}
				else {
					list = (List<ESFNationalMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult findByESFMatchId_ExternalShooter_First(
		long esfMatchId, boolean externalShooter,
		OrderByComparator orderByComparator)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = fetchByESFMatchId_ExternalShooter_First(esfMatchId,
				externalShooter, orderByComparator);

		if (esfNationalMatchResult != null) {
			return esfNationalMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", externalShooter=");
		msg.append(externalShooter);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult fetchByESFMatchId_ExternalShooter_First(
		long esfMatchId, boolean externalShooter,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFNationalMatchResult> list = findByESFMatchId_ExternalShooter(esfMatchId,
				externalShooter, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult findByESFMatchId_ExternalShooter_Last(
		long esfMatchId, boolean externalShooter,
		OrderByComparator orderByComparator)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = fetchByESFMatchId_ExternalShooter_Last(esfMatchId,
				externalShooter, orderByComparator);

		if (esfNationalMatchResult != null) {
			return esfNationalMatchResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", externalShooter=");
		msg.append(externalShooter);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNationalMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult fetchByESFMatchId_ExternalShooter_Last(
		long esfMatchId, boolean externalShooter,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMatchId_ExternalShooter(esfMatchId,
				externalShooter);

		if (count == 0) {
			return null;
		}

		List<ESFNationalMatchResult> list = findByESFMatchId_ExternalShooter(esfMatchId,
				externalShooter, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfNationalMatchResultId the primary key of the current e s f national match result
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult[] findByESFMatchId_ExternalShooter_PrevAndNext(
		long esfNationalMatchResultId, long esfMatchId,
		boolean externalShooter, OrderByComparator orderByComparator)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = findByPrimaryKey(esfNationalMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFNationalMatchResult[] array = new ESFNationalMatchResultImpl[3];

			array[0] = getByESFMatchId_ExternalShooter_PrevAndNext(session,
					esfNationalMatchResult, esfMatchId, externalShooter,
					orderByComparator, true);

			array[1] = esfNationalMatchResult;

			array[2] = getByESFMatchId_ExternalShooter_PrevAndNext(session,
					esfNationalMatchResult, esfMatchId, externalShooter,
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

	protected ESFNationalMatchResult getByESFMatchId_ExternalShooter_PrevAndNext(
		Session session, ESFNationalMatchResult esfNationalMatchResult,
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

		query.append(_SQL_SELECT_ESFNATIONALMATCHRESULT_WHERE);

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
			query.append(ESFNationalMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(externalShooter);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfNationalMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFNationalMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatchId_ExternalShooter(long esfMatchId,
		boolean externalShooter) throws SystemException {
		for (ESFNationalMatchResult esfNationalMatchResult : findByESFMatchId_ExternalShooter(
				esfMatchId, externalShooter, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfNationalMatchResult);
		}
	}

	/**
	 * Returns the number of e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param externalShooter the external shooter
	 * @return the number of matching e s f national match results
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

			query.append(_SQL_COUNT_ESFNATIONALMATCHRESULT_WHERE);

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
		"esfNationalMatchResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMATCHID_EXTERNALSHOOTER_EXTERNALSHOOTER_2 =
		"esfNationalMatchResult.externalShooter = ?";

	public ESFNationalMatchResultPersistenceImpl() {
		setModelClass(ESFNationalMatchResult.class);
	}

	/**
	 * Caches the e s f national match result in the entity cache if it is enabled.
	 *
	 * @param esfNationalMatchResult the e s f national match result
	 */
	@Override
	public void cacheResult(ESFNationalMatchResult esfNationalMatchResult) {
		EntityCacheUtil.putResult(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class,
			esfNationalMatchResult.getPrimaryKey(), esfNationalMatchResult);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFMATCHID,
			new Object[] { esfNationalMatchResult.getEsfMatchId() },
			esfNationalMatchResult);

		esfNationalMatchResult.resetOriginalValues();
	}

	/**
	 * Caches the e s f national match results in the entity cache if it is enabled.
	 *
	 * @param esfNationalMatchResults the e s f national match results
	 */
	@Override
	public void cacheResult(
		List<ESFNationalMatchResult> esfNationalMatchResults) {
		for (ESFNationalMatchResult esfNationalMatchResult : esfNationalMatchResults) {
			if (EntityCacheUtil.getResult(
						ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
						ESFNationalMatchResultImpl.class,
						esfNationalMatchResult.getPrimaryKey()) == null) {
				cacheResult(esfNationalMatchResult);
			}
			else {
				esfNationalMatchResult.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f national match results.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFNationalMatchResultImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFNationalMatchResultImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f national match result.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFNationalMatchResult esfNationalMatchResult) {
		EntityCacheUtil.removeResult(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class,
			esfNationalMatchResult.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfNationalMatchResult);
	}

	@Override
	public void clearCache(List<ESFNationalMatchResult> esfNationalMatchResults) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFNationalMatchResult esfNationalMatchResult : esfNationalMatchResults) {
			EntityCacheUtil.removeResult(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
				ESFNationalMatchResultImpl.class,
				esfNationalMatchResult.getPrimaryKey());

			clearUniqueFindersCache(esfNationalMatchResult);
		}
	}

	protected void cacheUniqueFindersCache(
		ESFNationalMatchResult esfNationalMatchResult) {
		if (esfNationalMatchResult.isNew()) {
			Object[] args = new Object[] { esfNationalMatchResult.getEsfMatchId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFMATCHID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFMATCHID, args,
				esfNationalMatchResult);
		}
		else {
			ESFNationalMatchResultModelImpl esfNationalMatchResultModelImpl = (ESFNationalMatchResultModelImpl)esfNationalMatchResult;

			if ((esfNationalMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ESFMATCHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNationalMatchResult.getEsfMatchId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESFMATCHID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ESFMATCHID,
					args, esfNationalMatchResult);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ESFNationalMatchResult esfNationalMatchResult) {
		ESFNationalMatchResultModelImpl esfNationalMatchResultModelImpl = (ESFNationalMatchResultModelImpl)esfNationalMatchResult;

		Object[] args = new Object[] { esfNationalMatchResult.getEsfMatchId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFMATCHID, args);

		if ((esfNationalMatchResultModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ESFMATCHID.getColumnBitmask()) != 0) {
			args = new Object[] {
					esfNationalMatchResultModelImpl.getOriginalEsfMatchId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ESFMATCHID, args);
		}
	}

	/**
	 * Creates a new e s f national match result with the primary key. Does not add the e s f national match result to the database.
	 *
	 * @param esfNationalMatchResultId the primary key for the new e s f national match result
	 * @return the new e s f national match result
	 */
	@Override
	public ESFNationalMatchResult create(long esfNationalMatchResultId) {
		ESFNationalMatchResult esfNationalMatchResult = new ESFNationalMatchResultImpl();

		esfNationalMatchResult.setNew(true);
		esfNationalMatchResult.setPrimaryKey(esfNationalMatchResultId);

		return esfNationalMatchResult;
	}

	/**
	 * Removes the e s f national match result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfNationalMatchResultId the primary key of the e s f national match result
	 * @return the e s f national match result that was removed
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult remove(long esfNationalMatchResultId)
		throws NoSuchNationalMatchResultException, SystemException {
		return remove((Serializable)esfNationalMatchResultId);
	}

	/**
	 * Removes the e s f national match result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f national match result
	 * @return the e s f national match result that was removed
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult remove(Serializable primaryKey)
		throws NoSuchNationalMatchResultException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFNationalMatchResult esfNationalMatchResult = (ESFNationalMatchResult)session.get(ESFNationalMatchResultImpl.class,
					primaryKey);

			if (esfNationalMatchResult == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNationalMatchResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfNationalMatchResult);
		}
		catch (NoSuchNationalMatchResultException nsee) {
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
	protected ESFNationalMatchResult removeImpl(
		ESFNationalMatchResult esfNationalMatchResult)
		throws SystemException {
		esfNationalMatchResult = toUnwrappedModel(esfNationalMatchResult);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfNationalMatchResult)) {
				esfNationalMatchResult = (ESFNationalMatchResult)session.get(ESFNationalMatchResultImpl.class,
						esfNationalMatchResult.getPrimaryKeyObj());
			}

			if (esfNationalMatchResult != null) {
				session.delete(esfNationalMatchResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfNationalMatchResult != null) {
			clearCache(esfNationalMatchResult);
		}

		return esfNationalMatchResult;
	}

	@Override
	public ESFNationalMatchResult updateImpl(
		it.ethica.esf.model.ESFNationalMatchResult esfNationalMatchResult)
		throws SystemException {
		esfNationalMatchResult = toUnwrappedModel(esfNationalMatchResult);

		boolean isNew = esfNationalMatchResult.isNew();

		ESFNationalMatchResultModelImpl esfNationalMatchResultModelImpl = (ESFNationalMatchResultModelImpl)esfNationalMatchResult;

		Session session = null;

		try {
			session = openSession();

			if (esfNationalMatchResult.isNew()) {
				session.save(esfNationalMatchResult);

				esfNationalMatchResult.setNew(false);
			}
			else {
				session.merge(esfNationalMatchResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFNationalMatchResultModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfNationalMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNationalMatchResultModelImpl.getOriginalEsfMatchId(),
						esfNationalMatchResultModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID,
					args);

				args = new Object[] {
						esfNationalMatchResultModelImpl.getEsfMatchId(),
						esfNationalMatchResultModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_ESFUSERID,
					args);
			}

			if ((esfNationalMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNationalMatchResultModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);

				args = new Object[] {
						esfNationalMatchResultModelImpl.getEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFUSERID,
					args);
			}

			if ((esfNationalMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfNationalMatchResultModelImpl.getOriginalEsfMatchId(),
						esfNationalMatchResultModelImpl.getOriginalExternalShooter()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_EXTERNALSHOOTER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER,
					args);

				args = new Object[] {
						esfNationalMatchResultModelImpl.getEsfMatchId(),
						esfNationalMatchResultModelImpl.getExternalShooter()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID_EXTERNALSHOOTER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID_EXTERNALSHOOTER,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFNationalMatchResultImpl.class,
			esfNationalMatchResult.getPrimaryKey(), esfNationalMatchResult);

		clearUniqueFindersCache(esfNationalMatchResult);
		cacheUniqueFindersCache(esfNationalMatchResult);

		return esfNationalMatchResult;
	}

	protected ESFNationalMatchResult toUnwrappedModel(
		ESFNationalMatchResult esfNationalMatchResult) {
		if (esfNationalMatchResult instanceof ESFNationalMatchResultImpl) {
			return esfNationalMatchResult;
		}

		ESFNationalMatchResultImpl esfNationalMatchResultImpl = new ESFNationalMatchResultImpl();

		esfNationalMatchResultImpl.setNew(esfNationalMatchResult.isNew());
		esfNationalMatchResultImpl.setPrimaryKey(esfNationalMatchResult.getPrimaryKey());

		esfNationalMatchResultImpl.setEsfNationalMatchResultId(esfNationalMatchResult.getEsfNationalMatchResultId());
		esfNationalMatchResultImpl.setGroupId(esfNationalMatchResult.getGroupId());
		esfNationalMatchResultImpl.setCompanyId(esfNationalMatchResult.getCompanyId());
		esfNationalMatchResultImpl.setUserId(esfNationalMatchResult.getUserId());
		esfNationalMatchResultImpl.setUserName(esfNationalMatchResult.getUserName());
		esfNationalMatchResultImpl.setCreateDate(esfNationalMatchResult.getCreateDate());
		esfNationalMatchResultImpl.setModifiedDate(esfNationalMatchResult.getModifiedDate());
		esfNationalMatchResultImpl.setEsfMatchId(esfNationalMatchResult.getEsfMatchId());
		esfNationalMatchResultImpl.setEsfUserId(esfNationalMatchResult.getEsfUserId());
		esfNationalMatchResultImpl.setPosition(esfNationalMatchResult.getPosition());
		esfNationalMatchResultImpl.setQualification(esfNationalMatchResult.getQualification());
		esfNationalMatchResultImpl.setShootOff(esfNationalMatchResult.getShootOff());
		esfNationalMatchResultImpl.setClayPigeonTotal(esfNationalMatchResult.getClayPigeonTotal());
		esfNationalMatchResultImpl.setFinalResult(esfNationalMatchResult.getFinalResult());
		esfNationalMatchResultImpl.setShootOffFinal(esfNationalMatchResult.getShootOffFinal());
		esfNationalMatchResultImpl.setExternalShooter(esfNationalMatchResult.isExternalShooter());
		esfNationalMatchResultImpl.setExternalName(esfNationalMatchResult.getExternalName());

		return esfNationalMatchResultImpl;
	}

	/**
	 * Returns the e s f national match result with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f national match result
	 * @return the e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNationalMatchResultException, SystemException {
		ESFNationalMatchResult esfNationalMatchResult = fetchByPrimaryKey(primaryKey);

		if (esfNationalMatchResult == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNationalMatchResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfNationalMatchResult;
	}

	/**
	 * Returns the e s f national match result with the primary key or throws a {@link it.ethica.esf.NoSuchNationalMatchResultException} if it could not be found.
	 *
	 * @param esfNationalMatchResultId the primary key of the e s f national match result
	 * @return the e s f national match result
	 * @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult findByPrimaryKey(
		long esfNationalMatchResultId)
		throws NoSuchNationalMatchResultException, SystemException {
		return findByPrimaryKey((Serializable)esfNationalMatchResultId);
	}

	/**
	 * Returns the e s f national match result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f national match result
	 * @return the e s f national match result, or <code>null</code> if a e s f national match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFNationalMatchResult esfNationalMatchResult = (ESFNationalMatchResult)EntityCacheUtil.getResult(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
				ESFNationalMatchResultImpl.class, primaryKey);

		if (esfNationalMatchResult == _nullESFNationalMatchResult) {
			return null;
		}

		if (esfNationalMatchResult == null) {
			Session session = null;

			try {
				session = openSession();

				esfNationalMatchResult = (ESFNationalMatchResult)session.get(ESFNationalMatchResultImpl.class,
						primaryKey);

				if (esfNationalMatchResult != null) {
					cacheResult(esfNationalMatchResult);
				}
				else {
					EntityCacheUtil.putResult(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
						ESFNationalMatchResultImpl.class, primaryKey,
						_nullESFNationalMatchResult);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFNationalMatchResultModelImpl.ENTITY_CACHE_ENABLED,
					ESFNationalMatchResultImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfNationalMatchResult;
	}

	/**
	 * Returns the e s f national match result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfNationalMatchResultId the primary key of the e s f national match result
	 * @return the e s f national match result, or <code>null</code> if a e s f national match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFNationalMatchResult fetchByPrimaryKey(
		long esfNationalMatchResultId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfNationalMatchResultId);
	}

	/**
	 * Returns all the e s f national match results.
	 *
	 * @return the e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f national match results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f national match results
	 * @param end the upper bound of the range of e s f national match results (not inclusive)
	 * @return the range of e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f national match results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f national match results
	 * @param end the upper bound of the range of e s f national match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f national match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFNationalMatchResult> findAll(int start, int end,
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

		List<ESFNationalMatchResult> list = (List<ESFNationalMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFNATIONALMATCHRESULT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFNATIONALMATCHRESULT;

				if (pagination) {
					sql = sql.concat(ESFNationalMatchResultModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFNationalMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFNationalMatchResult>(list);
				}
				else {
					list = (List<ESFNationalMatchResult>)QueryUtil.list(q,
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
	 * Removes all the e s f national match results from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFNationalMatchResult esfNationalMatchResult : findAll()) {
			remove(esfNationalMatchResult);
		}
	}

	/**
	 * Returns the number of e s f national match results.
	 *
	 * @return the number of e s f national match results
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

				Query q = session.createQuery(_SQL_COUNT_ESFNATIONALMATCHRESULT);

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
	 * Initializes the e s f national match result persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFNationalMatchResult")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFNationalMatchResult>> listenersList = new ArrayList<ModelListener<ESFNationalMatchResult>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFNationalMatchResult>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFNationalMatchResultImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFNATIONALMATCHRESULT = "SELECT esfNationalMatchResult FROM ESFNationalMatchResult esfNationalMatchResult";
	private static final String _SQL_SELECT_ESFNATIONALMATCHRESULT_WHERE = "SELECT esfNationalMatchResult FROM ESFNationalMatchResult esfNationalMatchResult WHERE ";
	private static final String _SQL_COUNT_ESFNATIONALMATCHRESULT = "SELECT COUNT(esfNationalMatchResult) FROM ESFNationalMatchResult esfNationalMatchResult";
	private static final String _SQL_COUNT_ESFNATIONALMATCHRESULT_WHERE = "SELECT COUNT(esfNationalMatchResult) FROM ESFNationalMatchResult esfNationalMatchResult WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfNationalMatchResult.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFNationalMatchResult exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFNationalMatchResult exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFNationalMatchResultPersistenceImpl.class);
	private static ESFNationalMatchResult _nullESFNationalMatchResult = new ESFNationalMatchResultImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFNationalMatchResult> toCacheModel() {
				return _nullESFNationalMatchResultCacheModel;
			}
		};

	private static CacheModel<ESFNationalMatchResult> _nullESFNationalMatchResultCacheModel =
		new CacheModel<ESFNationalMatchResult>() {
			@Override
			public ESFNationalMatchResult toEntityModel() {
				return _nullESFNationalMatchResult;
			}
		};
}