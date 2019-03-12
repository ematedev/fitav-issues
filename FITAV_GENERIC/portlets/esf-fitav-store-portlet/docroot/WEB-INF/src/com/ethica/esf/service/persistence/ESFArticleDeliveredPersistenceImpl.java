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

package com.ethica.esf.service.persistence;

import com.ethica.esf.NoSuchArticleDeliveredException;
import com.ethica.esf.model.ESFArticleDelivered;
import com.ethica.esf.model.impl.ESFArticleDeliveredImpl;
import com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f article delivered service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFArticleDeliveredPersistence
 * @see ESFArticleDeliveredUtil
 * @generated
 */
public class ESFArticleDeliveredPersistenceImpl extends BasePersistenceImpl<ESFArticleDelivered>
	implements ESFArticleDeliveredPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFArticleDeliveredUtil} to access the e s f article delivered persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFArticleDeliveredImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredModelImpl.FINDER_CACHE_ENABLED,
			ESFArticleDeliveredImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredModelImpl.FINDER_CACHE_ENABLED,
			ESFArticleDeliveredImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFARTICLEID =
		new FinderPath(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredModelImpl.FINDER_CACHE_ENABLED,
			ESFArticleDeliveredImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfArticleId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFARTICLEID =
		new FinderPath(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredModelImpl.FINDER_CACHE_ENABLED,
			ESFArticleDeliveredImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEsfArticleId",
			new String[] { Long.class.getName() },
			ESFArticleDeliveredModelImpl.ESFARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFARTICLEID = new FinderPath(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEsfArticleId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f article delivereds where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @return the matching e s f article delivereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleDelivered> findByEsfArticleId(long esfArticleId)
		throws SystemException {
		return findByEsfArticleId(esfArticleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f article delivereds where esfArticleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfArticleId the esf article ID
	 * @param start the lower bound of the range of e s f article delivereds
	 * @param end the upper bound of the range of e s f article delivereds (not inclusive)
	 * @return the range of matching e s f article delivereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleDelivered> findByEsfArticleId(long esfArticleId,
		int start, int end) throws SystemException {
		return findByEsfArticleId(esfArticleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f article delivereds where esfArticleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfArticleId the esf article ID
	 * @param start the lower bound of the range of e s f article delivereds
	 * @param end the upper bound of the range of e s f article delivereds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f article delivereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleDelivered> findByEsfArticleId(long esfArticleId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFARTICLEID;
			finderArgs = new Object[] { esfArticleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFARTICLEID;
			finderArgs = new Object[] {
					esfArticleId,
					
					start, end, orderByComparator
				};
		}

		List<ESFArticleDelivered> list = (List<ESFArticleDelivered>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFArticleDelivered esfArticleDelivered : list) {
				if ((esfArticleId != esfArticleDelivered.getEsfArticleId())) {
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

			query.append(_SQL_SELECT_ESFARTICLEDELIVERED_WHERE);

			query.append(_FINDER_COLUMN_ESFARTICLEID_ESFARTICLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFArticleDeliveredModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfArticleId);

				if (!pagination) {
					list = (List<ESFArticleDelivered>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticleDelivered>(list);
				}
				else {
					list = (List<ESFArticleDelivered>)QueryUtil.list(q,
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
	 * Returns the first e s f article delivered in the ordered set where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article delivered
	 * @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered findByEsfArticleId_First(long esfArticleId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleDeliveredException, SystemException {
		ESFArticleDelivered esfArticleDelivered = fetchByEsfArticleId_First(esfArticleId,
				orderByComparator);

		if (esfArticleDelivered != null) {
			return esfArticleDelivered;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfArticleId=");
		msg.append(esfArticleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleDeliveredException(msg.toString());
	}

	/**
	 * Returns the first e s f article delivered in the ordered set where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered fetchByEsfArticleId_First(long esfArticleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFArticleDelivered> list = findByEsfArticleId(esfArticleId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f article delivered in the ordered set where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article delivered
	 * @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered findByEsfArticleId_Last(long esfArticleId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleDeliveredException, SystemException {
		ESFArticleDelivered esfArticleDelivered = fetchByEsfArticleId_Last(esfArticleId,
				orderByComparator);

		if (esfArticleDelivered != null) {
			return esfArticleDelivered;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfArticleId=");
		msg.append(esfArticleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleDeliveredException(msg.toString());
	}

	/**
	 * Returns the last e s f article delivered in the ordered set where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered fetchByEsfArticleId_Last(long esfArticleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfArticleId(esfArticleId);

		if (count == 0) {
			return null;
		}

		List<ESFArticleDelivered> list = findByEsfArticleId(esfArticleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f article delivereds before and after the current e s f article delivered in the ordered set where esfArticleId = &#63;.
	 *
	 * @param esfArticleDeliveredId the primary key of the current e s f article delivered
	 * @param esfArticleId the esf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f article delivered
	 * @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered[] findByEsfArticleId_PrevAndNext(
		long esfArticleDeliveredId, long esfArticleId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleDeliveredException, SystemException {
		ESFArticleDelivered esfArticleDelivered = findByPrimaryKey(esfArticleDeliveredId);

		Session session = null;

		try {
			session = openSession();

			ESFArticleDelivered[] array = new ESFArticleDeliveredImpl[3];

			array[0] = getByEsfArticleId_PrevAndNext(session,
					esfArticleDelivered, esfArticleId, orderByComparator, true);

			array[1] = esfArticleDelivered;

			array[2] = getByEsfArticleId_PrevAndNext(session,
					esfArticleDelivered, esfArticleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFArticleDelivered getByEsfArticleId_PrevAndNext(
		Session session, ESFArticleDelivered esfArticleDelivered,
		long esfArticleId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFARTICLEDELIVERED_WHERE);

		query.append(_FINDER_COLUMN_ESFARTICLEID_ESFARTICLEID_2);

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
			query.append(ESFArticleDeliveredModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfArticleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfArticleDelivered);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFArticleDelivered> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f article delivereds where esfArticleId = &#63; from the database.
	 *
	 * @param esfArticleId the esf article ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfArticleId(long esfArticleId)
		throws SystemException {
		for (ESFArticleDelivered esfArticleDelivered : findByEsfArticleId(
				esfArticleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfArticleDelivered);
		}
	}

	/**
	 * Returns the number of e s f article delivereds where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @return the number of matching e s f article delivereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfArticleId(long esfArticleId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFARTICLEID;

		Object[] finderArgs = new Object[] { esfArticleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFARTICLEDELIVERED_WHERE);

			query.append(_FINDER_COLUMN_ESFARTICLEID_ESFARTICLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfArticleId);

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

	private static final String _FINDER_COLUMN_ESFARTICLEID_ESFARTICLEID_2 = "esfArticleDelivered.esfArticleId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFSHOOTERID =
		new FinderPath(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredModelImpl.FINDER_CACHE_ENABLED,
			ESFArticleDeliveredImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEsfShooterId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSHOOTERID =
		new FinderPath(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredModelImpl.FINDER_CACHE_ENABLED,
			ESFArticleDeliveredImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEsfShooterId",
			new String[] { Long.class.getName() },
			ESFArticleDeliveredModelImpl.ESFSHOOTERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFSHOOTERID = new FinderPath(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEsfShooterId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f article delivereds where esfShooterId = &#63;.
	 *
	 * @param esfShooterId the esf shooter ID
	 * @return the matching e s f article delivereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleDelivered> findByEsfShooterId(long esfShooterId)
		throws SystemException {
		return findByEsfShooterId(esfShooterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f article delivereds where esfShooterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfShooterId the esf shooter ID
	 * @param start the lower bound of the range of e s f article delivereds
	 * @param end the upper bound of the range of e s f article delivereds (not inclusive)
	 * @return the range of matching e s f article delivereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleDelivered> findByEsfShooterId(long esfShooterId,
		int start, int end) throws SystemException {
		return findByEsfShooterId(esfShooterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f article delivereds where esfShooterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfShooterId the esf shooter ID
	 * @param start the lower bound of the range of e s f article delivereds
	 * @param end the upper bound of the range of e s f article delivereds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f article delivereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleDelivered> findByEsfShooterId(long esfShooterId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSHOOTERID;
			finderArgs = new Object[] { esfShooterId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFSHOOTERID;
			finderArgs = new Object[] {
					esfShooterId,
					
					start, end, orderByComparator
				};
		}

		List<ESFArticleDelivered> list = (List<ESFArticleDelivered>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFArticleDelivered esfArticleDelivered : list) {
				if ((esfShooterId != esfArticleDelivered.getEsfShooterId())) {
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

			query.append(_SQL_SELECT_ESFARTICLEDELIVERED_WHERE);

			query.append(_FINDER_COLUMN_ESFSHOOTERID_ESFSHOOTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFArticleDeliveredModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfShooterId);

				if (!pagination) {
					list = (List<ESFArticleDelivered>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticleDelivered>(list);
				}
				else {
					list = (List<ESFArticleDelivered>)QueryUtil.list(q,
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
	 * Returns the first e s f article delivered in the ordered set where esfShooterId = &#63;.
	 *
	 * @param esfShooterId the esf shooter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article delivered
	 * @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered findByEsfShooterId_First(long esfShooterId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleDeliveredException, SystemException {
		ESFArticleDelivered esfArticleDelivered = fetchByEsfShooterId_First(esfShooterId,
				orderByComparator);

		if (esfArticleDelivered != null) {
			return esfArticleDelivered;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfShooterId=");
		msg.append(esfShooterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleDeliveredException(msg.toString());
	}

	/**
	 * Returns the first e s f article delivered in the ordered set where esfShooterId = &#63;.
	 *
	 * @param esfShooterId the esf shooter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered fetchByEsfShooterId_First(long esfShooterId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFArticleDelivered> list = findByEsfShooterId(esfShooterId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f article delivered in the ordered set where esfShooterId = &#63;.
	 *
	 * @param esfShooterId the esf shooter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article delivered
	 * @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered findByEsfShooterId_Last(long esfShooterId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleDeliveredException, SystemException {
		ESFArticleDelivered esfArticleDelivered = fetchByEsfShooterId_Last(esfShooterId,
				orderByComparator);

		if (esfArticleDelivered != null) {
			return esfArticleDelivered;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfShooterId=");
		msg.append(esfShooterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleDeliveredException(msg.toString());
	}

	/**
	 * Returns the last e s f article delivered in the ordered set where esfShooterId = &#63;.
	 *
	 * @param esfShooterId the esf shooter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered fetchByEsfShooterId_Last(long esfShooterId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEsfShooterId(esfShooterId);

		if (count == 0) {
			return null;
		}

		List<ESFArticleDelivered> list = findByEsfShooterId(esfShooterId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f article delivereds before and after the current e s f article delivered in the ordered set where esfShooterId = &#63;.
	 *
	 * @param esfArticleDeliveredId the primary key of the current e s f article delivered
	 * @param esfShooterId the esf shooter ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f article delivered
	 * @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered[] findByEsfShooterId_PrevAndNext(
		long esfArticleDeliveredId, long esfShooterId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleDeliveredException, SystemException {
		ESFArticleDelivered esfArticleDelivered = findByPrimaryKey(esfArticleDeliveredId);

		Session session = null;

		try {
			session = openSession();

			ESFArticleDelivered[] array = new ESFArticleDeliveredImpl[3];

			array[0] = getByEsfShooterId_PrevAndNext(session,
					esfArticleDelivered, esfShooterId, orderByComparator, true);

			array[1] = esfArticleDelivered;

			array[2] = getByEsfShooterId_PrevAndNext(session,
					esfArticleDelivered, esfShooterId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFArticleDelivered getByEsfShooterId_PrevAndNext(
		Session session, ESFArticleDelivered esfArticleDelivered,
		long esfShooterId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFARTICLEDELIVERED_WHERE);

		query.append(_FINDER_COLUMN_ESFSHOOTERID_ESFSHOOTERID_2);

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
			query.append(ESFArticleDeliveredModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfShooterId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfArticleDelivered);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFArticleDelivered> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f article delivereds where esfShooterId = &#63; from the database.
	 *
	 * @param esfShooterId the esf shooter ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEsfShooterId(long esfShooterId)
		throws SystemException {
		for (ESFArticleDelivered esfArticleDelivered : findByEsfShooterId(
				esfShooterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfArticleDelivered);
		}
	}

	/**
	 * Returns the number of e s f article delivereds where esfShooterId = &#63;.
	 *
	 * @param esfShooterId the esf shooter ID
	 * @return the number of matching e s f article delivereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEsfShooterId(long esfShooterId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFSHOOTERID;

		Object[] finderArgs = new Object[] { esfShooterId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFARTICLEDELIVERED_WHERE);

			query.append(_FINDER_COLUMN_ESFSHOOTERID_ESFSHOOTERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfShooterId);

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

	private static final String _FINDER_COLUMN_ESFSHOOTERID_ESFSHOOTERID_2 = "esfArticleDelivered.esfShooterId = ?";

	public ESFArticleDeliveredPersistenceImpl() {
		setModelClass(ESFArticleDelivered.class);
	}

	/**
	 * Caches the e s f article delivered in the entity cache if it is enabled.
	 *
	 * @param esfArticleDelivered the e s f article delivered
	 */
	@Override
	public void cacheResult(ESFArticleDelivered esfArticleDelivered) {
		EntityCacheUtil.putResult(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredImpl.class, esfArticleDelivered.getPrimaryKey(),
			esfArticleDelivered);

		esfArticleDelivered.resetOriginalValues();
	}

	/**
	 * Caches the e s f article delivereds in the entity cache if it is enabled.
	 *
	 * @param esfArticleDelivereds the e s f article delivereds
	 */
	@Override
	public void cacheResult(List<ESFArticleDelivered> esfArticleDelivereds) {
		for (ESFArticleDelivered esfArticleDelivered : esfArticleDelivereds) {
			if (EntityCacheUtil.getResult(
						ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
						ESFArticleDeliveredImpl.class,
						esfArticleDelivered.getPrimaryKey()) == null) {
				cacheResult(esfArticleDelivered);
			}
			else {
				esfArticleDelivered.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f article delivereds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFArticleDeliveredImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFArticleDeliveredImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f article delivered.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFArticleDelivered esfArticleDelivered) {
		EntityCacheUtil.removeResult(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredImpl.class, esfArticleDelivered.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFArticleDelivered> esfArticleDelivereds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFArticleDelivered esfArticleDelivered : esfArticleDelivereds) {
			EntityCacheUtil.removeResult(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
				ESFArticleDeliveredImpl.class,
				esfArticleDelivered.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f article delivered with the primary key. Does not add the e s f article delivered to the database.
	 *
	 * @param esfArticleDeliveredId the primary key for the new e s f article delivered
	 * @return the new e s f article delivered
	 */
	@Override
	public ESFArticleDelivered create(long esfArticleDeliveredId) {
		ESFArticleDelivered esfArticleDelivered = new ESFArticleDeliveredImpl();

		esfArticleDelivered.setNew(true);
		esfArticleDelivered.setPrimaryKey(esfArticleDeliveredId);

		return esfArticleDelivered;
	}

	/**
	 * Removes the e s f article delivered with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfArticleDeliveredId the primary key of the e s f article delivered
	 * @return the e s f article delivered that was removed
	 * @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered remove(long esfArticleDeliveredId)
		throws NoSuchArticleDeliveredException, SystemException {
		return remove((Serializable)esfArticleDeliveredId);
	}

	/**
	 * Removes the e s f article delivered with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f article delivered
	 * @return the e s f article delivered that was removed
	 * @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered remove(Serializable primaryKey)
		throws NoSuchArticleDeliveredException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFArticleDelivered esfArticleDelivered = (ESFArticleDelivered)session.get(ESFArticleDeliveredImpl.class,
					primaryKey);

			if (esfArticleDelivered == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleDeliveredException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfArticleDelivered);
		}
		catch (NoSuchArticleDeliveredException nsee) {
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
	protected ESFArticleDelivered removeImpl(
		ESFArticleDelivered esfArticleDelivered) throws SystemException {
		esfArticleDelivered = toUnwrappedModel(esfArticleDelivered);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfArticleDelivered)) {
				esfArticleDelivered = (ESFArticleDelivered)session.get(ESFArticleDeliveredImpl.class,
						esfArticleDelivered.getPrimaryKeyObj());
			}

			if (esfArticleDelivered != null) {
				session.delete(esfArticleDelivered);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfArticleDelivered != null) {
			clearCache(esfArticleDelivered);
		}

		return esfArticleDelivered;
	}

	@Override
	public ESFArticleDelivered updateImpl(
		com.ethica.esf.model.ESFArticleDelivered esfArticleDelivered)
		throws SystemException {
		esfArticleDelivered = toUnwrappedModel(esfArticleDelivered);

		boolean isNew = esfArticleDelivered.isNew();

		ESFArticleDeliveredModelImpl esfArticleDeliveredModelImpl = (ESFArticleDeliveredModelImpl)esfArticleDelivered;

		Session session = null;

		try {
			session = openSession();

			if (esfArticleDelivered.isNew()) {
				session.save(esfArticleDelivered);

				esfArticleDelivered.setNew(false);
			}
			else {
				session.merge(esfArticleDelivered);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFArticleDeliveredModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfArticleDeliveredModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFARTICLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfArticleDeliveredModelImpl.getOriginalEsfArticleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFARTICLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFARTICLEID,
					args);

				args = new Object[] {
						esfArticleDeliveredModelImpl.getEsfArticleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFARTICLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFARTICLEID,
					args);
			}

			if ((esfArticleDeliveredModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSHOOTERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfArticleDeliveredModelImpl.getOriginalEsfShooterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSHOOTERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSHOOTERID,
					args);

				args = new Object[] {
						esfArticleDeliveredModelImpl.getEsfShooterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSHOOTERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSHOOTERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleDeliveredImpl.class, esfArticleDelivered.getPrimaryKey(),
			esfArticleDelivered);

		return esfArticleDelivered;
	}

	protected ESFArticleDelivered toUnwrappedModel(
		ESFArticleDelivered esfArticleDelivered) {
		if (esfArticleDelivered instanceof ESFArticleDeliveredImpl) {
			return esfArticleDelivered;
		}

		ESFArticleDeliveredImpl esfArticleDeliveredImpl = new ESFArticleDeliveredImpl();

		esfArticleDeliveredImpl.setNew(esfArticleDelivered.isNew());
		esfArticleDeliveredImpl.setPrimaryKey(esfArticleDelivered.getPrimaryKey());

		esfArticleDeliveredImpl.setEsfArticleDeliveredId(esfArticleDelivered.getEsfArticleDeliveredId());
		esfArticleDeliveredImpl.setData(esfArticleDelivered.getData());
		esfArticleDeliveredImpl.setDescription(esfArticleDelivered.getDescription());
		esfArticleDeliveredImpl.setEsfArticleId(esfArticleDelivered.getEsfArticleId());
		esfArticleDeliveredImpl.setEsfShooterId(esfArticleDelivered.getEsfShooterId());
		esfArticleDeliveredImpl.setXxxlQty(esfArticleDelivered.getXxxlQty());
		esfArticleDeliveredImpl.setXxlQty(esfArticleDelivered.getXxlQty());
		esfArticleDeliveredImpl.setXlQty(esfArticleDelivered.getXlQty());
		esfArticleDeliveredImpl.setLQty(esfArticleDelivered.getLQty());
		esfArticleDeliveredImpl.setMQty(esfArticleDelivered.getMQty());
		esfArticleDeliveredImpl.setSQty(esfArticleDelivered.getSQty());
		esfArticleDeliveredImpl.setXsQty(esfArticleDelivered.getXsQty());
		esfArticleDeliveredImpl.setXxsQty(esfArticleDelivered.getXxsQty());
		esfArticleDeliveredImpl.setOtherQty(esfArticleDelivered.getOtherQty());

		return esfArticleDeliveredImpl;
	}

	/**
	 * Returns the e s f article delivered with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f article delivered
	 * @return the e s f article delivered
	 * @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleDeliveredException, SystemException {
		ESFArticleDelivered esfArticleDelivered = fetchByPrimaryKey(primaryKey);

		if (esfArticleDelivered == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleDeliveredException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfArticleDelivered;
	}

	/**
	 * Returns the e s f article delivered with the primary key or throws a {@link com.ethica.esf.NoSuchArticleDeliveredException} if it could not be found.
	 *
	 * @param esfArticleDeliveredId the primary key of the e s f article delivered
	 * @return the e s f article delivered
	 * @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered findByPrimaryKey(long esfArticleDeliveredId)
		throws NoSuchArticleDeliveredException, SystemException {
		return findByPrimaryKey((Serializable)esfArticleDeliveredId);
	}

	/**
	 * Returns the e s f article delivered with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f article delivered
	 * @return the e s f article delivered, or <code>null</code> if a e s f article delivered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFArticleDelivered esfArticleDelivered = (ESFArticleDelivered)EntityCacheUtil.getResult(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
				ESFArticleDeliveredImpl.class, primaryKey);

		if (esfArticleDelivered == _nullESFArticleDelivered) {
			return null;
		}

		if (esfArticleDelivered == null) {
			Session session = null;

			try {
				session = openSession();

				esfArticleDelivered = (ESFArticleDelivered)session.get(ESFArticleDeliveredImpl.class,
						primaryKey);

				if (esfArticleDelivered != null) {
					cacheResult(esfArticleDelivered);
				}
				else {
					EntityCacheUtil.putResult(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
						ESFArticleDeliveredImpl.class, primaryKey,
						_nullESFArticleDelivered);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFArticleDeliveredModelImpl.ENTITY_CACHE_ENABLED,
					ESFArticleDeliveredImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfArticleDelivered;
	}

	/**
	 * Returns the e s f article delivered with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfArticleDeliveredId the primary key of the e s f article delivered
	 * @return the e s f article delivered, or <code>null</code> if a e s f article delivered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleDelivered fetchByPrimaryKey(long esfArticleDeliveredId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfArticleDeliveredId);
	}

	/**
	 * Returns all the e s f article delivereds.
	 *
	 * @return the e s f article delivereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleDelivered> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f article delivereds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f article delivereds
	 * @param end the upper bound of the range of e s f article delivereds (not inclusive)
	 * @return the range of e s f article delivereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleDelivered> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f article delivereds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f article delivereds
	 * @param end the upper bound of the range of e s f article delivereds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f article delivereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleDelivered> findAll(int start, int end,
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

		List<ESFArticleDelivered> list = (List<ESFArticleDelivered>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFARTICLEDELIVERED);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFARTICLEDELIVERED;

				if (pagination) {
					sql = sql.concat(ESFArticleDeliveredModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFArticleDelivered>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticleDelivered>(list);
				}
				else {
					list = (List<ESFArticleDelivered>)QueryUtil.list(q,
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
	 * Removes all the e s f article delivereds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFArticleDelivered esfArticleDelivered : findAll()) {
			remove(esfArticleDelivered);
		}
	}

	/**
	 * Returns the number of e s f article delivereds.
	 *
	 * @return the number of e s f article delivereds
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

				Query q = session.createQuery(_SQL_COUNT_ESFARTICLEDELIVERED);

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
	 * Initializes the e s f article delivered persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ethica.esf.model.ESFArticleDelivered")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFArticleDelivered>> listenersList = new ArrayList<ModelListener<ESFArticleDelivered>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFArticleDelivered>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFArticleDeliveredImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFARTICLEDELIVERED = "SELECT esfArticleDelivered FROM ESFArticleDelivered esfArticleDelivered";
	private static final String _SQL_SELECT_ESFARTICLEDELIVERED_WHERE = "SELECT esfArticleDelivered FROM ESFArticleDelivered esfArticleDelivered WHERE ";
	private static final String _SQL_COUNT_ESFARTICLEDELIVERED = "SELECT COUNT(esfArticleDelivered) FROM ESFArticleDelivered esfArticleDelivered";
	private static final String _SQL_COUNT_ESFARTICLEDELIVERED_WHERE = "SELECT COUNT(esfArticleDelivered) FROM ESFArticleDelivered esfArticleDelivered WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfArticleDelivered.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFArticleDelivered exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFArticleDelivered exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFArticleDeliveredPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"data"
			});
	private static ESFArticleDelivered _nullESFArticleDelivered = new ESFArticleDeliveredImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFArticleDelivered> toCacheModel() {
				return _nullESFArticleDeliveredCacheModel;
			}
		};

	private static CacheModel<ESFArticleDelivered> _nullESFArticleDeliveredCacheModel =
		new CacheModel<ESFArticleDelivered>() {
			@Override
			public ESFArticleDelivered toEntityModel() {
				return _nullESFArticleDelivered;
			}
		};
}