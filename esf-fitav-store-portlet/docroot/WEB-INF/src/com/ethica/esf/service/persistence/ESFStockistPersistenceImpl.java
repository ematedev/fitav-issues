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

import com.ethica.esf.NoSuchStockistException;
import com.ethica.esf.model.ESFStockist;
import com.ethica.esf.model.impl.ESFStockistImpl;
import com.ethica.esf.model.impl.ESFStockistModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e s f stockist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFStockistPersistence
 * @see ESFStockistUtil
 * @generated
 */
public class ESFStockistPersistenceImpl extends BasePersistenceImpl<ESFStockist>
	implements ESFStockistPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFStockistUtil} to access the e s f stockist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFStockistImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
			ESFStockistModelImpl.FINDER_CACHE_ENABLED, ESFStockistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
			ESFStockistModelImpl.FINDER_CACHE_ENABLED, ESFStockistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
			ESFStockistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_STOCKISTNAME = new FinderPath(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
			ESFStockistModelImpl.FINDER_CACHE_ENABLED, ESFStockistImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByStockistName",
			new String[] { String.class.getName() },
			ESFStockistModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STOCKISTNAME = new FinderPath(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
			ESFStockistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStockistName",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f stockist where name = &#63; or throws a {@link com.ethica.esf.NoSuchStockistException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching e s f stockist
	 * @throws com.ethica.esf.NoSuchStockistException if a matching e s f stockist could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist findByStockistName(String name)
		throws NoSuchStockistException, SystemException {
		ESFStockist esfStockist = fetchByStockistName(name);

		if (esfStockist == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStockistException(msg.toString());
		}

		return esfStockist;
	}

	/**
	 * Returns the e s f stockist where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching e s f stockist, or <code>null</code> if a matching e s f stockist could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist fetchByStockistName(String name)
		throws SystemException {
		return fetchByStockistName(name, true);
	}

	/**
	 * Returns the e s f stockist where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f stockist, or <code>null</code> if a matching e s f stockist could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist fetchByStockistName(String name,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STOCKISTNAME,
					finderArgs, this);
		}

		if (result instanceof ESFStockist) {
			ESFStockist esfStockist = (ESFStockist)result;

			if (!Validator.equals(name, esfStockist.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFSTOCKIST_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_STOCKISTNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STOCKISTNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_STOCKISTNAME_NAME_2);
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

				List<ESFStockist> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOCKISTNAME,
						finderArgs, list);
				}
				else {
					ESFStockist esfStockist = list.get(0);

					result = esfStockist;

					cacheResult(esfStockist);

					if ((esfStockist.getName() == null) ||
							!esfStockist.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOCKISTNAME,
							finderArgs, esfStockist);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STOCKISTNAME,
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
			return (ESFStockist)result;
		}
	}

	/**
	 * Removes the e s f stockist where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the e s f stockist that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist removeByStockistName(String name)
		throws NoSuchStockistException, SystemException {
		ESFStockist esfStockist = findByStockistName(name);

		return remove(esfStockist);
	}

	/**
	 * Returns the number of e s f stockists where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f stockists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStockistName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STOCKISTNAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSTOCKIST_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_STOCKISTNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STOCKISTNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_STOCKISTNAME_NAME_2);
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

	private static final String _FINDER_COLUMN_STOCKISTNAME_NAME_1 = "esfStockist.name IS NULL";
	private static final String _FINDER_COLUMN_STOCKISTNAME_NAME_2 = "esfStockist.name = ?";
	private static final String _FINDER_COLUMN_STOCKISTNAME_NAME_3 = "(esfStockist.name IS NULL OR esfStockist.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STOCKISTID =
		new FinderPath(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
			ESFStockistModelImpl.FINDER_CACHE_ENABLED, ESFStockistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStockistId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STOCKISTID =
		new FinderPath(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
			ESFStockistModelImpl.FINDER_CACHE_ENABLED, ESFStockistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStockistId",
			new String[] { Long.class.getName() },
			ESFStockistModelImpl.ESFSTOCKISTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STOCKISTID = new FinderPath(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
			ESFStockistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStockistId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f stockists where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @return the matching e s f stockists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStockist> findByStockistId(long esfStockistId)
		throws SystemException {
		return findByStockistId(esfStockistId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f stockists where esfStockistId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFStockistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param start the lower bound of the range of e s f stockists
	 * @param end the upper bound of the range of e s f stockists (not inclusive)
	 * @return the range of matching e s f stockists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStockist> findByStockistId(long esfStockistId, int start,
		int end) throws SystemException {
		return findByStockistId(esfStockistId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f stockists where esfStockistId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFStockistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param start the lower bound of the range of e s f stockists
	 * @param end the upper bound of the range of e s f stockists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f stockists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStockist> findByStockistId(long esfStockistId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STOCKISTID;
			finderArgs = new Object[] { esfStockistId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STOCKISTID;
			finderArgs = new Object[] {
					esfStockistId,
					
					start, end, orderByComparator
				};
		}

		List<ESFStockist> list = (List<ESFStockist>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFStockist esfStockist : list) {
				if ((esfStockistId != esfStockist.getEsfStockistId())) {
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

			query.append(_SQL_SELECT_ESFSTOCKIST_WHERE);

			query.append(_FINDER_COLUMN_STOCKISTID_ESFSTOCKISTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFStockistModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfStockistId);

				if (!pagination) {
					list = (List<ESFStockist>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFStockist>(list);
				}
				else {
					list = (List<ESFStockist>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f stockist in the ordered set where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f stockist
	 * @throws com.ethica.esf.NoSuchStockistException if a matching e s f stockist could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist findByStockistId_First(long esfStockistId,
		OrderByComparator orderByComparator)
		throws NoSuchStockistException, SystemException {
		ESFStockist esfStockist = fetchByStockistId_First(esfStockistId,
				orderByComparator);

		if (esfStockist != null) {
			return esfStockist;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfStockistId=");
		msg.append(esfStockistId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStockistException(msg.toString());
	}

	/**
	 * Returns the first e s f stockist in the ordered set where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f stockist, or <code>null</code> if a matching e s f stockist could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist fetchByStockistId_First(long esfStockistId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFStockist> list = findByStockistId(esfStockistId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f stockist in the ordered set where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f stockist
	 * @throws com.ethica.esf.NoSuchStockistException if a matching e s f stockist could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist findByStockistId_Last(long esfStockistId,
		OrderByComparator orderByComparator)
		throws NoSuchStockistException, SystemException {
		ESFStockist esfStockist = fetchByStockistId_Last(esfStockistId,
				orderByComparator);

		if (esfStockist != null) {
			return esfStockist;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfStockistId=");
		msg.append(esfStockistId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStockistException(msg.toString());
	}

	/**
	 * Returns the last e s f stockist in the ordered set where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f stockist, or <code>null</code> if a matching e s f stockist could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist fetchByStockistId_Last(long esfStockistId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStockistId(esfStockistId);

		if (count == 0) {
			return null;
		}

		List<ESFStockist> list = findByStockistId(esfStockistId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the e s f stockists where esfStockistId = &#63; from the database.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStockistId(long esfStockistId)
		throws SystemException {
		for (ESFStockist esfStockist : findByStockistId(esfStockistId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfStockist);
		}
	}

	/**
	 * Returns the number of e s f stockists where esfStockistId = &#63;.
	 *
	 * @param esfStockistId the esf stockist ID
	 * @return the number of matching e s f stockists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStockistId(long esfStockistId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STOCKISTID;

		Object[] finderArgs = new Object[] { esfStockistId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFSTOCKIST_WHERE);

			query.append(_FINDER_COLUMN_STOCKISTID_ESFSTOCKISTID_2);

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

	private static final String _FINDER_COLUMN_STOCKISTID_ESFSTOCKISTID_2 = "esfStockist.esfStockistId = ?";

	public ESFStockistPersistenceImpl() {
		setModelClass(ESFStockist.class);
	}

	/**
	 * Caches the e s f stockist in the entity cache if it is enabled.
	 *
	 * @param esfStockist the e s f stockist
	 */
	@Override
	public void cacheResult(ESFStockist esfStockist) {
		EntityCacheUtil.putResult(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
			ESFStockistImpl.class, esfStockist.getPrimaryKey(), esfStockist);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOCKISTNAME,
			new Object[] { esfStockist.getName() }, esfStockist);

		esfStockist.resetOriginalValues();
	}

	/**
	 * Caches the e s f stockists in the entity cache if it is enabled.
	 *
	 * @param esfStockists the e s f stockists
	 */
	@Override
	public void cacheResult(List<ESFStockist> esfStockists) {
		for (ESFStockist esfStockist : esfStockists) {
			if (EntityCacheUtil.getResult(
						ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
						ESFStockistImpl.class, esfStockist.getPrimaryKey()) == null) {
				cacheResult(esfStockist);
			}
			else {
				esfStockist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f stockists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFStockistImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFStockistImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f stockist.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFStockist esfStockist) {
		EntityCacheUtil.removeResult(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
			ESFStockistImpl.class, esfStockist.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfStockist);
	}

	@Override
	public void clearCache(List<ESFStockist> esfStockists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFStockist esfStockist : esfStockists) {
			EntityCacheUtil.removeResult(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
				ESFStockistImpl.class, esfStockist.getPrimaryKey());

			clearUniqueFindersCache(esfStockist);
		}
	}

	protected void cacheUniqueFindersCache(ESFStockist esfStockist) {
		if (esfStockist.isNew()) {
			Object[] args = new Object[] { esfStockist.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STOCKISTNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOCKISTNAME, args,
				esfStockist);
		}
		else {
			ESFStockistModelImpl esfStockistModelImpl = (ESFStockistModelImpl)esfStockist;

			if ((esfStockistModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STOCKISTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfStockist.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STOCKISTNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOCKISTNAME,
					args, esfStockist);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFStockist esfStockist) {
		ESFStockistModelImpl esfStockistModelImpl = (ESFStockistModelImpl)esfStockist;

		Object[] args = new Object[] { esfStockist.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STOCKISTNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STOCKISTNAME, args);

		if ((esfStockistModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STOCKISTNAME.getColumnBitmask()) != 0) {
			args = new Object[] { esfStockistModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STOCKISTNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STOCKISTNAME, args);
		}
	}

	/**
	 * Creates a new e s f stockist with the primary key. Does not add the e s f stockist to the database.
	 *
	 * @param esfStockistId the primary key for the new e s f stockist
	 * @return the new e s f stockist
	 */
	@Override
	public ESFStockist create(long esfStockistId) {
		ESFStockist esfStockist = new ESFStockistImpl();

		esfStockist.setNew(true);
		esfStockist.setPrimaryKey(esfStockistId);

		return esfStockist;
	}

	/**
	 * Removes the e s f stockist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfStockistId the primary key of the e s f stockist
	 * @return the e s f stockist that was removed
	 * @throws com.ethica.esf.NoSuchStockistException if a e s f stockist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist remove(long esfStockistId)
		throws NoSuchStockistException, SystemException {
		return remove((Serializable)esfStockistId);
	}

	/**
	 * Removes the e s f stockist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f stockist
	 * @return the e s f stockist that was removed
	 * @throws com.ethica.esf.NoSuchStockistException if a e s f stockist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist remove(Serializable primaryKey)
		throws NoSuchStockistException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFStockist esfStockist = (ESFStockist)session.get(ESFStockistImpl.class,
					primaryKey);

			if (esfStockist == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStockistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfStockist);
		}
		catch (NoSuchStockistException nsee) {
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
	protected ESFStockist removeImpl(ESFStockist esfStockist)
		throws SystemException {
		esfStockist = toUnwrappedModel(esfStockist);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfStockist)) {
				esfStockist = (ESFStockist)session.get(ESFStockistImpl.class,
						esfStockist.getPrimaryKeyObj());
			}

			if (esfStockist != null) {
				session.delete(esfStockist);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfStockist != null) {
			clearCache(esfStockist);
		}

		return esfStockist;
	}

	@Override
	public ESFStockist updateImpl(com.ethica.esf.model.ESFStockist esfStockist)
		throws SystemException {
		esfStockist = toUnwrappedModel(esfStockist);

		boolean isNew = esfStockist.isNew();

		ESFStockistModelImpl esfStockistModelImpl = (ESFStockistModelImpl)esfStockist;

		Session session = null;

		try {
			session = openSession();

			if (esfStockist.isNew()) {
				session.save(esfStockist);

				esfStockist.setNew(false);
			}
			else {
				session.merge(esfStockist);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFStockistModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfStockistModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STOCKISTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfStockistModelImpl.getOriginalEsfStockistId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STOCKISTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STOCKISTID,
					args);

				args = new Object[] { esfStockistModelImpl.getEsfStockistId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STOCKISTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STOCKISTID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
			ESFStockistImpl.class, esfStockist.getPrimaryKey(), esfStockist);

		clearUniqueFindersCache(esfStockist);
		cacheUniqueFindersCache(esfStockist);

		return esfStockist;
	}

	protected ESFStockist toUnwrappedModel(ESFStockist esfStockist) {
		if (esfStockist instanceof ESFStockistImpl) {
			return esfStockist;
		}

		ESFStockistImpl esfStockistImpl = new ESFStockistImpl();

		esfStockistImpl.setNew(esfStockist.isNew());
		esfStockistImpl.setPrimaryKey(esfStockist.getPrimaryKey());

		esfStockistImpl.setEsfStockistId(esfStockist.getEsfStockistId());
		esfStockistImpl.setName(esfStockist.getName());
		esfStockistImpl.setEmail(esfStockist.getEmail());
		esfStockistImpl.setPhone(esfStockist.getPhone());
		esfStockistImpl.setAddress(esfStockist.getAddress());
		esfStockistImpl.setNameReference(esfStockist.getNameReference());
		esfStockistImpl.setLastNameReference(esfStockist.getLastNameReference());
		esfStockistImpl.setEmailReference(esfStockist.getEmailReference());
		esfStockistImpl.setPhoneReference(esfStockist.getPhoneReference());
		esfStockistImpl.setDescription(esfStockist.getDescription());
		esfStockistImpl.setOther(esfStockist.getOther());

		return esfStockistImpl;
	}

	/**
	 * Returns the e s f stockist with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f stockist
	 * @return the e s f stockist
	 * @throws com.ethica.esf.NoSuchStockistException if a e s f stockist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStockistException, SystemException {
		ESFStockist esfStockist = fetchByPrimaryKey(primaryKey);

		if (esfStockist == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStockistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfStockist;
	}

	/**
	 * Returns the e s f stockist with the primary key or throws a {@link com.ethica.esf.NoSuchStockistException} if it could not be found.
	 *
	 * @param esfStockistId the primary key of the e s f stockist
	 * @return the e s f stockist
	 * @throws com.ethica.esf.NoSuchStockistException if a e s f stockist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist findByPrimaryKey(long esfStockistId)
		throws NoSuchStockistException, SystemException {
		return findByPrimaryKey((Serializable)esfStockistId);
	}

	/**
	 * Returns the e s f stockist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f stockist
	 * @return the e s f stockist, or <code>null</code> if a e s f stockist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFStockist esfStockist = (ESFStockist)EntityCacheUtil.getResult(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
				ESFStockistImpl.class, primaryKey);

		if (esfStockist == _nullESFStockist) {
			return null;
		}

		if (esfStockist == null) {
			Session session = null;

			try {
				session = openSession();

				esfStockist = (ESFStockist)session.get(ESFStockistImpl.class,
						primaryKey);

				if (esfStockist != null) {
					cacheResult(esfStockist);
				}
				else {
					EntityCacheUtil.putResult(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
						ESFStockistImpl.class, primaryKey, _nullESFStockist);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFStockistModelImpl.ENTITY_CACHE_ENABLED,
					ESFStockistImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfStockist;
	}

	/**
	 * Returns the e s f stockist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfStockistId the primary key of the e s f stockist
	 * @return the e s f stockist, or <code>null</code> if a e s f stockist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFStockist fetchByPrimaryKey(long esfStockistId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfStockistId);
	}

	/**
	 * Returns all the e s f stockists.
	 *
	 * @return the e s f stockists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStockist> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f stockists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFStockistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f stockists
	 * @param end the upper bound of the range of e s f stockists (not inclusive)
	 * @return the range of e s f stockists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStockist> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f stockists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFStockistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f stockists
	 * @param end the upper bound of the range of e s f stockists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f stockists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFStockist> findAll(int start, int end,
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

		List<ESFStockist> list = (List<ESFStockist>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFSTOCKIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFSTOCKIST;

				if (pagination) {
					sql = sql.concat(ESFStockistModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFStockist>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFStockist>(list);
				}
				else {
					list = (List<ESFStockist>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f stockists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFStockist esfStockist : findAll()) {
			remove(esfStockist);
		}
	}

	/**
	 * Returns the number of e s f stockists.
	 *
	 * @return the number of e s f stockists
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

				Query q = session.createQuery(_SQL_COUNT_ESFSTOCKIST);

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
	 * Initializes the e s f stockist persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ethica.esf.model.ESFStockist")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFStockist>> listenersList = new ArrayList<ModelListener<ESFStockist>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFStockist>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFStockistImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFSTOCKIST = "SELECT esfStockist FROM ESFStockist esfStockist";
	private static final String _SQL_SELECT_ESFSTOCKIST_WHERE = "SELECT esfStockist FROM ESFStockist esfStockist WHERE ";
	private static final String _SQL_COUNT_ESFSTOCKIST = "SELECT COUNT(esfStockist) FROM ESFStockist esfStockist";
	private static final String _SQL_COUNT_ESFSTOCKIST_WHERE = "SELECT COUNT(esfStockist) FROM ESFStockist esfStockist WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfStockist.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFStockist exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFStockist exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFStockistPersistenceImpl.class);
	private static ESFStockist _nullESFStockist = new ESFStockistImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFStockist> toCacheModel() {
				return _nullESFStockistCacheModel;
			}
		};

	private static CacheModel<ESFStockist> _nullESFStockistCacheModel = new CacheModel<ESFStockist>() {
			@Override
			public ESFStockist toEntityModel() {
				return _nullESFStockist;
			}
		};
}