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

import com.ethica.esf.NoSuchArticleTypeException;
import com.ethica.esf.model.ESFArticleType;
import com.ethica.esf.model.impl.ESFArticleTypeImpl;
import com.ethica.esf.model.impl.ESFArticleTypeModelImpl;

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
 * The persistence implementation for the e s f article type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFArticleTypePersistence
 * @see ESFArticleTypeUtil
 * @generated
 */
public class ESFArticleTypePersistenceImpl extends BasePersistenceImpl<ESFArticleType>
	implements ESFArticleTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFArticleTypeUtil} to access the e s f article type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFArticleTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFArticleTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFArticleTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION = new FinderPath(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFArticleTypeImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByArticleTypeDescription",
			new String[] { String.class.getName() },
			ESFArticleTypeModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLETYPEDESCRIPTION = new FinderPath(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByArticleTypeDescription",
			new String[] { String.class.getName() });

	/**
	 * Returns the e s f article type where description = &#63; or throws a {@link com.ethica.esf.NoSuchArticleTypeException} if it could not be found.
	 *
	 * @param description the description
	 * @return the matching e s f article type
	 * @throws com.ethica.esf.NoSuchArticleTypeException if a matching e s f article type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType findByArticleTypeDescription(String description)
		throws NoSuchArticleTypeException, SystemException {
		ESFArticleType esfArticleType = fetchByArticleTypeDescription(description);

		if (esfArticleType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("description=");
			msg.append(description);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchArticleTypeException(msg.toString());
		}

		return esfArticleType;
	}

	/**
	 * Returns the e s f article type where description = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param description the description
	 * @return the matching e s f article type, or <code>null</code> if a matching e s f article type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType fetchByArticleTypeDescription(String description)
		throws SystemException {
		return fetchByArticleTypeDescription(description, true);
	}

	/**
	 * Returns the e s f article type where description = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param description the description
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e s f article type, or <code>null</code> if a matching e s f article type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType fetchByArticleTypeDescription(String description,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { description };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION,
					finderArgs, this);
		}

		if (result instanceof ESFArticleType) {
			ESFArticleType esfArticleType = (ESFArticleType)result;

			if (!Validator.equals(description, esfArticleType.getDescription())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ESFARTICLETYPE_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_ARTICLETYPEDESCRIPTION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ARTICLETYPEDESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_ARTICLETYPEDESCRIPTION_DESCRIPTION_2);
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

				List<ESFArticleType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION,
						finderArgs, list);
				}
				else {
					ESFArticleType esfArticleType = list.get(0);

					result = esfArticleType;

					cacheResult(esfArticleType);

					if ((esfArticleType.getDescription() == null) ||
							!esfArticleType.getDescription().equals(description)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION,
							finderArgs, esfArticleType);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION,
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
			return (ESFArticleType)result;
		}
	}

	/**
	 * Removes the e s f article type where description = &#63; from the database.
	 *
	 * @param description the description
	 * @return the e s f article type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType removeByArticleTypeDescription(String description)
		throws NoSuchArticleTypeException, SystemException {
		ESFArticleType esfArticleType = findByArticleTypeDescription(description);

		return remove(esfArticleType);
	}

	/**
	 * Returns the number of e s f article types where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching e s f article types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByArticleTypeDescription(String description)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTICLETYPEDESCRIPTION;

		Object[] finderArgs = new Object[] { description };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFARTICLETYPE_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_ARTICLETYPEDESCRIPTION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ARTICLETYPEDESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_ARTICLETYPEDESCRIPTION_DESCRIPTION_2);
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

	private static final String _FINDER_COLUMN_ARTICLETYPEDESCRIPTION_DESCRIPTION_1 =
		"esfArticleType.description IS NULL";
	private static final String _FINDER_COLUMN_ARTICLETYPEDESCRIPTION_DESCRIPTION_2 =
		"esfArticleType.description = ?";
	private static final String _FINDER_COLUMN_ARTICLETYPEDESCRIPTION_DESCRIPTION_3 =
		"(esfArticleType.description IS NULL OR esfArticleType.description = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLETYPEID =
		new FinderPath(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFArticleTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByArticleTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLETYPEID =
		new FinderPath(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleTypeModelImpl.FINDER_CACHE_ENABLED,
			ESFArticleTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticleTypeId",
			new String[] { Long.class.getName() },
			ESFArticleTypeModelImpl.ESFARTICLETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLETYPEID = new FinderPath(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticleTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the e s f article types where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @return the matching e s f article types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleType> findByArticleTypeId(long esfArticleTypeId)
		throws SystemException {
		return findByArticleTypeId(esfArticleTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f article types where esfArticleTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param start the lower bound of the range of e s f article types
	 * @param end the upper bound of the range of e s f article types (not inclusive)
	 * @return the range of matching e s f article types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleType> findByArticleTypeId(long esfArticleTypeId,
		int start, int end) throws SystemException {
		return findByArticleTypeId(esfArticleTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f article types where esfArticleTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param start the lower bound of the range of e s f article types
	 * @param end the upper bound of the range of e s f article types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f article types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleType> findByArticleTypeId(long esfArticleTypeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLETYPEID;
			finderArgs = new Object[] { esfArticleTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLETYPEID;
			finderArgs = new Object[] {
					esfArticleTypeId,
					
					start, end, orderByComparator
				};
		}

		List<ESFArticleType> list = (List<ESFArticleType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFArticleType esfArticleType : list) {
				if ((esfArticleTypeId != esfArticleType.getEsfArticleTypeId())) {
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

			query.append(_SQL_SELECT_ESFARTICLETYPE_WHERE);

			query.append(_FINDER_COLUMN_ARTICLETYPEID_ESFARTICLETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFArticleTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(esfArticleTypeId);

				if (!pagination) {
					list = (List<ESFArticleType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticleType>(list);
				}
				else {
					list = (List<ESFArticleType>)QueryUtil.list(q,
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
	 * Returns the first e s f article type in the ordered set where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article type
	 * @throws com.ethica.esf.NoSuchArticleTypeException if a matching e s f article type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType findByArticleTypeId_First(long esfArticleTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleTypeException, SystemException {
		ESFArticleType esfArticleType = fetchByArticleTypeId_First(esfArticleTypeId,
				orderByComparator);

		if (esfArticleType != null) {
			return esfArticleType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfArticleTypeId=");
		msg.append(esfArticleTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleTypeException(msg.toString());
	}

	/**
	 * Returns the first e s f article type in the ordered set where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f article type, or <code>null</code> if a matching e s f article type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType fetchByArticleTypeId_First(long esfArticleTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ESFArticleType> list = findByArticleTypeId(esfArticleTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f article type in the ordered set where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article type
	 * @throws com.ethica.esf.NoSuchArticleTypeException if a matching e s f article type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType findByArticleTypeId_Last(long esfArticleTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleTypeException, SystemException {
		ESFArticleType esfArticleType = fetchByArticleTypeId_Last(esfArticleTypeId,
				orderByComparator);

		if (esfArticleType != null) {
			return esfArticleType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("esfArticleTypeId=");
		msg.append(esfArticleTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleTypeException(msg.toString());
	}

	/**
	 * Returns the last e s f article type in the ordered set where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f article type, or <code>null</code> if a matching e s f article type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType fetchByArticleTypeId_Last(long esfArticleTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByArticleTypeId(esfArticleTypeId);

		if (count == 0) {
			return null;
		}

		List<ESFArticleType> list = findByArticleTypeId(esfArticleTypeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the e s f article types where esfArticleTypeId = &#63; from the database.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByArticleTypeId(long esfArticleTypeId)
		throws SystemException {
		for (ESFArticleType esfArticleType : findByArticleTypeId(
				esfArticleTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfArticleType);
		}
	}

	/**
	 * Returns the number of e s f article types where esfArticleTypeId = &#63;.
	 *
	 * @param esfArticleTypeId the esf article type ID
	 * @return the number of matching e s f article types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByArticleTypeId(long esfArticleTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTICLETYPEID;

		Object[] finderArgs = new Object[] { esfArticleTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFARTICLETYPE_WHERE);

			query.append(_FINDER_COLUMN_ARTICLETYPEID_ESFARTICLETYPEID_2);

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

	private static final String _FINDER_COLUMN_ARTICLETYPEID_ESFARTICLETYPEID_2 = "esfArticleType.esfArticleTypeId = ?";

	public ESFArticleTypePersistenceImpl() {
		setModelClass(ESFArticleType.class);
	}

	/**
	 * Caches the e s f article type in the entity cache if it is enabled.
	 *
	 * @param esfArticleType the e s f article type
	 */
	@Override
	public void cacheResult(ESFArticleType esfArticleType) {
		EntityCacheUtil.putResult(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleTypeImpl.class, esfArticleType.getPrimaryKey(),
			esfArticleType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION,
			new Object[] { esfArticleType.getDescription() }, esfArticleType);

		esfArticleType.resetOriginalValues();
	}

	/**
	 * Caches the e s f article types in the entity cache if it is enabled.
	 *
	 * @param esfArticleTypes the e s f article types
	 */
	@Override
	public void cacheResult(List<ESFArticleType> esfArticleTypes) {
		for (ESFArticleType esfArticleType : esfArticleTypes) {
			if (EntityCacheUtil.getResult(
						ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFArticleTypeImpl.class, esfArticleType.getPrimaryKey()) == null) {
				cacheResult(esfArticleType);
			}
			else {
				esfArticleType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f article types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFArticleTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFArticleTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f article type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ESFArticleType esfArticleType) {
		EntityCacheUtil.removeResult(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleTypeImpl.class, esfArticleType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(esfArticleType);
	}

	@Override
	public void clearCache(List<ESFArticleType> esfArticleTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFArticleType esfArticleType : esfArticleTypes) {
			EntityCacheUtil.removeResult(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFArticleTypeImpl.class, esfArticleType.getPrimaryKey());

			clearUniqueFindersCache(esfArticleType);
		}
	}

	protected void cacheUniqueFindersCache(ESFArticleType esfArticleType) {
		if (esfArticleType.isNew()) {
			Object[] args = new Object[] { esfArticleType.getDescription() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLETYPEDESCRIPTION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION,
				args, esfArticleType);
		}
		else {
			ESFArticleTypeModelImpl esfArticleTypeModelImpl = (ESFArticleTypeModelImpl)esfArticleType;

			if ((esfArticleTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { esfArticleType.getDescription() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLETYPEDESCRIPTION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION,
					args, esfArticleType);
			}
		}
	}

	protected void clearUniqueFindersCache(ESFArticleType esfArticleType) {
		ESFArticleTypeModelImpl esfArticleTypeModelImpl = (ESFArticleTypeModelImpl)esfArticleType;

		Object[] args = new Object[] { esfArticleType.getDescription() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLETYPEDESCRIPTION,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION,
			args);

		if ((esfArticleTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION.getColumnBitmask()) != 0) {
			args = new Object[] { esfArticleTypeModelImpl.getOriginalDescription() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLETYPEDESCRIPTION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLETYPEDESCRIPTION,
				args);
		}
	}

	/**
	 * Creates a new e s f article type with the primary key. Does not add the e s f article type to the database.
	 *
	 * @param esfArticleTypeId the primary key for the new e s f article type
	 * @return the new e s f article type
	 */
	@Override
	public ESFArticleType create(long esfArticleTypeId) {
		ESFArticleType esfArticleType = new ESFArticleTypeImpl();

		esfArticleType.setNew(true);
		esfArticleType.setPrimaryKey(esfArticleTypeId);

		return esfArticleType;
	}

	/**
	 * Removes the e s f article type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfArticleTypeId the primary key of the e s f article type
	 * @return the e s f article type that was removed
	 * @throws com.ethica.esf.NoSuchArticleTypeException if a e s f article type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType remove(long esfArticleTypeId)
		throws NoSuchArticleTypeException, SystemException {
		return remove((Serializable)esfArticleTypeId);
	}

	/**
	 * Removes the e s f article type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f article type
	 * @return the e s f article type that was removed
	 * @throws com.ethica.esf.NoSuchArticleTypeException if a e s f article type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType remove(Serializable primaryKey)
		throws NoSuchArticleTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFArticleType esfArticleType = (ESFArticleType)session.get(ESFArticleTypeImpl.class,
					primaryKey);

			if (esfArticleType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfArticleType);
		}
		catch (NoSuchArticleTypeException nsee) {
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
	protected ESFArticleType removeImpl(ESFArticleType esfArticleType)
		throws SystemException {
		esfArticleType = toUnwrappedModel(esfArticleType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfArticleType)) {
				esfArticleType = (ESFArticleType)session.get(ESFArticleTypeImpl.class,
						esfArticleType.getPrimaryKeyObj());
			}

			if (esfArticleType != null) {
				session.delete(esfArticleType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfArticleType != null) {
			clearCache(esfArticleType);
		}

		return esfArticleType;
	}

	@Override
	public ESFArticleType updateImpl(
		com.ethica.esf.model.ESFArticleType esfArticleType)
		throws SystemException {
		esfArticleType = toUnwrappedModel(esfArticleType);

		boolean isNew = esfArticleType.isNew();

		ESFArticleTypeModelImpl esfArticleTypeModelImpl = (ESFArticleTypeModelImpl)esfArticleType;

		Session session = null;

		try {
			session = openSession();

			if (esfArticleType.isNew()) {
				session.save(esfArticleType);

				esfArticleType.setNew(false);
			}
			else {
				session.merge(esfArticleType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ESFArticleTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfArticleTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLETYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfArticleTypeModelImpl.getOriginalEsfArticleTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLETYPEID,
					args);

				args = new Object[] {
						esfArticleTypeModelImpl.getEsfArticleTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLETYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLETYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
			ESFArticleTypeImpl.class, esfArticleType.getPrimaryKey(),
			esfArticleType);

		clearUniqueFindersCache(esfArticleType);
		cacheUniqueFindersCache(esfArticleType);

		return esfArticleType;
	}

	protected ESFArticleType toUnwrappedModel(ESFArticleType esfArticleType) {
		if (esfArticleType instanceof ESFArticleTypeImpl) {
			return esfArticleType;
		}

		ESFArticleTypeImpl esfArticleTypeImpl = new ESFArticleTypeImpl();

		esfArticleTypeImpl.setNew(esfArticleType.isNew());
		esfArticleTypeImpl.setPrimaryKey(esfArticleType.getPrimaryKey());

		esfArticleTypeImpl.setEsfArticleTypeId(esfArticleType.getEsfArticleTypeId());
		esfArticleTypeImpl.setDescription(esfArticleType.getDescription());
		esfArticleTypeImpl.setDepartment(esfArticleType.getDepartment());
		esfArticleTypeImpl.setArea(esfArticleType.getArea());

		return esfArticleTypeImpl;
	}

	/**
	 * Returns the e s f article type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f article type
	 * @return the e s f article type
	 * @throws com.ethica.esf.NoSuchArticleTypeException if a e s f article type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleTypeException, SystemException {
		ESFArticleType esfArticleType = fetchByPrimaryKey(primaryKey);

		if (esfArticleType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfArticleType;
	}

	/**
	 * Returns the e s f article type with the primary key or throws a {@link com.ethica.esf.NoSuchArticleTypeException} if it could not be found.
	 *
	 * @param esfArticleTypeId the primary key of the e s f article type
	 * @return the e s f article type
	 * @throws com.ethica.esf.NoSuchArticleTypeException if a e s f article type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType findByPrimaryKey(long esfArticleTypeId)
		throws NoSuchArticleTypeException, SystemException {
		return findByPrimaryKey((Serializable)esfArticleTypeId);
	}

	/**
	 * Returns the e s f article type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f article type
	 * @return the e s f article type, or <code>null</code> if a e s f article type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ESFArticleType esfArticleType = (ESFArticleType)EntityCacheUtil.getResult(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
				ESFArticleTypeImpl.class, primaryKey);

		if (esfArticleType == _nullESFArticleType) {
			return null;
		}

		if (esfArticleType == null) {
			Session session = null;

			try {
				session = openSession();

				esfArticleType = (ESFArticleType)session.get(ESFArticleTypeImpl.class,
						primaryKey);

				if (esfArticleType != null) {
					cacheResult(esfArticleType);
				}
				else {
					EntityCacheUtil.putResult(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
						ESFArticleTypeImpl.class, primaryKey,
						_nullESFArticleType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFArticleTypeModelImpl.ENTITY_CACHE_ENABLED,
					ESFArticleTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfArticleType;
	}

	/**
	 * Returns the e s f article type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfArticleTypeId the primary key of the e s f article type
	 * @return the e s f article type, or <code>null</code> if a e s f article type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFArticleType fetchByPrimaryKey(long esfArticleTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)esfArticleTypeId);
	}

	/**
	 * Returns all the e s f article types.
	 *
	 * @return the e s f article types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f article types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f article types
	 * @param end the upper bound of the range of e s f article types (not inclusive)
	 * @return the range of e s f article types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f article types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f article types
	 * @param end the upper bound of the range of e s f article types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f article types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFArticleType> findAll(int start, int end,
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

		List<ESFArticleType> list = (List<ESFArticleType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFARTICLETYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFARTICLETYPE;

				if (pagination) {
					sql = sql.concat(ESFArticleTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFArticleType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFArticleType>(list);
				}
				else {
					list = (List<ESFArticleType>)QueryUtil.list(q,
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
	 * Removes all the e s f article types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFArticleType esfArticleType : findAll()) {
			remove(esfArticleType);
		}
	}

	/**
	 * Returns the number of e s f article types.
	 *
	 * @return the number of e s f article types
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

				Query q = session.createQuery(_SQL_COUNT_ESFARTICLETYPE);

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
	 * Initializes the e s f article type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ethica.esf.model.ESFArticleType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFArticleType>> listenersList = new ArrayList<ModelListener<ESFArticleType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFArticleType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFArticleTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFARTICLETYPE = "SELECT esfArticleType FROM ESFArticleType esfArticleType";
	private static final String _SQL_SELECT_ESFARTICLETYPE_WHERE = "SELECT esfArticleType FROM ESFArticleType esfArticleType WHERE ";
	private static final String _SQL_COUNT_ESFARTICLETYPE = "SELECT COUNT(esfArticleType) FROM ESFArticleType esfArticleType";
	private static final String _SQL_COUNT_ESFARTICLETYPE_WHERE = "SELECT COUNT(esfArticleType) FROM ESFArticleType esfArticleType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfArticleType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFArticleType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFArticleType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFArticleTypePersistenceImpl.class);
	private static ESFArticleType _nullESFArticleType = new ESFArticleTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFArticleType> toCacheModel() {
				return _nullESFArticleTypeCacheModel;
			}
		};

	private static CacheModel<ESFArticleType> _nullESFArticleTypeCacheModel = new CacheModel<ESFArticleType>() {
			@Override
			public ESFArticleType toEntityModel() {
				return _nullESFArticleType;
			}
		};
}