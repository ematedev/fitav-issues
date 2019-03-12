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

import com.ethica.esf.NoSuchArticle_ESFUserException;
import com.ethica.esf.model.ESFArticle_ESFUser;
import com.ethica.esf.model.impl.ESFArticle_ESFUserImpl;
import com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl;

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
 * The persistence implementation for the e s f article_ e s f user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFArticle_ESFUserPersistence
 * @see ESFArticle_ESFUserUtil
 * @generated
 */
public class ESFArticle_ESFUserPersistenceImpl extends BasePersistenceImpl<ESFArticle_ESFUser>
	implements ESFArticle_ESFUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFArticle_ESFUserUtil} to access the e s f article_ e s f user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFArticle_ESFUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFUserModelImpl.FINDER_CACHE_ENABLED,
			ESFArticle_ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFUserModelImpl.FINDER_CACHE_ENABLED,
			ESFArticle_ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESFARTICLEID =
		new FinderPath(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFUserModelImpl.FINDER_CACHE_ENABLED,
			ESFArticle_ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByESFArticleId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFARTICLEID =
		new FinderPath(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFUserModelImpl.FINDER_CACHE_ENABLED,
			ESFArticle_ESFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByESFArticleId",
			new String[] { Long.class.getName() },
			ESFArticle_ESFUserModelImpl.ESFARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESFARTICLEID = new FinderPath(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByESFArticleId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f article_ e s f users where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @return the matching e s f article_ e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFUser> findByESFArticleId(long esfArticleId)
		throws SystemException {
		return findByESFArticleId(esfArticleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f article_ e s f users where esfArticleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfArticleId the esf article ID
	 * @param start the lower bound of the range of e s f article_ e s f users
	 * @param end the upper bound of the range of e s f article_ e s f users (not inclusive)
	 * @return the range of matching e s f article_ e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFUser> findByESFArticleId(long esfArticleId,
		int start, int end) throws SystemException {
		return findByESFArticleId(esfArticleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f article_ e s f users where esfArticleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfArticleId the esf article ID
	 * @param start the lower bound of the range of e s f article_ e s f users
	 * @param end the upper bound of the range of e s f article_ e s f users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f article_ e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFUser> findByESFArticleId(long esfArticleId,
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

		List<ESFArticle_ESFUser> list = (List<ESFArticle_ESFUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFArticle_ESFUser esfArticle_ESFUser : list) {
				if ((esfArticleId != esfArticle_ESFUser.getEsfArticleId())) {
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

			query.append(_SQL_SELECT_ESFARTICLE_ESFUSER_WHERE);

			query.append(_FINDER_COLUMN_ESFARTICLEID_ESFARTICLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFArticle_ESFUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfArticleId);

				if (!pagination) {
					list = (List<ESFArticle_ESFUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticle_ESFUser>(list);
				}
				else {
					list = (List<ESFArticle_ESFUser>)QueryUtil.list(q,
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
	 * Returns the first e s f article_ e s f user in the ordered set where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article_ e s f user
	 * @throws com.ethica.esf.NoSuchArticle_ESFUserException if a matching e s f article_ e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFUser findByESFArticleId_First(long esfArticleId,
		OrderByComparator orderByComparator)
		throws NoSuchArticle_ESFUserException, SystemException {
		ESFArticle_ESFUser esfArticle_ESFUser = fetchByESFArticleId_First(esfArticleId,
				orderByComparator);

		if (esfArticle_ESFUser != null) {
			return esfArticle_ESFUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfArticleId=");
		msg.append(esfArticleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticle_ESFUserException(msg.toString());
	}

	/**
	 * Returns the first e s f article_ e s f user in the ordered set where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article_ e s f user, or <code>null</code> if a matching e s f article_ e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFUser fetchByESFArticleId_First(long esfArticleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFArticle_ESFUser> list = findByESFArticleId(esfArticleId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f article_ e s f user in the ordered set where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article_ e s f user
	 * @throws com.ethica.esf.NoSuchArticle_ESFUserException if a matching e s f article_ e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFUser findByESFArticleId_Last(long esfArticleId,
		OrderByComparator orderByComparator)
		throws NoSuchArticle_ESFUserException, SystemException {
		ESFArticle_ESFUser esfArticle_ESFUser = fetchByESFArticleId_Last(esfArticleId,
				orderByComparator);

		if (esfArticle_ESFUser != null) {
			return esfArticle_ESFUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfArticleId=");
		msg.append(esfArticleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticle_ESFUserException(msg.toString());
	}

	/**
	 * Returns the last e s f article_ e s f user in the ordered set where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article_ e s f user, or <code>null</code> if a matching e s f article_ e s f user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFUser fetchByESFArticleId_Last(long esfArticleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByESFArticleId(esfArticleId);

		if (count == 0) {
			return null;
		}

		List<ESFArticle_ESFUser> list = findByESFArticleId(esfArticleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f article_ e s f users before and after the current e s f article_ e s f user in the ordered set where esfArticleId = &#63;.
	 *
	 * @param esfArticle_ESFUserPK the primary key of the current e s f article_ e s f user
	 * @param esfArticleId the esf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f article_ e s f user
	 * @throws com.ethica.esf.NoSuchArticle_ESFUserException if a e s f article_ e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFUser[] findByESFArticleId_PrevAndNext(
		ESFArticle_ESFUserPK esfArticle_ESFUserPK, long esfArticleId,
		OrderByComparator orderByComparator)
		throws NoSuchArticle_ESFUserException, SystemException {
		ESFArticle_ESFUser esfArticle_ESFUser = findByPrimaryKey(esfArticle_ESFUserPK);

		Session session = null;

		try {
			session = openSession();

			ESFArticle_ESFUser[] array = new ESFArticle_ESFUserImpl[3];

			array[0] = getByESFArticleId_PrevAndNext(session,
					esfArticle_ESFUser, esfArticleId, orderByComparator, true);

			array[1] = esfArticle_ESFUser;

			array[2] = getByESFArticleId_PrevAndNext(session,
					esfArticle_ESFUser, esfArticleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFArticle_ESFUser getByESFArticleId_PrevAndNext(
		Session session, ESFArticle_ESFUser esfArticle_ESFUser,
		long esfArticleId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFARTICLE_ESFUSER_WHERE);

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
			query.append(ESFArticle_ESFUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfArticleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfArticle_ESFUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFArticle_ESFUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f article_ e s f users where esfArticleId = &#63; from the database.
	 *
	 * @param esfArticleId the esf article ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByESFArticleId(long esfArticleId)
		throws SystemException {
		for (ESFArticle_ESFUser esfArticle_ESFUser : findByESFArticleId(
				esfArticleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfArticle_ESFUser);
		}
	}

	/**
	 * Returns the number of e s f article_ e s f users where esfArticleId = &#63;.
	 *
	 * @param esfArticleId the esf article ID
	 * @return the number of matching e s f article_ e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByESFArticleId(long esfArticleId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ESFARTICLEID;

		Object[] finderArgs = new Object[] { esfArticleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFARTICLE_ESFUSER_WHERE);

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

	private static final String _FINDER_COLUMN_ESFARTICLEID_ESFARTICLEID_2 = "esfArticle_ESFUser.id.esfArticleId = ?";

	public ESFArticle_ESFUserPersistenceImpl() {
		setModelClass(ESFArticle_ESFUser.class);
	}

	/**
	 * Caches the e s f article_ e s f user in the entity cache if it is enabled.
	 *
	 * @param esfArticle_ESFUser the e s f article_ e s f user
	 */
	@Override
	public void cacheResult(ESFArticle_ESFUser esfArticle_ESFUser) {
		EntityCacheUtil.putResult(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFUserImpl.class, esfArticle_ESFUser.getPrimaryKey(),
			esfArticle_ESFUser);

		esfArticle_ESFUser.resetOriginalValues();
	}

	/**
	 * Caches the e s f article_ e s f users in the entity cache if it is enabled.
	 *
	 * @param esfArticle_ESFUsers the e s f article_ e s f users
	 */
	@Override
	public void cacheResult(List<ESFArticle_ESFUser> esfArticle_ESFUsers) {
		for (ESFArticle_ESFUser esfArticle_ESFUser : esfArticle_ESFUsers) {
			if (EntityCacheUtil.getResult(
						ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
						ESFArticle_ESFUserImpl.class,
						esfArticle_ESFUser.getPrimaryKey()) == null) {
				cacheResult(esfArticle_ESFUser);
			}
			else {
				esfArticle_ESFUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f article_ e s f users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFArticle_ESFUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFArticle_ESFUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f article_ e s f user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFArticle_ESFUser esfArticle_ESFUser) {
		EntityCacheUtil.removeResult(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFUserImpl.class, esfArticle_ESFUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ESFArticle_ESFUser> esfArticle_ESFUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFArticle_ESFUser esfArticle_ESFUser : esfArticle_ESFUsers) {
			EntityCacheUtil.removeResult(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
				ESFArticle_ESFUserImpl.class, esfArticle_ESFUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f article_ e s f user with the primary key. Does not add the e s f article_ e s f user to the database.
	 *
	 * @param esfArticle_ESFUserPK the primary key for the new e s f article_ e s f user
	 * @return the new e s f article_ e s f user
	 */
	@Override
	public ESFArticle_ESFUser create(ESFArticle_ESFUserPK esfArticle_ESFUserPK) {
		ESFArticle_ESFUser esfArticle_ESFUser = new ESFArticle_ESFUserImpl();

		esfArticle_ESFUser.setNew(true);
		esfArticle_ESFUser.setPrimaryKey(esfArticle_ESFUserPK);

		return esfArticle_ESFUser;
	}

	/**
	 * Removes the e s f article_ e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfArticle_ESFUserPK the primary key of the e s f article_ e s f user
	 * @return the e s f article_ e s f user that was removed
	 * @throws com.ethica.esf.NoSuchArticle_ESFUserException if a e s f article_ e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFUser remove(ESFArticle_ESFUserPK esfArticle_ESFUserPK)
		throws NoSuchArticle_ESFUserException, SystemException {
		return remove((Serializable)esfArticle_ESFUserPK);
	}

	/**
	 * Removes the e s f article_ e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f article_ e s f user
	 * @return the e s f article_ e s f user that was removed
	 * @throws com.ethica.esf.NoSuchArticle_ESFUserException if a e s f article_ e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFUser remove(Serializable primaryKey)
		throws NoSuchArticle_ESFUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFArticle_ESFUser esfArticle_ESFUser = (ESFArticle_ESFUser)session.get(ESFArticle_ESFUserImpl.class,
					primaryKey);

			if (esfArticle_ESFUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticle_ESFUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfArticle_ESFUser);
		}
		catch (NoSuchArticle_ESFUserException nsee) {
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
	protected ESFArticle_ESFUser removeImpl(
		ESFArticle_ESFUser esfArticle_ESFUser) throws SystemException {
		esfArticle_ESFUser = toUnwrappedModel(esfArticle_ESFUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfArticle_ESFUser)) {
				esfArticle_ESFUser = (ESFArticle_ESFUser)session.get(ESFArticle_ESFUserImpl.class,
						esfArticle_ESFUser.getPrimaryKeyObj());
			}

			if (esfArticle_ESFUser != null) {
				session.delete(esfArticle_ESFUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfArticle_ESFUser != null) {
			clearCache(esfArticle_ESFUser);
		}

		return esfArticle_ESFUser;
	}

	@Override
	public ESFArticle_ESFUser updateImpl(
		com.ethica.esf.model.ESFArticle_ESFUser esfArticle_ESFUser)
		throws SystemException {
		esfArticle_ESFUser = toUnwrappedModel(esfArticle_ESFUser);

		boolean isNew = esfArticle_ESFUser.isNew();

		ESFArticle_ESFUserModelImpl esfArticle_ESFUserModelImpl = (ESFArticle_ESFUserModelImpl)esfArticle_ESFUser;

		Session session = null;

		try {
			session = openSession();

			if (esfArticle_ESFUser.isNew()) {
				session.save(esfArticle_ESFUser);

				esfArticle_ESFUser.setNew(false);
			}
			else {
				session.merge(esfArticle_ESFUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFArticle_ESFUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfArticle_ESFUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFARTICLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfArticle_ESFUserModelImpl.getOriginalEsfArticleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFARTICLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFARTICLEID,
					args);

				args = new Object[] {
						esfArticle_ESFUserModelImpl.getEsfArticleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESFARTICLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESFARTICLEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticle_ESFUserImpl.class, esfArticle_ESFUser.getPrimaryKey(),
			esfArticle_ESFUser);

		return esfArticle_ESFUser;
	}

	protected ESFArticle_ESFUser toUnwrappedModel(
		ESFArticle_ESFUser esfArticle_ESFUser) {
		if (esfArticle_ESFUser instanceof ESFArticle_ESFUserImpl) {
			return esfArticle_ESFUser;
		}

		ESFArticle_ESFUserImpl esfArticle_ESFUserImpl = new ESFArticle_ESFUserImpl();

		esfArticle_ESFUserImpl.setNew(esfArticle_ESFUser.isNew());
		esfArticle_ESFUserImpl.setPrimaryKey(esfArticle_ESFUser.getPrimaryKey());

		esfArticle_ESFUserImpl.setEsfArticleId(esfArticle_ESFUser.getEsfArticleId());
		esfArticle_ESFUserImpl.setEsfUserId(esfArticle_ESFUser.getEsfUserId());
		esfArticle_ESFUserImpl.setXxxlQty(esfArticle_ESFUser.getXxxlQty());
		esfArticle_ESFUserImpl.setXxlQty(esfArticle_ESFUser.getXxlQty());
		esfArticle_ESFUserImpl.setXlQty(esfArticle_ESFUser.getXlQty());
		esfArticle_ESFUserImpl.setLQty(esfArticle_ESFUser.getLQty());
		esfArticle_ESFUserImpl.setMQty(esfArticle_ESFUser.getMQty());
		esfArticle_ESFUserImpl.setSQty(esfArticle_ESFUser.getSQty());
		esfArticle_ESFUserImpl.setXsQty(esfArticle_ESFUser.getXsQty());
		esfArticle_ESFUserImpl.setXxsQty(esfArticle_ESFUser.getXxsQty());
		esfArticle_ESFUserImpl.setOtherQty(esfArticle_ESFUser.getOtherQty());
		esfArticle_ESFUserImpl.setTotalQty(esfArticle_ESFUser.getTotalQty());
		esfArticle_ESFUserImpl.setDescription(esfArticle_ESFUser.getDescription());
		esfArticle_ESFUserImpl.setDeliveryDate(esfArticle_ESFUser.getDeliveryDate());

		return esfArticle_ESFUserImpl;
	}

	/**
	 * Returns the e s f article_ e s f user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f article_ e s f user
	 * @return the e s f article_ e s f user
	 * @throws com.ethica.esf.NoSuchArticle_ESFUserException if a e s f article_ e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticle_ESFUserException, SystemException {
		ESFArticle_ESFUser esfArticle_ESFUser = fetchByPrimaryKey(primaryKey);

		if (esfArticle_ESFUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticle_ESFUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfArticle_ESFUser;
	}

	/**
	 * Returns the e s f article_ e s f user with the primary key or throws a {@link com.ethica.esf.NoSuchArticle_ESFUserException} if it could not be found.
	 *
	 * @param esfArticle_ESFUserPK the primary key of the e s f article_ e s f user
	 * @return the e s f article_ e s f user
	 * @throws com.ethica.esf.NoSuchArticle_ESFUserException if a e s f article_ e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFUser findByPrimaryKey(
		ESFArticle_ESFUserPK esfArticle_ESFUserPK)
		throws NoSuchArticle_ESFUserException, SystemException {
		return findByPrimaryKey((Serializable)esfArticle_ESFUserPK);
	}

	/**
	 * Returns the e s f article_ e s f user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f article_ e s f user
	 * @return the e s f article_ e s f user, or <code>null</code> if a e s f article_ e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFArticle_ESFUser esfArticle_ESFUser = (ESFArticle_ESFUser)EntityCacheUtil.getResult(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
				ESFArticle_ESFUserImpl.class, primaryKey);

		if (esfArticle_ESFUser == _nullESFArticle_ESFUser) {
			return null;
		}

		if (esfArticle_ESFUser == null) {
			Session session = null;

			try {
				session = openSession();

				esfArticle_ESFUser = (ESFArticle_ESFUser)session.get(ESFArticle_ESFUserImpl.class,
						primaryKey);

				if (esfArticle_ESFUser != null) {
					cacheResult(esfArticle_ESFUser);
				}
				else {
					EntityCacheUtil.putResult(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
						ESFArticle_ESFUserImpl.class, primaryKey,
						_nullESFArticle_ESFUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFArticle_ESFUserModelImpl.ENTITY_CACHE_ENABLED,
					ESFArticle_ESFUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfArticle_ESFUser;
	}

	/**
	 * Returns the e s f article_ e s f user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfArticle_ESFUserPK the primary key of the e s f article_ e s f user
	 * @return the e s f article_ e s f user, or <code>null</code> if a e s f article_ e s f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle_ESFUser fetchByPrimaryKey(
		ESFArticle_ESFUserPK esfArticle_ESFUserPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfArticle_ESFUserPK);
	}

	/**
	 * Returns all the e s f article_ e s f users.
	 *
	 * @return the e s f article_ e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f article_ e s f users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f article_ e s f users
	 * @param end the upper bound of the range of e s f article_ e s f users (not inclusive)
	 * @return the range of e s f article_ e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f article_ e s f users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f article_ e s f users
	 * @param end the upper bound of the range of e s f article_ e s f users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f article_ e s f users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle_ESFUser> findAll(int start, int end,
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

		List<ESFArticle_ESFUser> list = (List<ESFArticle_ESFUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFARTICLE_ESFUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFARTICLE_ESFUSER;

				if (pagination) {
					sql = sql.concat(ESFArticle_ESFUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFArticle_ESFUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticle_ESFUser>(list);
				}
				else {
					list = (List<ESFArticle_ESFUser>)QueryUtil.list(q,
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
	 * Removes all the e s f article_ e s f users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFArticle_ESFUser esfArticle_ESFUser : findAll()) {
			remove(esfArticle_ESFUser);
		}
	}

	/**
	 * Returns the number of e s f article_ e s f users.
	 *
	 * @return the number of e s f article_ e s f users
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

				Query q = session.createQuery(_SQL_COUNT_ESFARTICLE_ESFUSER);

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
	 * Initializes the e s f article_ e s f user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ethica.esf.model.ESFArticle_ESFUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFArticle_ESFUser>> listenersList = new ArrayList<ModelListener<ESFArticle_ESFUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFArticle_ESFUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFArticle_ESFUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFARTICLE_ESFUSER = "SELECT esfArticle_ESFUser FROM ESFArticle_ESFUser esfArticle_ESFUser";
	private static final String _SQL_SELECT_ESFARTICLE_ESFUSER_WHERE = "SELECT esfArticle_ESFUser FROM ESFArticle_ESFUser esfArticle_ESFUser WHERE ";
	private static final String _SQL_COUNT_ESFARTICLE_ESFUSER = "SELECT COUNT(esfArticle_ESFUser) FROM ESFArticle_ESFUser esfArticle_ESFUser";
	private static final String _SQL_COUNT_ESFARTICLE_ESFUSER_WHERE = "SELECT COUNT(esfArticle_ESFUser) FROM ESFArticle_ESFUser esfArticle_ESFUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfArticle_ESFUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFArticle_ESFUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFArticle_ESFUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFArticle_ESFUserPersistenceImpl.class);
	private static ESFArticle_ESFUser _nullESFArticle_ESFUser = new ESFArticle_ESFUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFArticle_ESFUser> toCacheModel() {
				return _nullESFArticle_ESFUserCacheModel;
			}
		};

	private static CacheModel<ESFArticle_ESFUser> _nullESFArticle_ESFUserCacheModel =
		new CacheModel<ESFArticle_ESFUser>() {
			@Override
			public ESFArticle_ESFUser toEntityModel() {
				return _nullESFArticle_ESFUser;
			}
		};
}