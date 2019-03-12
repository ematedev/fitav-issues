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

import it.ethica.esf.NoSuchMatchResultException;
import it.ethica.esf.model.ESFMatchResult;
import it.ethica.esf.model.impl.ESFMatchResultImpl;
import it.ethica.esf.model.impl.ESFMatchResultModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f match result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFMatchResultPersistence
 * @see ESFMatchResultUtil
 * @generated
 */
public class ESFMatchResultPersistenceImpl extends BasePersistenceImpl<ESFMatchResult>
	implements ESFMatchResultPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFMatchResultUtil} to access the e s f match result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFMatchResultImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFMatchResultImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID =
		new FinderPath(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFMatchResultImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEsfMatchId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID =
		new FinderPath(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEsfMatchId",
			new String[] { Long.class.getName() },
			ESFMatchResultModelImpl.ESFMATCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID = new FinderPath(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEsfMatchId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f match results where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchResult> findByEsfMatchId(long esfMatchId)
		throws SystemException {
		return findByEsfMatchId(esfMatchId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f match results where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f match results
	 * @param end the upper bound of the range of e s f match results (not inclusive)
	 * @return the range of matching e s f match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchResult> findByEsfMatchId(long esfMatchId, int start,
		int end) throws SystemException {
		return findByEsfMatchId(esfMatchId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f match results where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f match results
	 * @param end the upper bound of the range of e s f match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchResult> findByEsfMatchId(long esfMatchId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID;
			finderArgs = new Object[] { esfMatchId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID;
			finderArgs = new Object[] { esfMatchId, start, end, orderByComparator };
		}

		List<ESFMatchResult> list = (List<ESFMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatchResult esfMatchResult : list) {
				if ((esfMatchId != esfMatchResult.getEsfMatchId())) {
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

			query.append(_SQL_SELECT_ESFMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFMATCHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (!pagination) {
					list = (List<ESFMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatchResult>(list);
				}
				else {
					list = (List<ESFMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f match result in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match result
	 * @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult findByEsfMatchId_First(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchMatchResultException, SystemException {
		ESFMatchResult esfMatchResult = fetchByEsfMatchId_First(esfMatchId,
				orderByComparator);

		if (esfMatchResult != null) {
			return esfMatchResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f match result in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult fetchByEsfMatchId_First(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatchResult> list = findByEsfMatchId(esfMatchId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match result in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match result
	 * @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult findByEsfMatchId_Last(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchMatchResultException, SystemException {
		ESFMatchResult esfMatchResult = fetchByEsfMatchId_Last(esfMatchId,
				orderByComparator);

		if (esfMatchResult != null) {
			return esfMatchResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f match result in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult fetchByEsfMatchId_Last(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfMatchId(esfMatchId);

		if (count == 0) {
			return null;
		}

		List<ESFMatchResult> list = findByEsfMatchId(esfMatchId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f match results before and after the current e s f match result in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchResultId the primary key of the current e s f match result
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match result
	 * @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult[] findByEsfMatchId_PrevAndNext(
		long esfMatchResultId, long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchMatchResultException, SystemException {
		ESFMatchResult esfMatchResult = findByPrimaryKey(esfMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFMatchResult[] array = new ESFMatchResultImpl[3];

			array[0] = getByEsfMatchId_PrevAndNext(session, esfMatchResult,
					esfMatchId, orderByComparator, true);

			array[1] = esfMatchResult;

			array[2] = getByEsfMatchId_PrevAndNext(session, esfMatchResult,
					esfMatchId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFMatchResult getByEsfMatchId_PrevAndNext(Session session,
		ESFMatchResult esfMatchResult, long esfMatchId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCHRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFMATCHID_ESFMATCHID_2);

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
			query.append(ESFMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f match results where esfMatchId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfMatchId(long esfMatchId) throws SystemException {
		for (ESFMatchResult esfMatchResult : findByEsfMatchId(esfMatchId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfMatchResult);
		}
	}

	/**
	 * Returns the number of e s f match results where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the number of matching e s f match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfMatchId(long esfMatchId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMATCHID;

		Object[] finderArgs = new Object[] { esfMatchId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFMATCHRESULT_WHERE);

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

	private static final String _FINDER_COLUMN_ESFMATCHID_ESFMATCHID_2 = "esfMatchResult.esfMatchId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESULTUSERID =
		new FinderPath(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFMatchResultImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByResultUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTUSERID =
		new FinderPath(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultModelImpl.FINDER_CACHE_ENABLED,
			ESFMatchResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByResultUserId",
			new String[] { Long.class.getName() },
			ESFMatchResultModelImpl.ESFPARTECIPANTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESULTUSERID = new FinderPath(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByResultUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f match results where esfPartecipantId = &#63;.
	 *
	 * @param esfPartecipantId the esf partecipant ID
	 * @return the matching e s f match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchResult> findByResultUserId(long esfPartecipantId)
		throws SystemException {
		return findByResultUserId(esfPartecipantId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f match results where esfPartecipantId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfPartecipantId the esf partecipant ID
	 * @param start the lower bound of the range of e s f match results
	 * @param end the upper bound of the range of e s f match results (not inclusive)
	 * @return the range of matching e s f match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchResult> findByResultUserId(long esfPartecipantId,
		int start, int end) throws SystemException {
		return findByResultUserId(esfPartecipantId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f match results where esfPartecipantId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfPartecipantId the esf partecipant ID
	 * @param start the lower bound of the range of e s f match results
	 * @param end the upper bound of the range of e s f match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchResult> findByResultUserId(long esfPartecipantId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTUSERID;
			finderArgs = new Object[] { esfPartecipantId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESULTUSERID;
			finderArgs = new Object[] {
					esfPartecipantId,
					
					start, end, orderByComparator
				};
		}

		List<ESFMatchResult> list = (List<ESFMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatchResult esfMatchResult : list) {
				if ((esfPartecipantId != esfMatchResult.getEsfPartecipantId())) {
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

			query.append(_SQL_SELECT_ESFMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_RESULTUSERID_ESFPARTECIPANTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfPartecipantId);

				if (!pagination) {
					list = (List<ESFMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatchResult>(list);
				}
				else {
					list = (List<ESFMatchResult>)QueryUtil.list(q,
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
	 * Returns the first e s f match result in the ordered set where esfPartecipantId = &#63;.
	 *
	 * @param esfPartecipantId the esf partecipant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match result
	 * @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult findByResultUserId_First(long esfPartecipantId,
		OrderByComparator orderByComparator)
		throws NoSuchMatchResultException, SystemException {
		ESFMatchResult esfMatchResult = fetchByResultUserId_First(esfPartecipantId,
				orderByComparator);

		if (esfMatchResult != null) {
			return esfMatchResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfPartecipantId=");
		msg.append(esfPartecipantId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f match result in the ordered set where esfPartecipantId = &#63;.
	 *
	 * @param esfPartecipantId the esf partecipant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult fetchByResultUserId_First(long esfPartecipantId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatchResult> list = findByResultUserId(esfPartecipantId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match result in the ordered set where esfPartecipantId = &#63;.
	 *
	 * @param esfPartecipantId the esf partecipant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match result
	 * @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult findByResultUserId_Last(long esfPartecipantId,
		OrderByComparator orderByComparator)
		throws NoSuchMatchResultException, SystemException {
		ESFMatchResult esfMatchResult = fetchByResultUserId_Last(esfPartecipantId,
				orderByComparator);

		if (esfMatchResult != null) {
			return esfMatchResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfPartecipantId=");
		msg.append(esfPartecipantId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f match result in the ordered set where esfPartecipantId = &#63;.
	 *
	 * @param esfPartecipantId the esf partecipant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult fetchByResultUserId_Last(long esfPartecipantId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByResultUserId(esfPartecipantId);

		if (count == 0) {
			return null;
		}

		List<ESFMatchResult> list = findByResultUserId(esfPartecipantId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f match results before and after the current e s f match result in the ordered set where esfPartecipantId = &#63;.
	 *
	 * @param esfMatchResultId the primary key of the current e s f match result
	 * @param esfPartecipantId the esf partecipant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match result
	 * @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult[] findByResultUserId_PrevAndNext(
		long esfMatchResultId, long esfPartecipantId,
		OrderByComparator orderByComparator)
		throws NoSuchMatchResultException, SystemException {
		ESFMatchResult esfMatchResult = findByPrimaryKey(esfMatchResultId);

		Session session = null;

		try {
			session = openSession();

			ESFMatchResult[] array = new ESFMatchResultImpl[3];

			array[0] = getByResultUserId_PrevAndNext(session, esfMatchResult,
					esfPartecipantId, orderByComparator, true);

			array[1] = esfMatchResult;

			array[2] = getByResultUserId_PrevAndNext(session, esfMatchResult,
					esfPartecipantId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFMatchResult getByResultUserId_PrevAndNext(Session session,
		ESFMatchResult esfMatchResult, long esfPartecipantId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCHRESULT_WHERE);

		query.append(_FINDER_COLUMN_RESULTUSERID_ESFPARTECIPANTID_2);

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
			query.append(ESFMatchResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfPartecipantId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatchResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatchResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f match results where esfPartecipantId = &#63; from the database.
	 *
	 * @param esfPartecipantId the esf partecipant ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByResultUserId(long esfPartecipantId)
		throws SystemException {
		for (ESFMatchResult esfMatchResult : findByResultUserId(
				esfPartecipantId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfMatchResult);
		}
	}

	/**
	 * Returns the number of e s f match results where esfPartecipantId = &#63;.
	 *
	 * @param esfPartecipantId the esf partecipant ID
	 * @return the number of matching e s f match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByResultUserId(long esfPartecipantId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESULTUSERID;

		Object[] finderArgs = new Object[] { esfPartecipantId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFMATCHRESULT_WHERE);

			query.append(_FINDER_COLUMN_RESULTUSERID_ESFPARTECIPANTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfPartecipantId);

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

	private static final String _FINDER_COLUMN_RESULTUSERID_ESFPARTECIPANTID_2 = "esfMatchResult.esfPartecipantId = ?";

	public ESFMatchResultPersistenceImpl() {
		setModelClass(ESFMatchResult.class);
	}

	/**
	 * Caches the e s f match result in the entity cache if it is enabled.
	 *
	 * @param esfMatchResult the e s f match result
	 */
	@Override
	public void cacheResult(ESFMatchResult esfMatchResult) {
		EntityCacheUtil.putResult(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultImpl.class, esfMatchResult.getPrimaryKey(),
			esfMatchResult);

		esfMatchResult.resetOriginalValues();
	}

	/**
	 * Caches the e s f match results in the entity cache if it is enabled.
	 *
	 * @param esfMatchResults the e s f match results
	 */
	@Override
	public void cacheResult(List<ESFMatchResult> esfMatchResults) {
		for (ESFMatchResult esfMatchResult : esfMatchResults) {
			if (EntityCacheUtil.getResult(
						ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
						ESFMatchResultImpl.class, esfMatchResult.getPrimaryKey()) == null) {
				cacheResult(esfMatchResult);
			}
			else {
				esfMatchResult.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f match results.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFMatchResultImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFMatchResultImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f match result.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFMatchResult esfMatchResult) {
		EntityCacheUtil.removeResult(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultImpl.class, esfMatchResult.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFMatchResult> esfMatchResults) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFMatchResult esfMatchResult : esfMatchResults) {
			EntityCacheUtil.removeResult(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
				ESFMatchResultImpl.class, esfMatchResult.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f match result with the primary key. Does not add the e s f match result to the database.
	 *
	 * @param esfMatchResultId the primary key for the new e s f match result
	 * @return the new e s f match result
	 */
	@Override
	public ESFMatchResult create(long esfMatchResultId) {
		ESFMatchResult esfMatchResult = new ESFMatchResultImpl();

		esfMatchResult.setNew(true);
		esfMatchResult.setPrimaryKey(esfMatchResultId);

		return esfMatchResult;
	}

	/**
	 * Removes the e s f match result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfMatchResultId the primary key of the e s f match result
	 * @return the e s f match result that was removed
	 * @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult remove(long esfMatchResultId)
		throws NoSuchMatchResultException, SystemException {
		return remove((Serializable)esfMatchResultId);
	}

	/**
	 * Removes the e s f match result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f match result
	 * @return the e s f match result that was removed
	 * @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult remove(Serializable primaryKey)
		throws NoSuchMatchResultException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFMatchResult esfMatchResult = (ESFMatchResult)session.get(ESFMatchResultImpl.class,
					primaryKey);

			if (esfMatchResult == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMatchResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfMatchResult);
		}
		catch (NoSuchMatchResultException nsee) {
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
	protected ESFMatchResult removeImpl(ESFMatchResult esfMatchResult)
		throws SystemException {
		esfMatchResult = toUnwrappedModel(esfMatchResult);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfMatchResult)) {
				esfMatchResult = (ESFMatchResult)session.get(ESFMatchResultImpl.class,
						esfMatchResult.getPrimaryKeyObj());
			}

			if (esfMatchResult != null) {
				session.delete(esfMatchResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfMatchResult != null) {
			clearCache(esfMatchResult);
		}

		return esfMatchResult;
	}

	@Override
	public ESFMatchResult updateImpl(
		it.ethica.esf.model.ESFMatchResult esfMatchResult)
		throws SystemException {
		esfMatchResult = toUnwrappedModel(esfMatchResult);

		boolean isNew = esfMatchResult.isNew();

		ESFMatchResultModelImpl esfMatchResultModelImpl = (ESFMatchResultModelImpl)esfMatchResult;

		Session session = null;

		try {
			session = openSession();

			if (esfMatchResult.isNew()) {
				session.save(esfMatchResult);

				esfMatchResult.setNew(false);
			}
			else {
				session.merge(esfMatchResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFMatchResultModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchResultModelImpl.getOriginalEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID,
					args);

				args = new Object[] { esfMatchResultModelImpl.getEsfMatchId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID,
					args);
			}

			if ((esfMatchResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchResultModelImpl.getOriginalEsfPartecipantId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESULTUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTUSERID,
					args);

				args = new Object[] {
						esfMatchResultModelImpl.getEsfPartecipantId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESULTUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESULTUSERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchResultImpl.class, esfMatchResult.getPrimaryKey(),
			esfMatchResult);

		return esfMatchResult;
	}

	protected ESFMatchResult toUnwrappedModel(ESFMatchResult esfMatchResult) {
		if (esfMatchResult instanceof ESFMatchResultImpl) {
			return esfMatchResult;
		}

		ESFMatchResultImpl esfMatchResultImpl = new ESFMatchResultImpl();

		esfMatchResultImpl.setNew(esfMatchResult.isNew());
		esfMatchResultImpl.setPrimaryKey(esfMatchResult.getPrimaryKey());

		esfMatchResultImpl.setEsfMatchResultId(esfMatchResult.getEsfMatchResultId());
		esfMatchResultImpl.setGroupId(esfMatchResult.getGroupId());
		esfMatchResultImpl.setCompanyId(esfMatchResult.getCompanyId());
		esfMatchResultImpl.setUserId(esfMatchResult.getUserId());
		esfMatchResultImpl.setUserName(esfMatchResult.getUserName());
		esfMatchResultImpl.setCreateDate(esfMatchResult.getCreateDate());
		esfMatchResultImpl.setModifiedDate(esfMatchResult.getModifiedDate());
		esfMatchResultImpl.setEsfMatchId(esfMatchResult.getEsfMatchId());
		esfMatchResultImpl.setEsfPartecipantId(esfMatchResult.getEsfPartecipantId());
		esfMatchResultImpl.setCardCode(esfMatchResult.getCardCode());
		esfMatchResultImpl.setGeneralClassPosition(esfMatchResult.getGeneralClassPosition());
		esfMatchResultImpl.setCategoryClassPosition(esfMatchResult.getCategoryClassPosition());
		esfMatchResultImpl.setCategoryName(esfMatchResult.getCategoryName());
		esfMatchResultImpl.setQualification(esfMatchResult.getQualification());
		esfMatchResultImpl.setFirst(esfMatchResult.getFirst());
		esfMatchResultImpl.setSecond(esfMatchResult.getSecond());
		esfMatchResultImpl.setThird(esfMatchResult.getThird());
		esfMatchResultImpl.setFourth(esfMatchResult.getFourth());
		esfMatchResultImpl.setFifth(esfMatchResult.getFifth());
		esfMatchResultImpl.setTotal(esfMatchResult.getTotal());
		esfMatchResultImpl.setFirstPlayOff(esfMatchResult.getFirstPlayOff());
		esfMatchResultImpl.setSecondPlayOff(esfMatchResult.getSecondPlayOff());
		esfMatchResultImpl.setThirdPlayOff(esfMatchResult.getThirdPlayOff());
		esfMatchResultImpl.setTotalAfterPlayOff(esfMatchResult.getTotalAfterPlayOff());
		esfMatchResultImpl.setNextFirstPlayOff(esfMatchResult.getNextFirstPlayOff());
		esfMatchResultImpl.setNextSecondPlayOff(esfMatchResult.getNextSecondPlayOff());
		esfMatchResultImpl.setNextTotalPlayOff(esfMatchResult.getNextTotalPlayOff());
		esfMatchResultImpl.setFiscalCode(esfMatchResult.getFiscalCode());

		return esfMatchResultImpl;
	}

	/**
	 * Returns the e s f match result with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f match result
	 * @return the e s f match result
	 * @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMatchResultException, SystemException {
		ESFMatchResult esfMatchResult = fetchByPrimaryKey(primaryKey);

		if (esfMatchResult == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMatchResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfMatchResult;
	}

	/**
	 * Returns the e s f match result with the primary key or throws a {@link it.ethica.esf.NoSuchMatchResultException} if it could not be found.
	 *
	 * @param esfMatchResultId the primary key of the e s f match result
	 * @return the e s f match result
	 * @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult findByPrimaryKey(long esfMatchResultId)
		throws NoSuchMatchResultException, SystemException {
		return findByPrimaryKey((Serializable)esfMatchResultId);
	}

	/**
	 * Returns the e s f match result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f match result
	 * @return the e s f match result, or <code>null</code> if a e s f match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFMatchResult esfMatchResult = (ESFMatchResult)EntityCacheUtil.getResult(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
				ESFMatchResultImpl.class, primaryKey);

		if (esfMatchResult == _nullESFMatchResult) {
			return null;
		}

		if (esfMatchResult == null) {
			Session session = null;

			try {
				session = openSession();

				esfMatchResult = (ESFMatchResult)session.get(ESFMatchResultImpl.class,
						primaryKey);

				if (esfMatchResult != null) {
					cacheResult(esfMatchResult);
				}
				else {
					EntityCacheUtil.putResult(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
						ESFMatchResultImpl.class, primaryKey,
						_nullESFMatchResult);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFMatchResultModelImpl.ENTITY_CACHE_ENABLED,
					ESFMatchResultImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfMatchResult;
	}

	/**
	 * Returns the e s f match result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfMatchResultId the primary key of the e s f match result
	 * @return the e s f match result, or <code>null</code> if a e s f match result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchResult fetchByPrimaryKey(long esfMatchResultId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfMatchResultId);
	}

	/**
	 * Returns all the e s f match results.
	 *
	 * @return the e s f match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchResult> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f match results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f match results
	 * @param end the upper bound of the range of e s f match results (not inclusive)
	 * @return the range of e s f match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchResult> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f match results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f match results
	 * @param end the upper bound of the range of e s f match results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f match results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchResult> findAll(int start, int end,
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

		List<ESFMatchResult> list = (List<ESFMatchResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFMATCHRESULT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFMATCHRESULT;

				if (pagination) {
					sql = sql.concat(ESFMatchResultModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFMatchResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatchResult>(list);
				}
				else {
					list = (List<ESFMatchResult>)QueryUtil.list(q,
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
	 * Removes all the e s f match results from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFMatchResult esfMatchResult : findAll()) {
			remove(esfMatchResult);
		}
	}

	/**
	 * Returns the number of e s f match results.
	 *
	 * @return the number of e s f match results
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

				Query q = session.createQuery(_SQL_COUNT_ESFMATCHRESULT);

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
	 * Initializes the e s f match result persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFMatchResult")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFMatchResult>> listenersList = new ArrayList<ModelListener<ESFMatchResult>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFMatchResult>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFMatchResultImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFMATCHRESULT = "SELECT esfMatchResult FROM ESFMatchResult esfMatchResult";
	private static final String _SQL_SELECT_ESFMATCHRESULT_WHERE = "SELECT esfMatchResult FROM ESFMatchResult esfMatchResult WHERE ";
	private static final String _SQL_COUNT_ESFMATCHRESULT = "SELECT COUNT(esfMatchResult) FROM ESFMatchResult esfMatchResult";
	private static final String _SQL_COUNT_ESFMATCHRESULT_WHERE = "SELECT COUNT(esfMatchResult) FROM ESFMatchResult esfMatchResult WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfMatchResult.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFMatchResult exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFMatchResult exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFMatchResultPersistenceImpl.class);
	private static ESFMatchResult _nullESFMatchResult = new ESFMatchResultImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFMatchResult> toCacheModel() {
				return _nullESFMatchResultCacheModel;
			}
		};

	private static CacheModel<ESFMatchResult> _nullESFMatchResultCacheModel = new CacheModel<ESFMatchResult>() {
			@Override
			public ESFMatchResult toEntityModel() {
				return _nullESFMatchResult;
			}
		};
}