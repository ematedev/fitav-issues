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

import it.ethica.esf.NoSuchResultException;
import it.ethica.esf.model.ESFResult;
import it.ethica.esf.model.impl.ESFResultImpl;
import it.ethica.esf.model.impl.ESFResultModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFResultPersistence
 * @see ESFResultUtil
 * @generated
 */
public class ESFResultPersistenceImpl extends BasePersistenceImpl<ESFResult>
	implements ESFResultPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFResultUtil} to access the e s f result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFResultImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMATCHID =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFMatchId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFMatchId",
			new String[] { Long.class.getName() },
			ESFResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFResultModelImpl.DESCGROUPRANKING_COLUMN_BITMASK |
			ESFResultModelImpl.POSITION_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERQUALIFICATION_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMATCHID = new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFMatchId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f results where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMatchId(long esfMatchId)
		throws SystemException {
		return findByESFMatchId(esfMatchId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f results where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @return the range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMatchId(long esfMatchId, int start, int end)
		throws SystemException {
		return findByESFMatchId(esfMatchId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f results where esfMatchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMatchId(long esfMatchId, int start,
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

		List<ESFResult> list = (List<ESFResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFResult esfResult : list) {
				if ((esfMatchId != esfResult.getEsfMatchId())) {
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

			query.append(_SQL_SELECT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMATCHID_ESFMATCHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				if (!pagination) {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFResult>(list);
				}
				else {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMatchId_First(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMatchId_First(esfMatchId,
				orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMatchId_First(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFResult> list = findByESFMatchId(esfMatchId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMatchId_Last(long esfMatchId,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMatchId_Last(esfMatchId,
				orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMatchId_Last(long esfMatchId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMatchId(esfMatchId);

		if (count == 0) {
			return null;
		}

		List<ESFResult> list = findByESFMatchId(esfMatchId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63;.
	 *
	 * @param esfResultId the primary key of the current e s f result
	 * @param esfMatchId the esf match ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult[] findByESFMatchId_PrevAndNext(long esfResultId,
		long esfMatchId, OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = findByPrimaryKey(esfResultId);

		Session session = null;

		try {
			session = openSession();

			ESFResult[] array = new ESFResultImpl[3];

			array[0] = getByESFMatchId_PrevAndNext(session, esfResult,
					esfMatchId, orderByComparator, true);

			array[1] = esfResult;

			array[2] = getByESFMatchId_PrevAndNext(session, esfResult,
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

	protected ESFResult getByESFMatchId_PrevAndNext(Session session,
		ESFResult esfResult, long esfMatchId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRESULT_WHERE);

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
			query.append(ESFResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f results where esfMatchId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMatchId(long esfMatchId) throws SystemException {
		for (ESFResult esfResult : findByESFMatchId(esfMatchId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfResult);
		}
	}

	/**
	 * Returns the number of e s f results where esfMatchId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @return the number of matching e s f results
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

			query.append(_SQL_COUNT_ESFRESULT_WHERE);

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

	private static final String _FINDER_COLUMN_ESFMATCHID_ESFMATCHID_2 = "esfResult.esfMatchId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFSHOOTERID =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFShooterId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSHOOTERID =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFShooterId",
			new String[] { Long.class.getName() },
			ESFResultModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFResultModelImpl.DESCGROUPRANKING_COLUMN_BITMASK |
			ESFResultModelImpl.POSITION_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERQUALIFICATION_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFSHOOTERID = new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFShooterId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f results where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFShooterId(long esfUserId)
		throws SystemException {
		return findByESFShooterId(esfUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f results where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @return the range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFShooterId(long esfUserId, int start, int end)
		throws SystemException {
		return findByESFShooterId(esfUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f results where esfUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfUserId the esf user ID
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFShooterId(long esfUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSHOOTERID;
			finderArgs = new Object[] { esfUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFSHOOTERID;
			finderArgs = new Object[] { esfUserId, start, end, orderByComparator };
		}

		List<ESFResult> list = (List<ESFResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFResult esfResult : list) {
				if ((esfUserId != esfResult.getEsfUserId())) {
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

			query.append(_SQL_SELECT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFSHOOTERID_ESFUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfUserId);

				if (!pagination) {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFResult>(list);
				}
				else {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFShooterId_First(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFShooterId_First(esfUserId,
				orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFShooterId_First(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFResult> list = findByESFShooterId(esfUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFShooterId_Last(long esfUserId,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFShooterId_Last(esfUserId,
				orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfUserId=");
		msg.append(esfUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFShooterId_Last(long esfUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFShooterId(esfUserId);

		if (count == 0) {
			return null;
		}

		List<ESFResult> list = findByESFShooterId(esfUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f results before and after the current e s f result in the ordered set where esfUserId = &#63;.
	 *
	 * @param esfResultId the primary key of the current e s f result
	 * @param esfUserId the esf user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult[] findByESFShooterId_PrevAndNext(long esfResultId,
		long esfUserId, OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = findByPrimaryKey(esfResultId);

		Session session = null;

		try {
			session = openSession();

			ESFResult[] array = new ESFResultImpl[3];

			array[0] = getByESFShooterId_PrevAndNext(session, esfResult,
					esfUserId, orderByComparator, true);

			array[1] = esfResult;

			array[2] = getByESFShooterId_PrevAndNext(session, esfResult,
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

	protected ESFResult getByESFShooterId_PrevAndNext(Session session,
		ESFResult esfResult, long esfUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFSHOOTERID_ESFUSERID_2);

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
			query.append(ESFResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f results where esfUserId = &#63; from the database.
	 *
	 * @param esfUserId the esf user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFShooterId(long esfUserId) throws SystemException {
		for (ESFResult esfResult : findByESFShooterId(esfUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfResult);
		}
	}

	/**
	 * Returns the number of e s f results where esfUserId = &#63;.
	 *
	 * @param esfUserId the esf user ID
	 * @return the number of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFShooterId(long esfUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFSHOOTERID;

		Object[] finderArgs = new Object[] { esfUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFSHOOTERID_ESFUSERID_2);

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

	private static final String _FINDER_COLUMN_ESFSHOOTERID_ESFUSERID_2 = "esfResult.esfUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMID_UID_STID =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFMId_UId_STId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_UID_STID =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFMId_UId_STId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ESFResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFResultModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFResultModelImpl.ESFMATCHTYPEID_COLUMN_BITMASK |
			ESFResultModelImpl.DESCGROUPRANKING_COLUMN_BITMASK |
			ESFResultModelImpl.POSITION_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERQUALIFICATION_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMID_UID_STID = new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMId_UId_STId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @return the matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_UId_STId(long esfMatchId,
		long esfUserId, long esfMatchTypeId) throws SystemException {
		return findByESFMId_UId_STId(esfMatchId, esfUserId, esfMatchTypeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @return the range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_UId_STId(long esfMatchId,
		long esfUserId, long esfMatchTypeId, int start, int end)
		throws SystemException {
		return findByESFMId_UId_STId(esfMatchId, esfUserId, esfMatchTypeId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_UId_STId(long esfMatchId,
		long esfUserId, long esfMatchTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_UID_STID;
			finderArgs = new Object[] { esfMatchId, esfUserId, esfMatchTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMID_UID_STID;
			finderArgs = new Object[] {
					esfMatchId, esfUserId, esfMatchTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFResult> list = (List<ESFResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFResult esfResult : list) {
				if ((esfMatchId != esfResult.getEsfMatchId()) ||
						(esfUserId != esfResult.getEsfUserId()) ||
						(esfMatchTypeId != esfResult.getEsfMatchTypeId())) {
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

			query.append(_SQL_SELECT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_ESFUSERID_2);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_ESFMATCHTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfUserId);

				qPos.add(esfMatchTypeId);

				if (!pagination) {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFResult>(list);
				}
				else {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMId_UId_STId_First(long esfMatchId,
		long esfUserId, long esfMatchTypeId, OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMId_UId_STId_First(esfMatchId,
				esfUserId, esfMatchTypeId, orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(", esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMId_UId_STId_First(long esfMatchId,
		long esfUserId, long esfMatchTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFResult> list = findByESFMId_UId_STId(esfMatchId, esfUserId,
				esfMatchTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMId_UId_STId_Last(long esfMatchId,
		long esfUserId, long esfMatchTypeId, OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMId_UId_STId_Last(esfMatchId,
				esfUserId, esfMatchTypeId, orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(", esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMId_UId_STId_Last(long esfMatchId,
		long esfUserId, long esfMatchTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByESFMId_UId_STId(esfMatchId, esfUserId, esfMatchTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFResult> list = findByESFMId_UId_STId(esfMatchId, esfUserId,
				esfMatchTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	 *
	 * @param esfResultId the primary key of the current e s f result
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult[] findByESFMId_UId_STId_PrevAndNext(long esfResultId,
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = findByPrimaryKey(esfResultId);

		Session session = null;

		try {
			session = openSession();

			ESFResult[] array = new ESFResultImpl[3];

			array[0] = getByESFMId_UId_STId_PrevAndNext(session, esfResult,
					esfMatchId, esfUserId, esfMatchTypeId, orderByComparator,
					true);

			array[1] = esfResult;

			array[2] = getByESFMId_UId_STId_PrevAndNext(session, esfResult,
					esfMatchId, esfUserId, esfMatchTypeId, orderByComparator,
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

	protected ESFResult getByESFMId_UId_STId_PrevAndNext(Session session,
		ESFResult esfResult, long esfMatchId, long esfUserId,
		long esfMatchTypeId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFMID_UID_STID_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMID_UID_STID_ESFUSERID_2);

		query.append(_FINDER_COLUMN_ESFMID_UID_STID_ESFMATCHTYPEID_2);

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
			query.append(ESFResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfUserId);

		qPos.add(esfMatchTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMId_UId_STId(long esfMatchId, long esfUserId,
		long esfMatchTypeId) throws SystemException {
		for (ESFResult esfResult : findByESFMId_UId_STId(esfMatchId, esfUserId,
				esfMatchTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfResult);
		}
	}

	/**
	 * Returns the number of e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @return the number of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMId_UId_STId(long esfMatchId, long esfUserId,
		long esfMatchTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMID_UID_STID;

		Object[] finderArgs = new Object[] { esfMatchId, esfUserId, esfMatchTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_ESFUSERID_2);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_ESFMATCHTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfUserId);

				qPos.add(esfMatchTypeId);

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

	private static final String _FINDER_COLUMN_ESFMID_UID_STID_ESFMATCHID_2 = "esfResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMID_UID_STID_ESFUSERID_2 = "esfResult.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMID_UID_STID_ESFMATCHTYPEID_2 = "esfResult.esfMatchTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMID_UID_STID_SINGLE =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFMId_UId_STId_Single",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_UID_STID_SINGLE =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMId_UId_STId_Single",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			ESFResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFResultModelImpl.ESFUSERID_COLUMN_BITMASK |
			ESFResultModelImpl.ESFMATCHTYPEID_COLUMN_BITMASK |
			ESFResultModelImpl.RESULTCLASSTEAM_COLUMN_BITMASK |
			ESFResultModelImpl.DESCGROUPRANKING_COLUMN_BITMASK |
			ESFResultModelImpl.POSITION_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERQUALIFICATION_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMID_UID_STID_SINGLE = new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMId_UId_STId_Single",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param resultClassTeam the result class team
	 * @return the matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_UId_STId_Single(long esfMatchId,
		long esfUserId, long esfMatchTypeId, int resultClassTeam)
		throws SystemException {
		return findByESFMId_UId_STId_Single(esfMatchId, esfUserId,
			esfMatchTypeId, resultClassTeam, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param resultClassTeam the result class team
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @return the range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_UId_STId_Single(long esfMatchId,
		long esfUserId, long esfMatchTypeId, int resultClassTeam, int start,
		int end) throws SystemException {
		return findByESFMId_UId_STId_Single(esfMatchId, esfUserId,
			esfMatchTypeId, resultClassTeam, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param resultClassTeam the result class team
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_UId_STId_Single(long esfMatchId,
		long esfUserId, long esfMatchTypeId, int resultClassTeam, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_UID_STID_SINGLE;
			finderArgs = new Object[] {
					esfMatchId, esfUserId, esfMatchTypeId, resultClassTeam
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMID_UID_STID_SINGLE;
			finderArgs = new Object[] {
					esfMatchId, esfUserId, esfMatchTypeId, resultClassTeam,
					
					start, end, orderByComparator
				};
		}

		List<ESFResult> list = (List<ESFResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFResult esfResult : list) {
				if ((esfMatchId != esfResult.getEsfMatchId()) ||
						(esfUserId != esfResult.getEsfUserId()) ||
						(esfMatchTypeId != esfResult.getEsfMatchTypeId()) ||
						(resultClassTeam != esfResult.getResultClassTeam())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFUSERID_2);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFMATCHTYPEID_2);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_RESULTCLASSTEAM_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfUserId);

				qPos.add(esfMatchTypeId);

				qPos.add(resultClassTeam);

				if (!pagination) {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFResult>(list);
				}
				else {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param resultClassTeam the result class team
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMId_UId_STId_Single_First(long esfMatchId,
		long esfUserId, long esfMatchTypeId, int resultClassTeam,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMId_UId_STId_Single_First(esfMatchId,
				esfUserId, esfMatchTypeId, resultClassTeam, orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(", esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(", resultClassTeam=");
		msg.append(resultClassTeam);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param resultClassTeam the result class team
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMId_UId_STId_Single_First(long esfMatchId,
		long esfUserId, long esfMatchTypeId, int resultClassTeam,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFResult> list = findByESFMId_UId_STId_Single(esfMatchId,
				esfUserId, esfMatchTypeId, resultClassTeam, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param resultClassTeam the result class team
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMId_UId_STId_Single_Last(long esfMatchId,
		long esfUserId, long esfMatchTypeId, int resultClassTeam,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMId_UId_STId_Single_Last(esfMatchId,
				esfUserId, esfMatchTypeId, resultClassTeam, orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfUserId=");
		msg.append(esfUserId);

		msg.append(", esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(", resultClassTeam=");
		msg.append(resultClassTeam);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param resultClassTeam the result class team
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMId_UId_STId_Single_Last(long esfMatchId,
		long esfUserId, long esfMatchTypeId, int resultClassTeam,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMId_UId_STId_Single(esfMatchId, esfUserId,
				esfMatchTypeId, resultClassTeam);

		if (count == 0) {
			return null;
		}

		List<ESFResult> list = findByESFMId_UId_STId_Single(esfMatchId,
				esfUserId, esfMatchTypeId, resultClassTeam, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	 *
	 * @param esfResultId the primary key of the current e s f result
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param resultClassTeam the result class team
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult[] findByESFMId_UId_STId_Single_PrevAndNext(
		long esfResultId, long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam, OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = findByPrimaryKey(esfResultId);

		Session session = null;

		try {
			session = openSession();

			ESFResult[] array = new ESFResultImpl[3];

			array[0] = getByESFMId_UId_STId_Single_PrevAndNext(session,
					esfResult, esfMatchId, esfUserId, esfMatchTypeId,
					resultClassTeam, orderByComparator, true);

			array[1] = esfResult;

			array[2] = getByESFMId_UId_STId_Single_PrevAndNext(session,
					esfResult, esfMatchId, esfUserId, esfMatchTypeId,
					resultClassTeam, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFResult getByESFMId_UId_STId_Single_PrevAndNext(
		Session session, ESFResult esfResult, long esfMatchId, long esfUserId,
		long esfMatchTypeId, int resultClassTeam,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFUSERID_2);

		query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFMATCHTYPEID_2);

		query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_RESULTCLASSTEAM_2);

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
			query.append(ESFResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfUserId);

		qPos.add(esfMatchTypeId);

		qPos.add(resultClassTeam);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param resultClassTeam the result class team
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMId_UId_STId_Single(long esfMatchId, long esfUserId,
		long esfMatchTypeId, int resultClassTeam) throws SystemException {
		for (ESFResult esfResult : findByESFMId_UId_STId_Single(esfMatchId,
				esfUserId, esfMatchTypeId, resultClassTeam, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfResult);
		}
	}

	/**
	 * Returns the number of e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfUserId the esf user ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param resultClassTeam the result class team
	 * @return the number of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMId_UId_STId_Single(long esfMatchId, long esfUserId,
		long esfMatchTypeId, int resultClassTeam) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMID_UID_STID_SINGLE;

		Object[] finderArgs = new Object[] {
				esfMatchId, esfUserId, esfMatchTypeId, resultClassTeam
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFUSERID_2);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFMATCHTYPEID_2);

			query.append(_FINDER_COLUMN_ESFMID_UID_STID_SINGLE_RESULTCLASSTEAM_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfUserId);

				qPos.add(esfMatchTypeId);

				qPos.add(resultClassTeam);

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

	private static final String _FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFMATCHID_2 =
		"esfResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFUSERID_2 =
		"esfResult.esfUserId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMID_UID_STID_SINGLE_ESFMATCHTYPEID_2 =
		"esfResult.esfMatchTypeId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMID_UID_STID_SINGLE_RESULTCLASSTEAM_2 =
		"esfResult.resultClassTeam = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMID_STID_SQID =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFMId_STId_SQId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMId_STId_SQId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ESFResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFResultModelImpl.ESFMATCHTYPEID_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERQUALIFICATION_COLUMN_BITMASK |
			ESFResultModelImpl.DESCGROUPRANKING_COLUMN_BITMASK |
			ESFResultModelImpl.POSITION_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMID_STID_SQID = new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMId_STId_SQId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @return the matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_STId_SQId(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws SystemException {
		return findByESFMId_STId_SQId(esfMatchId, esfMatchTypeId,
			shooterQualification, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @return the range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_STId_SQId(long esfMatchId,
		long esfMatchTypeId, long shooterQualification, int start, int end)
		throws SystemException {
		return findByESFMId_STId_SQId(esfMatchId, esfMatchTypeId,
			shooterQualification, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_STId_SQId(long esfMatchId,
		long esfMatchTypeId, long shooterQualification, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID;
			finderArgs = new Object[] {
					esfMatchId, esfMatchTypeId, shooterQualification
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMID_STID_SQID;
			finderArgs = new Object[] {
					esfMatchId, esfMatchTypeId, shooterQualification,
					
					start, end, orderByComparator
				};
		}

		List<ESFResult> list = (List<ESFResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFResult esfResult : list) {
				if ((esfMatchId != esfResult.getEsfMatchId()) ||
						(esfMatchTypeId != esfResult.getEsfMatchTypeId()) ||
						(shooterQualification != esfResult.getShooterQualification())) {
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

			query.append(_SQL_SELECT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_ESFMATCHTYPEID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SHOOTERQUALIFICATION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfMatchTypeId);

				qPos.add(shooterQualification);

				if (!pagination) {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFResult>(list);
				}
				else {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMId_STId_SQId_First(long esfMatchId,
		long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMId_STId_SQId_First(esfMatchId,
				esfMatchTypeId, shooterQualification, orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(", shooterQualification=");
		msg.append(shooterQualification);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMId_STId_SQId_First(long esfMatchId,
		long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFResult> list = findByESFMId_STId_SQId(esfMatchId,
				esfMatchTypeId, shooterQualification, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMId_STId_SQId_Last(long esfMatchId,
		long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMId_STId_SQId_Last(esfMatchId,
				esfMatchTypeId, shooterQualification, orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(", shooterQualification=");
		msg.append(shooterQualification);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMId_STId_SQId_Last(long esfMatchId,
		long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMId_STId_SQId(esfMatchId, esfMatchTypeId,
				shooterQualification);

		if (count == 0) {
			return null;
		}

		List<ESFResult> list = findByESFMId_STId_SQId(esfMatchId,
				esfMatchTypeId, shooterQualification, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfResultId the primary key of the current e s f result
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult[] findByESFMId_STId_SQId_PrevAndNext(long esfResultId,
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = findByPrimaryKey(esfResultId);

		Session session = null;

		try {
			session = openSession();

			ESFResult[] array = new ESFResultImpl[3];

			array[0] = getByESFMId_STId_SQId_PrevAndNext(session, esfResult,
					esfMatchId, esfMatchTypeId, shooterQualification,
					orderByComparator, true);

			array[1] = esfResult;

			array[2] = getByESFMId_STId_SQId_PrevAndNext(session, esfResult,
					esfMatchId, esfMatchTypeId, shooterQualification,
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

	protected ESFResult getByESFMId_STId_SQId_PrevAndNext(Session session,
		ESFResult esfResult, long esfMatchId, long esfMatchTypeId,
		long shooterQualification, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFMID_STID_SQID_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMID_STID_SQID_ESFMATCHTYPEID_2);

		query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SHOOTERQUALIFICATION_2);

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
			query.append(ESFResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfMatchTypeId);

		qPos.add(shooterQualification);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMId_STId_SQId(long esfMatchId, long esfMatchTypeId,
		long shooterQualification) throws SystemException {
		for (ESFResult esfResult : findByESFMId_STId_SQId(esfMatchId,
				esfMatchTypeId, shooterQualification, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfResult);
		}
	}

	/**
	 * Returns the number of e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @return the number of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMId_STId_SQId(long esfMatchId, long esfMatchTypeId,
		long shooterQualification) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMID_STID_SQID;

		Object[] finderArgs = new Object[] {
				esfMatchId, esfMatchTypeId, shooterQualification
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_ESFMATCHTYPEID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SHOOTERQUALIFICATION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfMatchTypeId);

				qPos.add(shooterQualification);

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

	private static final String _FINDER_COLUMN_ESFMID_STID_SQID_ESFMATCHID_2 = "esfResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMID_STID_SQID_ESFMATCHTYPEID_2 =
		"esfResult.esfMatchTypeId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMID_STID_SQID_SHOOTERQUALIFICATION_2 =
		"esfResult.shooterQualification = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMID_STID_SQID_RESULTCLASSTEAM =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFMId_STId_SQId_ResultClassTeam",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID_RESULTCLASSTEAM =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMId_STId_SQId_ResultClassTeam",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ESFResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFResultModelImpl.ESFMATCHTYPEID_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERQUALIFICATION_COLUMN_BITMASK |
			ESFResultModelImpl.DESCGROUPRANKING_COLUMN_BITMASK |
			ESFResultModelImpl.POSITION_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMID_STID_SQID_RESULTCLASSTEAM =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMId_STId_SQId_ResultClassTeam",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @return the matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_STId_SQId_ResultClassTeam(
		long esfMatchId, long esfMatchTypeId, long shooterQualification)
		throws SystemException {
		return findByESFMId_STId_SQId_ResultClassTeam(esfMatchId,
			esfMatchTypeId, shooterQualification, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @return the range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_STId_SQId_ResultClassTeam(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end) throws SystemException {
		return findByESFMId_STId_SQId_ResultClassTeam(esfMatchId,
			esfMatchTypeId, shooterQualification, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_STId_SQId_ResultClassTeam(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID_RESULTCLASSTEAM;
			finderArgs = new Object[] {
					esfMatchId, esfMatchTypeId, shooterQualification
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMID_STID_SQID_RESULTCLASSTEAM;
			finderArgs = new Object[] {
					esfMatchId, esfMatchTypeId, shooterQualification,
					
					start, end, orderByComparator
				};
		}

		List<ESFResult> list = (List<ESFResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFResult esfResult : list) {
				if ((esfMatchId != esfResult.getEsfMatchId()) ||
						(esfMatchTypeId != esfResult.getEsfMatchTypeId()) ||
						(shooterQualification != esfResult.getShooterQualification())) {
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

			query.append(_SQL_SELECT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_ESFMATCHTYPEID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_SHOOTERQUALIFICATION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfMatchTypeId);

				qPos.add(shooterQualification);

				if (!pagination) {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFResult>(list);
				}
				else {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMId_STId_SQId_ResultClassTeam_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMId_STId_SQId_ResultClassTeam_First(esfMatchId,
				esfMatchTypeId, shooterQualification, orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(", shooterQualification=");
		msg.append(shooterQualification);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMId_STId_SQId_ResultClassTeam_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFResult> list = findByESFMId_STId_SQId_ResultClassTeam(esfMatchId,
				esfMatchTypeId, shooterQualification, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMId_STId_SQId_ResultClassTeam_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMId_STId_SQId_ResultClassTeam_Last(esfMatchId,
				esfMatchTypeId, shooterQualification, orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(", shooterQualification=");
		msg.append(shooterQualification);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMId_STId_SQId_ResultClassTeam_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMId_STId_SQId_ResultClassTeam(esfMatchId,
				esfMatchTypeId, shooterQualification);

		if (count == 0) {
			return null;
		}

		List<ESFResult> list = findByESFMId_STId_SQId_ResultClassTeam(esfMatchId,
				esfMatchTypeId, shooterQualification, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfResultId the primary key of the current e s f result
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult[] findByESFMId_STId_SQId_ResultClassTeam_PrevAndNext(
		long esfResultId, long esfMatchId, long esfMatchTypeId,
		long shooterQualification, OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = findByPrimaryKey(esfResultId);

		Session session = null;

		try {
			session = openSession();

			ESFResult[] array = new ESFResultImpl[3];

			array[0] = getByESFMId_STId_SQId_ResultClassTeam_PrevAndNext(session,
					esfResult, esfMatchId, esfMatchTypeId,
					shooterQualification, orderByComparator, true);

			array[1] = esfResult;

			array[2] = getByESFMId_STId_SQId_ResultClassTeam_PrevAndNext(session,
					esfResult, esfMatchId, esfMatchTypeId,
					shooterQualification, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFResult getByESFMId_STId_SQId_ResultClassTeam_PrevAndNext(
		Session session, ESFResult esfResult, long esfMatchId,
		long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_ESFMATCHTYPEID_2);

		query.append(_FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_SHOOTERQUALIFICATION_2);

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
			query.append(ESFResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfMatchTypeId);

		qPos.add(shooterQualification);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMId_STId_SQId_ResultClassTeam(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws SystemException {
		for (ESFResult esfResult : findByESFMId_STId_SQId_ResultClassTeam(
				esfMatchId, esfMatchTypeId, shooterQualification,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfResult);
		}
	}

	/**
	 * Returns the number of e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @return the number of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMId_STId_SQId_ResultClassTeam(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMID_STID_SQID_RESULTCLASSTEAM;

		Object[] finderArgs = new Object[] {
				esfMatchId, esfMatchTypeId, shooterQualification
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_ESFMATCHTYPEID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_SHOOTERQUALIFICATION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfMatchTypeId);

				qPos.add(shooterQualification);

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

	private static final String _FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_ESFMATCHID_2 =
		"esfResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_ESFMATCHTYPEID_2 =
		"esfResult.esfMatchTypeId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMID_STID_SQID_RESULTCLASSTEAM_SHOOTERQUALIFICATION_2 =
		"esfResult.shooterQualification = ? AND esfResult.resultClassTeam!=0";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMID_STID_SQID_SINGLE =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByESFMId_STId_SQId_Single",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID_SINGLE =
		new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, ESFResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByESFMId_STId_SQId_Single",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ESFResultModelImpl.ESFMATCHID_COLUMN_BITMASK |
			ESFResultModelImpl.ESFMATCHTYPEID_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERQUALIFICATION_COLUMN_BITMASK |
			ESFResultModelImpl.DESCGROUPRANKING_COLUMN_BITMASK |
			ESFResultModelImpl.POSITION_COLUMN_BITMASK |
			ESFResultModelImpl.SHOOTERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFMID_STID_SQID_SINGLE = new FinderPath(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByESFMId_STId_SQId_Single",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @return the matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_STId_SQId_Single(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws SystemException {
		return findByESFMId_STId_SQId_Single(esfMatchId, esfMatchTypeId,
			shooterQualification, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @return the range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_STId_SQId_Single(long esfMatchId,
		long esfMatchTypeId, long shooterQualification, int start, int end)
		throws SystemException {
		return findByESFMId_STId_SQId_Single(esfMatchId, esfMatchTypeId,
			shooterQualification, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findByESFMId_STId_SQId_Single(long esfMatchId,
		long esfMatchTypeId, long shooterQualification, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID_SINGLE;
			finderArgs = new Object[] {
					esfMatchId, esfMatchTypeId, shooterQualification
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFMID_STID_SQID_SINGLE;
			finderArgs = new Object[] {
					esfMatchId, esfMatchTypeId, shooterQualification,
					
					start, end, orderByComparator
				};
		}

		List<ESFResult> list = (List<ESFResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFResult esfResult : list) {
				if ((esfMatchId != esfResult.getEsfMatchId()) ||
						(esfMatchTypeId != esfResult.getEsfMatchTypeId()) ||
						(shooterQualification != esfResult.getShooterQualification())) {
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

			query.append(_SQL_SELECT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_ESFMATCHTYPEID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_SHOOTERQUALIFICATION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfMatchTypeId);

				qPos.add(shooterQualification);

				if (!pagination) {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFResult>(list);
				}
				else {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMId_STId_SQId_Single_First(long esfMatchId,
		long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMId_STId_SQId_Single_First(esfMatchId,
				esfMatchTypeId, shooterQualification, orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(", shooterQualification=");
		msg.append(shooterQualification);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMId_STId_SQId_Single_First(long esfMatchId,
		long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFResult> list = findByESFMId_STId_SQId_Single(esfMatchId,
				esfMatchTypeId, shooterQualification, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByESFMId_STId_SQId_Single_Last(long esfMatchId,
		long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByESFMId_STId_SQId_Single_Last(esfMatchId,
				esfMatchTypeId, shooterQualification, orderByComparator);

		if (esfResult != null) {
			return esfResult;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfMatchId=");
		msg.append(esfMatchId);

		msg.append(", esfMatchTypeId=");
		msg.append(esfMatchTypeId);

		msg.append(", shooterQualification=");
		msg.append(shooterQualification);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResultException(msg.toString());
	}

	/**
	 * Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByESFMId_STId_SQId_Single_Last(long esfMatchId,
		long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFMId_STId_SQId_Single(esfMatchId, esfMatchTypeId,
				shooterQualification);

		if (count == 0) {
			return null;
		}

		List<ESFResult> list = findByESFMId_STId_SQId_Single(esfMatchId,
				esfMatchTypeId, shooterQualification, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfResultId the primary key of the current e s f result
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult[] findByESFMId_STId_SQId_Single_PrevAndNext(
		long esfResultId, long esfMatchId, long esfMatchTypeId,
		long shooterQualification, OrderByComparator orderByComparator)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = findByPrimaryKey(esfResultId);

		Session session = null;

		try {
			session = openSession();

			ESFResult[] array = new ESFResultImpl[3];

			array[0] = getByESFMId_STId_SQId_Single_PrevAndNext(session,
					esfResult, esfMatchId, esfMatchTypeId,
					shooterQualification, orderByComparator, true);

			array[1] = esfResult;

			array[2] = getByESFMId_STId_SQId_Single_PrevAndNext(session,
					esfResult, esfMatchId, esfMatchTypeId,
					shooterQualification, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFResult getByESFMId_STId_SQId_Single_PrevAndNext(
		Session session, ESFResult esfResult, long esfMatchId,
		long esfMatchTypeId, long shooterQualification,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFRESULT_WHERE);

		query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_ESFMATCHID_2);

		query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_ESFMATCHTYPEID_2);

		query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_SHOOTERQUALIFICATION_2);

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
			query.append(ESFResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfMatchId);

		qPos.add(esfMatchTypeId);

		qPos.add(shooterQualification);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63; from the database.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFMId_STId_SQId_Single(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws SystemException {
		for (ESFResult esfResult : findByESFMId_STId_SQId_Single(esfMatchId,
				esfMatchTypeId, shooterQualification, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfResult);
		}
	}

	/**
	 * Returns the number of e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	 *
	 * @param esfMatchId the esf match ID
	 * @param esfMatchTypeId the esf match type ID
	 * @param shooterQualification the shooter qualification
	 * @return the number of matching e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFMId_STId_SQId_Single(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFMID_STID_SQID_SINGLE;

		Object[] finderArgs = new Object[] {
				esfMatchId, esfMatchTypeId, shooterQualification
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ESFRESULT_WHERE);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_ESFMATCHID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_ESFMATCHTYPEID_2);

			query.append(_FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_SHOOTERQUALIFICATION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfMatchId);

				qPos.add(esfMatchTypeId);

				qPos.add(shooterQualification);

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

	private static final String _FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_ESFMATCHID_2 =
		"esfResult.esfMatchId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_ESFMATCHTYPEID_2 =
		"esfResult.esfMatchTypeId = ? AND ";
	private static final String _FINDER_COLUMN_ESFMID_STID_SQID_SINGLE_SHOOTERQUALIFICATION_2 =
		"esfResult.shooterQualification = ? AND esfResult.resultClassTeam=0";

	public ESFResultPersistenceImpl() {
		setModelClass(ESFResult.class);
	}

	/**
	 * Caches the e s f result in the entity cache if it is enabled.
	 *
	 * @param esfResult the e s f result
	 */
	@Override
	public void cacheResult(ESFResult esfResult) {
		EntityCacheUtil.putResult(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultImpl.class, esfResult.getPrimaryKey(), esfResult);

		esfResult.resetOriginalValues();
	}

	/**
	 * Caches the e s f results in the entity cache if it is enabled.
	 *
	 * @param esfResults the e s f results
	 */
	@Override
	public void cacheResult(List<ESFResult> esfResults) {
		for (ESFResult esfResult : esfResults) {
			if (EntityCacheUtil.getResult(
						ESFResultModelImpl.ENTITY_CACHE_ENABLED,
						ESFResultImpl.class, esfResult.getPrimaryKey()) == null) {
				cacheResult(esfResult);
			}
			else {
				esfResult.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f results.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFResultImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFResultImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f result.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFResult esfResult) {
		EntityCacheUtil.removeResult(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultImpl.class, esfResult.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFResult> esfResults) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFResult esfResult : esfResults) {
			EntityCacheUtil.removeResult(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
				ESFResultImpl.class, esfResult.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f result with the primary key. Does not add the e s f result to the database.
	 *
	 * @param esfResultId the primary key for the new e s f result
	 * @return the new e s f result
	 */
	@Override
	public ESFResult create(long esfResultId) {
		ESFResult esfResult = new ESFResultImpl();

		esfResult.setNew(true);
		esfResult.setPrimaryKey(esfResultId);

		return esfResult;
	}

	/**
	 * Removes the e s f result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfResultId the primary key of the e s f result
	 * @return the e s f result that was removed
	 * @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult remove(long esfResultId)
		throws NoSuchResultException, SystemException {
		return remove((Serializable)esfResultId);
	}

	/**
	 * Removes the e s f result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f result
	 * @return the e s f result that was removed
	 * @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult remove(Serializable primaryKey)
		throws NoSuchResultException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFResult esfResult = (ESFResult)session.get(ESFResultImpl.class,
					primaryKey);

			if (esfResult == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfResult);
		}
		catch (NoSuchResultException nsee) {
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
	protected ESFResult removeImpl(ESFResult esfResult)
		throws SystemException {
		esfResult = toUnwrappedModel(esfResult);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfResult)) {
				esfResult = (ESFResult)session.get(ESFResultImpl.class,
						esfResult.getPrimaryKeyObj());
			}

			if (esfResult != null) {
				session.delete(esfResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfResult != null) {
			clearCache(esfResult);
		}

		return esfResult;
	}

	@Override
	public ESFResult updateImpl(it.ethica.esf.model.ESFResult esfResult)
		throws SystemException {
		esfResult = toUnwrappedModel(esfResult);

		boolean isNew = esfResult.isNew();

		ESFResultModelImpl esfResultModelImpl = (ESFResultModelImpl)esfResult;

		Session session = null;

		try {
			session = openSession();

			if (esfResult.isNew()) {
				session.save(esfResult);

				esfResult.setNew(false);
			}
			else {
				session.merge(esfResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFResultModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfResultModelImpl.getOriginalEsfMatchId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID,
					args);

				args = new Object[] { esfResultModelImpl.getEsfMatchId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMATCHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMATCHID,
					args);
			}

			if ((esfResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSHOOTERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfResultModelImpl.getOriginalEsfUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSHOOTERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSHOOTERID,
					args);

				args = new Object[] { esfResultModelImpl.getEsfUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSHOOTERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSHOOTERID,
					args);
			}

			if ((esfResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_UID_STID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfResultModelImpl.getOriginalEsfMatchId(),
						esfResultModelImpl.getOriginalEsfUserId(),
						esfResultModelImpl.getOriginalEsfMatchTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMID_UID_STID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_UID_STID,
					args);

				args = new Object[] {
						esfResultModelImpl.getEsfMatchId(),
						esfResultModelImpl.getEsfUserId(),
						esfResultModelImpl.getEsfMatchTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMID_UID_STID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_UID_STID,
					args);
			}

			if ((esfResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_UID_STID_SINGLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfResultModelImpl.getOriginalEsfMatchId(),
						esfResultModelImpl.getOriginalEsfUserId(),
						esfResultModelImpl.getOriginalEsfMatchTypeId(),
						esfResultModelImpl.getOriginalResultClassTeam()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMID_UID_STID_SINGLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_UID_STID_SINGLE,
					args);

				args = new Object[] {
						esfResultModelImpl.getEsfMatchId(),
						esfResultModelImpl.getEsfUserId(),
						esfResultModelImpl.getEsfMatchTypeId(),
						esfResultModelImpl.getResultClassTeam()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMID_UID_STID_SINGLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_UID_STID_SINGLE,
					args);
			}

			if ((esfResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfResultModelImpl.getOriginalEsfMatchId(),
						esfResultModelImpl.getOriginalEsfMatchTypeId(),
						esfResultModelImpl.getOriginalShooterQualification()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMID_STID_SQID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID,
					args);

				args = new Object[] {
						esfResultModelImpl.getEsfMatchId(),
						esfResultModelImpl.getEsfMatchTypeId(),
						esfResultModelImpl.getShooterQualification()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMID_STID_SQID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID,
					args);
			}

			if ((esfResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID_RESULTCLASSTEAM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfResultModelImpl.getOriginalEsfMatchId(),
						esfResultModelImpl.getOriginalEsfMatchTypeId(),
						esfResultModelImpl.getOriginalShooterQualification()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMID_STID_SQID_RESULTCLASSTEAM,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID_RESULTCLASSTEAM,
					args);

				args = new Object[] {
						esfResultModelImpl.getEsfMatchId(),
						esfResultModelImpl.getEsfMatchTypeId(),
						esfResultModelImpl.getShooterQualification()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMID_STID_SQID_RESULTCLASSTEAM,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID_RESULTCLASSTEAM,
					args);
			}

			if ((esfResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID_SINGLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfResultModelImpl.getOriginalEsfMatchId(),
						esfResultModelImpl.getOriginalEsfMatchTypeId(),
						esfResultModelImpl.getOriginalShooterQualification()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMID_STID_SQID_SINGLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID_SINGLE,
					args);

				args = new Object[] {
						esfResultModelImpl.getEsfMatchId(),
						esfResultModelImpl.getEsfMatchTypeId(),
						esfResultModelImpl.getShooterQualification()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFMID_STID_SQID_SINGLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFMID_STID_SQID_SINGLE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
			ESFResultImpl.class, esfResult.getPrimaryKey(), esfResult);

		return esfResult;
	}

	protected ESFResult toUnwrappedModel(ESFResult esfResult) {
		if (esfResult instanceof ESFResultImpl) {
			return esfResult;
		}

		ESFResultImpl esfResultImpl = new ESFResultImpl();

		esfResultImpl.setNew(esfResult.isNew());
		esfResultImpl.setPrimaryKey(esfResult.getPrimaryKey());

		esfResultImpl.setEsfResultId(esfResult.getEsfResultId());
		esfResultImpl.setGroupId(esfResult.getGroupId());
		esfResultImpl.setCompanyId(esfResult.getCompanyId());
		esfResultImpl.setUserId(esfResult.getUserId());
		esfResultImpl.setUserName(esfResult.getUserName());
		esfResultImpl.setCreateDate(esfResult.getCreateDate());
		esfResultImpl.setModifiedDate(esfResult.getModifiedDate());
		esfResultImpl.setMatchYear(esfResult.getMatchYear());
		esfResultImpl.setNumberMatch(esfResult.getNumberMatch());
		esfResultImpl.setEsfMatchId(esfResult.getEsfMatchId());
		esfResultImpl.setName(esfResult.getName());
		esfResultImpl.setName2(esfResult.getName2());
		esfResultImpl.setEsfAssociationId(esfResult.getEsfAssociationId());
		esfResultImpl.setSportTypeCode(esfResult.getSportTypeCode());
		esfResultImpl.setStartdDate(esfResult.getStartdDate());
		esfResultImpl.setEndDate(esfResult.getEndDate());
		esfResultImpl.setGroupRanking(esfResult.getGroupRanking());
		esfResultImpl.setDescGroupRanking(esfResult.getDescGroupRanking());
		esfResultImpl.setPosition(esfResult.getPosition());
		esfResultImpl.setCardNumber(esfResult.getCardNumber());
		esfResultImpl.setShooterName(esfResult.getShooterName());
		esfResultImpl.setNationCode(esfResult.getNationCode());
		esfResultImpl.setCategory(esfResult.getCategory());
		esfResultImpl.setQualificationCode(esfResult.getQualificationCode());
		esfResultImpl.setResultS1(esfResult.getResultS1());
		esfResultImpl.setResultS2(esfResult.getResultS2());
		esfResultImpl.setResultS3(esfResult.getResultS3());
		esfResultImpl.setResultS4(esfResult.getResultS4());
		esfResultImpl.setResultS5(esfResult.getResultS5());
		esfResultImpl.setResultS6(esfResult.getResultS6());
		esfResultImpl.setResultS7(esfResult.getResultS7());
		esfResultImpl.setResultS8(esfResult.getResultS8());
		esfResultImpl.setTotalS(esfResult.getTotalS());
		esfResultImpl.setBarrage(esfResult.getBarrage());
		esfResultImpl.setFinalS(esfResult.getFinalS());
		esfResultImpl.setFinalTotal(esfResult.getFinalTotal());
		esfResultImpl.setAmerican1(esfResult.getAmerican1());
		esfResultImpl.setAmerican2(esfResult.getAmerican2());
		esfResultImpl.setAmerican3(esfResult.getAmerican3());
		esfResultImpl.setRifle(esfResult.getRifle());
		esfResultImpl.setCaliber(esfResult.getCaliber());
		esfResultImpl.setCatridge(esfResult.getCatridge());
		esfResultImpl.setFinalType(esfResult.getFinalType());
		esfResultImpl.setSemifinalResult(esfResult.getSemifinalResult());
		esfResultImpl.setShootOff1s(esfResult.getShootOff1s());
		esfResultImpl.setShootOff2s(esfResult.getShootOff2s());
		esfResultImpl.setShootOff3s(esfResult.getShootOff3s());
		esfResultImpl.setBronzeResult(esfResult.getBronzeResult());
		esfResultImpl.setShootOffBronze(esfResult.getShootOffBronze());
		esfResultImpl.setGoldResult(esfResult.getGoldResult());
		esfResultImpl.setShootOffGold(esfResult.getShootOffGold());
		esfResultImpl.setTeamCategory(esfResult.getTeamCategory());
		esfResultImpl.setTeamName(esfResult.getTeamName());
		esfResultImpl.setNaz_int(esfResult.getNaz_int());
		esfResultImpl.setShowTypeCode(esfResult.getShowTypeCode());
		esfResultImpl.setShowType(esfResult.getShowType());
		esfResultImpl.setEsfUserId(esfResult.getEsfUserId());
		esfResultImpl.setVariationDate(esfResult.getVariationDate());
		esfResultImpl.setSent(esfResult.getSent());
		esfResultImpl.setYouthQualification(esfResult.getYouthQualification());
		esfResultImpl.setEsfMatchTypeId(esfResult.getEsfMatchTypeId());
		esfResultImpl.setResultClassTeam(esfResult.getResultClassTeam());
		esfResultImpl.setSpare1(esfResult.getSpare1());
		esfResultImpl.setSpare2(esfResult.getSpare2());
		esfResultImpl.setShooterCode(esfResult.getShooterCode());
		esfResultImpl.setShooterQualification(esfResult.getShooterQualification());

		return esfResultImpl;
	}

	/**
	 * Returns the e s f result with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f result
	 * @return the e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResultException, SystemException {
		ESFResult esfResult = fetchByPrimaryKey(primaryKey);

		if (esfResult == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfResult;
	}

	/**
	 * Returns the e s f result with the primary key or throws a {@link it.ethica.esf.NoSuchResultException} if it could not be found.
	 *
	 * @param esfResultId the primary key of the e s f result
	 * @return the e s f result
	 * @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult findByPrimaryKey(long esfResultId)
		throws NoSuchResultException, SystemException {
		return findByPrimaryKey((Serializable)esfResultId);
	}

	/**
	 * Returns the e s f result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f result
	 * @return the e s f result, or <code>null</code> if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFResult esfResult = (ESFResult)EntityCacheUtil.getResult(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
				ESFResultImpl.class, primaryKey);

		if (esfResult == _nullESFResult) {
			return null;
		}

		if (esfResult == null) {
			Session session = null;

			try {
				session = openSession();

				esfResult = (ESFResult)session.get(ESFResultImpl.class,
						primaryKey);

				if (esfResult != null) {
					cacheResult(esfResult);
				}
				else {
					EntityCacheUtil.putResult(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
						ESFResultImpl.class, primaryKey, _nullESFResult);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFResultModelImpl.ENTITY_CACHE_ENABLED,
					ESFResultImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfResult;
	}

	/**
	 * Returns the e s f result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfResultId the primary key of the e s f result
	 * @return the e s f result, or <code>null</code> if a e s f result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFResult fetchByPrimaryKey(long esfResultId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfResultId);
	}

	/**
	 * Returns all the e s f results.
	 *
	 * @return the e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @return the range of e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f results
	 * @param end the upper bound of the range of e s f results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFResult> findAll(int start, int end,
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

		List<ESFResult> list = (List<ESFResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFRESULT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFRESULT;

				if (pagination) {
					sql = sql.concat(ESFResultModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFResult>(list);
				}
				else {
					list = (List<ESFResult>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f results from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFResult esfResult : findAll()) {
			remove(esfResult);
		}
	}

	/**
	 * Returns the number of e s f results.
	 *
	 * @return the number of e s f results
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

				Query q = session.createQuery(_SQL_COUNT_ESFRESULT);

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
	 * Initializes the e s f result persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFResult")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFResult>> listenersList = new ArrayList<ModelListener<ESFResult>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFResult>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFResultImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFRESULT = "SELECT esfResult FROM ESFResult esfResult";
	private static final String _SQL_SELECT_ESFRESULT_WHERE = "SELECT esfResult FROM ESFResult esfResult WHERE ";
	private static final String _SQL_COUNT_ESFRESULT = "SELECT COUNT(esfResult) FROM ESFResult esfResult";
	private static final String _SQL_COUNT_ESFRESULT_WHERE = "SELECT COUNT(esfResult) FROM ESFResult esfResult WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfResult.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFResult exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFResult exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFResultPersistenceImpl.class);
	private static ESFResult _nullESFResult = new ESFResultImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFResult> toCacheModel() {
				return _nullESFResultCacheModel;
			}
		};

	private static CacheModel<ESFResult> _nullESFResultCacheModel = new CacheModel<ESFResult>() {
			@Override
			public ESFResult toEntityModel() {
				return _nullESFResult;
			}
		};
}