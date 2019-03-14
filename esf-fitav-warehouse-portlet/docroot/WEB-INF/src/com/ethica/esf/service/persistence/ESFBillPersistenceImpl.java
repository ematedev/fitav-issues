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

import com.ethica.esf.NoSuchBillException;
import com.ethica.esf.model.ESFBill;
import com.ethica.esf.model.impl.ESFBillImpl;
import com.ethica.esf.model.impl.ESFBillModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f bill service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFBillPersistence
 * @see ESFBillUtil
 * @generated
 */
public class ESFBillPersistenceImpl extends BasePersistenceImpl<ESFBill>
	implements ESFBillPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFBillUtil} to access the e s f bill persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFBillImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
			ESFBillModelImpl.FINDER_CACHE_ENABLED, ESFBillImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
			ESFBillModelImpl.FINDER_CACHE_ENABLED, ESFBillImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
			ESFBillModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EA_EO = new FinderPath(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
			ESFBillModelImpl.FINDER_CACHE_ENABLED, ESFBillImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEA_EO",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EA_EO = new FinderPath(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
			ESFBillModelImpl.FINDER_CACHE_ENABLED, ESFBillImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEA_EO",
			new String[] { Long.class.getName(), Long.class.getName() },
			ESFBillModelImpl.ESFARTICLEID_COLUMN_BITMASK |
			ESFBillModelImpl.ESFORDERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EA_EO = new FinderPath(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
			ESFBillModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEA_EO",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e s f bills where esfArticleId = &#63; and esfOrderId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param esfOrderId the esf order ID
	 * @return the matching e s f bills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFBill> findByEA_EO(long esfArticleId, long esfOrderId)
		throws SystemException {
		return findByEA_EO(esfArticleId, esfOrderId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f bills where esfArticleId = &#63; and esfOrderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfArticleId the esf article ID
	 * @param esfOrderId the esf order ID
	 * @param start the lower bound of the range of e s f bills
	 * @param end the upper bound of the range of e s f bills (not inclusive)
	 * @return the range of matching e s f bills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFBill> findByEA_EO(long esfArticleId, long esfOrderId,
		int start, int end) throws SystemException {
		return findByEA_EO(esfArticleId, esfOrderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f bills where esfArticleId = &#63; and esfOrderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfArticleId the esf article ID
	 * @param esfOrderId the esf order ID
	 * @param start the lower bound of the range of e s f bills
	 * @param end the upper bound of the range of e s f bills (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f bills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFBill> findByEA_EO(long esfArticleId, long esfOrderId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EA_EO;
			finderArgs = new Object[] { esfArticleId, esfOrderId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EA_EO;
			finderArgs = new Object[] {
					esfArticleId, esfOrderId,
					
					start, end, orderByComparator
				};
		}

		List<ESFBill> list = (List<ESFBill>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFBill esfBill : list) {
				if ((esfArticleId != esfBill.getEsfArticleId()) ||
						(esfOrderId != esfBill.getEsfOrderId())) {
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

			query.append(_SQL_SELECT_ESFBILL_WHERE);

			query.append(_FINDER_COLUMN_EA_EO_ESFARTICLEID_2);

			query.append(_FINDER_COLUMN_EA_EO_ESFORDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFBillModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfArticleId);

				qPos.add(esfOrderId);

				if (!pagination) {
					list = (List<ESFBill>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFBill>(list);
				}
				else {
					list = (List<ESFBill>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param esfOrderId the esf order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f bill
	 * @throws com.ethica.esf.NoSuchBillException if a matching e s f bill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBill findByEA_EO_First(long esfArticleId, long esfOrderId,
		OrderByComparator orderByComparator)
		throws NoSuchBillException, SystemException {
		ESFBill esfBill = fetchByEA_EO_First(esfArticleId, esfOrderId,
				orderByComparator);

		if (esfBill != null) {
			return esfBill;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfArticleId=");
		msg.append(esfArticleId);

		msg.append(", esfOrderId=");
		msg.append(esfOrderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBillException(msg.toString());
	}

	/**
	 * Returns the first e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param esfOrderId the esf order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f bill, or <code>null</code> if a matching e s f bill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBill fetchByEA_EO_First(long esfArticleId, long esfOrderId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFBill> list = findByEA_EO(esfArticleId, esfOrderId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param esfOrderId the esf order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f bill
	 * @throws com.ethica.esf.NoSuchBillException if a matching e s f bill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBill findByEA_EO_Last(long esfArticleId, long esfOrderId,
		OrderByComparator orderByComparator)
		throws NoSuchBillException, SystemException {
		ESFBill esfBill = fetchByEA_EO_Last(esfArticleId, esfOrderId,
				orderByComparator);

		if (esfBill != null) {
			return esfBill;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfArticleId=");
		msg.append(esfArticleId);

		msg.append(", esfOrderId=");
		msg.append(esfOrderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBillException(msg.toString());
	}

	/**
	 * Returns the last e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param esfOrderId the esf order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f bill, or <code>null</code> if a matching e s f bill could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBill fetchByEA_EO_Last(long esfArticleId, long esfOrderId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEA_EO(esfArticleId, esfOrderId);

		if (count == 0) {
			return null;
		}

		List<ESFBill> list = findByEA_EO(esfArticleId, esfOrderId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f bills before and after the current e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	 *
	 * @param esfBillId the primary key of the current e s f bill
	 * @param esfArticleId the esf article ID
	 * @param esfOrderId the esf order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f bill
	 * @throws com.ethica.esf.NoSuchBillException if a e s f bill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBill[] findByEA_EO_PrevAndNext(long esfBillId, long esfArticleId,
		long esfOrderId, OrderByComparator orderByComparator)
		throws NoSuchBillException, SystemException {
		ESFBill esfBill = findByPrimaryKey(esfBillId);

		Session session = null;

		try {
			session = openSession();

			ESFBill[] array = new ESFBillImpl[3];

			array[0] = getByEA_EO_PrevAndNext(session, esfBill, esfArticleId,
					esfOrderId, orderByComparator, true);

			array[1] = esfBill;

			array[2] = getByEA_EO_PrevAndNext(session, esfBill, esfArticleId,
					esfOrderId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFBill getByEA_EO_PrevAndNext(Session session, ESFBill esfBill,
		long esfArticleId, long esfOrderId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFBILL_WHERE);

		query.append(_FINDER_COLUMN_EA_EO_ESFARTICLEID_2);

		query.append(_FINDER_COLUMN_EA_EO_ESFORDERID_2);

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
			query.append(ESFBillModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfArticleId);

		qPos.add(esfOrderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfBill);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFBill> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f bills where esfArticleId = &#63; and esfOrderId = &#63; from the database.
	 *
	 * @param esfArticleId the esf article ID
	 * @param esfOrderId the esf order ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEA_EO(long esfArticleId, long esfOrderId)
		throws SystemException {
		for (ESFBill esfBill : findByEA_EO(esfArticleId, esfOrderId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfBill);
		}
	}

	/**
	 * Returns the number of e s f bills where esfArticleId = &#63; and esfOrderId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param esfOrderId the esf order ID
	 * @return the number of matching e s f bills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEA_EO(long esfArticleId, long esfOrderId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EA_EO;

		Object[] finderArgs = new Object[] { esfArticleId, esfOrderId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ESFBILL_WHERE);

			query.append(_FINDER_COLUMN_EA_EO_ESFARTICLEID_2);

			query.append(_FINDER_COLUMN_EA_EO_ESFORDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfArticleId);

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

	private static final String _FINDER_COLUMN_EA_EO_ESFARTICLEID_2 = "esfBill.esfArticleId = ? AND ";
	private static final String _FINDER_COLUMN_EA_EO_ESFORDERID_2 = "esfBill.esfOrderId = ?";

	public ESFBillPersistenceImpl() {
		setModelClass(ESFBill.class);
	}

	/**
	 * Caches the e s f bill in the entity cache if it is enabled.
	 *
	 * @param esfBill the e s f bill
	 */
	@Override
	public void cacheResult(ESFBill esfBill) {
		EntityCacheUtil.putResult(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
			ESFBillImpl.class, esfBill.getPrimaryKey(), esfBill);

		esfBill.resetOriginalValues();
	}

	/**
	 * Caches the e s f bills in the entity cache if it is enabled.
	 *
	 * @param esfBills the e s f bills
	 */
	@Override
	public void cacheResult(List<ESFBill> esfBills) {
		for (ESFBill esfBill : esfBills) {
			if (EntityCacheUtil.getResult(
						ESFBillModelImpl.ENTITY_CACHE_ENABLED,
						ESFBillImpl.class, esfBill.getPrimaryKey()) == null) {
				cacheResult(esfBill);
			}
			else {
				esfBill.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f bills.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFBillImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFBillImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f bill.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFBill esfBill) {
		EntityCacheUtil.removeResult(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
			ESFBillImpl.class, esfBill.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFBill> esfBills) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFBill esfBill : esfBills) {
			EntityCacheUtil.removeResult(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
				ESFBillImpl.class, esfBill.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f bill with the primary key. Does not add the e s f bill to the database.
	 *
	 * @param esfBillId the primary key for the new e s f bill
	 * @return the new e s f bill
	 */
	@Override
	public ESFBill create(long esfBillId) {
		ESFBill esfBill = new ESFBillImpl();

		esfBill.setNew(true);
		esfBill.setPrimaryKey(esfBillId);

		return esfBill;
	}

	/**
	 * Removes the e s f bill with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfBillId the primary key of the e s f bill
	 * @return the e s f bill that was removed
	 * @throws com.ethica.esf.NoSuchBillException if a e s f bill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBill remove(long esfBillId)
		throws NoSuchBillException, SystemException {
		return remove((Serializable)esfBillId);
	}

	/**
	 * Removes the e s f bill with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f bill
	 * @return the e s f bill that was removed
	 * @throws com.ethica.esf.NoSuchBillException if a e s f bill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBill remove(Serializable primaryKey)
		throws NoSuchBillException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFBill esfBill = (ESFBill)session.get(ESFBillImpl.class, primaryKey);

			if (esfBill == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBillException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfBill);
		}
		catch (NoSuchBillException nsee) {
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
	protected ESFBill removeImpl(ESFBill esfBill) throws SystemException {
		esfBill = toUnwrappedModel(esfBill);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfBill)) {
				esfBill = (ESFBill)session.get(ESFBillImpl.class,
						esfBill.getPrimaryKeyObj());
			}

			if (esfBill != null) {
				session.delete(esfBill);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfBill != null) {
			clearCache(esfBill);
		}

		return esfBill;
	}

	@Override
	public ESFBill updateImpl(com.ethica.esf.model.ESFBill esfBill)
		throws SystemException {
		esfBill = toUnwrappedModel(esfBill);

		boolean isNew = esfBill.isNew();

		ESFBillModelImpl esfBillModelImpl = (ESFBillModelImpl)esfBill;

		Session session = null;

		try {
			session = openSession();

			if (esfBill.isNew()) {
				session.save(esfBill);

				esfBill.setNew(false);
			}
			else {
				session.merge(esfBill);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFBillModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfBillModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EA_EO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfBillModelImpl.getOriginalEsfArticleId(),
						esfBillModelImpl.getOriginalEsfOrderId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EA_EO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EA_EO,
					args);

				args = new Object[] {
						esfBillModelImpl.getEsfArticleId(),
						esfBillModelImpl.getEsfOrderId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EA_EO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EA_EO,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
			ESFBillImpl.class, esfBill.getPrimaryKey(), esfBill);

		return esfBill;
	}

	protected ESFBill toUnwrappedModel(ESFBill esfBill) {
		if (esfBill instanceof ESFBillImpl) {
			return esfBill;
		}

		ESFBillImpl esfBillImpl = new ESFBillImpl();

		esfBillImpl.setNew(esfBill.isNew());
		esfBillImpl.setPrimaryKey(esfBill.getPrimaryKey());

		esfBillImpl.setEsfBillId(esfBill.getEsfBillId());
		esfBillImpl.setEsfArticleId(esfBill.getEsfArticleId());
		esfBillImpl.setEsfOrderId(esfBill.getEsfOrderId());
		esfBillImpl.setBillNumber(esfBill.getBillNumber());
		esfBillImpl.setXxxlQty(esfBill.getXxxlQty());
		esfBillImpl.setXxlQty(esfBill.getXxlQty());
		esfBillImpl.setXlQty(esfBill.getXlQty());
		esfBillImpl.setLQty(esfBill.getLQty());
		esfBillImpl.setMQty(esfBill.getMQty());
		esfBillImpl.setSQty(esfBill.getSQty());
		esfBillImpl.setXsQty(esfBill.getXsQty());
		esfBillImpl.setXxsQty(esfBill.getXxsQty());
		esfBillImpl.setOtherQty(esfBill.getOtherQty());
		esfBillImpl.setTotalQty(esfBill.getTotalQty());

		return esfBillImpl;
	}

	/**
	 * Returns the e s f bill with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f bill
	 * @return the e s f bill
	 * @throws com.ethica.esf.NoSuchBillException if a e s f bill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBill findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBillException, SystemException {
		ESFBill esfBill = fetchByPrimaryKey(primaryKey);

		if (esfBill == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBillException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfBill;
	}

	/**
	 * Returns the e s f bill with the primary key or throws a {@link com.ethica.esf.NoSuchBillException} if it could not be found.
	 *
	 * @param esfBillId the primary key of the e s f bill
	 * @return the e s f bill
	 * @throws com.ethica.esf.NoSuchBillException if a e s f bill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBill findByPrimaryKey(long esfBillId)
		throws NoSuchBillException, SystemException {
		return findByPrimaryKey((Serializable)esfBillId);
	}

	/**
	 * Returns the e s f bill with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f bill
	 * @return the e s f bill, or <code>null</code> if a e s f bill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBill fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFBill esfBill = (ESFBill)EntityCacheUtil.getResult(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
				ESFBillImpl.class, primaryKey);

		if (esfBill == _nullESFBill) {
			return null;
		}

		if (esfBill == null) {
			Session session = null;

			try {
				session = openSession();

				esfBill = (ESFBill)session.get(ESFBillImpl.class, primaryKey);

				if (esfBill != null) {
					cacheResult(esfBill);
				}
				else {
					EntityCacheUtil.putResult(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
						ESFBillImpl.class, primaryKey, _nullESFBill);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFBillModelImpl.ENTITY_CACHE_ENABLED,
					ESFBillImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfBill;
	}

	/**
	 * Returns the e s f bill with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfBillId the primary key of the e s f bill
	 * @return the e s f bill, or <code>null</code> if a e s f bill with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFBill fetchByPrimaryKey(long esfBillId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfBillId);
	}

	/**
	 * Returns all the e s f bills.
	 *
	 * @return the e s f bills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFBill> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f bills.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f bills
	 * @param end the upper bound of the range of e s f bills (not inclusive)
	 * @return the range of e s f bills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFBill> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f bills.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f bills
	 * @param end the upper bound of the range of e s f bills (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f bills
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFBill> findAll(int start, int end,
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

		List<ESFBill> list = (List<ESFBill>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFBILL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFBILL;

				if (pagination) {
					sql = sql.concat(ESFBillModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFBill>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFBill>(list);
				}
				else {
					list = (List<ESFBill>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f bills from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFBill esfBill : findAll()) {
			remove(esfBill);
		}
	}

	/**
	 * Returns the number of e s f bills.
	 *
	 * @return the number of e s f bills
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

				Query q = session.createQuery(_SQL_COUNT_ESFBILL);

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
	 * Initializes the e s f bill persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ethica.esf.model.ESFBill")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFBill>> listenersList = new ArrayList<ModelListener<ESFBill>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFBill>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFBillImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFBILL = "SELECT esfBill FROM ESFBill esfBill";
	private static final String _SQL_SELECT_ESFBILL_WHERE = "SELECT esfBill FROM ESFBill esfBill WHERE ";
	private static final String _SQL_COUNT_ESFBILL = "SELECT COUNT(esfBill) FROM ESFBill esfBill";
	private static final String _SQL_COUNT_ESFBILL_WHERE = "SELECT COUNT(esfBill) FROM ESFBill esfBill WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfBill.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFBill exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFBill exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFBillPersistenceImpl.class);
	private static ESFBill _nullESFBill = new ESFBillImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFBill> toCacheModel() {
				return _nullESFBillCacheModel;
			}
		};

	private static CacheModel<ESFBill> _nullESFBillCacheModel = new CacheModel<ESFBill>() {
			@Override
			public ESFBill toEntityModel() {
				return _nullESFBill;
			}
		};
}