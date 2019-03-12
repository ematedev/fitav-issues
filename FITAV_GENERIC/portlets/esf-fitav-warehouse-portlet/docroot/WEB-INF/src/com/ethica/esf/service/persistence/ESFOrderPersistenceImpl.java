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

import com.ethica.esf.NoSuchOrderException;
import com.ethica.esf.model.ESFOrder;
import com.ethica.esf.model.impl.ESFOrderImpl;
import com.ethica.esf.model.impl.ESFOrderModelImpl;

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
import com.liferay.portal.kernel.util.CharPool;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrderPersistence
 * @see ESFOrderUtil
 * @generated
 */
public class ESFOrderPersistenceImpl extends BasePersistenceImpl<ESFOrder>
	implements ESFOrderPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFOrderUtil} to access the e s f order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFOrderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, ESFOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, ESFOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, ESFOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME = new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f orders where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f orders where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f orders
	 * @param end the upper bound of the range of e s f orders (not inclusive)
	 * @return the range of matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f orders where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f orders
	 * @param end the upper bound of the range of e s f orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
		finderArgs = new Object[] { name, start, end, orderByComparator };

		List<ESFOrder> list = (List<ESFOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrder esfOrder : list) {
				if (!StringUtil.wildcardMatches(esfOrder.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_ESFORDER_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<ESFOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrder>(list);
				}
				else {
					list = (List<ESFOrder>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f order in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = fetchByName_First(name, orderByComparator);

		if (esfOrder != null) {
			return esfOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrderException(msg.toString());
	}

	/**
	 * Returns the first e s f order in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f order, or <code>null</code> if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrder> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f order in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = fetchByName_Last(name, orderByComparator);

		if (esfOrder != null) {
			return esfOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrderException(msg.toString());
	}

	/**
	 * Returns the last e s f order in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f order, or <code>null</code> if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ESFOrder> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f orders before and after the current e s f order in the ordered set where name LIKE &#63;.
	 *
	 * @param esfOrderId the primary key of the current e s f order
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder[] findByName_PrevAndNext(long esfOrderId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = findByPrimaryKey(esfOrderId);

		Session session = null;

		try {
			session = openSession();

			ESFOrder[] array = new ESFOrderImpl[3];

			array[0] = getByName_PrevAndNext(session, esfOrder, name,
					orderByComparator, true);

			array[1] = esfOrder;

			array[2] = getByName_PrevAndNext(session, esfOrder, name,
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

	protected ESFOrder getByName_PrevAndNext(Session session,
		ESFOrder esfOrder, String name, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORDER_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

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
			query.append(ESFOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f orders where name LIKE &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (ESFOrder esfOrder : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfOrder);
		}
	}

	/**
	 * Returns the number of e s f orders where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORDER_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "esfOrder.name LIKE NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "esfOrder.name LIKE ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(esfOrder.name IS NULL OR esfOrder.name LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, ESFOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDescription",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_DESCRIPTION =
		new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDescription",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f orders where description LIKE &#63;.
	 *
	 * @param description the description
	 * @return the matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findByDescription(String description)
		throws SystemException {
		return findByDescription(description, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f orders where description LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of e s f orders
	 * @param end the upper bound of the range of e s f orders (not inclusive)
	 * @return the range of matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findByDescription(String description, int start,
		int end) throws SystemException {
		return findByDescription(description, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f orders where description LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of e s f orders
	 * @param end the upper bound of the range of e s f orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findByDescription(String description, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION;
		finderArgs = new Object[] { description, start, end, orderByComparator };

		List<ESFOrder> list = (List<ESFOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrder esfOrder : list) {
				if (!StringUtil.wildcardMatches(esfOrder.getDescription(),
							description, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_ESFORDER_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescription) {
					qPos.add(description);
				}

				if (!pagination) {
					list = (List<ESFOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrder>(list);
				}
				else {
					list = (List<ESFOrder>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f order in the ordered set where description LIKE &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder findByDescription_First(String description,
		OrderByComparator orderByComparator)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = fetchByDescription_First(description,
				orderByComparator);

		if (esfOrder != null) {
			return esfOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrderException(msg.toString());
	}

	/**
	 * Returns the first e s f order in the ordered set where description LIKE &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f order, or <code>null</code> if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder fetchByDescription_First(String description,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrder> list = findByDescription(description, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f order in the ordered set where description LIKE &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder findByDescription_Last(String description,
		OrderByComparator orderByComparator)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = fetchByDescription_Last(description,
				orderByComparator);

		if (esfOrder != null) {
			return esfOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrderException(msg.toString());
	}

	/**
	 * Returns the last e s f order in the ordered set where description LIKE &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f order, or <code>null</code> if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder fetchByDescription_Last(String description,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDescription(description);

		if (count == 0) {
			return null;
		}

		List<ESFOrder> list = findByDescription(description, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f orders before and after the current e s f order in the ordered set where description LIKE &#63;.
	 *
	 * @param esfOrderId the primary key of the current e s f order
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder[] findByDescription_PrevAndNext(long esfOrderId,
		String description, OrderByComparator orderByComparator)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = findByPrimaryKey(esfOrderId);

		Session session = null;

		try {
			session = openSession();

			ESFOrder[] array = new ESFOrderImpl[3];

			array[0] = getByDescription_PrevAndNext(session, esfOrder,
					description, orderByComparator, true);

			array[1] = esfOrder;

			array[2] = getByDescription_PrevAndNext(session, esfOrder,
					description, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFOrder getByDescription_PrevAndNext(Session session,
		ESFOrder esfOrder, String description,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORDER_WHERE);

		boolean bindDescription = false;

		if (description == null) {
			query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1);
		}
		else if (description.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
		}
		else {
			bindDescription = true;

			query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
		}

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
			query.append(ESFOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDescription) {
			qPos.add(description);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f orders where description LIKE &#63; from the database.
	 *
	 * @param description the description
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDescription(String description)
		throws SystemException {
		for (ESFOrder esfOrder : findByDescription(description,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrder);
		}
	}

	/**
	 * Returns the number of e s f orders where description LIKE &#63;.
	 *
	 * @param description the description
	 * @return the number of matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDescription(String description) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_DESCRIPTION;

		Object[] finderArgs = new Object[] { description };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORDER_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescription) {
					qPos.add(description);
				}

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

	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1 = "esfOrder.description LIKE NULL";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2 = "esfOrder.description LIKE ?";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3 = "(esfOrder.description IS NULL OR esfOrder.description LIKE '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, ESFOrderImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			ESFOrderModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f order where code = &#63; or throws a {@link com.ethica.esf.NoSuchOrderException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder findByCode(String code)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = fetchByCode(code);

		if (esfOrder == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrderException(msg.toString());
		}

		return esfOrder;
	}

	/**
	 * Returns the e s f order where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching e s f order, or <code>null</code> if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the e s f order where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f order, or <code>null</code> if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ESFOrder) {
			ESFOrder esfOrder = (ESFOrder)result;

			if (!Validator.equals(code, esfOrder.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFORDER_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				List<ESFOrder> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					ESFOrder esfOrder = list.get(0);

					result = esfOrder;

					cacheResult(esfOrder);

					if ((esfOrder.getCode() == null) ||
							!esfOrder.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, esfOrder);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
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
			return (ESFOrder)result;
		}
	}

	/**
	 * Removes the e s f order where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the e s f order that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder removeByCode(String code)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = findByCode(code);

		return remove(esfOrder);
	}

	/**
	 * Returns the number of e s f orders where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORDER_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfOrder.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfOrder.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfOrder.code IS NULL OR esfOrder.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFSTOCKISTID =
		new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, ESFOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFStockistId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSTOCKISTID =
		new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, ESFOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFStockistId",
			new String[] { Long.class.getName() },
			ESFOrderModelImpl.ESFSTOCKISTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFSTOCKISTID = new FinderPath(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFStockistId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f orders where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @return the matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findByESFStockistId(long esfStockistId)
		throws SystemException {
		return findByESFStockistId(esfStockistId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f orders where esfStockistId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param start the lower bound of the range of e s f orders
	 * @param end the upper bound of the range of e s f orders (not inclusive)
	 * @return the range of matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findByESFStockistId(long esfStockistId, int start,
		int end) throws SystemException {
		return findByESFStockistId(esfStockistId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f orders where esfStockistId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param start the lower bound of the range of e s f orders
	 * @param end the upper bound of the range of e s f orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findByESFStockistId(long esfStockistId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSTOCKISTID;
			finderArgs = new Object[] { esfStockistId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFSTOCKISTID;
			finderArgs = new Object[] {
					esfStockistId,
					
					start, end, orderByComparator
				};
		}

		List<ESFOrder> list = (List<ESFOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrder esfOrder : list) {
				if ((esfStockistId != esfOrder.getEsfStockistId())) {
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

			query.append(_SQL_SELECT_ESFORDER_WHERE);

			query.append(_FINDER_COLUMN_ESFSTOCKISTID_ESFSTOCKISTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfStockistId);

				if (!pagination) {
					list = (List<ESFOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrder>(list);
				}
				else {
					list = (List<ESFOrder>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f order in the ordered set where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder findByESFStockistId_First(long esfStockistId,
		OrderByComparator orderByComparator)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = fetchByESFStockistId_First(esfStockistId,
				orderByComparator);

		if (esfOrder != null) {
			return esfOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfStockistId=");
		msg.append(esfStockistId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrderException(msg.toString());
	}

	/**
	 * Returns the first e s f order in the ordered set where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f order, or <code>null</code> if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder fetchByESFStockistId_First(long esfStockistId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFOrder> list = findByESFStockistId(esfStockistId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f order in the ordered set where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder findByESFStockistId_Last(long esfStockistId,
		OrderByComparator orderByComparator)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = fetchByESFStockistId_Last(esfStockistId,
				orderByComparator);

		if (esfOrder != null) {
			return esfOrder;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfStockistId=");
		msg.append(esfStockistId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrderException(msg.toString());
	}

	/**
	 * Returns the last e s f order in the ordered set where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f order, or <code>null</code> if a matching e s f order could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder fetchByESFStockistId_Last(long esfStockistId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFStockistId(esfStockistId);

		if (count == 0) {
			return null;
		}

		List<ESFOrder> list = findByESFStockistId(esfStockistId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f orders before and after the current e s f order in the ordered set where esfStockistId = &#63;.
	 *
	 * @param esfOrderId the primary key of the current e s f order
	 * @param esfStockistId the esf stockist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder[] findByESFStockistId_PrevAndNext(long esfOrderId,
		long esfStockistId, OrderByComparator orderByComparator)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = findByPrimaryKey(esfOrderId);

		Session session = null;

		try {
			session = openSession();

			ESFOrder[] array = new ESFOrderImpl[3];

			array[0] = getByESFStockistId_PrevAndNext(session, esfOrder,
					esfStockistId, orderByComparator, true);

			array[1] = esfOrder;

			array[2] = getByESFStockistId_PrevAndNext(session, esfOrder,
					esfStockistId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFOrder getByESFStockistId_PrevAndNext(Session session,
		ESFOrder esfOrder, long esfStockistId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORDER_WHERE);

		query.append(_FINDER_COLUMN_ESFSTOCKISTID_ESFSTOCKISTID_2);

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
			query.append(ESFOrderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfStockistId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrder);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrder> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f orders where esfStockistId = &#63; from the database.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFStockistId(long esfStockistId)
		throws SystemException {
		for (ESFOrder esfOrder : findByESFStockistId(esfStockistId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrder);
		}
	}

	/**
	 * Returns the number of e s f orders where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @return the number of matching e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFStockistId(long esfStockistId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFSTOCKISTID;

		Object[] finderArgs = new Object[] { esfStockistId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORDER_WHERE);

			query.append(_FINDER_COLUMN_ESFSTOCKISTID_ESFSTOCKISTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfStockistId);

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

	private static final String _FINDER_COLUMN_ESFSTOCKISTID_ESFSTOCKISTID_2 = "esfOrder.esfStockistId = ?";

	public ESFOrderPersistenceImpl() {
		setModelClass(ESFOrder.class);
	}

	/**
	 * Caches the e s f order in the entity cache if it is enabled.
	 *
	 * @param esfOrder the e s f order
	 */
	@Override
	public void cacheResult(ESFOrder esfOrder) {
		EntityCacheUtil.putResult(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderImpl.class, esfOrder.getPrimaryKey(), esfOrder);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { esfOrder.getCode() }, esfOrder);

		esfOrder.resetOriginalValues();
	}

	/**
	 * Caches the e s f orders in the entity cache if it is enabled.
	 *
	 * @param esfOrders the e s f orders
	 */
	@Override
	public void cacheResult(List<ESFOrder> esfOrders) {
		for (ESFOrder esfOrder : esfOrders) {
			if (EntityCacheUtil.getResult(
						ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
						ESFOrderImpl.class, esfOrder.getPrimaryKey()) == null) {
				cacheResult(esfOrder);
			}
			else {
				esfOrder.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f orders.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFOrderImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFOrderImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f order.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFOrder esfOrder) {
		EntityCacheUtil.removeResult(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderImpl.class, esfOrder.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfOrder);
	}

	@Override
	public void clearCache(List<ESFOrder> esfOrders) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFOrder esfOrder : esfOrders) {
			EntityCacheUtil.removeResult(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
				ESFOrderImpl.class, esfOrder.getPrimaryKey());

			clearUniqueFindersCache(esfOrder);
		}
	}

	protected void cacheUniqueFindersCache(ESFOrder esfOrder) {
		if (esfOrder.isNew()) {
			Object[] args = new Object[] { esfOrder.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args, esfOrder);
		}
		else {
			ESFOrderModelImpl esfOrderModelImpl = (ESFOrderModelImpl)esfOrder;

			if ((esfOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfOrder.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					esfOrder);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFOrder esfOrder) {
		ESFOrderModelImpl esfOrderModelImpl = (ESFOrderModelImpl)esfOrder;

		Object[] args = new Object[] { esfOrder.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((esfOrderModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfOrderModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new e s f order with the primary key. Does not add the e s f order to the database.
	 *
	 * @param esfOrderId the primary key for the new e s f order
	 * @return the new e s f order
	 */
	@Override
	public ESFOrder create(long esfOrderId) {
		ESFOrder esfOrder = new ESFOrderImpl();

		esfOrder.setNew(true);
		esfOrder.setPrimaryKey(esfOrderId);

		return esfOrder;
	}

	/**
	 * Removes the e s f order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfOrderId the primary key of the e s f order
	 * @return the e s f order that was removed
	 * @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder remove(long esfOrderId)
		throws NoSuchOrderException, SystemException {
		return remove((Serializable)esfOrderId);
	}

	/**
	 * Removes the e s f order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f order
	 * @return the e s f order that was removed
	 * @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder remove(Serializable primaryKey)
		throws NoSuchOrderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFOrder esfOrder = (ESFOrder)session.get(ESFOrderImpl.class,
					primaryKey);

			if (esfOrder == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfOrder);
		}
		catch (NoSuchOrderException nsee) {
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
	protected ESFOrder removeImpl(ESFOrder esfOrder) throws SystemException {
		esfOrder = toUnwrappedModel(esfOrder);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfOrder)) {
				esfOrder = (ESFOrder)session.get(ESFOrderImpl.class,
						esfOrder.getPrimaryKeyObj());
			}

			if (esfOrder != null) {
				session.delete(esfOrder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfOrder != null) {
			clearCache(esfOrder);
		}

		return esfOrder;
	}

	@Override
	public ESFOrder updateImpl(com.ethica.esf.model.ESFOrder esfOrder)
		throws SystemException {
		esfOrder = toUnwrappedModel(esfOrder);

		boolean isNew = esfOrder.isNew();

		ESFOrderModelImpl esfOrderModelImpl = (ESFOrderModelImpl)esfOrder;

		Session session = null;

		try {
			session = openSession();

			if (esfOrder.isNew()) {
				session.save(esfOrder);

				esfOrder.setNew(false);
			}
			else {
				session.merge(esfOrder);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFOrderModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfOrderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSTOCKISTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrderModelImpl.getOriginalEsfStockistId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSTOCKISTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSTOCKISTID,
					args);

				args = new Object[] { esfOrderModelImpl.getEsfStockistId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFSTOCKISTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFSTOCKISTID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrderImpl.class, esfOrder.getPrimaryKey(), esfOrder);

		clearUniqueFindersCache(esfOrder);
		cacheUniqueFindersCache(esfOrder);

		return esfOrder;
	}

	protected ESFOrder toUnwrappedModel(ESFOrder esfOrder) {
		if (esfOrder instanceof ESFOrderImpl) {
			return esfOrder;
		}

		ESFOrderImpl esfOrderImpl = new ESFOrderImpl();

		esfOrderImpl.setNew(esfOrder.isNew());
		esfOrderImpl.setPrimaryKey(esfOrder.getPrimaryKey());

		esfOrderImpl.setEsfOrderId(esfOrder.getEsfOrderId());
		esfOrderImpl.setCode(esfOrder.getCode());
		esfOrderImpl.setName(esfOrder.getName());
		esfOrderImpl.setDescription(esfOrder.getDescription());
		esfOrderImpl.setDate(esfOrder.getDate());
		esfOrderImpl.setNote(esfOrder.getNote());
		esfOrderImpl.setProtocolCode(esfOrder.getProtocolCode());
		esfOrderImpl.setAttachment(esfOrder.getAttachment());
		esfOrderImpl.setState(esfOrder.getState());
		esfOrderImpl.setEsfStockistId(esfOrder.getEsfStockistId());

		return esfOrderImpl;
	}

	/**
	 * Returns the e s f order with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f order
	 * @return the e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrderException, SystemException {
		ESFOrder esfOrder = fetchByPrimaryKey(primaryKey);

		if (esfOrder == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfOrder;
	}

	/**
	 * Returns the e s f order with the primary key or throws a {@link com.ethica.esf.NoSuchOrderException} if it could not be found.
	 *
	 * @param esfOrderId the primary key of the e s f order
	 * @return the e s f order
	 * @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder findByPrimaryKey(long esfOrderId)
		throws NoSuchOrderException, SystemException {
		return findByPrimaryKey((Serializable)esfOrderId);
	}

	/**
	 * Returns the e s f order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f order
	 * @return the e s f order, or <code>null</code> if a e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFOrder esfOrder = (ESFOrder)EntityCacheUtil.getResult(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
				ESFOrderImpl.class, primaryKey);

		if (esfOrder == _nullESFOrder) {
			return null;
		}

		if (esfOrder == null) {
			Session session = null;

			try {
				session = openSession();

				esfOrder = (ESFOrder)session.get(ESFOrderImpl.class, primaryKey);

				if (esfOrder != null) {
					cacheResult(esfOrder);
				}
				else {
					EntityCacheUtil.putResult(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
						ESFOrderImpl.class, primaryKey, _nullESFOrder);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFOrderModelImpl.ENTITY_CACHE_ENABLED,
					ESFOrderImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfOrder;
	}

	/**
	 * Returns the e s f order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfOrderId the primary key of the e s f order
	 * @return the e s f order, or <code>null</code> if a e s f order with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrder fetchByPrimaryKey(long esfOrderId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfOrderId);
	}

	/**
	 * Returns all the e s f orders.
	 *
	 * @return the e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f orders
	 * @param end the upper bound of the range of e s f orders (not inclusive)
	 * @return the range of e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f orders
	 * @param end the upper bound of the range of e s f orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f orders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrder> findAll(int start, int end,
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

		List<ESFOrder> list = (List<ESFOrder>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFORDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFORDER;

				if (pagination) {
					sql = sql.concat(ESFOrderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrder>(list);
				}
				else {
					list = (List<ESFOrder>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f orders from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFOrder esfOrder : findAll()) {
			remove(esfOrder);
		}
	}

	/**
	 * Returns the number of e s f orders.
	 *
	 * @return the number of e s f orders
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

				Query q = session.createQuery(_SQL_COUNT_ESFORDER);

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
	 * Initializes the e s f order persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ethica.esf.model.ESFOrder")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFOrder>> listenersList = new ArrayList<ModelListener<ESFOrder>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFOrder>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFOrderImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFORDER = "SELECT esfOrder FROM ESFOrder esfOrder";
	private static final String _SQL_SELECT_ESFORDER_WHERE = "SELECT esfOrder FROM ESFOrder esfOrder WHERE ";
	private static final String _SQL_COUNT_ESFORDER = "SELECT COUNT(esfOrder) FROM ESFOrder esfOrder";
	private static final String _SQL_COUNT_ESFORDER_WHERE = "SELECT COUNT(esfOrder) FROM ESFOrder esfOrder WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfOrder.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFOrder exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFOrder exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFOrderPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code", "date", "state"
			});
	private static ESFOrder _nullESFOrder = new ESFOrderImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFOrder> toCacheModel() {
				return _nullESFOrderCacheModel;
			}
		};

	private static CacheModel<ESFOrder> _nullESFOrderCacheModel = new CacheModel<ESFOrder>() {
			@Override
			public ESFOrder toEntityModel() {
				return _nullESFOrder;
			}
		};
}