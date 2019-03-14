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

import com.ethica.esf.NoSuchArticleException;
import com.ethica.esf.model.ESFArticle;
import com.ethica.esf.model.impl.ESFArticleImpl;
import com.ethica.esf.model.impl.ESFArticleModelImpl;

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
 * The persistence implementation for the e s f article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFArticlePersistence
 * @see ESFArticleUtil
 * @generated
 */
public class ESFArticlePersistenceImpl extends BasePersistenceImpl<ESFArticle>
	implements ESFArticlePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFArticleUtil} to access the e s f article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFArticleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleModelImpl.FINDER_CACHE_ENABLED, ESFArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleModelImpl.FINDER_CACHE_ENABLED, ESFArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ARTICLECODE = new FinderPath(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleModelImpl.FINDER_CACHE_ENABLED, ESFArticleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByArticleCode",
			new String[] { String.class.getName() },
			ESFArticleModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLECODE = new FinderPath(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticleCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f article where code = &#63; or throws a {@link com.ethica.esf.NoSuchArticleException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching e s f article
	 * @throws com.ethica.esf.NoSuchArticleException if a matching e s f article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle findByArticleCode(String code)
		throws NoSuchArticleException, SystemException {
		ESFArticle esfArticle = fetchByArticleCode(code);

		if (esfArticle == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchArticleException(msg.toString());
		}

		return esfArticle;
	}

	/**
	 * Returns the e s f article where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching e s f article, or <code>null</code> if a matching e s f article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle fetchByArticleCode(String code) throws SystemException {
		return fetchByArticleCode(code, true);
	}

	/**
	 * Returns the e s f article where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f article, or <code>null</code> if a matching e s f article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle fetchByArticleCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ARTICLECODE,
					finderArgs, this);
		}

		if (result instanceof ESFArticle) {
			ESFArticle esfArticle = (ESFArticle)result;

			if (!Validator.equals(code, esfArticle.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFARTICLE_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_ARTICLECODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ARTICLECODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_ARTICLECODE_CODE_2);
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

				List<ESFArticle> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLECODE,
						finderArgs, list);
				}
				else {
					ESFArticle esfArticle = list.get(0);

					result = esfArticle;

					cacheResult(esfArticle);

					if ((esfArticle.getCode() == null) ||
							!esfArticle.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLECODE,
							finderArgs, esfArticle);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLECODE,
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
			return (ESFArticle)result;
		}
	}

	/**
	 * Removes the e s f article where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the e s f article that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle removeByArticleCode(String code)
		throws NoSuchArticleException, SystemException {
		ESFArticle esfArticle = findByArticleCode(code);

		return remove(esfArticle);
	}

	/**
	 * Returns the number of e s f articles where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByArticleCode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTICLECODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFARTICLE_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_ARTICLECODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ARTICLECODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_ARTICLECODE_CODE_2);
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

	private static final String _FINDER_COLUMN_ARTICLECODE_CODE_1 = "esfArticle.code IS NULL";
	private static final String _FINDER_COLUMN_ARTICLECODE_CODE_2 = "esfArticle.code = ?";
	private static final String _FINDER_COLUMN_ARTICLECODE_CODE_3 = "(esfArticle.code IS NULL OR esfArticle.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLETYPE =
		new FinderPath(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleModelImpl.FINDER_CACHE_ENABLED, ESFArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticleType",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLETYPE =
		new FinderPath(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleModelImpl.FINDER_CACHE_ENABLED, ESFArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticleType",
			new String[] { Long.class.getName() },
			ESFArticleModelImpl.ESFARTICLETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLETYPE = new FinderPath(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticleType",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f articles where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @return the matching e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle> findByArticleType(long esfArticleTypeId)
		throws SystemException {
		return findByArticleType(esfArticleTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f articles where esfArticleTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param start the lower bound of the range of e s f articles
	 * @param end the upper bound of the range of e s f articles (not inclusive)
	 * @return the range of matching e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle> findByArticleType(long esfArticleTypeId, int start,
		int end) throws SystemException {
		return findByArticleType(esfArticleTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f articles where esfArticleTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param start the lower bound of the range of e s f articles
	 * @param end the upper bound of the range of e s f articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle> findByArticleType(long esfArticleTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLETYPE;
			finderArgs = new Object[] { esfArticleTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLETYPE;
			finderArgs = new Object[] {
					esfArticleTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFArticle> list = (List<ESFArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFArticle esfArticle : list) {
				if ((esfArticleTypeId != esfArticle.getEsfArticleTypeId())) {
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

			query.append(_SQL_SELECT_ESFARTICLE_WHERE);

			query.append(_FINDER_COLUMN_ARTICLETYPE_ESFARTICLETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfArticleTypeId);

				if (!pagination) {
					list = (List<ESFArticle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticle>(list);
				}
				else {
					list = (List<ESFArticle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f article in the ordered set where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article
	 * @throws com.ethica.esf.NoSuchArticleException if a matching e s f article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle findByArticleType_First(long esfArticleTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		ESFArticle esfArticle = fetchByArticleType_First(esfArticleTypeId,
				orderByComparator);

		if (esfArticle != null) {
			return esfArticle;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfArticleTypeId=");
		msg.append(esfArticleTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the first e s f article in the ordered set where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article, or <code>null</code> if a matching e s f article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle fetchByArticleType_First(long esfArticleTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFArticle> list = findByArticleType(esfArticleTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f article in the ordered set where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article
	 * @throws com.ethica.esf.NoSuchArticleException if a matching e s f article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle findByArticleType_Last(long esfArticleTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		ESFArticle esfArticle = fetchByArticleType_Last(esfArticleTypeId,
				orderByComparator);

		if (esfArticle != null) {
			return esfArticle;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfArticleTypeId=");
		msg.append(esfArticleTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the last e s f article in the ordered set where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article, or <code>null</code> if a matching e s f article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle fetchByArticleType_Last(long esfArticleTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByArticleType(esfArticleTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFArticle> list = findByArticleType(esfArticleTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f articles before and after the current e s f article in the ordered set where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleId the primary key of the current e s f article
	 * @param esfArticleTypeId the esf article type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f article
	 * @throws com.ethica.esf.NoSuchArticleException if a e s f article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle[] findByArticleType_PrevAndNext(long esfArticleId,
		long esfArticleTypeId, OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		ESFArticle esfArticle = findByPrimaryKey(esfArticleId);

		Session session = null;

		try {
			session = openSession();

			ESFArticle[] array = new ESFArticleImpl[3];

			array[0] = getByArticleType_PrevAndNext(session, esfArticle,
					esfArticleTypeId, orderByComparator, true);

			array[1] = esfArticle;

			array[2] = getByArticleType_PrevAndNext(session, esfArticle,
					esfArticleTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFArticle getByArticleType_PrevAndNext(Session session,
		ESFArticle esfArticle, long esfArticleTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFARTICLE_WHERE);

		query.append(_FINDER_COLUMN_ARTICLETYPE_ESFARTICLETYPEID_2);

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
			query.append(ESFArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(esfArticleTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfArticle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFArticle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f articles where esfArticleTypeId = &#63; from the database.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByArticleType(long esfArticleTypeId)
		throws SystemException {
		for (ESFArticle esfArticle : findByArticleType(esfArticleTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfArticle);
		}
	}

	/**
	 * Returns the number of e s f articles where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @return the number of matching e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByArticleType(long esfArticleTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTICLETYPE;

		Object[] finderArgs = new Object[] { esfArticleTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFARTICLE_WHERE);

			query.append(_FINDER_COLUMN_ARTICLETYPE_ESFARTICLETYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfArticleTypeId);

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

	private static final String _FINDER_COLUMN_ARTICLETYPE_ESFARTICLETYPEID_2 = "esfArticle.esfArticleTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleModelImpl.FINDER_CACHE_ENABLED, ESFArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleModelImpl.FINDER_CACHE_ENABLED, ESFArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			ESFArticleModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f articles where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f articles where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f articles
	 * @param end the upper bound of the range of e s f articles (not inclusive)
	 * @return the range of matching e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f articles where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f articles
	 * @param end the upper bound of the range of e s f articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<ESFArticle> list = (List<ESFArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFArticle esfArticle : list) {
				if (!Validator.equals(name, esfArticle.getName())) {
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

			query.append(_SQL_SELECT_ESFARTICLE_WHERE);

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
				query.append(ESFArticleModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFArticle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticle>(list);
				}
				else {
					list = (List<ESFArticle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f article in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article
	 * @throws com.ethica.esf.NoSuchArticleException if a matching e s f article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		ESFArticle esfArticle = fetchByName_First(name, orderByComparator);

		if (esfArticle != null) {
			return esfArticle;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the first e s f article in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article, or <code>null</code> if a matching e s f article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFArticle> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f article in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article
	 * @throws com.ethica.esf.NoSuchArticleException if a matching e s f article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		ESFArticle esfArticle = fetchByName_Last(name, orderByComparator);

		if (esfArticle != null) {
			return esfArticle;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the last e s f article in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article, or <code>null</code> if a matching e s f article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ESFArticle> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f articles before and after the current e s f article in the ordered set where name = &#63;.
	 *
	 * @param esfArticleId the primary key of the current e s f article
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f article
	 * @throws com.ethica.esf.NoSuchArticleException if a e s f article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle[] findByName_PrevAndNext(long esfArticleId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		ESFArticle esfArticle = findByPrimaryKey(esfArticleId);

		Session session = null;

		try {
			session = openSession();

			ESFArticle[] array = new ESFArticleImpl[3];

			array[0] = getByName_PrevAndNext(session, esfArticle, name,
					orderByComparator, true);

			array[1] = esfArticle;

			array[2] = getByName_PrevAndNext(session, esfArticle, name,
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

	protected ESFArticle getByName_PrevAndNext(Session session,
		ESFArticle esfArticle, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFARTICLE_WHERE);

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
			query.append(ESFArticleModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfArticle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFArticle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f articles where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (ESFArticle esfArticle : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfArticle);
		}
	}

	/**
	 * Returns the number of e s f articles where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFARTICLE_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "esfArticle.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "esfArticle.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(esfArticle.name IS NULL OR esfArticle.name = '')";

	public ESFArticlePersistenceImpl() {
		setModelClass(ESFArticle.class);
	}

	/**
	 * Caches the e s f article in the entity cache if it is enabled.
	 *
	 * @param esfArticle the e s f article
	 */
	@Override
	public void cacheResult(ESFArticle esfArticle) {
		EntityCacheUtil.putResult(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleImpl.class, esfArticle.getPrimaryKey(), esfArticle);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLECODE,
			new Object[] { esfArticle.getCode() }, esfArticle);

		esfArticle.resetOriginalValues();
	}

	/**
	 * Caches the e s f articles in the entity cache if it is enabled.
	 *
	 * @param esfArticles the e s f articles
	 */
	@Override
	public void cacheResult(List<ESFArticle> esfArticles) {
		for (ESFArticle esfArticle : esfArticles) {
			if (EntityCacheUtil.getResult(
						ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
						ESFArticleImpl.class, esfArticle.getPrimaryKey()) == null) {
				cacheResult(esfArticle);
			}
			else {
				esfArticle.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f articles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFArticleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFArticleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f article.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFArticle esfArticle) {
		EntityCacheUtil.removeResult(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleImpl.class, esfArticle.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfArticle);
	}

	@Override
	public void clearCache(List<ESFArticle> esfArticles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFArticle esfArticle : esfArticles) {
			EntityCacheUtil.removeResult(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
				ESFArticleImpl.class, esfArticle.getPrimaryKey());

			clearUniqueFindersCache(esfArticle);
		}
	}

	protected void cacheUniqueFindersCache(ESFArticle esfArticle) {
		if (esfArticle.isNew()) {
			Object[] args = new Object[] { esfArticle.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLECODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLECODE, args,
				esfArticle);
		}
		else {
			ESFArticleModelImpl esfArticleModelImpl = (ESFArticleModelImpl)esfArticle;

			if ((esfArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ARTICLECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfArticle.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLECODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLECODE,
					args, esfArticle);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFArticle esfArticle) {
		ESFArticleModelImpl esfArticleModelImpl = (ESFArticleModelImpl)esfArticle;

		Object[] args = new Object[] { esfArticle.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLECODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLECODE, args);

		if ((esfArticleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ARTICLECODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfArticleModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLECODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLECODE, args);
		}
	}

	/**
	 * Creates a new e s f article with the primary key. Does not add the e s f article to the database.
	 *
	 * @param esfArticleId the primary key for the new e s f article
	 * @return the new e s f article
	 */
	@Override
	public ESFArticle create(long esfArticleId) {
		ESFArticle esfArticle = new ESFArticleImpl();

		esfArticle.setNew(true);
		esfArticle.setPrimaryKey(esfArticleId);

		return esfArticle;
	}

	/**
	 * Removes the e s f article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfArticleId the primary key of the e s f article
	 * @return the e s f article that was removed
	 * @throws com.ethica.esf.NoSuchArticleException if a e s f article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle remove(long esfArticleId)
		throws NoSuchArticleException, SystemException {
		return remove((Serializable)esfArticleId);
	}

	/**
	 * Removes the e s f article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f article
	 * @return the e s f article that was removed
	 * @throws com.ethica.esf.NoSuchArticleException if a e s f article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle remove(Serializable primaryKey)
		throws NoSuchArticleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFArticle esfArticle = (ESFArticle)session.get(ESFArticleImpl.class,
					primaryKey);

			if (esfArticle == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfArticle);
		}
		catch (NoSuchArticleException nsee) {
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
	protected ESFArticle removeImpl(ESFArticle esfArticle)
		throws SystemException {
		esfArticle = toUnwrappedModel(esfArticle);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfArticle)) {
				esfArticle = (ESFArticle)session.get(ESFArticleImpl.class,
						esfArticle.getPrimaryKeyObj());
			}

			if (esfArticle != null) {
				session.delete(esfArticle);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfArticle != null) {
			clearCache(esfArticle);
		}

		return esfArticle;
	}

	@Override
	public ESFArticle updateImpl(com.ethica.esf.model.ESFArticle esfArticle)
		throws SystemException {
		esfArticle = toUnwrappedModel(esfArticle);

		boolean isNew = esfArticle.isNew();

		ESFArticleModelImpl esfArticleModelImpl = (ESFArticleModelImpl)esfArticle;

		Session session = null;

		try {
			session = openSession();

			if (esfArticle.isNew()) {
				session.save(esfArticle);

				esfArticle.setNew(false);
			}
			else {
				session.merge(esfArticle);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFArticleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfArticleModelImpl.getOriginalEsfArticleTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLETYPE,
					args);

				args = new Object[] { esfArticleModelImpl.getEsfArticleTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLETYPE,
					args);
			}

			if ((esfArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfArticleModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { esfArticleModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleImpl.class, esfArticle.getPrimaryKey(), esfArticle);

		clearUniqueFindersCache(esfArticle);
		cacheUniqueFindersCache(esfArticle);

		return esfArticle;
	}

	protected ESFArticle toUnwrappedModel(ESFArticle esfArticle) {
		if (esfArticle instanceof ESFArticleImpl) {
			return esfArticle;
		}

		ESFArticleImpl esfArticleImpl = new ESFArticleImpl();

		esfArticleImpl.setNew(esfArticle.isNew());
		esfArticleImpl.setPrimaryKey(esfArticle.getPrimaryKey());

		esfArticleImpl.setEsfArticleId(esfArticle.getEsfArticleId());
		esfArticleImpl.setCode(esfArticle.getCode());
		esfArticleImpl.setName(esfArticle.getName());
		esfArticleImpl.setDescription(esfArticle.getDescription());
		esfArticleImpl.setEsfArticleTypeId(esfArticle.getEsfArticleTypeId());
		esfArticleImpl.setXxxlQty(esfArticle.getXxxlQty());
		esfArticleImpl.setXxlQty(esfArticle.getXxlQty());
		esfArticleImpl.setXlQty(esfArticle.getXlQty());
		esfArticleImpl.setLQty(esfArticle.getLQty());
		esfArticleImpl.setMQty(esfArticle.getMQty());
		esfArticleImpl.setSQty(esfArticle.getSQty());
		esfArticleImpl.setXsQty(esfArticle.getXsQty());
		esfArticleImpl.setXxsQty(esfArticle.getXxsQty());
		esfArticleImpl.setOtherQty(esfArticle.getOtherQty());
		esfArticleImpl.setPrice(esfArticle.getPrice());
		esfArticleImpl.setTax(esfArticle.getTax());
		esfArticleImpl.setSale(esfArticle.getSale());

		return esfArticleImpl;
	}

	/**
	 * Returns the e s f article with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f article
	 * @return the e s f article
	 * @throws com.ethica.esf.NoSuchArticleException if a e s f article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleException, SystemException {
		ESFArticle esfArticle = fetchByPrimaryKey(primaryKey);

		if (esfArticle == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfArticle;
	}

	/**
	 * Returns the e s f article with the primary key or throws a {@link com.ethica.esf.NoSuchArticleException} if it could not be found.
	 *
	 * @param esfArticleId the primary key of the e s f article
	 * @return the e s f article
	 * @throws com.ethica.esf.NoSuchArticleException if a e s f article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle findByPrimaryKey(long esfArticleId)
		throws NoSuchArticleException, SystemException {
		return findByPrimaryKey((Serializable)esfArticleId);
	}

	/**
	 * Returns the e s f article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f article
	 * @return the e s f article, or <code>null</code> if a e s f article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFArticle esfArticle = (ESFArticle)EntityCacheUtil.getResult(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
				ESFArticleImpl.class, primaryKey);

		if (esfArticle == _nullESFArticle) {
			return null;
		}

		if (esfArticle == null) {
			Session session = null;

			try {
				session = openSession();

				esfArticle = (ESFArticle)session.get(ESFArticleImpl.class,
						primaryKey);

				if (esfArticle != null) {
					cacheResult(esfArticle);
				}
				else {
					EntityCacheUtil.putResult(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
						ESFArticleImpl.class, primaryKey, _nullESFArticle);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFArticleModelImpl.ENTITY_CACHE_ENABLED,
					ESFArticleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfArticle;
	}

	/**
	 * Returns the e s f article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfArticleId the primary key of the e s f article
	 * @return the e s f article, or <code>null</code> if a e s f article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticle fetchByPrimaryKey(long esfArticleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfArticleId);
	}

	/**
	 * Returns all the e s f articles.
	 *
	 * @return the e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f articles
	 * @param end the upper bound of the range of e s f articles (not inclusive)
	 * @return the range of e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f articles
	 * @param end the upper bound of the range of e s f articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticle> findAll(int start, int end,
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

		List<ESFArticle> list = (List<ESFArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFARTICLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFARTICLE;

				if (pagination) {
					sql = sql.concat(ESFArticleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFArticle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticle>(list);
				}
				else {
					list = (List<ESFArticle>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f articles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFArticle esfArticle : findAll()) {
			remove(esfArticle);
		}
	}

	/**
	 * Returns the number of e s f articles.
	 *
	 * @return the number of e s f articles
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

				Query q = session.createQuery(_SQL_COUNT_ESFARTICLE);

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
	 * Initializes the e s f article persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ethica.esf.model.ESFArticle")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFArticle>> listenersList = new ArrayList<ModelListener<ESFArticle>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFArticle>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFArticleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFARTICLE = "SELECT esfArticle FROM ESFArticle esfArticle";
	private static final String _SQL_SELECT_ESFARTICLE_WHERE = "SELECT esfArticle FROM ESFArticle esfArticle WHERE ";
	private static final String _SQL_COUNT_ESFARTICLE = "SELECT COUNT(esfArticle) FROM ESFArticle esfArticle";
	private static final String _SQL_COUNT_ESFARTICLE_WHERE = "SELECT COUNT(esfArticle) FROM ESFArticle esfArticle WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfArticle.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFArticle exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFArticle exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFArticlePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code", "sale"
			});
	private static ESFArticle _nullESFArticle = new ESFArticleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFArticle> toCacheModel() {
				return _nullESFArticleCacheModel;
			}
		};

	private static CacheModel<ESFArticle> _nullESFArticleCacheModel = new CacheModel<ESFArticle>() {
			@Override
			public ESFArticle toEntityModel() {
				return _nullESFArticle;
			}
		};
}