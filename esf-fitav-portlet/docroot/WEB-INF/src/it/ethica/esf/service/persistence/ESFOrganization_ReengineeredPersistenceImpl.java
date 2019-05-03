/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.ethica.esf.NoSuchOrganization_ReengineeredException;
import it.ethica.esf.model.ESFOrganization_Reengineered;
import it.ethica.esf.model.impl.ESFOrganization_ReengineeredImpl;
import it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the e s f organization_ reengineered service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrganization_ReengineeredPersistence
 * @see ESFOrganization_ReengineeredUtil
 * @generated
 */
public class ESFOrganization_ReengineeredPersistenceImpl
	extends BasePersistenceImpl<ESFOrganization_Reengineered>
	implements ESFOrganization_ReengineeredPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ESFOrganization_ReengineeredUtil} to access the e s f organization_ reengineered persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ESFOrganization_ReengineeredImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganization_ReengineeredModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganization_ReengineeredImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganization_ReengineeredModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganization_ReengineeredImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganization_ReengineeredModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDORGANIZATIONBYTYPE =
		new FinderPath(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganization_ReengineeredModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganization_ReengineeredImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFindOrganizationByType",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDORGANIZATIONBYTYPE =
		new FinderPath(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganization_ReengineeredModelImpl.FINDER_CACHE_ENABLED,
			ESFOrganization_ReengineeredImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFindOrganizationByType",
			new String[] { Integer.class.getName() },
			ESFOrganization_ReengineeredModelImpl.TYPE__COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDORGANIZATIONBYTYPE = new FinderPath(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganization_ReengineeredModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFindOrganizationByType",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the e s f organization_ reengineereds where type_ = &#63;.
	 *
	 * @param type_ the type_
	 * @return the matching e s f organization_ reengineereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization_Reengineered> findByFindOrganizationByType(
		int type_) throws SystemException {
		return findByFindOrganizationByType(type_, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organization_ reengineereds where type_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type_ the type_
	 * @param start the lower bound of the range of e s f organization_ reengineereds
	 * @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	 * @return the range of matching e s f organization_ reengineereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization_Reengineered> findByFindOrganizationByType(
		int type_, int start, int end) throws SystemException {
		return findByFindOrganizationByType(type_, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization_ reengineereds where type_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type_ the type_
	 * @param start the lower bound of the range of e s f organization_ reengineereds
	 * @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e s f organization_ reengineereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization_Reengineered> findByFindOrganizationByType(
		int type_, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDORGANIZATIONBYTYPE;
			finderArgs = new Object[] { type_ };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDORGANIZATIONBYTYPE;
			finderArgs = new Object[] { type_, start, end, orderByComparator };
		}

		List<ESFOrganization_Reengineered> list = (List<ESFOrganization_Reengineered>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ESFOrganization_Reengineered esfOrganization_Reengineered : list) {
				if ((type_ != esfOrganization_Reengineered.getType_())) {
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

			query.append(_SQL_SELECT_ESFORGANIZATION_REENGINEERED_WHERE);

			query.append(_FINDER_COLUMN_FINDORGANIZATIONBYTYPE_TYPE__2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ESFOrganization_ReengineeredModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type_);

				if (!pagination) {
					list = (List<ESFOrganization_Reengineered>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganization_Reengineered>(list);
				}
				else {
					list = (List<ESFOrganization_Reengineered>)QueryUtil.list(q,
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
	 * Returns the first e s f organization_ reengineered in the ordered set where type_ = &#63;.
	 *
	 * @param type_ the type_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization_ reengineered
	 * @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a matching e s f organization_ reengineered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization_Reengineered findByFindOrganizationByType_First(
		int type_, OrderByComparator orderByComparator)
		throws NoSuchOrganization_ReengineeredException, SystemException {
		ESFOrganization_Reengineered esfOrganization_Reengineered = fetchByFindOrganizationByType_First(type_,
				orderByComparator);

		if (esfOrganization_Reengineered != null) {
			return esfOrganization_Reengineered;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type_=");
		msg.append(type_);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganization_ReengineeredException(msg.toString());
	}

	/**
	 * Returns the first e s f organization_ reengineered in the ordered set where type_ = &#63;.
	 *
	 * @param type_ the type_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e s f organization_ reengineered, or <code>null</code> if a matching e s f organization_ reengineered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization_Reengineered fetchByFindOrganizationByType_First(
		int type_, OrderByComparator orderByComparator)
		throws SystemException {
		List<ESFOrganization_Reengineered> list = findByFindOrganizationByType(type_,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e s f organization_ reengineered in the ordered set where type_ = &#63;.
	 *
	 * @param type_ the type_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization_ reengineered
	 * @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a matching e s f organization_ reengineered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization_Reengineered findByFindOrganizationByType_Last(
		int type_, OrderByComparator orderByComparator)
		throws NoSuchOrganization_ReengineeredException, SystemException {
		ESFOrganization_Reengineered esfOrganization_Reengineered = fetchByFindOrganizationByType_Last(type_,
				orderByComparator);

		if (esfOrganization_Reengineered != null) {
			return esfOrganization_Reengineered;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type_=");
		msg.append(type_);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganization_ReengineeredException(msg.toString());
	}

	/**
	 * Returns the last e s f organization_ reengineered in the ordered set where type_ = &#63;.
	 *
	 * @param type_ the type_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e s f organization_ reengineered, or <code>null</code> if a matching e s f organization_ reengineered could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization_Reengineered fetchByFindOrganizationByType_Last(
		int type_, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFindOrganizationByType(type_);

		if (count == 0) {
			return null;
		}

		List<ESFOrganization_Reengineered> list = findByFindOrganizationByType(type_,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e s f organization_ reengineereds before and after the current e s f organization_ reengineered in the ordered set where type_ = &#63;.
	 *
	 * @param esfOrganizationId the primary key of the current e s f organization_ reengineered
	 * @param type_ the type_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e s f organization_ reengineered
	 * @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a e s f organization_ reengineered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization_Reengineered[] findByFindOrganizationByType_PrevAndNext(
		long esfOrganizationId, int type_, OrderByComparator orderByComparator)
		throws NoSuchOrganization_ReengineeredException, SystemException {
		ESFOrganization_Reengineered esfOrganization_Reengineered = findByPrimaryKey(esfOrganizationId);

		Session session = null;

		try {
			session = openSession();

			ESFOrganization_Reengineered[] array = new ESFOrganization_ReengineeredImpl[3];

			array[0] = getByFindOrganizationByType_PrevAndNext(session,
					esfOrganization_Reengineered, type_, orderByComparator, true);

			array[1] = esfOrganization_Reengineered;

			array[2] = getByFindOrganizationByType_PrevAndNext(session,
					esfOrganization_Reengineered, type_, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ESFOrganization_Reengineered getByFindOrganizationByType_PrevAndNext(
		Session session,
		ESFOrganization_Reengineered esfOrganization_Reengineered, int type_,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ESFORGANIZATION_REENGINEERED_WHERE);

		query.append(_FINDER_COLUMN_FINDORGANIZATIONBYTYPE_TYPE__2);

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
			query.append(ESFOrganization_ReengineeredModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(type_);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(esfOrganization_Reengineered);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ESFOrganization_Reengineered> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e s f organization_ reengineereds where type_ = &#63; from the database.
	 *
	 * @param type_ the type_
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFindOrganizationByType(int type_)
		throws SystemException {
		for (ESFOrganization_Reengineered esfOrganization_Reengineered : findByFindOrganizationByType(
				type_, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(esfOrganization_Reengineered);
		}
	}

	/**
	 * Returns the number of e s f organization_ reengineereds where type_ = &#63;.
	 *
	 * @param type_ the type_
	 * @return the number of matching e s f organization_ reengineereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFindOrganizationByType(int type_)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDORGANIZATIONBYTYPE;

		Object[] finderArgs = new Object[] { type_ };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ESFORGANIZATION_REENGINEERED_WHERE);

			query.append(_FINDER_COLUMN_FINDORGANIZATIONBYTYPE_TYPE__2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type_);

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

	private static final String _FINDER_COLUMN_FINDORGANIZATIONBYTYPE_TYPE__2 = "esfOrganization_Reengineered.type_ = ? AND esfOrganization_Reengineered.esfOrganization_Reengineered.type_=3";

	public ESFOrganization_ReengineeredPersistenceImpl() {
		setModelClass(ESFOrganization_Reengineered.class);
	}

	/**
	 * Caches the e s f organization_ reengineered in the entity cache if it is enabled.
	 *
	 * @param esfOrganization_Reengineered the e s f organization_ reengineered
	 */
	@Override
	public void cacheResult(
		ESFOrganization_Reengineered esfOrganization_Reengineered) {
		EntityCacheUtil.putResult(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganization_ReengineeredImpl.class,
			esfOrganization_Reengineered.getPrimaryKey(),
			esfOrganization_Reengineered);

		esfOrganization_Reengineered.resetOriginalValues();
	}

	/**
	 * Caches the e s f organization_ reengineereds in the entity cache if it is enabled.
	 *
	 * @param esfOrganization_Reengineereds the e s f organization_ reengineereds
	 */
	@Override
	public void cacheResult(
		List<ESFOrganization_Reengineered> esfOrganization_Reengineereds) {
		for (ESFOrganization_Reengineered esfOrganization_Reengineered : esfOrganization_Reengineereds) {
			if (EntityCacheUtil.getResult(
						ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
						ESFOrganization_ReengineeredImpl.class,
						esfOrganization_Reengineered.getPrimaryKey()) == null) {
				cacheResult(esfOrganization_Reengineered);
			}
			else {
				esfOrganization_Reengineered.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e s f organization_ reengineereds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ESFOrganization_ReengineeredImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ESFOrganization_ReengineeredImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e s f organization_ reengineered.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ESFOrganization_Reengineered esfOrganization_Reengineered) {
		EntityCacheUtil.removeResult(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganization_ReengineeredImpl.class,
			esfOrganization_Reengineered.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ESFOrganization_Reengineered> esfOrganization_Reengineereds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ESFOrganization_Reengineered esfOrganization_Reengineered : esfOrganization_Reengineereds) {
			EntityCacheUtil.removeResult(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
				ESFOrganization_ReengineeredImpl.class,
				esfOrganization_Reengineered.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e s f organization_ reengineered with the primary key. Does not add the e s f organization_ reengineered to the database.
	 *
	 * @param esfOrganizationId the primary key for the new e s f organization_ reengineered
	 * @return the new e s f organization_ reengineered
	 */
	@Override
	public ESFOrganization_Reengineered create(long esfOrganizationId) {
		ESFOrganization_Reengineered esfOrganization_Reengineered = new ESFOrganization_ReengineeredImpl();

		esfOrganization_Reengineered.setNew(true);
		esfOrganization_Reengineered.setPrimaryKey(esfOrganizationId);

		return esfOrganization_Reengineered;
	}

	/**
	 * Removes the e s f organization_ reengineered with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfOrganizationId the primary key of the e s f organization_ reengineered
	 * @return the e s f organization_ reengineered that was removed
	 * @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a e s f organization_ reengineered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization_Reengineered remove(long esfOrganizationId)
		throws NoSuchOrganization_ReengineeredException, SystemException {
		return remove((Serializable)esfOrganizationId);
	}

	/**
	 * Removes the e s f organization_ reengineered with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e s f organization_ reengineered
	 * @return the e s f organization_ reengineered that was removed
	 * @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a e s f organization_ reengineered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization_Reengineered remove(Serializable primaryKey)
		throws NoSuchOrganization_ReengineeredException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ESFOrganization_Reengineered esfOrganization_Reengineered = (ESFOrganization_Reengineered)session.get(ESFOrganization_ReengineeredImpl.class,
					primaryKey);

			if (esfOrganization_Reengineered == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganization_ReengineeredException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(esfOrganization_Reengineered);
		}
		catch (NoSuchOrganization_ReengineeredException nsee) {
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
	protected ESFOrganization_Reengineered removeImpl(
		ESFOrganization_Reengineered esfOrganization_Reengineered)
		throws SystemException {
		esfOrganization_Reengineered = toUnwrappedModel(esfOrganization_Reengineered);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(esfOrganization_Reengineered)) {
				esfOrganization_Reengineered = (ESFOrganization_Reengineered)session.get(ESFOrganization_ReengineeredImpl.class,
						esfOrganization_Reengineered.getPrimaryKeyObj());
			}

			if (esfOrganization_Reengineered != null) {
				session.delete(esfOrganization_Reengineered);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (esfOrganization_Reengineered != null) {
			clearCache(esfOrganization_Reengineered);
		}

		return esfOrganization_Reengineered;
	}

	@Override
	public ESFOrganization_Reengineered updateImpl(
		it.ethica.esf.model.ESFOrganization_Reengineered esfOrganization_Reengineered)
		throws SystemException {
		esfOrganization_Reengineered = toUnwrappedModel(esfOrganization_Reengineered);

		boolean isNew = esfOrganization_Reengineered.isNew();

		ESFOrganization_ReengineeredModelImpl esfOrganization_ReengineeredModelImpl =
			(ESFOrganization_ReengineeredModelImpl)esfOrganization_Reengineered;

		Session session = null;

		try {
			session = openSession();

			if (esfOrganization_Reengineered.isNew()) {
				session.save(esfOrganization_Reengineered);

				esfOrganization_Reengineered.setNew(false);
			}
			else {
				session.merge(esfOrganization_Reengineered);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!ESFOrganization_ReengineeredModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((esfOrganization_ReengineeredModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDORGANIZATIONBYTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						esfOrganization_ReengineeredModelImpl.getOriginalType_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDORGANIZATIONBYTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDORGANIZATIONBYTYPE,
					args);

				args = new Object[] {
						esfOrganization_ReengineeredModelImpl.getType_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDORGANIZATIONBYTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDORGANIZATIONBYTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
			ESFOrganization_ReengineeredImpl.class,
			esfOrganization_Reengineered.getPrimaryKey(),
			esfOrganization_Reengineered);

		return esfOrganization_Reengineered;
	}

	protected ESFOrganization_Reengineered toUnwrappedModel(
		ESFOrganization_Reengineered esfOrganization_Reengineered) {
		if (esfOrganization_Reengineered instanceof ESFOrganization_ReengineeredImpl) {
			return esfOrganization_Reengineered;
		}

		ESFOrganization_ReengineeredImpl esfOrganization_ReengineeredImpl = new ESFOrganization_ReengineeredImpl();

		esfOrganization_ReengineeredImpl.setNew(esfOrganization_Reengineered.isNew());
		esfOrganization_ReengineeredImpl.setPrimaryKey(esfOrganization_Reengineered.getPrimaryKey());

		esfOrganization_ReengineeredImpl.setEsfOrganizationId(esfOrganization_Reengineered.getEsfOrganizationId());
		esfOrganization_ReengineeredImpl.setCode(esfOrganization_Reengineered.getCode());
		esfOrganization_ReengineeredImpl.setVat(esfOrganization_Reengineered.getVat());
		esfOrganization_ReengineeredImpl.setFiscalCode(esfOrganization_Reengineered.getFiscalCode());
		esfOrganization_ReengineeredImpl.setIbanCode(esfOrganization_Reengineered.getIbanCode());
		esfOrganization_ReengineeredImpl.setIsMultiSport(esfOrganization_Reengineered.isIsMultiSport());
		esfOrganization_ReengineeredImpl.setLegalForm(esfOrganization_Reengineered.getLegalForm());
		esfOrganization_ReengineeredImpl.setCategory(esfOrganization_Reengineered.getCategory());
		esfOrganization_ReengineeredImpl.setEstablishmentDate(esfOrganization_Reengineered.getEstablishmentDate());
		esfOrganization_ReengineeredImpl.setClosureDate(esfOrganization_Reengineered.getClosureDate());
		esfOrganization_ReengineeredImpl.setType(esfOrganization_Reengineered.getType());
		esfOrganization_ReengineeredImpl.setInsertDate(esfOrganization_Reengineered.getInsertDate());
		esfOrganization_ReengineeredImpl.setConiDate(esfOrganization_Reengineered.getConiDate());
		esfOrganization_ReengineeredImpl.setConiCode(esfOrganization_Reengineered.getConiCode());
		esfOrganization_ReengineeredImpl.setDescription(esfOrganization_Reengineered.getDescription());
		esfOrganization_ReengineeredImpl.setIsYouthActive(esfOrganization_Reengineered.isIsYouthActive());
		esfOrganization_ReengineeredImpl.setFirstAffiliationDate(esfOrganization_Reengineered.getFirstAffiliationDate());
		esfOrganization_ReengineeredImpl.setVariations(esfOrganization_Reengineered.getVariations());
		esfOrganization_ReengineeredImpl.setRegionCode(esfOrganization_Reengineered.getRegionCode());
		esfOrganization_ReengineeredImpl.setIdFatherAssociation(esfOrganization_Reengineered.getIdFatherAssociation());
		esfOrganization_ReengineeredImpl.setConstitutiveAct(esfOrganization_Reengineered.isConstitutiveAct());
		esfOrganization_ReengineeredImpl.setRegisteredStatus(esfOrganization_Reengineered.isRegisteredStatus());
		esfOrganization_ReengineeredImpl.setPlanimetrySportsStand(esfOrganization_Reengineered.isPlanimetrySportsStand());
		esfOrganization_ReengineeredImpl.setCertificateFITAV(esfOrganization_Reengineered.isCertificateFITAV());
		esfOrganization_ReengineeredImpl.setNote(esfOrganization_Reengineered.getNote());
		esfOrganization_ReengineeredImpl.setIsSimplyOrganizzation(esfOrganization_Reengineered.isIsSimplyOrganizzation());
		esfOrganization_ReengineeredImpl.setWebSite(esfOrganization_Reengineered.getWebSite());
		esfOrganization_ReengineeredImpl.setIncludeConiReport(esfOrganization_Reengineered.isIncludeConiReport());
		esfOrganization_ReengineeredImpl.setOrganizzationCategory(esfOrganization_Reengineered.getOrganizzationCategory());
		esfOrganization_ReengineeredImpl.setType_(esfOrganization_Reengineered.getType_());

		return esfOrganization_ReengineeredImpl;
	}

	/**
	 * Returns the e s f organization_ reengineered with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f organization_ reengineered
	 * @return the e s f organization_ reengineered
	 * @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a e s f organization_ reengineered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization_Reengineered findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchOrganization_ReengineeredException, SystemException {
		ESFOrganization_Reengineered esfOrganization_Reengineered = fetchByPrimaryKey(primaryKey);

		if (esfOrganization_Reengineered == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganization_ReengineeredException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return esfOrganization_Reengineered;
	}

	/**
	 * Returns the e s f organization_ reengineered with the primary key or throws a {@link it.ethica.esf.NoSuchOrganization_ReengineeredException} if it could not be found.
	 *
	 * @param esfOrganizationId the primary key of the e s f organization_ reengineered
	 * @return the e s f organization_ reengineered
	 * @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a e s f organization_ reengineered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization_Reengineered findByPrimaryKey(long esfOrganizationId)
		throws NoSuchOrganization_ReengineeredException, SystemException {
		return findByPrimaryKey((Serializable)esfOrganizationId);
	}

	/**
	 * Returns the e s f organization_ reengineered with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e s f organization_ reengineered
	 * @return the e s f organization_ reengineered, or <code>null</code> if a e s f organization_ reengineered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization_Reengineered fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ESFOrganization_Reengineered esfOrganization_Reengineered = (ESFOrganization_Reengineered)EntityCacheUtil.getResult(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
				ESFOrganization_ReengineeredImpl.class, primaryKey);

		if (esfOrganization_Reengineered == _nullESFOrganization_Reengineered) {
			return null;
		}

		if (esfOrganization_Reengineered == null) {
			Session session = null;

			try {
				session = openSession();

				esfOrganization_Reengineered = (ESFOrganization_Reengineered)session.get(ESFOrganization_ReengineeredImpl.class,
						primaryKey);

				if (esfOrganization_Reengineered != null) {
					cacheResult(esfOrganization_Reengineered);
				}
				else {
					EntityCacheUtil.putResult(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
						ESFOrganization_ReengineeredImpl.class, primaryKey,
						_nullESFOrganization_Reengineered);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ESFOrganization_ReengineeredModelImpl.ENTITY_CACHE_ENABLED,
					ESFOrganization_ReengineeredImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return esfOrganization_Reengineered;
	}

	/**
	 * Returns the e s f organization_ reengineered with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param esfOrganizationId the primary key of the e s f organization_ reengineered
	 * @return the e s f organization_ reengineered, or <code>null</code> if a e s f organization_ reengineered with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganization_Reengineered fetchByPrimaryKey(
		long esfOrganizationId) throws SystemException {
		return fetchByPrimaryKey((Serializable)esfOrganizationId);
	}

	/**
	 * Returns all the e s f organization_ reengineereds.
	 *
	 * @return the e s f organization_ reengineereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization_Reengineered> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e s f organization_ reengineereds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f organization_ reengineereds
	 * @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	 * @return the range of e s f organization_ reengineereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization_Reengineered> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e s f organization_ reengineereds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f organization_ reengineereds
	 * @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e s f organization_ reengineereds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganization_Reengineered> findAll(int start, int end,
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

		List<ESFOrganization_Reengineered> list = (List<ESFOrganization_Reengineered>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ESFORGANIZATION_REENGINEERED);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ESFORGANIZATION_REENGINEERED;

				if (pagination) {
					sql = sql.concat(ESFOrganization_ReengineeredModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ESFOrganization_Reengineered>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ESFOrganization_Reengineered>(list);
				}
				else {
					list = (List<ESFOrganization_Reengineered>)QueryUtil.list(q,
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
	 * Removes all the e s f organization_ reengineereds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ESFOrganization_Reengineered esfOrganization_Reengineered : findAll()) {
			remove(esfOrganization_Reengineered);
		}
	}

	/**
	 * Returns the number of e s f organization_ reengineereds.
	 *
	 * @return the number of e s f organization_ reengineereds
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

				Query q = session.createQuery(_SQL_COUNT_ESFORGANIZATION_REENGINEERED);

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
	 * Initializes the e s f organization_ reengineered persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.ethica.esf.model.ESFOrganization_Reengineered")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ESFOrganization_Reengineered>> listenersList = new ArrayList<ModelListener<ESFOrganization_Reengineered>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ESFOrganization_Reengineered>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ESFOrganization_ReengineeredImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ESFORGANIZATION_REENGINEERED = "SELECT esfOrganization_Reengineered FROM ESFOrganization_Reengineered esfOrganization_Reengineered";
	private static final String _SQL_SELECT_ESFORGANIZATION_REENGINEERED_WHERE = "SELECT esfOrganization_Reengineered FROM ESFOrganization_Reengineered esfOrganization_Reengineered WHERE ";
	private static final String _SQL_COUNT_ESFORGANIZATION_REENGINEERED = "SELECT COUNT(esfOrganization_Reengineered) FROM ESFOrganization_Reengineered esfOrganization_Reengineered";
	private static final String _SQL_COUNT_ESFORGANIZATION_REENGINEERED_WHERE = "SELECT COUNT(esfOrganization_Reengineered) FROM ESFOrganization_Reengineered esfOrganization_Reengineered WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "esfOrganization_Reengineered.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ESFOrganization_Reengineered exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ESFOrganization_Reengineered exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ESFOrganization_ReengineeredPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code", "type"
			});
	private static ESFOrganization_Reengineered _nullESFOrganization_Reengineered =
		new ESFOrganization_ReengineeredImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ESFOrganization_Reengineered> toCacheModel() {
				return _nullESFOrganization_ReengineeredCacheModel;
			}
		};

	private static CacheModel<ESFOrganization_Reengineered> _nullESFOrganization_ReengineeredCacheModel =
		new CacheModel<ESFOrganization_Reengineered>() {
			@Override
			public ESFOrganization_Reengineered toEntityModel() {
				return _nullESFOrganization_Reengineered;
			}
		};
}