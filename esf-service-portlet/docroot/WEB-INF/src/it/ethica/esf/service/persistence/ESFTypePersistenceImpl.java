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

import it.ethica.esf.NoSuchTypeException;
import it.ethica.esf.model.ESFType;
import it.ethica.esf.model.impl.ESFTypeImpl;
import it.ethica.esf.model.impl.ESFTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFTypePersistence
 * @see ESFTypeUtil
 * @generated
 */
public class ESFTypePersistenceImpl extends BasePersistenceImpl<ESFType>
	implements ESFTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFTypeUtil} to access the e s f type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, ESFTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, ESFTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, ESFTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			ESFTypeModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f type where code = &#63; or throws a {@link it.ethica.esf.NoSuchTypeException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType findByCode(String code)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = fetchByCode(code);

		if (esfType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTypeException(msg.toString());
		}

		return esfType;
	}

	/**
	 * Returns the e s f type where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching e s f type, or <code>null</code> if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the e s f type where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f type, or <code>null</code> if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ESFType) {
			ESFType esfType = (ESFType)result;

			if (!Validator.equals(code, esfType.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFTYPE_WHERE);

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

				List<ESFType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ESFTypePersistenceImpl.fetchByCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ESFType esfType = list.get(0);

					result = esfType;

					cacheResult(esfType);

					if ((esfType.getCode() == null) ||
							!esfType.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, esfType);
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
			return (ESFType)result;
		}
	}

	/**
	 * Removes the e s f type where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the e s f type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType removeByCode(String code)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = findByCode(code);

		return remove(esfType);
	}

	/**
	 * Returns the number of e s f types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching e s f types
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

			query.append(_SQL_COUNT_ESFTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "esfType.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "esfType.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(esfType.code IS NULL OR esfType.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, ESFTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, ESFTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			ESFTypeModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f types where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f types
	 * @param end the upper bound of the range of e s f types (not inclusive)
	 * @return the range of matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of e s f types
	 * @param end the upper bound of the range of e s f types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByName(String name, int start, int end,
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

		List<ESFType> list = (List<ESFType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFType esfType : list) {
				if (!Validator.equals(name, esfType.getName())) {
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

			query.append(_SQL_SELECT_ESFTYPE_WHERE);

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
				query.append(ESFTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<ESFType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFType>(list);
				}
				else {
					list = (List<ESFType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = fetchByName_First(name, orderByComparator);

		if (esfType != null) {
			return esfType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f type, or <code>null</code> if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFType> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = fetchByName_Last(name, orderByComparator);

		if (esfType != null) {
			return esfType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f type, or <code>null</code> if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ESFType> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f types before and after the current e s f type in the ordered set where name = &#63;.
	 *
	 * @param esfTypeId the primary key of the current e s f type
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a e s f type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType[] findByName_PrevAndNext(long esfTypeId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = findByPrimaryKey(esfTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFType[] array = new ESFTypeImpl[3];

			array[0] = getByName_PrevAndNext(session, esfType, name,
					orderByComparator, true);

			array[1] = esfType;

			array[2] = getByName_PrevAndNext(session, esfType, name,
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

	protected ESFType getByName_PrevAndNext(Session session, ESFType esfType,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTYPE_WHERE);

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
			query.append(ESFTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(esfType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f types where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (ESFType esfType : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfType);
		}
	}

	/**
	 * Returns the number of e s f types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching e s f types
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

			query.append(_SQL_COUNT_ESFTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "esfType.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "esfType.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(esfType.name IS NULL OR esfType.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME =
		new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, ESFTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClassName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME =
		new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, ESFTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClassName",
			new String[] { String.class.getName() },
			ESFTypeModelImpl.CLASSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAME = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClassName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f types where className = &#63;.
	 *
	 * @param className the class name
	 * @return the matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByClassName(String className)
		throws SystemException {
		return findByClassName(className, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e s f types where className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param start the lower bound of the range of e s f types
	 * @param end the upper bound of the range of e s f types (not inclusive)
	 * @return the range of matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByClassName(String className, int start, int end)
		throws SystemException {
		return findByClassName(className, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f types where className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param start the lower bound of the range of e s f types
	 * @param end the upper bound of the range of e s f types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByClassName(String className, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME;
			finderArgs = new Object[] { className };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME;
			finderArgs = new Object[] { className, start, end, orderByComparator };
		}

		List<ESFType> list = (List<ESFType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFType esfType : list) {
				if (!Validator.equals(className, esfType.getClassName())) {
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

			query.append(_SQL_SELECT_ESFTYPE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				if (!pagination) {
					list = (List<ESFType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFType>(list);
				}
				else {
					list = (List<ESFType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f type in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType findByClassName_First(String className,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = fetchByClassName_First(className, orderByComparator);

		if (esfType != null) {
			return esfType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f type in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f type, or <code>null</code> if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByClassName_First(String className,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFType> list = findByClassName(className, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f type in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType findByClassName_Last(String className,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = fetchByClassName_Last(className, orderByComparator);

		if (esfType != null) {
			return esfType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f type in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f type, or <code>null</code> if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByClassName_Last(String className,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByClassName(className);

		if (count == 0) {
			return null;
		}

		List<ESFType> list = findByClassName(className, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f types before and after the current e s f type in the ordered set where className = &#63;.
	 *
	 * @param esfTypeId the primary key of the current e s f type
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a e s f type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType[] findByClassName_PrevAndNext(long esfTypeId,
		String className, OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = findByPrimaryKey(esfTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFType[] array = new ESFTypeImpl[3];

			array[0] = getByClassName_PrevAndNext(session, esfType, className,
					orderByComparator, true);

			array[1] = esfType;

			array[2] = getByClassName_PrevAndNext(session, esfType, className,
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

	protected ESFType getByClassName_PrevAndNext(Session session,
		ESFType esfType, String className, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTYPE_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
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
			query.append(ESFTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f types where className = &#63; from the database.
	 *
	 * @param className the class name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClassName(String className) throws SystemException {
		for (ESFType esfType : findByClassName(className, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfType);
		}
	}

	/**
	 * Returns the number of e s f types where className = &#63;.
	 *
	 * @param className the class name
	 * @return the number of matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClassName(String className) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAME;

		Object[] finderArgs = new Object[] { className };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFTYPE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
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

	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_1 = "esfType.className IS NULL";
	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_2 = "esfType.className = ?";
	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_3 = "(esfType.className IS NULL OR esfType.className = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, ESFTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, ESFTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { String.class.getName() },
			ESFTypeModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the e s f types where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByStatus(String status) throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f types where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e s f types
	 * @param end the upper bound of the range of e s f types (not inclusive)
	 * @return the range of matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByStatus(String status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f types where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of e s f types
	 * @param end the upper bound of the range of e s f types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByStatus(String status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<ESFType> list = (List<ESFType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFType esfType : list) {
				if (!Validator.equals(status, esfType.getStatus())) {
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

			query.append(_SQL_SELECT_ESFTYPE_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<ESFType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFType>(list);
				}
				else {
					list = (List<ESFType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType findByStatus_First(String status,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = fetchByStatus_First(status, orderByComparator);

		if (esfType != null) {
			return esfType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f type, or <code>null</code> if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByStatus_First(String status,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFType> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType findByStatus_Last(String status,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = fetchByStatus_Last(status, orderByComparator);

		if (esfType != null) {
			return esfType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f type, or <code>null</code> if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByStatus_Last(String status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<ESFType> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f types before and after the current e s f type in the ordered set where status = &#63;.
	 *
	 * @param esfTypeId the primary key of the current e s f type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a e s f type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType[] findByStatus_PrevAndNext(long esfTypeId, String status,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = findByPrimaryKey(esfTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFType[] array = new ESFTypeImpl[3];

			array[0] = getByStatus_PrevAndNext(session, esfType, status,
					orderByComparator, true);

			array[1] = esfType;

			array[2] = getByStatus_PrevAndNext(session, esfType, status,
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

	protected ESFType getByStatus_PrevAndNext(Session session, ESFType esfType,
		String status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTYPE_WHERE);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);
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
			query.append(ESFTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f types where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(String status) throws SystemException {
		for (ESFType esfType : findByStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(esfType);
		}
	}

	/**
	 * Returns the number of e s f types where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(String status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFTYPE_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "esfType.status IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "esfType.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(esfType.status IS NULL OR esfType.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEPARENTID =
		new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, ESFTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTypeParentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEPARENTID =
		new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, ESFTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTypeParentId",
			new String[] { Long.class.getName() },
			ESFTypeModelImpl.TYPEPARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEPARENTID = new FinderPath(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeParentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f types where typeParentId = &#63;.
	 *
	 * @param typeParentId the type parent ID
	 * @return the matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByTypeParentId(long typeParentId)
		throws SystemException {
		return findByTypeParentId(typeParentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f types where typeParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typeParentId the type parent ID
	 * @param start the lower bound of the range of e s f types
	 * @param end the upper bound of the range of e s f types (not inclusive)
	 * @return the range of matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByTypeParentId(long typeParentId, int start,
		int end) throws SystemException {
		return findByTypeParentId(typeParentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f types where typeParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param typeParentId the type parent ID
	 * @param start the lower bound of the range of e s f types
	 * @param end the upper bound of the range of e s f types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findByTypeParentId(long typeParentId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEPARENTID;
			finderArgs = new Object[] { typeParentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEPARENTID;
			finderArgs = new Object[] {
					typeParentId,
					
					start, end, orderByComparator
				};
		}

		List<ESFType> list = (List<ESFType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFType esfType : list) {
				if ((typeParentId != esfType.getTypeParentId())) {
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

			query.append(_SQL_SELECT_ESFTYPE_WHERE);

			query.append(_FINDER_COLUMN_TYPEPARENTID_TYPEPARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeParentId);

				if (!pagination) {
					list = (List<ESFType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFType>(list);
				}
				else {
					list = (List<ESFType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e s f type in the ordered set where typeParentId = &#63;.
	 *
	 * @param typeParentId the type parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType findByTypeParentId_First(long typeParentId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = fetchByTypeParentId_First(typeParentId,
				orderByComparator);

		if (esfType != null) {
			return esfType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeParentId=");
		msg.append(typeParentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f type in the ordered set where typeParentId = &#63;.
	 *
	 * @param typeParentId the type parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f type, or <code>null</code> if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByTypeParentId_First(long typeParentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFType> list = findByTypeParentId(typeParentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f type in the ordered set where typeParentId = &#63;.
	 *
	 * @param typeParentId the type parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType findByTypeParentId_Last(long typeParentId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = fetchByTypeParentId_Last(typeParentId,
				orderByComparator);

		if (esfType != null) {
			return esfType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeParentId=");
		msg.append(typeParentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f type in the ordered set where typeParentId = &#63;.
	 *
	 * @param typeParentId the type parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f type, or <code>null</code> if a matching e s f type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByTypeParentId_Last(long typeParentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTypeParentId(typeParentId);

		if (count == 0) {
			return null;
		}

		List<ESFType> list = findByTypeParentId(typeParentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f types before and after the current e s f type in the ordered set where typeParentId = &#63;.
	 *
	 * @param esfTypeId the primary key of the current e s f type
	 * @param typeParentId the type parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a e s f type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType[] findByTypeParentId_PrevAndNext(long esfTypeId,
		long typeParentId, OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = findByPrimaryKey(esfTypeId);

		Session session = null;

		try {
			session = openSession();

			ESFType[] array = new ESFTypeImpl[3];

			array[0] = getByTypeParentId_PrevAndNext(session, esfType,
					typeParentId, orderByComparator, true);

			array[1] = esfType;

			array[2] = getByTypeParentId_PrevAndNext(session, esfType,
					typeParentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFType getByTypeParentId_PrevAndNext(Session session,
		ESFType esfType, long typeParentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFTYPE_WHERE);

		query.append(_FINDER_COLUMN_TYPEPARENTID_TYPEPARENTID_2);

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
			query.append(ESFTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeParentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f types where typeParentId = &#63; from the database.
	 *
	 * @param typeParentId the type parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypeParentId(long typeParentId)
		throws SystemException {
		for (ESFType esfType : findByTypeParentId(typeParentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfType);
		}
	}

	/**
	 * Returns the number of e s f types where typeParentId = &#63;.
	 *
	 * @param typeParentId the type parent ID
	 * @return the number of matching e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeParentId(long typeParentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPEPARENTID;

		Object[] finderArgs = new Object[] { typeParentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFTYPE_WHERE);

			query.append(_FINDER_COLUMN_TYPEPARENTID_TYPEPARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeParentId);

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

	private static final String _FINDER_COLUMN_TYPEPARENTID_TYPEPARENTID_2 = "esfType.typeParentId = ?";

	public ESFTypePersistenceImpl() {
		setModelClass(ESFType.class);
	}

	/**
	 * Caches the e s f type in the entity cache if it is enabled.
	 *
	 * @param esfType the e s f type
	 */
	@Override
	public void cacheResult(ESFType esfType) {
		EntityCacheUtil.putResult(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeImpl.class, esfType.getPrimaryKey(), esfType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { esfType.getCode() }, esfType);

		esfType.resetOriginalValues();
	}

	/**
	 * Caches the e s f types in the entity cache if it is enabled.
	 *
	 * @param esfTypes the e s f types
	 */
	@Override
	public void cacheResult(List<ESFType> esfTypes) {
		for (ESFType esfType : esfTypes) {
			if (EntityCacheUtil.getResult(
						ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFTypeImpl.class, esfType.getPrimaryKey()) == null) {
				cacheResult(esfType);
			}
			else {
				esfType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFType esfType) {
		EntityCacheUtil.removeResult(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeImpl.class, esfType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfType);
	}

	@Override
	public void clearCache(List<ESFType> esfTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFType esfType : esfTypes) {
			EntityCacheUtil.removeResult(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFTypeImpl.class, esfType.getPrimaryKey());

			clearUniqueFindersCache(esfType);
		}
	}

	protected void cacheUniqueFindersCache(ESFType esfType) {
		if (esfType.isNew()) {
			Object[] args = new Object[] { esfType.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args, esfType);
		}
		else {
			ESFTypeModelImpl esfTypeModelImpl = (ESFTypeModelImpl)esfType;

			if ((esfTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfType.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					esfType);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFType esfType) {
		ESFTypeModelImpl esfTypeModelImpl = (ESFTypeModelImpl)esfType;

		Object[] args = new Object[] { esfType.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((esfTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { esfTypeModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new e s f type with the primary key. Does not add the e s f type to the database.
	 *
	 * @param esfTypeId the primary key for the new e s f type
	 * @return the new e s f type
	 */
	@Override
	public ESFType create(long esfTypeId) {
		ESFType esfType = new ESFTypeImpl();

		esfType.setNew(true);
		esfType.setPrimaryKey(esfTypeId);

		return esfType;
	}

	/**
	 * Removes the e s f type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfTypeId the primary key of the e s f type
	 * @return the e s f type that was removed
	 * @throws it.ethica.esf.NoSuchTypeException if a e s f type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType remove(long esfTypeId)
		throws NoSuchTypeException, SystemException {
		return remove((Serializable)esfTypeId);
	}

	/**
	 * Removes the e s f type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f type
	 * @return the e s f type that was removed
	 * @throws it.ethica.esf.NoSuchTypeException if a e s f type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType remove(Serializable primaryKey)
		throws NoSuchTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFType esfType = (ESFType)session.get(ESFTypeImpl.class, primaryKey);

			if (esfType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfType);
		}
		catch (NoSuchTypeException nsee) {
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
	protected ESFType removeImpl(ESFType esfType) throws SystemException {
		esfType = toUnwrappedModel(esfType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfType)) {
				esfType = (ESFType)session.get(ESFTypeImpl.class,
						esfType.getPrimaryKeyObj());
			}

			if (esfType != null) {
				session.delete(esfType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfType != null) {
			clearCache(esfType);
		}

		return esfType;
	}

	@Override
	public ESFType updateImpl(it.ethica.esf.model.ESFType esfType)
		throws SystemException {
		esfType = toUnwrappedModel(esfType);

		boolean isNew = esfType.isNew();

		ESFTypeModelImpl esfTypeModelImpl = (ESFTypeModelImpl)esfType;

		Session session = null;

		try {
			session = openSession();

			if (esfType.isNew()) {
				session.save(esfType);

				esfType.setNew(false);
			}
			else {
				session.merge(esfType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfTypeModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { esfTypeModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((esfTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfTypeModelImpl.getOriginalClassName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
					args);

				args = new Object[] { esfTypeModelImpl.getClassName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
					args);
			}

			if ((esfTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfTypeModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { esfTypeModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((esfTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEPARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfTypeModelImpl.getOriginalTypeParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEPARENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEPARENTID,
					args);

				args = new Object[] { esfTypeModelImpl.getTypeParentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEPARENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEPARENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFTypeImpl.class, esfType.getPrimaryKey(), esfType);

		clearUniqueFindersCache(esfType);
		cacheUniqueFindersCache(esfType);

		return esfType;
	}

	protected ESFType toUnwrappedModel(ESFType esfType) {
		if (esfType instanceof ESFTypeImpl) {
			return esfType;
		}

		ESFTypeImpl esfTypeImpl = new ESFTypeImpl();

		esfTypeImpl.setNew(esfType.isNew());
		esfTypeImpl.setPrimaryKey(esfType.getPrimaryKey());

		esfTypeImpl.setEsfTypeId(esfType.getEsfTypeId());
		esfTypeImpl.setGroupId(esfType.getGroupId());
		esfTypeImpl.setCompanyId(esfType.getCompanyId());
		esfTypeImpl.setUserId(esfType.getUserId());
		esfTypeImpl.setUserName(esfType.getUserName());
		esfTypeImpl.setCreateDate(esfType.getCreateDate());
		esfTypeImpl.setModifiedDate(esfType.getModifiedDate());
		esfTypeImpl.setCode(esfType.getCode());
		esfTypeImpl.setName(esfType.getName());
		esfTypeImpl.setDescription(esfType.getDescription());
		esfTypeImpl.setClassName(esfType.getClassName());
		esfTypeImpl.setStatus(esfType.getStatus());
		esfTypeImpl.setTypeParentId(esfType.getTypeParentId());

		return esfTypeImpl;
	}

	/**
	 * Returns the e s f type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f type
	 * @return the e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a e s f type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTypeException, SystemException {
		ESFType esfType = fetchByPrimaryKey(primaryKey);

		if (esfType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfType;
	}

	/**
	 * Returns the e s f type with the primary key or throws a {@link it.ethica.esf.NoSuchTypeException} if it could not be found.
	 *
	 * @param esfTypeId the primary key of the e s f type
	 * @return the e s f type
	 * @throws it.ethica.esf.NoSuchTypeException if a e s f type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType findByPrimaryKey(long esfTypeId)
		throws NoSuchTypeException, SystemException {
		return findByPrimaryKey((Serializable)esfTypeId);
	}

	/**
	 * Returns the e s f type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f type
	 * @return the e s f type, or <code>null</code> if a e s f type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFType esfType = (ESFType)EntityCacheUtil.getResult(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFTypeImpl.class, primaryKey);

		if (esfType == _nullESFType) {
			return null;
		}

		if (esfType == null) {
			Session session = null;

			try {
				session = openSession();

				esfType = (ESFType)session.get(ESFTypeImpl.class, primaryKey);

				if (esfType != null) {
					cacheResult(esfType);
				}
				else {
					EntityCacheUtil.putResult(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFTypeImpl.class, primaryKey, _nullESFType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFTypeModelImpl.ENTITY_CACHE_ENABLED,
					ESFTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfType;
	}

	/**
	 * Returns the e s f type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfTypeId the primary key of the e s f type
	 * @return the e s f type, or <code>null</code> if a e s f type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFType fetchByPrimaryKey(long esfTypeId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfTypeId);
	}

	/**
	 * Returns all the e s f types.
	 *
	 * @return the e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f types
	 * @param end the upper bound of the range of e s f types (not inclusive)
	 * @return the range of e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f types
	 * @param end the upper bound of the range of e s f types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFType> findAll(int start, int end,
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

		List<ESFType> list = (List<ESFType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFTYPE;

				if (pagination) {
					sql = sql.concat(ESFTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFType>(list);
				}
				else {
					list = (List<ESFType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e s f types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFType esfType : findAll()) {
			remove(esfType);
		}
	}

	/**
	 * Returns the number of e s f types.
	 *
	 * @return the number of e s f types
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

				Query q = session.createQuery(_SQL_COUNT_ESFTYPE);

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
	 * Initializes the e s f type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFType>> listenersList = new ArrayList<ModelListener<ESFType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFTYPE = "SELECT esfType FROM ESFType esfType";
	private static final String _SQL_SELECT_ESFTYPE_WHERE = "SELECT esfType FROM ESFType esfType WHERE ";
	private static final String _SQL_COUNT_ESFTYPE = "SELECT COUNT(esfType) FROM ESFType esfType";
	private static final String _SQL_COUNT_ESFTYPE_WHERE = "SELECT COUNT(esfType) FROM ESFType esfType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code"
			});
	private static ESFType _nullESFType = new ESFTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFType> toCacheModel() {
				return _nullESFTypeCacheModel;
			}
		};

	private static CacheModel<ESFType> _nullESFTypeCacheModel = new CacheModel<ESFType>() {
			@Override
			public ESFType toEntityModel() {
				return _nullESFType;
			}
		};
}