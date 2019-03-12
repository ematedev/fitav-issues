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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchMatchTypeException;
import it.ethica.esf.model.ESFMatchType;
import it.ethica.esf.model.impl.ESFMatchTypeImpl;
import it.ethica.esf.model.impl.ESFMatchTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f match type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFMatchTypePersistence
 * @see ESFMatchTypeUtil
 * @generated
 */
public class ESFMatchTypePersistenceImpl extends BasePersistenceImpl<ESFMatchType>
	implements ESFMatchTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFMatchTypeUtil} to access the e s f match type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFMatchTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeModelImpl.FINDER_CACHE_ENABLED, ESFMatchTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeModelImpl.FINDER_CACHE_ENABLED, ESFMatchTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeModelImpl.FINDER_CACHE_ENABLED, ESFMatchTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			ESFMatchTypeModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f match type where code = &#63; or throws a {@link it.ethica.esf.NoSuchMatchTypeException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching e s f match type
	 * @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType findByCode(String code)
		throws NoSuchMatchTypeException, SystemException {
		ESFMatchType esfMatchType = fetchByCode(code);

		if (esfMatchType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMatchTypeException(msg.toString());
		}

		return esfMatchType;
	}

	/**
	 * Returns the e s f match type where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the e s f match type where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ESFMatchType) {
			ESFMatchType esfMatchType = (ESFMatchType)result;

			if (!Validator.equals(code, esfMatchType.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFMATCHTYPE_WHERE);

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

				List<ESFMatchType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					ESFMatchType esfMatchType = list.get(0);

					result = esfMatchType;

					cacheResult(esfMatchType);

					if ((esfMatchType.getCode() == null) ||
							!esfMatchType.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, esfMatchType);
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
			return (ESFMatchType)result;
		}
	}

	/**
	 * Removes the e s f match type where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the e s f match type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType removeByCode(String code)
		throws NoSuchMatchTypeException, SystemException {
		ESFMatchType esfMatchType = findByCode(code);

		return remove(esfMatchType);
	}

	/**
	 * Returns the number of e s f match types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f match types
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

			query.append(_SQL_COUNT_ESFMATCHTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfMatchType.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfMatchType.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfMatchType.code IS NULL OR esfMatchType.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISNATIONAL =
		new FinderPath(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeModelImpl.FINDER_CACHE_ENABLED, ESFMatchTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsNational",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISNATIONAL =
		new FinderPath(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeModelImpl.FINDER_CACHE_ENABLED, ESFMatchTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsNational",
			new String[] { Boolean.class.getName() },
			ESFMatchTypeModelImpl.ISNATIONAL_COLUMN_BITMASK |
			ESFMatchTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISNATIONAL = new FinderPath(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsNational",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the e s f match types where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @return the matching e s f match types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchType> findByIsNational(boolean isNational)
		throws SystemException {
		return findByIsNational(isNational, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f match types where isNational = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isNational the is national
	 * @param start the lower bound of the range of e s f match types
	 * @param end the upper bound of the range of e s f match types (not inclusive)
	 * @return the range of matching e s f match types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchType> findByIsNational(boolean isNational, int start,
		int end) throws SystemException {
		return findByIsNational(isNational, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f match types where isNational = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isNational the is national
	 * @param start the lower bound of the range of e s f match types
	 * @param end the upper bound of the range of e s f match types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f match types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchType> findByIsNational(boolean isNational, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISNATIONAL;
			finderArgs = new Object[] { isNational };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISNATIONAL;
			finderArgs = new Object[] { isNational, start, end, orderByComparator };
		}

		List<ESFMatchType> list = (List<ESFMatchType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFMatchType esfMatchType : list) {
				if ((isNational != esfMatchType.getIsNational())) {
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

			query.append(_SQL_SELECT_ESFMATCHTYPE_WHERE);

			query.append(_FINDER_COLUMN_ISNATIONAL_ISNATIONAL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFMatchTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isNational);

				if (!pagination) {
					list = (List<ESFMatchType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatchType>(list);
				}
				else {
					list = (List<ESFMatchType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f match type in the ordered set where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match type
	 * @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType findByIsNational_First(boolean isNational,
		OrderByComparator orderByComparator)
		throws NoSuchMatchTypeException, SystemException {
		ESFMatchType esfMatchType = fetchByIsNational_First(isNational,
				orderByComparator);

		if (esfMatchType != null) {
			return esfMatchType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isNational=");
		msg.append(isNational);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f match type in the ordered set where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType fetchByIsNational_First(boolean isNational,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFMatchType> list = findByIsNational(isNational, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f match type in the ordered set where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match type
	 * @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType findByIsNational_Last(boolean isNational,
		OrderByComparator orderByComparator)
		throws NoSuchMatchTypeException, SystemException {
		ESFMatchType esfMatchType = fetchByIsNational_Last(isNational,
				orderByComparator);

		if (esfMatchType != null) {
			return esfMatchType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isNational=");
		msg.append(isNational);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMatchTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f match type in the ordered set where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType fetchByIsNational_Last(boolean isNational,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIsNational(isNational);

		if (count == 0) {
			return null;
		}

		List<ESFMatchType> list = findByIsNational(isNational, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f match types before and after the current e s f match type in the ordered set where isNational = &#63;.
	 *
	 * @param esfMatchTypeId the primary key of the current e s f match type
	 * @param isNational the is national
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f match type
	 * @throws it.ethica.esf.NoSuchMatchTypeException if a e s f match type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType[] findByIsNational_PrevAndNext(long esfMatchTypeId,
		boolean isNational, OrderByComparator orderByComparator)
		throws NoSuchMatchTypeException, SystemException {
		ESFMatchType esfMatchType = findByPrimaryKey(esfMatchTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFMatchType[] array = new ESFMatchTypeImpl[3];

			array[0] = getByIsNational_PrevAndNext(session, esfMatchType,
					isNational, orderByComparator, true);

			array[1] = esfMatchType;

			array[2] = getByIsNational_PrevAndNext(session, esfMatchType,
					isNational, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFMatchType getByIsNational_PrevAndNext(Session session,
		ESFMatchType esfMatchType, boolean isNational,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFMATCHTYPE_WHERE);

		query.append(_FINDER_COLUMN_ISNATIONAL_ISNATIONAL_2);

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
			query.append(ESFMatchTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isNational);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfMatchType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFMatchType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f match types where isNational = &#63; from the database.
	 *
	 * @param isNational the is national
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIsNational(boolean isNational)
		throws SystemException {
		for (ESFMatchType esfMatchType : findByIsNational(isNational,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfMatchType);
		}
	}

	/**
	 * Returns the number of e s f match types where isNational = &#63;.
	 *
	 * @param isNational the is national
	 * @return the number of matching e s f match types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIsNational(boolean isNational) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISNATIONAL;

		Object[] finderArgs = new Object[] { isNational };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFMATCHTYPE_WHERE);

			query.append(_FINDER_COLUMN_ISNATIONAL_ISNATIONAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isNational);

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

	private static final String _FINDER_COLUMN_ISNATIONAL_ISNATIONAL_2 = "esfMatchType.isNational = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION = new FinderPath(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeModelImpl.FINDER_CACHE_ENABLED, ESFMatchTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByfindByDescription",
			new String[] { String.class.getName() },
			ESFMatchTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYDESCRIPTION = new FinderPath(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByDescription", new String[] { String.class.getName() });

	/**
	 * Returns the e s f match type where name = &#63; or throws a {@link it.ethica.esf.NoSuchMatchTypeException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching e s f match type
	 * @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType findByfindByDescription(String name)
		throws NoSuchMatchTypeException, SystemException {
		ESFMatchType esfMatchType = fetchByfindByDescription(name);

		if (esfMatchType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMatchTypeException(msg.toString());
		}

		return esfMatchType;
	}

	/**
	 * Returns the e s f match type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType fetchByfindByDescription(String name)
		throws SystemException {
		return fetchByfindByDescription(name, true);
	}

	/**
	 * Returns the e s f match type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType fetchByfindByDescription(String name,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION,
					finderArgs, this);
		}

		if (result instanceof ESFMatchType) {
			ESFMatchType esfMatchType = (ESFMatchType)result;

			if (!Validator.equals(name, esfMatchType.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFMATCHTYPE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_FINDBYDESCRIPTION_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FINDBYDESCRIPTION_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_FINDBYDESCRIPTION_NAME_2);
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

				List<ESFMatchType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFMatchTypePersistenceImpl.fetchByfindByDescription(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFMatchType esfMatchType = list.get(0);

					result = esfMatchType;

					cacheResult(esfMatchType);

					if ((esfMatchType.getName() == null) ||
							!esfMatchType.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION,
							finderArgs, esfMatchType);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION,
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
			return (ESFMatchType)result;
		}
	}

	/**
	 * Removes the e s f match type where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the e s f match type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType removeByfindByDescription(String name)
		throws NoSuchMatchTypeException, SystemException {
		ESFMatchType esfMatchType = findByfindByDescription(name);

		return remove(esfMatchType);
	}

	/**
	 * Returns the number of e s f match types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f match types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindByDescription(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYDESCRIPTION;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFMATCHTYPE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_FINDBYDESCRIPTION_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FINDBYDESCRIPTION_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_FINDBYDESCRIPTION_NAME_2);
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

	private static final String _FINDER_COLUMN_FINDBYDESCRIPTION_NAME_1 = "esfMatchType.name IS NULL";
	private static final String _FINDER_COLUMN_FINDBYDESCRIPTION_NAME_2 = "esfMatchType.name = ?";
	private static final String _FINDER_COLUMN_FINDBYDESCRIPTION_NAME_3 = "(esfMatchType.name IS NULL OR esfMatchType.name = '')";

	public ESFMatchTypePersistenceImpl() {
		setModelClass(ESFMatchType.class);
	}

	/**
	 * Caches the e s f match type in the entity cache if it is enabled.
	 *
	 * @param esfMatchType the e s f match type
	 */
	@Override
	public void cacheResult(ESFMatchType esfMatchType) {
		EntityCacheUtil.putResult(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeImpl.class, esfMatchType.getPrimaryKey(), esfMatchType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { esfMatchType.getCode() }, esfMatchType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION,
			new Object[] { esfMatchType.getName() }, esfMatchType);

		esfMatchType.resetOriginalValues();
	}

	/**
	 * Caches the e s f match types in the entity cache if it is enabled.
	 *
	 * @param esfMatchTypes the e s f match types
	 */
	@Override
	public void cacheResult(List<ESFMatchType> esfMatchTypes) {
		for (ESFMatchType esfMatchType : esfMatchTypes) {
			if (EntityCacheUtil.getResult(
						ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFMatchTypeImpl.class, esfMatchType.getPrimaryKey()) == null) {
				cacheResult(esfMatchType);
			}
			else {
				esfMatchType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f match types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFMatchTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFMatchTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f match type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFMatchType esfMatchType) {
		EntityCacheUtil.removeResult(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeImpl.class, esfMatchType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfMatchType);
	}

	@Override
	public void clearCache(List<ESFMatchType> esfMatchTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFMatchType esfMatchType : esfMatchTypes) {
			EntityCacheUtil.removeResult(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFMatchTypeImpl.class, esfMatchType.getPrimaryKey());

			clearUniqueFindersCache(esfMatchType);
		}
	}

	protected void cacheUniqueFindersCache(ESFMatchType esfMatchType) {
		if (esfMatchType.isNew()) {
			Object[] args = new Object[] { esfMatchType.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
				esfMatchType);

			args = new Object[] { esfMatchType.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYDESCRIPTION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION,
				args, esfMatchType);
		}
		else {
			ESFMatchTypeModelImpl esfMatchTypeModelImpl = (ESFMatchTypeModelImpl)esfMatchType;

			if ((esfMatchTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfMatchType.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					esfMatchType);
			}

			if ((esfMatchTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfMatchType.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYDESCRIPTION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION,
					args, esfMatchType);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFMatchType esfMatchType) {
		ESFMatchTypeModelImpl esfMatchTypeModelImpl = (ESFMatchTypeModelImpl)esfMatchType;

		Object[] args = new Object[] { esfMatchType.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((esfMatchTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfMatchTypeModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}

		args = new Object[] { esfMatchType.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYDESCRIPTION,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION,
			args);

		if ((esfMatchTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION.getColumnBitmask()) != 0) {
			args = new Object[] { esfMatchTypeModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYDESCRIPTION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYDESCRIPTION,
				args);
		}
	}

	/**
	 * Creates a new e s f match type with the primary key. Does not add the e s f match type to the database.
	 *
	 * @param esfMatchTypeId the primary key for the new e s f match type
	 * @return the new e s f match type
	 */
	@Override
	public ESFMatchType create(long esfMatchTypeId) {
		ESFMatchType esfMatchType = new ESFMatchTypeImpl();

		esfMatchType.setNew(true);
		esfMatchType.setPrimaryKey(esfMatchTypeId);

		return esfMatchType;
	}

	/**
	 * Removes the e s f match type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfMatchTypeId the primary key of the e s f match type
	 * @return the e s f match type that was removed
	 * @throws it.ethica.esf.NoSuchMatchTypeException if a e s f match type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType remove(long esfMatchTypeId)
		throws NoSuchMatchTypeException, SystemException {
		return remove((Serializable)esfMatchTypeId);
	}

	/**
	 * Removes the e s f match type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f match type
	 * @return the e s f match type that was removed
	 * @throws it.ethica.esf.NoSuchMatchTypeException if a e s f match type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType remove(Serializable primaryKey)
		throws NoSuchMatchTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFMatchType esfMatchType = (ESFMatchType)session.get(ESFMatchTypeImpl.class,
					primaryKey);

			if (esfMatchType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMatchTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfMatchType);
		}
		catch (NoSuchMatchTypeException nsee) {
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
	protected ESFMatchType removeImpl(ESFMatchType esfMatchType)
		throws SystemException {
		esfMatchType = toUnwrappedModel(esfMatchType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfMatchType)) {
				esfMatchType = (ESFMatchType)session.get(ESFMatchTypeImpl.class,
						esfMatchType.getPrimaryKeyObj());
			}

			if (esfMatchType != null) {
				session.delete(esfMatchType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfMatchType != null) {
			clearCache(esfMatchType);
		}

		return esfMatchType;
	}

	@Override
	public ESFMatchType updateImpl(
		it.ethica.esf.model.ESFMatchType esfMatchType)
		throws SystemException {
		esfMatchType = toUnwrappedModel(esfMatchType);

		boolean isNew = esfMatchType.isNew();

		ESFMatchTypeModelImpl esfMatchTypeModelImpl = (ESFMatchTypeModelImpl)esfMatchType;

		Session session = null;

		try {
			session = openSession();

			if (esfMatchType.isNew()) {
				session.save(esfMatchType);

				esfMatchType.setNew(false);
			}
			else {
				session.merge(esfMatchType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFMatchTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfMatchTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISNATIONAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfMatchTypeModelImpl.getOriginalIsNational()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISNATIONAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISNATIONAL,
					args);

				args = new Object[] { esfMatchTypeModelImpl.getIsNational() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISNATIONAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISNATIONAL,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFMatchTypeImpl.class, esfMatchType.getPrimaryKey(), esfMatchType);

		clearUniqueFindersCache(esfMatchType);
		cacheUniqueFindersCache(esfMatchType);

		return esfMatchType;
	}

	protected ESFMatchType toUnwrappedModel(ESFMatchType esfMatchType) {
		if (esfMatchType instanceof ESFMatchTypeImpl) {
			return esfMatchType;
		}

		ESFMatchTypeImpl esfMatchTypeImpl = new ESFMatchTypeImpl();

		esfMatchTypeImpl.setNew(esfMatchType.isNew());
		esfMatchTypeImpl.setPrimaryKey(esfMatchType.getPrimaryKey());

		esfMatchTypeImpl.setEsfMatchTypeId(esfMatchType.getEsfMatchTypeId());
		esfMatchTypeImpl.setGroupId(esfMatchType.getGroupId());
		esfMatchTypeImpl.setCompanyId(esfMatchType.getCompanyId());
		esfMatchTypeImpl.setUserId(esfMatchType.getUserId());
		esfMatchTypeImpl.setUserName(esfMatchType.getUserName());
		esfMatchTypeImpl.setCreateDate(esfMatchType.getCreateDate());
		esfMatchTypeImpl.setModifiedDate(esfMatchType.getModifiedDate());
		esfMatchTypeImpl.setName(esfMatchType.getName());
		esfMatchTypeImpl.setIsCategoryQualification(esfMatchType.isIsCategoryQualification());
		esfMatchTypeImpl.setIsNational(esfMatchType.isIsNational());
		esfMatchTypeImpl.setCode(esfMatchType.getCode());

		return esfMatchTypeImpl;
	}

	/**
	 * Returns the e s f match type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f match type
	 * @return the e s f match type
	 * @throws it.ethica.esf.NoSuchMatchTypeException if a e s f match type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMatchTypeException, SystemException {
		ESFMatchType esfMatchType = fetchByPrimaryKey(primaryKey);

		if (esfMatchType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMatchTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfMatchType;
	}

	/**
	 * Returns the e s f match type with the primary key or throws a {@link it.ethica.esf.NoSuchMatchTypeException} if it could not be found.
	 *
	 * @param esfMatchTypeId the primary key of the e s f match type
	 * @return the e s f match type
	 * @throws it.ethica.esf.NoSuchMatchTypeException if a e s f match type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType findByPrimaryKey(long esfMatchTypeId)
		throws NoSuchMatchTypeException, SystemException {
		return findByPrimaryKey((Serializable)esfMatchTypeId);
	}

	/**
	 * Returns the e s f match type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f match type
	 * @return the e s f match type, or <code>null</code> if a e s f match type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFMatchType esfMatchType = (ESFMatchType)EntityCacheUtil.getResult(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFMatchTypeImpl.class, primaryKey);

		if (esfMatchType == _nullESFMatchType) {
			return null;
		}

		if (esfMatchType == null) {
			Session session = null;

			try {
				session = openSession();

				esfMatchType = (ESFMatchType)session.get(ESFMatchTypeImpl.class,
						primaryKey);

				if (esfMatchType != null) {
					cacheResult(esfMatchType);
				}
				else {
					EntityCacheUtil.putResult(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFMatchTypeImpl.class, primaryKey, _nullESFMatchType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFMatchTypeModelImpl.ENTITY_CACHE_ENABLED,
					ESFMatchTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfMatchType;
	}

	/**
	 * Returns the e s f match type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfMatchTypeId the primary key of the e s f match type
	 * @return the e s f match type, or <code>null</code> if a e s f match type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFMatchType fetchByPrimaryKey(long esfMatchTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfMatchTypeId);
	}

	/**
	 * Returns all the e s f match types.
	 *
	 * @return the e s f match types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f match types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f match types
	 * @param end the upper bound of the range of e s f match types (not inclusive)
	 * @return the range of e s f match types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f match types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f match types
	 * @param end the upper bound of the range of e s f match types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f match types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFMatchType> findAll(int start, int end,
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

		List<ESFMatchType> list = (List<ESFMatchType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFMATCHTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFMATCHTYPE;

				if (pagination) {
					sql = sql.concat(ESFMatchTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFMatchType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFMatchType>(list);
				}
				else {
					list = (List<ESFMatchType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f match types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFMatchType esfMatchType : findAll()) {
			remove(esfMatchType);
		}
	}

	/**
	 * Returns the number of e s f match types.
	 *
	 * @return the number of e s f match types
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

				Query q = session.createQuery(_SQL_COUNT_ESFMATCHTYPE);

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
	 * Initializes the e s f match type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFMatchType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFMatchType>> listenersList = new ArrayList<ModelListener<ESFMatchType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFMatchType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFMatchTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFMATCHTYPE = "SELECT esfMatchType FROM ESFMatchType esfMatchType";
	private static final String _SQL_SELECT_ESFMATCHTYPE_WHERE = "SELECT esfMatchType FROM ESFMatchType esfMatchType WHERE ";
	private static final String _SQL_COUNT_ESFMATCHTYPE = "SELECT COUNT(esfMatchType) FROM ESFMatchType esfMatchType";
	private static final String _SQL_COUNT_ESFMATCHTYPE_WHERE = "SELECT COUNT(esfMatchType) FROM ESFMatchType esfMatchType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfMatchType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFMatchType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFMatchType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFMatchTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code"
			});
	private static ESFMatchType _nullESFMatchType = new ESFMatchTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFMatchType> toCacheModel() {
				return _nullESFMatchTypeCacheModel;
			}
		};

	private static CacheModel<ESFMatchType> _nullESFMatchTypeCacheModel = new CacheModel<ESFMatchType>() {
			@Override
			public ESFMatchType toEntityModel() {
				return _nullESFMatchType;
			}
		};
}