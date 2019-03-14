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

import com.ethica.esf.NoSuchArticle_ESFOrderException;
import com.ethica.esf.model.ESFArticle_ESFOrder;
import com.ethica.esf.model.impl.ESFArticle_ESFOrderImpl;
import com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl;

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
 * The persistence implementation for the e s f article_ e s f order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFArticle_ESFOrderPersistence
 * @see ESFArticle_ESFOrderUtil
 * @generated
 */
public class ESFArticle_ESFOrderPersistenceImpl extends BasePersistenceImpl<ESFArticle_ESFOrder>
	implements ESFArticle_ESFOrderPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFArticle_ESFOrderUtil} to access the e s f article_ e s f order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFArticle_ESFOrderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFOrderModelImpl.FINDER_CACHE_ENABLED,
			ESFArticle_ESFOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFOrderModelImpl.FINDER_CACHE_ENABLED,
			ESFArticle_ESFOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFORDERID =
		new FinderPath(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFOrderModelImpl.FINDER_CACHE_ENABLED,
			ESFArticle_ESFOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFOrderId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORDERID =
		new FinderPath(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFOrderModelImpl.FINDER_CACHE_ENABLED,
			ESFArticle_ESFOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFOrderId",
			new String[] { Long.class.getName() },
			ESFArticle_ESFOrderModelImpl.ESFORDERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFORDERID = new FinderPath(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFOrderId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f article_ e s f orders where esfOrderId = &#63;.
	 *
	 * @param esfOrderId the esf order ID
	 * @return the matching e s f article_ e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFOrder> findByESFOrderId(long esfOrderId)
		throws SystemException {
		return findByESFOrderId(esfOrderId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f article_ e s f orders where esfOrderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrderId the esf order ID
	 * @param start the lower bound of the range of e s f article_ e s f orders
	 * @param end the upper bound of the range of e s f article_ e s f orders (not inclusive)
	 * @return the range of matching e s f article_ e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFOrder> findByESFOrderId(long esfOrderId,
		int start, int end) throws SystemException {
		return findByESFOrderId(esfOrderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f article_ e s f orders where esfOrderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfOrderId the esf order ID
	 * @param start the lower bound of the range of e s f article_ e s f orders
	 * @param end the upper bound of the range of e s f article_ e s f orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f article_ e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFOrder> findByESFOrderId(long esfOrderId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORDERID;
			finderArgs = new Object[] { esfOrderId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFORDERID;
			finderArgs = new Object[] { esfOrderId, start, end, orderByComparator };
		}

		List<ESFArticle_ESFOrder> list = (List<ESFArticle_ESFOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFArticle_ESFOrder esfArticle_ESFOrder : list) {
				if ((esfOrderId != esfArticle_ESFOrder.getEsfOrderId())) {
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

			query.append(_SQL_SELECT_ESFARTICLE_ESFORDER_WHERE);

			query.append(_FINDER_COLUMN_ESFORDERID_ESFORDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFArticle_ESFOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrderId);

				if (!pagination) {
					list = (List<ESFArticle_ESFOrder>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticle_ESFOrder>(list);
				}
				else {
					list = (List<ESFArticle_ESFOrder>)QueryUtil.list(q,
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
	 * Returns the first e s f article_ e s f order in the ordered set where esfOrderId = &#63;.
	 *
	 * @param esfOrderId the esf order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article_ e s f order
	 * @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a matching e s f article_ e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFOrder findByESFOrderId_First(long esfOrderId,
		OrderByComparator orderByComparator)
		throws NoSuchArticle_ESFOrderException, SystemException {
		ESFArticle_ESFOrder esfArticle_ESFOrder = fetchByESFOrderId_First(esfOrderId,
				orderByComparator);

		if (esfArticle_ESFOrder != null) {
			return esfArticle_ESFOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrderId=");
		msg.append(esfOrderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticle_ESFOrderException(msg.toString());
	}

	/**
	 * Returns the first e s f article_ e s f order in the ordered set where esfOrderId = &#63;.
	 *
	 * @param esfOrderId the esf order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article_ e s f order, or <code>null</code> if a matching e s f article_ e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFOrder fetchByESFOrderId_First(long esfOrderId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFArticle_ESFOrder> list = findByESFOrderId(esfOrderId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f article_ e s f order in the ordered set where esfOrderId = &#63;.
	 *
	 * @param esfOrderId the esf order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article_ e s f order
	 * @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a matching e s f article_ e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFOrder findByESFOrderId_Last(long esfOrderId,
		OrderByComparator orderByComparator)
		throws NoSuchArticle_ESFOrderException, SystemException {
		ESFArticle_ESFOrder esfArticle_ESFOrder = fetchByESFOrderId_Last(esfOrderId,
				orderByComparator);

		if (esfArticle_ESFOrder != null) {
			return esfArticle_ESFOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfOrderId=");
		msg.append(esfOrderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticle_ESFOrderException(msg.toString());
	}

	/**
	 * Returns the last e s f article_ e s f order in the ordered set where esfOrderId = &#63;.
	 *
	 * @param esfOrderId the esf order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article_ e s f order, or <code>null</code> if a matching e s f article_ e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFOrder fetchByESFOrderId_Last(long esfOrderId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFOrderId(esfOrderId);

		if (count == 0) {
			return null;
		}

		List<ESFArticle_ESFOrder> list = findByESFOrderId(esfOrderId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f article_ e s f orders before and after the current e s f article_ e s f order in the ordered set where esfOrderId = &#63;.
	 *
	 * @param esfArticle_ESFOrderPK the primary key of the current e s f article_ e s f order
	 * @param esfOrderId the esf order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f article_ e s f order
	 * @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a e s f article_ e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFOrder[] findByESFOrderId_PrevAndNext(
		ESFArticle_ESFOrderPK esfArticle_ESFOrderPK, long esfOrderId,
		OrderByComparator orderByComparator)
		throws NoSuchArticle_ESFOrderException, SystemException {
		ESFArticle_ESFOrder esfArticle_ESFOrder = findByPrimaryKey(esfArticle_ESFOrderPK);

		Session session = null;

		try {
			session = openSession();

			ESFArticle_ESFOrder[] array = new ESFArticle_ESFOrderImpl[3];

			array[0] = getByESFOrderId_PrevAndNext(session,
					esfArticle_ESFOrder, esfOrderId, orderByComparator, true);

			array[1] = esfArticle_ESFOrder;

			array[2] = getByESFOrderId_PrevAndNext(session,
					esfArticle_ESFOrder, esfOrderId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFArticle_ESFOrder getByESFOrderId_PrevAndNext(Session session,
		ESFArticle_ESFOrder esfArticle_ESFOrder, long esfOrderId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFARTICLE_ESFORDER_WHERE);

		query.append(_FINDER_COLUMN_ESFORDERID_ESFORDERID_2);

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
			query.append(ESFArticle_ESFOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfOrderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfArticle_ESFOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFArticle_ESFOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f article_ e s f orders where esfOrderId = &#63; from the database.
	 *
	 * @param esfOrderId the esf order ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFOrderId(long esfOrderId) throws SystemException {
		for (ESFArticle_ESFOrder esfArticle_ESFOrder : findByESFOrderId(
				esfOrderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfArticle_ESFOrder);
		}
	}

	/**
	 * Returns the number of e s f article_ e s f orders where esfOrderId = &#63;.
	 *
	 * @param esfOrderId the esf order ID
	 * @return the number of matching e s f article_ e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFOrderId(long esfOrderId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFORDERID;

		Object[] finderArgs = new Object[] { esfOrderId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFARTICLE_ESFORDER_WHERE);

			query.append(_FINDER_COLUMN_ESFORDERID_ESFORDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfOrderId);

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

	private static final String _FINDER_COLUMN_ESFORDERID_ESFORDERID_2 = "esfArticle_ESFOrder.id.esfOrderId = ?";

	public ESFArticle_ESFOrderPersistenceImpl() {
		setModelClass(ESFArticle_ESFOrder.class);
	}

	/**
	 * Caches the e s f article_ e s f order in the entity cache if it is enabled.
	 *
	 * @param esfArticle_ESFOrder the e s f article_ e s f order
	 */
	@Override
	public void cacheResult(ESFArticle_ESFOrder esfArticle_ESFOrder) {
		EntityCacheUtil.putResult(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFOrderImpl.class, esfArticle_ESFOrder.getPrimaryKey(),
			esfArticle_ESFOrder);

		esfArticle_ESFOrder.resetOriginalValues();
	}

	/**
	 * Caches the e s f article_ e s f orders in the entity cache if it is enabled.
	 *
	 * @param esfArticle_ESFOrders the e s f article_ e s f orders
	 */
	@Override
	public void cacheResult(List<ESFArticle_ESFOrder> esfArticle_ESFOrders) {
		for (ESFArticle_ESFOrder esfArticle_ESFOrder : esfArticle_ESFOrders) {
			if (EntityCacheUtil.getResult(
						ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
						ESFArticle_ESFOrderImpl.class,
						esfArticle_ESFOrder.getPrimaryKey()) == null) {
				cacheResult(esfArticle_ESFOrder);
			}
			else {
				esfArticle_ESFOrder.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f article_ e s f orders.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFArticle_ESFOrderImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFArticle_ESFOrderImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f article_ e s f order.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFArticle_ESFOrder esfArticle_ESFOrder) {
		EntityCacheUtil.removeResult(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFOrderImpl.class, esfArticle_ESFOrder.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFArticle_ESFOrder> esfArticle_ESFOrders) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFArticle_ESFOrder esfArticle_ESFOrder : esfArticle_ESFOrders) {
			EntityCacheUtil.removeResult(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
				ESFArticle_ESFOrderImpl.class,
				esfArticle_ESFOrder.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f article_ e s f order with the primary key. Does not add the e s f article_ e s f order to the database.
	 *
	 * @param esfArticle_ESFOrderPK the primary key for the new e s f article_ e s f order
	 * @return the new e s f article_ e s f order
	 */
	@Override
	public ESFArticle_ESFOrder create(
		ESFArticle_ESFOrderPK esfArticle_ESFOrderPK) {
		ESFArticle_ESFOrder esfArticle_ESFOrder = new ESFArticle_ESFOrderImpl();

		esfArticle_ESFOrder.setNew(true);
		esfArticle_ESFOrder.setPrimaryKey(esfArticle_ESFOrderPK);

		return esfArticle_ESFOrder;
	}

	/**
	 * Removes the e s f article_ e s f order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfArticle_ESFOrderPK the primary key of the e s f article_ e s f order
	 * @return the e s f article_ e s f order that was removed
	 * @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a e s f article_ e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFOrder remove(
		ESFArticle_ESFOrderPK esfArticle_ESFOrderPK)
		throws NoSuchArticle_ESFOrderException, SystemException {
		return remove((Serializable)esfArticle_ESFOrderPK);
	}

	/**
	 * Removes the e s f article_ e s f order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f article_ e s f order
	 * @return the e s f article_ e s f order that was removed
	 * @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a e s f article_ e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFOrder remove(Serializable primaryKey)
		throws NoSuchArticle_ESFOrderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFArticle_ESFOrder esfArticle_ESFOrder = (ESFArticle_ESFOrder)session.get(ESFArticle_ESFOrderImpl.class,
					primaryKey);

			if (esfArticle_ESFOrder == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticle_ESFOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfArticle_ESFOrder);
		}
		catch (NoSuchArticle_ESFOrderException nsee) {
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
	protected ESFArticle_ESFOrder removeImpl(
		ESFArticle_ESFOrder esfArticle_ESFOrder) throws SystemException {
		esfArticle_ESFOrder = toUnwrappedModel(esfArticle_ESFOrder);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfArticle_ESFOrder)) {
				esfArticle_ESFOrder = (ESFArticle_ESFOrder)session.get(ESFArticle_ESFOrderImpl.class,
						esfArticle_ESFOrder.getPrimaryKeyObj());
			}

			if (esfArticle_ESFOrder != null) {
				session.delete(esfArticle_ESFOrder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfArticle_ESFOrder != null) {
			clearCache(esfArticle_ESFOrder);
		}

		return esfArticle_ESFOrder;
	}

	@Override
	public ESFArticle_ESFOrder updateImpl(
		com.ethica.esf.model.ESFArticle_ESFOrder esfArticle_ESFOrder)
		throws SystemException {
		esfArticle_ESFOrder = toUnwrappedModel(esfArticle_ESFOrder);

		boolean isNew = esfArticle_ESFOrder.isNew();

		ESFArticle_ESFOrderModelImpl esfArticle_ESFOrderModelImpl = (ESFArticle_ESFOrderModelImpl)esfArticle_ESFOrder;

		Session session = null;

		try {
			session = openSession();

			if (esfArticle_ESFOrder.isNew()) {
				session.save(esfArticle_ESFOrder);

				esfArticle_ESFOrder.setNew(false);
			}
			else {
				session.merge(esfArticle_ESFOrder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFArticle_ESFOrderModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfArticle_ESFOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORDERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfArticle_ESFOrderModelImpl.getOriginalEsfOrderId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORDERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORDERID,
					args);

				args = new Object[] { esfArticle_ESFOrderModelImpl.getEsfOrderId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFORDERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFORDERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFOrderImpl.class, esfArticle_ESFOrder.getPrimaryKey(),
			esfArticle_ESFOrder);

		return esfArticle_ESFOrder;
	}

	protected ESFArticle_ESFOrder toUnwrappedModel(
		ESFArticle_ESFOrder esfArticle_ESFOrder) {
		if (esfArticle_ESFOrder instanceof ESFArticle_ESFOrderImpl) {
			return esfArticle_ESFOrder;
		}

		ESFArticle_ESFOrderImpl esfArticle_ESFOrderImpl = new ESFArticle_ESFOrderImpl();

		esfArticle_ESFOrderImpl.setNew(esfArticle_ESFOrder.isNew());
		esfArticle_ESFOrderImpl.setPrimaryKey(esfArticle_ESFOrder.getPrimaryKey());

		esfArticle_ESFOrderImpl.setEsfArticleId(esfArticle_ESFOrder.getEsfArticleId());
		esfArticle_ESFOrderImpl.setEsfOrderId(esfArticle_ESFOrder.getEsfOrderId());
		esfArticle_ESFOrderImpl.setXxxlQty(esfArticle_ESFOrder.getXxxlQty());
		esfArticle_ESFOrderImpl.setXxlQty(esfArticle_ESFOrder.getXxlQty());
		esfArticle_ESFOrderImpl.setXlQty(esfArticle_ESFOrder.getXlQty());
		esfArticle_ESFOrderImpl.setLQty(esfArticle_ESFOrder.getLQty());
		esfArticle_ESFOrderImpl.setMQty(esfArticle_ESFOrder.getMQty());
		esfArticle_ESFOrderImpl.setSQty(esfArticle_ESFOrder.getSQty());
		esfArticle_ESFOrderImpl.setXsQty(esfArticle_ESFOrder.getXsQty());
		esfArticle_ESFOrderImpl.setXxsQty(esfArticle_ESFOrder.getXxsQty());
		esfArticle_ESFOrderImpl.setOtherQty(esfArticle_ESFOrder.getOtherQty());
		esfArticle_ESFOrderImpl.setTotalQty(esfArticle_ESFOrder.getTotalQty());
		esfArticle_ESFOrderImpl.setPrice(esfArticle_ESFOrder.getPrice());
		esfArticle_ESFOrderImpl.setVat(esfArticle_ESFOrder.getVat());
		esfArticle_ESFOrderImpl.setSale(esfArticle_ESFOrder.getSale());

		return esfArticle_ESFOrderImpl;
	}

	/**
	 * Returns the e s f article_ e s f order with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f article_ e s f order
	 * @return the e s f article_ e s f order
	 * @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a e s f article_ e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFOrder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticle_ESFOrderException, SystemException {
		ESFArticle_ESFOrder esfArticle_ESFOrder = fetchByPrimaryKey(primaryKey);

		if (esfArticle_ESFOrder == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticle_ESFOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfArticle_ESFOrder;
	}

	/**
	 * Returns the e s f article_ e s f order with the primary key or throws a {@link com.ethica.esf.NoSuchArticle_ESFOrderException} if it could not be found.
	 *
	 * @param esfArticle_ESFOrderPK the primary key of the e s f article_ e s f order
	 * @return the e s f article_ e s f order
	 * @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a e s f article_ e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFOrder findByPrimaryKey(
		ESFArticle_ESFOrderPK esfArticle_ESFOrderPK)
		throws NoSuchArticle_ESFOrderException, SystemException {
		return findByPrimaryKey((Serializable)esfArticle_ESFOrderPK);
	}

	/**
	 * Returns the e s f article_ e s f order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f article_ e s f order
	 * @return the e s f article_ e s f order, or <code>null</code> if a e s f article_ e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFOrder fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFArticle_ESFOrder esfArticle_ESFOrder = (ESFArticle_ESFOrder)EntityCacheUtil.getResult(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
				ESFArticle_ESFOrderImpl.class, primaryKey);

		if (esfArticle_ESFOrder == _nullESFArticle_ESFOrder) {
			return null;
		}

		if (esfArticle_ESFOrder == null) {
			Session session = null;

			try {
				session = openSession();

				esfArticle_ESFOrder = (ESFArticle_ESFOrder)session.get(ESFArticle_ESFOrderImpl.class,
						primaryKey);

				if (esfArticle_ESFOrder != null) {
					cacheResult(esfArticle_ESFOrder);
				}
				else {
					EntityCacheUtil.putResult(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
						ESFArticle_ESFOrderImpl.class, primaryKey,
						_nullESFArticle_ESFOrder);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFArticle_ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
					ESFArticle_ESFOrderImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfArticle_ESFOrder;
	}

	/**
	 * Returns the e s f article_ e s f order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfArticle_ESFOrderPK the primary key of the e s f article_ e s f order
	 * @return the e s f article_ e s f order, or <code>null</code> if a e s f article_ e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFOrder fetchByPrimaryKey(
		ESFArticle_ESFOrderPK esfArticle_ESFOrderPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfArticle_ESFOrderPK);
	}

	/**
	 * Returns all the e s f article_ e s f orders.
	 *
	 * @return the e s f article_ e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFOrder> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f article_ e s f orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f article_ e s f orders
	 * @param end the upper bound of the range of e s f article_ e s f orders (not inclusive)
	 * @return the range of e s f article_ e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFOrder> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f article_ e s f orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f article_ e s f orders
	 * @param end the upper bound of the range of e s f article_ e s f orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f article_ e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFOrder> findAll(int start, int end,
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

		List<ESFArticle_ESFOrder> list = (List<ESFArticle_ESFOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFARTICLE_ESFORDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFARTICLE_ESFORDER;

				if (pagination) {
					sql = sql.concat(ESFArticle_ESFOrderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFArticle_ESFOrder>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticle_ESFOrder>(list);
				}
				else {
					list = (List<ESFArticle_ESFOrder>)QueryUtil.list(q,
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
	 * Removes all the e s f article_ e s f orders from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFArticle_ESFOrder esfArticle_ESFOrder : findAll()) {
			remove(esfArticle_ESFOrder);
		}
	}

	/**
	 * Returns the number of e s f article_ e s f orders.
	 *
	 * @return the number of e s f article_ e s f orders
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

				Query q = session.createQuery(_SQL_COUNT_ESFARTICLE_ESFORDER);

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
	 * Initializes the e s f article_ e s f order persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ethica.esf.model.ESFArticle_ESFOrder")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFArticle_ESFOrder>> listenersList = new ArrayList<ModelListener<ESFArticle_ESFOrder>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFArticle_ESFOrder>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFArticle_ESFOrderImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFARTICLE_ESFORDER = "SELECT esfArticle_ESFOrder FROM ESFArticle_ESFOrder esfArticle_ESFOrder";
	private static final String _SQL_SELECT_ESFARTICLE_ESFORDER_WHERE = "SELECT esfArticle_ESFOrder FROM ESFArticle_ESFOrder esfArticle_ESFOrder WHERE ";
	private static final String _SQL_COUNT_ESFARTICLE_ESFORDER = "SELECT COUNT(esfArticle_ESFOrder) FROM ESFArticle_ESFOrder esfArticle_ESFOrder";
	private static final String _SQL_COUNT_ESFARTICLE_ESFORDER_WHERE = "SELECT COUNT(esfArticle_ESFOrder) FROM ESFArticle_ESFOrder esfArticle_ESFOrder WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfArticle_ESFOrder.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFArticle_ESFOrder exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFArticle_ESFOrder exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFArticle_ESFOrderPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"sale"
			});
	private static ESFArticle_ESFOrder _nullESFArticle_ESFOrder = new ESFArticle_ESFOrderImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFArticle_ESFOrder> toCacheModel() {
				return _nullESFArticle_ESFOrderCacheModel;
			}
		};

	private static CacheModel<ESFArticle_ESFOrder> _nullESFArticle_ESFOrderCacheModel =
		new CacheModel<ESFArticle_ESFOrder>() {
			@Override
			public ESFArticle_ESFOrder toEntityModel() {
				return _nullESFArticle_ESFOrder;
			}
		};
}